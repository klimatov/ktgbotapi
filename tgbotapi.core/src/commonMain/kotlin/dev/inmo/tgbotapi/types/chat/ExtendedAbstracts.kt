package dev.inmo.tgbotapi.types.chat

import dev.inmo.tgbotapi.types.*
import dev.inmo.tgbotapi.types.message.abstracts.Message
import dev.inmo.tgbotapi.types.message.abstracts.TelegramBotAPIMessageDeserializeOnlySerializer
import kotlinx.serialization.Serializable

@Serializable(ExtendedChatSerializer.Companion::class)
sealed interface ExtendedChannelChat : ChannelChat, ExtendedPublicChat, ExtendedChatWithUsername {
    val linkedGroupChatId: IdChatIdentifier?
}

@Serializable(ExtendedChatSerializer.Companion::class)
sealed interface ExtendedGroupChat : GroupChat, ExtendedPublicChat {
    val permissions: ChatPermissions
}

@Serializable(ExtendedChatSerializer.Companion::class)
sealed interface ExtendedPrivateChat : PrivateChat, ExtendedChatWithUsername {
    val bio: String
    val hasPrivateForwards: Boolean
    val hasRestrictedVoiceAndVideoMessages: Boolean
    val statusEmojiId: CustomEmojiId?

    val allowCreateUserIdLink: Boolean
        get() = hasPrivateForwards
}

sealed interface ExtendedPublicChat : ExtendedChat, PublicChat {
    val description: String
    val inviteLink: String?
    @Serializable(TelegramBotAPIMessageDeserializeOnlySerializer::class)
    val pinnedMessage: Message?
    val membersHidden: Boolean
}

@Serializable(ExtendedChatSerializer.Companion::class)
sealed interface ExtendedSupergroupChat : SupergroupChat, ExtendedGroupChat, ExtendedChatWithUsername {
    val slowModeDelay: Long?
    val stickerSetName: StickerSetName?
    val canSetStickerSet: Boolean
    val linkedChannelChatId: IdChatIdentifier?
    val location: ChatLocation?

    /**
     * This field represents field "join_to_send_messages" from API
     */
    val requiresJoinForMessaging: Boolean

    /**
     * This field represents field "join_by_request" from API
     */
    val requireAdminApproveToJoin: Boolean

    /**
     * This field represents field "has_aggressive_anti_spam_enabled" from API
     */
    val isAggressiveAntiSpamEnabled: Boolean
}

@Serializable(ExtendedChatSerializer.Companion::class)
sealed interface ExtendedForumChat : ExtendedSupergroupChat, ForumChat

@Serializable(ExtendedChatSerializer.Companion::class)
sealed interface ExtendedChat : Chat {
    val chatPhoto: ChatPhoto?
}

@Serializable(ExtendedChatSerializer.Companion::class)
sealed interface ExtendedChatWithUsername : UsernameChat, ExtendedChat {
    val activeUsernames: List<Username>
}
