gx.evt.autoSkip=!1;gx.define("sexos",!1,function(){var n,t,i;this.ServerClass="sexos";this.PackageName="web";this.ServerFullClass="web.sexos";this.setObjectType("trn");this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7SexoId=gx.fn.getIntegerValue("vSEXOID",gx.thousandSeparator);this.AV13Insert_SexoPaiCod=gx.fn.getIntegerValue("vINSERT_SEXOPAICOD",gx.thousandSeparator);this.AV22Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Sexoid=function(){return this.validCliEvt("Valid_Sexoid",0,function(){try{var n=gx.util.balloon.getNew("SEXOID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Sexopaicod=function(){return this.validSrvEvt("valid_Sexopaicod",0).then(function(n){return n}.closure(this))};this.Valid_Sexobiologico=function(){return this.validCliEvt("Valid_Sexobiologico",0,function(){try{var n=gx.util.balloon.getNew("SEXOBIOLOGICO");if(this.AnyError=0,!(gx.text.compare(this.A1745SexoBiologico,"macho")==0||gx.text.compare(this.A1745SexoBiologico,"hembra")==0||gx.text.compare("",this.A1745SexoBiologico)===0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Sexo Biologico"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Sexoidentidad=function(){return this.validCliEvt("Valid_Sexoidentidad",0,function(){try{var n=gx.util.balloon.getNew("SEXOIDENTIDAD");if(this.AnyError=0,!(gx.text.compare(this.A1746SexoIdentidad,"macho")==0||gx.text.compare(this.A1746SexoIdentidad,"hembra")==0))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Sexo Identidad"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Sexocodfor=function(){return this.validSrvEvt("valid_Sexocodfor",0).then(function(n){return n}.closure(this))};this.Validv_Combosexopaicod=function(){return this.validCliEvt("Validv_Combosexopaicod",0,function(){try{var n=gx.util.balloon.getNew("vCOMBOSEXOPAICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e1353235_client=function(){return this.clearMessages(),this.AV20ComboSexoPaiCod=gx.num.trunc(gx.num.val(this.COMBO_SEXOPAICODContainer.SelectedValue_get),0),this.refreshOutputs([{av:"AV20ComboSexoPaiCod",fld:"vCOMBOSEXOPAICOD",pic:"ZZZ9"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12532_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e1453235_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e1553235_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,59,60,61,62,63,64,65,66,67,68,69,70];this.GXLastCtrlId=70;this.COMBO_SEXOPAICODContainer=gx.uc.getNew(this,30,22,"BootstrapDropDownOptions","COMBO_SEXOPAICODContainer","Combo_sexopaicod","COMBO_SEXOPAICOD");t=this.COMBO_SEXOPAICODContainer;t.setProp("Class","Class","","char");t.setProp("IconType","Icontype","Image","str");t.setProp("Icon","Icon","","str");t.setProp("Caption","Caption","","str");t.setProp("Tooltip","Tooltip","","str");t.setProp("Cls","Cls","ExtendedCombo Attribute","str");t.setDynProp("SelectedValue_set","Selectedvalue_set","","char");t.setProp("SelectedValue_get","Selectedvalue_get","","char");t.setDynProp("SelectedText_set","Selectedtext_set","","char");t.setProp("SelectedText_get","Selectedtext_get","","char");t.setProp("GAMOAuthToken","Gamoauthtoken","","char");t.setProp("DDOInternalName","Ddointernalname","","char");t.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");t.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");t.setDynProp("Enabled","Enabled",!0,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");t.setProp("DataListType","Datalisttype","Dynamic","str");t.setProp("AllowMultipleSelection","Allowmultipleselection",!1,"bool");t.setProp("DataListFixedValues","Datalistfixedvalues","","char");t.setProp("IsGridItem","Isgriditem",!1,"bool");t.setProp("HasDescription","Hasdescription",!1,"bool");t.setProp("DataListProc","Datalistproc","SexosLoadDVCombo","str");t.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix",' "ComboName": "SexoPaiCod", "TrnMode": "INS", "IsDynamicCall": true, "SexoId": 0',"str");t.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");t.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");t.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!1,"boolean");t.setProp("IncludeSelectAllOption","Includeselectalloption",!1,"boolean");t.setProp("EmptyItem","Emptyitem",!1,"bool");t.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");t.setProp("HTMLTemplate","Htmltemplate","","str");t.setProp("MultipleValuesType","Multiplevaluestype","Text","str");t.setProp("LoadingData","Loadingdata","","str");t.setProp("NoResultsFound","Noresultsfound","","str");t.setProp("EmptyItemText","Emptyitemtext","","char");t.setProp("OnlySelectedValues","Onlyselectedvalues","","char");t.setProp("SelectAllText","Selectalltext","","char");t.setProp("MultipleValuesSeparator","Multiplevaluesseparator","","char");t.setProp("AddNewOptionText","Addnewoptiontext","","str");t.addV2CFunction("AV16DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");t.addC2VFunction(function(n){n.ParentObject.AV16DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV16DDO_TitleSettingsIcons)});t.addV2CFunction("AV15SexoPaiCod_Data","vSEXOPAICOD_DATA","SetDropDownOptionsData");t.addC2VFunction(function(n){n.ParentObject.AV15SexoPaiCod_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vSEXOPAICOD_DATA",n.ParentObject.AV15SexoPaiCod_Data)});t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});t.addEventHandler("OnOptionClicked",this.e1353235_client);this.setUserControl(t);this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");i=this.DVPANEL_TABLEATTRIBUTESContainer;i.setProp("Class","Class","","char");i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Width","Width","100%","str");i.setProp("Height","Height","100","str");i.setProp("AutoWidth","Autowidth",!1,"bool");i.setProp("AutoHeight","Autoheight",!0,"bool");i.setProp("Cls","Cls","PanelCard_GrayTitle","str");i.setProp("ShowHeader","Showheader",!0,"bool");i.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");i.setProp("Collapsible","Collapsible",!1,"bool");i.setProp("Collapsed","Collapsed",!1,"bool");i.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");i.setProp("IconPosition","Iconposition","Right","str");i.setProp("AutoScroll","Autoscroll",!1,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});this.setUserControl(i);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEMAINFIX",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Sexoid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOID",fmt:0,gxz:"Z1743SexoId",gxold:"O1743SexoId",gxvar:"A1743SexoId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1743SexoId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1743SexoId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("SEXOID",gx.O.A1743SexoId,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1743SexoId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SEXOID",gx.thousandSeparator)},nac:gx.falseFn};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"TABLESPLITTEDSEXOPAICOD",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,fld:"TEXTBLOCKSEXOPAICOD",format:0,grid:0,ctrltype:"textblock"};n[29]={id:29,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Sexopaicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOPAICOD",fmt:0,gxz:"Z1742SexoPaiCod",gxold:"O1742SexoPaiCod",gxvar:"A1742SexoPaiCod",ucs:[],op:[],ip:[33],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1742SexoPaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1742SexoPaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("SEXOPAICOD",gx.O.A1742SexoPaiCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1742SexoPaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SEXOPAICOD",gx.thousandSeparator)},nac:function(){return gx.text.compare(this.Gx_mode,"INS")==0&&!(0==this.AV13Insert_SexoPaiCod)}};this.declareDomainHdlr(33,function(){});n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXONOMBRE",fmt:0,gxz:"Z1744SexoNombre",gxold:"O1744SexoNombre",gxvar:"A1744SexoNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1744SexoNombre=n)},v2z:function(n){n!==undefined&&(gx.O.Z1744SexoNombre=n)},v2c:function(){gx.fn.setControlValue("SEXONOMBRE",gx.O.A1744SexoNombre,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1744SexoNombre=this.val())},val:function(){return gx.fn.getControlValue("SEXONOMBRE")},nac:gx.falseFn};this.declareDomainHdlr(38,function(){});n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Sexobiologico,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOBIOLOGICO",fmt:0,gxz:"Z1745SexoBiologico",gxold:"O1745SexoBiologico",gxvar:"A1745SexoBiologico",ucs:[],op:[43],ip:[43],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A1745SexoBiologico=n)},v2z:function(n){n!==undefined&&(gx.O.Z1745SexoBiologico=n)},v2c:function(){gx.fn.setComboBoxValue("SEXOBIOLOGICO",gx.O.A1745SexoBiologico);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1745SexoBiologico=this.val())},val:function(){return gx.fn.getControlValue("SEXOBIOLOGICO")},nac:gx.falseFn};this.declareDomainHdlr(43,function(){});n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Sexoidentidad,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOIDENTIDAD",fmt:0,gxz:"Z1746SexoIdentidad",gxold:"O1746SexoIdentidad",gxvar:"A1746SexoIdentidad",ucs:[],op:[48],ip:[48],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A1746SexoIdentidad=n)},v2z:function(n){n!==undefined&&(gx.O.Z1746SexoIdentidad=n)},v2c:function(){gx.fn.setComboBoxValue("SEXOIDENTIDAD",gx.O.A1746SexoIdentidad);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1746SexoIdentidad=this.val())},val:function(){return gx.fn.getControlValue("SEXOIDENTIDAD")},nac:gx.falseFn};this.declareDomainHdlr(48,function(){});n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Sexocodfor,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SEXOCODFOR",fmt:0,gxz:"Z2092SexoCodFor",gxold:"O2092SexoCodFor",gxvar:"A2092SexoCodFor",ucs:[],op:[],ip:[22,53,33],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2092SexoCodFor=n)},v2z:function(n){n!==undefined&&(gx.O.Z2092SexoCodFor=n)},v2c:function(){gx.fn.setControlValue("SEXOCODFOR",gx.O.A2092SexoCodFor,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2092SexoCodFor=this.val())},val:function(){return gx.fn.getControlValue("SEXOCODFOR")},nac:gx.falseFn};this.declareDomainHdlr(53,function(){});n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"BTNTRN_ENTER",grid:0,evt:"e1453235_client",std:"ENTER"};n[62]={id:62,fld:"",grid:0};n[63]={id:63,fld:"BTNTRN_CANCEL",grid:0,evt:"e1553235_client"};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"BTNTRN_DELETE",grid:0,evt:"e1653235_client",std:"DELETE"};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"",grid:0};n[68]={id:68,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[69]={id:69,fld:"SECTIONATTRIBUTE_SEXOPAICOD",grid:0};n[70]={id:70,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Validv_Combosexopaicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCOMBOSEXOPAICOD",fmt:0,gxz:"ZV20ComboSexoPaiCod",gxold:"OV20ComboSexoPaiCod",gxvar:"AV20ComboSexoPaiCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV20ComboSexoPaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV20ComboSexoPaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCOMBOSEXOPAICOD",gx.O.AV20ComboSexoPaiCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV20ComboSexoPaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCOMBOSEXOPAICOD",gx.thousandSeparator)},nac:gx.falseFn};this.A1743SexoId=0;this.Z1743SexoId=0;this.O1743SexoId=0;this.A1742SexoPaiCod=0;this.Z1742SexoPaiCod=0;this.O1742SexoPaiCod=0;this.A1744SexoNombre="";this.Z1744SexoNombre="";this.O1744SexoNombre="";this.A1745SexoBiologico="";this.Z1745SexoBiologico="";this.O1745SexoBiologico="";this.A1746SexoIdentidad="";this.Z1746SexoIdentidad="";this.O1746SexoIdentidad="";this.A2092SexoCodFor="";this.Z2092SexoCodFor="";this.O2092SexoCodFor="";this.AV20ComboSexoPaiCod=0;this.ZV20ComboSexoPaiCod=0;this.OV20ComboSexoPaiCod=0;this.AV8WWPContext={UserId:0,UserName:""};this.AV20ComboSexoPaiCod=0;this.AV9IsAuthorized=!1;this.AV22Pgmname="";this.AV11TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV23GXV1=0;this.AV13Insert_SexoPaiCod=0;this.AV19Combo_DataJson="";this.AV14TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV18ComboSelectedText="";this.AV17ComboSelectedValue="";this.AV7SexoId=0;this.AV12WebSession={};this.A1743SexoId=0;this.A1742SexoPaiCod=0;this.A1744SexoNombre="";this.A1745SexoBiologico="";this.A1746SexoIdentidad="";this.A2092SexoCodFor="";this.AV16DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV15SexoPaiCod_Data=[];this.Gx_mode="";this.Events={e12532_client:["AFTER TRN",!0],e1453235_client:["ENTER",!0],e1553235_client:["CANCEL",!0],e1353235_client:["COMBO_SEXOPAICOD.ONOPTIONCLICKED",!1]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7SexoId",fld:"vSEXOID",pic:"Z9",hsh:!0}],[]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7SexoId",fld:"vSEXOID",pic:"Z9",hsh:!0},{av:"A1743SexoId",fld:"SEXOID",pic:"Z9"}],[]];this.EvtParms["AFTER TRN"]=[[],[]];this.EvtParms["COMBO_SEXOPAICOD.ONOPTIONCLICKED"]=[[{av:"this.COMBO_SEXOPAICODContainer.SelectedValue_get",ctrl:"COMBO_SEXOPAICOD",prop:"SelectedValue_get"}],[{av:"AV20ComboSexoPaiCod",fld:"vCOMBOSEXOPAICOD",pic:"ZZZ9"}]];this.EvtParms.VALID_SEXOID=[[],[]];this.EvtParms.VALID_SEXOPAICOD=[[{av:"A1742SexoPaiCod",fld:"SEXOPAICOD",pic:"ZZZ9"}],[]];this.EvtParms.VALID_SEXOBIOLOGICO=[[{ctrl:"SEXOBIOLOGICO"},{av:"A1745SexoBiologico",fld:"SEXOBIOLOGICO",pic:""}],[{ctrl:"SEXOBIOLOGICO"},{av:"A1745SexoBiologico",fld:"SEXOBIOLOGICO",pic:""}]];this.EvtParms.VALID_SEXOIDENTIDAD=[[{ctrl:"SEXOIDENTIDAD"},{av:"A1746SexoIdentidad",fld:"SEXOIDENTIDAD",pic:""}],[{ctrl:"SEXOIDENTIDAD"},{av:"A1746SexoIdentidad",fld:"SEXOIDENTIDAD",pic:""}]];this.EvtParms.VALID_SEXOCODFOR=[[{av:"A1742SexoPaiCod",fld:"SEXOPAICOD",pic:"ZZZ9"},{av:"A2092SexoCodFor",fld:"SEXOCODFOR",pic:""},{av:"A1743SexoId",fld:"SEXOID",pic:"Z9"}],[]];this.EvtParms.VALIDV_COMBOSEXOPAICOD=[[],[]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("AV7SexoId","vSEXOID",0,"int",2,0);this.setVCMap("AV13Insert_SexoPaiCod","vINSERT_SEXOPAICOD",0,"int",4,0);this.setVCMap("AV22Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.Initialize();this.setSDTMapping("WWPBaseObjects\\WWPTransactionContext",{Attributes:{sdt:"WWPBaseObjects\\WWPTransactionContext.Attribute"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}})});gx.wi(function(){gx.createParentObj(this.sexos)})