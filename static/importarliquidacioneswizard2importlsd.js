gx.evt.autoSkip=!1;gx.define("importarliquidacioneswizard2importlsd",!0,function(n){var t,i,r;this.ServerClass="importarliquidacioneswizard2importlsd";this.PackageName="web";this.ServerFullClass="web.importarliquidacioneswizard2importlsd";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!0;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV10HasValidationErrors=gx.fn.getControlValue("vHASVALIDATIONERRORS");this.AV14MenuOpcCod=gx.fn.getControlValue("vMENUOPCCOD");this.AV6WebSessionKey=gx.fn.getControlValue("vWEBSESSIONKEY");this.AV8PreviousStep=gx.fn.getControlValue("vPREVIOUSSTEP");this.AV7GoingBack=gx.fn.getControlValue("vGOINGBACK")};this.e12od2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e13od2_client=function(){return this.executeServerEvent("'WIZARDPREVIOUS'",!0,null,!1,!1)};this.e16od2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,10,11,12,13,15];this.GXLastCtrlId=15;this.BTNWIZARDPREVIOUSContainer=gx.uc.getNew(this,14,0,"WWP_IconButton",this.CmpContext+"BTNWIZARDPREVIOUSContainer","Btnwizardprevious","BTNWIZARDPREVIOUS");i=this.BTNWIZARDPREVIOUSContainer;i.setProp("Enabled","Enabled",!0,"boolean");i.setProp("BeforeIconClass","Beforeiconclass","fas fa-arrow-left","str");i.setProp("AfterIconClass","Aftericonclass","","str");i.addEventHandler("Event",this.e13od2_client);i.setProp("Caption","Caption",gx.getMessage("GXM_previous"),"str");i.setProp("Class","Class","BtnDefault ButtonWizard","str");i.setProp("Visible","Visible",!0,"bool");i.setC2ShowFunction(function(n){n.show()});this.setUserControl(i);this.BTNWIZARDNEXTContainer=gx.uc.getNew(this,16,0,"WWP_IconButton",this.CmpContext+"BTNWIZARDNEXTContainer","Btnwizardnext","BTNWIZARDNEXT");r=this.BTNWIZARDNEXTContainer;r.setProp("Enabled","Enabled",!0,"boolean");r.setProp("BeforeIconClass","Beforeiconclass","","str");r.setProp("AfterIconClass","Aftericonclass","fas fa-arrow-right","str");r.addEventHandler("Event",this.e12od2_client);r.setProp("Caption","Caption",gx.getMessage("GXM_next"),"str");r.setProp("Class","Class","Button ButtonWizard","str");r.setProp("Visible","Visible",!0,"bool");r.setC2ShowFunction(function(n){n.show()});this.setUserControl(r);t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLEMAIN",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"TABLEACTIONS",grid:0};t[13]={id:13,fld:"",grid:0};t[15]={id:15,fld:"",grid:0};this.AV6WebSessionKey="";this.AV8PreviousStep="";this.AV7GoingBack=!1;this.AV14MenuOpcCod="";this.AV10HasValidationErrors=!1;this.Events={e12od2_client:["ENTER",!0],e13od2_client:["'WIZARDPREVIOUS'",!0],e16od2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"AV10HasValidationErrors",fld:"vHASVALIDATIONERRORS",pic:"",hsh:!0}],[]];this.EvtParms.ENTER=[[{av:"AV10HasValidationErrors",fld:"vHASVALIDATIONERRORS",pic:"",hsh:!0},{av:"AV14MenuOpcCod",fld:"vMENUOPCCOD",pic:""},{av:"AV6WebSessionKey",fld:"vWEBSESSIONKEY",pic:""}],[{av:"AV14MenuOpcCod",fld:"vMENUOPCCOD",pic:""}]];this.EvtParms["'WIZARDPREVIOUS'"]=[[{av:"AV14MenuOpcCod",fld:"vMENUOPCCOD",pic:""},{av:"AV6WebSessionKey",fld:"vWEBSESSIONKEY",pic:""}],[{av:"AV14MenuOpcCod",fld:"vMENUOPCCOD",pic:""}]];this.EnterCtrl=["BTNWIZARDNEXT"];this.setVCMap("AV10HasValidationErrors","vHASVALIDATIONERRORS",0,"boolean",4,0);this.setVCMap("AV14MenuOpcCod","vMENUOPCCOD",0,"svchar",100,0);this.setVCMap("AV6WebSessionKey","vWEBSESSIONKEY",0,"svchar",40,0);this.setVCMap("AV8PreviousStep","vPREVIOUSSTEP",0,"svchar",40,0);this.setVCMap("AV7GoingBack","vGOINGBACK",0,"boolean",4,0);this.Initialize();this.setComponent({id:"WCIMPORTLSD",GXClass:null,Prefix:"W0009",lvl:1})})