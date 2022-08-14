package com.homee.bang_20220727.datas

import java.text.DecimalFormat

class RoomData (
    val price : Int,   //필요한 data들을 받아줄거임
    val address : String,
    val level : Int,
    val description : String
        ){

    //원화 계산을 위한 클래스를 이용 (원체 많이 써서 이미 클래스화 되어있음)
    fun getFormattedPrice() : String{
        // 어떤 모야(format)으로 꾸밀건지에 대한 변수화
        val formatter = DecimalFormat("#,###") //#은 아무거나 들어와도 된다는 뜻

        var resultPrice = ""

//        if(price<10000){
//           resultPrice = formatter.format(price)
//        }else if(price == 10000){
//
//        }
//
//        val resultPrice = formatter.format(price)

        return resultPrice
    }

}