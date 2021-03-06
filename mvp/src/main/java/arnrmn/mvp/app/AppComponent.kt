package arnrmn.mvp.app

import arnrmn.mvp.utils.network.NetworkModule
import arnrmn.mvp.utils.newsprovider.NewsProviderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            ContributorsModule::class,
            NetworkModule::class,
            NewsProviderModule::class
        ]
)
interface AppComponent : AndroidInjector<MvpApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MvpApplication>()
}
