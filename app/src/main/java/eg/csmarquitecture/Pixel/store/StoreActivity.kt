package eg.csmarquitecture.Pixel.store

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import eg.csmarquitecture.BE.Country
import eg.csmarquitecture.BE.Country.CountryBE
import eg.csmarquitecture.BE.StoreBE
import eg.csmarquitecture.BL.StoreBL
import eg.csmarquitecture.R
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class StoreActivity : AppCompatActivity() , View.OnClickListener{

    private var mierdas: ArrayList<CountryBE> = ArrayList()
    private var observer: Disposable? = null

    private var handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMierda.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            btnMierda -> {
                if (observer != null){
                    observer?.dispose()
                }
                observer = StoreBL.fetchStores {
                    handler.postDelayed({
                        Log.d("MIERDA", "CORRECTA")
                        mierdas.clear()
                        mierdas.addAll(it)
                        for (i in mierdas){
                            Log.d("NOMBRE :", i.name)
                        }
                    }, 3000)
                }
            }
        }
    }
}

