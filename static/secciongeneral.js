gx.evt.autoSkip=!1;gx.define("secciongeneral",!0,function(n){this.ServerClass="secciongeneral";this.PackageName="web";this.ServerFullClass="web.secciongeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV11CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator)};this.Valid_Seccodigo=function(){return this.validCliEvt("Valid_Seccodigo",0,function(){try{var n=gx.util.balloon.getNew("SECCODIGO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e115a1_client=function(){return this.clearMessages(),this.call("web.seccion",["UPD",this.A3CliCod,this.A13SecCodigo],null,["Mode","CliCod","SecCodigo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e125a1_client=function(){return this.clearMessages(),this.call("web.seccion",["DLT",this.A3CliCod,this.A13SecCodigo],null,["Mode","CliCod","SecCodigo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e165a2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e175a2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40];this.GXLastCtrlId=40;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Seccodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECCODIGO",fmt:0,gxz:"Z13SecCodigo",gxold:"O13SecCodigo",gxvar:"A13SecCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A13SecCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z13SecCodigo=n)},v2c:function(){gx.fn.setControlValue("SECCODIGO",gx.O.A13SecCodigo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A13SecCodigo=this.val())},val:function(){return gx.fn.getControlValue("SECCODIGO")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECDESCRIP",fmt:0,gxz:"Z329SecDescrip",gxold:"O329SecDescrip",gxvar:"A329SecDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A329SecDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z329SecDescrip=n)},v2c:function(){gx.fn.setControlValue("SECDESCRIP",gx.O.A329SecDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A329SecDescrip=this.val())},val:function(){return gx.fn.getControlValue("SECDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECRELSEC",fmt:0,gxz:"Z1984SecRelSec",gxold:"O1984SecRelSec",gxvar:"A1984SecRelSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1984SecRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1984SecRelSec=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("SECRELSEC",gx.O.A1984SecRelSec)},c2v:function(){this.val()!==undefined&&(gx.O.A1984SecRelSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SECRELSEC",gx.thousandSeparator)},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECAPOOPC",fmt:0,gxz:"Z2308SecApoOpc",gxold:"O2308SecApoOpc",gxvar:"A2308SecApoOpc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A2308SecApoOpc=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z2308SecApoOpc=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("SECAPOOPC",gx.O.A2308SecApoOpc,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A2308SecApoOpc=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("SECAPOOPC")},nac:gx.falseFn,values:["true","false"]};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"BTNUPDATE",grid:0,evt:"e115a1_client"};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"BTNDELETE",grid:0,evt:"e125a1_client"};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[40]={id:40,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};this.A13SecCodigo="";this.Z13SecCodigo="";this.O13SecCodigo="";this.A329SecDescrip="";this.Z329SecDescrip="";this.O329SecDescrip="";this.A1984SecRelSec=0;this.Z1984SecRelSec=0;this.O1984SecRelSec=0;this.A2308SecApoOpc=!1;this.Z2308SecApoOpc=!1;this.O2308SecApoOpc=!1;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A13SecCodigo="";this.A329SecDescrip="";this.A1984SecRelSec=0;this.A2308SecApoOpc=!1;this.A3CliCod=0;this.Events={e165a2_client:["ENTER",!0],e175a2_client:["CANCEL",!0],e115a1_client:["'DOUPDATE'",!1],e125a1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A13SecCodigo",fld:"SECCODIGO",pic:""},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A13SecCodigo",fld:"SECCODIGO",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A13SecCodigo",fld:"SECCODIGO",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_SECCODIGO=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.setVCMap("AV11CliCod","vCLICOD",0,"int",6,0);this.Initialize()})