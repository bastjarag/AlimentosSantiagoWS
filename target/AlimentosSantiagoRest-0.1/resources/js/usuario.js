/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var restUrl = "localhost:8084/AlimentosSantiagoREST/rest/usuario/";
var usuario;

$(document).ready(function () {
    console.log("entra al evento.");
    $.get(restUrl, function (data) {
        console.log(data);
    });
});

$('#btn-login').click(function () {
    usuario = {
        "usuario": $("#tbx-usuario").val(),
        "password": $("#tbx-clave").val()
    }
    console.log(restUrl + "login");
    console.log(usuario);
    $.ajax({
        url: (restUrl + "login"),
        data: usuario,
        type: 'POST',
        dataType: 'json',
        headers: { "Content-Type": "application/json" },
        success: function () {
            alert("Success");
        },
        error: function (xhr, status, error) {
            alert('Failed!');
            console.log(xhr.status);
            console.log(xhr);
            console.log(status);
            console.log(error);
            
        }
    });
});
