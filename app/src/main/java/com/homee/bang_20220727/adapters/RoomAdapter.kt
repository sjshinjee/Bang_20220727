package com.homee.bang_20220727.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.homee.bang_20220727.datas.RoomData
import kotlinx.android.synthetic.main.room_listitem.view.*

class RoomAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<RoomData>
) : ArrayAdapter<RoomData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = LayoutInflater.from(mContext).inflate(resId,null)

        }
        val row = tempRow!!

        val roomData = mList[position] //mList에 position번째를 roomData로 넣어줌/말 그대로 RoomData클래스를 변수화 시켜준거임

        //from MainActivity.kt  //RoomAdapter에서 실제 data를 구현해보자
        row.priceTxt.text = roomData.Price.toString() //row한테 점을 찍어서 priceTxt의 text속성은
                                                             //mList의 position번째의 Price에 있는데
                                                             //toString으로 바꿔줘 / mList가 중복될 것이므로
                                                                                  //위에 변수로 묶어줌
                                //mList[position]을 roomData변수로 바꿔줌
                                //오늘 이론수업에서 들었던 data클래스를 변수화 한것에 점을 찍어서
                                //멤버변수와 함수를 활용하는 것을직관적으로 보는 것임

        row.addressTxt.text = "${roomData.address}," //주소옆에 ,를 위해서 중괄호+스트링화함
        row.levelTxt.text = roomData.level.toString()
        row.descriptionTxt.text = roomData.description //여기까지하면 주소와 층수 설명까지 나옴 but아직 -2와 같은 로직은 작성 안됨
                                                       //반지하같은 로직은 여기서 작성해도 되는데 우리는 RoomData에서 함수로 만들어서 묶어놓자
        return row
    }
}