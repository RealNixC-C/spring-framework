/**
 * 
 */
console.log("board_add.js")

const btnAdd = document.getElementById("btn_add");
const result = document.getElementById("result");
const fileSize = document.getElementById("result").getAttribute("data-file-count");
const deleteFile = document.querySelectorAll(".deleteFile");
let count = fileSize;

deleteFile.forEach((item)=>{
	item.addEventListener("click", ()=>{
		let params = new URLSearchParams();
		params.append("fileNo", 5)
		fetch(`./fileDelete`, {
			method : "post",
			body : params
		})
		.then(r=>r.json())
		.then(r=>{
			console.log(r);
		})
	})
})

btnAdd.addEventListener("click", ()=>{
//	const childNum = result.children.length;
//	if(childNum >= 5) {
//		alert("5개 초과!!");
//		return;
//	} 

	if(count >= 5) {
		alert("최대 5개 가능");
		return;
	} 
	count++;
	console.log(count);
		
// 방법1. innerHTML
// 이방식은 파일 추가 누를시 기존 등록된 파일이 날아감 - innerHTML은 지웠다가 다시 덮어씌우기때문
// result.innerHTML += `<div class="col-md-12 mb-3">
//							<input type="file" class="form-control" name="attaches">
//							<button type="button" class="btn_close">X</button>
//						</div>`;



// 방법2. createElement 생성 후 append	
	let div = document.createElement("div"); //<div></div>
	div.classList.add("mb-3", "col-md-12")                 //<div class="mb-3"></div>
	div.innerHTML=	`<input type="file" class="form-control" name="attaches"><button type="button" class="btn_close">X</button>`
	
//	let ch = document.createElement("input"); //<input>
//	ch.setAttribute("type", "file");		  //<input type="file">
//	ch.classList.add("form-control");		  //<input type="file" class="form-control">
//	ch.setAttribute("name", "attaches");	  //<input type="file" class="form-control" name="attaches">
//	
//	div.append(ch);							  //<div class="mb-3"><input type="file" class="form-control" name="attaches"></div>
//						
//	ch = document.createElement("button");	  //<button></button>
//	ch.classList.add("btn_close");			  //<button class="btn_close"></button>
//	ch.setAttribute("type", "button");		  //<button type="button" class="btn_close"></button>
//	ch.innerText="X";						  //<button type="button" class="btn_close">X</button>
//	
//	div.append(ch); 						  // `<div class="col-md-12 mb-3"><input type="file" class="form-control" 
// 												 name="attaches"><button type="button" class="btn_close">X</button></div>`;
						
	result.append(div);
});

result.addEventListener("click", (e)=>{
	if(e.target.classList.contains("btn_close")) {
		e.target.parentElement.remove();
	}
	count--;

});


//jQuery용
//$("#result").on("click", ".del", ()=>{
//	
//})