package arnrmn.mvvmkoin.app

import android.content.Context
import arnrmn.mvvmkoin.utils.dagger.IO
import arnrmn.mvvmkoin.utils.dagger.UI
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
abstract class AppModule {
    @Binds
    abstract fun bindApplicationContext(app: MvvmApplication): Context

    @Module
    companion object {
        @JvmStatic @Provides @IO
        fun provideIoScheduler(): Scheduler = Schedulers.io()

        @JvmStatic @Provides @UI
        fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()
    }
}