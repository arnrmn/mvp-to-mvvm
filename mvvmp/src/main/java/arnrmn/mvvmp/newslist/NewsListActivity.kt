package arnrmn.mvvmp.newslist

import android.os.Bundle
import arnrmn.mvvmp.R
import arnrmn.mvvmp.newslist.fragment.NewsListFragment
import arnrmn.mvvmp.utils.android.BaseActivity
import arnrmn.mvvmp.utils.android.replaceFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        replaceFragment(NewsListFragment.newInstance())
    }
}
