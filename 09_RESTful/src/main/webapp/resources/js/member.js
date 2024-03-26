/**
 * 
 */

// 전역 변수(vXXX)
var vPage = 1;
var vDisplay = 20; 

 // jQuery 객체 선언(jqXXX)
var jqMembers = $('#members');
var jqTotal = $('#total');
var jqPaging = $('#paging');
var jqDisplay=$('#vDisplay');
var jqEmail = $('#email');
var jqName = $('#name');
var jqZonecode = $('#zonecode');
var jqAddress = $('#address');
var jqDetailAddress = $('#ExtraAddress');
var jqExtraAddress = $('#BtnInit');
var jqBtnInit = $('#btn-init');
var jqBtnRegister = $('#btn-register');
var jqBtnModify = $('#btn-modify');
var jqBtnRemove = $('#btn-remove');
var jqBtnSelectRemove = $('#btn-select-remove');


// 함수 표현식 (함수 만들기)
const fnInit = ()=>{
  jqEmail.val('');
  jqName.val('');
  $('#none').prop('checked', true);
  zonecode.val('');
  jqAddress.val('');
  jqDetailAddress.val('');
  jqExtraAddress.val('');
}

const getContextPath = ()=>{
  const host = location.host; /* localhost:8080 */
  const url = location.href   /* http://localhost:8080/mvc/getDate.do */
  const begin = url.indexOf(host) + host.length;
  const end = url.indexOf('/', begin + 1);
  return url.substring(begin, end);
}

const fnRegisterMember = ()=>{
  $.ajax({
    // 요청
    type: 'POST',
    url: getContextPath() + '/jqMembers',
    contentType: 'application/json',  // 보내는 데이터의 타입
    data: JSON.stringify({            // 보내는 데이터 (문자열 형식의 JSON 데이터)
      'jqEmail': jqEmail.val(),
      'name': jqName.val(),
      'gender': $(':radio:checked').val(),
      'jqZonecode': jqZonecode.val(),
      'jqAddress': jqAddress.val(),
      'jqDetailAddress': jqDetailAddress.val(),
      'jqExtraAddress': jqExtraAddress.val()
    }),
    // 응답
    dataType: 'json'  // 받는 데이터 타입
  }).done(resData=>{  // resData = {"insertCount": 2}
    if(resData.insertCount === 2){
      alert('정상적으로 등록되었습니다.');
      fnInit();
      fnGetMemberList();
    }
  }).fail(jqXHR=>{
    alert(jqXHR.responseText);
  })
}




// 함수 표현식 (함수 만들기)
const fnMemberList = ()=>{
  $.ajax({
    type: 'GET',
    url: getContextPath() + '/jqMembers/vPage/' + vPage + '/vDisplay/' + vDisplay,
    dataType:'json',
    success: (resData)=>{ /*
                          resData = {
                           "jqMembers:" [
                             {"jqAddressNo":1,
                               "jqZonecode":'12345',
                               "jqAddress":'서울시 구로구',
                               "jqDetailAddress":'디지털로',
                               "jqExtraAddress":'(가산동)',
                               "jqMembers":{
                                 "memberNo":1,
                                 "jqEmail": 'aaa@bbb',
                                 "name":'gildong',
                                 "gender":'none'
                                }
                               },...}
                            ],
                           "jqTotal": 30,
                           "jqPaging:" '<1 2 3 4 5 6 7 8 9 10>'}
                          */
      jqTotal.html('총 회원' + resData.jqTotal + '명');
      jqMembers.empty();
      $.each(resData.jqMembers, (i, member)=>{
        let str = '<tr>';
        str += '<td><input type="checkbox" class="chk-member" value="'+ member.member.memberNo+'"></td>';
        str += '<td>'+member.member.jqEmail+'</td>';
        str += '<td>'+ member.member.name +'</td>';
        str += '<td>'+ member.member.gender +'</td>';
        str += '<td><button type="button" class="btn-detail" data-member-no="'+ member.member.memberNo+'">조회</button></td>';
        str += '</tr>';
        jqMembers.append(str);
      })
      jqPaging.html(resData.jqPaging);
    },
    error: (jqXHR)=>{
      alert(jqXHR.statusText + '(' + jqXHR.status + ')');
    }
  })
}
  //MyPageUtils 클래스의 getAsyncPaging() 메소드에서 만든 <a=javascript:fnPaging()>여기에 의해서 실행된는함수
  const fnPaging = (p)=>{
    vPage = p;
    fnMemberList();
  }
  
//select이용한 함수 호출
const fnChangeDisplay = ()=>{
  vDisplay = jqDisplay.val();
  fnMemberList();
}
  
// 함수 호출 및 이벤트
fnMemberList();
jqDisplay.on('change', fnChangeDisplay);


// 함수 호출 및 이벤트
fnInit();
jqBtnInit.on('click', fnInit);
jqBtnRegister.on('click', fnRegisterMember);