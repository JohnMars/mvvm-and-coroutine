package kz.janibek.mvvmcoroutine.news

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kz.janibek.mvvmcoroutine.R
import kz.janibek.mvvmcoroutine.domain.model.News
import org.koin.android.ext.android.inject

class NewsActivity : AppCompatActivity() {

    val mViewModel: NewsViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel.getNewsLiveData().observe(this, Observer {
            onNewsUpdated(it)
        })
    }

    private fun onNewsUpdated(news: List<News>?) {
        TODO("not implemented")
    }
}
