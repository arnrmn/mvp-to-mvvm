package arnrmn.mvvmkoin.newspager

import arnrmn.mvvmkoin.newspager.fragment.NewsPagerFragment
import arnrmn.mvvmkoin.newspager.fragment.NewsPagerModule
import arnrmn.mvvmkoin.utils.dagger.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsPagerActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsPagerModule::class])
    abstract fun contributePagerfragment(): NewsPagerFragment
}