package egorikem.bidrushkotlin.data.dto

/**
 * Created by egorikem on 7/26/17.
 */
data class UserDTO(
        val id: String,
        var firstName: String,
        val lastName: String,
        var score: Int
) {

    fun getFullName(): String {
        return "$firstName $lastName"
    }
}