package org.d3if3127.dicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBurung: RecyclerView
    private val list = ArrayList<Burung>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvBurung = findViewById(R.id.rv_burung)
        rvBurung.setHasFixedSize(true)
        list.addAll(getListBurung())
        showRecyclerList()
    }
    private fun getListBurung(): ArrayList<Burung> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataMakanan = resources.getStringArray(R.array.data_makanan)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listBurung = ArrayList<Burung>()
        for (i in dataName.indices) {
            val Burung = Burung(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataMakanan[i])
            listBurung.add(Burung)
        }
        return listBurung
    }

    private fun showRecyclerList() {
        rvBurung.layoutManager = LinearLayoutManager(this)
        val listBurungAdapter = ListBurungAdapter(list)
        rvBurung.adapter = listBurungAdapter
        listBurungAdapter.setOnItemClickCallback(object : ListBurungAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Burung) {
                showSelectedBurung(data)
            }
        })
    }
    private fun showSelectedBurung(burung: Burung) {
        Toast.makeText(this, "Kamu memilih " + burung.name, Toast.LENGTH_SHORT).show()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.abouat -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}