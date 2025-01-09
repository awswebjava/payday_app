gx.evt.autoSkip=!1;gx.define("periodocardsgeneral",!0,function(n){this.ServerClass="periodocardsgeneral";this.PackageName="web";this.ServerFullClass="web.periodocardsgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV15MenuOpcCod=gx.fn.getControlValue("vMENUOPCCOD")};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Empcod=function(){return this.validCliEvt("Valid_Empcod",0,function(){try{var n=gx.util.balloon.getNew("EMPCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Periodoliq=function(){return this.validCliEvt("Valid_Periodoliq",0,function(){try{var n=gx.util.balloon.getNew("PERIODOLIQ");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11pa1_client=function(){return this.clearMessages(),this.call("web.periodocards",["UPD",this.A3CliCod,this.A1EmpCod,this.A1729PeriodoLiq],null,["Mode","CliCod","EmpCod","PeriodoLiq"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12pa1_client=function(){return this.clearMessages(),this.call("web.periodocards",["DLT",this.A3CliCod,this.A1EmpCod,this.A1729PeriodoLiq],null,["Mode","CliCod","EmpCod","PeriodoLiq"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16pa2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17pa2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46];this.GXLastCtrlId=46;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Empcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPCOD",fmt:0,gxz:"Z1EmpCod",gxold:"O1EmpCod",gxvar:"A1EmpCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1EmpCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1EmpCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPCOD",gx.O.A1EmpCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1EmpCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Periodoliq,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERIODOLIQ",fmt:0,gxz:"Z1729PeriodoLiq",gxold:"O1729PeriodoLiq",gxvar:"A1729PeriodoLiq",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1729PeriodoLiq=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1729PeriodoLiq=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("PERIODOLIQ",gx.O.A1729PeriodoLiq,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1729PeriodoLiq=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("PERIODOLIQ")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERIODOANIO",fmt:0,gxz:"Z1730PeriodoAnio",gxold:"O1730PeriodoAnio",gxvar:"A1730PeriodoAnio",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1730PeriodoAnio=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1730PeriodoAnio=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PERIODOANIO",gx.O.A1730PeriodoAnio,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1730PeriodoAnio=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PERIODOANIO",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERIODOMES",fmt:0,gxz:"Z1731PeriodoMes",gxold:"O1731PeriodoMes",gxvar:"A1731PeriodoMes",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A1731PeriodoMes=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1731PeriodoMes=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("PERIODOMES",gx.O.A1731PeriodoMes);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1731PeriodoMes=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PERIODOMES",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERIODODESCRIP",fmt:0,gxz:"Z1732PeriodoDescrip",gxold:"O1732PeriodoDescrip",gxvar:"A1732PeriodoDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1732PeriodoDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z1732PeriodoDescrip=n)},v2c:function(){gx.fn.setControlValue("PERIODODESCRIP",gx.O.A1732PeriodoDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1732PeriodoDescrip=this.val())},val:function(){return gx.fn.getControlValue("PERIODODESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(39,function(){});t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"BTNUPDATE",grid:0,evt:"e11pa1_client"};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"BTNDELETE",grid:0,evt:"e12pa1_client"};this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1EmpCod=0;this.Z1EmpCod=0;this.O1EmpCod=0;this.A1729PeriodoLiq=gx.date.nullDate();this.Z1729PeriodoLiq=gx.date.nullDate();this.O1729PeriodoLiq=gx.date.nullDate();this.A1730PeriodoAnio=0;this.Z1730PeriodoAnio=0;this.O1730PeriodoAnio=0;this.A1731PeriodoMes=0;this.Z1731PeriodoMes=0;this.O1731PeriodoMes=0;this.A1732PeriodoDescrip="";this.Z1732PeriodoDescrip="";this.O1732PeriodoDescrip="";this.A3CliCod=0;this.A1EmpCod=0;this.A1729PeriodoLiq=gx.date.nullDate();this.A1730PeriodoAnio=0;this.A1731PeriodoMes=0;this.A1732PeriodoDescrip="";this.AV15MenuOpcCod="";this.Events={e16pa2_client:["ENTER",!0],e17pa2_client:["CANCEL",!0],e11pa1_client:["'DOUPDATE'",!1],e12pa1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A1729PeriodoLiq",fld:"PERIODOLIQ",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A1729PeriodoLiq",fld:"PERIODOLIQ",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A1729PeriodoLiq",fld:"PERIODOLIQ",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.EvtParms.VALID_EMPCOD=[[],[]];this.EvtParms.VALID_PERIODOLIQ=[[],[]];this.setVCMap("AV15MenuOpcCod","vMENUOPCCOD",0,"svchar",100,0);this.Initialize()})