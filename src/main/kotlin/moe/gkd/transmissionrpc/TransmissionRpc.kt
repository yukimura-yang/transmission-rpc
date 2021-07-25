package moe.gkd.transmissionrpc

import moe.gkd.transmissionrpc.data.Torrent
import moe.gkd.transmissionrpc.network.Api
import moe.gkd.transmissionrpc.network.request.AddTorrentReqBody
import moe.gkd.transmissionrpc.network.response.args.GetSessionRespArgs
import retrofit2.HttpException

object TransmissionRpc {

    /**
     * 初始化
     */
    fun initialize(userName: String, password: String, url: String) {
        Api.initialize(userName, password, url)
        getSession()
    }

    /**
     * 获取session
     */
    fun getSession(): GetSessionRespArgs {
        try {
            val resp = Api.getApi().getSession()
            return resp.arguments
        } catch (e: HttpException) {
            val error = e.response()!!.errorBody()!!.string()
            val session = error.substring(error.indexOf("<code>"), error.indexOf("</code>")).split(":")[1].trim()
            Api.SessionId = session
            return getSession()
        }
    }

    /**
     * 添加下载
     * @return hashString
     */
    fun addTorrentMagnet(magnet: String, dir: String): String? {
        try {
            val resp = Api.getApi().addTorrent(
                AddTorrentReqBody(
                    magnet = magnet,
                    dir = dir
                )
            )
            return resp.arguments.torrentAdded.hashString
        } catch (e: NullPointerException) {
            //已存在
            return null
        }
    }

    /**
     * 添加下载
     * @param torrent 文件的base64编码
     */
    fun addTorrent(torrent: String, dir: String): String? {
        try {
            val resp = Api.getApi().addTorrent(
                AddTorrentReqBody(
                    torrent = torrent,
                    dir = dir
                )
            )
            return resp.arguments.torrentAdded.hashString
        } catch (e: NullPointerException) {
            //已存在
            return null
        }
    }

    fun getTorrent(): List<Torrent> {
        try {
            val resp = Api.getApi().getTorrents()
            return resp.arguments.torrents
        } catch (e: NullPointerException) {
            return arrayListOf()
        }
    }
}