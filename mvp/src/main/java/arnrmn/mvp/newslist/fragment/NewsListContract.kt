package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.utils.entity.Article
import arnrmn.mvp.utils.presenter.BasePresenter

interface NewsListContract {
    interface View {
        fun showArticles(articles: List<Article>)

        fun showNoArticles()

        fun showMessage(message: String)

        fun showProgress()

        fun hideProgress()

        fun showDetails(article: Article)
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()

        fun onRefreshRequested()

        fun onArticleClicked(article: Article)
    }
}