package ipv4


fun isValidIPv4(address:String):Boolean{


    val segments=address.split('.')

    if(segments.size!=4)return false

    for(segment in segments) {

        val digit=segment.toIntOrNull()

        if (digit != null) {
            if(digit <0 || digit>255)return false
        }

        if(segment.isEmpty())return false

        if(segment.length>1&&segment.startsWith('0'))return false

        if(!segment.all { it.isDigit() })return false

    }

    return true

}


fun main(){

    println("Enter Your IPv4 ")

    var ipv4= readlnOrNull()

    var result= isValidIPv4(ipv4!!)

    println("Your IPv4 is : $result")

}