<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olivi
  Date: 02/08/2022
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Actor</title>
  </head>
  <body>


    <fieldset>
      <legend>Recherche All</legend>
      <form action="/jdbc/actors?type=all" method="POST">
          <input type="submit" value="Rechercher">
      </form>
    </fieldset>



    <fieldset>
        <legend>Recherche par Id</legend>
        <form action="/jdbc/actors?type=id" method="POST">
            <input type="number" name="id">
            <input type="submit" value="Rechercher">
        </form>
    </fieldset>


    <fieldset>
        <legend>Recherche par Nom</legend>
        <form action="/jdbc/actors?type=nom" method="POST">
            <input type="text" name="nom">
            <input type="submit" value="Rechercher">
        </form>
    </fieldset>

    <fieldset>
        <legend>Resultats de la recherche</legend>
        <c:forEach items="${actors}" var="item">
            <div>id:${item.id}  nom:${item.nom} prenom:${item.prenom} date:${item.dateToString()}</div>
        </c:forEach>
    </fieldset>



  </body>
</html>
