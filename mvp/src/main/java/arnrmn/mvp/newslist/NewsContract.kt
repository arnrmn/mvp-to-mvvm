package arnrmn.mvp.newslist

import arnrmn.mvp.utils.entity.Article
import arnrmn.mvp.utils.presenter.BasePresenter
import io.reactivex.Single

interface NewsContract {
    interface View {
        fun showArticles(articles: List<Article>)

        fun showNoArticles()

        fun showMessage(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun onViewReady()
    }

    interface Model {
        fun loadArticles(): Single<List<Article>>
    }
}