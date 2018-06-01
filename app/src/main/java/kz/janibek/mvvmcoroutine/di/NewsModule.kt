package kz.janibek.mvvmcoroutine.di

import kz.janibek.mvvmcoroutine.data.DefaultNewsRepository
import kz.janibek.mvvmcoroutine.data.api.NewsAPI
import kz.janibek.mvvmcoroutine.data.api.NewsRestAPI
import kz.janibek.mvvmcoroutine.data.mapper.RedditNewsMapper
import kz.janibek.mvvmcoroutine.data.model.RedditNewsDataResponse
import kz.janibek.mvvmcoroutine.domain.NewsInteractor
import kz.janibek.mvvmcoroutine.domain.NewsRepository
import kz.janibek.mvvmcoroutine.domain.model.News
import kz.janibek.mvvmcoroutine.utils.Mapper
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

private const val REDDIT_NEWS_MAPPER = "reddit_news_mapper"
/**
 * DI module for news
 */
val newsModule: Module = applicationContext {
    bean {
        NewsRestAPI(redditApi = get()) as NewsAPI
    }
    bean {
        DefaultNewsRepository(
                redditApi = get(),
                mapper = get(REDDIT_NEWS_MAPPER)
        ) as NewsRepository
    }
    bean(REDDIT_NEWS_MAPPER) { RedditNewsMapper() as Mapper<RedditNewsDataResponse, News> }
    bean {
        NewsInteractor(newsRepository = get())
    }
}