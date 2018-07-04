package arnrmn.mvvm.utils.android

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arnrmn.mvvm.utils.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlin.reflect.KClass

abstract class BaseFragment : DaggerFragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(getLayoutId(), container, false)
    }

    protected fun <T : ViewModel> getViewModel(clazz: KClass<T>): T {
        return ViewModelProviders.of(this, viewModelFactory)[clazz.java]
    }

    protected fun <T> LiveData<T>.onResult(action: (T) -> Unit) {
            observe(this@BaseFragment, Observer { data -> data?.let(action) })
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
}