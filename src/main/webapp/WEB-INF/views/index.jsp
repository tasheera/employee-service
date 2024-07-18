<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.*" %>

<%@ page import="java.util.List" %>
<%@ page import="com.hsenid.employeeservice.entity.Employee" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee details</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script>
        function submitForm() {
            var eid=document.getElementById("eid").value;
            var name = document.getElementById("name").value;
            var nic = document.getElementById("nic").value;
            var email = document.getElementById("email").value;
            var jdate=document.getElementById("jdate").value;
            var dep=document.getElementById("dep").value;

            if(eid ==="" || name===""){
                alert("Please fill details");
                return;
            }

            var userDetails = {
                id:eid,
                name: name,
                nic:nic,
                email: email,
                joinDate:jdate,
                departmentId:dep
            };

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/addemployee", true); // add api call
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    alert("User details submitted successfully!");
                    location.reload();
                }
            };
            xhr.send(JSON.stringify(userDetails));
            alert("Loading");
            location.reload();

        }

        function deleteEmployee(employeeId) {
            if (confirm("Are you sure you want to delete this employee?")) {
                $.ajax({
                    url: '/deleteemployee/' + employeeId,
                    type: 'DELETE',
                    success: function(result) {
                        alert("Delete successfully");
                        location.reload();
                    },
                    error: function(err) {
                        alert('Error deleting employee: ' + err.responseText);
                    }
                });
            }
        }

        function fillForm(employeeId) {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "getallemployee/id/" +  + employeeId, true); // get api call
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var userDetails = JSON.parse(xhr.responseText);
                    document.getElementById("eid").value=userDetails.id;
                    document.getElementById("name").value = userDetails.name;
                    document.getElementById("email").value = userDetails.email;
                    document.getElementById("nic").value=userDetails.nic;
                    document.getElementById("jdate").value=userDetails.joinDate;
                    document.getElementById("dep").value=userDetails.departmentId

                }
            };
            xhr.send();
        }
    </script>

    <style>
        th{
            padding: 3px;
        }
    </style>

</head>
<body >
<h1 class="text-primary text-center">Employee Details</h1>

<div class="row" style="margin-left: 5px">
    <h2>Add/Update employee</h2>
    <div class="col-sm-4">
        <form>

            <div align="left">
                <label class="form-label"> Employee ID</label>
                <input type="text" class="form-control" placeholder="id" name="eid" id="eid" required>
            </div>
            <div align="left">
                <label class="form-label"> Employee name</label>
                <input type="text" class="form-control" placeholder="name" name="name" id="name" required>
            </div>


            <div align="left">
                <label class="form-label">Nic</label>
                <input type="text" class="form-control" placeholder="nic" name="nic" id="nic" required>
            </div>

            <div align="left">
                <label class="form-label">email</label>
                <input type="text" class="form-control" placeholder="email" name="email" id="email" required>
            </div>

            <div align="left">
                <label class="form-label"> Join Date</label>
                <input type="text" class="form-control" placeholder="jdate" name="jdate" id="jdate" required>
            </div>

            <div align="left">
                <label class="form-label"> Department</label>
                <input type="text" class="form-control" placeholder="department" name="dep" id="dep" required>
            </div>

            <div align="right">
                <input type="submit" id="submit" value="submit" name="submit" class="btn btn-success" onclick="submitForm()">
                <input type="reset" id="reset" value="reset" name="reset" class="btn btn-warning">
            </div>



        </form>
    </div>

    <div class="col-sm-8">

        <div class="panel-body">
            <table border="1">
                <tr>
                    <th>Employee ID</th>
                    <th>Name</th>
                    <th>NIC</th>
                    <th>Email</th>
                    <th>Join Date</th>
                    <th>Department ID</th>

                </tr>

                <% for (Employee employee : (List<Employee>) request.getAttribute("employees")) { %>
                <tr>
                    <td class="text-center"><%= employee.getId() %></td>
                    <td><%= employee.getName() %></td>
                    <td><%= employee.getNic() %></td>
                    <td><%= employee.getEmail() %></td>
                    <td><%= employee.getJoinDate() %></td>
                    <td class="text-center"><%= employee.getDepartmentId() %></td>

                    <td>
                        <div style="padding: 2px">
                        <button onclick="deleteEmployee(<%= employee.getId() %>)" class="btn btn-danger" style="padding: 2px">Delete</button>
                        <button onclick="fillForm(<%= employee.getId() %>)" class="btn btn-warning" style="padding: 2px">Update</button>
                        </div>

                    </td>


                </tr>
                <% } %>
            </table>
        </div>

    </div>
</div>
</body>
</html>