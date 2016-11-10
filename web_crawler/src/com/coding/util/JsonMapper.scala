package com.coding.util

/**
 * Created by edward.gong on 2015/11/19.
 */
package tools

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.coding.model.TermObject


import scala.Unit


/**
 * Created by edward.gong on 2015/4/21.
 */
object JsonMapper {
  val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

  def toJson(value: Map[Symbol, Any]): String = {
    toJson(value map { case (k, v) => k.name -> v })
  }

  def toJson(value: Any): String = {
    mapper.writeValueAsString(value)
  }

  def toMap[V](json: String)(implicit m: Manifest[V]) = fromJson[Map[String, V]](json)
  def toList[V](json: String)(implicit m: Manifest[V]) = fromJson[V](json)
  def getMapFromJsonString(jsonString: String) = mapper.readValue[Map[String, Any]](jsonString)
  def fromJson[T](json: String)(implicit m: Manifest[T]): T =   mapper.readValue[T](json)
  def fromTermMapToJson(map:Map[String,String])=mapper.readValue[TermObject](toJson(map),classOf[TermObject])
  def getMapper=this.mapper
}
