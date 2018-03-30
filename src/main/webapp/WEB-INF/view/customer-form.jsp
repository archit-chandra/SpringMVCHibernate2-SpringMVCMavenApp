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
        <h2>${headerLabel}</h2>
        <hr>
        <i>Fill out the form. Asterik (*) means required.</i>
        <br><br>
        <form:form action="processForm" modelAttribute="customer">
            First Name : <form:input path="firstName"></form:input>
            <form:errors path="firstName" cssClass="error"></form:errors>
            <br><br>
            Last Name (*): <form:input path="lastName"></form:input>
            <form:errors path="lastName" cssClass="error"></form:errors>
            <br><br>
            Free Passes :<form:input path="freePasses"></form:input>
            <form:errors path="freePasses" cssClass="error"></form:errors>
            <br><br>
            Postal Code: <form:input path="postalCode"></form:input>
            <form:errors path="postalCode" cssClass="error"></form:errors>
            <br><br>
            Course Code: <form:input path="courseCode"></form:input>
            <form:errors path="courseCode" cssClass="error"></form:errors>
            <br><br>
            Hobby: <form:input path="hobby"></form:input>
            <form:errors path="hobby" cssClass="error"></form:errors>
            <br><br>
            Country: <form:input path="address.country"></form:input>
            <form:errors path="address.country" cssClass="error"></form:errors>
            <br><br>
            City: <form:input path="address.city"></form:input>
            <form:errors path="address.city" cssClass="error"></form:errors>
            <br><br>
            Street: <form:input path="address.street"></form:input>
            <form:errors path="address.street" cssClass="error"></form:errors>
            <br><br>
            Pincode: <form:input path="address.pincode"></form:input>
            <form:errors path="address.pincode" cssClass="error"></form:errors>
            <br><br>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>
