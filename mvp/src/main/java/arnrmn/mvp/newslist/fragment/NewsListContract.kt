package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.utils.entity.Article
import arnrmn.mvp.utils.presenter.BasePresenter
import io.reactivex.Single

interface NewsListContract {
    interface View {
        fun showArticles(articles: List<Article>)

        fun showNoArticles()

        fun showMessage(message: String)

        fun showProgress()

        fun hideProgress()
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()
    }

    interface Model {
        fun loadArticles(): Single<List<Article>>
    }
}