function postType(){
	let TypeForm=document.TypeForm;
	let typeName=TypeForm.typeName.value;
	if(typeName===""){
        alert("分类名不能为空");
        return false;
    }
	 return true;
}