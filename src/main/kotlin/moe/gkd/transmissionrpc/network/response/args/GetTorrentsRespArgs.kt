package moe.gkd.transmissionrpc.network.response.args

import moe.gkd.transmissionrpc.data.Torrent


class GetTorrentsRespArgs(
    val torrents: List<Torrent>
)