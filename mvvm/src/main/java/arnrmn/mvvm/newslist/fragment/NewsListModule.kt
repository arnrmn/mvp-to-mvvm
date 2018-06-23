package arnrmn.mvvm.newslist.fragment

import arnrmn.mvvm.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvm.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvvm.newslist.fragment.list.ArticlesAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NewsListModule {
    @Binds
    abstract fun bindViewModel(viewModel: NewsListViewModel): NewsListContract.MainViewModel

    @Binds
    abstract fun bindArticleClickListener(viewModel: NewsListViewModel): ArticleClickListener

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