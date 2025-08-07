/**
 * 
 */
console.log("board_list")

const pn = document.querySelectorAll(".pn");
const pn2 = document.getElementsByClassName("pn");
const searchForm = document.getElementById("searchFrom");
const pageNum = document.querySelector("#pageNum");

console.log(pn);
console.log(pn2);

pn.forEach(function (el) {
	el.addEventListener("click", function() {
		let n = this.getAttribute("data-pn");
		pageNum.value=n;
//		searchForm.submit();
		console.log(n)
	})
})

//for (const p of pn2) {
//	console.log(p)
//}