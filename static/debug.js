gx.evt.autoSkip=!1;gx.define("debug",!1,function(){var n,t;this.ServerClass="debug";this.PackageName="web";this.ServerFullClass="web.debug";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV8DebugPgm=gx.fn.getControlValue("vDEBUGPGM");this.AV14Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Debugpgm=function(){return this.validCliEvt("Valid_Debugpgm",0,function(){try{var n=gx.util.balloon.getNew("DEBUGPGM");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validSrvEvt("valid_Clicod",0).then(function(n){return n}.closure(this))};this.e12562_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e1356287_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e1456287_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,33,34,35,36,37,38,39,40,41,42,43];this.GXLastCtrlId=43;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Debugpgm,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DEBUGPGM",fmt:0,gxz:"Z1754DebugPgm",gxold:"O1754DebugPgm",gxvar:"A1754DebugPgm",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1754DebugPgm=n)},v2z:function(n){n!==undefined&&(gx.O.Z1754DebugPgm=n)},v2c:function(){gx.fn.setControlValue("DEBUGPGM",gx.O.A1754DebugPgm,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1754DebugPgm=this.val())},val:function(){return gx.fn.getControlValue("DEBUGPGM")},nac:function(){return!(gx.text.compare("",this.AV8DebugPgm)==0)}};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"DEBUGACTIVO",fmt:0,gxz:"Z1755DebugActivo",gxold:"O1755DebugActivo",gxvar:"A1755DebugActivo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1755DebugActivo=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1755DebugActivo=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("DEBUGACTIVO",gx.O.A1755DebugActivo,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1755DebugActivo=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("DEBUGACTIVO")},nac:gx.falseFn,values:["true","false"]};n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"BTNTRN_ENTER",grid:0,evt:"e1356287_client",std:"ENTER"};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"BTNTRN_CANCEL",grid:0,evt:"e1456287_client"};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"BTNTRN_DELETE",grid:0,evt:"e1556287_client",std:"DELETE"};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[43]={id:43,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[43],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV7CliCod)}};this.A1754DebugPgm="";this.Z1754DebugPgm="";this.O1754DebugPgm="";this.A1755DebugActivo=!1;this.Z1755DebugActivo=!1;this.O1755DebugActivo=!1;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.AV9WWPContext={UserId:0,UserName:""};this.AV10IsAuthorized=!1;this.AV14Pgmname="";this.AV12TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7CliCod=0;this.AV8DebugPgm="";this.AV13WebSession={};this.A3CliCod=0;this.A1754DebugPgm="";this.A1755DebugActivo=!1;this.Gx_mode="";this.Events={e12562_client:["AFTER TRN",!0],e1356287_client:["ENTER",!0],e1456287_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV8DebugPgm",fld:"vDEBUGPGM",pic:"",hsh:!0},{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}],[{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV8DebugPgm",fld:"vDEBUGPGM",pic:"",hsh:!0},{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}],[{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}]];this.EvtParms["AFTER TRN"]=[[{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}],[{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}]];this.EvtParms.VALID_DEBUGPGM=[[{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}],[{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}]];this.EvtParms.VALID_CLICOD=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}],[{av:"A1755DebugActivo",fld:"DEBUGACTIVO",pic:""}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV8DebugPgm","vDEBUGPGM",0,"svchar",100,0);this.setVCMap("AV14Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.debug)})