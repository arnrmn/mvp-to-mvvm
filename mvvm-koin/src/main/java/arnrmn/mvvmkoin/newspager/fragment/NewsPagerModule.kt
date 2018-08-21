package arnrmn.mvvmkoin.newspager.fragment

import arnrmn.mvvmkoin.newslist.fragment.NewsListFragment
import arnrmn.mvvmkoin.newslist.fragment.NewsListModule
import arnrmn.mvvmkoin.utils.dagger.ChildFragmentScope
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsPagerModule {
    @ChildFragmentScope
    @ContributesAndroidInjector(modules = [NewsListModule::class])
    abstract fun contributeDetailsFragment(): NewsListFragment

    @Module
    companion object {
        @JvmStatic @Provides
        fun providePagerAdapter(fragment: NewsPagerFragment): NewsPagerAdapter {
            return NewsPagerAdapter(fragment.childFragmentManager)
        }
    }
}