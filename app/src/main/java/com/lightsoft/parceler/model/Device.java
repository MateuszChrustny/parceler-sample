package com.lightsoft.parceler.model;

import com.lightsoft.parceler.converter.DeviceConverter;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(value = Parcel.Serialization.BEAN, converter = DeviceConverter.class)
public class Device {
    private String manufacturer;
    private String model;
    private String deviceId;

    @ParcelConstructor
    public Device(String manufacturer, String model, String deviceId) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.deviceId = deviceId;
    }

    public Device() {
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Device device = (Device) o;

        return (manufacturer != null ? manufacturer
                .equals(device.manufacturer) : device.manufacturer == null) && (model != null ? model
                .equals(device.model) : device.model == null) && (deviceId != null ? deviceId
                .equals(device.deviceId) : device.deviceId == null);
    }

    @Override
    public int hashCode() {
        int result = manufacturer != null ? manufacturer.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (deviceId != null ? deviceId.hashCode() : 0);
        return result;
    }
}
