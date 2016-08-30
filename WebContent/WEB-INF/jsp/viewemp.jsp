 

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

 <!DOCTYPE html>
  <html>
  <head>
  
  
  
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.css">
        <script src="js/jquery.js"></script>
        <script src="js/jquery.dataTables.js" ></script>

      <script>
            function confirm_delete() 
            {
                return confirm("Are you sure want to delete?");
            }
     </script>
   
   <script>
        $(document).ready(function()
        		{
        	$('#example-1').DataTable();
        });
        
        </script>
        
   </head>
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2" id="example-1" >  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>ActionEdit</th><th>ActionDelete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
  		 <td>${emp.id}</td>  
   		<td>${emp.name}</td>  
   		<td>${emp.salary}</td>  
   		<td>${emp.designation}</td>  
   		<td><a href="editemp/${emp.id}">Edit</a></td>  
   		<td><a href="deleteemp/${emp.id}" onclick="return confirm_delete()">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a>
   
   
    </html>