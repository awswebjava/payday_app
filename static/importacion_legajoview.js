gx.evt.autoSkip=!1;gx.define("importacion_legajoview",!1,function(){var n,t;this.ServerClass="importacion_legajoview";this.PackageName="web";this.ServerFullClass="web.importacion_legajoview";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A3CliCod=gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator);this.AV10CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.A1EmpCod=gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator);this.AV11EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.A87MigrLegNumero=gx.fn.getIntegerValue("MIGRLEGNUMERO",gx.thousandSeparator);this.AV12MigrLegNumero=gx.fn.getIntegerValue("vMIGRLEGNUMERO",gx.thousandSeparator);this.AV13LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV14SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE");this.AV8TabCode=gx.fn.getControlValue("vTABCODE")};this.e110h2_client=function(){return this.executeServerEvent("TABS.TABCHANGED",!1,null,!0,!0)};this.e140h2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e150h2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,20,21,22,25,26,28,29,30];this.GXLastCtrlId=30;this.TABSContainer=gx.uc.getNew(this,15,0,"gx.ui.controls.Tab","TABSContainer","Tabs","TABS");t=this.TABSContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("ActivePage","Activepage","","int");t.setDynProp("ActivePageControlName","Activepagecontrolname","","char");t.setProp("PageCount","Pagecount",2,"num");t.setProp("Class","Class","ViewTab Tab","str");t.setProp("HistoryManagement","Historymanagement",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("TabChanged",this.e110h2_client);this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"UNNAMEDTABLEVIEWCONTAINER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"GENERAL_TITLE",format:0,grid:0,ctrltype:"textblock"};n[18]={id:18,fld:"",grid:0};n[20]={id:20,fld:"UNNAMEDTABLEGENERAL",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[25]={id:25,fld:"MIGRLEGUPD_TITLE",format:0,grid:0,ctrltype:"textblock"};n[26]={id:26,fld:"",grid:0};n[28]={id:28,fld:"UNNAMEDTABLEMIGRLEGUPD",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};this.AV10CliCod=0;this.AV11EmpCod=0;this.AV12MigrLegNumero=0;this.AV8TabCode="";this.A87MigrLegNumero=0;this.A1EmpCod=0;this.A3CliCod=0;this.A597MigrLegCUIL="";this.AV13LoadAllTabs=!1;this.AV14SelectedTabCode="";this.Events={e110h2_client:["TABS.TABCHANGED",!0],e140h2_client:["ENTER",!0],e150h2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"AV10CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV11EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV12MigrLegNumero",fld:"vMIGRLEGNUMERO",pic:"ZZZZZZZ9",hsh:!0},{av:"AV8TabCode",fld:"vTABCODE",pic:"",hsh:!0}],[]];this.EvtParms["TABS.TABCHANGED"]=[[{av:"this.TABSContainer.ActivePageControlName",ctrl:"TABS",prop:"ActivePageControlName"},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"AV10CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"AV11EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"A87MigrLegNumero",fld:"MIGRLEGNUMERO",pic:"ZZZZZZZ9"},{av:"AV12MigrLegNumero",fld:"vMIGRLEGNUMERO",pic:"ZZZZZZZ9",hsh:!0},{av:"AV13LoadAllTabs",fld:"vLOADALLTABS",pic:""},{av:"AV14SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""}],[{av:"AV14SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV13LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"},{ctrl:"MIGRLEGUPDWC"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("A3CliCod","CLICOD",0,"int",6,0);this.setVCMap("AV10CliCod","vCLICOD",0,"int",6,0);this.setVCMap("A1EmpCod","EMPCOD",0,"int",4,0);this.setVCMap("AV11EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("A87MigrLegNumero","MIGRLEGNUMERO",0,"int",8,0);this.setVCMap("AV12MigrLegNumero","vMIGRLEGNUMERO",0,"int",8,0);this.setVCMap("AV13LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV14SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.setVCMap("AV8TabCode","vTABCODE",0,"char",50,0);this.Initialize();this.setComponent({id:"GENERALWC",GXClass:null,Prefix:"W0023",lvl:1});this.setComponent({id:"MIGRLEGUPDWC",GXClass:null,Prefix:"W0031",lvl:1})});gx.wi(function(){gx.createParentObj(this.importacion_legajoview)})