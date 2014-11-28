<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Station</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/custom.css" />
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a href="../" class="navbar-brand">Recherche température</a>
        </div>
        <div class="pull-right">
            <input type="text" id="search" class="form-control"  placeholder="Filtre"/>
        </div>
    </div>
</nav>

<div class="container poffset7">

        <c:forEach var="error" items="${errors}">
            <div class="alert alert-danger" role="alert">
                <strong>${error}</strong>
            </div>
        </c:forEach>

        <h2>Station - ${station}</h2>
        <h4>Zone - ${zone}</h4>
        <h4>Route - ${route}</h4>

       <form:form modelAttribute="StationForm" method="post" action="../station/${id}" cssClass="poffset2">
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span> Début</div>
                    <form:input path="begin" cssClass="form-control" cssErrorClass="has-error"/>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span> Fin</div>
                    <form:input path="end" cssClass="form-control" cssErrorClass="has-error"/>
                </div>
            </div>

            <button type="submit" class="btn btn-default">Filter</button>
            <a href="../../station/${id}">RAZ</a>
        </form:form>


    <table class="table" id="data">
        <thead>
        <tr>
            <th>Sonde</th>
            <th>Date</th>
            <th>Température</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="temp" items="${tempList}">
            <c:choose>
                <c:when test="${temp.getTemperatureValue() <= 0 }">
                    <tr class="info">
                </c:when>
                <c:when test="${temp.getTemperatureValue() <= 10 && temp.getTemperatureValue() > 0 }">
                    <tr class="active">
                </c:when>
                <c:when test="${temp.getTemperatureValue() <= 20 && temp.getTemperatureValue() > 10 }">
                    <tr class="success">
                </c:when>
                <c:when test="${temp.getTemperatureValue() <= 30 && temp.getTemperatureValue() > 20 }">
                    <tr class="warning">
                </c:when>
                <c:when test="${temp.getTemperatureValue() > 30 }">
                    <tr class="danger">
                </c:when>
                <c:otherwise>
                    <tr class="">
                </c:otherwise>
            </c:choose>

            <td>${temp.getSensorLabel()}</td>
            <td>${temp.getTemperatureDate()}</td>
            <td>${temp.getTemperatureValue()}°</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>


<script type="text/javascript" src=".../js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<script type="text/javascript" src="../js/script.js"></script>
</html>