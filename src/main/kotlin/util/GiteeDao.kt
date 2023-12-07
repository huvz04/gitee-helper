package io.huvz.gitee.util

import config.SeleniumConfig
import config.driver
import io.huvz.gitee.GiteePlugin
import io.huvz.gitee.GiteePlugin.logger
import io.huvz.gitee.GiteePlugin.reload
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import net.mamoe.mirai.console.command.ConsoleCommandSender.name
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.warning
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import xyz.cssxsh.mirai.selenium.*
import xyz.cssxsh.mirai.selenium.data.*
import xyz.cssxsh.selenium.*
import java.io.File
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.*
/**
 * Gitee查询工具
 */
class GiteeDao {
    /**
     * 如果加载成功则为真
     */

    companion object{
        val selenium: Boolean by lazy {
            try {
                MiraiSeleniumPlugin.setup()
            } catch (exception: NoClassDefFoundError) {
                //logger.warning { "相关类加载失败，请安装 https://github.com/cssxsh/mirai-selenium-plugin $exception" }
                false
            }
        }


        suspend fun getImg(name:String ): ByteArray? {
            if (selenium) {
                    /**
                     * 使用 [MiraiSeleniumPlugin] 的默认设置 [MiraiSeleniumConfig]
                     */
                    driver = MiraiSeleniumPlugin.driver()

                    /**
                     * 使用 自定义的 的设置 [SeleniumConfig], 实现 [RemoteWebDriverConfig]
                     *
                     * 注意，[SeleniumConfig] 不要出现在 if (selenium) { } 外面，
                     * 否则 [MiraiSeleniumPlugin] 未安装时会出现 [NoClassDefFoundError]
                     */
                    SeleniumConfig.reload()
                    driver = MiraiSeleniumPlugin.driver(config = SeleniumConfig)
                val result :ByteArray = driver.getScreenshot(url = "https://gitee.com/${name}/");
                driver.close();

                    return result;
                }
            return null;
        }


    }
}