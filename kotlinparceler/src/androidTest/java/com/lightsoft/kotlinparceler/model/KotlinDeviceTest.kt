package com.lightsoft.kotlinparceler.model

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.support.test.runner.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.parceler.Parcels
import java.util.*

@RunWith(AndroidJUnit4::class)
class KotlinDeviceTest {
    val EMPLOYEE_KEY = "employee"

    @Test
    fun afterParcelTheObjectShouldNotLostAnyData() {
        val deviceList = ArrayList<Device>(1)
        val samsungPhone = Phone("Samsung", "SM001", "SM001001", "+48999999999")
        deviceList.add(samsungPhone)
        val employee = Employee("Sam", "Samuel", deviceList)

        val bundle = Bundle()
        bundle.putParcelable(EMPLOYEE_KEY, Parcels.wrap(employee))

        val parcel = Parcel.obtain()
        parcel.writeBundle(bundle)
        parcel.setDataPosition(0)

        val readBundle = parcel.readBundle(javaClass.classLoader)
        parcel.recycle()
        val unwrappedEmployee = Parcels.unwrap<Employee>(readBundle.getParcelable<Parcelable>(EMPLOYEE_KEY))

        assertEquals(employee.name, unwrappedEmployee.name)
        assertEquals(employee.lastName, unwrappedEmployee.lastName)
        assertEquals(deviceList, unwrappedEmployee.devices)
    }
}