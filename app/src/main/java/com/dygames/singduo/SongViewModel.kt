package com.dygames.singduo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongViewModel() : ViewModel() {
    var path = MutableLiveData<String>()
    var title = MutableLiveData<String>()
    var lyric = MutableLiveData<String>()
    var list = MutableLiveData<List<String>>()

    var songRepository = SongRepository()
    fun onClickSong(idx: Int) {
        val data = songRepository.getSongData(idx)
        path.value = data
        title.value = data
        lyric.value = data
    }

    fun getSongList() {
        list.value = songRepository.getSonglist().split(" ")
    }
}