<?php
	require_once('../mk_function.php');
	
	$order_detail_id = $_GET['order_detail_id'];
	$new_status = "served";
	change_orderDetail_status($order_detail_id,$new_status);
	
	header("order_detail.php");
	

?>