package com.homee.bang_20220727.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.homee.bang_20220727.datas.RoomData
import kotlinx.android.synthetic.main.room_listitem.view.*

class RoomAdapter(
    val mContext : Context,  //mContext라고 해서 Context하나 받을거다 /생성자를 만드는거임>자식이 생성자 만들어서 부모에 넘겨줌
    val resId : Int,         ///resId라고 해서 Int값 하나 받을거고
    val mList : ArrayList<RoomData>  ///mList라고 해서 ArrayList하나 받을거다

    //원래 class RoomAdapter : ArrayAdapter<RoomData>{}문장이었는데 RoomAdapter뒤에 생성자를 만들기 위해()열어주고 생성자 만듦
) : ArrayAdapter<RoomData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //{}내부에서 getView함수를 이용할건데 return super를 지우고 여기에서 작성할 때 위에있는 생성자들을 활용못함 so 생성자들을
        ///멤버변수로 만드는거다 /여기서 처음에 getView라고 할 때 var로 null검사를 하기 위해서 임시적인 한 줄 tempRow 변수를 만듦
        var tempRow = convertView  ///재사용할 View가 있는지 물음
        if(tempRow == null){
            ///재사용할 뷰가 없다면
            tempRow = LayoutInflater.from(mContext).inflate(resId,null)  //LayoutInflater는 inflate를 하는 클래스 BTW 점을
                     //LayoutInflater라는 클래스는 사실 Activity에만 존재한다///찍고 mContext를 들고옴 BTW안들고 와지는데 그 이유는
                     //so 나중에 Activity에서 RoomAdapter를 연결할때 Activity///멤버변수로 만들지 않아서다 그래서 생성자들을 멤버변수
                     //에서 this로 받기때문에 그 Activity에 있는 LayoutInflater///var로 하나씩 만드는거다 mContext ~~ > val mContext
                     //를 빌려와서 inflate를 시켜주는거임
        }
        val row = tempRow!! //실제로 return해줄 row를 tempRow로 대입해주고 그것을 저 아래 코드 return row 했을때
                            //null값 들어갈수 없기 때문에 위에서 if문으로 null값을 확인했다 so 이 tempRow에는 절대
                            //null값이 안들어갈거라고 !! 붙여서 선언해준다

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