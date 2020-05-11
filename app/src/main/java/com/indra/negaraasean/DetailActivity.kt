package com.indra.negaraasean

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Negara"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_set_name)
        val imgSetFlag: ImageView = findViewById(R.id.img_item_flag)
        val imgSetLambang: ImageView = findViewById(R.id.img_item_lambang)
        val tvSetIdentity: TextView = findViewById(R.id.tv_set_identity)
        val tvOverview: TextView = findViewById(R.id.tv_set_overview)


        val tName  = intent.getStringExtra(EXTRA_NAME)
        val tFlag = intent.getStringExtra(EXTRA_FLAG)
        val tLambang = intent.getStringExtra(EXTRA_LAMBANG)
        val tIdentity = intent.getStringExtra(EXTRA_IDENTITY)
        val tOverview = intent.getStringExtra(EXTRA_OVERVIEW)



        tvSetName.text = tName
        Glide.with(this)
            .load(tFlag)
            .apply(RequestOptions())
            .into(imgSetFlag)
        tvSetIdentity.text = tIdentity
        tvOverview.text = tOverview
        Glide.with(this)
            .load(tLambang)
            .apply(RequestOptions())
            .into(imgSetLambang)
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_FLAG = "extra_flag"
        const val EXTRA_LAMBANG = "extra_lambang"
        const val EXTRA_IDENTITY = "extra_identity"
        const val EXTRA_OVERVIEW = "extra_overview"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}