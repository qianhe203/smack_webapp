<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Slot Reservation</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>slot0</th>
        <th>slot1</th>
        <th>slot2</th>
        <th>slot3</th>
    </tr>
    <tr>
        <td><c:out value="${racksData.rackID}" /></td>
        <td><c:out value="${racksData.slot0}" /></td>
        <td><c:out value="${racksData.slot1}" /></td>
        <td><c:out value="${racksData.slot2}" /></td>
        <td><c:out value="${racksData.slot3}" /></td>
    </tr>
</table>
<!--<c:out value="${racksData}" />-->
<form action="reserve" method="post">
            <p>
                <label for="id">Enter rack ID:</label>
                <input id="id" name="id" value="${fn:escapeXml(param.id)}">
                <span class="error">${messages.id}</span>
            </p>
            <p>
                <label for="slot">Enter slot number:</label>
                <input id="slot" name="slot" value="${fn:escapeXml(param.slot)}">
                <span class="error">${messages.slot}</span>
            </p>
            <p>
                <label for="pin">Enter PIN:</label>
                <input id="pin" name="pin" value="${fn:escapeXml(param.pin)}">
                <span class="error">${messages.pin}</span>
            </p>
            <p>
                <label for="duration">Enter duration for reservation:</label>
                <input id="duration" name="duration" value="${fn:escapeXml(param.duration)}">
                <span class="error">${messages.duration}</span>
            </p>
            <p>
                <input type="submit">
                <span class="error">${messages.success}</span>
            </p>
        </form>
</body>
</html>