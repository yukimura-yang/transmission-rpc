package moe.gkd.transmissionrpc.network.response.args

import com.google.gson.annotations.SerializedName
import moe.gkd.transmissionrpc.data.TorrentAdded

class AddTorrentRespArgs(
    @SerializedName("torrent-added")
    val torrentAdded: TorrentAdded
)