package arnrmn.mvp.newslist.fragment

import android.os.Bundle
import android.view.View
import arnrmn.mvp.R
import arnrmn.mvp.utils.android.BaseFragment
import arnrmn.mvp.utils.entity.Article
import javax.inject.Inject

class NewsListFragment : BaseFragment(), NewsListContract.View {
    @Inject lateinit var presenter: NewsListContract.Presenter

    override fun getLayoutId(): Int = R.layout.fragment_news_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onViewCreated(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewReady()
    }

    override fun onDestroyView() {
        presenter.onViewDestroyed()
        super.onDestroyView()
    }

    override fun showArticles(articles: List<Article>) {
        //Do nothing
    }

    override fun showNoArticles() {
        //Do nothing
    }

    override fun showMessage(message: String) {
        //Do nothing
    }

    companion object {
        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}