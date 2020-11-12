<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
#body {
	margin: auto;
	width: 60%;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	padding: 10px;
	text-align: center;
}

#features {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
	width: 70%;
}

#features th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #4CAF50;
	color: white;
	border: 1px solid #ddd;
	padding: 8px;
}

#features td {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #e6ffe6;
	color: black;
	border: 1px solid #ddd;
	padding: 8px;
}

#project {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;
	width: 70%;
}

#project th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: centre;
	background-color: #4CAF50;
	color: white;
	border: 1px solid #ddd;
	padding: 8px;
}

#project th:nth-child(even) {
	color: black;
	background-color: #e6ffe6;
}
</style>
<title>Project View</title>
</head>
<body>

	<form action="/download" method="get" >
		<div id="body">
			<h2>Submitted Project Information</h2>
			
			<table id="project">
				<tr>
					<th>Project Name</th>
					<th>${projectName}</th>
				</tr>
			</table>
			<br /> <br />
			<table id="features">
				<tr>
					<th>Feature name</th>
					<th>Item Name</th>
					<th>Item Type</th>
					<th>New/modify</th>
					<th>Component Complexity</th>
					<th>Degree of Change</th>
					<th>Technology</th>
					<th>Weightage</th>
				</tr>

				<c:forEach var="featureList" items="${projectFeatureList}">

					<tr>

						<td rowspan="${fn:length(featureList.devComponents)+1}">${featureList.featureName}</td>
						<c:forEach var="itemList" items="${ featureList.devComponents}">


							<tr>
								<td>${itemList.itemName}</td>
								<td>${itemList.itemType}</td>
								<td>${itemList.newOrModify}</td>
								<td>${itemList.componentComplexityForItem }</td>
								<td>${itemList.degreeOfChangesForItem}</td>
								<td>${itemList.technologyForItem}</td>
								<td>${itemList.weightage}</td>
							</tr>



						</c:forEach>
					</tr>
				</c:forEach>
				<%-- <tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Total Weightage</td>
				<td>${totWtg }</td>
			</tr> --%>

			</table>
			<table id="project">
				<tr>
					<th>Total Weightage</th>
					<th>${totWtg }</th>
				</tr>
			</table>
			<br> <br>
			<hr>

			<h3>QA Components for Respective Features</h3>
			<table id="features">
				<tr>
					<th>Feature name</th>
					<th>QA Component</th>
					<th>Test Data Complexity</th>
					<th>Validation Component</th>
					<th>Requirement Complexity</th>
					<th>Validation Point</th>
					<th>Score</th>
				</tr>
				<c:forEach var="featureList" items="${projectFeatureList}">

					<tr>

						<td rowspan="${fn:length(featureList.qaComponents)+1}">${featureList.featureName}</td>
						<c:forEach var="qaList" items="${ featureList.qaComponents}"
							varStatus="loop">
							<tr>
								<td>${loop.index+1}</td>
								<td>${qaList.testDataComplexity }</td>
								<td>${qaList.validationComponent }</td>
								<td>${qaList.requirementComplexity }</td>
								<td><c:if test="${qaList.validationPoints==1}">
										<c:out value="<2" />
									</c:if> <c:if test="${qaList.validationPoints==2}">
										<c:out value="3-5" />
									</c:if> <c:if test="${qaList.validationPoints==3}">
										<c:out value="5-10" />
									</c:if> <c:if test="${qaList.validationPoints==4}">
										<c:out value=">10" />
									</c:if></td>
								<td>${qaList.score }</td>
							</tr>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
			<table id="project">
				<tr>
					<th>Total Score</th>
					<th>${totSc }</th>
				</tr>
			</table>
			<%-- <h3>Weightage for the respective items</h3>
		<table id="features">

			<tr>
				<th>Item Name</th>

				<th>Weightage</th>
			</tr>
			<c:forEach var="weightageItem" items="${itemWeightageList }">
				<tr>

					<td>${weightageItem.itemName }</td>
					<td>${weightageItem.itemWeightage }</td>
				</tr>

			</c:forEach>
		</table> --%>

			<br />
			<hr>
			<br />

		</div>
		<br /> <br />
		<div align="center">
         
			<button type="submit">Download</button>
		</div>
	</form>
</body>
</html>