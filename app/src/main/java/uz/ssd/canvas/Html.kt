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
                <div class="table-block">
                    <table class="table">
                        <tbody class="table-row date-period">
                            <tr style="width: 40%">
                                 <td><input type="text" name="period-from-day" value="19"></td>
                                 <td><input type="text" name="period-from-month" value="Октабрь"></td>
                                 <td><input type="text" name="period-from-year" value="20"></td>
                            </tr>
                            <tr style="width: 40%">
                                 <td><input type="text" name="period-to-day" value="21"></td>
                                 <td><input type="text" name="period-to-month" value="Декабр"></td>
                                 <td><input type="text" name="period-to-year" value="23"></td>
                            </tr>
                        </tbody>
                        <tbody class="table-row insurance-company">
                            <tr>
                                 <td><input type="text" name="company-full-name" value="Tashkent Investment pro company" maxlength="75"></td>
                            </tr>
                        </tbody>
                        <tbody class="table-row insurance-client">
                            <tr>
                                 <td><input type="text" name="client-full-name" value="Роналдоев Криштиано Родриго угли" maxlength="80"></td>
                            </tr>
                        </tbody>
                        <tbody class="table-row client-phone">
                            <tr>
                                 <td><input type="text" name="client-phone" value="998911631236" maxlength="12"></td>
                            </tr>
                        </tbody>

                        <tbody class="table-row transport-information">
                            <tr>
                                 <td><input type="text" name="transport-model" value="GM / Nexia2"></td>
                                 <td><input type="text" name="transport-year" value="2016"></td>
                                 <td><input type="text" name="transport-number" value="01AAA777"></td>
                                 <td><input type="text" name="kuzov-number" value="123456789"></td>
                                 <td><input type="text" name="govern-number" value="01AAA777"></td>
                             </tr>
                           
                        </tbody>
                        <tbody class="table-row client-sector">
                            <tr>
                                 <td><input type="text" name="transport-model" value="Дастурий таъминотлар ишлаб чикариш"></td>
                             </tr>
                           
                        </tbody>
                        <tbody class="table-row transport-used-teritory">
                            <tr>
                                 <td><input type="text" name="transport-model" value="Тошкент шахри"></td>
                             </tr>
                        </tbody>                        
                        <tbody class="table-row transport-can-use item-1">
                            <tr>
                                <td>
                                    <input type="text" name="can-use-first-name" value="Роналдоев">
                                    <input type="text" name="can-use-last-name" value="Криштиано">
                                    <input type="text" name="can-use-third-name" value="Родриго угли">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="AA" maxlength="3">
                                    <input type="text" name="can-use-number" maxlength="8" value="5635624">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="Futbolist">
                                </td>
                            </tr>
                        </tbody>
                        <tbody class="table-row transport-can-use item-2">
                            <tr>
                                <td>
                                    <input type="text" name="can-use-first-name" value="Роналдоев">
                                    <input type="text" name="can-use-last-name" value="Криштиано">
                                    <input type="text" name="can-use-third-name" value="Родриго угли">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="AA" maxlength="3">
                                    <input type="text" name="can-use-number" maxlength="8" value="5635624">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="Futbolist">
                                </td>
                            </tr>
                        </tbody>
                        <tbody class="table-row transport-can-use item-3">
                            <tr>
                                <td>
                                    <input type="text" name="can-use-first-name" value="Роналдоев">
                                    <input type="text" name="can-use-last-name" value="Криштиано">
                                    <input type="text" name="can-use-third-name" value="Родриго угли">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="AA" maxlength="3">
                                    <input type="text" name="can-use-number" maxlength="8" value="5635624">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="Futbolist">
                                </td>
                            </tr>
                        </tbody>
                        <tbody class="table-row transport-can-use item-4">
                            <tr>
                                <td>
                                    <input type="text" name="can-use-first-name" value="Роналдоев">
                                    <input type="text" name="can-use-last-name" value="Криштиано">
                                    <input type="text" name="can-use-third-name" value="Родриго угли">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="AA" maxlength="3">
                                    <input type="text" name="can-use-number" maxlength="8" value="5635624">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="Futbolist">
                                </td>
                            </tr>
                        </tbody>
                        <tbody class="table-row transport-can-use item-5">
                            <tr>
                                <td>
                                    <input type="text" name="can-use-first-name" value="Роналдоев">
                                    <input type="text" name="can-use-last-name" value="Криштиано">
                                    <input type="text" name="can-use-third-name" value="Родриго угли">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="AA" maxlength="3">
                                    <input type="text" name="can-use-number" maxlength="8" value="5635624">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="Futbolist">
                                </td>
                            </tr>
                        </tbody>
                        <!-- <tbody class="table-row transport-can-use item">
                            <tr>
                                <td>
                                    <input type="text" name="can-use-first-name" value="Тошкент шахри">
                                    <input type="text" name="can-use-last-name" value="Тошкент шахри">
                                    <input type="text" name="can-use-third-name" value="Тошкент шахри">
                                </td>
                                <td>
                                    <input type="text" name="can-use-serial" value="Тошкент шахри">
                                    <input type="text" name="can-use-number" value="Тошкент шахри">
                                </td>
                                <td>
                                    <input type="text" name="can-use-relationship" value="Тошкент шахри">
                                </td>
                             </tr>
                        </tbody> -->
                    </table>
                </div>
            </div>
        </form>
    </div>
</body>
</html>"""
}