package eg.csmarquitecture.Pixel.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eg.csmarquitecture.BE.StoreBE
import eg.csmarquitecture.BL.StoreBL
import eg.csmarquitecture.R
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mierdas: StoreBE.StoreBE
    private var observer: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observer = StoreBL.fetchStores {
            this.mierdas = it.tResponse.result[0]
            txvMierda.text = mierdas.name
            btnMierda.animate().alpha(0f)
        }

        //observer?.dispose()
    }
}
