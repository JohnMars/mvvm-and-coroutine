package kz.janibek.mvvmcoroutine.di

import kz.janibek.mvvmcoroutine.data.api.RedditApi
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val retrofitModule: Module = applicationContext {
    bean {
        Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
    bean {
        val retrofit: Retrofit = get()
        retrofit.create(RedditApi::class.java) as RedditApi
    }
}