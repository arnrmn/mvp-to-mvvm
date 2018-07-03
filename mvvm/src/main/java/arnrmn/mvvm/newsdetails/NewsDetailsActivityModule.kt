package arnrmn.mvvm.newsdetails

import arnrmn.mvvm.newsdetails.fragment.NewsDetailsFragment
import arnrmn.mvvm.newsdetails.fragment.NewsDetailsModule
import arnrmn.mvvm.utils.dagger.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsDetailsActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsDetailsModule::class])
    abstract fun contributeNewsDetailsFragment(): NewsDetailsFragment
}