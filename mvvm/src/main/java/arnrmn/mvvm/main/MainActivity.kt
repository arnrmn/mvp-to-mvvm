package arnrmn.mvvm.main

import android.os.Bundle
import arnrmn.mvvm.R
import arnrmn.mvvm.main.fragment.MainFragment
import arnrmn.mvvm.utils.android.BaseActivity
import arnrmn.mvvm.utils.android.replaceFragment

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        if (savedInstanceState == null) {
            replaceFragment(MainFragment.newInstance())
        }
    }
}