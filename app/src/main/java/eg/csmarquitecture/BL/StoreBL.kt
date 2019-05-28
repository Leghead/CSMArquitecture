package eg.csmarquitecture.BL

import eg.csmarquitecture.BE.StoreBE
import eg.csmarquitecture.WS.StoreWS
import io.reactivex.disposables.Disposable


class StoreBL {

    companion object {

        fun fetchStores(callback: (StoreBE.TotalResponse) -> Unit): Disposable?{
            return StoreWS.fetchStores(callback)
        }

    }

}