gx.evt.autoSkip=!1;gx.define("liqimportarauxtrnview",!1,function(){this.ServerClass="liqimportarauxtrnview";this.PackageName="web";this.ServerFullClass="web.liqimportarauxtrnview";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV10CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV11EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV8TabCode=gx.fn.getControlValue("vTABCODE")};this.s112_client=function(){};this.e131s2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e141s2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8];this.GXLastCtrlId=8;n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};this.AV10CliCod=0;this.AV11EmpCod=0;this.AV8TabCode="";this.A1EmpCod=0;this.A3CliCod=0;this.A2EmpNom="";this.Events={e131s2_client:["ENTER",!0],e141s2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"AV10CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV11EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV10CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV11EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV8TabCode","vTABCODE",0,"char",50,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.liqimportarauxtrnview)})