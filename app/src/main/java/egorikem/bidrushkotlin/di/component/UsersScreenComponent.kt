package egorikem.bidrushkotlin.di.component

import dagger.Component
import egorikem.bidrushkotlin.di.modules.ApiModule
import egorikem.bidrushkotlin.di.modules.NetworkDataProviderModule
import egorikem.bidrushkotlin.di.modules.RetrofitModule
import egorikem.bidrushkotlin.di.modules.UsersScreenModule
import egorikem.bidrushkotlin.di.scope.PerActivity
import egorikem.bidrushkotlin.presentation.view.activities.UserActivity
import egorikem.bidrushkotlin.presentation.view.fragments.UserFragment

/**
 * Created by egorikem on 22/10/16.
 */
@PerActivity
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(
                UsersScreenModule::class,
                RetrofitModule::class,
                ApiModule::class,
                NetworkDataProviderModule::class
        )
)
interface UsersScreenComponent {
    fun inject(activity: UserActivity)
    fun inject(fragment: UserFragment)
}