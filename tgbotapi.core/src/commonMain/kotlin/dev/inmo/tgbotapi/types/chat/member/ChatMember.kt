package dev.inmo.tgbotapi.types.chat.member

import dev.inmo.tgbotapi.abstracts.WithUser
import dev.inmo.tgbotapi.types.statusField
import dev.inmo.tgbotapi.utils.RiskFeature
import dev.inmo.tgbotapi.utils.nonstrictJsonFormat
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive

@Serializable(ChatMemberSerializer::class)
sealed interface ChatMember : WithUser

@RiskFeature
object ChatMemberSerializer : KSerializer<ChatMember> {
    override val descriptor: SerialDescriptor = JsonObject.serializer().descriptor

    override fun deserialize(decoder: Decoder): ChatMember {
        val json = JsonObject.serializer().deserialize(decoder)
        return when (json[statusField] ?.jsonPrimitive ?.content ?: error("Status field of chat member must be specified, but incoming json contains next: $json")) {
            "creator" -> nonstrictJsonFormat.decodeFromJsonElement(OwnerChatMember.serializer(), json)
            "administrator" -> nonstrictJsonFormat.decodeFromJsonElement(AdministratorChatMemberImpl.serializer(), json)
            "member" -> nonstrictJsonFormat.decodeFromJsonElement(MemberChatMemberImpl.serializer(), json)
            "restricted" -> nonstrictJsonFormat.decodeFromJsonElement(RestrictedChatMember.serializer(), json)
            "left" -> nonstrictJsonFormat.decodeFromJsonElement(LeftChatMemberImpl.serializer(), json)
            "kicked" -> nonstrictJsonFormat.decodeFromJsonElement(KickedChatMember.serializer(), json)
            else -> error("Unknown type of chat member in json: $json")
        }
    }

    override fun serialize(encoder: Encoder, value: ChatMember) {
        when (value) {
            is OwnerChatMember -> OwnerChatMember.serializer().serialize(encoder, value)
            is AdministratorChatMemberImpl -> AdministratorChatMemberImpl.serializer().serialize(encoder, value)
            is MemberChatMemberImpl -> MemberChatMemberImpl.serializer().serialize(encoder, value)
            is RestrictedChatMember -> RestrictedChatMember.serializer().serialize(encoder, value)
            is LeftChatMemberImpl -> LeftChatMemberImpl.serializer().serialize(encoder, value)
            is KickedChatMember -> KickedChatMember.serializer().serialize(encoder, value)
        }
    }
}
