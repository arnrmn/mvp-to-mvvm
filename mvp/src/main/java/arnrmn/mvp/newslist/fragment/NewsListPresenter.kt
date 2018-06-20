package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.utils.entity.Article
import arnrmn.mvp.utils.presenter.ViewPresenter
import dk.tv2.onboarding.UI
import io.reactivex.Scheduler
import timber.log.Timber
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
        private val model: NewsListContract.Model,
        @UI private val scheduler: Scheduler
) : NewsListContract.Presenter, ViewPresenter<NewsListContract.View>() {

    override fun onViewReady() {
        model.loadArticles()
                .observeOn(scheduler)
                .subscribe(
                        { articles -> handleArticles(articles) },
                        { error -> handleError(error) })
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
}