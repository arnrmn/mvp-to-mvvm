package arnrmn.mvp.newslist.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import arnrmn.mvp.R
import arnrmn.mvp.newslist.fragment.list.ArticlesAdapter
import arnrmn.mvp.utils.android.BaseFragment
import arnrmn.mvp.utils.entity.Article
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : BaseFragment(), NewsListContract.View {
    @Inject lateinit var presenter: NewsListContract.Presenter
    @Inject lateinit var adapter: ArticlesAdapter

    override fun getLayoutId(): Int = R.layout.fragment_news_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onViewCreated(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshListener { presenter.onRefreshRequested() }
        presenter.onViewReady()
    }

    override fun onDestroyView() {
        presenter.onViewDestroyed()
        super.onDestroyView()
    }

    override fun showArticles(articles: List<Article>) {
        adapter.update(articles)
        recyclerView.visibility = View.VISIBLE
        noItemsTextView.visibility = View.INVISIBLE
    }

    override fun showNoArticles() {
        recyclerView.visibility = View.INVISIBLE
        noItemsTextView.visibility = View.VISIBLE
    }

    override fun showProgress() {
        refreshLayout.isRefreshing = true
    }

    override fun hideProgress() {
        refreshLayout.isRefreshing = false
    }

    override fun showMessage(message: String) {
        view?.let { view -> Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show() }
    }

    companion object {
        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}