package arnrmn.mvvmkoin.newsdetails

import arnrmn.mvvmkoin.newsdetails.formatter.ArticleDescriptionFormatter
import arnrmn.mvvmkoin.newsdetails.formatter.ArticleTitleFormatter
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.dsl.path.moduleName

val newsDetailsModule: Module = module(NewsDetailsFragment::class.moduleName) {
    single<ArticleDescriptionFormatter>()
    single<ArticleTitleFormatter>()
    viewModel<NewsDetailsViewModel>()
}