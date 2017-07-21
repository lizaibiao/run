<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/global/global.jsp" %>
<html>
<c:set var="ctx" value="<%=request.getContextPath()%>" />
<head>
<title>用户管理</title>
<style type="text/css">
body {
	font: 12px/20px "微软雅黑", "宋体", Arial, sans-serif, Verdana, Tahoma;
	padding: 0;
	margin: 0;
}
</style>

<script type="text/javascript" >
 $(document).ready(function(){
	 //用户list
  $("#userGrid").datagrid({
	    url :"${ctx}/admin/user/getUserPage.do", //获取数据地址
	    iconCls : "icon-save", //图标
		pagination : true, //开启分页
		pageSize : 5, //每页显示数目 
		pageList : [ 5, 10, 20, 30, 40, 50 ], //选择每页显示数目(与pageSize对应)
		fit : false, //适应大小
		fitColumns : true, //自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动
		nowrap : false, //是否关闭自动换行(true关闭，false开启)
		border : true, //边框
		remoteSort : true,//是否往后台传排序
		singleSelect : true,//设置为 true，则只允许选中一行。
		checkOnSelect:false,//点击整行,复选框是否被选中
		rownumbers : true,
	/* 	sortName : "name",
		sortOrder : 'asc', */
		striped:true,
	    collapsible:true,
		columns : [[{title : "序号",field : "xuid",align : 'center',checkbox:true,width : 100},
		            {title : "用户编码",field : "code",sortable:true,align : 'center',width : 100},
		            {title : "用户名",field : "name",sortable:true,align : 'center',width : 100},
		            {title : "手机号",field : "mobile",sortable:true,align : 'center',width : 100},
		            {title : "创建时间",field : "createTime",sortable:true,align : 'center',width : 100,formatter:formatDate},
		            {title : "最后登录时间",field : "lastLoginTime",sortable:true,align : 'center',width : 100,formatter:formatDate},
		            {title : "状态",field : "status",sortable:true,align : 'center',width : 100,
		                formatter: function (value, rec) {
		                   if(value=='1'){
		                	   return "启用";
		                   }else{
		                	   return "不启用";
		                   }
		                   
		                }
		            }
		]]/* ,
		toolbar: [{
			    text : '添加',iconCls : 'icon-add',handler : function() {
				$("#add").show();
				$('#add').dialog({title : '添加用户',width : 500,height :200,top:150,closed : false,cache : false,modal : true,
					href : '${ctx}/admin/usermodel/adduser.jsp',
					buttons : [
						{text : '提交',iconCls : 'icon-ok',
							handler : function() {//添加时,异步提交
							$.ajax({
										type : "POST",
										url : "${ctx}/admin/user/saveUser.do",
										data : $('#adduserForm').serialize(),// 你的formid
										async : false,
										error : function(request) {
											alert("Connection error");
										},
										success : function(data) {
											$("#add").dialog('close');
									 		$('#userGrid').datagrid('load','${ctx}/admin/user/getUserPage.do');
										}
										});
							}
						},
						{iconCls : 'icon-no',
							text : '关闭',
							handler : function() {
								$("#add").dialog('close');
							}
						} ]
			});
			}
		}]
		
		 */
   });
 });
 
	/*  
	*格式话时间
	*/
 function formatDate(value,row,index){  
     var unixTimestamp = new Date(value);  
     return unixTimestamp.toLocaleString();  
     };
  /*
   *多条件查询方法
  */
  function doSearch(){
	  	var postData={};
		 postData["code"]=$("#code").val();
		 postData["name"]=$("#name").val();
	//	 postData["createTime"]=$("#createTime").datetimebox('getValue');
		// postData["createTime2"]=$("#createTime2").datetimebox('getValue');
		
		  $('#userGrid').datagrid('options').queryParams=postData;        
         $("#userGrid").datagrid('reload'); 
    	/* $('#userGrid').datagrid('load','${ctx}/admin/user/getUserPage.do',postData);
		 $('#userGrid').datagrid({
			 url :"${ctx}/admin/user/saveUser.do",
			 queryParams:postData
			 }); */
 	};
/* 重置
 */  
  function doReset(){
	$("#tb input,#tb select").val("");
	};
	
</script>

</head>
<body>
	<div id="tb" style="padding:3px">
	<span>用户编码</span>
	<input id="code" class="easyui-textbox" />
	<span>用户名</span>
	<input id="name"  class="easyui-textbox" />
	<span>创建时间</span>
	<input id="createTime"  data-options="showSeconds:true"  style="width:150px" class="easyui-datetimebox" />
	<span>至</span>
	<input id="createTime2"  data-options="showSeconds:true" style="width:150px" class="easyui-datetimebox" />
	<br/>
	<a href="#" class="easyui-linkbutton"  onclick="doSearch()">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="easyui-linkbutton"  onclick="doReset()">重置</a>
</div>
<table id="userGrid"></table>
<div id="add" style="display: none"></div>
<div id="update" style="display: none">update</div>


</body>
</html>