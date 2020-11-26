//選択されている番号を示す変数
var count = 0;

//numberボタンが押された時の処理
function numClick( num ){
	document.images[count].src="number/number" + num + ".png";
	count++;

	if (count >= 4){
		count = 0;
	}
	selectBtn();
}

//数字下の選択ボタンが押された時の処理
function select( num ){
	count = num;
	selectBtn();
}

//数字下の選択ボタンの整合性を保つ処理
function selectBtn(){
	switch(count){
		case 0:
			document.getElementById("first").src="button/btn_2.gif";
			document.getElementById("second").src="button/btn_1.gif";
			document.getElementById("third").src="button/btn_1.gif";
			document.getElementById("fourth").src="button/btn_1.gif";
			break;
		case 1:
			document.getElementById("second").src="button/btn_2.gif";
			document.getElementById("first").src="button/btn_1.gif";
			document.getElementById("third").src="button/btn_1.gif";
			document.getElementById("fourth").src="button/btn_1.gif";
			break;
		case 2:
			document.getElementById("third").src="button/btn_2.gif";
			document.getElementById("first").src="button/btn_1.gif";
			document.getElementById("second").src="button/btn_1.gif";
			document.getElementById("fourth").src="button/btn_1.gif";
			break;
		case 3:
			document.getElementById("fourth").src="button/btn_2.gif";
			document.getElementById("first").src="button/btn_1.gif";
			document.getElementById("second").src="button/btn_1.gif";
			document.getElementById("third").src="button/btn_1.gif";
			break;
	}
}

//リセットボタンが押された時の処理
function reSet(){
	for (i = 0; i <= 3; i++){
		document.images[i].src="number/number0.png";
	}
	count = 0;
	selectBtn();
}

//数字を送信するための処理
function setValue(){
	var postNumber = "";
	document.getElementsByName("playerNumber")[0].value = "";
	var imgContent = document.getElementsByName("numberSelect");
	for (i = 0; i < 4; i++) {
		var imgUrl = imgContent[i].src;
		var n = imgUrl.lastIndexOf(".png");
		postNumber += imgUrl.charAt(n-1);
	}
	document.getElementsByName("playerNumber")[0].value = postNumber;
}
