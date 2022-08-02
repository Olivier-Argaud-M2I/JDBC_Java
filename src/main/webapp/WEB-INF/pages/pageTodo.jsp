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
      <legend>Creation Todo</legend>
      <form action="/jdbc/todos?type=create" method="POST">
          <input type="text" name="nom" placeholder="Nom">
          <input type="text" name="description" placeholder="Description">
          <input type="submit" value="Creer">
      </form>
  </fieldset>



  <fieldset>
      <legend>Recherche All</legend>
      <form action="/jdbc/todos?type=all" method="POST">
          <input type="submit" value="Rechercher">
      </form>
    </fieldset>


    <fieldset>
        <legend>Recherche par Id</legend>
        <form action="/jdbc/todos?type=id" method="POST">
            <input type="number" name="id">
            <input type="submit" value="Rechercher">
        </form>
    </fieldset>

    <fieldset>
        <legend>Recherche par Nom</legend>
        <form action="/jdbc/todos?type=nom" method="POST">
            <input type="text" name="nom">
            <input type="submit" value="Rechercher">
        </form>
    </fieldset>

    <fieldset>
        <legend>Resultats de la recherche</legend>
        <c:forEach items="${todos}" var="todo">
            <div>id:${todo.id}  nom:${todo.nom} description:${todo.description}</div>
        </c:forEach>
    </fieldset>



  </body>
</html>
