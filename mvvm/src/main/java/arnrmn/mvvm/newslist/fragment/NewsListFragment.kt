package arnrmn.mvvm.newslist.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import arnrmn.mvvm.R
import arnrmn.mvvm.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvm.newslist.fragment.list.ArticlesAdapter
import arnrmn.mvvm.utils.entity.Article
import arnrmn.mvvm.utils.livedata.on
import arnrmn.mvvm.utils.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : DaggerFragment(), ArticleClickListener {
    @Inject lateinit var adapter: ArticlesAdapter
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: NewsListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[NewsListViewModel::class.java]
        viewModel.observeError().on(this, ::showToast)
        viewModel.observeDetails().on(this, ::showDetails)
        viewModel.observeProgress().on(this, ::showProgress)
        viewModel.observeArticles().on(this, adapter::update)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshListener { viewModel.onRefresh() }
    }

    override fun onArticleClicked(article: Article) {
        viewModel.onArticleClicked(article)
    }

    private fun showToast(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    private fun showDetails(article: Article) {
        showToast(article.title)
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