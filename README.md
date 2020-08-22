# Kotlin_Generic_Api_Service
Generic Api Service For Kotlin (Get-Put-Post-Delete + Token Header)

implement IHttpModel to your Class

Add this prop like 
  - @Transient  override var dataList: MutableList<Base>?= mutableListOf<Base>()
  @Transient : That code removes dataList properties when you serialize
  
  
  ------------------  Usage   ----------------
  
     val apiBaseClient=ApiClient("")

     apiBaseClient.Get<Base>(Base(),"users/1"){ isSuccess, response, message ->
         if (isSuccess)
             println(response)
        else 
             println(message)
     }
