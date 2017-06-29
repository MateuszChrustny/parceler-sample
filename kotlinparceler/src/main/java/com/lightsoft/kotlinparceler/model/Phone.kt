package com.lightsoft.kotlinparceler.model

import org.parceler.Parcel
import org.parceler.ParcelConstructor
import org.parceler.ParcelProperty

@Parcel(Parcel.Serialization.BEAN)
class Phone
@ParcelConstructor
constructor(@ParcelProperty("manufacturer") manufacturer: String?,
            @ParcelProperty("model") model: String?,
            @ParcelProperty("deviceId") deviceId: String?,
            @ParcelProperty("phoneNumber") var phoneNumber: String?) : Device(manufacturer, model, deviceId)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        if (!super.equals(other)) return false

        other as Phone

        if (phoneNumber != other.phoneNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + (phoneNumber?.hashCode() ?: 0)
        return result
    }
}