package arnrmn.mvvm.newspager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import arnrmn.mvvm.R
import arnrmn.mvvm.newspager.fragment.NewsPagerFragment
import arnrmn.mvvm.utils.android.BaseActivity
import arnrmn.mvvm.utils.android.replaceFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewsPagerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            replaceFragment(NewsPagerFragment.newInstance())
        }
    }

    companion object {
        fun start(context: Context?) {
            context?.startActivity(createIntent(context))
        }

        fun createIntent(context: Context?): Intent {
            return Intent(context, NewsPagerActivity::class.java)
        }
    }
}