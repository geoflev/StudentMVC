<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students' List</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
            button {
                border-radius: 4px;
            }
            .submit{
                background-color: green;
                font-size: 22px;
            }
            .button1{
                background-color: yellow;
                font-size: 12px;
                display: block;
                margin: auto;
            }
            .button2{
                background-color: red;
                font-size:12px;
                display: block;
                margin: auto;
            }
            h1
            {
                text-align: center;
            }
            .header{
                font-weight: bold;
            }
            
        </style>
    </head>
    <body>
        <h1>Students List</h1>
        <table>
            <tr class="header">
                <td>ID</td><td>First Name</td><td>Last Name</td><td>Date of Birth</td><td>Tuition Fees</td><td>Edit</td><td>Delete</td>
            </tr>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.dateOfBirth}</td>
                    <td>${student.tuitionFees}</td>
                    <td><button class="button1" ><a href="<c:url value='/edit-${student.id}-student' />">Edit</a></button></td>
                    <td><button class="button2"><a href="<c:url value='/delete-${student.id}-student' />">Delete</a></button></td>
                </tr>
            </c:forEach>
        </table>
        </br>
        <button class="submit"><a href="<c:url value='/new' />">Add</a></button>
    </body>
</html>
