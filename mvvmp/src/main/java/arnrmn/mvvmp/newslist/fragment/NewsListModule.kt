package arnrmn.mvvmp.newslist.fragment

import arnrmn.mvvmp.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvmp.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvvmp.newslist.fragment.list.ArticlesAdapter
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