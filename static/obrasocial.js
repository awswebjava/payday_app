gx.evt.autoSkip=!1;gx.define("obrasocial",!1,function(){var n,t;this.ServerClass="obrasocial";this.PackageName="web";this.ServerFullClass="web.obrasocial";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A681OsoDescripSinAc=gx.fn.getControlValue("OSODESCRIPSINAC");this.A555OsoSiglaYDesc=gx.fn.getControlValue("OSOSIGLAYDESC");this.AV11CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV7OsoCod=gx.fn.getControlValue("vOSOCOD");this.AV16Insert_OsoActCom=gx.fn.getControlValue("vINSERT_OSOACTCOM");this.A2160OsoActCom=gx.fn.getControlValue("OSOACTCOM");this.A1983OsoPadre=gx.fn.getControlValue("OSOPADRE");this.Gx_BScreen=gx.fn.getIntegerValue("vGXBSCREEN",gx.thousandSeparator);this.A308OsoHabilitada=gx.fn.getControlValue("OSOHABILITADA");this.AV15aplicadoHay=gx.fn.getControlValue("vAPLICADOHAY");this.A1982OsoRelSecCli=gx.fn.getIntegerValue("OSORELSECCLI",gx.thousandSeparator);this.A2014OsoRelRef=gx.fn.getControlValue("OSORELREF");this.A2035OsoOld=gx.fn.getControlValue("OSOOLD");this.A2161OsoActComDesc=gx.fn.getControlValue("OSOACTCOMDESC");this.AV19Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Osocod=function(){return this.validCliEvt("Valid_Osocod",0,function(){try{var n=gx.util.balloon.getNew("OSOCOD");if(this.AnyError=0,gx.text.compare("",this.A5OsoCod)==0)try{n.setError(gx.text.format(gx.getMessage("WWP_RequiredAttribute"),gx.getMessage("Obra Social"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}this.refreshOutputs([{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validSrvEvt("valid_Clicod",0).then(function(n){return n}.closure(this))};this.Valid_Osodescrip=function(){return this.validSrvEvt("valid_Osodescrip",0).then(function(n){return n}.closure(this))};this.Valid_Ososigla=function(){return this.validCliEvt("Valid_Ososigla",0,function(){try{var n=gx.util.balloon.getNew("OSOSIGLA");this.AnyError=0;this.refreshOutputs([{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Osoc3992=function(){return this.validCliEvt("Valid_Osoc3992",0,function(){try{var n=gx.util.balloon.getNew("OSOC3992");this.AnyError=0;try{this.A555OsoSiglaYDesc=gx.text.compare("",this.A392OsoSigla)==0||gx.text.compare("",this.A306OsoC3992)!==0?gx.text.compare("",this.A392OsoSigla)==0||gx.text.compare("",this.A306OsoC3992)===0?gx.text.compare("",this.A392OsoSigla)!=0||gx.text.compare("",this.A306OsoC3992)===0?this.A307OsoDescrip:gx.text.trim(this.A307OsoDescrip)+gx.getMessage(" (Cod. ")+gx.text.trim(this.A306OsoC3992)+")":gx.text.trim(this.A392OsoSigla)+" "+gx.text.trim(this.A307OsoDescrip)+gx.getMessage(" (Cod. ")+gx.text.trim(this.A306OsoC3992)+")":gx.text.trim(this.A392OsoSigla)+" "+gx.text.trim(this.A307OsoDescrip)}catch(t){}this.refreshOutputs([{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Osoaporteadic=function(){return this.validSrvEvt("valid_Osoaporteadic",0).then(function(n){return n}.closure(this))};this.Valid_Osorelsec=function(){return this.validSrvEvt("valid_Osorelsec",0).then(function(n){return n}.closure(this))};this.s112_client=function(){gx.fn.setCtrlProperty("OSORELSEC_CELL","Class","col-xs-12 col-sm-6 DataContentCell DscTop")};this.e12142_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e131437_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e141437_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,16,17,18,19,20,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66];this.GXLastCtrlId=66;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,21,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLEHEADER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"TABLECONTENT",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[23]={id:23,fld:"TABLEATTRIBUTES",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Osocod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"OSOCOD",fmt:0,gxz:"Z5OsoCod",gxold:"O5OsoCod",gxvar:"A5OsoCod",ucs:[],op:[28],ip:[28],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A5OsoCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z5OsoCod=n)},v2c:function(){gx.fn.setControlValue("OSOCOD",gx.O.A5OsoCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A5OsoCod=this.val())},val:function(){return gx.fn.getControlValue("OSOCOD")},nac:function(){return!(gx.text.compare("",this.AV7OsoCod)==0)}};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:this.Valid_Osodescrip,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"OSODESCRIP",fmt:0,gxz:"Z307OsoDescrip",gxold:"O307OsoDescrip",gxvar:"A307OsoDescrip",ucs:[],op:[33],ip:[33],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A307OsoDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z307OsoDescrip=n)},v2c:function(){gx.fn.setControlValue("OSODESCRIP",gx.O.A307OsoDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A307OsoDescrip=this.val())},val:function(){return gx.fn.getControlValue("OSODESCRIP")},nac:function(){return!(gx.text.compare("",this.A1983OsoPadre)==0)}};this.declareDomainHdlr(33,function(){});n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Ososigla,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"OSOSIGLA",fmt:0,gxz:"Z392OsoSigla",gxold:"O392OsoSigla",gxvar:"A392OsoSigla",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A392OsoSigla=n)},v2z:function(n){n!==undefined&&(gx.O.Z392OsoSigla=n)},v2c:function(){gx.fn.setControlValue("OSOSIGLA",gx.O.A392OsoSigla,0)},c2v:function(){this.val()!==undefined&&(gx.O.A392OsoSigla=this.val())},val:function(){return gx.fn.getControlValue("OSOSIGLA")},nac:function(){return!(gx.text.compare("",this.A1983OsoPadre)==0)}};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Osoc3992,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"OSOC3992",fmt:0,gxz:"Z306OsoC3992",gxold:"O306OsoC3992",gxvar:"A306OsoC3992",ucs:[],op:[],ip:[43,33,38],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A306OsoC3992=n)},v2z:function(n){n!==undefined&&(gx.O.Z306OsoC3992=n)},v2c:function(){gx.fn.setControlValue("OSOC3992",gx.O.A306OsoC3992,0)},c2v:function(){this.val()!==undefined&&(gx.O.A306OsoC3992=this.val())},val:function(){return gx.fn.getControlValue("OSOC3992")},nac:function(){return!(gx.text.compare("",this.A1983OsoPadre)==0)}};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,lvl:0,type:"decimal",len:14,dec:2,sign:!0,pic:"ZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Osoaporteadic,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"OSOAPORTEADIC",fmt:0,gxz:"Z893OsoAporteAdic",gxold:"O893OsoAporteAdic",gxvar:"A893OsoAporteAdic",ucs:[],op:[],ip:[48,43,33,28],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A893OsoAporteAdic=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z893OsoAporteAdic=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("OSOAPORTEADIC",gx.O.A893OsoAporteAdic,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A893OsoAporteAdic=this.val())},val:function(){return gx.fn.getDecimalValue("OSOAPORTEADIC",gx.thousandSeparator,gx.decimalPoint)},nac:function(){return!(gx.text.compare("",this.A1983OsoPadre)==0)}};this.declareDomainHdlr(48,function(){});n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"OSORELSEC_CELL",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Osorelsec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"OSORELSEC",fmt:0,gxz:"Z1981OsoRelSec",gxold:"O1981OsoRelSec",gxvar:"A1981OsoRelSec",ucs:[],op:[53,48,43,33,28],ip:[53,48,43,33,28],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1981OsoRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1981OsoRelSec=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("OSORELSEC",gx.O.A1981OsoRelSec)},c2v:function(){this.val()!==undefined&&(gx.O.A1981OsoRelSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("OSORELSEC",gx.thousandSeparator)},nac:gx.falseFn};n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"BTNTRN_ENTER",grid:0,evt:"e131437_client",std:"ENTER"};n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"BTNTRN_CANCEL",grid:0,evt:"e141437_client"};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"BTNTRN_DELETE",grid:0,evt:"e151437_client",std:"DELETE"};n[63]={id:63,fld:"",grid:0};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[66]={id:66,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[66],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV11CliCod)}};this.A5OsoCod="";this.Z5OsoCod="";this.O5OsoCod="";this.A307OsoDescrip="";this.Z307OsoDescrip="";this.O307OsoDescrip="";this.A392OsoSigla="";this.Z392OsoSigla="";this.O392OsoSigla="";this.A306OsoC3992="";this.Z306OsoC3992="";this.O306OsoC3992="";this.A893OsoAporteAdic=0;this.Z893OsoAporteAdic=0;this.O893OsoAporteAdic=0;this.A1981OsoRelSec=0;this.Z1981OsoRelSec=0;this.O1981OsoRelSec=0;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV13IsAuthorized=!1;this.AV19Pgmname="";this.AV9TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV20GXV1=0;this.AV16Insert_OsoActCom="";this.AV17TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV11CliCod=0;this.AV7OsoCod="";this.AV10WebSession={};this.A3CliCod=0;this.A5OsoCod="";this.A2160OsoActCom="";this.AV15aplicadoHay=!1;this.Gx_BScreen=0;this.A555OsoSiglaYDesc="";this.A681OsoDescripSinAc="";this.A307OsoDescrip="";this.A392OsoSigla="";this.A308OsoHabilitada=!1;this.A306OsoC3992="";this.A893OsoAporteAdic=0;this.A1981OsoRelSec=0;this.A1982OsoRelSecCli=0;this.A1983OsoPadre="";this.A2014OsoRelRef="";this.A2035OsoOld="";this.A2161OsoActComDesc="";this.Gx_mode="";this.Events={e12142_client:["AFTER TRN",!0],e131437_client:["ENTER",!0],e141437_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7OsoCod",fld:"vOSOCOD",pic:"",hsh:!0},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7OsoCod",fld:"vOSOCOD",pic:"",hsh:!0},{av:"A308OsoHabilitada",fld:"OSOHABILITADA",pic:""},{av:"A1982OsoRelSecCli",fld:"OSORELSECCLI",pic:"ZZZZZ9"},{av:"A1983OsoPadre",fld:"OSOPADRE",pic:""},{av:"A2014OsoRelRef",fld:"OSORELREF",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms["AFTER TRN"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_OSOCOD=[[{av:"A5OsoCod",fld:"OSOCOD",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"A5OsoCod",fld:"OSOCOD",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_OSODESCRIP=[[{av:"A307OsoDescrip",fld:"OSODESCRIP",pic:""},{av:"A681OsoDescripSinAc",fld:"OSODESCRIPSINAC",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"A681OsoDescripSinAc",fld:"OSODESCRIPSINAC",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_OSOSIGLA=[[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_OSOC3992=[[{av:"A306OsoC3992",fld:"OSOC3992",pic:""},{av:"A307OsoDescrip",fld:"OSODESCRIP",pic:""},{av:"A392OsoSigla",fld:"OSOSIGLA",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_OSOAPORTEADIC=[[{av:"O893OsoAporteAdic"},{av:"O306OsoC3992"},{av:"O307OsoDescrip"},{av:"O5OsoCod"},{av:"A5OsoCod",fld:"OSOCOD",pic:""},{av:"A307OsoDescrip",fld:"OSODESCRIP",pic:""},{av:"A306OsoC3992",fld:"OSOC3992",pic:""},{av:"A893OsoAporteAdic",fld:"OSOAPORTEADIC",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:'gx.fn.getCtrlProperty("OSORELSEC_CELL","Class")',ctrl:"OSORELSEC_CELL",prop:"Class"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_OSORELSEC=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"O893OsoAporteAdic"},{av:"O306OsoC3992"},{av:"O307OsoDescrip"},{av:"O5OsoCod"},{av:"A5OsoCod",fld:"OSOCOD",pic:""},{av:"A307OsoDescrip",fld:"OSODESCRIP",pic:""},{av:"A306OsoC3992",fld:"OSOC3992",pic:""},{av:"A893OsoAporteAdic",fld:"OSOAPORTEADIC",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV15aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"AV15aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CLICOD=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"OSORELSEC"},{av:"A1981OsoRelSec",fld:"OSORELSEC",pic:"ZZZZZ9"}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("A681OsoDescripSinAc","OSODESCRIPSINAC",0,"svchar",400,0);this.setVCMap("A555OsoSiglaYDesc","OSOSIGLAYDESC",0,"svchar",400,0);this.setVCMap("AV11CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV7OsoCod","vOSOCOD",0,"char",20,0);this.setVCMap("AV16Insert_OsoActCom","vINSERT_OSOACTCOM",0,"char",20,0);this.setVCMap("A2160OsoActCom","OSOACTCOM",0,"char",20,0);this.setVCMap("A1983OsoPadre","OSOPADRE",0,"char",20,0);this.setVCMap("Gx_BScreen","vGXBSCREEN",0,"int",1,0);this.setVCMap("A308OsoHabilitada","OSOHABILITADA",0,"boolean",4,0);this.setVCMap("AV15aplicadoHay","vAPLICADOHAY",0,"boolean",4,0);this.setVCMap("A1982OsoRelSecCli","OSORELSECCLI",0,"int",6,0);this.setVCMap("A2014OsoRelRef","OSORELREF",0,"svchar",40,0);this.setVCMap("A2035OsoOld","OSOOLD",0,"vchar",2097152,0);this.setVCMap("A2161OsoActComDesc","OSOACTCOMDESC",0,"svchar",400,0);this.setVCMap("AV19Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize();this.LvlOlds[37]=["O893OsoAporteAdic","O306OsoC3992","O307OsoDescrip","O5OsoCod"]});gx.wi(function(){gx.createParentObj(this.obrasocial)})