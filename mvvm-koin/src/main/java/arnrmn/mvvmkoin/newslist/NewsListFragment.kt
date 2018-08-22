package arnrmn.mvvmkoin.newslist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import arnrmn.mvvmkoin.R
import arnrmn.mvvmkoin.newsdetails.NewsDetailsActivity
import arnrmn.mvvmkoin.newslist.list.ArticleClickListener
import arnrmn.mvvmkoin.newslist.list.ArticlesAdapter
import arnrmn.mvvmkoin.utils.android.BaseFragment
import arnrmn.mvvmkoin.utils.android.setVisiblility
import arnrmn.mvvmkoin.utils.entity.Article
import kotlinx.android.synthetic.main.fragment_news_list.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.scopedWith
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.path.moduleName

class NewsListFragment : BaseFragment(), ArticleClickListener {
    private val viewModel: NewsListViewModel by viewModel()
    private val adapter: ArticlesAdapter by inject { parametersOf(this) }

    override fun getLayoutId(): Int {
        return R.layout.fragment_news_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scopedWith(this::class.moduleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        viewModel.observeError().onResult(::showToast)
        viewModel.observeDetails().onResult(::showDetails)
        viewModel.observeProgress().onResult(::showProgress)
        viewModel.observeArticles().onResult(::showArticles)
        viewModel.observeNoArticles().onResult(::showNoArticles)
        refreshLayout.setOnRefreshListener { viewModel.onRefresh() }
    }

    override fun onArticleClicked(article: Article) {
        viewModel.onArticleClicked(article)
    }

    private fun showArticles(articles: List<Article>) {
        adapter.update(articles)
    }

    private fun showNoArticles(show: Boolean) {
        noItemsTextView.setVisiblility(show)
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