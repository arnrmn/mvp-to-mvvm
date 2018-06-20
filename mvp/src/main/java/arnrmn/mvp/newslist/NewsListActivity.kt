package arnrmn.mvp.newslist

import android.os.Bundle
import arnrmn.mvp.newslist.fragment.NewsListFragment
import arnrmn.mvp.utils.android.BaseActivity
import arnrmn.mvp.utils.android.replaceFragment
import arnrmn.mvp_mvvm.R

class NewsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(NewsListFragment.newInstance())
    }
}
