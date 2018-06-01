package kz.janibek.mvvmcoroutine.domain.model

/**
 *
 */
data class News(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
)