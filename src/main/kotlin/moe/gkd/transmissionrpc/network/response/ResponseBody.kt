package moe.gkd.transmissionrpc.network.response

class ResponseBody<T>(
    val arguments: T,
    val result: String
)