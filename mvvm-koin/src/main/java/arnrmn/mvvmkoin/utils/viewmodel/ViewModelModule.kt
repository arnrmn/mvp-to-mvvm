package arnrmn.mvvmkoin.utils.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import arnrmn.mvvmkoin.newsdetails.fragment.NewsDetailsViewModel
import arnrmn.mvvmkoin.newslist.fragment.NewsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds @IntoMap @ViewModelKey(NewsListViewModel::class)
    abstract fun listViewModel(viewModel: NewsListViewModel): ViewModel

    @Binds @IntoMap @ViewModelKey(NewsDetailsViewModel::class)
    abstract fun detailsViewModel(viewModel: NewsDetailsViewModel): ViewModel
}