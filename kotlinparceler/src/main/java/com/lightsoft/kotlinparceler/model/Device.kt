package com.lightsoft.kotlinparceler.model

import com.lightsoft.kotlinparceler.converter.DeviceConverter
import org.parceler.Parcel
import org.parceler.ParcelConstructor
import org.parceler.ParcelProperty

@Parcel(Parcel.Serialization.BEAN, converter = DeviceConverter::class)
open class Device
@ParcelConstructor
constructor(@ParcelProperty("manufacturer") var manufacturer: String?,
            @ParcelProperty("model") var model: String?,
            @ParcelProperty("deviceId") var deviceId: String?)
{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Device

        if (manufacturer != other.manufacturer) return false
        if (model != other.model) return false
        if (deviceId != other.deviceId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = manufacturer?.hashCode() ?: 0
        result = 31 * result + (model?.hashCode() ?: 0)
        result = 31 * result + (deviceId?.hashCode() ?: 0)
        return result
    }
}