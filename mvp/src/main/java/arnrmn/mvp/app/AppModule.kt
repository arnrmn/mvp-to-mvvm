package arnrmn.mvp.app

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import arnrmn.mvp.utils.dagger.IO
import arnrmn.mvp.utils.dagger.UI
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
abstract class AppModule {
    @Binds
    abstract fun bindApplicationContext(app: MvpApplication): Context

    @Module
    companion object {
        @JvmStatic @Provides @IO
        fun provideIoScheduler(): Scheduler = Schedulers.io()

        @JvmStatic @Provides @UI
        fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()
    }
}