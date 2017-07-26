package egorikem.bidrushkotlin.di.modules

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.controller.IUsersController
import egorikem.bidrushkotlin.controller.cache.framework.AbstractTimedCacheService
import egorikem.bidrushkotlin.controller.network.NetworkDataProvider
import egorikem.bidrushkotlin.controller.network.UsersController
import egorikem.bidrushkotlin.data.dto.UserDTO

/**
 * Created by egorikem on 7/26/17.
 */
@Module
class UsersControllerModule {
    @Provides
    fun provideUsersController(
            networkDataProvider: NetworkDataProvider,
            usersCache: AbstractTimedCacheService<UserDTO>
    ): IUsersController {
        // Just return implementation we have. If there is a situation dependant situation, do all code here
        return UsersController(networkDataProvider, usersCache)
    }
}