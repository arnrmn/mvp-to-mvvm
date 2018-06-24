package arnrmn.mvvmp.newslist

import arnrmn.mvvmp.newslist.fragment.NewsListFragment
import arnrmn.mvvmp.newslist.fragment.NewsListModule
import arnrmn.mvvmp.utils.dagger.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsListActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsListModule::class])
    abstract fun contributeNewsListFragment(): NewsListFragment
}