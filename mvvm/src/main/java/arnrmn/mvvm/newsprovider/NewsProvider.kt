package arnrmn.mvvm.newsprovider

import arnrmn.mvvm.utils.entity.Article
import io.reactivex.Single

interface NewsProvider {
    fun getNews(): Single<List<Article>>
}