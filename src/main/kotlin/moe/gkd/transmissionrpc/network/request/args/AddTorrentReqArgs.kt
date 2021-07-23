package moe.gkd.transmissionrpc.network.request.args

import com.google.gson.annotations.SerializedName

class AddTorrentReqArgs(
    val filename: String,
    @SerializedName("download-dir")
    val downloadDir: String
)