gx.evt.autoSkip=!1;gx.define("legajos",!0,function(n){var t,i;this.ServerClass="legajos";this.PackageName="web";this.ServerFullClass="web.legajos";this.setObjectType("trn");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A251LegNombre=gx.fn.getControlValue("LEGNOMBRE");this.A591LegNomApe=gx.fn.getControlValue("LEGNOMAPE");this.A93LegId=gx.fn.getControlValue("LEGID");this.A250LegIdNomApe=gx.fn.getControlValue("LEGIDNOMAPE");this.A1576LegConveVersionCli=gx.fn.getIntegerValue("LEGCONVEVERSIONCLI",gx.thousandSeparator);this.A22LegPaiCod=gx.fn.getIntegerValue("LEGPAICOD",gx.thousandSeparator);this.A937LegConveCodigo=gx.fn.getControlValue("LEGCONVECODIGO");this.A235LegClase=gx.fn.getIntegerValue("LEGCLASE",gx.thousandSeparator);this.A233LegBasico=gx.fn.getDecimalValue("LEGBASICO",gx.thousandSeparator,gx.decimalPoint);this.A329SecDescrip=gx.fn.getControlValue("SECDESCRIP");this.A675SecDescripSinAc=gx.fn.getControlValue("SECDESCRIPSINAC");this.A291LpgDescri=gx.fn.getControlValue("LPGDESCRI");this.A677LpgDescriSinAc=gx.fn.getControlValue("LPGDESCRISINAC");this.A117BanDescrip=gx.fn.getControlValue("BANDESCRIP");this.A679BanDescripSinAc=gx.fn.getControlValue("BANDESCRIPSINAC");this.A331SinDescrip=gx.fn.getControlValue("SINDESCRIP");this.A680SinDescripSinAc=gx.fn.getControlValue("SINDESCRIPSINAC");this.A307OsoDescrip=gx.fn.getControlValue("OSODESCRIP");this.A681OsoDescripSinAc=gx.fn.getControlValue("OSODESCRIPSINAC");this.A392OsoSigla=gx.fn.getControlValue("OSOSIGLA");this.A306OsoC3992=gx.fn.getControlValue("OSOC3992");this.A555OsoSiglaYDesc=gx.fn.getControlValue("OSOSIGLAYDESC");this.A237LegConvenio=gx.fn.getControlValue("LEGCONVENIO");this.AV7CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV8EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV10LegNumero=gx.fn.getIntegerValue("vLEGNUMERO",gx.thousandSeparator);this.AV33Insert_LegSexo=gx.fn.getIntegerValue("vINSERT_LEGSEXO",gx.thousandSeparator);this.A263LegSexo=gx.fn.getIntegerValue("LEGSEXO",gx.thousandSeparator);this.AV34Insert_LegEstadoCivil=gx.fn.getIntegerValue("vINSERT_LEGESTADOCIVIL",gx.thousandSeparator);this.A243LegEstadoCivil=gx.fn.getIntegerValue("LEGESTADOCIVIL",gx.thousandSeparator);this.AV16Insert_LegNacionCod=gx.fn.getIntegerValue("vINSERT_LEGNACIONCOD",gx.thousandSeparator);this.A21LegNacionCod=gx.fn.getIntegerValue("LEGNACIONCOD",gx.thousandSeparator);this.AV35Insert_LegPaiCod=gx.fn.getIntegerValue("vINSERT_LEGPAICOD",gx.thousandSeparator);this.AV36Insert_LegProvCod=gx.fn.getIntegerValue("vINSERT_LEGPROVCOD",gx.thousandSeparator);this.A23LegProvCod=gx.fn.getIntegerValue("LEGPROVCOD",gx.thousandSeparator);this.AV37Insert_LegLocCod=gx.fn.getIntegerValue("vINSERT_LEGLOCCOD",gx.thousandSeparator);this.A24LegLocCod=gx.fn.getIntegerValue("LEGLOCCOD",gx.thousandSeparator);this.AV17Insert_LegMegCodigo=gx.fn.getControlValue("vINSERT_LEGMEGCODIGO");this.A1583LegMegCodigo=gx.fn.getControlValue("LEGMEGCODIGO");this.AV18Insert_LegSecCodigo=gx.fn.getControlValue("vINSERT_LEGSECCODIGO");this.A1579LegSecCodigo=gx.fn.getControlValue("LEGSECCODIGO");this.AV19Insert_LegLpgCodigo=gx.fn.getControlValue("vINSERT_LEGLPGCODIGO");this.A1581LegLpgCodigo=gx.fn.getControlValue("LEGLPGCODIGO");this.AV20Insert_LegBanCod=gx.fn.getControlValue("vINSERT_LEGBANCOD");this.A1582LegBanCod=gx.fn.getControlValue("LEGBANCOD");this.AV38Insert_LegSinCod=gx.fn.getControlValue("vINSERT_LEGSINCOD");this.A910LegSinCod=gx.fn.getControlValue("LEGSINCOD");this.AV21Insert_LegOsoCod=gx.fn.getControlValue("vINSERT_LEGOSOCOD");this.A1580LegOsoCod=gx.fn.getControlValue("LEGOSOCOD");this.AV22Insert_LegActCodigo=gx.fn.getControlValue("vINSERT_LEGACTCODIGO");this.A15LegActCodigo=gx.fn.getControlValue("LEGACTCODIGO");this.AV23Insert_MprCod=gx.fn.getControlValue("vINSERT_MPRCOD");this.A18MprCod=gx.fn.getControlValue("MPRCOD");this.AV24Insert_ZonCod=gx.fn.getControlValue("vINSERT_ZONCOD");this.A20ZonCod=gx.fn.getControlValue("ZONCOD");this.AV25Insert_CondiCodigo=gx.fn.getIntegerValue("vINSERT_CONDICODIGO",gx.thousandSeparator);this.A17CondiCodigo=gx.fn.getIntegerValue("CONDICODIGO",gx.thousandSeparator);this.AV26Insert_SinieCodigo=gx.fn.getControlValue("vINSERT_SINIECODIGO");this.A19SinieCodigo=gx.fn.getControlValue("SINIECODIGO");this.AV27Insert_LegPuesCodigo=gx.fn.getControlValue("vINSERT_LEGPUESCODIGO");this.A1578LegPuesCodigo=gx.fn.getControlValue("LEGPUESCODIGO");this.AV28Insert_LegSucCodigo=gx.fn.getControlValue("vINSERT_LEGSUCCODIGO");this.A1577LegSucCodigo=gx.fn.getControlValue("LEGSUCCODIGO");this.AV29Insert_LegSitRevEgreso=gx.fn.getIntegerValue("vINSERT_LEGSITREVEGRESO",gx.thousandSeparator);this.A1603LegSitRevEgreso=gx.fn.getIntegerValue("LEGSITREVEGRESO",gx.thousandSeparator);this.A249LegFoto=gx.fn.getBlobValue("LEGFOTO");this.A266LegTipDoc=gx.fn.getIntegerValue("LEGTIPDOC",gx.thousandSeparator);this.A257LegNumDoc=gx.fn.getControlValue("LEGNUMDOC");this.A246LegFecNac=gx.fn.getDateValue("LEGFECNAC");this.A239LegCUIL=gx.fn.getIntegerValue("LEGCUIL",gx.thousandSeparator);this.A241LegDiscapacidad=gx.fn.getIntegerValue("LEGDISCAPACIDAD",gx.thousandSeparator);this.A242LegDomici=gx.fn.getControlValue("LEGDOMICI");this.A479LegEmail=gx.fn.getControlValue("LEGEMAIL");this.A236LegCodPos=gx.fn.getControlValue("LEGCODPOS");this.A265LegTelefono=gx.fn.getControlValue("LEGTELEFONO");this.A245LegFecIngreso=gx.fn.getDateValue("LEGFECINGRESO");this.A244LegFecEgreso=gx.fn.getDateValue("LEGFECEGRESO");this.A939LegCatCodigo=gx.fn.getControlValue("LEGCATCODIGO");this.A248LegFormaPago=gx.fn.getIntegerValue("LEGFORMAPAGO",gx.thousandSeparator);this.A231LegBanSuc=gx.fn.getControlValue("LEGBANSUC");this.A232LegBanTipCuen=gx.fn.getControlValue("LEGBANTIPCUEN");this.A247LegFecUltMod=gx.fn.getDateValue("LEGFECULTMOD");this.A238LegCuentaBanc=gx.fn.getControlValue("LEGCUENTABANC");this.A253LegLicInicio=gx.fn.getDateValue("LEGLICINICIO");this.A252LegLicFinal=gx.fn.getDateValue("LEGLICFINAL");this.A234LegCBU=gx.fn.getControlValue("LEGCBU");this.A262LegSCVO=gx.fn.getControlValue("LEGSCVO");this.A228LegActivo=gx.fn.getControlValue("LEGACTIVO");this.A264LegSueldoFuera=gx.fn.getDecimalValue("LEGSUELDOFUERA",gx.thousandSeparator,gx.decimalPoint);this.A515LegObs=gx.fn.getControlValue("LEGOBS");this.A630LegFecImportacion=gx.fn.getDateTimeValue("LEGFECIMPORTACION");this.A877LegAgenReten=gx.fn.getControlValue("LEGAGENRETEN");this.A879LegContinua=gx.fn.getControlValue("LEGCONTINUA");this.A942LegRecalcLiq=gx.fn.getControlValue("LEGRECALCLIQ");this.A1016LegJubilado=gx.fn.getControlValue("LEGJUBILADO");this.A1023LegHorasDia=gx.fn.getDecimalValue("LEGHORASDIA",gx.thousandSeparator,gx.decimalPoint);this.A1268LegHorasSem=gx.fn.getDecimalValue("LEGHORASSEM",gx.thousandSeparator,gx.decimalPoint);this.A1245LegTrabLun=gx.fn.getControlValue("LEGTRABLUN");this.A1246LegTrabMar=gx.fn.getControlValue("LEGTRABMAR");this.A1247LegTrabMie=gx.fn.getControlValue("LEGTRABMIE");this.A1248LegTrabJue=gx.fn.getControlValue("LEGTRABJUE");this.A1249LegTrabVie=gx.fn.getControlValue("LEGTRABVIE");this.A1250LegTrabSa=gx.fn.getControlValue("LEGTRABSA");this.A1251LegTrabDo=gx.fn.getControlValue("LEGTRABDO");this.A1523LegVacPend=gx.fn.getIntegerValue("LEGVACPEND",gx.thousandSeparator);this.A1531LegFecPreAviso=gx.fn.getDateValue("LEGFECPREAVISO");this.A1759LegPromDias=gx.fn.getControlValue("LEGPROMDIAS");this.A1804LegTitulo=gx.fn.getControlValue("LEGTITULO");this.A1818LegEstado=gx.fn.getIntegerValue("LEGESTADO",gx.thousandSeparator);this.A2267LegIncompleto=gx.fn.getControlValue("LEGINCOMPLETO");this.A1031LegFotoExt=gx.fn.getControlValue("LEGFOTOEXT");this.A1030LegFotoNom=gx.fn.getControlValue("LEGFOTONOM");this.A1235LegReligion=gx.fn.getControlValue("LEGRELIGION");this.A1236LegOrigen=gx.fn.getControlValue("LEGORIGEN");this.A300MegDescrip=gx.fn.getControlValue("MEGDESCRIP");this.A1965EmpOsoCod=gx.fn.getControlValue("EMPOSOCOD");this.A2EmpNom=gx.fn.getControlValue("EMPNOM");this.A45TipEmpleCod=gx.fn.getControlValue("TIPEMPLECOD");this.A684MprDescripSinAc=gx.fn.getControlValue("MPRDESCRIPSINAC");this.A303MprDescrip=gx.fn.getControlValue("MPRDESCRIP");this.A678ZonDescripSinAc=gx.fn.getControlValue("ZONDESCRIPSINAC");this.A342ZonDescrip=gx.fn.getControlValue("ZONDESCRIP");this.A343ZonPorcReduc=gx.fn.getDecimalValue("ZONPORCREDUC",gx.thousandSeparator,gx.decimalPoint);this.A686CondiDescriSinAc=gx.fn.getControlValue("CONDIDESCRISINAC");this.A144CondiDescri=gx.fn.getControlValue("CONDIDESCRI");this.A688SinieDescriSinAc=gx.fn.getControlValue("SINIEDESCRISINAC");this.A333SinieDescri=gx.fn.getControlValue("SINIEDESCRI");this.A258LegPaiNom=gx.fn.getControlValue("LEGPAINOM");this.A260LegProvNom=gx.fn.getControlValue("LEGPROVNOM");this.A255LegLocNom=gx.fn.getControlValue("LEGLOCNOM");this.A256LegNacionalidad=gx.fn.getControlValue("LEGNACIONALIDAD");this.A227LegActDescri=gx.fn.getControlValue("LEGACTDESCRI");this.AV39Pgmname=gx.fn.getControlValue("vPGMNAME");this.Gx_mode=gx.fn.getControlValue("vMODE");this.AV31DetailWCInfo=gx.fn.getControlValue("vDETAILWCINFO");this.AV31DetailWCInfo=gx.fn.getControlValue("vDETAILWCINFO")};this.Valid_Clicod=function(){return this.validCliEvt("Valid_Clicod",0,function(){try{var n=gx.util.balloon.getNew("CLICOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Empcod=function(){return this.validSrvEvt("valid_Empcod",0).then(function(n){return n}.closure(this))};this.Valid_Legnumero=function(){return this.validCliEvt("Valid_Legnumero",0,function(){try{var n=gx.util.balloon.getNew("LEGNUMERO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Legapellido=function(){return this.validCliEvt("Valid_Legapellido",0,function(){try{var n=gx.util.balloon.getNew("LEGAPELLIDO");this.AnyError=0;try{this.A591LegNomApe=gx.text.trim(this.A230LegApellido)+", "+gx.text.trim(this.A251LegNombre)}catch(t){}try{this.A250LegIdNomApe=gx.text.trim(this.A93LegId)+" - "+gx.text.trim(this.A230LegApellido)+", "+gx.text.trim(this.A251LegNombre)}catch(t){}}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e115k23_client=function(){return this.clearMessages(),GlobalEvents.executeMethod("SplitScreen_LoadDetail",[2,this.AV31DetailWCInfo,!1,"legajo"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e135k2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e145k23_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e155k23_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,13,14,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44];this.GXLastCtrlId=44;this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,15,0,"BootstrapPanel",this.CmpContext+"DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");i=this.DVPANEL_TABLEATTRIBUTESContainer;i.setProp("Class","Class","","char");i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Width","Width","100%","str");i.setProp("Height","Height","100","str");i.setProp("AutoWidth","Autowidth",!1,"bool");i.setProp("AutoHeight","Autoheight",!0,"bool");i.setProp("Cls","Cls","PanelCard_GrayTitle","str");i.setProp("ShowHeader","Showheader",!0,"bool");i.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");i.setProp("Collapsible","Collapsible",!1,"bool");i.setProp("Collapsed","Collapsed",!1,"bool");i.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");i.setProp("IconPosition","Iconposition","Right","str");i.setProp("AutoScroll","Autoscroll",!1,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});this.setUserControl(i);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLEMAIN",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TABLECONTENT",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,fld:"",grid:0};t[17]={id:17,fld:"TABLEATTRIBUTES",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,fld:"",grid:0};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV7CliCod)}};t[23]={id:23,fld:"",grid:0};t[24]={id:24,fld:"",grid:0};t[25]={id:25,fld:"",grid:0};t[26]={id:26,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Empcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"EMPCOD",fmt:0,gxz:"Z1EmpCod",gxold:"O1EmpCod",gxvar:"A1EmpCod",ucs:[],op:[],ip:[26,22],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1EmpCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1EmpCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("EMPCOD",gx.O.A1EmpCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1EmpCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("EMPCOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV8EmpCod)}};this.declareDomainHdlr(26,function(){});t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"",grid:0};t[30]={id:30,fld:"",grid:0};t[31]={id:31,lvl:0,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Legnumero,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGNUMERO",fmt:0,gxz:"Z6LegNumero",gxold:"O6LegNumero",gxvar:"A6LegNumero",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A6LegNumero=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z6LegNumero=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("LEGNUMERO",gx.O.A6LegNumero,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A6LegNumero=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("LEGNUMERO",gx.thousandSeparator)},nac:function(){return!(0==this.AV10LegNumero)}};this.declareDomainHdlr(31,function(){});t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"",grid:0};t[35]={id:35,lvl:0,type:"svchar",len:30,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Legapellido,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"LEGAPELLIDO",fmt:0,gxz:"Z230LegApellido",gxold:"O230LegApellido",gxvar:"A230LegApellido",ucs:[],op:[],ip:[35],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A230LegApellido=n)},v2z:function(n){n!==undefined&&(gx.O.Z230LegApellido=n)},v2c:function(){gx.fn.setControlValue("LEGAPELLIDO",gx.O.A230LegApellido,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A230LegApellido=this.val())},val:function(){return gx.fn.getControlValue("LEGAPELLIDO")},nac:gx.falseFn};this.declareDomainHdlr(35,function(){});t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,fld:"",grid:0};t[40]={id:40,fld:"BTNTRN_ENTER",grid:0,evt:"e145k23_client",std:"ENTER"};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"BTNTRN_CANCEL",grid:0,evt:"e115k23_client"};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"BTNTRN_DELETE",grid:0,evt:"e165k23_client",std:"DELETE"};this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1EmpCod=0;this.Z1EmpCod=0;this.O1EmpCod=0;this.A6LegNumero=0;this.Z6LegNumero=0;this.O6LegNumero=0;this.A230LegApellido="";this.Z230LegApellido="";this.O230LegApellido="";this.A1965EmpOsoCod="";this.AV11WWPContext={UserId:0,UserName:""};this.AV12IsAuthorized=!1;this.AV39Pgmname="";this.AV14TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV40GXV1=0;this.AV33Insert_LegSexo=0;this.AV34Insert_LegEstadoCivil=0;this.AV16Insert_LegNacionCod=0;this.AV35Insert_LegPaiCod=0;this.AV36Insert_LegProvCod=0;this.AV37Insert_LegLocCod=0;this.AV17Insert_LegMegCodigo="";this.AV18Insert_LegSecCodigo="";this.AV19Insert_LegLpgCodigo="";this.AV20Insert_LegBanCod="";this.AV38Insert_LegSinCod="";this.AV21Insert_LegOsoCod="";this.AV22Insert_LegActCodigo="";this.AV23Insert_MprCod="";this.AV24Insert_ZonCod="";this.AV25Insert_CondiCodigo=0;this.AV26Insert_SinieCodigo="";this.AV27Insert_LegPuesCodigo="";this.AV28Insert_LegSucCodigo="";this.AV29Insert_LegSitRevEgreso=0;this.AV30TrnContextAtt={AttributeName:"",AttributeValue:""};this.AV7CliCod=0;this.AV8EmpCod=0;this.AV10LegNumero=0;this.AV15WebSession={};this.A3CliCod=0;this.A1EmpCod=0;this.A6LegNumero=0;this.A263LegSexo=0;this.A243LegEstadoCivil=0;this.A21LegNacionCod=0;this.A22LegPaiCod=0;this.A23LegProvCod=0;this.A24LegLocCod=0;this.A1583LegMegCodigo="";this.A1579LegSecCodigo="";this.A1581LegLpgCodigo="";this.A1582LegBanCod="";this.A910LegSinCod="";this.A1580LegOsoCod="";this.A15LegActCodigo="";this.A18MprCod="";this.A20ZonCod="";this.A17CondiCodigo=0;this.A19SinieCodigo="";this.A1578LegPuesCodigo="";this.A1577LegSucCodigo="";this.A1603LegSitRevEgreso=0;this.A237LegConvenio=!1;this.A688SinieDescriSinAc="";this.A686CondiDescriSinAc="";this.A678ZonDescripSinAc="";this.A684MprDescripSinAc="";this.A555OsoSiglaYDesc="";this.A681OsoDescripSinAc="";this.A680SinDescripSinAc="";this.A679BanDescripSinAc="";this.A677LpgDescriSinAc="";this.A675SecDescripSinAc="";this.A233LegBasico=0;this.A250LegIdNomApe="";this.A591LegNomApe="";this.A2EmpNom="";this.A230LegApellido="";this.A251LegNombre="";this.A249LegFoto="";this.A266LegTipDoc=0;this.A257LegNumDoc="";this.A246LegFecNac=gx.date.nullDate();this.A256LegNacionalidad="";this.A239LegCUIL=0;this.A241LegDiscapacidad=0;this.A242LegDomici="";this.A479LegEmail="";this.A236LegCodPos="";this.A258LegPaiNom="";this.A260LegProvNom="";this.A255LegLocNom="";this.A265LegTelefono="";this.A245LegFecIngreso=gx.date.nullDate();this.A244LegFecEgreso=gx.date.nullDate();this.A300MegDescrip="";this.A939LegCatCodigo="";this.A329SecDescrip="";this.A291LpgDescri="";this.A235LegClase=0;this.A248LegFormaPago=0;this.A117BanDescrip="";this.A231LegBanSuc="";this.A232LegBanTipCuen="";this.A331SinDescrip="";this.A307OsoDescrip="";this.A227LegActDescri="";this.A303MprDescrip="";this.A247LegFecUltMod=gx.date.nullDate();this.A238LegCuentaBanc="";this.A253LegLicInicio=gx.date.nullDate();this.A252LegLicFinal=gx.date.nullDate();this.A342ZonDescrip="";this.A343ZonPorcReduc=0;this.A234LegCBU="";this.A262LegSCVO=!1;this.A144CondiDescri="";this.A333SinieDescri="";this.A228LegActivo=!1;this.A264LegSueldoFuera=0;this.A93LegId="";this.A937LegConveCodigo="";this.A45TipEmpleCod="";this.A306OsoC3992="";this.A515LegObs="";this.A630LegFecImportacion=gx.date.nullDate();this.A877LegAgenReten=!1;this.A879LegContinua="";this.A942LegRecalcLiq=!1;this.A1016LegJubilado=!1;this.A1023LegHorasDia=0;this.A1268LegHorasSem=0;this.A1235LegReligion="";this.A1236LegOrigen="";this.A1245LegTrabLun=!1;this.A1246LegTrabMar=!1;this.A1247LegTrabMie=!1;this.A1248LegTrabJue=!1;this.A1249LegTrabVie=!1;this.A1250LegTrabSa=!1;this.A1251LegTrabDo=!1;this.A1523LegVacPend=0;this.A1531LegFecPreAviso=gx.date.nullDate();this.A1576LegConveVersionCli=0;this.A1759LegPromDias="";this.A1804LegTitulo="";this.A1818LegEstado=0;this.A2267LegIncompleto=!1;this.A1031LegFotoExt="";this.A1030LegFotoNom="";this.A392OsoSigla="";this.Gx_mode="";this.AV31DetailWCInfo={Link:"",Title:"",Keys:""};this.Events={e135k2_client:["AFTER TRN",!0],e145k23_client:["ENTER",!0],e155k23_client:["CANCEL",!0],e115k23_client:["'CANCEL'",!1]};this.EvtParms.ENTER=[[{postForm:!0},{sPrefix:!0},{sSFPrefix:!0},{sCompEvt:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!"},{av:"AV7CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{av:"AV8EmpCod",fld:"vEMPCOD",pic:"ZZZ9"},{av:"AV10LegNumero",fld:"vLEGNUMERO",pic:"ZZZZZZZ9"}],[]];this.EvtParms.REFRESH=[[{av:"AV31DetailWCInfo",fld:"vDETAILWCINFO",pic:"",hsh:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!"},{av:"A251LegNombre",fld:"LEGNOMBRE",pic:""},{av:"A266LegTipDoc",fld:"LEGTIPDOC",pic:"9"},{av:"A257LegNumDoc",fld:"LEGNUMDOC",pic:"@!"},{av:"A246LegFecNac",fld:"LEGFECNAC",pic:""},{av:"A239LegCUIL",fld:"LEGCUIL",pic:"ZZ-ZZZZZZZZ-9"},{av:"A241LegDiscapacidad",fld:"LEGDISCAPACIDAD",pic:"9"},{av:"A242LegDomici",fld:"LEGDOMICI",pic:""},{av:"A479LegEmail",fld:"LEGEMAIL",pic:""},{av:"A236LegCodPos",fld:"LEGCODPOS",pic:"@!"},{av:"A265LegTelefono",fld:"LEGTELEFONO",pic:"@!"},{av:"A245LegFecIngreso",fld:"LEGFECINGRESO",pic:""},{av:"A244LegFecEgreso",fld:"LEGFECEGRESO",pic:""},{av:"A939LegCatCodigo",fld:"LEGCATCODIGO",pic:""},{av:"A235LegClase",fld:"LEGCLASE",pic:"9"},{av:"A248LegFormaPago",fld:"LEGFORMAPAGO",pic:"9"},{av:"A231LegBanSuc",fld:"LEGBANSUC",pic:"@!"},{av:"A232LegBanTipCuen",fld:"LEGBANTIPCUEN",pic:""},{av:"A247LegFecUltMod",fld:"LEGFECULTMOD",pic:""},{av:"A238LegCuentaBanc",fld:"LEGCUENTABANC",pic:"@!"},{av:"A253LegLicInicio",fld:"LEGLICINICIO",pic:""},{av:"A252LegLicFinal",fld:"LEGLICFINAL",pic:""},{av:"A234LegCBU",fld:"LEGCBU",pic:""},{av:"A262LegSCVO",fld:"LEGSCVO",pic:""},{av:"A228LegActivo",fld:"LEGACTIVO",pic:""},{av:"A264LegSueldoFuera",fld:"LEGSUELDOFUERA",pic:"ZZ,ZZZ,ZZZ,ZZ9.99"},{av:"A93LegId",fld:"LEGID",pic:""},{av:"A937LegConveCodigo",fld:"LEGCONVECODIGO",pic:""},{av:"A630LegFecImportacion",fld:"LEGFECIMPORTACION",pic:"99/99/99 99:99"},{av:"A877LegAgenReten",fld:"LEGAGENRETEN",pic:""},{av:"A879LegContinua",fld:"LEGCONTINUA",pic:""},{av:"A942LegRecalcLiq",fld:"LEGRECALCLIQ",pic:""},{av:"A1016LegJubilado",fld:"LEGJUBILADO",pic:""},{av:"A1023LegHorasDia",fld:"LEGHORASDIA",pic:"9.9"},{av:"A1268LegHorasSem",fld:"LEGHORASSEM",pic:"Z9.9"},{av:"A1235LegReligion",fld:"LEGRELIGION",pic:""},{av:"A1236LegOrigen",fld:"LEGORIGEN",pic:""},{av:"A1245LegTrabLun",fld:"LEGTRABLUN",pic:""},{av:"A1246LegTrabMar",fld:"LEGTRABMAR",pic:""},{av:"A1247LegTrabMie",fld:"LEGTRABMIE",pic:""},{av:"A1248LegTrabJue",fld:"LEGTRABJUE",pic:""},{av:"A1249LegTrabVie",fld:"LEGTRABVIE",pic:""},{av:"A1250LegTrabSa",fld:"LEGTRABSA",pic:""},{av:"A1251LegTrabDo",fld:"LEGTRABDO",pic:""},{av:"A1523LegVacPend",fld:"LEGVACPEND",pic:"ZZZ9"},{av:"A1531LegFecPreAviso",fld:"LEGFECPREAVISO",pic:""},{av:"A1576LegConveVersionCli",fld:"LEGCONVEVERSIONCLI",pic:"ZZZZZ9"},{av:"A1759LegPromDias",fld:"LEGPROMDIAS",pic:""},{av:"A1804LegTitulo",fld:"LEGTITULO",pic:""},{av:"A1818LegEstado",fld:"LEGESTADO",pic:"9"},{av:"A2267LegIncompleto",fld:"LEGINCOMPLETO",pic:""}],[]];this.EvtParms["AFTER TRN"]=[[{av:"Gx_mode",fld:"vMODE",pic:"@!"},{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A6LegNumero",fld:"LEGNUMERO",pic:"ZZZZZZZ9"},{av:"AV31DetailWCInfo",fld:"vDETAILWCINFO",pic:"",hsh:!0}],[{av:"AV31DetailWCInfo",fld:"vDETAILWCINFO",pic:"",hsh:!0}]];this.EvtParms["'CANCEL'"]=[[{av:"AV31DetailWCInfo",fld:"vDETAILWCINFO",pic:"",hsh:!0}],[]];this.EvtParms.VALID_CLICOD=[[],[]];this.EvtParms.VALID_EMPCOD=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"A1EmpCod",fld:"EMPCOD",pic:"ZZZ9"},{av:"A1965EmpOsoCod",fld:"EMPOSOCOD",pic:""},{av:"A307OsoDescrip",fld:"OSODESCRIP",pic:""},{av:"A2EmpNom",fld:"EMPNOM",pic:"@!"},{av:"A45TipEmpleCod",fld:"TIPEMPLECOD",pic:""},{av:"A306OsoC3992",fld:"OSOC3992",pic:""},{av:"A681OsoDescripSinAc",fld:"OSODESCRIPSINAC",pic:""}],[{av:"A1965EmpOsoCod",fld:"EMPOSOCOD",pic:""},{av:"A2EmpNom",fld:"EMPNOM",pic:"@!"},{av:"A45TipEmpleCod",fld:"TIPEMPLECOD",pic:""},{av:"A307OsoDescrip",fld:"OSODESCRIP",pic:""},{av:"A306OsoC3992",fld:"OSOC3992",pic:""},{av:"A681OsoDescripSinAc",fld:"OSODESCRIPSINAC",pic:""}]];this.EvtParms.VALID_LEGNUMERO=[[],[]];this.EvtParms.VALID_LEGAPELLIDO=[[{av:"A230LegApellido",fld:"LEGAPELLIDO",pic:""}],[]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("A251LegNombre","LEGNOMBRE",0,"svchar",30,0);this.setVCMap("A591LegNomApe","LEGNOMAPE",0,"svchar",100,0);this.setVCMap("A93LegId","LEGID",0,"char",20,0);this.setVCMap("A250LegIdNomApe","LEGIDNOMAPE",0,"svchar",100,0);this.setVCMap("A1576LegConveVersionCli","LEGCONVEVERSIONCLI",0,"int",6,0);this.setVCMap("A22LegPaiCod","LEGPAICOD",0,"int",4,0);this.setVCMap("A937LegConveCodigo","LEGCONVECODIGO",0,"char",20,0);this.setVCMap("A235LegClase","LEGCLASE",0,"int",1,0);this.setVCMap("A233LegBasico","LEGBASICO",0,"decimal",14,2);this.setVCMap("A329SecDescrip","SECDESCRIP",0,"svchar",400,0);this.setVCMap("A675SecDescripSinAc","SECDESCRIPSINAC",0,"svchar",400,0);this.setVCMap("A291LpgDescri","LPGDESCRI",0,"svchar",30,0);this.setVCMap("A677LpgDescriSinAc","LPGDESCRISINAC",0,"svchar",30,0);this.setVCMap("A117BanDescrip","BANDESCRIP",0,"svchar",400,0);this.setVCMap("A679BanDescripSinAc","BANDESCRIPSINAC",0,"svchar",400,0);this.setVCMap("A331SinDescrip","SINDESCRIP",0,"svchar",400,0);this.setVCMap("A680SinDescripSinAc","SINDESCRIPSINAC",0,"svchar",400,0);this.setVCMap("A307OsoDescrip","OSODESCRIP",0,"svchar",400,0);this.setVCMap("A681OsoDescripSinAc","OSODESCRIPSINAC",0,"svchar",400,0);this.setVCMap("A392OsoSigla","OSOSIGLA",0,"char",20,0);this.setVCMap("A306OsoC3992","OSOC3992",0,"char",20,0);this.setVCMap("A555OsoSiglaYDesc","OSOSIGLAYDESC",0,"svchar",400,0);this.setVCMap("A237LegConvenio","LEGCONVENIO",0,"boolean",4,0);this.setVCMap("AV7CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV8EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV10LegNumero","vLEGNUMERO",0,"int",8,0);this.setVCMap("AV33Insert_LegSexo","vINSERT_LEGSEXO",0,"int",2,0);this.setVCMap("A263LegSexo","LEGSEXO",0,"int",2,0);this.setVCMap("AV34Insert_LegEstadoCivil","vINSERT_LEGESTADOCIVIL",0,"int",4,0);this.setVCMap("A243LegEstadoCivil","LEGESTADOCIVIL",0,"int",4,0);this.setVCMap("AV16Insert_LegNacionCod","vINSERT_LEGNACIONCOD",0,"int",4,0);this.setVCMap("A21LegNacionCod","LEGNACIONCOD",0,"int",4,0);this.setVCMap("AV35Insert_LegPaiCod","vINSERT_LEGPAICOD",0,"int",4,0);this.setVCMap("AV36Insert_LegProvCod","vINSERT_LEGPROVCOD",0,"int",4,0);this.setVCMap("A23LegProvCod","LEGPROVCOD",0,"int",4,0);this.setVCMap("AV37Insert_LegLocCod","vINSERT_LEGLOCCOD",0,"int",4,0);this.setVCMap("A24LegLocCod","LEGLOCCOD",0,"int",4,0);this.setVCMap("AV17Insert_LegMegCodigo","vINSERT_LEGMEGCODIGO",0,"char",20,0);this.setVCMap("A1583LegMegCodigo","LEGMEGCODIGO",0,"char",20,0);this.setVCMap("AV18Insert_LegSecCodigo","vINSERT_LEGSECCODIGO",0,"char",20,0);this.setVCMap("A1579LegSecCodigo","LEGSECCODIGO",0,"char",20,0);this.setVCMap("AV19Insert_LegLpgCodigo","vINSERT_LEGLPGCODIGO",0,"char",20,0);this.setVCMap("A1581LegLpgCodigo","LEGLPGCODIGO",0,"char",20,0);this.setVCMap("AV20Insert_LegBanCod","vINSERT_LEGBANCOD",0,"char",6,0);this.setVCMap("A1582LegBanCod","LEGBANCOD",0,"char",6,0);this.setVCMap("AV38Insert_LegSinCod","vINSERT_LEGSINCOD",0,"char",20,0);this.setVCMap("A910LegSinCod","LEGSINCOD",0,"char",20,0);this.setVCMap("AV21Insert_LegOsoCod","vINSERT_LEGOSOCOD",0,"char",20,0);this.setVCMap("A1580LegOsoCod","LEGOSOCOD",0,"char",20,0);this.setVCMap("AV22Insert_LegActCodigo","vINSERT_LEGACTCODIGO",0,"char",8,0);this.setVCMap("A15LegActCodigo","LEGACTCODIGO",0,"char",8,0);this.setVCMap("AV23Insert_MprCod","vINSERT_MPRCOD",0,"char",20,0);this.setVCMap("A18MprCod","MPRCOD",0,"char",20,0);this.setVCMap("AV24Insert_ZonCod","vINSERT_ZONCOD",0,"char",20,0);this.setVCMap("A20ZonCod","ZONCOD",0,"char",20,0);this.setVCMap("AV25Insert_CondiCodigo","vINSERT_CONDICODIGO",0,"int",4,0);this.setVCMap("A17CondiCodigo","CONDICODIGO",0,"int",4,0);this.setVCMap("AV26Insert_SinieCodigo","vINSERT_SINIECODIGO",0,"char",4,0);this.setVCMap("A19SinieCodigo","SINIECODIGO",0,"char",4,0);this.setVCMap("AV27Insert_LegPuesCodigo","vINSERT_LEGPUESCODIGO",0,"char",20,0);this.setVCMap("A1578LegPuesCodigo","LEGPUESCODIGO",0,"char",20,0);this.setVCMap("AV28Insert_LegSucCodigo","vINSERT_LEGSUCCODIGO",0,"char",20,0);this.setVCMap("A1577LegSucCodigo","LEGSUCCODIGO",0,"char",20,0);this.setVCMap("AV29Insert_LegSitRevEgreso","vINSERT_LEGSITREVEGRESO",0,"int",3,0);this.setVCMap("A1603LegSitRevEgreso","LEGSITREVEGRESO",0,"int",3,0);this.setVCMap("A249LegFoto","LEGFOTO",0,"bitstr",1024,0);this.setVCMap("A266LegTipDoc","LEGTIPDOC",0,"int",1,0);this.setVCMap("A257LegNumDoc","LEGNUMDOC",0,"svchar",20,0);this.setVCMap("A246LegFecNac","LEGFECNAC",0,"date",8,0);this.setVCMap("A239LegCUIL","LEGCUIL",0,"int",11,0);this.setVCMap("A241LegDiscapacidad","LEGDISCAPACIDAD",0,"int",1,0);this.setVCMap("A242LegDomici","LEGDOMICI",0,"svchar",4e3,0);this.setVCMap("A479LegEmail","LEGEMAIL",0,"svchar",100,0);this.setVCMap("A236LegCodPos","LEGCODPOS",0,"char",20,0);this.setVCMap("A265LegTelefono","LEGTELEFONO",0,"svchar",30,0);this.setVCMap("A245LegFecIngreso","LEGFECINGRESO",0,"date",8,0);this.setVCMap("A244LegFecEgreso","LEGFECEGRESO",0,"date",8,0);this.setVCMap("A939LegCatCodigo","LEGCATCODIGO",0,"char",40,0);this.setVCMap("A248LegFormaPago","LEGFORMAPAGO",0,"int",1,0);this.setVCMap("A231LegBanSuc","LEGBANSUC",0,"svchar",30,0);this.setVCMap("A232LegBanTipCuen","LEGBANTIPCUEN",0,"char",20,0);this.setVCMap("A247LegFecUltMod","LEGFECULTMOD",0,"date",8,0);this.setVCMap("A238LegCuentaBanc","LEGCUENTABANC",0,"svchar",20,0);this.setVCMap("A253LegLicInicio","LEGLICINICIO",0,"date",8,0);this.setVCMap("A252LegLicFinal","LEGLICFINAL",0,"date",8,0);this.setVCMap("A234LegCBU","LEGCBU",0,"svchar",22,0);this.setVCMap("A262LegSCVO","LEGSCVO",0,"boolean",4,0);this.setVCMap("A228LegActivo","LEGACTIVO",0,"boolean",4,0);this.setVCMap("A264LegSueldoFuera","LEGSUELDOFUERA",0,"decimal",14,2);this.setVCMap("A515LegObs","LEGOBS",0,"vchar",2e3,0);this.setVCMap("A630LegFecImportacion","LEGFECIMPORTACION",0,"dtime",8,5);this.setVCMap("A877LegAgenReten","LEGAGENRETEN",0,"boolean",4,0);this.setVCMap("A879LegContinua","LEGCONTINUA",0,"char",2,0);this.setVCMap("A942LegRecalcLiq","LEGRECALCLIQ",0,"boolean",4,0);this.setVCMap("A1016LegJubilado","LEGJUBILADO",0,"boolean",4,0);this.setVCMap("A1023LegHorasDia","LEGHORASDIA",0,"decimal",3,1);this.setVCMap("A1268LegHorasSem","LEGHORASSEM",0,"decimal",4,1);this.setVCMap("A1245LegTrabLun","LEGTRABLUN",0,"boolean",4,0);this.setVCMap("A1246LegTrabMar","LEGTRABMAR",0,"boolean",4,0);this.setVCMap("A1247LegTrabMie","LEGTRABMIE",0,"boolean",4,0);this.setVCMap("A1248LegTrabJue","LEGTRABJUE",0,"boolean",4,0);this.setVCMap("A1249LegTrabVie","LEGTRABVIE",0,"boolean",4,0);this.setVCMap("A1250LegTrabSa","LEGTRABSA",0,"boolean",4,0);this.setVCMap("A1251LegTrabDo","LEGTRABDO",0,"boolean",4,0);this.setVCMap("A1523LegVacPend","LEGVACPEND",0,"int",4,0);this.setVCMap("A1531LegFecPreAviso","LEGFECPREAVISO",0,"date",8,0);this.setVCMap("A1759LegPromDias","LEGPROMDIAS",0,"svchar",4e3,0);this.setVCMap("A1804LegTitulo","LEGTITULO",0,"char",20,0);this.setVCMap("A1818LegEstado","LEGESTADO",0,"int",1,0);this.setVCMap("A2267LegIncompleto","LEGINCOMPLETO",0,"boolean",4,0);this.setVCMap("A1031LegFotoExt","LEGFOTOEXT",0,"char",20,0);this.setVCMap("A1030LegFotoNom","LEGFOTONOM",0,"svchar",1e3,0);this.setVCMap("A1235LegReligion","LEGRELIGION",0,"char",20,0);this.setVCMap("A1236LegOrigen","LEGORIGEN",0,"char",20,0);this.setVCMap("A300MegDescrip","MEGDESCRIP",0,"svchar",400,0);this.setVCMap("A1965EmpOsoCod","EMPOSOCOD",0,"char",20,0);this.setVCMap("A2EmpNom","EMPNOM",0,"svchar",40,0);this.setVCMap("A45TipEmpleCod","TIPEMPLECOD",0,"char",4,0);this.setVCMap("A684MprDescripSinAc","MPRDESCRIPSINAC",0,"svchar",400,0);this.setVCMap("A303MprDescrip","MPRDESCRIP",0,"svchar",400,0);this.setVCMap("A678ZonDescripSinAc","ZONDESCRIPSINAC",0,"svchar",400,0);this.setVCMap("A342ZonDescrip","ZONDESCRIP",0,"svchar",400,0);this.setVCMap("A343ZonPorcReduc","ZONPORCREDUC",0,"decimal",6,2);this.setVCMap("A686CondiDescriSinAc","CONDIDESCRISINAC",0,"svchar",40,0);this.setVCMap("A144CondiDescri","CONDIDESCRI",0,"svchar",40,0);this.setVCMap("A688SinieDescriSinAc","SINIEDESCRISINAC",0,"svchar",400,0);this.setVCMap("A333SinieDescri","SINIEDESCRI",0,"svchar",400,0);this.setVCMap("A258LegPaiNom","LEGPAINOM",0,"svchar",30,0);this.setVCMap("A260LegProvNom","LEGPROVNOM",0,"svchar",400,0);this.setVCMap("A255LegLocNom","LEGLOCNOM",0,"svchar",40,0);this.setVCMap("A256LegNacionalidad","LEGNACIONALIDAD",0,"svchar",30,0);this.setVCMap("A227LegActDescri","LEGACTDESCRI",0,"svchar",150,0);this.setVCMap("AV39Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV31DetailWCInfo","vDETAILWCINFO",0,"WWPBaseObjectsSplitScreenDetailInfo",0,0);this.setVCMap("AV31DetailWCInfo","vDETAILWCINFO",0,"WWPBaseObjectsSplitScreenDetailInfo",0,0);this.Initialize()})