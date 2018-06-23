package arnrmn.mvvm.newslist.fragment

import android.arch.lifecycle.LiveData
import arnrmn.mvvm.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvm.utils.entity.Article
import io.reactivex.Single

interface NewsListContract {
    interface ViewModel: ArticleClickListener {
        fun observeArticles(): LiveData<List<Article>>

        fun observeDetails(): LiveData<Article>

        fun observeError(): LiveData<String>

        fun observeProgress(): LiveData<Boolean>

        fun onRefresh()

        override fun onArticleClicked(article: Article)
    }

    interface Model {
        fun loadNews(): Single<List<Article>>
    }
}