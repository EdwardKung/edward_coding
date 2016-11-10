package com.coding.preprocesses

import com.coding.model.TermObject
import com.coding.util.FileIO
import com.coding.util.tools.JsonMapper


/**
 * Created by edward.gong on 2015/11/20.
 */
object BankConvert {
  def execute()={
    val list = JsonMapper.fromJson[List[List[Map[String, String]]]](FileIO.getFile( """C:\Users\edward.gong\Desktop\銀行資料\KeyTerm.txt"""))
    list.map(sentence =>sentenceMapFunction(sentence))
  }
  def termMapFunction(term:Map[String,String]):TermObject={
    JsonMapper.fromTermMapToJson(term)
  }
  def sentenceMapFunction(sentence:List[Map[String,String]])={
    sentence.map(term =>termMapFunction(term))
      .filter(_.getTag!=null)
      .filter(!_.getTag.contains("CATEGORY"))
  }
}
