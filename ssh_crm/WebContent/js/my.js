function loadSelect(typecode,positionId,selectName,selectedId ){
		//1.创建select对象，指定name属性
		var $select = $("<select name="+selectName+"></select>");
		//2.添加提示选项
		
		$select.append($("<option value=''>---请选择---</option>"));
		//3.使用jquery的ajax方法，访问后台action
		$.post("${pageContext.request.contextPath}/BaseDictAction", { dict_type_code: typecode },
  			function(data){
    			
    			
    	//4.遍历json数组对象，每次遍历创建一个option对象，并判断是否要回显		
    		$.each( data, function(i, json){
    			var $option = $("<option value='"+json["dict_id"]+"'>"+json["dict_item_name"]+"</option>")
    			
    			if(json["dict_id"]==selectedId){
    				$option.attr( "selected", "selected");
    			}
    			
    			
    			$select.append($option);
    		});
    			
 		 }, "json");
		
		
		//5.将组装好的select对象放入指定位置
		$("#"+positionId).append($select);
		
	}