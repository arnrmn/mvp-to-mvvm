package arnrmn.mvvmp.newslist.fragment

import arnrmn.mvvmp.newsprovider.NewsProvider
import arnrmn.mvvmp.utils.dagger.IO
import arnrmn.mvvmp.utils.entity.Article
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class NewsListModel @Inject constructor(
        private val provider: NewsProvider,
        @IO private val scheduler: Scheduler
) {
    fun loadNews(): Single<List<Article>> {
        return provider.getNews().subscribeOn(scheduler)
    }
}