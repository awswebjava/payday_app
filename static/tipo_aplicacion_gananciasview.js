gx.evt.autoSkip=!1;gx.define("tipo_aplicacion_gananciasview",!1,function(){var n,t;this.ServerClass="tipo_aplicacion_gananciasview";this.PackageName="web";this.ServerFullClass="web.tipo_aplicacion_gananciasview";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV12LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV13SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE");this.AV10CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV11AplIIGG=gx.fn.getIntegerValue("vAPLIIGG",gx.thousandSeparator);this.AV8TabCode=gx.fn.getControlValue("vTABCODE");this.AV10CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV11AplIIGG=gx.fn.getIntegerValue("vAPLIIGG",gx.thousandSeparator);this.AV12LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV13SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE")};this.s112_client=function(){(this.AV12LoadAllTabs||gx.text.compare(this.AV13SelectedTabCode,"")==0||gx.text.compare(this.AV13SelectedTabCode,"General")==0)&&this.createWebComponent("Generalwc","tipo_aplicacion_gananciasGeneral",[this.AV10CliCod,this.AV11AplIIGG])};this.e13br1_client=function(){return this.clearMessages(),this.AV13SelectedTabCode=this.TABSContainer.ActivePageControlName,this.AV12LoadAllTabs=!1,this.s112_client(),this.refreshOutputs([{av:"AV13SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV12LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14br2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e15br2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,20,21,22];this.GXLastCtrlId=22;this.TABSContainer=gx.uc.getNew(this,15,0,"gx.ui.controls.Tab","TABSContainer","Tabs","TABS");t=this.TABSContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("ActivePage","Activepage","","int");t.setDynProp("ActivePageControlName","Activepagecontrolname","","char");t.setProp("PageCount","Pagecount",1,"num");t.setProp("Class","Class","ViewTab Tab","str");t.setProp("HistoryManagement","Historymanagement",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("TabChanged",this.e13br1_client);this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"UNNAMEDTABLEVIEWCONTAINER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"GENERAL_TITLE",format:0,grid:0,ctrltype:"textblock"};n[18]={id:18,fld:"",grid:0};n[20]={id:20,fld:"UNNAMEDTABLEGENERAL",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};this.AV10CliCod=0;this.AV11AplIIGG=0;this.AV8TabCode="";this.A1112AplIIGG=0;this.A3CliCod=0;this.A1113AplIIGGNom="";this.AV12LoadAllTabs=!1;this.AV13SelectedTabCode="";this.Events={e14br2_client:["ENTER",!0],e15br2_client:["CANCEL",!0],e13br1_client:["TABS.TABCHANGED",!1]};this.EvtParms.REFRESH=[[{av:"AV10CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV11AplIIGG",fld:"vAPLIIGG",pic:"ZZZ9",hsh:!0},{av:"AV8TabCode",fld:"vTABCODE",pic:"",hsh:!0}],[]];this.EvtParms["TABS.TABCHANGED"]=[[{av:"this.TABSContainer.ActivePageControlName",ctrl:"TABS",prop:"ActivePageControlName"},{av:"AV12LoadAllTabs",fld:"vLOADALLTABS",pic:""},{av:"AV13SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV10CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV11AplIIGG",fld:"vAPLIIGG",pic:"ZZZ9",hsh:!0}],[{av:"AV13SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV12LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV12LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV13SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.setVCMap("AV10CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV11AplIIGG","vAPLIIGG",0,"int",4,0);this.setVCMap("AV8TabCode","vTABCODE",0,"char",50,0);this.setVCMap("AV10CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV11AplIIGG","vAPLIIGG",0,"int",4,0);this.setVCMap("AV12LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV13SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.Initialize();this.setComponent({id:"GENERALWC",GXClass:null,Prefix:"W0023",lvl:1})});gx.wi(function(){gx.createParentObj(this.tipo_aplicacion_gananciasview)})