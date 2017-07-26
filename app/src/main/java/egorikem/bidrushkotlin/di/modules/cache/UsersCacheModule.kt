package egorikem.bidrushkotlin.di.modules.cache

import dagger.Module
import dagger.Provides
import egorikem.bidrushkotlin.controller.cache.clients.ImpUsersTimedCacheService
import egorikem.bidrushkotlin.controller.cache.framework.AbstractTimedCacheService
import egorikem.bidrushkotlin.data.dto.UserDTO
import java.util.concurrent.Executor

/**
 * Created by egorikem on 7/26/17.
 */
@Module
class UsersCacheModule {
    @Provides
    fun provideUsersCache(executor: Executor): AbstractTimedCacheService<UserDTO> {
        return ImpUsersTimedCacheService(executor)
    }
}