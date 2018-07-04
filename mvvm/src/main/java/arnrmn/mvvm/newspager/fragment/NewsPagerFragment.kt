package arnrmn.mvvm.newspager.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import arnrmn.mvvm.R
import arnrmn.mvvm.newslist.fragment.NewsListViewModel
import arnrmn.mvvm.utils.android.BaseFragment
import arnrmn.mvvm.utils.android.setVisiblility
import arnrmn.mvvm.utils.entity.Article
import kotlinx.android.synthetic.main.fragment_pager.*
import javax.inject.Inject

class NewsPagerFragment : BaseFragment() {
    @Inject lateinit var adapter: NewsPagerAdapter
    private lateinit var viewModel: NewsListViewModel

    override fun getLayoutId(): Int = R.layout.fragment_pager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsPager.adapter = adapter
        viewModel = getViewModel(NewsListViewModel::class)
        viewModel.observeError().onResult(::showToast)
        viewModel.observeArticles().onResult(::updateArticles)
        viewModel.observeProgress().onResult(::setProgressBarVisibility)
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun updateArticles(articles: List<Article>) {
        adapter.update(articles)
    }

    private fun setProgressBarVisibility(isVisible: Boolean) {
        progressBar.setVisiblility(isVisible)
    }

    companion object {
        fun newInstance(): NewsPagerFragment = NewsPagerFragment()
    }
}