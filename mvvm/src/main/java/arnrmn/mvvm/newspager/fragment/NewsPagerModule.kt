package arnrmn.mvvm.newspager.fragment

import arnrmn.mvvm.newsdetails.fragment.NewsDetailsFragment
import arnrmn.mvvm.newsdetails.fragment.NewsDetailsModule
import arnrmn.mvvm.utils.dagger.ChildFragmentScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsPagerModule {
    @ChildFragmentScope
    @ContributesAndroidInjector(modules = [NewsDetailsModule::class])
    abstract fun contributeDetailsFragment(): NewsDetailsFragment

    @Module
    companion object {
        @JvmStatic @Provides
        fun providePagerAdapter(fragment: NewsPagerFragment): NewsPagerAdapter {
            return NewsPagerAdapter(fragment.childFragmentManager)
        }
    }
}