package arnrmn.mvvmp.newsprovider

import arnrmn.mvvmp.utils.entity.Article
import io.reactivex.Single

interface NewsProvider {
    fun getNews(): Single<List<Article>>
}