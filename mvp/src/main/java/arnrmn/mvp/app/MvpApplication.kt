package arnrmn.mvp.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class MvpApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}