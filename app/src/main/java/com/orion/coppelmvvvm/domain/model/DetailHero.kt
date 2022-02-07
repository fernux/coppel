package com.orion.coppelmvvvm.domain.model

import com.google.gson.annotations.SerializedName


data class DetailHero (

    @SerializedName("biography")val biography: Biography = Biography(),
    @SerializedName("powerstats")val powerstats:Powerstats = Powerstats(),
    @SerializedName("id")val id: String = "",
    @SerializedName("name")val name: String = "",
    @SerializedName("appearance")val appearance:Appearance = Appearance(),
    @SerializedName("image")val image:Image = Image(),
    @SerializedName("work")val work:Work = Work(),
    @SerializedName("connections")val connections:Connections = Connections(),

    ){

}

data class Biography(
    @SerializedName("aliases")val aliases: List<String> = arrayListOf(),
    @SerializedName("alignment")val alignment: String = "",
    @SerializedName("alter-egos")val alter_egos: String = "",
    @SerializedName("first-appearance")val first_appearance: String= "",
    @SerializedName("full-name") val full_name: String= "",
    @SerializedName("place-of-birth")val place_of_birth: String= "",
    @SerializedName("publisher")val publisher: String= ""
)
data class Powerstats(
    @SerializedName("combat")val combat: String= "",
    @SerializedName("durability")val durability: String= "",
    @SerializedName("intelligence")val intelligence: String= "",
    @SerializedName("power")val power: String= "",
    @SerializedName("speed")val speed: String= "",
    @SerializedName("strength")val strength: String= ""
)
data class Image(
    @SerializedName("url")val url: String =""
)
data class Work(
    @SerializedName("base")val base: String = "",
    @SerializedName("occupation")val occupation: String = ""
)
data class Connections(
    @SerializedName("group-affiliation")val group_affiliation: String ="",
    @SerializedName("relatives")val relatives: String=""
)
data class Appearance(
    @SerializedName("eye-color")val eye_color: String="",
    @SerializedName("gender")val gender: String="",
    @SerializedName("hair-color")val hair_color: String="",
    @SerializedName("height")val height: List<String> = arrayListOf(),
    @SerializedName("race")val race: String ="",
    @SerializedName("weight")val weight: List<String> = arrayListOf()
)




