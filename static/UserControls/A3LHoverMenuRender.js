function A3LHoverMenu(n){var i='<script>\t/*gx.fx.obs.addObserver("gx.onload", window, setHoverMenu);\t\tfunction setHoverMenu(){*/\t\t$("#{{idContenedor}}").hover(\t\t\tfunction () {\t\t\t\t\teffect = "{{effect}}";\t\t\t\t\tif(effect === \'slide\'){\t\t\t\t\t\t\t$("#{{idMenuExpandido}}").slideIn({{duration}});\t\t\t}\t\t\telse{\t\t\t\t\t\t\t\t\t$("#{{idMenuExpandido}}").fadeIn({{duration}});\t\t\t}\t\t\t\t\t},\t\t\tfunction () {\t\t\t\t\teffect = "{{effect}}";\t\t\t\t\tif(effect === \'slide\'){\t\t\t\t\t\t\t$("#{{idMenuExpandido}}").slideOut({{duration}});\t\t\t}\t\t\telse{\t\t\t\t\t\t\t\t$("#{{idMenuExpandido}}").fadeOut({{duration}});\t\t\t}\t\t\t\t\t}\t\t);/*\t\t$("#{{idMenuExpandido}}").click(function () {\t\t\tconsole.log(\'click hide!!\');\t\t\t$("#{{idMenuExpandido}}").hide();\t\t\t$("#{{idMenuExpandido}}").hover(function (event) {\t\t\t\tevent.stopPropagation();\t\t\t});\t\t});\t\t*/\t\t<\/script>',r,t;Mustache.parse(i);this.show=function(){r=n(this.getContainerControl());this.setHtml(Mustache.render(i,this));this.renderChildContainers()};this.Scripts=[];this.autoToggleVisibility=!0;t={};this.renderChildContainers=function(){r.find("[data-slot][data-parent='"+this.ContainerName+"']").each(function(i,r){var e=n(r),f=e.attr("data-slot"),u;u=t[f];u||(u=this.getChildContainer(f),t[f]=u,u.parentNode.removeChild(u));e.append(u);n(u).show()}.closure(this))}}