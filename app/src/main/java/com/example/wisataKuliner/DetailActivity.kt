package com.example.wisataKuliner

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var btnShare : Button

    companion object{
        const val EXTRA_KULINER = "extra_kuliner"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val Kuliner = intent.getParcelableExtra<Kuliner>(MainActivity.INTENT_PARCELABLE)
        val tvNama = findViewById<TextView>(R.id.tvDetailNama)
        val tvDeskripsi = findViewById<TextView>(R.id.tvDeskripsi)
        val ivPhoto = findViewById<ImageView>(R.id.imageView)
        val tvLokasi = findViewById<TextView>(R.id.tvLokasi)

        Kuliner?.photo?.let {ivPhoto.setImageResource(it)}
        tvDeskripsi.text = Kuliner?.deskripsi
        tvLokasi.text = Kuliner?.lokasi
        tvNama.text = Kuliner?.nama

        btnShare = findViewById(R.id.btnShare)

        btnShare.setOnClickListener {
            val myDrawable = ivPhoto.drawable
            val nBitmap = (myDrawable as BitmapDrawable).bitmap
            val s = tvDeskripsi.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            val path = MediaStore.Images.Media.insertImage(contentResolver,nBitmap,"title",null)
            val uri = Uri.parse(path)

            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_STREAM,uri)
            intent.putExtra(Intent.EXTRA_TEXT,s)
            startActivity(Intent.createChooser(intent,"Share Via"))

        }

    }
}