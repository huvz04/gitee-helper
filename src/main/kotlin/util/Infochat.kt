package io.huvz.webinfo.util


import io.huvz.webinfo.WebinfoPlugin
import io.huvz.webinfo.util.SendTask.Companion.sendMessage
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import net.mamoe.mirai.utils.info
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.concurrent.TimeUnit

/**
 * Gitee
 */

object Infochat : SimpleCommand(WebinfoPlugin,"info",description = "获取各个网站的信息") {


        @Handler
        suspend fun handler(sender: CommandSender,url:String, name:String ){
            val client = OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS) // 设置连接超时时间为 30 秒
                .readTimeout(30, TimeUnit.SECONDS) // 设置读取超时时间为 30 秒
                .build()
            try{

                val nurl = "http://43.142.135.84:9085/v2api/bot/info?url=${url}&name=${name}"
                WebinfoPlugin.logger.info {"http to ${nurl}"  }
                val requestBody = "name:postTO".toRequestBody("image/jpeg".toMediaType())
                val request: Request = Request.Builder().url(nurl).post(requestBody).build()
                val imgs = client.newCall(request).execute();
                val bt : ExternalResource? = imgs.body?.byteStream()?.toExternalResource();
                bt?.uploadAsImage(sender.subject!!)?.let { sendMessage(sender, it) };
            }catch (e:Exception){
                WebinfoPlugin.logger.error("code:500:${e.message}")
                sender.subject?.let { sendMessage(it,"唔~！服务器好像开小差了") }
            }

        }

}