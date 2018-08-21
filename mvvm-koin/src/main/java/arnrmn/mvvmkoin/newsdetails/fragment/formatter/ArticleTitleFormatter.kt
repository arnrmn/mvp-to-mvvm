package arnrmn.mvvmkoin.newsdetails.fragment.formatter

import arnrmn.mvvmkoin.utils.entity.Article
import javax.inject.Inject

class ArticleTitleFormatter @Inject constructor() {
    fun format(article: Article): String {
        return article.title
    }
}