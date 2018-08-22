package arnrmn.mvvmkoin.newslist.list

import arnrmn.mvvmkoin.utils.entity.Article

interface ArticleClickListener {
    fun onArticleClicked(article: Article)
}