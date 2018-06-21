package arnrmn.mvvm.app

import arnrmn.mvvm.newslist.NewsListActivity
import arnrmn.mvvm.newslist.NewsListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import arnrmn.mvvm.utils.dagger.ActivityScope

@Module
abstract class ContributorsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsListActivityModule::class])
    abstract fun contributeNewsListActivity(): NewsListActivity
}