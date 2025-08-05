/**
 * 
 */
console.log("detail");

const frm = document.getElementById("frm")
const buttons = document.getElementsByClassName("action")

for(a of buttons) {
	a.addEventListener("click", function(e){
		let k = e.target;
		let kind = k.getAttribute("data-kind");
		console.log(kind)
		if(kind=='d') {
			if (confirm("삭제하시겠습니까?")) {
				frm.setAttribute("method", "POST");
				frm.setAttribute("action", "./delete");
			} 
		} else if(kind == 'u'){
			frm.setAttribute("method", "POST");
			frm.setAttribute("action", "./update");
		} else {
			frm.setAttribute("action", "./reply")
		}
		
		frm.submit();
		
	})
}
