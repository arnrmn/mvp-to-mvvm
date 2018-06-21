package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.utils.entity.Article
import arnrmn.mvp.utils.presenter.ViewPresenter
import arnrmn.mvp.utils.dagger.UI
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
        private val model: NewsListContract.Model,
        @UI private val scheduler: Scheduler
) : NewsListContract.Presenter, ViewPresenter<NewsListContract.View>() {
    private val disposables = CompositeDisposable()

    override fun onViewReady() {
        model.loadArticles().onResult(::handleArticles)
    }

    override fun onRefreshRequested() {
        onViewReady()
    }

    override fun onArticleClicked(article: Article) {
        onView { showDetails(article) }
    }

    override fun onCleared() {
        disposables.dispose()
    }

    private fun handleArticles(articles: List<Article>) {
        if (articles.isEmpty()) {
            onView { showNoArticles() }
        } else {
            onView { showArticles(articles) }
        }
    }

    private fun handleError(error: Throwable) {
        Timber.d(error)
        onView { showMessage(error.message.toString()) }
    }

    private fun <T> Single<T>.onResult(action: (T) -> Unit) {
        disposables.add(
                this.observeOn(scheduler)
                        .doOnSubscribe { onView { showProgress() } }
                        .doOnSuccess { onView { hideProgress() } }
                        .doOnError { onView { hideProgress() } }
                        .subscribe(
                                action::invoke,
                                this@NewsListPresenter::handleError
                        )
        )
    }
}