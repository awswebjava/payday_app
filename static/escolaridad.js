gx.evt.autoSkip=!1;gx.define("escolaridad",!1,function(){var n,t;this.ServerClass="escolaridad";this.PackageName="web";this.ServerFullClass="web.escolaridad";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.Gx_BScreen=gx.fn.getIntegerValue("vGXBSCREEN",gx.thousandSeparator);this.A188EscRes551=gx.fn.getControlValue("ESCRES551")};this.Valid_Esccod=function(){return this.validCliEvt("Valid_Esccod",0,function(){try{var n=gx.util.balloon.getNew("ESCCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validSrvEvt("valid_Clicod",0).then(function(n){return n}.closure(this))};this.e120g2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e130g14_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e140g14_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,38,39,40,41,42,43,44,45,46,47,48];this.GXLastCtrlId=48;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Esccod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ESCCOD",fmt:0,gxz:"Z49EscCod",gxold:"O49EscCod",gxvar:"A49EscCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A49EscCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z49EscCod=n)},v2c:function(){gx.fn.setControlValue("ESCCOD",gx.O.A49EscCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A49EscCod=this.val())},val:function(){return gx.fn.getControlValue("ESCCOD")},nac:gx.falseFn};this.declareDomainHdlr(22,function(){});n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ESCDESCRIP",fmt:0,gxz:"Z186EscDescrip",gxold:"O186EscDescrip",gxvar:"A186EscDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A186EscDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z186EscDescrip=n)},v2c:function(){gx.fn.setControlValue("ESCDESCRIP",gx.O.A186EscDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A186EscDescrip=this.val())},val:function(){return gx.fn.getControlValue("ESCDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(27,function(){});n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ESCHABILITADA",fmt:0,gxz:"Z187EscHabilitada",gxold:"O187EscHabilitada",gxvar:"A187EscHabilitada",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A187EscHabilitada=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z187EscHabilitada=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("ESCHABILITADA",gx.O.A187EscHabilitada,!0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A187EscHabilitada=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("ESCHABILITADA")},nac:gx.falseFn,values:["true","false"]};this.declareDomainHdlr(32,function(){});n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"BTNTRN_ENTER",grid:0,evt:"e130g14_client",std:"ENTER"};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"BTNTRN_CANCEL",grid:0,evt:"e140g14_client"};n[43]={id:43,fld:"",grid:0};n[44]={id:44,fld:"BTNTRN_DELETE",grid:0,evt:"e150g14_client",std:"DELETE"};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[48]={id:48,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[32,27],ip:[32,27,22,48],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};this.A49EscCod="";this.Z49EscCod="";this.O49EscCod="";this.A186EscDescrip="";this.Z186EscDescrip="";this.O186EscDescrip="";this.A187EscHabilitada=!1;this.Z187EscHabilitada=!1;this.O187EscHabilitada=!1;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.AV13WebSession={};this.A3CliCod=0;this.A49EscCod="";this.Gx_BScreen=0;this.A186EscDescrip="";this.A187EscHabilitada=!1;this.A188EscRes551="";this.Events={e120g2_client:["AFTER TRN",!0],e130g14_client:["ENTER",!0],e140g14_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}],[{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}]];this.EvtParms.REFRESH=[[{av:"A188EscRes551",fld:"ESCRES551",pic:"@!"},{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}],[{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}]];this.EvtParms["AFTER TRN"]=[[{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}],[{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}]];this.EvtParms.VALID_ESCCOD=[[{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}],[{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}]];this.EvtParms.VALID_CLICOD=[[{av:"A188EscRes551",fld:"ESCRES551",pic:"@!"},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A49EscCod",fld:"ESCCOD",pic:""},{av:"Gx_BScreen",fld:"vGXBSCREEN",pic:"9"},{av:"Gx_mode",fld:"vMODE",pic:"@!"},{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}],[{av:"A186EscDescrip",fld:"ESCDESCRIP",pic:"@!"},{av:"A188EscRes551",fld:"ESCRES551",pic:"@!"},{av:"Gx_mode",fld:"vMODE",pic:"@!"},{av:"Z3CliCod"},{av:"Z49EscCod"},{av:"Z186EscDescrip"},{av:"Z187EscHabilitada"},{av:"Z188EscRes551"},{ctrl:"BTNTRN_DELETE",prop:"Enabled"},{ctrl:"BTNTRN_ENTER",prop:"Enabled"},{av:"A187EscHabilitada",fld:"ESCHABILITADA",pic:""}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("Gx_BScreen","vGXBSCREEN",0,"int",1,0);this.setVCMap("A188EscRes551","ESCRES551",0,"svchar",20,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.escolaridad)})