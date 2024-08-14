package favorites.data.models

import com.google.gson.annotations.SerializedName


data class Generation-iii (

  @SerializedName("emerald"           ) var emerald           : Emerald?           = Emerald(),
  @SerializedName("firered-leafgreen" ) var firered-leafgreen : Firered-leafgreen? = Firered-leafgreen(),
  @SerializedName("ruby-sapphire"     ) var ruby-sapphire     : Ruby-sapphire?     = Ruby-sapphire()

)