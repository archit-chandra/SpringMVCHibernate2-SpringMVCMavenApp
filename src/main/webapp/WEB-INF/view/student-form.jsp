<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Student Registration Form</title>
    </head>
    <body>
        <form:form action="processForm" modelAttribute="student">
            First Name: <form:input path="firstName"></form:input>
            <br><br>
            Last Name: <form:input path="lastName"></form:input>
            <br><br>
            Country:
            <form:select path="country">
                <%--<form:option value="Brazil" label="Brazil"></form:option>--%>
                <%--<form:option value="France" label="France"></form:option>--%>
                <%--<form:option value="Germany" label="Germany"></form:option>--%>
                <%--<form:option value="India" label="India"></form:option>--%>
                <form:options items="${student.countryOptions}"></form:options>
            </form:select>
            <br><br>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>