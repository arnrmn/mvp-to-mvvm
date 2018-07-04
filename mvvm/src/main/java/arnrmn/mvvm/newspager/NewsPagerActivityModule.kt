package arnrmn.mvvm.newspager

import arnrmn.mvvm.newspager.fragment.NewsPagerFragment
import arnrmn.mvvm.newspager.fragment.NewsPagerModule
import arnrmn.mvvm.utils.dagger.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsPagerActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = [NewsPagerModule::class])
    abstract fun contributePagerfragment(): NewsPagerFragment
}