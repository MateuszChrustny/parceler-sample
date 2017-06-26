package com.lightsoft.kotlinparceler

import org.parceler.Parcel
import org.parceler.ParcelConstructor
import org.parceler.ParcelProperty

@Parcel(Parcel.Serialization.BEAN)
class Employee
@ParcelConstructor
constructor(@ParcelProperty("name") var name: String?, @ParcelProperty("lastName") var lastName: String?) {
    constructor() : this(null, null)
}
