gx.evt.autoSkip=!1;gx.define("menuversionesgeneral",!0,function(n){this.ServerClass="menuversionesgeneral";this.PackageName="web";this.ServerFullClass="web.menuversionesgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Perfilid=function(){return this.validCliEvt("Valid_Perfilid",0,function(){try{var n=gx.util.balloon.getNew("PERFILID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Menuverid=function(){return this.validCliEvt("Valid_Menuverid",0,function(){try{var n=gx.util.balloon.getNew("MENUVERID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Rolid=function(){return this.validCliEvt("Valid_Rolid",0,function(){try{var n=gx.util.balloon.getNew("ROLID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11la1_client=function(){return this.clearMessages(),this.call("web.menuversiones",["UPD",this.A1923RolId,this.A1925PerfilId,this.A1928MenuVerId],null,["Mode","RolId","PerfilId","MenuVerId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12la1_client=function(){return this.clearMessages(),this.call("web.menuversiones",["DLT",this.A1923RolId,this.A1925PerfilId,this.A1928MenuVerId],null,["Mode","RolId","PerfilId","MenuVerId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16la2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17la2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35];this.GXLastCtrlId=35;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Perfilid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERFILID",fmt:0,gxz:"Z1925PerfilId",gxold:"O1925PerfilId",gxvar:"A1925PerfilId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1925PerfilId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1925PerfilId=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("PERFILID",gx.O.A1925PerfilId)},c2v:function(){this.val()!==undefined&&(gx.O.A1925PerfilId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PERFILID",gx.thousandSeparator)},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"int",len:15,dec:0,sign:!1,pic:"ZZZZZZZZZZZZZZ9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Menuverid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MENUVERID",fmt:0,gxz:"Z1928MenuVerId",gxold:"O1928MenuVerId",gxvar:"A1928MenuVerId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1928MenuVerId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1928MenuVerId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("MENUVERID",gx.O.A1928MenuVerId,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1928MenuVerId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("MENUVERID",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(19,function(){});t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"int",len:4,dec:0,sign:!1,pic:"ZZZ9",ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MENUPAIS",fmt:0,gxz:"Z1927MenuPais",gxold:"O1927MenuPais",gxvar:"A1927MenuPais",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1927MenuPais=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1927MenuPais=gx.num.intval(n))},v2c:function(){gx.fn.setComboBoxValue("MENUPAIS",gx.O.A1927MenuPais);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1927MenuPais=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("MENUPAIS",gx.thousandSeparator)},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,fld:"BTNUPDATE",grid:0,evt:"e11la1_client"};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"BTNDELETE",grid:0,evt:"e12la1_client"};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,fld:"HTML_BOTTOMAUXILIARCONTROLS",grid:0};t[35]={id:35,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Rolid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"ROLID",fmt:0,gxz:"Z1923RolId",gxold:"O1923RolId",gxvar:"A1923RolId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1923RolId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1923RolId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("ROLID",gx.O.A1923RolId,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1923RolId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("ROLID",gx.thousandSeparator)},nac:gx.falseFn};this.A1925PerfilId=0;this.Z1925PerfilId=0;this.O1925PerfilId=0;this.A1928MenuVerId=0;this.Z1928MenuVerId=0;this.O1928MenuVerId=0;this.A1927MenuPais=0;this.Z1927MenuPais=0;this.O1927MenuPais=0;this.A1923RolId=0;this.Z1923RolId=0;this.O1923RolId=0;this.A1925PerfilId=0;this.A1928MenuVerId=0;this.A1927MenuPais=0;this.A1923RolId=0;this.Events={e16la2_client:["ENTER",!0],e17la2_client:["CANCEL",!0],e11la1_client:["'DOUPDATE'",!1],e12la1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A1923RolId",fld:"ROLID",pic:"Z9"},{av:"A1928MenuVerId",fld:"MENUVERID",pic:"ZZZZZZZZZZZZZZ9"},{ctrl:"MENUPAIS"},{av:"A1927MenuPais",fld:"MENUPAIS",pic:"ZZZ9"},{ctrl:"PERFILID"},{av:"A1925PerfilId",fld:"PERFILID",pic:"Z9"}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A1923RolId",fld:"ROLID",pic:"Z9"},{ctrl:"PERFILID"},{av:"A1925PerfilId",fld:"PERFILID",pic:"Z9"},{av:"A1928MenuVerId",fld:"MENUVERID",pic:"ZZZZZZZZZZZZZZ9"}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A1923RolId",fld:"ROLID",pic:"Z9"},{ctrl:"PERFILID"},{av:"A1925PerfilId",fld:"PERFILID",pic:"Z9"},{av:"A1928MenuVerId",fld:"MENUVERID",pic:"ZZZZZZZZZZZZZZ9"}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_PERFILID=[[],[]];this.EvtParms.VALID_MENUVERID=[[],[]];this.EvtParms.VALID_ROLID=[[],[]];this.Initialize()})