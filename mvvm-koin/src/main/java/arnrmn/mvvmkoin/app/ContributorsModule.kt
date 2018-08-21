package arnrmn.mvvmkoin.app

import arnrmn.mvvmkoin.newsdetails.NewsDetailsActivity
import arnrmn.mvvmkoin.newsdetails.NewsDetailsActivityModule
import arnrmn.mvvmkoin.newslist.NewsListActivity
import arnrmn.mvvmkoin.newslist.NewsListActivityModule
import arnrmn.mvvmkoin.newspager.NewsPagerActivity
import arnrmn.mvvmkoin.newspager.NewsPagerActivityModule
import arnrmn.mvvmkoin.utils.dagger.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributorsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsListActivityModule::class])
    abstract fun contributeNewsListActivity(): NewsListActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsDetailsActivityModule::class])
    abstract fun contributeNewsDetailsActivity(): NewsDetailsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsPagerActivityModule::class])
    abstract fun contributeNewsPagerActivity(): NewsPagerActivity
}