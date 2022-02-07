package com.orion.coppelmvvvm.data.model

import com.google.gson.annotations.SerializedName

data class HeroModel(
    @SerializedName("response") val response:String,
    @SerializedName("id") val id:String,
    @SerializedName("name")val name:String,
    @SerializedName("url") val url:String

)
