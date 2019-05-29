package eg.csmarquitecture.ws

import eg.csmarquitecture.general.Constants.Companion.base_url
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface AirportApi {

    @GET("country/get/all")
    fun fetchStores() : Single<String>

    companion object {
        fun create(): AirportApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(base_url)
                .build()

            return retrofit.create(AirportApi::class.java)
        }
    }
}