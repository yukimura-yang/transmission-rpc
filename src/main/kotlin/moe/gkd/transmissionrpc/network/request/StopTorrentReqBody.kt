package moe.gkd.transmissionrpc.network.request

import moe.gkd.transmissionrpc.data.EnumTransmissionMethod
import moe.gkd.transmissionrpc.network.request.args.IdsTorrentReqArgs

class StopTorrentReqBody(
    ids: IntArray
) : BaseRequestBody<IdsTorrentReqArgs>(
    arguments = IdsTorrentReqArgs(ids),
    method = EnumTransmissionMethod.TORRENT_STOP
)