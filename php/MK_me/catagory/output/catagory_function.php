<?php
    function createMysqlConnection()
    {
        $servername = "localhost";
        $username = "root";
        $password = "";
        $dbname = "mk";
        // Create connection
        $conn = new mysqli($servername, $username, $password, $dbname);
        // Check connection
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }
        $conn->query('SET NAMES UTF8;');
        return $conn;
    }
    function insertNewcatagory(
        $name
                )
    {
        $conn= createMysqlConnection();
        $sql = "INSERT INTO catagory
                (
        id, name
                 )
                VALUES (0,
                ?
                )";
        $stmt = $conn->prepare( $sql);
        $stmt-> bind_param("s",
                           
                $name
                           
                           );
        
        $isSuccess = false;
        if ($stmt->execute() === TRUE)
        {
            $isSuccess = true;
        }
        else
        {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
        $stmt->close();
        $conn->close();
        return $isSuccess;
    }
    
    
    function updatecatagory(
         $id, $name
                )
    {
        $conn= createMysqlConnection();
        
        $sql = "UPDATE catagory SET
                    name =      ?
                    WHERE id =  ?";
                    
        echo  $sql."<br/>";
        $stmt = $conn->prepare( $sql);
        $stmt-> bind_param("si", 
                            $name
                           
                           ,$id);
        
        $isSuccess = false;
        if ($stmt->execute()  === TRUE)
        {
            $isSuccess = true;
        } else
        {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
        $stmt->close();
        $conn->close();
        return $isSuccess;

    }
    function deletecatagory($id)
    {
        $conn= createMysqlConnection();
        
        $sql = "DELETE FROM catagory WHERE id = ?" ;
        $stmt = $conn->prepare( $sql);
        $stmt-> bind_param("i",$id);
        
        if ($stmt->execute() === TRUE) {
            echo "New record created successfully";
        } else {
            echo "Error: " . $sql . "<br>" . $conn->error;
        }
        $stmt->close();
        $conn->close();

    }
       
    function getAllcatagory()
    {
        $conn= createMysqlConnection();
        
        $sql = "SELECT *  FROM catagory ORDER BY id";
        $result = $conn->query($sql);
        
        $catagorys = array();
        if ($result->num_rows > 0)
        {
            // output data of each row
            while($row = $result->fetch_assoc())
            {
                $catagorys_row = array(
                            "id"=>$row["id"],
                                "name"=>$row["name"]
                                       );
                array_push($catagorys,$catagorys_row);
            }
        } else {
            echo "0 results";
        }
        
        $conn->close();
        return   $catagorys;
    }

    function getcatagoryByid($id)
    {
        $conn= createMysqlConnection();
        
        $sql = "SELECT *  FROM catagory WHERE id = ?"; //////////////////////
        
        $stmt = $conn->prepare( $sql);
        $stmt-> bind_param("i",$id);
        $stmt->execute();
        
        
        $stmt->bind_result(
                           
                            $id, $name
                          );
       
        
        $catagorys = array();
       
        // output data of each row
        while($stmt->fetch())
        {
            $catagorys_row = array(
                            "id"=>$id,
                                "name"=>$name
                                    
                                   );
            array_push($catagorys,$catagorys_row);
        }
       $stmt->close();
        $conn->close();
        return   $catagorys;
    }

//%' AND  '1' =  '1' UNION SELECT * , 1, 1, 1 FROM  `users`  WHERE '1' = '1
    function searchcatagory($name_search,$column_name_to_search)
    {
        $conn= createMysqlConnection();
        
        $sql = "SELECT *  FROM catagory WHERE `$column_name_to_search` LIKE ?   "; //////////////////////
        echo "$sql";
        $stmt = $conn->prepare( $sql);
        $stmt-> bind_param("s",$name_search);
        $stmt->execute();
        //$result = $stmt->get_result();
        
        $stmt->bind_result(
                           
                            $id, $name
                          );
       
        
        $catagorys = array();
       
        // output data of each row
        while($stmt->fetch())
        {
            $catagorys_row = array(
                            "id"=>$id,
                                "name"=>$name
                                    
                                   );
            array_push($catagorys,$catagorys_row);
        }
        $stmt->close();
        $conn->close();
        return   $catagorys;
    }
?>