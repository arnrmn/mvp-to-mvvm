package arnrmn.mvvm.app

import arnrmn.mvvm.newsdetails.NewsDetailsActivity
import arnrmn.mvvm.newsdetails.NewsDetailsActivityModule
import arnrmn.mvvm.newslist.NewsListActivity
import arnrmn.mvvm.newslist.NewsListActivityModule
import arnrmn.mvvm.utils.dagger.ActivityScope
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
}