function A3LUploadImg(n){var i='<!--<input id="id_input_file" style="DISPLAY: none" type="file" multiple="multiple">--><img class="{{class_img}}" id="{{id_img}}" src="{{src_default}}"><input  type="button" value="{{caption}}"  class="{{class}}" id="{{id_btn}}" onClick="triggerFileClick()" /><script>console.log(\'foto UC\');/*gx.fx.obs.addObserver("gx.onload", window, setUploadBtn);*/gx.fx.obs.addObserver("{{observer}}", window, setUploadBtn);function triggerFileClick(){\t\tconsole.log(\'trigger! \');\t\t/*\t$(\'#{{id_fileinput}}\').show().click().hide();\t*/\t\tconsole.log(\'trigger clicko\');\t}function setUploadBtn(){\t\tconsole.log(\'setUploadBtn 1 src_default {{src_default}}\');\t\t\t$("#{{id_fileinput}}").hide();\t$("#Object_{{id_fileinput}}").hide();\t\tconsole.log(\'a setUploadBtn 2 {{id_fileinput}}\');\t\tinputFile = document.getElementById(\'{{id_fileinput}}\');\t/*console.log(\'setUploadBtn 3 \' + inputFile); */\tif(inputFile){\t\tinputFile.onchange = evt => {\t\t\tconsole.log(\'change\');\t\t\tconst [file] = inputFile.files;\t\t\t/*console.log(\' \' + file);*/\t\t\tif (file) {\t\t\t\t\t\t\t\t\t\t\t\t/*console.log(\'{{id_img}}\');*/\t\t\t\tdocument.getElementById(\'{{id_img}}\').src = URL.createObjectURL(file);\t\t\t\tgx.dom.byId("{{{imageURI_id}}}")["value"] = document.getElementById(\'{{id_img}}\').src;\t\t\t\tconsole.log(\'voila!\');\t\t\t}\t\t}\t}\tconsole.log(\'fin\');\t}<\/script>',r,t;Mustache.parse(i);this.show=function(){r=n(this.getContainerControl());this.setHtml(Mustache.render(i,this));this.renderChildContainers()};this.Scripts=[];this.autoToggleVisibility=!0;t={};this.renderChildContainers=function(){r.find("[data-slot][data-parent='"+this.ContainerName+"']").each(function(i,r){var e=n(r),f=e.attr("data-slot"),u;u=t[f];u||(u=this.getChildContainer(f),t[f]=u,u.parentNode.removeChild(u));e.append(u);n(u).show()}.closure(this))}}