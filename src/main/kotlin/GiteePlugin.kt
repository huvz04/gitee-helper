package io.huvz.gitee


import io.huvz.gitee.GiteePlugin.reload
import io.huvz.gitee.util.GiteeCommand
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info


object GiteePlugin : KotlinPlugin(
    JvmPluginDescription(
        id = "io.huvz.gitee",
        name = "gitee-helper",
        version = "0.1.1",
    ) {
        author("huvz")
        dependsOn("xyz.cssxsh.mirai.plugin.mirai-selenium-plugin", true)
    }
) {
    override fun onEnable() {
        CommandManager.registerCommand(GiteeCommand)
        logger.info { "Gitee Plugin loaded" }
    }
}
