<?php
	require_once("catagory_function.php");
	
	$data = getAllcatagory();
	echo json_encode($data,JSON_UNESCAPED_UNICODE);
?>