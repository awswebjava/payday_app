gx.evt.autoSkip=!1;gx.define("sindicato",!1,function(){var n,t;this.ServerClass="sindicato";this.PackageName="web";this.ServerFullClass="web.sindicato";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A680SinDescripSinAc=gx.fn.getControlValue("SINDESCRIPSINAC");this.AV18PaiCod=gx.fn.getIntegerValue("vPAICOD",gx.thousandSeparator);this.AV11CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.Gx_BScreen=gx.fn.getIntegerValue("vGXBSCREEN",gx.thousandSeparator);this.AV7SinCod=gx.fn.getControlValue("vSINCOD");this.AV17Insert_ActComCodigo=gx.fn.getControlValue("vINSERT_ACTCOMCODIGO");this.A332SinHabilitado=gx.fn.getControlValue("SINHABILITADO");this.AV20Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Sincod=function(){return this.validCliEvt("Valid_Sincod",0,function(){try{var n=gx.util.balloon.getNew("SINCOD");if(this.AnyError=0,gx.text.compare("",this.A14SinCod)==0)try{n.setError(gx.text.format(gx.getMessage("WWP_RequiredAttribute"),gx.getMessage("Sindicato"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}this.refreshOutputs([{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Paicod=function(){return this.validSrvEvt("valid_Paicod",0).then(function(n){return n}.closure(this))};this.Valid_Actcomcodigo=function(){return this.validSrvEvt("valid_Actcomcodigo",0).then(function(n){return n}.closure(this))};this.Valid_Sindescrip=function(){return this.validSrvEvt("valid_Sindescrip",0).then(function(n){return n}.closure(this))};this.e121b2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e131b107_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e141b107_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,16,17,18,19,20,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66];this.GXLastCtrlId=66;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,21,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLEHEADER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"TABLECONTENT",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[23]={id:23,fld:"TABLEATTRIBUTES",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Actcomcodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ACTCOMCODIGO",fmt:0,gxz:"Z903ActComCodigo",gxold:"O903ActComCodigo",gxvar:"A903ActComCodigo",ucs:[],op:[28],ip:[28],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A903ActComCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z903ActComCodigo=n)},v2c:function(){gx.fn.setComboBoxValue("ACTCOMCODIGO",gx.O.A903ActComCodigo);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A903ActComCodigo=this.val())},val:function(){return gx.fn.getControlValue("ACTCOMCODIGO")},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(gx.text.compare("",this.AV17Insert_ActComCodigo)==0)}};this.declareDomainHdlr(28,function(){});n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Sincod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINCOD",fmt:0,gxz:"Z14SinCod",gxold:"O14SinCod",gxvar:"A14SinCod",ucs:[],op:[33],ip:[33],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A14SinCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z14SinCod=n)},v2c:function(){gx.fn.setControlValue("SINCOD",gx.O.A14SinCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A14SinCod=this.val())},val:function(){return gx.fn.getControlValue("SINCOD")},nac:function(){return!(gx.text.compare("",this.AV7SinCod)==0)}};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:this.Valid_Sindescrip,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINDESCRIP",fmt:0,gxz:"Z331SinDescrip",gxold:"O331SinDescrip",gxvar:"A331SinDescrip",ucs:[],op:[38],ip:[38],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A331SinDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z331SinDescrip=n)},v2c:function(){gx.fn.setControlValue("SINDESCRIP",gx.O.A331SinDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A331SinDescrip=this.val())},val:function(){return gx.fn.getControlValue("SINDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(38,function(){});n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINSIGLA",fmt:0,gxz:"Z1647SinSigla",gxold:"O1647SinSigla",gxvar:"A1647SinSigla",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1647SinSigla=n)},v2z:function(n){n!==undefined&&(gx.O.Z1647SinSigla=n)},v2c:function(){gx.fn.setControlValue("SINSIGLA",gx.O.A1647SinSigla,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1647SinSigla=this.val())},val:function(){return gx.fn.getControlValue("SINSIGLA")},nac:gx.falseFn};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,lvl:0,type:"decimal",len:6,dec:4,sign:!1,pic:"9.9999",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINCUOTAALI",fmt:0,gxz:"Z930SinCuotaAli",gxold:"O930SinCuotaAli",gxvar:"A930SinCuotaAli",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A930SinCuotaAli=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z930SinCuotaAli=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("SINCUOTAALI",gx.O.A930SinCuotaAli,4,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A930SinCuotaAli=this.val())},val:function(){return gx.fn.getDecimalValue("SINCUOTAALI",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.declareDomainHdlr(48,function(){});n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINDEFAULT",fmt:0,gxz:"Z906SinDefault",gxold:"O906SinDefault",gxvar:"A906SinDefault",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A906SinDefault=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z906SinDefault=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("SINDEFAULT",gx.O.A906SinDefault,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A906SinDefault=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("SINDEFAULT")},nac:gx.falseFn,values:["true","false"]};n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"BTNTRN_ENTER",grid:0,evt:"e131b107_client",std:"ENTER"};n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"BTNTRN_CANCEL",grid:0,evt:"e141b107_client"};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"BTNTRN_DELETE",grid:0,evt:"e151b107_client",std:"DELETE"};n[63]={id:63,fld:"",grid:0};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[66]={id:66,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Paicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PAICOD",fmt:0,gxz:"Z46PaiCod",gxold:"O46PaiCod",gxvar:"A46PaiCod",ucs:[],op:[],ip:[66],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A46PaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z46PaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PAICOD",gx.O.A46PaiCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A46PaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PAICOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV18PaiCod)}};this.declareDomainHdlr(66,function(){});this.A903ActComCodigo="";this.Z903ActComCodigo="";this.O903ActComCodigo="";this.A14SinCod="";this.Z14SinCod="";this.O14SinCod="";this.A331SinDescrip="";this.Z331SinDescrip="";this.O331SinDescrip="";this.A1647SinSigla="";this.Z1647SinSigla="";this.O1647SinSigla="";this.A930SinCuotaAli=0;this.Z930SinCuotaAli=0;this.O930SinCuotaAli=0;this.A906SinDefault=!1;this.Z906SinDefault=!1;this.O906SinDefault=!1;this.A46PaiCod=0;this.Z46PaiCod=0;this.O46PaiCod=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV13IsAuthorized=!1;this.AV20Pgmname="";this.AV9TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV21GXV1=0;this.AV17Insert_ActComCodigo="";this.AV16TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV18PaiCod=0;this.AV7SinCod="";this.AV10WebSession={};this.A46PaiCod=0;this.A14SinCod="";this.A903ActComCodigo="";this.AV11CliCod=0;this.Gx_BScreen=0;this.A680SinDescripSinAc="";this.A331SinDescrip="";this.A332SinHabilitado=!1;this.A906SinDefault=!1;this.A930SinCuotaAli=0;this.A1647SinSigla="";this.Gx_mode="";this.Events={e121b2_client:["AFTER TRN",!0],e131b107_client:["ENTER",!0],e141b107_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV18PaiCod",fld:"vPAICOD",pic:"ZZZ9",hsh:!0},{av:"AV7SinCod",fld:"vSINCOD",pic:"",hsh:!0},{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}],[{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV18PaiCod",fld:"vPAICOD",pic:"ZZZ9",hsh:!0},{av:"AV7SinCod",fld:"vSINCOD",pic:"",hsh:!0},{av:"A332SinHabilitado",fld:"SINHABILITADO",pic:""},{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}],[{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}]];this.EvtParms["AFTER TRN"]=[[{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}],[{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}]];this.EvtParms.VALID_ACTCOMCODIGO=[[{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}],[{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}]];this.EvtParms.VALID_SINCOD=[[{av:"A14SinCod",fld:"SINCOD",pic:""},{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}],[{av:"A14SinCod",fld:"SINCOD",pic:""},{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}]];this.EvtParms.VALID_SINDESCRIP=[[{av:"A331SinDescrip",fld:"SINDESCRIP",pic:""},{av:"A680SinDescripSinAc",fld:"SINDESCRIPSINAC",pic:""},{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}],[{av:"A680SinDescripSinAc",fld:"SINDESCRIPSINAC",pic:""},{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}]];this.EvtParms.VALID_PAICOD=[[{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}],[{ctrl:"ACTCOMCODIGO"},{av:"A903ActComCodigo",fld:"ACTCOMCODIGO",pic:""},{av:"A906SinDefault",fld:"SINDEFAULT",pic:""}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("A680SinDescripSinAc","SINDESCRIPSINAC",0,"svchar",400,0);this.setVCMap("AV18PaiCod","vPAICOD",0,"int",4,0);this.setVCMap("AV11CliCod","vCLICOD",0,"int",6,0);this.setVCMap("Gx_BScreen","vGXBSCREEN",0,"int",1,0);this.setVCMap("AV7SinCod","vSINCOD",0,"char",20,0);this.setVCMap("AV17Insert_ActComCodigo","vINSERT_ACTCOMCODIGO",0,"char",20,0);this.setVCMap("A332SinHabilitado","SINHABILITADO",0,"boolean",4,0);this.setVCMap("AV20Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.sindicato)})