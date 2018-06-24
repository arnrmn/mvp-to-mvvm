package arnrmn.mvvmp.newslist.fragment.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import arnrmn.mvvmp.utils.entity.Article
import javax.inject.Inject

class ArticlesAdapter @Inject constructor(
        private val factory: ArticleViewHolderFactory
) : RecyclerView.Adapter<ArticleViewHolder>() {
    private val articles = mutableListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return factory.create(parent)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    fun update(articles: List<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }
}