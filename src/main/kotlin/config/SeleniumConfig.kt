package config

import net.mamoe.mirai.console.data.ReadOnlyPluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.ValueName
import net.mamoe.mirai.console.data.value
import xyz.cssxsh.selenium.RemoteWebDriverConfig
import xyz.cssxsh.selenium.UserAgents

object SeleniumConfig : ReadOnlyPluginConfig("SeleniumConfig"), RemoteWebDriverConfig {
    @ValueName("user_agent")
    @ValueDescription("截图UA")
    override val userAgent: String by value(UserAgents.IPAD)

    @ValueName("width")
    @ValueDescription("截图宽度")
    override val width: Int by value(979)

    @ValueName("height")
    @ValueDescription("截图高度")
    override val height: Int by value(1448)

    @ValueName("headless")
    @ValueDescription("无头模式（后台模式）")
    override val headless: Boolean by value(true)

    @ValueName("browser")
    @ValueDescription("指定使用的浏览器，Chrome/Firefox")
    override val browser: String by value("Chrome")
}