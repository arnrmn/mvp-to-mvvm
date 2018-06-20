package arnrmn.mvp.newslist

import arnrmn.mvp.newsprovider.NewsProvider
import arnrmn.mvp.utils.entity.Article
import dk.tv2.onboarding.IO
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class NewsListModel @Inject constructor(
        private val provider: NewsProvider,
        @IO private val scheduler: Scheduler
) : NewsContract.Model {

    override fun loadArticles(): Single<List<Article>> {
        return provider.getNews()
                .subscribeOn(scheduler)
    }
}