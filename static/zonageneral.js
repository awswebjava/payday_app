gx.evt.autoSkip=!1;gx.define("zonageneral",!0,function(n){this.ServerClass="zonageneral";this.PackageName="web";this.ServerFullClass="web.zonageneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Zoncod=function(){return this.validCliEvt("Valid_Zoncod",0,function(){try{var n=gx.util.balloon.getNew("ZONCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e115j1_client=function(){return this.clearMessages(),this.call("web.zona",["UPD",this.A20ZonCod],null,["Mode","ZonCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e125j1_client=function(){return this.clearMessages(),this.call("web.zona",["DLT",this.A20ZonCod],null,["Mode","ZonCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e165j2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e175j2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36];this.GXLastCtrlId=36;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Zoncod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ZONCOD",fmt:0,gxz:"Z20ZonCod",gxold:"O20ZonCod",gxvar:"A20ZonCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A20ZonCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z20ZonCod=n)},v2c:function(){gx.fn.setControlValue("ZONCOD",gx.O.A20ZonCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A20ZonCod=this.val())},val:function(){return gx.fn.getControlValue("ZONCOD")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ZONDESCRIP",fmt:0,gxz:"Z342ZonDescrip",gxold:"O342ZonDescrip",gxvar:"A342ZonDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A342ZonDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z342ZonDescrip=n)},v2c:function(){gx.fn.setControlValue("ZONDESCRIP",gx.O.A342ZonDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A342ZonDescrip=this.val())},val:function(){return gx.fn.getControlValue("ZONDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"decimal",len:6,dec:4,sign:!1,pic:"9.9999",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ZONPORCAUMENDED",fmt:0,gxz:"Z880ZonPorcAumenDed",gxold:"O880ZonPorcAumenDed",gxvar:"A880ZonPorcAumenDed",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A880ZonPorcAumenDed=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z880ZonPorcAumenDed=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("ZONPORCAUMENDED",gx.O.A880ZonPorcAumenDed,4,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A880ZonPorcAumenDed=this.val())},val:function(){return gx.fn.getDecimalValue("ZONPORCAUMENDED",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ZONPROVINCIA",fmt:0,gxz:"Z589ZonProvincia",gxold:"O589ZonProvincia",gxvar:"A589ZonProvincia",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A589ZonProvincia=n)},v2z:function(n){n!==undefined&&(gx.O.Z589ZonProvincia=n)},v2c:function(){gx.fn.setControlValue("ZONPROVINCIA",gx.O.A589ZonProvincia,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A589ZonProvincia=this.val())},val:function(){return gx.fn.getControlValue("ZONPROVINCIA")},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"BTNUPDATE",grid:0,evt:"e115j1_client"};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"BTNDELETE",grid:0,evt:"e125j1_client"};this.A20ZonCod="";this.Z20ZonCod="";this.O20ZonCod="";this.A342ZonDescrip="";this.Z342ZonDescrip="";this.O342ZonDescrip="";this.A880ZonPorcAumenDed=0;this.Z880ZonPorcAumenDed=0;this.O880ZonPorcAumenDed=0;this.A589ZonProvincia="";this.Z589ZonProvincia="";this.O589ZonProvincia="";this.A20ZonCod="";this.A342ZonDescrip="";this.A880ZonPorcAumenDed=0;this.A589ZonProvincia="";this.Events={e165j2_client:["ENTER",!0],e175j2_client:["CANCEL",!0],e115j1_client:["'DOUPDATE'",!1],e125j1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A20ZonCod",fld:"ZONCOD",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A20ZonCod",fld:"ZONCOD",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A20ZonCod",fld:"ZONCOD",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_ZONCOD=[[],[]];this.Initialize()})