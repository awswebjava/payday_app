gx.evt.autoSkip=!1;gx.define("motivoegresorevistaafipgeneral",!0,function(n){this.ServerClass="motivoegresorevistaafipgeneral";this.PackageName="web";this.ServerFullClass="web.motivoegresorevistaafipgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A3CliCod=gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator);this.A11MegCodigo=gx.fn.getControlValue("MEGCODIGO");this.A1601MegSitRevista=gx.fn.getIntegerValue("MEGSITREVISTA",gx.thousandSeparator);this.A1601MegSitRevista=gx.fn.getIntegerValue("MEGSITREVISTA",gx.thousandSeparator);this.A11MegCodigo=gx.fn.getControlValue("MEGCODIGO");this.A3CliCod=gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)};this.e11hy1_client=function(){return this.clearMessages(),this.call("web.motivoegresorevistaafip",["UPD",this.A3CliCod,this.A11MegCodigo,this.A1601MegSitRevista],null,["Mode","CliCod","MegCodigo","MegSitRevista"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12hy1_client=function(){return this.clearMessages(),this.call("web.motivoegresorevistaafip",["DLT",this.A3CliCod,this.A11MegCodigo,this.A1601MegSitRevista],null,["Mode","CliCod","MegCodigo","MegSitRevista"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16hy2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17hy2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36];this.GXLastCtrlId=36;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"svchar",len:40,dec:0,sign:!1,pic:"@!",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLINOM",fmt:0,gxz:"Z344CliNom",gxold:"O344CliNom",gxvar:"A344CliNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A344CliNom=n)},v2z:function(n){n!==undefined&&(gx.O.Z344CliNom=n)},v2c:function(){gx.fn.setControlValue("CLINOM",gx.O.A344CliNom,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A344CliNom=this.val())},val:function(){return gx.fn.getControlValue("CLINOM")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MEGDESCRIP",fmt:0,gxz:"Z300MegDescrip",gxold:"O300MegDescrip",gxvar:"A300MegDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A300MegDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z300MegDescrip=n)},v2c:function(){gx.fn.setControlValue("MEGDESCRIP",gx.O.A300MegDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A300MegDescrip=this.val())},val:function(){return gx.fn.getControlValue("MEGDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vMEGSITREVISTA_DESCRIPTION",fmt:0,gxz:"ZV12MegSitRevista_Description",gxold:"OV12MegSitRevista_Description",gxvar:"AV12MegSitRevista_Description",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12MegSitRevista_Description=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12MegSitRevista_Description=n)},v2c:function(){gx.fn.setControlValue("vMEGSITREVISTA_DESCRIPTION",gx.O.AV12MegSitRevista_Description,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV12MegSitRevista_Description=this.val())},val:function(){return gx.fn.getControlValue("vMEGSITREVISTA_DESCRIPTION")},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MEGSITREVDEF",fmt:0,gxz:"Z1606MegSitRevDef",gxold:"O1606MegSitRevDef",gxvar:"A1606MegSitRevDef",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1606MegSitRevDef=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1606MegSitRevDef=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("MEGSITREVDEF",gx.O.A1606MegSitRevDef,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1606MegSitRevDef=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("MEGSITREVDEF")},nac:gx.falseFn,values:["true","false"]};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"BTNUPDATE",grid:0,evt:"e11hy1_client"};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"BTNDELETE",grid:0,evt:"e12hy1_client"};this.A344CliNom="";this.Z344CliNom="";this.O344CliNom="";this.A300MegDescrip="";this.Z300MegDescrip="";this.O300MegDescrip="";this.AV12MegSitRevista_Description="";this.ZV12MegSitRevista_Description="";this.OV12MegSitRevista_Description="";this.A1606MegSitRevDef=!1;this.Z1606MegSitRevDef=!1;this.O1606MegSitRevDef=!1;this.A344CliNom="";this.A300MegDescrip="";this.AV12MegSitRevista_Description="";this.A1606MegSitRevDef=!1;this.A3CliCod=0;this.A11MegCodigo="";this.A1601MegSitRevista=0;this.Events={e16hy2_client:["ENTER",!0],e17hy2_client:["CANCEL",!0],e11hy1_client:["'DOUPDATE'",!1],e12hy1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A11MegCodigo",fld:"MEGCODIGO",pic:""},{av:"A1601MegSitRevista",fld:"MEGSITREVISTA",pic:"ZZ9"},{av:"A1606MegSitRevDef",fld:"MEGSITREVDEF",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A11MegCodigo",fld:"MEGCODIGO",pic:""},{av:"A1601MegSitRevista",fld:"MEGSITREVISTA",pic:"ZZ9"}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A11MegCodigo",fld:"MEGCODIGO",pic:""},{av:"A1601MegSitRevista",fld:"MEGSITREVISTA",pic:"ZZ9"}],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("A3CliCod","CLICOD",0,"int",6,0);this.setVCMap("A11MegCodigo","MEGCODIGO",0,"char",20,0);this.setVCMap("A1601MegSitRevista","MEGSITREVISTA",0,"int",3,0);this.setVCMap("A1601MegSitRevista","MEGSITREVISTA",0,"int",3,0);this.setVCMap("A11MegCodigo","MEGCODIGO",0,"char",20,0);this.setVCMap("A3CliCod","CLICOD",0,"int",6,0);this.Initialize()})