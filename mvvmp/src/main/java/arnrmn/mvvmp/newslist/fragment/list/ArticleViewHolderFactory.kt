package arnrmn.mvvmp.newslist.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import arnrmn.mvvmp.R

class ArticleViewHolderFactory(
        private val listener: ArticleClickListener
) {
    fun create(parent: ViewGroup): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view, listener)
    }
}