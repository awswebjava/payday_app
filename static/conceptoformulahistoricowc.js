gx.evt.autoSkip=!1;gx.define("conceptoformulahistoricowc",!0,function(n){var r,u,i,t,f;this.ServerClass="conceptoformulahistoricowc";this.PackageName="web";this.ServerFullClass="web.conceptoformulahistoricowc";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV40Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV13OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV14OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV35CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV7ConCodigo=gx.fn.getControlValue("vCONCODIGO");this.AV35CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV7ConCodigo=gx.fn.getControlValue("vCONCODIGO");this.AV40Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV13OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV14OrderedDsc=gx.fn.getControlValue("vORDEREDDSC")};this.s132_client=function(){this.DDO_GRIDContainer.SortedStatus=gx.text.trim(gx.num.str(this.AV13OrderedBy,4,0))+":"+(this.AV14OrderedDsc?"DSC":"ASC")};this.e114w2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEPAGE",!1,null,!0,!0)};this.e124w2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!1,null,!0,!0)};this.e134w2_client=function(){return this.executeServerEvent("DDO_GRID.ONOPTIONCLICKED",!1,null,!0,!0)};this.e174w2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e184w2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];r=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,19,20,21,22,23,24,25,26,27,29,30,31,33];this.GXLastCtrlId=33;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",18,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"conceptoformulahistoricowc",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);u=this.GridContainer;u.addSingleLineEdit(223,19,"FORHISFECHA",gx.getMessage("Fecha"),"","ForHisFecha","dtime",0,"px",14,14,"right",null,[],223,"ForHisFecha",!0,5,!1,!1,"Attribute",0,"WWColumn");u.addSingleLineEdit(224,20,"FORHISUSUARIO",gx.getMessage("Usuario"),"","ForHisUsuario","svchar",0,"px",100,80,"left",null,[],224,"ForHisUsuario",!0,0,!1,!1,"Attribute",0,"WWColumn hidden-xs");u.addSingleLineEdit(222,21,"FORHISDESPUES",gx.getMessage("Fórmula"),"","ForHisDespues","vchar",0,"px",2e3,80,"left",null,[],222,"ForHisDespues",!0,0,!1,!1,"Attribute",0,"WWColumn hidden-xs");u.addSingleLineEdit(51,22,"FORHISNUM",gx.getMessage("For His Num"),"","ForHisNum","int",0,"px",4,4,"right",null,[],51,"ForHisNum",!1,0,!1,!1,"Attribute",0,"WWColumn hidden-xs");u.addSingleLineEdit(52,23,"IMPSEC",gx.getMessage("Imp Sec"),"","ImpSec","int",0,"px",18,18,"right",null,[],52,"ImpSec",!1,0,!1,!1,"Attribute",0,"WWColumn hidden-xs");u.addSingleLineEdit(221,24,"FORHISANTES",gx.getMessage("For His Antes"),"","ForHisAntes","vchar",0,"px",2e3,80,"left",null,[],221,"ForHisAntes",!1,0,!1,!1,"Attribute",0,"WWColumn hidden-xs");u.addSingleLineEdit(26,25,"CONCODIGO",gx.getMessage("Código"),"","ConCodigo","char",0,"px",10,10,"left",null,[],26,"ConCodigo",!1,0,!1,!1,"Attribute",0,"WWColumn");this.GridContainer.emptyText=gx.getMessage("");this.setGrid(u);this.GRIDPAGINATIONBARContainer=gx.uc.getNew(this,28,19,"DVelop_DVPaginationBar",this.CmpContext+"GRIDPAGINATIONBARContainer","Gridpaginationbar","GRIDPAGINATIONBAR");i=this.GRIDPAGINATIONBARContainer;i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Class","Class","PaginationBar","str");i.setProp("ShowFirst","Showfirst",!1,"bool");i.setProp("ShowPrevious","Showprevious",!0,"bool");i.setProp("ShowNext","Shownext",!0,"bool");i.setProp("ShowLast","Showlast",!1,"bool");i.setProp("PagesToShow","Pagestoshow",5,"num");i.setProp("PagingButtonsPosition","Pagingbuttonsposition","Right","str");i.setProp("PagingCaptionPosition","Pagingcaptionposition","Left","str");i.setProp("EmptyGridClass","Emptygridclass","PaginationBarEmptyGrid","str");i.setProp("SelectedPage","Selectedpage","","char");i.setProp("RowsPerPageSelector","Rowsperpageselector",!0,"bool");i.setDynProp("RowsPerPageSelectedValue","Rowsperpageselectedvalue",10,"num");i.setProp("RowsPerPageOptions","Rowsperpageoptions","5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50","str");i.setProp("First","First","First","str");i.setProp("Previous","Previous","WWP_PagingPreviousCaption","str");i.setProp("Next","Next","WWP_PagingNextCaption","str");i.setProp("Last","Last","Last","str");i.setProp("Caption","Caption",gx.getMessage("WWP_PagingCaption"),"str");i.setProp("EmptyGridCaption","Emptygridcaption","WWP_PagingEmptyGridCaption","str");i.setProp("RowsPerPageCaption","Rowsperpagecaption","WWP_PagingRowsPerPage","str");i.addV2CFunction("AV28GridCurrentPage","vGRIDCURRENTPAGE","SetCurrentPage");i.addC2VFunction(function(n){n.ParentObject.AV28GridCurrentPage=n.GetCurrentPage();gx.fn.setControlValue("vGRIDCURRENTPAGE",n.ParentObject.AV28GridCurrentPage)});i.addV2CFunction("AV29GridPageCount","vGRIDPAGECOUNT","SetPageCount");i.addC2VFunction(function(n){n.ParentObject.AV29GridPageCount=n.GetPageCount();gx.fn.setControlValue("vGRIDPAGECOUNT",n.ParentObject.AV29GridPageCount)});i.setProp("RecordCount","Recordcount","","str");i.setProp("Page","Page","","str");i.addV2CFunction("AV30GridAppliedFilters","vGRIDAPPLIEDFILTERS","SetAppliedFilters");i.addC2VFunction(function(n){n.ParentObject.AV30GridAppliedFilters=n.GetAppliedFilters();gx.fn.setControlValue("vGRIDAPPLIEDFILTERS",n.ParentObject.AV30GridAppliedFilters)});i.setProp("Visible","Visible",!0,"bool");i.setC2ShowFunction(function(n){n.show()});i.addEventHandler("ChangePage",this.e114w2_client);i.addEventHandler("ChangeRowsPerPage",this.e124w2_client);this.setUserControl(i);this.DDO_GRIDContainer=gx.uc.getNew(this,32,19,"DDOGridTitleSettingsM",this.CmpContext+"DDO_GRIDContainer","Ddo_grid","DDO_GRID");t=this.DDO_GRIDContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","","str");t.setProp("ActiveEventKey","Activeeventkey","","char");t.setProp("FilteredText_set","Filteredtext_set","","char");t.setProp("FilteredText_get","Filteredtext_get","","char");t.setProp("FilteredTextTo_set","Filteredtextto_set","","char");t.setProp("FilteredTextTo_get","Filteredtextto_get","","char");t.setProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("SelectedColumn","Selectedcolumn","","char");t.setProp("SelectedColumnFixedFilter","Selectedcolumnfixedfilter","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("TitleControlAlign","Titlecontrolalign","","str");t.setProp("Visible","Visible","","str");t.setDynProp("GridInternalName","Gridinternalname","","str");t.setProp("ColumnIds","Columnids","0:ForHisFecha|1:ForHisUsuario|2:ForHisDespues","str");t.setProp("ColumnsSortValues","Columnssortvalues","1|2|3","str");t.setProp("IncludeSortASC","Includesortasc","T","str");t.setProp("IncludeSortDSC","Includesortdsc","","str");t.setProp("AllowGroup","Allowgroup","","str");t.setProp("Fixable","Fixable","","str");t.setDynProp("SortedStatus","Sortedstatus","","char");t.setProp("IncludeFilter","Includefilter","","str");t.setProp("FilterType","Filtertype","","str");t.setProp("FilterIsRange","Filterisrange","","str");t.setProp("IncludeDataList","Includedatalist","","str");t.setProp("DataListType","Datalisttype","","str");t.setProp("AllowMultipleSelection","Allowmultipleselection","","str");t.setProp("DataListFixedValues","Datalistfixedvalues","","str");t.setProp("DataListProc","Datalistproc","","str");t.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("FixedFilters","Fixedfilters","","str");t.setProp("Format","Format","","str");t.setProp("SelectedFixedFilter","Selectedfixedfilter","","char");t.setProp("SortASC","Sortasc","","str");t.setProp("SortDSC","Sortdsc","","str");t.setProp("AllowGroupText","Allowgrouptext","","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("CleanFilter","Cleanfilter","","str");t.setProp("RangeFilterFrom","Rangefilterfrom","","str");t.setProp("RangeFilterTo","Rangefilterto","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("SearchButtonText","Searchbuttontext","","str");t.addV2CFunction("AV25DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV25DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV25DDO_TitleSettingsIcons)});t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e134w2_client);this.setUserControl(t);this.GRID_EMPOWERERContainer=gx.uc.getNew(this,34,33,"WWP_GridEmpowerer",this.CmpContext+"GRID_EMPOWERERContainer","Grid_empowerer","GRID_EMPOWERER");f=this.GRID_EMPOWERERContainer;f.setProp("Class","Class","","char");f.setProp("Enabled","Enabled",!0,"boolean");f.setDynProp("GridInternalName","Gridinternalname","","char");f.setProp("HasCategories","Hascategories",!1,"bool");f.setProp("InfiniteScrolling","Infinitescrolling","False","str");f.setProp("HasTitleSettings","Hastitlesettings",!0,"bool");f.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");f.setProp("HasRowGroups","Hasrowgroups",!1,"bool");f.setProp("FixedColumns","Fixedcolumns","","str");f.setProp("PopoversInGrid","Popoversingrid","","str");f.setProp("Visible","Visible",!0,"bool");f.setC2ShowFunction(function(n){n.show()});this.setUserControl(f);r[2]={id:2,fld:"",grid:0};r[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};r[4]={id:4,fld:"",grid:0};r[5]={id:5,fld:"",grid:0};r[6]={id:6,fld:"TABLEGRIDHEADER",grid:0};r[7]={id:7,fld:"",grid:0};r[8]={id:8,fld:"",grid:0};r[10]={id:10,fld:"",grid:0};r[11]={id:11,fld:"",grid:0};r[12]={id:12,fld:"TABLEHEADER",grid:0};r[13]={id:13,fld:"",grid:0};r[14]={id:14,fld:"",grid:0};r[15]={id:15,fld:"GRIDTABLEWITHPAGINATIONBAR",grid:0};r[16]={id:16,fld:"",grid:0};r[17]={id:17,fld:"",grid:0};r[19]={id:19,lvl:2,type:"dtime",len:8,dec:5,sign:!1,ro:1,isacc:0,grid:18,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"FORHISFECHA",fmt:0,gxz:"Z223ForHisFecha",gxold:"O223ForHisFecha",gxvar:"A223ForHisFecha",dp:{f:0,st:!0,wn:!1,mf:!1,pic:"99/99/99 99:99",dec:5},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A223ForHisFecha=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z223ForHisFecha=gx.fn.toDatetimeValue(n))},v2c:function(n){gx.fn.setGridControlValue("FORHISFECHA",n||gx.fn.currentGridRowImpl(18),gx.O.A223ForHisFecha,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A223ForHisFecha=gx.fn.toDatetimeValue(this.val(n)))},val:function(n){return gx.fn.getGridDateTimeValue("FORHISFECHA",n||gx.fn.currentGridRowImpl(18))},nac:gx.falseFn};r[20]={id:20,lvl:2,type:"svchar",len:100,dec:0,sign:!1,ro:1,isacc:0,grid:18,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"FORHISUSUARIO",fmt:0,gxz:"Z224ForHisUsuario",gxold:"O224ForHisUsuario",gxvar:"A224ForHisUsuario",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A224ForHisUsuario=n)},v2z:function(n){n!==undefined&&(gx.O.Z224ForHisUsuario=n)},v2c:function(n){gx.fn.setGridControlValue("FORHISUSUARIO",n||gx.fn.currentGridRowImpl(18),gx.O.A224ForHisUsuario,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A224ForHisUsuario=this.val(n))},val:function(n){return gx.fn.getGridControlValue("FORHISUSUARIO",n||gx.fn.currentGridRowImpl(18))},nac:gx.falseFn};r[21]={id:21,lvl:2,type:"vchar",len:2e3,dec:0,sign:!1,ro:1,isacc:0,grid:18,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"FORHISDESPUES",fmt:0,gxz:"Z222ForHisDespues",gxold:"O222ForHisDespues",gxvar:"A222ForHisDespues",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A222ForHisDespues=n)},v2z:function(n){n!==undefined&&(gx.O.Z222ForHisDespues=n)},v2c:function(n){gx.fn.setGridControlValue("FORHISDESPUES",n||gx.fn.currentGridRowImpl(18),gx.O.A222ForHisDespues,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A222ForHisDespues=this.val(n))},val:function(n){return gx.fn.getGridControlValue("FORHISDESPUES",n||gx.fn.currentGridRowImpl(18))},nac:gx.falseFn};r[22]={id:22,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:18,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"FORHISNUM",fmt:0,gxz:"Z51ForHisNum",gxold:"O51ForHisNum",gxvar:"A51ForHisNum",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A51ForHisNum=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z51ForHisNum=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("FORHISNUM",n||gx.fn.currentGridRowImpl(18),gx.O.A51ForHisNum,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A51ForHisNum=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("FORHISNUM",n||gx.fn.currentGridRowImpl(18),gx.thousandSeparator)},nac:gx.falseFn};r[23]={id:23,lvl:2,type:"int",len:18,dec:0,sign:!1,pic:"ZZZZZZZZZZZZZZZZZ9",ro:1,isacc:0,grid:18,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"IMPSEC",fmt:0,gxz:"Z52ImpSec",gxold:"O52ImpSec",gxvar:"A52ImpSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A52ImpSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z52ImpSec=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("IMPSEC",n||gx.fn.currentGridRowImpl(18),gx.O.A52ImpSec,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A52ImpSec=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("IMPSEC",n||gx.fn.currentGridRowImpl(18),gx.thousandSeparator)},nac:gx.falseFn};r[24]={id:24,lvl:2,type:"vchar",len:2e3,dec:0,sign:!1,ro:1,isacc:0,grid:18,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"FORHISANTES",fmt:0,gxz:"Z221ForHisAntes",gxold:"O221ForHisAntes",gxvar:"A221ForHisAntes",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A221ForHisAntes=n)},v2z:function(n){n!==undefined&&(gx.O.Z221ForHisAntes=n)},v2c:function(n){gx.fn.setGridControlValue("FORHISANTES",n||gx.fn.currentGridRowImpl(18),gx.O.A221ForHisAntes,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A221ForHisAntes=this.val(n))},val:function(n){return gx.fn.getGridControlValue("FORHISANTES",n||gx.fn.currentGridRowImpl(18))},nac:gx.falseFn};r[25]={id:25,lvl:2,type:"char",len:10,dec:0,sign:!1,ro:1,isacc:0,grid:18,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONCODIGO",fmt:0,gxz:"Z26ConCodigo",gxold:"O26ConCodigo",gxvar:"A26ConCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A26ConCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z26ConCodigo=n)},v2c:function(n){gx.fn.setGridControlValue("CONCODIGO",n||gx.fn.currentGridRowImpl(18),gx.O.A26ConCodigo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A26ConCodigo=this.val(n))},val:function(n){return gx.fn.getGridControlValue("CONCODIGO",n||gx.fn.currentGridRowImpl(18))},nac:gx.falseFn};r[26]={id:26,fld:"",grid:0};r[27]={id:27,fld:"",grid:0};r[29]={id:29,fld:"",grid:0};r[30]={id:30,fld:"",grid:0};r[31]={id:31,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};r[33]={id:33,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};this.Z223ForHisFecha=gx.date.nullDate();this.O223ForHisFecha=gx.date.nullDate();this.Z224ForHisUsuario="";this.O224ForHisUsuario="";this.Z222ForHisDespues="";this.O222ForHisDespues="";this.Z51ForHisNum=0;this.O51ForHisNum=0;this.Z52ImpSec=0;this.O52ImpSec=0;this.Z221ForHisAntes="";this.O221ForHisAntes="";this.Z26ConCodigo="";this.O26ConCodigo="";this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.AV28GridCurrentPage=0;this.AV25DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.A3CliCod=0;this.AV35CliCod=0;this.AV7ConCodigo="";this.A223ForHisFecha=gx.date.nullDate();this.A224ForHisUsuario="";this.A222ForHisDespues="";this.A51ForHisNum=0;this.A52ImpSec=0;this.A221ForHisAntes="";this.A26ConCodigo="";this.AV40Pgmname="";this.AV13OrderedBy=0;this.AV14OrderedDsc=!1;this.Events={e114w2_client:["GRIDPAGINATIONBAR.CHANGEPAGE",!0],e124w2_client:["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!0],e134w2_client:["DDO_GRID.ONOPTIONCLICKED",!0],e174w2_client:["ENTER",!0],e184w2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:"AV35CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"sPrefix"},{ctrl:"GRID",prop:"Rows"},{av:"AV40Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""}],[{av:"AV35CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV28GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV29GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV30GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""}]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV35CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV40Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"sPrefix"},{av:"this.GRIDPAGINATIONBARContainer.SelectedPage",ctrl:"GRIDPAGINATIONBAR",prop:"SelectedPage"}],[]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV35CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV40Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"sPrefix"},{av:"this.GRIDPAGINATIONBARContainer.RowsPerPageSelectedValue",ctrl:"GRIDPAGINATIONBAR",prop:"RowsPerPageSelectedValue"}],[{ctrl:"GRID",prop:"Rows"}]];this.EvtParms["DDO_GRID.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV35CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV7ConCodigo",fld:"vCONCODIGO",pic:""},{av:"AV40Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"sPrefix"},{av:"this.DDO_GRIDContainer.ActiveEventKey",ctrl:"DDO_GRID",prop:"ActiveEventKey"},{av:"this.DDO_GRIDContainer.SelectedValue_get",ctrl:"DDO_GRID",prop:"SelectedValue_get"}],[{av:"AV13OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV14OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"this.DDO_GRIDContainer.SortedStatus",ctrl:"DDO_GRID",prop:"SortedStatus"}]];this.EvtParms["GRID.LOAD"]=[[],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV40Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV13OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV14OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV35CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV7ConCodigo","vCONCODIGO",0,"char",10,0);this.setVCMap("AV35CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV7ConCodigo","vCONCODIGO",0,"char",10,0);this.setVCMap("AV40Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV13OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV14OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV35CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV7ConCodigo","vCONCODIGO",0,"char",10,0);this.setVCMap("AV40Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV13OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV14OrderedDsc","vORDEREDDSC",0,"boolean",4,0);u.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});u.addRefreshingVar({rfrVar:"AV35CliCod"});u.addRefreshingVar({rfrVar:"AV7ConCodigo"});u.addRefreshingVar({rfrVar:"AV40Pgmname"});u.addRefreshingVar({rfrVar:"AV13OrderedBy"});u.addRefreshingVar({rfrVar:"AV14OrderedDsc"});u.addRefreshingParm({rfrVar:"AV35CliCod"});u.addRefreshingParm({rfrVar:"AV7ConCodigo"});u.addRefreshingParm({rfrVar:"AV40Pgmname"});u.addRefreshingParm({rfrVar:"AV13OrderedBy"});u.addRefreshingParm({rfrVar:"AV14OrderedDsc"});this.Initialize();this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWPGridState",{FilterValues:{sdt:"WWPBaseObjects\\WWPGridState.FilterValue"},DynamicFilters:{sdt:"WWPBaseObjects\\WWPGridState.DynamicFilter"}});this.setSDTMapping("WWPBaseObjects\\WWPGridState.DynamicFilter",{Dsc:{extr:"d"}})})