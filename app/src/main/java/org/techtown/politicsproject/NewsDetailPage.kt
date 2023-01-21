package org.techtown.politicsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.politicsproject.databinding.NewsDetailPageBinding

class NewsDetailPage : AppCompatActivity() {
    private var mBinding: NewsDetailPage? = null
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = NewsDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data1 = intent.getStringExtra("data")
        binding.sample.text = data1
    }
}