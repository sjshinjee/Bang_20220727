package com.homee.bang_20220727

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homee.bang_20220727.adapters.RoomAdapter
import com.homee.bang_20220727.datas.RoomData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
 //// 첫 작성 //// MainActivity에서 우선적으로 멤버변수로 다 만들어줘라
    val mRoomList = ArrayList<RoomData>()   //2 //mRoomList를 ArrayList로 객체화까지 바로 함
    lateinit var mRoomAdapter: RoomAdapter   //5 객체화를 나중에 해 주겠다고 말하고 onCreate에서 객체화 함

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //3  onCreate내부에 setContentView이후에 List에다가 RoomData를 직접 입력해줌  >>Activity코틀린단에서 ~~git 커밋

        //4 실제로 그 Adapter변수를 멤버변수로 만들고 Adapter를 갳체화 시킨뒤에 그 Adapter를 xml에 있는 ListView의 변수에 Adapter로 대입해주면 됨

        mRoomAdapter = RoomAdapter(this, R.ㅅㄱLayout.room_listitem, mRoomList) //나중에 객체화 시켜주겠다고 한 약속을 지킴
        roomListView.adapter = mRoomAdapter //객체화 하기 전에 ListView변수에 Adapter먼저 찍으면 초기화 안됐다고 또 에러발생
                                            // 즉 먼가를 활용하려면 객체화를 먼저 해 줘야함
                                            //이 순서로 코드를 해 준 후에 돌려주면 Data를 연결했기 때문에 가상앱에 뭔가 표시는 됨

        //여기까지 하면 실제 data는 연결하지 않았지만 xml에 있는 listView와 Adapter와 Activity를 다 연결해줌

        //이젠 RoomAdapter에서 실제 data를 구현해볼거임 > RoomAdapter.kt창으로 가
    }
}