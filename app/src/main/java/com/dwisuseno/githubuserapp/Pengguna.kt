package com.dwisuseno.githubuserapp


import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pengguna(
    var name: String?,
    var username: String?,
    var avatars: Int,
//    var location: String?,
//    var repository: String?,
//    var company: String?,

    var followers: String?,
    var following: String?
) : Parcelable

