package uz.ssd.canvas

import uz.ssd.canvas.kasko.data.KaskoData
import uz.ssd.canvas.osago.data.Insurance
import uz.ssd.canvas.osago.data.Policy
import uz.ssd.canvas.osago.data.Relative

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
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
	<meta http-equiv="Pragma" content="no-cache" />
	<meta http-equiv="Expires" content="0" />
	<link rel="stylesheet" href="fonts/stylesheet.css">
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
            <!-- <input type="text" name="insurance_owner__phone" value="998971631236" maxlength="12"> -->
            <table class="insurance_owner__phone">
            	<tr>
            		<td>9</td>
            		<td>9</td>
            		<td>8</td>
            		<td>9</td>
            		<td>1</td>
            		<td>1</td>
            		<td>6</td>
            		<td>3</td>
            		<td>1</td>
            		<td>2</td>
            		<td>3</td>
            		<td>6</td>
            	</tr>
            </table>
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


    fun html1(insurance: Insurance): String {
        return """<!DOCTYPE html>
<html lang="">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Blue document 2</title>
  <link rel="stylesheet" href="style.css">
</head>
<body class="document">
<div class="page">
  <table>
    <tr class="top_space"></tr>
    <tr class="insurer_sum">
      <td class="with_numbers">${insurance.reward1Digit}</td>
      <td class="with_words">${insurance.reward1Alpha}</td>
    </tr>
    <tr class="insurer_award">
      <td class="with_numbers">${insurance.reward2Digit}</td>
      <td class="with_words">${insurance.reward2Alpha}</td>
    </tr>
    <tr class="discount_award">
      <td class="with_numbers">${insurance.reward3Digit}</td>
      <td class="with_words">${insurance.reward3Alpha}</td>
    </tr>
    <tr class="paid_award">
      <td class="with_numbers">${insurance.reward4Digit}</td>
      <td class="with_words">${insurance.reward4Alpha}</td>
    </tr>
    <tr class="body_space"></tr>
    <tr class="regional_info">
      <td class="region">${insurance.region}</td>
      <td class="region_unit">${insurance.subdivisions}</td>
      <td class="addresses">${insurance.address}</td>
    </tr>
    <tr class="series_info">
      <td class="series">${insurance.serial}</td>
      <td class="number">${insurance.number}</td>
      <td class="state_series">${insurance.serialState}</td>
      <td class="state_number">${insurance.numberState}</td>
    </tr>
    <tr class="comment">
      <td>${insurance.comment}</td>
    </tr>
    <tr class="delegate_name">
      <td>${insurance.fio}</td>
    </tr>
    <tr class="date">
      <td class="day">${insurance.day}</td>
      <td class="month">${insurance.month}</td>
      <td class="year">${insurance.year}</td>
    </tr>
    <tr class="time">
      <td class="hour">${insurance.hour}</td>
      <td class="minut">${insurance.minute}</td>
    </tr>
  </table>
</div>
<script type="text/javascript">
  // window.print();
</script>
</body>
</html>
"""
    }

    fun html2(policy: Policy): String {
        return """<!DOCTYPE html>
<html lang="">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Blue document 2</title>
  <link rel="stylesheet" href="style2.css">
</head>
<body class="document">
<div class="page">
  <table class="table_polis">
    <tr class="tr_polis_date">
      <td class="day1">${policy.day1}</td>
      <td class="month1">${policy.month1}</td>
      <td class="year1">${policy.year1}</td>
      <td class="date_space"></td>
      <td class="day2">${policy.day2}</td>
      <td class="month2">${policy.month2}</td>
      <td class="year2">${policy.year2}</td>
    </tr>
    <tr class="tr_insurer_details">
      <td class="name_details">${policy.insurerDetails}</td>
    </tr>
    <tr class="tr_insured_details">
      <td class="name_details">${policy.insuredDetails}</td>
    </tr>
    <tr class="tr_phone">
      <td class="td_phone">${policy.phone}</td>
    </tr>
     <tr class="tr_info_car">
      <td class="model">${policy.model}</td>
      <td class="make_year">${policy.makeYear}</td>
      <td class="dvig_number">${policy.dvigNumber}</td>
      <td class="kuzov_number">${policy.kuzovNumber}</td>
      <td class="numbers">${policy.carNumber}</td>
    </tr>
    <tr class="tr_insurer_work">
      <td class="name_details">${policy.insurerWorkType}</td>
    </tr>
    <tr class="tr_use_car_region">
      <td class="name_details">${policy.useCarRegion}</td>
    </tr>
  </table>
</div>
<script type="text/javascript">
  // window.print();
</script>
</body>
</html>
"""
    }

    fun html3(relative: Relative): String {
        return """<!DOCTYPE html>
<html lang="">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Blue document 2</title>
  <link rel="stylesheet" href="style3.css">
</head>
<body class="document">
<div class="page">

  <table class="table_relative">
    <tr class="tr_relatives">
      <td class="relatives">${relative.r1Name}</td>
      <td class="license">${relative.r1Certificate}</td>
      <td class="kinship">${relative.r1Type}</td>
    </tr>
    <tr class="tr_relatives">
     <td class="relatives">${relative.r2Name}</td>
      <td class="license">${relative.r2Certificate}</td>
      <td class="kinship">${relative.r2Type}</td>
    </tr>
    <tr class="tr_relatives">
      <td class="relatives"> ${relative.r3Name}</td>
      <td class="license">${relative.r3Certificate}</td>
      <td class="kinship">${relative.r3Type}</td>
    </tr>
    <tr class="tr_relatives">
      <td class="relatives">${relative.r4Name}</td>
      <td class="license">${relative.r4Certificate}</td>
      <td class="kinship">${relative.r4Type}</td>
    </tr>
    <tr class="tr_relatives">
      <td class="relatives">${relative.r5Name}</td>
      <td class="license">${relative.r5Certificate}</td>
      <td class="kinship">${relative.r5Type}</td>
    </tr>
  </table>

  <table class="table_reward">
    <tr class="tr_reward">
     <td class="sum_digit">${relative.reward1Digit}</td>
      <td class="sum_alpha">${relative.reward1Alpha}</td>
    </tr>
    <tr class="tr_reward">
      <td class="sum_digit">${relative.reward2Digit}</td>
      <td class="sum_alpha">${relative.reward2Alpha}</td>
    </tr>
    <tr class="tr_reward">
      <td class="sum_digit">${relative.reward3Digit}</td>
      <td class="sum_alpha">${relative.reward3Alpha}</td>
    </tr>
    <tr class="tr_reward">
      <td class="sum_digit">${relative.reward4Digit}</td>
      <td class="sum_alpha">${relative.reward4Alpha}</td>
    </tr>
  </table>

  <table class="table_region">
    <tr class="regional_info">
      <td class="region">${relative.region}</td>
      <td class="region_unit">${relative.subdivisions}</td>
      <td class="addresses">${relative.address}</td>
    </tr>
  </table>
  <table>
    <tr class="series_info">
      <td class="series">${relative.serial}</td>
      <td class="number">${relative.number}</td>
      <td class="state_series">${relative.serialState}</td>
      <td class="state_number">${relative.numberState}</td>
    </tr>
    <tr class="comment">
      <td>${relative.comment}</td>
    </tr>
    <tr class="delegate_name">
      <td>${relative.fio}</td>
    </tr>
    <tr class="date">
      <td class="day">${relative.day}</td>
      <td class="month">${relative.month}</td>
      <td class="year">${relative.year}</td>
    </tr>
    <tr class="time">
      <td class="hour">${relative.hour}</td>
      <td class="minut">${relative.minute}</td>
    </tr>
  </table>
</div>
<script type="text/javascript">
  // window.print();
</script>
</body>
</html>
"""
    }

    fun kaskoHtml1(data: KaskoData): String {
        return """ <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel='stylesheet' href="style_kasko.css">
</head>
<body>
    <div class="page">

        <div class="smalltable">
            <table class="small-one">
                <tr>
                    <td class="small-img"><img src="./img/uzbekinvest.png" style="width: 170px;" alt="uzbekinvest"></td>
                    <td rowspan="2 " class="small-text">Правила страхования <br/>транспортного средства «АвтоХИМОЯ»
                    </td>
                    
                </tr>
                <tr>
                    <td class="small-text2">GK31</td>

                </tr>
    
            </table>
            <table  class="small-right" >
                <tr >
                    <td class="small-right01">RD-108_ К3</td>
                </tr>
                <td class="small-right02">
                    Стр. 2 из 12 <br/>
                    От: 24.12.2018г
                    </td>
    
            </table>
        </div>
        <!-- Small Table End -->

        <!-- Big Table Begin -->
        <table  class="table01" >
            <tr>
                <th class="table01-img;"><img src="./img/uzbekinvest1.png" alt=""></th>
                <th class="header01">
                    НАЦИОНАЛЬНАЯ КОМПАНИЯ 
                    ЭКСПОРТНО-ИМПОРТНОГО СТРАХОВАНИЯ <br> «УЗБЕКИНВЕСТ»
                    <div class="header01left">номер бланка</div> 
                    <div class="header01left1">F-35</div> 
                </th>
            </tr>
        </table>

        <table class="table02" >
            <tr>
                <th class="table02-01">
                    <div class="table02-02">ISO  9001:2015</div>
                </th>
                <th>
                    <div class="table02-03">Moody`s B1</div>
                </th>
            </tr>
        </table>

        <table class="table03" >
            <tr>
                <th>ПОЛИС СТРАХОВАНИЯ ТРАНСПОРТНОГО СРЕДСТВА  «АвтоХИМОЯ»» № 
                    <span class="bottom-line01"></span>
                </th>
                
                
            </tr>
        </table>
        
        <table class="table04">
            <tr>
                <td rowspan="3" class="table04-1">
                    <span class="table04-2">1. Страхователь:</span><br/>
                    <i class="table04-3">(Ф.И.О., адрес и контактный телефон)</i>
                </td>
                <td class="bline">
                    <span class="b-line01"></span>
                </td>
                
            </tr>
            <tr>
                <td class="bline">
                    <span class="b-line01"></span>
                </td>
            </tr>
            <tr>
                <td class="bline">
                    <span class="b-line01"></span>
                </td>
            </tr>
            
        </table>
        <table class="table04">
            <tr>
                <td rowspan="2" class="table04-4">
                    <span class="table04-5">2. Выгодоприобретатель:</span><br/>
                    <i class="table04-6">(Ф.И.О. и контактный телефон)</i>
                </td>
                <td style="height: 20px;">
                    <span class="bottom-line01"></span> 
                </td>
                
            </tr>
            <tr>
                <td style="height: 20px;">
                    <span class="bottom-line01"></span>
                </td>
            </tr>
            
            
        </table>
        <table class="table04">
            <tr>
                <td rowspan="2" class="table04-7">
                    <span style="font-weight: 600;">3. ПАКЕТ</span><br/>
                    <i class="table04-8">(нужное отметить)</i>
                </td>
                <td class="table04-9">4. Страховая сумма, сум</td>
                <td class="table04-10">5.Страховой тариф</td>
                <td class="table04-11">6.Страховая премия, сум</td>
                
            </tr>
        </table>
        <table class="table04">
            <tr>
                <td rowspan="2" class="table04-12">
                    <span style="font-weight: 600; ">«СТАНДАРТ»</span><br/>
                    
                </td>
                <td class="table04-13">
                    <span>☑️</span>
                </td>
                <td class="table04-14"> 
                    <span class="bottom-line01" ></span>
                </td>
                <td class="table04-15">0.8%</td>
                <td class="table04-16">
                    <span class="bottom-line01" ></span>
                </td>
                
            </tr>
        </table>
        <table class="table04">
            <tr>
                <td rowspan="2" class="table04-12">
                    <span style="font-weight: 600; ">«ПРЕМИУМ»</span><br/>
                    
                </td>
                <td class="table04-13">
                    <span></span>
                </td>
                <td class="table04-14">
                    <span class="bottom-line01" ></span></td>
                <td class="table04-15">1.0%</td>
                <td class="table04-16">
                    <span class="bottom-line01" ></span>
                </td>
                
            </tr>
        </table>
        <table class="table04">
            <tr>
                <td rowspan="2" class="table04-12">
                    <span style="font-weight: 600; ">«ГОЛД»</span><br/>
                    
                </td>
                <td class="table04-13">
                    <span></span>
                </td>
                <td class="table04-14">
                    <span class="bottom-line01" ></span>
                </td>
                <td class="table04-15">1.2%</td>
                <td class="table04-16">
                    <span class="bottom-line01"></span>
                </td>
                
            </tr>
        </table>


        <table class="table04">
            <tr>
                <td class="tabel04-17">7. Период страхования: с «
                    <span style="width:2%; height: 15px;" class="bottom-line01"></span> »
                    <span style="width:10%;height: 15px;" class="bottom-line01"></span>20
                    <span style="width:2%;height: 15px;" class="bottom-line01"></span> года по 
                    «<span style="width:2%;height: 15px;" class="bottom-line01"></span> »
                    <span style="width:10%;height: 15px;" class="bottom-line01"></span>  20
                    <span style="width:2%;height: 15px;" class="bottom-line01"></span> года
                </td>
            </tr>
        </table>


        <table class="table04">
            <tr>
                <td class="tabel04-21" style="width: 30%;" ><i>От имени Компании:</i></td>
                <td class="tabel04-21" style="width: 35%;" ><i>Страховой агент:</i></td>
                <td class="tabel04-21" style="width: 35%"><i>Страхователь:</i></td>
            </tr>
        </table>


        <table class="table04">
            <tr>
                <td class="table04-18" style="width: 30.1%">Директор филиала в 
                    <span class="t04-18">
                        <div class="bot-line"></div>
                        <span>вилояте</span>
                    </span>
                    <div class="bot-line"></div>
                    <i>(Ф.И.О.)</i>
                </td>
                

                <td class="table04-18" style="width: 35% ">
                    
                    <div class="bot-line"  style="padding-top: 40px;" ></div>
                    <i>(Ф.И.О.)</i>
                </td>
                

                <td class="table04-18" >
                        Правила и <br>
                        Страховой полис получил: 
                        <span class="bot-line"></span><br>
                        <div class="bot-line"></div>
                        <i>(подпись)</i>
                </td>
                
            </tr>
        </table>


        <table class="table04">
            <tr>
                <td class="table04-19 bottom-line01" style="width: 30.1%;" >
                    
                    (подпись, м.п.)
                    </i></td>
                <td class="table04-19 bottom-line01" style="width: 35%;"  >
                    
                    (подпись, м.п.)
                    </i></td>
                <td class="table04-19 bottom-line01" >
                    <i>(подпись, м.п.)</i></td>
            </tr>
        </table>

        
        <div class="b-text">
            Внимание! <br>
            С предложениями и жалобами по поводу качества обслуживания <br>
            Вы можете позвонить по телефону доверия (71)200 02 34 (понедельник-пятница с 9.00 до 18.00)
        </div>

        




        

    </div>
</body>
</html> """
    }
}