package eg.csmarquitecture.BE

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

object Country{

    @Parcelize
    data class Response(@SerializedName("RestResponse") var tResponse: Response = null ?: Response()
    ) : Parcelable

    @Parcelize
    data class Data(@SerializedName("messages") var messages: ArrayList<String> = null ?: ArrayList(),
                    @SerializedName("result") var result: ArrayList<CountryBE> = null ?: ArrayList()
    ) : Parcelable

    @Parcelize
    data class CountryBE(@SerializedName("name") var name: String? = null ?: "",
                        @SerializedName("alpha2_code") var alpha2_code: String? = null ?: "",
                        @SerializedName("alpha3_code") var alpha3_code: String? = null ?: ""
    ) : Parcelable

}