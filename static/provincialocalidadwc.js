gx.evt.autoSkip=!1;gx.define("provincialocalidadwc",!0,function(n){var i,u,r,t,f;this.ServerClass="provincialocalidadwc";this.PackageName="web";this.ServerFullClass="web.provincialocalidadwc";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV32Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV15OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV16OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV25IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE");this.AV26IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV8PaiCod=gx.fn.getIntegerValue("vPAICOD",gx.thousandSeparator);this.AV9ProvCod=gx.fn.getIntegerValue("vPROVCOD",gx.thousandSeparator);this.AV8PaiCod=gx.fn.getIntegerValue("vPAICOD",gx.thousandSeparator);this.AV9ProvCod=gx.fn.getIntegerValue("vPROVCOD",gx.thousandSeparator);this.AV32Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV15OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV16OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV25IsAuthorized_Update=gx.fn.getControlValue("vISAUTHORIZED_UPDATE");this.AV26IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE")};this.s132_client=function(){this.DDO_GRIDContainer.SortedStatus=gx.text.trim(gx.num.str(this.AV15OrderedBy,4,0))+":"+(this.AV16OrderedDsc?"DSC":"ASC")};this.e18eh2_client=function(){return this.clearMessages(),this.AV24GridActions==1?this.s162_client():this.AV24GridActions==2&&this.s172_client(),this.AV24GridActions=gx.num.trunc(0,0),this.refreshOutputs([{ctrl:"vGRIDACTIONS"},{av:"AV24GridActions",fld:"vGRIDACTIONS",pic:"ZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.s162_client=function(){this.call("web.localidad",["UPD",this.A46PaiCod,this.A47ProvCod,this.A48LocCod],null,["Mode","PaiCod","ProvCod","LocCod"])};this.s172_client=function(){this.call("web.localidad",["DLT",this.A46PaiCod,this.A47ProvCod,this.A48LocCod],null,["Mode","PaiCod","ProvCod","LocCod"])};this.e11eh2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEPAGE",!1,null,!0,!0)};this.e12eh2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!1,null,!0,!0)};this.e13eh2_client=function(){return this.executeServerEvent("DDO_GRID.ONOPTIONCLICKED",!1,null,!0,!0)};this.e14eh2_client=function(){return this.executeServerEvent("'DOINSERT'",!1,null,!1,!1)};this.e19eh2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e20eh2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];i=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,27,28,29,30,31,32,34,35,36,38,39];this.GXLastCtrlId=39;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",26,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"provincialocalidadwc",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);u=this.GridContainer;u.addSingleLineEdit(48,27,"LOCCOD",gx.getMessage("Cod. Loc."),"","LocCod","int",0,"px",4,4,"right",null,[],48,"LocCod",!0,0,!1,!1,"Attribute",0,"WWColumn hidden-xs");u.addSingleLineEdit(286,28,"LOCNOM",gx.getMessage("Nom. Loc."),"","LocNom","svchar",0,"px",40,40,"left",null,[],286,"LocNom",!0,0,!1,!1,"Attribute",0,"WWColumn");u.addSingleLineEdit(285,29,"LOCCP",gx.getMessage("CP"),"","LocCP","char",0,"px",20,20,"left",null,[],285,"LocCP",!0,0,!1,!1,"Attribute",0,"WWColumn hidden-xs");u.addComboBox("Gridactions",30,"vGRIDACTIONS","","GridActions","int","e18eh2_client",0,!0,!1,0,"px","WWActionGroupColumn");this.GridContainer.emptyText=gx.getMessage("");this.setGrid(u);this.GRIDPAGINATIONBARContainer=gx.uc.getNew(this,33,27,"DVelop_DVPaginationBar",this.CmpContext+"GRIDPAGINATIONBARContainer","Gridpaginationbar","GRIDPAGINATIONBAR");r=this.GRIDPAGINATIONBARContainer;r.setProp("Enabled","Enabled",!0,"boolean");r.setProp("Class","Class","PaginationBar","str");r.setProp("ShowFirst","Showfirst",!1,"bool");r.setProp("ShowPrevious","Showprevious",!0,"bool");r.setProp("ShowNext","Shownext",!0,"bool");r.setProp("ShowLast","Showlast",!1,"bool");r.setProp("PagesToShow","Pagestoshow",5,"num");r.setProp("PagingButtonsPosition","Pagingbuttonsposition","Right","str");r.setProp("PagingCaptionPosition","Pagingcaptionposition","Left","str");r.setProp("EmptyGridClass","Emptygridclass","PaginationBarEmptyGrid","str");r.setProp("SelectedPage","Selectedpage","","char");r.setProp("RowsPerPageSelector","Rowsperpageselector",!0,"bool");r.setDynProp("RowsPerPageSelectedValue","Rowsperpageselectedvalue",10,"num");r.setProp("RowsPerPageOptions","Rowsperpageoptions","5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50","str");r.setProp("First","First","First","str");r.setProp("Previous","Previous","WWP_PagingPreviousCaption","str");r.setProp("Next","Next","WWP_PagingNextCaption","str");r.setProp("Last","Last","Last","str");r.setProp("Caption","Caption",gx.getMessage("WWP_PagingCaption"),"str");r.setProp("EmptyGridCaption","Emptygridcaption","WWP_PagingEmptyGridCaption","str");r.setProp("RowsPerPageCaption","Rowsperpagecaption","WWP_PagingRowsPerPage","str");r.addV2CFunction("AV21GridCurrentPage","vGRIDCURRENTPAGE","SetCurrentPage");r.addC2VFunction(function(n){n.ParentObject.AV21GridCurrentPage=n.GetCurrentPage();gx.fn.setControlValue("vGRIDCURRENTPAGE",n.ParentObject.AV21GridCurrentPage)});r.addV2CFunction("AV22GridPageCount","vGRIDPAGECOUNT","SetPageCount");r.addC2VFunction(function(n){n.ParentObject.AV22GridPageCount=n.GetPageCount();gx.fn.setControlValue("vGRIDPAGECOUNT",n.ParentObject.AV22GridPageCount)});r.setProp("RecordCount","Recordcount","","str");r.setProp("Page","Page","","str");r.addV2CFunction("AV23GridAppliedFilters","vGRIDAPPLIEDFILTERS","SetAppliedFilters");r.addC2VFunction(function(n){n.ParentObject.AV23GridAppliedFilters=n.GetAppliedFilters();gx.fn.setControlValue("vGRIDAPPLIEDFILTERS",n.ParentObject.AV23GridAppliedFilters)});r.setProp("Visible","Visible",!0,"bool");r.setC2ShowFunction(function(n){n.show()});r.addEventHandler("ChangePage",this.e11eh2_client);r.addEventHandler("ChangeRowsPerPage",this.e12eh2_client);this.setUserControl(r);this.DDO_GRIDContainer=gx.uc.getNew(this,37,27,"DDOGridTitleSettingsM",this.CmpContext+"DDO_GRIDContainer","Ddo_grid","DDO_GRID");t=this.DDO_GRIDContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","","str");t.setProp("ActiveEventKey","Activeeventkey","","char");t.setProp("FilteredText_set","Filteredtext_set","","char");t.setProp("FilteredText_get","Filteredtext_get","","char");t.setProp("FilteredTextTo_set","Filteredtextto_set","","char");t.setProp("FilteredTextTo_get","Filteredtextto_get","","char");t.setProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("SelectedColumn","Selectedcolumn","","char");t.setProp("SelectedColumnFixedFilter","Selectedcolumnfixedfilter","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("TitleControlAlign","Titlecontrolalign","","str");t.setProp("Visible","Visible","","str");t.setDynProp("GridInternalName","Gridinternalname","","str");t.setProp("ColumnIds","Columnids","0:LocCod|1:LocNom|2:LocCP","str");t.setProp("ColumnsSortValues","Columnssortvalues","1|2|3","str");t.setProp("IncludeSortASC","Includesortasc","T","str");t.setProp("IncludeSortDSC","Includesortdsc","","str");t.setProp("AllowGroup","Allowgroup","","str");t.setProp("Fixable","Fixable","","str");t.setDynProp("SortedStatus","Sortedstatus","","char");t.setProp("IncludeFilter","Includefilter","","str");t.setProp("FilterType","Filtertype","","str");t.setProp("FilterIsRange","Filterisrange","","str");t.setProp("IncludeDataList","Includedatalist","","str");t.setProp("DataListType","Datalisttype","","str");t.setProp("AllowMultipleSelection","Allowmultipleselection","","str");t.setProp("DataListFixedValues","Datalistfixedvalues","","str");t.setProp("DataListProc","Datalistproc","","str");t.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("FixedFilters","Fixedfilters","","str");t.setProp("Format","Format","","str");t.setProp("SelectedFixedFilter","Selectedfixedfilter","","char");t.setProp("SortASC","Sortasc","","str");t.setProp("SortDSC","Sortdsc","","str");t.setProp("AllowGroupText","Allowgrouptext","","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("CleanFilter","Cleanfilter","","str");t.setProp("RangeFilterFrom","Rangefilterfrom","","str");t.setProp("RangeFilterTo","Rangefilterto","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("SearchButtonText","Searchbuttontext","","str");t.addV2CFunction("AV18DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV18DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV18DDO_TitleSettingsIcons)});t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e13eh2_client);this.setUserControl(t);this.GRID_EMPOWERERContainer=gx.uc.getNew(this,40,38,"WWP_GridEmpowerer",this.CmpContext+"GRID_EMPOWERERContainer","Grid_empowerer","GRID_EMPOWERER");f=this.GRID_EMPOWERERContainer;f.setProp("Class","Class","","char");f.setProp("Enabled","Enabled",!0,"boolean");f.setDynProp("GridInternalName","Gridinternalname","","char");f.setProp("HasCategories","Hascategories",!1,"bool");f.setProp("InfiniteScrolling","Infinitescrolling","False","str");f.setProp("HasTitleSettings","Hastitlesettings",!0,"bool");f.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");f.setProp("HasRowGroups","Hasrowgroups",!1,"bool");f.setProp("FixedColumns","Fixedcolumns",";;;L","str");f.setProp("PopoversInGrid","Popoversingrid","","str");f.setProp("Visible","Visible",!0,"bool");f.setC2ShowFunction(function(n){n.show()});this.setUserControl(f);i[2]={id:2,fld:"",grid:0};i[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};i[4]={id:4,fld:"",grid:0};i[5]={id:5,fld:"",grid:0};i[6]={id:6,fld:"TABLEGRIDHEADER",grid:0};i[7]={id:7,fld:"",grid:0};i[8]={id:8,fld:"",grid:0};i[10]={id:10,fld:"",grid:0};i[11]={id:11,fld:"",grid:0};i[12]={id:12,fld:"TABLEHEADER",grid:0};i[13]={id:13,fld:"",grid:0};i[14]={id:14,fld:"TABLEHEADERCONTENT",grid:0};i[15]={id:15,fld:"",grid:0};i[16]={id:16,fld:"TABLEACTIONS",grid:0};i[17]={id:17,fld:"",grid:0};i[18]={id:18,fld:"",grid:0};i[19]={id:19,fld:"",grid:0};i[20]={id:20,fld:"BTNINSERT",grid:0,evt:"e14eh2_client"};i[21]={id:21,fld:"",grid:0};i[22]={id:22,fld:"",grid:0};i[23]={id:23,fld:"GRIDTABLEWITHPAGINATIONBAR",grid:0};i[24]={id:24,fld:"",grid:0};i[25]={id:25,fld:"",grid:0};i[27]={id:27,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LOCCOD",fmt:0,gxz:"Z48LocCod",gxold:"O48LocCod",gxvar:"A48LocCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A48LocCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z48LocCod=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("LOCCOD",n||gx.fn.currentGridRowImpl(26),gx.O.A48LocCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A48LocCod=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("LOCCOD",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn};i[28]={id:28,lvl:2,type:"svchar",len:40,dec:0,sign:!1,pic:"@!",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LOCNOM",fmt:0,gxz:"Z286LocNom",gxold:"O286LocNom",gxvar:"A286LocNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A286LocNom=n)},v2z:function(n){n!==undefined&&(gx.O.Z286LocNom=n)},v2c:function(n){gx.fn.setGridControlValue("LOCNOM",n||gx.fn.currentGridRowImpl(26),gx.O.A286LocNom,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A286LocNom=this.val(n))},val:function(n){return gx.fn.getGridControlValue("LOCNOM",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn};i[29]={id:29,lvl:2,type:"char",len:20,dec:0,sign:!1,pic:"@!",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LOCCP",fmt:0,gxz:"Z285LocCP",gxold:"O285LocCP",gxvar:"A285LocCP",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A285LocCP=n)},v2z:function(n){n!==undefined&&(gx.O.Z285LocCP=n)},v2c:function(n){gx.fn.setGridControlValue("LOCCP",n||gx.fn.currentGridRowImpl(26),gx.O.A285LocCP,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A285LocCP=this.val(n))},val:function(n){return gx.fn.getGridControlValue("LOCCP",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn};i[30]={id:30,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vGRIDACTIONS",fmt:0,gxz:"ZV24GridActions",gxold:"OV24GridActions",gxvar:"AV24GridActions",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV24GridActions=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV24GridActions=gx.num.intval(n))},v2c:function(n){gx.fn.setGridComboBoxValue("vGRIDACTIONS",n||gx.fn.currentGridRowImpl(26),gx.O.AV24GridActions)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV24GridActions=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("vGRIDACTIONS",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn,evt:"e18eh2_client"};i[31]={id:31,fld:"",grid:0};i[32]={id:32,fld:"",grid:0};i[34]={id:34,fld:"",grid:0};i[35]={id:35,fld:"",grid:0};i[36]={id:36,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};i[38]={id:38,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PAICOD",fmt:0,gxz:"Z46PaiCod",gxold:"O46PaiCod",gxvar:"A46PaiCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A46PaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z46PaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PAICOD",gx.O.A46PaiCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A46PaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PAICOD",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(38,function(){});i[39]={id:39,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PROVCOD",fmt:0,gxz:"Z47ProvCod",gxold:"O47ProvCod",gxvar:"A47ProvCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A47ProvCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z47ProvCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PROVCOD",gx.O.A47ProvCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A47ProvCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PROVCOD",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(39,function(){});this.Z48LocCod=0;this.O48LocCod=0;this.Z286LocNom="";this.O286LocNom="";this.Z285LocCP="";this.O285LocCP="";this.ZV24GridActions=0;this.OV24GridActions=0;this.A46PaiCod=0;this.Z46PaiCod=0;this.O46PaiCod=0;this.A47ProvCod=0;this.Z47ProvCod=0;this.O47ProvCod=0;this.AV21GridCurrentPage=0;this.AV18DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.A46PaiCod=0;this.A47ProvCod=0;this.AV8PaiCod=0;this.AV9ProvCod=0;this.A48LocCod=0;this.A286LocNom="";this.A285LocCP="";this.AV24GridActions=0;this.AV32Pgmname="";this.AV15OrderedBy=0;this.AV16OrderedDsc=!1;this.AV25IsAuthorized_Update=!1;this.AV26IsAuthorized_Delete=!1;this.Events={e11eh2_client:["GRIDPAGINATIONBAR.CHANGEPAGE",!0],e12eh2_client:["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!0],e13eh2_client:["DDO_GRID.ONOPTIONCLICKED",!0],e14eh2_client:["'DOINSERT'",!0],e19eh2_client:["ENTER",!0],e20eh2_client:["CANCEL",!0],e18eh2_client:["VGRIDACTIONS.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:"AV8PaiCod",fld:"vPAICOD",pic:"ZZZ9"},{av:"AV9ProvCod",fld:"vPROVCOD",pic:"ZZZ9"},{av:"sPrefix"},{ctrl:"GRID",prop:"Rows"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV15OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV16OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV25IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV26IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"A47ProvCod",fld:"PROVCOD",pic:"ZZZ9"}],[{av:"AV21GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV22GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV23GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{av:"AV25IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV26IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{ctrl:"BTNINSERT",prop:"Visible"}]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV8PaiCod",fld:"vPAICOD",pic:"ZZZ9"},{av:"AV9ProvCod",fld:"vPROVCOD",pic:"ZZZ9"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV15OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV16OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV25IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV26IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"A47ProvCod",fld:"PROVCOD",pic:"ZZZ9"},{av:"sPrefix"},{av:"this.GRIDPAGINATIONBARContainer.SelectedPage",ctrl:"GRIDPAGINATIONBAR",prop:"SelectedPage"}],[]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV8PaiCod",fld:"vPAICOD",pic:"ZZZ9"},{av:"AV9ProvCod",fld:"vPROVCOD",pic:"ZZZ9"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV15OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV16OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV25IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV26IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"A47ProvCod",fld:"PROVCOD",pic:"ZZZ9"},{av:"sPrefix"},{av:"this.GRIDPAGINATIONBARContainer.RowsPerPageSelectedValue",ctrl:"GRIDPAGINATIONBAR",prop:"RowsPerPageSelectedValue"}],[{ctrl:"GRID",prop:"Rows"}]];this.EvtParms["DDO_GRID.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV8PaiCod",fld:"vPAICOD",pic:"ZZZ9"},{av:"AV9ProvCod",fld:"vPROVCOD",pic:"ZZZ9"},{av:"AV32Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV15OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV16OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV25IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV26IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"A47ProvCod",fld:"PROVCOD",pic:"ZZZ9"},{av:"sPrefix"},{av:"this.DDO_GRIDContainer.ActiveEventKey",ctrl:"DDO_GRID",prop:"ActiveEventKey"},{av:"this.DDO_GRIDContainer.SelectedValue_get",ctrl:"DDO_GRID",prop:"SelectedValue_get"}],[{av:"AV15OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV16OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.DDO_GRIDContainer.SortedStatus",ctrl:"DDO_GRID",prop:"SortedStatus"}]];this.EvtParms["GRID.LOAD"]=[[{av:"AV25IsAuthorized_Update",fld:"vISAUTHORIZED_UPDATE",pic:"",hsh:!0},{av:"AV26IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0}],[{ctrl:"vGRIDACTIONS"},{av:"AV24GridActions",fld:"vGRIDACTIONS",pic:"ZZZ9"}]];this.EvtParms["VGRIDACTIONS.CLICK"]=[[{ctrl:"vGRIDACTIONS"},{av:"AV24GridActions",fld:"vGRIDACTIONS",pic:"ZZZ9"},{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"A47ProvCod",fld:"PROVCOD",pic:"ZZZ9"},{av:"A48LocCod",fld:"LOCCOD",pic:"ZZZ9",hsh:!0}],[{ctrl:"vGRIDACTIONS"},{av:"AV24GridActions",fld:"vGRIDACTIONS",pic:"ZZZ9"}]];this.EvtParms["'DOINSERT'"]=[[{av:"AV8PaiCod",fld:"vPAICOD",pic:"ZZZ9"},{av:"AV9ProvCod",fld:"vPROVCOD",pic:"ZZZ9"},{av:"A48LocCod",fld:"LOCCOD",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV32Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV15OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV16OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV25IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV26IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV8PaiCod","vPAICOD",0,"int",4,0);this.setVCMap("AV9ProvCod","vPROVCOD",0,"int",4,0);this.setVCMap("AV8PaiCod","vPAICOD",0,"int",4,0);this.setVCMap("AV9ProvCod","vPROVCOD",0,"int",4,0);this.setVCMap("AV32Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV15OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV16OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV25IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV26IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV8PaiCod","vPAICOD",0,"int",4,0);this.setVCMap("AV9ProvCod","vPROVCOD",0,"int",4,0);this.setVCMap("AV32Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV15OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV16OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV25IsAuthorized_Update","vISAUTHORIZED_UPDATE",0,"boolean",4,0);this.setVCMap("AV26IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);u.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});u.addRefreshingVar({rfrVar:"AV8PaiCod"});u.addRefreshingVar({rfrVar:"AV9ProvCod"});u.addRefreshingVar({rfrVar:"AV32Pgmname"});u.addRefreshingVar({rfrVar:"AV15OrderedBy"});u.addRefreshingVar({rfrVar:"AV16OrderedDsc"});u.addRefreshingVar({rfrVar:"AV25IsAuthorized_Update"});u.addRefreshingVar({rfrVar:"AV26IsAuthorized_Delete"});u.addRefreshingVar(this.GXValidFnc[38]);u.addRefreshingVar(this.GXValidFnc[39]);u.addRefreshingParm({rfrVar:"AV8PaiCod"});u.addRefreshingParm({rfrVar:"AV9ProvCod"});u.addRefreshingParm({rfrVar:"AV32Pgmname"});u.addRefreshingParm({rfrVar:"AV15OrderedBy"});u.addRefreshingParm({rfrVar:"AV16OrderedDsc"});u.addRefreshingParm({rfrVar:"AV25IsAuthorized_Update"});u.addRefreshingParm({rfrVar:"AV26IsAuthorized_Delete"});u.addRefreshingParm(this.GXValidFnc[38]);u.addRefreshingParm(this.GXValidFnc[39]);this.Initialize();this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWPGridState",{FilterValues:{sdt:"WWPBaseObjects\\WWPGridState.FilterValue"},DynamicFilters:{sdt:"WWPBaseObjects\\WWPGridState.DynamicFilter"}});this.setSDTMapping("WWPBaseObjects\\WWPGridState.DynamicFilter",{Dsc:{extr:"d"}})})