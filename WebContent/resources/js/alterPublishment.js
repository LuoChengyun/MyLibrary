function postPublishment(){
	let PublishmentForm=document.PublishmentForm;
	let publishName=PublishementForm.publishName.value;
	let publishLocal=PublishementForm.publishlocal.value;
	if(publishName===""){
        alert("出版社名不能为空");
        return false;
    }
	if(publishLocal===""){
        alert("出版社地址不能为空");
        return false;
    }
	 return true;
}