package co.obss.tr.obsstest.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("results") val results: List<Character>?
)