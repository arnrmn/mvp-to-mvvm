package arnrmn.mvvm.newslist.fragment

import arnrmn.mvvm.newsprovider.NewsProvider
import arnrmn.mvvm.utils.dagger.IO
import arnrmn.mvvm.utils.entity.Article
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