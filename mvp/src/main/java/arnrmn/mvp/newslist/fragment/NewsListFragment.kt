package arnrmn.mvp.newslist.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import arnrmn.mvp.R
import arnrmn.mvp.newsdetails.NewsDetailsActivity
import arnrmn.mvp.newslist.fragment.list.ArticleClickListener
import arnrmn.mvp.newslist.fragment.list.ArticlesAdapter
import arnrmn.mvp.utils.android.BaseFragment
import arnrmn.mvp.utils.entity.Article
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : BaseFragment(), NewsListContract.View, ArticleClickListener {
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
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showDetails(article: Article) {
        NewsDetailsActivity.start(context, article)
    }

    override fun onArticleClicked(article: Article) {
        presenter.onArticleClicked(article)
    }

    companion object {
        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}