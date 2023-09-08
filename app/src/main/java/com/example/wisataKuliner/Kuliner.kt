package com.example.wisataKuliner

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kuliner (
    var nama:String ,
    var deskripsi:String ,
    var lokasi:String,
    var photo:Int ,
):Parcelable