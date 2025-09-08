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
	
	<div>
		<button onclick="sendMessage()">메세지 보내기</button>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>

	
	<script type="text/javascript">
		let socket = new SockJS("/chat"); // 엔드포인트
		let stompClient = Stomp.over(socket);
		
		 stompClient.connect({}, function (frame) {
	        console.log("Connected: " + frame);

	        // 구독
	        stompClient.subscribe("/topic/public", function (message) {
	            let msg = JSON.parse(message.body);
	            console.log("Received: ", msg);
	        });
	    });
		 
		function sendMessage() {
			stompClient.send("/app/chat.send", {}, JSON.stringify({
				sender: "User1",
				content: "Hello World!"
			}));
		}
	</script>
	
	
<!-- <!-- 	<script type="text/javascript"> -->
<!-- // 		const send = document.getElementById("send"); -->
<!-- // 		const msg = document.getElementById("msg"); -->
		
<!-- // 		// WebSocket연결 -->
<!-- // 		// 프로토골 : ws(websocket) -->
<!-- // 		const socket = new WebSocket("ws://192.168.1.3/chat") -->
	
<!-- // 		// 연결에 성공했을때 open -->
<!-- // 		socket.addEventListener("open", (e)=> { -->
<!-- // 			console.log("socket 연결 성공") -->
<!-- // 		}) -->
		
<!-- // 		// 메세지를 수신했을때 message -->
<!-- // 		socket.addEventListener("message", (e)=> { -->
<!-- // 			console.log(e.data) -->
<!-- // 		}) -->
		
<!-- // 		// 연결이 끊어졌을때 close -->
<!-- // 		socket.addEventListener("close", (e)=> { -->
<!-- // 			console.log("socket 연결 해제") -->
<!-- // 		}) -->
		
<!-- // 		// 에러 발생시 -->
<!-- // 		socket.addEventListener("error", (e)=> { -->
<!-- // 			console.log("에러 발생") -->
<!-- // 		}) -->
		
<!-- // 		send.addEventListener("click", (e)=> { -->
<!-- // 			let m = msg.value; -->
<!-- // 			socket.send(m);	 -->
<!-- // 		}) -->
		
<!-- <!-- 	</script> -->
</body>
</html>