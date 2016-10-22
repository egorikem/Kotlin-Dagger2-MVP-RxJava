package egorikem.bidrushkotlin.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by egorikem on 22/10/16.
 */
data class User(
        val id: String,
        @SerializedName("facebook_id") val facebookId: String,
        val name: String,
        val picture: String,
        var credits: Double,
        var tokens: Double,
        @SerializedName("is_superuser") var isSuperUser: Boolean,
        val roles: List<String>,
        @SerializedName("has_tokens_renewed") val hasTokensRenewed: Boolean,
        @SerializedName("is_graduated") val isGraduated: Boolean,
        @SerializedName("ref_code") val refCode: String,
        @SerializedName("is_bounced") val isBounced: Boolean,
        @SerializedName("left_application") val leftApplication: String,
        val activity: Activity,
        val vip: VipStatus
)