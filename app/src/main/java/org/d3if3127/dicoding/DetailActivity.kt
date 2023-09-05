package org.d3if3127.dicoding

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_BURUNG = "extra_burung"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val deskripsiq: TextView = findViewById(R.id.deskripsiq)
        val nama : TextView = findViewById(R.id.judul)
        val gambar : ImageView = findViewById(R.id.img_item_photozz)
        val makanan : TextView = findViewById(R.id.makananan)
        val Burung = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Burung>(EXTRA_BURUNG, Burung::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Burung>(EXTRA_BURUNG)
        }
        if (Burung != null) {
            deskripsiq.text = Burung.description
            nama.text = Burung.name
            gambar.setImageResource(Burung.photo)
            makanan.text = Burung.makanan
        }
    }
}