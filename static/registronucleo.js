gx.evt.autoSkip=!1;gx.define("registronucleo",!1,function(){var n,t,i;this.ServerClass="registronucleo";this.PackageName="web";this.ServerFullClass="web.registronucleo";this.setObjectType("web");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7SecUser=gx.fn.getControlValue("vSECUSER");this.AV25SecPaiCod=gx.fn.getControlValue("vSECPAICOD");this.AV17TrnMode=gx.fn.getControlValue("vTRNMODE");this.AV49Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV27terminoInicializacion=gx.fn.getControlValue("vTERMINOINICIALIZACION");this.AV19CheckRequiredFieldsResult=gx.fn.getControlValue("vCHECKREQUIREDFIELDSRESULT");this.A747ClienteSistema=gx.fn.getControlValue("CLIENTESISTEMA");this.A4CliPaiCod=gx.fn.getIntegerValue("CLIPAICOD",gx.thousandSeparator);this.AV26hay=gx.fn.getControlValue("vHAY");this.AV24SecUserEmpNom=gx.fn.getControlValue("vSECUSEREMPNOM");this.AV16Messages=gx.fn.getControlValue("vMESSAGES");this.AV21SecUserId=gx.fn.getIntegerValue("vSECUSERID",gx.thousandSeparator)};this.Validv_Gxv3=function(){return this.validCliEvt("Validv_Gxv3",0,function(){try{var n=gx.util.balloon.getNew("SECUSER_SECUSERNAME");if(this.AnyError=0,!gx.util.regExp.isMatch(this.GXV3,"(?:[a-z0-9!#$%&'*+/=?^_{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))try{n.setError(gx.text.format(gx.getMessage("Debe ser una dirección de correo válida"),gx.getMessage("Usuario"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Validv_Paicod=function(){return this.validCliEvt("Validv_Paicod",0,function(){try{var n=gx.util.balloon.getNew("vPAICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s112_client=function(){for(this.AV50GXV8=gx.num.trunc(1,0);this.AV50GXV8<=this.AV16Messages.length;)this.AV15Message=this.AV16Messages[this.AV50GXV8-1],this.addMessage(this.AV15Message.Description),this.AV50GXV8=gx.num.trunc(this.AV50GXV8+1,0)};this.s122_client=function(){gx.text.compare(this.AV17TrnMode,"DSP")!=0||gx.fn.setCtrlProperty("BTNENTER","Visible",!1)};this.e11g91_client=function(){return this.clearMessages(),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14g92_client=function(){return this.executeServerEvent("'DOVOLVER'",!0,null,!1,!1)};this.e15g92_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17g91_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,21,22,23,24,25,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108];this.GXLastCtrlId=108;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,26,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","DVBootstrapResponsivePanel","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);this.DVPANEL_PANELEMP1Container=gx.uc.getNew(this,61,33,"BootstrapPanel","DVPANEL_PANELEMP1Container","Dvpanel_panelemp1","DVPANEL_PANELEMP1");i=this.DVPANEL_PANELEMP1Container;i.setProp("Class","Class","","char");i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Width","Width","100%","str");i.setProp("Height","Height","100","str");i.setProp("AutoWidth","Autowidth",!1,"bool");i.setProp("AutoHeight","Autoheight",!0,"bool");i.setProp("Cls","Cls","DVBootstrapResponsivePanel","str");i.setProp("ShowHeader","Showheader",!0,"bool");i.setProp("Title","Title",gx.getMessage("Empresa Principal"),"str");i.setProp("Collapsible","Collapsible",!1,"bool");i.setProp("Collapsed","Collapsed",!1,"bool");i.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");i.setProp("IconPosition","Iconposition","Right","str");i.setProp("AutoScroll","Autoscroll",!1,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});this.setUserControl(i);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEHEADER",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"TABLEHEADERCONTENT",grid:0};n[12]={id:12,fld:"",grid:0};n[13]={id:13,fld:"TABLEACTIONS",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"VOLVER",grid:0,evt:"e14g92_client"};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"TABLECONTENT",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[28]={id:28,fld:"TABLEATTRIBUTES",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECUSER_SECUSERPERNAME",fmt:0,gxz:"ZV42GXV1",gxold:"OV42GXV1",gxvar:"GXV1",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV1=n)},v2z:function(n){n!==undefined&&(gx.O.ZV42GXV1=n)},v2c:function(){gx.fn.setControlValue("SECUSER_SECUSERPERNAME",gx.O.GXV1,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV1=this.val())},val:function(){return gx.fn.getControlValue("SECUSER_SECUSERPERNAME")},nac:gx.falseFn};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECUSER_SECUSERPERLASTNAME",fmt:0,gxz:"ZV43GXV2",gxold:"OV43GXV2",gxvar:"GXV2",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV2=n)},v2z:function(n){n!==undefined&&(gx.O.ZV43GXV2=n)},v2c:function(){gx.fn.setControlValue("SECUSER_SECUSERPERLASTNAME",gx.O.GXV2,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV2=this.val())},val:function(){return gx.fn.getControlValue("SECUSER_SECUSERPERLASTNAME")},nac:gx.falseFn};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"svchar",len:100,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Validv_Gxv3,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECUSER_SECUSERNAME",fmt:0,gxz:"ZV44GXV3",gxold:"OV44GXV3",gxvar:"GXV3",ucs:[],op:[],ip:[43],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV3=n)},v2z:function(n){n!==undefined&&(gx.O.ZV44GXV3=n)},v2c:function(){gx.fn.setControlValue("SECUSER_SECUSERNAME",gx.O.GXV3,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV3=this.val())},val:function(){return gx.fn.getControlValue("SECUSER_SECUSERNAME")},nac:gx.falseFn};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECUSER_SECUSERPASSWORD",fmt:0,gxz:"ZV45GXV4",gxold:"OV45GXV4",gxvar:"GXV4",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV4=n)},v2z:function(n){n!==undefined&&(gx.O.ZV45GXV4=n)},v2c:function(){gx.fn.setControlValue("SECUSER_SECUSERPASSWORD",gx.O.GXV4,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV4=this.val())},val:function(){return gx.fn.getControlValue("SECUSER_SECUSERPASSWORD")},nac:gx.falseFn};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSECUSERPASSWORD",fmt:0,gxz:"ZV11SecUserPassword",gxold:"OV11SecUserPassword",gxvar:"AV11SecUserPassword",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV11SecUserPassword=n)},v2z:function(n){n!==undefined&&(gx.O.ZV11SecUserPassword=n)},v2c:function(){gx.fn.setControlValue("vSECUSERPASSWORD",gx.O.AV11SecUserPassword,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV11SecUserPassword=this.val())},val:function(){return gx.fn.getControlValue("vSECUSERPASSWORD")},nac:gx.falseFn};n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,lvl:0,type:"char",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vMULTIEMPRESA",fmt:0,gxz:"ZV12MultiEmpresa",gxold:"OV12MultiEmpresa",gxvar:"AV12MultiEmpresa",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.AV12MultiEmpresa=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12MultiEmpresa=n)},v2c:function(){gx.fn.setComboBoxValue("vMULTIEMPRESA",gx.O.AV12MultiEmpresa)},c2v:function(){this.val()!==undefined&&(gx.O.AV12MultiEmpresa=this.val())},val:function(){return gx.fn.getControlValue("vMULTIEMPRESA")},nac:gx.falseFn};n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"",grid:0};n[63]={id:63,fld:"PANELEMP1",grid:0};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"",grid:0};n[68]={id:68,lvl:0,type:"svchar",len:40,dec:0,sign:!1,pic:"@!",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECUSER_SECUSEREMPNOM",fmt:0,gxz:"ZV46GXV5",gxold:"OV46GXV5",gxvar:"GXV5",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV5=n)},v2z:function(n){n!==undefined&&(gx.O.ZV46GXV5=n)},v2c:function(){gx.fn.setControlValue("SECUSER_SECUSEREMPNOM",gx.O.GXV5,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV5=this.val())},val:function(){return gx.fn.getControlValue("SECUSER_SECUSEREMPNOM")},nac:gx.falseFn};n[69]={id:69,fld:"",grid:0};n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"",grid:0};n[72]={id:72,fld:"",grid:0};n[73]={id:73,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZ-ZZZZZZZZ-9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vSECUSEREMPCUIT",fmt:0,gxz:"ZV8SecUserEmpCuit",gxold:"OV8SecUserEmpCuit",gxvar:"AV8SecUserEmpCuit",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV8SecUserEmpCuit=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV8SecUserEmpCuit=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vSECUSEREMPCUIT",gx.O.AV8SecUserEmpCuit,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV8SecUserEmpCuit=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vSECUSEREMPCUIT",gx.thousandSeparator)},nac:gx.falseFn};n[74]={id:74,fld:"",grid:0};n[75]={id:75,fld:"",grid:0};n[76]={id:76,fld:"",grid:0};n[77]={id:77,fld:"",grid:0};n[78]={id:78,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vACTCOMCODIGO",fmt:0,gxz:"ZV29ActComCodigo",gxold:"OV29ActComCodigo",gxvar:"AV29ActComCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.AV29ActComCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.ZV29ActComCodigo=n)},v2c:function(){gx.fn.setComboBoxValue("vACTCOMCODIGO",gx.O.AV29ActComCodigo)},c2v:function(){this.val()!==undefined&&(gx.O.AV29ActComCodigo=this.val())},val:function(){return gx.fn.getControlValue("vACTCOMCODIGO")},nac:gx.falseFn};n[79]={id:79,fld:"",grid:0};n[80]={id:80,fld:"",grid:0};n[81]={id:81,fld:"",grid:0};n[82]={id:82,fld:"",grid:0};n[83]={id:83,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vNUCLEOES",fmt:0,gxz:"ZV33nucleoEs",gxold:"OV33nucleoEs",gxvar:"AV33nucleoEs",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.AV33nucleoEs=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV33nucleoEs=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("vNUCLEOES",gx.O.AV33nucleoEs,!0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV33nucleoEs=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("vNUCLEOES")},nac:gx.falseFn,values:["true","false"]};this.declareDomainHdlr(83,function(){});n[84]={id:84,fld:"",grid:0};n[85]={id:85,fld:"",grid:0};n[86]={id:86,fld:"",grid:0};n[87]={id:87,fld:"",grid:0};n[88]={id:88,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Validv_Paicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vPAICOD",fmt:0,gxz:"ZV35PaiCod",gxold:"OV35PaiCod",gxvar:"AV35PaiCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV35PaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV35PaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vPAICOD",gx.O.AV35PaiCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV35PaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vPAICOD",gx.thousandSeparator)},nac:gx.falseFn};n[89]={id:89,fld:"",grid:0};n[90]={id:90,fld:"",grid:0};n[91]={id:91,fld:"",grid:0};n[92]={id:92,fld:"",grid:0};n[93]={id:93,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCONVENIADORES",fmt:0,gxz:"ZV34conveniadorEs",gxold:"OV34conveniadorEs",gxvar:"AV34conveniadorEs",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.AV34conveniadorEs=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV34conveniadorEs=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("vCONVENIADORES",gx.O.AV34conveniadorEs,!0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.AV34conveniadorEs=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("vCONVENIADORES")},nac:gx.falseFn,values:["true","false"]};this.declareDomainHdlr(93,function(){});n[94]={id:94,fld:"",grid:0};n[95]={id:95,fld:"",grid:0};n[96]={id:96,fld:"",grid:0};n[97]={id:97,fld:"",grid:0};n[98]={id:98,fld:"BTNENTER",grid:0,evt:"e15g92_client",std:"ENTER"};n[99]={id:99,fld:"",grid:0};n[100]={id:100,fld:"BTNCANCEL",grid:0,evt:"e17g91_client"};n[101]={id:101,fld:"",grid:0};n[102]={id:102,fld:"BTNTEST",grid:0,evt:"e11g91_client"};n[103]={id:103,fld:"",grid:0};n[104]={id:104,fld:"",grid:0};n[105]={id:105,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[106]={id:106,lvl:0,type:"char",len:8,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vACTCODIGO",fmt:0,gxz:"ZV10ActCodigo",gxold:"OV10ActCodigo",gxvar:"AV10ActCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV10ActCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.ZV10ActCodigo=n)},v2c:function(){gx.fn.setControlValue("vACTCODIGO",gx.O.AV10ActCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV10ActCodigo=this.val())},val:function(){return gx.fn.getControlValue("vACTCODIGO")},nac:gx.falseFn};n[107]={id:107,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECUSER_SECUSERID",fmt:0,gxz:"ZV47GXV6",gxold:"OV47GXV6",gxvar:"GXV6",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV6=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV47GXV6=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("SECUSER_SECUSERID",gx.O.GXV6,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV6=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SECUSER_SECUSERID",gx.thousandSeparator)},nac:gx.falseFn};n[108]={id:108,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECPAICOD_SECUSERPAICOD",fmt:0,gxz:"ZV48GXV7",gxold:"OV48GXV7",gxvar:"GXV7",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV7=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV48GXV7=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("SECPAICOD_SECUSERPAICOD",gx.O.GXV7,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV7=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SECPAICOD_SECUSERPAICOD",gx.thousandSeparator)},nac:gx.falseFn};this.GXV1="";this.ZV42GXV1="";this.OV42GXV1="";this.GXV2="";this.ZV43GXV2="";this.OV43GXV2="";this.GXV3="";this.ZV44GXV3="";this.OV44GXV3="";this.GXV4="";this.ZV45GXV4="";this.OV45GXV4="";this.AV11SecUserPassword="";this.ZV11SecUserPassword="";this.OV11SecUserPassword="";this.AV12MultiEmpresa="";this.ZV12MultiEmpresa="";this.OV12MultiEmpresa="";this.GXV5="";this.ZV46GXV5="";this.OV46GXV5="";this.AV8SecUserEmpCuit=0;this.ZV8SecUserEmpCuit=0;this.OV8SecUserEmpCuit=0;this.AV29ActComCodigo="";this.ZV29ActComCodigo="";this.OV29ActComCodigo="";this.AV33nucleoEs=!1;this.ZV33nucleoEs=!1;this.OV33nucleoEs=!1;this.AV35PaiCod=0;this.ZV35PaiCod=0;this.OV35PaiCod=0;this.AV34conveniadorEs=!1;this.ZV34conveniadorEs=!1;this.OV34conveniadorEs=!1;this.AV10ActCodigo="";this.ZV10ActCodigo="";this.OV10ActCodigo="";this.GXV6=0;this.ZV47GXV6=0;this.OV47GXV6=0;this.GXV7=0;this.ZV48GXV7=0;this.OV48GXV7=0;this.GXV1="";this.GXV2="";this.GXV3="";this.GXV4="";this.AV11SecUserPassword="";this.AV12MultiEmpresa="";this.GXV5="";this.AV8SecUserEmpCuit=0;this.AV29ActComCodigo="";this.AV33nucleoEs=!1;this.AV35PaiCod=0;this.AV34conveniadorEs=!1;this.AV10ActCodigo="";this.GXV6=0;this.GXV7=0;this.AV17TrnMode="";this.AV21SecUserId=0;this.A4CliPaiCod=0;this.A747ClienteSistema=!1;this.AV49Pgmname="";this.AV27terminoInicializacion="";this.AV7SecUser={SecUserId:0,SecUserName:"",SecUserPassword:"",CliCod:0,SecUserEmpNom:"",SecUsuActivo:!1,SecUserPerName:"",SecUserPerLastName:"",SecUserEmpCuit:0,SecUserTipEmpl:"",SecUserPaiCod:0,RolId:0,PerfilId:0,MenuVerId:0,RolNombre:"",SecUserSal:""};this.AV19CheckRequiredFieldsResult=!1;this.AV26hay=!1;this.AV24SecUserEmpNom="";this.AV22httpRequest={};this.AV16Messages=[];this.AV15Message={Id:"",Type:0,Description:""};this.AV50GXV8=0;this.AV25SecPaiCod={SecUserId:0,SecUserName:"",SecUserPassword:"",CliCod:0,SecUserEmpNom:"",SecUsuActivo:!1,SecUserPerName:"",SecUserPerLastName:"",SecUserEmpCuit:0,SecUserTipEmpl:"",SecUserPaiCod:0,RolId:0,PerfilId:0,MenuVerId:0,RolNombre:"",SecUserSal:""};this.Events={e14g92_client:["'DOVOLVER'",!0],e15g92_client:["ENTER",!0],e17g91_client:["CANCEL",!0],e11g91_client:["'DOTEST'",!1]};this.EvtParms.REFRESH=[[{ctrl:"vACTCOMCODIGO"},{av:"AV29ActComCodigo",fld:"vACTCOMCODIGO",pic:""},{av:"AV33nucleoEs",fld:"vNUCLEOES",pic:""},{av:"AV34conveniadorEs",fld:"vCONVENIADORES",pic:""},{av:"AV17TrnMode",fld:"vTRNMODE",pic:"",hsh:!0},{av:"AV49Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV26hay",fld:"vHAY",pic:"",hsh:!0},{av:"AV24SecUserEmpNom",fld:"vSECUSEREMPNOM",pic:"@!",hsh:!0},{av:"AV21SecUserId",fld:"vSECUSERID",pic:"ZZZ9",hsh:!0}],[{ctrl:"BTNENTER",prop:"Visible"}]];this.EvtParms["'DOTEST'"]=[[],[]];this.EvtParms["'DOVOLVER'"]=[[],[]];this.EvtParms.ENTER=[[{av:"AV49Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV27terminoInicializacion",fld:"vTERMINOINICIALIZACION",pic:""},{av:"AV7SecUser",fld:"vSECUSER",pic:""},{av:"AV17TrnMode",fld:"vTRNMODE",pic:"",hsh:!0},{av:"AV19CheckRequiredFieldsResult",fld:"vCHECKREQUIREDFIELDSRESULT",pic:""},{ctrl:"vACTCOMCODIGO"},{av:"AV29ActComCodigo",fld:"vACTCOMCODIGO",pic:""},{av:"A747ClienteSistema",fld:"CLIENTESISTEMA",pic:""},{av:"AV35PaiCod",fld:"vPAICOD",pic:"ZZZ9"},{av:"AV33nucleoEs",fld:"vNUCLEOES",pic:""},{av:"A4CliPaiCod",fld:"CLIPAICOD",pic:"ZZZ9"},{ctrl:"vMULTIEMPRESA"},{av:"AV12MultiEmpresa",fld:"vMULTIEMPRESA",pic:""},{av:"AV26hay",fld:"vHAY",pic:"",hsh:!0},{av:"AV34conveniadorEs",fld:"vCONVENIADORES",pic:""},{av:"AV24SecUserEmpNom",fld:"vSECUSEREMPNOM",pic:"@!",hsh:!0},{av:"AV8SecUserEmpCuit",fld:"vSECUSEREMPCUIT",pic:"ZZ-ZZZZZZZZ-9"},{av:"AV10ActCodigo",fld:"vACTCODIGO",pic:""},{av:"this.AV22httpRequest.Baseurl",ctrl:"vHTTPREQUEST",prop:"Baseurl"},{av:"AV16Messages",fld:"vMESSAGES",pic:""}],[{av:"AV27terminoInicializacion",fld:"vTERMINOINICIALIZACION",pic:""},{av:"AV7SecUser",fld:"vSECUSER",pic:""},{av:"AV16Messages",fld:"vMESSAGES",pic:""},{av:"AV19CheckRequiredFieldsResult",fld:"vCHECKREQUIREDFIELDSRESULT",pic:""}]];this.EvtParms.VALIDV_GXV3=[[],[]];this.EvtParms.VALIDV_PAICOD=[[],[]];this.EnterCtrl=["BTNENTER"];this.setVCMap("AV7SecUser","vSECUSER",0,"WWPBaseObjectsSecUser",0,0);this.setVCMap("AV25SecPaiCod","vSECPAICOD",0,"WWPBaseObjectsSecUser",0,0);this.setVCMap("AV7SecUser","vSECUSER",0,"WWPBaseObjectsSecUser",0,0);this.setVCMap("AV25SecPaiCod","vSECPAICOD",0,"WWPBaseObjectsSecUser",0,0);this.setVCMap("AV7SecUser","vSECUSER",0,"WWPBaseObjectsSecUser",0,0);this.setVCMap("AV25SecPaiCod","vSECPAICOD",0,"WWPBaseObjectsSecUser",0,0);this.setVCMap("AV17TrnMode","vTRNMODE",0,"char",3,0);this.setVCMap("AV49Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV27terminoInicializacion","vTERMINOINICIALIZACION",0,"char",1,0);this.setVCMap("AV19CheckRequiredFieldsResult","vCHECKREQUIREDFIELDSRESULT",0,"boolean",4,0);this.setVCMap("A747ClienteSistema","CLIENTESISTEMA",0,"boolean",20,0);this.setVCMap("A4CliPaiCod","CLIPAICOD",0,"int",4,0);this.setVCMap("AV26hay","vHAY",0,"boolean",4,0);this.setVCMap("AV24SecUserEmpNom","vSECUSEREMPNOM",0,"svchar",40,0);this.setVCMap("AV16Messages","vMESSAGES",0,"CollGeneXusCommonMessages.Message",0,0);this.setVCMap("AV21SecUserId","vSECUSERID",0,"int",4,0);this.addBCProperty("Secuser",["SecUserPerName"],this.GXValidFnc[33],"AV7SecUser");this.addBCProperty("Secuser",["SecUserPerLastName"],this.GXValidFnc[38],"AV7SecUser");this.addBCProperty("Secuser",["SecUserName"],this.GXValidFnc[43],"AV7SecUser");this.addBCProperty("Secuser",["SecUserPassword"],this.GXValidFnc[48],"AV7SecUser");this.addBCProperty("Secuser",["SecUserEmpNom"],this.GXValidFnc[68],"AV7SecUser");this.addBCProperty("Secuser",["SecUserId"],this.GXValidFnc[107],"AV7SecUser");this.addBCProperty("Secpaicod",["SecUserPaiCod"],this.GXValidFnc[108],"AV25SecPaiCod");this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}})});gx.wi(function(){gx.createParentObj(this.registronucleo)})