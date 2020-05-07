<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>New Student</title>
        <style>

            .error {
                color: #ff0000;
            }
            td {
                border: 1px solid #dddddd;
                text-align: left;
            }

        </style>
    </head>
    <body>

        <h1>Register a new Student</h1>

        <form:form method="POST" modelAttribute="student">
            <form:input type="hidden" path="id" id="id"/>
            <table>
                <tr>
                    <td><label for="firstName">First Name </label> </td>
                    <td><form:input path="firstName" /></td>
                    <td><form:errors path="firstName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="lastName">Last Name </label> </td>
                    <td><form:input path="lastName" /></td>
                    <td><form:errors path="lastName" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="dateOfBirth">Date of Birth </label> </td>
                    <td><form:input path="dateOfBirth"/></td>
                    <td><form:errors path="dateOfBirth" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label for="tuitionFees">Tuition Fees </label> </td>
                    <td><form:input path="tuitionFees" /></td>
                    <td><form:errors path="tuitionFees" cssClass="error"/></td>
                </tr>
                </br>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </form:form>
    </table>
    </br>
    Go back to <a href="<c:url value='/' />">List of All Students</a>
</body>
</html>
