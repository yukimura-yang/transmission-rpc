package moe.gkd.transmissionrpc.network.calladapter

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type

class TransmissionRpcBodyCallAdapter<R>(private val responseType: Type) : CallAdapter<R, Any> {

    override fun responseType(): Type = responseType

    override fun adapt(call: Call<R>): Any {
        val response: Response<R>
        try {
            response = call.execute()
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        if (response.isSuccessful) {
            return response.body()!!
        }
        throw  HttpException(response)
    }

}