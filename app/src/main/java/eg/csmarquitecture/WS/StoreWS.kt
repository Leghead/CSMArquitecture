package eg.csmarquitecture.WS

import android.util.Log
import eg.csmarquitecture.BE.Country.CountryBE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class StoreWS {

    companion object {

        private var disposable: Disposable? = null

        private val airportApi by lazy {
            AirportApi.create()
        }

        fun fetchStores(callback: (ArrayList<CountryBE>) -> Unit): Disposable? {
            disposable = airportApi.fetchStores()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    val json     = JSONObject(it)
                    val response = json.getJSONObject("RestResponse")
                    //val messages = response.getJSONArray("messages").getString(0)
                    val result   = response.getJSONArray("result")
                    val countrys : ArrayList<CountryBE> = ArrayList()
                    for (i in 0 until result.length()){
                        val country = CountryBE()
                        country.name = result.getString(i)
                        country.alpha2_code = result.getString(i)
                        country.alpha3_code = null
                        countrys.add(country)
                    }
                    return@map countrys
                }
                .subscribe(
                    { result ->
                        callback(result)
                    },
                    { error -> Log.d("ERROR", error.localizedMessage) }
                )
            return disposable
        }
    }

}