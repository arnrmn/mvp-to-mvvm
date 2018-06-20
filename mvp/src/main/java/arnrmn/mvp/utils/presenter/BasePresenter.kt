package arnrmn.mvp.utils.presenter

interface BasePresenter<in T> {
    fun onViewCreated(view: T)

    fun onViewDestroyed()
}