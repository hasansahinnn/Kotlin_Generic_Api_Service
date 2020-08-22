package com.example.generalproject.Models

import com.example.generalproject.Service.IHttpModel
import com.google.gson.annotations.Expose


data class todo(val userId: Number?=null, val id: Number?=null, val title: String?=null, val completed: Boolean?=null,
                @Transient  override var dataList: MutableList<todo>?= mutableListOf<todo>()
):IHttpModel<todo>