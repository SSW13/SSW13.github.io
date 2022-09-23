<?php
	require_once('mk_function.php');
	
	$status = $_POST['status'];
	$order_id = $_POST['order_id'];
	
	$status = explode("|", $status);
	//print_r($status);
	
	$data = get_all_orderDetail_by_order_id($status,$order_id);
	$order_data = json_encode($data);
	echo $order_data;
	
?>