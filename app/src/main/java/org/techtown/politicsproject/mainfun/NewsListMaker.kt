package org.techtown.politicsproject.mainfun

class News(val newsTitle:String = "NO_TITLE",
                val newsHeadLine:String = "NO_HEADLINE",
                val newsImageURL:String = "NO_IMAGE")

class NewsListMaker {
    //title headline url 순서
    var news = arrayListOf<News>()

    // 서버 기능구현 후 만들기
    // strategy patter 통해서 검색기능 구현
    // guName 받아서 만들기
    fun getNews(guState:String):ArrayList<News>{
        // guName으로 검색기능

        //example data, 서버에서 갖고오기
        var newsTitle="나폴리 출시!"
        var newsHeadLine="나폴리가 출시됐다고???"
        var newsImageURL="https://ibb.co/cDmzMFC"

        //뉴스데이터를 arraylist에 넣음
        //데이터 삽입해보기
        for(i in 1..10){
            news.add(News("${newsTitle}$i",newsHeadLine,newsImageURL))
        }
        return news
    }
}