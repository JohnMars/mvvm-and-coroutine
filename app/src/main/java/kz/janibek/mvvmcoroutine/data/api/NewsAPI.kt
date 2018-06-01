package kz.janibek.mvvmcoroutine.data.api

import kz.janibek.mvvmcoroutine.data.model.RedditNewsResponse
import retrofit2.Call

interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}