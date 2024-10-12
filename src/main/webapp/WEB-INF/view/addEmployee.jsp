<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vladi
  Date: 9/1/2024
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add an Employee</title>
</head>
<body>

<h2>Employee Info</h2>


<form:form action="saveEmployee" modelAttribute="employee">

  Name: <form:input path="name"/>
  <br> <br>
  Surname: <form:input path="surname"/>
  <br> <br>
  Department: <form:input path="department"/>
  <br> <br>
  Salary: <form:input path="salary"/>
  <form:errors path="salary"/>
  <br> <br>

  <input type="submit" value="Add"/>
  


</form:form>



</body>
</html>