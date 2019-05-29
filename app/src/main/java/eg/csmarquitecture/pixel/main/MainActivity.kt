package eg.csmarquitecture.pixel.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eg.csmarquitecture.pixel.store.StoreActivity
import eg.csmarquitecture.R
import kotlinx.android.synthetic.main.activity_store.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        btnCTM.setOnClickListener {
            startActivity(Intent(this, StoreActivity::class.java))
        }
    }
}
