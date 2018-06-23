package arnrmn.mvvm.utils.livedata

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer

class SingleLiveData<T> : MutableLiveData<T>() {
    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
        super.observe(owner, Observer { data ->
            if(data != null) {
                observer.onChanged(data)
                value = null
            }
        })
    }
}