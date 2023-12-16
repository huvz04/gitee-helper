package io.huvz.gitee.util

import io.huvz.gitee.GiteePlugin
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object GiteeUser : SimpleCommand(GiteePlugin,"GiteeUser",description = "获取gitee用户") {


    @Handler
    suspend fun handler(sender: CommandSender, msg:String ){
        try{
        val client = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS) // 设置连接超时时间为 30 秒
            .readTimeout(30, TimeUnit.SECONDS) // 设置读取超时时间为 30 秒
            .build()
            val nurl = "http://43.142.135.84:9085/v2api/view/searchGitee?name=${msg}"
            val request: Request = Request.Builder().url(nurl).get().build()
            val imgs = client.newCall(request).execute();
            val bt : ExternalResource? = imgs.body?.bytes()?.toExternalResource();
            bt?.uploadAsImage(sender.subject!!)?.let { SendTask.sendMessage(sender, it) };
        }catch (e:Exception){
            sender.subject?.let { SendTask.sendMessage(it, "唔~！服务器好像开小差了") }
        }
    }

}