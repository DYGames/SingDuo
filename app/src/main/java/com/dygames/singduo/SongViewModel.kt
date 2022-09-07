package com.dygames.singduo

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONObject
import java.time.LocalTime
import java.util.*

class SongViewModel() : ViewModel() {
    var cover = MutableLiveData<String>()
    var title = MutableLiveData<String>()
    var lyrics = MutableLiveData<MutableList<Pair<Int, String>>>()
    var list = MutableLiveData<List<String>>()

    var songRepository = SongRepository()

    fun getSongData(idx: Int) {
        val data = JSONObject(songRepository.getSongData(idx)).getJSONObject("data")
        cover.value = data.getString("cover")
        title.value = data.getString("title")
        var lyricsList = data.getJSONArray("lyrics")
        lyrics.value = mutableListOf<Pair<Int, String>>()
        Log.d("DyDY", lyricsList.length().toString())
        for (x in 0 until lyricsList.length()) {
            val time = lyricsList.getJSONObject(x).getInt("time")
            val lycs = lyricsList.getJSONObject(x).getString("lyrics")
            lyrics.value?.add(Pair(time, lycs))
        }
    }

    fun getSongList() {
        list.value = songRepository.getSongList().split(" ")
    }
}