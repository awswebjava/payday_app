gx.evt.autoSkip=!1;gx.define("webpanel5",!1,function(){this.ServerClass="webpanel5";this.PackageName="web";this.ServerFullClass="web.webpanel5";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.e11pb1_client=function(){return this.clearMessages(),this.addMessage(gx.getMessage("hola")),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e15pb2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e16pb2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15];this.GXLastCtrlId=15;n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"MAINTABLE",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"BTNUSERACTION1",grid:0,evt:"e11pb1_client"};this.Events={e15pb2_client:["ENTER",!0],e16pb2_client:["CANCEL",!0],e11pb1_client:["'DOUSERACTION1'",!1]};this.EvtParms.REFRESH=[[],[]];this.EvtParms["'DOUSERACTION1'"]=[[],[]];this.EvtParms.ENTER=[[],[]];this.Initialize()});gx.wi(function(){gx.createParentObj(this.webpanel5)})