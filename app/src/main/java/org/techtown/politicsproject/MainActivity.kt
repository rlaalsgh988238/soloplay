package org.techtown.politicsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.politicsproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    }
}