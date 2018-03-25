<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer Registration</title>
        <style>
            .error {
                color: red;
            }
        </style>
    </head>
    <body>
        <i>Fill out the form. Asterik (*) means required.</i>
        <br><br>
        <form:form action="processForm" modelAttribute="customer">
            First Name : <form:input path="firstName"></form:input>
            <br><br>
            Last Name (*): <form:input path="lastName"></form:input>
            <form:errors path="lastName" cssClass="error"></form:errors>
            <br><br>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>
