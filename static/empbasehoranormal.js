gx.evt.autoSkip=!1;gx.define("empbasehoranormal",!1,function(){var n,t;this.ServerClass="empbasehoranormal";this.PackageName="web";this.ServerFullClass="web.empbasehoranormal";this.setObjectType("web");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV12Empresabase_calculo=gx.fn.getControlValue("vEMPRESABASE_CALCULO");this.AV18TrnMode=gx.fn.getControlValue("vTRNMODE");this.AV20CheckRequiredFieldsResult=gx.fn.getControlValue("vCHECKREQUIREDFIELDSRESULT");this.AV17Messages=gx.fn.getControlValue("vMESSAGES");this.AV28MenuOpcCod=gx.fn.getControlValue("vMENUOPCCOD");this.AV22CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV23EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV24EmpBaseClaseLeg=gx.fn.getIntegerValue("vEMPBASECLASELEG",gx.thousandSeparator);this.AV25EmpBaseTipo=gx.fn.getControlValue("vEMPBASETIPO");this.AV26EmpBaseCod1=gx.fn.getControlValue("vEMPBASECOD1");this.AV27EmpBaseCod2=gx.fn.getControlValue("vEMPBASECOD2")};this.Validv_Gxv1=function(){return this.validCliEvt("Validv_Gxv1",0,function(){try{var n=gx.util.balloon.getNew("EMPRESABASE_CALCULO_EMPBASECLASELEG");if(this.AnyError=0,!(this.GXV1==1||this.GXV1==2||this.GXV1==3||this.GXV1==4))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Clase de legajo"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Validv_Gxv2=function(){return this.validCliEvt("Validv_Gxv2",0,function(){try{var n=gx.util.balloon.getNew("EMPRESABASE_CALCULO_EMPBASETIPO");if(this.AnyError=0,!(gx.text.compare(this.GXV2,"licencia")==0||gx.text.compare(this.GXV2,"feriado")==0||gx.text.compare(this.GXV2,"horaNormal")==0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Tipo"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Validv_Gxv5=function(){return this.validCliEvt("Validv_Gxv5",0,function(){try{var n=gx.util.balloon.getNew("EMPRESABASE_CALCULO_EMPBASEPROMTCNT");if(this.AnyError=0,!(gx.text.compare(this.GXV5,"dias")==0||gx.text.compare(this.GXV5,"meses")==0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Días o Meses"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s112_client=function(){for(this.AV41GXV10=gx.num.trunc(1,0);this.AV41GXV10<=this.AV17Messages.length;)this.AV16Message=this.AV17Messages[this.AV41GXV10-1],this.addMessage(this.AV16Message.Description),this.AV41GXV10=gx.num.trunc(this.AV41GXV10+1,0)};this.s122_client=function(){gx.text.compare(this.AV18TrnMode,"DSP")!=0||gx.fn.setCtrlProperty("BTNENTER","Visible",!1)};this.s132_client=function(){this.AV20CheckRequiredFieldsResult=!0};this.e11of1_client=function(){return this.clearMessages(),gx.fn.setCtrlProperty("WELCOMEMESSAGE_WELCOMETABLEPARENT","Visible",!1),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("WELCOMEMESSAGE_WELCOMETABLEPARENT","Visible")',ctrl:"WELCOMEMESSAGE_WELCOMETABLEPARENT",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e14of2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e15of2_client=function(){return this.executeServerEvent("VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",!0,null,!1,!0)};this.e17of1_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,27,28,29,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,49,50,51,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,90,91,92,93,94,95,96,97,98,99,100,101];this.GXLastCtrlId=101;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,52,20,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"WELCOMEMESSAGE_WELCOMETABLEPARENT",grid:0};n[10]={id:10,fld:"WELCOMEMESSAGE_WELCOMETABLEPRINCIPAL",grid:0};n[11]={id:11,fld:"WELCOMEMESSAGE_TABLECLOSE",grid:0};n[12]={id:12,fld:"",grid:0};n[13]={id:13,fld:"WELCOMEMESSAGE_CLOSEHELP",format:1,grid:0,evt:"e11of1_client",ctrltype:"textblock"};n[14]={id:14,fld:"WELCOMEMESSAGE_WELCOMECONTENTITEM",grid:0};n[15]={id:15,fld:"WELCOMEMESSAGE_WELCOMECONTENTFLEX",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"WELCOMEMESSAGE_WELCOMETABLEIMAGEN",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,lvl:0,type:"bits",len:1024,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWELCOMEMESSAGE_FOTO",fmt:0,gxz:"ZV15WelcomeMessage_Foto",gxold:"OV15WelcomeMessage_Foto",gxvar:"AV15WelcomeMessage_Foto",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV15WelcomeMessage_Foto=n)},v2z:function(n){n!==undefined&&(gx.O.ZV15WelcomeMessage_Foto=n)},v2c:function(){gx.fn.setMultimediaValue("vWELCOMEMESSAGE_FOTO",gx.O.AV15WelcomeMessage_Foto,gx.O.AV40Welcomemessage_foto_GXI)},c2v:function(){gx.O.AV40Welcomemessage_foto_GXI=this.val_GXI();this.val()!==undefined&&(gx.O.AV15WelcomeMessage_Foto=this.val())},val:function(){return gx.fn.getBlobValue("vWELCOMEMESSAGE_FOTO")},val_GXI:function(){return gx.fn.getControlValue("vWELCOMEMESSAGE_FOTO_GXI")},gxvar_GXI:"AV40Welcomemessage_foto_GXI",nac:gx.falseFn};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"WELCOMEMESSAGE_TABLETEXTO",grid:0};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"WELCOMEMESSAGE_TABLETITULO",grid:0};n[27]={id:27,fld:"WELCOMEMESSAGE_TITULO",format:0,grid:0,ctrltype:"textblock"};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"WELCOMEMESSAGE_TABLEDESCRIPCION",grid:0};n[32]={id:32,fld:"WELCOMEMESSAGE_DESCRIPCION",format:0,grid:0,ctrltype:"textblock"};n[33]={id:33,fld:"WELCOMEMESSAGE_WELCOMEBOTTOMITEM",grid:0};n[34]={id:34,fld:"WELCOMEMESSAGE_TABLECMB",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"WELCOMEMESSAGE_TABLEC",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[39]={id:39,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vWELCOMEMESSAGE_NOMOSTRARMAS",fmt:0,gxz:"ZV14WelcomeMessage_NoMostrarMas",gxold:"OV14WelcomeMessage_NoMostrarMas",gxvar:"AV14WelcomeMessage_NoMostrarMas",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.AV14WelcomeMessage_NoMostrarMas=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV14WelcomeMessage_NoMostrarMas=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("vWELCOMEMESSAGE_NOMOSTRARMAS",gx.O.AV14WelcomeMessage_NoMostrarMas,!0)},c2v:function(){this.val()!==undefined&&(gx.O.AV14WelcomeMessage_NoMostrarMas=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("vWELCOMEMESSAGE_NOMOSTRARMAS")},nac:gx.falseFn,evt:"e15of2_client",values:["true","false"]};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"WELCOMEMESSAGE_TABLETEXT",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"WELCOMEMESSAGE_COMBOTEXT",format:0,grid:0,ctrltype:"textblock"};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"TABLEMAINFIX",grid:0};n[49]={id:49,fld:"TABLECONTENT",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[54]={id:54,fld:"TABLEATTRIBUTES",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,lvl:0,type:"svchar",len:40,dec:0,sign:!1,pic:"@!",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vEMPNOM",fmt:0,gxz:"ZV13EmpNom",gxold:"OV13EmpNom",gxvar:"AV13EmpNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV13EmpNom=n)},v2z:function(n){n!==undefined&&(gx.O.ZV13EmpNom=n)},v2c:function(){gx.fn.setControlValue("vEMPNOM",gx.O.AV13EmpNom,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV13EmpNom=this.val())},val:function(){return gx.fn.getControlValue("vEMPNOM")},nac:gx.falseFn};n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"",grid:0};n[63]={id:63,fld:"",grid:0};n[64]={id:64,lvl:0,type:"int",len:1,dec:0,sign:!1,pic:"9",ro:0,grid:0,gxgrid:null,fnc:this.Validv_Gxv1,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_EMPBASECLASELEG",fmt:0,gxz:"ZV31GXV1",gxold:"OV31GXV1",gxvar:"GXV1",ucs:[],op:[64],ip:[64],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.GXV1=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV31GXV1=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("EMPRESABASE_CALCULO_EMPBASECLASELEG",gx.O.GXV1)},c2v:function(){this.val()!==undefined&&(gx.O.GXV1=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPRESABASE_CALCULO_EMPBASECLASELEG",gx.thousandSeparator)},nac:gx.falseFn};n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"",grid:0};n[69]={id:69,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Validv_Gxv2,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_EMPBASETIPO",fmt:0,gxz:"ZV32GXV2",gxold:"OV32GXV2",gxvar:"GXV2",ucs:[],op:[69],ip:[69],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.GXV2=n)},v2z:function(n){n!==undefined&&(gx.O.ZV32GXV2=n)},v2c:function(){gx.fn.setComboBoxValue("EMPRESABASE_CALCULO_EMPBASETIPO",gx.O.GXV2)},c2v:function(){this.val()!==undefined&&(gx.O.GXV2=this.val())},val:function(){return gx.fn.getControlValue("EMPRESABASE_CALCULO_EMPBASETIPO")},nac:gx.falseFn};n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"",grid:0};n[72]={id:72,fld:"",grid:0};n[73]={id:73,fld:"",grid:0};n[74]={id:74,lvl:0,type:"int",len:3,dec:0,sign:!1,pic:"ZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_EMPBASEPROMCNT1",fmt:0,gxz:"ZV33GXV3",gxold:"OV33GXV3",gxvar:"GXV3",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV3=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV33GXV3=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPRESABASE_CALCULO_EMPBASEPROMCNT1",gx.O.GXV3,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV3=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPRESABASE_CALCULO_EMPBASEPROMCNT1",gx.thousandSeparator)},nac:gx.falseFn};n[75]={id:75,fld:"",grid:0};n[76]={id:76,fld:"",grid:0};n[77]={id:77,fld:"",grid:0};n[78]={id:78,fld:"",grid:0};n[79]={id:79,lvl:0,type:"int",len:3,dec:0,sign:!1,pic:"ZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_EMPBASEPROMCNT2",fmt:0,gxz:"ZV34GXV4",gxold:"OV34GXV4",gxvar:"GXV4",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV4=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV34GXV4=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPRESABASE_CALCULO_EMPBASEPROMCNT2",gx.O.GXV4,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV4=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPRESABASE_CALCULO_EMPBASEPROMCNT2",gx.thousandSeparator)},nac:gx.falseFn};n[80]={id:80,fld:"",grid:0};n[81]={id:81,fld:"",grid:0};n[82]={id:82,fld:"",grid:0};n[83]={id:83,fld:"",grid:0};n[84]={id:84,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Validv_Gxv5,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_EMPBASEPROMTCNT",fmt:0,gxz:"ZV35GXV5",gxold:"OV35GXV5",gxvar:"GXV5",ucs:[],op:[84],ip:[84],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.GXV5=n)},v2z:function(n){n!==undefined&&(gx.O.ZV35GXV5=n)},v2c:function(){gx.fn.setComboBoxValue("EMPRESABASE_CALCULO_EMPBASEPROMTCNT",gx.O.GXV5)},c2v:function(){this.val()!==undefined&&(gx.O.GXV5=this.val())},val:function(){return gx.fn.getControlValue("EMPRESABASE_CALCULO_EMPBASEPROMTCNT")},nac:gx.falseFn};n[90]={id:90,fld:"",grid:0};n[91]={id:91,fld:"",grid:0};n[92]={id:92,fld:"BTNENTER",grid:0,evt:"e14of2_client",std:"ENTER"};n[93]={id:93,fld:"",grid:0};n[94]={id:94,fld:"BTNCANCEL",grid:0,evt:"e17of1_client"};n[95]={id:95,fld:"",grid:0};n[96]={id:96,fld:"",grid:0};n[97]={id:97,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[98]={id:98,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_CLICOD",fmt:0,gxz:"ZV36GXV6",gxold:"OV36GXV6",gxvar:"GXV6",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV6=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV36GXV6=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPRESABASE_CALCULO_CLICOD",gx.O.GXV6,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV6=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPRESABASE_CALCULO_CLICOD",gx.thousandSeparator)},nac:gx.falseFn};n[99]={id:99,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_EMPCOD",fmt:0,gxz:"ZV37GXV7",gxold:"OV37GXV7",gxvar:"GXV7",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV7=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV37GXV7=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPRESABASE_CALCULO_EMPCOD",gx.O.GXV7,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV7=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPRESABASE_CALCULO_EMPCOD",gx.thousandSeparator)},nac:gx.falseFn};n[100]={id:100,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_EMPBASECOD1",fmt:0,gxz:"ZV38GXV8",gxold:"OV38GXV8",gxvar:"GXV8",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV8=n)},v2z:function(n){n!==undefined&&(gx.O.ZV38GXV8=n)},v2c:function(){gx.fn.setControlValue("EMPRESABASE_CALCULO_EMPBASECOD1",gx.O.GXV8,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV8=this.val())},val:function(){return gx.fn.getControlValue("EMPRESABASE_CALCULO_EMPBASECOD1")},nac:gx.falseFn};n[101]={id:101,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPRESABASE_CALCULO_EMPBASECOD2",fmt:0,gxz:"ZV39GXV9",gxold:"OV39GXV9",gxvar:"GXV9",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV9=n)},v2z:function(n){n!==undefined&&(gx.O.ZV39GXV9=n)},v2c:function(){gx.fn.setControlValue("EMPRESABASE_CALCULO_EMPBASECOD2",gx.O.GXV9,0)},c2v:function(){this.val()!==undefined&&(gx.O.GXV9=this.val())},val:function(){return gx.fn.getControlValue("EMPRESABASE_CALCULO_EMPBASECOD2")},nac:gx.falseFn};this.AV40Welcomemessage_foto_GXI="";this.AV15WelcomeMessage_Foto="";this.ZV15WelcomeMessage_Foto="";this.OV15WelcomeMessage_Foto="";this.AV14WelcomeMessage_NoMostrarMas=!1;this.ZV14WelcomeMessage_NoMostrarMas=!1;this.OV14WelcomeMessage_NoMostrarMas=!1;this.AV13EmpNom="";this.ZV13EmpNom="";this.OV13EmpNom="";this.GXV1=0;this.ZV31GXV1=0;this.OV31GXV1=0;this.GXV2="";this.ZV32GXV2="";this.OV32GXV2="";this.GXV3=0;this.ZV33GXV3=0;this.OV33GXV3=0;this.GXV4=0;this.ZV34GXV4=0;this.OV34GXV4=0;this.GXV5="";this.ZV35GXV5="";this.OV35GXV5="";this.GXV6=0;this.ZV36GXV6=0;this.OV36GXV6=0;this.GXV7=0;this.ZV37GXV7=0;this.OV37GXV7=0;this.GXV8="";this.ZV38GXV8="";this.OV38GXV8="";this.GXV9="";this.ZV39GXV9="";this.OV39GXV9="";this.AV15WelcomeMessage_Foto="";this.AV14WelcomeMessage_NoMostrarMas=!1;this.AV13EmpNom="";this.GXV1=0;this.GXV2="";this.GXV3=0;this.GXV4=0;this.GXV5="";this.GXV6=0;this.GXV7=0;this.GXV8="";this.GXV9="";this.AV18TrnMode="";this.AV22CliCod=0;this.AV23EmpCod=0;this.AV24EmpBaseClaseLeg=0;this.AV25EmpBaseTipo="";this.AV26EmpBaseCod1="";this.AV27EmpBaseCod2="";this.AV28MenuOpcCod="";this.AV20CheckRequiredFieldsResult=!1;this.AV12Empresabase_calculo={CliCod:0,EmpCod:0,EmpBaseClaseLeg:0,EmpBaseTipo:"",EmpBaseCod1:"",EmpBaseC1Txt:"",EmpBaseCod2:"",EmpBaseC2Txt:"",EmpBasePlus:0,EmpLicDMin:0,EmpLicDLim:0,EmpLicDSeman:0,EmpLicDMes:0,EmpLicDSemes:0,EmpLicDAnual:0,EmpLicAdju:!1,EmpLicAdjuObl:!1,EmpLicNecAut:!1,EmpLicIngMot:!1,EmpLicMotObl:!1,EmpBaseOrd:0,EmpBasePromCnt1:0,EmpBasePromCnt2:0,EmpBasePromTCnt:"",EmpBaseRelSec:0};this.AV17Messages=[];this.AV16Message={Id:"",Type:0,Description:""};this.AV41GXV10=0;this.Events={e14of2_client:["ENTER",!0],e15of2_client:["VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK",!0],e17of1_client:["CANCEL",!0],e11of1_client:["WELCOMEMESSAGE_CLOSEHELP.CLICK",!1]};this.EvtParms.REFRESH=[[{av:"AV14WelcomeMessage_NoMostrarMas",fld:"vWELCOMEMESSAGE_NOMOSTRARMAS",pic:""},{av:"AV18TrnMode",fld:"vTRNMODE",pic:"",hsh:!0},{av:"AV28MenuOpcCod",fld:"vMENUOPCCOD",pic:"",hsh:!0},{av:"AV22CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV23EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV24EmpBaseClaseLeg",fld:"vEMPBASECLASELEG",pic:"9",hsh:!0},{av:"AV25EmpBaseTipo",fld:"vEMPBASETIPO",pic:"",hsh:!0},{av:"AV26EmpBaseCod1",fld:"vEMPBASECOD1",pic:"",hsh:!0},{av:"AV27EmpBaseCod2",fld:"vEMPBASECOD2",pic:"",hsh:!0}],[{ctrl:"BTNENTER",prop:"Visible"}]];this.EvtParms.ENTER=[[{av:"AV18TrnMode",fld:"vTRNMODE",pic:"",hsh:!0},{av:"AV20CheckRequiredFieldsResult",fld:"vCHECKREQUIREDFIELDSRESULT",pic:""},{av:"AV12Empresabase_calculo",fld:"vEMPRESABASE_CALCULO",pic:""},{av:"AV17Messages",fld:"vMESSAGES",pic:""}],[{av:"AV12Empresabase_calculo",fld:"vEMPRESABASE_CALCULO",pic:""},{av:"AV17Messages",fld:"vMESSAGES",pic:""},{av:"AV20CheckRequiredFieldsResult",fld:"vCHECKREQUIREDFIELDSRESULT",pic:""}]];this.EvtParms["VWELCOMEMESSAGE_NOMOSTRARMAS.CLICK"]=[[{av:"AV14WelcomeMessage_NoMostrarMas",fld:"vWELCOMEMESSAGE_NOMOSTRARMAS",pic:""},{av:"AV28MenuOpcCod",fld:"vMENUOPCCOD",pic:"",hsh:!0},{av:"AV22CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}],[{av:'gx.fn.getCtrlProperty("WELCOMEMESSAGE_COMBOTEXT","Caption")',ctrl:"WELCOMEMESSAGE_COMBOTEXT",prop:"Caption"}]];this.EvtParms["WELCOMEMESSAGE_CLOSEHELP.CLICK"]=[[],[{av:'gx.fn.getCtrlProperty("WELCOMEMESSAGE_WELCOMETABLEPARENT","Visible")',ctrl:"WELCOMEMESSAGE_WELCOMETABLEPARENT",prop:"Visible"}]];this.EvtParms.VALIDV_GXV1=[[],[]];this.EvtParms.VALIDV_GXV2=[[],[]];this.EvtParms.VALIDV_GXV5=[[],[]];this.EnterCtrl=["BTNENTER"];this.setVCMap("AV12Empresabase_calculo","vEMPRESABASE_CALCULO",0,"Empresabase_calculo",0,0);this.setVCMap("AV18TrnMode","vTRNMODE",0,"char",3,0);this.setVCMap("AV20CheckRequiredFieldsResult","vCHECKREQUIREDFIELDSRESULT",0,"boolean",4,0);this.setVCMap("AV17Messages","vMESSAGES",0,"CollGeneXusCommonMessages.Message",0,0);this.setVCMap("AV28MenuOpcCod","vMENUOPCCOD",0,"svchar",100,0);this.setVCMap("AV22CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV23EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV24EmpBaseClaseLeg","vEMPBASECLASELEG",0,"int",1,0);this.setVCMap("AV25EmpBaseTipo","vEMPBASETIPO",0,"char",20,0);this.setVCMap("AV26EmpBaseCod1","vEMPBASECOD1",0,"char",20,0);this.setVCMap("AV27EmpBaseCod2","vEMPBASECOD2",0,"char",20,0);this.addBCProperty("Empresabase_calculo",["EmpBaseClaseLeg"],this.GXValidFnc[64],"AV12Empresabase_calculo");this.addBCProperty("Empresabase_calculo",["EmpBaseTipo"],this.GXValidFnc[69],"AV12Empresabase_calculo");this.addBCProperty("Empresabase_calculo",["EmpBasePromCnt1"],this.GXValidFnc[74],"AV12Empresabase_calculo");this.addBCProperty("Empresabase_calculo",["EmpBasePromCnt2"],this.GXValidFnc[79],"AV12Empresabase_calculo");this.addBCProperty("Empresabase_calculo",["EmpBasePromTCnt"],this.GXValidFnc[84],"AV12Empresabase_calculo");this.addBCProperty("Empresabase_calculo",["CliCod"],this.GXValidFnc[98],"AV12Empresabase_calculo");this.addBCProperty("Empresabase_calculo",["EmpCod"],this.GXValidFnc[99],"AV12Empresabase_calculo");this.addBCProperty("Empresabase_calculo",["EmpBaseCod1"],this.GXValidFnc[100],"AV12Empresabase_calculo");this.addBCProperty("Empresabase_calculo",["EmpBaseCod2"],this.GXValidFnc[101],"AV12Empresabase_calculo");this.Initialize()});gx.wi(function(){gx.createParentObj(this.empbasehoranormal)})