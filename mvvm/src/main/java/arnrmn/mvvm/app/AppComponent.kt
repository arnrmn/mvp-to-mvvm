package arnrmn.mvvm.app

import arnrmn.mvvm.newsprovider.NewsProviderModule
import arnrmn.mvvm.utils.network.NetworkModule
import arnrmn.mvvm.utils.viewmodel.ViewModelModule
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
interface AppComponent : AndroidInjector<MvvmApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MvvmApplication>()
}
