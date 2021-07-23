package moe.gkd.transmissionrpc.network.request.args

class GetTorrentsReqArgs {
    val fields = arrayOf(
        "id",
        "addedDate",
        "name",
        "totalSize",
        "error",
        "errorString",
        "eta",
        "isFinished",
        "isStalled",
        "leftUntilDone",
        "metadataPercentComplete",
        "peersConnected",
        "peersGettingFromUs",
        "peersSendingToUs",
        "percentDone",
        "queuePosition",
        "rateDownload",
        "rateUpload",
        "recheckProgress",
        "seedRatioMode",
        "seedRatioLimit",
        "sizeWhenDone",
        "status",
        "trackers",
        "downloadDir",
        "uploadedEver",
        "uploadRatio",
        "webseedsSendingToUs",
        "activityDate",
        "corruptEver",
        "desiredAvailable",
        "downloadedEver",
        "fileStats",
        "haveUnchecked",
        "haveValid",
        "peers",
        "startDate",
        "trackerStats",
        "comment",
        "creator",
        "dateCreated",
        "files",
        "hashString",
        "isPrivate",
        "pieceCount",
        "pieceSize"
    )
}