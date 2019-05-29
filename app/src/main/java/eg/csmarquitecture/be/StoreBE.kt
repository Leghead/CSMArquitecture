package eg.csmarquitecture.be

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

object StoreBE{

    @Parcelize
    data class TotalResponse(@SerializedName("RestResponse") var tResponse: Response? = Response()
    ) : Parcelable

    @Parcelize
    data class Response(@SerializedName("messages") var messages: ArrayList<String?>? = ArrayList(),
                        @SerializedName("result") var result: ArrayList<StoreBE?>? = ArrayList()
    ) : Parcelable

    @Parcelize
    data class StoreBE(@SerializedName("name") var name: String? = "",
                       @SerializedName("alpha2_code") var alpha2_code: String? = "",
                       @SerializedName("alpha3_code") var alpha3_code: String? = ""
    ) : Parcelable

}