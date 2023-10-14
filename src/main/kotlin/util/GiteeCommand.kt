package io.huvz.gitee.util


import io.huvz.gitee.GiteePlugin
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import org.checkerframework.checker.units.qual.t

object GiteeCommand : SimpleCommand(GiteePlugin,"gitee",description = "获取gitee用户") {

        @Handler
        suspend fun handler(sender: CommandSender, msg:String ){

            val imgs = GiteeDao.getImg(msg)
            val img = sender.subject?.let { imgs.uploadAsImage(it) }

            img?.let { sender.sendMessage(it) }

        }





}