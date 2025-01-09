gx.evt.autoSkip=!1;gx.define("artgeneral",!0,function(n){this.ServerClass="artgeneral";this.PackageName="web";this.ServerFullClass="web.artgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Artsec=function(){return this.validCliEvt("Valid_Artsec",0,function(){try{var n=gx.util.balloon.getNew("ARTSEC");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11c41_client=function(){return this.clearMessages(),this.call("web.art",["UPD",this.A1151ARTSec],null,["Mode","ARTSec"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12c41_client=function(){return this.clearMessages(),this.call("web.art",["DLT",this.A1151ARTSec],null,["Mode","ARTSec"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16c42_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17c42_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36];this.GXLastCtrlId=36;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Artsec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTSEC",fmt:0,gxz:"Z1151ARTSec",gxold:"O1151ARTSec",gxvar:"A1151ARTSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1151ARTSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1151ARTSec=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("ARTSEC",gx.O.A1151ARTSec,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1151ARTSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("ARTSEC",gx.thousandSeparator)},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTPAINOM",fmt:0,gxz:"Z1150ARTPaiNom",gxold:"O1150ARTPaiNom",gxvar:"A1150ARTPaiNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1150ARTPaiNom=n)},v2z:function(n){n!==undefined&&(gx.O.Z1150ARTPaiNom=n)},v2c:function(){gx.fn.setControlValue("ARTPAINOM",gx.O.A1150ARTPaiNom,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1150ARTPaiNom=this.val())},val:function(){return gx.fn.getControlValue("ARTPAINOM")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTNOM",fmt:0,gxz:"Z1152ARTNom",gxold:"O1152ARTNom",gxvar:"A1152ARTNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1152ARTNom=n)},v2z:function(n){n!==undefined&&(gx.O.Z1152ARTNom=n)},v2c:function(){gx.fn.setControlValue("ARTNOM",gx.O.A1152ARTNom,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1152ARTNom=this.val())},val:function(){return gx.fn.getControlValue("ARTNOM")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"decimal",len:6,dec:4,sign:!1,pic:"9.9999",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ARTALI",fmt:0,gxz:"Z1153ARTAli",gxold:"O1153ARTAli",gxvar:"A1153ARTAli",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1153ARTAli=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z1153ARTAli=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("ARTALI",gx.O.A1153ARTAli,4,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1153ARTAli=this.val())},val:function(){return gx.fn.getDecimalValue("ARTALI",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"BTNUPDATE",grid:0,evt:"e11c41_client"};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"BTNDELETE",grid:0,evt:"e12c41_client"};this.A1151ARTSec=0;this.Z1151ARTSec=0;this.O1151ARTSec=0;this.A1150ARTPaiNom="";this.Z1150ARTPaiNom="";this.O1150ARTPaiNom="";this.A1152ARTNom="";this.Z1152ARTNom="";this.O1152ARTNom="";this.A1153ARTAli=0;this.Z1153ARTAli=0;this.O1153ARTAli=0;this.A1151ARTSec=0;this.A1150ARTPaiNom="";this.A1152ARTNom="";this.A1153ARTAli=0;this.A1149ARTPaiCod=0;this.Events={e16c42_client:["ENTER",!0],e17c42_client:["CANCEL",!0],e11c41_client:["'DOUPDATE'",!1],e12c41_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A1151ARTSec",fld:"ARTSEC",pic:"ZZZ9"}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A1151ARTSec",fld:"ARTSEC",pic:"ZZZ9"}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A1151ARTSec",fld:"ARTSEC",pic:"ZZZ9"}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_ARTSEC=[[],[]];this.Initialize()})