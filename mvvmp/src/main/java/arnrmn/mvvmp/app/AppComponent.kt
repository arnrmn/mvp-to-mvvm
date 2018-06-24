package arnrmn.mvvmp.app

import arnrmn.mvvmp.newsprovider.NewsProviderModule
import arnrmn.mvvmp.utils.network.NetworkModule
import arnrmn.mvvmp.utils.viewmodel.ViewModelModule
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
            NewsProviderModule::class,
            ViewModelModule::class
        ]
)
interface AppComponent : AndroidInjector<mvvmpApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<mvvmpApplication>()
}
