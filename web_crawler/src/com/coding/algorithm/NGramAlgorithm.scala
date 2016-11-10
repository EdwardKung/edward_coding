package com.coding.algorithm

import com.coding.model.TermObject

import scala.collection.immutable.ListMap

/**
 * Created by edward.gong on 2015/11/20.
 */
object NGramAlgorithm {
  private  def sentenceCalculator (n:Int ,collection:List[TermObject])=(for( i <- 2 to n) yield collection.sliding(i).map(p => p)).flatMap(x => x)
  def execute(n:Int,termList:List[List[TermObject]])={
   val allSet= termList.map(sentence => sentenceCalculator(n, sentence))
      .flatMap(x => x)
    countAndSort(allSet).filter(_._2 > 3)
  }

  private def countAndSort(ngrams: List[List[TermObject]]) = {
    def itemListMapFunction(list: List[TermObject]) = {
      list.foldLeft("")((x, y) => {
        x + y.getTerm
      })
    }
    val countNgram = ngrams.map(item => itemListMapFunction(item)).groupBy(l => l).map(t => (t._1, t._2.length))

    ListMap(countNgram.toList.sortBy(_._2)(Ordering[Int].reverse): _*)
  }
}
