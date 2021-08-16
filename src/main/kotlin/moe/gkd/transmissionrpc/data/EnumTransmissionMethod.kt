package moe.gkd.transmissionrpc.data

import com.google.gson.annotations.SerializedName

enum class EnumTransmissionMethod {
    @SerializedName("torrent-add")
    TORRENT_ADD,

    @SerializedName("session-get")
    SESSION_GET,

    @SerializedName("torrent-get")
    TORRENT_GET,

    @SerializedName("torrent-stop")
    TORRENT_STOP,

    @SerializedName("torrent-start")
    TORRENT_START,
}