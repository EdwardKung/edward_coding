package com.coding.util

import java.util.concurrent.TimeUnit

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.openqa.selenium.{By, WebDriver}
import org.openqa.selenium.phantomjs.{PhantomJSDriver, PhantomJSDriverService}
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities}

/**
 * Created by edward.gong on 2015/11/18.
 */
object WebSimulation {
  val driver:WebDriver=init
  def init():WebDriver={
        val capabilities:DesiredCapabilities=new DesiredCapabilities()
        capabilities.setJavascriptEnabled(true)
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
        capabilities.setCapability( PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:\\phantomjs.exe")
       new PhantomJSDriver(capabilities)
  }
  def requestPage(inputURL:String): String ={
    request(inputURL)
    driver.findElement(By.tagName("html")).getAttribute("innerHTML")
  }
  def request(inputURL:String):WebDriver={
    driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS)
    driver.get(inputURL)
    driver
  }
  def getPageAsDocument(inputURL:String):Document={
    Jsoup parse requestPage(inputURL)
  }
}
