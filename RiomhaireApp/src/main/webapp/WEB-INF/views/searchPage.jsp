<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
			<div class="row">
                    		<div style="height:30px;background-color:steelblue;width:90%; margin-left:20px">
	                    		<span style="color:white;font-size:15px">Search Page</span>
	                    	</div>
                    	</div>
                    	<br/>
                    	<br/>
            <div class="row">
                    	<form action="viewResults" method="POST" class="form-horizontal" >
                    	<table style ="width:80%;margin-left:20px;">
                    	<tr>
                    	<td>
                    	 <input name = "firstName" type="text" placeholder="First Name" class="form-control" style="width:400px;margin-left:20px" required =""/></td>
                    	 <td><input name = "lastName" type="text" placeholder="Last Name" class="form-control" style="width:400px;" required=""/>
                    	</td>
                    	</tr>
                    	<tr>
                    	<td colspan="2">
	                    	<select style="width:700px;margin-left:40px;margin-right:40px;" id="department" name="department" class="form-control input-md">
	      					<option value="" selected/>
	      					<option>Manufacturing</option>
	      					<option>HR</option>
	      					<option>Sales</option>
	    					</select>
                    	</tr>
                    	<tr>
                    	<td colspan="2">
	                    	<input type="submit" style="width:600px;margin-left:100px;" value="Submit" class="btn btn-info btn-block"/>
                    	</tr>
                    	</table>
                    	</form>
              </div>
              
</body>
</html>