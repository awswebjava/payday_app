gx.evt.autoSkip=!1;gx.define("situacionrevistaafip",!1,function(){var n,t;this.ServerClass="situacionrevistaafip";this.PackageName="web";this.ServerFullClass="web.situacionrevistaafip";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7SitRevCodigo=gx.fn.getIntegerValue("vSITREVCODIGO",gx.thousandSeparator);this.AV13Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Sitrevcodigo=function(){return this.validCliEvt("Valid_Sitrevcodigo",0,function(){try{var n=gx.util.balloon.getNew("SITREVCODIGO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e124o2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e134o219_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e144o219_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,38,39,40,41,42,43,44];this.GXLastCtrlId=44;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:3,dec:0,sign:!1,pic:"ZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Sitrevcodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SITREVCODIGO",fmt:0,gxz:"Z1595SitRevCodigo",gxold:"O1595SitRevCodigo",gxvar:"A1595SitRevCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1595SitRevCodigo=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1595SitRevCodigo=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("SITREVCODIGO",gx.O.A1595SitRevCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1595SitRevCodigo=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SITREVCODIGO",gx.thousandSeparator)},nac:function(){return!(0==this.AV7SitRevCodigo)}};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SITREVDESCRIP",fmt:0,gxz:"Z1596SitRevDescrip",gxold:"O1596SitRevDescrip",gxvar:"A1596SitRevDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1596SitRevDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z1596SitRevDescrip=n)},v2c:function(){gx.fn.setControlValue("SITREVDESCRIP",gx.O.A1596SitRevDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1596SitRevDescrip=this.val())},val:function(){return gx.fn.getControlValue("SITREVDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(27,function(){});n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SITREVESBAJA",fmt:0,gxz:"Z1597SitRevEsBaja",gxold:"O1597SitRevEsBaja",gxvar:"A1597SitRevEsBaja",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1597SitRevEsBaja=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1597SitRevEsBaja=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("SITREVESBAJA",gx.O.A1597SitRevEsBaja,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1597SitRevEsBaja=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("SITREVESBAJA")},nac:gx.falseFn,values:["true","false"]};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"BTNTRN_ENTER",grid:0,evt:"e134o219_client",std:"ENTER"};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"BTNTRN_CANCEL",grid:0,evt:"e144o219_client"};n[43]={id:43,fld:"",grid:0};n[44]={id:44,fld:"BTNTRN_DELETE",grid:0,evt:"e154o219_client",std:"DELETE"};this.A1595SitRevCodigo=0;this.Z1595SitRevCodigo=0;this.O1595SitRevCodigo=0;this.A1596SitRevDescrip="";this.Z1596SitRevDescrip="";this.O1596SitRevDescrip="";this.A1597SitRevEsBaja=!1;this.Z1597SitRevEsBaja=!1;this.O1597SitRevEsBaja=!1;this.AV8WWPContext={UserId:0,UserName:""};this.AV9IsAuthorized=!1;this.AV13Pgmname="";this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7SitRevCodigo=0;this.AV12WebSession={};this.A1595SitRevCodigo=0;this.A1596SitRevDescrip="";this.A1597SitRevEsBaja=!1;this.Gx_mode="";this.Events={e124o2_client:["AFTER TRN",!0],e134o219_client:["ENTER",!0],e144o219_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7SitRevCodigo",fld:"vSITREVCODIGO",pic:"ZZ9",hsh:!0},{av:"A1597SitRevEsBaja",fld:"SITREVESBAJA",pic:""}],[{av:"A1597SitRevEsBaja",fld:"SITREVESBAJA",pic:""}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7SitRevCodigo",fld:"vSITREVCODIGO",pic:"ZZ9",hsh:!0},{av:"A1597SitRevEsBaja",fld:"SITREVESBAJA",pic:""}],[{av:"A1597SitRevEsBaja",fld:"SITREVESBAJA",pic:""}]];this.EvtParms["AFTER TRN"]=[[{av:"A1597SitRevEsBaja",fld:"SITREVESBAJA",pic:""}],[{av:"A1597SitRevEsBaja",fld:"SITREVESBAJA",pic:""}]];this.EvtParms.VALID_SITREVCODIGO=[[{av:"A1597SitRevEsBaja",fld:"SITREVESBAJA",pic:""}],[{av:"A1597SitRevEsBaja",fld:"SITREVESBAJA",pic:""}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7SitRevCodigo","vSITREVCODIGO",0,"int",3,0);this.setVCMap("AV13Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.situacionrevistaafip)})