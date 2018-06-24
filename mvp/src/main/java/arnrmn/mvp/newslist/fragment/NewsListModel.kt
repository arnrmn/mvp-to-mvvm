package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.newsprovider.NewsProvider
import arnrmn.mvp.utils.dagger.IO
import arnrmn.mvp.utils.entity.Article
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class NewsListModel @Inject constructor(
        private val provider: NewsProvider,
        @IO private val scheduler: Scheduler
) : NewsListContract.Model {

    override fun loadArticles(): Single<List<Article>> {
        return provider.getNews().subscribeOn(scheduler)
    }
}