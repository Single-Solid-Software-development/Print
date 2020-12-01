package uz.ssd.canvas

/**
 * Created by mr-shoxruxbek on 14/10/2020.
 */
object Html {

    const val htmlCss = "http://project.webforte.uz/pdf2html/style.css"
    const val DESKTOP_USER_AGENT =
        "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.2049.0 Safari/537.36"
    const val day = "6365030"
    const val O = "4"

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

}