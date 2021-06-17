function postAuthor(){
	let AuthorForm=document.AuthorForm;
	let authorName=AuthorForm.authorName.value;
	let authorSex=AuthorForm.authorSex.value;
	let authorIntroduct=AuthorForm.authorIntroduct.value;
	if(authorName===""){
        alert("作者名不能为空");
        return false;
    }
	if(authorSex===""){
        alert("作者性别不能为空");
        return false;
    }
	 return true;
}