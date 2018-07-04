package arnrmn.mvvm.newsdetails.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import arnrmn.mvvm.R
import arnrmn.mvvm.utils.android.BaseFragment
import arnrmn.mvvm.utils.android.loadUrl
import arnrmn.mvvm.utils.entity.Article
import kotlinx.android.synthetic.main.fragment_news_details.*

class NewsDetailsFragment : BaseFragment() {
    private lateinit var viewModel: NewsDetailsViewModel

    override fun getLayoutId(): Int {
        return R.layout.fragment_news_details
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openButton.setOnClickListener { viewModel.onButtonClicked() }
        viewModel = getViewModel(NewsDetailsViewModel::class)
        viewModel.observeTitle().onResult(titleTextView::setText)
        viewModel.observeImageUrl().onResult(imageView::loadUrl)
        viewModel.observeDescription().onResult(descriptionTextView::setText)
        viewModel.observeOpenLinkAction().onResult(::showToast)
        viewModel.onArticleSelected(getSelectedArticle())
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun getSelectedArticle(): Article {
        return arguments?.getParcelable(KEY_ARTICLE) ?: throw IllegalStateException("No article")
    }

    companion object {
        private const val KEY_ARTICLE = "key.article"

        fun newInstance(article: Article): NewsDetailsFragment {
            val arguments = Bundle()
            arguments.putParcelable(KEY_ARTICLE, article)
            val fragment = NewsDetailsFragment()
            fragment.arguments = arguments
            return fragment
        }
    }
}