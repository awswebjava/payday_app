gx.evt.autoSkip=!1;gx.define("empresabancosgeneral",!0,function(n){this.ServerClass="empresabancosgeneral";this.PackageName="web";this.ServerFullClass="web.empresabancosgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV13CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.A1966EmpBanCod=gx.fn.getControlValue("EMPBANCOD");this.A1966EmpBanCod=gx.fn.getControlValue("EMPBANCOD")};this.Valid_Empcod=function(){return this.validCliEvt("Valid_Empcod",0,function(){try{var n=gx.util.balloon.getNew("EMPCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11o61_client=function(){return this.clearMessages(),this.call("web.empresabancos",["UPD",this.A3CliCod,this.A1EmpCod,this.A1966EmpBanCod],null,["Mode","CliCod","EmpCod","EmpBanCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12o61_client=function(){return this.clearMessages(),this.call("web.empresabancos",["DLT",this.A3CliCod,this.A1EmpCod,this.A1966EmpBanCod],null,["Mode","CliCod","EmpCod","EmpBanCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16o62_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17o62_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50];this.GXLastCtrlId=50;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Empcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPCOD",fmt:0,gxz:"Z1EmpCod",gxold:"O1EmpCod",gxvar:"A1EmpCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1EmpCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1EmpCod=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("EMPCOD",gx.O.A1EmpCod);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1EmpCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPBANDESCRIP",fmt:0,gxz:"Z1967EmpBanDescrip",gxold:"O1967EmpBanDescrip",gxvar:"A1967EmpBanDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1967EmpBanDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z1967EmpBanDescrip=n)},v2c:function(){gx.fn.setControlValue("EMPBANDESCRIP",gx.O.A1967EmpBanDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1967EmpBanDescrip=this.val())},val:function(){return gx.fn.getControlValue("EMPBANDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPBANTIPCUEN",fmt:0,gxz:"Z1970EmpBanTipCuen",gxold:"O1970EmpBanTipCuen",gxvar:"A1970EmpBanTipCuen",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A1970EmpBanTipCuen=n)},v2z:function(n){n!==undefined&&(gx.O.Z1970EmpBanTipCuen=n)},v2c:function(){gx.fn.setComboBoxValue("EMPBANTIPCUEN",gx.O.A1970EmpBanTipCuen);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1970EmpBanTipCuen=this.val())},val:function(){return gx.fn.getControlValue("EMPBANTIPCUEN")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPBANSUC",fmt:0,gxz:"Z1969EmpBanSuc",gxold:"O1969EmpBanSuc",gxvar:"A1969EmpBanSuc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1969EmpBanSuc=n)},v2z:function(n){n!==undefined&&(gx.O.Z1969EmpBanSuc=n)},v2c:function(){gx.fn.setControlValue("EMPBANSUC",gx.O.A1969EmpBanSuc,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1969EmpBanSuc=this.val())},val:function(){return gx.fn.getControlValue("EMPBANSUC")},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"svchar",len:22,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPBANCBU",fmt:0,gxz:"Z1968EmpBanCBU",gxold:"O1968EmpBanCBU",gxvar:"A1968EmpBanCBU",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1968EmpBanCBU=n)},v2z:function(n){n!==undefined&&(gx.O.Z1968EmpBanCBU=n)},v2c:function(){gx.fn.setControlValue("EMPBANCBU",gx.O.A1968EmpBanCBU,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1968EmpBanCBU=this.val())},val:function(){return gx.fn.getControlValue("EMPBANCBU")},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"svchar",len:20,dec:0,sign:!1,pic:"@!",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPCUENTABANC",fmt:0,gxz:"Z1971EmpCuentaBanc",gxold:"O1971EmpCuentaBanc",gxvar:"A1971EmpCuentaBanc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1971EmpCuentaBanc=n)},v2z:function(n){n!==undefined&&(gx.O.Z1971EmpCuentaBanc=n)},v2c:function(){gx.fn.setControlValue("EMPCUENTABANC",gx.O.A1971EmpCuentaBanc,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1971EmpCuentaBanc=this.val())},val:function(){return gx.fn.getControlValue("EMPCUENTABANC")},nac:gx.falseFn};this.declareDomainHdlr(39,function(){});t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"BTNUPDATE",grid:0,evt:"e11o61_client"};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"BTNDELETE",grid:0,evt:"e12o61_client"};t[47]={id:47,fld:"",grid:0};t[48]={id:48,fld:"",grid:0};t[49]={id:49,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[50]={id:50,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};this.A1EmpCod=0;this.Z1EmpCod=0;this.O1EmpCod=0;this.A1967EmpBanDescrip="";this.Z1967EmpBanDescrip="";this.O1967EmpBanDescrip="";this.A1970EmpBanTipCuen="";this.Z1970EmpBanTipCuen="";this.O1970EmpBanTipCuen="";this.A1969EmpBanSuc="";this.Z1969EmpBanSuc="";this.O1969EmpBanSuc="";this.A1968EmpBanCBU="";this.Z1968EmpBanCBU="";this.O1968EmpBanCBU="";this.A1971EmpCuentaBanc="";this.Z1971EmpCuentaBanc="";this.O1971EmpCuentaBanc="";this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1EmpCod=0;this.A1967EmpBanDescrip="";this.A1970EmpBanTipCuen="";this.A1969EmpBanSuc="";this.A1968EmpBanCBU="";this.A1971EmpCuentaBanc="";this.A3CliCod=0;this.A1966EmpBanCod="";this.Events={e16o62_client:["ENTER",!0],e17o62_client:["CANCEL",!0],e11o61_client:["'DOUPDATE'",!1],e12o61_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{ctrl:"EMPCOD"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A1966EmpBanCod",fld:"EMPBANCOD",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{ctrl:"EMPCOD"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A1966EmpBanCod",fld:"EMPBANCOD",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{ctrl:"EMPCOD"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A1966EmpBanCod",fld:"EMPBANCOD",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_EMPCOD=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.setVCMap("AV13CliCod","vCLICOD",0,"int",6,0);this.setVCMap("A1966EmpBanCod","EMPBANCOD",0,"char",6,0);this.setVCMap("A1966EmpBanCod","EMPBANCOD",0,"char",6,0);this.Initialize()})