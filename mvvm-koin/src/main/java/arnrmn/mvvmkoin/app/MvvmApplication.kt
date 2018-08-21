package arnrmn.mvvmkoin.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import org.koin.android.ext.android.startKoin

class MvvmApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf())
    }
}