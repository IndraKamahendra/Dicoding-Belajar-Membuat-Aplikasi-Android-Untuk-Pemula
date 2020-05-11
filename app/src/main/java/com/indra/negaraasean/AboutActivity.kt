package com.indra.negaraasean

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

        initPhotoProfile()
    }
    private fun initPhotoProfile() {
        val photoProfile: ImageView = findViewById(R.id.img_item_photo)
        val photo = RequestOptions()
            .placeholder(R.drawable.indrakamahendra)

        Glide.with(this)
            .load(photo)
            .apply(photo)
            .into(photoProfile)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}