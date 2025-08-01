/**
 * 
 */
console.log("detail");

const frm = document.getElementById("frm")
// 방법 1
//const buttons = document.querySelectorAll(".action");
//
//list.forEach(function(a) {
//	
//	a.addEventListener("click", ()=>{
//		console.log("click")
//	})
//})

// 방법 2
const buttons = document.getElementsByClassName("action")

for(a of buttons) {
	a.addEventListener("click", function(e){
		let k = e.target;
		let kind = k.getAttribute("data-kind");
		console.log(kind)
		if(kind=='d') {
			frm.setAttribute("method", "POST");
			frm.setAttribute("action", "./delete");
		} else {
			frm.setAttribute("method", "GET");
			frm.setAttribute("action", "./update");
		}
		
		frm.submit();
		
	})
}
