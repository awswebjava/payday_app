gx.evt.autoSkip=!1;gx.define("siniestrado",!1,function(){var n,t;this.ServerClass="siniestrado";this.PackageName="web";this.ServerFullClass="web.siniestrado";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A688SinieDescriSinAc=gx.fn.getControlValue("SINIEDESCRISINAC");this.AV7SinieCodigo=gx.fn.getControlValue("vSINIECODIGO");this.A1514SinieEsIncap=gx.fn.getControlValue("SINIEESINCAP");this.AV18Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Siniecodigo=function(){return this.validCliEvt("Valid_Siniecodigo",0,function(){try{var n=gx.util.balloon.getNew("SINIECODIGO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Siniedescri=function(){return this.validSrvEvt("valid_Siniedescri",0).then(function(n){return n}.closure(this))};this.e121c2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e131c45_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e141c45_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,15,16,17,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39];this.GXLastCtrlId=39;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,18,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"TABLECONTENT",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[20]={id:20,fld:"TABLEATTRIBUTES",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,lvl:0,type:"char",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Siniecodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINIECODIGO",fmt:0,gxz:"Z19SinieCodigo",gxold:"O19SinieCodigo",gxvar:"A19SinieCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A19SinieCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z19SinieCodigo=n)},v2c:function(){gx.fn.setControlValue("SINIECODIGO",gx.O.A19SinieCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.A19SinieCodigo=this.val())},val:function(){return gx.fn.getControlValue("SINIECODIGO")},nac:function(){return!(gx.text.compare("",this.AV7SinieCodigo)==0)}};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:this.Valid_Siniedescri,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SINIEDESCRI",fmt:0,gxz:"Z333SinieDescri",gxold:"O333SinieDescri",gxvar:"A333SinieDescri",ucs:[],op:[],ip:[30],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A333SinieDescri=n)},v2z:function(n){n!==undefined&&(gx.O.Z333SinieDescri=n)},v2c:function(){gx.fn.setControlValue("SINIEDESCRI",gx.O.A333SinieDescri,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A333SinieDescri=this.val())},val:function(){return gx.fn.getControlValue("SINIEDESCRI")},nac:gx.falseFn};this.declareDomainHdlr(30,function(){});n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"BTNTRN_ENTER",grid:0,evt:"e131c45_client",std:"ENTER"};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"BTNTRN_CANCEL",grid:0,evt:"e141c45_client"};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"BTNTRN_DELETE",grid:0,evt:"e151c45_client",std:"DELETE"};this.A19SinieCodigo="";this.Z19SinieCodigo="";this.O19SinieCodigo="";this.A333SinieDescri="";this.Z333SinieDescri="";this.O333SinieDescri="";this.AV8WWPContext={UserId:0,UserName:""};this.AV13IsAuthorized=!1;this.AV18Pgmname="";this.AV9TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7SinieCodigo="";this.AV10WebSession={};this.A19SinieCodigo="";this.A688SinieDescriSinAc="";this.A333SinieDescri="";this.A1514SinieEsIncap=!1;this.Gx_mode="";this.Events={e121c2_client:["AFTER TRN",!0],e131c45_client:["ENTER",!0],e141c45_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7SinieCodigo",fld:"vSINIECODIGO",pic:"",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7SinieCodigo",fld:"vSINIECODIGO",pic:"",hsh:!0},{av:"A1514SinieEsIncap",fld:"SINIEESINCAP",pic:""}],[]];this.EvtParms["AFTER TRN"]=[[],[]];this.EvtParms.VALID_SINIECODIGO=[[],[]];this.EvtParms.VALID_SINIEDESCRI=[[{av:"A333SinieDescri",fld:"SINIEDESCRI",pic:""},{av:"A688SinieDescriSinAc",fld:"SINIEDESCRISINAC",pic:""}],[{av:"A688SinieDescriSinAc",fld:"SINIEDESCRISINAC",pic:""}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("A688SinieDescriSinAc","SINIEDESCRISINAC",0,"svchar",400,0);this.setVCMap("AV7SinieCodigo","vSINIECODIGO",0,"char",4,0);this.setVCMap("A1514SinieEsIncap","SINIEESINCAP",0,"boolean",4,0);this.setVCMap("AV18Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize()});gx.wi(function(){gx.createParentObj(this.siniestrado)})