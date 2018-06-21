package arnrmn.mvvm.newslist

import android.os.Bundle
import arnrmn.mvvm.R
import arnrmn.mvvm.newslist.fragment.NewsListFragment
import arnrmn.mvvm.utils.android.BaseActivity
import arnrmn.mvvm.utils.android.replaceFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewsListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        replaceFragment(NewsListFragment.newInstance())
    }
}
