function img_uc(n){var i='<img class="{{class_img}}" src="{{src}}">',r,t;Mustache.parse(i);this.show=function(){r=n(this.getContainerControl());this.setHtml(Mustache.render(i,this));this.renderChildContainers()};this.Scripts=[];this.autoToggleVisibility=!0;t={};this.renderChildContainers=function(){r.find("[data-slot][data-parent='"+this.ContainerName+"']").each(function(i,r){var e=n(r),f=e.attr("data-slot"),u;u=t[f];u||(u=this.getChildContainer(f),t[f]=u,u.parentNode.removeChild(u));e.append(u);n(u).show()}.closure(this))}}