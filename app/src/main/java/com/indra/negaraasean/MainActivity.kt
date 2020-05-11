package com.indra.negaraasean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvNegara: RecyclerView
    private var list: ArrayList<Negara> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Negara Anggota Asean"

        rvNegara = findViewById(R.id.rv_negara)
        rvNegara.setHasFixedSize(true)

        list.addAll(NegaraData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvNegara.layoutManager = LinearLayoutManager(this)
        val listNegaraAdapter = ListNegaraAdapter(list)
        rvNegara.adapter = listNegaraAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.menuCompose -> {
                val iAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(iAbout)
            }
        }
    }
}
