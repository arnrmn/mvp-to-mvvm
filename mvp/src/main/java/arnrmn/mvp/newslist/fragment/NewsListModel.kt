package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.newsprovider.NewsProvider
import arnrmn.mvp.utils.entity.Article
import dk.tv2.onboarding.IO
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NewsListModel @Inject constructor(
        private val provider: NewsProvider,
        @IO private val scheduler: Scheduler
) : NewsListContract.Model {

    override fun loadArticles(): Single<List<Article>> {
        return Completable.timer(2, TimeUnit.SECONDS)
                .andThen(provider.getNews ())
                .subscribeOn(scheduler)
    }
}