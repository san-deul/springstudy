<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<c:set var="dt" value="<%=System.currentTimeMillis()%>"/>

<jsp:include page="../layout/header.jsp"/>

<h1 class="title">업로드 편집화면</h1>

<form id="frm-upload-modify"
      method="POST"
      action="${contextPath}/upload/modify.do">

  <div>
    <span>작성자</span>
    <span>${sessionScope.user.email}</span>
  </div>
  
  <div>
    <span>최종수정일</span>
    <span>${upload.modifyDt}</span>
  </div>
  
  <div>
    <span>작성일자</span>
    <span>${upload.createDt}</span>
  </div>
  
  <div>
    <label for="title">제목</label>
    <input type="text" name="title" id="title" value="${upload.title}">
  </div>

  <div>
    <textarea id="contents" name="contents" >${upload.contents}</textarea>
  </div>
  
  <div>
    <input type="hidden" name="uploadNo" value="${upload.uploadNo}">
    <button id="submit-btn" type="submit">수정완료</button>
    <a href="${contextPath}/upload/list.do"><button type="button">작성취소</button></a>
  </div>  
      
</form>



<div>
  <label for="files">첨부</label>
  <input type="file" name="files" id="files" multiple>
</div>

<div id="attach-list"></div>

<script>

// 첨부 목록 가져와서 <div id="attach-list"></div> 에 표시하기
const fnAttachList = () => {
	fetch('${contextPath}/upload/attachList.do?uploadNo=${upload.uploadNo}',{
		method: 'GET',
	})
	.then(response => response.json()) // response로부터 json만 가져와라
	.then(resData => { // resData = {"attachList":[]}
		let divAttachList = document.getElementById('attach-list');
		divAttachList.innerHTML = '';
		const attachList = resData.attachList;
		for(let i = 0; i < attachList.length; i++){
			const attach = attachList[i];
			let str = '<div class="attach">';
			if(attach.hasThumbnail === 0){
				str += '<img src="${contextPath}/resources/images/attach.png" width="96px">'
			} else{
				str += '<img src="${contextPath}' + attach.uploadPath + '/s_' + attach.filesystemName + '">';
			}
			str += '<span>' + attach.originalFilename + '</span>';
			if('${sessionScope.user.userNo}' === '${upload.user.userNo}'){
				str += '<a style="margin-left:10px;" class="remove-attach" data-attach-no="' + attach.attachNo + '">x</a>'
			}
			str += '</div>';
			divAttachList.innerHTML += str;
		}
	})
}


// 첨부 삭제
const fnRemoveAttach = () =>{
	$(document).on('click', '.remove-attach', (evt) => {
		if(!confirm('해당 첨부파일을 삭제할까요?')){
			return;
		}
		fetch('${contextPath}/upload/removeAttach.do', {
			method:'POST',
			headers:{
				'Content-Type':'application/json'
			},
			body:JSON.stringify({
				'attachNo' : evt.target.dataset.attachNo
			})
		})
		.then(response => response.json())
		.then(resData => { //resData = {"deleteCount": 1}
			if(resData.deleteCount === 1){
				alert('첨부파일이 삭제되었습니다');
		    fnAttachList();
			}else{
				alert('첨부파일이 삭제되지 않았습니다.');
			}
		})
	})
}





// 제목 필수 입력 스크립트
/*
const fnRegisterUpload = () => {
  document.getElementById('frm-upload-register').addEventListener('submit', (evt) => {
    if(document.getElementById('title').value === '') {
      alert('제목은 필수입니다.');
      evt.preventDefault();
      return;
    }
  })
}
*/

// 크기 제한 스크립트
// 첨부 목록 출력 스크립트
// 크기 제한 스크립트 + 첨부 목록 출력 스크립트
/*
const fnAttachCheck = () => {
  document.getElementById('files').addEventListener('change', (evt) => {
    const limitPerSize = 1024 * 1024 * 10;
    const limitTotalSize = 1024 * 1024 * 100;
    let totalSize = 0;
    const files = evt.target.files;
    const attachList = document.getElementById('attach-list');
    attachList.innerHTML = '';
    for(let i = 0; i < files.length; i++){
      if(files[i].size > limitPerSize){
        alert('각 첨부 파일의 최대 크기는 10MB입니다.');
        evt.target.value = '';
        attachList.innerHTML = '';
        return;
      }
      totalSize += files[i].size;
      if(totalSize > limitTotalSize){
        alert('전체 첨부 파일의 최대 크기는 100MB입니다.');
        evt.target.value = '';
        attachList.innerHTML = '';
        return;
      }
      attachList.innerHTML += '<div>' + files[i].name + '</div>';
    }
  })
}

*/

fnAttachList();
fnRemoveAttach();
//fnRegisterUpload();
//fnAttachCheck();
    


</script>

<%@ include file="../layout/footer.jsp" %>