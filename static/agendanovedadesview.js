gx.evt.autoSkip=!1;gx.define("agendanovedadesview",!1,function(){var n,t;this.ServerClass="agendanovedadesview";this.PackageName="web";this.ServerFullClass="web.agendanovedadesview";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A3CliCod=gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator);this.AV14CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.A1EmpCod=gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator);this.AV9EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.A6LegNumero=gx.fn.getIntegerValue("LEGNUMERO",gx.thousandSeparator);this.AV10LegNumero=gx.fn.getIntegerValue("vLEGNUMERO",gx.thousandSeparator);this.A25AgeOrden=gx.fn.getIntegerValue("AGEORDEN",gx.thousandSeparator);this.AV11AgeOrden=gx.fn.getIntegerValue("vAGEORDEN",gx.thousandSeparator);this.AV12LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV13SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE");this.AV7TabCode=gx.fn.getControlValue("vTABCODE")};this.e110p2_client=function(){return this.executeServerEvent("TABS.TABCHANGED",!1,null,!0,!0)};this.e140p2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e150p2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,20,21,22,25,26,28,29,30];this.GXLastCtrlId=30;this.TABSContainer=gx.uc.getNew(this,15,0,"gx.ui.controls.Tab","TABSContainer","Tabs","TABS");t=this.TABSContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("ActivePage","Activepage","","int");t.setDynProp("ActivePageControlName","Activepagecontrolname","","char");t.setProp("PageCount","Pagecount",2,"num");t.setProp("Class","Class","ViewTab Tab","str");t.setProp("HistoryManagement","Historymanagement",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("TabChanged",this.e110p2_client);this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"UNNAMEDTABLEVIEWCONTAINER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"GENERAL_TITLE",format:0,grid:0,ctrltype:"textblock"};n[18]={id:18,fld:"",grid:0};n[20]={id:20,fld:"UNNAMEDTABLEGENERAL",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[25]={id:25,fld:"NOVEDADES_TITLE",format:0,grid:0,ctrltype:"textblock"};n[26]={id:26,fld:"",grid:0};n[28]={id:28,fld:"UNNAMEDTABLENOVEDADES",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};this.AV14CliCod=0;this.AV9EmpCod=0;this.AV10LegNumero=0;this.AV11AgeOrden=0;this.AV7TabCode="";this.A25AgeOrden=0;this.A6LegNumero=0;this.A1EmpCod=0;this.A3CliCod=0;this.A110AgeCanti=0;this.AV12LoadAllTabs=!1;this.AV13SelectedTabCode="";this.Events={e110p2_client:["TABS.TABCHANGED",!0],e140p2_client:["ENTER",!0],e150p2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"AV14CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV10LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9",hsh:!0},{av:"AV11AgeOrden",fld:"vAGEORDEN",pic:"ZZZ9",hsh:!0},{av:"AV7TabCode",fld:"vTABCODE",pic:"",hsh:!0}],[]];this.EvtParms["TABS.TABCHANGED"]=[[{av:"this.TABSContainer.ActivePageControlName",ctrl:"TABS",prop:"ActivePageControlName"},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"AV14CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"AV10LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9",hsh:!0},{av:"A25AgeOrden",fld:"AGEORDEN",pic:"ZZZ9"},{av:"AV11AgeOrden",fld:"vAGEORDEN",pic:"ZZZ9",hsh:!0},{av:"AV12LoadAllTabs",fld:"vLOADALLTABS",pic:""},{av:"AV13SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""}],[{av:"AV13SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV12LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"},{ctrl:"NOVEDADESWC"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("A3CliCod","CLICOD",0,"int",6,0);this.setVCMap("AV14CliCod","vCLICOD",0,"int",6,0);this.setVCMap("A1EmpCod","EMPCOD",0,"int",4,0);this.setVCMap("AV9EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("A6LegNumero","LEGNUMERO",0,"int",8,0);this.setVCMap("AV10LegNumero","vLEGNUMERO",0,"int",8,0);this.setVCMap("A25AgeOrden","AGEORDEN",0,"int",4,0);this.setVCMap("AV11AgeOrden","vAGEORDEN",0,"int",4,0);this.setVCMap("AV12LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV13SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.setVCMap("AV7TabCode","vTABCODE",0,"char",50,0);this.Initialize();this.setComponent({id:"GENERALWC",GXClass:null,Prefix:"W0023",lvl:1});this.setComponent({id:"NOVEDADESWC",GXClass:null,Prefix:"W0031",lvl:1})});gx.wi(function(){gx.createParentObj(this.agendanovedadesview)})