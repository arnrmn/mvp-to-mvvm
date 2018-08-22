package arnrmn.mvvmkoin.utils.android

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(getLayoutId(), container, false)
    }

    protected fun <T> LiveData<T>.onResult(action: (T) -> Unit) {
        observe(this@BaseFragment, Observer { data -> data?.let(action) })
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
}