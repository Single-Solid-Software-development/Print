package uz.ssd.canvas

/**
 * Created by mr-shoxruxbek on 14/10/2020.
 */
object Html {

    const val htmlCss = "http://project.webforte.uz/pdf2html/style.css"
    const val DESKTOP_USER_AGENT =
        "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.2049.0 Safari/537.36"
    const val day = "6365030"
    const val htmlString = """<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Pdf to Html</title>
</head>
<body>
       <div class="wrapper page1">
        <form action="">
            <input type="text" name="date_from__day" value="09">
            <input type="text" name="date_from__month" value="Ноябрь">
            <input type="text" name="date_from__year" value="20">
            <input type="text" name="date_to__day" value="09">
            <input type="text" name="date_to__month" value="Октябрь">
            <input type="text" name="date_to__year" value="21">
            <input type="text" name="insurance_giver__company" value="Tashkent Investment Organistaion">
            <input type="text" name="insurance_owner__fio" value="Ахмедов Одил">
            <input type="text" name="insurance_owner__phone" value="998971631236" maxlength="12">
            <input type="text" name="tranport_info__model" value="Ravon Nexia3">
            <input type="text" name="tranport_info__year" value="2020">
            <input type="text" name="tranport_info__engine_number" value="FAFA2020">
            <input type="text" name="tranport_info__shassi_number" value="55396974">
            <input type="text" name="tranport_info__gov_number" value="01AAA007">
            <input type="text" name="owner__work_type" value="Дастурий махсулотлар ишлаб чикариш">
            <input type="text" name="owner__transport_region" value="Тошкент шахри">
            <div class="family-item item-1">
                <input type="text" name="who_can_drive__first_name" value="Cristiano">
                <input type="text" name="who_can_drive__second_name" value="Ronaldo">
                <input type="text" name="who_can_drive__last_name" value="Junior">
                <input type="text" name="who_can_drive__passport_serial" value="AA">
                <input type="text" name="who_can_drive__passport_number" value="7777777">
                <input type="text" name="who_can_drive__relation_type" value="Football">
            </div>
            <div class="family-item item-2">
                <input type="text" name="who_can_drive__first_name" value="Cristiano">
                <input type="text" name="who_can_drive__second_name" value="Ronaldo">
                <input type="text" name="who_can_drive__last_name" value="Junior">
                <input type="text" name="who_can_drive__passport_serial" value="AA">
                <input type="text" name="who_can_drive__passport_number" value="7777777">
                <input type="text" name="who_can_drive__relation_type" value="Football">
            </div>
            <div class="family-item item-3">
                <input type="text" name="who_can_drive__first_name" value="Cristiano">
                <input type="text" name="who_can_drive__second_name" value="Ronaldo">
                <input type="text" name="who_can_drive__last_name" value="Junior">
                <input type="text" name="who_can_drive__passport_serial" value="AA">
                <input type="text" name="who_can_drive__passport_number" value="7777777">
                <input type="text" name="who_can_drive__relation_type" value="Football">
            </div>
            <div class="family-item item-4">
                <input type="text" name="who_can_drive__first_name" value="Cristiano">
                <input type="text" name="who_can_drive__second_name" value="Ronaldo">
                <input type="text" name="who_can_drive__last_name" value="Junior">
                <input type="text" name="who_can_drive__passport_serial" value="AA">
                <input type="text" name="who_can_drive__passport_number" value="7777777">
                <input type="text" name="who_can_drive__relation_type" value="Football">
            </div>
            <div class="family-item item-5">
                <input type="text" name="who_can_drive__first_name" value="Cristiano">
                <input type="text" name="who_can_drive__second_name" value="Ronaldo">
                <input type="text" name="who_can_drive__last_name" value="Junior">
                <input type="text" name="who_can_drive__passport_serial" value="AA">
                <input type="text" name="who_can_drive__passport_number" value="7777777">
                <input type="text" name="who_can_drive__relation_type" value="Football">
            </div>
        </form>
    </div>
</body>
</html>"""
}