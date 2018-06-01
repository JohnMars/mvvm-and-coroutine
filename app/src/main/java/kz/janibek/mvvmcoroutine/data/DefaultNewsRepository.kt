package kz.janibek.mvvmcoroutine.data

import kz.janibek.mvvmcoroutine.data.api.RedditApi
import kz.janibek.mvvmcoroutine.data.model.RedditNewsDataResponse
import kz.janibek.mvvmcoroutine.domain.NewsRepository
import kz.janibek.mvvmcoroutine.domain.model.News
import kz.janibek.mvvmcoroutine.utils.Mapper
import retrofit2.Response

/**
 *
 */
class DefaultNewsRepository(
        private val redditApi: RedditApi,
        private val mapper: Mapper<RedditNewsDataResponse, News>
) : NewsRepository {

    override suspend fun getNews(): Response<List<News>> {
        val topResponse = redditApi.getTop(after = "", limit = "20").execute()
        val children = topResponse.body()?.data?.children

        return children?.map {
            mapper.map(it.data)
        }.let {
            Response.success(it)
        } ?: Response.error<List<News>>(
                topResponse.code(),
                topResponse.errorBody()!!
        )
    }
}