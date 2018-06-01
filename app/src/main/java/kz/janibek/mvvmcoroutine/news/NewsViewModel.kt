package kz.janibek.mvvmcoroutine.news

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.newCoroutineContext
import kz.janibek.mvvmcoroutine.domain.NewsInteractor
import kz.janibek.mvvmcoroutine.domain.model.News
import kotlin.coroutines.experimental.CoroutineContext

/**
 *
 */
class NewsViewModel(
        private val newsInteractor: NewsInteractor,
        private val uiContext: CoroutineContext = UI,
        private val ioContext: CoroutineContext = CommonPool
) : ViewModel() {

    private val newsLiveData = MutableLiveData<List<News>>()
    private val progressLiveData = MutableLiveData<Boolean>()

    fun getNewsLiveData(): LiveData<List<News>>{
        if (newsLiveData.value?.isEmpty() == true) {
            requestNews()
        }
        return newsLiveData
    }

    fun onScrolledBotton() {
//        suspend функции можем вызывать только в coroutine scope
//        newsInteractor.getTopNews()
    }

    private fun requestNews() = launch(uiContext) {
        progressLiveData.value = true
        val newsList = async(ioContext) {
            newsInteractor.getTopNews()
        }.await()

        newsLiveData.value = newsList.body()
        progressLiveData.value = false
    }
}