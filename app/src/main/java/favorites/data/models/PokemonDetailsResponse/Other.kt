package favorites.data.models

import com.google.gson.annotations.SerializedName


data class Other (

  @SerializedName("dream_world"      ) var dreamWorld       : DreamWorld?       = DreamWorld(),
  @SerializedName("home"             ) var home             : Home?             = Home(),
  @SerializedName("official-artwork" ) var official-artwork : Official-artwork? = Official-artwork(),
  @SerializedName("showdown"         ) var showdown         : Showdown?         = Showdown()

)