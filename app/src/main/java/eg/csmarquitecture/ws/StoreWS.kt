package eg.csmarquitecture.ws

import android.util.Log
import eg.csmarquitecture.be.Country.CountryBE
import eg.csmarquitecture.general.Countries
import eg.csmarquitecture.general.ErrorMessage
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class StoreWS {

    companion object {

        private var disposable: Disposable? = null

        private val airportApi by lazy { AirportApi.create() }

        fun fetchStores(success: Countries, error: ErrorMessage): Disposable? {
            disposable = airportApi.fetchStores()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map { jsonString ->
                    val json     = JSONObject(jsonString)
                    val response= json.getJSONObject("RestResponse")
                    //val messages= response.getJSONArray("messages").getString(0)
                    val result= response.getJSONArray("result")
                    val countries : ArrayList<CountryBE> = ArrayList()
                    for (i in 0 until result.length()){
                        val country = CountryBE()
                        country.name        = result.getJSONObject(i).getString("name") ?: ""
                        country.alpha2_code = result.getJSONObject(i).getString("alpha2_code") ?: ""
                        country.alpha3_code = null ?: ""
                        countries.add(country)
                    }
                    return@map countries
                }
                .subscribe(
                    { result  -> success(result) },
                    { failure -> error(failure.localizedMessage) }
                )
            return disposable
        }
    }

}