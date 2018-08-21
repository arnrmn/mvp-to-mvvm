package arnrmn.mvvmkoin.newslist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import arnrmn.mvvmkoin.R
import arnrmn.mvvmkoin.newslist.fragment.NewsListFragment
import arnrmn.mvvmkoin.utils.android.BaseActivity
import arnrmn.mvvmkoin.utils.android.replaceFragment
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
