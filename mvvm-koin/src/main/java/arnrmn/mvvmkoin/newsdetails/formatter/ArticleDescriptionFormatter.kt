package arnrmn.mvvmkoin.newsdetails.formatter

import arnrmn.mvvmkoin.utils.entity.Article

class ArticleDescriptionFormatter {
    fun format(article: Article): String {
        return article.description
    }
}