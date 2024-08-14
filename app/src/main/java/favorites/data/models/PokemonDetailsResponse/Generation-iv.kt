package favorites.data.models

import com.google.gson.annotations.SerializedName


data class Generation-iv (

  @SerializedName("diamond-pearl"        ) var diamond-pearl        : Diamond-pearl?        = Diamond-pearl(),
  @SerializedName("heartgold-soulsilver" ) var heartgold-soulsilver : Heartgold-soulsilver? = Heartgold-soulsilver(),
  @SerializedName("platinum"             ) var platinum             : Platinum?             = Platinum()

)