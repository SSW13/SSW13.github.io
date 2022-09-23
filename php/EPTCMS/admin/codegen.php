<?php
	function createConnection(){
			$servername ="localhost";
			$username = "root";
			$password = "";
			$dbname = "ept_cms";
			
			
			$conn = new mysqli($servername, $username, $password, $dbname);
			// Check connection
			if ($conn->connect_error) {
			  die("Connection failed: " . $conn->connect_error);
			}
			return $conn;
	};
	
	function createTable($sql){

			$conn = createConnection();

			if ($conn->multi_query($sql) === TRUE) {
			 
			} else {
			  echo "Error: " . $sql . "<br>" . $conn->error;
			}

			$conn->close();
	};
	
	function showTableColumn($table_name){
			$conn = createConnection();
			
			$sql = "SHOW FULL COLUMNS FROM $table_name";
			$result = $conn->query($sql);
			
			$column = array();
			
			
			if ($result->num_rows > 0) {
			  // output data of each row
			  //Field	Type	Null	Key	Default	Extra
				while($row = $result->fetch_assoc()) 
				{	  $column_row = array(
					"Field"=>$row["Field"],
					"Type"=>$row["Type"],
					"Collation"=>$row["Collation"],
					"Null"=>$row["Null"],
					"Key"=>$row["Key"],
					"Default"=>$row["Default"],
					"Extra"=>$row["Extra"],
					"Privileges"=>$row["Privileges"],
					"Comment"=>$row["Comment"]);				  
					array_push($column, $column_row);
				}
			} else {
			  echo "0 results";
			}
			$conn->close();
			return $column;
	};
	
	function getTableNameFromFile($file_table){
		$lines = explode("\n",$file_table);
		$table_name_temp = explode(" ",$lines[0]);
		$table_name_temp = $table_name_temp[count($table_name_temp)-1];
		$table_name = substr($table_name_temp,1,strlen($table_name_temp)-4);
		return $table_name;
	};
	
	function clear(){
		if(is_dir('output')){
			array_map('unlink', glob("output/*.*"));
			rmdir('output');
		}
	}
	
	
	function generateFileIndex($table_name,$column){

		if(!mkdir('output/', 0777, true)){
			die('Failed to create folders....');
		}
		
		
		$toSearch = array("{{TABLE_NAME}}");
		$toReplace = array($table_name);
		
		$temp_content = file_get_contents("template/index.php");
		$file = fopen("output/index.php","w") or die("Unable to open file!");
		echo "aaa";
		$temp_content_out = str_replace($toSearch,$toReplace,$temp_content);
		echo "aaa";
		$txt = $temp_content_out;
		fwrite($file,$txt);
		fclose($file);
	};
	
	
	$file_table = file_get_contents("table.txt");
	//echo $file_table;
	$aa = file_get_contents("template/index.php");
	//echo $aa;
	$table_name = getTableNameFromFile($file_table);
	//echo $table_name;
	
	createTable($file_table);
	$column = showTableColumn($table_name);
	print_r($column);
	clear();
	generateFileIndex($table_name,$column);
	
?>