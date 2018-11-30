/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    
    $("#container").on('click', '#modifier', function (){
        var id = $(this).attr("v");
        $.ajax({
                url: "FiliereServlet",
                type: 'GET',
                data: {id: id, action: 'modifier'},
                success: function (data) {
                    $('#nom').val(data.nom);
                    $('#code').val(data.code);
                    $('#description').val(data.description);
                    $('#ajouter').prop('value', 'Modifier');
                    $("#operation").val("update");
                    $('#operation').attr("v", data.id);
                },
                error: function (errorThrown) {
                    console.log("Erreur");
                }
            });
    });

    $("#container").on('click', '#supprimer', function () {
        var id = $(this).attr("v");
        if (confirm("Vous voulez supprimer cette filiere !")) {
            $.ajax({
                url: "FiliereServlet",
                type: 'GET',
                cache: false,
                data: {id: id, action: 'supprimer'},
                success: function (data) {
                    init();
                    $("#container").empty();
                    $("#container").html(remplir(data));
                },
                error: function (errorThrown) {
                    console.log("Erreur");
                }
            });
            return true;
        }else{
            return false;
        }
    });

    function init() {
        $("#nom").val("");
        $("#code").val("");
        $("#description").val("");
    }
    
    function remplir(data) {
        var td = "";
        for (var i = 0; i < data.length; i++) {
            td += '<tr><td>' + data[i].id + '</td><td>' + data[i].nom + '</td><td>' + data[i].code + '</td><td>' + data[i].description + '</td><td><input id="modifier" type="button" v="' + data[i].id + '" value="Modifier"></td><td><input id="supprimer" type="button" v="' + data[i].id + '" value="Supprimer"></td></tr>';
        }
        return td;
    }
    
    $('#ajouter').click(function () {
        var nom = $('#nom').val();
        var code = $('#code').val();
        var description = $('#description').val();
        var operation = $('#operation').val();
        var id = $('#operation').attr("v");

        $.ajax({
            url: "FiliereServlet",
            type: 'GET',
            data: {id: id, nom: nom, code: code, description: description, action: 'ajouter', operation: operation},
            success: function (data) {
                init();
                $("#container").empty();
                $("#container").html(remplir(data));
                $('#ajouter').prop('value', 'Ajouter');
            },
            error: function (errorThrown) {
                console.log("erreur");
            }
        });
    });

});