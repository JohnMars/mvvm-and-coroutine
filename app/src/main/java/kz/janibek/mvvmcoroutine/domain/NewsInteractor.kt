package kz.janibek.mvvmcoroutine.domain

import kz.janibek.mvvmcoroutine.domain.model.News
import retrofit2.Response

/**
 * Some news feed business case
 */
class NewsInteractor(
        private val newsRepository: NewsRepository
) {

    suspend fun getTopNews(): Response<List<News>> {
        return newsRepository.getNews()
    }
}