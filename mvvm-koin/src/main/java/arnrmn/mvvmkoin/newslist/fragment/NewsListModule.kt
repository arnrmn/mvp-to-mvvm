package arnrmn.mvvmkoin.newslist.fragment

import arnrmn.mvvmkoin.newslist.fragment.list.ArticleClickListener
import arnrmn.mvvmkoin.newslist.fragment.list.ArticleViewHolderFactory
import arnrmn.mvvmkoin.newslist.fragment.list.ArticlesAdapter
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName

val newsListModule: Module = module(NewsListFragment::class.moduleName) {
    factory { (listener: ArticleClickListener) -> createArticleAdapter(listener) }
    viewModel<NewsListViewModel>()
}

private fun createArticleAdapter(listener: ArticleClickListener): ArticlesAdapter {
    return ArticlesAdapter(ArticleViewHolderFactory(listener))
}