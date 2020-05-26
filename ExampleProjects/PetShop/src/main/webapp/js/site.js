function getpet(name) {
	debugger
	let obj = {};
	obj['name'] = name;
	obj['count'] = 1;
	
	fetch("getpet", {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(obj)
	})
	.then((response) => {
		return response.json();
	})
	.then((data) => {
		debugger
		let element = document.getElementById(name);
		element.innerHTML = data;
	});
}