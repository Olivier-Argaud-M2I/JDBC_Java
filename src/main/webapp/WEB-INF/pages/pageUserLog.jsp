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
      <legend>Ajout User with logs</legend>
      <form action="<c:url value="/userLog"/>" method="POST">
          <input type="text" name="nom" placeholder="nom"/>
          <input type="text" name="prenom" placeholder="prenom">
          <input type="text" name="log" placeholder="data">
          <input type="number" name="idlog" placeholder="id log">
          <input type="submit" value="valider" >
      </form>
    </fieldset>



  </body>
</html>
