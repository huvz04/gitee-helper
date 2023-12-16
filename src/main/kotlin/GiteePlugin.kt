package io.huvz.gitee


import io.huvz.gitee.GiteePlugin.reload
import io.huvz.gitee.util.GiteeCommand
import io.huvz.gitee.util.GiteeUser
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info


object GiteePlugin : KotlinPlugin(
    JvmPluginDescription(
        id = "io.huvz.gitee",
        name = "gitee-helper",
        version = "0.2",
    ) {
        author("huvz")
    }
) {
    override fun onEnable() {
        CommandManager.registerCommand(GiteeCommand)
        CommandManager.registerCommand(GiteeUser)
        logger.info { "Gitee Plugin loaded" }
    }
}
