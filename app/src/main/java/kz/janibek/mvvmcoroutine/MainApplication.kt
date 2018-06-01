package kz.janibek.mvvmcoroutine

import android.app.Application
import kz.janibek.mvvmcoroutine.di.newsModule
import kz.janibek.mvvmcoroutine.di.retrofitModule
import org.koin.android.ext.android.startKoin

/**
 *
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(listOf(retrofitModule, newsModule))
    }
}