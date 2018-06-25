package arnrmn.mvp.newslist.fragment

import arnrmn.mvp.newslist.fragment.list.ArticleClickListener
import arnrmn.mvp.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvp.newslist.fragment.list.ArticlesAdapter
import arnrmn.mvp.utils.dagger.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class NewsListModule {
    @Binds @FragmentScope
    abstract fun bindPresenter(presenter: NewsListPresenter): NewsListContract.Presenter

    @Binds
    abstract fun bindArticleClickListener(fragment: NewsListFragment): ArticleClickListener

    @Module
    companion object {
        @JvmStatic @Provides
        fun provideViewHolderFactory(listener: ArticleClickListener): ArticleViewHolderFactory {
            return ArticleViewHolderFactory(listener)
        }

        @JvmStatic @Provides
        fun provideAdapter(factory: ArticleViewHolderFactory): ArticlesAdapter {
            return ArticlesAdapter(factory)
        }
    }
}