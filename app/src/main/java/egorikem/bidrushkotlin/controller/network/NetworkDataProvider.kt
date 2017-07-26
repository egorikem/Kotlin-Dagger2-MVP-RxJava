package egorikem.bidrushkotlin.controller.network

import egorikem.bidrushkotlin.data.dto.UserDTO
import rx.Observable

/**
 * Created by egorikem on 22/10/16.
 */
class NetworkDataProvider(val api: IBidRushApi) : INetworkDataProvider {

    override fun getAllUsers(): Observable<List<UserDTO>> = api.getUsers()

    override fun getUser(id: String): Observable<UserDTO> = api.getUser(id)
}