package kz.janibek.mvvmcoroutine.data.mapper

import kz.janibek.mvvmcoroutine.data.model.RedditNewsDataResponse
import kz.janibek.mvvmcoroutine.domain.model.News
import kz.janibek.mvvmcoroutine.utils.Mapper

/**
 *
 */
class RedditNewsMapper : Mapper<RedditNewsDataResponse, News> {

    override fun map(from: RedditNewsDataResponse): News {
        return News(
                from.author,
                from.title,
                from.num_comments,
                from.created,
                from.thumbnail,
                from.url
        )
    }
}