package arnrmn.mvvmkoin.newsdetails.formatter

import arnrmn.mvvmkoin.utils.entity.Article

class ArticleTitleFormatter {
    fun format(article: Article): String {
        return article.title
    }
}