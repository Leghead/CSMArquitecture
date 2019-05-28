package eg.csmarquitecture.WS

import eg.csmarquitecture.BE.StoreBE
import eg.csmarquitecture.WS.Constants.Companion.base_url
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AirportApi {

    @GET("country/get/all")
    fun fetchStores() : Observable<StoreBE.TotalResponse>

    companion object {
        fun create(): AirportApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url)
                .build()

            return retrofit.create(AirportApi::class.java)
        }
    }
}