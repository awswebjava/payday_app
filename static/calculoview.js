gx.evt.autoSkip=!1;gx.define("calculoview",!1,function(){var n,t;this.ServerClass="calculoview";this.PackageName="web";this.ServerFullClass="web.calculoview";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A46PaiCod=gx.fn.getIntegerValue("PAICOD",gx.thousandSeparator);this.AV10PaiCod=gx.fn.getIntegerValue("vPAICOD",gx.thousandSeparator);this.A74idOperando=gx.fn.getControlValue("IDOPERANDO");this.AV11idOperando=gx.fn.getControlValue("vIDOPERANDO");this.AV12LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV13SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE");this.AV23Opecodformula=gx.fn.getControlValue("vOPECODFORMULA");this.AV8TabCode=gx.fn.getControlValue("vTABCODE")};this.e119o2_client=function(){return this.executeServerEvent("TABS.TABCHANGED",!1,null,!0,!0)};this.e149o2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e159o2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,20,21,22,25,26,28,29,30,33,34,36,37,38];this.GXLastCtrlId=38;this.TABSContainer=gx.uc.getNew(this,15,0,"gx.ui.controls.Tab","TABSContainer","Tabs","TABS");t=this.TABSContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("ActivePage","Activepage","","int");t.setDynProp("ActivePageControlName","Activepagecontrolname","","char");t.setProp("PageCount","Pagecount",3,"num");t.setProp("Class","Class","ViewTab Tab","str");t.setProp("HistoryManagement","Historymanagement",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("TabChanged",this.e119o2_client);this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"UNNAMEDTABLEVIEWCONTAINER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"GENERAL_TITLE",format:0,grid:0,ctrltype:"textblock"};n[18]={id:18,fld:"",grid:0};n[20]={id:20,fld:"UNNAMEDTABLEGENERAL",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[25]={id:25,fld:"CALCULO_PARAMETROS_TITLE",format:0,grid:0,ctrltype:"textblock"};n[26]={id:26,fld:"",grid:0};n[28]={id:28,fld:"UNNAMEDTABLECALCULO_PARAMETROS",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[33]={id:33,fld:"OPERANDOSEUSAEN_TITLE",format:0,grid:0,ctrltype:"textblock"};n[34]={id:34,fld:"",grid:0};n[36]={id:36,fld:"UNNAMEDTABLEOPERANDOSEUSAEN",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};this.AV10PaiCod=0;this.AV11idOperando="";this.AV8TabCode="";this.A74idOperando="";this.A46PaiCod=0;this.A473OpeCodFormula="";this.AV12LoadAllTabs=!1;this.AV13SelectedTabCode="";this.AV23Opecodformula="";this.Events={e119o2_client:["TABS.TABCHANGED",!0],e149o2_client:["ENTER",!0],e159o2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"AV10PaiCod",fld:"vPAICOD",pic:"ZZZ9",hsh:!0},{av:"AV11idOperando",fld:"vIDOPERANDO",pic:"",hsh:!0},{av:"AV23Opecodformula",fld:"vOPECODFORMULA",pic:"",hsh:!0},{av:"AV8TabCode",fld:"vTABCODE",pic:"",hsh:!0}],[]];this.EvtParms["TABS.TABCHANGED"]=[[{av:"this.TABSContainer.ActivePageControlName",ctrl:"TABS",prop:"ActivePageControlName"},{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"AV10PaiCod",fld:"vPAICOD",pic:"ZZZ9",hsh:!0},{av:"A74idOperando",fld:"IDOPERANDO",pic:""},{av:"AV11idOperando",fld:"vIDOPERANDO",pic:"",hsh:!0},{av:"AV12LoadAllTabs",fld:"vLOADALLTABS",pic:""},{av:"AV13SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV23Opecodformula",fld:"vOPECODFORMULA",pic:"",hsh:!0}],[{av:"AV13SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV12LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"},{ctrl:"CALCULO_PARAMETROSWC"},{ctrl:"OPERANDOSEUSAENWC"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("A46PaiCod","PAICOD",0,"int",4,0);this.setVCMap("AV10PaiCod","vPAICOD",0,"int",4,0);this.setVCMap("A74idOperando","IDOPERANDO",0,"char",40,0);this.setVCMap("AV11idOperando","vIDOPERANDO",0,"char",40,0);this.setVCMap("AV12LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV13SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.setVCMap("AV23Opecodformula","vOPECODFORMULA",0,"char",40,0);this.setVCMap("AV8TabCode","vTABCODE",0,"char",50,0);this.Initialize();this.setComponent({id:"GENERALWC",GXClass:null,Prefix:"W0023",lvl:1});this.setComponent({id:"CALCULO_PARAMETROSWC",GXClass:null,Prefix:"W0031",lvl:1});this.setComponent({id:"OPERANDOSEUSAENWC",GXClass:null,Prefix:"W0039",lvl:1})});gx.wi(function(){gx.createParentObj(this.calculoview)})