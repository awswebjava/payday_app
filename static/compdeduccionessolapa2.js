gx.evt.autoSkip=!1;gx.define("compdeduccionessolapa2",!0,function(n){var u,i,t,f,r;this.ServerClass="compdeduccionessolapa2";this.PackageName="web";this.ServerFullClass="web.compdeduccionessolapa2";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.anyGridBaseTable=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV42Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV17OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV18OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV20TFLegDedAnio=gx.fn.getIntegerValue("vTFLEGDEDANIO",gx.thousandSeparator);this.AV21TFLegDedAnio_To=gx.fn.getIntegerValue("vTFLEGDEDANIO_TO",gx.thousandSeparator);this.AV23TFLegDedMes_Sels=gx.fn.getControlValue("vTFLEGDEDMES_SELS");this.AV25TFLegDedConCodYDesc=gx.fn.getControlValue("vTFLEGDEDCONCODYDESC");this.AV26TFLegDedConCodYDesc_Sels=gx.fn.getControlValue("vTFLEGDEDCONCODYDESC_SELS");this.AV28TFLegDedDescrip=gx.fn.getControlValue("vTFLEGDEDDESCRIP");this.AV29TFLegDedDescrip_Sels=gx.fn.getControlValue("vTFLEGDEDDESCRIP_SELS");this.AV30TFLegDedImporte=gx.fn.getDecimalValue("vTFLEGDEDIMPORTE",gx.thousandSeparator,gx.decimalPoint);this.AV31TFLegDedImporte_To=gx.fn.getDecimalValue("vTFLEGDEDIMPORTE_TO",gx.thousandSeparator,gx.decimalPoint);this.AV8CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV9EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV11LegNumero=gx.fn.getIntegerValue("vLEGNUMERO",gx.thousandSeparator);this.AV39datetime=gx.fn.getDateTimeValue("vDATETIME");this.AV8CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV9EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV11LegNumero=gx.fn.getIntegerValue("vLEGNUMERO",gx.thousandSeparator);this.AV42Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV17OrderedBy=gx.fn.getIntegerValue("vORDEREDBY",gx.thousandSeparator);this.AV18OrderedDsc=gx.fn.getControlValue("vORDEREDDSC");this.AV20TFLegDedAnio=gx.fn.getIntegerValue("vTFLEGDEDANIO",gx.thousandSeparator);this.AV21TFLegDedAnio_To=gx.fn.getIntegerValue("vTFLEGDEDANIO_TO",gx.thousandSeparator);this.AV23TFLegDedMes_Sels=gx.fn.getControlValue("vTFLEGDEDMES_SELS");this.AV25TFLegDedConCodYDesc=gx.fn.getControlValue("vTFLEGDEDCONCODYDESC");this.AV26TFLegDedConCodYDesc_Sels=gx.fn.getControlValue("vTFLEGDEDCONCODYDESC_SELS");this.AV28TFLegDedDescrip=gx.fn.getControlValue("vTFLEGDEDDESCRIP");this.AV29TFLegDedDescrip_Sels=gx.fn.getControlValue("vTFLEGDEDDESCRIP_SELS");this.AV30TFLegDedImporte=gx.fn.getDecimalValue("vTFLEGDEDIMPORTE",gx.thousandSeparator,gx.decimalPoint);this.AV31TFLegDedImporte_To=gx.fn.getDecimalValue("vTFLEGDEDIMPORTE_TO",gx.thousandSeparator,gx.decimalPoint)};this.Valid_Clicod=function(){var n=gx.fn.currentGridRowImpl(23);return this.validCliEvt("Valid_Clicod",23,function(){try{if(gx.fn.currentGridRowImpl(23)===0)return!0;var n=gx.util.balloon.getNew("CLICOD",gx.fn.currentGridRowImpl(23));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Legdedconcodigo=function(){var n=gx.fn.currentGridRowImpl(23);return this.validCliEvt("Valid_Legdedconcodigo",23,function(){try{if(gx.fn.currentGridRowImpl(23)===0)return!0;var n=gx.util.balloon.getNew("LEGDEDCONCODIGO",gx.fn.currentGridRowImpl(23));this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s132_client=function(){this.DDO_GRIDContainer.SortedStatus=gx.text.trim(gx.num.str(this.AV17OrderedBy,4,0))+":"+(this.AV18OrderedDsc?"DSC":"ASC")};this.e11jz2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEPAGE",!1,null,!0,!0)};this.e12jz2_client=function(){return this.executeServerEvent("GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!1,null,!0,!0)};this.e13jz2_client=function(){return this.executeServerEvent("DDO_GRID.ONOPTIONCLICKED",!1,null,!0,!0)};this.e14jz2_client=function(){return this.executeServerEvent("'DOIMPORTARSIRADIG'",!1,null,!1,!1)};this.e18jz2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e19jz2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];u=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,9,10,11,12,13,14,15,16,17,20,21,22,24,25,26,27,28,29,30,31,32,33,34,35,36,37,39,40,41];this.GXLastCtrlId=41;this.GridContainer=new gx.grid.grid(this,2,"WbpLvl2",23,"Grid","Grid","GridContainer",this.CmpContext,this.IsMasterPage,"compdeduccionessolapa2",[],!1,1,!1,!0,0,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);i=this.GridContainer;i.addSingleLineEdit(3,24,"CLICOD",gx.getMessage("Cod"),"","CliCod","int",0,"px",6,6,"right",null,[],3,"CliCod",!1,0,!1,!1,"Attribute",0,"WWColumn");i.addSingleLineEdit(1,25,"EMPCOD",gx.getMessage("Empresa"),"","EmpCod","int",0,"px",4,4,"right",null,[],1,"EmpCod",!1,0,!1,!1,"Attribute",0,"WWColumn");i.addSingleLineEdit(6,26,"LEGNUMERO",gx.getMessage("Legajo"),"","LegNumero","int",0,"px",8,8,"right",null,[],6,"LegNumero",!1,0,!1,!1,"Attribute",0,"WWColumn");i.addSingleLineEdit(83,27,"LEGDEDSEC",gx.getMessage("Ded Sec"),"","LegDedSec","int",0,"px",8,8,"right",null,[],83,"LegDedSec",!1,0,!1,!1,"Attribute",0,"WWColumn");i.addSingleLineEdit(556,28,"LEGDEDFCHDES",gx.getMessage("Desde"),"","LegDedFchDes","date",0,"px",8,8,"right",null,[],556,"LegDedFchDes",!1,0,!1,!1,"Attribute",0,"WWColumn");i.addSingleLineEdit(768,29,"LEGDEDANIO",gx.getMessage("Año"),"","LegDedAnio","int",0,"px",4,4,"right",null,[],768,"LegDedAnio",!0,0,!1,!1,"Attribute",0,"WWColumn");i.addComboBox(767,30,"LEGDEDMES",gx.getMessage("Mes"),"LegDedMes","int",null,0,!0,!1,0,"px","WWColumn");i.addSingleLineEdit(557,31,"LEGDEDFCHHAS",gx.getMessage("Hasta"),"","LegDedFchHas","date",0,"px",8,8,"right",null,[],557,"LegDedFchHas",!1,0,!1,!1,"Attribute",0,"WWColumn");i.addSingleLineEdit(84,32,"LEGDEDCONCODIGO",gx.getMessage("Deducción"),"","LegDedConCodigo","char",0,"px",10,10,"left",null,[],84,"LegDedConCodigo",!1,0,!1,!1,"Attribute",0,"WWColumn");i.addSingleLineEdit(570,33,"LEGDEDCONCODYDESC",gx.getMessage("Concepto"),"","LegDedConCodYDesc","svchar",0,"px",400,80,"left",null,[],570,"LegDedConCodYDesc",!0,0,!1,!1,"Attribute",0,"WWColumn");i.addSingleLineEdit(568,34,"LEGDEDDESCRIP",gx.getMessage("Descripción"),"","LegDedDescrip","svchar",0,"px",400,80,"left",null,[],568,"LegDedDescrip",!0,0,!1,!1,"Attribute",0,"WWColumn hidden-xs");i.addSingleLineEdit(560,35,"LEGDEDIMPORTE",gx.getMessage("Importe"),"","LegDedImporte","decimal",0,"px",17,17,"right",null,[],560,"LegDedImporte",!0,2,!1,!1,"Attribute",0,"WWColumn hidden-xs");this.GridContainer.emptyText=gx.getMessage("");this.setGrid(i);this.DDO_GRIDContainer=gx.uc.getNew(this,42,24,"DDOGridTitleSettingsM",this.CmpContext+"DDO_GRIDContainer","Ddo_grid","DDO_GRID");t=this.DDO_GRIDContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","","str");t.setProp("ActiveEventKey","Activeeventkey","","char");t.setDynProp("FilteredText_set","Filteredtext_set","","char");t.setProp("FilteredText_get","Filteredtext_get","","char");t.setDynProp("FilteredTextTo_set","Filteredtextto_set","","char");t.setProp("FilteredTextTo_get","Filteredtextto_get","","char");t.setDynProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("SelectedColumn","Selectedcolumn","","char");t.setProp("SelectedColumnFixedFilter","Selectedcolumnfixedfilter","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("TitleControlAlign","Titlecontrolalign","","str");t.setProp("Visible","Visible","","str");t.setDynProp("GridInternalName","Gridinternalname","","str");t.setProp("ColumnIds","Columnids","5:LegDedAnio|6:LegDedMes|9:LegDedConCodYDesc|10:LegDedDescrip|11:LegDedImporte","str");t.setProp("ColumnsSortValues","Columnssortvalues","1|2|3|4|5","str");t.setProp("IncludeSortASC","Includesortasc","T","str");t.setProp("IncludeSortDSC","Includesortdsc","","str");t.setProp("AllowGroup","Allowgroup","","str");t.setProp("Fixable","Fixable","","str");t.setDynProp("SortedStatus","Sortedstatus","","char");t.setProp("IncludeFilter","Includefilter","T||T|T|T","str");t.setProp("FilterType","Filtertype","Numeric||Character|Character|Numeric","str");t.setProp("FilterIsRange","Filterisrange","T||||T","str");t.setProp("IncludeDataList","Includedatalist","|T|T|T|","str");t.setProp("DataListType","Datalisttype","|FixedValues|Dynamic|Dynamic|","str");t.setProp("AllowMultipleSelection","Allowmultipleselection","|T|T|T|","str");t.setProp("DataListFixedValues","Datalistfixedvalues","|1:Enero,2:Febrero,3:Marzo,4:Abril,5:Mayo,6:Junio,7:Julio,8:Agosto,9:Septiembre,10:Octubre,11:Noviembre,12:Diciembre|||","str");t.setProp("DataListProc","Datalistproc","CompDeduccionesSolapa2GetFilterData","str");t.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("FixedFilters","Fixedfilters","","str");t.setProp("Format","Format","4.0||||-14.2","str");t.setProp("SelectedFixedFilter","Selectedfixedfilter","","char");t.setProp("SortASC","Sortasc","","str");t.setProp("SortDSC","Sortdsc","","str");t.setProp("AllowGroupText","Allowgrouptext","","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("CleanFilter","Cleanfilter","","str");t.setProp("RangeFilterFrom","Rangefilterfrom","","str");t.setProp("RangeFilterTo","Rangefilterto","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("SearchButtonText","Searchbuttontext","","str");t.addV2CFunction("AV32DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV32DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV32DDO_TitleSettingsIcons)});t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e13jz2_client);this.setUserControl(t);this.GRID_EMPOWERERContainer=gx.uc.getNew(this,43,24,"WWP_GridEmpowerer",this.CmpContext+"GRID_EMPOWERERContainer","Grid_empowerer","GRID_EMPOWERER");f=this.GRID_EMPOWERERContainer;f.setProp("Class","Class","","char");f.setProp("Enabled","Enabled",!0,"boolean");f.setDynProp("GridInternalName","Gridinternalname","","char");f.setProp("HasCategories","Hascategories",!1,"bool");f.setProp("InfiniteScrolling","Infinitescrolling","False","str");f.setProp("HasTitleSettings","Hastitlesettings",!0,"bool");f.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");f.setProp("HasRowGroups","Hasrowgroups",!1,"bool");f.setProp("FixedColumns","Fixedcolumns","","str");f.setProp("PopoversInGrid","Popoversingrid","","str");f.setProp("Visible","Visible",!0,"bool");f.setC2ShowFunction(function(n){n.show()});this.setUserControl(f);this.GRIDPAGINATIONBARContainer=gx.uc.getNew(this,38,24,"DVelop_DVPaginationBar",this.CmpContext+"GRIDPAGINATIONBARContainer","Gridpaginationbar","GRIDPAGINATIONBAR");r=this.GRIDPAGINATIONBARContainer;r.setProp("Enabled","Enabled",!0,"boolean");r.setProp("Class","Class","PaginationBar","str");r.setProp("ShowFirst","Showfirst",!1,"bool");r.setProp("ShowPrevious","Showprevious",!0,"bool");r.setProp("ShowNext","Shownext",!0,"bool");r.setProp("ShowLast","Showlast",!1,"bool");r.setProp("PagesToShow","Pagestoshow",5,"num");r.setProp("PagingButtonsPosition","Pagingbuttonsposition","Right","str");r.setProp("PagingCaptionPosition","Pagingcaptionposition","Left","str");r.setProp("EmptyGridClass","Emptygridclass","PaginationBarEmptyGrid","str");r.setProp("SelectedPage","Selectedpage","","char");r.setProp("RowsPerPageSelector","Rowsperpageselector",!0,"bool");r.setDynProp("RowsPerPageSelectedValue","Rowsperpageselectedvalue",10,"num");r.setProp("RowsPerPageOptions","Rowsperpageoptions","5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50","str");r.setProp("First","First","First","str");r.setProp("Previous","Previous","WWP_PagingPreviousCaption","str");r.setProp("Next","Next","WWP_PagingNextCaption","str");r.setProp("Last","Last","Last","str");r.setProp("Caption","Caption",gx.getMessage("WWP_PagingCaption"),"str");r.setProp("EmptyGridCaption","Emptygridcaption","WWP_PagingEmptyGridCaption","str");r.setProp("RowsPerPageCaption","Rowsperpagecaption","WWP_PagingRowsPerPage","str");r.addV2CFunction("AV35GridCurrentPage","vGRIDCURRENTPAGE","SetCurrentPage");r.addC2VFunction(function(n){n.ParentObject.AV35GridCurrentPage=n.GetCurrentPage();gx.fn.setControlValue("vGRIDCURRENTPAGE",n.ParentObject.AV35GridCurrentPage)});r.addV2CFunction("AV36GridPageCount","vGRIDPAGECOUNT","SetPageCount");r.addC2VFunction(function(n){n.ParentObject.AV36GridPageCount=n.GetPageCount();gx.fn.setControlValue("vGRIDPAGECOUNT",n.ParentObject.AV36GridPageCount)});r.setProp("RecordCount","Recordcount","","str");r.setProp("Page","Page","","str");r.addV2CFunction("AV37GridAppliedFilters","vGRIDAPPLIEDFILTERS","SetAppliedFilters");r.addC2VFunction(function(n){n.ParentObject.AV37GridAppliedFilters=n.GetAppliedFilters();gx.fn.setControlValue("vGRIDAPPLIEDFILTERS",n.ParentObject.AV37GridAppliedFilters)});r.setProp("Visible","Visible",!0,"bool");r.setProp("Gx Control Type","Gxcontroltype","","int");r.setC2ShowFunction(function(n){n.show()});r.addEventHandler("ChangePage",this.e11jz2_client);r.addEventHandler("ChangeRowsPerPage",this.e12jz2_client);this.setUserControl(r);u[2]={id:2,fld:"",grid:0};u[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};u[4]={id:4,fld:"",grid:0};u[5]={id:5,fld:"",grid:0};u[6]={id:6,fld:"UNNAMEDTABLE1",grid:0};u[9]={id:9,fld:"TABLEHEADER",grid:0};u[10]={id:10,fld:"",grid:0};u[11]={id:11,fld:"TABLEHEADERCONTENT",grid:0};u[12]={id:12,fld:"",grid:0};u[13]={id:13,fld:"TABLEACTIONS",grid:0};u[14]={id:14,fld:"",grid:0};u[15]={id:15,fld:"",grid:0};u[16]={id:16,fld:"",grid:0};u[17]={id:17,fld:"BTNIMPORTARSIRADIG",grid:0,evt:"e14jz2_client"};u[20]={id:20,fld:"GRIDTABLEWITHPAGINATIONBAR",grid:0};u[21]={id:21,fld:"",grid:0};u[22]={id:22,fld:"",grid:0};u[24]={id:24,lvl:2,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("CLICOD",n||gx.fn.currentGridRowImpl(23),gx.O.A3CliCod,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("CLICOD",n||gx.fn.currentGridRowImpl(23),gx.thousandSeparator)},nac:gx.falseFn};u[25]={id:25,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPCOD",fmt:0,gxz:"Z1EmpCod",gxold:"O1EmpCod",gxvar:"A1EmpCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A1EmpCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1EmpCod=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("EMPCOD",n||gx.fn.currentGridRowImpl(23),gx.O.A1EmpCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A1EmpCod=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("EMPCOD",n||gx.fn.currentGridRowImpl(23),gx.thousandSeparator)},nac:gx.falseFn};u[26]={id:26,lvl:2,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGNUMERO",fmt:0,gxz:"Z6LegNumero",gxold:"O6LegNumero",gxvar:"A6LegNumero",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A6LegNumero=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z6LegNumero=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("LEGNUMERO",n||gx.fn.currentGridRowImpl(23),gx.O.A6LegNumero,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A6LegNumero=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("LEGNUMERO",n||gx.fn.currentGridRowImpl(23),gx.thousandSeparator)},nac:gx.falseFn};u[27]={id:27,lvl:2,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDSEC",fmt:0,gxz:"Z83LegDedSec",gxold:"O83LegDedSec",gxvar:"A83LegDedSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A83LegDedSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z83LegDedSec=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("LEGDEDSEC",n||gx.fn.currentGridRowImpl(23),gx.O.A83LegDedSec,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A83LegDedSec=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("LEGDEDSEC",n||gx.fn.currentGridRowImpl(23),gx.thousandSeparator)},nac:gx.falseFn};u[28]={id:28,lvl:2,type:"date",len:8,dec:0,sign:!1,ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDFCHDES",fmt:0,gxz:"Z556LegDedFchDes",gxold:"O556LegDedFchDes",gxvar:"A556LegDedFchDes",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A556LegDedFchDes=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z556LegDedFchDes=gx.fn.toDatetimeValue(n))},v2c:function(n){gx.fn.setGridControlValue("LEGDEDFCHDES",n||gx.fn.currentGridRowImpl(23),gx.O.A556LegDedFchDes,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A556LegDedFchDes=gx.fn.toDatetimeValue(this.val(n)))},val:function(n){return gx.fn.getGridDateTimeValue("LEGDEDFCHDES",n||gx.fn.currentGridRowImpl(23))},nac:gx.falseFn};u[29]={id:29,lvl:2,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDANIO",fmt:0,gxz:"Z768LegDedAnio",gxold:"O768LegDedAnio",gxvar:"A768LegDedAnio",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A768LegDedAnio=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z768LegDedAnio=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("LEGDEDANIO",n||gx.fn.currentGridRowImpl(23),gx.O.A768LegDedAnio,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A768LegDedAnio=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("LEGDEDANIO",n||gx.fn.currentGridRowImpl(23),gx.thousandSeparator)},nac:gx.falseFn};u[30]={id:30,lvl:2,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDMES",fmt:0,gxz:"Z767LegDedMes",gxold:"O767LegDedMes",gxvar:"A767LegDedMes",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A767LegDedMes=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z767LegDedMes=gx.num.intval(n))},v2c:function(n){gx.fn.setGridComboBoxValue("LEGDEDMES",n||gx.fn.currentGridRowImpl(23),gx.O.A767LegDedMes);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A767LegDedMes=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("LEGDEDMES",n||gx.fn.currentGridRowImpl(23),gx.thousandSeparator)},nac:gx.falseFn};u[31]={id:31,lvl:2,type:"date",len:8,dec:0,sign:!1,ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDFCHHAS",fmt:0,gxz:"Z557LegDedFchHas",gxold:"O557LegDedFchHas",gxvar:"A557LegDedFchHas",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A557LegDedFchHas=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z557LegDedFchHas=gx.fn.toDatetimeValue(n))},v2c:function(n){gx.fn.setGridControlValue("LEGDEDFCHHAS",n||gx.fn.currentGridRowImpl(23),gx.O.A557LegDedFchHas,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A557LegDedFchHas=gx.fn.toDatetimeValue(this.val(n)))},val:function(n){return gx.fn.getGridDateTimeValue("LEGDEDFCHHAS",n||gx.fn.currentGridRowImpl(23))},nac:gx.falseFn};u[32]={id:32,lvl:2,type:"char",len:10,dec:0,sign:!1,ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:this.Valid_Legdedconcodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDCONCODIGO",fmt:0,gxz:"Z84LegDedConCodigo",gxold:"O84LegDedConCodigo",gxvar:"A84LegDedConCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A84LegDedConCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z84LegDedConCodigo=n)},v2c:function(n){gx.fn.setGridControlValue("LEGDEDCONCODIGO",n||gx.fn.currentGridRowImpl(23),gx.O.A84LegDedConCodigo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A84LegDedConCodigo=this.val(n))},val:function(n){return gx.fn.getGridControlValue("LEGDEDCONCODIGO",n||gx.fn.currentGridRowImpl(23))},nac:gx.falseFn};u[33]={id:33,lvl:2,type:"svchar",len:400,dec:0,sign:!1,ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDCONCODYDESC",fmt:0,gxz:"Z570LegDedConCodYDesc",gxold:"O570LegDedConCodYDesc",gxvar:"A570LegDedConCodYDesc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A570LegDedConCodYDesc=n)},v2z:function(n){n!==undefined&&(gx.O.Z570LegDedConCodYDesc=n)},v2c:function(n){gx.fn.setGridControlValue("LEGDEDCONCODYDESC",n||gx.fn.currentGridRowImpl(23),gx.O.A570LegDedConCodYDesc,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A570LegDedConCodYDesc=this.val(n))},val:function(n){return gx.fn.getGridControlValue("LEGDEDCONCODYDESC",n||gx.fn.currentGridRowImpl(23))},nac:gx.falseFn};u[34]={id:34,lvl:2,type:"svchar",len:400,dec:0,sign:!1,ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDDESCRIP",fmt:0,gxz:"Z568LegDedDescrip",gxold:"O568LegDedDescrip",gxvar:"A568LegDedDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A568LegDedDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z568LegDedDescrip=n)},v2c:function(n){gx.fn.setGridControlValue("LEGDEDDESCRIP",n||gx.fn.currentGridRowImpl(23),gx.O.A568LegDedDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A568LegDedDescrip=this.val(n))},val:function(n){return gx.fn.getGridControlValue("LEGDEDDESCRIP",n||gx.fn.currentGridRowImpl(23))},nac:gx.falseFn};u[35]={id:35,lvl:2,type:"decimal",len:14,dec:2,sign:!0,pic:"ZZ,ZZZ,ZZZ,ZZ9.99",ro:1,isacc:0,grid:23,gxgrid:this.GridContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGDEDIMPORTE",fmt:0,gxz:"Z560LegDedImporte",gxold:"O560LegDedImporte",gxvar:"A560LegDedImporte",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A560LegDedImporte=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z560LegDedImporte=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(n){gx.fn.setGridDecimalValue("LEGDEDIMPORTE",n||gx.fn.currentGridRowImpl(23),gx.O.A560LegDedImporte,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A560LegDedImporte=this.val(n))},val:function(n){return gx.fn.getGridDecimalValue("LEGDEDIMPORTE",n||gx.fn.currentGridRowImpl(23),gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};u[36]={id:36,fld:"",grid:0};u[37]={id:37,fld:"",grid:0};u[39]={id:39,fld:"",grid:0};u[40]={id:40,fld:"",grid:0};u[41]={id:41,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};this.Z3CliCod=0;this.O3CliCod=0;this.Z1EmpCod=0;this.O1EmpCod=0;this.Z6LegNumero=0;this.O6LegNumero=0;this.Z83LegDedSec=0;this.O83LegDedSec=0;this.Z556LegDedFchDes=gx.date.nullDate();this.O556LegDedFchDes=gx.date.nullDate();this.Z768LegDedAnio=0;this.O768LegDedAnio=0;this.Z767LegDedMes=0;this.O767LegDedMes=0;this.Z557LegDedFchHas=gx.date.nullDate();this.O557LegDedFchHas=gx.date.nullDate();this.Z84LegDedConCodigo="";this.O84LegDedConCodigo="";this.Z570LegDedConCodYDesc="";this.O570LegDedConCodYDesc="";this.Z568LegDedDescrip="";this.O568LegDedDescrip="";this.Z560LegDedImporte=0;this.O560LegDedImporte=0;this.AV35GridCurrentPage=0;this.AV32DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV8CliCod=0;this.AV9EmpCod=0;this.AV11LegNumero=0;this.A559LegDedConDescrip="";this.A3CliCod=0;this.A1EmpCod=0;this.A6LegNumero=0;this.A83LegDedSec=0;this.A556LegDedFchDes=gx.date.nullDate();this.A768LegDedAnio=0;this.A767LegDedMes=0;this.A557LegDedFchHas=gx.date.nullDate();this.A84LegDedConCodigo="";this.A570LegDedConCodYDesc="";this.A568LegDedDescrip="";this.A560LegDedImporte=0;this.AV42Pgmname="";this.AV17OrderedBy=0;this.AV18OrderedDsc=!1;this.AV20TFLegDedAnio=0;this.AV21TFLegDedAnio_To=0;this.AV23TFLegDedMes_Sels=[];this.AV25TFLegDedConCodYDesc="";this.AV26TFLegDedConCodYDesc_Sels=[];this.AV28TFLegDedDescrip="";this.AV29TFLegDedDescrip_Sels=[];this.AV30TFLegDedImporte=0;this.AV31TFLegDedImporte_To=0;this.AV39datetime=gx.date.nullDate();this.Events={e11jz2_client:["GRIDPAGINATIONBAR.CHANGEPAGE",!0],e12jz2_client:["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE",!0],e13jz2_client:["DDO_GRID.ONOPTIONCLICKED",!0],e14jz2_client:["'DOIMPORTARSIRADIG'",!0],e18jz2_client:["ENTER",!0],e19jz2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{av:"sPrefix"},{ctrl:"GRID",prop:"Rows"},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"AV11LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9"},{av:"AV42Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV17OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV18OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV20TFLegDedAnio",fld:"vTFLEGDEDANIO",pic:"ZZZ9"},{av:"AV21TFLegDedAnio_To",fld:"vTFLEGDEDANIO_TO",pic:"ZZZ9"},{av:"AV23TFLegDedMes_Sels",fld:"vTFLEGDEDMES_SELS",pic:""},{av:"AV25TFLegDedConCodYDesc",fld:"vTFLEGDEDCONCODYDESC",pic:""},{av:"AV26TFLegDedConCodYDesc_Sels",fld:"vTFLEGDEDCONCODYDESC_SELS",pic:""},{av:"AV28TFLegDedDescrip",fld:"vTFLEGDEDDESCRIP",pic:""},{av:"AV29TFLegDedDescrip_Sels",fld:"vTFLEGDEDDESCRIP_SELS",pic:""},{av:"AV30TFLegDedImporte",fld:"vTFLEGDEDIMPORTE",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV31TFLegDedImporte_To",fld:"vTFLEGDEDIMPORTE_TO",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV39datetime",fld:"vDATETIME",pic:"99/99/99 99:99",hsh:!0}],[{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV35GridCurrentPage",fld:"vGRIDCURRENTPAGE",pic:"ZZZZZZZZZ9"},{av:"AV36GridPageCount",fld:"vGRIDPAGECOUNT",pic:"ZZZZZZZZZ9"},{av:"AV37GridAppliedFilters",fld:"vGRIDAPPLIEDFILTERS",pic:""},{ctrl:"BTNIMPORTARSIRADIG",prop:"Visible"}]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"AV11LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9"},{av:"AV42Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV17OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV18OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV20TFLegDedAnio",fld:"vTFLEGDEDANIO",pic:"ZZZ9"},{av:"AV21TFLegDedAnio_To",fld:"vTFLEGDEDANIO_TO",pic:"ZZZ9"},{av:"AV23TFLegDedMes_Sels",fld:"vTFLEGDEDMES_SELS",pic:""},{av:"AV25TFLegDedConCodYDesc",fld:"vTFLEGDEDCONCODYDESC",pic:""},{av:"AV26TFLegDedConCodYDesc_Sels",fld:"vTFLEGDEDCONCODYDESC_SELS",pic:""},{av:"AV28TFLegDedDescrip",fld:"vTFLEGDEDDESCRIP",pic:""},{av:"AV29TFLegDedDescrip_Sels",fld:"vTFLEGDEDDESCRIP_SELS",pic:""},{av:"AV30TFLegDedImporte",fld:"vTFLEGDEDIMPORTE",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV31TFLegDedImporte_To",fld:"vTFLEGDEDIMPORTE_TO",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV39datetime",fld:"vDATETIME",pic:"99/99/99 99:99",hsh:!0},{av:"sPrefix"},{av:"this.GRIDPAGINATIONBARContainer.SelectedPage",ctrl:"GRIDPAGINATIONBAR",prop:"SelectedPage"}],[]];this.EvtParms["GRIDPAGINATIONBAR.CHANGEROWSPERPAGE"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"AV11LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9"},{av:"AV42Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV17OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV18OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV20TFLegDedAnio",fld:"vTFLEGDEDANIO",pic:"ZZZ9"},{av:"AV21TFLegDedAnio_To",fld:"vTFLEGDEDANIO_TO",pic:"ZZZ9"},{av:"AV23TFLegDedMes_Sels",fld:"vTFLEGDEDMES_SELS",pic:""},{av:"AV25TFLegDedConCodYDesc",fld:"vTFLEGDEDCONCODYDESC",pic:""},{av:"AV26TFLegDedConCodYDesc_Sels",fld:"vTFLEGDEDCONCODYDESC_SELS",pic:""},{av:"AV28TFLegDedDescrip",fld:"vTFLEGDEDDESCRIP",pic:""},{av:"AV29TFLegDedDescrip_Sels",fld:"vTFLEGDEDDESCRIP_SELS",pic:""},{av:"AV30TFLegDedImporte",fld:"vTFLEGDEDIMPORTE",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV31TFLegDedImporte_To",fld:"vTFLEGDEDIMPORTE_TO",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV39datetime",fld:"vDATETIME",pic:"99/99/99 99:99",hsh:!0},{av:"sPrefix"},{av:"this.GRIDPAGINATIONBARContainer.RowsPerPageSelectedValue",ctrl:"GRIDPAGINATIONBAR",prop:"RowsPerPageSelectedValue"}],[{ctrl:"GRID",prop:"Rows"}]];this.EvtParms["DDO_GRID.ONOPTIONCLICKED"]=[[{av:"GRID_nFirstRecordOnPage"},{av:"GRID_nEOF"},{ctrl:"GRID",prop:"Rows"},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"AV11LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9"},{av:"AV42Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV17OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV18OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV20TFLegDedAnio",fld:"vTFLEGDEDANIO",pic:"ZZZ9"},{av:"AV21TFLegDedAnio_To",fld:"vTFLEGDEDANIO_TO",pic:"ZZZ9"},{av:"AV23TFLegDedMes_Sels",fld:"vTFLEGDEDMES_SELS",pic:""},{av:"AV25TFLegDedConCodYDesc",fld:"vTFLEGDEDCONCODYDESC",pic:""},{av:"AV26TFLegDedConCodYDesc_Sels",fld:"vTFLEGDEDCONCODYDESC_SELS",pic:""},{av:"AV28TFLegDedDescrip",fld:"vTFLEGDEDDESCRIP",pic:""},{av:"AV29TFLegDedDescrip_Sels",fld:"vTFLEGDEDDESCRIP_SELS",pic:""},{av:"AV30TFLegDedImporte",fld:"vTFLEGDEDIMPORTE",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV31TFLegDedImporte_To",fld:"vTFLEGDEDIMPORTE_TO",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV39datetime",fld:"vDATETIME",pic:"99/99/99 99:99",hsh:!0},{av:"sPrefix"},{av:"this.DDO_GRIDContainer.ActiveEventKey",ctrl:"DDO_GRID",prop:"ActiveEventKey"},{av:"this.DDO_GRIDContainer.SelectedValue_get",ctrl:"DDO_GRID",prop:"SelectedValue_get"},{av:"this.DDO_GRIDContainer.SelectedColumn",ctrl:"DDO_GRID",prop:"SelectedColumn"},{av:"this.DDO_GRIDContainer.FilteredText_get",ctrl:"DDO_GRID",prop:"FilteredText_get"},{av:"this.DDO_GRIDContainer.FilteredTextTo_get",ctrl:"DDO_GRID",prop:"FilteredTextTo_get"}],[{av:"AV17OrderedBy",fld:"vORDEREDBY",pic:"ZZZ9"},{av:"AV18OrderedDsc",fld:"vORDEREDDSC",pic:""},{av:"AV20TFLegDedAnio",fld:"vTFLEGDEDANIO",pic:"ZZZ9"},{av:"AV21TFLegDedAnio_To",fld:"vTFLEGDEDANIO_TO",pic:"ZZZ9"},{av:"AV22TFLegDedMes_SelsJson",fld:"vTFLEGDEDMES_SELSJSON",pic:""},{av:"AV23TFLegDedMes_Sels",fld:"vTFLEGDEDMES_SELS",pic:""},{av:"AV25TFLegDedConCodYDesc",fld:"vTFLEGDEDCONCODYDESC",pic:""},{av:"AV24TFLegDedConCodYDesc_SelsJson",fld:"vTFLEGDEDCONCODYDESC_SELSJSON",pic:""},{av:"AV26TFLegDedConCodYDesc_Sels",fld:"vTFLEGDEDCONCODYDESC_SELS",pic:""},{av:"AV28TFLegDedDescrip",fld:"vTFLEGDEDDESCRIP",pic:""},{av:"AV27TFLegDedDescrip_SelsJson",fld:"vTFLEGDEDDESCRIP_SELSJSON",pic:""},{av:"AV29TFLegDedDescrip_Sels",fld:"vTFLEGDEDDESCRIP_SELS",pic:""},{av:"AV30TFLegDedImporte",fld:"vTFLEGDEDIMPORTE",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV31TFLegDedImporte_To",fld:"vTFLEGDEDIMPORTE_TO",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"this.DDO_GRIDContainer.SortedStatus",ctrl:"DDO_GRID",prop:"SortedStatus"}]];this.EvtParms["GRID.LOAD"]=[[],[]];this.EvtParms["'DOIMPORTARSIRADIG'"]=[[{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"AV39datetime",fld:"vDATETIME",pic:"99/99/99 99:99",hsh:!0},{av:"AV11LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9"}],[{av:"AV11LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.EvtParms.VALID_LEGDEDCONCODIGO=[[],[]];this.setVCMap("AV42Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV17OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV18OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV20TFLegDedAnio","vTFLEGDEDANIO",0,"int",4,0);this.setVCMap("AV21TFLegDedAnio_To","vTFLEGDEDANIO_TO",0,"int",4,0);this.setVCMap("AV23TFLegDedMes_Sels","vTFLEGDEDMES_SELS",0,"Collint",0,0);this.setVCMap("AV25TFLegDedConCodYDesc","vTFLEGDEDCONCODYDESC",0,"svchar",400,0);this.setVCMap("AV26TFLegDedConCodYDesc_Sels","vTFLEGDEDCONCODYDESC_SELS",0,"Collsvchar",0,0);this.setVCMap("AV28TFLegDedDescrip","vTFLEGDEDDESCRIP",0,"svchar",400,0);this.setVCMap("AV29TFLegDedDescrip_Sels","vTFLEGDEDDESCRIP_SELS",0,"Collsvchar",0,0);this.setVCMap("AV30TFLegDedImporte","vTFLEGDEDIMPORTE",0,"decimal",14,2);this.setVCMap("AV31TFLegDedImporte_To","vTFLEGDEDIMPORTE_TO",0,"decimal",14,2);this.setVCMap("AV8CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV9EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV11LegNumero","vLEGNUMERO",0,"int",8,0);this.setVCMap("AV39datetime","vDATETIME",0,"dtime",8,5);this.setVCMap("AV8CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV9EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV11LegNumero","vLEGNUMERO",0,"int",8,0);this.setVCMap("AV42Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV17OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV18OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV20TFLegDedAnio","vTFLEGDEDANIO",0,"int",4,0);this.setVCMap("AV21TFLegDedAnio_To","vTFLEGDEDANIO_TO",0,"int",4,0);this.setVCMap("AV23TFLegDedMes_Sels","vTFLEGDEDMES_SELS",0,"Collint",0,0);this.setVCMap("AV25TFLegDedConCodYDesc","vTFLEGDEDCONCODYDESC",0,"svchar",400,0);this.setVCMap("AV26TFLegDedConCodYDesc_Sels","vTFLEGDEDCONCODYDESC_SELS",0,"Collsvchar",0,0);this.setVCMap("AV28TFLegDedDescrip","vTFLEGDEDDESCRIP",0,"svchar",400,0);this.setVCMap("AV29TFLegDedDescrip_Sels","vTFLEGDEDDESCRIP_SELS",0,"Collsvchar",0,0);this.setVCMap("AV30TFLegDedImporte","vTFLEGDEDIMPORTE",0,"decimal",14,2);this.setVCMap("AV31TFLegDedImporte_To","vTFLEGDEDIMPORTE_TO",0,"decimal",14,2);this.setVCMap("AV8CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV9EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV11LegNumero","vLEGNUMERO",0,"int",8,0);this.setVCMap("AV42Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV17OrderedBy","vORDEREDBY",0,"int",4,0);this.setVCMap("AV18OrderedDsc","vORDEREDDSC",0,"boolean",4,0);this.setVCMap("AV20TFLegDedAnio","vTFLEGDEDANIO",0,"int",4,0);this.setVCMap("AV21TFLegDedAnio_To","vTFLEGDEDANIO_TO",0,"int",4,0);this.setVCMap("AV23TFLegDedMes_Sels","vTFLEGDEDMES_SELS",0,"Collint",0,0);this.setVCMap("AV25TFLegDedConCodYDesc","vTFLEGDEDCONCODYDESC",0,"svchar",400,0);this.setVCMap("AV26TFLegDedConCodYDesc_Sels","vTFLEGDEDCONCODYDESC_SELS",0,"Collsvchar",0,0);this.setVCMap("AV28TFLegDedDescrip","vTFLEGDEDDESCRIP",0,"svchar",400,0);this.setVCMap("AV29TFLegDedDescrip_Sels","vTFLEGDEDDESCRIP_SELS",0,"Collsvchar",0,0);this.setVCMap("AV30TFLegDedImporte","vTFLEGDEDIMPORTE",0,"decimal",14,2);this.setVCMap("AV31TFLegDedImporte_To","vTFLEGDEDIMPORTE_TO",0,"decimal",14,2);i.addRefreshingParm({rfrProp:"Rows",gxGrid:"Grid"});i.addRefreshingVar({rfrVar:"AV8CliCod"});i.addRefreshingVar({rfrVar:"AV9EmpCod"});i.addRefreshingVar({rfrVar:"AV11LegNumero"});i.addRefreshingVar({rfrVar:"AV42Pgmname"});i.addRefreshingVar({rfrVar:"AV17OrderedBy"});i.addRefreshingVar({rfrVar:"AV18OrderedDsc"});i.addRefreshingVar({rfrVar:"AV20TFLegDedAnio"});i.addRefreshingVar({rfrVar:"AV21TFLegDedAnio_To"});i.addRefreshingVar({rfrVar:"AV23TFLegDedMes_Sels"});i.addRefreshingVar({rfrVar:"AV25TFLegDedConCodYDesc"});i.addRefreshingVar({rfrVar:"AV26TFLegDedConCodYDesc_Sels"});i.addRefreshingVar({rfrVar:"AV28TFLegDedDescrip"});i.addRefreshingVar({rfrVar:"AV29TFLegDedDescrip_Sels"});i.addRefreshingVar({rfrVar:"AV30TFLegDedImporte"});i.addRefreshingVar({rfrVar:"AV31TFLegDedImporte_To"});i.addRefreshingVar({rfrVar:"AV39datetime"});i.addRefreshingParm({rfrVar:"AV8CliCod"});i.addRefreshingParm({rfrVar:"AV9EmpCod"});i.addRefreshingParm({rfrVar:"AV11LegNumero"});i.addRefreshingParm({rfrVar:"AV42Pgmname"});i.addRefreshingParm({rfrVar:"AV17OrderedBy"});i.addRefreshingParm({rfrVar:"AV18OrderedDsc"});i.addRefreshingParm({rfrVar:"AV20TFLegDedAnio"});i.addRefreshingParm({rfrVar:"AV21TFLegDedAnio_To"});i.addRefreshingParm({rfrVar:"AV23TFLegDedMes_Sels"});i.addRefreshingParm({rfrVar:"AV25TFLegDedConCodYDesc"});i.addRefreshingParm({rfrVar:"AV26TFLegDedConCodYDesc_Sels"});i.addRefreshingParm({rfrVar:"AV28TFLegDedDescrip"});i.addRefreshingParm({rfrVar:"AV29TFLegDedDescrip_Sels"});i.addRefreshingParm({rfrVar:"AV30TFLegDedImporte"});i.addRefreshingParm({rfrVar:"AV31TFLegDedImporte_To"});i.addRefreshingParm({rfrVar:"AV39datetime"});this.Initialize();this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWPGridState",{FilterValues:{sdt:"WWPBaseObjects\\WWPGridState.FilterValue"}})})