package favorites.data.models

import com.google.gson.annotations.SerializedName


data class Generation-i (

  @SerializedName("red-blue" ) var red-blue : Red-blue? = Red-blue(),
  @SerializedName("yellow"   ) var yellow   : Yellow?   = Yellow()

)