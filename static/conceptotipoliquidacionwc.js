gx.evt.autoSkip=!1;gx.define("conceptotipoliquidacionwc",!0,function(n){var i,u,r,t,f;this.ServerClass="conceptotipoliquidacionwc";this.PackageName="web";this.ServerFullClass="web.conceptotipoliquidacionwc";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV29EditableGrid_Mode=gx.fn.getControlValue("vEDITABLEGRID_MODE");this.AV39Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV13OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV14OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV27IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV34TLiqCod_SelectedLine=gx.fn.getControlValue("vTLIQCOD_SELECTEDLINE");this.AV31Messages=gx.fn.getControlValue("vMESSAGES");this.AV23CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV7ConCodigo=gx.fn.getControlValue("vCONCODIGO");this.AV23CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV7ConCodigo=gx.fn.getControlValue("vCONCODIGO");this.AV29EditableGrid_Mode=gx.fn.getControlValue("vEDITABLEGRID_MODE");this.AV39Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV13OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV14OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV27IsAuthorized_Delete=gx.fn.getControlValue("vISAUTHORIZED_DELETE");this.AV34TLiqCod_SelectedLine=gx.fn.getControlValue("vTLIQCOD_SELECTEDLINE")};this.Valid_Tliqcod=function(){var n=gx.fn.currentGridRowImpl(26);return this.validCliEvt("Valid_Tliqcod",26,function(){try{if(gx.fn.currentGridRowImpl(26)===0)return!0;var n=gx.util.balloon.getNew("TLIQCOD",gx.fn.currentGridRowImpl(26));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s132_client=function(){this.DDO_GRIDContainer.SortedStatus=gx.text.trim(gx.num.str(this.AV13OrderedBy,4,0))+":"+(this.AV14OrderedDsc?"DSC":"ASC")};this.s162_client=function(){for(this.AV40GXV1=gx.num.trunc(1,0);this.AV40GXV1<=this.AV31Messages.length;)this.AV30Message=this.AV31Messages[this.AV40GXV1-1],this.addMessage(this.AV30Message.Description),this.AV40GXV1=gx.num.trunc(this.AV40GXV1+1,0)};this.e114v2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEPAGE",!1,null,!0,!0)};this.e124v2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!1,null,!0,!0)};this.e134v2_client=function(){return this.executeServerEvent("DDO_GRID.ONOPTIONCLICKED",!1,null,!0,!0)};this.e184v2_client=function(){return this.executeServerEvent("'EDITABLEGRIDCONFIRM'",!0,arguments[0],!1,!1)};this.e194v2_client=function(){return this.executeServerEvent("'EDITABLEGRIDCANCEL'",!0,arguments[0],!1,!1)};this.e204v2_client=function(){return this.executeServerEvent("VGRIDACTIONS.CLICK",!0,arguments[0],!1,!1)};this.e144v2_client=function(){return this.executeServerEvent("'DOINSERT'",!1,null,!1,!1)};this.e214v2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e224v2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];i=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,27,28,29,30,31,32,33,35,36,37,39,40];this.GXLastCtrlId=40;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",26,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"conceptotipoliquidacionwc",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);u=this.GridContainer;u.addSingleLineEdit("Editablegridcancel",27,"vEDITABLEGRIDCANCEL","",gx.getMessage("GX_BtnCancel"),"EditableGridCancel","char",0,"px",20,20,"left","e194v2_client",[],"Editablegridcancel","EditableGridCancel",!0,0,!1,!1,"",0,"WWIconActionColumn");u.addComboBox("Gridactions",28,"vGRIDACTIONS","","GridActions","int","e204v2_client",0,!0,!1,0,"px","WWActionGroupColumn");u.addSingleLineEdit(32,29,"TLIQCOD",gx.getMessage("Código"),"","TLiqCod","char",0,"px",20,20,"left",null,[],32,"TLiqCod",!0,0,!1,!1,"",0,"WWColumn hidden-xs");u.addSingleLineEdit(340,30,"TLIQDESC",gx.getMessage("Descripción"),"","TliqDesc","svchar",0,"px",30,30,"left",null,[],340,"TliqDesc",!0,0,!1,!1,"",0,"WWColumn hidden-xs");u.addSingleLineEdit("Editablegridconfirm",31,"vEDITABLEGRIDCONFIRM","",gx.getMessage("GX_BtnEnter"),"EditableGridConfirm","char",0,"px",20,20,"left","e184v2_client",[],"Editablegridconfirm","EditableGridConfirm",!0,0,!1,!1,"",0,"WWIconActionColumn");this.GridContainer.emptyText=gx.getMessage("");this.setGrid(u);this.GRIDPAGINATIONBARContainer=gx.uc.getNew(this,34,27,"DVelop_DVPaginationBar",this.CmpContext+"GRIDPAGINATIONBARContainer","Gridpaginationbar","GRIDPAGINATIONBAR");r=this.GRIDPAGINATIONBARContainer;r.setProp("Enabled","Enabled",!0,"boolean");r.setProp("Class","Class","PaginationBar","str");r.setProp("ShowFirst","Showfirst",!1,"bool");r.setProp("ShowPrevious","Showprevious",!0,"bool");r.setProp("ShowNext","Shownext",!0,"bool");r.setProp("ShowLast","Showlast",!1,"bool");r.setProp("PagesToShow","Pagestoshow",5,"num");r.setProp("PagingButtonsPosition","Pagingbuttonsposition","Right","str");r.setProp("PagingCaptionPosition","Pagingcaptionposition","Left","str");r.setProp("EmptyGridClass","Emptygridclass","PaginationBarEmptyGrid","str");r.setProp("SelectedPage","Selectedpage","","char");r.setProp("RowsPerPageSelector","Rowsperpageselector",!0,"bool");r.setDynProp("RowsPerPageSelectedValue","Rowsperpageselectedvalue",10,"num");r.setProp("RowsPerPageOptions","Rowsperpageoptions","5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50","str");r.setProp("First","First","First","str");r.setProp("Previous","Previous","WWP_PagingPreviousCaption","str");r.setProp("Next","Next","WWP_PagingNextCaption","str");r.setProp("Last","Last","Last","str");r.setProp("Caption","Caption",gx.getMessage("WWP_PagingCaption"),"str");r.setProp("EmptyGridCaption","Emptygridcaption","WWP_PagingEmptyGridCaption","str");r.setProp("RowsPerPageCaption","Rowsperpagecaption","WWP_PagingRowsPerPage","str");r.addV2CFunction("AV19GridCurrentPage","vGRIDCURRENTPAGE","SetCurrentPage");r.addC2VFunction(function(n){n.ParentObject.AV19GridCurrentPage=n.GetCurrentPage();gx.fn.setControlValue("vGRIDCURRENTPAGE",n.ParentObject.AV19GridCurrentPage)});r.addV2CFunction("AV20GridPageCount","vGRIDPAGECOUNT","SetPageCount");r.addC2VFunction(function(n){n.ParentObject.AV20GridPageCount=n.GetPageCount();gx.fn.setControlValue("vGRIDPAGECOUNT",n.ParentObject.AV20GridPageCount)});r.setProp("RecordCount","Recordcount","","str");r.setProp("Page","Page","","str");r.addV2CFunction("AV21GridAppliedFilters","vGRIDAPPLIEDFILTERS","SetAppliedFilters");r.addC2VFunction(function(n){n.ParentObject.AV21GridAppliedFilters=n.GetAppliedFilters();gx.fn.setControlValue("vGRIDAPPLIEDFILTERS",n.ParentObject.AV21GridAppliedFilters)});r.setProp("Visible","Visible",!0,"bool");r.setProp("Gx Control Type","Gxcontroltype","","int");r.setC2ShowFunction(function(n){n.show()});r.addEventHandler("ChangePage",this.e114v2_client);r.addEventHandler("ChangeRowsPerPage",this.e124v2_client);this.setUserControl(r);this.DDO_GRIDContainer=gx.uc.getNew(this,38,27,"DDOGridTitleSettingsM",this.CmpContext+"DDO_GRIDContainer","Ddo_grid","DDO_GRID");t=this.DDO_GRIDContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","","str");t.setProp("ActiveEventKey","Activeeventkey","","char");t.setProp("FilteredText_set","Filteredtext_set","","char");t.setProp("FilteredText_get","Filteredtext_get","","char");t.setProp("FilteredTextTo_set","Filteredtextto_set","","char");t.setProp("FilteredTextTo_get","Filteredtextto_get","","char");t.setProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("SelectedColumn","Selectedcolumn","","char");t.setProp("SelectedColumnFixedFilter","Selectedcolumnfixedfilter","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("TitleControlAlign","Titlecontrolalign","","str");t.setProp("Visible","Visible","","str");t.setDynProp("GridInternalName","Gridinternalname","","str");t.setProp("ColumnIds","Columnids","2:TLiqCod|3:TliqDesc","str");t.setProp("ColumnsSortValues","Columnssortvalues","1|2","str");t.setProp("IncludeSortASC","Includesortasc","T","str");t.setProp("IncludeSortDSC","Includesortdsc","","str");t.setProp("AllowGroup","Allowgroup","","str");t.setProp("Fixable","Fixable","","str");t.setDynProp("SortedStatus","Sortedstatus","","char");t.setProp("IncludeFilter","Includefilter","","str");t.setProp("FilterType","Filtertype","","str");t.setProp("FilterIsRange","Filterisrange","","str");t.setProp("IncludeDataList","Includedatalist","","str");t.setProp("DataListType","Datalisttype","","str");t.setProp("AllowMultipleSelection","Allowmultipleselection","","str");t.setProp("DataListFixedValues","Datalistfixedvalues","","str");t.setProp("DataListProc","Datalistproc","","str");t.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("FixedFilters","Fixedfilters","","str");t.setProp("Format","Format","","str");t.setProp("SelectedFixedFilter","Selectedfixedfilter","","char");t.setProp("SortASC","Sortasc","","str");t.setProp("SortDSC","Sortdsc","","str");t.setProp("AllowGroupText","Allowgrouptext","","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("CleanFilter","Cleanfilter","","str");t.setProp("RangeFilterFrom","Rangefilterfrom","","str");t.setProp("RangeFilterTo","Rangefilterto","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("SearchButtonText","Searchbuttontext","","str");t.addV2CFunction("AV16DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV16DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV16DDO_TitleSettingsIcons)});t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e134v2_client);this.setUserControl(t);this.GRID_EMPOWERERContainer=gx.uc.getNew(this,41,39,"WWP_GridEmpowerer",this.CmpContext+"GRID_EMPOWERERContainer","Grid_empowerer","GRID_EMPOWERER");f=this.GRID_EMPOWERERContainer;f.setProp("Class","Class","","char");f.setProp("Enabled","Enabled",!0,"boolean");f.setDynProp("GridInternalName","Gridinternalname","","char");f.setProp("HasCategories","Hascategories",!1,"bool");f.setProp("InfiniteScrolling","Infinitescrolling","False","str");f.setProp("HasTitleSettings","Hastitlesettings",!0,"bool");f.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");f.setProp("HasRowGroups","Hasrowgroups",!1,"bool");f.setProp("FixedColumns","Fixedcolumns",";L;;;","str");f.setProp("PopoversInGrid","Popoversingrid","","str");f.setProp("Visible","Visible",!0,"bool");f.setC2ShowFunction(function(n){n.show()});this.setUserControl(f);i[2]={id:2,fld:"",grid:0};i[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};i[4]={id:4,fld:"",grid:0};i[5]={id:5,fld:"",grid:0};i[6]={id:6,fld:"TABLEGRIDHEADER",grid:0};i[7]={id:7,fld:"",grid:0};i[8]={id:8,fld:"",grid:0};i[10]={id:10,fld:"",grid:0};i[11]={id:11,fld:"",grid:0};i[12]={id:12,fld:"TABLEHEADER",grid:0};i[13]={id:13,fld:"",grid:0};i[14]={id:14,fld:"TABLEHEADERCONTENT",grid:0};i[15]={id:15,fld:"",grid:0};i[16]={id:16,fld:"TABLEACTIONS",grid:0};i[17]={id:17,fld:"",grid:0};i[18]={id:18,fld:"",grid:0};i[19]={id:19,fld:"",grid:0};i[20]={id:20,fld:"BTNINSERT",grid:0,evt:"e144v2_client"};i[21]={id:21,fld:"",grid:0};i[22]={id:22,fld:"",grid:0};i[23]={id:23,fld:"GRIDTABLEWITHPAGINATIONBAR",grid:0};i[24]={id:24,fld:"",grid:0};i[25]={id:25,fld:"",grid:0};i[27]={id:27,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:0,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vEDITABLEGRIDCANCEL",fmt:1,gxz:"ZV35EditableGridCancel",gxold:"OV35EditableGridCancel",gxvar:"AV35EditableGridCancel",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV35EditableGridCancel=n)},v2z:function(n){n!==undefined&&(gx.O.ZV35EditableGridCancel=n)},v2c:function(n){gx.fn.setGridControlValue("vEDITABLEGRIDCANCEL",n||gx.fn.currentGridRowImpl(26),gx.O.AV35EditableGridCancel,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV35EditableGridCancel=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vEDITABLEGRIDCANCEL",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn,evt:"e194v2_client"};i[28]={id:28,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vGRIDACTIONS",fmt:0,gxz:"ZV22GridActions",gxold:"OV22GridActions",gxvar:"AV22GridActions",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.AV22GridActions=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV22GridActions=gx.num.intval(n))},v2c:function(n){gx.fn.setGridComboBoxValue("vGRIDACTIONS",n||gx.fn.currentGridRowImpl(26),gx.O.AV22GridActions)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV22GridActions=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("vGRIDACTIONS",n||gx.fn.currentGridRowImpl(26),gx.thousandSeparator)},nac:gx.falseFn,evt:"e204v2_client"};i[29]={id:29,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:this.Valid_Tliqcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TLIQCOD",fmt:0,gxz:"Z32TLiqCod",gxold:"O32TLiqCod",gxvar:"A32TLiqCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A32TLiqCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z32TLiqCod=n)},v2c:function(n){gx.fn.setGridControlValue("TLIQCOD",n||gx.fn.currentGridRowImpl(26),gx.O.A32TLiqCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A32TLiqCod=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TLIQCOD",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn};i[30]={id:30,lvl:2,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:1,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TLIQDESC",fmt:0,gxz:"Z340TliqDesc",gxold:"O340TliqDesc",gxvar:"A340TliqDesc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A340TliqDesc=n)},v2z:function(n){n!==undefined&&(gx.O.Z340TliqDesc=n)},v2c:function(n){gx.fn.setGridControlValue("TLIQDESC",n||gx.fn.currentGridRowImpl(26),gx.O.A340TliqDesc,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A340TliqDesc=this.val(n))},val:function(n){return gx.fn.getGridControlValue("TLIQDESC",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn};i[31]={id:31,lvl:2,type:"char",len:20,dec:0,sign:!1,ro:0,isacc:0,grid:26,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vEDITABLEGRIDCONFIRM",fmt:1,gxz:"ZV36EditableGridConfirm",gxold:"OV36EditableGridConfirm",gxvar:"AV36EditableGridConfirm",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.AV36EditableGridConfirm=n)},v2z:function(n){n!==undefined&&(gx.O.ZV36EditableGridConfirm=n)},v2c:function(n){gx.fn.setGridControlValue("vEDITABLEGRIDCONFIRM",n||gx.fn.currentGridRowImpl(26),gx.O.AV36EditableGridConfirm,1)},c2v:function(n){this.val(n)!==undefined&&(gx.O.AV36EditableGridConfirm=this.val(n))},val:function(n){return gx.fn.getGridControlValue("vEDITABLEGRIDCONFIRM",n||gx.fn.currentGridRowImpl(26))},nac:gx.falseFn,evt:"e184v2_client"};i[32]={id:32,fld:"",grid:0};i[33]={id:33,fld:"",grid:0};i[35]={id:35,fld:"",grid:0};i[36]={id:36,fld:"",grid:0};i[37]={id:37,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};i[39]={id:39,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};i[40]={id:40,lvl:0,type:"char",len:10,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONCODIGO",fmt:0,gxz:"Z26ConCodigo",gxold:"O26ConCodigo",gxvar:"A26ConCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A26ConCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z26ConCodigo=n)},v2c:function(){gx.fn.setControlValue("CONCODIGO",gx.O.A26ConCodigo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A26ConCodigo=this.val())},val:function(){return gx.fn.getControlValue("CONCODIGO")},nac:gx.falseFn};this.declareDomainHdlr(40,function(){});this.ZV35EditableGridCancel="";this.OV35EditableGridCancel="";this.ZV22GridActions=0;this.OV22GridActions=0;this.Z32TLiqCod="";this.O32TLiqCod="";this.Z340TliqDesc="";this.O340TliqDesc="";this.ZV36EditableGridConfirm="";this.OV36EditableGridConfirm="";this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A26ConCodigo="";this.Z26ConCodigo="";this.O26ConCodigo="";this.AV19GridCurrentPage=0;this.AV16DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.A3CliCod=0;this.A26ConCodigo="";this.AV23CliCod=0;this.AV7ConCodigo="";this.AV35EditableGridCancel="";this.AV22GridActions=0;this.A32TLiqCod="";this.A340TliqDesc="";this.AV36EditableGridConfirm="";this.AV29EditableGrid_Mode="";this.AV39Pgmname="";this.AV13OrderedBy=0;this.AV14OrderedDsc=!1;this.AV27IsAuthorized_Delete=!1;this.AV34TLiqCod_SelectedLine="";this.AV31Messages=[];this.AV30Message={Id:"",Type:0,Description:""};this.AV40GXV1=0;this.Events={e114v2_client:["GRIDPAGINATIONBAR.CHANGEPAGE",!0],e124v2_client:["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!0],e134v2_client:["DDO_GRID.ONOPTIONCLICKED",!0],e184v2_client:["'EDITABLEGRIDCONFIRM'",!0],e194v2_client:["'EDITABLEGRIDCANCEL'",!0],e204v2_client:["VGRIDACTIONS.CLICK",!0],e144v2_client:["'DOINSERT'",!0],e214v2_client:["ENTER",!0],e224v2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"sPrefix"},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{ctrl:"GRID",prop:"Rows"},{av:"AV39Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"}],[{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{ctrl:"BTNINSERT",prop:"Visible"},{av:"AV19GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV20GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV21GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{ctrl:"vGRIDACTIONS"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCANCEL","Visible")',ctrl:"vEDITABLEGRIDCANCEL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCONFIRM","Visible")',ctrl:"vEDITABLEGRIDCONFIRM",prop:"Visible"},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0}]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV39Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"sPrefix"},{av:"this.GRIDPAGINATIONBARContainer.SelectedPage",ctrl:"GRIDPAGINATIONBAR",prop:"SelectedPage"}],[]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV39Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"sPrefix"},{av:"this.GRIDPAGINATIONBARContainer.RowsPerPageSelectedValue",ctrl:"GRIDPAGINATIONBAR",prop:"RowsPerPageSelectedValue"}],[{ctrl:"GRID",prop:"Rows"}]];this.EvtParms["DDO_GRID.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV39Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"sPrefix"},{av:"this.DDO_GRIDContainer.ActiveEventKey",ctrl:"DDO_GRID",prop:"ActiveEventKey"},{av:"this.DDO_GRIDContainer.SelectedValue_get",ctrl:"DDO_GRID",prop:"SelectedValue_get"}],[{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.DDO_GRIDContainer.SortedStatus",ctrl:"DDO_GRID",prop:"SortedStatus"}]];this.EvtParms["GRID.LOAD"]=[[{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"A32TLiqCod",fld:"TLIQCOD",pic:"",hsh:!0}],[{av:"AV35EditableGridCancel",fld:"vEDITABLEGRIDCANCEL",pic:""},{ctrl:"vGRIDACTIONS"},{av:"AV22GridActions",fld:"vGRIDACTIONS",pic:"ZZZ9"},{av:"AV36EditableGridConfirm",fld:"vEDITABLEGRIDCONFIRM",pic:""},{av:'gx.fn.getCtrlProperty("TLIQCOD","Class")',ctrl:"TLIQCOD",prop:"Class"},{av:'gx.fn.getCtrlProperty("TLIQDESC","Class")',ctrl:"TLIQDESC",prop:"Class"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCANCEL","Class")',ctrl:"vEDITABLEGRIDCANCEL",prop:"Class"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCONFIRM","Class")',ctrl:"vEDITABLEGRIDCONFIRM",prop:"Class"}]];this.EvtParms["'EDITABLEGRIDCONFIRM'"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV39Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"sPrefix"},{av:"A32TLiqCod",fld:"TLIQCOD",pic:"",hsh:!0},{av:"AV31Messages",fld:"vMESSAGES",pic:""}],[{av:"AV31Messages",fld:"vMESSAGES",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"BTNINSERT",prop:"Visible"},{av:"AV19GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV20GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV21GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{ctrl:"vGRIDACTIONS"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCANCEL","Visible")',ctrl:"vEDITABLEGRIDCANCEL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCONFIRM","Visible")',ctrl:"vEDITABLEGRIDCONFIRM",prop:"Visible"},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0}]];this.EvtParms["'EDITABLEGRIDCANCEL'"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV39Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"sPrefix"}],[{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"BTNINSERT",prop:"Visible"},{av:"AV19GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV20GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV21GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{ctrl:"vGRIDACTIONS"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCANCEL","Visible")',ctrl:"vEDITABLEGRIDCANCEL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCONFIRM","Visible")',ctrl:"vEDITABLEGRIDCONFIRM",prop:"Visible"},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0}]];this.EvtParms["VGRIDACTIONS.CLICK"]=[[{ctrl:"vGRIDACTIONS"},{av:"AV22GridActions",fld:"vGRIDACTIONS",pic:"ZZZ9"},{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV39Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"sPrefix"},{av:"A32TLiqCod",fld:"TLIQCOD",pic:"",hsh:!0}],[{ctrl:"vGRIDACTIONS"},{av:"AV22GridActions",fld:"vGRIDACTIONS",pic:"ZZZ9"},{av:"AV34TLiqCod_SelectedLine",fld:"vTLIQCOD_SELECTEDLINE",pic:""},{av:"AV29EditableGrid_Mode",fld:"vEDITABLEGRID_MODE",pic:""},{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"BTNINSERT",prop:"Visible"},{av:"AV19GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV20GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV21GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCANCEL","Visible")',ctrl:"vEDITABLEGRIDCANCEL",prop:"Visible"},{av:'gx.fn.getCtrlProperty("vEDITABLEGRIDCONFIRM","Visible")',ctrl:"vEDITABLEGRIDCONFIRM",prop:"Visible"},{av:"AV27IsAuthorized_Delete",fld:"vISAUTHORIZED_DELETE",pic:"",hsh:!0}]];this.EvtParms["'DOINSERT'"]=[[{av:"AV23CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"A32TLiqCod",fld:"TLIQCOD",pic:"",hsh:!0}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.EvtParms.VALID_TLIQCOD=[[],[]];this.setVCMap("AV29EditableGrid_Mode","vEDITABLEGRID_MODE",0,"svchar",100,0);this.setVCMap("AV39Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV13OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV14OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV27IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV34TLiqCod_SelectedLine","vTLIQCOD_SELECTEDLINE",0,"char",20,0);this.setVCMap("AV31Messages","vMESSAGES",0,"CollGeneXusCommonMessages.Message",0,0);this.setVCMap("AV23CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV7ConCodigo","vCONCODIGO",0,"char",10,0);this.setVCMap("AV23CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV7ConCodigo","vCONCODIGO",0,"char",10,0);this.setVCMap("AV29EditableGrid_Mode","vEDITABLEGRID_MODE",0,"svchar",100,0);this.setVCMap("AV39Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV13OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV14OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV27IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV34TLiqCod_SelectedLine","vTLIQCOD_SELECTEDLINE",0,"char",20,0);this.setVCMap("AV23CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV7ConCodigo","vCONCODIGO",0,"char",10,0);this.setVCMap("AV29EditableGrid_Mode","vEDITABLEGRID_MODE",0,"svchar",100,0);this.setVCMap("AV39Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV13OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV14OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV27IsAuthorized_Delete","vISAUTHORIZED_DELETE",0,"boolean",4,0);this.setVCMap("AV34TLiqCod_SelectedLine","vTLIQCOD_SELECTEDLINE",0,"char",20,0);u.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});u.addRefreshingVar({rfrVar:"AV23CliCod"});u.addRefreshingVar({rfrVar:"AV7ConCodigo"});u.addRefreshingVar({rfrVar:"AV29EditableGrid_Mode"});u.addRefreshingVar({rfrVar:"AV39Pgmname"});u.addRefreshingVar({rfrVar:"AV13OrderedBy"});u.addRefreshingVar({rfrVar:"AV14OrderedDsc"});u.addRefreshingVar({rfrVar:"AV27IsAuthorized_Delete"});u.addRefreshingVar({rfrVar:"AV34TLiqCod_SelectedLine"});u.addRefreshingVar(this.GXValidFnc[39]);u.addRefreshingParm({rfrVar:"AV23CliCod"});u.addRefreshingParm({rfrVar:"AV7ConCodigo"});u.addRefreshingParm({rfrVar:"AV29EditableGrid_Mode"});u.addRefreshingParm({rfrVar:"AV39Pgmname"});u.addRefreshingParm({rfrVar:"AV13OrderedBy"});u.addRefreshingParm({rfrVar:"AV14OrderedDsc"});u.addRefreshingParm({rfrVar:"AV27IsAuthorized_Delete"});u.addRefreshingParm({rfrVar:"AV34TLiqCod_SelectedLine"});u.addRefreshingParm(this.GXValidFnc[39]);this.Initialize();this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWPGridState",{FilterValues:{sdt:"WWPBaseObjects\\WWPGridState.FilterValue"}})})