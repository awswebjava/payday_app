gx.evt.autoSkip=!1;gx.define("seccion",!1,function(){var n,r,t,i;this.ServerClass="seccion";this.PackageName="web";this.ServerFullClass="web.seccion";this.setObjectType("trn");this.anyGridBaseTable=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A675SecDescripSinAc=gx.fn.getControlValue("SECDESCRIPSINAC");this.AV11CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV7SecCodigo=gx.fn.getControlValue("vSECCODIGO");this.Gx_BScreen=gx.fn.getIntegerValue("vGXBSCREEN",gx.thousandSeparator);this.A330SecHabilitada=gx.fn.getControlValue("SECHABILITADA");this.AV15aplicadoHay=gx.fn.getControlValue("vAPLICADOHAY");this.A1985SecRelSecCli=gx.fn.getIntegerValue("SECRELSECCLI",gx.thousandSeparator);this.A1986SecPadre=gx.fn.getControlValue("SECPADRE");this.A2015SecRelRef=gx.fn.getControlValue("SECRELREF");this.A2033SecOld=gx.fn.getControlValue("SECOLD");this.AV17Pgmname=gx.fn.getControlValue("vPGMNAME");this.A1242PuestoDescripSinAc=gx.fn.getControlValue("PUESTODESCRIPSINAC");this.A1988PuestoRelSecCli=gx.fn.getIntegerValue("PUESTORELSECCLI",gx.thousandSeparator);this.A1989PuestoPadre=gx.fn.getControlValue("PUESTOPADRE");this.A2016PuestoRelRef=gx.fn.getControlValue("PUESTORELREF");this.A2034PuestoOld=gx.fn.getControlValue("PUESTOOLD");this.Gx_mode=gx.fn.getControlValue("vMODE")};this.Valid_Seccodigo=function(){return this.validCliEvt("Valid_Seccodigo",0,function(){try{var n=gx.util.balloon.getNew("SECCODIGO");if(this.AnyError=0,gx.text.compare("",this.A13SecCodigo)==0)try{n.setError(gx.text.format(gx.getMessage("WWP_RequiredAttribute"),gx.getMessage("Area"),"","","","","","","",""));this.AnyError=gx.num.trunc(1,0)}catch(t){}this.refreshOutputs([{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Clicod=function(){return this.validSrvEvt("valid_Clicod",0).then(function(n){return n}.closure(this))};this.Valid_Secdescrip=function(){return this.validSrvEvt("valid_Secdescrip",0).then(function(n){return n}.closure(this))};this.Valid_Secrelsec=function(){return this.validSrvEvt("valid_Secrelsec",0).then(function(n){return n}.closure(this))};this.Valid_Puestocodigo=function(){var n=gx.fn.currentGridRowImpl(51);return this.validCliEvt("Valid_Puestocodigo",51,function(){try{if(gx.fn.currentGridRowImpl(51)===0)return!0;var n=gx.util.balloon.getNew("PUESTOCODIGO",gx.fn.currentGridRowImpl(51));this.AnyError=0;this.sMode153=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(153,51);this.standaloneModal1A153();this.standaloneNotModal1A153();gx.fn.gridDuplicateKey(52)&&(n.setError(gx.text.format(gx.getMessage("GXM_1004"),gx.getMessage("Puestos"),"","","","","","","","")),this.AnyError=gx.num.trunc(1,0));this.refreshOutputs([{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return(this.Gx_mode=this.sMode153,n==null)?!0:n.show()}catch(t){}return!0})};this.Valid_Puestodescrip=function(){var n=gx.fn.currentGridRowImpl(51);return this.validSrvEvt("valid_Puestodescrip",51).then(function(n){try{this.sMode153=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(153,51)}finally{this.Gx_mode=this.sMode153}return n}.closure(this))};this.Valid_Puestohorasext=function(){var n=gx.fn.currentGridRowImpl(51);return this.validCliEvt("Valid_Puestohorasext",51,function(){try{if(gx.fn.currentGridRowImpl(51)===0)return!0;var n=gx.util.balloon.getNew("PUESTOHORASEXT",gx.fn.currentGridRowImpl(51));this.AnyError=0;this.sMode153=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(153,51);this.refreshOutputs([{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"}])}catch(t){}try{return(this.Gx_mode=this.sMode153,n==null)?!0:n.show()}catch(t){}return!0})};this.Valid_Puestorelsec=function(){var n=gx.fn.currentGridRowImpl(51);return this.validSrvEvt("valid_Puestorelsec",51).then(function(n){try{this.sMode153=this.Gx_mode;this.Gx_mode=gx.fn.getGridRowMode(153,51)}finally{this.Gx_mode=this.sMode153}return n}.closure(this))};this.standaloneModal1A153=function(){try{gx.text.compare(this.Gx_mode,"INS")!=0?gx.fn.setCtrlProperty("PUESTOCODIGO","Enabled",0):gx.fn.setCtrlProperty("PUESTOCODIGO","Enabled",1)}catch(n){}};this.standaloneNotModal1A153=function(){};this.s112_client=function(){gx.fn.setCtrlProperty("SECRELSEC_CELL","Class","col-xs-12 col-sm-6 DataContentCell DscTop")};this.e121a2_client=function(){return this.executeServerEvent("AFTER TRN",!0,null,!1,!1)};this.e131a43_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e141a43_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,16,17,18,19,20,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,48,49,50,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68];this.GXLastCtrlId=68;this.Gridlevel1Container=new gx.grid.grid(this,153,"Puestos",51,"Gridlevel1","Gridlevel1","Gridlevel1Container",this.CmpContext,this.IsMasterPage,"seccion",[1240],!1,1,!1,!0,5,!1,!1,!1,"",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"",!1,[1,1,1,1],!1,0,!0,!1);r=this.Gridlevel1Container;r.addSingleLineEdit(1240,52,"PUESTOCODIGO",gx.getMessage("Puesto"),"","PuestoCodigo","char",0,"px",20,20,"left",null,[],1240,"PuestoCodigo",!0,0,!1,!1,"Attribute",0,"TrnColumn");r.addSingleLineEdit(1241,53,"PUESTODESCRIP",gx.getMessage("Descripción"),"","PuestoDescrip","svchar",0,"px",400,80,"left",null,[],1241,"PuestoDescrip",!0,0,!1,!1,"Attribute",0,"TrnColumn");r.addCheckBox(1255,54,"PUESTOHORASEXT",gx.getMessage("Puede realizar horas extras"),"","PuestoHorasExt","boolean","true","false",null,!0,!1,0,"px","TrnColumn");r.addComboBox(1987,55,"PUESTORELSEC",gx.getMessage("Liberación"),"PuestoRelSec","int",null,0,!0,!1,0,"px","TrnColumn");this.Gridlevel1Container.emptyText=gx.getMessage("");this.setGrid(r);this.DVPANEL_TABLEATTRIBUTESContainer=gx.uc.getNew(this,21,0,"BootstrapPanel","DVPANEL_TABLEATTRIBUTESContainer","Dvpanel_tableattributes","DVPANEL_TABLEATTRIBUTES");t=this.DVPANEL_TABLEATTRIBUTESContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setProp("Width","Width","100%","str");t.setProp("Height","Height","100","str");t.setProp("AutoWidth","Autowidth",!1,"bool");t.setProp("AutoHeight","Autoheight",!0,"bool");t.setProp("Cls","Cls","PanelCard_GrayTitle","str");t.setProp("ShowHeader","Showheader",!0,"bool");t.setProp("Title","Title",gx.getMessage("WWP_TemplateDataPanelTitle"),"str");t.setProp("Collapsible","Collapsible",!1,"bool");t.setProp("Collapsed","Collapsed",!1,"bool");t.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");t.setProp("IconPosition","Iconposition","Right","str");t.setProp("AutoScroll","Autoscroll",!1,"bool");t.setProp("Visible","Visible",!0,"bool");t.setProp("Gx Control Type","Gxcontroltype","","int");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);this.DVPANEL_UNNAMEDTABLE1Container=gx.uc.getNew(this,46,28,"BootstrapPanel","DVPANEL_UNNAMEDTABLE1Container","Dvpanel_unnamedtable1","DVPANEL_UNNAMEDTABLE1");i=this.DVPANEL_UNNAMEDTABLE1Container;i.setProp("Class","Class","","char");i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("Width","Width","100%","str");i.setProp("Height","Height","100","str");i.setProp("AutoWidth","Autowidth",!1,"bool");i.setProp("AutoHeight","Autoheight",!0,"bool");i.setProp("Cls","Cls","PanelCard_GrayTitle","str");i.setProp("ShowHeader","Showheader",!0,"bool");i.setProp("Title","Title",gx.getMessage("Puestos"),"str");i.setProp("Collapsible","Collapsible",!0,"bool");i.setProp("Collapsed","Collapsed",!1,"bool");i.setProp("ShowCollapseIcon","Showcollapseicon",!1,"bool");i.setProp("IconPosition","Iconposition","Right","str");i.setProp("AutoScroll","Autoscroll",!1,"bool");i.setProp("Visible","Visible",!0,"bool");i.setProp("Gx Control Type","Gxcontroltype","","int");i.setC2ShowFunction(function(n){n.show()});this.setUserControl(i);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TEXTBLOCKTITLE",format:0,grid:0,ctrltype:"textblock"};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLEHEADER",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[18]={id:18,fld:"TABLECONTENT",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[23]={id:23,fld:"TABLEATTRIBUTES",grid:0};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,fld:"",grid:0};n[28]={id:28,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:this.Valid_Seccodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Gridlevel1Container],fld:"SECCODIGO",fmt:0,gxz:"Z13SecCodigo",gxold:"O13SecCodigo",gxvar:"A13SecCodigo",ucs:[],op:[28],ip:[28],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A13SecCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z13SecCodigo=n)},v2c:function(){gx.fn.setControlValue("SECCODIGO",gx.O.A13SecCodigo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A13SecCodigo=this.val())},val:function(){return gx.fn.getControlValue("SECCODIGO")},nac:function(){return!(gx.text.compare("",this.AV7SecCodigo)==0)}};this.declareDomainHdlr(28,function(){});n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:0,multiline:!0,grid:0,gxgrid:null,fnc:this.Valid_Secdescrip,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECDESCRIP",fmt:0,gxz:"Z329SecDescrip",gxold:"O329SecDescrip",gxvar:"A329SecDescrip",ucs:[],op:[33],ip:[28,33],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A329SecDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z329SecDescrip=n)},v2c:function(){gx.fn.setControlValue("SECDESCRIP",gx.O.A329SecDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A329SecDescrip=this.val())},val:function(){return gx.fn.getControlValue("SECDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(33,function(){});n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"SECRELSEC_CELL",grid:0};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Secrelsec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECRELSEC",fmt:0,gxz:"Z1984SecRelSec",gxold:"O1984SecRelSec",gxvar:"A1984SecRelSec",ucs:[],op:[38,33,28],ip:[38,33,28],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1984SecRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1984SecRelSec=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("SECRELSEC",gx.O.A1984SecRelSec)},c2v:function(){this.val()!==undefined&&(gx.O.A1984SecRelSec=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("SECRELSEC",gx.thousandSeparator)},nac:gx.falseFn};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,fld:"",grid:0};n[42]={id:42,fld:"",grid:0};n[43]={id:43,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SECAPOOPC",fmt:0,gxz:"Z2308SecApoOpc",gxold:"O2308SecApoOpc",gxvar:"A2308SecApoOpc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A2308SecApoOpc=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z2308SecApoOpc=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("SECAPOOPC",gx.O.A2308SecApoOpc,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A2308SecApoOpc=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("SECAPOOPC")},nac:gx.falseFn,values:["true","false"]};n[44]={id:44,fld:"",grid:0};n[45]={id:45,fld:"",grid:0};n[48]={id:48,fld:"UNNAMEDTABLE1",grid:0};n[49]={id:49,fld:"",grid:0};n[50]={id:50,fld:"",grid:0};n[52]={id:52,lvl:153,type:"char",len:20,dec:0,sign:!1,ro:0,isacc:1,grid:51,gxgrid:this.Gridlevel1Container,fnc:this.Valid_Puestocodigo,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PUESTOCODIGO",fmt:0,gxz:"Z1240PuestoCodigo",gxold:"O1240PuestoCodigo",gxvar:"A1240PuestoCodigo",ucs:[],op:[55],ip:[55],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A1240PuestoCodigo=n)},v2z:function(n){n!==undefined&&(gx.O.Z1240PuestoCodigo=n)},v2c:function(n){gx.fn.setGridControlValue("PUESTOCODIGO",n||gx.fn.currentGridRowImpl(51),gx.O.A1240PuestoCodigo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A1240PuestoCodigo=this.val(n))},val:function(n){return gx.fn.getGridControlValue("PUESTOCODIGO",n||gx.fn.currentGridRowImpl(51))},nac:gx.falseFn};n[53]={id:53,lvl:153,type:"svchar",len:400,dec:0,sign:!1,ro:0,isacc:1,grid:51,gxgrid:this.Gridlevel1Container,fnc:this.Valid_Puestodescrip,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PUESTODESCRIP",fmt:0,gxz:"Z1241PuestoDescrip",gxold:"O1241PuestoDescrip",gxvar:"A1241PuestoDescrip",ucs:[],op:[],ip:[53],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.A1241PuestoDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z1241PuestoDescrip=n)},v2c:function(n){gx.fn.setGridControlValue("PUESTODESCRIP",n||gx.fn.currentGridRowImpl(51),gx.O.A1241PuestoDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A1241PuestoDescrip=this.val(n))},val:function(n){return gx.fn.getGridControlValue("PUESTODESCRIP",n||gx.fn.currentGridRowImpl(51))},nac:gx.falseFn};n[54]={id:54,lvl:153,type:"boolean",len:4,dec:0,sign:!1,ro:0,isacc:1,grid:51,gxgrid:this.Gridlevel1Container,fnc:this.Valid_Puestohorasext,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PUESTOHORASEXT",fmt:0,gxz:"Z1255PuestoHorasExt",gxold:"O1255PuestoHorasExt",gxvar:"A1255PuestoHorasExt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A1255PuestoHorasExt=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1255PuestoHorasExt=gx.lang.booleanValue(n))},v2c:function(n){gx.fn.setGridCheckBoxValue("PUESTOHORASEXT",n||gx.fn.currentGridRowImpl(51),gx.O.A1255PuestoHorasExt,!0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A1255PuestoHorasExt=gx.lang.booleanValue(this.val(n)))},val:function(n){return gx.fn.getGridControlValue("PUESTOHORASEXT",n||gx.fn.currentGridRowImpl(51))},nac:gx.falseFn,values:["true","false"]};n[55]={id:55,lvl:153,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,isacc:1,grid:51,gxgrid:this.Gridlevel1Container,fnc:this.Valid_Puestorelsec,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PUESTORELSEC",fmt:0,gxz:"Z1987PuestoRelSec",gxold:"O1987PuestoRelSec",gxvar:"A1987PuestoRelSec",ucs:[],op:[55,54,52],ip:[55,54,52],nacdep:[],ctrltype:"dyncombo",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.A1987PuestoRelSec=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1987PuestoRelSec=gx.num.intval(n))},v2c:function(n){gx.fn.setGridComboBoxValue("PUESTORELSEC",n||gx.fn.currentGridRowImpl(51),gx.O.A1987PuestoRelSec)},c2v:function(n){this.val(n)!==undefined&&(gx.O.A1987PuestoRelSec=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("PUESTORELSEC",n||gx.fn.currentGridRowImpl(51),gx.thousandSeparator)},nac:gx.falseFn};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,fld:"",grid:0};n[60]={id:60,fld:"BTNTRN_ENTER",grid:0,evt:"e131a43_client",std:"ENTER"};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"BTNTRN_CANCEL",grid:0,evt:"e141a43_client"};n[63]={id:63,fld:"",grid:0};n[64]={id:64,fld:"BTNTRN_DELETE",grid:0,evt:"e151a43_client",std:"DELETE"};n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[68]={id:68,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:this.Valid_Clicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[this.Gridlevel1Container],fld:"CLICOD",fmt:0,gxz:"Z3CliCod",gxold:"O3CliCod",gxvar:"A3CliCod",ucs:[],op:[],ip:[68],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A3CliCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z3CliCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("CLICOD",gx.O.A3CliCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A3CliCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("CLICOD",gx.thousandSeparator)},nac:function(){return!(0==this.AV11CliCod)}};this.A13SecCodigo="";this.Z13SecCodigo="";this.O13SecCodigo="";this.A329SecDescrip="";this.Z329SecDescrip="";this.O329SecDescrip="";this.A1984SecRelSec=0;this.Z1984SecRelSec=0;this.O1984SecRelSec=0;this.A2308SecApoOpc=!1;this.Z2308SecApoOpc=!1;this.O2308SecApoOpc=!1;this.Z1240PuestoCodigo="";this.O1240PuestoCodigo="";this.Z1241PuestoDescrip="";this.O1241PuestoDescrip="";this.Z1255PuestoHorasExt=!1;this.O1255PuestoHorasExt=!1;this.Z1987PuestoRelSec=0;this.O1987PuestoRelSec=0;this.A3CliCod=0;this.Z3CliCod=0;this.O3CliCod=0;this.A1240PuestoCodigo="";this.A1242PuestoDescripSinAc="";this.A1241PuestoDescrip="";this.A1255PuestoHorasExt=!1;this.A1987PuestoRelSec=0;this.A1988PuestoRelSecCli=0;this.A1989PuestoPadre="";this.A2016PuestoRelRef="";this.A2034PuestoOld="";this.AV8WWPContext={UserId:0,UserName:""};this.AV13IsAuthorized=!1;this.AV17Pgmname="";this.AV9TrnContext={CallerObject:"",CallerOnDelete:!1,CallerURL:"",TransactionName:"",Attributes:[]};this.AV11CliCod=0;this.AV7SecCodigo="";this.AV10WebSession={};this.A3CliCod=0;this.A13SecCodigo="";this.AV15aplicadoHay=!1;this.Gx_BScreen=0;this.A675SecDescripSinAc="";this.A329SecDescrip="";this.A330SecHabilitada=!1;this.A1984SecRelSec=0;this.A1985SecRelSecCli=0;this.A1986SecPadre="";this.A2015SecRelRef="";this.A2033SecOld="";this.A2308SecApoOpc=!1;this.Gx_mode="";this.Events={e121a2_client:["AFTER TRN",!0],e131a43_client:["ENTER",!0],e141a43_client:["CANCEL",!0]};this.EvtParms.ENTER=[[{postForm:!0},{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7SecCodigo",fld:"vSECCODIGO",pic:"",hsh:!0},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.REFRESH=[[{av:"Gx_mode",fld:"vMODE",pic:"@!",hsh:!0},{av:"AV7SecCodigo",fld:"vSECCODIGO",pic:"",hsh:!0},{av:"A330SecHabilitada",fld:"SECHABILITADA",pic:""},{av:"A1985SecRelSecCli",fld:"SECRELSECCLI",pic:"ZZZZZ9"},{av:"A1986SecPadre",fld:"SECPADRE",pic:""},{av:"A2015SecRelRef",fld:"SECRELREF",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms["AFTER TRN"]=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.VALID_SECCODIGO=[[{av:"A13SecCodigo",fld:"SECCODIGO",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"A13SecCodigo",fld:"SECCODIGO",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.VALID_SECDESCRIP=[[{av:"O329SecDescrip"},{av:"O13SecCodigo"},{av:"A329SecDescrip",fld:"SECDESCRIP",pic:""},{av:"A13SecCodigo",fld:"SECCODIGO",pic:""},{ctrl:"PUESTORELSEC"},{av:"A1987PuestoRelSec",fld:"PUESTORELSEC",pic:"ZZZZZ9"},{av:"A675SecDescripSinAc",fld:"SECDESCRIPSINAC",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"A675SecDescripSinAc",fld:"SECDESCRIPSINAC",pic:""},{av:'gx.fn.getCtrlProperty("SECRELSEC_CELL","Class")',ctrl:"SECRELSEC_CELL",prop:"Class"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.VALID_SECRELSEC=[[{av:"Gx_mode",fld:"vMODE",pic:"@!"},{av:"O329SecDescrip"},{av:"O13SecCodigo"},{av:"A13SecCodigo",fld:"SECCODIGO",pic:""},{av:"A329SecDescrip",fld:"SECDESCRIP",pic:""},{ctrl:"PUESTORELSEC"},{av:"A1987PuestoRelSec",fld:"PUESTORELSEC",pic:"ZZZZZ9"},{av:"AV15aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"AV15aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.VALID_CLICOD=[[{av:"A3CliCod",fld:"CLICOD",pic:"ZZZZZ9"},{ctrl:"PUESTORELSEC"},{av:"A1987PuestoRelSec",fld:"PUESTORELSEC",pic:"ZZZZZ9"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.VALID_PUESTOCODIGO=[[{ctrl:"PUESTORELSEC"},{av:"A1987PuestoRelSec",fld:"PUESTORELSEC",pic:"ZZZZZ9"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{ctrl:"PUESTORELSEC"},{av:"A1987PuestoRelSec",fld:"PUESTORELSEC",pic:"ZZZZZ9"},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.VALID_PUESTODESCRIP=[[{av:"A1241PuestoDescrip",fld:"PUESTODESCRIP",pic:""},{ctrl:"PUESTORELSEC"},{av:"A1987PuestoRelSec",fld:"PUESTORELSEC",pic:"ZZZZZ9"},{av:"A1242PuestoDescripSinAc",fld:"PUESTODESCRIPSINAC",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"A1242PuestoDescripSinAc",fld:"PUESTODESCRIPSINAC",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.VALID_PUESTOHORASEXT=[[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EvtParms.VALID_PUESTORELSEC=[[{av:"Gx_mode",fld:"vMODE",pic:"@!"},{av:"O1255PuestoHorasExt"},{av:"O1240PuestoCodigo"},{av:"A1240PuestoCodigo",fld:"PUESTOCODIGO",pic:""},{av:"A1255PuestoHorasExt",fld:"PUESTOHORASEXT",pic:""},{ctrl:"PUESTORELSEC"},{av:"A1987PuestoRelSec",fld:"PUESTORELSEC",pic:"ZZZZZ9"},{av:"AV15aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}],[{av:"AV15aplicadoHay",fld:"vAPLICADOHAY",pic:""},{av:"AV11CliCod",fld:"vCLICOD",pic:"ZZZZZ9"},{ctrl:"SECRELSEC"},{av:"A1984SecRelSec",fld:"SECRELSEC",pic:"ZZZZZ9"},{av:"A2308SecApoOpc",fld:"SECAPOOPC",pic:""}]];this.EnterCtrl=["BTNTRN_ENTER"];this.setVCMap("A675SecDescripSinAc","SECDESCRIPSINAC",0,"svchar",400,0);this.setVCMap("AV11CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV7SecCodigo","vSECCODIGO",0,"char",20,0);this.setVCMap("Gx_BScreen","vGXBSCREEN",0,"int",1,0);this.setVCMap("A330SecHabilitada","SECHABILITADA",0,"boolean",4,0);this.setVCMap("AV15aplicadoHay","vAPLICADOHAY",0,"boolean",4,0);this.setVCMap("A1985SecRelSecCli","SECRELSECCLI",0,"int",6,0);this.setVCMap("A1986SecPadre","SECPADRE",0,"char",20,0);this.setVCMap("A2015SecRelRef","SECRELREF",0,"svchar",40,0);this.setVCMap("A2033SecOld","SECOLD",0,"vchar",2097152,0);this.setVCMap("AV17Pgmname","vPGMNAME",0,"char",129,0);this.setVCMap("A1242PuestoDescripSinAc","PUESTODESCRIPSINAC",51,"svchar",400,0);this.setVCMap("A1988PuestoRelSecCli","PUESTORELSECCLI",51,"int",6,0);this.setVCMap("A1989PuestoPadre","PUESTOPADRE",51,"char",20,0);this.setVCMap("A2016PuestoRelRef","PUESTORELREF",51,"svchar",40,0);this.setVCMap("A2034PuestoOld","PUESTOOLD",51,"vchar",2097152,0);this.setVCMap("Gx_mode","vMODE",0,"char",3,0);this.setVCMap("AV11CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV11CliCod","vCLICOD",0,"int",6,0);r.addPostingVar({rfrVar:"Gx_mode"});r.addPostingVar(this.GXValidFnc[68]);r.addPostingVar({rfrVar:"AV11CliCod"});this.Initialize();this.LvlOlds[43]=["O329SecDescrip","O13SecCodigo"];this.LvlOlds[153]=["O1240PuestoCodigo","O1255PuestoHorasExt"]});gx.wi(function(){gx.createParentObj(this.seccion)})