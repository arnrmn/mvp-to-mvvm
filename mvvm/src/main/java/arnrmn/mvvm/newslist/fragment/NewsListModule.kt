package arnrmn.mvvm.newslist.fragment

import arnrmn.mvvm.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvm.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvvm.newslist.fragment.list.ArticlesAdapter
import arnrmn.mvvm.utils.dagger.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NewsListModule {
    @Binds @FragmentScope
    abstract fun bindViewModel(viewModel: NewsListViewModel): NewsListContract.ViewModel

    @Binds
    abstract fun bindArticleClickListener(
            viewModel: NewsListContract.ViewModel
    ): ArticleClickListener

    @Binds
    abstract fun bindModel(model: NewsListModel): NewsListContract.Model

    @Module
    companion object {
        @JvmStatic @Provides
        fun provideArticleViewHolderFactory(
                listener: ArticleClickListener
        ): ArticleViewHolderFactory {
            return ArticleViewHolderFactory(listener)
        }

        @JvmStatic @Provides
        fun provideAdapter(factory: ArticleViewHolderFactory): ArticlesAdapter {
            return ArticlesAdapter(factory)
        }
    }
}