package com.dwisuseno.githubuserapp


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pengguna(
    var avatars: Int,
    var name: String?,
    var username: String?,
    var followers: String?,
    var following: String?,
    var company: String?,
    var repository: String?,
    var location: String?
) : Parcelable

