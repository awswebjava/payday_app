gx.evt.autoSkip=!1;gx.define("siniestradogeneral",!0,function(n){this.ServerClass="siniestradogeneral";this.PackageName="web";this.ServerFullClass="web.siniestradogeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Siniecodigo=function(){return this.validCliEvt("Valid_Siniecodigo",0,function(){try{var n=gx.util.balloon.getNew("SINIECODIGO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e115d1_client=function(){return this.clearMessages(),this.call("web.siniestrado",["UPD",this.A19SinieCodigo],null,["Mode","SinieCodigo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e125d1_client=function(){return this.clearMessages(),this.call("web.siniestrado",["DLT",this.A19SinieCodigo],null,["Mode","SinieCodigo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e165d2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e175d2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26];this.GXLastCtrlId=26;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Siniecodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINIECODIGO",fmt:0,gxz:"Z19SinieCodigo",gxold:"O19SinieCodigo",gxvar:"A19SinieCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A19SinieCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z19SinieCodigo=n)},v2c:function(){gx.fn.setControlValue("SINIECODIGO",gx.O.A19SinieCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.A19SinieCodigo=this.val())},val:function(){return gx.fn.getControlValue("SINIECODIGO")},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINIEDESCRI",fmt:0,gxz:"Z333SinieDescri",gxold:"O333SinieDescri",gxvar:"A333SinieDescri",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A333SinieDescri=n)},v2z:function(n){n!==undefined&&(gx.O.Z333SinieDescri=n)},v2c:function(){gx.fn.setControlValue("SINIEDESCRI",gx.O.A333SinieDescri,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A333SinieDescri=this.val())},val:function(){return gx.fn.getControlValue("SINIEDESCRI")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,fld:"BTNUPDATE",grid:0,evt:"e115d1_client"};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"BTNDELETE",grid:0,evt:"e125d1_client"};this.A19SinieCodigo="";this.Z19SinieCodigo="";this.O19SinieCodigo="";this.A333SinieDescri="";this.Z333SinieDescri="";this.O333SinieDescri="";this.A19SinieCodigo="";this.A333SinieDescri="";this.Events={e165d2_client:["ENTER",!0],e175d2_client:["CANCEL",!0],e115d1_client:["'DOUPDATE'",!1],e125d1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A19SinieCodigo",fld:"SINIECODIGO",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A19SinieCodigo",fld:"SINIECODIGO",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A19SinieCodigo",fld:"SINIECODIGO",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_SINIECODIGO=[[],[]];this.Initialize()})