function A3LUploadImgSinBoton(n){var i="<!--<input id=\"id_input_file\" style=\"DISPLAY: none\" type=\"file\" multiple=\"multiple\">--><img class=\"{{class_img}}\" id=\"{{id_img}}\" src=\"{{src_default}}\"><script>console.log('foti UC');gx.fx.obs.addObserver(\"{{observer}}\", window, setUploadBtn);function setUploadBtn(){\t\tconsole.log('setUploadBtn 11 #Object_{{id_fileinput}}');\t$(\"#Object_{{id_fileinput}}\").hide();\t\tinputFile = document.getElementById('{{id_fileinput}}');\t/*console.log('setUploadBtn 3 ' + inputFile); */\tif(inputFile){\t\tinputFile.onchange = evt => {\t\t\tconsole.log('change!');\t\t\tconst [file] = inputFile.files;\t\t\t\t\t\tconsole.log(' ' + file);\t\t\t\t\t\tif (file) {\t\t\t\t\t\t\t\t\t\t\t\tconsole.log(' id {{id_img}}');\t\t\t\tdocument.getElementById('{{id_img}}').src = URL.createObjectURL(file);\t\t\t\t/*gx.dom.byId(\"{{{imageURI_id}}}\")[\"value\"] = document.getElementById('{{id_img}}').src;*/\t\t\t\t\t\t\t\tconsole.log('voila! ' + URL.createObjectURL(file));\t\t\t}\t\t}\t}\tconsole.log('fin');\t}<\/script>",r,t;Mustache.parse(i);this.show=function(){r=n(this.getContainerControl());this.setHtml(Mustache.render(i,this));this.renderChildContainers()};this.Scripts=[];this.autoToggleVisibility=!0;t={};this.renderChildContainers=function(){r.find("[data-slot][data-parent='"+this.ContainerName+"']").each(function(i,r){var e=n(r),f=e.attr("data-slot"),u;u=t[f];u||(u=this.getChildContainer(f),t[f]=u,u.parentNode.removeChild(u));e.append(u);n(u).show()}.closure(this))}}