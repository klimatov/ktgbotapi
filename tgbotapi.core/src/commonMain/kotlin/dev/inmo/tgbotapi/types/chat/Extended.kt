package dev.inmo.tgbotapi.types.chat

import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.message.abstracts.Message
import dev.inmo.tgbotapi.types.message.abstracts.TelegramBotAPIMessageDeserializeOnlySerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class ExtendedChannelChatImpl(
    @SerialName(idField)
    override val id: ChatId,
    @SerialName(titleField)
    override val title: String,
    @SerialName(usernameField)
    override val username: Username? = null,
    @SerialName(activeUsernamesField)
    override val activeUsernames: List<Username> = emptyList(),
    @SerialName(photoField)
    override val chatPhoto: ChatPhoto? = null,
    @SerialName(descriptionField)
    override val description: String = "",
    @SerialName(inviteLinkField)
    override val inviteLink: String? = null,
    @SerialName(pinnedMessageField)
    @Serializable(TelegramBotAPIMessageDeserializeOnlySerializer::class)
    override val pinnedMessage: Message? = null,
    @SerialName(linkedChatIdField)
    override val linkedGroupChatId: IdChatIdentifier? = null,
    @SerialName(hasHiddenMembersField)
    override val membersHidden: Boolean = false
) : ExtendedChannelChat

@Serializable
data class ExtendedGroupChatImpl(
    @SerialName(idField)
    override val id: ChatId,
    @SerialName(titleField)
    override val title: String,
    @SerialName(photoField)
    override val chatPhoto: ChatPhoto? = null,
    @SerialName(permissionsField)
    override val permissions: ChatPermissions,
    @SerialName(descriptionField)
    override val description: String = "",
    @SerialName(inviteLinkField)
    override val inviteLink: String? = null,
    @SerialName(pinnedMessageField)
    @Serializable(TelegramBotAPIMessageDeserializeOnlySerializer::class)
    override val pinnedMessage: Message? = null,
    @SerialName(hasHiddenMembersField)
    override val membersHidden: Boolean = false
) : ExtendedGroupChat

@Serializable
data class ExtendedPrivateChatImpl(
    @SerialName(idField)
    override val id: UserId,
    @SerialName(photoField)
    override val chatPhoto: ChatPhoto? = null,
    @SerialName(usernameField)
    override val username: Username? = null,
    @SerialName(activeUsernamesField)
    override val activeUsernames: List<Username> = emptyList(),
    @SerialName(firstNameField)
    override val firstName: String = "",
    @SerialName(lastNameField)
    override val lastName: String = "",
    @SerialName(bioField)
    override val bio: String = "",
    @SerialName(hasPrivateForwardsField)
    override val hasPrivateForwards: Boolean = false,
    @SerialName(hasRestrictedVoiceAndVideoMessagesField)
    override val hasRestrictedVoiceAndVideoMessages: Boolean = false,
    @SerialName(emojiStatusCustomEmojiIdField)
    override val statusEmojiId: CustomEmojiId? = null
) : ExtendedPrivateChat

typealias ExtendedUser = ExtendedPrivateChatImpl

@Serializable
data class ExtendedSupergroupChatImpl(
    @SerialName(idField)
    override val id: ChatId,
    @SerialName(titleField)
    override val title: String,
    @SerialName(usernameField)
    override val username: Username? = null,
    @SerialName(activeUsernamesField)
    override val activeUsernames: List<Username> = emptyList(),
    @SerialName(photoField)
    override val chatPhoto: ChatPhoto? = null,
    @SerialName(permissionsField)
    override val permissions: ChatPermissions,
    @SerialName(descriptionField)
    override val description: String = "",
    @SerialName(inviteLinkField)
    override val inviteLink: String? = null,
    @SerialName(pinnedMessageField)
    @Serializable(TelegramBotAPIMessageDeserializeOnlySerializer::class)
    override val pinnedMessage: Message? = null,
    @SerialName(stickerSetNameFullField)
    override val stickerSetName: StickerSetName? = null,
    @SerialName(slowModeDelayField)
    override val slowModeDelay: Long? = null,
    @SerialName(canSetStickerSetField)
    override val canSetStickerSet: Boolean = false,
    @SerialName(linkedChatIdField)
    override val linkedChannelChatId: IdChatIdentifier? = null,
    @SerialName(locationField)
    override val location: ChatLocation? = null,
    @SerialName(joinToSendMessagesField)
    override val requiresJoinForMessaging: Boolean = false,
    @SerialName(joinByRequestField)
    override val requireAdminApproveToJoin: Boolean = false,
    @SerialName(hasAggressiveAntiSpamEnabledField)
    override val isAggressiveAntiSpamEnabled: Boolean = false,
    @SerialName(hasHiddenMembersField)
    override val membersHidden: Boolean = false
) : ExtendedSupergroupChat

@Serializable
data class ExtendedForumChatImpl(
    @SerialName(idField)
    override val id: IdChatIdentifier,
    @SerialName(titleField)
    override val title: String,
    @SerialName(usernameField)
    override val username: Username? = null,
    @SerialName(activeUsernamesField)
    override val activeUsernames: List<Username> = emptyList(),
    @SerialName(photoField)
    override val chatPhoto: ChatPhoto? = null,
    @SerialName(permissionsField)
    override val permissions: ChatPermissions,
    @SerialName(descriptionField)
    override val description: String = "",
    @SerialName(inviteLinkField)
    override val inviteLink: String? = null,
    @SerialName(pinnedMessageField)
    @Serializable(TelegramBotAPIMessageDeserializeOnlySerializer::class)
    override val pinnedMessage: Message? = null,
    @SerialName(stickerSetNameFullField)
    override val stickerSetName: StickerSetName? = null,
    @SerialName(slowModeDelayField)
    override val slowModeDelay: Long? = null,
    @SerialName(canSetStickerSetField)
    override val canSetStickerSet: Boolean = false,
    @SerialName(linkedChatIdField)
    override val linkedChannelChatId: IdChatIdentifier? = null,
    @SerialName(locationField)
    override val location: ChatLocation? = null,
    @SerialName(joinToSendMessagesField)
    override val requiresJoinForMessaging: Boolean = false,
    @SerialName(joinByRequestField)
    override val requireAdminApproveToJoin: Boolean = false,
    @SerialName(hasAggressiveAntiSpamEnabledField)
    override val isAggressiveAntiSpamEnabled: Boolean = false,
    @SerialName(hasHiddenMembersField)
    override val membersHidden: Boolean = false
) : ExtendedForumChat

@Serializable
data class ExtendedBot(
    override val id: UserId,
    @SerialName(usernameField)
    override val username: Username,
    @SerialName(firstNameField)
    override val firstName: String,
    @SerialName(lastNameField)
    override val lastName: String = "",
    @SerialName(canJoinGroupsField)
    val canJoinGroups: Boolean = false,
    @SerialName(canReadAllGroupMessagesField)
    val canReadAllGroupMessages: Boolean = false,
    @SerialName(supportInlineQueriesField)
    val supportsInlineQueries: Boolean = false
) : Bot() {
    @SerialName(isBotField)
    private val isBot = true
}

data class UnknownExtendedChat(
    override val id: IdChatIdentifier,
    val raw: String,
    val rawJson: JsonObject
) : ExtendedChat {
    override val chatPhoto: ChatPhoto? = null
}
