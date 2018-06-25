package arnrmn.mvvmp.newslist.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import arnrmn.mvvmp.R
import arnrmn.mvvmp.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvmp.newslist.fragment.list.ArticlesAdapter
import arnrmn.mvvmp.utils.android.BaseFragment
import arnrmn.mvvmp.utils.android.setVisible
import arnrmn.mvvmp.utils.entity.Article
import arnrmn.mvvmp.utils.livedata.on
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : BaseFragment(), ArticleClickListener {
    @Inject lateinit var adapter: ArticlesAdapter
    @Inject lateinit var presenter: NewsListContract.Presenter
    @Inject lateinit var viewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.observeMessage().on(this, ::showToast)
        viewModel.observeDetails().on(this, ::showDetails)
        viewModel.observeProgress().on(this, ::showProgress)
        viewModel.observeArticles().on(this, ::showArticles)
        viewModel.observeNoArticles().on(this, ::showNoArticles)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_news_list
    }

    override fun onDestroyView() {
        presenter.onCleared()
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshListener { presenter.onRefreshRequested() }
    }

    override fun onArticleClicked(article: Article) {
        presenter.onArticleClicked(article)
    }

    private fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun showDetails(article: Article) {
        showToast(article.title)
    }

    private fun showNoArticles(visible: Boolean) {
        noItemsTextView.setVisible(visible)
    }

    private fun showArticles(articles: List<Article>) {
        adapter.update(articles)
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