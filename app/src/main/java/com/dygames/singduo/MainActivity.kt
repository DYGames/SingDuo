package com.dygames.singduo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dygames.singduo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
        supportFragmentManager.beginTransaction().replace(R.id.frame_main, SongListFragment()).addToBackStack(null).commitAllowingStateLoss()
    }
}