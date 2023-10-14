package io.huvz.gitee.util

import io.huvz.gitee.GiteePlugin
import kotlinx.coroutines.delay
import net.mamoe.mirai.utils.ExternalResource
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.io.FileHandler
import java.io.File
import java.util.concurrent.TimeUnit
class GiteeDao {
    companion object{

        suspend fun getImg(name:String ): ExternalResource {

            val options  = ChromeOptions();

            options.addArguments("--headless");
            //填入无头配置
            val driver: WebDriver = ChromeDriver(options)
            driver.manage().window().size = Dimension(1448,979)
            val jsExecutor = driver as JavascriptExecutor
            jsExecutor.executeScript("document.body.style.overflow = 'hidden';")
            driver.get("https://gitee.com/${name}")
            GiteePlugin.logger.info("进入网站成功")
                // 设置隐式等待时间
                driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS)
                val screenshot: File = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
                // 保存截图为图片文件
                val outputImageFile = File(GiteePlugin.dataFolder.absolutePath+"\\TEMP\\${name}.png")
                FileHandler.copy(screenshot, outputImageFile)

            GiteePlugin.logger.info("截图已保存为：${outputImageFile.absolutePath}")

            // 关闭浏览器
            driver.quit()
            return outputImageFile.toExternalResource().toAutoCloseable()
        }
    }

}