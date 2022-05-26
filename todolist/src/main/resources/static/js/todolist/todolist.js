const insertBtn = document.querySelector(".insert-btn");
const inputContent = document.querySelector(".input-content");

load();

insertBtn.onclick = () => {
	if (inputContent != null) {
		submit();
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


function load() {
	let url = "api/v1/todo/all";
	fetch(url)
	.then(response =>{
		if(response.ok){
			return response.json();
		}else{
			throw new Error(response.json());
		}
	})
	.then(data =>{
		getToDoList(data.data);
	})
	.catch(error => console.log(error));
}

function getToDoList(data) {
	const boardList = document.querySelector(".board-list");
	let boardStr = ``;
	for (let i = 0; i < data.length; i++) {
		boardStr += `
		<li class="board-list-items"> 
			<span>${data[i].content}</span>
			<button type="button" class="update-btn">수정</button>
			<button type="button" class="delete-btn">삭제</button>
		</li>`
	}
	boardList.innerHTML = boardStr;
}









