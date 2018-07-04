package arnrmn.mvvm.main

import arnrmn.mvvm.main.fragment.MainFragment
import arnrmn.mvvm.utils.dagger.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}