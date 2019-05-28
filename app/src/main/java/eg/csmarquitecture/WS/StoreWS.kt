package eg.csmarquitecture.WS

import eg.csmarquitecture.BE.StoreBE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class StoreWS {

    companion object {

        private var disposable : Disposable? = null

        private val airportApi by lazy {
            AirportApi.create()
        }

        fun fetchStores(callback: (StoreBE.TotalResponse) -> Unit) : Disposable?{
            disposable = airportApi.fetchStores()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ result -> callback(result) }
            return disposable
        }
    }

}