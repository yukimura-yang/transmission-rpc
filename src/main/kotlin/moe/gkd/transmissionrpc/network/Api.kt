package moe.gkd.transmissionrpc.network

import moe.gkd.transmissionrpc.network.calladapter.TransmissionRpcCallAdapterFactory
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Api {
    private lateinit var api: IApi
    var SessionId = ""

    fun initialize(userName: String, password: String, url: String) {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(logging)
            .addInterceptor(BasicParamsInterceptor())
            .authenticator(object : Authenticator {
                override fun authenticate(route: Route?, response: Response): Request? {
                    if (response.request.header("Authorization") != null) {
                        return null; // Give up, we've already attempted to authenticate.
                    }
                    val credential = Credentials.basic(userName, password)
                    return response.request.newBuilder()
                        .header("Authorization", credential)
                        .build();
                }
            }
            )
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addCallAdapterFactory(TransmissionRpcCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        api = retrofit.create(IApi::class.java)
    }

    fun getApi(): IApi {
        if (this::api.isInitialized) {
            return api
        } else {
            throw RuntimeException("没有初始化")
        }
    }
}