gx.evt.autoSkip=!1;gx.define("legajolicenciasgeneral",!0,function(n){this.ServerClass="legajolicenciasgeneral";this.PackageName="web";this.ServerFullClass="web.legajolicenciasgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Leglicenini=function(){return this.validCliEvt("Valid_Leglicenini",0,function(){try{var n=gx.util.balloon.getNew("LEGLICENINI");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Empcod=function(){return this.validCliEvt("Valid_Empcod",0,function(){try{var n=gx.util.balloon.getNew("EMPCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Legnumero=function(){return this.validCliEvt("Valid_Legnumero",0,function(){try{var n=gx.util.balloon.getNew("LEGNUMERO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e117c1_client=function(){return this.clearMessages(),this.call("web.legajolicencias",["UPD",this.A3CliCod,this.A1EmpCod,this.A6LegNumero,this.A76LegLicenIni],null,["Mode","CliCod","EmpCod","LegNumero","LegLicenIni"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e127c1_client=function(){return this.clearMessages(),this.call("web.legajolicencias",["DLT",this.A3CliCod,this.A1EmpCod,this.A6LegNumero,this.A76LegLicenIni],null,["Mode","CliCod","EmpCod","LegNumero","LegLicenIni"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e167c2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e177c2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42];this.GXLastCtrlId=42;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Leglicenini,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGLICENINI",fmt:0,gxz:"Z76LegLicenIni",gxold:"O76LegLicenIni",gxvar:"A76LegLicenIni",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A76LegLicenIni=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z76LegLicenIni=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("LEGLICENINI",gx.O.A76LegLicenIni,0)},c2v:function(){this.val()!==undefined&&(gx.O.A76LegLicenIni=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("LEGLICENINI")},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGLICENFIN",fmt:0,gxz:"Z481LegLicenFin",gxold:"O481LegLicenFin",gxvar:"A481LegLicenFin",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A481LegLicenFin=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z481LegLicenFin=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("LEGLICENFIN",gx.O.A481LegLicenFin,0)},c2v:function(){this.val()!==undefined&&(gx.O.A481LegLicenFin=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("LEGLICENFIN")},nac:gx.falseFn};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"char",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGLICSITCODIGO",fmt:0,gxz:"Z506LegLicSitCodigo",gxold:"O506LegLicSitCodigo",gxvar:"A506LegLicSitCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A506LegLicSitCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z506LegLicSitCodigo=n)},v2c:function(){gx.fn.setControlValue("LEGLICSITCODIGO",gx.O.A506LegLicSitCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.A506LegLicSitCodigo=this.val())},val:function(){return gx.fn.getControlValue("LEGLICSITCODIGO")},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGLICCONPLUS",fmt:0,gxz:"Z1218LegLicConPlus",gxold:"O1218LegLicConPlus",gxvar:"A1218LegLicConPlus",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1218LegLicConPlus=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1218LegLicConPlus=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("LEGLICCONPLUS",gx.O.A1218LegLicConPlus,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1218LegLicConPlus=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("LEGLICCONPLUS")},nac:gx.falseFn,values:["true","false"]};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"BTNUPDATE",grid:0,evt:"e117c1_client"};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"BTNDELETE",grid:0,evt:"e127c1_client"};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[40]={id:40,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};t[41]={id:41,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Empcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPCOD",fmt:0,gxz:"Z1EmpCod",gxold:"O1EmpCod",gxvar:"A1EmpCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1EmpCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1EmpCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPCOD",gx.O.A1EmpCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1EmpCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(41,function(){});t[42]={id:42,lvl:0,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Legnumero,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGNUMERO",fmt:0,gxz:"Z6LegNumero",gxold:"O6LegNumero",gxvar:"A6LegNumero",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A6LegNumero=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z6LegNumero=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("LEGNUMERO",gx.O.A6LegNumero,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A6LegNumero=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("LEGNUMERO",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(42,function(){});this.A76LegLicenIni=gx.date.nullDate();this.Z76LegLicenIni=gx.date.nullDate();this.O76LegLicenIni=gx.date.nullDate();this.A481LegLicenFin=gx.date.nullDate();this.Z481LegLicenFin=gx.date.nullDate();this.O481LegLicenFin=gx.date.nullDate();this.A506LegLicSitCodigo="";this.Z506LegLicSitCodigo="";this.O506LegLicSitCodigo="";this.A1218LegLicConPlus=!1;this.Z1218LegLicConPlus=!1;this.O1218LegLicConPlus=!1;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1EmpCod=0;this.Z1EmpCod=0;this.O1EmpCod=0;this.A6LegNumero=0;this.Z6LegNumero=0;this.O6LegNumero=0;this.A76LegLicenIni=gx.date.nullDate();this.A481LegLicenFin=gx.date.nullDate();this.A506LegLicSitCodigo="";this.A1218LegLicConPlus=!1;this.A3CliCod=0;this.A1EmpCod=0;this.A6LegNumero=0;this.Events={e167c2_client:["ENTER",!0],e177c2_client:["CANCEL",!0],e117c1_client:["'DOUPDATE'",!1],e127c1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"A76LegLicenIni",fld:"LEGLICENINI",pic:""},{av:"A1218LegLicConPlus",fld:"LEGLICCONPLUS",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"A76LegLicenIni",fld:"LEGLICENINI",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"A76LegLicenIni",fld:"LEGLICENINI",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_LEGLICENINI=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.EvtParms.VALID_EMPCOD=[[],[]];this.EvtParms.VALID_LEGNUMERO=[[],[]];this.Initialize()})