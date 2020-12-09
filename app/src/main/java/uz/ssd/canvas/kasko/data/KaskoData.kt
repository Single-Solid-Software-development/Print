package uz.ssd.canvas.kasko.data

/**
 * Created by mr-shoxruxbek on 09/12/2020.
 */
class KaskoData(
        val polisNumber: String,
        val fio: String,
        val address: String,
        val phone: String,
        val fio2: String,
        val tel2: String,
        val doneStandart: String="",
        val donePerimium: String="",
        val doneGold: String="",
        val priceStandart: String="",
        val pricePerimium: String="",
        val priceGold: String="",
        val pricePrimiumStandart: String="",
        val pricePrimiumPerimium: String="",
        val pricePrimiumGold: String="",
        val fromDay: String,
        val fromMonth: String,
        val fromYear: String,
        val toDay: String,
        val toMonth: String,
        val toYear: String,
        val whereViloyat: String,
        val direcotrFio: String,
        val agentName: String,
)