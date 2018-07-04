package arnrmn.mvvm.main

import android.os.Bundle
import arnrmn.mvvm.R
import arnrmn.mvvm.main.fragment.MainFragment
import arnrmn.mvvm.utils.android.BaseActivity
import arnrmn.mvvm.utils.android.replaceFragment
import kotlinx.android.synthetic.main.layout_toolbar.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            replaceFragment(MainFragment.newInstance())
        }
    }
}