function postManager(){
	let managerInformationForm=document.managerInformationForm;
	let userName=managerInformationForm.userName.value;
	let userAccount=managerInformationForm.userAccount.value;
	let userPassword=managerInformationForm.userPassword.value;
	if(userName===""){
        alert("姓名不能为空");
        return false;
    }
	if(userAccount===""){
        alert("账号不能为空");
        return false;
    }
	if(userPassword===""){
        alert("密码不能为空");
        return false;
    }
	return true;
}