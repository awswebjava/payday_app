gx.evt.autoSkip=!1;gx.define("parentescogeneral",!0,function(n){this.ServerClass="parentescogeneral";this.PackageName="web";this.ServerFullClass="web.parentescogeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Parcod=function(){return this.validCliEvt("Valid_Parcod",0,function(){try{var n=gx.util.balloon.getNew("PARCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11581_client=function(){return this.clearMessages(),this.call("web.parentesco",["UPD",this.A3CliCod,this.A30ParCod],null,["Mode","CliCod","ParCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12581_client=function(){return this.clearMessages(),this.call("web.parentesco",["DLT",this.A3CliCod,this.A30ParCod],null,["Mode","CliCod","ParCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16582_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17582_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30];this.GXLastCtrlId=30;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Parcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PARCOD",fmt:0,gxz:"Z30ParCod",gxold:"O30ParCod",gxvar:"A30ParCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A30ParCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z30ParCod=n)},v2c:function(){gx.fn.setControlValue("PARCOD",gx.O.A30ParCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A30ParCod=this.val())},val:function(){return gx.fn.getControlValue("PARCOD")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PARDESCRIP",fmt:0,gxz:"Z313ParDescrip",gxold:"O313ParDescrip",gxvar:"A313ParDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A313ParDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z313ParDescrip=n)},v2c:function(){gx.fn.setControlValue("PARDESCRIP",gx.O.A313ParDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A313ParDescrip=this.val())},val:function(){return gx.fn.getControlValue("PARDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,fld:"BTNUPDATE",grid:0,evt:"e11581_client"};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"BTNDELETE",grid:0,evt:"e12581_client"};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[30]={id:30,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};this.A30ParCod="";this.Z30ParCod="";this.O30ParCod="";this.A313ParDescrip="";this.Z313ParDescrip="";this.O313ParDescrip="";this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A30ParCod="";this.A313ParDescrip="";this.A3CliCod=0;this.Events={e16582_client:["ENTER",!0],e17582_client:["CANCEL",!0],e11581_client:["'DOUPDATE'",!1],e12581_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A30ParCod",fld:"PARCOD",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A30ParCod",fld:"PARCOD",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A30ParCod",fld:"PARCOD",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_PARCOD=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.Initialize()})