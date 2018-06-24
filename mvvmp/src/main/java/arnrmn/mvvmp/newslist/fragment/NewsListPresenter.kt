package arnrmn.mvvmp.newslist.fragment

import arnrmn.mvvmp.utils.entity.Article
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
        private val view: NewsListContract.View,
        private val model: NewsListContract.Model
) : NewsListContract.Presenter {
    private val disposables = CompositeDisposable()

    init {
        onRefreshRequested()
    }

    override fun onRefreshRequested() {
        model.loadArticles()
                .onResult { articles ->
                    if(articles.isEmpty()){
                        view.showNoArticles()
                    } else {
                        view.showArticles(articles)
                    }
                }
    }

    override fun onArticleClicked(article: Article) {
        view.showDetails(article)
    }

    override fun onCleared() {
        disposables.clear()
    }

    private fun handleError(error: Throwable) {
        Timber.d(error)
        view.showMessage(error.message.toString())
    }

    private fun <T> Single<T>.onResult(action: (T) -> Unit) {
        disposables.add(
                this.doOnSubscribe { view.showProgress() }
                        .doOnSuccess { view.hideProgress() }
                        .doOnError { view.hideProgress() }
                        .subscribe(
                                { result -> action.invoke(result) },
                                { cause -> handleError(cause) }
                        )
        )
    }
}