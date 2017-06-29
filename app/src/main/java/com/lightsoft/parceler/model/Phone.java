package com.lightsoft.parceler.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@SuppressWarnings("WeakerAccess")
@Parcel(Parcel.Serialization.BEAN)
public class Phone extends Device {
    private String phoneNumber;

    @ParcelConstructor
    public Phone(String manufacturer, String model, String deviceId, String phoneNumber) {
        super(manufacturer, model, deviceId);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        Phone phone = (Phone) o;

        return phoneNumber != null ? phoneNumber
                .equals(phone.phoneNumber) : phone.phoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
