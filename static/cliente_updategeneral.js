gx.evt.autoSkip=!1;gx.define("cliente_updategeneral",!0,function(n){this.ServerClass="cliente_updategeneral";this.PackageName="web";this.ServerFullClass="web.cliente_updategeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A3CliCod=gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator);this.A1881CliUpdCliCod=gx.fn.getIntegerValue("CLIUPDCLICOD",gx.thousandSeparator);this.A1887CliUpdRelSec=gx.fn.getIntegerValue("CLIUPDRELSEC",gx.thousandSeparator)};this.e14kz2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e15kz2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29];this.GXLastCtrlId=29;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"svchar",len:40,dec:0,sign:!1,pic:"@!",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLINOM",fmt:0,gxz:"Z344CliNom",gxold:"O344CliNom",gxvar:"A344CliNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A344CliNom=n)},v2z:function(n){n!==undefined&&(gx.O.Z344CliNom=n)},v2c:function(){gx.fn.setControlValue("CLINOM",gx.O.A344CliNom,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A344CliNom=this.val())},val:function(){return gx.fn.getControlValue("CLINOM")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCLIUPDCLICOD_DESCRIPTION",fmt:0,gxz:"ZV12CliUpdCliCod_Description",gxold:"OV12CliUpdCliCod_Description",gxvar:"AV12CliUpdCliCod_Description",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12CliUpdCliCod_Description=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12CliUpdCliCod_Description=n)},v2c:function(){gx.fn.setControlValue("vCLIUPDCLICOD_DESCRIPTION",gx.O.AV12CliUpdCliCod_Description,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV12CliUpdCliCod_Description=this.val())},val:function(){return gx.fn.getControlValue("vCLIUPDCLICOD_DESCRIPTION")},nac:gx.falseFn};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCLIUPDRELSEC_DESCRIPTION",fmt:0,gxz:"ZV18CliUpdRelSec_Description",gxold:"OV18CliUpdRelSec_Description",gxvar:"AV18CliUpdRelSec_Description",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV18CliUpdRelSec_Description=n)},v2z:function(n){n!==undefined&&(gx.O.ZV18CliUpdRelSec_Description=n)},v2c:function(){gx.fn.setControlValue("vCLIUPDRELSEC_DESCRIPTION",gx.O.AV18CliUpdRelSec_Description,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV18CliUpdRelSec_Description=this.val())},val:function(){return gx.fn.getControlValue("vCLIUPDRELSEC_DESCRIPTION")},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"dtime",len:8,dec:5,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIUPDDTAPL",fmt:0,gxz:"Z1883CliUpdDTApl",gxold:"O1883CliUpdDTApl",gxvar:"A1883CliUpdDTApl",dp:{f:0,st:!0,wn:!1,mf:!1,pic:"99/99/99 99:99",dec:5},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1883CliUpdDTApl=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1883CliUpdDTApl=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("CLIUPDDTAPL",gx.O.A1883CliUpdDTApl,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1883CliUpdDTApl=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getDateTimeValue("CLIUPDDTAPL")},nac:gx.falseFn};this.A344CliNom="";this.Z344CliNom="";this.O344CliNom="";this.AV12CliUpdCliCod_Description="";this.ZV12CliUpdCliCod_Description="";this.OV12CliUpdCliCod_Description="";this.AV18CliUpdRelSec_Description="";this.ZV18CliUpdRelSec_Description="";this.OV18CliUpdRelSec_Description="";this.A1883CliUpdDTApl=gx.date.nullDate();this.Z1883CliUpdDTApl=gx.date.nullDate();this.O1883CliUpdDTApl=gx.date.nullDate();this.A344CliNom="";this.AV12CliUpdCliCod_Description="";this.AV18CliUpdRelSec_Description="";this.A1883CliUpdDTApl=gx.date.nullDate();this.A3CliCod=0;this.A1881CliUpdCliCod=0;this.A1887CliUpdRelSec=0;this.Events={e14kz2_client:["ENTER",!0],e15kz2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1881CliUpdCliCod",fld:"CLIUPDCLICOD",pic:"ZZZZZ9"},{av:"A1887CliUpdRelSec",fld:"CLIUPDRELSEC",pic:"ZZZZZ9"}],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("A3CliCod","CLICOD",0,"int",6,0);this.setVCMap("A1881CliUpdCliCod","CLIUPDCLICOD",0,"int",6,0);this.setVCMap("A1887CliUpdRelSec","CLIUPDRELSEC",0,"int",6,0);this.Initialize()})