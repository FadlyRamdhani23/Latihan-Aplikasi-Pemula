package org.d3if3127.dicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000 // Delay dalam milidetik (1 detik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            // Kode ini akan dijalankan setelah SPLASH_DELAY
            val intent = Intent(this, MainActivity::class.java) // Ganti dengan nama aktivitas utama Anda
            startActivity(intent)
            finish() // Tutup aktivitas ini agar tidak dapat dikembalikan dengan tombol back
        }, SPLASH_DELAY)
    }
}