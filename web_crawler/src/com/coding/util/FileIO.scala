package com.coding.util

import java.io.File

/**
 * Created by edward.gong on 2015/11/18.
 */
object FileIO {
  def getFile(location:String):String={
    val source = scala.io.Source.fromFile(location)
    try source.mkString finally source.close()
  }
  def writeFile(path:String,content:String): Unit ={
    val pw = new java.io.PrintWriter(new File(path))
    try pw.write(content) finally pw.close()
  }
}
