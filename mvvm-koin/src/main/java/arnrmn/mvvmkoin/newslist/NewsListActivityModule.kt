package arnrmn.mvvmkoin.newslist

import arnrmn.mvvmkoin.newslist.fragment.NewsListFragment
import arnrmn.mvvmkoin.newslist.fragment.NewsListModule
import arnrmn.mvvmkoin.utils.dagger.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsListActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsListModule::class])
    abstract fun contributeNewsListFragment(): NewsListFragment
}