gx.evt.autoSkip=!1;gx.define("paisvacacionesgeneral",!0,function(n){this.ServerClass="paisvacacionesgeneral";this.PackageName="web";this.ServerFullClass="web.paisvacacionesgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.A46PaiCod=gx.fn.getIntegerValue("PAICOD",gx.thousandSeparator);this.A46PaiCod=gx.fn.getIntegerValue("PAICOD",gx.thousandSeparator)};this.Valid_Paivacdesant=function(){return this.validCliEvt("Valid_Paivacdesant",0,function(){try{var n=gx.util.balloon.getNew("PAIVACDESANT");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11j51_client=function(){return this.clearMessages(),this.call("web.paisvacaciones",["UPD",this.A46PaiCod,this.A1766PaiVacDesAnt],null,["Mode","PaiCod","PaiVacDesAnt"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12j51_client=function(){return this.clearMessages(),this.call("web.paisvacaciones",["DLT",this.A46PaiCod,this.A1766PaiVacDesAnt],null,["Mode","PaiCod","PaiVacDesAnt"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16j52_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17j52_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36];this.GXLastCtrlId=36;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"svchar",len:30,dec:0,sign:!1,pic:"@!",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PAINOM",fmt:0,gxz:"Z312PaiNom",gxold:"O312PaiNom",gxvar:"A312PaiNom",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A312PaiNom=n)},v2z:function(n){n!==undefined&&(gx.O.Z312PaiNom=n)},v2c:function(){gx.fn.setControlValue("PAINOM",gx.O.A312PaiNom,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A312PaiNom=this.val())},val:function(){return gx.fn.getControlValue("PAINOM")},nac:gx.falseFn};this.declareDomainHdlr(14,function(){});t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Paivacdesant,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PAIVACDESANT",fmt:0,gxz:"Z1766PaiVacDesAnt",gxold:"O1766PaiVacDesAnt",gxvar:"A1766PaiVacDesAnt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1766PaiVacDesAnt=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1766PaiVacDesAnt=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PAIVACDESANT",gx.O.A1766PaiVacDesAnt,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1766PaiVacDesAnt=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PAIVACDESANT",gx.thousandSeparator)},nac:gx.falseFn};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PAIVACHASANT",fmt:0,gxz:"Z1767PaiVacHasAnt",gxold:"O1767PaiVacHasAnt",gxvar:"A1767PaiVacHasAnt",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1767PaiVacHasAnt=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1767PaiVacHasAnt=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PAIVACHASANT",gx.O.A1767PaiVacHasAnt,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1767PaiVacHasAnt=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PAIVACHASANT",gx.thousandSeparator)},nac:gx.falseFn};t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PAIVACDIAS",fmt:0,gxz:"Z1768PaiVacDias",gxold:"O1768PaiVacDias",gxvar:"A1768PaiVacDias",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1768PaiVacDias=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1768PaiVacDias=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PAIVACDIAS",gx.O.A1768PaiVacDias,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1768PaiVacDias=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PAIVACDIAS",gx.thousandSeparator)},nac:gx.falseFn};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"BTNUPDATE",grid:0,evt:"e11j51_client"};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"BTNDELETE",grid:0,evt:"e12j51_client"};this.A312PaiNom="";this.Z312PaiNom="";this.O312PaiNom="";this.A1766PaiVacDesAnt=0;this.Z1766PaiVacDesAnt=0;this.O1766PaiVacDesAnt=0;this.A1767PaiVacHasAnt=0;this.Z1767PaiVacHasAnt=0;this.O1767PaiVacHasAnt=0;this.A1768PaiVacDias=0;this.Z1768PaiVacDias=0;this.O1768PaiVacDias=0;this.A312PaiNom="";this.A1766PaiVacDesAnt=0;this.A1767PaiVacHasAnt=0;this.A1768PaiVacDias=0;this.A46PaiCod=0;this.Events={e16j52_client:["ENTER",!0],e17j52_client:["CANCEL",!0],e11j51_client:["'DOUPDATE'",!1],e12j51_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"A1766PaiVacDesAnt",fld:"PAIVACDESANT",pic:"Z9"}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"A1766PaiVacDesAnt",fld:"PAIVACDESANT",pic:"Z9"}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A46PaiCod",fld:"PAICOD",pic:"ZZZ9"},{av:"A1766PaiVacDesAnt",fld:"PAIVACDESANT",pic:"Z9"}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_PAIVACDESANT=[[],[]];this.setVCMap("A46PaiCod","PAICOD",0,"int",4,0);this.setVCMap("A46PaiCod","PAICOD",0,"int",4,0);this.Initialize()})