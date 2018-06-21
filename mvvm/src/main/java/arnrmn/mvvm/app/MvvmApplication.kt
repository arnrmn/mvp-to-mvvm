package arnrmn.mvvm.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MvvmApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}