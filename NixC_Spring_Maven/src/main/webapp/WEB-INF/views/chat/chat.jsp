<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Chat Page</h1>
	<div>
		<input type="text" id="msg">	
		<button id="send">send</button>
	</div>	
	
	<script type="text/javascript">
		const send = document.getElementById("send");
		const msg = document.getElementById("msg");
		
		// WebSocket연결
		// 프로토골 : ws(websocket)
		const socket = new WebSocket("ws://192.168.1.3/chat")
	
		// 연결에 성공했을때 open
		socket.addEventListener("open", (e)=> {
			console.log("socket 연결 성공")
		})
		
		// 메세지를 수신했을때 message
		socket.addEventListener("message", (e)=> {
			console.log(e.data)
		})
		
		// 연결이 끊어졌을때 close
		socket.addEventListener("close", (e)=> {
			console.log("socket 연결 해제")
		})
		
		// 에러 발생시
		socket.addEventListener("error", (e)=> {
			console.log("에러 발생")
		})
		
		send.addEventListener("click", (e)=> {
			let m = msg.value;
			socket.send(m);	
		})
		
	</script>
</body>
</html>