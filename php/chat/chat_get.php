<?php
	$filename = "chat.txt";
	$content = file_get_contents($filename);
	$lines = explode("\r\n",$content);
	$data = array();
	for($i = 0 ; $i < count($lines)-1 ; $i++){
		$d = explode (":",$lines[$i]);
		$dd = array();
		array_push($dd, $d[0], $d[1]);
		array_push($data, $dd);
	}	
	$json = json_encode($data);
	
	
	echo $json;

?>