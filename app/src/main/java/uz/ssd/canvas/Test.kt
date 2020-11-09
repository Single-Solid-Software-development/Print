package uz.ssd.canvas

/**
 * Created by mr-shoxruxbek on 22/10/2020.
 */
fun main() {
    val value =
        "\\u041d\\u0435\\u0434\\u043e\\u0441\\u0442\\u0430\\u0442\\u043e\\u0447\\u043d\\u043e \\u0441\\u0440\\u0435\\u0434\\u0441\\u0442\\u0432"
    val value2 = "Lolhello"


    val charset = Charsets.UTF_8
    val bytes = String(value.toByteArray(charset = charset), charset = charset)
//    println(bytes)

//    println(String(value.toByteArray(Charsets.UTF_8)))
//    println(String(value2.toByteArray(Charsets.UTF_8)))
//    println(value)
    println(value2)
}