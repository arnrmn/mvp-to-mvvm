package arnrmn.mvvm.newslist.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import arnrmn.mvvm.R
import arnrmn.mvvm.newsdetails.NewsDetailsActivity
import arnrmn.mvvm.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvm.newslist.fragment.list.ArticlesAdapter
import arnrmn.mvvm.utils.android.BaseFragment
import arnrmn.mvvm.utils.android.setVisible
import arnrmn.mvvm.utils.entity.Article
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : BaseFragment(), ArticleClickListener {
    @Inject lateinit var adapter: ArticlesAdapter
    private lateinit var viewModel: NewsListViewModel

    override fun getLayoutId(): Int {
        return R.layout.fragment_news_list
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        viewModel = getViewModel(NewsListViewModel::class)
        viewModel.observeError().with(::showToast)
        viewModel.observeDetails().with(::showDetails)
        viewModel.observeProgress().with(::showProgress)
        viewModel.observeArticles().with(::showArticles)
        viewModel.observeNoArticles().with(::showNoArticles)
        refreshLayout.setOnRefreshListener { viewModel.onRefresh() }
    }

    override fun onArticleClicked(article: Article) {
        viewModel.onArticleClicked(article)
    }

    private fun showArticles(articles: List<Article>) {
        adapter.update(articles)
    }

    private fun showNoArticles(show: Boolean) {
        noItemsTextView.setVisible(show)
    }

    private fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun showDetails(article: Article) {
        NewsDetailsActivity.start(context, article)
    }

    private fun showProgress(showProgress: Boolean) {
        refreshLayout.isRefreshing = showProgress
    }

    companion object {
        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}