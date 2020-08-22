package com.example.generalproject.Models

import com.example.generalproject.Service.IHttpModel
import com.google.gson.annotations.Expose //Disable data serialize


data class Post(val userId: Number?=null, val id: Number?=null, val title: String?=null, val body: String?=null,
                @Transient    override var dataList: MutableList<Post>? = mutableListOf<Post>()
):IHttpModel<Post>
