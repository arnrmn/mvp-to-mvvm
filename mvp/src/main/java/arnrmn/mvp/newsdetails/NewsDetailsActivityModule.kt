package arnrmn.mvp.newsdetails

import arnrmn.mvp.newsdetails.fragment.NewsDetailsFragment
import arnrmn.mvp.newsdetails.fragment.NewsDetailsModule
import arnrmn.mvp.utils.dagger.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsDetailsActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsDetailsModule::class])
    abstract fun contributeNewsDetailsFragment(): NewsDetailsFragment
}