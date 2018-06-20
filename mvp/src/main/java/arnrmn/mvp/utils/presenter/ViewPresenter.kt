package arnrmn.mvp.utils.presenter

import java.lang.ref.WeakReference

abstract class ViewPresenter<T> : BasePresenter<T> {
    private var viewRef = WeakReference<T>(null)

    override fun onViewCreated(view: T) {
        viewRef = WeakReference(view)
    }

    override fun onViewDestroyed() {
        viewRef.clear()
    }

    fun onView(action: T.() -> Unit) {
        viewRef.get()?.action()
    }
}