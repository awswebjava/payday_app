gx.evt.autoSkip=!1;gx.define("activarusuario",!1,function(){this.ServerClass="activarusuario";this.PackageName="web";this.ServerFullClass="web.activarusuario";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV10SecUserName=gx.fn.getControlValue("vSECUSERNAME");this.AV9SecParAct=gx.fn.getControlValue("vSECPARACT");this.AV10SecUserName=gx.fn.getControlValue("vSECUSERNAME")};this.e11311_client=function(){return this.clearMessages(),this.call("web.login",[this.AV10SecUserName,""],null,["defaultSecUserName","URL"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e15312_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e16312_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15];this.GXLastCtrlId=15;n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLECONTENT",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"MENSAJE",format:0,grid:0,ctrltype:"textblock"};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"BTNGOTOLOGIN",grid:0,evt:"e11311_client"};this.AV9SecParAct="";this.AV10SecUserName="";this.Events={e15312_client:["ENTER",!0],e16312_client:["CANCEL",!0],e11311_client:["'DOGOTOLOGIN'",!1]};this.EvtParms.REFRESH=[[{av:"AV10SecUserName",fld:"vSECUSERNAME",pic:"",hsh:!0},{av:"AV9SecParAct",fld:"vSECPARACT",pic:"",hsh:!0}],[]];this.EvtParms["'DOGOTOLOGIN'"]=[[{av:"AV10SecUserName",fld:"vSECUSERNAME",pic:"",hsh:!0}],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV10SecUserName","vSECUSERNAME",0,"svchar",100,0);this.setVCMap("AV9SecParAct","vSECPARACT",0,"svchar",40,0);this.setVCMap("AV10SecUserName","vSECUSERNAME",0,"svchar",100,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.activarusuario)})