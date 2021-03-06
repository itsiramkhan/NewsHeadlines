package com.iram.newsheadlines.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iram.newsheadlines.entity.News

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(newsList: List<News>)

    @Query("SELECT * FROM News")
    fun getNewsList(): LiveData<List<News>>

    @Query("SELECT * FROM News where title=:title")
    fun getNewsListByTitle(title:String): LiveData<News>
}