package com.dygames.singduo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dygames.singduo.databinding.ViewSonglistRecyclerBinding

class SongListRecyclerAdapter : RecyclerView.Adapter<SongListRecyclerAdapter.SongListViewHolder>() {
    var data = mutableListOf<String>()

    inner class SongListViewHolder(private val binding: ViewSonglistRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String, idx: Int) {
            binding.songlistTitle.text = data
            binding.root.setOnClickListener {
                (binding.root.context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.frame_main, SongFragment(idx)).addToBackStack(null).commitAllowingStateLoss()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongListViewHolder {
        val binding =
            ViewSonglistRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SongListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongListViewHolder, position: Int) {
        holder.bind(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}