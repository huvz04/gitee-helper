package io.huvz.gitee.util

import kotlinx.coroutines.delay
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.io.FileHandler
import java.io.File
import java.util.concurrent.TimeUnit

suspend fun main(){
    GiteeDao.getImg()
}
class GiteeDao {
    companion object{

        suspend fun getImg(){
            println("正在初始化……");
            val options  = ChromeOptions();

            options.addArguments("--headless");
            //填入无头配置
            val driver: WebDriver = ChromeDriver(options)
            println("初始化成功")

            driver.manage().window().size = Dimension(1300,620)
            val jsExecutor = driver as JavascriptExecutor
            jsExecutor.executeScript("document.body.style.overflow = 'hidden';")
                driver.get("https://gitee.com/ChenYiXuan04")
                println("进入网站成功")
                // 设置隐式等待时间
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS)
                val screenshot: File = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
                // 保存截图为图片文件
                val outputImageFile = File("E:\\TEST\\screenshot.png")
                FileHandler.copy(screenshot, outputImageFile)

                println("截图已保存为：${outputImageFile.absolutePath}")

            // 关闭浏览器
            driver.quit()
            println("关闭浏览器")
        }
    }

}