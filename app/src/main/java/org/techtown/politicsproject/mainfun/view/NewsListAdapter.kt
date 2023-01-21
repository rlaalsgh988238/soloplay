package org.techtown.politicsproject.mainfun.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.politicsproject.R
import org.techtown.politicsproject.databinding.ActivityMainBinding
import org.techtown.politicsproject.mainfun.News

class NewsListAdapter (private val items: ArrayList<News>) : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    // 아이템 개수 파악
    override fun getItemCount(): Int = items.size

    // 뷰홀더 삽입
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.news_listview, parent, false)
        return NewsViewHolder(inflatedView)
    }

    // UI에 데이터(아이템) 삽입
    override fun onBindViewHolder(holder: NewsListAdapter.NewsViewHolder, position: Int) {
        holder.title.text=items.get(position).newsTitle
        holder.headline.text=items.get(position).newsHeadLine

        // 클릭리스너 삽입
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    // 각 항목에 필요한 기능을 구현
    class NewsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val title = itemView.findViewById<TextView>(R.id.title_textView)
        val headline = itemView.findViewById<TextView>(R.id.headLine_textView)
        //val image = itemView.findViewById<ImageView>(R.id.newsListImage) // 나중에 삽입 예정
    }

    // 리스트 클릭 구현
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: NewsListAdapter.OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener : NewsListAdapter.OnItemClickListener
    // 여기까지
}


