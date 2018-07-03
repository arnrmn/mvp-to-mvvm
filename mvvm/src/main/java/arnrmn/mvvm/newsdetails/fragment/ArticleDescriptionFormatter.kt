package arnrmn.mvvm.newsdetails.fragment

import arnrmn.mvvm.utils.entity.Article
import javax.inject.Inject

class ArticleDescriptionFormatter @Inject constructor() {
    fun format(article: Article): String {
        return article.description
    }
}