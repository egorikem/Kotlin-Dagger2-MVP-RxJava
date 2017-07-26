package egorikem.bidrushkotlin.controller.cache.clients

import egorikem.bidrushkotlin.controller.cache.TimedCacheObject
import egorikem.bidrushkotlin.controller.cache.framework.AbstractTimedCacheService
import egorikem.bidrushkotlin.controller.cache.framework.ImpTimedAbstractPaperService
import egorikem.bidrushkotlin.data.Constants
import egorikem.bidrushkotlin.data.dto.UserDTO
import java.util.concurrent.Executor

/**
 * Created by egorikem on 7/23/17.
 */
class ImpUsersTimedCacheService(executor: Executor) : AbstractTimedCacheService<UserDTO>(executor) {

    private class UsersTimedPaperService : ImpTimedAbstractPaperService<UserDTO>() {
        override fun setBook(): String {
            return Constants.Books.USERS_BOOK
        }

        override fun setKey(): String {
            return Constants.Keys.USERS_KEY
        }

        override fun comparator(item: TimedCacheObject<UserDTO>): String {
            return item.getData()!!.id
        }
    }

    override fun provideTimedPaperService(): ImpTimedAbstractPaperService<UserDTO> {
        return UsersTimedPaperService()
    }
}