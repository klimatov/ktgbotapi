package dev.inmo.tgbotapi.extensions.utils.extensions

import dev.inmo.tgbotapi.abstracts.FromUser
import dev.inmo.tgbotapi.abstracts.WithUser
import dev.inmo.tgbotapi.extensions.utils.asUser
import dev.inmo.tgbotapi.types.chat.Chat
import dev.inmo.tgbotapi.types.chat.User
import dev.inmo.tgbotapi.types.update.ChatJoinRequestUpdate
import dev.inmo.tgbotapi.types.update.abstracts.BaseMessageUpdate
import dev.inmo.tgbotapi.types.update.abstracts.Update
import dev.inmo.tgbotapi.utils.PreviewFeature

@PreviewFeature
fun Update.sourceChat(): Chat? = when (this) {
    is BaseMessageUpdate -> data.chat
    is ChatJoinRequestUpdate -> data.chat
    else -> {
        when (val data = data) {
            is FromUser -> data.from
            is WithUser -> data.user
            else -> null
        }
    }
}

@PreviewFeature
fun Update.sourceUser(): User? = when (val data = data) {
    is FromUser -> data.from
    is WithUser -> data.user
    else -> sourceChat()?.asUser()
}
