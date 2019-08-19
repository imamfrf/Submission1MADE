package com.dicoding.imamf.submission1made

import android.os.Parcel
import android.os.Parcelable


data class Movie(val title: String, val releaseDate: String, val score: String, val topCast: String,
                 val description: String, val poster: Int) : Parcelable{


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(releaseDate)
        parcel.writeString(score)
        parcel.writeString(topCast)
        parcel.writeString(description)
        parcel.writeInt(poster)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }


}