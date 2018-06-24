package arnrmn.mvvmp.utils.android

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import arnrmn.mvvmp.R

fun FragmentActivity.replaceFragment(
        fragment: Fragment,
        container: Int = R.id.fragmentContainer
) {
    supportFragmentManager.beginTransaction()
            .replace(container, fragment)
            .commit()
}