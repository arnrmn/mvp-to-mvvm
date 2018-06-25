package arnrmn.mvvmp.newslist.fragment

import android.arch.lifecycle.ViewModelProviders
import arnrmn.mvvmp.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvmp.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvvmp.newslist.fragment.list.ArticlesAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NewsListModule {
    @Binds
    abstract fun bindView(viewModel: NewsListViewModel): NewsListContract.View

    @Binds
    abstract fun bindPresenter(presenter: NewsListPresenter): NewsListContract.Presenter

    @Binds
    abstract fun bindArticleClickListener(fragment: NewsListFragment): ArticleClickListener

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

        @JvmStatic @Provides
        fun provideViewModel(fragment: NewsListFragment): NewsListViewModel {
            return ViewModelProviders.of(fragment)[NewsListViewModel::class.java]
        }
    }
}