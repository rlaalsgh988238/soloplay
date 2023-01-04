package org.techtown.politicsproject.mainfun.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.politicsproject.R
import org.techtown.politicsproject.mainfun.News

class NewsListAdapter (private val items: ArrayList<News>) : RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.news_listview, parent, false)
        return NewsViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: NewsListAdapter.NewsViewHolder, position: Int) {
        holder.title.text=items[position].newsTitle
        holder.headline.text=items[position].newsHeadLine
        System.out.println("${items[position].newsHeadLine}")
    }

    // 각 항목에 필요한 기능을 구현
    class NewsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val title = itemView.findViewById<TextView>(R.id.title_textView)
        val headline = itemView.findViewById<TextView>(R.id.headLine_textView)
        val image = itemView.findViewById<ImageView>(R.id.newsListImage)
    }
}