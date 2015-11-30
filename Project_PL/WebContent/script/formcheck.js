var idDuplicated = false;


function regModFormCheck(){
	if(!$("#adminId").val()){
		$("#adminId").focus();
		alert("ID는 필수 입력사항입니다.");
		return false;
	}
	if(!$("#adminPassword").val()){
		$("#adminPassword").focus();
		alert("패스워드는 필수 입력사항입니다.");
		return false;
	}
	if(!$("#adminName").val()){
		$("#adminName").focus();
		alert("이름은 필수 입력사항입니다.");
		return false;
	}
	if(!$("#adminPhone").val()){
		$("#adminPhone").focus();
		alert("전화번호는 필수 입력사항입니다.");
		return false;
	}
	return true;
}

function registerFormCheck(){
	if(idDuplicated){
		alert("사용할 수 없는 ID입니다.");
		return false;
	}
	return regModFormCheck();
}
