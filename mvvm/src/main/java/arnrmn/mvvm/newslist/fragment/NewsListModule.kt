package arnrmn.mvvm.newslist.fragment

import arnrmn.mvvm.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvm.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvvm.newslist.fragment.list.ArticlesAdapter
import dagger.Binds
import dagger.Module
import dagger.Provides
import arnrmn.mvvm.utils.dagger.FragmentScope

@Module
abstract class NewsListModule {
    @Binds @FragmentScope
    abstract fun bindPresenter(presenter: NewsListPresenter): NewsListContract.Presenter

    @Binds
    abstract fun bindModel(model: NewsListModel): NewsListContract.Model

    @Binds
    abstract fun bindArticleClickListener(
            presenter: NewsListContract.Presenter
    ): ArticleClickListener

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