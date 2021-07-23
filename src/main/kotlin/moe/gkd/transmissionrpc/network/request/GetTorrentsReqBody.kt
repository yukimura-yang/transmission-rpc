package moe.gkd.transmissionrpc.network.request

import moe.gkd.transmissionrpc.data.EnumTransmissionMethod
import moe.gkd.transmissionrpc.network.request.args.GetTorrentsReqArgs


class GetTorrentsReqBody :
    BaseRequestBody<GetTorrentsReqArgs>(GetTorrentsReqArgs(), EnumTransmissionMethod.TORRENT_GET)