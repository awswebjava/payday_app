gx.evt.autoSkip=!1;gx.define("f1357_alta",!1,function(){var t,n;this.ServerClass="f1357_alta";this.PackageName="web";this.ServerFullClass="web.f1357_alta";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.A3CliCod=gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator);this.A1EmpCod=gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator);this.A31LiqNro=gx.fn.getIntegerValue("LIQNRO",gx.thousandSeparator);this.AV8EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.A283LiqPeriodo=gx.fn.getDateValue("LIQPERIODO");this.A32TLiqCod=gx.fn.getControlValue("TLIQCOD");this.A6LegNumero=gx.fn.getIntegerValue("LEGNUMERO",gx.thousandSeparator);this.AV13LegNumero=gx.fn.getControlValue("vLEGNUMERO");this.AV31Pgmname=gx.fn.getControlValue("vPGMNAME");this.AV24AdelantoTipo=gx.fn.getIntegerValue("vADELANTOTIPO",gx.thousandSeparator);this.AV19Modo=gx.fn.getControlValue("vMODO");this.AV13LegNumero=gx.fn.getControlValue("vLEGNUMERO")};this.Validv_Liqpermes=function(){return this.validCliEvt("Validv_Liqpermes",0,function(){try{var n=gx.util.balloon.getNew("vLIQPERMES");if(this.AnyError=0,!(this.AV10LiqPerMes==1||this.AV10LiqPerMes==2||this.AV10LiqPerMes==3||this.AV10LiqPerMes==4||this.AV10LiqPerMes==5||this.AV10LiqPerMes==6||this.AV10LiqPerMes==7||this.AV10LiqPerMes==8||this.AV10LiqPerMes==9||this.AV10LiqPerMes==10||this.AV10LiqPerMes==11||this.AV10LiqPerMes==12))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("Liq Per Mes"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Validv_F1357ctipopre=function(){return this.validCliEvt("Validv_F1357ctipopre",0,function(){try{var n=gx.util.balloon.getNew("vF1357CTIPOPRE");if(this.AnyError=0,!(this.AV11F1357CTipoPre==1||this.AV11F1357CTipoPre==2||this.AV11F1357CTipoPre==3))try{n.setError(gx.text.format(gx.getMessage("GXSPC_OutOfRange"),gx.getMessage("F1357 CTipo Pre"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.s122_client=function(){gx.text.compare(this.AV12AplicaA,gx.getMessage("TODOS"))==0?gx.fn.setCtrlProperty("TABLESPLITTEDLEGNUMERO","Visible",!1):gx.fn.setCtrlProperty("TABLESPLITTEDLEGNUMERO","Visible",!0)};this.e179d1_client=function(){return this.clearMessages(),gx.json.SDTFromJson(this.AV13LegNumero,"undefined",this.COMBO_LEGNUMEROContainer.SelectedValue_get),this.refreshOutputs([{av:"AV13LegNumero",fld:"vLEGNUMERO",pic:""}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e189d1_client=function(){return this.clearMessages(),this.s122_client(),this.refreshOutputs([{av:'gx.fn.getCtrlProperty("TABLESPLITTEDLEGNUMERO","Visible")',ctrl:"TABLESPLITTEDLEGNUMERO",prop:"Visible"}]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e129d2_client=function(){return this.executeServerEvent("'DOCONFIRMAR'",!1,null,!1,!1)};this.e139d2_client=function(){return this.executeServerEvent("'DOCANCELAR'",!1,null,!1,!1)};this.e159d2_client=function(){return this.executeServerEvent("'DOVOLVER'",!0,null,!1,!1)};this.e199d2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e209d2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,45,46,47,48,49];this.GXLastCtrlId=49;this.COMBO_LEGNUMEROContainer=gx.uc.getNew(this,39,17,"BootstrapDropDownOptions","COMBO_LEGNUMEROContainer","Combo_legnumero","COMBO_LEGNUMERO");n=this.COMBO_LEGNUMEROContainer;n.setProp("Class","Class","","char");n.setProp("IconType","Icontype","Image","str");n.setProp("Icon","Icon","","str");n.setProp("Caption","Caption","","str");n.setProp("Tooltip","Tooltip","","str");n.setProp("Cls","Cls","ExtendedCombo Attribute","str");n.setDynProp("SelectedValue_set","Selectedvalue_set","","char");n.setProp("SelectedValue_get","Selectedvalue_get","","char");n.setProp("SelectedText_set","Selectedtext_set","","char");n.setProp("SelectedText_get","Selectedtext_get","","char");n.setProp("GAMOAuthToken","Gamoauthtoken","","char");n.setProp("DDOInternalName","Ddointernalname","","char");n.setProp("TitleControlAlign","Titlecontrolalign","Automatic","str");n.setProp("DropDownOptionsType","Dropdownoptionstype","ExtendedComboBox","str");n.setProp("Enabled","Enabled",!0,"bool");n.setProp("Visible","Visible",!0,"bool");n.setProp("TitleControlIdToReplace","Titlecontrolidtoreplace","","str");n.setProp("DataListType","Datalisttype","Dynamic","str");n.setProp("AllowMultipleSelection","Allowmultipleselection",!0,"bool");n.setProp("DataListFixedValues","Datalistfixedvalues","","char");n.setProp("IsGridItem","Isgriditem",!1,"bool");n.setProp("HasDescription","Hasdescription",!1,"bool");n.setProp("DataListProc","Datalistproc","","str");n.setProp("DataListProcParametersPrefix","Datalistprocparametersprefix","","str");n.setProp("RemoteServicesParameters","Remoteservicesparameters","","str");n.setProp("DataListUpdateMinimumCharacters","Datalistupdateminimumcharacters",0,"num");n.setProp("IncludeOnlySelectedOption","Includeonlyselectedoption",!0,"bool");n.setProp("IncludeSelectAllOption","Includeselectalloption",!0,"bool");n.setProp("EmptyItem","Emptyitem",!1,"bool");n.setProp("IncludeAddNewOption","Includeaddnewoption",!1,"bool");n.setProp("HTMLTemplate","Htmltemplate","","str");n.setProp("MultipleValuesType","Multiplevaluestype","Tags","str");n.setProp("LoadingData","Loadingdata","","char");n.setProp("NoResultsFound","Noresultsfound","","char");n.setProp("EmptyItemText","Emptyitemtext","","char");n.setProp("OnlySelectedValues","Onlyselectedvalues","","str");n.setProp("SelectAllText","Selectalltext","","str");n.setProp("MultipleValuesSeparator","Multiplevaluesseparator",", ","str");n.setProp("AddNewOptionText","Addnewoptiontext","","str");n.addV2CFunction("AV15DDO_TitleSettingsIcons","vDDO_TITLESETTINGSICONS","SetDropDownOptionsTitleSettingsIcons");n.addC2VFunction(function(n){n.ParentObject.AV15DDO_TitleSettingsIcons=n.GetDropDownOptionsTitleSettingsIcons();gx.fn.setControlValue("vDDO_TITLESETTINGSICONS",n.ParentObject.AV15DDO_TitleSettingsIcons)});n.addV2CFunction("AV14LegNumero_Data","vLEGNUMERO_DATA","SetDropDownOptionsData");n.addC2VFunction(function(n){n.ParentObject.AV14LegNumero_Data=n.GetDropDownOptionsData();gx.fn.setControlValue("vLEGNUMERO_DATA",n.ParentObject.AV14LegNumero_Data)});n.setProp("Gx Control Type","Gxcontroltype","","int");n.setC2ShowFunction(function(n){n.show()});n.addEventHandler("OnOptionClicked",this.e179d1_client);this.setUserControl(n);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLEMAIN",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TABLEMAINFIX",grid:0};t[12]={id:12,fld:"TABLECONTENT",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,fld:"",grid:0};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vLIQPERANO",fmt:0,gxz:"ZV9LiqPerAno",gxold:"OV9LiqPerAno",gxvar:"AV9LiqPerAno",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV9LiqPerAno=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV9LiqPerAno=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vLIQPERANO",gx.O.AV9LiqPerAno,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV9LiqPerAno=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vLIQPERANO",gx.thousandSeparator)},nac:gx.falseFn};t[18]={id:18,fld:"",grid:0};t[19]={id:19,fld:"",grid:0};t[20]={id:20,fld:"",grid:0};t[21]={id:21,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:0,grid:0,gxgrid:null,fnc:this.Validv_Liqpermes,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vLIQPERMES",fmt:0,gxz:"ZV10LiqPerMes",gxold:"OV10LiqPerMes",gxvar:"AV10LiqPerMes",ucs:[],op:[21],ip:[21],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.AV10LiqPerMes=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV10LiqPerMes=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("vLIQPERMES",gx.O.AV10LiqPerMes)},c2v:function(){this.val()!==undefined&&(gx.O.AV10LiqPerMes=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vLIQPERMES",gx.thousandSeparator)},nac:gx.falseFn};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,fld:"",grid:0};t[25]={id:25,fld:"",grid:0};t[26]={id:26,lvl:0,type:"int",len:1,dec:0,sign:!1,pic:"9",ro:0,grid:0,gxgrid:null,fnc:this.Validv_F1357ctipopre,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vF1357CTIPOPRE",fmt:0,gxz:"ZV11F1357CTipoPre",gxold:"OV11F1357CTipoPre",gxvar:"AV11F1357CTipoPre",ucs:[],op:[26],ip:[26],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.AV11F1357CTipoPre=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV11F1357CTipoPre=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("vF1357CTIPOPRE",gx.O.AV11F1357CTipoPre)},c2v:function(){this.val()!==undefined&&(gx.O.AV11F1357CTipoPre=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vF1357CTIPOPRE",gx.thousandSeparator)},nac:gx.falseFn};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"",grid:0};t[30]={id:30,fld:"",grid:0};t[31]={id:31,lvl:0,type:"char",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:"e189d1_client",evt_cvcing:null,rgrid:[],fld:"vAPLICAA",fmt:0,gxz:"ZV12AplicaA",gxold:"OV12AplicaA",gxvar:"AV12AplicaA",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"radio",v2v:function(n){n!==undefined&&(gx.O.AV12AplicaA=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12AplicaA=n)},v2c:function(){gx.fn.setRadioValue("vAPLICAA",gx.O.AV12AplicaA)},c2v:function(){this.val()!==undefined&&(gx.O.AV12AplicaA=this.val())},val:function(){return gx.fn.getControlValue("vAPLICAA")},nac:gx.falseFn};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"TABLESPLITTEDLEGNUMERO",grid:0};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"TEXTBLOCKCOMBO_LEGNUMERO",format:0,grid:0,ctrltype:"textblock"};t[38]={id:38,fld:"",grid:0};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"",grid:0};t[47]={id:47,fld:"BTNCONFIRMAR",grid:0,evt:"e129d2_client"};t[48]={id:48,fld:"",grid:0};t[49]={id:49,fld:"BTNCANCELAR",grid:0,evt:"e139d2_client"};this.AV9LiqPerAno=0;this.ZV9LiqPerAno=0;this.OV9LiqPerAno=0;this.AV10LiqPerMes=0;this.ZV10LiqPerMes=0;this.OV10LiqPerMes=0;this.AV11F1357CTipoPre=0;this.ZV11F1357CTipoPre=0;this.OV11F1357CTipoPre=0;this.AV12AplicaA="";this.ZV12AplicaA="";this.OV12AplicaA="";this.AV9LiqPerAno=0;this.AV10LiqPerMes=0;this.AV11F1357CTipoPre=0;this.AV12AplicaA="";this.AV15DDO_TitleSettingsIcons={Default_fi:"",Filtered_fi:"",SortedASC_fi:"",SortedDSC_fi:"",FilteredSortedASC_fi:"",FilteredSortedDSC_fi:"",OptionSortASC_fi:"",OptionSortDSC_fi:"",OptionApplyFilter_fi:"",OptionFilteringData_fi:"",OptionCleanFilters_fi:"",SelectedOption_fi:"",MultiselOption_fi:"",MultiselSelOption_fi:"",TreeviewCollapse_fi:"",TreeviewExpand_fi:"",FixLeft_fi:"",FixRight_fi:"",OptionGroup_fi:""};this.AV19Modo="";this.AV7CliCod=0;this.AV8EmpCod=0;this.A1EmpCod=0;this.A3CliCod=0;this.A6LegNumero=0;this.A250LegIdNomApe="";this.A31LiqNro=0;this.A283LiqPeriodo=gx.date.nullDate();this.A32TLiqCod="";this.AV13LegNumero=[];this.AV31Pgmname="";this.AV24AdelantoTipo=0;this.Events={e129d2_client:["'DOCONFIRMAR'",!0],e139d2_client:["'DOCANCELAR'",!0],e159d2_client:["'DOVOLVER'",!0],e199d2_client:["ENTER",!0],e209d2_client:["CANCEL",!0],e179d1_client:["COMBO_LEGNUMERO.ONOPTIONCLICKED",!1],e189d1_client:["VAPLICAA.CONTROLVALUECHANGED",!1]};this.EvtParms.REFRESH=[[{ctrl:"vAPLICAA"},{av:"AV12AplicaA",fld:"vAPLICAA",pic:""},{av:"AV31Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV24AdelantoTipo",fld:"vADELANTOTIPO",pic:"9",hsh:!0}],[{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9"}]];this.EvtParms["'DOCONFIRMAR'"]=[[{ctrl:"vF1357CTIPOPRE"},{av:"AV11F1357CTipoPre",fld:"vF1357CTIPOPRE",pic:"9"},{ctrl:"vLIQPERMES"},{av:"AV10LiqPerMes",fld:"vLIQPERMES",pic:"Z9"},{av:"AV9LiqPerAno",fld:"vLIQPERANO",pic:"ZZZ9"},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A31LiqNro",fld:"LIQNRO",pic:"ZZZZZZZ9"},{av:"AV8EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"A283LiqPeriodo",fld:"LIQPERIODO",pic:""},{av:"A32TLiqCod",fld:"TLIQCOD",pic:""},{ctrl:"vAPLICAA"},{av:"AV12AplicaA",fld:"vAPLICAA",pic:""},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"AV13LegNumero",fld:"vLEGNUMERO",pic:""},{av:"AV31Pgmname",fld:"vPGMNAME",pic:"",hsh:!0},{av:"AV24AdelantoTipo",fld:"vADELANTOTIPO",pic:"9",hsh:!0},{av:"AV19Modo",fld:"vMODO",pic:""}],[{av:"AV18LiqPeriodo",fld:"vLIQPERIODO",pic:""},{av:"AV22egresoTLiqCod",fld:"vEGRESOTLIQCOD",pic:""},{av:"AV13LegNumero",fld:"vLEGNUMERO",pic:""}]];this.EvtParms["'DOCANCELAR'"]=[[{av:"AV8EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV19Modo",fld:"vMODO",pic:""}],[]];this.EvtParms["COMBO_LEGNUMERO.ONOPTIONCLICKED"]=[[{av:"this.COMBO_LEGNUMEROContainer.SelectedValue_get",ctrl:"COMBO_LEGNUMERO",prop:"SelectedValue_get"}],[{av:"AV13LegNumero",fld:"vLEGNUMERO",pic:""}]];this.EvtParms["'DOVOLVER'"]=[[{av:"AV8EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV19Modo",fld:"vMODO",pic:""}],[]];this.EvtParms["VAPLICAA.CONTROLVALUECHANGED"]=[[{ctrl:"vAPLICAA"},{av:"AV12AplicaA",fld:"vAPLICAA",pic:""}],[{av:'gx.fn.getCtrlProperty("TABLESPLITTEDLEGNUMERO","Visible")',ctrl:"TABLESPLITTEDLEGNUMERO",prop:"Visible"}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALIDV_LIQPERMES=[[],[]];this.EvtParms.VALIDV_F1357CTIPOPRE=[[],[]];this.setVCMap("AV7CliCod","vCLICOD",0,"int",6,0);this.setVCMap("A3CliCod","CLICOD",0,"int",6,0);this.setVCMap("A1EmpCod","EMPCOD",0,"int",4,0);this.setVCMap("A31LiqNro","LIQNRO",0,"int",8,0);this.setVCMap("AV8EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("A283LiqPeriodo","LIQPERIODO",0,"date",8,0);this.setVCMap("A32TLiqCod","TLIQCOD",0,"char",20,0);this.setVCMap("A6LegNumero","LEGNUMERO",0,"int",8,0);this.setVCMap("AV13LegNumero","vLEGNUMERO",0,"Collint",0,0);this.setVCMap("AV31Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("AV24AdelantoTipo","vADELANTOTIPO",0,"int",1,0);this.setVCMap("AV19Modo","vMODO",0,"char",3,0);this.setVCMap("AV13LegNumero","vLEGNUMERO",0,"Collint",0,0);this.Initialize();this.setSDTMapping("WWPBaseObjects\\DVB_SDTComboData.Item",{Title:{extr:"T"},Children:{extr:"C"}});this.setSDTMapping("WWPBaseObjects\\DVB_SDTDropDownOptionsTitleSettingsIcons",{Default_fi:{extr:"def"},Filtered_fi:{extr:"fil"},SortedASC_fi:{extr:"asc"},SortedDSC_fi:{extr:"dsc"},FilteredSortedASC_fi:{extr:"fasc"},FilteredSortedDSC_fi:{extr:"fdsc"},OptionSortASC_fi:{extr:"osasc"},OptionSortDSC_fi:{extr:"osdsc"},OptionApplyFilter_fi:{extr:"app"},OptionFilteringData_fi:{extr:"fildata"},OptionCleanFilters_fi:{extr:"cle"},SelectedOption_fi:{extr:"selo"},MultiselOption_fi:{extr:"mul"},MultiselSelOption_fi:{extr:"muls"},TreeviewCollapse_fi:{extr:"tcol"},TreeviewExpand_fi:{extr:"texp"},FixLeft_fi:{extr:"fixl"},FixRight_fi:{extr:"fixr"},OptionGroup_fi:{extr:"og"}})});gx.wi(function(){gx.createParentObj(this.f1357_alta)})