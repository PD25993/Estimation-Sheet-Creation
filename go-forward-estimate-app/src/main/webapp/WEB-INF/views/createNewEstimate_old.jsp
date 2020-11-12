<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Estimate</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
.header {
	padding: 6px;
	text-align: left;
	background: #2a9df4;
	color: white;
	font-size: 18px;
}

body {
	font-family: Arial;
}

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}

.border1 {
	border: 2px solid black;
	border-radius: 12px;
}

.border2 {
	border: 2px solid black;
	border-radius: 12px;
	width: 75%;
}

#show1 {
	display: none;
}

#show2 {
	display: none;
}
</style>
<script type="text/javascript">


    $(function() {

        // Start indexing at the size of the current list
        var index = ${fn:length(projectDetails.projectFeaturesComponents)};
        var index1 = 0;
        // Add a new Feature
        $("#add").off("click").on("click", function() {
            $(this).before(function() {
                var html = '<div id="projectFeaturesComponents' + index + '.wrapper" class="hidden">';                    
               html += '<input type="text" id="projectFeaturesComponents' + index + '.featureName" name="projectFeaturesComponents[' + index + '].featureName" /><br>';   
                html += '<label for="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].itemName"> Item Name : </label>';
                html += '<div class="input_fields_wrap">';
                html += '<button id="addItem" class ="add_field_button">Add New Item</button>';
                html += '<div><input type="text" id="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].itemName" /></div>';
                
                html += '</div>';
                
                
                // html += '</div>'; 
                /* html += '<input type="hidden" id="projectFeaturesComponents' + index + '.remove" name="projectFeaturesComponents[' + index + '].remove" value="0" />'; */
                /* html += '<a href="#" class="projectFeaturesComponents.remove" data-index="' + index + '">remove</a>'; */                    
                html += "</div>";
                return html;
            });
            
            var clicked="false"
            	$('#add')
            	    .on(
            	        'click',
            	        function() {
            	    console.log("user had pressed the button");
            	    clicked=true;
            	    });
            
            $(document).ready(function() {
                var max_fields      = 10; //maximum input boxes allowed
                var wrapper         = $(".input_fields_wrap"); //Fields wrapper
                var add_button      = $(".add_field_button"); //Add button ID

                var x = 0; //initlal text box count
                
                var indexForFeatureItem;
                if(clicked == true ){
                	indexForFeatureItem=index
                }else{
                	indexForFeatureItem=1
                }
                
                
                $(add_button).click(function(e){ //on add input button click
                    e.preventDefault();
                    if(x < max_fields){ //max input box allowed
                        x++; //text box increment
                        $(wrapper).append('<div><input type="text" id="projectFeaturesComponents.projectFeaturesComponents' + indexForFeatureItem + '.devComponents" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].itemName" /><a href="#" class="remove_field">Remove</a></div>'); //add input box
                    }
                });

                $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
                    e.preventDefault(); $(this).parent('div').remove(); x--;
                })
            });
            $("#projectFeaturesComponents" + index + "\\.wrapper").show();
            index++;
            //index1++;
            return false;
        });

        // Remove a Feature
        /* $("a.projectFeaturesComponents\\.remove").off("click").on("click", function() {
            var index2remove = $(this).data("index");
            $("#projectFeaturesComponents" + index2remove + "\\.wrapper").hide();
            $("#projectFeaturesComponents" + index2remove + "\\.remove").val("1");
            return false;
        }); */

    });
    
    </script>
   <script type='text/javascript'>
            $(function () {
                $('#searchInput').keyup(function () {
                     if ($(this).val() == '') {
                        //Check to see if there is any text entered
                        // If there is no text within the input then enable the button
                        $('.enableOnInput').prop('disabled', true);
                    } else {
                        //If there is text in the input, then disable the button
                        $('.enableOnInput').prop('disabled', false);
                    } 
                    
                	
                });
            }); 
        </script> 
     
      
