   // Api Service Example
   
   val apiBaseClient=ApiClient("")

   println("Get jsonplaceholder Users..")
   apiBaseClient.Get<Base>(Base(),"users/1"){ isSuccess, response, message ->
	   if (isSuccess) {
		   if(response!=null){
			   println(response)
		   }else{
			   println("Data==[]")
		   }
	   } else {
		   println("Hata!!")
		   println(message)
	   }
   }
   println("Get jsonplaceholder Todos..")
	  apiBaseClient.Get<todo>(todo(),"todos/1"){ isSuccess, response, message ->
		  if (isSuccess) {
			  if(response!=null){
				  println(response)
			  }else{
				  println("Data==[]")
			  }
		  } else {
			  println("Hata!!")
			  println(message)
		  }
	  }

 /*
  val formBody2: RequestBody = FormBody.Builder() 
  .add("username", "test")
  .add("password", "test")
  .build()
 */

  var newpost=Post(id = 11,userId = 11,title = "test",body = "new body")
  val mediatypes = MediaType.parse("application/json; charset=utf-8")
  var formBody = RequestBody.create(mediatypes, Gson().toJson(newpost)) //Convert Data to Json

  println("Post jsonplaceholder Todos..")
  apiBaseClient.Post<todo>(todo(),"posts",formBody){ isSuccess, response, message ->
	  if (isSuccess) {
		  if(response!=null){
			  println(response)
		  }else{
			  println("Data==[]")
		  }
	  } else {
		  println("Hata!!")
		  println(message)
	  }
  }

  println("Put jsonplaceholder Todos..")
  apiBaseClient.Put<todo>(todo(),"posts/3",formBody){ isSuccess, response, message ->
	  if (isSuccess) {
		  if(response!=null){
			  println(response)
		  }else{
			  println("Data==[]")
		  }
	  } else {
		  println("Hata!!")
		  println(message)
	  }
  }

  println("Delete jsonplaceholder Todos..")
  apiBaseClient.Delete<todo>(todo(),"posts/3",formBody){ isSuccess, response, message ->
	  if (isSuccess) {
		  if(response!=null){
			  println(response)
		  }else{
			  println("Data==[]")
		  }
	  } else {
		  println("Hata!!")
		  println(message)
	  }
  }