gx.evt.autoSkip=!1;gx.define("legajo_permanenciageneral",!0,function(n){this.ServerClass="legajo_permanenciageneral";this.PackageName="web";this.ServerFullClass="web.legajo_permanenciageneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV13CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator)};this.Valid_Legnumero=function(){return this.validCliEvt("Valid_Legnumero",0,function(){try{var n=gx.util.balloon.getNew("LEGNUMERO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Leghisfecing=function(){return this.validCliEvt("Valid_Leghisfecing",0,function(){try{var n=gx.util.balloon.getNew("LEGHISFECING");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Empcod=function(){return this.validCliEvt("Valid_Empcod",0,function(){try{var n=gx.util.balloon.getNew("EMPCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11p01_client=function(){return this.clearMessages(),this.call("web.legajo_permanencia",["UPD",this.A3CliCod,this.A1EmpCod,this.A6LegNumero,this.A2253LegHisFecIng],null,["Mode","CliCod","EmpCod","LegNumero","LegHisFecIng"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12p01_client=function(){return this.clearMessages(),this.call("web.legajo_permanencia",["DLT",this.A3CliCod,this.A1EmpCod,this.A6LegNumero,this.A2253LegHisFecIng],null,["Mode","CliCod","EmpCod","LegNumero","LegHisFecIng"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16p02_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17p02_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52];this.GXLastCtrlId=52;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Legnumero,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGNUMERO",fmt:0,gxz:"Z6LegNumero",gxold:"O6LegNumero",gxvar:"A6LegNumero",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A6LegNumero=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z6LegNumero=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("LEGNUMERO",gx.O.A6LegNumero,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A6LegNumero=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("LEGNUMERO",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"date",len:10,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Leghisfecing,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISFECING",fmt:0,gxz:"Z2253LegHisFecIng",gxold:"O2253LegHisFecIng",gxvar:"A2253LegHisFecIng",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/9999",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2253LegHisFecIng=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z2253LegHisFecIng=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("LEGHISFECING",gx.O.A2253LegHisFecIng,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2253LegHisFecIng=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("LEGHISFECING")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"date",len:10,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISFECEGR",fmt:0,gxz:"Z2254LegHisFecEgr",gxold:"O2254LegHisFecEgr",gxvar:"A2254LegHisFecEgr",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/9999",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2254LegHisFecEgr=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z2254LegHisFecEgr=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("LEGHISFECEGR",gx.O.A2254LegHisFecEgr,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2254LegHisFecEgr=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("LEGHISFECEGR")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISMOTCOD",fmt:0,gxz:"Z2330LegHisMotCod",gxold:"O2330LegHisMotCod",gxvar:"A2330LegHisMotCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A2330LegHisMotCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z2330LegHisMotCod=n)},v2c:function(){gx.fn.setComboBoxValue("LEGHISMOTCOD",gx.O.A2330LegHisMotCod);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2330LegHisMotCod=this.val())},val:function(){return gx.fn.getControlValue("LEGHISMOTCOD")},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISAFECANT",fmt:0,gxz:"Z2258LegHisAfecAnt",gxold:"O2258LegHisAfecAnt",gxvar:"A2258LegHisAfecAnt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A2258LegHisAfecAnt=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z2258LegHisAfecAnt=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("LEGHISAFECANT",gx.O.A2258LegHisAfecAnt,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A2258LegHisAfecAnt=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("LEGHISAFECANT")},nac:gx.falseFn,values:["true","false"]};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"BTNUPDATE",grid:0,evt:"e11p01_client"};t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"BTNDELETE",grid:0,evt:"e12p01_client"};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[45]={id:45,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};t[46]={id:46,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Empcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPCOD",fmt:0,gxz:"Z1EmpCod",gxold:"O1EmpCod",gxvar:"A1EmpCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1EmpCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1EmpCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPCOD",gx.O.A1EmpCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1EmpCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(46,function(){});t[47]={id:47,lvl:0,type:"date",len:10,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISFECTEL",fmt:0,gxz:"Z2255LegHisFecTel",gxold:"O2255LegHisFecTel",gxvar:"A2255LegHisFecTel",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/9999",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2255LegHisFecTel=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z2255LegHisFecTel=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("LEGHISFECTEL",gx.O.A2255LegHisFecTel,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2255LegHisFecTel=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("LEGHISFECTEL")},nac:gx.falseFn};this.declareDomainHdlr(47,function(){});t[48]={id:48,lvl:0,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISLIQNRO",fmt:0,gxz:"Z2252LegHisLiqNro",gxold:"O2252LegHisLiqNro",gxvar:"A2252LegHisLiqNro",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2252LegHisLiqNro=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z2252LegHisLiqNro=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("LEGHISLIQNRO",gx.O.A2252LegHisLiqNro,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2252LegHisLiqNro=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("LEGHISLIQNRO",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(48,function(){});t[49]={id:49,lvl:0,type:"int",len:5,dec:0,sign:!1,pic:"ZZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISDIASANT",fmt:0,gxz:"Z2257LegHisDiasAnt",gxold:"O2257LegHisDiasAnt",gxvar:"A2257LegHisDiasAnt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2257LegHisDiasAnt=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z2257LegHisDiasAnt=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("LEGHISDIASANT",gx.O.A2257LegHisDiasAnt,0)},c2v:function(){this.val()!==undefined&&(gx.O.A2257LegHisDiasAnt=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("LEGHISDIASANT",gx.thousandSeparator)},nac:gx.falseFn};t[50]={id:50,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISMESESANT",fmt:0,gxz:"Z2317LegHisMesesAnt",gxold:"O2317LegHisMesesAnt",gxvar:"A2317LegHisMesesAnt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2317LegHisMesesAnt=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z2317LegHisMesesAnt=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("LEGHISMESESANT",gx.O.A2317LegHisMesesAnt,0)},c2v:function(){this.val()!==undefined&&(gx.O.A2317LegHisMesesAnt=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("LEGHISMESESANT",gx.thousandSeparator)},nac:gx.falseFn};t[51]={id:51,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISANIOSANT",fmt:0,gxz:"Z2318LegHisAniosAnt",gxold:"O2318LegHisAniosAnt",gxvar:"A2318LegHisAniosAnt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2318LegHisAniosAnt=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z2318LegHisAniosAnt=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("LEGHISANIOSANT",gx.O.A2318LegHisAniosAnt,0)},c2v:function(){this.val()!==undefined&&(gx.O.A2318LegHisAniosAnt=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("LEGHISANIOSANT",gx.thousandSeparator)},nac:gx.falseFn};t[52]={id:52,lvl:0,type:"vchar",len:2097152,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGHISANTTEXTO",fmt:0,gxz:"Z2319LegHisAntTexto",gxold:"O2319LegHisAntTexto",gxvar:"A2319LegHisAntTexto",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2319LegHisAntTexto=n)},v2z:function(n){n!==undefined&&(gx.O.Z2319LegHisAntTexto=n)},v2c:function(){gx.fn.setControlValue("LEGHISANTTEXTO",gx.O.A2319LegHisAntTexto,0)},c2v:function(){this.val()!==undefined&&(gx.O.A2319LegHisAntTexto=this.val())},val:function(){return gx.fn.getControlValue("LEGHISANTTEXTO")},nac:gx.falseFn};this.A6LegNumero=0;this.Z6LegNumero=0;this.O6LegNumero=0;this.A2253LegHisFecIng=gx.date.nullDate();this.Z2253LegHisFecIng=gx.date.nullDate();this.O2253LegHisFecIng=gx.date.nullDate();this.A2254LegHisFecEgr=gx.date.nullDate();this.Z2254LegHisFecEgr=gx.date.nullDate();this.O2254LegHisFecEgr=gx.date.nullDate();this.A2330LegHisMotCod="";this.Z2330LegHisMotCod="";this.O2330LegHisMotCod="";this.A2258LegHisAfecAnt=!1;this.Z2258LegHisAfecAnt=!1;this.O2258LegHisAfecAnt=!1;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1EmpCod=0;this.Z1EmpCod=0;this.O1EmpCod=0;this.A2255LegHisFecTel=gx.date.nullDate();this.Z2255LegHisFecTel=gx.date.nullDate();this.O2255LegHisFecTel=gx.date.nullDate();this.A2252LegHisLiqNro=0;this.Z2252LegHisLiqNro=0;this.O2252LegHisLiqNro=0;this.A2257LegHisDiasAnt=0;this.Z2257LegHisDiasAnt=0;this.O2257LegHisDiasAnt=0;this.A2317LegHisMesesAnt=0;this.Z2317LegHisMesesAnt=0;this.O2317LegHisMesesAnt=0;this.A2318LegHisAniosAnt=0;this.Z2318LegHisAniosAnt=0;this.O2318LegHisAniosAnt=0;this.A2319LegHisAntTexto="";this.Z2319LegHisAntTexto="";this.O2319LegHisAntTexto="";this.A6LegNumero=0;this.A2253LegHisFecIng=gx.date.nullDate();this.A2254LegHisFecEgr=gx.date.nullDate();this.A2330LegHisMotCod="";this.A2258LegHisAfecAnt=!1;this.A3CliCod=0;this.A1EmpCod=0;this.A2255LegHisFecTel=gx.date.nullDate();this.A2252LegHisLiqNro=0;this.A2257LegHisDiasAnt=0;this.A2317LegHisMesesAnt=0;this.A2318LegHisAniosAnt=0;this.A2319LegHisAntTexto="";this.Events={e16p02_client:["ENTER",!0],e17p02_client:["CANCEL",!0],e11p01_client:["'DOUPDATE'",!1],e12p01_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"A2253LegHisFecIng",fld:"LEGHISFECING",pic:""},{av:"A2258LegHisAfecAnt",fld:"LEGHISAFECANT",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"A2253LegHisFecIng",fld:"LEGHISFECING",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"A2253LegHisFecIng",fld:"LEGHISFECING",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_LEGNUMERO=[[],[]];this.EvtParms.VALID_LEGHISFECING=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.EvtParms.VALID_EMPCOD=[[],[]];this.setVCMap("AV13CliCod","vCLICOD",0,"int",6,0);this.Initialize()})