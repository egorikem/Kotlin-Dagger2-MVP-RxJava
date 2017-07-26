package egorikem.bidrushkotlin.controller.network

import egorikem.bidrushkotlin.controller.IUsersController
import egorikem.bidrushkotlin.controller.cache.framework.AbstractTimedCacheService
import egorikem.bidrushkotlin.data.dto.UserDTO
import rx.Completable
import rx.Observable
import javax.inject.Inject

/**
 * Created by egorikem on 7/26/17.
 */
class UsersController: IUsersController {

    private var networkController: NetworkDataProvider
    private var usersCache: AbstractTimedCacheService<UserDTO>

    @Inject
    constructor(networkController: NetworkDataProvider, usersCache: AbstractTimedCacheService<UserDTO>) {
        this.networkController = networkController
        this.usersCache = usersCache
    }

    override fun getUsers(): Observable<List<UserDTO>> {
        return usersCache.readCollection()
    }

    override fun getUser(userId: String): Observable<UserDTO?> {
        return usersCache.readItem(userId)
    }

    override fun addUser(userDTO: UserDTO): Completable {
        return Completable.fromAction {
            usersCache.addItem(userDTO)
        }
    }
}