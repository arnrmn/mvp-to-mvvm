package arnrmn.mvp.app

import arnrmn.mvp.newsdetails.NewsDetailsActivity
import arnrmn.mvp.newsdetails.NewsDetailsActivityModule
import arnrmn.mvp.newslist.NewsListActivity
import arnrmn.mvp.newslist.NewsListActivityModule
import arnrmn.mvp.utils.dagger.ActivityScope
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