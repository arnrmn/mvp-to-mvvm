package arnrmn.mvvmkoin.app

import android.app.Application
import arnrmn.mvvmkoin.newslist.newsListModule
import arnrmn.mvvmkoin.main.newsPagerModule
import arnrmn.mvvmkoin.utils.network.networkModule
import arnrmn.mvvmkoin.utils.newsprovider.newsProviderModule
import org.koin.android.ext.android.startKoin

class MvvmApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
                appModule,
                networkModule,
                newsProviderModule,
                newsPagerModule,
                newsListModule
        ))
    }
}