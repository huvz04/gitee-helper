package io.huvz.webinfo.util

import io.huvz.webinfo.WebinfoPlugin.logger
import kotlinx.coroutines.delay
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.Message
import net.mamoe.mirai.message.data.MessageChain
import kotlin.random.Random

/**
 * 统一任务发送
 */
class SendTask {



    /**
     * 群聊回复
     */
    companion object{
        var messageInterval = Random.nextInt(1500)+500L;



        public suspend fun sendMessage(event :GroupMessageEvent ,messages: List<Message>) = try {
            messages.forEach {
                delay(messageInterval)
                event.group.sendMessage(it)

            }
            delay(messageInterval)
        }catch (e: Throwable) {
            logger.error("发送消息失败！", e)
            delay(messageInterval)
        }
        public suspend fun sendMessage(event :CommandSender ,messages:Image) = try {
            delay(messageInterval)
            event.sendMessage(messages)
        }catch (e: Throwable) {
            logger.error("发送消息失败！", e)
            delay(messageInterval)
        }
        /**
         * 私聊回复
         */
        public suspend fun sendMessage(event :CommandSender ,messages: List<Message>) = try {
            messages.forEach {
                delay(messageInterval)
                event.sendMessage(it)

            }
            delay(messageInterval)
        }catch (e: Throwable) {
            logger.error("发送消息失败！", e)
            delay(messageInterval)
        }

        public suspend fun sendMessage(sender: Contact, messageChain: MessageChain) = try {
            delay(messageInterval)
            sender.sendMessage(messageChain)

        }catch (e: Throwable) {
            logger.error("发送消息失败！", e)
            delay(messageInterval)
        }

        public suspend fun sendMessage(sender: Contact, messageChain: String) = try {
            delay(messageInterval)
            sender.sendMessage(messageChain)

        }catch (e: Throwable) {
            logger.error("发送消息失败！", e)
            delay(messageInterval)
        }

        public suspend fun sendMessage(sender: Contact, img: Image)= try {
            delay(messageInterval)
            sender.sendMessage(img)

        }catch (e: Throwable) {
            logger.error("发送消息失败！", e)
            delay(messageInterval)
        }
    }

}