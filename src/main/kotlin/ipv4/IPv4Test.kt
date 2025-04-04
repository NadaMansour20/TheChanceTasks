package ipv4


fun testIPv4(
    name:String,
    result:Boolean,
    correctResult:Boolean

){
    if(correctResult==result){
        println("Success :$name")
    }
    else{
        println("Failed :$name")
    }
}

fun main() {


    testIPv4(
        name = "valid IP address 1",
        result = isValidIPv4("192.168.1.1"),
        correctResult = true
    )
    testIPv4(
        name = "valid IP address 2",
        result = isValidIPv4("255.255.255.255"),
        correctResult = true
    )
    testIPv4(
        name = "valid IP address 3",
        result = isValidIPv4("0.0.0.0"),
        correctResult = true
    )

    //////////////////////////////////////////////////////////////////

    testIPv4(
        name = "IPv4 is empty",
        result = isValidIPv4(" "),
        correctResult = false
    )
    testIPv4(
        name = "IPv4 address with less than four segments",
        result = isValidIPv4("192.168.1"),
        correctResult = false
    )
    testIPv4(
        name = "IPv4 address with more than four segments",
        result = isValidIPv4("192.168.1.1.1"),
        correctResult = false
    )
    testIPv4(
        name = "segment out of range",
        result = isValidIPv4("192.300.1.-1"),
        correctResult = false
    )
    testIPv4(
        name = "segment with leading zeros",
        result = isValidIPv4("01.168.001.1"),
        correctResult = false
    )
    testIPv4(
        name = "non-numeric segments",
        result = isValidIPv4("192.168.one.a"),
        correctResult = false
    )
    testIPv4(
        name = "IPv4 with spaces between segments",
        result = isValidIPv4("192. 168.1.1"),
        correctResult = false
    )
    testIPv4(
        name = "IPv4 address with Special characters",
        result = isValidIPv4("192.168.1.1#"),
        correctResult = false
    )
    testIPv4(
        name = "IPv4 address loss the segment",
        result = isValidIPv4("192..1."),
        correctResult = false
    )

}
