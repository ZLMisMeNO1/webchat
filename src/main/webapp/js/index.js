$(function(){
	var ws = new WebSocket("ws://localhost:7397?request=sdfsd");

	ws.onopen = function(evt) { 
	  console.log("Connection open ..."); 
	  writeMsg("Connection open.");
	 
	};

	ws.onmessage = function(evt) {
	  writeMsg("Received Message: " + evt.data);
	};

	ws.onclose = function(evt) {
	  writeMsg("Connection closed.");
	};
	$('#btn').click(function(){
		ws.send($('#msg').val());
	});
});
function writeMsg(msg) {
	var sli ='<li> ' + msg + '</li>';
	$('#list').append(sli);
}