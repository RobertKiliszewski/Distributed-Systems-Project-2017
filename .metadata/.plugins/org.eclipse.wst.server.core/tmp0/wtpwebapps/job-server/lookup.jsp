<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dictionary</title>
</head>
<body>

<h1>Search dictionary</h1>
<form action="lookup" method="post">
<div class="form-group">
  <label>Enter word to search:</label>
  <input type="text" class="form-control" name="word">
</div>

<div class="form-group">
  <button class="btn btn-success" type="submit">Search</button>
</div>	

</form>

<div class="alert alert-success">  
   		${messages.description}  
	</div>  

</body>
</html>