package com.lightsoft.parceler.converter;

import android.os.Parcel;

import com.lightsoft.parceler.model.Device;

import org.parceler.ParcelConverter;
import org.parceler.Parcels;

public class DeviceConverter implements ParcelConverter<Device> {
    @Override
    public void toParcel(Device input, Parcel parcel) {
        parcel.writeParcelable(Parcels.wrap(input), 0);
    }

    @Override
    public Device fromParcel(Parcel parcel) {
        return Parcels.unwrap(parcel.readParcelable(Device.class.getClassLoader()));
    }
}
