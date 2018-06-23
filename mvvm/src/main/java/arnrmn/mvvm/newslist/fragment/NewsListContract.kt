package arnrmn.mvvm.newslist.fragment

import android.arch.lifecycle.LiveData
import arnrmn.mvvm.utils.entity.Article
import io.reactivex.Single

interface NewsListContract {
    interface ViewModel {
        fun observeArticles(): LiveData<List<Article>>

        fun observeDetails(): LiveData<Article>

        fun observeError(): LiveData<String>

        fun observeProgress(): LiveData<Boolean>

        fun onArticleClicked(article: Article)

        fun onRefresh()
    }

    interface Model {
        fun loadNews(): Single<List<Article>>
    }
}