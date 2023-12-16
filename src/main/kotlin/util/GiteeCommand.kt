package io.huvz.gitee.util


import io.huvz.gitee.GiteePlugin
import io.huvz.gitee.util.SendTask.Companion.sendMessage
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.message.data.Image
import net.mamoe.mirai.message.data.MessageChain
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.TimeUnit

/**
 * Gitee
 */

object GiteeCommand : SimpleCommand(GiteePlugin,"GiteeInfo",description = "获取gitee用户") {


        @Handler
        suspend fun handler(sender: CommandSender, msg:String ){
            val client = OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS) // 设置连接超时时间为 30 秒
                .readTimeout(30, TimeUnit.SECONDS) // 设置读取超时时间为 30 秒
                .build()
            try{
                val nurl = "http://43.142.135.84:9085/v2api/view/gitee?name=${msg}"
                val request: Request = Request.Builder().url(nurl).get().build()
                val imgs = client.newCall(request).execute();
                val bt : ExternalResource? = imgs.body?.bytes()?.toExternalResource();
                bt?.uploadAsImage(sender.subject!!)?.let { sendMessage(sender, it) };
            }catch (e:Exception){
                sender.subject?.let { sendMessage(it,"唔~！服务器好像开小差了") }
            }

        }

}