package uz.ssd.canvas

/**
 * Created by mr-shoxruxbek on 22/10/2020.
 */
fun main() {
    val value = "'\'xD0'\'xB6"
    val value2 = "Lol"

    println(String(value.toByteArray(Charsets.UTF_8)))
    println(String(value2.toByteArray(Charsets.UTF_8)))
    println(value)
    println(value2)
}