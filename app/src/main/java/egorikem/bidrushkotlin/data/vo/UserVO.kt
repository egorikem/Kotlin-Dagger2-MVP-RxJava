package egorikem.bidrushkotlin.data.vo

import egorikem.bidrushkotlin.data.dto.UserDTO

/**
 * Created by egorikem on 7/26/17.
 */
data class UserVO(
        val id: String,
        var name: String,
        private var isSelected: Boolean,
        var score: Int
) {
    fun toggleSelected() {
        isSelected = !isSelected
    }

    fun getSelected(): Boolean {
        return isSelected
    }

    companion object
}

infix fun <DTO>UserVO.Companion.copyFrom(dto: DTO): UserVO? {
    if(dto is UserDTO) {
        return UserVO(
                id = dto.id,
                name = dto.getFullName(),
                isSelected = false,
                score = dto.score
        )
    }

    return null
}