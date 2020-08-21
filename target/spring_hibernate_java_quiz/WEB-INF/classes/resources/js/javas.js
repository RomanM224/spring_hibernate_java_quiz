
	document.querySelectorAll('.answerCheckbox').forEach((element) => {
		element.onclick = orderFunction;
	});
	
	function orderFunction(){
	let answer1 = document.querySelector('.answerCheckbox[value="answer1"]');
	let answer2 = document.querySelector('.answerCheckbox[value="answer2"]');
	let answer3 = document.querySelector('.answerCheckbox[value="answer3"]');
	let answer4 = document.querySelector('.answerCheckbox[value="answer4"]');
	console.log(1);
	
	if(this.value == 'answer1'){
		answer2.checked = false;
		answer3.checked = false;
		answer4.checked = false;
	}
	if(this.value == 'answer2'){
		answer1.checked = false;
		answer3.checked = false;
		answer4.checked = false;
	}
	if(this.value == 'answer3'){
		answer1.checked = false;
		answer2.checked = false;
		answer4.checked = false;
	}
	if(this.value == 'answer4'){
		answer1.checked = false;
		answer2.checked = false;
		answer3.checked = false;
	}
	
	}