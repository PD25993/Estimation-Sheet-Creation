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
                html += '<label for="projectFeaturesComponents' + index + '.featureName" name="projectFeaturesComponents[' + index + '].featureName"> Feature Name : </label>';
               html += '<input type="text" id="projectFeaturesComponents' + index + '.featureName" name="projectFeaturesComponents[' + index + '].featureName" /><br>';   
               html += '<br><label for="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].itemName"> Item Name : </label>';
               html += '<div><input type="text" id="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents[' + index1 + '].itemName" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].itemName" />';
               html += '<label>Type</label><select id="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents[' + index1 + '].itemType" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].itemType" >';
               html += '<option>Service</option>';
               html += '<option>UI</option>';
               html += '<option>Batch job</option>';
               html += '<option>Testing</option></select>';
               html += '<label>New/Modify</label><select id="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents[' + index1 + '].newOrModify" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].newOrModify" >';
               html += '<option>New/Modify</option>';
               html += '<option>New</option>';
               html += '<option>Modify</option> </select>';
               html += '<label>Component Complexity</label><select id="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents[' + index1 + '].componentComplexityForItem" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].componentComplexityForItem" >';
               html += '<option>Simple</option>';
				html += '<option>Medium</option>';
				html += '<option>Complex</option>';
				html += '<option>Very Complex</option></select> <br> <br> <br> ';
				html += '<label>Degree of Change</label><select  id="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents[' + index1 + '].degreeOfChangesForItem" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].degreeOfChangesForItem" >';
				html += '<option>Simple</option>';
				html += '<option>Medium</option>';
				html += '<option>Complex</option>';
				html += '<option>Very Complex</option></select>'; 
				html += '<label>Technology</label><select  id="projectFeaturesComponents.projectFeaturesComponents' + index + '.devComponents[' + index1 + '].technologyForItem" name="projectFeaturesComponents[' + index + '].devComponents[' + index1 + '].technologyForItem" >';
				html += '<option>Tuxedo</option>';
				html += '<option>Java</option>';
				html += '<option>Centura</option>';
				html += '<option>Data Power</option>';
				html += '<option>IIB</option>';
				html += '<option>ODM</option>';
				html += '<option>BPM</option>';
				html += '<option>Mainframe</option>';
				html += '<option>Abinitio</option></select></div>';
                
                html += '<button id="addItem" class ="add_field_button">Add New Item</button>';
                
				html += '<div class="input_fields_wrap"><hr style="height:15px;border-width:0;color:green;background-color:green">';
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
                var index_i=0;
                var indexForFeatureItem;
                
                indexForFeatureItem=index-1;
                
                
                $(add_button).off("click").on("click",function(e){ //on add input button click
                    e.preventDefault();
                $(this).after(function(){
                    if(x < max_fields){ //max input box allowed
                    	 x++; //text box increment	
                        var addRows='<br><br><div><hr style="height:8px;border-width:0;color:gray;background-color:gray"><tr>'
                        addRows += '<br><label for="projectFeaturesComponents.projectFeaturesComponents[' + indexForFeatureItem + '].devComponents" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].itemName"> Item Name From additem:'+(x+1)+' </label>';
                        addRows += '<div><input type="text" id="projectFeaturesComponents.projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].itemName" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].itemName" />';
                        addRows += '<label>Type</label><select id="projectFeaturesComponents.projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].itemType" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].itemType" >';
                        addRows += '<option>Service</option>';
                        addRows += '<option>UI</option>';
                        addRows += '<option>Batch job</option>';
                        addRows += '<option>Testing</option></select>';
                        addRows += '<label>New/Modify</label><select id="projectFeaturesComponents.projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].newOrModify" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].newOrModify" >';
                        addRows+= '<option>New/Modify</option>';
                        addRows += '<option>New</option>';
                        addRows += '<option>Modify</option> </select>';
                        addRows += '<label>Component Complexity</label><select id="projectFeaturesComponents.projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].componentComplexityForItem" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].componentComplexityForItem" >';
                        addRows += '<option>Simple</option>';
                        addRows += '<option>Medium</option>';
                        addRows += '<option>Complex</option>';
                        addRows += '<option>Very Complex</option></select> <br> <br> <br> ';
                        addRows += '<label>Degree of Change</label><select  id="projectFeaturesComponents.projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].degreeOfChangesForItem" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].degreeOfChangesForItem" >';
                        addRows += '<option>Simple</option>';
                        addRows += '<option>Medium</option>';
                        addRows += '<option>Complex</option>';
                        addRows += '<option>Very Complex</option></select>'; 
                        addRows += '<label>Technology</label><select  id="projectFeaturesComponents.projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].technologyForItem" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].technologyForItem" >';
                        addRows += '<option>Tuxedo</option>';
                        addRows += '<option>Java</option>';
                        addRows += '<option>Centura</option>';
                        addRows += '<option>Data Power</option>';
                        addRows += '<option>IIB</option>';
                        addRows += '<option>ODM</option>';
                        addRows += '<option>BPM</option>';
                        addRows += '<option>Mainframe</option>';
                        addRows += '<option>Abinitio</option></select></div>';
                        addRows+='<tr><td><a href="#" class="remove_field">Remove</a></td></tr></div>';
                       
                    			
                      // $(wrapper).append(addRows); //add input box
                      return addRows;
                    }
                });
                });

                $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
                    e.preventDefault(); $(this).parent('div').remove(); x--;
                    console.log("remove clicked");
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

	</c:choose>

	<form:form action="/addProject" modelAttribute="projectDetails"
		method="POST" name="projectDetails">
		<div id="cfd" class="tabcontent">
			<table>
				<tr>
					<td><form:label path="projectName">Project Name</form:label></td>

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
					<td>
						<button id="add" type="button" id="submitBtn">Add New
							Feature</button>

					</td>

				</tr>
				<tr>
			</table>
			<div>
				<button type="submit">OK</button>
			</div>
		</div>
	</form:form>


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