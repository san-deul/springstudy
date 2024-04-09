<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<c:set var="dt" value="<%=System.currentTimeMillis()%>"/>

<jsp:include page="../layout/header.jsp"/>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<h1 class="title">블로그 작성화면</h1>

<form id="frm-blog-register"
      method="POST"
      action="${contextPath}/blog/register.do">

  <div>
    <span>작성자</span>
    <span>${sessionScope.user.email}</span>
  </div>
  
  <div>
    <label for="title">제목</label>
    <input type="text" name="title" id="title">
  </div>
  
  <div>
    <textarea id="contents" name="contents" placeholder="서머노트를 입력하세요"></textarea>
  </div>
  
  <div>
    <input type="hidden" name="userNo" value="${sessionScope.user.userNo}">
    <button type="submit">작성완료</button>
    <a href="${contextPath}/blog/list.page"><button type="button">작성취소</button></a>
  </div>  
      
</form>

<script>

  const fnRegisterBbs = (evt) => {
    if(document.getElementById('contents').value === '') {
      alert('내용 입력은 필수입니다.');
      evt.preventDefault();
      return;
    }
  }

  document.getElementById('frm-blog-register').addEventListener('submit', (evt) => {
    fnRegisterBbs(evt);
  });
  
  
  const fnSummernoteEditor = () =>{
	  
	   $('#contents').summernote({
		      width:1024,
		      height:500,
		      lang:'ko-KR',
		      callbacks: {
		        onImageUpload: (images)=>{
		          // 비동기 방식을 이용한 이미지 업로드
		          for(let i = 0; i < images.length; i++){
		            let formData = new FormData();
		            formData.append('image', images[i]);
		            fetch('${contextPath}/blog/summernote/imageUpload.do', {
		              method: 'POST',
		              body:formData
		            }).then(response=> response.json())
		              .then(resData=>{
		                $('#contents').summernote('insertImage', resData.src);
		              });
		          }
		        }
		      }
		    });
  }
  
  fnSummernoteEditor();

</script>

<%@ include file="../layout/footer.jsp" %>