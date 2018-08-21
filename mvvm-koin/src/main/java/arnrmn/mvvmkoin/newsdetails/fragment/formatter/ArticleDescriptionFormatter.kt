package arnrmn.mvvmkoin.newsdetails.fragment.formatter

import arnrmn.mvvmkoin.utils.entity.Article
import javax.inject.Inject

class ArticleDescriptionFormatter @Inject constructor() {
    fun format(article: Article): String {
        return article.description
    }
}