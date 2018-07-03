package arnrmn.mvp.newsdetails.fragment

import android.os.Bundle
import arnrmn.mvp.R
import arnrmn.mvp.utils.android.BaseFragment
import arnrmn.mvp.utils.entity.Article

class NewsDetailsFragment : BaseFragment() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_news_details
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