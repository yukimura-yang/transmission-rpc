package moe.gkd.transmissionrpc.network.calladapter

import moe.gkd.transmissionrpc.network.response.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.reflect.Type


class TransmissionRpcCallAdapterFactory : CallAdapter.Factory() {
    companion object {
        fun create(): TransmissionRpcCallAdapterFactory {
            return TransmissionRpcCallAdapterFactory()
        }
    }

    override fun get(returnType: Type, annotations: Array<out Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) == ResponseBody::class.java) {
            return TransmissionRpcBodyCallAdapter<Any>(returnType)
        }
        return null
    }

}