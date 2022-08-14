package com.homee.bang_20220727

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.homee.bang_20220727.datas.RoomData

class MainActivity : AppCompatActivity() {

    val mRoomList = ArrayList<RoomData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}