package io.huvz.webinfo


import io.huvz.webinfo.util.GiteeUser
import io.huvz.webinfo.util.Infochat
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info


object WebinfoPlugin : KotlinPlugin(
    JvmPluginDescription(
        id = "io.huvz.webinfo",
        name = "webinfo-helper",
        version = "0.3",
    ) {
        author("huvz")
    }
) {
    override fun onEnable() {
        CommandManager.registerCommand(GiteeUser)
        CommandManager.registerCommand(Infochat)
        logger.info { "webinfo Plugin loaded" }
    }
}
