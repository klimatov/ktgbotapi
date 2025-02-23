package dev.inmo.tgbotapi.types.message

import korlibs.time.DateTime
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.buttons.InlineKeyboardMarkup
import dev.inmo.tgbotapi.types.chat.ChannelChat
import dev.inmo.tgbotapi.types.chat.CommonBot
import dev.inmo.tgbotapi.types.message.abstracts.*
import dev.inmo.tgbotapi.types.message.content.MessageContent

data class ChannelContentMessageImpl<T: MessageContent>(
    override val messageId: MessageId,
    override val chat: ChannelChat,
    override val content: T,
    override val date: DateTime,
    override val editDate: DateTime?,
    override val hasProtectedContent: Boolean,
    override val forwardInfo: ForwardInfo?,
    override val replyTo: Message?,
    override val replyMarkup: InlineKeyboardMarkup?,
    override val senderBot: CommonBot?,
    override val authorSignature: AuthorSignature?,
    override val mediaGroupId: MediaGroupIdentifier?,
) : ChannelContentMessage<T>
