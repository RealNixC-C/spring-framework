/**
 * 
 */
console.log("product.js");

const frm = document.getElementById("frm")
const buttons = document.querySelectorAll(".action");
const cart = document.getElementById("cart");
const signUp = document.getElementById("sign_up");

buttons.forEach(function (b){
	b.addEventListener("click", function(e){
		console.log("클릭됨")
		let k = e.target;
		let kind = k.getAttribute("data-kind");
		console.log(kind);
		
		if(kind == 'd') {
			if(confirm("삭제하시겠습니까?")) {
				frm.setAttribute("method", "POST");
				frm.setAttribute("action", "./delete");
			} else {
				return;
			}
		} else if(kind == 'u') {
			frm.setAttribute("method", "GET");
			frm.setAttribute("action", "./update");
		}
		
		frm.submit();
	})
})


cart.addEventListener('click', ()=>{
	
	let productNo = cart.getAttribute('data-product-no');
	let params = new URLSearchParams;
	params.append("productNo", productNo)
	
	fetch("/member/addCart", {
		method : 'post',
		body : params
	})
	.then(r =>r.json())
	.then(r => {
		if(confirm(`장바구니로 이동하시겠습니까?`)) {
			location.href="./cartList";
		}
	})
	.catch(e=>{
		alert("등록 실패")
	})
})

signUp.addEventListener("click", ()=> {
	if(confirm("상품에 가입하시겠습니까?")) {
		const productNo = signUp.getAttribute("data-product-no")		
		location.href="/account/add?productNo=" + productNo;
	}	
})









