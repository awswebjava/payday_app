gx.evt.autoSkip=!1;gx.define("menuitemgeneral",!0,function(n){this.ServerClass="menuitemgeneral";this.PackageName="web";this.ServerFullClass="web.menuitemgeneral";this.setObjectType("web");this.setCmpContext(n);this.ReadonlyForm=!0;this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){};this.Valid_Perfilid=function(){return this.validCliEvt("Valid_Perfilid",0,function(){try{var n=gx.util.balloon.getNew("PERFILID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.Valid_Menuitemid=function(){return this.validCliEvt("Valid_Menuitemid",0,function(){try{var n=gx.util.balloon.getNew("MENUITEMID");this.AnyError=0}catch(t){}try{return n==null?!0:n.show()}catch(t){}return!0})};this.e11lj1_client=function(){return this.clearMessages(),this.call("web.menuitem",["UPD",this.A1925PerfilId,this.A1937MenuItemId],null,["Mode","PerfilId","MenuItemId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e12lj1_client=function(){return this.clearMessages(),this.call("web.menuitem",["DLT",this.A1925PerfilId,this.A1937MenuItemId],null,["Mode","PerfilId","MenuItemId"]),this.refreshOutputs([]),this.OnClientEventEnd(),gx.$.Deferred().resolve()};this.e16lj2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e17lj2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var t=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76];this.GXLastCtrlId=76;t[2]={id:2,fld:"",grid:0};t[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};t[4]={id:4,fld:"",grid:0};t[5]={id:5,fld:"",grid:0};t[6]={id:6,fld:"TABLE",grid:0};t[7]={id:7,fld:"",grid:0};t[8]={id:8,fld:"",grid:0};t[9]={id:9,fld:"TRANSACTIONDETAIL_TABLEATTRIBUTES",grid:0};t[10]={id:10,fld:"",grid:0};t[11]={id:11,fld:"",grid:0};t[12]={id:12,fld:"",grid:0};t[13]={id:13,fld:"",grid:0};t[14]={id:14,lvl:0,type:"int",len:2,dec:0,sign:!1,pic:"Z9",ro:1,grid:0,gxgrid:null,fnc:this.Valid_Perfilid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"PERFILID",fmt:0,gxz:"Z1925PerfilId",gxold:"O1925PerfilId",gxvar:"A1925PerfilId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1925PerfilId=gx.num.intval(n))},v2z:function(n){n!==undefined&&(gx.O.Z1925PerfilId=gx.num.intval(n))},v2c:function(){gx.fn.setControlValue("PERFILID",gx.O.A1925PerfilId,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1925PerfilId=gx.num.intval(this.val()))},val:function(){return gx.fn.getIntegerValue("PERFILID",gx.thousandSeparator)},nac:gx.falseFn};t[15]={id:15,fld:"",grid:0};t[16]={id:16,fld:"",grid:0};t[17]={id:17,fld:"",grid:0};t[18]={id:18,fld:"",grid:0};t[19]={id:19,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:this.Valid_Menuitemid,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MENUITEMID",fmt:0,gxz:"Z1937MenuItemId",gxold:"O1937MenuItemId",gxvar:"A1937MenuItemId",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1937MenuItemId=n)},v2z:function(n){n!==undefined&&(gx.O.Z1937MenuItemId=n)},v2c:function(){gx.fn.setControlValue("MENUITEMID",gx.O.A1937MenuItemId,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1937MenuItemId=this.val())},val:function(){return gx.fn.getControlValue("MENUITEMID")},nac:gx.falseFn};t[20]={id:20,fld:"",grid:0};t[21]={id:21,fld:"",grid:0};t[22]={id:22,fld:"",grid:0};t[23]={id:23,fld:"",grid:0};t[24]={id:24,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MENUITEMTITULO",fmt:0,gxz:"Z1939MenuItemTitulo",gxold:"O1939MenuItemTitulo",gxvar:"A1939MenuItemTitulo",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1939MenuItemTitulo=n)},v2z:function(n){n!==undefined&&(gx.O.Z1939MenuItemTitulo=n)},v2c:function(){gx.fn.setControlValue("MENUITEMTITULO",gx.O.A1939MenuItemTitulo,0);typeof this.dom_hdl=="function"&&this.dom_hdl.call(gx.O)},c2v:function(){this.val()!==undefined&&(gx.O.A1939MenuItemTitulo=this.val())},val:function(){return gx.fn.getControlValue("MENUITEMTITULO")},nac:gx.falseFn};this.declareDomainHdlr(24,function(){});t[25]={id:25,fld:"",grid:0};t[26]={id:26,fld:"",grid:0};t[27]={id:27,fld:"",grid:0};t[28]={id:28,fld:"",grid:0};t[29]={id:29,lvl:0,type:"char",len:20,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMICOSVG",fmt:0,gxz:"Z1957MItemIcoSVG",gxold:"O1957MItemIcoSVG",gxvar:"A1957MItemIcoSVG",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"dyncombo",v2v:function(n){n!==undefined&&(gx.O.A1957MItemIcoSVG=n)},v2z:function(n){n!==undefined&&(gx.O.Z1957MItemIcoSVG=n)},v2c:function(){gx.fn.setComboBoxValue("MITEMICOSVG",gx.O.A1957MItemIcoSVG)},c2v:function(){this.val()!==undefined&&(gx.O.A1957MItemIcoSVG=this.val())},val:function(){return gx.fn.getControlValue("MITEMICOSVG")},nac:gx.falseFn};t[30]={id:30,fld:"",grid:0};t[31]={id:31,fld:"",grid:0};t[32]={id:32,fld:"",grid:0};t[33]={id:33,fld:"",grid:0};t[34]={id:34,lvl:0,type:"bitstr",len:1024,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMICOIMG",fmt:0,gxz:"Z1958MitemIcoImg",gxold:"O1958MitemIcoImg",gxvar:"A1958MitemIcoImg",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1958MitemIcoImg=n)},v2z:function(n){n!==undefined&&(gx.O.Z1958MitemIcoImg=n)},v2c:function(){gx.fn.setBlobValue("MITEMICOIMG",gx.O.A1958MitemIcoImg)},c2v:function(){this.val()!==undefined&&(gx.O.A1958MitemIcoImg=this.val())},val:function(){return gx.fn.getBlobValue("MITEMICOIMG")},nac:gx.falseFn};t[35]={id:35,fld:"",grid:0};t[36]={id:36,fld:"",grid:0};t[37]={id:37,fld:"",grid:0};t[38]={id:38,fld:"",grid:0};t[39]={id:39,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMESMENU",fmt:0,gxz:"Z1938MItemEsMenu",gxold:"O1938MItemEsMenu",gxvar:"A1938MItemEsMenu",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1938MItemEsMenu=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1938MItemEsMenu=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("MITEMESMENU",gx.O.A1938MItemEsMenu,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1938MItemEsMenu=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("MITEMESMENU")},nac:gx.falseFn,values:["true","false"]};t[40]={id:40,fld:"",grid:0};t[41]={id:41,fld:"",grid:0};t[42]={id:42,fld:"",grid:0};t[43]={id:43,fld:"",grid:0};t[44]={id:44,lvl:0,type:"svchar",len:40,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMPADREDEF",fmt:0,gxz:"Z1944MItemPadreDef",gxold:"O1944MItemPadreDef",gxvar:"A1944MItemPadreDef",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1944MItemPadreDef=n)},v2z:function(n){n!==undefined&&(gx.O.Z1944MItemPadreDef=n)},v2c:function(){gx.fn.setControlValue("MITEMPADREDEF",gx.O.A1944MItemPadreDef,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1944MItemPadreDef=this.val())},val:function(){return gx.fn.getControlValue("MITEMPADREDEF")},nac:gx.falseFn};t[45]={id:45,fld:"",grid:0};t[46]={id:46,fld:"",grid:0};t[47]={id:47,fld:"",grid:0};t[48]={id:48,fld:"",grid:0};t[49]={id:49,lvl:0,type:"boolean",len:4,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMPADREOBL",fmt:0,gxz:"Z1945MItemPadreObl",gxold:"O1945MItemPadreObl",gxvar:"A1945MItemPadreObl",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"checkbox",v2v:function(n){n!==undefined&&(gx.O.A1945MItemPadreObl=gx.lang.booleanValue(n))},v2z:function(n){n!==undefined&&(gx.O.Z1945MItemPadreObl=gx.lang.booleanValue(n))},v2c:function(){gx.fn.setCheckBoxValue("MITEMPADREOBL",gx.O.A1945MItemPadreObl,!0)},c2v:function(){this.val()!==undefined&&(gx.O.A1945MItemPadreObl=gx.lang.booleanValue(this.val()))},val:function(){return gx.fn.getControlValue("MITEMPADREOBL")},nac:gx.falseFn,values:["true","false"]};t[50]={id:50,fld:"",grid:0};t[51]={id:51,fld:"",grid:0};t[52]={id:52,fld:"",grid:0};t[53]={id:53,fld:"",grid:0};t[54]={id:54,lvl:0,type:"svchar",len:400,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMBIENTITDEF",fmt:0,gxz:"Z1955MItemBienTitDef",gxold:"O1955MItemBienTitDef",gxvar:"A1955MItemBienTitDef",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1955MItemBienTitDef=n)},v2z:function(n){n!==undefined&&(gx.O.Z1955MItemBienTitDef=n)},v2c:function(){gx.fn.setControlValue("MITEMBIENTITDEF",gx.O.A1955MItemBienTitDef,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1955MItemBienTitDef=this.val())},val:function(){return gx.fn.getControlValue("MITEMBIENTITDEF")},nac:gx.falseFn};t[55]={id:55,fld:"",grid:0};t[56]={id:56,fld:"",grid:0};t[57]={id:57,fld:"",grid:0};t[58]={id:58,fld:"",grid:0};t[59]={id:59,lvl:0,type:"vchar",len:2097152,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMBIENTEXTDEF",fmt:0,gxz:"Z1956MItemBienTextDef",gxold:"O1956MItemBienTextDef",gxvar:"A1956MItemBienTextDef",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1956MItemBienTextDef=n)},v2z:function(n){n!==undefined&&(gx.O.Z1956MItemBienTextDef=n)},v2c:function(){gx.fn.setControlValue("MITEMBIENTEXTDEF",gx.O.A1956MItemBienTextDef,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1956MItemBienTextDef=this.val())},val:function(){return gx.fn.getControlValue("MITEMBIENTEXTDEF")},nac:gx.falseFn};t[60]={id:60,fld:"",grid:0};t[61]={id:61,fld:"",grid:0};t[62]={id:62,fld:"",grid:0};t[63]={id:63,fld:"",grid:0};t[64]={id:64,lvl:0,type:"bitstr",len:1024,dec:0,sign:!1,ro:1,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMBIENIMGDEF",fmt:0,gxz:"Z1952MItemBienImgDef",gxold:"O1952MItemBienImgDef",gxvar:"A1952MItemBienImgDef",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1952MItemBienImgDef=n)},v2z:function(n){n!==undefined&&(gx.O.Z1952MItemBienImgDef=n)},v2c:function(){gx.fn.setBlobValue("MITEMBIENIMGDEF",gx.O.A1952MItemBienImgDef)},c2v:function(){this.val()!==undefined&&(gx.O.A1952MItemBienImgDef=this.val())},val:function(){return gx.fn.getBlobValue("MITEMBIENIMGDEF")},nac:gx.falseFn};t[65]={id:65,fld:"",grid:0};t[66]={id:66,fld:"",grid:0};t[67]={id:67,fld:"",grid:0};t[68]={id:68,fld:"",grid:0};t[69]={id:69,lvl:0,type:"vchar",len:2097152,dec:0,sign:!1,ro:1,multiline:!0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"MITEMHELP",fmt:0,gxz:"Z1961MItemHelp",gxold:"O1961MItemHelp",gxvar:"A1961MItemHelp",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.A1961MItemHelp=n)},v2z:function(n){n!==undefined&&(gx.O.Z1961MItemHelp=n)},v2c:function(){gx.fn.setControlValue("MITEMHELP",gx.O.A1961MItemHelp,0)},c2v:function(){this.val()!==undefined&&(gx.O.A1961MItemHelp=this.val())},val:function(){return gx.fn.getControlValue("MITEMHELP")},nac:gx.falseFn};t[70]={id:70,fld:"",grid:0};t[71]={id:71,fld:"",grid:0};t[72]={id:72,fld:"",grid:0};t[73]={id:73,fld:"",grid:0};t[74]={id:74,fld:"BTNUPDATE",grid:0,evt:"e11lj1_client"};t[75]={id:75,fld:"",grid:0};t[76]={id:76,fld:"BTNDELETE",grid:0,evt:"e12lj1_client"};this.A1925PerfilId=0;this.Z1925PerfilId=0;this.O1925PerfilId=0;this.A1937MenuItemId="";this.Z1937MenuItemId="";this.O1937MenuItemId="";this.A1939MenuItemTitulo="";this.Z1939MenuItemTitulo="";this.O1939MenuItemTitulo="";this.A1957MItemIcoSVG="";this.Z1957MItemIcoSVG="";this.O1957MItemIcoSVG="";this.A1958MitemIcoImg="";this.Z1958MitemIcoImg="";this.O1958MitemIcoImg="";this.A1938MItemEsMenu=!1;this.Z1938MItemEsMenu=!1;this.O1938MItemEsMenu=!1;this.A1944MItemPadreDef="";this.Z1944MItemPadreDef="";this.O1944MItemPadreDef="";this.A1945MItemPadreObl=!1;this.Z1945MItemPadreObl=!1;this.O1945MItemPadreObl=!1;this.A1955MItemBienTitDef="";this.Z1955MItemBienTitDef="";this.O1955MItemBienTitDef="";this.A1956MItemBienTextDef="";this.Z1956MItemBienTextDef="";this.O1956MItemBienTextDef="";this.A1952MItemBienImgDef="";this.Z1952MItemBienImgDef="";this.O1952MItemBienImgDef="";this.A1961MItemHelp="";this.Z1961MItemHelp="";this.O1961MItemHelp="";this.A1925PerfilId=0;this.A1937MenuItemId="";this.A1939MenuItemTitulo="";this.A1957MItemIcoSVG="";this.A1958MitemIcoImg="";this.A1938MItemEsMenu=!1;this.A1944MItemPadreDef="";this.A1945MItemPadreObl=!1;this.A1955MItemBienTitDef="";this.A1956MItemBienTextDef="";this.A1952MItemBienImgDef="";this.A1961MItemHelp="";this.A1954MItemBienImgNom="";this.A1960MitemIcoImgNom="";this.A1953MItemBienImgExt="";this.A1959MItemIcoImgExt="";this.Events={e16lj2_client:["ENTER",!0],e17lj2_client:["CANCEL",!0],e11lj1_client:["'DOUPDATE'",!1],e12lj1_client:["'DODELETE'",!1]};this.EvtParms.REFRESH=[[{av:"A1925PerfilId",fld:"PERFILID",pic:"Z9"},{av:"A1937MenuItemId",fld:"MENUITEMID",pic:""},{ctrl:"MITEMICOSVG"},{av:"A1957MItemIcoSVG",fld:"MITEMICOSVG",pic:""},{av:"A1938MItemEsMenu",fld:"MITEMESMENU",pic:""},{av:"A1945MItemPadreObl",fld:"MITEMPADREOBL",pic:""}],[]];this.EvtParms["'DOUPDATE'"]=[[{av:"A1925PerfilId",fld:"PERFILID",pic:"Z9"},{av:"A1937MenuItemId",fld:"MENUITEMID",pic:""}],[]];this.EvtParms["'DODELETE'"]=[[{av:"A1925PerfilId",fld:"PERFILID",pic:"Z9"},{av:"A1937MenuItemId",fld:"MENUITEMID",pic:""}],[]];this.EvtParms.ENTER=[[],[]];this.EvtParms.VALID_PERFILID=[[],[]];this.EvtParms.VALID_MENUITEMID=[[],[]];this.Initialize()})