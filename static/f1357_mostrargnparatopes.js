gx.evt.autoSkip=!1;gx.define("f1357_mostrargnparatopes",!1,function(){this.ServerClass="f1357_mostrargnparatopes";this.PackageName="web";this.ServerFullClass="web.f1357_mostrargnparatopes";this.setObjectType("web");this.hasEnterEvent=!1;this.skipOnEnter=!1;this.autoRefresh=!0;this.fullAjax=!0;this.supportAjaxEvents=!0;this.ajaxSecurityToken=!0;this.DSO="WorkWithPlusDS";this.SetStandaloneVars=function(){this.AV7F1357_GananciaNetaParaTopes=gx.fn.getControlValue("vF1357_GANANCIANETAPARATOPES");this.AV11CliCod=gx.fn.getIntegerValue("vCLICOD",gx.thousandSeparator);this.AV12EmpCod=gx.fn.getIntegerValue("vEMPCOD",gx.thousandSeparator);this.AV15F1357CTipoPre=gx.fn.getIntegerValue("vF1357CTIPOPRE",gx.thousandSeparator);this.AV8F1357CPer=gx.fn.getControlValue("vF1357CPER");this.AV13F1357CSec=gx.fn.getIntegerValue("vF1357CSEC",gx.thousandSeparator);this.AV14LegNumero=gx.fn.getIntegerValue("vLEGNUMERO",gx.thousandSeparator)};this.e139r2_client=function(){return this.executeServerEvent("ENTER",!0,null,!1,!1)};this.e149r2_client=function(){return this.executeServerEvent("CANCEL",!0,null,!1,!1)};this.GXValidFnc=[];var n=this.GXValidFnc;this.GXCtrlIds=[2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81];this.GXLastCtrlId=81;n[2]={id:2,fld:"",grid:0};n[3]={id:3,fld:"LAYOUTMAINTABLE",grid:0};n[4]={id:4,fld:"",grid:0};n[5]={id:5,fld:"",grid:0};n[6]={id:6,fld:"TABLEMAIN",grid:0};n[7]={id:7,fld:"",grid:0};n[8]={id:8,fld:"",grid:0};n[9]={id:9,fld:"TABLEATTRIBUTES",grid:0};n[10]={id:10,fld:"",grid:0};n[11]={id:11,fld:"",grid:0};n[12]={id:12,fld:"",grid:0};n[13]={id:13,fld:"",grid:0};n[14]={id:14,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LRGRAVADA",fmt:0,gxz:"ZV18GXV1",gxold:"OV18GXV1",gxvar:"GXV1",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV1=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV18GXV1=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LRGRAVADA",gx.O.GXV1,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV1=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LRGRAVADA",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[15]={id:15,fld:"",grid:0};n[16]={id:16,fld:"",grid:0};n[17]={id:17,fld:"",grid:0};n[18]={id:18,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_DESCUENTOSDELEY",fmt:0,gxz:"ZV19GXV2",gxold:"OV19GXV2",gxvar:"GXV2",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV2=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV19GXV2=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_DESCUENTOSDELEY",gx.O.GXV2,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV2=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_DESCUENTOSDELEY",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[19]={id:19,fld:"",grid:0};n[20]={id:20,fld:"",grid:0};n[21]={id:21,fld:"",grid:0};n[22]={id:22,fld:"",grid:0};n[23]={id:23,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGSEGURO",fmt:0,gxz:"ZV20GXV3",gxold:"OV20GXV3",gxvar:"GXV3",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV3=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV20GXV3=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGSEGURO",gx.O.GXV3,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV3=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGSEGURO",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[24]={id:24,fld:"",grid:0};n[25]={id:25,fld:"",grid:0};n[26]={id:26,fld:"",grid:0};n[27]={id:27,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGSEGUMIXTO",fmt:0,gxz:"ZV21GXV4",gxold:"OV21GXV4",gxvar:"GXV4",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV4=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV21GXV4=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGSEGUMIXTO",gx.O.GXV4,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV4=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGSEGUMIXTO",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[28]={id:28,fld:"",grid:0};n[29]={id:29,fld:"",grid:0};n[30]={id:30,fld:"",grid:0};n[31]={id:31,fld:"",grid:0};n[32]={id:32,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGRETPRIV",fmt:0,gxz:"ZV22GXV5",gxold:"OV22GXV5",gxvar:"GXV5",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV5=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV22GXV5=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGRETPRIV",gx.O.GXV5,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV5=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGRETPRIV",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[33]={id:33,fld:"",grid:0};n[34]={id:34,fld:"",grid:0};n[35]={id:35,fld:"",grid:0};n[36]={id:36,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGCUOTAPARTES",fmt:0,gxz:"ZV23GXV6",gxold:"OV23GXV6",gxvar:"GXV6",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV6=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV23GXV6=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGCUOTAPARTES",gx.O.GXV6,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV6=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGCUOTAPARTES",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[37]={id:37,fld:"",grid:0};n[38]={id:38,fld:"",grid:0};n[39]={id:39,fld:"",grid:0};n[40]={id:40,fld:"",grid:0};n[41]={id:41,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGSEPELIO",fmt:0,gxz:"ZV24GXV7",gxold:"OV24GXV7",gxvar:"GXV7",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV7=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV24GXV7=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGSEPELIO",gx.O.GXV7,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV7=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGSEPELIO",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[42]={id:42,fld:"",grid:0};n[43]={id:43,fld:"",grid:0};n[44]={id:44,fld:"",grid:0};n[45]={id:45,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGRODADO",fmt:0,gxz:"ZV25GXV8",gxold:"OV25GXV8",gxvar:"GXV8",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV8=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV25GXV8=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGRODADO",gx.O.GXV8,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV8=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGRODADO",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[46]={id:46,fld:"",grid:0};n[47]={id:47,fld:"",grid:0};n[48]={id:48,fld:"",grid:0};n[49]={id:49,fld:"",grid:0};n[50]={id:50,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGOBLIG",fmt:0,gxz:"ZV26GXV9",gxold:"OV26GXV9",gxvar:"GXV9",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV9=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV26GXV9=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGOBLIG",gx.O.GXV9,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV9=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGOBLIG",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[51]={id:51,fld:"",grid:0};n[52]={id:52,fld:"",grid:0};n[53]={id:53,fld:"",grid:0};n[54]={id:54,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGHIPOTECA",fmt:0,gxz:"ZV27GXV10",gxold:"OV27GXV10",gxvar:"GXV10",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV10=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV27GXV10=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGHIPOTECA",gx.O.GXV10,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV10=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGHIPOTECA",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[55]={id:55,fld:"",grid:0};n[56]={id:56,fld:"",grid:0};n[57]={id:57,fld:"",grid:0};n[58]={id:58,fld:"",grid:0};n[59]={id:59,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGSGR",fmt:0,gxz:"ZV28GXV11",gxold:"OV28GXV11",gxvar:"GXV11",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV11=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV28GXV11=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGSGR",gx.O.GXV11,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV11=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGSGR",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[60]={id:60,fld:"",grid:0};n[61]={id:61,fld:"",grid:0};n[62]={id:62,fld:"",grid:0};n[63]={id:63,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGDOMES",fmt:0,gxz:"ZV29GXV12",gxold:"OV29GXV12",gxvar:"GXV12",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV12=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV29GXV12=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGDOMES",gx.O.GXV12,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV12=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGDOMES",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[64]={id:64,fld:"",grid:0};n[65]={id:65,fld:"",grid:0};n[66]={id:66,fld:"",grid:0};n[67]={id:67,fld:"",grid:0};n[68]={id:68,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGALQUILER",fmt:0,gxz:"ZV30GXV13",gxold:"OV30GXV13",gxvar:"GXV13",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV13=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV30GXV13=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGALQUILER",gx.O.GXV13,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV13=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGALQUILER",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[69]={id:69,fld:"",grid:0};n[70]={id:70,fld:"",grid:0};n[71]={id:71,fld:"",grid:0};n[72]={id:72,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGVIATICOS",fmt:0,gxz:"ZV31GXV14",gxold:"OV31GXV14",gxvar:"GXV14",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV14=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV31GXV14=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGVIATICOS",gx.O.GXV14,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV14=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGVIATICOS",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[73]={id:73,fld:"",grid:0};n[74]={id:74,fld:"",grid:0};n[75]={id:75,fld:"",grid:0};n[76]={id:76,fld:"",grid:0};n[77]={id:77,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGINDU",fmt:0,gxz:"ZV32GXV15",gxold:"OV32GXV15",gxvar:"GXV15",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV15=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV32GXV15=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGINDU",gx.O.GXV15,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV15=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGINDU",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};n[78]={id:78,fld:"",grid:0};n[79]={id:79,fld:"",grid:0};n[80]={id:80,fld:"",grid:0};n[81]={id:81,lvl:0,type:"decimal",len:16,dec:2,sign:!0,pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99",ro:0,grid:0,gxgrid:null,fnc:null,isvalid:null,evt_cvc:null,evt_cvcing:null,rgrid:[],fld:"F1357_GANANCIANETAPARATOPES_F1357LDGOTRAS",fmt:0,gxz:"ZV33GXV16",gxold:"OV33GXV16",gxvar:"GXV16",ucs:[],op:[],ip:[],nacdep:[],ctrltype:"edit",v2v:function(n){n!==undefined&&(gx.O.GXV16=gx.fn.toDecimalValue(n,",","."))},v2z:function(n){n!==undefined&&(gx.O.ZV33GXV16=gx.fn.toDecimalValue(n,gx.thousandSeparator,gx.decimalPoint))},v2c:function(){gx.fn.setDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGOTRAS",gx.O.GXV16,2,gx.decimalPoint)},c2v:function(){this.val()!==undefined&&(gx.O.GXV16=this.val())},val:function(){return gx.fn.getDecimalValue("F1357_GANANCIANETAPARATOPES_F1357LDGOTRAS",gx.thousandSeparator,gx.decimalPoint)},nac:gx.falseFn};this.GXV1=0;this.ZV18GXV1=0;this.OV18GXV1=0;this.GXV2=0;this.ZV19GXV2=0;this.OV19GXV2=0;this.GXV3=0;this.ZV20GXV3=0;this.OV20GXV3=0;this.GXV4=0;this.ZV21GXV4=0;this.OV21GXV4=0;this.GXV5=0;this.ZV22GXV5=0;this.OV22GXV5=0;this.GXV6=0;this.ZV23GXV6=0;this.OV23GXV6=0;this.GXV7=0;this.ZV24GXV7=0;this.OV24GXV7=0;this.GXV8=0;this.ZV25GXV8=0;this.OV25GXV8=0;this.GXV9=0;this.ZV26GXV9=0;this.OV26GXV9=0;this.GXV10=0;this.ZV27GXV10=0;this.OV27GXV10=0;this.GXV11=0;this.ZV28GXV11=0;this.OV28GXV11=0;this.GXV12=0;this.ZV29GXV12=0;this.OV29GXV12=0;this.GXV13=0;this.ZV30GXV13=0;this.OV30GXV13=0;this.GXV14=0;this.ZV31GXV14=0;this.OV31GXV14=0;this.GXV15=0;this.ZV32GXV15=0;this.OV32GXV15=0;this.GXV16=0;this.ZV33GXV16=0;this.OV33GXV16=0;this.GXV1=0;this.GXV2=0;this.GXV3=0;this.GXV4=0;this.GXV5=0;this.GXV6=0;this.GXV7=0;this.GXV8=0;this.GXV9=0;this.GXV10=0;this.GXV11=0;this.GXV12=0;this.GXV13=0;this.GXV14=0;this.GXV15=0;this.GXV16=0;this.AV11CliCod=0;this.AV12EmpCod=0;this.AV15F1357CTipoPre=0;this.AV8F1357CPer="";this.AV13F1357CSec=0;this.AV14LegNumero=0;this.A6LegNumero=0;this.A778F1357CSec=0;this.A777F1357CPer="";this.A784F1357CTipoPre=0;this.A1EmpCod=0;this.A3CliCod=0;this.A863F1357LDGTipReg="";this.A825F1357LDGDescuentosLey="";this.A826F1357LDGOtrDescuLey="";this.A803F1357LDGSeguro=0;this.A804F1357LDGSeguMixto=0;this.A805F1357LDGRetPriv=0;this.A806F1357LDGCuotapartes=0;this.A807F1357LDGSepelio=0;this.A808F1357LDGRodado=0;this.A810F1357LDGOblig=0;this.A812F1357LDGHipoteca=0;this.A813F1357LDGSGR=0;this.A816F1357LDGDomes=0;this.A815F1357LDGAlquiler=0;this.A817F1357LDGViaticos=0;this.A818F1357LDGIndu=0;this.A819F1357LDGOtras=0;this.A797F1357LRTipReg="";this.A800F1357LRGravada=0;this.AV7F1357_GananciaNetaParaTopes={F1357LRGravada:0,DescuentosDeLey:0,F1357LDGSeguro:0,F1357LDGSeguMixto:0,F1357LDGRetPriv:0,F1357LDGCuotapartes:0,F1357LDGSepelio:0,F1357LDGRodado:0,F1357LDGOblig:0,F1357LDGHipoteca:0,F1357LDGSGR:0,F1357LDGDomes:0,F1357LDGAlquiler:0,F1357LDGViaticos:0,F1357LDGIndu:0,F1357LDGOtras:0};this.Events={e139r2_client:["ENTER",!0],e149r2_client:["CANCEL",!0]};this.EvtParms.REFRESH=[[{av:"GXV1",fld:"F1357_GANANCIANETAPARATOPES_F1357LRGRAVADA",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV2",fld:"F1357_GANANCIANETAPARATOPES_DESCUENTOSDELEY",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV3",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGSEGURO",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV4",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGSEGUMIXTO",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV5",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGRETPRIV",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV6",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGCUOTAPARTES",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV7",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGSEPELIO",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV8",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGRODADO",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV9",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGOBLIG",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV10",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGHIPOTECA",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV11",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGSGR",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV12",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGDOMES",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV13",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGALQUILER",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV14",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGVIATICOS",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV15",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGINDU",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"},{av:"GXV16",fld:"F1357_GANANCIANETAPARATOPES_F1357LDGOTRAS",pic:"Z,ZZZ,ZZZ,ZZZ,ZZ9.99"}],[]];this.EvtParms.ENTER=[[],[]];this.setVCMap("AV7F1357_GananciaNetaParaTopes","vF1357_GANANCIANETAPARATOPES",0,"F1357_GananciaNetaParaTopes",0,0);this.setVCMap("AV7F1357_GananciaNetaParaTopes","vF1357_GANANCIANETAPARATOPES",0,"F1357_GananciaNetaParaTopes",0,0);this.setVCMap("AV7F1357_GananciaNetaParaTopes","vF1357_GANANCIANETAPARATOPES",0,"F1357_GananciaNetaParaTopes",0,0);this.setVCMap("AV11CliCod","vCLICOD",0,"int",6,0);this.setVCMap("AV12EmpCod","vEMPCOD",0,"int",4,0);this.setVCMap("AV15F1357CTipoPre","vF1357CTIPOPRE",0,"int",1,0);this.setVCMap("AV8F1357CPer","vF1357CPER",0,"char",6,0);this.setVCMap("AV13F1357CSec","vF1357CSEC",0,"int",2,0);this.setVCMap("AV14LegNumero","vLEGNUMERO",0,"int",8,0);this.addBCProperty("F1357_ganancianetaparatopes",["F1357LRGravada"],this.GXValidFnc[14],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["DescuentosDeLey"],this.GXValidFnc[18],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGSeguro"],this.GXValidFnc[23],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGSeguMixto"],this.GXValidFnc[27],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGRetPriv"],this.GXValidFnc[32],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGCuotapartes"],this.GXValidFnc[36],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGSepelio"],this.GXValidFnc[41],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGRodado"],this.GXValidFnc[45],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGOblig"],this.GXValidFnc[50],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGHipoteca"],this.GXValidFnc[54],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGSGR"],this.GXValidFnc[59],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGDomes"],this.GXValidFnc[63],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGAlquiler"],this.GXValidFnc[68],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGViaticos"],this.GXValidFnc[72],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGIndu"],this.GXValidFnc[77],"AV7F1357_GananciaNetaParaTopes");this.addBCProperty("F1357_ganancianetaparatopes",["F1357LDGOtras"],this.GXValidFnc[81],"AV7F1357_GananciaNetaParaTopes");this.Initialize()});gx.wi(function(){gx.createParentObj(this.f1357_mostrargnparatopes)})