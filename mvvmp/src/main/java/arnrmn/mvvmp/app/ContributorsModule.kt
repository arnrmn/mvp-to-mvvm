package arnrmn.mvvmp.app

import arnrmn.mvvmp.newslist.NewsListActivity
import arnrmn.mvvmp.newslist.NewsListActivityModule
import arnrmn.mvvmp.utils.dagger.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributorsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsListActivityModule::class])
    abstract fun contributeNewsListActivity(): NewsListActivity
}