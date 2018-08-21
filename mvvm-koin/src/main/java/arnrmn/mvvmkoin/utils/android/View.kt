package arnrmn.mvvmkoin.utils.android

import android.view.View

fun View.setVisiblility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.INVISIBLE
}