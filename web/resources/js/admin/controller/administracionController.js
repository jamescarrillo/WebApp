/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$.ajax({
    url: "./ParticipacionCiudadana?action=GetAlertaSolicitud",
    success: function(data){
        alert(data);
    }
});
    
$("document").ready(function(){
    $("body").roles();
});

