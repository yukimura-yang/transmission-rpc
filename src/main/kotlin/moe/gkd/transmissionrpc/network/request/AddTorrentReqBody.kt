package moe.gkd.transmissionrpc.network.request

import moe.gkd.transmissionrpc.data.EnumTransmissionMethod
import moe.gkd.transmissionrpc.network.request.args.AddTorrentReqArgs


class AddTorrentReqBody(
    magnet: String,
    dir: String
) : BaseRequestBody<AddTorrentReqArgs>(
    method = EnumTransmissionMethod.TORRENT_ADD,
    arguments = AddTorrentReqArgs(
        magnet,
        dir
    )
)