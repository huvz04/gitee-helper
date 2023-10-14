package io.huvz.gitee


import io.huvz.gitee.util.ChromeConfig
import io.huvz.gitee.util.GiteeCommand
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info
import javax.imageio.spi.RegisterableService


object GiteePlugin : KotlinPlugin(
    JvmPluginDescription(
        id = "io.huvz.gitee",
        name = "gitee-helper",
        version = "0.1.1",
    ) {
        author("huvz")
    }
) {
    override fun onEnable() {
        ChromeConfig.reload()
        CommandManager.registerCommand(GiteeCommand)
        logger.info { "Plugin loaded" }
    }
}