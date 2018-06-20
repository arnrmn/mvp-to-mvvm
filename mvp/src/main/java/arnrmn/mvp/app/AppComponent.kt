package arnrmn.mvp.app

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            AppModule::class,
            ContributorsModule::class
        ]
)
interface AppComponent : AndroidInjector<MvpApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MvpApplication>()
}
