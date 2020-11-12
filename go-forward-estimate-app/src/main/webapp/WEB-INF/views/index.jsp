<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estimation Application</title>
<style>
table {
  font-family: arial, sans-serif;
  width: 100%;
  border-spacing: 0; 
  border-width: 0; 
  padding: 0; 
  border-width: 0;
  cell-spacing :0;
}

td{
  text-align: left;
  padding: 8px;
  
}

#cnestimate{
background-color: lightblue;
  opacity: 1;
  height: 100px;
  width: 130px;
  font-style: bold;
  font-size: 15px;
  border-radius: 10px;
  white-space: normal;
}
#ueestimate{
background-color: lightblue;
  opacity: 1;
  height: 100px;
  width: 130px;
  font-style: bold;
  font-size: 15px;
  border-radius: 10px;
  white-space: normal;
}
#reporting{
background-color: lightblue;
  opacity: 1;
  height: 100px;
  width: 130px;
  font-style: bold;
  font-size: 15px;
  border-radius: 10px;
  white-space: normal;
}
#upmaintenance{
background-color: lightblue;
  opacity: 1;
  height: 100px;
  width: 130px;
  font-style: bold;
  font-size: 15px;
  border-radius: 10px;
  white-space: normal;
}
#ermaintenance{
background-color: lightblue;
  opacity: 1;
  height: 100px;
  width: 130px;
  font-style: bold;
  font-size: 15px;
  border-radius: 10px;
  white-space: normal;
}
.header {
  padding: 6px;
  text-align: center;
  background: #1abc9c;
  color: white;
  font-size: 18px;
}
</style>
</head>
<body>

<div class="header">
<h2>Go Forward Estimation Application</h2>
</div>


<table>
  <tr>
  <form:form action="/redirect_page" method="GET" >
  
   <td><input id="cnestimate" type="submit" class="button" name="newEstimate" value="Create New Estimate"></td>
   </form:form>
   <form action = "/updateExistingEstimate" method="post">
  
   <td><input id="ueestimate" type="submit" class="button" name="existingEstimate" value="Update Existing Estimate"></td>
   </form>
   <form action = "/reporting" method="post">
  
   <td><input id="reporting" type="submit" class="button" name="reporting" value="Reporting"></td>
   </form>
  </tr>
  <tr>
    <form action = "/userProfileMaintenance" method="post">
  
   <td><input id="upmaintenance" type="submit" class="button" name="userProfileMaintenance" value="User Profile Maintenance"></td>
   </form>
   <form action = "/estimationRuleMaintenance" method="post">
  
   <td><input id="ermaintenance" type="submit" class="button" name="estimationRuleMaintenance" value="Estimation Rule Maintenance"></td>
   </form>
  </tr>
</table>



</body>
</html>