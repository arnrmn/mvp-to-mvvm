package arnrmn.mvvmkoin.newsdetails

import arnrmn.mvvmkoin.newsdetails.fragment.NewsDetailsFragment
import arnrmn.mvvmkoin.newsdetails.fragment.NewsDetailsModule
import arnrmn.mvvmkoin.utils.dagger.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsDetailsActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsDetailsModule::class])
    abstract fun contributeNewsDetailsFragment(): NewsDetailsFragment
}