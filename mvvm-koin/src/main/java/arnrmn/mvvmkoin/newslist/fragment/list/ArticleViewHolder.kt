package arnrmn.mvvmkoin.newslist.fragment.list

import android.support.v7.widget.RecyclerView
import android.view.View
import arnrmn.mvvmkoin.utils.android.loadUrl
import arnrmn.mvvmkoin.utils.entity.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleViewHolder(
        view: View,
        private val listener: ArticleClickListener
) : RecyclerView.ViewHolder(view) {

    fun bind(article: Article) {
        itemView.setOnClickListener { listener.onArticleClicked(article) }
        itemView.articleImageView.loadUrl(article.urlToImage)
        itemView.titleTextView.text = article.title
        itemView.dateTextView.text = article.publishedAt
    }
}