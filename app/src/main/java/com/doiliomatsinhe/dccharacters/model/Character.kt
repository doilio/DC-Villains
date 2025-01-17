package com.doiliomatsinhe.dccharacters.model

data class Character(
    val id: Int,
    val name: String,
    val slug: String,
    val powerstats: Powerstats,
    val appearance: Appearance,
    val biography: Biography,
    val work: Work,
    val connections: Connections,
    val images: Images
) {

    var dominantcolor: Int = -12038056
}

data class Work(
    val occupation: String,
    val base: String
)

data class Powerstats(
    val intelligence: Int = 0,
    val strength: Int = 0,
    val speed: Int = 0,
    val durability: Int = 0,
    val power: Int = 0,
    val combat: Int = 0
)

data class Images(
    val xs: String,
    val sm: String,
    val md: String,
    val lg: String
)

data class Connections(
    val groupAffiliation: String,
    val relatives: String
)

data class Biography(
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String?,
    val alignment: String
)

data class Appearance(
    val gender: String,
    val race: String?,
    val height: List<String>,
    val weight: List<String>,
    val eyeColor: String,
    val hairColor: String
)