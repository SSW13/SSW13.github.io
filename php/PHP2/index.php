<html>
	<head>
		<title>MM's Bag[Custtomers]</title>
		<meta charset="UTF-8"/>
		<script src="jquery.min.js"></script>
		<script>
		$(document).ready(function(){
			$("#button").click(function()
			{
				$("#data").load("backend.php", function(responseTxt, statusTxt, xhr){
					if(statusTxt == "success")
						alert("External content loaded successfully!");
					if(statusTxt == "error")
						alert("Error: " + xhr.status + ": " + xhr.statusText);
				});
			});
		});
		</script>
		
	</head>
	
	<body>
		<h1>เลือกเมนู</h1>
		
		<ol>
			<li><button id="button" >CLICK HERE!!</button></li>
			<li>
					<div id="data">
					
					</div>
			</li>
		</ol>
	</body>
	

</html>