function checkClick (node,input){
	var value = $(input).val();
	
	$(node).click(function(){
		if (value == null || value.trim() == "")
		{	
			alert("pelase input content!"+value);
			return false;
		}
		return true;
	});
}
  function iconSet(theme_json, class_name) {
        for (var i in theme_json) {
            console.log(i + ":" + theme_json[i].name);
            var theme_name = theme_json[i].name;
            var obj = $("."+class_name+":contains(" + theme_name + ")");
            console.log(obj.html());
            if (obj != null) {
                obj.parent().prev().css({
                    "background-position": theme_json[i].position,
                    "background-size": theme_json[i].size
                });
            }
        }
    }