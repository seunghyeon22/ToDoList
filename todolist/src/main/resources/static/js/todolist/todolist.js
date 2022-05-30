const insertBtn = document.querySelector(".insert-btn");
const inputContent = document.querySelector(".input-content");

let todolistObj = {};

load();

function load() {
	let url = "api/v1/todo/all";
	fetch(url)
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw new Error(response.json());
			}
		})
		.then(data => {
			todolistObj = data;
			getToDoList(data);
			updatebtn();
			deletebtn();

		})
		.catch(error => console.log(error));
}

function getToDoList(data) {
	const boardList = document.querySelector(".board-list");
	let boardStr = ``;
	for (let i = 0; i < data.length; i++) {
		boardStr += `
		<li class="board-list-items"> 
			<span class = "content-data">${data[i].content}</span>
			<button type="button" class="update-btn">수정</button>
			<button type="button" class="delete-btn">삭제</button>
		</li>`
	}
	boardList.innerHTML = boardStr;
}


insertBtn.onclick = () => {
	if (inputContent.value != null) {
		submit();
		location.replace("/index")
	}
}

function submit() {
	let url = "api/v1/todo";
	let option = {
		method: "post",
		headers: {
			"Content-Type": "application/json"
		},
		body: JSON.stringify({
			content: inputContent.value
		})
	}
	fetch(url, option)
		.then(response => {
			console.log(response)
			if (response.ok) {
				return response.json();
			} else {
				throw new Error(response.json());
			}
		})
		.then((data) => console.log(data))
		.catch(error => console.log(error))
}


function updatebtn() {
	const updateBtn = document.querySelectorAll(".update-btn");
	const contentdata = document.querySelectorAll(".content-data");
	for (let i = 0; i < updateBtn.length; i++) {
		updateBtn[i].onclick = () => {
			let url = `api/v1/todo/${todolistObj[i].id}`;
			let option = {
				method: "put",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify({
					content: contentdata[i].value
				})
			}
			fetch(url, option)
				.then(response => {
					if (response.ok) {
						return response.json();
					} else {
						throw new Error(response.json());
					}
				})
		}
	}
}

function deletebtn() {
	const deleteBtn = document.querySelectorAll(".delete-btn");

	for (let i = 0; i < deleteBtn.length; i++) {
		deleteBtn[i].onclick = () => {
			let url = "api/v1/todo/" + todolistObj[i].id;
			let option = {
				method: "delete"

			}
			fetch(url, option)
				.then(response => {
					if (response.ok) {
						load();
					} else {
						throw new Error(response.json());
					}
				})
				.catch(error => console.log(error));

		}
	}
}

















