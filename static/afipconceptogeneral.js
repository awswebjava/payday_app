gx.evt.autoSkip=!1;gx.define("afipconceptogeneral",!0,function(n){this.ServerClass="afipconceptogeneral";this.PackageName="web";this.ServerFullClass="web.afipconceptogeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Afipconcod=function(){return this.validCliEvt("Valid_Afipconcod",0,function(){try{var n=gx.util.balloon.getNew("AFIPCONCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11h41_client=function(){return this.clearMessages(),this.call("web.afipconcepto",["UPD",this.A72AFIPConCod],null,["Mode","AFIPConCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12h41_client=function(){return this.clearMessages(),this.call("web.afipconcepto",["DLT",this.A72AFIPConCod],null,["Mode","AFIPConCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16h42_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17h42_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46];this.GXLastCtrlId=46;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:6,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Afipconcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AFIPCONCOD",fmt:0,gxz:"Z72AFIPConCod",gxold:"O72AFIPConCod",gxvar:"A72AFIPConCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A72AFIPConCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z72AFIPConCod=n)},v2c:function(){gx.fn.setControlValue("AFIPCONCOD",gx.O.A72AFIPConCod,0)},c2v:function(){this.val()!==undefined&&(gx.O.A72AFIPConCod=this.val())},val:function(){return gx.fn.getControlValue("AFIPCONCOD")},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AFIPCONDESCRIP",fmt:0,gxz:"Z369AFIPConDescrip",gxold:"O369AFIPConDescrip",gxvar:"A369AFIPConDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A369AFIPConDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z369AFIPConDescrip=n)},v2c:function(){gx.fn.setControlValue("AFIPCONDESCRIP",gx.O.A369AFIPConDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A369AFIPConDescrip=this.val())},val:function(){return gx.fn.getControlValue("AFIPCONDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AFIPCONTIPOCONCOD",fmt:0,gxz:"Z387AfipConTipoConCod",gxold:"O387AfipConTipoConCod",gxvar:"A387AfipConTipoConCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A387AfipConTipoConCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z387AfipConTipoConCod=n)},v2c:function(){gx.fn.setComboBoxValue("AFIPCONTIPOCONCOD",gx.O.A387AfipConTipoConCod);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A387AfipConTipoConCod=this.val())},val:function(){return gx.fn.getControlValue("AFIPCONTIPOCONCOD")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AFIPCONSUBTIPOCONCOD1",fmt:0,gxz:"Z388AfipConSubTipoConCod1",gxold:"O388AfipConSubTipoConCod1",gxvar:"A388AfipConSubTipoConCod1",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A388AfipConSubTipoConCod1=n)},v2z:function(n){n!==undefined&&(gx.O.Z388AfipConSubTipoConCod1=n)},v2c:function(){gx.fn.setControlValue("AFIPCONSUBTIPOCONCOD1",gx.O.A388AfipConSubTipoConCod1,0)},c2v:function(){this.val()!==undefined&&(gx.O.A388AfipConSubTipoConCod1=this.val())},val:function(){return gx.fn.getControlValue("AFIPCONSUBTIPOCONCOD1")},nac:gx.falseFn};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"svchar",len:200,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AFIPCONCODMASDESC",fmt:0,gxz:"Z385AfipConCodMasDesc",gxold:"O385AfipConCodMasDesc",gxvar:"A385AfipConCodMasDesc",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A385AfipConCodMasDesc=n)},v2z:function(n){n!==undefined&&(gx.O.Z385AfipConCodMasDesc=n)},v2c:function(){gx.fn.setControlValue("AFIPCONCODMASDESC",gx.O.A385AfipConCodMasDesc,0)},c2v:function(){this.val()!==undefined&&(gx.O.A385AfipConCodMasDesc=this.val())},val:function(){return gx.fn.getControlValue("AFIPCONCODMASDESC")},nac:gx.falseFn};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"AFIPCONLIQAGIL",fmt:0,gxz:"Z1646AFIPConLiqAgil",gxold:"O1646AFIPConLiqAgil",gxvar:"A1646AFIPConLiqAgil",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1646AFIPConLiqAgil=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1646AFIPConLiqAgil=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("AFIPCONLIQAGIL",gx.O.A1646AFIPConLiqAgil,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1646AFIPConLiqAgil=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("AFIPCONLIQAGIL")},nac:gx.falseFn,values:["true","false"]};t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,fld:"BTNUPDATE",grid:0,evt:"e11h41_client"};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"BTNDELETE",grid:0,evt:"e12h41_client"};this.A72AFIPConCod="";this.Z72AFIPConCod="";this.O72AFIPConCod="";this.A369AFIPConDescrip="";this.Z369AFIPConDescrip="";this.O369AFIPConDescrip="";this.A387AfipConTipoConCod="";this.Z387AfipConTipoConCod="";this.O387AfipConTipoConCod="";this.A388AfipConSubTipoConCod1="";this.Z388AfipConSubTipoConCod1="";this.O388AfipConSubTipoConCod1="";this.A385AfipConCodMasDesc="";this.Z385AfipConCodMasDesc="";this.O385AfipConCodMasDesc="";this.A1646AFIPConLiqAgil=!1;this.Z1646AFIPConLiqAgil=!1;this.O1646AFIPConLiqAgil=!1;this.A72AFIPConCod="";this.A369AFIPConDescrip="";this.A387AfipConTipoConCod="";this.A388AfipConSubTipoConCod1="";this.A385AfipConCodMasDesc="";this.A1646AFIPConLiqAgil=!1;this.Events={e16h42_client:["ENTER",!0],e17h42_client:["CANCEL",!0],e11h41_client:["'DOUPDATE'",!1],e12h41_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A72AFIPConCod",fld:"AFIPCONCOD",pic:""},{av:"A1646AFIPConLiqAgil",fld:"AFIPCONLIQAGIL",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A72AFIPConCod",fld:"AFIPCONCOD",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A72AFIPConCod",fld:"AFIPCONCOD",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_AFIPCONCOD=[[],[]];this.Initialize()})