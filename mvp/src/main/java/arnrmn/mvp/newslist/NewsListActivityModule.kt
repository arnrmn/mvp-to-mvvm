package arnrmn.mvp.newslist

import arnrmn.mvp.newslist.fragment.NewsListFragment
import arnrmn.mvp.newslist.fragment.NewsListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dk.tv2.onboarding.FragmentScope

@Module
abstract class NewsListActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsListModule::class])
    abstract fun contributeNewsListFragment(): NewsListFragment
}