package arnrmn.mvvmkoin.newsdetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import arnrmn.mvvmkoin.R
import arnrmn.mvvmkoin.utils.android.BaseFragment
import arnrmn.mvvmkoin.utils.android.loadUrl
import arnrmn.mvvmkoin.utils.entity.Article
import kotlinx.android.synthetic.main.fragment_news_details.*
import org.koin.android.scope.ext.android.scopedWith
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.dsl.path.moduleName

class NewsDetailsFragment : BaseFragment() {
    private val viewModel: NewsDetailsViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.fragment_news_details
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scopedWith(this::class.moduleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openButton.setOnClickListener { viewModel.onButtonClicked() }
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