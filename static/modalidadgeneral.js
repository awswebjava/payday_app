gx.evt.autoSkip=!1;gx.define("modalidadgeneral",!0,function(n){this.ServerClass="modalidadgeneral";this.PackageName="web";this.ServerFullClass="web.modalidadgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Mprcod=function(){return this.validCliEvt("Valid_Mprcod",0,function(){try{var n=gx.util.balloon.getNew("MPRCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11b61_client=function(){return this.clearMessages(),this.call("web.modalidadafip",["UPD",this.A18MprCod],null,["Mode","MprCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12b61_client=function(){return this.clearMessages(),this.call("web.modalidadafip",["DLT",this.A18MprCod],null,["Mode","MprCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16b62_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17b62_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46];this.GXLastCtrlId=46;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Mprcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MPRCOD",fmt:0,gxz:"Z18MprCod",gxold:"O18MprCod",gxvar:"A18MprCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A18MprCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z18MprCod=n)},v2c:function(){gx.fn.setControlValue("MPRCOD",gx.O.A18MprCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A18MprCod=this.val())},val:function(){return gx.fn.getControlValue("MPRCOD")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MPRDESCRIP",fmt:0,gxz:"Z303MprDescrip",gxold:"O303MprDescrip",gxvar:"A303MprDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A303MprDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z303MprDescrip=n)},v2c:function(){gx.fn.setControlValue("MPRDESCRIP",gx.O.A303MprDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A303MprDescrip=this.val())},val:function(){return gx.fn.getControlValue("MPRDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MPRHABILITADA",fmt:0,gxz:"Z304MprHabilitada",gxold:"O304MprHabilitada",gxvar:"A304MprHabilitada",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A304MprHabilitada=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z304MprHabilitada=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("MPRHABILITADA",gx.O.A304MprHabilitada,!0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A304MprHabilitada=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("MPRHABILITADA")},nac:gx.falseFn,values:["true","false"]};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MPRESPARCIAL",fmt:0,gxz:"Z1024MprEsParcial",gxold:"O1024MprEsParcial",gxvar:"A1024MprEsParcial",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1024MprEsParcial=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1024MprEsParcial=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("MPRESPARCIAL",gx.O.A1024MprEsParcial,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1024MprEsParcial=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("MPRESPARCIAL")},nac:gx.falseFn,values:["true","false"]};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MPRNODETRAE",fmt:0,gxz:"Z1071MprNoDetrae",gxold:"O1071MprNoDetrae",gxvar:"A1071MprNoDetrae",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1071MprNoDetrae=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1071MprNoDetrae=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("MPRNODETRAE",gx.O.A1071MprNoDetrae,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1071MprNoDetrae=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("MPRNODETRAE")},nac:gx.falseFn,values:["true","false"]};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MPRHORASEXTRAS",fmt:0,gxz:"Z1353MprHorasExtras",gxold:"O1353MprHorasExtras",gxvar:"A1353MprHorasExtras",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1353MprHorasExtras=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1353MprHorasExtras=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("MPRHORASEXTRAS",gx.O.A1353MprHorasExtras,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1353MprHorasExtras=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("MPRHORASEXTRAS")},nac:gx.falseFn,values:["true","false"]};t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"BTNUPDATE",grid:0,evt:"e11b61_client"};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"BTNDELETE",grid:0,evt:"e12b61_client"};this.A18MprCod="";this.Z18MprCod="";this.O18MprCod="";this.A303MprDescrip="";this.Z303MprDescrip="";this.O303MprDescrip="";this.A304MprHabilitada=!1;this.Z304MprHabilitada=!1;this.O304MprHabilitada=!1;this.A1024MprEsParcial=!1;this.Z1024MprEsParcial=!1;this.O1024MprEsParcial=!1;this.A1071MprNoDetrae=!1;this.Z1071MprNoDetrae=!1;this.O1071MprNoDetrae=!1;this.A1353MprHorasExtras=!1;this.Z1353MprHorasExtras=!1;this.O1353MprHorasExtras=!1;this.A18MprCod="";this.A303MprDescrip="";this.A304MprHabilitada=!1;this.A1024MprEsParcial=!1;this.A1071MprNoDetrae=!1;this.A1353MprHorasExtras=!1;this.Events={e16b62_client:["ENTER",!0],e17b62_client:["CANCEL",!0],e11b61_client:["'DOUPDATE'",!1],e12b61_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A18MprCod",fld:"MPRCOD",pic:""},{av:"A304MprHabilitada",fld:"MPRHABILITADA",pic:""},{av:"A1024MprEsParcial",fld:"MPRESPARCIAL",pic:""},{av:"A1071MprNoDetrae",fld:"MPRNODETRAE",pic:""},{av:"A1353MprHorasExtras",fld:"MPRHORASEXTRAS",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A18MprCod",fld:"MPRCOD",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A18MprCod",fld:"MPRCOD",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_MPRCOD=[[],[]];this.Initialize()})