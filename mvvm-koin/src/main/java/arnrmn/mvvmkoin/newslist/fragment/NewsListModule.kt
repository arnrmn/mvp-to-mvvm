package arnrmn.mvvmkoin.newslist.fragment

import arnrmn.mvvmkoin.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvmkoin.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvvmkoin.newslist.fragment.list.ArticlesAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NewsListModule {
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
    }
}