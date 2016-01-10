
function editFunction(url, id, page) {
		window.location.href = url + "?id="+ id + "&pages=" + page;
}
function deleteFunction(url, id, page) {
	if (confirm("您确认要删除这条记录吗？Id：" + id))
		window.location.href = url + "?id="+ id + "&pages=" + page;
}
function gopages(url, page) {
	window.location.href = url + "?pages=" + page;
}
function gopage(url, page, pram) {
	if(pram==''){
		gopages(url, page);
	}else{
		window.location.href = url + "?pages=" + page + "&pram=" + pram;
	}
}

/**
 * 模块表头数据
 */
table_title = [];
/**
 * 模块字段标识
 */
data_sign = [];
/**
 * 根据模块标识获取模块表头数据
 * @param model
 */
function getTitles(model){
	
	switch(model){
		case "User" :{
			table_title = ["用户Id","账号","密码","昵称","真实姓名","性别","生日","头像","电话","邮箱","QQ","微信","简介","是否冻结","创建日期","更新日期","备注"];
			data_sign = ["userId","account","password","nickName","trueName","sexs","birthdays","icon","phone","email","qq","wechat","info","signs","createDates","lastUpdates","remark"];
			break;
		}
		case "Comment" :{
			table_title = ["评论Id","用户Id","景区Id","名店Id","特产Id","内容","时间","分数","备注"];
			data_sign = ["commentId","userId","viewId","storeId","specialId","content","createDates","score","remark"];
			break;
		}
		case "Specialty" :{
			table_title = ["特产Id","名称","简介","地址","创建日期","备注"];
			data_sign = ["specialId","specialName","specialInfo","specialAddress","createDates","remark"];
			break;
		}
		case "Store" :{
			table_title = ["名店Id","名称","简介","地址","时间","创建日期","备注"];
			data_sign = ["storeId","storeName","storeInfo","storeAddress","storeTime","createDates","remark"];
			break;
		}
		case "ViewImage" :{
			table_title = ["相片Id","景区Id","用户Id","图片信息","图片URL","创建日期","备注"];
			data_sign = ["imageId","viewId","userId","imageInfo","imageUrl","createDates","remark"];
			break;
		}
		case "View" :{
			table_title = ["景区Id","村子Id","名称","地址","导语","简介","标志","开放时间","票价","联系电话","创建日期","备注"];
			data_sign = ["viewId","villageId","viewName","viewAddress","viewGuide","viewInfo","viewLogo","openTime","ticket","phone","createDates","remark"];
			break;
		}
		case "Village" :{
			table_title = ["村子Id","名称","地址","简介","标志","村史","村志","创建时间","备注"];
			data_sign = ["villageId","villageName","villageAddress","villageInfo","villageLogo","historyRecord","villageStory","createDates","remark"];
			break;
		}
		default : break;
	}
	
};
