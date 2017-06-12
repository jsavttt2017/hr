var xmlHttpRequest;
function createXMLHttpRequest() {
	if(window.XMLHttpRequest){
		xmlHttpRequest = new XMLHttpRequest;
	}else{
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHttp");
	}
}
window.onload = function() {
	document.getElementById("aid").addEventListener("change",loadAreaplus,false);
}
function loadAreaplus() {
	var aid = document.getElementById("aid").value;
		createXMLHttpRequest();
		xmlHttpRequest.open("post","AreaplusServlet?aid=" + aid);
		xmlHttpRequest.onreadystatechange = function() {
			if(xmlHttpRequest.status == 200){
				if(xmlHttpRequest.readyState == 4){
					var allAreapluses = xmlHttpRequest.responseXML;
					var apids = allAreapluses.getElementsByTagName("apid");
					var titles = allAreapluses.getElementsByTagName("title");
					var apidElement = document.getElementById("apid");
					apidElement.length = 1;
					for(var x = 0; x < apids.length; x ++){
						var optionElement = document.createElement("option");
						optionElement.setAttribute("value", apids[x].firstChild.nodeValue);
						optionElement.appendChild(document.createTextNode(titles[x].firstChild.nodeValue));
						apidElement.appendChild(optionElement);
					}
				}
			}
		}
		xmlHttpRequest.send(null);
	}