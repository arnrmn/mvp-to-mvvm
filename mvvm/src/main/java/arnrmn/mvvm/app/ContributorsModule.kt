package arnrmn.mvvm.app

import arnrmn.mvvm.main.MainActivity
import arnrmn.mvvm.main.MainActivityModule
import arnrmn.mvvm.newsdetails.NewsDetailsActivity
import arnrmn.mvvm.newsdetails.NewsDetailsActivityModule
import arnrmn.mvvm.newslist.NewsListActivity
import arnrmn.mvvm.newslist.NewsListActivityModule
import arnrmn.mvvm.newspager.NewsPagerActivity
import arnrmn.mvvm.newspager.NewsPagerActivityModule
import arnrmn.mvvm.utils.dagger.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ContributorsModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsListActivityModule::class])
    abstract fun contributeNewsListActivity(): NewsListActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsDetailsActivityModule::class])
    abstract fun contributeNewsDetailsActivity(): NewsDetailsActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [NewsPagerActivityModule::class])
    abstract fun contributeNewsPagerActivity(): NewsPagerActivity
}