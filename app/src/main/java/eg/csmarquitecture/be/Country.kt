package eg.csmarquitecture.be

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

object Country{

    @Parcelize
    data class Response(@SerializedName("RestResponse") var tResponse: Response? = Response()
    ) : Parcelable

    @Parcelize
    data class Data(@SerializedName("messages") var messages: ArrayList<String?>? = ArrayList(),
                    @SerializedName("result") var result: ArrayList<CountryBE?>? = ArrayList()
    ) : Parcelable

    @Parcelize
    data class CountryBE(@SerializedName("name") var name: String? = "",
                        @SerializedName("alpha2_code") var alpha2_code: String? = "",
                        @SerializedName("alpha3_code") var alpha3_code: String? = ""
    ) : Parcelable

}