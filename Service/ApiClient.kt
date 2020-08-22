package com.example.generalproject.Service

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import okhttp3.*
import java.io.IOException


class ApiClient(val token:String) {
    var baseurl="https://jsonplaceholder.typicode.com/";
    var convertStatus=0

    fun <T>Get(modelclass:IHttpModel<T>, path: String, requestCallback: (isSuccess: Boolean, response: MutableList<T>?, message: String?) -> (Unit)) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(baseurl+path)
            .addHeader("Authorization", token)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException){
                requestCallback(false, null,e.toString())
            }
            override fun onResponse(call: Call, response: Response){
                val modeljson = response.body()!!.string()
                try{
                    val tradeElement: JsonElement = JsonParser().parse(modeljson)
                    if(!(tradeElement is JsonArray))
                        modelclass.dataList!!.add(Gson().fromJson(tradeElement, modelclass::class.java) as T)
                    else{
                        val dataArray = tradeElement.asJsonArray
                        for(data in dataArray)
                            modelclass.dataList!!.add(Gson().fromJson(data, modelclass::class.java) as T)
                    }
                    convertStatus=1
                }catch (e:Exception){
                    convertStatus=-1
                }
                if(response.code()!=401 && response.code()!=403 &&response.code()!=400 && response.code()!=404 && response.code()!=500 && modelclass!=null){
                    requestCallback(true, modelclass.dataList,null)
                }
                else{
                    requestCallback(false, null ,"Veri Alma İşleminde Hata! Status Code:"+response.code() +" JsonConvertStatus:"+convertStatus)
                }
            }
        })
    }

    fun <T>Post(modelclass:IHttpModel<T>, path: String,formBody :RequestBody, requestCallback: (isSuccess: Boolean, response: MutableList<T>?, message: String?) -> (Unit)) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(baseurl+path)
            .post(formBody)
            .addHeader("Authorization", token)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException){
                requestCallback(false, null,e.toString())
            }
            override fun onResponse(call: Call, response: Response){
                println("post başladı")
                println(response.code())
                val modeljson = response.body()!!.string()
                try{
                    val tradeElement: JsonElement = JsonParser().parse(modeljson)
                    if(!(tradeElement is JsonArray))
                        modelclass.dataList!!.add(Gson().fromJson(tradeElement, modelclass::class.java) as T)
                    else{
                        val dataArray = tradeElement.asJsonArray
                        for(data in dataArray)
                            modelclass.dataList!!.add(Gson().fromJson(data, modelclass::class.java) as T)
                    }
                    convertStatus=1
                }catch (e:Exception){
                    convertStatus=-1
                }
                if(response.code()!=401 && response.code()!=403 &&response.code()!=400 && response.code()!=404 && response.code()!=500 && modelclass!=null){
                    requestCallback(true, modelclass.dataList,null)
                }
                else{
                    requestCallback(false, null ,"Veri Alma İşleminde Hata! Status Code:"+response.code() +" JsonConvertStatus:"+convertStatus)
                }
            }
        })
    }

    fun <T>Put(modelclass:IHttpModel<T>, path: String,formBody :RequestBody, requestCallback: (isSuccess: Boolean, response: MutableList<T>?, message: String?) -> (Unit)) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(baseurl+path)
            .put(formBody)
            .addHeader("Authorization", token)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException){
                requestCallback(false, null,e.toString())
            }
            override fun onResponse(call: Call, response: Response){
                println("put başladı")
                println(response.code())
                val modeljson = response.body()!!.string()
                try{
                    val tradeElement: JsonElement = JsonParser().parse(modeljson)
                    if(!(tradeElement is JsonArray))
                        modelclass.dataList!!.add(Gson().fromJson(tradeElement, modelclass::class.java) as T)
                    else{
                        val dataArray = tradeElement.asJsonArray
                        for(data in dataArray)
                            modelclass.dataList!!.add(Gson().fromJson(data, modelclass::class.java) as T)
                    }
                    convertStatus=1
                }catch (e:Exception){
                    convertStatus=-1
                }
                if(response.code()!=401 && response.code()!=403 &&response.code()!=400 && response.code()!=404 && response.code()!=500 && modelclass!=null){
                    requestCallback(true, modelclass.dataList,null)
                }
                else{
                    requestCallback(false, null ,"Veri Alma İşleminde Hata! Status Code:"+response.code() +" JsonConvertStatus:"+convertStatus)
                }
            }
        })
    }

    fun <T>Delete(modelclass:IHttpModel<T>, path: String,formBody :RequestBody, requestCallback: (isSuccess: Boolean, response: MutableList<T>?, message: String?) -> (Unit)) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(baseurl+path)
            .delete(formBody)
            .addHeader("Authorization", token)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException){
                requestCallback(false, null,e.toString())
            }
            override fun onResponse(call: Call, response: Response){
                println("put başladı")
                println(response.code())
                val modeljson = response.body()!!.string()
                try{
                    val tradeElement: JsonElement = JsonParser().parse(modeljson)
                    if(!(tradeElement is JsonArray))
                        modelclass.dataList!!.add(Gson().fromJson(tradeElement, modelclass::class.java) as T)
                    else{
                        val dataArray = tradeElement.asJsonArray
                        for(data in dataArray)
                            modelclass.dataList!!.add(Gson().fromJson(data, modelclass::class.java) as T)
                    }
                    convertStatus=1
                }catch (e:Exception){
                    convertStatus=-1
                }
                if(response.code()!=401 && response.code()!=403 &&response.code()!=400 && response.code()!=404 && response.code()!=500 && modelclass!=null){
                    requestCallback(true, modelclass.dataList,null)
                }
                else{
                    requestCallback(false, null ,"Veri Alma İşleminde Hata! Status Code:"+response.code() +" JsonConvertStatus:"+convertStatus)
                }
            }
        })
    }


}

