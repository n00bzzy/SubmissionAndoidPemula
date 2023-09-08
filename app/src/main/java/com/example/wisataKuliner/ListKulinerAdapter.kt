package com.example.wisataKuliner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListKulinerAdapter (
    private val listkuliner: MutableList<Kuliner>,
    val listener : (Kuliner)-> Unit
): RecyclerView.Adapter<ListKulinerAdapter.ViewHolder>() {


    class ViewHolder(private  val v : View) : RecyclerView.ViewHolder(v) {
        private val gambar: ImageView = v.findViewById(R.id.img_item_photo)
        private val judul: TextView = v.findViewById(R.id.tv_item_nama_kuliner)
        private val deskripsi:TextView = v.findViewById(R.id.tv_item_description_kuliner)


        fun onBind(data: Kuliner,listner:(Kuliner) -> Unit){
            this.judul.text = data.nama
            this.deskripsi.text = data.deskripsi
            this.gambar.setImageResource(data.photo)
            itemView.setOnClickListener{listner(data)}
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListKulinerAdapter.ViewHolder  {
        val view: View =  LayoutInflater.from(parent.context).inflate(R.layout.item_kuliner,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.onBind(listkuliner[position],listener)
    }

    override fun getItemCount(): Int = listkuliner.size
}