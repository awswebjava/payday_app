gx.evt.autoSkip=!1;gx.define("tipodeconceptogeneral",!0,function(n){this.ServerClass="tipodeconceptogeneral";this.PackageName="web";this.ServerFullClass="web.tipodeconceptogeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Tipoconcod=function(){return this.validCliEvt("Valid_Tipoconcod",0,function(){try{var n=gx.util.balloon.getNew("TIPOCONCOD");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11p61_client=function(){return this.clearMessages(),this.call("web.tipodeconcepto",["UPD",this.A37TipoConCod],null,["Mode","TipoConCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12p61_client=function(){return this.clearMessages(),this.call("web.tipodeconcepto",["DLT",this.A37TipoConCod],null,["Mode","TipoConCod"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16p62_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17p62_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56];this.GXLastCtrlId=56;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Tipoconcod,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOCONCOD",fmt:0,gxz:"Z37TipoConCod",gxold:"O37TipoConCod",gxvar:"A37TipoConCod",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A37TipoConCod=n)},v2z:function(n){n!==undefined&&(gx.O.Z37TipoConCod=n)},v2c:function(){gx.fn.setComboBoxValue("TIPOCONCOD",gx.O.A37TipoConCod);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A37TipoConCod=this.val())},val:function(){return gx.fn.getControlValue("TIPOCONCOD")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOCONDESCRIP",fmt:0,gxz:"Z370TipoConDescrip",gxold:"O370TipoConDescrip",gxvar:"A370TipoConDescrip",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A370TipoConDescrip=n)},v2z:function(n){n!==undefined&&(gx.O.Z370TipoConDescrip=n)},v2c:function(){gx.fn.setControlValue("TIPOCONDESCRIP",gx.O.A370TipoConDescrip,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A370TipoConDescrip=this.val())},val:function(){return gx.fn.getControlValue("TIPOCONDESCRIP")},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRANGODESDE",fmt:0,gxz:"Z377TRangoDesde",gxold:"O377TRangoDesde",gxvar:"A377TRangoDesde",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A377TRangoDesde=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z377TRangoDesde=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TRANGODESDE",gx.O.A377TRangoDesde,0)},c2v:function(){this.val()!==undefined&&(gx.O.A377TRangoDesde=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TRANGODESDE",gx.thousandSeparator)},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"int",len:8,dec:0,sign:!1,pic:"ZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TRANGOHASTA",fmt:0,gxz:"Z378TRangoHasta",gxold:"O378TRangoHasta",gxvar:"A378TRangoHasta",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A378TRangoHasta=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z378TRangoHasta=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TRANGOHASTA",gx.O.A378TRangoHasta,0)},c2v:function(){this.val()!==undefined&&(gx.O.A378TRangoHasta=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TRANGOHASTA",gx.thousandSeparator)},nac:gx.falseFn};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOCONORDEN",fmt:0,gxz:"Z384TipoConOrden",gxold:"O384TipoConOrden",gxvar:"A384TipoConOrden",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A384TipoConOrden=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z384TipoConOrden=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("TIPOCONORDEN",gx.O.A384TipoConOrden,0)},c2v:function(){this.val()!==undefined&&(gx.O.A384TipoConOrden=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("TIPOCONORDEN",gx.thousandSeparator)},nac:gx.falseFn};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOCONPALABRA",fmt:0,gxz:"Z2102TipoConPalabra",gxold:"O2102TipoConPalabra",gxvar:"A2102TipoConPalabra",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A2102TipoConPalabra=n)},v2z:function(n){n!==undefined&&(gx.O.Z2102TipoConPalabra=n)},v2c:function(){gx.fn.setControlValue("TIPOCONPALABRA",gx.O.A2102TipoConPalabra,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2102TipoConPalabra=this.val())},val:function(){return gx.fn.getControlValue("TIPOCONPALABRA")},nac:gx.falseFn};this.declareDomainHdlr(39,function(){});t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"vTIPOCONPAI_DESCRIPTION",fmt:0,gxz:"ZV12TipoConPai_Description",gxold:"OV12TipoConPai_Description",gxvar:"AV12TipoConPai_Description",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.AV12TipoConPai_Description=n)},v2z:function(n){n!==undefined&&(gx.O.ZV12TipoConPai_Description=n)},v2c:function(){gx.fn.setControlValue("vTIPOCONPAI_DESCRIPTION",gx.O.AV12TipoConPai_Description,0)},c2v:function(){this.val()!==undefined&&(gx.O.AV12TipoConPai_Description=this.val())},val:function(){return gx.fn.getControlValue("vTIPOCONPAI_DESCRIPTION")},nac:gx.falseFn};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"",grid:0};t[47]={id:47,fld:"",grid:0};t[48]={id:48,fld:"",grid:0};t[49]={id:49,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"TIPOCONTIPO",fmt:0,gxz:"Z2157TipoConTipo",gxold:"O2157TipoConTipo",gxvar:"A2157TipoConTipo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"combo",v2v:function(n){n!==undefined&&(gx.O.A2157TipoConTipo=n)},v2z:function(n){n!==undefined&&(gx.O.Z2157TipoConTipo=n)},v2c:function(){gx.fn.setComboBoxValue("TIPOCONTIPO",gx.O.A2157TipoConTipo);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A2157TipoConTipo=this.val())},val:function(){return gx.fn.getControlValue("TIPOCONTIPO")},nac:gx.falseFn};this.declareDomainHdlr(49,function(){});t[50]={id:50,fld:"",grid:0};t[51]={id:51,fld:"",grid:0};t[52]={id:52,fld:"",grid:0};t[53]={id:53,fld:"",grid:0};t[54]={id:54,fld:"BTNUPDATE",grid:0,evt:"e11p61_client"};t[55]={id:55,fld:"",grid:0};t[56]={id:56,fld:"BTNDELETE",grid:0,evt:"e12p61_client"};this.A37TipoConCod="";this.Z37TipoConCod="";this.O37TipoConCod="";this.A370TipoConDescrip="";this.Z370TipoConDescrip="";this.O370TipoConDescrip="";this.A377TRangoDesde=0;this.Z377TRangoDesde=0;this.O377TRangoDesde=0;this.A378TRangoHasta=0;this.Z378TRangoHasta=0;this.O378TRangoHasta=0;this.A384TipoConOrden=0;this.Z384TipoConOrden=0;this.O384TipoConOrden=0;this.A2102TipoConPalabra="";this.Z2102TipoConPalabra="";this.O2102TipoConPalabra="";this.AV12TipoConPai_Description="";this.ZV12TipoConPai_Description="";this.OV12TipoConPai_Description="";this.A2157TipoConTipo="";this.Z2157TipoConTipo="";this.O2157TipoConTipo="";this.A37TipoConCod="";this.A370TipoConDescrip="";this.A377TRangoDesde=0;this.A378TRangoHasta=0;this.A384TipoConOrden=0;this.A2102TipoConPalabra="";this.AV12TipoConPai_Description="";this.A2157TipoConTipo="";this.Events={e16p62_client:["ENTER",!0],e17p62_client:["CANCEL",!0],e11p61_client:["'DOUPDATE'",!1],e12p61_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{ctrl:"TIPOCONCOD"},{av:"A37TipoConCod",fld:"TIPOCONCOD",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{ctrl:"TIPOCONCOD"},{av:"A37TipoConCod",fld:"TIPOCONCOD",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{ctrl:"TIPOCONCOD"},{av:"A37TipoConCod",fld:"TIPOCONCOD",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_TIPOCONCOD=[[],[]];this.Initialize()})