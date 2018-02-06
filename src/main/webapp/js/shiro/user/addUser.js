
$(function(){
		$("#createBtn").click(function(){
			var username = $("#username").val();
			var password = $("#password").val();
			var roomId = $("#roomId").val();
			executeAjax("auth/usermanage/create",{
				data : {
					'username' : username,
					'password' : password,
					'roomId' : roomId
				}
			},function(data){
				console.log(data);
				if(data.success ) {
					parent.layer.closeAll();
				}
			})
		}) ;
})
