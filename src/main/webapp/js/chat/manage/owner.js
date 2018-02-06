$(function(){
		$('#start').click(function(){
			executeAjax("chater/start",{})
		});
	});
	function writeMsg(msg) {
		var sli ='<li> ' + msg + '</li>';
		$('#list').append(sli);
	}
	
	