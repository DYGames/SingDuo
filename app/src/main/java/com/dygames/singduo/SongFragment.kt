package com.dygames.singduo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.dygames.singduo.databinding.FragmentSongBinding
import org.json.JSONObject
import kotlin.concurrent.timer

class SongFragment(code: Int) : Fragment() {
    private var _binding: FragmentSongBinding? = null
    private val binding get() = _binding!!
    private val code = code
    private val songViewModel = SongViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentSongBinding.inflate(layoutInflater)
        songViewModel.getSongData(code)
        Glide.with(binding.songCover.context).load(songViewModel.cover.value.toString())
            .into(binding.songCover)
        binding.songExit.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
        binding.songLyrics.text = songViewModel.lyrics.value?.get(0)?.second.toString()

        for (i in 1 until songViewModel.lyrics.value!!.size) {
            timer(initialDelay = songViewModel.lyrics.value?.get(i)?.first!!.toLong(), period = 1) {
                activity?.runOnUiThread {
                    binding.songLyrics.text = songViewModel.lyrics.value?.get(i)?.second.toString()
                }
                cancel()
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}