gx.evt.autoSkip=!1;gx.define("confirmarliquidacion",!1,function(){var n,i,t;this.ServerClass="confirmarliquidacion";this.PackageName="web";this.ServerFullClass="web.confirmarliquidacion";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV12LiqPeriodo=gx.fn.getDateValue("vLIQPERIODO");this.AV9EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV8CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV5SDTLegajos=gx.fn.getControlValue("vSDTLEGAJOS");this.AV26Respuesta=gx.fn.getControlValue("vRESPUESTA")};this.e119w2_client=function(){return this.executeServerEvent("'DOCONFIRMAR'",!1,null,!1,!1)};this.e129w2_client=function(){return this.executeServerEvent("'DOCANCELAR'",!1,null,!1,!1)};this.e169w2_client=function(){return this.executeServerEvent("ENTER",!0,arguments[0],!1,!1)};this.e179w2_client=function(){return this.executeServerEvent("CANCEL",!0,arguments[0],!1,!1)};this.GXValidFnc=[];n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,26,27,28,29,30,31,32,33,34,35,36,37,38,39];this.GXLastCtrlId=39;this.GridsdtlegajossContainer=new gx.grid.grid(this,2,"WbpLvl2",25,"Gridsdtlegajoss","Gridsdtlegajoss","GridsdtlegajossContainer",this.CmpContext,this.IsMasterPage,"confirmarliquidacion",[],!1,1,!1,!0,0,!0,!1,!1,"CollSDTLegajos.SDTLegajosItem",0,"px",0,"px",gx.getMessage("GXM_newrow"),!0,!1,!1,null,null,!1,"AV5SDTLegajos",!1,[1,1,1,1],!0,0,!0,!1);i=this.GridsdtlegajossContainer;i.addSingleLineEdit("GXV2",26,"SDTLEGAJOS__LEGNUMERO",gx.getMessage("Legajo"),"","LegNumero","int",0,"px",8,8,"right",null,[],"GXV2","GXV2",!1,0,!1,!1,"Attribute",0,"WWColumn");i.addCheckBox("GXV3",27,"SDTLEGAJOS__SELECCIONADO","","","seleccionado","boolean","true","false",null,!1,!1,0,"px","WWColumn");i.addSingleLineEdit("GXV4",28,"SDTLEGAJOS__LEGIDNOMAPE",gx.getMessage("Legajos"),"","LegIdNomApe","svchar",0,"px",100,80,"left",null,[],"GXV4","GXV4",!0,0,!1,!1,"Attribute",0,"WWColumn");this.GridsdtlegajossContainer.emptyText=gx.getMessage("");this.setGrid(i);this.GRIDSDTLEGAJOSS_EMPOWERERContainer=gx.uc.getNew(this,40,17,"WWP_GridEmpowerer","GRIDSDTLEGAJOSS_EMPOWERERContainer","Gridsdtlegajoss_empowerer","GRIDSDTLEGAJOSS_EMPOWERER");t=this.GRIDSDTLEGAJOSS_EMPOWERERContainer;t.setProp("Class","Class","","char");t.setProp("Enabled","Enabled",!0,"boolean");t.setDynProp("GridInternalName","Gridinternalname","","char");t.setProp("HasCategories","Hascategories",!1,"bool");t.setProp("InfiniteScrolling","Infinitescrolling","Grid","str");t.setProp("HasTitleSettings","Hastitlesettings",!1,"bool");t.setProp("HasColumnsSelector","Hascolumnsselector",!1,"bool");t.setProp("HasRowGroups","Hasrowgroups",!1,"bool");t.setProp("FixedColumns","Fixedcolumns","","str");t.setProp("PopoversInGrid","Popoversingrid","","str");t.setProp("Visible","Visible",!0,"bool");t.setC2ShowFunction(function(n){n.show()});this.setUserControl(t);n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"TABLECONTENT",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,fld:"",grid:0};n[15]={id:15,fld:"",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vLIQNOMBRE",fmt:0,gxz:"ZV10LiqNombre",gxold:"OV10LiqNombre",gxvar:"AV10LiqNombre",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV10LiqNombre=n)},v2z:function(n){n!==undefined&&(gx.O.ZV10LiqNombre=n)},v2c:function(){gx.fn.setControlValue("vLIQNOMBRE",gx.O.AV10LiqNombre,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV10LiqNombre=this.val())},val:function(){return gx.fn.getControlValue("vLIQNOMBRE")},nac:gx.falseFn};n[18]={id:18,fld:"",grid:0};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,lvl:0,type:"int",len:6,dec:0,sign:!1,pic:"ZZZZZ9",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vCNTLEG",fmt:0,gxz:"ZV36CntLeg",gxold:"OV36CntLeg",gxvar:"AV36CntLeg",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV36CntLeg=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV36CntLeg=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("vCNTLEG",gx.O.AV36CntLeg,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV36CntLeg=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("vCNTLEG",gx.thousandSeparator)},nac:gx.falseFn};n[23]={id:23,fld:"",grid:0};n[24]={id:24,fld:"",grid:0};n[26]={id:26,lvl:2,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:1,isacc:0,grid:25,gxgrid:this.GridsdtlegajossContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SDTLEGAJOS__LEGNUMERO",fmt:0,gxz:"ZV40GXV2",gxold:"OV40GXV2",gxvar:"GXV2",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.GXV2=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.ZV40GXV2=gx.num.intval(n))},v2c:function(n){gx.fn.setGridControlValue("SDTLEGAJOS__LEGNUMERO",n||gx.fn.currentGridRowImpl(25),gx.O.GXV2,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.GXV2=gx.num.intval(this.val(n)))},val:function(n){return gx.fn.getGridIntegerValue("SDTLEGAJOS__LEGNUMERO",n||gx.fn.currentGridRowImpl(25),gx.thousandSeparator)},nac:gx.falseFn};n[27]={id:27,lvl:2,type:"boolean",len:4,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridsdtlegajossContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SDTLEGAJOS__SELECCIONADO",fmt:0,gxz:"ZV41GXV3",gxold:"OV41GXV3",gxvar:"GXV3",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",inputType:"text",v2v:function(n){n!==undefined&&(gx.O.GXV3=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.ZV41GXV3=gx.lang.booleanValue(n))},v2c:function(n){gx.fn.setGridCheckBoxValue("SDTLEGAJOS__SELECCIONADO",n||gx.fn.currentGridRowImpl(25),gx.O.GXV3,!0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.GXV3=gx.lang.booleanValue(this.val(n)))},val:function(n){return gx.fn.getGridControlValue("SDTLEGAJOS__SELECCIONADO",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn,values:["true","false"]};n[28]={id:28,lvl:2,type:"svchar",len:100,dec:0,sign:!1,ro:1,isacc:0,grid:25,gxgrid:this.GridsdtlegajossContainer,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"SDTLEGAJOS__LEGIDNOMAPE",fmt:0,gxz:"ZV42GXV4",gxold:"OV42GXV4",gxvar:"GXV4",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",inputType:"text",autoCorrect:"1",v2v:function(n){n!==undefined&&(gx.O.GXV4=n)},v2z:function(n){n!==undefined&&(gx.O.ZV42GXV4=n)},v2c:function(n){gx.fn.setGridControlValue("SDTLEGAJOS__LEGIDNOMAPE",n||gx.fn.currentGridRowImpl(25),gx.O.GXV4,0)},c2v:function(n){this.val(n)!==undefined&&(gx.O.GXV4=this.val(n))},val:function(n){return gx.fn.getGridControlValue("SDTLEGAJOS__LEGIDNOMAPE",n||gx.fn.currentGridRowImpl(25))},nac:gx.falseFn};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,fld:"",grid:0};n[33]={id:33,fld:"BTNCONFIRMAR",grid:0,evt:"e119w2_client"};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"BTNCANCELAR",grid:0,evt:"e129w2_client"};n[36]={id:36,fld:"",grid:0};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};n[39]={id:39,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vTLIQCOD",fmt:0,gxz:"ZV11TLiqCod",gxold:"OV11TLiqCod",gxvar:"AV11TLiqCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV11TLiqCod=n)},v2z:function(n){n!==undefined&&(gx.O.ZV11TLiqCod=n)},v2c:function(){gx.fn.setControlValue("vTLIQCOD",gx.O.AV11TLiqCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV11TLiqCod=this.val())},val:function(){return gx.fn.getControlValue("vTLIQCOD")},nac:gx.falseFn};this.AV10LiqNombre="";this.ZV10LiqNombre="";this.OV10LiqNombre="";this.AV36CntLeg=0;this.ZV36CntLeg=0;this.OV36CntLeg=0;this.ZV40GXV2=0;this.OV40GXV2=0;this.ZV41GXV3=!1;this.OV41GXV3=!1;this.ZV42GXV4="";this.OV42GXV4="";this.AV11TLiqCod="";this.ZV11TLiqCod="";this.OV11TLiqCod="";this.AV10LiqNombre="";this.AV36CntLeg=0;this.AV11TLiqCod="";this.AV8CliCod=0;this.AV9EmpCod=0;this.AV12LiqPeriodo=gx.date.nullDate();this.AV26Respuesta="";this.GXV2=0;this.GXV3=!1;this.GXV4="";this.AV5SDTLegajos=[];this.Events={e119w2_client:["'DOCONFIRMAR'",!0],e129w2_client:["'DOCANCELAR'",!0],e169w2_client:["ENTER",!0],e179w2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GRIDSDTLEGAJOSS_nFirstRecordOnPage"},{av:"GRIDSDTLEGAJOSS_nEOF"},{av:"AV5SDTLegajos",fld:"vSDTLEGAJOS",grid:25,pic:""},{av:"nGXsfl_25_idx",ctrl:"GRID",prop:"GridCurrRow",grid:25},{av:"nRC_GXsfl_25",ctrl:"GRIDSDTLEGAJOSS",prop:"GridRC",grid:25},{ctrl:"GRIDSDTLEGAJOSS",prop:"Rows"},{av:"AV12LiqPeriodo",fld:"vLIQPERIODO",pic:"",hsh:!0},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}],[{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}]];this.EvtParms["GRIDSDTLEGAJOSS.LOAD"]=[[],[]];this.EvtParms["'DOCONFIRMAR'"]=[[{av:"AV11TLiqCod",fld:"vTLIQCOD",pic:""},{av:"AV12LiqPeriodo",fld:"vLIQPERIODO",pic:"",hsh:!0},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}],[{av:"AV26Respuesta",fld:"vRESPUESTA",pic:""}]];this.EvtParms["'DOCANCELAR'"]=[[{av:"AV11TLiqCod",fld:"vTLIQCOD",pic:""},{av:"AV12LiqPeriodo",fld:"vLIQPERIODO",pic:"",hsh:!0},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}],[{av:"AV26Respuesta",fld:"vRESPUESTA",pic:""}]];this.EvtParms.ENTER=[[],[]];this.EvtParms.GRIDSDTLEGAJOSS_FIRSTPAGE=[[{av:"GRIDSDTLEGAJOSS_nFirstRecordOnPage"},{av:"GRIDSDTLEGAJOSS_nEOF"},{ctrl:"GRIDSDTLEGAJOSS",prop:"Rows"},{av:"AV12LiqPeriodo",fld:"vLIQPERIODO",pic:"",hsh:!0},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV5SDTLegajos",fld:"vSDTLEGAJOS",grid:25,pic:""},{av:"nGXsfl_25_idx",ctrl:"GRID",prop:"GridCurrRow",grid:25},{av:"nRC_GXsfl_25",ctrl:"GRIDSDTLEGAJOSS",prop:"GridRC",grid:25}],[{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}]];this.EvtParms.GRIDSDTLEGAJOSS_PREVPAGE=[[{av:"GRIDSDTLEGAJOSS_nFirstRecordOnPage"},{av:"GRIDSDTLEGAJOSS_nEOF"},{ctrl:"GRIDSDTLEGAJOSS",prop:"Rows"},{av:"AV12LiqPeriodo",fld:"vLIQPERIODO",pic:"",hsh:!0},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV5SDTLegajos",fld:"vSDTLEGAJOS",grid:25,pic:""},{av:"nGXsfl_25_idx",ctrl:"GRID",prop:"GridCurrRow",grid:25},{av:"nRC_GXsfl_25",ctrl:"GRIDSDTLEGAJOSS",prop:"GridRC",grid:25}],[{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}]];this.EvtParms.GRIDSDTLEGAJOSS_NEXTPAGE=[[{av:"GRIDSDTLEGAJOSS_nFirstRecordOnPage"},{av:"GRIDSDTLEGAJOSS_nEOF"},{ctrl:"GRIDSDTLEGAJOSS",prop:"Rows"},{av:"AV12LiqPeriodo",fld:"vLIQPERIODO",pic:"",hsh:!0},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV5SDTLegajos",fld:"vSDTLEGAJOS",grid:25,pic:""},{av:"nGXsfl_25_idx",ctrl:"GRID",prop:"GridCurrRow",grid:25},{av:"nRC_GXsfl_25",ctrl:"GRIDSDTLEGAJOSS",prop:"GridRC",grid:25}],[{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}]];this.EvtParms.GRIDSDTLEGAJOSS_LASTPAGE=[[{av:"GRIDSDTLEGAJOSS_nFirstRecordOnPage"},{av:"GRIDSDTLEGAJOSS_nEOF"},{ctrl:"GRIDSDTLEGAJOSS",prop:"Rows"},{av:"AV12LiqPeriodo",fld:"vLIQPERIODO",pic:"",hsh:!0},{av:"AV9EmpCod",fld:"vEMPCOD",pic:"ZZZ9",hsh:!0},{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0},{av:"AV5SDTLegajos",fld:"vSDTLEGAJOS",grid:25,pic:""},{av:"nGXsfl_25_idx",ctrl:"GRID",prop:"GridCurrRow",grid:25},{av:"nRC_GXsfl_25",ctrl:"GRIDSDTLEGAJOSS",prop:"GridRC",grid:25}],[{av:"AV8CliCod",fld:"vCLICOD",pic:"ZZZZZ9",hsh:!0}]];this.setVCMap("AV12LiqPeriodo","vLIQPERIODO",0,"date",8,0);this.setVCMap("AV9EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV8CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV5SDTLegajos","vSDTLEGAJOS",0,"CollSDTLegajos.SDTLegajosItem",0,0);this.setVCMap("AV26Respuesta","vRESPUESTA",0,"char",20,0);i.addRefreshingParm({rfrProp:"Rows",gxGrid:"Gridsdtlegajoss"});i.addRefreshingVar({rfrVar:"AV12LiqPeriodo"});i.addRefreshingVar({rfrVar:"AV9EmpCod"});i.addRefreshingVar({rfrVar:"AV8CliCod"});i.addRefreshingParm({rfrVar:"AV12LiqPeriodo"});i.addRefreshingParm({rfrVar:"AV9EmpCod"});i.addRefreshingParm({rfrVar:"AV8CliCod"});this.addGridBCProperty("Sdtlegajos",["LegNumero"],this.GXValidFnc[26],"AV5SDTLegajos");this.addGridBCProperty("Sdtlegajos",["seleccionado"],this.GXValidFnc[27],"AV5SDTLegajos");this.addGridBCProperty("Sdtlegajos",["LegIdNomApe"],this.GXValidFnc[28],"AV5SDTLegajos");this.Initialize()});gx.wi(function(){gx.createParentObj(this.confirmarliquidacion)})