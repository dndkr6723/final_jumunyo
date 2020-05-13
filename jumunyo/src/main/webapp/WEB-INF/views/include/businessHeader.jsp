<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.header {
	width: 100%;
	height: 50px;
	background: linear-gradient(to bottom, #00D8FF, #8C8C8C, #E5D85C);
}

#logo {
	float: left;
	width: 40%;
	margin: 0 10%;
	line-height:50px;
}

#a1 {
	font-size: 30px;
	font-weight: bold;
	color: #A566FF;
	font-family: 'Nanum Pen Script', cursive;
}

#a2 {
	font-size: 30px;
	font-weight: bold;
	color: #1DDB16;
	font-family: 'Nanum Pen Script', cursive;
}

#a3 {
	font-size: 30px;
	font-weight: bold;
	color: #003399;
	font-family: 'Nanum Pen Script', cursive;
}

#a4 {
	font-size: 30px;
	color: #F29661;
	font-family: 'Nanum Pen Script', cursive;
}
#bp {
	font-size: 20px;
	font-family: 'Nanum Pen Script', cursive;
}
.res-name {
	float: left;
	line-height:50px;
	font-size: 20px;
	width: 10%;
}
.operator {
	float: left;
	width:10%;
	line-height:50px; 
	
}
.logout {
	line-height:50px;
	float: left;
	width:10%;
}
</style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
</head>
<body>
	<div class="header">
			<div id="logo" onmouseover="logo1();" onmouseout="logo2();">
				<a href="../index.jsp" style="text-decoration: none;"> 
					<b id="a1">��</b> 
					<b id="a2">��</b> 
					<b id="a3">��</b> 
					<b id="a4">��</b>
					<b id="bp">(����� ������)</b>
				</a>
			</div>
		<div class="res-name">
			<b>�Դ븮�� ��������</b>
		</div>
		<div class="operator">
			<b>���</b>
			<a>(</a>			
			<a href="" style="text-decoration: none; color: red; font-size: 15px;">ȫ�浿</a>
			<a>)</a>
		</div>
		<div class="logout">
			<a href="" style="text-decoration: none; font-size: 20px;"><b>�α׾ƿ�</b></a>
		</div>
	</div>

</body>
</html>