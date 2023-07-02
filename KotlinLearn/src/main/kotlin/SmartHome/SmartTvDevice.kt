package SmartHome

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    //    private var speakerVolume = 2
    //        set(value) {
    //            if (value in 0..100) {
    //                field = value
    //            }
    //        }
    //    private var channelNumber = 1
    //        set(value) {
    //            if (value in 1..200) {
    //                field = value
    //            }
    //        }
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    override val deviceType = "Smart TV"

    override fun turnOn() {
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to $channelNumber")
    }

    override fun turnOff() {
        super.turnOff()
        println("$name is turned off.")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decrease to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decrease to $channelNumber")
    }
}