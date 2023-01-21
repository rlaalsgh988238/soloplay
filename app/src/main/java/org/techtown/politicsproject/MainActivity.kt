package org.techtown.politicsproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
    var guName: String = "광진구"
    //val sharedPreference = getSharedPreferences("guStore", 0)
    //val editor = sharedPreference.edit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //서버에 뉴스 요청
        val newsListMaker = NewsListMaker()
        val adapter=NewsListAdapter(newsListMaker.getNews(guName))

        //리사이클러뷰 띄우기
        binding.newsListView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.newsListView.setHasFixedSize(true)
        binding.newsListView.adapter=adapter

        //뉴스디테일페이지 인텐트
        val intent: Intent = Intent(this,NewsDetailPage::class.java)

        // 리사이클러뷰에서 아이템 클릭했을 시
        adapter.setItemClickListener(object: NewsListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                // 클릭 시 이벤트 작성
                Toast.makeText(v.context,
                    "${newsListMaker.news[position].newsTitle}",
                    Toast.LENGTH_SHORT).show()
                intent.putExtra("data","${newsListMaker.news[position].newsTitle}")
                startActivity(intent) // 뉴스 디테일 페이지 들어가기

            }
        })


    }
}
