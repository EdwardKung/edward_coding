package com.coding.model

import java.io.File


import info.folone.scala.poi.Workbook
import org.apache.poi.ss.usermodel.{Sheet, WorkbookFactory}


/**
 * Created by edward.gong on 2015/11/18.
 */
class Excel(path:String){
  private val excelFile=  WorkbookFactory.create(new File(path))
  def getWorkBook=this.excelFile
}
