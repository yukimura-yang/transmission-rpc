package moe.gkd.transmissionrpc.network.request

import moe.gkd.transmissionrpc.data.EnumTransmissionMethod
import moe.gkd.transmissionrpc.network.request.args.AddTorrentReqArgs


class AddTorrentReqBody(
    magnet: String? = null,
    torrent: String? = null,
    dir: String
) : BaseRequestBody<AddTorrentReqArgs>(
    method = EnumTransmissionMethod.TORRENT_ADD,
    arguments = AddTorrentReqArgs(
        magnet,
        torrent,
        dir
    )
)