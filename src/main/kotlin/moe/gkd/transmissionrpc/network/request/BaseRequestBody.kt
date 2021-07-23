package moe.gkd.transmissionrpc.network.request

import moe.gkd.transmissionrpc.data.EnumTransmissionMethod

open class BaseRequestBody<T>(
    val arguments: T?,
    val method: EnumTransmissionMethod
)