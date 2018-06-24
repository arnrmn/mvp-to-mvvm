package arnrmn.mvvmp.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class mvvmpApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}