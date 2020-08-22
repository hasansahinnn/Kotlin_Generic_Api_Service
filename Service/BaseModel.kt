package com.example.generalproject.Service

import com.google.gson.annotations.Expose

//Disable datalist serialize and use your model Add To Your Models-> @Transient  override var dataList: MutableList<todo>?= mutableListOf<todo>()
//
interface IHttpModel<T>{

   var dataList: MutableList<T>?
}
