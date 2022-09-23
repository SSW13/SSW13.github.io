<html>
	<head>
		<script type="text/javascript">
			var vx =5, vy =5;
			function start(){
				window.setInterval("xxx()",30);
			}
			function xxx(){
				var ball = document.getElementById('ball');
				var rect_ball = ball.getBoundingClientRect();
				
				ball.style.top = rect_ball.top + vy;
				ball.style.left = rect_ball.left + vx;
				
				var w = window,
				d= document,
				e= d.documentElement.
				g= d.getElementsByTagName('body')[0],
				client_width = w.innerWidth || e.clientWidth || g.clientWidth,
				client_height = w.innerHeight || e.clientHeight || g.clientHeight;

				if(rect_ball.top < 0){
					ball.style.top = 1;
					vy *=-1;
				}
				if(rect_ball.top > client_height-110){
					ball.style.top = client_height-111;
					vy *=-1;
				}
				
				if(rect_ball.left < 0){
					ball.style.left = 1;
					vx *=-1;
				}
				if(rect_ball.left > client_width-110){
					ball.style.left = client_width-111;
					vx *=-1;
				}
			}
		</script>
		<style  type="text/css">
			.ball
			{
				background-color: red;
				width: 100px;
				height: 100px;
				border-radius: 50px;
				margin: 0px;
				position: absolute;
				top: 100px;
				left : 150px;
			}
		</style>
	</head>
	
	
	<body onload="start()">
	
		<div id="ball" class="ball">
		
		</div>
	</body>


</html>
