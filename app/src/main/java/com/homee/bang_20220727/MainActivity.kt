package com.homee.bang_20220727

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homee.bang_20220727.adapters.RoomAdapter
import com.homee.bang_20220727.datas.RoomData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<RoomData>()
    lateinit var mRoomAdapter: RoomAdapter   //객체화를 나중에 해 주겠다고 말하고 onCreate에서 객체화 함

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRoomAdapter = RoomAdapter(this, R.Layout.room_listitem, mRoomList) //나중에 객체화 시켜주겠다고 한 약속을 지킴
        roomListView.adapter = mRoomAdapter //객체화 하기 전에 ListView변수에 Adapter먼저 찍으면 초기화 안됐다고 또 에러발생
                                            // 즉 먼가를 활용하려면 객체화를 먼저 해 줘야함
                                            //이 순서로 코드를 해 준 후에 돌려주면 Data를 연결했기 때문에 가상앱에 뭔가 표시는 됨

        //여기까지 하면 실제 data는 연결하지 않았지만 xml에 있는 listView와 Adapter와 Activity를 다 연결해줌

        //이젠 RoomAdapter에서 실제 data를 구현해볼거임 > RoomAdapter.kt창으로 가
    }
}