package egorikem.bidrushkotlin.controller

import egorikem.bidrushkotlin.data.dto.UserDTO
import rx.Completable
import rx.Observable

/**
 * Created by egorikem on 7/26/17.
 */
interface IUsersController {
    fun getUsers(): Observable<List<UserDTO>>
    fun getUser(userId: String): Observable<UserDTO?>
    fun addUser(userDTO: UserDTO): Completable
}