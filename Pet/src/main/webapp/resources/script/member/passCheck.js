
 const check = function() {
	const pass = document.getElementById('pass').value;
	const message = document.getElementById('message');
		
	if(document.getElementById('pass').value=='') {
	
		message.style.color = 'red';
		message.innerHTML = '비밀번호를 입력해주세요';
		 
	} else if (document.getElementById('pass').value == document.getElementById('confirmPassword').value) {

	    message.style.color = 'green';
	    message.innerHTML = '일치합니다';

	} else {
	
	    message.style.color = 'red';
	    message.innerHTML = '일치하지 않습니다';

	}
	

}

