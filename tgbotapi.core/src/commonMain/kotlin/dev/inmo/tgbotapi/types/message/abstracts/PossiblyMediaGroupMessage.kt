package dev.inmo.tgbotapi.types.message.abstracts

import dev.inmo.tgbotapi.types.MediaGroupIdentifier
import dev.inmo.tgbotapi.types.message.content.MessageContent

interface PossiblyMediaGroupMessage<out T : MessageContent> : ContentMessage<T> {
    val mediaGroupId: MediaGroupIdentifier?
}
