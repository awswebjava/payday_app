gx.evt.autoSkip=!1;gx.define("perfil",!1,function(){var n,t;this.ServerClass="perfil";this.PackageName="web";this.ServerFullClass="web.perfil";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7PerfilId=gx.fn.getIntegerValue("vPERFILID",gx.thousandSeparator);this.AV13Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Perfilid=function(){return this.validCliEvt("Valid_Perfilid",0,function(){try{var n=gx.util.balloon.getNew("PERFILID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e125u2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e135u254_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e145u254_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,33,34,35,36,37,38,39];this.GXLastCtrlId=39;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Perfilid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERFILID",fmt:0,gxz:"Z1925PerfilId",gxold:"O1925PerfilId",gxvar:"A1925PerfilId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1925PerfilId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1925PerfilId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PERFILID",gx.O.A1925PerfilId,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1925PerfilId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PERFILID",gx.thousandSeparator)},nac:function(){return!(0==this.AV7PerfilId)}};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERFILNOMBRE",fmt:0,gxz:"Z1926PerfilNombre",gxold:"O1926PerfilNombre",gxvar:"A1926PerfilNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1926PerfilNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z1926PerfilNombre=n)},v2c:function(){gx.fn.setControlValue("PERFILNOMBRE",gx.O.A1926PerfilNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1926PerfilNombre=this.val())},val:function(){return gx.fn.getControlValue("PERFILNOMBRE")},nac:gx.falseFn};this.declareDomainHdlr(27,function(){});n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"BTNTRN_ENTER",grid:0,evt:"e135u254_client",std:"ENTER"};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"BTNTRN_CANCEL",grid:0,evt:"e145u254_client"};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"BTNTRN_DELETE",grid:0,evt:"e155u254_client",std:"DELETE"};this.A1925PerfilId=0;this.Z1925PerfilId=0;this.O1925PerfilId=0;this.A1926PerfilNombre="";this.Z1926PerfilNombre="";this.O1926PerfilNombre="";this.AV8WWPContext={UserId:0,UserName:""};this.AV9IsAuthorized=!1;this.AV13Pgmname="";this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7PerfilId=0;this.AV12WebSession={};this.A1925PerfilId=0;this.A1926PerfilNombre="";this.Gx_mode="";this.Events={e125u2_client:["AFTER TRN",!0],e135u254_client:["ENTER",!0],e145u254_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7PerfilId",fld:"vPERFILID",pic:"Z9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7PerfilId",fld:"vPERFILID",pic:"Z9",hsh:!0}],[]];this.EvtParms["AFTER TRN"]=[[],[]];this.EvtParms.VALID_PERFILID=[[],[]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7PerfilId","vPERFILID",0,"int",2,0);this.setVCMap("AV13Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.perfil)})