gx.evt.autoSkip=!1;gx.define("convenio_adicional_importes",!1,function(){var n,t,i;this.ServerClass="convenio_adicional_importes";this.PackageName="web";this.ServerFullClass="web.convenio_adicional_importes";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV8CliPaiConve=gx.fn.getIntegerValue("vCLIPAICONVE",gx.thousandSeparator);this.AV9CliConvenio=gx.fn.getControlValue("vCLICONVENIO");this.AV10ConveAdicod=gx.fn.getControlValue("vCONVEADICOD");this.AV11ConveAdiVig=gx.fn.getDateValue("vCONVEADIVIG");this.AV23aplicadoHay=gx.fn.getControlValue("vAPLICADOHAY");this.A2059ConveAdiImpRelRef=gx.fn.getControlValue("CONVEADIIMPRELREF");this.A2049ConveAdiImpOld=gx.fn.getControlValue("CONVEADIIMPOLD");this.AV24Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Conveadicod=function(){return this.validCliEvt("Valid_Conveadicod",0,function(){try{var n=gx.util.balloon.getNew("CONVEADICOD");this.AnyError=0;this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Conveadivig=function(){return this.validCliEvt("Valid_Conveadivig",0,function(){try{var n=gx.util.balloon.getNew("CONVEADIVIG");this.AnyError=0;this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0;this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clipaiconve=function(){return this.validCliEvt("Valid_Clipaiconve",0,function(){try{var n=gx.util.balloon.getNew("CLIPAICONVE");this.AnyError=0;this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Cliconvenio=function(){return this.validSrvEvt("valid_Cliconvenio",0).then(function(n){return n}.closure(this))};this.Valid_Conveadiimporte=function(){return this.validCliEvt("Valid_Conveadiimporte",0,function(){try{var n=gx.util.balloon.getNew("CONVEADIIMPORTE");this.AnyError=0;try{new gx.date.gxdate(this.A999ConveAdiVig).compare(gx.OldDate("CONVEADIVIG","O999ConveAdiVig"))!=0||this.A1000ConveAdiImporte!=gx.OldDecimal("CONVEADIIMPORTE","O1000ConveAdiImporte")?(new gx.date.gxdate(this.A999ConveAdiVig).compare(gx.OldDate("CONVEADIVIG","O999ConveAdiVig"))!=0||this.A1000ConveAdiImporte!=gx.OldDecimal("CONVEADIIMPORTE","O1000ConveAdiImporte"))&&gx.fn.setCtrlProperty("CONVEADIIMPRELSEC_CELL","Class",gx.getMessage("col-xs-12 RequiredDataContentCell")):gx.fn.setCtrlProperty("CONVEADIIMPRELSEC_CELL","Class",gx.getMessage("col-xs-12 DataContentCell"))}catch(t){}this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Conveadiimprelsec=function(){return this.validSrvEvt("valid_Conveadiimprelsec",0).then(function(n){return n}.closure(this))};this.Validv_Comboconveadicod=function(){return this.validCliEvt("Validv_Comboconveadicod",0,function(){try{var n=gx.util.balloon.getNew("vCOMBOCONVEADICOD");this.AnyError=0;this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s122_client=function(){gx.fn.setCtrlProperty("CONVEADIIMPRELSEC_CELL","Class","col-xs-12 DataContentCell")};this.e134r208_client=function(){return this.clearMessages(),this.AV22ComboConveAdicod=this.COMBO_CONVEADICODContainer.SelectedValue_get,this.refreshOutputs([{av:"AV22ComboConveAdicod",fld:"vCOMBOCONVEADICOD",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e124r2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e144r208_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e154r208_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63];this.GXLastCtrlId=63;this.COMBO_CONVEADICODContainer=gx.uc.getNew(this,25,0,"BootstrapDropDownOptions","COMBO_CONVEADICODContainer","Combo_conveadicod","COMBO_CONVEADICOD");t=this.COMBO_CONVEADICODContainer;t.setProp("Class","Class","","char");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","ExtendedCombo Attribute","str");t.setDynProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setDynProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("DDOInternalName","Ddointernalname","","char");t.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");t.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");t.setDynProp("Enabled","Enabled",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");t.setProp("DataListType","Datalisttype","Dynamic","str");t.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");t.setProp("DataListFixedValues","Datalistfixedvalues","","char");t.setProp("IsGridItem","Isgriditem",!1,"bool");t.setProp("HasDescription","Hasdescription",!1,"bool");t.setProp("DataListProc","Datalistproc","Convenio_Adicional_ImportesLoadDVCombo","str");t.setDynProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");t.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");t.setProp("EmptyItem","Emptyitem",!1,"bool");t.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");t.setProp("HTMLTemplate","Htmltemplate","","str");t.setProp("MultipleValuesType","Multiplevaluestype","Text","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("EmptyItemText","Emptyitemtext","","char");t.setProp("OnlySelectedValues","Onlyselectedvalues","","char");t.setProp("SelectAllText","Selectalltext","","char");t.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");t.setProp("AddNewOptionText","Addnewoptiontext","","str");t.addV2CFunction("AV18DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV18DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV18DDO_TitleSettingsIcons)});t.addV2CFunction("AV17ConveAdicod_Data","vCONVEADICOD_DATA","SetDropDownOptionsData");t.addC2VFunction(function(n){n.ParentObject.AV17ConveAdicod_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vCONVEADICOD_DATA",n.ParentObject.AV17ConveAdicod_Data)});t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e134r208_client);this.setUserControl(t);this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");i=this.DVPANEL_TABLEATTRIBUTESContainer;i.setProp("Class","Class","","char");i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Width","Width","100%","str");i.setProp("Height","Height","100","str");i.setProp("AutoWidth","Autowidth",!1,"bool");i.setProp("AutoHeight","Autoheight",!0,"bool");i.setProp("Cls","Cls","PanelCard_GrayTitle","str");i.setProp("ShowHeader","Showheader",!0,"bool");i.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");i.setProp("Collapsible","Collapsible",!1,"bool");i.setProp("Collapsed","Collapsed",!1,"bool");i.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");i.setProp("IconPosition","Iconposition","Right","str");i.setProp("AutoScroll","Autoscroll",!1,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});this.setUserControl(i);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"TABLESPLITTEDCONVEADICOD",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,fld:"TEXTBLOCKCONVEADICOD",format:0,grid:0,ctrltype:"textblock"};n[24]={id:24,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Conveadicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADICOD",fmt:0,gxz:"Z996ConveAdicod",gxold:"O996ConveAdicod",gxvar:"A996ConveAdicod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A996ConveAdicod=n)},v2z:function(n){n!==undefined&&(gx.O.Z996ConveAdicod=n)},v2c:function(){gx.fn.setControlValue("CONVEADICOD",gx.O.A996ConveAdicod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A996ConveAdicod=this.val())},val:function(){return gx.fn.getControlValue("CONVEADICOD")},nac:function(){return!(gx.text.compare("",this.AV10ConveAdicod)==0)}};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"date",len:8,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Conveadivig,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADIVIG",fmt:0,gxz:"Z999ConveAdiVig",gxold:"O999ConveAdiVig",gxvar:"A999ConveAdiVig",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/99",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A999ConveAdiVig=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z999ConveAdiVig=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("CONVEADIVIG",gx.O.A999ConveAdiVig,0)},c2v:function(){this.val()!==undefined&&(gx.O.A999ConveAdiVig=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("CONVEADIVIG")},nac:function(){return!(new gx.date.gxdate("").compare(this.AV11ConveAdiVig)==0)}};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"decimal",len:14,dec:2,sign:!0,pic:"ZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Conveadiimporte,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADIIMPORTE",fmt:0,gxz:"Z1000ConveAdiImporte",gxold:"O1000ConveAdiImporte",gxvar:"A1000ConveAdiImporte",ucs:[],op:[],ip:[38,33],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1000ConveAdiImporte=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z1000ConveAdiImporte=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("CONVEADIIMPORTE",gx.O.A1000ConveAdiImporte,2,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1000ConveAdiImporte=this.val())},val:function(){return gx.fn.getDecimalValue("CONVEADIIMPORTE",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.declareDomainHdlr(38,function(){});n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"CONVEADIIMPRELSEC_CELL",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Conveadiimprelsec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CONVEADIIMPRELSEC",fmt:0,gxz:"Z1899ConveAdiImpRelSec",gxold:"O1899ConveAdiImpRelSec",gxvar:"A1899ConveAdiImpRelSec",ucs:[],op:[43,38,33],ip:[43,38,33],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1899ConveAdiImpRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1899ConveAdiImpRelSec=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("CONVEADIIMPRELSEC",gx.O.A1899ConveAdiImpRelSec)},c2v:function(){this.val()!==undefined&&(gx.O.A1899ConveAdiImpRelSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CONVEADIIMPRELSEC",gx.thousandSeparator)},nac:gx.falseFn};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"BTNTRN_ENTER",grid:0,evt:"e144r208_client",std:"ENTER"};n[52]={id:52,fld:"",grid:0};n[53]={id:53,fld:"BTNTRN_CANCEL",grid:0,evt:"e154r208_client"};n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"BTNTRN_DELETE",grid:0,evt:"e164r208_client",std:"DELETE"};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[59]={id:59,fld:"SECTIONATTRIBUTE_CONVEADICOD",grid:0};n[60]={id:60,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Validv_Comboconveadicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCOMBOCONVEADICOD",fmt:0,gxz:"ZV22ComboConveAdicod",gxold:"OV22ComboConveAdicod",gxvar:"AV22ComboConveAdicod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV22ComboConveAdicod=n)},v2z:function(n){n!==undefined&&(gx.O.ZV22ComboConveAdicod=n)},v2c:function(){gx.fn.setControlValue("vCOMBOCONVEADICOD",gx.O.AV22ComboConveAdicod,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV22ComboConveAdicod=this.val())},val:function(){return gx.fn.getControlValue("vCOMBOCONVEADICOD")},nac:gx.falseFn};n[61]={id:61,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV7CliCod)}};n[62]={id:62,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clipaiconve,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLIPAICONVE",fmt:0,gxz:"Z1564CliPaiConve",gxold:"O1564CliPaiConve",gxvar:"A1564CliPaiConve",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1564CliPaiConve=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1564CliPaiConve=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLIPAICONVE",gx.O.A1564CliPaiConve,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1564CliPaiConve=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLIPAICONVE",gx.thousandSeparator)},nac:function(){return!(0==this.AV8CliPaiConve)}};this.declareDomainHdlr(62,function(){});n[63]={id:63,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Cliconvenio,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICONVENIO",fmt:0,gxz:"Z1565CliConvenio",gxold:"O1565CliConvenio",gxvar:"A1565CliConvenio",ucs:[],op:[],ip:[28,63,62,61],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1565CliConvenio=n)},v2z:function(n){n!==undefined&&(gx.O.Z1565CliConvenio=n)},v2c:function(){gx.fn.setControlValue("CLICONVENIO",gx.O.A1565CliConvenio,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1565CliConvenio=this.val())},val:function(){return gx.fn.getControlValue("CLICONVENIO")},nac:function(){return!(gx.text.compare("",this.AV9CliConvenio)==0)}};this.A996ConveAdicod="";this.Z996ConveAdicod="";this.O996ConveAdicod="";this.A999ConveAdiVig=gx.date.nullDate();this.Z999ConveAdiVig=gx.date.nullDate();this.O999ConveAdiVig=gx.date.nullDate();this.A1000ConveAdiImporte=0;this.Z1000ConveAdiImporte=0;this.O1000ConveAdiImporte=0;this.A1899ConveAdiImpRelSec=0;this.Z1899ConveAdiImpRelSec=0;this.O1899ConveAdiImpRelSec=0;this.AV22ComboConveAdicod="";this.ZV22ComboConveAdicod="";this.OV22ComboConveAdicod="";this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1564CliPaiConve=0;this.Z1564CliPaiConve=0;this.O1564CliPaiConve=0;this.A1565CliConvenio="";this.Z1565CliConvenio="";this.O1565CliConvenio="";this.AV12WWPContext={UserId:0,UserName:""};this.AV22ComboConveAdicod="";this.AV13IsAuthorized=!1;this.AV24Pgmname="";this.AV15TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV7CliCod=0;this.AV8CliPaiConve=0;this.AV9CliConvenio="";this.AV10ConveAdicod="";this.AV11ConveAdiVig=gx.date.nullDate();this.AV16WebSession={};this.A3CliCod=0;this.A1564CliPaiConve=0;this.A1565CliConvenio="";this.A996ConveAdicod="";this.A999ConveAdiVig=gx.date.nullDate();this.AV23aplicadoHay=!1;this.A1000ConveAdiImporte=0;this.A1899ConveAdiImpRelSec=0;this.A2059ConveAdiImpRelRef="";this.A2049ConveAdiImpOld="";this.AV18DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV17ConveAdicod_Data=[];this.Gx_mode="";this.Events={e124r2_client:["AFTER TRN",!0],e144r208_client:["ENTER",!0],e154r208_client:["CANCEL",!0],e134r208_client:["COMBO_CONVEADICOD.ONOPTIONCLICKED",!1]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV8CliPaiConve",fld:"vCLIPAICONVE",pic:"ZZZ9",hsh:!0},{av:"AV9CliConvenio",fld:"vCLICONVENIO",pic:"",hsh:!0},{av:"AV10ConveAdicod",fld:"vCONVEADICOD",pic:"",hsh:!0},{av:"AV11ConveAdiVig",fld:"vCONVEADIVIG",pic:"",hsh:!0},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV8CliPaiConve",fld:"vCLIPAICONVE",pic:"ZZZ9",hsh:!0},{av:"AV9CliConvenio",fld:"vCLICONVENIO",pic:"",hsh:!0},{av:"AV10ConveAdicod",fld:"vCONVEADICOD",pic:"",hsh:!0},{av:"AV11ConveAdiVig",fld:"vCONVEADIVIG",pic:"",hsh:!0},{av:"A2059ConveAdiImpRelRef",fld:"CONVEADIIMPRELREF",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms["AFTER TRN"]=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms["COMBO_CONVEADICOD.ONOPTIONCLICKED"]=[[{av:"this.COMBO_CONVEADICODContainer.SelectedValue_get",ctrl:"COMBO_CONVEADICOD",prop:"SelectedValue_get"},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV22ComboConveAdicod",fld:"vCOMBOCONVEADICOD",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CONVEADICOD=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CONVEADIVIG=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CONVEADIIMPORTE=[[{av:"A1000ConveAdiImporte",fld:"CONVEADIIMPORTE",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"A999ConveAdiVig",fld:"CONVEADIVIG",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CONVEADIIMPRELSEC=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"O1000ConveAdiImporte"},{av:"O999ConveAdiVig"},{av:"A999ConveAdiVig",fld:"CONVEADIVIG",pic:""},{av:"A1000ConveAdiImporte",fld:"CONVEADIIMPORTE",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"AV23aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV23aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALIDV_COMBOCONVEADICOD=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CLICOD=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CLIPAICONVE=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CLICONVENIO=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1564CliPaiConve",fld:"CLIPAICONVE",pic:"ZZZ9"},{av:"A1565CliConvenio",fld:"CLICONVENIO",pic:""},{av:"A996ConveAdicod",fld:"CONVEADICOD",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"CONVEADIIMPRELSEC"},{av:"A1899ConveAdiImpRelSec",fld:"CONVEADIIMPRELSEC",pic:"ZZZZZ9"}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV8CliPaiConve","vCLIPAICONVE",0,"int",4,0);this.setVCMap("AV9CliConvenio","vCLICONVENIO",0,"char",20,0);this.setVCMap("AV10ConveAdicod","vCONVEADICOD",0,"char",20,0);this.setVCMap("AV11ConveAdiVig","vCONVEADIVIG",0,"date",8,0);this.setVCMap("AV23aplicadoHay","vAPLICADOHAY",0,"boolean",4,0);this.setVCMap("A2059ConveAdiImpRelRef","CONVEADIIMPRELREF",0,"svchar",40,0);this.setVCMap("A2049ConveAdiImpOld","CONVEADIIMPOLD",0,"vchar",2097152,0);this.setVCMap("AV24Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize();this.LvlOlds[208]=["O1000ConveAdiImporte","O999ConveAdiVig"];this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}})});gx.wi(function(){gx.createParentObj(this.convenio_adicional_importes)})