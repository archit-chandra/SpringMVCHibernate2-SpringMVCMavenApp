<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Customer Confirmation</title>
    </head>
    <body>
        <h2>${headerLabel}</h2>
        <hr>
        The customer is confirmed: ${customer.firstName} ${customer.lastName}
        <br><br>
        Free passes: ${customer.freePasses}
        <br><br>
        Postal Code: ${customer.postalCode}
        <br><br>
        Course Code: ${customer.courseCode}
        <br><br>
        Hobby: ${customer.hobby}
        <br><br>
        Country: ${customer.address.country}
        <br><br>
        City: ${customer.address.city}
        <br><br>
        Street: ${customer.address.street}
        <br><br>
        Pincode: ${customer.address.pincode}
        <br><br>
        Mobile: ${customer.mobile}
    </body>
</html>