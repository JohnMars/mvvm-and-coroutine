package kz.janibek.mvvmcoroutine.domain

import kz.janibek.mvvmcoroutine.domain.model.News
import retrofit2.Response

/**
 *
 */
interface NewsRepository {
    fun getNews(): Response<List<News>>
}