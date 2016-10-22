package egorikem.bidrushkotlin.data.network

import egorikem.bidrushkotlin.data.dto.User
import rx.Observable

/**
 * Created by egorikem on 22/10/16.
 */
interface INetworkDataProvider {
    fun getAllUsers(): Observable<List<User>>

    fun getUser(id: String): Observable<User>
}