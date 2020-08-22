package com.example.generalproject.Models
import com.example.generalproject.Service.IHttpModel
import com.google.gson.annotations.Expose

// result generated from /json

data class Address(val street: String?=null, val suite: String?=null, val city: String?=null, val zipcode: String?=null, val geo: Geo?=null)

data class Base(val id: Number?=null, val name: String?=null, val username: String?=null, val email: String?=null, val address: Address?=null, val phone: String?=null, val website: String?=null, val company: Company?=null,

                @Transient  override var dataList: MutableList<Base>?= mutableListOf<Base>()
): IHttpModel<Base>

data class Company(val name: String?=null, val catchPhrase: String?=null, val bs: String?=null)

data class Geo(val lat: String?=null, val lng: String?=null)
