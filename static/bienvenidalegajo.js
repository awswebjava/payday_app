gx.evt.autoSkip=!1;gx.define("bienvenidalegajo",!0,function(n){this.ServerClass="bienvenidalegajo";this.PackageName="web";this.ServerFullClass="web.bienvenidalegajo";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV16MenuOpcCod=gx.fn.getControlValue("vMENUOPCCOD");this.AV12CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV17modoPalabra=gx.fn.getControlValue("vMODOPALABRA")};this.e11ml1_client=function(){return this.clearMessages(),gx.fn.setCtrlProperty("WELCOMEMESSAGE_WELCOMETABLEPARENT","Visible",!1),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("WELCOMEMESSAGE_WELCOMETABLEPARENT","Visible")',ctrl:"WELCOMEMESSAGE_WELCOMETABLEPARENT",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14ml2_client=function(){return this.executeServerEvent("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",!0,null,!1,!0)};this.e16ml2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17ml2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,33,34,35,38,39,40,41,42,43,44,45,46,47,48,49];this.GXLastCtrlId=49;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"MAINTABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"TABLECONTENT",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,fld:"",grid:0};t[15]={id:15,fld:"WELCOMEMESSAGE_WELCOMETABLEPARENT",grid:0};t[16]={id:16,fld:"WELCOMEMESSAGE_WELCOMETABLEPRINCIPAL",grid:0};t[17]={id:17,fld:"WELCOMEMESSAGE_TABLECLOSE",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,fld:"WELCOMEMESSAGE_CLOSEHELP",format:1,grid:0,evt:"e11ml1_client",ctrltype:"textblock"};t[20]={id:20,fld:"WELCOMEMESSAGE_WELCOMECONTENTITEM",grid:0};t[21]={id:21,fld:"WELCOMEMESSAGE_WELCOMECONTENTFLEX",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"WELCOMEMESSAGE_WELCOMETABLEIMAGEN",grid:0};t[24]={id:24,fld:"",grid:0};t[25]={id:25,fld:"",grid:0};t[26]={id:26,lvl:0,type:"bits",len:1024,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWELCOMEMESSAGE_FOTO",fmt:0,gxz:"ZV15WelcomeMessage_Foto",gxold:"OV15WelcomeMessage_Foto",gxvar:"AV15WelcomeMessage_Foto",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV15WelcomeMessage_Foto=n)},v2z:function(n){n!==undefined&&(gx.O.ZV15WelcomeMessage_Foto=n)},v2c:function(){gx.fn.setMultimediaValue("vWELCOMEMESSAGE_FOTO",gx.O.AV15WelcomeMessage_Foto,gx.O.AV21Welcomemessage_foto_GXI)},c2v:function(){gx.O.AV21Welcomemessage_foto_GXI=this.val_GXI();this.val()!==undefined&&(gx.O.AV15WelcomeMessage_Foto=this.val())},val:function(){return gx.fn.getBlobValue("vWELCOMEMESSAGE_FOTO")},val_GXI:function(){return gx.fn.getControlValue("vWELCOMEMESSAGE_FOTO_GXI")},gxvar_GXI:"AV21Welcomemessage_foto_GXI",nac:gx.falseFn};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"WELCOMEMESSAGE_TABLETEXTO",grid:0};t[29]={id:29,fld:"",grid:0};t[30]={id:30,fld:"WELCOMEMESSAGE_TABLETITULO",grid:0};t[33]={id:33,fld:"WELCOMEMESSAGE_TITULO",format:0,grid:0,ctrltype:"textblock"};t[34]={id:34,fld:"",grid:0};t[35]={id:35,fld:"WELCOMEMESSAGE_TABLEDESCRIPCION",grid:0};t[38]={id:38,fld:"WELCOMEMESSAGE_DESCRIPCION",format:0,grid:0,ctrltype:"textblock"};t[39]={id:39,fld:"WELCOMEMESSAGE_WELCOMEBOTTOMITEM",grid:0};t[40]={id:40,fld:"WELCOMEMESSAGE_TABLECMB",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"WELCOMEMESSAGE_TABLEC",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"",grid:0};t[45]={id:45,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWELCOMEMESSAGE_NOMOSTRARMAS",fmt:0,gxz:"ZV14WelcomeMessage_NoMostrarMas",gxold:"OV14WelcomeMessage_NoMostrarMas",gxvar:"AV14WelcomeMessage_NoMostrarMas",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.AV14WelcomeMessage_NoMostrarMas=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV14WelcomeMessage_NoMostrarMas=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("vWELCOMEMESSAGE_NOMOSTRARMAS",gx.O.AV14WelcomeMessage_NoMostrarMas,!0)},c2v:function(){this.val()!==undefined&&(gx.O.AV14WelcomeMessage_NoMostrarMas=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("vWELCOMEMESSAGE_NOMOSTRARMAS")},nac:gx.falseFn,evt:"e14ml2_client",values:["true","false"]};t[46]={id:46,fld:"",grid:0};t[47]={id:47,fld:"WELCOMEMESSAGE_TABLETEXT",grid:0};t[48]={id:48,fld:"",grid:0};t[49]={id:49,fld:"WELCOMEMESSAGE_COMBOTEXT",format:0,grid:0,ctrltype:"textblock"};this.AV21Welcomemessage_foto_GXI="";this.AV15WelcomeMessage_Foto="";this.ZV15WelcomeMessage_Foto="";this.OV15WelcomeMessage_Foto="";this.AV14WelcomeMessage_NoMostrarMas=!1;this.ZV14WelcomeMessage_NoMostrarMas=!1;this.OV14WelcomeMessage_NoMostrarMas=!1;this.AV15WelcomeMessage_Foto="";this.AV14WelcomeMessage_NoMostrarMas=!1;this.AV17modoPalabra="";this.AV16MenuOpcCod="";this.AV12CliCod=0;this.Events={e14ml2_client:["VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",!0],e16ml2_client:["ENTER",!0],e17ml2_client:["CANCEL",!0],e11ml1_client:["WELCOMEMESSAGE_CLOSEHELP.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"AV14WelcomeMessage_NoMostrarMas",fld:"vWELCOMEMESSAGE_NOMOSTRARMAS",pic:""},{av:"AV16MenuOpcCod",fld:"vMENUOPCCOD",pic:"",hsh:!0},{av:"AV12CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}],[{av:"AV12CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}]];this.EvtParms["VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK"]=[[{av:"AV14WelcomeMessage_NoMostrarMas",fld:"vWELCOMEMESSAGE_NOMOSTRARMAS",pic:""},{av:"AV16MenuOpcCod",fld:"vMENUOPCCOD",pic:"",hsh:!0},{av:"AV12CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}],[{av:'gx.fn.getCtrlProperty("WELCOMEMESSAGE_COMBOTEXT","Caption")',ctrl:"WELCOMEMESSAGE_COMBOTEXT",prop:"Caption"}]];this.EvtParms["WELCOMEMESSAGE_CLOSEHELP.CLICK"]=[[],[{av:'gx.fn.getCtrlProperty("WELCOMEMESSAGE_WELCOMETABLEPARENT","Visible")',ctrl:"WELCOMEMESSAGE_WELCOMETABLEPARENT",prop:"Visible"}]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV16MenuOpcCod","vMENUOPCCOD",0,"svchar",100,0);this.setVCMap("AV12CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV17modoPalabra","vMODOPALABRA",0,"char",20,0);this.Initialize()})