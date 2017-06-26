package com.lightsoft.kotlinparceler

import android.os.Parcel
import android.os.Parcelable

class Employee
constructor(var name: String?, var lastName: String?) : Parcelable {

    constructor() : this(null, null)

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Employee> = object : Parcelable.Creator<Employee> {
            override fun createFromParcel(source: Parcel): Employee = Employee(source)
            override fun newArray(size: Int): Array<Employee?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(lastName)
    }
}
