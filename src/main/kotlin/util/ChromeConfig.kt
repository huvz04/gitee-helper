package io.huvz.gitee.util

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.value

/**
 * 大约是没什么用的配置
 */
object ChromeConfig : AutoSavePluginConfig("LaiZhiConfig"){
    @ValueDescription("触发-添加图库-指令")
    val ChromeUrl:String by value("C:\\Program Files\\Google\\Chrome\\Application")


}