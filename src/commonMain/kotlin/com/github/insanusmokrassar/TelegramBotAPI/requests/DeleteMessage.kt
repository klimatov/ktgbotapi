package com.github.insanusmokrassar.TelegramBotAPI.requests

import com.github.insanusmokrassar.TelegramBotAPI.CommonAbstracts.types.MessageAction
import com.github.insanusmokrassar.TelegramBotAPI.bot.RequestsExecutor
import com.github.insanusmokrassar.TelegramBotAPI.requests.abstracts.SimpleRequest
import com.github.insanusmokrassar.TelegramBotAPI.types.*
import com.github.insanusmokrassar.TelegramBotAPI.types.chat.abstracts.Chat
import com.github.insanusmokrassar.TelegramBotAPI.types.message.abstracts.Message
import kotlinx.serialization.*
import kotlinx.serialization.internal.BooleanSerializer

@Serializable
data class DeleteMessage(
    @SerialName(chatIdField)
    override val chatId: ChatIdentifier,
    @SerialName(messageIdField)
    override val messageId: MessageIdentifier
) : SimpleRequest<Boolean>, MessageAction {
    override fun method(): String = "deleteMessage"

    override val resultDeserializer: DeserializationStrategy<Boolean>
        get() = BooleanSerializer
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()
}

suspend fun RequestsExecutor.deleteMessage(
    chatId: ChatIdentifier,
    messageId: MessageIdentifier
) = execute(
    DeleteMessage(chatId, messageId)
)

suspend fun RequestsExecutor.deleteMessage(
    chat: Chat,
    messageId: MessageIdentifier
) = deleteMessage(chat.id, messageId)

suspend fun RequestsExecutor.deleteMessage(
    chatId: ChatId,
    message: Message
) = deleteMessage(chatId, message.messageId)

suspend fun RequestsExecutor.deleteMessage(
    chat: Chat,
    message: Message
) = deleteMessage(chat.id, message.messageId)
