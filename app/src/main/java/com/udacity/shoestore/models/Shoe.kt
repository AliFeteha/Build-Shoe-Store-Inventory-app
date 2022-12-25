package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Shoe : Parcelable{
    var name: String? = null
    var size: String? = null
    var company: String? = null
    var description: String? = null
                val images: List<String> = mutableListOf()}