package arnrmn.mvvm.utils.android

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment

fun <T : ViewModel> Fragment.getViewModel(factory: ViewModelProvider.Factory, clazz: Class<T>): T {
    return ViewModelProviders.of(this, factory)[clazz]
}