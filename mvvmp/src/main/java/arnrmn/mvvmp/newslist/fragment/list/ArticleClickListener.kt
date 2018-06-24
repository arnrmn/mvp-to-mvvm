package arnrmn.mvvmp.newslist.fragment.list

import arnrmn.mvvmp.utils.entity.Article

interface ArticleClickListener {
    fun onArticleClicked(article: Article)
}