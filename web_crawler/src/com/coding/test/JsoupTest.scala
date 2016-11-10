package com.coding.test


import java.io.{PrintWriter, File}

import com.coding.algorithm.{CrawlerAlgorithm, NGramAlgorithm}
import com.coding.model.{LinkNode, TermObject, Excel}
import com.coding.preprocesses.BankConvert
import com.coding.util.tools.JsonMapper
import org.jsoup.Jsoup
import org.openqa.selenium.By
import tw.cheyingwu.ckip.{Term, CKIP}
import scala.collection.JavaConversions._
import scala.collection.immutable.ListMap
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import com.coding.util.{WebSimulation, FileIO}

/**
 * Created by edward.gong on 2015/11/17.
 */

object JsoupTest {



  def main(args: Array[String]) {
//    val ckip=new CKIP("140.109.19.104",1501,"w250146","26844534")
//    ckip.setRawText(Jsoup.parse(FileIO.getFile("""D:\test6.html""")).select("html").text())
//    ckip.send()
//    val terms=ckip.getTerm
//    terms.filter(term=> !term.getTag.contains("CATEGORY") ).foreach(term=>{
//      println(term.getTerm+"\t"+term.getTag)
//    })
   // CrawlerAlgorithm.execute("http://www.amexcards.com.tw/2015eSavvy/index.html")
    CrawlerAlgorithm.execute("http://www.citibank.com.tw/sim/index.htm")


  }
  def getPage(url:String,fileName:String): Unit ={
    FileIO.writeFile("D:\\"+fileName,WebSimulation.requestPage(url))
    println("OK")

  }
  def webParser(): Unit ={
    val termList = BankConvert.execute()
    val nGramParameter =2
    val resultScore=NGramAlgorithm.execute(nGramParameter,termList)
    val host="http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/"
    val web=WebSimulation.request(host+"platinum-rcp_027.html")
     val listTagA=web.findElements(By.tagName("a"))
    val listUrl=List("http://www.americanexpress.com.tw/", "http://www.amexcards.com.tw/2015eSavvy/index.html", "http://www.amexcards.com.tw/2015eSavvy/notice.htm", "http://www.americanexpress.com/taiwan/Personal/cards/apply/default.shtml?taiwan_nav=PAGELINK_homepage", "http://www.americanexpress.com/taiwan/customerservice/contactamex.shtml", "http://www.amexcards.com.tw/2015eSavvy/mobile_app.html", "http://www.amexcards.com.tw/2015eSavvy/index.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_027.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_027.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_259.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_259.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_027.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_026.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_185.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_190.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_290.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_251.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_192.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_252.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_253.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_254.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_178.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_024.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_255.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_198.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_035.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_031.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_033.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_030.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_256.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_045.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_257.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_258.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_027.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_259.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_259.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_027.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_263.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_236.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_154.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_277.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_236.html", "http://www.grandhyatttaipei.com.tw/", "http://maps.google.com.tw/maps?f=q&source=s_q&hl=zh-tw&geocode=&q=%E5%8F%B0%E5%8C%97%E5%B8%82%E6%9D%BE%E5%A3%BD%E8%B7%AF2%E8%99%9F&sll=22.99739,120.213604&sspn=0.010686,0.014677&brcurrent=3,0x3442abadec7543e7:0x5dbcdd8252aeabe7,0,0x3442ac6b61dbbd9d:0xc0c243da98cba64b&ie=UTF8&hq=&hnear=110%E5%8F%B0%E5%8C%97%E5%B8%82%E4%BF%A1%E7%BE%A9%E5%8D%80%E6%9D%BE%E5%A3%BD%E8%B7%AF2%E8%99%9F&ll=25.036655,121.562669&spn=0.010518,0.014677&z=16&iwloc=r0")
    //val listUrl=List("http://www.americanexpress.com.tw/","http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_027.html", "http://www.amexcards.com.tw/2015eSavvy/platinum-rcp/platinum-rcp_259.html")
    listUrl.map(a=>{
      val doc=WebSimulation.request(a)
      val linkNode=new LinkNode(a)
      linkNode.setContent(doc.findElement(By.tagName("html")).getAttribute("innerText"))
      linkNode
    }).foreach(link=>{
      val score = resultScore.filter(gramMap => {
        link.getContent.contains(gramMap._1)
      }).foldLeft(0)((x, y) => {
        x + y._2
      })
    println(link.url+"\t" +score)
    })



  }
def nGram()={
  val termList = BankConvert.execute()
  val nGramParameter =2
  val resultScore=NGramAlgorithm.execute(nGramParameter,termList)

  val doc=Jsoup.parse(FileIO.getFile("""D:\test6.html"""))
  val no=doc.select("a").filter(link=>link.text!=""||link.attr("title")!="").map(link=>{
    val score = resultScore.filter(gramMap => {
      link.parent().text.contains(gramMap._1)
    }).foldLeft(0)((x, y) => {
      x + y._2
    })
    Map(
      "link"->link.attr("href"),
      "score"-> score.toString,
      "text"->link.parent().text
    )
  })
 no. sortBy(x=>x("score").toInt)(Ordering[Int].reverse) foreach println

}


}
