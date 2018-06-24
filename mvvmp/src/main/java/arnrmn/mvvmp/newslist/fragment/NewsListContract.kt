package arnrmn.mvvmp.newslist.fragment

import arnrmn.mvvmp.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvmp.utils.entity.Article
import io.reactivex.Single

interface NewsListContract {
    interface View {
        fun showArticles(articles: List<Article>)

        fun showNoArticles()

        fun showMessage(message: String)

        fun showProgress()

        fun hideProgress()

        fun showDetails(article: Article)
    }

    interface Presenter : ArticleClickListener {
        fun onRefreshRequested()

        fun onCleared()

        override fun onArticleClicked(article: Article)
    }

    interface Model {
        fun loadArticles(): Single<List<Article>>
    }
}