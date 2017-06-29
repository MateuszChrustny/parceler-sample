package com.lightsoft.kotlinparceler.converter

import android.os.Parcel
import com.lightsoft.kotlinparceler.model.Device
import org.parceler.ParcelConverter
import org.parceler.Parcels

class DeviceConverter : ParcelConverter<Device> {

    override fun toParcel(input: Device?, parcel: Parcel?) {
        parcel?.writeParcelable(Parcels.wrap(input), 0)
    }

    override fun fromParcel(parcel: Parcel?): Device {
        return Parcels.unwrap(parcel?.readParcelable(Device::class.java.classLoader))
    }
}
