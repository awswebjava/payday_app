gx.evt.autoSkip=!1;gx.define("categoriaview",!1,function(){var n,t;this.ServerClass="categoriaview";this.PackageName="web";this.ServerFullClass="web.categoriaview";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV11LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV12SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE");this.AV16CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV19CliPaiConve=gx.fn.getIntegerValue("vCLIPAICONVE",gx.thousandSeparator);this.AV20CliConvenio=gx.fn.getControlValue("vCLICONVENIO");this.AV10CatCodigo=gx.fn.getControlValue("vCATCODIGO");this.AV7TabCode=gx.fn.getControlValue("vTABCODE");this.AV16CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV19CliPaiConve=gx.fn.getIntegerValue("vCLIPAICONVE",gx.thousandSeparator);this.AV20CliConvenio=gx.fn.getControlValue("vCLICONVENIO");this.AV10CatCodigo=gx.fn.getControlValue("vCATCODIGO");this.AV11LoadAllTabs=gx.fn.getControlValue("vLOADALLTABS");this.AV12SelectedTabCode=gx.fn.getControlValue("vSELECTEDTABCODE")};this.s112_client=function(){(this.AV11LoadAllTabs||gx.text.compare(this.AV12SelectedTabCode,"")==0||gx.text.compare(this.AV12SelectedTabCode,"General")==0)&&this.createWebComponent("Generalwc","CategoriaGeneral",[this.AV16CliCod,this.AV19CliPaiConve,this.AV20CliConvenio,this.AV10CatCodigo])};this.e130s1_client=function(){return this.clearMessages(),this.AV12SelectedTabCode=this.TABSContainer.ActivePageControlName,this.AV11LoadAllTabs=!1,this.s112_client(),this.refreshOutputs([{av:"AV12SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV11LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e140s2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e150s2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,20,21,22];this.GXLastCtrlId=22;this.TABSContainer=gx.uc.getNew(this,15,0,"gx.ui.controls.Tab","TABSContainer","Tabs","TABS");t=this.TABSContainer;t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("ActivePage","Activepage","","int");t.setDynProp("ActivePageControlName","Activepagecontrolname","","char");t.setProp("PageCount","Pagecount",1,"num");t.setProp("Class","Class","ViewTab Tab","str");t.setProp("HistoryManagement","Historymanagement",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("TabChanged",this.e130s1_client);this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"UNNAMEDTABLEVIEWCONTAINER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"GENERAL_TITLE",format:0,grid:0,ctrltype:"textblock"};n[18]={id:18,fld:"",grid:0};n[20]={id:20,fld:"UNNAMEDTABLEGENERAL",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};this.AV16CliCod=0;this.AV19CliPaiConve=0;this.AV20CliConvenio="";this.AV10CatCodigo="";this.AV7TabCode="";this.A8CatCodigo="";this.A1565CliConvenio="";this.A1564CliPaiConve=0;this.A3CliCod=0;this.A123CatDescrip="";this.AV11LoadAllTabs=!1;this.AV12SelectedTabCode="";this.Events={e140s2_client:["ENTER",!0],e150s2_client:["CANCEL",!0],e130s1_client:["TABS.TABCHANGED",!1]};this.EvtParms.REFRESH=[[{av:"AV16CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV19CliPaiConve",fld:"vCLIPAICONVE",pic:"ZZZ9",hsh:!0},{av:"AV20CliConvenio",fld:"vCLICONVENIO",pic:"",hsh:!0},{av:"AV10CatCodigo",fld:"vCATCODIGO",pic:"",hsh:!0},{av:"AV7TabCode",fld:"vTABCODE",pic:"",hsh:!0}],[]];this.EvtParms["TABS.TABCHANGED"]=[[{av:"this.TABSContainer.ActivePageControlName",ctrl:"TABS",prop:"ActivePageControlName"},{av:"AV11LoadAllTabs",fld:"vLOADALLTABS",pic:""},{av:"AV12SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV16CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV19CliPaiConve",fld:"vCLIPAICONVE",pic:"ZZZ9",hsh:!0},{av:"AV20CliConvenio",fld:"vCLICONVENIO",pic:"",hsh:!0},{av:"AV10CatCodigo",fld:"vCATCODIGO",pic:"",hsh:!0}],[{av:"AV12SelectedTabCode",fld:"vSELECTEDTABCODE",pic:""},{av:"AV11LoadAllTabs",fld:"vLOADALLTABS",pic:""},{ctrl:"GENERALWC"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV11LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV12SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.setVCMap("AV16CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV19CliPaiConve","vCLIPAICONVE",0,"int",4,0);this.setVCMap("AV20CliConvenio","vCLICONVENIO",0,"char",20,0);this.setVCMap("AV10CatCodigo","vCATCODIGO",0,"char",40,0);this.setVCMap("AV7TabCode","vTABCODE",0,"char",50,0);this.setVCMap("AV16CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV19CliPaiConve","vCLIPAICONVE",0,"int",4,0);this.setVCMap("AV20CliConvenio","vCLICONVENIO",0,"char",20,0);this.setVCMap("AV10CatCodigo","vCATCODIGO",0,"char",40,0);this.setVCMap("AV11LoadAllTabs","vLOADALLTABS",0,"boolean",4,0);this.setVCMap("AV12SelectedTabCode","vSELECTEDTABCODE",0,"char",50,0);this.Initialize();this.setComponent({id:"GENERALWC",GXClass:null,Prefix:"W0023",lvl:1})});gx.wi(function(){gx.createParentObj(this.categoriaview)})