<?php
header("Content-Type","application/json");
$method = $_SERVER["REQUEST_METHOD"];
echo "----------------------\n".  $method . "\n----------------------\n";

switch($method){
    case 'GET': 
        echo "USTED VA CONSULTAR UN(OS) REGISTRO \n";

        try{ 
            $conexion = new PDO("mysql:host=localhost;dbname=gedee","root","");
        }catch(PDOException $e){
            echo $e->getMessage();
        }

        switch ($_GET['accion']){ 
            case "persona" :
                echo "-------------------\n Personas\n---------------\n";
                if (isset($_GET['name'])){
                    echo "Registro Unico\n";

                    $rs =  name($conexion);
                    if ($rs != null){
                        echo json_encode($rs, JSON_PRETTY_PRINT);
                    }else{
                        echo "-----------------Persona no encontrada! =(";
                    }
                }else{
                    
                    $pstm = $conexion->prepare('SELECT persona.name,personaje.lastname,curp,birthday,docente.numemp as docente , estudiante.matri AS estudiante FROM gedee.persona inner join docente on docente_numemp=docente.numemp inner join estudiante on  estudiante_matri = estudiante.matri ;');
                    $pstm->execute();
                    $rs = $pstm->fetchAll(PDO::FETCH_ASSOC); 
                    echo json_encode($rs, JSON_PRETTY_PRINT);
                }

                break;
            case "docente" :
                echo "-------------------\n Docentes \n---------------\n";
                $pstm = $conexion->prepare('SELECT * FROM gedee.docente;');
                $pstm->execute(); 
                $rs = $pstm->fetchAll(PDO::FETCH_ASSOC); 
                echo json_encode($rs, JSON_PRETTY_PRINT);

                break;
            case "estudiante" :
                echo "-------------------\n estudiantes\n---------------\n";
                $pstm = $conexion->prepare('SELECT * FROM gedee.estudiante;');
                $pstm->execute(); 
                $rs = $pstm->fetchAll(PDO::FETCH_ASSOC); 
                echo json_encode($rs, JSON_PRETTY_PRINT); 

                break;
                case "evaluacion" :
                echo "-------------------\n evaluaciones \n---------------\n";
                $pstm = $conexion->prepare('SELECT * FROM gedee.evaluacion;');
                $pstm->execute(); 
                $rs = $pstm->fetchAll(PDO::FETCH_ASSOC); 
                echo json_encode($rs, JSON_PRETTY_PRINT);

                break;
            default:
                echo "Dato no encontradoo! =(";
                break;
        }
        break;

    case 'POST':
        if($_GET['accion']=='persona'){
            $jsonData = json_decode(file_get_contents("php://input")); 
            try{
                $conn = new PDO("mysql:host=localhost;dbname=gedee","root","");
            }catch(PDOException $e){
                echo $e->getMessage();
            }

            if (!names($conn,$jsonData)){
                $query = $conn->prepare('INSERT INTO `gedee`.`persona` (`name`, `lastname`, `curp`, `birthday`, `docente_numemp`, `estudiante_matri`) VALUES (:name, :lastname, :curp :date, :docnu, :estma);');

                $query->bindParam(":name",$jsonData->name);
                $query->bindParam(":lastname",$jsonData->lastname);
                $query->bindParam(":curp",$jsonData->curp);
                $query->bindParam(":date",$jsonData->birthday);
                $query->bindParam(":docnu",$jsonData->docnu);
                $query->bindParam(":estma",$jsonData->estma);
                $result = $query->execute();
                if($result){
                    $_POST["error"] = false;
                    $_POST["message"] = "Persona registrado correctamente.";
                    $_POST["status"] = 200;
                }else{
                    $_POST["error"] = true;
                    $_POST["message"] = "Error al registrar";
                    $_POST["status"] = 400;
                }

                echo json_encode($_POST);
            }else{
                echo "-----------------Registro ya existente\n ";
            }

        }
        break;

    case 'PUT':
        echo "USTED VA ACTUALIZAR UN REGISTRO \n";

        if($_GET['accion']=='persona'){
            $jsonData = json_decode(file_get_contents("php://input")); // give dates in a object
            try{
                $conn = new PDO("mysql:host=localhost;dbname=gedee","root","");
            }catch(PDOException $e){
                echo $e->getMessage();
                if (!names($conn,$jsonData)){ 

                    $query = $conn->prepare('UPDATE `gedee`.`persona` SET `name` = :name, `lastname` = :lastname, `curp` = :curp, `birthday` = :date, `docente_numemp` = :docnu, `estudiante_matri` = :estma');

                    $query->bindParam(":name",$jsonData->name);
                    $query->bindParam(":lastname",$jsonData->lastname);
                    $query->bindParam(":curp",$jsonData->curp);
                    $query->bindParam(":date",$jsonData->birthday);
                    $query->bindParam(":docnu",$jsonData->docente_numemp);
                    $query->bindParam(":estma",$jsonData->estudiante_matri);
                    $result = $query->execute();
                    if($result){
                        $_POST["error"] = false;
                        $_POST["message"] = "Persona Actualizado  correctamente.";
                        $_POST["status"] = 200;
                    }else{
                        $_POST["error"] = true;
                        $_POST["message"] = "Error al actualizar";
                        $_POST["status"] = 400;
                    }

                    echo json_encode($_POST);
                }else{
                    echo "-----------------Registro ya existente\n ";
                }

            }else{
                echo "-----------------Persona no encontrado/a para actualizar! =(";
            }

        }

        break;

}

function name($conexion ){
    $pstm = $conexion->prepare('		SELECT persona.name,lastname,curp,birthday,docente.numemp as docente , estudiante.matri AS estudiante FROM gedee.persona inner join docente on docente_numemp=docente.numemp inner join estudiante on  estudiante_matri = estudiante.matri');
    $pstm->bindParam(":name",$_GET['name'] );
    $pstm->execute(); 
    $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
    return $rs;
}



function names($conn, $json ){
    $pstm = $conn->prepare('SELECT * FROM gedee.persona WHERE `name`  = :name AND `lastname` = :lastname ' AND `curp`  = :curp);
    $pstm->bindParam(":name",$json->name );
    $pstm->bindParam(":lastname",$json->lastname );
    $pstm->bindParam(":curp",$json->curp );
    $pstm->execute(); 
    $rs = $pstm->fetchAll(PDO::FETCH_ASSOC);
    return $rs != null ;
}