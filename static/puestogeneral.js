gx.evt.autoSkip=!1;gx.define("puestogeneral",!0,function(n){this.ServerClass="puestogeneral";this.PackageName="web";this.ServerFullClass="web.puestogeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A13SecCodigo=gx.fn.getControlValue("SECCODIGO");this.A13SecCodigo=gx.fn.getControlValue("SECCODIGO")};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11cp1_client=function(){return this.clearMessages(),this.call("web.puesto",["UPD",this.A3CliCod,this.A13SecCodigo,this.A1240PuestoCodigo],null,["Mode","CliCod","SecCodigo","PuestoCodigo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12cp1_client=function(){return this.clearMessages(),this.call("web.puesto",["DLT",this.A3CliCod,this.A13SecCodigo,this.A1240PuestoCodigo],null,["Mode","CliCod","SecCodigo","PuestoCodigo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16cp2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17cp2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40];this.GXLastCtrlId=40;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECDESCRIP",fmt:0,gxz:"Z329SecDescrip",gxold:"O329SecDescrip",gxvar:"A329SecDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A329SecDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z329SecDescrip=n)},v2c:function(){gx.fn.setControlValue("SECDESCRIP",gx.O.A329SecDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A329SecDescrip=this.val())},val:function(){return gx.fn.getControlValue("SECDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PUESTOCODIGO",fmt:0,gxz:"Z1240PuestoCodigo",gxold:"O1240PuestoCodigo",gxvar:"A1240PuestoCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1240PuestoCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z1240PuestoCodigo=n)},v2c:function(){gx.fn.setControlValue("PUESTOCODIGO",gx.O.A1240PuestoCodigo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1240PuestoCodigo=this.val())},val:function(){return gx.fn.getControlValue("PUESTOCODIGO")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PUESTODESCRIP",fmt:0,gxz:"Z1241PuestoDescrip",gxold:"O1241PuestoDescrip",gxvar:"A1241PuestoDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1241PuestoDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z1241PuestoDescrip=n)},v2c:function(){gx.fn.setControlValue("PUESTODESCRIP",gx.O.A1241PuestoDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1241PuestoDescrip=this.val())},val:function(){return gx.fn.getControlValue("PUESTODESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PUESTOHORASEXT",fmt:0,gxz:"Z1255PuestoHorasExt",gxold:"O1255PuestoHorasExt",gxvar:"A1255PuestoHorasExt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1255PuestoHorasExt=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1255PuestoHorasExt=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("PUESTOHORASEXT",gx.O.A1255PuestoHorasExt,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1255PuestoHorasExt=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("PUESTOHORASEXT")},nac:gx.falseFn,values:["true","false"]};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"BTNUPDATE",grid:0,evt:"e11cp1_client"};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"BTNDELETE",grid:0,evt:"e12cp1_client"};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[40]={id:40,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};this.A329SecDescrip="";this.Z329SecDescrip="";this.O329SecDescrip="";this.A1240PuestoCodigo="";this.Z1240PuestoCodigo="";this.O1240PuestoCodigo="";this.A1241PuestoDescrip="";this.Z1241PuestoDescrip="";this.O1241PuestoDescrip="";this.A1255PuestoHorasExt=!1;this.Z1255PuestoHorasExt=!1;this.O1255PuestoHorasExt=!1;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A329SecDescrip="";this.A1240PuestoCodigo="";this.A1241PuestoDescrip="";this.A1255PuestoHorasExt=!1;this.A3CliCod=0;this.A13SecCodigo="";this.Events={e16cp2_client:["ENTER",!0],e17cp2_client:["CANCEL",!0],e11cp1_client:["'DOUPDATE'",!1],e12cp1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1240PuestoCodigo",fld:"PUESTOCODIGO",pic:""},{av:"A1255PuestoHorasExt",fld:"PUESTOHORASEXT",pic:""},{av:"A13SecCodigo",fld:"SECCODIGO",pic:"",hsh:!0}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A13SecCodigo",fld:"SECCODIGO",pic:"",hsh:!0},{av:"A1240PuestoCodigo",fld:"PUESTOCODIGO",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A13SecCodigo",fld:"SECCODIGO",pic:"",hsh:!0},{av:"A1240PuestoCodigo",fld:"PUESTOCODIGO",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.setVCMap("A13SecCodigo","SECCODIGO",0,"char",20,0);this.setVCMap("A13SecCodigo","SECCODIGO",0,"char",20,0);this.Initialize()})