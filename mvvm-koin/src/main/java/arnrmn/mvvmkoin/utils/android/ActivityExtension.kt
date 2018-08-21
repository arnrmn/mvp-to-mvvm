package arnrmn.mvvmkoin.utils.android

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import arnrmn.mvvmkoin.R

fun FragmentActivity.replaceFragment(
        fragment: Fragment,
        container: Int = R.id.fragmentContainer
) {
    supportFragmentManager.beginTransaction()
            .replace(container, fragment)
            .commit()
}