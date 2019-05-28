package eg.csmarquitecture.BL

import eg.csmarquitecture.BE.Country.CountryBE
import eg.csmarquitecture.WS.StoreWS
import io.reactivex.disposables.Disposable


class StoreBL {

    companion object {

        fun fetchStores(callback: (ArrayList<CountryBE>) -> Unit): Disposable?{
            return StoreWS.fetchStores(callback)
        }

    }

}