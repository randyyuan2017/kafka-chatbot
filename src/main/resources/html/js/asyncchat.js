var client = uuidv4();
var connection = null;

$(document).ready(function(){
    $("#message_window").hide();

    $("#submit").click(function(){
        var JSONObject= {
            sender: $('#sender').val(),
            message: $('#message').val(),
            room: $("#group option:selected").text()
            };
        var jsonData = JSON.stringify(JSONObject);
        $.ajax({
            url: "api/chat",
            type: "POST",
            data: jsonData,
            dataType: "json",
            contentType: 'application/json',
            success: function(data, status){$('#message').val("")},
            error: function(data, status){alert("Data: " + data + "\nStatus: " + status)}
         });
    });

    $("#message").keyup(function(event){
        if(event.keyCode == 13){
            $("#submit").click();
        }
    });

    $("#save").click(function(){
        $("#sender").prop('disabled', true);
        $("#group").prop('disabled', true);
        $("#save").hide();
        $("#message_window").show(1000);
        connection = connect($("#group option:selected").text());
    });
});

function connect(topic) {
    oboe('/api/chat?topic=' + topic + "&client=" + client)
       .node('!.*', function( message ){
          if ($('#sender').val() == message.sender) {
            $('#Response').append("<div class='sender_messages'><span class='sender_messages'>" + message.sender + ": " + message.message + "</div>");
          } else {
            $('#Response').append("<div  class='other_messages'><span class='other_messages'>" + message.sender + ": " + message.message + "</span></div>");
          }
          $("#Response").animate({ scrollTop: $('#Response').prop("scrollHeight")}, 1000);
       })
       .fail(function() {
        connection = connect($("#group option:selected").text());
       } )
       .done(function(things){console.log("Stream Complete");});
}

function uuidv4() {
  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
    var r = Math.random() * 16 | 0, v = c == 'x' ? r : (r & 0x3 | 0x8);
    return v.toString(16);
  });
}
