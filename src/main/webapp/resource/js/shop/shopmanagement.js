$(function() {
	var shopId = getQueryString('shopId');
	var shopInfoUrl = '/shopadmin/getshopmanagementinfo?shopId=' + shopId;
	$.getJSON(shopInfoUrl, function(data) {
		if (data.redirect) {
			window.location.href = data.url;
			console.log("没有获取到shopId")
		} else {
			if (data.shopId != undefined && data.shopId != null) {
				shopId = data.shopId;
				console.log("没有获取到shopId")
			}
			$('#shopInfo')
					.attr('href', '/shopadmin/shopoperation?shopId=' + shopId);

		}
	});
});
