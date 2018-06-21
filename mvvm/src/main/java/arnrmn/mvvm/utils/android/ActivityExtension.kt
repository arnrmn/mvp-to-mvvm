package arnrmn.mvvm.utils.android

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import arnrmn.mvvm.R

fun FragmentActivity.replaceFragment(
        fragment: Fragment,
        container: Int = R.id.fragmentContainer
) {
    supportFragmentManager.beginTransaction()
            .replace(container, fragment)
            .commit()
}