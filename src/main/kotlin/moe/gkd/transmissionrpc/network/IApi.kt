package moe.gkd.transmissionrpc.network

import moe.gkd.transmissionrpc.network.request.*
import moe.gkd.transmissionrpc.network.response.ResponseBody
import moe.gkd.transmissionrpc.network.response.args.AddTorrentRespArgs
import moe.gkd.transmissionrpc.network.response.args.GetSessionRespArgs
import moe.gkd.transmissionrpc.network.response.args.GetTorrentsRespArgs
import retrofit2.http.Body
import retrofit2.http.POST

interface IApi {
    @POST("/transmission/rpc")
    fun getSession(
        @Body body: GetSessionBody = GetSessionBody()
    ): ResponseBody<GetSessionRespArgs>

    @POST("/transmission/rpc")
    fun addTorrent(
        @Body body: AddTorrentReqBody
    ): ResponseBody<AddTorrentRespArgs>

    @POST("/transmission/rpc")
    fun getTorrents(
        @Body body: GetTorrentsReqBody = GetTorrentsReqBody()
    ): ResponseBody<GetTorrentsRespArgs>

    @POST("/transmission/rpc")
    fun startTorrent(
        @Body body: StartTorrentReqBody
    ): ResponseBody<Any>

    @POST("/transmission/rpc")
    fun stopTorrent(
        @Body body: StopTorrentReqBody
    ): ResponseBody<Any>

}