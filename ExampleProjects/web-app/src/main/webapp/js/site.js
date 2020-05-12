function extraction(name) {
	debugger
	
	var obj = {};
	obj['name'] = name;
	obj['count'] = 1;
	
	fetch("extractionFruit", {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(obj)
	})
	.then((response) => {
		return response.json()
	})
	.then((data) => {
		var element = document.getElementById(name);
		element.innerHTML = data;
	});
}
