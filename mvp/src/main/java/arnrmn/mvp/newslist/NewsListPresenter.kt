package arnrmn.mvp.newslist

import arnrmn.mvp.utils.presenter.ViewPresenter
import dk.tv2.onboarding.UI
import io.reactivex.Scheduler
import timber.log.Timber
import javax.inject.Inject

class NewsListPresenter @Inject constructor(
        private val model: NewsContract.Model,
        @UI private val scheduler: Scheduler
) : NewsContract.Presenter, ViewPresenter<NewsContract.View>() {

    override fun onViewReady() {
        model.loadArticles()
                .observeOn(scheduler)
                .subscribe(
                        { articles -> onView { showArticles(articles) } },
                        { error -> handleError(error) })
    }

    private fun handleError(error: Throwable) {
        Timber.d(error)
        onView { showMessage(error.message.toString()) }
    }
}