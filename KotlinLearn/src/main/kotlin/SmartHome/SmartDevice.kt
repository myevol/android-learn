package SmartHome

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "off"
        protected set

    open val deviceType = "unknown"

    constructor(name: String, category: String, onlineStatus: Int): this(name, category) {
        deviceStatus = when(onlineStatus) {
            0 -> "off"
            1 -> "on"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
//        println("Smart device is turned on.")
    }

    open fun turnOff() {
        deviceStatus = "off"
//        println("Smart device is turned off.")
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }
}
