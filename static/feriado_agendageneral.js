gx.evt.autoSkip=!1;gx.define("feriado_agendageneral",!0,function(n){this.ServerClass="feriado_agendageneral";this.PackageName="web";this.ServerFullClass="web.feriado_agendageneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Ferid=function(){return this.validCliEvt("Valid_Ferid",0,function(){try{var n=gx.util.balloon.getNew("FERID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Feranio=function(){return this.validCliEvt("Valid_Feranio",0,function(){try{var n=gx.util.balloon.getNew("FERANIO");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Paicod=function(){return this.validSrvEvt("valid_Paicod",0).then(function(n){return n}.closure(this))};this.e11cl1_client=function(){return this.clearMessages(),this.call("web.feriado_agenda",["UPD",this.A46PaiCod,this.A1223FerId,this.A1226FerAnio,this.A1227FerFecha],null,["Mode","PaiCod","FerId","FerAnio","FerFecha"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12cl1_client=function(){return this.clearMessages(),this.call("web.feriado_agenda",["DLT",this.A46PaiCod,this.A1223FerId,this.A1226FerAnio,this.A1227FerFecha],null,["Mode","PaiCod","FerId","FerAnio","FerFecha"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16cl2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17cl2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35];this.GXLastCtrlId=35;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:40,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Ferid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"FERID",fmt:0,gxz:"Z1223FerId",gxold:"O1223FerId",gxvar:"A1223FerId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1223FerId=n)},v2z:function(n){n!==undefined&&(gx.O.Z1223FerId=n)},v2c:function(){gx.fn.setComboBoxValue("FERID",gx.O.A1223FerId)},c2v:function(){this.val()!==undefined&&(gx.O.A1223FerId=this.val())},val:function(){return gx.fn.getControlValue("FERID")},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"FERANIO_CELL",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Feranio,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"FERANIO",fmt:0,gxz:"Z1226FerAnio",gxold:"O1226FerAnio",gxvar:"A1226FerAnio",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1226FerAnio=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1226FerAnio=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("FERANIO",gx.O.A1226FerAnio,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1226FerAnio=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("FERANIO",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"date",len:10,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"FERFECHA",fmt:0,gxz:"Z1227FerFecha",gxold:"O1227FerFecha",gxvar:"A1227FerFecha",dp:{f:0,st:!1,wn:!1,mf:!1,pic:"99/99/9999",dec:0},ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1227FerFecha=gx.fn.toDatetimeValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1227FerFecha=gx.fn.toDatetimeValue(n))},v2c:function(){gx.fn.setControlValue("FERFECHA",gx.O.A1227FerFecha,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1227FerFecha=gx.fn.toDatetimeValue(this.val()))},val:function(){return gx.fn.getControlValue("FERFECHA")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"BTNUPDATE",grid:0,evt:"e11cl1_client"};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"BTNDELETE",grid:0,evt:"e12cl1_client"};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[35]={id:35,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Paicod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PAICOD",fmt:0,gxz:"Z46PaiCod",gxold:"O46PaiCod",gxvar:"A46PaiCod",ucs:[],op:[14],ip:[14,35],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A46PaiCod=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z46PaiCod=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PAICOD",gx.O.A46PaiCod,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A46PaiCod=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PAICOD",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(35,function(){});this.A1223FerId="";this.Z1223FerId="";this.O1223FerId="";this.A1226FerAnio=0;this.Z1226FerAnio=0;this.O1226FerAnio=0;this.A1227FerFecha=gx.date.nullDate();this.Z1227FerFecha=gx.date.nullDate();this.O1227FerFecha=gx.date.nullDate();this.A46PaiCod=0;this.Z46PaiCod=0;this.O46PaiCod=0;this.A1223FerId="";this.A1226FerAnio=0;this.A1227FerFecha=gx.date.nullDate();this.A46PaiCod=0;this.Events={e16cl2_client:["ENTER",!0],e17cl2_client:["CANCEL",!0],e11cl1_client:["'DOUPDATE'",!1],e12cl1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A1226FerAnio",fld:"FERANIO",pic:"ZZZ9"},{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{ctrl:"FERID"},{av:"A1223FerId",fld:"FERID",pic:""},{av:"A1227FerFecha",fld:"FERFECHA",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{ctrl:"FERID"},{av:"A1223FerId",fld:"FERID",pic:""},{av:"A1226FerAnio",fld:"FERANIO",pic:"ZZZ9"},{av:"A1227FerFecha",fld:"FERFECHA",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{ctrl:"FERID"},{av:"A1223FerId",fld:"FERID",pic:""},{av:"A1226FerAnio",fld:"FERANIO",pic:"ZZZ9"},{av:"A1227FerFecha",fld:"FERFECHA",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_FERID=[[],[]];this.EvtParms.VALID_FERANIO=[[],[]];this.EvtParms.VALID_PAICOD=[[{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{ctrl:"FERID"},{av:"A1223FerId",fld:"FERID",pic:""}],[{ctrl:"FERID"},{av:"A1223FerId",fld:"FERID",pic:""}]];this.Initialize()})