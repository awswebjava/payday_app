gx.evt.autoSkip=!1;gx.define("paramgeneral",!0,function(n){this.ServerClass="paramgeneral";this.PackageName="web";this.ServerFullClass="web.paramgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV13CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator)};this.Valid_Parmcod=function(){return this.validCliEvt("Valid_Parmcod",0,function(){try{var n=gx.util.balloon.getNew("PARMCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e118x1_client=function(){return this.clearMessages(),this.call("web.param",["UPD",this.A3CliCod,this.A61ParmCod],null,["Mode","CliCod","ParmCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e128x1_client=function(){return this.clearMessages(),this.call("web.param",["DLT",this.A3CliCod,this.A61ParmCod],null,["Mode","CliCod","ParmCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e168x2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e178x2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40];this.GXLastCtrlId=40;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:30,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Parmcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PARMCOD",fmt:0,gxz:"Z61ParmCod",gxold:"O61ParmCod",gxvar:"A61ParmCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A61ParmCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z61ParmCod=n)},v2c:function(){gx.fn.setControlValue("PARMCOD",gx.O.A61ParmCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A61ParmCod=this.val())},val:function(){return gx.fn.getControlValue("PARMCOD")},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PARMDESCRI",fmt:0,gxz:"Z315ParmDescri",gxold:"O315ParmDescri",gxvar:"A315ParmDescri",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A315ParmDescri=n)},v2z:function(n){n!==undefined&&(gx.O.Z315ParmDescri=n)},v2c:function(){gx.fn.setControlValue("PARMDESCRI",gx.O.A315ParmDescri,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A315ParmDescri=this.val())},val:function(){return gx.fn.getControlValue("PARMDESCRI")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"vchar",len:2097152,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PARMVALUE",fmt:0,gxz:"Z316ParmValue",gxold:"O316ParmValue",gxvar:"A316ParmValue",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A316ParmValue=n)},v2z:function(n){n!==undefined&&(gx.O.Z316ParmValue=n)},v2c:function(){gx.fn.setControlValue("PARMVALUE",gx.O.A316ParmValue,0)},c2v:function(){this.val()!==undefined&&(gx.O.A316ParmValue=this.val())},val:function(){return gx.fn.getControlValue("PARMVALUE")},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PARMRELSEC",fmt:0,gxz:"Z1996ParmRelSec",gxold:"O1996ParmRelSec",gxvar:"A1996ParmRelSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1996ParmRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1996ParmRelSec=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("PARMRELSEC",gx.O.A1996ParmRelSec)},c2v:function(){this.val()!==undefined&&(gx.O.A1996ParmRelSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PARMRELSEC",gx.thousandSeparator)},nac:gx.falseFn};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"BTNUPDATE",grid:0,evt:"e118x1_client"};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"BTNDELETE",grid:0,evt:"e128x1_client"};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[40]={id:40,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};this.A61ParmCod="";this.Z61ParmCod="";this.O61ParmCod="";this.A315ParmDescri="";this.Z315ParmDescri="";this.O315ParmDescri="";this.A316ParmValue="";this.Z316ParmValue="";this.O316ParmValue="";this.A1996ParmRelSec=0;this.Z1996ParmRelSec=0;this.O1996ParmRelSec=0;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A61ParmCod="";this.A315ParmDescri="";this.A316ParmValue="";this.A1996ParmRelSec=0;this.A3CliCod=0;this.Events={e168x2_client:["ENTER",!0],e178x2_client:["CANCEL",!0],e118x1_client:["'DOUPDATE'",!1],e128x1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A61ParmCod",fld:"PARMCOD",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A61ParmCod",fld:"PARMCOD",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A61ParmCod",fld:"PARMCOD",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_PARMCOD=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.setVCMap("AV13CliCod","vCLICOD",0,"int",6,0);this.Initialize()})