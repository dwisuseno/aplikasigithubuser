package com.dwisuseno.githubuserapp


import android.os.Parcel
import android.os.Parcelable

@Parcelize
data class Pengguna(
    var name: Parcelable,
    var user_name: Parcelable,
    var location: String,
    var repository: String,
    var company: String,
    var avatars: String,
    var followers: String,
    var following: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(user_name)
        parcel.writeString(location)
        parcel.writeString(repository)
        parcel.writeString(company)
        parcel.writeString(avatars)
        parcel.writeString(followers)
        parcel.writeString(following)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pengguna> {
        override fun createFromParcel(parcel: Parcel): Pengguna {
            return Pengguna(parcel)
        }

        override fun newArray(size: Int): Array<Pengguna?> {
            return arrayOfNulls(size)
        }
    }
}