<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
   <head>
   <meta charset="ISO-8859-1">
      <title>File Upload Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
   </head>
   
   <body>
   	  <h2>File Upload & Data Save Page</h2>
   	  
      <form   action ="uploadFile" method = "POST" enctype = "multipart/form-data" id="form-id" >
      <br /> <br />
         Please select a file to upload : 
         <input type = "file" name = "file" value = "Browse File" id="input-file" accept=".xls,.xlsx"  /> <br /> <br />
         Press here to upload the file :
         <input type = "submit" value = "upload" /> <br /> <br /> 
         
         <h4 style="color: green">${message}</h4> <br /> 
         
         Do you want to save excel data into database ? <a href="saveData"><b>Yes</b></a> &nbsp &nbsp <a href="/"><b>No</b></a>
         <br><br>
         <a href="viewFiles">View Files</a>
      </form>
      
      <script type="text/javascript">
    $(document).ready(function(){
    $("#input-file").on('change',function(){
    var file=$("#input-file").val();
  var  fileExtension = file.replace(/^.*\./, '');
  console.log(fileExtension);
if(fileExtension =='xls' || fileExtension =='xlsx') {
console.log(fileExtension);


}
    else{
    alert("upload only excel files!!!");
 $("#form-id").get(0).reset();
    }

    });
    });
      </script>
   </body>
</html>