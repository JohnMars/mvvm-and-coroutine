package kz.janibek.mvvmcoroutine.utils

/**
 *
 */
interface Mapper<in From, out To> {

    fun map(from: From): To
}