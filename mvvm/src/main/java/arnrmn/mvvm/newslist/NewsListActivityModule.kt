package arnrmn.mvvm.newslist

import arnrmn.mvvm.newslist.fragment.NewsListFragment
import arnrmn.mvvm.newslist.fragment.NewsListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import arnrmn.mvvm.utils.dagger.FragmentScope

@Module
abstract class NewsListActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsListModule::class])
    abstract fun contributeNewsListFragment(): NewsListFragment
}