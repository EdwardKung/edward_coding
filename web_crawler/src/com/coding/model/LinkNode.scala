package com.coding.model

import com.coding.util.tools.JsonMapper

import scala.collection.immutable.ListMap

/**
 * Created by edward.gong on 2015/11/26.
 */
case class LinkNode(url:String) {
  private var score:Int=0
  private var level:Int=0
  private var childList:List[LinkNode]=List()
  private var content:String=""

  override def toString={
    url+" ___"+score
  }
  def getLevel=this.level
  def setLevel(level:Int)=this.level=level
  def getScore=this.score
  def setScore(score:Int)=this.score=score
  def getContent=this.content
  def setContent(content:String)=this.content=content
}
