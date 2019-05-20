window.onload = function() {
	getPetInfo();
}


function getPetInfo() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let pet = JSON.parse(xhttp.responseText);
			buildTable(pet);

		}
	}

	xhttp.open("GET", 'http://localhost:9005/Project1USF/html/AdminHome.do',
			true);
	xhttp.send();
}

function setValues(pet) {
	document.getElementById("userID").innerHTML = pet.userID;
	document.getElementById("firstName").innerHTML = pet.firstName;
	document.getElementById("lastName").innerHTML = pet.lastName;
	document.getElementById("type").innerHTML = pet.type;
	document.getElementById("amount").innerHTML = pet.amount;
	document.getElementById("dateSubmitted").innerHTML = pet.dateSubmitted;
	document.getElementById("dateResolved").innerHTML = pet.dateResolved;
	document.getElementById("status").innerHTML = pet.status;
	document.getElementById("description").innerHTML = pet.description;
	document.getElementById("ticketID").innerHTML = pet.ticketID;
}

function buildTable(pet) {
	var tblBody = document.createElement("tbody");
	for (var i = 0; i < pet.length; i++) {
		var tr = document.createElement('tr');
		var td1 = document.createElement('td');
		var i1='userID' + i;
		td1.id = i1.toString();
		var td2 = document.createElement('td');
		var i2 = "firstName" + i;
		td2.id = i2.toString();
		var td3 = document.createElement('td');
		var i3 = "lastName" + i;
		td3.id = i3.toString();
		var td4 = document.createElement('td');
		var i4 = "type" + i;
		td4.id = i4.toString();
		var td5 = document.createElement('td');
		var i5 = "amount" + i;
		td5.id = i5.toString();
		var td6 = document.createElement('td');
		var i6 = "dateSubmitted" + i;
		td6.id = i6.toString();
		var td7 = document.createElement('td');
		var i7 = "dateResolved" + i;
		td7.id = i7.toString();
		var td8 = document.createElement('td');
		var i8 = "status";
		td8.class = i8;
		var td9 = document.createElement('td');
		var i9 = "description" + i;
		td9.id = i9.toString();
		var td10 = document.createElement('td');
		var i10 = "ticketID" + i;
		td10.id = i10.toString();
		var td11 = document.createElement('td');
		var input1 = document.createElement('button');
		var input2 = document.createElement('button');
		
		input1.setAttribute("name", "approve");
		input1.setAttribute("value", pet[i].ticketID);
		input1.innerHTML="Approve";
		input1.addEventListener('click', approveButton); 

		var input2 = document.createElement('button');
		input2.setAttribute("name", "deny");
		input2.innerHTML="Deny";
		input2.setAttribute("value", pet[i].ticketID);
		input2.addEventListener('click', denyButton); 
	
		 var text1 = document.createTextNode(pet[i].userID);
		 var text2 = document.createTextNode(pet[i].firstName);
		 var text3 = document.createTextNode(pet[i].lastName);
		 var text4 = document.createTextNode(pet[i].type);
		 var text5 = document.createTextNode(pet[i].amount);
		 var text6 = document.createTextNode(pet[i].dateSubmitted);
		 var text7 = document.createTextNode(pet[i].dateResolved);
		 var text8 = document.createTextNode(pet[i].status);
		 var text9 = document.createTextNode(pet[i].description);
		 var text10 = document.createTextNode(pet[i].ticketID);
		 
		 td1.appendChild(text1);
		 td2.appendChild(text2);
		 td3.appendChild(text3);
		 td4.appendChild(text4);
		 td5.appendChild(text5);
		 td6.appendChild(text6);
		 td7.appendChild(text7);
		 td8.appendChild(text8);
		 td9.appendChild(text9);
		 td10.appendChild(text10);
		 td11.appendChild(input1);
		 td11.appendChild(input2);
		 
		tr.appendChild(td1);
		tr.appendChild(td2);
		tr.appendChild(td3);
		tr.appendChild(td4);
		tr.appendChild(td5);
		tr.appendChild(td6);
		tr.appendChild(td7);
		tr.appendChild(td8);
		tr.appendChild(td9);
		tr.appendChild(td10);
		tr.appendChild(td11);

		tblBody.appendChild(tr);
	}

	document.getElementById("reimbtable").appendChild(tblBody);
}

function approveButton(e) {
	let target = e.target;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let pet = JSON.parse(xhttp.responseText);
			getPetInfo();
		}
	}

	xhttp.open("POST", 'http://localhost:9005/Project1USF/html/AdminApprove.do',
			true);
	xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
	xhttp.send("value=" +e.target.value);
}

function denyButton(e) {
	let target = e.target;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let pet = JSON.parse(xhttp.responseText);
			getPetInfo();
		}
	}
	xhttp.open("POST", 'http://localhost:9005/Project1USF/html/AdminDeny.do',
			true);
	xhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
	xhttp.send("value=" + e.target.value);
}


