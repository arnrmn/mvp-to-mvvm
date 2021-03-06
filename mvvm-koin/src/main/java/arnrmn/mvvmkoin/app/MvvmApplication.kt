package arnrmn.mvvmkoin.app

import android.app.Application
import arnrmn.mvvmkoin.main.newsPagerModule
import arnrmn.mvvmkoin.newsdetails.newsDetailsModule
import arnrmn.mvvmkoin.newslist.newsListModule
import arnrmn.mvvmkoin.utils.network.networkModule
import arnrmn.mvvmkoin.utils.newsprovider.newsProviderModule
import org.koin.android.ext.android.startKoin

class MvvmApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = listOf(
                appModule,
                networkModule,
                newsProviderModule,
                newsPagerModule,
                newsListModule,
                newsDetailsModule
        )
        startKoin(this, modules)
    }
}