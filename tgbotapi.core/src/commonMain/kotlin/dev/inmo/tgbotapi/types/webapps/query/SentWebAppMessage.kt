package dev.inmo.tgbotapi.types.webapps.query

import dev.inmo.tgbotapi.types.InlineMessageIdentifier
import kotlinx.serialization.Serializable

@Serializable
data class SentWebAppMessage(
    val inlineMessageId: InlineMessageIdentifier? = null
)
