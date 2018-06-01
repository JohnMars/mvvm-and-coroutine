package kz.janibek.mvvmcoroutine.news

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.runBlocking
import kz.janibek.mvvmcoroutine.domain.NewsInteractor
import kz.janibek.mvvmcoroutine.domain.NewsRepository
import kz.janibek.mvvmcoroutine.domain.model.News
import org.junit.After
import org.junit.Test


import org.junit.Before
import org.junit.Rule

/**
 *
 */
class NewViewModelTest {

    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    private lateinit var newsViewModel: NewsViewModel
    private val newsRepository: NewsRepository = mock()
    private val newsObserver: Observer<List<News>> = mock()

    @Before
    fun setUp() {
        val newsInteractor = NewsInteractor(newsRepository)
        newsViewModel = NewsViewModel(newsInteractor,
                uiContext = Unconfined,
                ioContext = Unconfined
        )
    }

    @Test
    fun `getNewsLiveData should request top news`() = runBlocking {
        newsViewModel.getNewsLiveData().observeForever(newsObserver)


        verify(newsRepository).getNews()
    }

    @After
    fun tearDown() {
        newsViewModel.getNewsLiveData().removeObserver(newsObserver)
    }
}