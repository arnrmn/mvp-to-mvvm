package arnrmn.mvvm.newslist

import android.content.Context
import android.content.Intent
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
        if (savedInstanceState == null) {
            replaceFragment(NewsListFragment.newInstance())
        }
    }

    companion object {
        fun start(context: Context?) {
            context?.startActivity(createIntent(context))
        }

        fun createIntent(context: Context?): Intent {
            return Intent(context, NewsListActivity::class.java)
        }
    }
}
