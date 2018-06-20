package arnrmn.mvp.newsprovider

import arnrmn.mvp.utils.entity.Article
import io.reactivex.Single

interface NewsProvider {
    fun getNews(): Single<List<Article>>
}