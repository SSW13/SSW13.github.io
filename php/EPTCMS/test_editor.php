<?php
	if(isset($_POST['save'])){
			$value=$_POST['editor1'];
	}
?>


<html>
	<head>
		<title>CKEditor Sample</title>
		<meta charset="UTF-8"/>
		<script src="ckeditor.js"></script>
		<link rel="stylesheet" href="css/samples.css">
	
	</head>
	
	<body>
		<?php
			if(isset($_POST['save'])){
				echo $value;
			}
		?>

		<form action="test_editor.php" method="POST">
			<textarea class="ckeditor" name="editor1"></textarea>
			<input type="submit" value="SAVE" name="save"/>
		</form>
	
	</body>


</html>