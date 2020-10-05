package org.example

import org.usb4java.*
import java.lang.Exception

fun main(args: Array<String>) {
    val context = Context()
    var result = LibUsb.init(context)
    if (result < 0) {
        throw Exception("Nu cto tut")
    }
    val list = DeviceList()
    result = LibUsb.getDeviceList(context, list)
    list.forEach {
        val adress = LibUsb.getDeviceAddress(it)
        val desk = DeviceDescriptor()
        result = LibUsb.getDeviceDescriptor(it, desk)
        println("Vid = ${desk.idVendor().toUInt().toString(16)}")
        println("Pid = ${desk.idProduct().toUInt().toString(16)}")
    }

}
