package arnrmn.mvp.newslist

import android.os.Bundle
import arnrmn.mvp.newslist.fragment.NewsListFragment
import arnrmn.mvp.utils.android.BaseActivity
import arnrmn.mvp.utils.android.replaceFragment
import arnrmn.mvp_mvvm.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        replaceFragment(NewsListFragment.newInstance())
    }
}
