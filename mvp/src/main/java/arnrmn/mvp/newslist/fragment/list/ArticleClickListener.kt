package arnrmn.mvp.newslist.fragment.list

import arnrmn.mvp.utils.entity.Article

interface ArticleClickListener {
    fun onArticleClicked(article: Article)
}