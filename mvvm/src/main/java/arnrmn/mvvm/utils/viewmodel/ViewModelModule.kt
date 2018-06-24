package arnrmn.mvvm.utils.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import arnrmn.mvvm.newslist.fragment.NewsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds @IntoMap @ViewModelKey(NewsListViewModel::class)
    abstract fun mainViewModel(viewModel: NewsListViewModel): ViewModel
}