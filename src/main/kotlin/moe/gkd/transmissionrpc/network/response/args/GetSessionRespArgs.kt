package moe.gkd.transmissionrpc.network.response.args

import com.google.gson.annotations.SerializedName

class GetSessionRespArgs(
    @SerializedName("session-id")
    val sessionId: String,
    val version: String
)