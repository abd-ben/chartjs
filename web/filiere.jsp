<%-- 
    Document   : filiere
    Created on : 25 nov. 2018, 17:01:53
    Author     : root
--%>

<%@page import="beans.Filiere"%>
<%@page import="service.FiliereService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="script/jquery-3.3.1.min.js"></script>
        <script src="script/Chart.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-grid.min.css" rel="stylesheet">
        <link href="css/bootstrap-reboot.min.css" rel="stylesheet">


        <title>JQuery | Filiere </title>
    </head>
    <body style="">
        <h1>Ajouter une Filiere</h1>
        <div class="row">
            <div class="box col-md-6">
                <div class="container">
                    
                    <table>
                        <input id="operation" type="hidden" name="operation" value="add" v="" />
                        <tr>
                            <td>nom :</td>
                            <td><input type="text" name="nom" id="nom"></td>
                        </tr>
                        <tr>
                            <td>code :</td>
                            <td><input type="text" name="code" id="code"></td>
                        </tr>
                        <tr>
                            <td>description :</td>
                            <td><input type="text" name="description" id="description"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="button" value="ajouter" id="ajouter"></td>
                        </tr>
                    </table>
                    <h1>Liste des Filieres</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>nom</th>
                                <th>code</th>
                                <th>description</th>
                                <th>modifier</th>
                                <th>supprimer</th>
                            </tr>
                        </thead>
                        <tbody id="container">
                            <%
                                FiliereService fs = new FiliereService();
                                //fs.findAll().forEach(filiere -> {

                                for (Filiere filiere : fs.findAll()) {
                            %>
                            <tr>
                                <td><%=filiere.getId()%></td>
                                <td><%=filiere.getNom()%></td>
                                <td><%=filiere.getCode()%></td>
                                <td><%=filiere.getDescription()%></td>
                                <td><input id="modifier" type="button" v="<%=filiere.getId()%>" value="Modifier"></td>
                                <td><input id="supprimer" type="button" v="<%=filiere.getId()%>" value="Supprimer"></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="box col-md-6">
                <canvas id="myChart" ></canvas>
            </div>
        </div>


        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="script/index.js"></script>
        <script src="script/filiere.js"></script>        
    </body>
</html>
