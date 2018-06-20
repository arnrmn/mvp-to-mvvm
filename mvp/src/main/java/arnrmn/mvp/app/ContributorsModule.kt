package arnrmn.mvp.app

import arnrmn.mvp.newslist.NewsListActivity
import arnrmn.mvp.newslist.NewsListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dk.tv2.onboarding.ActivityScope

@Module
abstract class ContributorsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsListActivityModule::class])
    abstract fun contributeNewsListActivity(): NewsListActivity
}