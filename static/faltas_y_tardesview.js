gx.evt.autoSkip=!1;gx.define("faltas_y_tardesview",!1,function(){var n,t;this.ServerClass="faltas_y_tardesview";this.PackageName="web";this.ServerFullClass="web.faltas_y_tardesview";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV14LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV15SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE");this.AV10CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV11EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV12LegNumero=gx.fn.getIntegerValue("vLEGNUMERO",gx.thousandSeparator);this.AV13LegLicenIni=gx.fn.getDateValue("vLEGLICENINI");this.AV8TabCode=gx.fn.getControlValue("vTABCODE");this.AV10CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV11EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV12LegNumero=gx.fn.getIntegerValue("vLEGNUMERO",gx.thousandSeparator);this.AV13LegLicenIni=gx.fn.getDateValue("vLEGLICENINI");this.AV14LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV15SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE")};this.s112_client=function(){(this.AV14LoadAllTabs||gx.text.compare(this.AV15SelectedTabCode,"")==0||gx.text.compare(this.AV15SelectedTabCode,"General")==0)&&this.createWebComponent("Generalwc","faltas_y_tardesGeneral",[this.AV10CliCod,this.AV11EmpCod,this.AV12LegNumero,this.AV13LegLicenIni])};this.e13cv1_client=function(){return this.clearMessages(),this.AV15SelectedTabCode=this.TABSContainer.ActivePageControlName,this.AV14LoadAllTabs=!1,this.s112_client(),this.refreshOutputs([{av:"AV15SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV14LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14cv2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e15cv2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,20,21,22];this.GXLastCtrlId=22;this.TABSContainer=gx.uc.getNew(this,15,0,"gx.ui.controls.Tab","TABSContainer","Tabs","TABS");t=this.TABSContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("ActivePage","Activepage","","int");t.setDynProp("ActivePageControlName","Activepagecontrolname","","char");t.setProp("PageCount","Pagecount",1,"num");t.setProp("Class","Class","ViewTab Tab","str");t.setProp("HistoryManagement","Historymanagement",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("TabChanged",this.e13cv1_client);this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"UNNAMEDTABLEVIEWCONTAINER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"GENERAL_TITLE",format:0,grid:0,ctrltype:"textblock"};n[18]={id:18,fld:"",grid:0};n[20]={id:20,fld:"UNNAMEDTABLEGENERAL",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};this.AV10CliCod=0;this.AV11EmpCod=0;this.AV12LegNumero=0;this.AV13LegLicenIni=gx.date.nullDate();this.AV8TabCode="";this.A76LegLicenIni=gx.date.nullDate();this.A6LegNumero=0;this.A1EmpCod=0;this.A3CliCod=0;this.A481LegLicenFin=gx.date.nullDate();this.AV14LoadAllTabs=!1;this.AV15SelectedTabCode="";this.Events={e14cv2_client:["ENTER",!0],e15cv2_client:["CANCEL",!0],e13cv1_client:["TABS.TABCHANGED",!1]};this.EvtParms.REFRESH=[[{av:"AV10CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV11EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV12LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9",hsh:!0},{av:"AV13LegLicenIni",fld:"vLEGLICENINI",pic:"",hsh:!0},{av:"AV8TabCode",fld:"vTABCODE",pic:"",hsh:!0}],[]];this.EvtParms["TABS.TABCHANGED"]=[[{av:"this.TABSContainer.ActivePageControlName",ctrl:"TABS",prop:"ActivePageControlName"},{av:"AV14LoadAllTabs",fld:"vLOADALLTABS",pic:""},{av:"AV15SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV10CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV11EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV12LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9",hsh:!0},{av:"AV13LegLicenIni",fld:"vLEGLICENINI",pic:"",hsh:!0}],[{av:"AV15SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV14LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV14LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV15SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.setVCMap("AV10CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV11EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV12LegNumero","vLEGNUMERO",0,"int",8,0);this.setVCMap("AV13LegLicenIni","vLEGLICENINI",0,"date",8,0);this.setVCMap("AV8TabCode","vTABCODE",0,"char",50,0);this.setVCMap("AV10CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV11EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV12LegNumero","vLEGNUMERO",0,"int",8,0);this.setVCMap("AV13LegLicenIni","vLEGLICENINI",0,"date",8,0);this.setVCMap("AV14LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV15SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.Initialize();this.setComponent({id:"GENERALWC",GXClass:null,Prefix:"W0023",lvl:1})});gx.wi(function(){gx.createParentObj(this.faltas_y_tardesview)})