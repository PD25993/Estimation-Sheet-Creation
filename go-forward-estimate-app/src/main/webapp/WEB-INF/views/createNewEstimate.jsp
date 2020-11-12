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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
	</script>

<style>
input[type=number] {
  -moz-appearance: textfield;
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
.header {
  padding: 6px;
  text-align: center;
  background: #1abc9c;
  color: white;
  font-size: 18px;
  height: 115px;
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

ul.tab {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Float the list items side by side */
ul.tab li {float: left;}

/* Style the links inside the list items */
ul.tab li a {
    display: inline-block;
    color: black;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of links on hover */
ul.tab li a:hover {
    background-color: #ddd;
}

/* Create an active/current tablink class */
ul.tab li a:focus, .active {
    background-color: #ccc;
}

/* /* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    -webkit-animation: fadeEffect 1s;
    animation: fadeEffect 1s;
} */

</style>
<script type="text/javascript">


$(function() {

    // Start indexing at the size of the current list
    var index = ${fn:length(projectDetails.projectFeaturesComponents)};
    var index1 = 0;
    // Add a new Feature
    $("#add").off("click").on("click", function() {
        $(this).before(function() {
            var html = '<div id="projectFeaturesComponents' + index + '.wrapper" class="hidden"><hr style="height:15px;border-width:0;color:green;background-color:green">';   
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
            
			html += '<div class="input_fields_wrap">';
			 html += '<button id="addItem" class ="add_field_button">Add New Item</button></div>';
           
            html +='<hr style="height:8px;border-width:0;color:pink;background-color:pink">';  
            html+= '<p>QA Component:</p>';
            html+='<label>Test Data Complexity:</label>';
            html+='<select id="projectFeaturesComponents.projectFeaturesComponents' + index + '.qaComponents[' + index1 + '].testDataComplexity" name="projectFeaturesComponents[' + index + '].qaComponents[' + index1 + '].testDataComplexity" >';
            html+='<option>Simple</option>';
            html+='<option>Medium</option>';
            html+='<option>Complex</option>';
            html+='<option>Very Complex</option></select>';
            html+='<label>Requirement Complexity:</label>';
            html+='<select id="projectFeaturesComponents.projectFeaturesComponents' + index + '.qaComponents[' + index1 + '].requirementComplexity" name="projectFeaturesComponents[' + index + '].qaComponents[' + index1 + '].requirementComplexity" >';
            html+='<option>Simple</option>';
            html+='<option>Medium</option>';
            html+='<option>Complex</option>';
            html+='<option>Very Complex</option></select>';
            html+='<br><label>Validation Complexity:</label>';
            html+='<select id="projectFeaturesComponents.projectFeaturesComponents' + index + '.qaComponents[' + index1 + '].validationComponent" name="projectFeaturesComponents[' + index + '].qaComponents[' + index1 + '].validationComponent" >';
            html+='<option>Simple</option>';
            html+='<option>Medium</option>';
            html+='<option>Complex</option>';
            html+='<option>Very Complex</option></select>';
            html+='<label>Validation Point:</label>';
            html+='<select id="projectFeaturesComponents.projectFeaturesComponents' + index + '.qaComponents[' + index1 + '].validationPoints" name="projectFeaturesComponents[' + index + '].qaComponents[' + index1 + '].validationPoints" >';
            html+='<option value="1"><2</option>';
            html+='<option value="2">3-5</option>';
            html+='<option value="3">5-10</option>';
            html+='<option value="4">>10</option></select>';
            html+='<br><br/>';
            
            
            html += '<div class="input_qa_wrap">';
            html += '<button id="addQA" class ="addQA">Add New QA Component</button></div><br/><br/>';
            
                            
            
            html+='<tr><td><a href="#" class="remove_feature">Remove Feature</a></td></tr></div>'; 
            
            return html;
        });
        console.log("index1: "+index1+",index: "+index);
        
        $('.hidden').on("click",".remove_feature", function(e){ //user click on remove text
            e.preventDefault();                 
        	$(this).parent('div').remove();
        	index1--;
            console.log("remove clicked");
           
        })
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

            var x=0; //initlal text box count
            var index_i=0;
            var indexForFeatureItem;
            indexForFeatureItem=index-1;
            
            
            $(add_button).off("click").on("click",function(e){ //on add input button click
                e.preventDefault();
            $(this).after(function(){
                if(x < max_fields){ //max input box allowed
                	 x++; //text box increment	
                    var addRows='<div><hr style="height:8px;border-width:0;color:gray;background-color:gray"><tr>'
                    addRows += '<br><label for="projectFeaturesComponents.projectFeaturesComponents[' + indexForFeatureItem + '].devComponents" name="projectFeaturesComponents[' + indexForFeatureItem + '].devComponents[' + x + '].itemName"> Item Name </label>';
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
                e.preventDefault();                 
            	$(this).parent('div').remove();
            	x--;
                console.log("remove clicked");
               
            })
        });
        //here to add
        $(document).ready(function() {
            var max_fields      = 10; //maximum input boxes allowed
            var wrapper         = $(".input_qa_wrap"); //Fields wrapper
            var add_button      = $(".addQA"); //Add button ID

            var y=0; //initlal text box count
            var index_i=0;
            var indexForFeatureItem;
            indexForFeatureItem=index-1;
            
            
            $(add_button).off("click").on("click",function(e){ //on add input button click
                e.preventDefault();
            $(this).after(function(){
                if(y < max_fields){ //max input box allowed
                	 y++; //text box increment	
                    var addRow='<div><hr style="height:8px;border-width:0;color:pink;background-color:pink"><tr>'
                    	addRow+= '<p>QA Component:</p>';
                    	addRow+='<label>Test Data Complexity:</label>';
                    	addRow+='<select id="projectFeaturesComponents.projectFeaturesComponents' + indexForFeatureItem + '.qaComponents[' + y + '].testDataComplexity" name="projectFeaturesComponents[' + indexForFeatureItem + '].qaComponents[' + y + '].testDataComplexity" >';
                    	addRow+='<option>Simple</option>';
                    	addRow+='<option>Medium</option>';
                    	addRow+='<option>Complex</option>';
                    	addRow+='<option>Very Complex</option></select>';
                    	addRow+='<label>Requirement Complexity:</label>';
                    	addRow+='<select id="projectFeaturesComponents.projectFeaturesComponents' + indexForFeatureItem + '.qaComponents[' + y + '].requirementComplexity" name="projectFeaturesComponents[' + indexForFeatureItem + '].qaComponents[' + y + '].requirementComplexity" >';
                    	addRow+='<option>Simple</option>';
                    	addRow+='<option>Medium</option>';
                    	addRow+='<option>Complex</option>';
                    	addRow+='<option>Very Complex</option></select>';
                    	addRow+='<br><label>Validation Complexity:</label>';
                    	addRow+='<select id="projectFeaturesComponents.projectFeaturesComponents' + indexForFeatureItem + '.qaComponents[' + y + '].validationComponent" name="projectFeaturesComponents[' + indexForFeatureItem + '].qaComponents[' + y + '].validationComponent" >';
                    	addRow+='<option>Simple</option>';
                    	addRow+='<option>Medium</option>';
                    	addRow+='<option>Complex</option>';
                    	addRow+='<option>Very Complex</option></select>';
                    	addRow+='<label>Validation Point:</label>';
                    	addRow+='<select id="projectFeaturesComponents.projectFeaturesComponents' + indexForFeatureItem + '.qaComponents[' + y + '].validationPoints" name="projectFeaturesComponents[' + indexForFeatureItem + '].qaComponents[' + y + '].validationPoints" >';
                    	addRow+='<option value="1"><2</option>';
                    	addRow+='<option value="2">3-5</option>';
                    	addRow+='<option value="3">5-10</option>';
                    	addRow+='<option value="4">>10</option></select>';
                    	addRow+='<br/><br/>';
                    	addRow+='<tr><td><a href="#" class="remove_field">Remove</a></td></tr></div>';
                			
                  // $(wrapper).append(addRows); //add input box
                  return addRow;
                }
            });
            });

            $(wrapper).on("click",".remove_field", function(e){ //user click on remove text
                e.preventDefault();                 
            	$(this).parent('div').remove();
            	y--;
                console.log("remove clicked");
               
            })
        });
        
        $("#projectFeaturesComponents" + index + "\\.wrapper").show();
        index++;
        
        //index1++;
        return false;
    });


    // Remove a Feature
     

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

	<ul class="tab">
		<li><a href="#" class="tablinks active"
			onclick="openTab(event, 'cfd')">Component & Feature Details</a></li>
		<li><a href="#" class="tablinks"
			onclick="openTab(event, 'pd')">Project Details</a></li>
	</ul>
	<c:choose>
		<c:when test="${type eq 'create'}">
			<c:set var="actionUrl" value="/addProject" />
		</c:when>

	</c:choose>

	<form:form action="/addProject" modelAttribute="projectDetails"
		method="POST" name="projectDetails">
		<div id="cfd" class="tabcontent" style="display:block">
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
		</div>
	
	


	<div id="pd" class="tabcontent">
		<div class="myDiv">
  <p class="myp"><b>NFRS</b></p>

  <label for="value1">What is the data volume under Consideration &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
  <input type="text"   name="value1" size="4"><br><br>
  <label for="pin">Are there any disaster recovery management?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
  <input type="radio" name="value2" value="Yes"> yes
  <input type="radio" name="value2" value="No"> No<br><br>
  <label for="pin">Are there any Scalabity Factors?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
  <input type="radio" name="value3" value="Yes"> Yes
  <input type="radio" name="value3" value="No"> No<br><br>
  <label for="pin">Are there any Security related requirements?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
  <input type="radio" name="value4" value="Yes"> Yes
  <input type="radio" name="value4" value="No"> No<br><br>
  <label for="pin">Are there any Response time related requirements?&nbsp&nbsp&nbsp </label>
  <input type="radio" name="value5" value="Yes"> Yes
  <input type="radio" name="value5" value="No"> No<br><br>
</div>

<div class="myDiv">
  <p class="myp"><b>Interfaces / Dependency</b></p>
   <label for="fname">Are there any requirements to open firewall port to implement a new interface? </label>
<input type="radio" name="value6" value="Yes"> yes
  <input type="radio" name="value6" value="No"> No<br><br>
  <label for="pin">Are there any communications protocol changes within walgreens applications(like Pnet1,Pnet2....etc)?</label>
  <input type="radio" name="value7" value="Yes"> yes
  <input type="radio" name="value7" value="No"> No<br><br>
  <label for="pin">Are we owning/coordinating the integration testing with multiple partners?</label>
  <input type="radio" name="value8" value="Yes"> yes
  <input type="radio" name="value8" value="No"> No<br><br>
  <label for="pin">Are there any information exchange with other applications( like PARS,RXR...etc)?</label>
  <input type="radio" name="value9" value="Yes"> yes
  <input type="radio" name="value9" value="No"> No<br><br>
</div>
<div class="myDiv">
  <p class="myp">Regression testing</p>
  <label for="fname">No. of Simple test cases &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
  <input type="text" name="value10" size="4"><br><br>
 <label for="fname">No. of Medium test cases &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
  <input type="text" name="value11" size="4"><br><br>
  <label for="fname">No. of Complex test cases &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
  <input type="text" name="value12" size="4"><br><br>
</div>
<div class="myDiv">
  <p class="myp"><b>Interfaces / Dependency</b></p>
   <label for="fname">Are there any hardware infrastructure related changes(Adding additional disk space, CPU etc)? </label>
<input type="radio" name="value13" value="Yes"> yes
  <input type="radio" name="value13" value="No"> No<br><br>
  <label for="pin">Are there any software related changes (installing new software,adding more software upgrade)?</label>
  <input type="radio" name="value14" value="Yes"> yes
  <input type="radio" name="value14" value="No"> No<br><br>
  <label for="pin">Are there any DBI/DBR?</label>
  <input type="radio" name="value15" value="Yes"> yes
  <input type="radio" name="value15" value="No"> No<br><br>
</div>
<div class="myDiv">
  <p class="myp"><b>Pilot / Deployment</b></p>
   <label for="fname">Is central Conversion required?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
<input type="radio" name="value16" value="Yes"> yes
  <input type="radio" name="value16" value="No"> No<br><br>
  <label for="pin">Is there a local change?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label>
  <input type="radio" name="value17" value="Yes"> yes
  <input type="radio" name="value18" value="No"> No<br><br>
  
</div>
  <%-- <center><input type="submit" value="Submit" class="button1"></center> --%>
  	</div>
  	
  	<div class="w3-container w3-blue" align="right">
		<p>
			<button type="submit">Generate Estimate</button>
			<button>Download</button>
			<button>Submit for Review</button>
		</p>
		<p>App Version</p>
	</div>

</form:form>



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