/**
 * 
 */
console.log("cartList.js");

const checkAll = document.getElementById("checkAll");

checkAll.addEventListener("click", ()=>{
	
	const checkBoxes = document.querySelectorAll(".ch");
	
	checkBoxes.forEach(function (checkBox){
		
		let isChecked = checkBox.checked;
		if(!isChecked) {
			checkBox.checked = true;
		} else {
			checkBox.checked = false;
		}
		
		
	})
	
})