gx.evt.autoSkip=!1;gx.define("categoriaalta2general",!0,function(n){this.ServerClass="categoriaalta2general";this.PackageName="web";this.ServerFullClass="web.categoriaalta2general";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV13CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.A3CliCod=gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator);this.A1564CliPaiConve=gx.fn.getIntegerValue("CLIPAICONVE",gx.thousandSeparator);this.A1565CliConvenio=gx.fn.getControlValue("CLICONVENIO");this.A1565CliConvenio=gx.fn.getControlValue("CLICONVENIO");this.A1564CliPaiConve=gx.fn.getIntegerValue("CLIPAICONVE",gx.thousandSeparator);this.A3CliCod=gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)};this.Valid_Catcodigo=function(){return this.validCliEvt("Valid_Catcodigo",0,function(){try{var n=gx.util.balloon.getNew("CATCODIGO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11ae1_client=function(){return this.clearMessages(),this.call("web.categoriaalta2",["UPD",this.A3CliCod,this.A1564CliPaiConve,this.A1565CliConvenio,this.A8CatCodigo],null,["Mode","CliCod","CliPaiConve","CliConvenio","CatCodigo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12ae1_client=function(){return this.clearMessages(),this.call("web.categoriaalta2",["DLT",this.A3CliCod,this.A1564CliPaiConve,this.A1565CliConvenio,this.A8CatCodigo],null,["Mode","CliCod","CliPaiConve","CliConvenio","CatCodigo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16ae2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17ae2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31];this.GXLastCtrlId=31;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:40,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Catcodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CATCODIGO",fmt:0,gxz:"Z8CatCodigo",gxold:"O8CatCodigo",gxvar:"A8CatCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A8CatCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z8CatCodigo=n)},v2c:function(){gx.fn.setControlValue("CATCODIGO",gx.O.A8CatCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.A8CatCodigo=this.val())},val:function(){return gx.fn.getControlValue("CATCODIGO")},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CATDESCRIP",fmt:0,gxz:"Z123CatDescrip",gxold:"O123CatDescrip",gxvar:"A123CatDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A123CatDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z123CatDescrip=n)},v2c:function(){gx.fn.setControlValue("CATDESCRIP",gx.O.A123CatDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A123CatDescrip=this.val())},val:function(){return gx.fn.getControlValue("CATDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"CATRELSEC_CELL",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CATRELSEC",fmt:0,gxz:"Z1894CatRelSec",gxold:"O1894CatRelSec",gxvar:"A1894CatRelSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1894CatRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1894CatRelSec=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("CATRELSEC",gx.O.A1894CatRelSec)},c2v:function(){this.val()!==undefined&&(gx.O.A1894CatRelSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CATRELSEC",gx.thousandSeparator)},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"BTNUPDATE",grid:0,evt:"e11ae1_client"};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"BTNDELETE",grid:0,evt:"e12ae1_client"};this.A8CatCodigo="";this.Z8CatCodigo="";this.O8CatCodigo="";this.A123CatDescrip="";this.Z123CatDescrip="";this.O123CatDescrip="";this.A1894CatRelSec=0;this.Z1894CatRelSec=0;this.O1894CatRelSec=0;this.A8CatCodigo="";this.A123CatDescrip="";this.A1894CatRelSec=0;this.A3CliCod=0;this.A1564CliPaiConve=0;this.A1565CliConvenio="";this.Events={e16ae2_client:["ENTER",!0],e17ae2_client:["CANCEL",!0],e11ae1_client:["'DOUPDATE'",!1],e12ae1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1564CliPaiConve",fld:"CLIPAICONVE",pic:"ZZZ9"},{av:"A1565CliConvenio",fld:"CLICONVENIO",pic:""},{av:"A8CatCodigo",fld:"CATCODIGO",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1564CliPaiConve",fld:"CLIPAICONVE",pic:"ZZZ9"},{av:"A1565CliConvenio",fld:"CLICONVENIO",pic:""},{av:"A8CatCodigo",fld:"CATCODIGO",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1564CliPaiConve",fld:"CLIPAICONVE",pic:"ZZZ9"},{av:"A1565CliConvenio",fld:"CLICONVENIO",pic:""},{av:"A8CatCodigo",fld:"CATCODIGO",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_CATCODIGO=[[],[]];this.setVCMap("AV13CliCod","vCLICOD",0,"int",6,0);this.setVCMap("A3CliCod","CLICOD",0,"int",6,0);this.setVCMap("A1564CliPaiConve","CLIPAICONVE",0,"int",4,0);this.setVCMap("A1565CliConvenio","CLICONVENIO",0,"char",20,0);this.setVCMap("A1565CliConvenio","CLICONVENIO",0,"char",20,0);this.setVCMap("A1564CliPaiConve","CLIPAICONVE",0,"int",4,0);this.setVCMap("A3CliCod","CLICOD",0,"int",6,0);this.Initialize()})