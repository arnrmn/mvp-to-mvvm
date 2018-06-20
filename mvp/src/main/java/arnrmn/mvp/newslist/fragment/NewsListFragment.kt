package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.utils.android.BaseFragment
import arnrmn.mvp_mvvm.R

class NewsListFragment : BaseFragment() {
    override fun getLayoutId(): Int = R.layout.fragment_news_list

    companion object {
        fun newInstance(): NewsListFragment {
            return NewsListFragment()
        }
    }
}