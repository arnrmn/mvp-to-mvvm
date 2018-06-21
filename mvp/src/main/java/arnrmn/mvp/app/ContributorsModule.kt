package arnrmn.mvp.app

import arnrmn.mvp.newslist.NewsListActivity
import arnrmn.mvp.newslist.NewsListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import arnrmn.mvp.utils.dagger.ActivityScope

@Module
abstract class ContributorsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsListActivityModule::class])
    abstract fun contributeNewsListActivity(): NewsListActivity
}