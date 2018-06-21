package arnrmn.mvvm.newslist.fragment

import arnrmn.mvvm.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvm.utils.entity.Article
import arnrmn.mvvm.utils.presenter.BasePresenter
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

    interface Presenter : BasePresenter<View>, ArticleClickListener {
        fun onViewReady()

        fun onRefreshRequested()

        override fun onArticleClicked(article: Article)
    }

    interface Model {
        fun loadArticles(): Single<List<Article>>
    }
}