package com.example.wisataKuliner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var rvKuliner: RecyclerView? = null

    companion object{
        val INTENT_PARCELABLE = "object_intent"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.buttonPanel_about -> {
                val intent = Intent (this@MainActivity,AboutMeActivivty::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //supportActionBar?.show()

        rvKuliner = findViewById(R.id.rv_kuliner)
        //data isian aplikasi
        val listkuliner = mutableListOf<Kuliner>(
            Kuliner(
                "Serabi Notosuman Ny.Handayani",
                "Serabi Notosuman Handayani adalah makanan ringan Indonesia yang terbuat dari adonan tepung beras, santan, dan gula. Makanan ini memiliki tekstur lembut dan kenyal dengan rasa manis yang khas. Serabi ini biasanya disajikan dengan sirup gula merah dan taburan kelapa parut sangrai.",
                "Jl. Moh. Yamin No.28, Jayengan, Kec. Serengan, Kota Surakarta, Jawa Tengah 57152",
                R.drawable.serabi
            ),
            Kuliner(
                "Cabuk Rambak",
                "Makanan khas Solo lainnya yang wajib kamu jajal saat berlibur ke Solo adalah cabuk rambak solo. Ini merupakan camilan khas masyarakat solo yang biasanya juga untuk tambahan menu sarapan, makan siang, atau mengganjal perut lapar pada malam hari. Cabuk rambak terdiri dari ketupat yang telah diiris tipis, sambal wijen, serta karak. Penyajiannya menggunakan pincuk (wadah dari daun pisang) dengan taburan kerupuk puli atau beras.Untuk harganya cukup murah. Kamu hanya perlu mengeluarkan uang Rp 5.000.",
                "Pasar Gedhe",
                R.drawable.cabuk_rambak
            ),
            Kuliner(
                "Sate Kambing Pak Bejo",
                "Tidak hanya digemari oleh Presiden Jokowi dan keluarganya, tempat kuliner yang telah lama berdiri ini jadi favorit masyarakat luas. Sudah dirintis sejak tahun 1970-an, warung satu ini masih eksis hingga saat ini.",
                "Jl. Sungai Sebakung No. 10, Kedung Lembu, atau yang lebih terkenal dengan Lojiwetan Sangkrah, Pasar Kliwon, Surakarta ",
                R.drawable.sate
            ),
            Kuliner(
                "Tengkleng Klewer Bu Edi",
                "Bisa dibilang, tengkleng klewer bu Edi ini menjadi salah satu wisata kuliner solo yang lagi hits sekaligus khas loh.Bagaimana tidak? Kuliner ini sudah ada sejak 1971 dan hingga sekarang masih selalu ramai pengunjung. Walau jam bukanya hanya 3,5 jam per hari.Ciri khas tengkleng bu Edi ada pada penyajiannya, yaitu menggunakan “pincukan”.",
                "Pasar Klewer, Jl DR. Radjiman, Surakarta",
                R.drawable.tengkleng
            ),
            Kuliner(
                "Bakpia Balong Sumber Rejeki",
                "Kurang lengkap rasanya jika berkunjung ke solo, tetapi tidak membawa oleh-oleh khas Solo. Ada oleh-oleh yang mungkin selama ini lebih terkenal sebagai oleh-oleh khas Jogja. Tetapi ternyata, Solo pun memilikinya.Oleh-oleh tersebut adalah Bakpia Balong Sumber Rejeki. Ukurannya lebih besar daripada bakpia Jogja. Selain itu, varian rasanya cukup beragam, seperti keju, kacang merah, coklat, kacang hijau, durian, bahkan isi daging.",
                "Jalan Kapten Mulyadi No 17, Sudiroprajan, Surakarta",
                R.drawable.bakpia
            ),
            Kuliner(
                "Gudeg Ceker Margoyudan Bu Kasno",
                "Meskipun asal gudeg dari Jogja, tetapi gudeg ceker margoyudan bu Kasno yang ada di Solo ini tidak kalah nikmatnya.Wisata kuliner solo di malam hari yang satu ini sudah ada sejak 1970-an dan masih eksis hingga sekarang.Kamu tidak perlu mengeluarkan kocek terlalu dalam saat lapar melanda pada malam hari. Sebab, satu piring nasi pulen yang dipadu dengan gudeg, telur, ceker, dan opor ayam ini cukup dibandrol dengan harga Rp 15.000.",
                "Jalan Monginsidi No 41 – 43 Margoyudan, Srabulan Banjasari",
                R.drawable.gudeg
            ),
            Kuliner(
                "Bakmi Jawa Radjiman",
                "Mie menjadi kuliner wajib bagi sebagian orang. Tak terkecuali saat berlibur ke Solo, baik liburan sendiri maupun maupun bersama rombongan menggunakan jasa paket wisata Solo.Uniknya dari bakmi Jawa Radjiman ini adalah pada cara memasaknya yang menggunakan tungku (anglo) dari tanah liat dan arang. Sehingga menciptakan rasa olahan bakmi yang berbeda dan istimewa dari lainnya.",
                "Jalan dr. Radjiman, Singosaren, Solo",
                R.drawable.bakmi
            ),
            Kuliner(
                "Pecel Solo",
                "Tempat kuliner satu ini memang sudah hits banget di kota Solo dan selalu menjadi tujuan utama saat berada di Solo. Menu andalan dari Warung Pecel ini adalah Pecel Ndeso menu yang satu ini terdiri dari nasi merah, daun bayam, daun pepaya, kembang turi, jantung pisang, daun kenikir, dan disiram dengan bumbu pecel yang khas yang memiliki citarasa manis, asin, pedas, dan gurih.",
                "Jalan Dr. Soepomo No. 55 Mangkubumen",
                R.drawable.pecel
            ),
            Kuliner(
                "Nasi Soto Ayam Gading",
                "Nasi Soto Gading sangat cocok dijadikan menu sarapan. Satu porsi soto terdiri dari nasi, sohun, suwiran daging ayam, dan kentang yang disiram kuah bening. Kamu juga bisa menambah lauk lain jika mau, seperti ampela, sate usus, dan sate telur puyuh. Nasi Soto Gading ini juga menjadi wisata kuliner Solo langganan Presiden Joko Widodo lho.",
                "Jalan Brigjen Sudiarto No 75.",
                R.drawable.soto
            ),
            Kuliner(
                "Selat Solo Mbak Lies",
                "Hanya dengan harga sekitar Rp28.000, kamu sudah bisa mendapat satu porsi selat Solo yang terdiri dari potongan daging sapi masak semur, galantin, telur rebus, wortel, buncis, kentang goreng, daun selada, acar mentimun, dan irisan bawang merah. Tidak ketinggalan, kuah segar dan mustard yang terbuat dari cuka dan campuran kuning telur yang semakin melengkapi kenikmata kuliner satu ini.Tak hanya menyajikan kuliner yang enak, Warung Selat Mbak Lies juga memiliki dekorasi interior yang unik. Di dalamnya, kamu bisa menemukan banyak ornamen keramik mulai dari piring hiasan dinding, guci, hingga lukisan yang ditata sedemikian rupa.",
                "Gang II No 42, Serengan.",
                R.drawable.selat
            )
        )

        val adapter = ListKulinerAdapter(listkuliner){
            Intent(this,DetailActivity::class.java).apply {
                putExtra(INTENT_PARCELABLE,it)
                startActivity(this)
            }
        }
        rvKuliner?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvKuliner?.adapter = adapter

    }


}