package egorikem.bidrushkotlin.di.component

import dagger.Component
import egorikem.bidrushkotlin.di.modules.NetworkDataProviderModule
import egorikem.bidrushkotlin.di.modules.UsersControllerModule
import egorikem.bidrushkotlin.di.modules.UsersActivityModule
import egorikem.bidrushkotlin.di.modules.cache.UsersCacheModule
import egorikem.bidrushkotlin.di.scope.PerActivity
import egorikem.bidrushkotlin.presentation.view.activities.UserActivity

/**
 * Created by egorikem on 22/10/16.
 */
@PerActivity
@Component(
        dependencies = arrayOf(
                AppComponent::class
        ),
        modules = arrayOf(
                UsersActivityModule::class,
                NetworkDataProviderModule::class,
                UsersCacheModule::class,
                UsersControllerModule::class
        )
)
interface UsersActivityComponent {
    fun inject(activity: UserActivity)
}