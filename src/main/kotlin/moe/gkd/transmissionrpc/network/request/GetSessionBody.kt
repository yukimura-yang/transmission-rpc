package moe.gkd.transmissionrpc.network.request

import moe.gkd.transmissionrpc.data.EnumTransmissionMethod

class GetSessionBody : BaseRequestBody<Void>(null, EnumTransmissionMethod.SESSION_GET)