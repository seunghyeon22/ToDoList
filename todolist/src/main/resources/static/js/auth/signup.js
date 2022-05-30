const submitBtn = document.querySelector("button");
const inputs = document.querySelectorAll("input");

submitBtn.onclick = () => {
	usernameCheck();

	const url = "/api/v1/auth/signup";
	const body = {
		username: inputs[0].value,
		password: inputs[1].value,
		name: inputs[2].value,
		email: inputs[3].value
	};
	const option = {
		method: "post",
		header: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(body)
	}
	
	
}


async function usernameCheck(username){
	const url = "/api/v1/auth/username"
	const body = {
		"username" : username	
	}
	const option = {
		method: "get",
		header: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify(body)
	}
	
	await request(url,option)
	.then(result=>{
		console.log(result);
	})
	.catch(error =>{
		console.log(error);
	})
}





async function request(url) {
	const response = await fecth(url);
	if (response.ok) {
		return response.json();
	} else {
		throw new Error("response Error" + response);
	}
}

async function request(url, option) {
	const response = await fecth(url, option);
	if (response.ok) {
		return response.json();
	} else {
		throw new Error("response Error" + response);
	}
}
