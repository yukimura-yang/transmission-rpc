package moe.gkd.transmissionrpc

import org.junit.jupiter.api.Test

class TransmissionRpcTests {

    private fun initialize() {
        TransmissionRpc.initialize("username", "password", "http://localhost:9091/")
    }

    @Test
    fun addTorrent() {
        initialize()
        TransmissionRpc.addTorrent(
            "magnet:?xt=urn:btih:8e6e83f808404d41fde22a145f157ddf1c9f4486&tr=https%3A%2F%2Ftr.bangumi.moe%3A9696%2Fannounce&tr=http%3A%2F%2Ftr.bangumi.moe%3A6969%2Fannounce&tr=udp%3A%2F%2Ftr.bangumi.moe%3A6969%2Fannounce&tr=http%3A%2F%2Fopen.acgtracker.com%3A1096%2Fannounce&tr=http%3A%2F%2F208.67.16.113%3A8000%2Fannounce&tr=udp%3A%2F%2F208.67.16.113%3A8000%2Fannounce&tr=http%3A%2F%2Ftracker.ktxp.com%3A6868%2Fannounce&tr=http%3A%2F%2Ftracker.ktxp.com%3A7070%2Fannounce&tr=http%3A%2F%2Ft2.popgo.org%3A7456%2Fannonce&tr=http%3A%2F%2Fbt.sc-ol.com%3A2710%2Fannounce&tr=http%3A%2F%2Fshare.camoe.cn%3A8080%2Fannounce&tr=http%3A%2F%2F61.154.116.205%3A8000%2Fannounce&tr=http%3A%2F%2Fbt.rghost.net%3A80%2Fannounce&tr=http%3A%2F%2Ftracker.openbittorrent.com%3A80%2Fannounce&tr=http%3A%2F%2Ftracker.publicbt.com%3A80%2Fannounce&tr=http%3A%2F%2Ftracker.prq.to%2Fannounce&tr=http%3A%2F%2Fopen.nyaatorrents.info%3A6544%2Fannounce",
            "/downloads/小林家的龙女仆s"
        )
    }

    @Test
    fun getTorrent() {
        initialize()
        val torrents = TransmissionRpc.getTorrent()
        torrents.forEach {
            println(it.name)
        }
    }
}