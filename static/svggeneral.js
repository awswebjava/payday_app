gx.evt.autoSkip=!1;gx.define("svggeneral",!0,function(n){this.ServerClass="svggeneral";this.PackageName="web";this.ServerFullClass="web.svggeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Svgid=function(){return this.validCliEvt("Valid_Svgid",0,function(){try{var n=gx.util.balloon.getNew("SVGID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11lh1_client=function(){return this.clearMessages(),this.call("web.svg",["UPD",this.A1935SVGId],null,["Mode","SVGId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12lh1_client=function(){return this.clearMessages(),this.call("web.svg",["DLT",this.A1935SVGId],null,["Mode","SVGId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16lh2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17lh2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26];this.GXLastCtrlId=26;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Svgid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SVGID",fmt:0,gxz:"Z1935SVGId",gxold:"O1935SVGId",gxvar:"A1935SVGId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1935SVGId=n)},v2z:function(n){n!==undefined&&(gx.O.Z1935SVGId=n)},v2c:function(){gx.fn.setControlValue("SVGID",gx.O.A1935SVGId,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1935SVGId=this.val())},val:function(){return gx.fn.getControlValue("SVGID")},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"vchar",len:2097152,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SVGVALOR",fmt:0,gxz:"Z1936SVGValor",gxold:"O1936SVGValor",gxvar:"A1936SVGValor",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1936SVGValor=n)},v2z:function(n){n!==undefined&&(gx.O.Z1936SVGValor=n)},v2c:function(){gx.fn.setControlValue("SVGVALOR",gx.O.A1936SVGValor,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1936SVGValor=this.val())},val:function(){return gx.fn.getControlValue("SVGVALOR")},nac:gx.falseFn};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,fld:"BTNUPDATE",grid:0,evt:"e11lh1_client"};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"BTNDELETE",grid:0,evt:"e12lh1_client"};this.A1935SVGId="";this.Z1935SVGId="";this.O1935SVGId="";this.A1936SVGValor="";this.Z1936SVGValor="";this.O1936SVGValor="";this.A1935SVGId="";this.A1936SVGValor="";this.Events={e16lh2_client:["ENTER",!0],e17lh2_client:["CANCEL",!0],e11lh1_client:["'DOUPDATE'",!1],e12lh1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A1935SVGId",fld:"SVGID",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A1935SVGId",fld:"SVGID",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A1935SVGId",fld:"SVGID",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_SVGID=[[],[]];this.Initialize()})