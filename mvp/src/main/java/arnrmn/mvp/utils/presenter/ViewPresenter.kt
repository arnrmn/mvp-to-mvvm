package arnrmn.mvp.utils.presenter

import java.lang.ref.WeakReference

abstract class ViewPresenter<T> : BasePresenter<T> {
    private var viewRef = WeakReference<T>(null)

    final override fun onViewCreated(view: T) {
        viewRef = WeakReference(view)
    }

    final override fun onViewDestroyed() {
        onCleared()
        viewRef.clear()
    }

    fun onView(action: T.() -> Unit) {
        viewRef.get()?.action()
    }

    abstract fun onCleared()
}