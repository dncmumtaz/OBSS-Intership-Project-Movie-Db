package co.obss.tr.obsstest.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id") val id: Long?,
    @SerializedName("name") val name: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("image") val image: String?
)
