gx.evt.autoSkip=!1;gx.define("templaterecibo",!1,function(){var n,t;this.ServerClass="templaterecibo";this.PackageName="web";this.ServerFullClass="web.templaterecibo";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV8EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV9TempRecSec=gx.fn.getIntegerValue("vTEMPRECSEC",gx.thousandSeparator);this.A972TempRecCss=gx.fn.getControlValue("TEMPRECCSS");this.A1139TempRecExplIIGG=gx.fn.getControlValue("TEMPRECEXPLIIGG");this.AV15Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Temprecsec=function(){return this.validCliEvt("Valid_Temprecsec",0,function(){try{var n=gx.util.balloon.getNew("TEMPRECSEC");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Empcod=function(){return this.validSrvEvt("valid_Empcod",0).then(function(n){return n}.closure(this))};this.Valid_Temprectiporecibo=function(){return this.validCliEvt("Valid_Temprectiporecibo",0,function(){try{var n=gx.util.balloon.getNew("TEMPRECTIPORECIBO");if(this.AnyError=0,!(gx.text.compare(this.A574TempRecTipoRecibo,"Apaisado")==0||gx.text.compare(this.A574TempRecTipoRecibo,"Vertical")==0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Tipo"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e12262_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e132674_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e142674_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,63,64,65,66,67,68,69,70,71,72,73,74];this.GXLastCtrlId=74;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Temprecsec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TEMPRECSEC",fmt:0,gxz:"Z86TempRecSec",gxold:"O86TempRecSec",gxvar:"A86TempRecSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A86TempRecSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z86TempRecSec=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TEMPRECSEC",gx.O.A86TempRecSec,0)},c2v:function(){this.val()!==undefined&&(gx.O.A86TempRecSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TEMPRECSEC",gx.thousandSeparator)},nac:function(){return!(0==this.AV9TempRecSec)}};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TEMPRECDESCRIP",fmt:0,gxz:"Z571TempRecDescrip",gxold:"O571TempRecDescrip",gxvar:"A571TempRecDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A571TempRecDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z571TempRecDescrip=n)},v2c:function(){gx.fn.setControlValue("TEMPRECDESCRIP",gx.O.A571TempRecDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A571TempRecDescrip=this.val())},val:function(){return gx.fn.getControlValue("TEMPRECDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(27,function(){});n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,lvl:0,type:"vchar",len:2097152,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TEMPRECHTML",fmt:1,gxz:"Z572TempRecHTML",gxold:"O572TempRecHTML",gxvar:"A572TempRecHTML",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A572TempRecHTML=n)},v2z:function(n){n!==undefined&&(gx.O.Z572TempRecHTML=n)},v2c:function(){gx.fn.setControlValue("TEMPRECHTML",gx.O.A572TempRecHTML,1);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A572TempRecHTML=this.val())},val:function(){return gx.fn.getControlValue("TEMPRECHTML")},nac:gx.falseFn};this.declareDomainHdlr(32,function(){});n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,lvl:0,type:"vchar",len:2097152,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TEMPRECHTMLBODY",fmt:1,gxz:"Z576TempRecHTMLBody",gxold:"O576TempRecHTMLBody",gxvar:"A576TempRecHTMLBody",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A576TempRecHTMLBody=n)},v2z:function(n){n!==undefined&&(gx.O.Z576TempRecHTMLBody=n)},v2c:function(){gx.fn.setControlValue("TEMPRECHTMLBODY",gx.O.A576TempRecHTMLBody,1);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A576TempRecHTMLBody=this.val())},val:function(){return gx.fn.getControlValue("TEMPRECHTMLBODY")},nac:gx.falseFn};this.declareDomainHdlr(37,function(){});n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,lvl:0,type:"svchar",len:500,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TEMPRECHTMLROW",fmt:0,gxz:"Z573TempRecHTMLRow",gxold:"O573TempRecHTMLRow",gxvar:"A573TempRecHTMLRow",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A573TempRecHTMLRow=n)},v2z:function(n){n!==undefined&&(gx.O.Z573TempRecHTMLRow=n)},v2c:function(){gx.fn.setControlValue("TEMPRECHTMLROW",gx.O.A573TempRecHTMLRow,0)},c2v:function(){this.val()!==undefined&&(gx.O.A573TempRecHTMLRow=this.val())},val:function(){return gx.fn.getControlValue("TEMPRECHTMLROW")},nac:gx.falseFn};n[43]={id:43,fld:"",grid:0};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Temprectiporecibo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TEMPRECTIPORECIBO",fmt:0,gxz:"Z574TempRecTipoRecibo",gxold:"O574TempRecTipoRecibo",gxvar:"A574TempRecTipoRecibo",ucs:[],op:[47],ip:[47],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A574TempRecTipoRecibo=n)},v2z:function(n){n!==undefined&&(gx.O.Z574TempRecTipoRecibo=n)},v2c:function(){gx.fn.setComboBoxValue("TEMPRECTIPORECIBO",gx.O.A574TempRecTipoRecibo);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A574TempRecTipoRecibo=this.val())},val:function(){return gx.fn.getControlValue("TEMPRECTIPORECIBO")},nac:gx.falseFn};this.declareDomainHdlr(47,function(){});n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TEMPRECPAGESIZE",fmt:0,gxz:"Z575TempRecPageSize",gxold:"O575TempRecPageSize",gxvar:"A575TempRecPageSize",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A575TempRecPageSize=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z575TempRecPageSize=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TEMPRECPAGESIZE",gx.O.A575TempRecPageSize,0)},c2v:function(){this.val()!==undefined&&(gx.O.A575TempRecPageSize=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TEMPRECPAGESIZE",gx.thousandSeparator)},nac:gx.falseFn};n[53]={id:53,fld:"",grid:0};n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,lvl:0,type:"svchar",len:800,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TEMPRECRUTA",fmt:0,gxz:"Z949TempRecRuta",gxold:"O949TempRecRuta",gxvar:"A949TempRecRuta",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A949TempRecRuta=n)},v2z:function(n){n!==undefined&&(gx.O.Z949TempRecRuta=n)},v2c:function(){gx.fn.setControlValue("TEMPRECRUTA",gx.O.A949TempRecRuta,0)},c2v:function(){this.val()!==undefined&&(gx.O.A949TempRecRuta=this.val())},val:function(){return gx.fn.getControlValue("TEMPRECRUTA")},nac:gx.falseFn};n[63]={id:63,fld:"",grid:0};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"BTNTRN_ENTER",grid:0,evt:"e132674_client",std:"ENTER"};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"BTNTRN_CANCEL",grid:0,evt:"e142674_client"};n[68]={id:68,fld:"",grid:0};n[69]={id:69,fld:"BTNTRN_DELETE",grid:0,evt:"e152674_client",std:"DELETE"};n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"",grid:0};n[72]={id:72,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[73]={id:73,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV7CliCod)}};n[74]={id:74,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Empcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPCOD",fmt:0,gxz:"Z1EmpCod",gxold:"O1EmpCod",gxvar:"A1EmpCod",ucs:[],op:[],ip:[74,73],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1EmpCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1EmpCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPCOD",gx.O.A1EmpCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1EmpCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV8EmpCod)}};this.declareDomainHdlr(74,function(){});this.A86TempRecSec=0;this.Z86TempRecSec=0;this.O86TempRecSec=0;this.A571TempRecDescrip="";this.Z571TempRecDescrip="";this.O571TempRecDescrip="";this.A572TempRecHTML="";this.Z572TempRecHTML="";this.O572TempRecHTML="";this.A576TempRecHTMLBody="";this.Z576TempRecHTMLBody="";this.O576TempRecHTMLBody="";this.A573TempRecHTMLRow="";this.Z573TempRecHTMLRow="";this.O573TempRecHTMLRow="";this.A574TempRecTipoRecibo="";this.Z574TempRecTipoRecibo="";this.O574TempRecTipoRecibo="";this.A575TempRecPageSize=0;this.Z575TempRecPageSize=0;this.O575TempRecPageSize=0;this.A949TempRecRuta="";this.Z949TempRecRuta="";this.O949TempRecRuta="";this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1EmpCod=0;this.Z1EmpCod=0;this.O1EmpCod=0;this.AV10WWPContext={UserId:0,UserName:""};this.AV11IsAuthorized=!1;this.AV15Pgmname="";this.AV13TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7CliCod=0;this.AV8EmpCod=0;this.AV9TempRecSec=0;this.AV14WebSession={};this.A3CliCod=0;this.A1EmpCod=0;this.A86TempRecSec=0;this.A571TempRecDescrip="";this.A572TempRecHTML="";this.A576TempRecHTMLBody="";this.A573TempRecHTMLRow="";this.A574TempRecTipoRecibo="";this.A575TempRecPageSize=0;this.A949TempRecRuta="";this.A972TempRecCss="";this.A1139TempRecExplIIGG="";this.Gx_mode="";this.Events={e12262_client:["AFTER TRN",!0],e132674_client:["ENTER",!0],e142674_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV8EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV9TempRecSec",fld:"vTEMPRECSEC",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV8EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV9TempRecSec",fld:"vTEMPRECSEC",pic:"ZZZ9",hsh:!0}],[]];this.EvtParms["AFTER TRN"]=[[],[]];this.EvtParms.VALID_TEMPRECSEC=[[],[]];this.EvtParms.VALID_TEMPRECTIPORECIBO=[[{ctrl:"TEMPRECTIPORECIBO"},{av:"A574TempRecTipoRecibo",fld:"TEMPRECTIPORECIBO",pic:""}],[{ctrl:"TEMPRECTIPORECIBO"},{av:"A574TempRecTipoRecibo",fld:"TEMPRECTIPORECIBO",pic:""}]];this.EvtParms.VALID_CLICOD=[[],[]];this.EvtParms.VALID_EMPCOD=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"}],[]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV8EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV9TempRecSec","vTEMPRECSEC",0,"int",4,0);this.setVCMap("A972TempRecCss","TEMPRECCSS",0,"vchar",2097152,0);this.setVCMap("A1139TempRecExplIIGG","TEMPRECEXPLIIGG",0,"vchar",2097152,0);this.setVCMap("AV15Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.templaterecibo)})