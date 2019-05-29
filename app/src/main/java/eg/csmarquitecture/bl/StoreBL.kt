package eg.csmarquitecture.bl

import eg.csmarquitecture.general.Countries
import eg.csmarquitecture.general.ErrorMessage
import eg.csmarquitecture.ws.StoreWS
import io.reactivex.disposables.Disposable


class StoreBL {

    companion object {

        fun fetchStores(success: Countries, error: ErrorMessage): Disposable?{
            return StoreWS.fetchStores(success, error)
        }

    }

}