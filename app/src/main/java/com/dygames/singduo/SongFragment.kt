package com.dygames.singduo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dygames.singduo.databinding.FragmentSongBinding

class SongFragment(code: Int) : Fragment() {
    private var _binding: FragmentSongBinding? = null
    private val binding get() = _binding!!
    private val code = code
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentSongBinding.inflate(layoutInflater)
        binding.test.text = code.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}