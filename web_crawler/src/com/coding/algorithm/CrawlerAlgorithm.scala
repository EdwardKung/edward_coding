package com.coding.algorithm

import com.coding.model.{Excel, LinkNode}
import com.coding.preprocesses.BankConvert
import com.coding.util.{FileIO, WebSimulation}
import org.openqa.selenium.{TimeoutException, WebDriver, WebElement, By}

import scala.collection.immutable.Stack
import scala.collection.mutable.{ListBuffer, ArrayBuffer}
import scala.collection.JavaConversions._

/**
 * Created by edward.gong on 2015/11/27.
 */
object CrawlerAlgorithm {
  var urlTask: List[LinkNode] = List()
  var finishNode: ListBuffer[LinkNode] = new ListBuffer[LinkNode]()
  val scoreList={
    val termList = BankConvert.execute()
    val nGramParameter =2
    NGramAlgorithm.execute(nGramParameter,termList)
  }

  def loadPageLink(doc: WebDriver,targetNode:LinkNode): List[LinkNode] = {

    def filterDuplicateWithFinishNode(linkNode:String)= {
       !finishNode.exists(completeNode => {
        completeNode.url.equals(linkNode)
      })
    }
    def filterDuplicateWithUrlTask(linkNode:String) ={
      !urlTask.exists(urlTaskNode => {
        urlTaskNode.url.equals(linkNode)
      })
    }
    doc.findElements(By.tagName("a")).toList
      .map(link=>link.getAttribute("href"))
      .distinct
      .filter(linkNode=>linkNode!=null)
      .filter(linkNode=>filterDuplicateWithUrlTask(linkNode))
      .filter(linkNode =>filterDuplicateWithFinishNode(linkNode))
      .filter(linkNode => linkNode.startsWith("http"))
      .map(linkString => {
          val linkNode=new LinkNode(linkString)
          linkNode.setLevel(targetNode.getLevel+1)
          linkNode
      })

  }

  def caculateContentScore(doc: WebDriver, node: LinkNode) = {
    node.setContent(doc.findElement(By.tagName("html")).getAttribute("innerText"))
    val score=scoreList.filter(gramMap => {
      node.getContent.contains(gramMap._1)
    }).foldLeft(0)((x, y) => {
      x+Math.pow( y._2,2).toInt
    })

    node.setScore(Math.sqrt(score.toDouble).toInt)
  }

  def execute(rootUrl: String) = {
    println("START")
    val rootUrlNode = new LinkNode(rootUrl)
    val levelLimitation:Int=4
    urlTask ::= rootUrlNode
    while (urlTask.nonEmpty && finishNode.size < 3000) {
      val node = urlTask.head
      println("node level is "+node.getLevel+"\t"+node.url)
      if(node.getLevel < levelLimitation){
        try{
          val doc = WebSimulation.request(node.url)
          caculateContentScore(doc,node)
          if(node.getScore>=100){
            val urlList: List[LinkNode] = loadPageLink(doc,node)
            urlTask =urlTask ::: urlList
          }

          finishNode.add(node)
        }catch{
          case   e:Exception=>println(e.getMessage)
        }

      }

      urlTask = urlTask.tail
      println(urlTask.size)
      println(finishNode.size)

    }
    println("__________________________")
   FileIO.writeFile("D:\\score_1.txt",finishNode. sortBy(x=>x.getScore)(Ordering[Int].reverse).filter(linkNode=>linkNode.getScore>=100).toString())



    println("END")
    // val urlList:List[LinkNode]=loadPageLink(rootUrlNode)


  }

}
