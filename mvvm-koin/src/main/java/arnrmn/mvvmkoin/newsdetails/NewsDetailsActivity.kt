package arnrmn.mvvmkoin.newsdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import arnrmn.mvvmkoin.R
import arnrmn.mvvmkoin.newsdetails.fragment.NewsDetailsFragment
import arnrmn.mvvmkoin.utils.android.BaseActivity
import arnrmn.mvvmkoin.utils.android.replaceFragment
import arnrmn.mvvmkoin.utils.entity.Article
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewsDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        replaceFragment(NewsDetailsFragment.newInstance(getArticle()))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getArticle(): Article {
        return intent.extras.getParcelable(EXTRA_ARTICLE)
    }

    companion object {
        private const val EXTRA_ARTICLE = "extra.article"

        fun start(context: Context?, article: Article) {
            context?.let {
                context.startActivity(createIntent(context, article))
            }
        }

        fun createIntent(context: Context?, article: Article): Intent {
            val intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra(EXTRA_ARTICLE, article)
            return intent
        }
    }
}