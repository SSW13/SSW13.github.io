<?php
    session_start();
    require_once("catagory_function.php");
    
    $isEdit = false;
    if(isset( $_GET['action'] ) and  $_GET['action'] == "edit" )
    {
        $isEdit = true;
        $id = $_GET['id'];
        $values = getcatagoryByid($id);
	
        if(count($values) > 0)
        {
	    



		$id       		=   	$values[0]["id"] 	;
		$_SESSION["id"]       =  	$id    ;
	    

		$name       		=   	$values[0]["name"] 	;
		$_SESSION["name"]       =  	$name    ;
	    

            
        }
    }
?>
<html>
	<head>
		<title>MM's Bag [catagory]</title>
		<meta charset="UTF-8"/>
	</head>
	<body>
    <?php

      
	



	    
	    if(isset( $_GET['return'] ) and $_GET['return'] == 1)
	    {
		echo "<p style='color:red;'>กรุณากรอกชื่อสินค้าด้วยค่ะ</p>";
	    }
       

       
   ?>
		<h1>insert new catagory</h1>
                <?php
                    if($isEdit)
                    {
                        echo "<form action='catagory_update_action.php' method='POST'>";
                    }
                    else
                    {
                        echo "<form action='catagory_insert_action.php' method='POST'>";
                    }
                ?>
                    <ul>
                            <?php
                                if($isEdit)
                                {
                                    echo "<input type='hidden' name='id'         value= '$id;' />";
                                }
                            ?>
			    



				
				<li>name  <input type="text" name="name"         value= "<?php echo $_SESSION["name"];?>" /> </li>
                            

       
			    <li> <input type="submit" name="submit" value="SAVE" /> </li>
                    </ul>
                </form>
               
	<body>
</html>