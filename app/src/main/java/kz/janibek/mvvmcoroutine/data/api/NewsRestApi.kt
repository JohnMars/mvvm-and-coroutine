package kz.janibek.mvvmcoroutine.data.api

import kz.janibek.mvvmcoroutine.data.model.RedditNewsResponse
import retrofit2.Call

class NewsRestAPI(
        val redditApi: RedditApi
) : NewsAPI {

    override fun getNews(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}