</head>
<body>
	<div class="header">
		<h3>${welcomeMessage}</h3>
		<h2 style="text-align: right; bottom-margin: 3px;">Create New
			Estimate</h2>
		<h2 style="text-align: right; bottom-margin: 3px;">Welcome
			**User**</h2>
	</div>
	<div class="tab">
		<button class="tablinks" onclick="openTab(event, 'cfd')">Component
			& Feature Details</button>
		<button class="tablinks" onclick="openTab(event, 'pd')">Project
			Details</button>
	</div>
	<c:choose>
		<c:when test="${type eq 'create'}">
			<c:set var="actionUrl" value="/addProject" />
		</c:when>
		<%-- <c:otherwise><c:set var="actionUrl" value="employer/update/${employer.id}" /></c:otherwise> --%>
	</c:choose>

	<form:form action="/addProject" modelAttribute="projectDetails"
		method="POST" name="projectDetails">
		<div id="cfd" class="tabcontent">
			<table>
				<tr>
					<td><form:label path="projectName">Project Name</form:label></td>
					<%--  <td><form:input path="firstname" /><form:errors path="firstname" /></td> --%>
					<td><form:input path="projectName" /></td>

					<p align="right">
						<button>Instructions</button>
						<button>Guidelines</button>
					</p>
	
				</tr>
                
				<tr>
					<td><h3>Project Feature</h3></td>
					</tr>
					<tr>
					<td><div></div></td>
					 </tr>
					<tr>
					<td>Feature Name</td>

					<td><%-- <c:forEach items="${projectDetails.projectFeaturesComponents}" var ="outer"
							varStatus="loop"> --%>
							<%--  <form:input path="projectFeaturesComponents[${loop.index}].featureName" name="searchQuery" id="searchInput"/>  --%>
							
							<%-- <c:forEach items="${projectDetails.projectFeaturesComponents[loop.index].devComponents}"
							varStatus="devLoop" var="inner">
							
							<form:input path="projectFeaturesComponents[${loop.index}].devComponents.[${devLoop.index}].itemName"/>
							<button id ="addItem">Show</button> 
							</c:forEach> --%>
							
						<%-- </c:forEach> --%>
						<button id="add" type="button" id="submitBtn" >Add New Feature</button>
						
						</td>

				</tr>
				<tr>
				<%-- c:forEach items="${projectDetails.projectFeaturesComponents.devComponents}"
							varStatus="devLoop">
							<c:choose>
								<c:when
									test="${devComponents[devLoop.index].remove eq 1}">
									<div id="${devLoop.index}.wrapper" class="hidden">
								</c:when>
								<c:otherwise>
									<div id="devComponents${devLoop.index}.wrapper">
								</c:otherwise>
							</c:choose>
							<form:input path="devComponents[${devLoop.index}].itemName"/>
							</c:forEach>
							<button id="add" type="button">Add New Item</button></td>
				</tr> --%>
			</table>
           <div> 
			<button type="submit">OK</button>
			</div>
		</div>
	</form:form>

	<!-- <label>Feature: </label>
	<input type="text">
	<div align="right">
		<a onclick="view2()"><button>Add New Feature</button></a>
	</div> -->
	<!-- <br>
	<div class="border1" id="show2">
		<h3>Development Component</h3>
		<hr>
		<div align="right">
			<a onclick="view1()"><button>Add New Item</button></a>
		</div>
		<div class="border2" id="show1">
			<br> <label>Item Name:</label><input type="text">
			<div align="right">
				<button>Save Item</button>
			</div>
			<label>Type</label><select><option>**Select**</option>
				<option>type2</option>
				<option>type3</option>
				<option>type4</option></select> <label>Degree of Change</label><select><option>**Select**</option>
				<option>type2</option>
				<option>type3</option>
				<option>type4</option></select> <label>Component Complexity</label><select><option>**Select**</option>
				<option>type2</option>
				<option>type3</option>
				<option>type4</option></select> <br> <br> <br> <label>New/Modify</label><select><option>**Select**</option>
				<option>type2</option>
				<option>type3</option>
				<option>type4</option></select> <label>Technology</label><select><option>**Select**</option>
				<option>type2</option>
				<option>type3</option>
				<option>type4</option></select> <br> <br>
		</div>
		<br>
		<h3>QA Component</h3>
		<hr>
		<br> <label>Testdata Complexity</label><select><option>**Select**</option>
			<option>type2</option>
			<option>type3</option>
			<option>type4</option></select> <label>Requirement Complexity</label><select><option>**Select**</option>
			<option>type2</option>
			<option>type3</option>
			<option>type4</option></select> <br> <br> <br> <label>Validation
			Complexity</label><select><option>**Select**</option>
			<option>type2</option>
			<option>type3</option>
			<option>type4</option></select> <label>Validation Point</label><select><option>**Select**</option>
			<option>type2</option>
			<option>type3</option>
			<option>type4</option></select>
		<div align="right">
			<button>Save Feature</button>
		</div>
		<br> <br>
	</div>
	<br>-->
	<div align="right">
		<p>
			<button>Generate Estimate</button>
			<button>Download</button>
			<button>Submit for Review</button>
		</p>
		<p>App Version</p>
	</div>
	</div>

	<div id="pd" class="tabcontent">
		<p>**Write your Code**</p>
	</div>


	<script>
		function openTab(evt, tabName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(tabName).style.display = "block";
			evt.currentTarget.className += " active";
		}
		function view1() {
			document.getElementById("show1").setAttribute('style',
					'display:block');
		}
		function view2() {
			document.getElementById("show2").setAttribute('style',
					'display:block');
		}
	</script>
</body>
</html>