/**
 * 
 */
console.log("cartList.js");
const checkAll = document.getElementById("checkAll");
const checkBoxes = document.querySelectorAll(".ch");
const btnCartDelete = document.getElementById("btn_cart_delete");
const cartFrm = document.getElementById("cart_frm");
const btnSignUp = document.getElementById("btn_sign_up");

checkAll.addEventListener("click", ()=>{
	checkBoxes.forEach(function (checkBox){
		checkBox.checked = checkAll.checked;
	})
})

checkBoxes.forEach(function (checkBox){
	checkBox.addEventListener("click", ()=>{
		let flag = true;
		checkBoxes.forEach((c)=>{
			if(!c.checked) {
				flag = false;
			}
		})
		checkAll.checked=flag;
	})
})

btnCartDelete.addEventListener("click", ()=>{
	// 체크 된것들이 하나 이상인지 검증
	cartFrm.submit();
})


btnSignUp.addEventListener("click", ()=>{
	// 체크 된것들이 하나 이상인지 검증
	cartFrm.setAttribute("action", "/account/add");
	cartFrm.submit();
})







