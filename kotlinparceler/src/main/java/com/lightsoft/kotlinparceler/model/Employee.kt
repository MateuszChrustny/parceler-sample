package com.lightsoft.kotlinparceler.model

import org.parceler.Parcel
import org.parceler.ParcelConstructor
import org.parceler.ParcelProperty

@Parcel(Parcel.Serialization.BEAN)
class Employee
@ParcelConstructor
constructor(@ParcelProperty("name") var name: String?,
            @ParcelProperty("lastName") var lastName: String?,
            @ParcelProperty("devices") var devices: ArrayList<Device>?) {

    constructor() : this(null, null, null)
}
