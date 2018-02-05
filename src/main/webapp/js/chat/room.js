$(function(){
		var ws = new WebSocket(socketURI);
		ws.onmessage = function(evt) {
			  writeMsg("Received Message: " + evt.data);
		};
		$('#btn').click(function(){
			ws.send($('#msg').val());
		});
		
	});
	function writeMsg(msg) {
		var sli ='<li> ' + msg + '</li>';
		$('#list').append(sli);
	}