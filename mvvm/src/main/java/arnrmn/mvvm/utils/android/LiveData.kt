package arnrmn.mvvm.utils.android

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

inline fun <reified T> LiveData<T>.on(owner: LifecycleOwner, crossinline action: (T) -> Unit) {
    this.observe(owner, Observer { data -> data?.let(action) })
}