gx.evt.autoSkip=!1;gx.define("cliente",!1,function(){var n,t,i;this.ServerClass="cliente";this.PackageName="web";this.ServerFullClass="web.cliente";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV13Insert_CliPaiCod=gx.fn.getIntegerValue("vINSERT_CLIPAICOD",gx.thousandSeparator);this.A1741ClienteTipo=gx.fn.getControlValue("CLIENTETIPO");this.A2023CliManten=gx.fn.getControlValue("CLIMANTEN");this.AV22Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clipaicod=function(){return this.validSrvEvt("valid_Clipaicod",0).then(function(n){return n}.closure(this))};this.Validv_Comboclipaicod=function(){return this.validCliEvt("Validv_Comboclipaicod",0,function(){try{var n=gx.util.balloon.getNew("vCOMBOCLIPAICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e131h49_client=function(){return this.clearMessages(),this.AV20ComboCliPaiCod=gx.num.trunc(gx.num.val(this.COMBO_CLIPAICODContainer.SelectedValue_get),0),this.refreshOutputs([{av:"AV20ComboCliPaiCod",fld:"vCOMBOCLIPAICOD",pic:"ZZZ9"},{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e121h2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e141h49_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e151h49_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,56,57,58,59,60,61,62,63,64,65,66,67,68,74,75,76,77,78,79,80,81,82,83,84,85];this.GXLastCtrlId=85;this.COMBO_CLIPAICODContainer=gx.uc.getNew(this,55,22,"BootstrapDropDownOptions","COMBO_CLIPAICODContainer","Combo_clipaicod","COMBO_CLIPAICOD");t=this.COMBO_CLIPAICODContainer;t.setProp("Class","Class","","char");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","ExtendedCombo Attribute","str");t.setDynProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setDynProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("DDOInternalName","Ddointernalname","","char");t.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");t.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");t.setDynProp("Enabled","Enabled",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");t.setProp("DataListType","Datalisttype","Dynamic","str");t.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");t.setProp("DataListFixedValues","Datalistfixedvalues","","char");t.setProp("IsGridItem","Isgriditem",!1,"bool");t.setProp("HasDescription","Hasdescription",!1,"bool");t.setProp("DataListProc","Datalistproc","ClienteLoadDVCombo","str");t.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix",' "ComboName": "CliPaiCod", "TrnMode": "INS", "IsDynamicCall": true, "CliCod": 0',"str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");t.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");t.setProp("EmptyItem","Emptyitem",!0,"bool");t.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");t.setProp("HTMLTemplate","Htmltemplate","","str");t.setProp("MultipleValuesType","Multiplevaluestype","Text","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("EmptyItemText","Emptyitemtext","GX_EmptyItemText","str");t.setProp("OnlySelectedValues","Onlyselectedvalues","","char");t.setProp("SelectAllText","Selectalltext","","char");t.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");t.setProp("AddNewOptionText","Addnewoptiontext","","str");t.addV2CFunction("AV16DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV16DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV16DDO_TitleSettingsIcons)});t.addV2CFunction("AV15CliPaiCod_Data","vCLIPAICOD_DATA","SetDropDownOptionsData");t.addC2VFunction(function(n){n.ParentObject.AV15CliPaiCod_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vCLIPAICOD_DATA",n.ParentObject.AV15CliPaiCod_Data)});t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e131h49_client);this.setUserControl(t);this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");i=this.DVPANEL_TABLEATTRIBUTESContainer;i.setProp("Class","Class","","char");i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Width","Width","100%","str");i.setProp("Height","Height","100","str");i.setProp("AutoWidth","Autowidth",!1,"bool");i.setProp("AutoHeight","Autoheight",!0,"bool");i.setProp("Cls","Cls","PanelCard_GrayTitle","str");i.setProp("ShowHeader","Showheader",!0,"bool");i.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");i.setProp("Collapsible","Collapsible",!1,"bool");i.setProp("Collapsed","Collapsed",!1,"bool");i.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");i.setProp("IconPosition","Iconposition","Right","str");i.setProp("AutoScroll","Autoscroll",!1,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});this.setUserControl(i);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:gx.falseFn};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"svchar",len:40,dec:0,sign:!1,pic:"@!",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLINOM",fmt:0,gxz:"Z344CliNom",gxold:"O344CliNom",gxvar:"A344CliNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A344CliNom=n)},v2z:function(n){n!==undefined&&(gx.O.Z344CliNom=n)},v2c:function(){gx.fn.setControlValue("CLINOM",gx.O.A344CliNom,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A344CliNom=this.val())},val:function(){return gx.fn.getControlValue("CLINOM")},nac:gx.falseFn};this.declareDomainHdlr(27,function(){});n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,lvl:0,type:"int",len:11,dec:0,sign:!1,pic:"ZZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICUIT",fmt:0,gxz:"Z345CliCUIT",gxold:"O345CliCUIT",gxvar:"A345CliCUIT",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A345CliCUIT=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z345CliCUIT=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICUIT",gx.O.A345CliCUIT,0)},c2v:function(){this.val()!==undefined&&(gx.O.A345CliCUIT=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICUIT",gx.thousandSeparator)},nac:gx.falseFn};n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,lvl:0,type:"date",len:10,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIFECALTA",fmt:0,gxz:"Z346CliFecAlta",gxold:"O346CliFecAlta",gxvar:"A346CliFecAlta",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/9999",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A346CliFecAlta=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z346CliFecAlta=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("CLIFECALTA",gx.O.A346CliFecAlta,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A346CliFecAlta=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("CLIFECALTA")},nac:gx.falseFn};this.declareDomainHdlr(37,function(){});n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIMULTIEMP",fmt:0,gxz:"Z366CliMultiEmp",gxold:"O366CliMultiEmp",gxvar:"A366CliMultiEmp",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A366CliMultiEmp=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z366CliMultiEmp=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("CLIMULTIEMP",gx.O.A366CliMultiEmp,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A366CliMultiEmp=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("CLIMULTIEMP")},nac:gx.falseFn,values:["true","false"]};n[43]={id:43,fld:"",grid:0};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,lvl:0,type:"int",len:12,dec:0,sign:!1,pic:"ZZZZZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIENTEPADRE",fmt:0,gxz:"Z546ClientePadre",gxold:"O546ClientePadre",gxvar:"A546ClientePadre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A546ClientePadre=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z546ClientePadre=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLIENTEPADRE",gx.O.A546ClientePadre,0)},c2v:function(){this.val()!==undefined&&(gx.O.A546ClientePadre=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLIENTEPADRE",gx.thousandSeparator)},nac:gx.falseFn};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"TABLESPLITTEDCLIPAICOD",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,fld:"TEXTBLOCKCLIPAICOD",format:0,grid:0,ctrltype:"textblock"};n[54]={id:54,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clipaicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIPAICOD",fmt:0,gxz:"Z4CliPaiCod",gxold:"O4CliPaiCod",gxvar:"A4CliPaiCod",ucs:[],op:[],ip:[58],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A4CliPaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z4CliPaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLIPAICOD",gx.O.A4CliPaiCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A4CliPaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLIPAICOD",gx.thousandSeparator)},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(0==this.AV13Insert_CliPaiCod)}};this.declareDomainHdlr(58,function(){});n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"",grid:0};n[63]={id:63,lvl:0,type:"boolean",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIENTESISTEMA",fmt:0,gxz:"Z747ClienteSistema",gxold:"O747ClienteSistema",gxvar:"A747ClienteSistema",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A747ClienteSistema=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z747ClienteSistema=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setControlValue("CLIENTESISTEMA",gx.O.A747ClienteSistema,0)},c2v:function(){this.val()!==undefined&&(gx.O.A747ClienteSistema=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("CLIENTESISTEMA")},nac:gx.falseFn};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"",grid:0};n[68]={id:68,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIENTECONVENIADOR",fmt:0,gxz:"Z1605ClienteConveniador",gxold:"O1605ClienteConveniador",gxvar:"A1605ClienteConveniador",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1605ClienteConveniador=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1605ClienteConveniador=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("CLIENTECONVENIADOR",gx.O.A1605ClienteConveniador,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1605ClienteConveniador=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("CLIENTECONVENIADOR")},nac:gx.falseFn,values:["true","false"]};n[74]={id:74,fld:"",grid:0};n[75]={id:75,fld:"",grid:0};n[76]={id:76,fld:"BTNTRN_ENTER",grid:0,evt:"e141h49_client",std:"ENTER"};n[77]={id:77,fld:"",grid:0};n[78]={id:78,fld:"BTNTRN_CANCEL",grid:0,evt:"e151h49_client"};n[79]={id:79,fld:"",grid:0};n[80]={id:80,fld:"BTNTRN_DELETE",grid:0,evt:"e161h49_client",std:"DELETE"};n[81]={id:81,fld:"",grid:0};n[82]={id:82,fld:"",grid:0};n[83]={id:83,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[84]={id:84,fld:"SECTIONATTRIBUTE_CLIPAICOD",grid:0};n[85]={id:85,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Validv_Comboclipaicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCOMBOCLIPAICOD",fmt:0,gxz:"ZV20ComboCliPaiCod",gxold:"OV20ComboCliPaiCod",gxvar:"AV20ComboCliPaiCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV20ComboCliPaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV20ComboCliPaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCOMBOCLIPAICOD",gx.O.AV20ComboCliPaiCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV20ComboCliPaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCOMBOCLIPAICOD",gx.thousandSeparator)},nac:gx.falseFn};this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A344CliNom="";this.Z344CliNom="";this.O344CliNom="";this.A345CliCUIT=0;this.Z345CliCUIT=0;this.O345CliCUIT=0;this.A346CliFecAlta=gx.date.nullDate();this.Z346CliFecAlta=gx.date.nullDate();this.O346CliFecAlta=gx.date.nullDate();this.A366CliMultiEmp=!1;this.Z366CliMultiEmp=!1;this.O366CliMultiEmp=!1;this.A546ClientePadre=0;this.Z546ClientePadre=0;this.O546ClientePadre=0;this.A4CliPaiCod=0;this.Z4CliPaiCod=0;this.O4CliPaiCod=0;this.A747ClienteSistema=!1;this.Z747ClienteSistema=!1;this.O747ClienteSistema=!1;this.A1605ClienteConveniador=!1;this.Z1605ClienteConveniador=!1;this.O1605ClienteConveniador=!1;this.AV20ComboCliPaiCod=0;this.ZV20ComboCliPaiCod=0;this.OV20ComboCliPaiCod=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV20ComboCliPaiCod=0;this.AV9IsAuthorized=!1;this.AV22Pgmname="";this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV23GXV1=0;this.AV13Insert_CliPaiCod=0;this.AV19Combo_DataJson="";this.AV14TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV18ComboSelectedText="";this.AV17ComboSelectedValue="";this.AV7CliCod=0;this.AV12WebSession={};this.A3CliCod=0;this.A4CliPaiCod=0;this.A344CliNom="";this.A345CliCUIT=0;this.A346CliFecAlta=gx.date.nullDate();this.A366CliMultiEmp=!1;this.A546ClientePadre=0;this.A747ClienteSistema=!1;this.A1605ClienteConveniador=!1;this.A1741ClienteTipo="";this.A2023CliManten=!1;this.AV16DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV15CliPaiCod_Data=[];this.Gx_mode="";this.Events={e121h2_client:["AFTER TRN",!0],e141h49_client:["ENTER",!0],e151h49_client:["CANCEL",!0],e131h49_client:["COMBO_CLIPAICOD.ONOPTIONCLICKED",!1]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}],[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1741ClienteTipo",fld:"CLIENTETIPO",pic:""},{av:"A2023CliManten",fld:"CLIMANTEN",pic:""},{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}],[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}]];this.EvtParms["AFTER TRN"]=[[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}],[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}]];this.EvtParms["COMBO_CLIPAICOD.ONOPTIONCLICKED"]=[[{av:"this.COMBO_CLIPAICODContainer.SelectedValue_get",ctrl:"COMBO_CLIPAICOD",prop:"SelectedValue_get"},{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}],[{av:"AV20ComboCliPaiCod",fld:"vCOMBOCLIPAICOD",pic:"ZZZ9"},{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}]];this.EvtParms.VALID_CLICOD=[[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}],[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}]];this.EvtParms.VALID_CLIPAICOD=[[{av:"A4CliPaiCod",fld:"CLIPAICOD",pic:"ZZZ9"},{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}],[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}]];this.EvtParms.VALIDV_COMBOCLIPAICOD=[[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}],[{av:"A366CliMultiEmp",fld:"CLIMULTIEMP",pic:""},{av:"A1605ClienteConveniador",fld:"CLIENTECONVENIADOR",pic:""}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV13Insert_CliPaiCod","vINSERT_CLIPAICOD",0,"int",4,0);this.setVCMap("A1741ClienteTipo","CLIENTETIPO",0,"char",20,0);this.setVCMap("A2023CliManten","CLIMANTEN",0,"boolean",4,0);this.setVCMap("AV22Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}})});gx.wi(function(){gx.createParentObj(this.cliente)})