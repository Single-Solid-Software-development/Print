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
    <div class="wrapper">
        <form action="">
            <div class="container">
                <div class="period-dates">
                    <div class="period-from">
                        <input type="text" name="from-day" class="day" value="31">
                        <input type="text" name="from-month" class="month" value="Oktabr">
                        <input type="text" name="from-year" class="year" value="20">
                    </div>
                    <div class="period-to">
                        <input type="text" name="to-day" class="day" value="12">
                        <input type="text" name="to-month" class="month" value="Decabr">
                        <input type="text" name="to-year" class="year" value="21">
                    </div>
                </div>
                <div class="insurance-firm">
                    <input type="text" name="insurance-subject" class="full-width" value="Travel Insurance">
                </div>
                <div class="insurance-object">
                    <input type="text" name="insurance-object" class="full-width" value="Maxmudov Shoxrubek Muzaffar o`g`li">
                </div>
                <div class="subject-phone" >
                    <input type="tel" name="subject-phone" maxlength="12" value="998998578086">
                </div>
                <div class="transport-info">
                    <input type="text" name="mark_and_model" class="mark" value="YAKT">
                    <input type="text" name="issue-year" class="issue-year" value="2025">
                    <input type="text" name="generator-number" class="generator-number" value="45454654465465">
                    <input type="text" name="carcase-number" class="carcase-number" value="Spark">
                    <input type="text" name="government-number" class="governtment-number" value="AAA1234658">
                </div>
                <div class="subject-profession" >
                    <input type="text" name="subject-profession" value="Programist">
                </div>
                <div class="transport-users">
                    <input type="text" name="transport-users" value="5 Yil experience">
                </div>
                <div class="users-can-drive">
                    <div class="user-item">
                        <div class="fio">
                            <input type="text" name="user[0][first-name]" value="Shoxruxbek">
                            <input type="text" name="user[0][last-name]" value="Maxmudov">
                            <input type="text" name="user[0][third-name]" value="Muzaffar o`g`li">   
                        </div>
                        <div class="driver-info">
                            <input type="text" name="user[0][serial]" class="serial" value="AB">
                            <input type="text" name="user[0][number]" class="number" value="1234567">
                        </div>
                        <div class="relationship">
                            <input type="text" name="user[0][relationship]" value="O`g`il">
                        </div>
                    </div>
                    <div class="user-item">
                        <div class="fio">
                            <input type="text" name="user[1][first-name]" value="$day">
                            <input type="text" name="user[1][last-name]" value="$day">
                            <input type="text" name="user[1][third-name]" value="$day">   
                        </div>
                        <div class="driver-info">
                            <input type="text" name="user[1][serial]" class="serial" value="$day">
                            <input type="text" name="user[1][number]" class="number" value="$day">
                        </div>
                        <div class="relationship">
                            <input type="text" name="user[1][relationship]" value="$day">
                        </div>
                    </div>
                    <div class="user-item">
                        <div class="fio">
                            <input type="text" name="user[2][first-name]" value="$day">
                            <input type="text" name="user[2][last-name]" value="$day">
                            <input type="text" name="user[2][third-name]" value="$day">   
                        </div>
                        <div class="driver-info">
                            <input type="text" name="user[2][serial]" class="serial" value="$day">
                            <input type="text" name="user[2][number]" class="number" value="$day">
                        </div>
                        <div class="relationship">
                            <input type="text" name="user[2][relationship]" value="$day">
                        </div>
                    </div>
                    <div class="user-item">
                        <div class="fio">
                            <input type="text" name="user[3][first-name]" value="$day">
                            <input type="text" name="user[3][last-name]" value="$day">
                            <input type="text" name="user[3][third-name]" value="$day">   
                        </div>
                        <div class="driver-info">
                            <input type="text" name="user[3][serial]" class="serial" value="$day">
                            <input type="text" name="user[3][number]" class="number" value="$day">
                        </div>
                        <div class="relationship">
                            <input type="text" name="user[3][relationship]" value="$day">
                        </div>
                    </div>
                    <div class="user-item">
                        <div class="fio">
                            <input type="text" name="user[4][first-name]" value="$day">
                            <input type="text" name="user[4][last-name]" value="$day">
                            <input type="text" name="user[3][third-name]" value="$day">   
                        </div>
                        <div class="driver-info">
                            <input type="text" name="user[3][serial]" class="serial" value="$day">
                            <input type="text" name="user[3][number]" class="number" value="$day">
                        </div>
                        <div class="relationship">
                            <input type="text" name="user[3][relationship]" value="$day">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>"""
}