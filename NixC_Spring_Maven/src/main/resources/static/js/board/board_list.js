/**
 * 
 */
console.log("board_list")

const pn = document.querySelectorAll(".pn");
const pn2 = document.getElementsByClassName("pn");
const searchForm = document.getElementById("searchForm");
const pageNum = document.querySelector("#pageNum");

console.log(pn);
console.log(pn2);

pn.forEach(function (el) {
	el.addEventListener("click", ()=> {
//		let n = this.getAttribute("data-pn");
		let n = el.getAttribute("data-pn");
		pageNum.value=n;
		console.log(n)
		searchForm.submit();
	})
})

//for (const p of pn2) {
//	console.log(p)
//}