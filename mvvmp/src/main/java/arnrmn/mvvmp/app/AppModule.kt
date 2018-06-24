package arnrmn.mvvmp.app

import android.content.Context
import arnrmn.mvvmp.utils.dagger.IO
import arnrmn.mvvmp.utils.dagger.UI
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
abstract class AppModule {
    @Binds
    abstract fun bindApplicationContext(app: mvvmpApplication): Context

    @Module
    companion object {
        @JvmStatic @Provides @IO
        fun provideIoScheduler(): Scheduler = Schedulers.io()

        @JvmStatic @Provides @UI
        fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()
    }
}