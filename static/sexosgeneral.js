gx.evt.autoSkip=!1;gx.define("sexosgeneral",!0,function(n){this.ServerClass="sexosgeneral";this.PackageName="web";this.ServerFullClass="web.sexosgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Sexoid=function(){return this.validCliEvt("Valid_Sexoid",0,function(){try{var n=gx.util.balloon.getNew("SEXOID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11i21_client=function(){return this.clearMessages(),this.call("web.sexos",["UPD",this.A1743SexoId],null,["Mode","SexoId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12i21_client=function(){return this.clearMessages(),this.call("web.sexos",["DLT",this.A1743SexoId],null,["Mode","SexoId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16i22_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17i22_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46];this.GXLastCtrlId=46;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Sexoid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOID",fmt:0,gxz:"Z1743SexoId",gxold:"O1743SexoId",gxvar:"A1743SexoId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1743SexoId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1743SexoId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("SEXOID",gx.O.A1743SexoId,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1743SexoId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SEXOID",gx.thousandSeparator)},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSEXOPAICOD_DESCRIPTION",fmt:0,gxz:"ZV12SexoPaiCod_Description",gxold:"OV12SexoPaiCod_Description",gxvar:"AV12SexoPaiCod_Description",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12SexoPaiCod_Description=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12SexoPaiCod_Description=n)},v2c:function(){gx.fn.setControlValue("vSEXOPAICOD_DESCRIPTION",gx.O.AV12SexoPaiCod_Description,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV12SexoPaiCod_Description=this.val())},val:function(){return gx.fn.getControlValue("vSEXOPAICOD_DESCRIPTION")},nac:gx.falseFn};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXONOMBRE",fmt:0,gxz:"Z1744SexoNombre",gxold:"O1744SexoNombre",gxvar:"A1744SexoNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1744SexoNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z1744SexoNombre=n)},v2c:function(){gx.fn.setControlValue("SEXONOMBRE",gx.O.A1744SexoNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1744SexoNombre=this.val())},val:function(){return gx.fn.getControlValue("SEXONOMBRE")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOBIOLOGICO",fmt:0,gxz:"Z1745SexoBiologico",gxold:"O1745SexoBiologico",gxvar:"A1745SexoBiologico",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A1745SexoBiologico=n)},v2z:function(n){n!==undefined&&(gx.O.Z1745SexoBiologico=n)},v2c:function(){gx.fn.setComboBoxValue("SEXOBIOLOGICO",gx.O.A1745SexoBiologico);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1745SexoBiologico=this.val())},val:function(){return gx.fn.getControlValue("SEXOBIOLOGICO")},nac:gx.falseFn};this.declareDomainHdlr(29,function(){});t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOIDENTIDAD",fmt:0,gxz:"Z1746SexoIdentidad",gxold:"O1746SexoIdentidad",gxvar:"A1746SexoIdentidad",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A1746SexoIdentidad=n)},v2z:function(n){n!==undefined&&(gx.O.Z1746SexoIdentidad=n)},v2c:function(){gx.fn.setComboBoxValue("SEXOIDENTIDAD",gx.O.A1746SexoIdentidad);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1746SexoIdentidad=this.val())},val:function(){return gx.fn.getControlValue("SEXOIDENTIDAD")},nac:gx.falseFn};this.declareDomainHdlr(34,function(){});t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOCODFOR",fmt:0,gxz:"Z2092SexoCodFor",gxold:"O2092SexoCodFor",gxvar:"A2092SexoCodFor",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2092SexoCodFor=n)},v2z:function(n){n!==undefined&&(gx.O.Z2092SexoCodFor=n)},v2c:function(){gx.fn.setControlValue("SEXOCODFOR",gx.O.A2092SexoCodFor,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2092SexoCodFor=this.val())},val:function(){return gx.fn.getControlValue("SEXOCODFOR")},nac:gx.falseFn};this.declareDomainHdlr(39,function(){});t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"BTNUPDATE",grid:0,evt:"e11i21_client"};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"BTNDELETE",grid:0,evt:"e12i21_client"};this.A1743SexoId=0;this.Z1743SexoId=0;this.O1743SexoId=0;this.AV12SexoPaiCod_Description="";this.ZV12SexoPaiCod_Description="";this.OV12SexoPaiCod_Description="";this.A1744SexoNombre="";this.Z1744SexoNombre="";this.O1744SexoNombre="";this.A1745SexoBiologico="";this.Z1745SexoBiologico="";this.O1745SexoBiologico="";this.A1746SexoIdentidad="";this.Z1746SexoIdentidad="";this.O1746SexoIdentidad="";this.A2092SexoCodFor="";this.Z2092SexoCodFor="";this.O2092SexoCodFor="";this.A1743SexoId=0;this.AV12SexoPaiCod_Description="";this.A1744SexoNombre="";this.A1745SexoBiologico="";this.A1746SexoIdentidad="";this.A2092SexoCodFor="";this.Events={e16i22_client:["ENTER",!0],e17i22_client:["CANCEL",!0],e11i21_client:["'DOUPDATE'",!1],e12i21_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A1743SexoId",fld:"SEXOID",pic:"Z9"}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A1743SexoId",fld:"SEXOID",pic:"Z9"}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A1743SexoId",fld:"SEXOID",pic:"Z9"}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_SEXOID=[[],[]];this.Initialize()})