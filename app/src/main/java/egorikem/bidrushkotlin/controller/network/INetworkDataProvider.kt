package egorikem.bidrushkotlin.controller.network

import egorikem.bidrushkotlin.data.dto.UserDTO
import rx.Observable

/**
 * Created by egorikem on 22/10/16.
 */
interface INetworkDataProvider {
    /**
     * Method to get all users
     */
    fun getAllUsers(): Observable<List<UserDTO>>

    /**
     * Method to get a specified user
     * @param id User id
     */
    fun getUser(id: String): Observable<UserDTO>
}