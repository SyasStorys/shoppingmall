$(function(){
	// solving the active menu problem
	switch(menu){

	case 'About US':
		$('#about').addClass('active');
		break;
	case 'Contact US':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;
	default :
		if(menu == "Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}

	// code for jquery dataTable
	var $table = $('#productListTable');

	// execute the below code only where we have this table
	if($table.length) {

		var jsonUrl = '';
		if(window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId + '/products';
		}

		$table.DataTable({
			lengthMenu : [[3,5,10,-1], ['3 Records', '5 Records', '10 Records', 'ALL']],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : ''
			},
			columns : [
				{
					data : 'code',
					mRender : function(data, type, row) {
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>'
					}
				},
				{
					data : 'name'
				},
				{
					data : 'brand'
				},
				{
					data : 'unitPrice',
					mRender : function(data, type, row) {
						return '￦' +data;
					}
				},
				{
					data : 'quantity',
					mRender : function(data, type, row) {
						if(data < 1) {
							return '<span style="color:rad">Out of Stock!</span>';
						}
						return data;
					}
				},
				{
					data : 'id',
					mRender : function(data, type, row) {
						var str = '';
						str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

						if(row.quantity < 1) {
							str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
						else {
							str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}

						return str;
					}
				},

			]
		});
	}
	
	// dismissing the alert after 3 seconds
	var $alert = $('.alert');
	
	if($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}
	
	// ---------------------------------------------------
	
	$('.switch input[type="checkbox"]').on('change',function(){
		
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked) ? 'You want to activate the product?' : 'You want to deactivate the product?';
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			size : 'medium',
			title : 'Product Activation & Deactivation',
			message : dMsg,
			callback : function(confirmed) {
				if(confirmed) {
					
					console.log(value);
					bootbox.alert({
						size : 'medium',
						title : 'Information',
						message : 'You are going to perform operation on product' + value
					});
					
				}
				else {
					checkbox.prop('checked', !checked);
				}
			}
		});
		
	});

	
	
	
	
	
	
	
	
	
	
});