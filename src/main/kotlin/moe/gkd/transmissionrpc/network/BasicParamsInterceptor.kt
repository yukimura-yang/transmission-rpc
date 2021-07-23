package moe.gkd.transmissionrpc.network

import okhttp3.Interceptor
import okhttp3.Response

class BasicParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        val headerBuilder = request.headers.newBuilder()
        if (Api.SessionId.isNotEmpty()) {
            headerBuilder.add("X-Transmission-Session-Id", Api.SessionId)
        }
        requestBuilder.headers(headerBuilder.build())
        return chain.proceed(requestBuilder.build())
    }
}