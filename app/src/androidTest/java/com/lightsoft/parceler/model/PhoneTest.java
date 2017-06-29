package com.lightsoft.parceler.model;

import android.os.Bundle;
import android.os.Parcel;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.parceler.Parcels;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class PhoneTest {

    private static final String EMPLOYEE_KEY = "employee";

    @Test
    public void afterParcelTheObjectShouldNotLostAnyData() throws Exception {
        ArrayList<Device> deviceList = new ArrayList<>(1);
        Phone samsungPhone = new Phone("Samsung", "SM001", "SM001001", "+48999999999");
        deviceList.add(samsungPhone);
        Employee employee = new Employee("Sam", "Samuel", deviceList);

        Bundle bundle = new Bundle();
        bundle.putParcelable(EMPLOYEE_KEY, Parcels.wrap(employee));

        Parcel parcel = Parcel.obtain();
        parcel.writeBundle(bundle);
        parcel.setDataPosition(0);

        Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
        parcel.recycle();
        Employee unwrappedEmployee = Parcels.unwrap(readBundle.getParcelable(EMPLOYEE_KEY));

        assertEquals(employee.getName(), unwrappedEmployee.getName());
        assertEquals(employee.getLastName(), unwrappedEmployee.getLastName());
        assertEquals(employee.getDevices(), unwrappedEmployee.getDevices());
    }
}