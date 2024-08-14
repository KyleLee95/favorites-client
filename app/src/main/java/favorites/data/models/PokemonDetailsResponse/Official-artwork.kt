package favorites.data.models

import com.google.gson.annotations.SerializedName


data class Official-artwork (

  @SerializedName("front_default" ) var frontDefault : String? = null,
  @SerializedName("front_shiny"   ) var frontShiny   : String? = null

)