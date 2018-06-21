package arnrmn.mvvm.newslist.fragment.list

import arnrmn.mvvm.utils.entity.Article

interface ArticleClickListener {
    fun onArticleClicked(article: Article)
}