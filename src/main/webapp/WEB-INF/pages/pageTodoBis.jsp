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
      <title>TodoBis</title>
  </head>
  <body>


  <fieldset>
      <legend>Creation/modification TodoBis</legend>
      <form action="<c:url value="todosBis?type=create"/>" method="POST">
          <input type="text" name="nom" id="nom" placeholder="Nom">
          <input type="text" name="description" id="description" placeholder="Description">
<%--          <input type="datetime-local">--%>
          <input type="number" name="id" id="id" hidden>
          <input type="submit" value="Valider">
      </form>
  </fieldset>



  <fieldset>
      <legend>Recherche All</legend>
      <form action="<c:url value="todosBis?type=all"/>" method="POST">
          <input type="submit" value="Rechercher">
      </form>
    </fieldset>


    <fieldset>
        <legend>Recherche par Id</legend>
        <form action="<c:url value="todosBis?type=id"/>" method="POST">
            <input type="number" name="id">
            <input type="submit" value="Rechercher">
        </form>
    </fieldset>

    <fieldset>
        <legend>Recherche par Nom</legend>
        <form action="<c:url value="todosBis?type=nom"/>" method="POST">
            <input type="text" name="nom">
            <input type="submit" value="Rechercher">
        </form>
    </fieldset>

    <fieldset>
        <legend>Resultats de la recherche</legend>
        <c:forEach items="${todos}" var="todo">
            <div>id:${todo.id}  nom:${todo.nom} description:${todo.description}</div>
            <div>
                <form action="<c:url value="todosBis?type=delete&id=${todo.id}"/>" method="POST">
                    <input type="submit" value="delete via form">
                </form>

                <a href="<c:url value="/todosBis?type=delete&id=${todo.id}"/>" method="POST"></a>

                <button onclick="del(${todo.id})">Delete via fetch</button>

                <button onclick="edit('${todo.id}','${todo.nom}','${todo.description}')">Edit</button>

            </div>
        </c:forEach>
    </fieldset>

    <script>
        function del(id){
            console.log("delete tache "+id);
            fetch("/jdbc/todosBis?type=delete&id="+id,{method:"POST"})
        }

        function edit(id,nom,description){
            console.log("edit tache "+id)
            document.getElementById("id").value = id;
            document.getElementById("nom").value = nom;
            document.getElementById("description").value = description;
        }

    </script>


  </body>
</html>
