package dev.inmo.tgbotapi.requests.send

import dev.inmo.tgbotapi.abstracts.*
import dev.inmo.tgbotapi.requests.send.abstracts.*
import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.buttons.KeyboardMarkup
import dev.inmo.tgbotapi.types.message.abstracts.ContentMessage
import dev.inmo.tgbotapi.types.message.abstracts.TelegramBotAPIMessageDeserializationStrategyClass
import dev.inmo.tgbotapi.types.message.content.*
import dev.inmo.tgbotapi.utils.throwRangeError
import kotlinx.serialization.*


private val commonResultDeserializer: DeserializationStrategy<ContentMessage<LocationContent>>
    = TelegramBotAPIMessageDeserializationStrategyClass()

fun SendLocation(
    chatId: ChatIdentifier,
    latitude: Double,
    longitude: Double,
    threadId: MessageThreadId? = chatId.threadId,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageId? = null,
    allowSendingWithoutReply: Boolean? = null,
    replyMarkup: KeyboardMarkup? = null
) = SendLocation(
    chatId,
    latitude,
    longitude,
    null,
    null,
    null,
    null,
    threadId,
    disableNotification,
    protectContent,
    replyToMessageId,
    allowSendingWithoutReply,
    replyMarkup
)

fun SendStaticLocation(
    chatId: ChatIdentifier,
    latitude: Double,
    longitude: Double,
    threadId: MessageThreadId? = chatId.threadId,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageId? = null,
    allowSendingWithoutReply: Boolean? = null,
    replyMarkup: KeyboardMarkup? = null
) = SendLocation(chatId, latitude, longitude, threadId, disableNotification, protectContent, replyToMessageId, allowSendingWithoutReply, replyMarkup)

fun SendLiveLocation(
    chatId: ChatIdentifier,
    latitude: Double,
    longitude: Double,
    livePeriod: Seconds,
    horizontalAccuracy: Meters? = null,
    heading: Degrees? = null,
    proximityAlertRadius: Meters? = null,
    threadId: MessageThreadId? = chatId.threadId,
    disableNotification: Boolean = false,
    protectContent: Boolean = false,
    replyToMessageId: MessageId? = null,
    allowSendingWithoutReply: Boolean? = null,
    replyMarkup: KeyboardMarkup? = null
) = SendLocation(
    chatId,
    latitude,
    longitude,
    livePeriod,
    horizontalAccuracy,
    heading,
    proximityAlertRadius,
    threadId,
    disableNotification,
    protectContent,
    replyToMessageId,
    allowSendingWithoutReply,
    replyMarkup
)

@Serializable
data class SendLocation internal constructor(
    @SerialName(chatIdField)
    override val chatId: ChatIdentifier,
    @SerialName(latitudeField)
    override val latitude: Double,
    @SerialName(longitudeField)
    override val longitude: Double,
    @SerialName(livePeriodField)
    override val livePeriod: Seconds? = null,
    @SerialName(horizontalAccuracyField)
    override val horizontalAccuracy: Meters? = null,
    @SerialName(headingField)
    override val heading: Degrees? = null,
    @SerialName(proximityAlertRadiusField)
    override val proximityAlertRadius: Meters? = null,
    @SerialName(messageThreadIdField)
    override val threadId: MessageThreadId? = chatId.threadId,
    @SerialName(disableNotificationField)
    override val disableNotification: Boolean = false,
    @SerialName(protectContentField)
    override val protectContent: Boolean = false,
    @SerialName(replyToMessageIdField)
    override val replyToMessageId: MessageId? = null,
    @SerialName(allowSendingWithoutReplyField)
    override val allowSendingWithoutReply: Boolean? = null,
    @SerialName(replyMarkupField)
    override val replyMarkup: KeyboardMarkup? = null
) : SendMessageRequest<ContentMessage<LocationContent>>,
    ReplyingMarkupSendMessageRequest<ContentMessage<LocationContent>>,
    PositionedSendMessageRequest<ContentMessage<LocationContent>>,
    HorizontallyAccured,
    Livable,
    ProximityAlertable,
    Headed
{
    override fun method(): String = "sendLocation"
    override val resultDeserializer: DeserializationStrategy<ContentMessage<LocationContent>>
        get() = commonResultDeserializer
    override val requestSerializer: SerializationStrategy<*>
        get() = serializer()

    init {
        if (livePeriod != null && livePeriod !in livePeriodLimit) {
            error("Live period for sending location must be in $livePeriodLimit, but was $livePeriod")
        }
        if (horizontalAccuracy != null && horizontalAccuracy !in horizontalAccuracyLimit) {
            throwRangeError("horizontalAccuracy", horizontalAccuracyLimit, horizontalAccuracy)
        }
    }
}
