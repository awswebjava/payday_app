function A3LUploadFile(n){var i='<input  type="button" value="{{caption}}"  class="{{class}}" id="{{id_btn}}" {{multiple}}/><script>\tgx.fx.obs.addObserver("gx.onload", window, A3LUploadFile)\tfunction A3LUploadFile() {\t\tdocument.getElementById("{{idNombreArchivo}}").innerHTML = "";\t\t$("#{{id_file}}").hide();\t\t$("#{{id_btn}}").click(function() {\t\t\t$("#{{id_file}}").show().click().hide();\t\t});\t\t$("#{{id_file}}").change(function() {\t\t\tdocument.getElementById("{{idNombreArchivo}}").innerHTML = document.getElementById("{{id_file}}").value.replace("C:\\fakepath\\", "");\t\t})\t}<\/script>',r,t;Mustache.parse(i);this.show=function(){r=n(this.getContainerControl());this.setHtml(Mustache.render(i,this));this.renderChildContainers()};this.Scripts=[];this.autoToggleVisibility=!0;t={};this.renderChildContainers=function(){r.find("[data-slot][data-parent='"+this.ContainerName+"']").each(function(i,r){var e=n(r),f=e.attr("data-slot"),u;u=t[f];u||(u=this.getChildContainer(f),t[f]=u,u.parentNode.removeChild(u));e.append(u);n(u).show()}.closure(this))}}