gx.evt.autoSkip=!1;gx.define("tipo_obligacion",!1,function(){var n,t,i,r;this.ServerClass="tipo_obligacion";this.PackageName="web";this.ServerFullClass="web.tipo_obligacion";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7TipoOblSec=gx.fn.getIntegerValue("vTIPOOBLSEC",gx.thousandSeparator);this.AV13Insert_TipoOblPaiCod=gx.fn.getIntegerValue("vINSERT_TIPOOBLPAICOD",gx.thousandSeparator);this.AV14Insert_EmbargaSec=gx.fn.getIntegerValue("vINSERT_EMBARGASEC",gx.thousandSeparator);this.A1162EmbargaDescrip=gx.fn.getControlValue("EMBARGADESCRIP");this.AV25Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Tipooblsec=function(){return this.validCliEvt("Valid_Tipooblsec",0,function(){try{var n=gx.util.balloon.getNew("TIPOOBLSEC");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Tipooblcodigo=function(){return this.validCliEvt("Valid_Tipooblcodigo",0,function(){try{var n=gx.util.balloon.getNew("TIPOOBLCODIGO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Tipooblpaicod=function(){return this.validSrvEvt("valid_Tipooblpaicod",0).then(function(n){return n}.closure(this))};this.Valid_Tipoobltottipo=function(){return this.validCliEvt("Valid_Tipoobltottipo",0,function(){try{var n=gx.util.balloon.getNew("TIPOOBLTOTTIPO");if(this.AnyError=0,!(this.A1168TipoOblTotTipo==0||this.A1168TipoOblTotTipo==1||this.A1168TipoOblTotTipo==2))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Total"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Embargasec=function(){return this.validSrvEvt("valid_Embargasec",0).then(function(n){return n}.closure(this))};this.Validv_Combotipooblpaicod=function(){return this.validCliEvt("Validv_Combotipooblpaicod",0,function(){try{var n=gx.util.balloon.getNew("vCOMBOTIPOOBLPAICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Validv_Comboembargasec=function(){return this.validCliEvt("Validv_Comboembargasec",0,function(){try{var n=gx.util.balloon.getNew("vCOMBOEMBARGASEC");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e133c133_client=function(){return this.clearMessages(),this.AV24ComboEmbargaSec=gx.num.trunc(gx.num.val(this.COMBO_EMBARGASECContainer.SelectedValue_get),0),this.refreshOutputs([{av:"AV24ComboEmbargaSec",fld:"vCOMBOEMBARGASEC",pic:"ZZZ9"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e143c133_client=function(){return this.clearMessages(),this.AV21ComboTipoOblPaiCod=gx.num.trunc(gx.num.val(this.COMBO_TIPOOBLPAICODContainer.SelectedValue_get),0),this.refreshOutputs([{av:"AV21ComboTipoOblPaiCod",fld:"vCOMBOTIPOOBLPAICOD",pic:"ZZZ9"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e123c2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e153c133_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e163c133_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,62,63,64,65,66,67,68,69,75,76,77,78,79,80,81,82,83,84,85,86,87,88];this.GXLastCtrlId=88;this.COMBO_TIPOOBLPAICODContainer=gx.uc.getNew(this,40,22,"BootstrapDropDownOptions","COMBO_TIPOOBLPAICODContainer","Combo_tipooblpaicod","COMBO_TIPOOBLPAICOD");t=this.COMBO_TIPOOBLPAICODContainer;t.setProp("Class","Class","","char");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","ExtendedCombo Attribute","str");t.setDynProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setDynProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("DDOInternalName","Ddointernalname","","char");t.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");t.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");t.setDynProp("Enabled","Enabled",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");t.setProp("DataListType","Datalisttype","Dynamic","str");t.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");t.setProp("DataListFixedValues","Datalistfixedvalues","","char");t.setProp("IsGridItem","Isgriditem",!1,"bool");t.setProp("HasDescription","Hasdescription",!1,"bool");t.setProp("DataListProc","Datalistproc","tipo_obligacionLoadDVCombo","str");t.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix",' "ComboName": "TipoOblPaiCod", "TrnMode": "INS", "IsDynamicCall": true, "TipoOblSec": 0',"str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");t.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");t.setProp("EmptyItem","Emptyitem",!1,"bool");t.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");t.setProp("HTMLTemplate","Htmltemplate","","str");t.setProp("MultipleValuesType","Multiplevaluestype","Text","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("EmptyItemText","Emptyitemtext","","char");t.setProp("OnlySelectedValues","Onlyselectedvalues","","char");t.setProp("SelectAllText","Selectalltext","","char");t.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");t.setProp("AddNewOptionText","Addnewoptiontext","","str");t.addV2CFunction("AV17DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV17DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV17DDO_TitleSettingsIcons)});t.addV2CFunction("AV16TipoOblPaiCod_Data","vTIPOOBLPAICOD_DATA","SetDropDownOptionsData");t.addC2VFunction(function(n){n.ParentObject.AV16TipoOblPaiCod_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vTIPOOBLPAICOD_DATA",n.ParentObject.AV16TipoOblPaiCod_Data)});t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e143c133_client);this.setUserControl(t);this.COMBO_EMBARGASECContainer=gx.uc.getNew(this,61,22,"BootstrapDropDownOptions","COMBO_EMBARGASECContainer","Combo_embargasec","COMBO_EMBARGASEC");i=this.COMBO_EMBARGASECContainer;i.setProp("Class","Class","","char");i.setProp("IconType","Icontype","Image","str");i.setProp("Icon","Icon","","str");i.setProp("Caption","Caption","","str");i.setProp("Tooltip","Tooltip","","str");i.setProp("Cls","Cls","ExtendedCombo Attribute","str");i.setDynProp("SelectedValue_set","Selectedvalue_set","","char");i.setProp("SelectedValue_get","Selectedvalue_get","","char");i.setDynProp("SelectedText_set","Selectedtext_set","","char");i.setProp("SelectedText_get","Selectedtext_get","","char");i.setProp("GAMOAuthToken","Gamoauthtoken","","char");i.setProp("DDOInternalName","Ddointernalname","","char");i.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");i.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");i.setDynProp("Enabled","Enabled",!0,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");i.setProp("DataListType","Datalisttype","Dynamic","str");i.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");i.setProp("DataListFixedValues","Datalistfixedvalues","","char");i.setProp("IsGridItem","Isgriditem",!1,"bool");i.setProp("HasDescription","Hasdescription",!1,"bool");i.setProp("DataListProc","Datalistproc","tipo_obligacionLoadDVCombo","str");i.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix",' "ComboName": "EmbargaSec", "TrnMode": "INS", "IsDynamicCall": true, "TipoOblSec": 0',"str");i.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");i.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");i.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");i.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");i.setProp("EmptyItem","Emptyitem",!0,"bool");i.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");i.setProp("HTMLTemplate","Htmltemplate","","str");i.setProp("MultipleValuesType","Multiplevaluestype","Text","str");i.setProp("LoadingData","Loadingdata","","str");i.setProp("NoResultsFound","Noresultsfound","","str");i.setProp("EmptyItemText","Emptyitemtext","GX_EmptyItemText","str");i.setProp("OnlySelectedValues","Onlyselectedvalues","","char");i.setProp("SelectAllText","Selectalltext","","char");i.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");i.setProp("AddNewOptionText","Addnewoptiontext","","str");i.addV2CFunction("AV17DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");i.addC2VFunction(function(n){n.ParentObject.AV17DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV17DDO_TitleSettingsIcons)});i.addV2CFunction("AV23EmbargaSec_Data","vEMBARGASEC_DATA","SetDropDownOptionsData");i.addC2VFunction(function(n){n.ParentObject.AV23EmbargaSec_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vEMBARGASEC_DATA",n.ParentObject.AV23EmbargaSec_Data)});i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});i.addEventHandler("OnOptionClicked",this.e133c133_client);this.setUserControl(i);this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");r=this.DVPANEL_TABLEATTRIBUTESContainer;r.setProp("Class","Class","","char");r.setProp("Enabled","Enabled",!0,"boolean");r.setProp("Width","Width","100%","str");r.setProp("Height","Height","100","str");r.setProp("AutoWidth","Autowidth",!1,"bool");r.setProp("AutoHeight","Autoheight",!0,"bool");r.setProp("Cls","Cls","PanelCard_GrayTitle","str");r.setProp("ShowHeader","Showheader",!0,"bool");r.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");r.setProp("Collapsible","Collapsible",!1,"bool");r.setProp("Collapsed","Collapsed",!1,"bool");r.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");r.setProp("IconPosition","Iconposition","Right","str");r.setProp("AutoScroll","Autoscroll",!1,"bool");r.setProp("Visible","Visible",!0,"bool");r.setProp("Gx Control Type","Gxcontroltype","","int");r.setC2ShowFunction(function(n){n.show()});this.setUserControl(r);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Tipooblsec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOOBLSEC",fmt:0,gxz:"Z1163TipoOblSec",gxold:"O1163TipoOblSec",gxvar:"A1163TipoOblSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1163TipoOblSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1163TipoOblSec=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TIPOOBLSEC",gx.O.A1163TipoOblSec,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1163TipoOblSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TIPOOBLSEC",gx.thousandSeparator)},nac:gx.falseFn};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Tipooblcodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOOBLCODIGO",fmt:0,gxz:"Z1164TipoOblCodigo",gxold:"O1164TipoOblCodigo",gxvar:"A1164TipoOblCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1164TipoOblCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z1164TipoOblCodigo=n)},v2c:function(){gx.fn.setControlValue("TIPOOBLCODIGO",gx.O.A1164TipoOblCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1164TipoOblCodigo=this.val())},val:function(){return gx.fn.getControlValue("TIPOOBLCODIGO")},nac:gx.falseFn};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOOBLDESCRIP",fmt:0,gxz:"Z1165TipoOblDescrip",gxold:"O1165TipoOblDescrip",gxvar:"A1165TipoOblDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1165TipoOblDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z1165TipoOblDescrip=n)},v2c:function(){gx.fn.setControlValue("TIPOOBLDESCRIP",gx.O.A1165TipoOblDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1165TipoOblDescrip=this.val())},val:function(){return gx.fn.getControlValue("TIPOOBLDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(32,function(){});n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"TABLESPLITTEDTIPOOBLPAICOD",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"TEXTBLOCKTIPOOBLPAICOD",format:0,grid:0,ctrltype:"textblock"};n[39]={id:39,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Tipooblpaicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOOBLPAICOD",fmt:0,gxz:"Z1159TipoOblPaiCod",gxold:"O1159TipoOblPaiCod",gxvar:"A1159TipoOblPaiCod",ucs:[],op:[],ip:[22,27,43],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1159TipoOblPaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1159TipoOblPaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TIPOOBLPAICOD",gx.O.A1159TipoOblPaiCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1159TipoOblPaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TIPOOBLPAICOD",gx.thousandSeparator)},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(0==this.AV13Insert_TipoOblPaiCod)}};this.declareDomainHdlr(43,function(){});n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOOBLANTI",fmt:0,gxz:"Z1167TipoOblAnti",gxold:"O1167TipoOblAnti",gxvar:"A1167TipoOblAnti",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1167TipoOblAnti=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1167TipoOblAnti=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("TIPOOBLANTI",gx.O.A1167TipoOblAnti,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1167TipoOblAnti=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("TIPOOBLANTI")},nac:gx.falseFn,values:["true","false"]};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,lvl:0,type:"int",len:1,dec:0,sign:!1,pic:"9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Tipoobltottipo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOOBLTOTTIPO",fmt:0,gxz:"Z1168TipoOblTotTipo",gxold:"O1168TipoOblTotTipo",gxvar:"A1168TipoOblTotTipo",ucs:[],op:[53],ip:[53],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A1168TipoOblTotTipo=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1168TipoOblTotTipo=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("TIPOOBLTOTTIPO",gx.O.A1168TipoOblTotTipo);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1168TipoOblTotTipo=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TIPOOBLTOTTIPO",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(53,function(){});n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"TABLESPLITTEDEMBARGASEC",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"TEXTBLOCKEMBARGASEC",format:0,grid:0,ctrltype:"textblock"};n[60]={id:60,fld:"",grid:0};n[62]={id:62,fld:"",grid:0};n[63]={id:63,fld:"",grid:0};n[64]={id:64,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Embargasec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMBARGASEC",fmt:0,gxz:"Z1161EmbargaSec",gxold:"O1161EmbargaSec",gxvar:"A1161EmbargaSec",ucs:[],op:[],ip:[64],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1161EmbargaSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1161EmbargaSec=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMBARGASEC",gx.O.A1161EmbargaSec,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1161EmbargaSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMBARGASEC",gx.thousandSeparator)},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(0==this.AV14Insert_EmbargaSec)}};n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"",grid:0};n[69]={id:69,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOOBLSOLODESCU",fmt:0,gxz:"Z2346TipoOblSoloDescu",gxold:"O2346TipoOblSoloDescu",gxvar:"A2346TipoOblSoloDescu",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A2346TipoOblSoloDescu=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z2346TipoOblSoloDescu=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("TIPOOBLSOLODESCU",gx.O.A2346TipoOblSoloDescu,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A2346TipoOblSoloDescu=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("TIPOOBLSOLODESCU")},nac:gx.falseFn,values:["true","false"]};n[75]={id:75,fld:"",grid:0};n[76]={id:76,fld:"",grid:0};n[77]={id:77,fld:"BTNTRN_ENTER",grid:0,evt:"e153c133_client",std:"ENTER"};n[78]={id:78,fld:"",grid:0};n[79]={id:79,fld:"BTNTRN_CANCEL",grid:0,evt:"e163c133_client"};n[80]={id:80,fld:"",grid:0};n[81]={id:81,fld:"BTNTRN_DELETE",grid:0,evt:"e173c133_client",std:"DELETE"};n[82]={id:82,fld:"",grid:0};n[83]={id:83,fld:"",grid:0};n[84]={id:84,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[85]={id:85,fld:"SECTIONATTRIBUTE_TIPOOBLPAICOD",grid:0};n[86]={id:86,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Validv_Combotipooblpaicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCOMBOTIPOOBLPAICOD",fmt:0,gxz:"ZV21ComboTipoOblPaiCod",gxold:"OV21ComboTipoOblPaiCod",gxvar:"AV21ComboTipoOblPaiCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV21ComboTipoOblPaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV21ComboTipoOblPaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCOMBOTIPOOBLPAICOD",gx.O.AV21ComboTipoOblPaiCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV21ComboTipoOblPaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCOMBOTIPOOBLPAICOD",gx.thousandSeparator)},nac:gx.falseFn};n[87]={id:87,fld:"SECTIONATTRIBUTE_EMBARGASEC",grid:0};n[88]={id:88,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Validv_Comboembargasec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCOMBOEMBARGASEC",fmt:0,gxz:"ZV24ComboEmbargaSec",gxold:"OV24ComboEmbargaSec",gxvar:"AV24ComboEmbargaSec",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV24ComboEmbargaSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV24ComboEmbargaSec=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCOMBOEMBARGASEC",gx.O.AV24ComboEmbargaSec,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV24ComboEmbargaSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCOMBOEMBARGASEC",gx.thousandSeparator)},nac:gx.falseFn};this.A1163TipoOblSec=0;this.Z1163TipoOblSec=0;this.O1163TipoOblSec=0;this.A1164TipoOblCodigo="";this.Z1164TipoOblCodigo="";this.O1164TipoOblCodigo="";this.A1165TipoOblDescrip="";this.Z1165TipoOblDescrip="";this.O1165TipoOblDescrip="";this.A1159TipoOblPaiCod=0;this.Z1159TipoOblPaiCod=0;this.O1159TipoOblPaiCod=0;this.A1167TipoOblAnti=!1;this.Z1167TipoOblAnti=!1;this.O1167TipoOblAnti=!1;this.A1168TipoOblTotTipo=0;this.Z1168TipoOblTotTipo=0;this.O1168TipoOblTotTipo=0;this.A1161EmbargaSec=0;this.Z1161EmbargaSec=0;this.O1161EmbargaSec=0;this.A2346TipoOblSoloDescu=!1;this.Z2346TipoOblSoloDescu=!1;this.O2346TipoOblSoloDescu=!1;this.AV21ComboTipoOblPaiCod=0;this.ZV21ComboTipoOblPaiCod=0;this.OV21ComboTipoOblPaiCod=0;this.AV24ComboEmbargaSec=0;this.ZV24ComboEmbargaSec=0;this.OV24ComboEmbargaSec=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV24ComboEmbargaSec=0;this.AV21ComboTipoOblPaiCod=0;this.AV9IsAuthorized=!1;this.AV25Pgmname="";this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV26GXV1=0;this.AV13Insert_TipoOblPaiCod=0;this.AV20Combo_DataJson="";this.AV14Insert_EmbargaSec=0;this.AV15TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV19ComboSelectedText="";this.AV18ComboSelectedValue="";this.AV7TipoOblSec=0;this.AV12WebSession={};this.A1163TipoOblSec=0;this.A1159TipoOblPaiCod=0;this.A1161EmbargaSec=0;this.A1164TipoOblCodigo="";this.A1165TipoOblDescrip="";this.A1167TipoOblAnti=!1;this.A1168TipoOblTotTipo=0;this.A1162EmbargaDescrip="";this.A2346TipoOblSoloDescu=!1;this.AV17DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV16TipoOblPaiCod_Data=[];this.AV23EmbargaSec_Data=[];this.Gx_mode="";this.Events={e123c2_client:["AFTER TRN",!0],e153c133_client:["ENTER",!0],e163c133_client:["CANCEL",!0],e133c133_client:["COMBO_EMBARGASEC.ONOPTIONCLICKED",!1],e143c133_client:["COMBO_TIPOOBLPAICOD.ONOPTIONCLICKED",!1]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7TipoOblSec",fld:"vTIPOOBLSEC",pic:"ZZZ9",hsh:!0},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7TipoOblSec",fld:"vTIPOOBLSEC",pic:"ZZZ9",hsh:!0},{av:"A1163TipoOblSec",fld:"TIPOOBLSEC",pic:"ZZZ9"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms["AFTER TRN"]=[[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms["COMBO_EMBARGASEC.ONOPTIONCLICKED"]=[[{av:"this.COMBO_EMBARGASECContainer.SelectedValue_get",ctrl:"COMBO_EMBARGASEC",prop:"SelectedValue_get"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"AV24ComboEmbargaSec",fld:"vCOMBOEMBARGASEC",pic:"ZZZ9"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms["COMBO_TIPOOBLPAICOD.ONOPTIONCLICKED"]=[[{av:"this.COMBO_TIPOOBLPAICODContainer.SelectedValue_get",ctrl:"COMBO_TIPOOBLPAICOD",prop:"SelectedValue_get"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"AV21ComboTipoOblPaiCod",fld:"vCOMBOTIPOOBLPAICOD",pic:"ZZZ9"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms.VALID_TIPOOBLSEC=[[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms.VALID_TIPOOBLCODIGO=[[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms.VALID_TIPOOBLPAICOD=[[{av:"A1159TipoOblPaiCod",fld:"TIPOOBLPAICOD",pic:"ZZZ9"},{av:"A1164TipoOblCodigo",fld:"TIPOOBLCODIGO",pic:""},{av:"A1163TipoOblSec",fld:"TIPOOBLSEC",pic:"ZZZ9"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms.VALID_TIPOOBLTOTTIPO=[[{ctrl:"TIPOOBLTOTTIPO"},{av:"A1168TipoOblTotTipo",fld:"TIPOOBLTOTTIPO",pic:"9"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{ctrl:"TIPOOBLTOTTIPO"},{av:"A1168TipoOblTotTipo",fld:"TIPOOBLTOTTIPO",pic:"9"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms.VALID_EMBARGASEC=[[{av:"A1161EmbargaSec",fld:"EMBARGASEC",pic:"ZZZ9"},{av:"A1162EmbargaDescrip",fld:"EMBARGADESCRIP",pic:"@!"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1162EmbargaDescrip",fld:"EMBARGADESCRIP",pic:"@!"},{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms.VALIDV_COMBOTIPOOBLPAICOD=[[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EvtParms.VALIDV_COMBOEMBARGASEC=[[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}],[{av:"A1167TipoOblAnti",fld:"TIPOOBLANTI",pic:""},{av:"A2346TipoOblSoloDescu",fld:"TIPOOBLSOLODESCU",pic:""}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7TipoOblSec","vTIPOOBLSEC",0,"int",4,0);this.setVCMap("AV13Insert_TipoOblPaiCod","vINSERT_TIPOOBLPAICOD",0,"int",4,0);this.setVCMap("AV14Insert_EmbargaSec","vINSERT_EMBARGASEC",0,"int",4,0);this.setVCMap("A1162EmbargaDescrip","EMBARGADESCRIP",0,"svchar",30,0);this.setVCMap("AV25Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}})});gx.wi(function(){gx.createParentObj(this.tipo_obligacion)})