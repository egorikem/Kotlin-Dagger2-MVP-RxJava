package egorikem.bidrushkotlin.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by egorikem on 22/10/16.
 */
data class VipStatus(
        val title: String,
        @SerializedName("monthly_cashback") val monthlyCashBack: Int,
        @SerializedName("level_up_credits") val levelUpCredits: Int,
        @SerializedName("auction_unlock") val auctionUnlock: Int
)