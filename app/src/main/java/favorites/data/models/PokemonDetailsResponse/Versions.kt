package favorites.data.models

import com.google.gson.annotations.SerializedName


data class Versions (

  @SerializedName("generation-i"    ) var generation-i    : Generation-i?    = Generation-i(),
  @SerializedName("generation-ii"   ) var generation-ii   : Generation-ii?   = Generation-ii(),
  @SerializedName("generation-iii"  ) var generation-iii  : Generation-iii?  = Generation-iii(),
  @SerializedName("generation-iv"   ) var generation-iv   : Generation-iv?   = Generation-iv(),
  @SerializedName("generation-v"    ) var generation-v    : Generation-v?    = Generation-v(),
  @SerializedName("generation-vi"   ) var generation-vi   : Generation-vi?   = Generation-vi(),
  @SerializedName("generation-vii"  ) var generation-vii  : Generation-vii?  = Generation-vii(),
  @SerializedName("generation-viii" ) var generation-viii : Generation-viii? = Generation-viii()

)