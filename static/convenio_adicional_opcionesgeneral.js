gx.evt.autoSkip=!1;gx.define("convenio_adicional_opcionesgeneral",!0,function(n){this.ServerClass="convenio_adicional_opcionesgeneral";this.PackageName="web";this.ServerFullClass="web.convenio_adicional_opcionesgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV13CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV18Clipaiconve=gx.fn.getIntegerValue("vCLIPAICONVE",gx.thousandSeparator);this.AV19Cliconvenio=gx.fn.getControlValue("vCLICONVENIO")};this.Valid_Conveadicod=function(){return this.validCliEvt("Valid_Conveadicod",0,function(){try{var n=gx.util.balloon.getNew("CONVEADICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Conveadiopccod=function(){return this.validCliEvt("Valid_Conveadiopccod",0,function(){try{var n=gx.util.balloon.getNew("CONVEADIOPCCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clipaiconve=function(){return this.validCliEvt("Valid_Clipaiconve",0,function(){try{var n=gx.util.balloon.getNew("CLIPAICONVE");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Cliconvenio=function(){return this.validCliEvt("Valid_Cliconvenio",0,function(){try{var n=gx.util.balloon.getNew("CLICONVENIO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11eu1_client=function(){return this.clearMessages(),this.call("web.convenio_adicional_opciones",["UPD",this.A3CliCod,this.A1564CliPaiConve,this.A1565CliConvenio,this.A996ConveAdicod,this.A1011ConveAdiOpcCod],null,["Mode","CliCod","CliPaiConve","CliConvenio","ConveAdicod","ConveAdiOpcCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12eu1_client=function(){return this.clearMessages(),this.call("web.convenio_adicional_opciones",["DLT",this.A3CliCod,this.A1564CliPaiConve,this.A1565CliConvenio,this.A996ConveAdicod,this.A1011ConveAdiOpcCod],null,["Mode","CliCod","CliPaiConve","CliConvenio","ConveAdicod","ConveAdiOpcCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16eu2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17eu2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52];this.GXLastCtrlId=52;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Conveadicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADICOD",fmt:0,gxz:"Z996ConveAdicod",gxold:"O996ConveAdicod",gxvar:"A996ConveAdicod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A996ConveAdicod=n)},v2z:function(n){n!==undefined&&(gx.O.Z996ConveAdicod=n)},v2c:function(){gx.fn.setComboBoxValue("CONVEADICOD",gx.O.A996ConveAdicod)},c2v:function(){this.val()!==undefined&&(gx.O.A996ConveAdicod=this.val())},val:function(){return gx.fn.getControlValue("CONVEADICOD")},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Conveadiopccod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADIOPCCOD",fmt:0,gxz:"Z1011ConveAdiOpcCod",gxold:"O1011ConveAdiOpcCod",gxvar:"A1011ConveAdiOpcCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1011ConveAdiOpcCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1011ConveAdiOpcCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CONVEADIOPCCOD",gx.O.A1011ConveAdiOpcCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1011ConveAdiOpcCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CONVEADIOPCCOD",gx.thousandSeparator)},nac:gx.falseFn};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADIOPCFOR",fmt:0,gxz:"Z1021ConveAdiOpcFor",gxold:"O1021ConveAdiOpcFor",gxvar:"A1021ConveAdiOpcFor",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1021ConveAdiOpcFor=n)},v2z:function(n){n!==undefined&&(gx.O.Z1021ConveAdiOpcFor=n)},v2c:function(){gx.fn.setControlValue("CONVEADIOPCFOR",gx.O.A1021ConveAdiOpcFor,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1021ConveAdiOpcFor=this.val())},val:function(){return gx.fn.getControlValue("CONVEADIOPCFOR")},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADIOPCDES",fmt:0,gxz:"Z1012ConveAdiOpcDes",gxold:"O1012ConveAdiOpcDes",gxvar:"A1012ConveAdiOpcDes",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1012ConveAdiOpcDes=n)},v2z:function(n){n!==undefined&&(gx.O.Z1012ConveAdiOpcDes=n)},v2c:function(){gx.fn.setControlValue("CONVEADIOPCDES",gx.O.A1012ConveAdiOpcDes,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1012ConveAdiOpcDes=this.val())},val:function(){return gx.fn.getControlValue("CONVEADIOPCDES")},nac:gx.falseFn};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"decimal",len:6,dec:4,sign:!1,pic:"9.9999",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADIOPCALI",fmt:0,gxz:"Z1013ConveAdiOpcAli",gxold:"O1013ConveAdiOpcAli",gxvar:"A1013ConveAdiOpcAli",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1013ConveAdiOpcAli=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z1013ConveAdiOpcAli=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("CONVEADIOPCALI",gx.O.A1013ConveAdiOpcAli,4,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1013ConveAdiOpcAli=this.val())},val:function(){return gx.fn.getDecimalValue("CONVEADIOPCALI",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADIOPCRELSEC",fmt:0,gxz:"Z1900ConveAdiOpcRelSec",gxold:"O1900ConveAdiOpcRelSec",gxvar:"A1900ConveAdiOpcRelSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1900ConveAdiOpcRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1900ConveAdiOpcRelSec=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("CONVEADIOPCRELSEC",gx.O.A1900ConveAdiOpcRelSec)},c2v:function(){this.val()!==undefined&&(gx.O.A1900ConveAdiOpcRelSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CONVEADIOPCRELSEC",gx.thousandSeparator)},nac:gx.falseFn};t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"BTNUPDATE",grid:0,evt:"e11eu1_client"};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"BTNDELETE",grid:0,evt:"e12eu1_client"};t[47]={id:47,fld:"",grid:0};t[48]={id:48,fld:"",grid:0};t[49]={id:49,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[50]={id:50,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};t[51]={id:51,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clipaiconve,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIPAICONVE",fmt:0,gxz:"Z1564CliPaiConve",gxold:"O1564CliPaiConve",gxvar:"A1564CliPaiConve",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1564CliPaiConve=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1564CliPaiConve=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLIPAICONVE",gx.O.A1564CliPaiConve,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1564CliPaiConve=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLIPAICONVE",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(51,function(){});t[52]={id:52,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Cliconvenio,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICONVENIO",fmt:0,gxz:"Z1565CliConvenio",gxold:"O1565CliConvenio",gxvar:"A1565CliConvenio",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1565CliConvenio=n)},v2z:function(n){n!==undefined&&(gx.O.Z1565CliConvenio=n)},v2c:function(){gx.fn.setControlValue("CLICONVENIO",gx.O.A1565CliConvenio,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1565CliConvenio=this.val())},val:function(){return gx.fn.getControlValue("CLICONVENIO")},nac:gx.falseFn};this.A996ConveAdicod="";this.Z996ConveAdicod="";this.O996ConveAdicod="";this.A1011ConveAdiOpcCod=0;this.Z1011ConveAdiOpcCod=0;this.O1011ConveAdiOpcCod=0;this.A1021ConveAdiOpcFor="";this.Z1021ConveAdiOpcFor="";this.O1021ConveAdiOpcFor="";this.A1012ConveAdiOpcDes="";this.Z1012ConveAdiOpcDes="";this.O1012ConveAdiOpcDes="";this.A1013ConveAdiOpcAli=0;this.Z1013ConveAdiOpcAli=0;this.O1013ConveAdiOpcAli=0;this.A1900ConveAdiOpcRelSec=0;this.Z1900ConveAdiOpcRelSec=0;this.O1900ConveAdiOpcRelSec=0;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1564CliPaiConve=0;this.Z1564CliPaiConve=0;this.O1564CliPaiConve=0;this.A1565CliConvenio="";this.Z1565CliConvenio="";this.O1565CliConvenio="";this.A996ConveAdicod="";this.A1011ConveAdiOpcCod=0;this.A1021ConveAdiOpcFor="";this.A1012ConveAdiOpcDes="";this.A1013ConveAdiOpcAli=0;this.A1900ConveAdiOpcRelSec=0;this.A3CliCod=0;this.A1564CliPaiConve=0;this.A1565CliConvenio="";this.Events={e16eu2_client:["ENTER",!0],e17eu2_client:["CANCEL",!0],e11eu1_client:["'DOUPDATE'",!1],e12eu1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1564CliPaiConve",fld:"CLIPAICONVE",pic:"ZZZ9"},{av:"A1565CliConvenio",fld:"CLICONVENIO",pic:""},{ctrl:"CONVEADICOD"},{av:"A996ConveAdicod",fld:"CONVEADICOD",pic:""},{av:"A1011ConveAdiOpcCod",fld:"CONVEADIOPCCOD",pic:"ZZZ9"}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1564CliPaiConve",fld:"CLIPAICONVE",pic:"ZZZ9"},{av:"A1565CliConvenio",fld:"CLICONVENIO",pic:""},{ctrl:"CONVEADICOD"},{av:"A996ConveAdicod",fld:"CONVEADICOD",pic:""},{av:"A1011ConveAdiOpcCod",fld:"CONVEADIOPCCOD",pic:"ZZZ9"}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1564CliPaiConve",fld:"CLIPAICONVE",pic:"ZZZ9"},{av:"A1565CliConvenio",fld:"CLICONVENIO",pic:""},{ctrl:"CONVEADICOD"},{av:"A996ConveAdicod",fld:"CONVEADICOD",pic:""},{av:"A1011ConveAdiOpcCod",fld:"CONVEADIOPCCOD",pic:"ZZZ9"}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_CONVEADICOD=[[],[]];this.EvtParms.VALID_CONVEADIOPCCOD=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.EvtParms.VALID_CLIPAICONVE=[[],[]];this.EvtParms.VALID_CLICONVENIO=[[],[]];this.setVCMap("AV13CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV18Clipaiconve","vCLIPAICONVE",0,"int",4,0);this.setVCMap("AV19Cliconvenio","vCLICONVENIO",0,"char",20,0);this.Initialize()})