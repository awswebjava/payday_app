﻿function DVelop_WorkWithPlusUtilities(){function n(n,t){return n?t.index()==0?0:t.parent().width()-(t.position().left+t.width()):t.position().left}function t(n,t){return n?t.parent().width()-t.position().left:t.position().left+t.width()}function i(n){return n.hasClass("TabsWithRightActions")||n.parent().parent().parent().parent().hasClass("TabsWithRightActions")}this.Width;this.Height;this.EnableAutoUpdateFromDocumentTitle;this.EnableFixObjectFitCover;this.EnableFloatingLabels;this.EnableConvertComboToBootstrapSelect;this.EnableUpdateRowSelectionStatus;this.AutoUpdateFromDocumentTitle_Enabled;this.CurrentTab_ReturnUrl;this.show=function(){var n;if(!this.initialized&&(this.initialized=!0,wwp.settings.columnsSelector.AllowColumnResizing=this.AllowColumnResizing,wwp.settings.columnsSelector.AllowColumnReordering=this.AllowColumnReordering,wwp.settings.columnsSelector.AllowColumnDragging=this.AllowColumnDragging,wwp.settings.columnsSelector.AllowColumnsRestore=this.AllowColumnsRestore,wwp.settings.columnsSelector.InfiniteScrolling=this.ComboLoadType=="InfiniteScrolling",wwp.settings.columnsSelector.InfiniteScrollingPage=this.InfiniteScrollingPage,wwp.settings.columnsSelector.RestoreColumnsIconClass=this.RestoreColumnsIconClass,wwp.settings.pagBar.IncludeGoTo=this.PagBarIncludeGoTo,wwp.labels.UpdateButtonText=this.UpdateButtonText,wwp.labels.AddNewOption=this.AddNewOption,wwp.labels.OnlySelectedValues=this.OnlySelectedValues,wwp.labels.MultipleValuesSeparator=this.MultipleValuesSeparator,wwp.labels.SelectAll=this.SelectAll,wwp.labels.SortASC=this.SortASC,wwp.labels.SortDSC=this.SortDSC,wwp.labels.AllowGroupText=this.AllowGroupText,wwp.labels.FixLeftText=this.FixLeftText,wwp.labels.FixRightText=this.FixRightText,wwp.labels.LoadingData=this.LoadingData,wwp.labels.CleanFilter=this.CleanFilter,wwp.labels.RangeFilterFrom=this.RangeFilterFrom,wwp.labels.RangeFilterTo=this.RangeFilterTo,wwp.labels.RangePickerInviteMessage=this.RangePickerInviteMessage,wwp.labels.NoResultsFound=this.NoResultsFound,wwp.labels.SearchButtonText=this.SearchButtonText,wwp.labels.SearchMultipleValuesButtonText=this.SearchMultipleValuesButtonText,wwp.labels.ColumnSelectorFixedLeftCategory=this.ColumnSelectorFixedLeftCategory,wwp.labels.ColumnSelectorFixedRightCategory=this.ColumnSelectorFixedRightCategory,wwp.labels.ColumnSelectorNotFixedCategory=this.ColumnSelectorNotFixedCategory,wwp.labels.ColumnSelectorNoCategoryText=this.ColumnSelectorNoCategoryText,wwp.labels.ColumnSelectorFixedEmpty=this.ColumnSelectorFixedEmpty,wwp.labels.ColumnSelectorRestoreTooltip=this.ColumnSelectorRestoreTooltip,wwp.labels.PagBarGoToCaption=this.PagBarGoToCaption,wwp.labels.PagBarGoToIconClass=this.PagBarGoToIconClass,wwp.labels.PagBarGoToTooltip=this.PagBarGoToTooltip,gx.fx.obs.addObserver("gx.onafterevent",window,function(n){return function(){SetMinWidthTotalizers();n.EnableUpdateRowSelectionStatus&&n.UpdateRowSelectedStatus(!0);n.EnableFloatingLabels&&n.FloatingLabels();n.EmpowerTabs&&n.ExecEmpowerTabs();n.EnableFixObjectFitCover&&WWP_IsIE()&&n.FixObjectFitCover();n.EnableConvertComboToBootstrapSelect&&(wwp_currentDDO!=null&&(ApplyBootstrapSelect_resetSelection(wwp_currentDDO.ddoControl,wwp_currentDDO.target),wwp_currentDDO=null),ApplyBootstrapSelect());n.PorcessDetailWCs();FixCheckboxDoubleClick()}}(this)),n=this,n.EnableConvertComboToBootstrapSelect&&$.each(["grid.onafterrender","gx.endprocessing","grid.onafterrefresh"],function(t,i){gx.fx.obs.addObserver(i,window,function(){return function(){ApplyBootstrapSelect()}}(n))}),gx.fx.obs.addObserver("gx.onload",window,function(n){return function(){SetMinWidthTotalizers();n.EnableFloatingLabels&&n.FloatingLabels();n.EmpowerTabs&&n.ExecEmpowerTabs();n.EnableFixObjectFitCover&&WWP_IsIE()&&n.FixObjectFitCover();n.EnableConvertComboToBootstrapSelect&&ApplyBootstrapSelect();n.PorcessDetailWCs()}}(this)),gx.fx.obs.addObserver("gx.onunload",window,function(n){return function(){n.initialized=!1}}(this)),this.EnableUpdateRowSelectionStatus&&gx.fx.obs.addObserver("gx.onclick",window,function(n){return function(){n.UpdateRowSelectedStatus(!0)}}(this)),this.EnableAutoUpdateFromDocumentTitle&&!this.AutoUpdateFromDocumentTitle_Enabled)){this.AutoUpdateFromDocumentTitle_Enabled=!0;var t=document.querySelector("head > title"),i=window.MutationObserver||window.WebKitMutationObserver||window.MozMutationObserver,r=new i(function(n){n.forEach(function(n){$(".AutoUpdateFromDocumentTitle").text(n.target.textContent)})});r.observe(t,{subtree:!0,characterData:!0,childList:!0})}SetMinWidthTotalizers();this.EnableFloatingLabels&&this.FloatingLabels();this.EmpowerTabs&&this.ExecEmpowerTabs();this.EnableConvertComboToBootstrapSelect&&ApplyBootstrapSelect();this.PorcessDetailWCs();window.frameElement!=null&&window.frameElement.urlHist!=null&&(window.frameElement.WWPUtils=this,window.frameElement.CurrentTab_ReturnUrl!=null&&(this.CurrentTab_ReturnUrl=window.frameElement.CurrentTab_ReturnUrl))};this.updateCurrentTab_ReturnUrl=function(){var t,n;window.frameElement!=null&&window.frameElement.urlHist!=null&&(window.frameElement.urlHist.length>0?(this.CurrentTab_ReturnUrl=window.frameElement.urlHist[window.frameElement.urlHist.length-1],t=window.frameElement.contentWindow.location+"",t.indexOf("#")>=0&&(n=this.CurrentTab_ReturnUrl,n.indexOf("#")>=0&&(n=n.substring(0,n.indexOf("#"))),WWP_startsWith(t,n)&&(this.CurrentTab_ReturnUrl=t,window.frameElement.urlHist[window.frameElement.urlHist.length-1]=this.CurrentTab_ReturnUrl)),window.frameElement.CurrentTab_ReturnUrl=this.CurrentTab_ReturnUrl):window.frameElement.CurrentTab_ReturnUrl=null)};this.CurrentTab_Return=function(){window.frameElement!=null&&window.frameElement.urlHist!=null&&window.frameElement.urlHist.length>1&&window.frameElement.urlHist.splice(window.frameElement.urlHist.length-2,2)};this.DetailWebComponent_Close=function(n,t){WWPActions.GridDetailWebComponent_Close(n,t)};this.FixObjectFitCover=function(){WWP_IsIE()&&$("img.ObjectFitCover").each(function(){this.getAttribute("src")!=""&&($(this).css("background-image","url('"+this.getAttribute("src")+"')"),$(this).addClass("ObjectFitCoverFix"),this.setAttribute("src",""))})};this.UpdateRowSelectedStatus=function(n){if($(".TableWithSelectableGrid").each(function(){$(this).toggleClass("WWPRowSelected",$(this).find("tr.gx-row-selected").length>0);$(this).toggleClass("WWPMultiRowWOPagingSelected",$(this).find("tr input[value='true']:not([disabled])").length>0)}),n){var t=this;window.setTimeout(function(){t.UpdateRowSelectedStatus(!1)},100)}};this.PorcessDetailWCs=function(){var n=this;$("td.WCD_ActionColumn").each(function(){var i,t,r;if(!$(this).hasClass("WCD_processed")&&($(this).addClass("WCD_processed"),i=$(".WCD_"+$(this).closest("table")[0].id.replace("ContainerTbl","").toUpperCase()),t=WWP_getWCId(null,this,i),t!=null&&t!=""))$(this).on("click",function(r){var d,h,c,l,a,v,s,p,w,y,b,u,k,g;if(r.target.tagName!="P"&&r.target.tagName!="TD")if($(this).hasClass("WCD_Expanded"))r.preventDefault(),r.stopPropagation(),$(this).removeClass("WCD_Expanded"),$("#"+t).length>0&&(u=$("#"+t),k=u.parent(),k.hasClass("SectionWCDContainer")&&(g=this,k.slideUp(function(){u=u.detach();u.length==1?u.appendTo(i[0]):(WWP_Debug_Log(!1,"detach div"),i.html('<div id="'+t+'"><\/div>'),u=i.find(">div"));u.html("");$(this).closest(".WCD_tr").prev().find(".WCD_ActionColumn").removeClass("WCD_Expanded");$(this).closest(".WCD_tr").remove();typeof SetMinWidthPaginationBars=="function"&&SetMinWidthPaginationBars();var n=$(g).closest(".gx-grid").data("WWP.Empowerer");n!=null&&n.ColumnsOrHeaderFixer!=null&&(n.ColumnsOrHeaderFixer.WCD_Collapsed(),n.ColumnsOrHeaderFixer.settings.right>0&&n.ColumnsOrHeaderFixer.Refresh())})));else{d=$(this).parent().find(".WCD_Expanded");$(this).addClass("WCD_Expanded");WWP_startsWith(t,"gxHTMLWrp")&&(h=$("#"+t.substring(9)),h.length==1&&h.parent()[0].tagName=="BODY"&&h.remove());c=$(this).closest(".gx-grid").data("WWP.Empowerer");c!=null&&c.ColumnsOrHeaderFixer!=null&&c.ColumnsOrHeaderFixer.WCD_PrepareToExpand(this.parentNode);l=document.createElement("tr");$(l).addClass("WCD_tr");this.parentNode.parentNode.insertBefore(l,this.parentNode.nextSibling);a=$(this).closest("table");v=a.data("IS_ProcessedRecords");v!=null&&v==a.find(">tbody").children().length-1&&a.data("IS_ProcessedRecords",v+1);var f=!0,o=document.createElement("div"),e=document.createElement("div");$(e).addClass("SectionWCDContainer");s=document.createElement("td");s.colSpan=$(this).parent().find(">td:visible").length;l.appendChild(s);$(e).css("display","none");f||s.appendChild(e);$("#"+t).length>0?(p=$("#"+t),w=$(p).parent(),w.hasClass("SectionWCDContainer")&&(f,w.slideUp(function(){d.removeClass("WCD_Expanded");$(this).closest(".WCD_tr").prev().find(".WCD_ActionColumn").removeClass("WCD_Expanded");$(this).closest(".WCD_tr").remove()})),y=p.detach(),y.find(".gxwebcomponent-body").addClass("Invisible"),y.appendTo(e),y.html("")):(b=document.createElement("div"),b.id=t,e.appendChild(b));f&&(o.innerHTML='<div class="WCD_Loading"><i class="fas fa-spinner fa-spin"><\/i><\/div>',s.appendChild(o),o.appendChild(e),$(o).css("display","none"),$(o).slideDown(function(){$(e).css("min-height",$(this).height())}));n.DWC_Timer!=null&&clearInterval(n.DWC_Timer);n.DWC_Timer=setInterval(function(){n.DetailWC_WCLoaded(f,t)},f?3e3:500);f&&(n.DetailWC_wcRenderHandler=function(i){i.containerControl==$("#"+t)[0]&&n.DetailWC_WCLoaded(f,t)},gx.fx.obs.addObserver("webcom.render",window,n.DetailWC_wcRenderHandler))}});$(this).hasClass("WCD_Opened")&&($(this).removeClass("WCD_Opened"),r=$(this).find("a, img").first(),window.setTimeout(function(){r.click()},0))})};this.DetailWC_WCLoaded=function(n,t){var i,r;this.DWC_Timer!=null&&(clearInterval(this.DWC_Timer),this.DWC_Timer=null);this.DetailWC_wcRenderHandler==null&&n||(i=this.DetailWC_wcRenderHandler,this.DetailWC_wcRenderHandler!=null&&delete this.DetailWC_wcRenderHandler,r=this,window.setTimeout(function(){var u=$("#"+t).closest(".SectionWCDContainer");n&&u.parent().find(".WCD_Loading").remove();u.slideDown(function(){$(this).css("min-height","");typeof SetMinWidthPaginationBars=="function"&&SetMinWidthPaginationBars();var n=$(this).closest(".gx-grid").data("WWP.Empowerer");n!=null&&n.ColumnsOrHeaderFixer!=null&&n.ColumnsOrHeaderFixer.settings.right>0&&n.ColumnsOrHeaderFixer.Refresh()});i!=null&&gx.fx.obs.deleteObserver("webcom.render",window,i);r.UpdateAllTabSliders()},150))};this.FloatingLabels=function(){var n=this;$(".AttributeFL>input:checkbox").on("click",function(){$(".AttributeFL").each(function(){n.FloatingLabels_AnimateLabel(this,null)});window.setTimeout(function(){n.FloatingLabels_WatchReadonlyAttributes()},100)});$(".ReadonlyAttributeFL>input:checkbox").each(function(){n.FloatingLabels_AnimateLabel_ToggleClases(this,!0,!1)});$("img.ReadonlyAttributeFL").each(function(){n.FloatingLabels_AnimateLabel_ToggleClases(this,!0,!1)});$(".AttributeFL").each(function(){if(!n.FloatingLabels_IsEventBound(this))$(this).on("focus blur",function(t){n.FloatingLabels_AttributeFocused(this,t)});if(WWP_IsIE()&&(($(this).get(0).onblur+""+$(this).get(0).onchange).indexOf("gx.date.")>=0||$(this).parent().find(".gx-image-link").length>0))$(this).parent().parent().off("DOMSubtreeModified").on("DOMSubtreeModified",function(){var t=$(this).find(".AttributeFL").get(0);if(t!=null&&!n.FloatingLabels_IsEventBound(t))$(t).on("focus blur",function(t){n.FloatingLabels_AttributeFocused(this,t)})});n.FloatingLabels_AnimateLabel(this,null);n.FloatingLabels_WatchReadonlyAttribute(this)});$("input[type=date]").each(function(){if(!n.FloatingLabels_IsEventBound(this,"change","FloatingLabels_AnimateLabel"))$(this).on("change",function(){var t=$(this).attr("id"),i;WWP_endsWith(t,"-picker")&&(i=$("#"+t.substring(0,t.length-7)),i.length==1&&n.FloatingLabels_AnimateLabel(i[0],null))})})};this.ExecEmpowerTabs=function(){var r=this,u;if($(".gx_usercontrol.ViewTab:not(.TabEmpowered)").each(function(){var o=$(this),u,s,e,h,f;o.addClass("TabEmpowered");u=document.createElement("div");u.innerHTML='<div class="moveLeft"><div class="moveLeftArrow"><\/div><\/div><div class="moveRight"><div class="moveRightArrow"><\/div><\/div>';u.className="tabsSlider";o[0].insertBefore(u,o[0].children[0]);s=o.find(">ul").detach();s.appendTo(u);e=$("body").css("direction")=="rtl";e&&$(u).addClass("Tabs_RTL");h=e?"right":"left";f=s;$(u).find(">.moveRight").click(function(){var s=null,y=$(f).find(">li:last-child()"),p=t(e,y),o=$(f).find(">li:first-child()"),c=$(u).width(),a=i($(u).parent()),l,v;a&&(c-=$(this).outerWidth());l=parseInt($(f).css(h),10);v=$(f).find(">li").length;$(f).find(">li").each(function(){return(s==null&&n(e,$(this))>=l*-1&&(s=$(this)),r.ForceShowSelectedLI&&$(this).hasClass("active"))?(o=$(this),!1):!r.ForceShowSelectedLI&&c-l-(!a&&$(this).index()<v-1?$(u).find(">.moveRight").outerWidth():0)<t(e,$(this))||c-$(u).find(">.moveLeft").outerWidth()>=p-n(e,$(this))?(o=$(this),!1):void 0});o[0]==s[0]&&o.next().length==1&&(o=o.next());r.SliderMoveTo(f,u,o,e)});$(u).find(">.moveLeft").click(function(){var l,a,s,y,o,p;if(r.ForceShowSelectedLI)o=$(f).find(">li.active"),l=$(f).find(">li:last-child()"),o[0]==l[0]&&(a=t(e,l),s=$(u).width(),$(f).find(">li").each(function(){if(s-$(u).find(">.moveLeft").outerWidth()>=a-n(e,$(this)))return o=$(this),!1})),r.SliderMoveTo(f,u,o,e);else{var c=$(f).find(">li:first-child()"),s=$(u).width(),v=i($(u).parent());v&&(s-=$(u).find(">.moveRight").outerWidth());y=parseInt($(f).css(h),10);$(f).find(">li").each(function(){if(n(e,$(this))>=y*-1)return c=$(this),!1});c!=null&&(o=$(f).find(">li:first-child()"),p=$(f).find(">li").length,$(f).find(">li").each(function(){if(n(e,$(this))+s-($(this).index()>0?$(u).find(">.moveLeft").outerWidth():0)-(!v&&$(this).index()<p-1?$(u).find(">.moveRight").outerWidth():0)>n(e,c))return o=$(this),!1}),o[0]==c[0]&&o.prev().length==1&&(o=o.prev()),r.SliderMoveTo(f,u,o,e))}});$(f).on("transitionend webkitTransitionEnd oTransitionEnd MSTransitionEnd",function(){r.UpdateSlider(f)});r.UpdateSlider(f)}),!this.TabsEmpowererEvents){this.TabsEmpowererEvents=!0;u=this;$(window).resize(function(){u.UpdateAllTabSliders()});gx.fx.obs.addObserver("gx.onload",window,function(n){return function(){n.UpdateAllTabSliders()}}(this));$(window).on("load",function(){u.UpdateAllTabSliders()});gx.fx.obs.addObserver("gx.onafterevent",window,function(n){return function(){n.UpdateAllTabSliders()}}(this))}};this.SliderMoveTo=function(r,u,f,e){var o;this.ForceShowSelectedLI=!1;o=n(e,f)*-1;o<0&&(o+=$(u).find(">.moveLeft").width());var s=$(r).parent(),h=s.width(),c=i(s.parent());c&&(h-=s.find(">.moveRight").outerWidth());$(u).toggleClass("NeedSliderLeft",o<0);c&&$(u).hasClass("NeedSliderRight")||$(u).toggleClass("NeedSliderRight",h-o<t(e,$(r).find(">li:last-child()")));$(r).css(e?"right":"left",o+"px")};this.UpdateAllTabSliders=function(){var n=this;$(".gx_usercontrol.ViewTab.TabEmpowered").each(function(){n.UpdateSlider($(this).find(">.tabsSlider>ul")[0])})};this.UpdateSlider=function(r,u){var e=$("body").css("direction")=="rtl",o=parseInt($(r).css(e?"right":"left"),10),f=$(r).parent(),h=$(r).find(">li").length>0,s,c,l;h?(s=f.width(),i(f.parent())&&(s-=f.find(">.moveRight").outerWidth()),f.length>0&&f.toggleClass("NeedSliderRight",h&&s-o<t(e,$(r).find(">li:last-child()"))).toggleClass("NeedSliderLeft",h&&o<0),this.ForceShowSelectedLI&&(c=$(r).find(">li.active"),s-o<t(e,c)?$(r).parent().find(">.moveRight").click():o<n(e,c)*-1?$(r).parent().find(">.moveLeft").click():this.ForceShowSelectedLI=!1),u==null&&$(r).css("position")=="absolute"&&$(r).closest(".entering").length==1&&(l=this,setTimeout(function(){l.UpdateSlider(r,!0)},1))):(f.toggleClass("NeedSliderRight",!1),f.toggleClass("NeedSliderLeft",!1))};this.FloatingLabels_IsEventBound=function(n,t,i){var f,r,u;if(t==null&&(t="focus"),i==null&&(i="FloatingLabels_AttributeFocused"),f=jQuery._data(n,"events"),f!=null){if(r=jQuery._data(n,"events")[t],r===undefined||r.length===0)return!1;for(u=0;u<r.length;u++)if((r[u].handler+" ").indexOf(i)>=0)return!0}return!1};this.FloatingLabels_AttributeFocused=function(n,t){var i=this;"focus"===t.type?$(".AttributeFL").each(function(){i.FloatingLabels_AnimateLabel(this,null)}):this.FloatingLabels_WatchReadonlyAttributes();this.FloatingLabels_AnimateLabel(n,t)};this.FloatingLabels_WatchReadonlyAttributes=function(){var n=this;$(".ReadonlyAttributeFL,span.AttributeFL, .Readonlyform-control.AttributeFL").each(function(){var t=$(this).closest(".form-group").find(".AttributeFL:not(.Readonlyform-control)").get(0);t!=null&&n.FloatingLabels_WatchReadonlyAttribute(t)})};this.FloatingLabels_WatchReadonlyAttribute=function(n){var t=this;$(n).closest(".form-group").find(".ReadonlyAttributeFL, span.AttributeFL, .Readonlyform-control.AttributeFL").parent().off("DOMSubtreeModified").on("DOMSubtreeModified",function(){var n=$(this).closest(".form-group").find(".AttributeFL:not(.Readonlyform-control)").get(0);if(n!=null&&($(n.parentNode).find("span").length==0?setTimeout(function(){t.FloatingLabels_AnimateLabel(n,null)},200):t.FloatingLabels_AnimateLabel(n,null)),this.tagName!="P"){$(this).off("DOMSubtreeModified");$(this).find(".ReadonlyAttributeFL, span.AttributeFL, .Readonlyform-control.AttributeFL").parent().off("DOMSubtreeModified").on("DOMSubtreeModified",function(){var n=$(this).closest(".form-group").find(".AttributeFL:not(.Readonlyform-control)").get(0);n!=null&&t.FloatingLabels_AnimateLabel(n,null)})}})};this.FloatingLabels_AnimateLabel=function(n,t){var i,u,r,f;(n.tagName!="SPAN"||n.className.indexOf("Readonly")==0||(n=$(n).closest(".gx-attribute").find(".form-control")[0],n!=null))&&(u=($(n).get(0).onblur+""+$(n).get(0).onchange).indexOf("gx.date.")>=0,u?i=$(n).val().replace("/","").replace("/","").trim():n.tagName=="SELECT"?i=$(n).find("option:selected").text():(i=n.value,i=="0"&&($(n).get(0).onblur+""+$(n).get(0).onchange).indexOf("gx.num.")>=0&&(i="")),r=!1,r=$(n.parentNode).is(":visible")?$(n).hasClass("ReadonlyExtendedCombo")||!$(n).is(":visible")&&$(n).closest(".gx-attribute").find("span").is(":visible"):$(n).css("display")=="none"&&$($(n).closest(".gx-attribute").find("span")).css("display")!="none",r=r&&(n.id==null||!n.id.match(/_GXI$/)),f=!r&&n.type!="checkbox"&&(n.tagName!="SPAN"||$(n).find(">input[type=checkbox]").length==0)&&n.type!="file"&&n.type!="textarea"&&n.tagName!="IMG"&&!$(n).hasClass("gx-radio-button")&&n.tagName!="LABEL"&&(n.id==null||!n.id.match(/_GXI$/))&&!(t!=null&&"focus"===t.type||i!=null&&i.length>0||$(n).is(":focus")),this.FloatingLabels_AnimateLabel_ToggleClases(n,r,f))};this.FloatingLabels_AnimateLabel_ToggleClases=function(n,t,i){var r,u,f,e;$(n).hasClass("ReadonlyExtendedCombo")?(r=$(n.parentNode.parentNode).hasClass("MergeDataCell")&&$(n.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.previousSibling).hasClass("MergeLabelCell"),r?($(n.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.previousSibling).addClass("FloatingLabelReadonly").find("span.Label").addClass("AttributeFLLabel").addClass("control-label"),$(n.parentNode.parentNode.parentNode.parentNode.parentNode).addClass("TableMergedReadonlyExtendedCombo")):$(n.parentNode.parentNode.previousSibling).hasClass("MergeLabelCell")&&$(n.parentNode.parentNode.previousSibling).addClass("FloatingLabelReadonly").find("span.Label").addClass("AttributeFLLabel").addClass("control-label")):$(n).hasClass("ExtendedCombo")?(r=$(n.parentNode).hasClass("MergeDataCell")&&$(n.parentNode.parentNode.parentNode.parentNode.parentNode.previousSibling).hasClass("MergeLabelCell"),r&&$(n.parentNode.parentNode.parentNode.parentNode).addClass("TableMergedExtendedCombo")):(r=$(n).closest(".gx-attribute").length==1&&$($(n).closest(".gx-attribute").get(0).parentNode).hasClass("MergeDataCell")&&$($(n).closest(".gx-attribute").get(0).parentNode.parentNode.parentNode.parentNode.parentNode.previousSibling).hasClass("MergeLabelCell"),r?(u=$(n).closest(".gx-attribute").get(0),$(u.parentNode).toggleClass("FloatingLabelEmpty",i),$(u.parentNode).toggleClass("FloatingLabelReadonly",t),$(u.parentNode.parentNode.parentNode.parentNode.parentNode.previousSibling).toggleClass("FloatingLabelEmpty",i).toggleClass("FloatingLabelReadonly",t).find("span.Label").addClass("AttributeFLLabel").addClass("control-label")):$(n).closest(".form-group").toggleClass("FloatingLabelEmpty",i).toggleClass("FloatingLabelReadonly",t),i?(f=$(n).attr("placeholder"),f!=null&&f!=""&&($(n).attr("origPH",f),$(n).attr("placeholder",""))):(e=$(n).attr("origPH"),e!=null&&e!=""&&$(n).attr("placeholder",e)))}}function ApplyBootstrapSelect(){$("select.ConvertToDDO:not(.selectpicker_DV)").each(function(n,t){var i=$(t);i.val(0);i.addClass("selectpicker_DV").selectpicker_DV({noneSelectedText:"",showContent:!1,dropupAuto:!1,size:!1});i.on("show.bs.select",function(){$(this).focus()});ApplyBootstrapSelect_updateDDO(t);i=i.parent();i.on("changed.bs.select",function(n){$(this).find(">select").hasClass("selectpicker_DV")&&($(this).css("display","none"),wwp_currentDDO={ddoControl:this,target:n.target})});i.on("hidden.bs.dropdown",function(n){var t=$(this).closest("td");t.length==1&&t.css("z-index")==parseInt(t.css("z-index"))&&t.css("z-index",parseInt(t.css("z-index"))-100);ApplyBootstrapSelect_setSectionGridMinHeight(n.target,!1)});i.on("shown.bs.dropdown",function(n){var t=$(this).closest("td");t.length==1&&t.css("z-index")==parseInt(t.css("z-index"))&&t.css("z-index",parseInt(t.css("z-index"))+100);WWP_dropdownAutoPosition(n.target,$(n.target).find(".dropdown-menu > ul")[0]);ApplyBootstrapSelect_setSectionGridMinHeight(n.target,!0)})})}function ApplyBootstrapSelect_resetSelection(n,t){$(t).val(0);$(t).selectpicker_DV("refresh");ApplyBootstrapSelect_updateDDO(t);$(n).css("display","")}function ApplyBootstrapSelect_updateDDO(n){var i=$(n).parent(),r,t;i.find("[data-original-index=0]").hide();r=i.find("button").get(0);t=i.find("button > span").get(0);t!=null&&t.innerText.indexOf(";")>=0&&(t.parentNode.childNodes[0].tagName!="I"&&$("<i><\/i>").addClass(t.innerText.substring(t.innerText.indexOf(";")+1)).insertBefore(t),t.innerText=t.innerText.substring(0,t.innerText.indexOf(";")));r.title="";i.find("li").each(function(n,t){var i=t.childNodes[0],r;i.childNodes[0].tagName!="I"&&i.childNodes[0].innerText.indexOf(";")>=0&&(r=document.createElement("i"),r.className=i.childNodes[0].innerText.substring(i.childNodes[0].innerText.indexOf(";")+1),i.childNodes[0].innerText=i.childNodes[0].innerText.substring(0,i.childNodes[0].innerText.indexOf(";")),i.insertBefore(r,i.childNodes[0]))})}function ApplyBootstrapSelect_setSectionGridMinHeight(n,t){var u,i,e,f,r;if(!$(n).hasClass("dropup")){for(u=$(n).find(".dropdown-menu > ul").get(0),i=u.parentElement,e=0;e<18;e++)if(i!=null&&($(i).is("table.table-responsive")||$(i).css("overflow")!="auto"&&$(i).css("overflow-x")!="auto"))i=i.parentElement;else break;($(i).css("overflow")=="auto"||$(i).css("overflow-x")=="auto")&&(t?(f=$(u).offset().top+$(u).outerHeight()+12-$(i).offset().top,$(i).css({"min-height":f+"px"}),hasScroll($(i),!1)&&(f+=getScrollBarWidth(),$(i).css({"min-height":f+"px"}))):$(i).css({"min-height":""}))}r=$(n).closest("td");r.css("position")=="relative"&&(t?r.data("zIndexIncresed")==null&&parseInt(r.css("z-index"))>0&&(r.css("z-index",parseInt(r.css("z-index"))+10),r.data("zIndexIncresed","T")):r.data("zIndexIncresed")=="T"&&(r.css("z-index",parseInt(r.css("z-index"))-10),r.data("zIndexIncresed",null)))}function SetMinWidthTotalizers(){$("table.GridWithTotalizer").each(function(){var u=$(this).attr("id"),f=u.substring(0,u.indexOf("ContainerTbl")).toUpperCase()+"TABLETOTALIZER",i,t;if($("#"+f).length>0&&$(this).data("wwpTotRowAdded")==null&&($(this).data("wwpTotRowAdded","T"),i=$("#"+f),i.css({display:"none"}),$(this).css("display")!="none"&&$(this).find(">tbody>tr").length>0)){t=document.createElement("tr");t.className=$(this).find(">tbody>tr:not(.DVGroupByRow):eq(0)")[0].className;$(t).addClass("TotalizerRow");t.style=$(this).find(">tbody>tr:not(.DVGroupByRow):eq(0)")[0].style;var e=!i.parent().parent().hasClass("Invisible"),r=!1,n=null;$(this).find(">tbody>tr:not(.DVGroupByRow):eq(0)>td").each(function(){var u=document.createElement("td");u.className=this.className;n==null&&u.className.indexOf("FirstColumn")>0&&(n=u.className.substring(u.className.lastIndexOf(" ")+1),n=WWP_replaceAll(n,"FirstColumn",""));n!=null?($(u).removeClass(n+"FirstColumn"),$(u).removeClass(n)):u.className.indexOf("SingleCell")>0&&(u.className=u.className.substring(0,u.className.lastIndexOf(" ")),u.className=u.className.substring(0,u.className.lastIndexOf(" ")));u.style.display=this.style.display;e&&$(u).css("background-color",i.css("background-color"));$("body").css("direction")=="rtl"?$(u).css("text-align",$(this).css("text-align")=="left"?"right":"left"):$(u).css("text-align",$(this).css("text-align"));$(u).append(i.find("td:eq("+$(this).index()+")>*").clone());$(u).find("[id]").removeAttr("id").removeAttr("name");t.appendChild(u);r=r||$(u).css("display")!="none"&&u.innerHTML!=""});r&&$(this).find(">tfoot").prepend(t);$(this).parent().toggleClass("TotalizerFooterVisible",r)}});$("table.TableTotalizerAl").each(function(){var n=$(this).closest(".row").prev();n.length==1&&n.find(">div>div").length==1&&n.find(">div>div").children().length==0&&window.setTimeout(function(){SetMinWidthTotalizers()},100)})}function FixCheckboxDoubleClick(){(!/chrom(e|ium)/.test(navigator.userAgent.toLowerCase())||/edge/.test(navigator.userAgent.toLowerCase()))&&$("html").toggleClass("notChrome",!0);$(".gx-grid>table>tbody>tr>td>label>input:checkbox:not(.dblClickFix)").each(function(){if($(this).addClass("dblClickFix"),this.onclick==null){this.disabledAux=0;$(this).on("click",function(){if(this.value+""==this.checked+""&&WWP_IsIE())return!1;this.disabledAux++;var n=this.disabledAux==1,t=this;return window.setTimeout(function(){t.disabledAux--},200),n})}})}var wwp_currentDDO=null;$(window).on("load",function(){SetMinWidthTotalizers();FixCheckboxDoubleClick()});$(window).one('load',function(){WWP_VV([['WorkWithPlusUtilities','15.0.4'],['WWP.WorkWithPlusUtilities_FAL','15.1.0'],['WorkWithPlusUtilities_F5','15.1.0']]);});