package org.techtown.politicsproject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.politicsproject.databinding.ActivityMainBinding
import org.techtown.politicsproject.mainfun.NewsListMaker
import org.techtown.politicsproject.mainfun.view.NewsListAdapter


class MainActivity : AppCompatActivity() {
    //뷰바인딩 위한 코드
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    //설정된 지역구
    private var guName: String = "광진구"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //서버에 뉴스 요청
        val newsListMaker = NewsListMaker()
        val adapter=NewsListAdapter(newsListMaker.getNews(guName))
        binding.newsListView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.newsListView.setHasFixedSize(true)
        binding.newsListView.adapter=adapter

    }
}
