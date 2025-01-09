gx.evt.autoSkip=!1;gx.define("siradig_codigos",!1,function(){var n,t,i;this.ServerClass="siradig_codigos";this.PackageName="web";this.ServerFullClass="web.siradig_codigos";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV8SiraTipo=gx.fn.getControlValue("vSIRATIPO");this.AV9SiraCodigo=gx.fn.getControlValue("vSIRACODIGO");this.AV15Insert_SiraConCodigo=gx.fn.getControlValue("vINSERT_SIRACONCODIGO");this.AV25aplicadoHay=gx.fn.getControlValue("vAPLICADOHAY");this.A2007SiraRelSecCli=gx.fn.getIntegerValue("SIRARELSECCLI",gx.thousandSeparator);this.A2008SiraTipoPadre=gx.fn.getControlValue("SIRATIPOPADRE");this.A2009SiraCodPadre=gx.fn.getControlValue("SIRACODPADRE");this.A2022SiraRelRef=gx.fn.getControlValue("SIRARELREF");this.A2026SiraOld=gx.fn.getControlValue("SIRAOLD");this.AV26Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Siratipo=function(){return this.validCliEvt("Valid_Siratipo",0,function(){try{var n=gx.util.balloon.getNew("SIRATIPO");if(this.AnyError=0,!(gx.text.compare(this.A1101SiraTipo,"DED")==0||gx.text.compare(this.A1101SiraTipo,"OTR")==0||gx.text.compare(this.A1101SiraTipo,"PAG")==0||gx.text.compare(this.A1101SiraTipo,"RTO")==0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Tipo"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Siracodigo=function(){return this.validCliEvt("Valid_Siracodigo",0,function(){try{var n=gx.util.balloon.getNew("SIRACODIGO");this.AnyError=0;this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0;this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Siraconcodigo=function(){return this.validSrvEvt("valid_Siraconcodigo",0).then(function(n){return n}.closure(this))};this.Valid_Sirapropor=function(){return this.validSrvEvt("valid_Sirapropor",0).then(function(n){return n}.closure(this))};this.Valid_Sirarelsec=function(){return this.validSrvEvt("valid_Sirarelsec",0).then(function(n){return n}.closure(this))};this.Validv_Combosiraconcodigo=function(){return this.validCliEvt("Validv_Combosiraconcodigo",0,function(){try{var n=gx.util.balloon.getNew("vCOMBOSIRACONCODIGO");this.AnyError=0;this.refreshOutputs([{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s122_client=function(){gx.fn.setCtrlProperty("SIRARELSEC_CELL","Class","col-xs-12 DataContentCell")};this.e1335123_client=function(){return this.clearMessages(),this.AV22ComboSiraConCodigo=this.COMBO_SIRACONCODIGOContainer.SelectedValue_get,this.refreshOutputs([{av:"AV22ComboSiraConCodigo",fld:"vCOMBOSIRACONCODIGO",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12352_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e1435123_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e1535123_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,36,37,38,39,40,41,42,43,44,45,46,47,48,54,55,56,57,58,59,60,61,62,63,64,65,66];this.GXLastCtrlId=66;this.COMBO_SIRACONCODIGOContainer=gx.uc.getNew(this,35,22,"BootstrapDropDownOptions","COMBO_SIRACONCODIGOContainer","Combo_siraconcodigo","COMBO_SIRACONCODIGO");t=this.COMBO_SIRACONCODIGOContainer;t.setProp("Class","Class","","char");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","ExtendedCombo Attribute","str");t.setDynProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setDynProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("DDOInternalName","Ddointernalname","","char");t.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");t.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");t.setDynProp("Enabled","Enabled",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");t.setProp("DataListType","Datalisttype","Dynamic","str");t.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");t.setProp("DataListFixedValues","Datalistfixedvalues","","char");t.setProp("IsGridItem","Isgriditem",!1,"bool");t.setProp("HasDescription","Hasdescription",!1,"bool");t.setProp("DataListProc","Datalistproc","siradig_codigosLoadDVCombo","str");t.setDynProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");t.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");t.setProp("EmptyItem","Emptyitem",!1,"bool");t.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");t.setProp("HTMLTemplate","Htmltemplate","","str");t.setProp("MultipleValuesType","Multiplevaluestype","Text","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("EmptyItemText","Emptyitemtext","","char");t.setProp("OnlySelectedValues","Onlyselectedvalues","","char");t.setProp("SelectAllText","Selectalltext","","char");t.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");t.setProp("AddNewOptionText","Addnewoptiontext","","str");t.addV2CFunction("AV18DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV18DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV18DDO_TitleSettingsIcons)});t.addV2CFunction("AV17SiraConCodigo_Data","vSIRACONCODIGO_DATA","SetDropDownOptionsData");t.addC2VFunction(function(n){n.ParentObject.AV17SiraConCodigo_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vSIRACONCODIGO_DATA",n.ParentObject.AV17SiraConCodigo_Data)});t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e1335123_client);this.setUserControl(t);this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");i=this.DVPANEL_TABLEATTRIBUTESContainer;i.setProp("Class","Class","","char");i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Width","Width","100%","str");i.setProp("Height","Height","100","str");i.setProp("AutoWidth","Autowidth",!1,"bool");i.setProp("AutoHeight","Autoheight",!0,"bool");i.setProp("Cls","Cls","PanelCard_GrayTitle","str");i.setProp("ShowHeader","Showheader",!0,"bool");i.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");i.setProp("Collapsible","Collapsible",!1,"bool");i.setProp("Collapsed","Collapsed",!1,"bool");i.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");i.setProp("IconPosition","Iconposition","Right","str");i.setProp("AutoScroll","Autoscroll",!1,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});this.setUserControl(i);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"char",len:3,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Siratipo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SIRATIPO",fmt:0,gxz:"Z1101SiraTipo",gxold:"O1101SiraTipo",gxvar:"A1101SiraTipo",ucs:[],op:[22],ip:[22],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A1101SiraTipo=n)},v2z:function(n){n!==undefined&&(gx.O.Z1101SiraTipo=n)},v2c:function(){gx.fn.setComboBoxValue("SIRATIPO",gx.O.A1101SiraTipo);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1101SiraTipo=this.val())},val:function(){return gx.fn.getControlValue("SIRATIPO")},nac:function(){return!(gx.text.compare("",this.AV8SiraTipo)==0)}};this.declareDomainHdlr(22,function(){});n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Siracodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SIRACODIGO",fmt:0,gxz:"Z1102SiraCodigo",gxold:"O1102SiraCodigo",gxvar:"A1102SiraCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1102SiraCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z1102SiraCodigo=n)},v2c:function(){gx.fn.setControlValue("SIRACODIGO",gx.O.A1102SiraCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1102SiraCodigo=this.val())},val:function(){return gx.fn.getControlValue("SIRACODIGO")},nac:function(){return!(gx.text.compare("",this.AV9SiraCodigo)==0)}};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"TABLESPLITTEDSIRACONCODIGO",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"TEXTBLOCKSIRACONCODIGO",format:0,grid:0,ctrltype:"textblock"};n[34]={id:34,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"char",len:10,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Siraconcodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SIRACONCODIGO",fmt:0,gxz:"Z1100SiraConCodigo",gxold:"O1100SiraConCodigo",gxvar:"A1100SiraConCodigo",ucs:[],op:[],ip:[38,66],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1100SiraConCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z1100SiraConCodigo=n)},v2c:function(){gx.fn.setControlValue("SIRACONCODIGO",gx.O.A1100SiraConCodigo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1100SiraConCodigo=this.val())},val:function(){return gx.fn.getControlValue("SIRACONCODIGO")},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(gx.text.compare("",this.AV15Insert_SiraConCodigo)==0)}};this.declareDomainHdlr(38,function(){});n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"decimal",len:6,dec:4,sign:!1,pic:"9.9999",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Sirapropor,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SIRAPROPOR",fmt:0,gxz:"Z1103SiraPropor",gxold:"O1103SiraPropor",gxvar:"A1103SiraPropor",ucs:[],op:[],ip:[43,38,27,22],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1103SiraPropor=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.Z1103SiraPropor=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("SIRAPROPOR",gx.O.A1103SiraPropor,4,gx.decimalPoint);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1103SiraPropor=this.val())},val:function(){return gx.fn.getDecimalValue("SIRAPROPOR",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.declareDomainHdlr(43,function(){});n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"SIRARELSEC_CELL",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Sirarelsec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SIRARELSEC",fmt:0,gxz:"Z2006SiraRelSec",gxold:"O2006SiraRelSec",gxvar:"A2006SiraRelSec",ucs:[],op:[48,43,38,27,22],ip:[48,43,38,27,22],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A2006SiraRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z2006SiraRelSec=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("SIRARELSEC",gx.O.A2006SiraRelSec)},c2v:function(){this.val()!==undefined&&(gx.O.A2006SiraRelSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SIRARELSEC",gx.thousandSeparator)},nac:gx.falseFn};n[54]={id:54,fld:"",grid:0};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"BTNTRN_ENTER",grid:0,evt:"e1435123_client",std:"ENTER"};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"BTNTRN_CANCEL",grid:0,evt:"e1535123_client"};n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"BTNTRN_DELETE",grid:0,evt:"e1635123_client",std:"DELETE"};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"",grid:0};n[63]={id:63,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[64]={id:64,fld:"SECTIONATTRIBUTE_SIRACONCODIGO",grid:0};n[65]={id:65,lvl:0,type:"char",len:10,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Validv_Combosiraconcodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCOMBOSIRACONCODIGO",fmt:0,gxz:"ZV22ComboSiraConCodigo",gxold:"OV22ComboSiraConCodigo",gxvar:"AV22ComboSiraConCodigo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV22ComboSiraConCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.ZV22ComboSiraConCodigo=n)},v2c:function(){gx.fn.setControlValue("vCOMBOSIRACONCODIGO",gx.O.AV22ComboSiraConCodigo,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV22ComboSiraConCodigo=this.val())},val:function(){return gx.fn.getControlValue("vCOMBOSIRACONCODIGO")},nac:gx.falseFn};n[66]={id:66,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV7CliCod)}};this.A1101SiraTipo="";this.Z1101SiraTipo="";this.O1101SiraTipo="";this.A1102SiraCodigo="";this.Z1102SiraCodigo="";this.O1102SiraCodigo="";this.A1100SiraConCodigo="";this.Z1100SiraConCodigo="";this.O1100SiraConCodigo="";this.A1103SiraPropor=0;this.Z1103SiraPropor=0;this.O1103SiraPropor=0;this.A2006SiraRelSec=0;this.Z2006SiraRelSec=0;this.O2006SiraRelSec=0;this.AV22ComboSiraConCodigo="";this.ZV22ComboSiraConCodigo="";this.OV22ComboSiraConCodigo="";this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.AV10WWPContext={UserId:0,UserName:""};this.AV22ComboSiraConCodigo="";this.AV11IsAuthorized=!1;this.AV26Pgmname="";this.AV13TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV27GXV1=0;this.AV15Insert_SiraConCodigo="";this.AV21Combo_DataJson="";this.AV16TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV20ComboSelectedText="";this.AV19ComboSelectedValue="";this.AV7CliCod=0;this.AV8SiraTipo="";this.AV9SiraCodigo="";this.AV14WebSession={};this.A3CliCod=0;this.A1101SiraTipo="";this.A1102SiraCodigo="";this.A1100SiraConCodigo="";this.AV25aplicadoHay=!1;this.A1103SiraPropor=0;this.A2006SiraRelSec=0;this.A2007SiraRelSecCli=0;this.A2008SiraTipoPadre="";this.A2009SiraCodPadre="";this.A2022SiraRelRef="";this.A2026SiraOld="";this.AV18DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV17SiraConCodigo_Data=[];this.Gx_mode="";this.Events={e12352_client:["AFTER TRN",!0],e1435123_client:["ENTER",!0],e1535123_client:["CANCEL",!0],e1335123_client:["COMBO_SIRACONCODIGO.ONOPTIONCLICKED",!1]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV8SiraTipo",fld:"vSIRATIPO",pic:"",hsh:!0},{av:"AV9SiraCodigo",fld:"vSIRACODIGO",pic:"",hsh:!0},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV8SiraTipo",fld:"vSIRATIPO",pic:"",hsh:!0},{av:"AV9SiraCodigo",fld:"vSIRACODIGO",pic:"",hsh:!0},{av:"A2007SiraRelSecCli",fld:"SIRARELSECCLI",pic:"ZZZZZ9"},{av:"A2008SiraTipoPadre",fld:"SIRATIPOPADRE",pic:""},{av:"A2009SiraCodPadre",fld:"SIRACODPADRE",pic:""},{av:"A2022SiraRelRef",fld:"SIRARELREF",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms["AFTER TRN"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{ctrl:"SIRATIPO"},{av:"A1101SiraTipo",fld:"SIRATIPO",pic:""},{av:"A1102SiraCodigo",fld:"SIRACODIGO",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms["COMBO_SIRACONCODIGO.ONOPTIONCLICKED"]=[[{av:"this.COMBO_SIRACONCODIGOContainer.SelectedValue_get",ctrl:"COMBO_SIRACONCODIGO",prop:"SelectedValue_get"},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV22ComboSiraConCodigo",fld:"vCOMBOSIRACONCODIGO",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_SIRATIPO=[[{ctrl:"SIRATIPO"},{av:"A1101SiraTipo",fld:"SIRATIPO",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{ctrl:"SIRATIPO"},{av:"A1101SiraTipo",fld:"SIRATIPO",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_SIRACODIGO=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_SIRACONCODIGO=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1100SiraConCodigo",fld:"SIRACONCODIGO",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_SIRAPROPOR=[[{av:"O1103SiraPropor"},{av:"O1100SiraConCodigo"},{av:"O1102SiraCodigo"},{av:"O1101SiraTipo"},{ctrl:"SIRATIPO"},{av:"A1101SiraTipo",fld:"SIRATIPO",pic:""},{av:"A1102SiraCodigo",fld:"SIRACODIGO",pic:""},{av:"A1100SiraConCodigo",fld:"SIRACONCODIGO",pic:""},{av:"A1103SiraPropor",fld:"SIRAPROPOR",pic:"9.9999"},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:'gx.fn.getCtrlProperty("SIRARELSEC_CELL","Class")',ctrl:"SIRARELSEC_CELL",prop:"Class"},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_SIRARELSEC=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"O1103SiraPropor"},{av:"O1100SiraConCodigo"},{av:"O1102SiraCodigo"},{av:"O1101SiraTipo"},{ctrl:"SIRATIPO"},{av:"A1101SiraTipo",fld:"SIRATIPO",pic:""},{av:"A1102SiraCodigo",fld:"SIRACODIGO",pic:""},{av:"A1100SiraConCodigo",fld:"SIRACONCODIGO",pic:""},{av:"A1103SiraPropor",fld:"SIRAPROPOR",pic:"9.9999"},{av:"AV25aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV25aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALIDV_COMBOSIRACONCODIGO=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EvtParms.VALID_CLICOD=[[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SIRARELSEC"},{av:"A2006SiraRelSec",fld:"SIRARELSEC",pic:"ZZZZZ9"}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV8SiraTipo","vSIRATIPO",0,"char",3,0);this.setVCMap("AV9SiraCodigo","vSIRACODIGO",0,"char",20,0);this.setVCMap("AV15Insert_SiraConCodigo","vINSERT_SIRACONCODIGO",0,"char",10,0);this.setVCMap("AV25aplicadoHay","vAPLICADOHAY",0,"boolean",4,0);this.setVCMap("A2007SiraRelSecCli","SIRARELSECCLI",0,"int",6,0);this.setVCMap("A2008SiraTipoPadre","SIRATIPOPADRE",0,"char",3,0);this.setVCMap("A2009SiraCodPadre","SIRACODPADRE",0,"char",20,0);this.setVCMap("A2022SiraRelRef","SIRARELREF",0,"svchar",40,0);this.setVCMap("A2026SiraOld","SIRAOLD",0,"vchar",2097152,0);this.setVCMap("AV26Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize();this.LvlOlds[123]=["O1103SiraPropor","O1100SiraConCodigo","O1102SiraCodigo","O1101SiraTipo"];this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}});this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}})});gx.wi(function(){gx.createParentObj(this.siradig_codigos)})