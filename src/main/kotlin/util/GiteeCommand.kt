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
import java.io.File
import java.io.FileOutputStream

/**
 * Gitee控制
 */
object GiteeCommand : SimpleCommand(GiteePlugin,"gitee",description = "获取gitee用户") {

        @Handler
        suspend fun handler(sender: CommandSender, msg:String ){

            val imgs = GiteeDao.getImg(msg)
            if(imgs!=null){
                val bt :ExternalResource = imgs.toExternalResource();
                sendMessage(sender,bt.uploadAsImage(sender.subject!!));
                //saveByteArrayAsImage(imgs,"C:\\Users\\dache\\Desktop\\F\\mcl-2.1.2\\data")
            }
            else{
                sender.subject?.let { sendMessage(it, "没有结果！") }
            }

        }

    fun saveByteArrayAsImage(byteArray: ByteArray, outputPath: String) {
        val file = File(outputPath)
        val outputStream = FileOutputStream(file)
        outputStream.write(byteArray)
        outputStream.close()
    }



}