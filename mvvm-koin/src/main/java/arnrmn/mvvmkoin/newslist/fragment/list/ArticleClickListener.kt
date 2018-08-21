package arnrmn.mvvmkoin.newslist.fragment.list

import arnrmn.mvvmkoin.utils.entity.Article

interface ArticleClickListener {
    fun onArticleClicked(article: Article)
}