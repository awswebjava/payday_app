package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class liquidacion_bc extends GXWebPanel implements IGxSilentTrn
{
   public liquidacion_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public liquidacion_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liquidacion_bc.class ));
   }

   public liquidacion_bc( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0R25( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0R25( ) ;
      standaloneModal( ) ;
      addRow0R25( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e110R2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z31LiqNro = A31LiqNro ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_0R0( )
   {
      beforeValidate0R25( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0R25( ) ;
         }
         else
         {
            checkExtendedTable0R25( ) ;
            if ( AnyError == 0 )
            {
               zm0R25( 17) ;
               zm0R25( 18) ;
               zm0R25( 19) ;
               zm0R25( 20) ;
               zm0R25( 21) ;
            }
            closeExtendedTableCursors0R25( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120R2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV24IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV24IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion_Insert", GXv_boolean3) ;
         liquidacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV24IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV24IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion_Update", GXv_boolean3) ;
         liquidacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV24IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV24IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLiquidacion_Delete", GXv_boolean3) ;
         liquidacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV24IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV24IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV29Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV10TrnContext.fromxml(AV11WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV10TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV29Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV30GXV1 = 1 ;
         while ( AV30GXV1 <= AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV13TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV10TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV30GXV1));
            if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "TLiqCod") == 0 )
            {
               AV12Insert_TLiqCod = AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LiqDepBanCod") == 0 )
            {
               AV26Insert_LiqDepBanCod = AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "PeriodoLiq") == 0 )
            {
               AV27Insert_PeriodoLiq = localUtil.ctod( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            }
            else if ( GXutil.strcmp(AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LiqRelNro") == 0 )
            {
               AV28Insert_LiqRelNro = (int)(GXutil.lval( AV13TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            AV30GXV1 = (int)(AV30GXV1+1) ;
         }
      }
   }

   public void e110R2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0R25( int GX_JID )
   {
      if ( ( GX_JID == 16 ) || ( GX_JID == 0 ) )
      {
         Z271LiqDescrip = A271LiqDescrip ;
         Z98LiqFecha = A98LiqFecha ;
         Z585LiqPerAno = A585LiqPerAno ;
         Z586LiqPerMes = A586LiqPerMes ;
         Z283LiqPeriodo = A283LiqPeriodo ;
         Z280LiqFecPago = A280LiqFecPago ;
         Z2368TLiqDescAux = A2368TLiqDescAux ;
         Z278LiqEstado = A278LiqEstado ;
         Z2292LiqLSDDepEst = A2292LiqLSDDepEst ;
         Z1403LiqAuxEstado = A1403LiqAuxEstado ;
         Z2293LiqContrEst = A2293LiqContrEst ;
         Z268LiqClase = A268LiqClase ;
         Z2180LiqPDFEstado = A2180LiqPDFEstado ;
         Z361LiqGenInter = A361LiqGenInter ;
         Z494LiqContabilizada = A494LiqContabilizada ;
         Z495LiqCntLeg = A495LiqCntLeg ;
         Z496LiqImpNeto = A496LiqImpNeto ;
         Z755LiqImpDescuentos = A755LiqImpDescuentos ;
         Z756LiqImpRetenGan = A756LiqImpRetenGan ;
         Z497LiqImpBruto = A497LiqImpBruto ;
         Z500LegEspecificos = A500LegEspecificos ;
         Z511LiqFecCre = A511LiqFecCre ;
         Z512LiqUsuCre = A512LiqUsuCre ;
         Z513LiqPerSinDia = A513LiqPerSinDia ;
         Z748LiqPerPalabra = A748LiqPerPalabra ;
         Z580LiqDepPrvPer = A580LiqDepPrvPer ;
         Z581LiqDepPrvFec = A581LiqDepPrvFec ;
         Z583LiqDepPerAno = A583LiqDepPerAno ;
         Z584LiqDepPerMes = A584LiqDepPerMes ;
         Z587LiqFecMod = A587LiqFecMod ;
         Z588LiqUsuMod = A588LiqUsuMod ;
         Z719LiqFecImp = A719LiqFecImp ;
         Z743LiqPisoGanancias = A743LiqPisoGanancias ;
         Z744LiqPisGanSAC = A744LiqPisGanSAC ;
         Z745LiqTopeDedInc = A745LiqTopeDedInc ;
         Z746LiqPerUltNorm = A746LiqPerUltNorm ;
         Z766LiqError = A766LiqError ;
         Z1404LiqErrorAux = A1404LiqErrorAux ;
         Z874LiqNombre = A874LiqNombre ;
         Z881LiqLegajosTxt = A881LiqLegajosTxt ;
         Z885LiqSegundos = A885LiqSegundos ;
         Z963LiqRutaPDFTodosVertical = A963LiqRutaPDFTodosVertical ;
         Z964LiqRutaPDFTodosHorizontal = A964LiqRutaPDFTodosHorizontal ;
         Z965LiqRutaPDFTodosNombreVertical = A965LiqRutaPDFTodosNombreVertical ;
         Z966LiqRutaPDFTodosNombreHorizonta = A966LiqRutaPDFTodosNombreHorizonta ;
         Z2195LiqSac = A2195LiqSac ;
         Z2196LiqSacLog = A2196LiqSacLog ;
         Z2298LiqCancel = A2298LiqCancel ;
         Z2409LiqModTra = A2409LiqModTra ;
         Z2414LiqFrecPag = A2414LiqFrecPag ;
         Z2410LiqPerDes = A2410LiqPerDes ;
         Z2411LiqPerHas = A2411LiqPerHas ;
         Z2426LiqTipoTarifa = A2426LiqTipoTarifa ;
         Z33LiqDepBanCod = A33LiqDepBanCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z1729PeriodoLiq = A1729PeriodoLiq ;
         Z2112LiqRelNro = A2112LiqRelNro ;
      }
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         Z582LiqDepBanDescrip = A582LiqDepBanDescrip ;
      }
      if ( ( GX_JID == 18 ) || ( GX_JID == 0 ) )
      {
         Z2EmpNom = A2EmpNom ;
      }
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         Z340TliqDesc = A340TliqDesc ;
      }
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -16 )
      {
         Z31LiqNro = A31LiqNro ;
         Z271LiqDescrip = A271LiqDescrip ;
         Z98LiqFecha = A98LiqFecha ;
         Z585LiqPerAno = A585LiqPerAno ;
         Z586LiqPerMes = A586LiqPerMes ;
         Z283LiqPeriodo = A283LiqPeriodo ;
         Z280LiqFecPago = A280LiqFecPago ;
         Z2368TLiqDescAux = A2368TLiqDescAux ;
         Z278LiqEstado = A278LiqEstado ;
         Z2292LiqLSDDepEst = A2292LiqLSDDepEst ;
         Z1403LiqAuxEstado = A1403LiqAuxEstado ;
         Z2293LiqContrEst = A2293LiqContrEst ;
         Z268LiqClase = A268LiqClase ;
         Z2180LiqPDFEstado = A2180LiqPDFEstado ;
         Z361LiqGenInter = A361LiqGenInter ;
         Z494LiqContabilizada = A494LiqContabilizada ;
         Z495LiqCntLeg = A495LiqCntLeg ;
         Z496LiqImpNeto = A496LiqImpNeto ;
         Z755LiqImpDescuentos = A755LiqImpDescuentos ;
         Z756LiqImpRetenGan = A756LiqImpRetenGan ;
         Z497LiqImpBruto = A497LiqImpBruto ;
         Z500LegEspecificos = A500LegEspecificos ;
         Z511LiqFecCre = A511LiqFecCre ;
         Z512LiqUsuCre = A512LiqUsuCre ;
         Z513LiqPerSinDia = A513LiqPerSinDia ;
         Z748LiqPerPalabra = A748LiqPerPalabra ;
         Z580LiqDepPrvPer = A580LiqDepPrvPer ;
         Z581LiqDepPrvFec = A581LiqDepPrvFec ;
         Z583LiqDepPerAno = A583LiqDepPerAno ;
         Z584LiqDepPerMes = A584LiqDepPerMes ;
         Z587LiqFecMod = A587LiqFecMod ;
         Z588LiqUsuMod = A588LiqUsuMod ;
         Z719LiqFecImp = A719LiqFecImp ;
         Z743LiqPisoGanancias = A743LiqPisoGanancias ;
         Z744LiqPisGanSAC = A744LiqPisGanSAC ;
         Z745LiqTopeDedInc = A745LiqTopeDedInc ;
         Z746LiqPerUltNorm = A746LiqPerUltNorm ;
         Z766LiqError = A766LiqError ;
         Z1404LiqErrorAux = A1404LiqErrorAux ;
         Z874LiqNombre = A874LiqNombre ;
         Z881LiqLegajosTxt = A881LiqLegajosTxt ;
         Z885LiqSegundos = A885LiqSegundos ;
         Z963LiqRutaPDFTodosVertical = A963LiqRutaPDFTodosVertical ;
         Z964LiqRutaPDFTodosHorizontal = A964LiqRutaPDFTodosHorizontal ;
         Z965LiqRutaPDFTodosNombreVertical = A965LiqRutaPDFTodosNombreVertical ;
         Z966LiqRutaPDFTodosNombreHorizonta = A966LiqRutaPDFTodosNombreHorizonta ;
         Z1142LiqLog = A1142LiqLog ;
         Z2195LiqSac = A2195LiqSac ;
         Z2196LiqSacLog = A2196LiqSacLog ;
         Z2298LiqCancel = A2298LiqCancel ;
         Z2409LiqModTra = A2409LiqModTra ;
         Z2414LiqFrecPag = A2414LiqFrecPag ;
         Z2410LiqPerDes = A2410LiqPerDes ;
         Z2411LiqPerHas = A2411LiqPerHas ;
         Z2426LiqTipoTarifa = A2426LiqTipoTarifa ;
         Z3CliCod = A3CliCod ;
         Z33LiqDepBanCod = A33LiqDepBanCod ;
         Z1EmpCod = A1EmpCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z1729PeriodoLiq = A1729PeriodoLiq ;
         Z2112LiqRelNro = A2112LiqRelNro ;
         Z2EmpNom = A2EmpNom ;
         Z340TliqDesc = A340TliqDesc ;
         Z582LiqDepBanDescrip = A582LiqDepBanDescrip ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         liquidacion_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load0R25( )
   {
      /* Using cursor BC000R9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A2EmpNom = BC000R9_A2EmpNom[0] ;
         A271LiqDescrip = BC000R9_A271LiqDescrip[0] ;
         A98LiqFecha = BC000R9_A98LiqFecha[0] ;
         A585LiqPerAno = BC000R9_A585LiqPerAno[0] ;
         A586LiqPerMes = BC000R9_A586LiqPerMes[0] ;
         A283LiqPeriodo = BC000R9_A283LiqPeriodo[0] ;
         A280LiqFecPago = BC000R9_A280LiqFecPago[0] ;
         A340TliqDesc = BC000R9_A340TliqDesc[0] ;
         A2368TLiqDescAux = BC000R9_A2368TLiqDescAux[0] ;
         A278LiqEstado = BC000R9_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = BC000R9_A2292LiqLSDDepEst[0] ;
         A1403LiqAuxEstado = BC000R9_A1403LiqAuxEstado[0] ;
         A2293LiqContrEst = BC000R9_A2293LiqContrEst[0] ;
         A268LiqClase = BC000R9_A268LiqClase[0] ;
         n268LiqClase = BC000R9_n268LiqClase[0] ;
         A2180LiqPDFEstado = BC000R9_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = BC000R9_n2180LiqPDFEstado[0] ;
         A361LiqGenInter = BC000R9_A361LiqGenInter[0] ;
         A494LiqContabilizada = BC000R9_A494LiqContabilizada[0] ;
         A495LiqCntLeg = BC000R9_A495LiqCntLeg[0] ;
         A496LiqImpNeto = BC000R9_A496LiqImpNeto[0] ;
         A755LiqImpDescuentos = BC000R9_A755LiqImpDescuentos[0] ;
         A756LiqImpRetenGan = BC000R9_A756LiqImpRetenGan[0] ;
         A497LiqImpBruto = BC000R9_A497LiqImpBruto[0] ;
         A500LegEspecificos = BC000R9_A500LegEspecificos[0] ;
         A511LiqFecCre = BC000R9_A511LiqFecCre[0] ;
         A512LiqUsuCre = BC000R9_A512LiqUsuCre[0] ;
         A513LiqPerSinDia = BC000R9_A513LiqPerSinDia[0] ;
         A748LiqPerPalabra = BC000R9_A748LiqPerPalabra[0] ;
         A580LiqDepPrvPer = BC000R9_A580LiqDepPrvPer[0] ;
         A581LiqDepPrvFec = BC000R9_A581LiqDepPrvFec[0] ;
         A582LiqDepBanDescrip = BC000R9_A582LiqDepBanDescrip[0] ;
         A583LiqDepPerAno = BC000R9_A583LiqDepPerAno[0] ;
         A584LiqDepPerMes = BC000R9_A584LiqDepPerMes[0] ;
         A587LiqFecMod = BC000R9_A587LiqFecMod[0] ;
         A588LiqUsuMod = BC000R9_A588LiqUsuMod[0] ;
         A719LiqFecImp = BC000R9_A719LiqFecImp[0] ;
         A743LiqPisoGanancias = BC000R9_A743LiqPisoGanancias[0] ;
         A744LiqPisGanSAC = BC000R9_A744LiqPisGanSAC[0] ;
         A745LiqTopeDedInc = BC000R9_A745LiqTopeDedInc[0] ;
         A746LiqPerUltNorm = BC000R9_A746LiqPerUltNorm[0] ;
         A766LiqError = BC000R9_A766LiqError[0] ;
         A1404LiqErrorAux = BC000R9_A1404LiqErrorAux[0] ;
         A874LiqNombre = BC000R9_A874LiqNombre[0] ;
         A881LiqLegajosTxt = BC000R9_A881LiqLegajosTxt[0] ;
         A885LiqSegundos = BC000R9_A885LiqSegundos[0] ;
         A963LiqRutaPDFTodosVertical = BC000R9_A963LiqRutaPDFTodosVertical[0] ;
         A964LiqRutaPDFTodosHorizontal = BC000R9_A964LiqRutaPDFTodosHorizontal[0] ;
         A965LiqRutaPDFTodosNombreVertical = BC000R9_A965LiqRutaPDFTodosNombreVertical[0] ;
         A966LiqRutaPDFTodosNombreHorizonta = BC000R9_A966LiqRutaPDFTodosNombreHorizonta[0] ;
         A1142LiqLog = BC000R9_A1142LiqLog[0] ;
         A2195LiqSac = BC000R9_A2195LiqSac[0] ;
         n2195LiqSac = BC000R9_n2195LiqSac[0] ;
         A2196LiqSacLog = BC000R9_A2196LiqSacLog[0] ;
         n2196LiqSacLog = BC000R9_n2196LiqSacLog[0] ;
         A2298LiqCancel = BC000R9_A2298LiqCancel[0] ;
         A2409LiqModTra = BC000R9_A2409LiqModTra[0] ;
         A2414LiqFrecPag = BC000R9_A2414LiqFrecPag[0] ;
         A2410LiqPerDes = BC000R9_A2410LiqPerDes[0] ;
         A2411LiqPerHas = BC000R9_A2411LiqPerHas[0] ;
         A2426LiqTipoTarifa = BC000R9_A2426LiqTipoTarifa[0] ;
         A33LiqDepBanCod = BC000R9_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = BC000R9_n33LiqDepBanCod[0] ;
         A32TLiqCod = BC000R9_A32TLiqCod[0] ;
         n32TLiqCod = BC000R9_n32TLiqCod[0] ;
         A1729PeriodoLiq = BC000R9_A1729PeriodoLiq[0] ;
         A2112LiqRelNro = BC000R9_A2112LiqRelNro[0] ;
         n2112LiqRelNro = BC000R9_n2112LiqRelNro[0] ;
         zm0R25( -16) ;
      }
      pr_default.close(7);
      onLoadActions0R25( ) ;
   }

   public void onLoadActions0R25( )
   {
      AV29Pgmname = "Liquidacion_BC" ;
   }

   public void checkExtendedTable0R25( )
   {
      nIsDirty_25 = (short)(0) ;
      standaloneModal( ) ;
      AV29Pgmname = "Liquidacion_BC" ;
      /* Using cursor BC000R10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A33LiqDepBanCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Banco Previsional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQDEPBANCOD");
            AnyError = (short)(1) ;
         }
      }
      A582LiqDepBanDescrip = BC000R10_A582LiqDepBanDescrip[0] ;
      pr_default.close(8);
      /* Using cursor BC000R11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(9) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (GXutil.strcmp("", A32TLiqCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Tipo Liquidacion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "TLIQCOD");
            AnyError = (short)(1) ;
         }
      }
      A340TliqDesc = BC000R11_A340TliqDesc[0] ;
      pr_default.close(9);
      /* Using cursor BC000R12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(10) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      A2EmpNom = BC000R12_A2EmpNom[0] ;
      pr_default.close(10);
      /* Using cursor BC000R13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Periodo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PERIODOLIQ");
         AnyError = (short)(1) ;
      }
      pr_default.close(11);
      /* Using cursor BC000R14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Boolean.valueOf(n2112LiqRelNro), Integer.valueOf(A2112LiqRelNro)});
      if ( (pr_default.getStatus(12) == 101) )
      {
         if ( ! ( (0==A3CliCod) || (0==A1EmpCod) || (0==A2112LiqRelNro) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Liquidacion Relacionada", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LIQRELNRO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(12);
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A98LiqFecha)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "de Liquidacion", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A586LiqPerMes == 1 ) || ( A586LiqPerMes == 2 ) || ( A586LiqPerMes == 3 ) || ( A586LiqPerMes == 4 ) || ( A586LiqPerMes == 5 ) || ( A586LiqPerMes == 6 ) || ( A586LiqPerMes == 7 ) || ( A586LiqPerMes == 8 ) || ( A586LiqPerMes == 9 ) || ( A586LiqPerMes == 10 ) || ( A586LiqPerMes == 11 ) || ( A586LiqPerMes == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Liq Per Mes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A278LiqEstado == 0 ) || ( A278LiqEstado == 1 ) || ( A278LiqEstado == 2 ) || ( A278LiqEstado == 3 ) || ( A278LiqEstado == 4 ) || ( A278LiqEstado == 5 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Estado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A2292LiqLSDDepEst == 0 ) || ( A2292LiqLSDDepEst == 1 ) || ( A2292LiqLSDDepEst == 2 ) || ( A2292LiqLSDDepEst == 3 ) || ( A2292LiqLSDDepEst == 4 ) || ( A2292LiqLSDDepEst == 5 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Conceptos dependencias de LSD", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1403LiqAuxEstado == 0 ) || ( A1403LiqAuxEstado == 1 ) || ( A1403LiqAuxEstado == 2 ) || ( A1403LiqAuxEstado == 3 ) || ( A1403LiqAuxEstado == 4 ) || ( A1403LiqAuxEstado == 5 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Conceptos aux. para liq. futuras", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A2293LiqContrEst == 0 ) || ( A2293LiqContrEst == 1 ) || ( A2293LiqContrEst == 2 ) || ( A2293LiqContrEst == 3 ) || ( A2293LiqContrEst == 4 ) || ( A2293LiqContrEst == 5 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A268LiqClase == 0 ) || ( A268LiqClase == 1 ) || (0==A268LiqClase) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A2180LiqPDFEstado, "Completo") == 0 ) || ( GXutil.strcmp(A2180LiqPDFEstado, "Enviado") == 0 ) || ( GXutil.strcmp(A2180LiqPDFEstado, "Pendiente") == 0 ) || ( GXutil.strcmp(A2180LiqPDFEstado, "Error") == 0 ) || ( GXutil.strcmp(A2180LiqPDFEstado, "Manual") == 0 ) || ( GXutil.strcmp(A2180LiqPDFEstado, "EnEspera") == 0 ) || (GXutil.strcmp("", A2180LiqPDFEstado)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Estado del PDF", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A584LiqDepPerMes == 1 ) || ( A584LiqDepPerMes == 2 ) || ( A584LiqDepPerMes == 3 ) || ( A584LiqDepPerMes == 4 ) || ( A584LiqDepPerMes == 5 ) || ( A584LiqDepPerMes == 6 ) || ( A584LiqDepPerMes == 7 ) || ( A584LiqDepPerMes == 8 ) || ( A584LiqDepPerMes == 9 ) || ( A584LiqDepPerMes == 10 ) || ( A584LiqDepPerMes == 11 ) || ( A584LiqDepPerMes == 12 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Liq Dep Per Mes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A2409LiqModTra, "E") == 0 ) || ( GXutil.strcmp(A2409LiqModTra, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Relación laboral", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A2414LiqFrecPag == 1 ) || ( A2414LiqFrecPag == 2 ) || ( A2414LiqFrecPag == 3 ) || ( A2414LiqFrecPag == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Frecuencia de pago", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A2426LiqTipoTarifa, "H") == 0 ) || ( GXutil.strcmp(A2426LiqTipoTarifa, "P") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de tarifa", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0R25( )
   {
      pr_default.close(8);
      pr_default.close(9);
      pr_default.close(10);
      pr_default.close(11);
      pr_default.close(12);
   }

   public void enableDisable( )
   {
   }

   public void getKey0R25( )
   {
      /* Using cursor BC000R15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound25 = (short)(1) ;
      }
      else
      {
         RcdFound25 = (short)(0) ;
      }
      pr_default.close(13);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000R16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         zm0R25( 16) ;
         RcdFound25 = (short)(1) ;
         A31LiqNro = BC000R16_A31LiqNro[0] ;
         A271LiqDescrip = BC000R16_A271LiqDescrip[0] ;
         A98LiqFecha = BC000R16_A98LiqFecha[0] ;
         A585LiqPerAno = BC000R16_A585LiqPerAno[0] ;
         A586LiqPerMes = BC000R16_A586LiqPerMes[0] ;
         A283LiqPeriodo = BC000R16_A283LiqPeriodo[0] ;
         A280LiqFecPago = BC000R16_A280LiqFecPago[0] ;
         A2368TLiqDescAux = BC000R16_A2368TLiqDescAux[0] ;
         A278LiqEstado = BC000R16_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = BC000R16_A2292LiqLSDDepEst[0] ;
         A1403LiqAuxEstado = BC000R16_A1403LiqAuxEstado[0] ;
         A2293LiqContrEst = BC000R16_A2293LiqContrEst[0] ;
         A268LiqClase = BC000R16_A268LiqClase[0] ;
         n268LiqClase = BC000R16_n268LiqClase[0] ;
         A2180LiqPDFEstado = BC000R16_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = BC000R16_n2180LiqPDFEstado[0] ;
         A361LiqGenInter = BC000R16_A361LiqGenInter[0] ;
         A494LiqContabilizada = BC000R16_A494LiqContabilizada[0] ;
         A495LiqCntLeg = BC000R16_A495LiqCntLeg[0] ;
         A496LiqImpNeto = BC000R16_A496LiqImpNeto[0] ;
         A755LiqImpDescuentos = BC000R16_A755LiqImpDescuentos[0] ;
         A756LiqImpRetenGan = BC000R16_A756LiqImpRetenGan[0] ;
         A497LiqImpBruto = BC000R16_A497LiqImpBruto[0] ;
         A500LegEspecificos = BC000R16_A500LegEspecificos[0] ;
         A511LiqFecCre = BC000R16_A511LiqFecCre[0] ;
         A512LiqUsuCre = BC000R16_A512LiqUsuCre[0] ;
         A513LiqPerSinDia = BC000R16_A513LiqPerSinDia[0] ;
         A748LiqPerPalabra = BC000R16_A748LiqPerPalabra[0] ;
         A580LiqDepPrvPer = BC000R16_A580LiqDepPrvPer[0] ;
         A581LiqDepPrvFec = BC000R16_A581LiqDepPrvFec[0] ;
         A583LiqDepPerAno = BC000R16_A583LiqDepPerAno[0] ;
         A584LiqDepPerMes = BC000R16_A584LiqDepPerMes[0] ;
         A587LiqFecMod = BC000R16_A587LiqFecMod[0] ;
         A588LiqUsuMod = BC000R16_A588LiqUsuMod[0] ;
         A719LiqFecImp = BC000R16_A719LiqFecImp[0] ;
         A743LiqPisoGanancias = BC000R16_A743LiqPisoGanancias[0] ;
         A744LiqPisGanSAC = BC000R16_A744LiqPisGanSAC[0] ;
         A745LiqTopeDedInc = BC000R16_A745LiqTopeDedInc[0] ;
         A746LiqPerUltNorm = BC000R16_A746LiqPerUltNorm[0] ;
         A766LiqError = BC000R16_A766LiqError[0] ;
         A1404LiqErrorAux = BC000R16_A1404LiqErrorAux[0] ;
         A874LiqNombre = BC000R16_A874LiqNombre[0] ;
         A881LiqLegajosTxt = BC000R16_A881LiqLegajosTxt[0] ;
         A885LiqSegundos = BC000R16_A885LiqSegundos[0] ;
         A963LiqRutaPDFTodosVertical = BC000R16_A963LiqRutaPDFTodosVertical[0] ;
         A964LiqRutaPDFTodosHorizontal = BC000R16_A964LiqRutaPDFTodosHorizontal[0] ;
         A965LiqRutaPDFTodosNombreVertical = BC000R16_A965LiqRutaPDFTodosNombreVertical[0] ;
         A966LiqRutaPDFTodosNombreHorizonta = BC000R16_A966LiqRutaPDFTodosNombreHorizonta[0] ;
         A1142LiqLog = BC000R16_A1142LiqLog[0] ;
         A2195LiqSac = BC000R16_A2195LiqSac[0] ;
         n2195LiqSac = BC000R16_n2195LiqSac[0] ;
         A2196LiqSacLog = BC000R16_A2196LiqSacLog[0] ;
         n2196LiqSacLog = BC000R16_n2196LiqSacLog[0] ;
         A2298LiqCancel = BC000R16_A2298LiqCancel[0] ;
         A2409LiqModTra = BC000R16_A2409LiqModTra[0] ;
         A2414LiqFrecPag = BC000R16_A2414LiqFrecPag[0] ;
         A2410LiqPerDes = BC000R16_A2410LiqPerDes[0] ;
         A2411LiqPerHas = BC000R16_A2411LiqPerHas[0] ;
         A2426LiqTipoTarifa = BC000R16_A2426LiqTipoTarifa[0] ;
         A3CliCod = BC000R16_A3CliCod[0] ;
         A33LiqDepBanCod = BC000R16_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = BC000R16_n33LiqDepBanCod[0] ;
         A1EmpCod = BC000R16_A1EmpCod[0] ;
         A32TLiqCod = BC000R16_A32TLiqCod[0] ;
         n32TLiqCod = BC000R16_n32TLiqCod[0] ;
         A1729PeriodoLiq = BC000R16_A1729PeriodoLiq[0] ;
         A2112LiqRelNro = BC000R16_A2112LiqRelNro[0] ;
         n2112LiqRelNro = BC000R16_n2112LiqRelNro[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0R25( ) ;
         if ( AnyError == 1 )
         {
            RcdFound25 = (short)(0) ;
            initializeNonKey0R25( ) ;
         }
         Gx_mode = sMode25 ;
      }
      else
      {
         RcdFound25 = (short)(0) ;
         initializeNonKey0R25( ) ;
         sMode25 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode25 ;
      }
      pr_default.close(14);
   }

   public void getEqualNoModal( )
   {
      getKey0R25( ) ;
      if ( RcdFound25 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_0R0( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency0R25( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000R17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(15) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Liquidacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(15) == 101) || ( GXutil.strcmp(Z271LiqDescrip, BC000R17_A271LiqDescrip[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z98LiqFecha), GXutil.resetTime(BC000R17_A98LiqFecha[0])) ) || ( Z585LiqPerAno != BC000R17_A585LiqPerAno[0] ) || ( Z586LiqPerMes != BC000R17_A586LiqPerMes[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z283LiqPeriodo), GXutil.resetTime(BC000R17_A283LiqPeriodo[0])) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z280LiqFecPago), GXutil.resetTime(BC000R17_A280LiqFecPago[0])) ) || ( GXutil.strcmp(Z2368TLiqDescAux, BC000R17_A2368TLiqDescAux[0]) != 0 ) || ( Z278LiqEstado != BC000R17_A278LiqEstado[0] ) || ( Z2292LiqLSDDepEst != BC000R17_A2292LiqLSDDepEst[0] ) || ( Z1403LiqAuxEstado != BC000R17_A1403LiqAuxEstado[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2293LiqContrEst != BC000R17_A2293LiqContrEst[0] ) || ( Z268LiqClase != BC000R17_A268LiqClase[0] ) || ( GXutil.strcmp(Z2180LiqPDFEstado, BC000R17_A2180LiqPDFEstado[0]) != 0 ) || ( Z361LiqGenInter != BC000R17_A361LiqGenInter[0] ) || ( Z494LiqContabilizada != BC000R17_A494LiqContabilizada[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z495LiqCntLeg != BC000R17_A495LiqCntLeg[0] ) || ( DecimalUtil.compareTo(Z496LiqImpNeto, BC000R17_A496LiqImpNeto[0]) != 0 ) || ( DecimalUtil.compareTo(Z755LiqImpDescuentos, BC000R17_A755LiqImpDescuentos[0]) != 0 ) || ( DecimalUtil.compareTo(Z756LiqImpRetenGan, BC000R17_A756LiqImpRetenGan[0]) != 0 ) || ( DecimalUtil.compareTo(Z497LiqImpBruto, BC000R17_A497LiqImpBruto[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z500LegEspecificos != BC000R17_A500LegEspecificos[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z511LiqFecCre), GXutil.resetTime(BC000R17_A511LiqFecCre[0])) ) || ( GXutil.strcmp(Z512LiqUsuCre, BC000R17_A512LiqUsuCre[0]) != 0 ) || ( GXutil.strcmp(Z513LiqPerSinDia, BC000R17_A513LiqPerSinDia[0]) != 0 ) || ( GXutil.strcmp(Z748LiqPerPalabra, BC000R17_A748LiqPerPalabra[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z580LiqDepPrvPer, BC000R17_A580LiqDepPrvPer[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z581LiqDepPrvFec), GXutil.resetTime(BC000R17_A581LiqDepPrvFec[0])) ) || ( Z583LiqDepPerAno != BC000R17_A583LiqDepPerAno[0] ) || ( Z584LiqDepPerMes != BC000R17_A584LiqDepPerMes[0] ) || !( GXutil.dateCompare(Z587LiqFecMod, BC000R17_A587LiqFecMod[0]) ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z588LiqUsuMod, BC000R17_A588LiqUsuMod[0]) != 0 ) || !( GXutil.dateCompare(Z719LiqFecImp, BC000R17_A719LiqFecImp[0]) ) || ( DecimalUtil.compareTo(Z743LiqPisoGanancias, BC000R17_A743LiqPisoGanancias[0]) != 0 ) || ( DecimalUtil.compareTo(Z744LiqPisGanSAC, BC000R17_A744LiqPisGanSAC[0]) != 0 ) || ( DecimalUtil.compareTo(Z745LiqTopeDedInc, BC000R17_A745LiqTopeDedInc[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z746LiqPerUltNorm), GXutil.resetTime(BC000R17_A746LiqPerUltNorm[0])) ) || ( GXutil.strcmp(Z766LiqError, BC000R17_A766LiqError[0]) != 0 ) || ( GXutil.strcmp(Z1404LiqErrorAux, BC000R17_A1404LiqErrorAux[0]) != 0 ) || ( GXutil.strcmp(Z874LiqNombre, BC000R17_A874LiqNombre[0]) != 0 ) || ( GXutil.strcmp(Z881LiqLegajosTxt, BC000R17_A881LiqLegajosTxt[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z885LiqSegundos, BC000R17_A885LiqSegundos[0]) != 0 ) || ( GXutil.strcmp(Z963LiqRutaPDFTodosVertical, BC000R17_A963LiqRutaPDFTodosVertical[0]) != 0 ) || ( GXutil.strcmp(Z964LiqRutaPDFTodosHorizontal, BC000R17_A964LiqRutaPDFTodosHorizontal[0]) != 0 ) || ( GXutil.strcmp(Z965LiqRutaPDFTodosNombreVertical, BC000R17_A965LiqRutaPDFTodosNombreVertical[0]) != 0 ) || ( GXutil.strcmp(Z966LiqRutaPDFTodosNombreHorizonta, BC000R17_A966LiqRutaPDFTodosNombreHorizonta[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z2195LiqSac != BC000R17_A2195LiqSac[0] ) || ( GXutil.strcmp(Z2196LiqSacLog, BC000R17_A2196LiqSacLog[0]) != 0 ) || ( Z2298LiqCancel != BC000R17_A2298LiqCancel[0] ) || ( GXutil.strcmp(Z2409LiqModTra, BC000R17_A2409LiqModTra[0]) != 0 ) || ( Z2414LiqFrecPag != BC000R17_A2414LiqFrecPag[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z2410LiqPerDes), GXutil.resetTime(BC000R17_A2410LiqPerDes[0])) ) || !( GXutil.dateCompare(GXutil.resetTime(Z2411LiqPerHas), GXutil.resetTime(BC000R17_A2411LiqPerHas[0])) ) || ( GXutil.strcmp(Z2426LiqTipoTarifa, BC000R17_A2426LiqTipoTarifa[0]) != 0 ) || ( GXutil.strcmp(Z33LiqDepBanCod, BC000R17_A33LiqDepBanCod[0]) != 0 ) || ( GXutil.strcmp(Z32TLiqCod, BC000R17_A32TLiqCod[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z1729PeriodoLiq), GXutil.resetTime(BC000R17_A1729PeriodoLiq[0])) ) || ( Z2112LiqRelNro != BC000R17_A2112LiqRelNro[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Liquidacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0R25( )
   {
      beforeValidate0R25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R25( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0R25( 0) ;
         checkOptimisticConcurrency0R25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R25( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0R25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000R18 */
                  pr_default.execute(16, new Object[] {Integer.valueOf(A31LiqNro), A271LiqDescrip, A98LiqFecha, Short.valueOf(A585LiqPerAno), Byte.valueOf(A586LiqPerMes), A283LiqPeriodo, A280LiqFecPago, A2368TLiqDescAux, Byte.valueOf(A278LiqEstado), Byte.valueOf(A2292LiqLSDDepEst), Byte.valueOf(A1403LiqAuxEstado), Byte.valueOf(A2293LiqContrEst), Boolean.valueOf(n268LiqClase), Byte.valueOf(A268LiqClase), Boolean.valueOf(n2180LiqPDFEstado), A2180LiqPDFEstado, Boolean.valueOf(A361LiqGenInter), Boolean.valueOf(A494LiqContabilizada), Short.valueOf(A495LiqCntLeg), A496LiqImpNeto, A755LiqImpDescuentos, A756LiqImpRetenGan, A497LiqImpBruto, Boolean.valueOf(A500LegEspecificos), A511LiqFecCre, A512LiqUsuCre, A513LiqPerSinDia, A748LiqPerPalabra, A580LiqDepPrvPer, A581LiqDepPrvFec, Short.valueOf(A583LiqDepPerAno), Byte.valueOf(A584LiqDepPerMes), A587LiqFecMod, A588LiqUsuMod, A719LiqFecImp, A743LiqPisoGanancias, A744LiqPisGanSAC, A745LiqTopeDedInc, A746LiqPerUltNorm, A766LiqError, A1404LiqErrorAux, A874LiqNombre, A881LiqLegajosTxt, A885LiqSegundos, A963LiqRutaPDFTodosVertical, A964LiqRutaPDFTodosHorizontal, A965LiqRutaPDFTodosNombreVertical, A966LiqRutaPDFTodosNombreHorizonta, A1142LiqLog, Boolean.valueOf(n2195LiqSac), Boolean.valueOf(A2195LiqSac), Boolean.valueOf(n2196LiqSacLog), A2196LiqSacLog, Boolean.valueOf(A2298LiqCancel), A2409LiqModTra, Byte.valueOf(A2414LiqFrecPag), A2410LiqPerDes, A2411LiqPerHas, A2426LiqTipoTarifa, Integer.valueOf(A3CliCod), Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod, Short.valueOf(A1EmpCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A1729PeriodoLiq, Boolean.valueOf(n2112LiqRelNro), Integer.valueOf(A2112LiqRelNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
                  if ( (pr_default.getStatus(16) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0R25( ) ;
         }
         endLevel0R25( ) ;
      }
      closeExtendedTableCursors0R25( ) ;
   }

   public void update0R25( )
   {
      beforeValidate0R25( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0R25( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R25( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0R25( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0R25( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000R19 */
                  pr_default.execute(17, new Object[] {A271LiqDescrip, A98LiqFecha, Short.valueOf(A585LiqPerAno), Byte.valueOf(A586LiqPerMes), A283LiqPeriodo, A280LiqFecPago, A2368TLiqDescAux, Byte.valueOf(A278LiqEstado), Byte.valueOf(A2292LiqLSDDepEst), Byte.valueOf(A1403LiqAuxEstado), Byte.valueOf(A2293LiqContrEst), Boolean.valueOf(n268LiqClase), Byte.valueOf(A268LiqClase), Boolean.valueOf(n2180LiqPDFEstado), A2180LiqPDFEstado, Boolean.valueOf(A361LiqGenInter), Boolean.valueOf(A494LiqContabilizada), Short.valueOf(A495LiqCntLeg), A496LiqImpNeto, A755LiqImpDescuentos, A756LiqImpRetenGan, A497LiqImpBruto, Boolean.valueOf(A500LegEspecificos), A511LiqFecCre, A512LiqUsuCre, A513LiqPerSinDia, A748LiqPerPalabra, A580LiqDepPrvPer, A581LiqDepPrvFec, Short.valueOf(A583LiqDepPerAno), Byte.valueOf(A584LiqDepPerMes), A587LiqFecMod, A588LiqUsuMod, A719LiqFecImp, A743LiqPisoGanancias, A744LiqPisGanSAC, A745LiqTopeDedInc, A746LiqPerUltNorm, A766LiqError, A1404LiqErrorAux, A874LiqNombre, A881LiqLegajosTxt, A885LiqSegundos, A963LiqRutaPDFTodosVertical, A964LiqRutaPDFTodosHorizontal, A965LiqRutaPDFTodosNombreVertical, A966LiqRutaPDFTodosNombreHorizonta, A1142LiqLog, Boolean.valueOf(n2195LiqSac), Boolean.valueOf(A2195LiqSac), Boolean.valueOf(n2196LiqSacLog), A2196LiqSacLog, Boolean.valueOf(A2298LiqCancel), A2409LiqModTra, Byte.valueOf(A2414LiqFrecPag), A2410LiqPerDes, A2411LiqPerHas, A2426LiqTipoTarifa, Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod, Boolean.valueOf(n32TLiqCod), A32TLiqCod, A1729PeriodoLiq, Boolean.valueOf(n2112LiqRelNro), Integer.valueOf(A2112LiqRelNro), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
                  if ( (pr_default.getStatus(17) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Liquidacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0R25( ) ;
                  if ( AnyError == 0 )
                  {
                     GXv_int5[0] = A3CliCod ;
                     GXv_int6[0] = A1EmpCod ;
                     GXv_int7[0] = A31LiqNro ;
                     new web.liquidacionupdateredundancy(remoteHandle, context).execute( GXv_int5, GXv_int6, GXv_int7) ;
                     liquidacion_bc.this.A3CliCod = GXv_int5[0] ;
                     liquidacion_bc.this.A1EmpCod = GXv_int6[0] ;
                     liquidacion_bc.this.A31LiqNro = GXv_int7[0] ;
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey( ) ;
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                        endTrnMsgCod = "SuccessfullyUpdated" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel0R25( ) ;
      }
      closeExtendedTableCursors0R25( ) ;
   }

   public void deferredUpdate0R25( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0R25( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0R25( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0R25( ) ;
         afterConfirm0R25( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0R25( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000R20 */
               pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                     endTrnMsgCod = "SuccessfullyDeleted" ;
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode25 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0R25( ) ;
      Gx_mode = sMode25 ;
   }

   public void onDeleteControls0R25( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV29Pgmname = "Liquidacion_BC" ;
         /* Using cursor BC000R21 */
         pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         A2EmpNom = BC000R21_A2EmpNom[0] ;
         pr_default.close(19);
         /* Using cursor BC000R22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         A340TliqDesc = BC000R22_A340TliqDesc[0] ;
         pr_default.close(20);
         /* Using cursor BC000R23 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod});
         A582LiqDepBanDescrip = BC000R23_A582LiqDepBanDescrip[0] ;
         pr_default.close(21);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000R24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(22) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(22);
         /* Using cursor BC000R25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(23) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionLegajoLinkPdf", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(23);
         /* Using cursor BC000R26 */
         pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(24) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licenciasconsumos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(24);
         /* Using cursor BC000R27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_cuenta_licenciasaprobaciones", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor BC000R28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_permanencia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
         /* Using cursor BC000R29 */
         pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(27) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionSucursal", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(27);
         /* Using cursor BC000R30 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(28) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionArea", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
         /* Using cursor BC000R31 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(29) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionConvenio", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
         /* Using cursor BC000R32 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(30) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LSD_reg1", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
         /* Using cursor BC000R33 */
         pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(31) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")+" ("+httpContext.getMessage( "Liq Nueva Obl Cuenta", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(31);
         /* Using cursor BC000R34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(32) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Obligacion Cuenta", "")+" ("+httpContext.getMessage( "Liq Alta Obl Cuenta", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(32);
         /* Using cursor BC000R35 */
         pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(33) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Obligacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(33);
         /* Using cursor BC000R36 */
         pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(34) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")+" ("+httpContext.getMessage( "Liq Nueva Prorra", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(34);
         /* Using cursor BC000R37 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(35) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liq Leg Concepto Cuenta", "")+" ("+httpContext.getMessage( "Liq Alta Prorrateo", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
         /* Using cursor BC000R38 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(36) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Lugar Pago", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
         /* Using cursor BC000R39 */
         pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(37) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(37);
         /* Using cursor BC000R40 */
         pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         if ( (pr_default.getStatus(38) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Agenda de Novedades", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(38);
      }
   }

   public void endLevel0R25( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(15);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0R25( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0R25( )
   {
      /* Scan By routine */
      /* Using cursor BC000R41 */
      pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
      RcdFound25 = (short)(0) ;
      if ( (pr_default.getStatus(39) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A31LiqNro = BC000R41_A31LiqNro[0] ;
         A2EmpNom = BC000R41_A2EmpNom[0] ;
         A271LiqDescrip = BC000R41_A271LiqDescrip[0] ;
         A98LiqFecha = BC000R41_A98LiqFecha[0] ;
         A585LiqPerAno = BC000R41_A585LiqPerAno[0] ;
         A586LiqPerMes = BC000R41_A586LiqPerMes[0] ;
         A283LiqPeriodo = BC000R41_A283LiqPeriodo[0] ;
         A280LiqFecPago = BC000R41_A280LiqFecPago[0] ;
         A340TliqDesc = BC000R41_A340TliqDesc[0] ;
         A2368TLiqDescAux = BC000R41_A2368TLiqDescAux[0] ;
         A278LiqEstado = BC000R41_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = BC000R41_A2292LiqLSDDepEst[0] ;
         A1403LiqAuxEstado = BC000R41_A1403LiqAuxEstado[0] ;
         A2293LiqContrEst = BC000R41_A2293LiqContrEst[0] ;
         A268LiqClase = BC000R41_A268LiqClase[0] ;
         n268LiqClase = BC000R41_n268LiqClase[0] ;
         A2180LiqPDFEstado = BC000R41_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = BC000R41_n2180LiqPDFEstado[0] ;
         A361LiqGenInter = BC000R41_A361LiqGenInter[0] ;
         A494LiqContabilizada = BC000R41_A494LiqContabilizada[0] ;
         A495LiqCntLeg = BC000R41_A495LiqCntLeg[0] ;
         A496LiqImpNeto = BC000R41_A496LiqImpNeto[0] ;
         A755LiqImpDescuentos = BC000R41_A755LiqImpDescuentos[0] ;
         A756LiqImpRetenGan = BC000R41_A756LiqImpRetenGan[0] ;
         A497LiqImpBruto = BC000R41_A497LiqImpBruto[0] ;
         A500LegEspecificos = BC000R41_A500LegEspecificos[0] ;
         A511LiqFecCre = BC000R41_A511LiqFecCre[0] ;
         A512LiqUsuCre = BC000R41_A512LiqUsuCre[0] ;
         A513LiqPerSinDia = BC000R41_A513LiqPerSinDia[0] ;
         A748LiqPerPalabra = BC000R41_A748LiqPerPalabra[0] ;
         A580LiqDepPrvPer = BC000R41_A580LiqDepPrvPer[0] ;
         A581LiqDepPrvFec = BC000R41_A581LiqDepPrvFec[0] ;
         A582LiqDepBanDescrip = BC000R41_A582LiqDepBanDescrip[0] ;
         A583LiqDepPerAno = BC000R41_A583LiqDepPerAno[0] ;
         A584LiqDepPerMes = BC000R41_A584LiqDepPerMes[0] ;
         A587LiqFecMod = BC000R41_A587LiqFecMod[0] ;
         A588LiqUsuMod = BC000R41_A588LiqUsuMod[0] ;
         A719LiqFecImp = BC000R41_A719LiqFecImp[0] ;
         A743LiqPisoGanancias = BC000R41_A743LiqPisoGanancias[0] ;
         A744LiqPisGanSAC = BC000R41_A744LiqPisGanSAC[0] ;
         A745LiqTopeDedInc = BC000R41_A745LiqTopeDedInc[0] ;
         A746LiqPerUltNorm = BC000R41_A746LiqPerUltNorm[0] ;
         A766LiqError = BC000R41_A766LiqError[0] ;
         A1404LiqErrorAux = BC000R41_A1404LiqErrorAux[0] ;
         A874LiqNombre = BC000R41_A874LiqNombre[0] ;
         A881LiqLegajosTxt = BC000R41_A881LiqLegajosTxt[0] ;
         A885LiqSegundos = BC000R41_A885LiqSegundos[0] ;
         A963LiqRutaPDFTodosVertical = BC000R41_A963LiqRutaPDFTodosVertical[0] ;
         A964LiqRutaPDFTodosHorizontal = BC000R41_A964LiqRutaPDFTodosHorizontal[0] ;
         A965LiqRutaPDFTodosNombreVertical = BC000R41_A965LiqRutaPDFTodosNombreVertical[0] ;
         A966LiqRutaPDFTodosNombreHorizonta = BC000R41_A966LiqRutaPDFTodosNombreHorizonta[0] ;
         A1142LiqLog = BC000R41_A1142LiqLog[0] ;
         A2195LiqSac = BC000R41_A2195LiqSac[0] ;
         n2195LiqSac = BC000R41_n2195LiqSac[0] ;
         A2196LiqSacLog = BC000R41_A2196LiqSacLog[0] ;
         n2196LiqSacLog = BC000R41_n2196LiqSacLog[0] ;
         A2298LiqCancel = BC000R41_A2298LiqCancel[0] ;
         A2409LiqModTra = BC000R41_A2409LiqModTra[0] ;
         A2414LiqFrecPag = BC000R41_A2414LiqFrecPag[0] ;
         A2410LiqPerDes = BC000R41_A2410LiqPerDes[0] ;
         A2411LiqPerHas = BC000R41_A2411LiqPerHas[0] ;
         A2426LiqTipoTarifa = BC000R41_A2426LiqTipoTarifa[0] ;
         A3CliCod = BC000R41_A3CliCod[0] ;
         A33LiqDepBanCod = BC000R41_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = BC000R41_n33LiqDepBanCod[0] ;
         A1EmpCod = BC000R41_A1EmpCod[0] ;
         A32TLiqCod = BC000R41_A32TLiqCod[0] ;
         n32TLiqCod = BC000R41_n32TLiqCod[0] ;
         A1729PeriodoLiq = BC000R41_A1729PeriodoLiq[0] ;
         A2112LiqRelNro = BC000R41_A2112LiqRelNro[0] ;
         n2112LiqRelNro = BC000R41_n2112LiqRelNro[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0R25( )
   {
      /* Scan next routine */
      pr_default.readNext(39);
      RcdFound25 = (short)(0) ;
      scanKeyLoad0R25( ) ;
   }

   public void scanKeyLoad0R25( )
   {
      sMode25 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(39) != 101) )
      {
         RcdFound25 = (short)(1) ;
         A31LiqNro = BC000R41_A31LiqNro[0] ;
         A2EmpNom = BC000R41_A2EmpNom[0] ;
         A271LiqDescrip = BC000R41_A271LiqDescrip[0] ;
         A98LiqFecha = BC000R41_A98LiqFecha[0] ;
         A585LiqPerAno = BC000R41_A585LiqPerAno[0] ;
         A586LiqPerMes = BC000R41_A586LiqPerMes[0] ;
         A283LiqPeriodo = BC000R41_A283LiqPeriodo[0] ;
         A280LiqFecPago = BC000R41_A280LiqFecPago[0] ;
         A340TliqDesc = BC000R41_A340TliqDesc[0] ;
         A2368TLiqDescAux = BC000R41_A2368TLiqDescAux[0] ;
         A278LiqEstado = BC000R41_A278LiqEstado[0] ;
         A2292LiqLSDDepEst = BC000R41_A2292LiqLSDDepEst[0] ;
         A1403LiqAuxEstado = BC000R41_A1403LiqAuxEstado[0] ;
         A2293LiqContrEst = BC000R41_A2293LiqContrEst[0] ;
         A268LiqClase = BC000R41_A268LiqClase[0] ;
         n268LiqClase = BC000R41_n268LiqClase[0] ;
         A2180LiqPDFEstado = BC000R41_A2180LiqPDFEstado[0] ;
         n2180LiqPDFEstado = BC000R41_n2180LiqPDFEstado[0] ;
         A361LiqGenInter = BC000R41_A361LiqGenInter[0] ;
         A494LiqContabilizada = BC000R41_A494LiqContabilizada[0] ;
         A495LiqCntLeg = BC000R41_A495LiqCntLeg[0] ;
         A496LiqImpNeto = BC000R41_A496LiqImpNeto[0] ;
         A755LiqImpDescuentos = BC000R41_A755LiqImpDescuentos[0] ;
         A756LiqImpRetenGan = BC000R41_A756LiqImpRetenGan[0] ;
         A497LiqImpBruto = BC000R41_A497LiqImpBruto[0] ;
         A500LegEspecificos = BC000R41_A500LegEspecificos[0] ;
         A511LiqFecCre = BC000R41_A511LiqFecCre[0] ;
         A512LiqUsuCre = BC000R41_A512LiqUsuCre[0] ;
         A513LiqPerSinDia = BC000R41_A513LiqPerSinDia[0] ;
         A748LiqPerPalabra = BC000R41_A748LiqPerPalabra[0] ;
         A580LiqDepPrvPer = BC000R41_A580LiqDepPrvPer[0] ;
         A581LiqDepPrvFec = BC000R41_A581LiqDepPrvFec[0] ;
         A582LiqDepBanDescrip = BC000R41_A582LiqDepBanDescrip[0] ;
         A583LiqDepPerAno = BC000R41_A583LiqDepPerAno[0] ;
         A584LiqDepPerMes = BC000R41_A584LiqDepPerMes[0] ;
         A587LiqFecMod = BC000R41_A587LiqFecMod[0] ;
         A588LiqUsuMod = BC000R41_A588LiqUsuMod[0] ;
         A719LiqFecImp = BC000R41_A719LiqFecImp[0] ;
         A743LiqPisoGanancias = BC000R41_A743LiqPisoGanancias[0] ;
         A744LiqPisGanSAC = BC000R41_A744LiqPisGanSAC[0] ;
         A745LiqTopeDedInc = BC000R41_A745LiqTopeDedInc[0] ;
         A746LiqPerUltNorm = BC000R41_A746LiqPerUltNorm[0] ;
         A766LiqError = BC000R41_A766LiqError[0] ;
         A1404LiqErrorAux = BC000R41_A1404LiqErrorAux[0] ;
         A874LiqNombre = BC000R41_A874LiqNombre[0] ;
         A881LiqLegajosTxt = BC000R41_A881LiqLegajosTxt[0] ;
         A885LiqSegundos = BC000R41_A885LiqSegundos[0] ;
         A963LiqRutaPDFTodosVertical = BC000R41_A963LiqRutaPDFTodosVertical[0] ;
         A964LiqRutaPDFTodosHorizontal = BC000R41_A964LiqRutaPDFTodosHorizontal[0] ;
         A965LiqRutaPDFTodosNombreVertical = BC000R41_A965LiqRutaPDFTodosNombreVertical[0] ;
         A966LiqRutaPDFTodosNombreHorizonta = BC000R41_A966LiqRutaPDFTodosNombreHorizonta[0] ;
         A1142LiqLog = BC000R41_A1142LiqLog[0] ;
         A2195LiqSac = BC000R41_A2195LiqSac[0] ;
         n2195LiqSac = BC000R41_n2195LiqSac[0] ;
         A2196LiqSacLog = BC000R41_A2196LiqSacLog[0] ;
         n2196LiqSacLog = BC000R41_n2196LiqSacLog[0] ;
         A2298LiqCancel = BC000R41_A2298LiqCancel[0] ;
         A2409LiqModTra = BC000R41_A2409LiqModTra[0] ;
         A2414LiqFrecPag = BC000R41_A2414LiqFrecPag[0] ;
         A2410LiqPerDes = BC000R41_A2410LiqPerDes[0] ;
         A2411LiqPerHas = BC000R41_A2411LiqPerHas[0] ;
         A2426LiqTipoTarifa = BC000R41_A2426LiqTipoTarifa[0] ;
         A3CliCod = BC000R41_A3CliCod[0] ;
         A33LiqDepBanCod = BC000R41_A33LiqDepBanCod[0] ;
         n33LiqDepBanCod = BC000R41_n33LiqDepBanCod[0] ;
         A1EmpCod = BC000R41_A1EmpCod[0] ;
         A32TLiqCod = BC000R41_A32TLiqCod[0] ;
         n32TLiqCod = BC000R41_n32TLiqCod[0] ;
         A1729PeriodoLiq = BC000R41_A1729PeriodoLiq[0] ;
         A2112LiqRelNro = BC000R41_A2112LiqRelNro[0] ;
         n2112LiqRelNro = BC000R41_n2112LiqRelNro[0] ;
      }
      Gx_mode = sMode25 ;
   }

   public void scanKeyEnd0R25( )
   {
      pr_default.close(39);
   }

   public void afterConfirm0R25( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0R25( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0R25( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0R25( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0R25( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0R25( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0R25( )
   {
   }

   public void send_integrity_lvl_hashes0R25( )
   {
   }

   public void addRow0R25( )
   {
      VarsToRow25( bcLiquidacion) ;
   }

   public void readRow0R25( )
   {
      RowToVars25( bcLiquidacion, 1) ;
   }

   public void initializeNonKey0R25( )
   {
      A2EmpNom = "" ;
      A271LiqDescrip = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A585LiqPerAno = (short)(0) ;
      A586LiqPerMes = (byte)(0) ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A280LiqFecPago = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      n32TLiqCod = false ;
      A340TliqDesc = "" ;
      A2368TLiqDescAux = "" ;
      A278LiqEstado = (byte)(0) ;
      A2292LiqLSDDepEst = (byte)(0) ;
      A1403LiqAuxEstado = (byte)(0) ;
      A2293LiqContrEst = (byte)(0) ;
      A268LiqClase = (byte)(0) ;
      n268LiqClase = false ;
      A2180LiqPDFEstado = "" ;
      n2180LiqPDFEstado = false ;
      A361LiqGenInter = false ;
      A494LiqContabilizada = false ;
      A495LiqCntLeg = (short)(0) ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      A755LiqImpDescuentos = DecimalUtil.ZERO ;
      A756LiqImpRetenGan = DecimalUtil.ZERO ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A500LegEspecificos = false ;
      A511LiqFecCre = GXutil.nullDate() ;
      A512LiqUsuCre = "" ;
      A513LiqPerSinDia = "" ;
      A748LiqPerPalabra = "" ;
      A580LiqDepPrvPer = "" ;
      A581LiqDepPrvFec = GXutil.nullDate() ;
      A582LiqDepBanDescrip = "" ;
      A33LiqDepBanCod = "" ;
      n33LiqDepBanCod = false ;
      A583LiqDepPerAno = (short)(0) ;
      A584LiqDepPerMes = (byte)(0) ;
      A587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      A588LiqUsuMod = "" ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      A743LiqPisoGanancias = DecimalUtil.ZERO ;
      A744LiqPisGanSAC = DecimalUtil.ZERO ;
      A745LiqTopeDedInc = DecimalUtil.ZERO ;
      A746LiqPerUltNorm = GXutil.nullDate() ;
      A766LiqError = "" ;
      A1404LiqErrorAux = "" ;
      A874LiqNombre = "" ;
      A881LiqLegajosTxt = "" ;
      A885LiqSegundos = DecimalUtil.ZERO ;
      A963LiqRutaPDFTodosVertical = "" ;
      A964LiqRutaPDFTodosHorizontal = "" ;
      A965LiqRutaPDFTodosNombreVertical = "" ;
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      A1142LiqLog = "" ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      A2112LiqRelNro = 0 ;
      n2112LiqRelNro = false ;
      A2195LiqSac = false ;
      n2195LiqSac = false ;
      A2196LiqSacLog = "" ;
      n2196LiqSacLog = false ;
      A2298LiqCancel = false ;
      A2409LiqModTra = "" ;
      A2414LiqFrecPag = (byte)(0) ;
      A2410LiqPerDes = GXutil.nullDate() ;
      A2411LiqPerHas = GXutil.nullDate() ;
      A2426LiqTipoTarifa = "" ;
      Z271LiqDescrip = "" ;
      Z98LiqFecha = GXutil.nullDate() ;
      Z585LiqPerAno = (short)(0) ;
      Z586LiqPerMes = (byte)(0) ;
      Z283LiqPeriodo = GXutil.nullDate() ;
      Z280LiqFecPago = GXutil.nullDate() ;
      Z2368TLiqDescAux = "" ;
      Z278LiqEstado = (byte)(0) ;
      Z2292LiqLSDDepEst = (byte)(0) ;
      Z1403LiqAuxEstado = (byte)(0) ;
      Z2293LiqContrEst = (byte)(0) ;
      Z268LiqClase = (byte)(0) ;
      Z2180LiqPDFEstado = "" ;
      Z361LiqGenInter = false ;
      Z494LiqContabilizada = false ;
      Z495LiqCntLeg = (short)(0) ;
      Z496LiqImpNeto = DecimalUtil.ZERO ;
      Z755LiqImpDescuentos = DecimalUtil.ZERO ;
      Z756LiqImpRetenGan = DecimalUtil.ZERO ;
      Z497LiqImpBruto = DecimalUtil.ZERO ;
      Z500LegEspecificos = false ;
      Z511LiqFecCre = GXutil.nullDate() ;
      Z512LiqUsuCre = "" ;
      Z513LiqPerSinDia = "" ;
      Z748LiqPerPalabra = "" ;
      Z580LiqDepPrvPer = "" ;
      Z581LiqDepPrvFec = GXutil.nullDate() ;
      Z583LiqDepPerAno = (short)(0) ;
      Z584LiqDepPerMes = (byte)(0) ;
      Z587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      Z588LiqUsuMod = "" ;
      Z719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      Z743LiqPisoGanancias = DecimalUtil.ZERO ;
      Z744LiqPisGanSAC = DecimalUtil.ZERO ;
      Z745LiqTopeDedInc = DecimalUtil.ZERO ;
      Z746LiqPerUltNorm = GXutil.nullDate() ;
      Z766LiqError = "" ;
      Z1404LiqErrorAux = "" ;
      Z874LiqNombre = "" ;
      Z881LiqLegajosTxt = "" ;
      Z885LiqSegundos = DecimalUtil.ZERO ;
      Z963LiqRutaPDFTodosVertical = "" ;
      Z964LiqRutaPDFTodosHorizontal = "" ;
      Z965LiqRutaPDFTodosNombreVertical = "" ;
      Z966LiqRutaPDFTodosNombreHorizonta = "" ;
      Z2195LiqSac = false ;
      Z2196LiqSacLog = "" ;
      Z2298LiqCancel = false ;
      Z2409LiqModTra = "" ;
      Z2414LiqFrecPag = (byte)(0) ;
      Z2410LiqPerDes = GXutil.nullDate() ;
      Z2411LiqPerHas = GXutil.nullDate() ;
      Z2426LiqTipoTarifa = "" ;
      Z33LiqDepBanCod = "" ;
      Z32TLiqCod = "" ;
      Z1729PeriodoLiq = GXutil.nullDate() ;
      Z2112LiqRelNro = 0 ;
   }

   public void initAll0R25( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A31LiqNro = 0 ;
      initializeNonKey0R25( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow25( web.SdtLiquidacion obj25 )
   {
      obj25.setgxTv_SdtLiquidacion_Mode( Gx_mode );
      obj25.setgxTv_SdtLiquidacion_Empnom( A2EmpNom );
      obj25.setgxTv_SdtLiquidacion_Liqdescrip( A271LiqDescrip );
      obj25.setgxTv_SdtLiquidacion_Liqfecha( A98LiqFecha );
      obj25.setgxTv_SdtLiquidacion_Liqperano( A585LiqPerAno );
      obj25.setgxTv_SdtLiquidacion_Liqpermes( A586LiqPerMes );
      obj25.setgxTv_SdtLiquidacion_Liqperiodo( A283LiqPeriodo );
      obj25.setgxTv_SdtLiquidacion_Liqfecpago( A280LiqFecPago );
      obj25.setgxTv_SdtLiquidacion_Tliqcod( A32TLiqCod );
      obj25.setgxTv_SdtLiquidacion_Tliqdesc( A340TliqDesc );
      obj25.setgxTv_SdtLiquidacion_Tliqdescaux( A2368TLiqDescAux );
      obj25.setgxTv_SdtLiquidacion_Liqestado( A278LiqEstado );
      obj25.setgxTv_SdtLiquidacion_Liqlsddepest( A2292LiqLSDDepEst );
      obj25.setgxTv_SdtLiquidacion_Liqauxestado( A1403LiqAuxEstado );
      obj25.setgxTv_SdtLiquidacion_Liqcontrest( A2293LiqContrEst );
      obj25.setgxTv_SdtLiquidacion_Liqclase( A268LiqClase );
      obj25.setgxTv_SdtLiquidacion_Liqpdfestado( A2180LiqPDFEstado );
      obj25.setgxTv_SdtLiquidacion_Liqgeninter( A361LiqGenInter );
      obj25.setgxTv_SdtLiquidacion_Liqcontabilizada( A494LiqContabilizada );
      obj25.setgxTv_SdtLiquidacion_Liqcntleg( A495LiqCntLeg );
      obj25.setgxTv_SdtLiquidacion_Liqimpneto( A496LiqImpNeto );
      obj25.setgxTv_SdtLiquidacion_Liqimpdescuentos( A755LiqImpDescuentos );
      obj25.setgxTv_SdtLiquidacion_Liqimpretengan( A756LiqImpRetenGan );
      obj25.setgxTv_SdtLiquidacion_Liqimpbruto( A497LiqImpBruto );
      obj25.setgxTv_SdtLiquidacion_Legespecificos( A500LegEspecificos );
      obj25.setgxTv_SdtLiquidacion_Liqfeccre( A511LiqFecCre );
      obj25.setgxTv_SdtLiquidacion_Liqusucre( A512LiqUsuCre );
      obj25.setgxTv_SdtLiquidacion_Liqpersindia( A513LiqPerSinDia );
      obj25.setgxTv_SdtLiquidacion_Liqperpalabra( A748LiqPerPalabra );
      obj25.setgxTv_SdtLiquidacion_Liqdepprvper( A580LiqDepPrvPer );
      obj25.setgxTv_SdtLiquidacion_Liqdepprvfec( A581LiqDepPrvFec );
      obj25.setgxTv_SdtLiquidacion_Liqdepbandescrip( A582LiqDepBanDescrip );
      obj25.setgxTv_SdtLiquidacion_Liqdepbancod( A33LiqDepBanCod );
      obj25.setgxTv_SdtLiquidacion_Liqdepperano( A583LiqDepPerAno );
      obj25.setgxTv_SdtLiquidacion_Liqdeppermes( A584LiqDepPerMes );
      obj25.setgxTv_SdtLiquidacion_Liqfecmod( A587LiqFecMod );
      obj25.setgxTv_SdtLiquidacion_Liqusumod( A588LiqUsuMod );
      obj25.setgxTv_SdtLiquidacion_Liqfecimp( A719LiqFecImp );
      obj25.setgxTv_SdtLiquidacion_Liqpisoganancias( A743LiqPisoGanancias );
      obj25.setgxTv_SdtLiquidacion_Liqpisgansac( A744LiqPisGanSAC );
      obj25.setgxTv_SdtLiquidacion_Liqtopededinc( A745LiqTopeDedInc );
      obj25.setgxTv_SdtLiquidacion_Liqperultnorm( A746LiqPerUltNorm );
      obj25.setgxTv_SdtLiquidacion_Liqerror( A766LiqError );
      obj25.setgxTv_SdtLiquidacion_Liqerroraux( A1404LiqErrorAux );
      obj25.setgxTv_SdtLiquidacion_Liqnombre( A874LiqNombre );
      obj25.setgxTv_SdtLiquidacion_Liqlegajostxt( A881LiqLegajosTxt );
      obj25.setgxTv_SdtLiquidacion_Liqsegundos( A885LiqSegundos );
      obj25.setgxTv_SdtLiquidacion_Liqrutapdftodosvertical( A963LiqRutaPDFTodosVertical );
      obj25.setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal( A964LiqRutaPDFTodosHorizontal );
      obj25.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical( A965LiqRutaPDFTodosNombreVertical );
      obj25.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal( A966LiqRutaPDFTodosNombreHorizonta );
      obj25.setgxTv_SdtLiquidacion_Liqlog( A1142LiqLog );
      obj25.setgxTv_SdtLiquidacion_Periodoliq( A1729PeriodoLiq );
      obj25.setgxTv_SdtLiquidacion_Liqrelnro( A2112LiqRelNro );
      obj25.setgxTv_SdtLiquidacion_Liqsac( A2195LiqSac );
      obj25.setgxTv_SdtLiquidacion_Liqsaclog( A2196LiqSacLog );
      obj25.setgxTv_SdtLiquidacion_Liqcancel( A2298LiqCancel );
      obj25.setgxTv_SdtLiquidacion_Liqmodtra( A2409LiqModTra );
      obj25.setgxTv_SdtLiquidacion_Liqfrecpag( A2414LiqFrecPag );
      obj25.setgxTv_SdtLiquidacion_Liqperdes( A2410LiqPerDes );
      obj25.setgxTv_SdtLiquidacion_Liqperhas( A2411LiqPerHas );
      obj25.setgxTv_SdtLiquidacion_Liqtipotarifa( A2426LiqTipoTarifa );
      obj25.setgxTv_SdtLiquidacion_Clicod( A3CliCod );
      obj25.setgxTv_SdtLiquidacion_Empcod( A1EmpCod );
      obj25.setgxTv_SdtLiquidacion_Liqnro( A31LiqNro );
      obj25.setgxTv_SdtLiquidacion_Clicod_Z( Z3CliCod );
      obj25.setgxTv_SdtLiquidacion_Empcod_Z( Z1EmpCod );
      obj25.setgxTv_SdtLiquidacion_Empnom_Z( Z2EmpNom );
      obj25.setgxTv_SdtLiquidacion_Liqnro_Z( Z31LiqNro );
      obj25.setgxTv_SdtLiquidacion_Liqdescrip_Z( Z271LiqDescrip );
      obj25.setgxTv_SdtLiquidacion_Liqfecha_Z( Z98LiqFecha );
      obj25.setgxTv_SdtLiquidacion_Liqperano_Z( Z585LiqPerAno );
      obj25.setgxTv_SdtLiquidacion_Liqpermes_Z( Z586LiqPerMes );
      obj25.setgxTv_SdtLiquidacion_Liqperiodo_Z( Z283LiqPeriodo );
      obj25.setgxTv_SdtLiquidacion_Liqfecpago_Z( Z280LiqFecPago );
      obj25.setgxTv_SdtLiquidacion_Tliqcod_Z( Z32TLiqCod );
      obj25.setgxTv_SdtLiquidacion_Tliqdesc_Z( Z340TliqDesc );
      obj25.setgxTv_SdtLiquidacion_Tliqdescaux_Z( Z2368TLiqDescAux );
      obj25.setgxTv_SdtLiquidacion_Liqestado_Z( Z278LiqEstado );
      obj25.setgxTv_SdtLiquidacion_Liqlsddepest_Z( Z2292LiqLSDDepEst );
      obj25.setgxTv_SdtLiquidacion_Liqauxestado_Z( Z1403LiqAuxEstado );
      obj25.setgxTv_SdtLiquidacion_Liqcontrest_Z( Z2293LiqContrEst );
      obj25.setgxTv_SdtLiquidacion_Liqclase_Z( Z268LiqClase );
      obj25.setgxTv_SdtLiquidacion_Liqpdfestado_Z( Z2180LiqPDFEstado );
      obj25.setgxTv_SdtLiquidacion_Liqgeninter_Z( Z361LiqGenInter );
      obj25.setgxTv_SdtLiquidacion_Liqcontabilizada_Z( Z494LiqContabilizada );
      obj25.setgxTv_SdtLiquidacion_Liqcntleg_Z( Z495LiqCntLeg );
      obj25.setgxTv_SdtLiquidacion_Liqimpneto_Z( Z496LiqImpNeto );
      obj25.setgxTv_SdtLiquidacion_Liqimpdescuentos_Z( Z755LiqImpDescuentos );
      obj25.setgxTv_SdtLiquidacion_Liqimpretengan_Z( Z756LiqImpRetenGan );
      obj25.setgxTv_SdtLiquidacion_Liqimpbruto_Z( Z497LiqImpBruto );
      obj25.setgxTv_SdtLiquidacion_Legespecificos_Z( Z500LegEspecificos );
      obj25.setgxTv_SdtLiquidacion_Liqfeccre_Z( Z511LiqFecCre );
      obj25.setgxTv_SdtLiquidacion_Liqusucre_Z( Z512LiqUsuCre );
      obj25.setgxTv_SdtLiquidacion_Liqpersindia_Z( Z513LiqPerSinDia );
      obj25.setgxTv_SdtLiquidacion_Liqperpalabra_Z( Z748LiqPerPalabra );
      obj25.setgxTv_SdtLiquidacion_Liqdepprvper_Z( Z580LiqDepPrvPer );
      obj25.setgxTv_SdtLiquidacion_Liqdepprvfec_Z( Z581LiqDepPrvFec );
      obj25.setgxTv_SdtLiquidacion_Liqdepbandescrip_Z( Z582LiqDepBanDescrip );
      obj25.setgxTv_SdtLiquidacion_Liqdepbancod_Z( Z33LiqDepBanCod );
      obj25.setgxTv_SdtLiquidacion_Liqdepperano_Z( Z583LiqDepPerAno );
      obj25.setgxTv_SdtLiquidacion_Liqdeppermes_Z( Z584LiqDepPerMes );
      obj25.setgxTv_SdtLiquidacion_Liqfecmod_Z( Z587LiqFecMod );
      obj25.setgxTv_SdtLiquidacion_Liqusumod_Z( Z588LiqUsuMod );
      obj25.setgxTv_SdtLiquidacion_Liqfecimp_Z( Z719LiqFecImp );
      obj25.setgxTv_SdtLiquidacion_Liqpisoganancias_Z( Z743LiqPisoGanancias );
      obj25.setgxTv_SdtLiquidacion_Liqpisgansac_Z( Z744LiqPisGanSAC );
      obj25.setgxTv_SdtLiquidacion_Liqtopededinc_Z( Z745LiqTopeDedInc );
      obj25.setgxTv_SdtLiquidacion_Liqperultnorm_Z( Z746LiqPerUltNorm );
      obj25.setgxTv_SdtLiquidacion_Liqerror_Z( Z766LiqError );
      obj25.setgxTv_SdtLiquidacion_Liqerroraux_Z( Z1404LiqErrorAux );
      obj25.setgxTv_SdtLiquidacion_Liqnombre_Z( Z874LiqNombre );
      obj25.setgxTv_SdtLiquidacion_Liqlegajostxt_Z( Z881LiqLegajosTxt );
      obj25.setgxTv_SdtLiquidacion_Liqsegundos_Z( Z885LiqSegundos );
      obj25.setgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z( Z963LiqRutaPDFTodosVertical );
      obj25.setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z( Z964LiqRutaPDFTodosHorizontal );
      obj25.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z( Z965LiqRutaPDFTodosNombreVertical );
      obj25.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z( Z966LiqRutaPDFTodosNombreHorizonta );
      obj25.setgxTv_SdtLiquidacion_Periodoliq_Z( Z1729PeriodoLiq );
      obj25.setgxTv_SdtLiquidacion_Liqrelnro_Z( Z2112LiqRelNro );
      obj25.setgxTv_SdtLiquidacion_Liqsac_Z( Z2195LiqSac );
      obj25.setgxTv_SdtLiquidacion_Liqsaclog_Z( Z2196LiqSacLog );
      obj25.setgxTv_SdtLiquidacion_Liqcancel_Z( Z2298LiqCancel );
      obj25.setgxTv_SdtLiquidacion_Liqmodtra_Z( Z2409LiqModTra );
      obj25.setgxTv_SdtLiquidacion_Liqfrecpag_Z( Z2414LiqFrecPag );
      obj25.setgxTv_SdtLiquidacion_Liqperdes_Z( Z2410LiqPerDes );
      obj25.setgxTv_SdtLiquidacion_Liqperhas_Z( Z2411LiqPerHas );
      obj25.setgxTv_SdtLiquidacion_Liqtipotarifa_Z( Z2426LiqTipoTarifa );
      obj25.setgxTv_SdtLiquidacion_Tliqcod_N( (byte)((byte)((n32TLiqCod)?1:0)) );
      obj25.setgxTv_SdtLiquidacion_Liqclase_N( (byte)((byte)((n268LiqClase)?1:0)) );
      obj25.setgxTv_SdtLiquidacion_Liqpdfestado_N( (byte)((byte)((n2180LiqPDFEstado)?1:0)) );
      obj25.setgxTv_SdtLiquidacion_Liqdepbancod_N( (byte)((byte)((n33LiqDepBanCod)?1:0)) );
      obj25.setgxTv_SdtLiquidacion_Liqrelnro_N( (byte)((byte)((n2112LiqRelNro)?1:0)) );
      obj25.setgxTv_SdtLiquidacion_Liqsac_N( (byte)((byte)((n2195LiqSac)?1:0)) );
      obj25.setgxTv_SdtLiquidacion_Liqsaclog_N( (byte)((byte)((n2196LiqSacLog)?1:0)) );
      obj25.setgxTv_SdtLiquidacion_Mode( Gx_mode );
   }

   public void KeyVarsToRow25( web.SdtLiquidacion obj25 )
   {
      obj25.setgxTv_SdtLiquidacion_Clicod( A3CliCod );
      obj25.setgxTv_SdtLiquidacion_Empcod( A1EmpCod );
      obj25.setgxTv_SdtLiquidacion_Liqnro( A31LiqNro );
   }

   public void RowToVars25( web.SdtLiquidacion obj25 ,
                            int forceLoad )
   {
      Gx_mode = obj25.getgxTv_SdtLiquidacion_Mode() ;
      A2EmpNom = obj25.getgxTv_SdtLiquidacion_Empnom() ;
      A271LiqDescrip = obj25.getgxTv_SdtLiquidacion_Liqdescrip() ;
      A98LiqFecha = obj25.getgxTv_SdtLiquidacion_Liqfecha() ;
      A585LiqPerAno = obj25.getgxTv_SdtLiquidacion_Liqperano() ;
      A586LiqPerMes = obj25.getgxTv_SdtLiquidacion_Liqpermes() ;
      A283LiqPeriodo = obj25.getgxTv_SdtLiquidacion_Liqperiodo() ;
      A280LiqFecPago = obj25.getgxTv_SdtLiquidacion_Liqfecpago() ;
      A32TLiqCod = obj25.getgxTv_SdtLiquidacion_Tliqcod() ;
      n32TLiqCod = false ;
      A340TliqDesc = obj25.getgxTv_SdtLiquidacion_Tliqdesc() ;
      A2368TLiqDescAux = obj25.getgxTv_SdtLiquidacion_Tliqdescaux() ;
      A278LiqEstado = obj25.getgxTv_SdtLiquidacion_Liqestado() ;
      A2292LiqLSDDepEst = obj25.getgxTv_SdtLiquidacion_Liqlsddepest() ;
      A1403LiqAuxEstado = obj25.getgxTv_SdtLiquidacion_Liqauxestado() ;
      A2293LiqContrEst = obj25.getgxTv_SdtLiquidacion_Liqcontrest() ;
      A268LiqClase = obj25.getgxTv_SdtLiquidacion_Liqclase() ;
      n268LiqClase = false ;
      A2180LiqPDFEstado = obj25.getgxTv_SdtLiquidacion_Liqpdfestado() ;
      n2180LiqPDFEstado = false ;
      A361LiqGenInter = obj25.getgxTv_SdtLiquidacion_Liqgeninter() ;
      A494LiqContabilizada = obj25.getgxTv_SdtLiquidacion_Liqcontabilizada() ;
      A495LiqCntLeg = obj25.getgxTv_SdtLiquidacion_Liqcntleg() ;
      A496LiqImpNeto = obj25.getgxTv_SdtLiquidacion_Liqimpneto() ;
      A755LiqImpDescuentos = obj25.getgxTv_SdtLiquidacion_Liqimpdescuentos() ;
      A756LiqImpRetenGan = obj25.getgxTv_SdtLiquidacion_Liqimpretengan() ;
      A497LiqImpBruto = obj25.getgxTv_SdtLiquidacion_Liqimpbruto() ;
      A500LegEspecificos = obj25.getgxTv_SdtLiquidacion_Legespecificos() ;
      A511LiqFecCre = obj25.getgxTv_SdtLiquidacion_Liqfeccre() ;
      A512LiqUsuCre = obj25.getgxTv_SdtLiquidacion_Liqusucre() ;
      A513LiqPerSinDia = obj25.getgxTv_SdtLiquidacion_Liqpersindia() ;
      A748LiqPerPalabra = obj25.getgxTv_SdtLiquidacion_Liqperpalabra() ;
      A580LiqDepPrvPer = obj25.getgxTv_SdtLiquidacion_Liqdepprvper() ;
      A581LiqDepPrvFec = obj25.getgxTv_SdtLiquidacion_Liqdepprvfec() ;
      A582LiqDepBanDescrip = obj25.getgxTv_SdtLiquidacion_Liqdepbandescrip() ;
      A33LiqDepBanCod = obj25.getgxTv_SdtLiquidacion_Liqdepbancod() ;
      n33LiqDepBanCod = false ;
      A583LiqDepPerAno = obj25.getgxTv_SdtLiquidacion_Liqdepperano() ;
      A584LiqDepPerMes = obj25.getgxTv_SdtLiquidacion_Liqdeppermes() ;
      A587LiqFecMod = obj25.getgxTv_SdtLiquidacion_Liqfecmod() ;
      A588LiqUsuMod = obj25.getgxTv_SdtLiquidacion_Liqusumod() ;
      A719LiqFecImp = obj25.getgxTv_SdtLiquidacion_Liqfecimp() ;
      A743LiqPisoGanancias = obj25.getgxTv_SdtLiquidacion_Liqpisoganancias() ;
      A744LiqPisGanSAC = obj25.getgxTv_SdtLiquidacion_Liqpisgansac() ;
      A745LiqTopeDedInc = obj25.getgxTv_SdtLiquidacion_Liqtopededinc() ;
      A746LiqPerUltNorm = obj25.getgxTv_SdtLiquidacion_Liqperultnorm() ;
      A766LiqError = obj25.getgxTv_SdtLiquidacion_Liqerror() ;
      A1404LiqErrorAux = obj25.getgxTv_SdtLiquidacion_Liqerroraux() ;
      A874LiqNombre = obj25.getgxTv_SdtLiquidacion_Liqnombre() ;
      A881LiqLegajosTxt = obj25.getgxTv_SdtLiquidacion_Liqlegajostxt() ;
      A885LiqSegundos = obj25.getgxTv_SdtLiquidacion_Liqsegundos() ;
      A963LiqRutaPDFTodosVertical = obj25.getgxTv_SdtLiquidacion_Liqrutapdftodosvertical() ;
      A964LiqRutaPDFTodosHorizontal = obj25.getgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal() ;
      A965LiqRutaPDFTodosNombreVertical = obj25.getgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical() ;
      A966LiqRutaPDFTodosNombreHorizonta = obj25.getgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal() ;
      A1142LiqLog = obj25.getgxTv_SdtLiquidacion_Liqlog() ;
      A1729PeriodoLiq = obj25.getgxTv_SdtLiquidacion_Periodoliq() ;
      A2112LiqRelNro = obj25.getgxTv_SdtLiquidacion_Liqrelnro() ;
      n2112LiqRelNro = false ;
      A2195LiqSac = obj25.getgxTv_SdtLiquidacion_Liqsac() ;
      n2195LiqSac = false ;
      A2196LiqSacLog = obj25.getgxTv_SdtLiquidacion_Liqsaclog() ;
      n2196LiqSacLog = false ;
      A2298LiqCancel = obj25.getgxTv_SdtLiquidacion_Liqcancel() ;
      A2409LiqModTra = obj25.getgxTv_SdtLiquidacion_Liqmodtra() ;
      A2414LiqFrecPag = obj25.getgxTv_SdtLiquidacion_Liqfrecpag() ;
      A2410LiqPerDes = obj25.getgxTv_SdtLiquidacion_Liqperdes() ;
      A2411LiqPerHas = obj25.getgxTv_SdtLiquidacion_Liqperhas() ;
      A2426LiqTipoTarifa = obj25.getgxTv_SdtLiquidacion_Liqtipotarifa() ;
      A3CliCod = obj25.getgxTv_SdtLiquidacion_Clicod() ;
      A1EmpCod = obj25.getgxTv_SdtLiquidacion_Empcod() ;
      A31LiqNro = obj25.getgxTv_SdtLiquidacion_Liqnro() ;
      Z3CliCod = obj25.getgxTv_SdtLiquidacion_Clicod_Z() ;
      Z1EmpCod = obj25.getgxTv_SdtLiquidacion_Empcod_Z() ;
      Z2EmpNom = obj25.getgxTv_SdtLiquidacion_Empnom_Z() ;
      Z31LiqNro = obj25.getgxTv_SdtLiquidacion_Liqnro_Z() ;
      Z271LiqDescrip = obj25.getgxTv_SdtLiquidacion_Liqdescrip_Z() ;
      Z98LiqFecha = obj25.getgxTv_SdtLiquidacion_Liqfecha_Z() ;
      Z585LiqPerAno = obj25.getgxTv_SdtLiquidacion_Liqperano_Z() ;
      Z586LiqPerMes = obj25.getgxTv_SdtLiquidacion_Liqpermes_Z() ;
      Z283LiqPeriodo = obj25.getgxTv_SdtLiquidacion_Liqperiodo_Z() ;
      Z280LiqFecPago = obj25.getgxTv_SdtLiquidacion_Liqfecpago_Z() ;
      Z32TLiqCod = obj25.getgxTv_SdtLiquidacion_Tliqcod_Z() ;
      Z340TliqDesc = obj25.getgxTv_SdtLiquidacion_Tliqdesc_Z() ;
      Z2368TLiqDescAux = obj25.getgxTv_SdtLiquidacion_Tliqdescaux_Z() ;
      Z278LiqEstado = obj25.getgxTv_SdtLiquidacion_Liqestado_Z() ;
      Z2292LiqLSDDepEst = obj25.getgxTv_SdtLiquidacion_Liqlsddepest_Z() ;
      Z1403LiqAuxEstado = obj25.getgxTv_SdtLiquidacion_Liqauxestado_Z() ;
      Z2293LiqContrEst = obj25.getgxTv_SdtLiquidacion_Liqcontrest_Z() ;
      Z268LiqClase = obj25.getgxTv_SdtLiquidacion_Liqclase_Z() ;
      Z2180LiqPDFEstado = obj25.getgxTv_SdtLiquidacion_Liqpdfestado_Z() ;
      Z361LiqGenInter = obj25.getgxTv_SdtLiquidacion_Liqgeninter_Z() ;
      Z494LiqContabilizada = obj25.getgxTv_SdtLiquidacion_Liqcontabilizada_Z() ;
      Z495LiqCntLeg = obj25.getgxTv_SdtLiquidacion_Liqcntleg_Z() ;
      Z496LiqImpNeto = obj25.getgxTv_SdtLiquidacion_Liqimpneto_Z() ;
      Z755LiqImpDescuentos = obj25.getgxTv_SdtLiquidacion_Liqimpdescuentos_Z() ;
      Z756LiqImpRetenGan = obj25.getgxTv_SdtLiquidacion_Liqimpretengan_Z() ;
      Z497LiqImpBruto = obj25.getgxTv_SdtLiquidacion_Liqimpbruto_Z() ;
      Z500LegEspecificos = obj25.getgxTv_SdtLiquidacion_Legespecificos_Z() ;
      Z511LiqFecCre = obj25.getgxTv_SdtLiquidacion_Liqfeccre_Z() ;
      Z512LiqUsuCre = obj25.getgxTv_SdtLiquidacion_Liqusucre_Z() ;
      Z513LiqPerSinDia = obj25.getgxTv_SdtLiquidacion_Liqpersindia_Z() ;
      Z748LiqPerPalabra = obj25.getgxTv_SdtLiquidacion_Liqperpalabra_Z() ;
      Z580LiqDepPrvPer = obj25.getgxTv_SdtLiquidacion_Liqdepprvper_Z() ;
      Z581LiqDepPrvFec = obj25.getgxTv_SdtLiquidacion_Liqdepprvfec_Z() ;
      Z582LiqDepBanDescrip = obj25.getgxTv_SdtLiquidacion_Liqdepbandescrip_Z() ;
      Z33LiqDepBanCod = obj25.getgxTv_SdtLiquidacion_Liqdepbancod_Z() ;
      Z583LiqDepPerAno = obj25.getgxTv_SdtLiquidacion_Liqdepperano_Z() ;
      Z584LiqDepPerMes = obj25.getgxTv_SdtLiquidacion_Liqdeppermes_Z() ;
      Z587LiqFecMod = obj25.getgxTv_SdtLiquidacion_Liqfecmod_Z() ;
      Z588LiqUsuMod = obj25.getgxTv_SdtLiquidacion_Liqusumod_Z() ;
      Z719LiqFecImp = obj25.getgxTv_SdtLiquidacion_Liqfecimp_Z() ;
      Z743LiqPisoGanancias = obj25.getgxTv_SdtLiquidacion_Liqpisoganancias_Z() ;
      Z744LiqPisGanSAC = obj25.getgxTv_SdtLiquidacion_Liqpisgansac_Z() ;
      Z745LiqTopeDedInc = obj25.getgxTv_SdtLiquidacion_Liqtopededinc_Z() ;
      Z746LiqPerUltNorm = obj25.getgxTv_SdtLiquidacion_Liqperultnorm_Z() ;
      Z766LiqError = obj25.getgxTv_SdtLiquidacion_Liqerror_Z() ;
      Z1404LiqErrorAux = obj25.getgxTv_SdtLiquidacion_Liqerroraux_Z() ;
      Z874LiqNombre = obj25.getgxTv_SdtLiquidacion_Liqnombre_Z() ;
      Z881LiqLegajosTxt = obj25.getgxTv_SdtLiquidacion_Liqlegajostxt_Z() ;
      Z885LiqSegundos = obj25.getgxTv_SdtLiquidacion_Liqsegundos_Z() ;
      Z963LiqRutaPDFTodosVertical = obj25.getgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z() ;
      Z964LiqRutaPDFTodosHorizontal = obj25.getgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z() ;
      Z965LiqRutaPDFTodosNombreVertical = obj25.getgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z() ;
      Z966LiqRutaPDFTodosNombreHorizonta = obj25.getgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z() ;
      Z1729PeriodoLiq = obj25.getgxTv_SdtLiquidacion_Periodoliq_Z() ;
      Z2112LiqRelNro = obj25.getgxTv_SdtLiquidacion_Liqrelnro_Z() ;
      Z2195LiqSac = obj25.getgxTv_SdtLiquidacion_Liqsac_Z() ;
      Z2196LiqSacLog = obj25.getgxTv_SdtLiquidacion_Liqsaclog_Z() ;
      Z2298LiqCancel = obj25.getgxTv_SdtLiquidacion_Liqcancel_Z() ;
      Z2409LiqModTra = obj25.getgxTv_SdtLiquidacion_Liqmodtra_Z() ;
      Z2414LiqFrecPag = obj25.getgxTv_SdtLiquidacion_Liqfrecpag_Z() ;
      Z2410LiqPerDes = obj25.getgxTv_SdtLiquidacion_Liqperdes_Z() ;
      Z2411LiqPerHas = obj25.getgxTv_SdtLiquidacion_Liqperhas_Z() ;
      Z2426LiqTipoTarifa = obj25.getgxTv_SdtLiquidacion_Liqtipotarifa_Z() ;
      n32TLiqCod = (boolean)((obj25.getgxTv_SdtLiquidacion_Tliqcod_N()==0)?false:true) ;
      n268LiqClase = (boolean)((obj25.getgxTv_SdtLiquidacion_Liqclase_N()==0)?false:true) ;
      n2180LiqPDFEstado = (boolean)((obj25.getgxTv_SdtLiquidacion_Liqpdfestado_N()==0)?false:true) ;
      n33LiqDepBanCod = (boolean)((obj25.getgxTv_SdtLiquidacion_Liqdepbancod_N()==0)?false:true) ;
      n2112LiqRelNro = (boolean)((obj25.getgxTv_SdtLiquidacion_Liqrelnro_N()==0)?false:true) ;
      n2195LiqSac = (boolean)((obj25.getgxTv_SdtLiquidacion_Liqsac_N()==0)?false:true) ;
      n2196LiqSacLog = (boolean)((obj25.getgxTv_SdtLiquidacion_Liqsaclog_N()==0)?false:true) ;
      Gx_mode = obj25.getgxTv_SdtLiquidacion_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A31LiqNro = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0R25( ) ;
      scanKeyStart0R25( ) ;
      if ( RcdFound25 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000R42 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(40) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A2EmpNom = BC000R42_A2EmpNom[0] ;
         pr_default.close(40);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
      }
      zm0R25( -16) ;
      onLoadActions0R25( ) ;
      addRow0R25( ) ;
      scanKeyEnd0R25( ) ;
      if ( RcdFound25 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars25( bcLiquidacion, 0) ;
      scanKeyStart0R25( ) ;
      if ( RcdFound25 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000R43 */
         pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(41) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         A2EmpNom = BC000R43_A2EmpNom[0] ;
         pr_default.close(41);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z31LiqNro = A31LiqNro ;
      }
      zm0R25( -16) ;
      onLoadActions0R25( ) ;
      addRow0R25( ) ;
      scanKeyEnd0R25( ) ;
      if ( RcdFound25 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0R25( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0R25( ) ;
      }
      else
      {
         if ( RcdFound25 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A31LiqNro = Z31LiqNro ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update0R25( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0R25( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert0R25( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars25( bcLiquidacion, 1) ;
      saveImpl( ) ;
      VarsToRow25( bcLiquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars25( bcLiquidacion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0R25( ) ;
      afterTrn( ) ;
      VarsToRow25( bcLiquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         web.SdtLiquidacion auxBC = new web.SdtLiquidacion( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A31LiqNro);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcLiquidacion);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars25( bcLiquidacion, 1) ;
      updateImpl( ) ;
      VarsToRow25( bcLiquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars25( bcLiquidacion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0R25( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow25( bcLiquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars25( bcLiquidacion, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0R25( ) ;
      if ( RcdFound25 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A31LiqNro = Z31LiqNro ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A31LiqNro != Z31LiqNro ) )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "liquidacion_bc");
      VarsToRow25( bcLiquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcLiquidacion.getgxTv_SdtLiquidacion_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcLiquidacion.setgxTv_SdtLiquidacion_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtLiquidacion sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcLiquidacion )
      {
         bcLiquidacion = sdt ;
         if ( GXutil.strcmp(bcLiquidacion.getgxTv_SdtLiquidacion_Mode(), "") == 0 )
         {
            bcLiquidacion.setgxTv_SdtLiquidacion_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow25( bcLiquidacion) ;
         }
         else
         {
            RowToVars25( bcLiquidacion, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcLiquidacion.getgxTv_SdtLiquidacion_Mode(), "") == 0 )
         {
            bcLiquidacion.setgxTv_SdtLiquidacion_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars25( bcLiquidacion, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtLiquidacion getLiquidacion_BC( )
   {
      return bcLiquidacion ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV29Pgmname = "" ;
      AV10TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV11WebSession = httpContext.getWebSession();
      AV13TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV12Insert_TLiqCod = "" ;
      AV26Insert_LiqDepBanCod = "" ;
      AV27Insert_PeriodoLiq = GXutil.nullDate() ;
      Z271LiqDescrip = "" ;
      A271LiqDescrip = "" ;
      Z98LiqFecha = GXutil.nullDate() ;
      A98LiqFecha = GXutil.nullDate() ;
      Z283LiqPeriodo = GXutil.nullDate() ;
      A283LiqPeriodo = GXutil.nullDate() ;
      Z280LiqFecPago = GXutil.nullDate() ;
      A280LiqFecPago = GXutil.nullDate() ;
      Z2368TLiqDescAux = "" ;
      A2368TLiqDescAux = "" ;
      Z2180LiqPDFEstado = "" ;
      A2180LiqPDFEstado = "" ;
      Z496LiqImpNeto = DecimalUtil.ZERO ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      Z755LiqImpDescuentos = DecimalUtil.ZERO ;
      A755LiqImpDescuentos = DecimalUtil.ZERO ;
      Z756LiqImpRetenGan = DecimalUtil.ZERO ;
      A756LiqImpRetenGan = DecimalUtil.ZERO ;
      Z497LiqImpBruto = DecimalUtil.ZERO ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      Z511LiqFecCre = GXutil.nullDate() ;
      A511LiqFecCre = GXutil.nullDate() ;
      Z512LiqUsuCre = "" ;
      A512LiqUsuCre = "" ;
      Z513LiqPerSinDia = "" ;
      A513LiqPerSinDia = "" ;
      Z748LiqPerPalabra = "" ;
      A748LiqPerPalabra = "" ;
      Z580LiqDepPrvPer = "" ;
      A580LiqDepPrvPer = "" ;
      Z581LiqDepPrvFec = GXutil.nullDate() ;
      A581LiqDepPrvFec = GXutil.nullDate() ;
      Z587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      A587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      Z588LiqUsuMod = "" ;
      A588LiqUsuMod = "" ;
      Z719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      Z743LiqPisoGanancias = DecimalUtil.ZERO ;
      A743LiqPisoGanancias = DecimalUtil.ZERO ;
      Z744LiqPisGanSAC = DecimalUtil.ZERO ;
      A744LiqPisGanSAC = DecimalUtil.ZERO ;
      Z745LiqTopeDedInc = DecimalUtil.ZERO ;
      A745LiqTopeDedInc = DecimalUtil.ZERO ;
      Z746LiqPerUltNorm = GXutil.nullDate() ;
      A746LiqPerUltNorm = GXutil.nullDate() ;
      Z766LiqError = "" ;
      A766LiqError = "" ;
      Z1404LiqErrorAux = "" ;
      A1404LiqErrorAux = "" ;
      Z874LiqNombre = "" ;
      A874LiqNombre = "" ;
      Z881LiqLegajosTxt = "" ;
      A881LiqLegajosTxt = "" ;
      Z885LiqSegundos = DecimalUtil.ZERO ;
      A885LiqSegundos = DecimalUtil.ZERO ;
      Z963LiqRutaPDFTodosVertical = "" ;
      A963LiqRutaPDFTodosVertical = "" ;
      Z964LiqRutaPDFTodosHorizontal = "" ;
      A964LiqRutaPDFTodosHorizontal = "" ;
      Z965LiqRutaPDFTodosNombreVertical = "" ;
      A965LiqRutaPDFTodosNombreVertical = "" ;
      Z966LiqRutaPDFTodosNombreHorizonta = "" ;
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      Z2196LiqSacLog = "" ;
      A2196LiqSacLog = "" ;
      Z2409LiqModTra = "" ;
      A2409LiqModTra = "" ;
      Z2410LiqPerDes = GXutil.nullDate() ;
      A2410LiqPerDes = GXutil.nullDate() ;
      Z2411LiqPerHas = GXutil.nullDate() ;
      A2411LiqPerHas = GXutil.nullDate() ;
      Z2426LiqTipoTarifa = "" ;
      A2426LiqTipoTarifa = "" ;
      Z33LiqDepBanCod = "" ;
      A33LiqDepBanCod = "" ;
      Z32TLiqCod = "" ;
      A32TLiqCod = "" ;
      Z1729PeriodoLiq = GXutil.nullDate() ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      Z582LiqDepBanDescrip = "" ;
      A582LiqDepBanDescrip = "" ;
      Z2EmpNom = "" ;
      A2EmpNom = "" ;
      Z340TliqDesc = "" ;
      A340TliqDesc = "" ;
      Z1142LiqLog = "" ;
      A1142LiqLog = "" ;
      BC000R9_A31LiqNro = new int[1] ;
      BC000R9_A2EmpNom = new String[] {""} ;
      BC000R9_A271LiqDescrip = new String[] {""} ;
      BC000R9_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A585LiqPerAno = new short[1] ;
      BC000R9_A586LiqPerMes = new byte[1] ;
      BC000R9_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A340TliqDesc = new String[] {""} ;
      BC000R9_A2368TLiqDescAux = new String[] {""} ;
      BC000R9_A278LiqEstado = new byte[1] ;
      BC000R9_A2292LiqLSDDepEst = new byte[1] ;
      BC000R9_A1403LiqAuxEstado = new byte[1] ;
      BC000R9_A2293LiqContrEst = new byte[1] ;
      BC000R9_A268LiqClase = new byte[1] ;
      BC000R9_n268LiqClase = new boolean[] {false} ;
      BC000R9_A2180LiqPDFEstado = new String[] {""} ;
      BC000R9_n2180LiqPDFEstado = new boolean[] {false} ;
      BC000R9_A361LiqGenInter = new boolean[] {false} ;
      BC000R9_A494LiqContabilizada = new boolean[] {false} ;
      BC000R9_A495LiqCntLeg = new short[1] ;
      BC000R9_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R9_A755LiqImpDescuentos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R9_A756LiqImpRetenGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R9_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R9_A500LegEspecificos = new boolean[] {false} ;
      BC000R9_A511LiqFecCre = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A512LiqUsuCre = new String[] {""} ;
      BC000R9_A513LiqPerSinDia = new String[] {""} ;
      BC000R9_A748LiqPerPalabra = new String[] {""} ;
      BC000R9_A580LiqDepPrvPer = new String[] {""} ;
      BC000R9_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A582LiqDepBanDescrip = new String[] {""} ;
      BC000R9_A583LiqDepPerAno = new short[1] ;
      BC000R9_A584LiqDepPerMes = new byte[1] ;
      BC000R9_A587LiqFecMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A588LiqUsuMod = new String[] {""} ;
      BC000R9_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R9_A744LiqPisGanSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R9_A745LiqTopeDedInc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R9_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A766LiqError = new String[] {""} ;
      BC000R9_A1404LiqErrorAux = new String[] {""} ;
      BC000R9_A874LiqNombre = new String[] {""} ;
      BC000R9_A881LiqLegajosTxt = new String[] {""} ;
      BC000R9_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R9_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      BC000R9_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      BC000R9_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      BC000R9_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      BC000R9_A1142LiqLog = new String[] {""} ;
      BC000R9_A2195LiqSac = new boolean[] {false} ;
      BC000R9_n2195LiqSac = new boolean[] {false} ;
      BC000R9_A2196LiqSacLog = new String[] {""} ;
      BC000R9_n2196LiqSacLog = new boolean[] {false} ;
      BC000R9_A2298LiqCancel = new boolean[] {false} ;
      BC000R9_A2409LiqModTra = new String[] {""} ;
      BC000R9_A2414LiqFrecPag = new byte[1] ;
      BC000R9_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A2426LiqTipoTarifa = new String[] {""} ;
      BC000R9_A3CliCod = new int[1] ;
      BC000R9_A33LiqDepBanCod = new String[] {""} ;
      BC000R9_n33LiqDepBanCod = new boolean[] {false} ;
      BC000R9_A1EmpCod = new short[1] ;
      BC000R9_A32TLiqCod = new String[] {""} ;
      BC000R9_n32TLiqCod = new boolean[] {false} ;
      BC000R9_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R9_A2112LiqRelNro = new int[1] ;
      BC000R9_n2112LiqRelNro = new boolean[] {false} ;
      BC000R10_A582LiqDepBanDescrip = new String[] {""} ;
      BC000R11_A340TliqDesc = new String[] {""} ;
      BC000R12_A2EmpNom = new String[] {""} ;
      BC000R13_A3CliCod = new int[1] ;
      BC000R14_A3CliCod = new int[1] ;
      BC000R15_A3CliCod = new int[1] ;
      BC000R15_A1EmpCod = new short[1] ;
      BC000R15_A31LiqNro = new int[1] ;
      BC000R16_A31LiqNro = new int[1] ;
      BC000R16_A271LiqDescrip = new String[] {""} ;
      BC000R16_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A585LiqPerAno = new short[1] ;
      BC000R16_A586LiqPerMes = new byte[1] ;
      BC000R16_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A2368TLiqDescAux = new String[] {""} ;
      BC000R16_A278LiqEstado = new byte[1] ;
      BC000R16_A2292LiqLSDDepEst = new byte[1] ;
      BC000R16_A1403LiqAuxEstado = new byte[1] ;
      BC000R16_A2293LiqContrEst = new byte[1] ;
      BC000R16_A268LiqClase = new byte[1] ;
      BC000R16_n268LiqClase = new boolean[] {false} ;
      BC000R16_A2180LiqPDFEstado = new String[] {""} ;
      BC000R16_n2180LiqPDFEstado = new boolean[] {false} ;
      BC000R16_A361LiqGenInter = new boolean[] {false} ;
      BC000R16_A494LiqContabilizada = new boolean[] {false} ;
      BC000R16_A495LiqCntLeg = new short[1] ;
      BC000R16_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R16_A755LiqImpDescuentos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R16_A756LiqImpRetenGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R16_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R16_A500LegEspecificos = new boolean[] {false} ;
      BC000R16_A511LiqFecCre = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A512LiqUsuCre = new String[] {""} ;
      BC000R16_A513LiqPerSinDia = new String[] {""} ;
      BC000R16_A748LiqPerPalabra = new String[] {""} ;
      BC000R16_A580LiqDepPrvPer = new String[] {""} ;
      BC000R16_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A583LiqDepPerAno = new short[1] ;
      BC000R16_A584LiqDepPerMes = new byte[1] ;
      BC000R16_A587LiqFecMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A588LiqUsuMod = new String[] {""} ;
      BC000R16_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R16_A744LiqPisGanSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R16_A745LiqTopeDedInc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R16_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A766LiqError = new String[] {""} ;
      BC000R16_A1404LiqErrorAux = new String[] {""} ;
      BC000R16_A874LiqNombre = new String[] {""} ;
      BC000R16_A881LiqLegajosTxt = new String[] {""} ;
      BC000R16_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R16_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      BC000R16_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      BC000R16_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      BC000R16_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      BC000R16_A1142LiqLog = new String[] {""} ;
      BC000R16_A2195LiqSac = new boolean[] {false} ;
      BC000R16_n2195LiqSac = new boolean[] {false} ;
      BC000R16_A2196LiqSacLog = new String[] {""} ;
      BC000R16_n2196LiqSacLog = new boolean[] {false} ;
      BC000R16_A2298LiqCancel = new boolean[] {false} ;
      BC000R16_A2409LiqModTra = new String[] {""} ;
      BC000R16_A2414LiqFrecPag = new byte[1] ;
      BC000R16_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A2426LiqTipoTarifa = new String[] {""} ;
      BC000R16_A3CliCod = new int[1] ;
      BC000R16_A33LiqDepBanCod = new String[] {""} ;
      BC000R16_n33LiqDepBanCod = new boolean[] {false} ;
      BC000R16_A1EmpCod = new short[1] ;
      BC000R16_A32TLiqCod = new String[] {""} ;
      BC000R16_n32TLiqCod = new boolean[] {false} ;
      BC000R16_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R16_A2112LiqRelNro = new int[1] ;
      BC000R16_n2112LiqRelNro = new boolean[] {false} ;
      sMode25 = "" ;
      BC000R17_A31LiqNro = new int[1] ;
      BC000R17_A271LiqDescrip = new String[] {""} ;
      BC000R17_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A585LiqPerAno = new short[1] ;
      BC000R17_A586LiqPerMes = new byte[1] ;
      BC000R17_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A2368TLiqDescAux = new String[] {""} ;
      BC000R17_A278LiqEstado = new byte[1] ;
      BC000R17_A2292LiqLSDDepEst = new byte[1] ;
      BC000R17_A1403LiqAuxEstado = new byte[1] ;
      BC000R17_A2293LiqContrEst = new byte[1] ;
      BC000R17_A268LiqClase = new byte[1] ;
      BC000R17_n268LiqClase = new boolean[] {false} ;
      BC000R17_A2180LiqPDFEstado = new String[] {""} ;
      BC000R17_n2180LiqPDFEstado = new boolean[] {false} ;
      BC000R17_A361LiqGenInter = new boolean[] {false} ;
      BC000R17_A494LiqContabilizada = new boolean[] {false} ;
      BC000R17_A495LiqCntLeg = new short[1] ;
      BC000R17_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R17_A755LiqImpDescuentos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R17_A756LiqImpRetenGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R17_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R17_A500LegEspecificos = new boolean[] {false} ;
      BC000R17_A511LiqFecCre = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A512LiqUsuCre = new String[] {""} ;
      BC000R17_A513LiqPerSinDia = new String[] {""} ;
      BC000R17_A748LiqPerPalabra = new String[] {""} ;
      BC000R17_A580LiqDepPrvPer = new String[] {""} ;
      BC000R17_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A583LiqDepPerAno = new short[1] ;
      BC000R17_A584LiqDepPerMes = new byte[1] ;
      BC000R17_A587LiqFecMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A588LiqUsuMod = new String[] {""} ;
      BC000R17_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R17_A744LiqPisGanSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R17_A745LiqTopeDedInc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R17_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A766LiqError = new String[] {""} ;
      BC000R17_A1404LiqErrorAux = new String[] {""} ;
      BC000R17_A874LiqNombre = new String[] {""} ;
      BC000R17_A881LiqLegajosTxt = new String[] {""} ;
      BC000R17_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R17_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      BC000R17_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      BC000R17_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      BC000R17_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      BC000R17_A1142LiqLog = new String[] {""} ;
      BC000R17_A2195LiqSac = new boolean[] {false} ;
      BC000R17_n2195LiqSac = new boolean[] {false} ;
      BC000R17_A2196LiqSacLog = new String[] {""} ;
      BC000R17_n2196LiqSacLog = new boolean[] {false} ;
      BC000R17_A2298LiqCancel = new boolean[] {false} ;
      BC000R17_A2409LiqModTra = new String[] {""} ;
      BC000R17_A2414LiqFrecPag = new byte[1] ;
      BC000R17_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A2426LiqTipoTarifa = new String[] {""} ;
      BC000R17_A3CliCod = new int[1] ;
      BC000R17_A33LiqDepBanCod = new String[] {""} ;
      BC000R17_n33LiqDepBanCod = new boolean[] {false} ;
      BC000R17_A1EmpCod = new short[1] ;
      BC000R17_A32TLiqCod = new String[] {""} ;
      BC000R17_n32TLiqCod = new boolean[] {false} ;
      BC000R17_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R17_A2112LiqRelNro = new int[1] ;
      BC000R17_n2112LiqRelNro = new boolean[] {false} ;
      GXv_int5 = new int[1] ;
      GXv_int6 = new short[1] ;
      GXv_int7 = new int[1] ;
      BC000R21_A2EmpNom = new String[] {""} ;
      BC000R22_A340TliqDesc = new String[] {""} ;
      BC000R23_A582LiqDepBanDescrip = new String[] {""} ;
      BC000R24_A3CliCod = new int[1] ;
      BC000R24_A1EmpCod = new short[1] ;
      BC000R24_A2112LiqRelNro = new int[1] ;
      BC000R24_n2112LiqRelNro = new boolean[] {false} ;
      BC000R25_A3CliCod = new int[1] ;
      BC000R25_A1EmpCod = new short[1] ;
      BC000R25_A31LiqNro = new int[1] ;
      BC000R25_A2285LinkLegNumero = new int[1] ;
      BC000R25_A2277LegLinkTiporec = new String[] {""} ;
      BC000R26_A3CliCod = new int[1] ;
      BC000R26_A1EmpCod = new short[1] ;
      BC000R26_A6LegNumero = new int[1] ;
      BC000R26_A2243LegCuenLicTpo = new String[] {""} ;
      BC000R26_A2266LegCuenAnio = new short[1] ;
      BC000R26_A2310LegCuLConsAnio = new short[1] ;
      BC000R26_A2311LegCuLConsSec = new short[1] ;
      BC000R27_A3CliCod = new int[1] ;
      BC000R27_A1EmpCod = new short[1] ;
      BC000R27_A6LegNumero = new int[1] ;
      BC000R27_A2243LegCuenLicTpo = new String[] {""} ;
      BC000R27_A2266LegCuenAnio = new short[1] ;
      BC000R27_A2324LegCuLAprLicFch = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R28_A3CliCod = new int[1] ;
      BC000R28_A1EmpCod = new short[1] ;
      BC000R28_A6LegNumero = new int[1] ;
      BC000R28_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R29_A3CliCod = new int[1] ;
      BC000R29_A1EmpCod = new short[1] ;
      BC000R29_A31LiqNro = new int[1] ;
      BC000R29_A2183LiqSuc = new String[] {""} ;
      BC000R30_A3CliCod = new int[1] ;
      BC000R30_A1EmpCod = new short[1] ;
      BC000R30_A31LiqNro = new int[1] ;
      BC000R30_A2145LiqArea = new String[] {""} ;
      BC000R31_A3CliCod = new int[1] ;
      BC000R31_A1EmpCod = new short[1] ;
      BC000R31_A31LiqNro = new int[1] ;
      BC000R31_A2142LiqPaiConve = new short[1] ;
      BC000R31_A2143LiqConvenio = new String[] {""} ;
      BC000R32_A3CliCod = new int[1] ;
      BC000R32_A1EmpCod = new short[1] ;
      BC000R32_A1649LSDSec = new int[1] ;
      BC000R33_A3CliCod = new int[1] ;
      BC000R33_A1EmpCod = new short[1] ;
      BC000R33_A6LegNumero = new int[1] ;
      BC000R33_A1172OblSecuencial = new short[1] ;
      BC000R33_A1184LiqOblAltaNro = new int[1] ;
      BC000R33_A1185LiqOblNuevaNro = new int[1] ;
      BC000R34_A3CliCod = new int[1] ;
      BC000R34_A1EmpCod = new short[1] ;
      BC000R34_A6LegNumero = new int[1] ;
      BC000R34_A1172OblSecuencial = new short[1] ;
      BC000R34_A1184LiqOblAltaNro = new int[1] ;
      BC000R34_A1185LiqOblNuevaNro = new int[1] ;
      BC000R35_A3CliCod = new int[1] ;
      BC000R35_A1EmpCod = new short[1] ;
      BC000R35_A6LegNumero = new int[1] ;
      BC000R35_A1172OblSecuencial = new short[1] ;
      BC000R36_A3CliCod = new int[1] ;
      BC000R36_A1EmpCod = new short[1] ;
      BC000R36_A869LiqLegConAnio = new short[1] ;
      BC000R36_A6LegNumero = new int[1] ;
      BC000R36_A26ConCodigo = new String[] {""} ;
      BC000R36_A1097LiqAltaNro = new int[1] ;
      BC000R36_A1098LiqNuevaNro = new int[1] ;
      BC000R37_A3CliCod = new int[1] ;
      BC000R37_A1EmpCod = new short[1] ;
      BC000R37_A869LiqLegConAnio = new short[1] ;
      BC000R37_A6LegNumero = new int[1] ;
      BC000R37_A26ConCodigo = new String[] {""} ;
      BC000R37_A1097LiqAltaNro = new int[1] ;
      BC000R37_A1098LiqNuevaNro = new int[1] ;
      BC000R38_A3CliCod = new int[1] ;
      BC000R38_A1EmpCod = new short[1] ;
      BC000R38_A31LiqNro = new int[1] ;
      BC000R38_A10LpgCodigo = new String[] {""} ;
      BC000R39_A3CliCod = new int[1] ;
      BC000R39_A1EmpCod = new short[1] ;
      BC000R39_A31LiqNro = new int[1] ;
      BC000R39_A6LegNumero = new int[1] ;
      BC000R40_A3CliCod = new int[1] ;
      BC000R40_A1EmpCod = new short[1] ;
      BC000R40_A6LegNumero = new int[1] ;
      BC000R40_A25AgeOrden = new short[1] ;
      BC000R41_A31LiqNro = new int[1] ;
      BC000R41_A2EmpNom = new String[] {""} ;
      BC000R41_A271LiqDescrip = new String[] {""} ;
      BC000R41_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A585LiqPerAno = new short[1] ;
      BC000R41_A586LiqPerMes = new byte[1] ;
      BC000R41_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A340TliqDesc = new String[] {""} ;
      BC000R41_A2368TLiqDescAux = new String[] {""} ;
      BC000R41_A278LiqEstado = new byte[1] ;
      BC000R41_A2292LiqLSDDepEst = new byte[1] ;
      BC000R41_A1403LiqAuxEstado = new byte[1] ;
      BC000R41_A2293LiqContrEst = new byte[1] ;
      BC000R41_A268LiqClase = new byte[1] ;
      BC000R41_n268LiqClase = new boolean[] {false} ;
      BC000R41_A2180LiqPDFEstado = new String[] {""} ;
      BC000R41_n2180LiqPDFEstado = new boolean[] {false} ;
      BC000R41_A361LiqGenInter = new boolean[] {false} ;
      BC000R41_A494LiqContabilizada = new boolean[] {false} ;
      BC000R41_A495LiqCntLeg = new short[1] ;
      BC000R41_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R41_A755LiqImpDescuentos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R41_A756LiqImpRetenGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R41_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R41_A500LegEspecificos = new boolean[] {false} ;
      BC000R41_A511LiqFecCre = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A512LiqUsuCre = new String[] {""} ;
      BC000R41_A513LiqPerSinDia = new String[] {""} ;
      BC000R41_A748LiqPerPalabra = new String[] {""} ;
      BC000R41_A580LiqDepPrvPer = new String[] {""} ;
      BC000R41_A581LiqDepPrvFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A582LiqDepBanDescrip = new String[] {""} ;
      BC000R41_A583LiqDepPerAno = new short[1] ;
      BC000R41_A584LiqDepPerMes = new byte[1] ;
      BC000R41_A587LiqFecMod = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A588LiqUsuMod = new String[] {""} ;
      BC000R41_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R41_A744LiqPisGanSAC = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R41_A745LiqTopeDedInc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R41_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A766LiqError = new String[] {""} ;
      BC000R41_A1404LiqErrorAux = new String[] {""} ;
      BC000R41_A874LiqNombre = new String[] {""} ;
      BC000R41_A881LiqLegajosTxt = new String[] {""} ;
      BC000R41_A885LiqSegundos = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000R41_A963LiqRutaPDFTodosVertical = new String[] {""} ;
      BC000R41_A964LiqRutaPDFTodosHorizontal = new String[] {""} ;
      BC000R41_A965LiqRutaPDFTodosNombreVertical = new String[] {""} ;
      BC000R41_A966LiqRutaPDFTodosNombreHorizonta = new String[] {""} ;
      BC000R41_A1142LiqLog = new String[] {""} ;
      BC000R41_A2195LiqSac = new boolean[] {false} ;
      BC000R41_n2195LiqSac = new boolean[] {false} ;
      BC000R41_A2196LiqSacLog = new String[] {""} ;
      BC000R41_n2196LiqSacLog = new boolean[] {false} ;
      BC000R41_A2298LiqCancel = new boolean[] {false} ;
      BC000R41_A2409LiqModTra = new String[] {""} ;
      BC000R41_A2414LiqFrecPag = new byte[1] ;
      BC000R41_A2410LiqPerDes = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A2411LiqPerHas = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A2426LiqTipoTarifa = new String[] {""} ;
      BC000R41_A3CliCod = new int[1] ;
      BC000R41_A33LiqDepBanCod = new String[] {""} ;
      BC000R41_n33LiqDepBanCod = new boolean[] {false} ;
      BC000R41_A1EmpCod = new short[1] ;
      BC000R41_A32TLiqCod = new String[] {""} ;
      BC000R41_n32TLiqCod = new boolean[] {false} ;
      BC000R41_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      BC000R41_A2112LiqRelNro = new int[1] ;
      BC000R41_n2112LiqRelNro = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000R42_A2EmpNom = new String[] {""} ;
      BC000R43_A2EmpNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liquidacion_bc__default(),
         new Object[] {
             new Object[] {
            BC000R2_A31LiqNro, BC000R2_A271LiqDescrip, BC000R2_A98LiqFecha, BC000R2_A585LiqPerAno, BC000R2_A586LiqPerMes, BC000R2_A283LiqPeriodo, BC000R2_A280LiqFecPago, BC000R2_A2368TLiqDescAux, BC000R2_A278LiqEstado, BC000R2_A2292LiqLSDDepEst,
            BC000R2_A1403LiqAuxEstado, BC000R2_A2293LiqContrEst, BC000R2_A268LiqClase, BC000R2_n268LiqClase, BC000R2_A2180LiqPDFEstado, BC000R2_n2180LiqPDFEstado, BC000R2_A361LiqGenInter, BC000R2_A494LiqContabilizada, BC000R2_A495LiqCntLeg, BC000R2_A496LiqImpNeto,
            BC000R2_A755LiqImpDescuentos, BC000R2_A756LiqImpRetenGan, BC000R2_A497LiqImpBruto, BC000R2_A500LegEspecificos, BC000R2_A511LiqFecCre, BC000R2_A512LiqUsuCre, BC000R2_A513LiqPerSinDia, BC000R2_A748LiqPerPalabra, BC000R2_A580LiqDepPrvPer, BC000R2_A581LiqDepPrvFec,
            BC000R2_A583LiqDepPerAno, BC000R2_A584LiqDepPerMes, BC000R2_A587LiqFecMod, BC000R2_A588LiqUsuMod, BC000R2_A719LiqFecImp, BC000R2_A743LiqPisoGanancias, BC000R2_A744LiqPisGanSAC, BC000R2_A745LiqTopeDedInc, BC000R2_A746LiqPerUltNorm, BC000R2_A766LiqError,
            BC000R2_A1404LiqErrorAux, BC000R2_A874LiqNombre, BC000R2_A881LiqLegajosTxt, BC000R2_A885LiqSegundos, BC000R2_A963LiqRutaPDFTodosVertical, BC000R2_A964LiqRutaPDFTodosHorizontal, BC000R2_A965LiqRutaPDFTodosNombreVertical, BC000R2_A966LiqRutaPDFTodosNombreHorizonta, BC000R2_A1142LiqLog, BC000R2_A2195LiqSac,
            BC000R2_n2195LiqSac, BC000R2_A2196LiqSacLog, BC000R2_n2196LiqSacLog, BC000R2_A2298LiqCancel, BC000R2_A2409LiqModTra, BC000R2_A2414LiqFrecPag, BC000R2_A2410LiqPerDes, BC000R2_A2411LiqPerHas, BC000R2_A2426LiqTipoTarifa, BC000R2_A3CliCod,
            BC000R2_A33LiqDepBanCod, BC000R2_n33LiqDepBanCod, BC000R2_A1EmpCod, BC000R2_A32TLiqCod, BC000R2_n32TLiqCod, BC000R2_A1729PeriodoLiq, BC000R2_A2112LiqRelNro, BC000R2_n2112LiqRelNro
            }
            , new Object[] {
            BC000R3_A31LiqNro, BC000R3_A271LiqDescrip, BC000R3_A98LiqFecha, BC000R3_A585LiqPerAno, BC000R3_A586LiqPerMes, BC000R3_A283LiqPeriodo, BC000R3_A280LiqFecPago, BC000R3_A2368TLiqDescAux, BC000R3_A278LiqEstado, BC000R3_A2292LiqLSDDepEst,
            BC000R3_A1403LiqAuxEstado, BC000R3_A2293LiqContrEst, BC000R3_A268LiqClase, BC000R3_n268LiqClase, BC000R3_A2180LiqPDFEstado, BC000R3_n2180LiqPDFEstado, BC000R3_A361LiqGenInter, BC000R3_A494LiqContabilizada, BC000R3_A495LiqCntLeg, BC000R3_A496LiqImpNeto,
            BC000R3_A755LiqImpDescuentos, BC000R3_A756LiqImpRetenGan, BC000R3_A497LiqImpBruto, BC000R3_A500LegEspecificos, BC000R3_A511LiqFecCre, BC000R3_A512LiqUsuCre, BC000R3_A513LiqPerSinDia, BC000R3_A748LiqPerPalabra, BC000R3_A580LiqDepPrvPer, BC000R3_A581LiqDepPrvFec,
            BC000R3_A583LiqDepPerAno, BC000R3_A584LiqDepPerMes, BC000R3_A587LiqFecMod, BC000R3_A588LiqUsuMod, BC000R3_A719LiqFecImp, BC000R3_A743LiqPisoGanancias, BC000R3_A744LiqPisGanSAC, BC000R3_A745LiqTopeDedInc, BC000R3_A746LiqPerUltNorm, BC000R3_A766LiqError,
            BC000R3_A1404LiqErrorAux, BC000R3_A874LiqNombre, BC000R3_A881LiqLegajosTxt, BC000R3_A885LiqSegundos, BC000R3_A963LiqRutaPDFTodosVertical, BC000R3_A964LiqRutaPDFTodosHorizontal, BC000R3_A965LiqRutaPDFTodosNombreVertical, BC000R3_A966LiqRutaPDFTodosNombreHorizonta, BC000R3_A1142LiqLog, BC000R3_A2195LiqSac,
            BC000R3_n2195LiqSac, BC000R3_A2196LiqSacLog, BC000R3_n2196LiqSacLog, BC000R3_A2298LiqCancel, BC000R3_A2409LiqModTra, BC000R3_A2414LiqFrecPag, BC000R3_A2410LiqPerDes, BC000R3_A2411LiqPerHas, BC000R3_A2426LiqTipoTarifa, BC000R3_A3CliCod,
            BC000R3_A33LiqDepBanCod, BC000R3_n33LiqDepBanCod, BC000R3_A1EmpCod, BC000R3_A32TLiqCod, BC000R3_n32TLiqCod, BC000R3_A1729PeriodoLiq, BC000R3_A2112LiqRelNro, BC000R3_n2112LiqRelNro
            }
            , new Object[] {
            BC000R4_A582LiqDepBanDescrip
            }
            , new Object[] {
            BC000R5_A2EmpNom
            }
            , new Object[] {
            BC000R6_A340TliqDesc
            }
            , new Object[] {
            BC000R7_A3CliCod
            }
            , new Object[] {
            BC000R8_A3CliCod
            }
            , new Object[] {
            BC000R9_A31LiqNro, BC000R9_A2EmpNom, BC000R9_A271LiqDescrip, BC000R9_A98LiqFecha, BC000R9_A585LiqPerAno, BC000R9_A586LiqPerMes, BC000R9_A283LiqPeriodo, BC000R9_A280LiqFecPago, BC000R9_A340TliqDesc, BC000R9_A2368TLiqDescAux,
            BC000R9_A278LiqEstado, BC000R9_A2292LiqLSDDepEst, BC000R9_A1403LiqAuxEstado, BC000R9_A2293LiqContrEst, BC000R9_A268LiqClase, BC000R9_n268LiqClase, BC000R9_A2180LiqPDFEstado, BC000R9_n2180LiqPDFEstado, BC000R9_A361LiqGenInter, BC000R9_A494LiqContabilizada,
            BC000R9_A495LiqCntLeg, BC000R9_A496LiqImpNeto, BC000R9_A755LiqImpDescuentos, BC000R9_A756LiqImpRetenGan, BC000R9_A497LiqImpBruto, BC000R9_A500LegEspecificos, BC000R9_A511LiqFecCre, BC000R9_A512LiqUsuCre, BC000R9_A513LiqPerSinDia, BC000R9_A748LiqPerPalabra,
            BC000R9_A580LiqDepPrvPer, BC000R9_A581LiqDepPrvFec, BC000R9_A582LiqDepBanDescrip, BC000R9_A583LiqDepPerAno, BC000R9_A584LiqDepPerMes, BC000R9_A587LiqFecMod, BC000R9_A588LiqUsuMod, BC000R9_A719LiqFecImp, BC000R9_A743LiqPisoGanancias, BC000R9_A744LiqPisGanSAC,
            BC000R9_A745LiqTopeDedInc, BC000R9_A746LiqPerUltNorm, BC000R9_A766LiqError, BC000R9_A1404LiqErrorAux, BC000R9_A874LiqNombre, BC000R9_A881LiqLegajosTxt, BC000R9_A885LiqSegundos, BC000R9_A963LiqRutaPDFTodosVertical, BC000R9_A964LiqRutaPDFTodosHorizontal, BC000R9_A965LiqRutaPDFTodosNombreVertical,
            BC000R9_A966LiqRutaPDFTodosNombreHorizonta, BC000R9_A1142LiqLog, BC000R9_A2195LiqSac, BC000R9_n2195LiqSac, BC000R9_A2196LiqSacLog, BC000R9_n2196LiqSacLog, BC000R9_A2298LiqCancel, BC000R9_A2409LiqModTra, BC000R9_A2414LiqFrecPag, BC000R9_A2410LiqPerDes,
            BC000R9_A2411LiqPerHas, BC000R9_A2426LiqTipoTarifa, BC000R9_A3CliCod, BC000R9_A33LiqDepBanCod, BC000R9_n33LiqDepBanCod, BC000R9_A1EmpCod, BC000R9_A32TLiqCod, BC000R9_n32TLiqCod, BC000R9_A1729PeriodoLiq, BC000R9_A2112LiqRelNro,
            BC000R9_n2112LiqRelNro
            }
            , new Object[] {
            BC000R10_A582LiqDepBanDescrip
            }
            , new Object[] {
            BC000R11_A340TliqDesc
            }
            , new Object[] {
            BC000R12_A2EmpNom
            }
            , new Object[] {
            BC000R13_A3CliCod
            }
            , new Object[] {
            BC000R14_A3CliCod
            }
            , new Object[] {
            BC000R15_A3CliCod, BC000R15_A1EmpCod, BC000R15_A31LiqNro
            }
            , new Object[] {
            BC000R16_A31LiqNro, BC000R16_A271LiqDescrip, BC000R16_A98LiqFecha, BC000R16_A585LiqPerAno, BC000R16_A586LiqPerMes, BC000R16_A283LiqPeriodo, BC000R16_A280LiqFecPago, BC000R16_A2368TLiqDescAux, BC000R16_A278LiqEstado, BC000R16_A2292LiqLSDDepEst,
            BC000R16_A1403LiqAuxEstado, BC000R16_A2293LiqContrEst, BC000R16_A268LiqClase, BC000R16_n268LiqClase, BC000R16_A2180LiqPDFEstado, BC000R16_n2180LiqPDFEstado, BC000R16_A361LiqGenInter, BC000R16_A494LiqContabilizada, BC000R16_A495LiqCntLeg, BC000R16_A496LiqImpNeto,
            BC000R16_A755LiqImpDescuentos, BC000R16_A756LiqImpRetenGan, BC000R16_A497LiqImpBruto, BC000R16_A500LegEspecificos, BC000R16_A511LiqFecCre, BC000R16_A512LiqUsuCre, BC000R16_A513LiqPerSinDia, BC000R16_A748LiqPerPalabra, BC000R16_A580LiqDepPrvPer, BC000R16_A581LiqDepPrvFec,
            BC000R16_A583LiqDepPerAno, BC000R16_A584LiqDepPerMes, BC000R16_A587LiqFecMod, BC000R16_A588LiqUsuMod, BC000R16_A719LiqFecImp, BC000R16_A743LiqPisoGanancias, BC000R16_A744LiqPisGanSAC, BC000R16_A745LiqTopeDedInc, BC000R16_A746LiqPerUltNorm, BC000R16_A766LiqError,
            BC000R16_A1404LiqErrorAux, BC000R16_A874LiqNombre, BC000R16_A881LiqLegajosTxt, BC000R16_A885LiqSegundos, BC000R16_A963LiqRutaPDFTodosVertical, BC000R16_A964LiqRutaPDFTodosHorizontal, BC000R16_A965LiqRutaPDFTodosNombreVertical, BC000R16_A966LiqRutaPDFTodosNombreHorizonta, BC000R16_A1142LiqLog, BC000R16_A2195LiqSac,
            BC000R16_n2195LiqSac, BC000R16_A2196LiqSacLog, BC000R16_n2196LiqSacLog, BC000R16_A2298LiqCancel, BC000R16_A2409LiqModTra, BC000R16_A2414LiqFrecPag, BC000R16_A2410LiqPerDes, BC000R16_A2411LiqPerHas, BC000R16_A2426LiqTipoTarifa, BC000R16_A3CliCod,
            BC000R16_A33LiqDepBanCod, BC000R16_n33LiqDepBanCod, BC000R16_A1EmpCod, BC000R16_A32TLiqCod, BC000R16_n32TLiqCod, BC000R16_A1729PeriodoLiq, BC000R16_A2112LiqRelNro, BC000R16_n2112LiqRelNro
            }
            , new Object[] {
            BC000R17_A31LiqNro, BC000R17_A271LiqDescrip, BC000R17_A98LiqFecha, BC000R17_A585LiqPerAno, BC000R17_A586LiqPerMes, BC000R17_A283LiqPeriodo, BC000R17_A280LiqFecPago, BC000R17_A2368TLiqDescAux, BC000R17_A278LiqEstado, BC000R17_A2292LiqLSDDepEst,
            BC000R17_A1403LiqAuxEstado, BC000R17_A2293LiqContrEst, BC000R17_A268LiqClase, BC000R17_n268LiqClase, BC000R17_A2180LiqPDFEstado, BC000R17_n2180LiqPDFEstado, BC000R17_A361LiqGenInter, BC000R17_A494LiqContabilizada, BC000R17_A495LiqCntLeg, BC000R17_A496LiqImpNeto,
            BC000R17_A755LiqImpDescuentos, BC000R17_A756LiqImpRetenGan, BC000R17_A497LiqImpBruto, BC000R17_A500LegEspecificos, BC000R17_A511LiqFecCre, BC000R17_A512LiqUsuCre, BC000R17_A513LiqPerSinDia, BC000R17_A748LiqPerPalabra, BC000R17_A580LiqDepPrvPer, BC000R17_A581LiqDepPrvFec,
            BC000R17_A583LiqDepPerAno, BC000R17_A584LiqDepPerMes, BC000R17_A587LiqFecMod, BC000R17_A588LiqUsuMod, BC000R17_A719LiqFecImp, BC000R17_A743LiqPisoGanancias, BC000R17_A744LiqPisGanSAC, BC000R17_A745LiqTopeDedInc, BC000R17_A746LiqPerUltNorm, BC000R17_A766LiqError,
            BC000R17_A1404LiqErrorAux, BC000R17_A874LiqNombre, BC000R17_A881LiqLegajosTxt, BC000R17_A885LiqSegundos, BC000R17_A963LiqRutaPDFTodosVertical, BC000R17_A964LiqRutaPDFTodosHorizontal, BC000R17_A965LiqRutaPDFTodosNombreVertical, BC000R17_A966LiqRutaPDFTodosNombreHorizonta, BC000R17_A1142LiqLog, BC000R17_A2195LiqSac,
            BC000R17_n2195LiqSac, BC000R17_A2196LiqSacLog, BC000R17_n2196LiqSacLog, BC000R17_A2298LiqCancel, BC000R17_A2409LiqModTra, BC000R17_A2414LiqFrecPag, BC000R17_A2410LiqPerDes, BC000R17_A2411LiqPerHas, BC000R17_A2426LiqTipoTarifa, BC000R17_A3CliCod,
            BC000R17_A33LiqDepBanCod, BC000R17_n33LiqDepBanCod, BC000R17_A1EmpCod, BC000R17_A32TLiqCod, BC000R17_n32TLiqCod, BC000R17_A1729PeriodoLiq, BC000R17_A2112LiqRelNro, BC000R17_n2112LiqRelNro
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000R21_A2EmpNom
            }
            , new Object[] {
            BC000R22_A340TliqDesc
            }
            , new Object[] {
            BC000R23_A582LiqDepBanDescrip
            }
            , new Object[] {
            BC000R24_A3CliCod, BC000R24_A1EmpCod, BC000R24_A2112LiqRelNro
            }
            , new Object[] {
            BC000R25_A3CliCod, BC000R25_A1EmpCod, BC000R25_A31LiqNro, BC000R25_A2285LinkLegNumero, BC000R25_A2277LegLinkTiporec
            }
            , new Object[] {
            BC000R26_A3CliCod, BC000R26_A1EmpCod, BC000R26_A6LegNumero, BC000R26_A2243LegCuenLicTpo, BC000R26_A2266LegCuenAnio, BC000R26_A2310LegCuLConsAnio, BC000R26_A2311LegCuLConsSec
            }
            , new Object[] {
            BC000R27_A3CliCod, BC000R27_A1EmpCod, BC000R27_A6LegNumero, BC000R27_A2243LegCuenLicTpo, BC000R27_A2266LegCuenAnio, BC000R27_A2324LegCuLAprLicFch
            }
            , new Object[] {
            BC000R28_A3CliCod, BC000R28_A1EmpCod, BC000R28_A6LegNumero, BC000R28_A2253LegHisFecIng
            }
            , new Object[] {
            BC000R29_A3CliCod, BC000R29_A1EmpCod, BC000R29_A31LiqNro, BC000R29_A2183LiqSuc
            }
            , new Object[] {
            BC000R30_A3CliCod, BC000R30_A1EmpCod, BC000R30_A31LiqNro, BC000R30_A2145LiqArea
            }
            , new Object[] {
            BC000R31_A3CliCod, BC000R31_A1EmpCod, BC000R31_A31LiqNro, BC000R31_A2142LiqPaiConve, BC000R31_A2143LiqConvenio
            }
            , new Object[] {
            BC000R32_A3CliCod, BC000R32_A1EmpCod, BC000R32_A1649LSDSec
            }
            , new Object[] {
            BC000R33_A3CliCod, BC000R33_A1EmpCod, BC000R33_A6LegNumero, BC000R33_A1172OblSecuencial, BC000R33_A1184LiqOblAltaNro, BC000R33_A1185LiqOblNuevaNro
            }
            , new Object[] {
            BC000R34_A3CliCod, BC000R34_A1EmpCod, BC000R34_A6LegNumero, BC000R34_A1172OblSecuencial, BC000R34_A1184LiqOblAltaNro, BC000R34_A1185LiqOblNuevaNro
            }
            , new Object[] {
            BC000R35_A3CliCod, BC000R35_A1EmpCod, BC000R35_A6LegNumero, BC000R35_A1172OblSecuencial
            }
            , new Object[] {
            BC000R36_A3CliCod, BC000R36_A1EmpCod, BC000R36_A869LiqLegConAnio, BC000R36_A6LegNumero, BC000R36_A26ConCodigo, BC000R36_A1097LiqAltaNro, BC000R36_A1098LiqNuevaNro
            }
            , new Object[] {
            BC000R37_A3CliCod, BC000R37_A1EmpCod, BC000R37_A869LiqLegConAnio, BC000R37_A6LegNumero, BC000R37_A26ConCodigo, BC000R37_A1097LiqAltaNro, BC000R37_A1098LiqNuevaNro
            }
            , new Object[] {
            BC000R38_A3CliCod, BC000R38_A1EmpCod, BC000R38_A31LiqNro, BC000R38_A10LpgCodigo
            }
            , new Object[] {
            BC000R39_A3CliCod, BC000R39_A1EmpCod, BC000R39_A31LiqNro, BC000R39_A6LegNumero
            }
            , new Object[] {
            BC000R40_A3CliCod, BC000R40_A1EmpCod, BC000R40_A6LegNumero, BC000R40_A25AgeOrden
            }
            , new Object[] {
            BC000R41_A31LiqNro, BC000R41_A2EmpNom, BC000R41_A271LiqDescrip, BC000R41_A98LiqFecha, BC000R41_A585LiqPerAno, BC000R41_A586LiqPerMes, BC000R41_A283LiqPeriodo, BC000R41_A280LiqFecPago, BC000R41_A340TliqDesc, BC000R41_A2368TLiqDescAux,
            BC000R41_A278LiqEstado, BC000R41_A2292LiqLSDDepEst, BC000R41_A1403LiqAuxEstado, BC000R41_A2293LiqContrEst, BC000R41_A268LiqClase, BC000R41_n268LiqClase, BC000R41_A2180LiqPDFEstado, BC000R41_n2180LiqPDFEstado, BC000R41_A361LiqGenInter, BC000R41_A494LiqContabilizada,
            BC000R41_A495LiqCntLeg, BC000R41_A496LiqImpNeto, BC000R41_A755LiqImpDescuentos, BC000R41_A756LiqImpRetenGan, BC000R41_A497LiqImpBruto, BC000R41_A500LegEspecificos, BC000R41_A511LiqFecCre, BC000R41_A512LiqUsuCre, BC000R41_A513LiqPerSinDia, BC000R41_A748LiqPerPalabra,
            BC000R41_A580LiqDepPrvPer, BC000R41_A581LiqDepPrvFec, BC000R41_A582LiqDepBanDescrip, BC000R41_A583LiqDepPerAno, BC000R41_A584LiqDepPerMes, BC000R41_A587LiqFecMod, BC000R41_A588LiqUsuMod, BC000R41_A719LiqFecImp, BC000R41_A743LiqPisoGanancias, BC000R41_A744LiqPisGanSAC,
            BC000R41_A745LiqTopeDedInc, BC000R41_A746LiqPerUltNorm, BC000R41_A766LiqError, BC000R41_A1404LiqErrorAux, BC000R41_A874LiqNombre, BC000R41_A881LiqLegajosTxt, BC000R41_A885LiqSegundos, BC000R41_A963LiqRutaPDFTodosVertical, BC000R41_A964LiqRutaPDFTodosHorizontal, BC000R41_A965LiqRutaPDFTodosNombreVertical,
            BC000R41_A966LiqRutaPDFTodosNombreHorizonta, BC000R41_A1142LiqLog, BC000R41_A2195LiqSac, BC000R41_n2195LiqSac, BC000R41_A2196LiqSacLog, BC000R41_n2196LiqSacLog, BC000R41_A2298LiqCancel, BC000R41_A2409LiqModTra, BC000R41_A2414LiqFrecPag, BC000R41_A2410LiqPerDes,
            BC000R41_A2411LiqPerHas, BC000R41_A2426LiqTipoTarifa, BC000R41_A3CliCod, BC000R41_A33LiqDepBanCod, BC000R41_n33LiqDepBanCod, BC000R41_A1EmpCod, BC000R41_A32TLiqCod, BC000R41_n32TLiqCod, BC000R41_A1729PeriodoLiq, BC000R41_A2112LiqRelNro,
            BC000R41_n2112LiqRelNro
            }
            , new Object[] {
            BC000R42_A2EmpNom
            }
            , new Object[] {
            BC000R43_A2EmpNom
            }
         }
      );
      AV29Pgmname = "Liquidacion_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120R2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z586LiqPerMes ;
   private byte A586LiqPerMes ;
   private byte Z278LiqEstado ;
   private byte A278LiqEstado ;
   private byte Z2292LiqLSDDepEst ;
   private byte A2292LiqLSDDepEst ;
   private byte Z1403LiqAuxEstado ;
   private byte A1403LiqAuxEstado ;
   private byte Z2293LiqContrEst ;
   private byte A2293LiqContrEst ;
   private byte Z268LiqClase ;
   private byte A268LiqClase ;
   private byte Z584LiqDepPerMes ;
   private byte A584LiqDepPerMes ;
   private byte Z2414LiqFrecPag ;
   private byte A2414LiqFrecPag ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z585LiqPerAno ;
   private short A585LiqPerAno ;
   private short Z495LiqCntLeg ;
   private short A495LiqCntLeg ;
   private short Z583LiqDepPerAno ;
   private short A583LiqDepPerAno ;
   private short RcdFound25 ;
   private short nIsDirty_25 ;
   private short GXv_int6[] ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z31LiqNro ;
   private int A31LiqNro ;
   private int AV30GXV1 ;
   private int AV28Insert_LiqRelNro ;
   private int GX_JID ;
   private int Z2112LiqRelNro ;
   private int A2112LiqRelNro ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private int GXv_int7[] ;
   private java.math.BigDecimal Z496LiqImpNeto ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private java.math.BigDecimal Z755LiqImpDescuentos ;
   private java.math.BigDecimal A755LiqImpDescuentos ;
   private java.math.BigDecimal Z756LiqImpRetenGan ;
   private java.math.BigDecimal A756LiqImpRetenGan ;
   private java.math.BigDecimal Z497LiqImpBruto ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal Z743LiqPisoGanancias ;
   private java.math.BigDecimal A743LiqPisoGanancias ;
   private java.math.BigDecimal Z744LiqPisGanSAC ;
   private java.math.BigDecimal A744LiqPisGanSAC ;
   private java.math.BigDecimal Z745LiqTopeDedInc ;
   private java.math.BigDecimal A745LiqTopeDedInc ;
   private java.math.BigDecimal Z885LiqSegundos ;
   private java.math.BigDecimal A885LiqSegundos ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV29Pgmname ;
   private String AV12Insert_TLiqCod ;
   private String AV26Insert_LiqDepBanCod ;
   private String Z2180LiqPDFEstado ;
   private String A2180LiqPDFEstado ;
   private String Z513LiqPerSinDia ;
   private String A513LiqPerSinDia ;
   private String Z748LiqPerPalabra ;
   private String A748LiqPerPalabra ;
   private String Z580LiqDepPrvPer ;
   private String A580LiqDepPrvPer ;
   private String Z965LiqRutaPDFTodosNombreVertical ;
   private String A965LiqRutaPDFTodosNombreVertical ;
   private String Z966LiqRutaPDFTodosNombreHorizonta ;
   private String A966LiqRutaPDFTodosNombreHorizonta ;
   private String Z2409LiqModTra ;
   private String A2409LiqModTra ;
   private String Z2426LiqTipoTarifa ;
   private String A2426LiqTipoTarifa ;
   private String Z33LiqDepBanCod ;
   private String A33LiqDepBanCod ;
   private String Z32TLiqCod ;
   private String A32TLiqCod ;
   private String sMode25 ;
   private java.util.Date Z587LiqFecMod ;
   private java.util.Date A587LiqFecMod ;
   private java.util.Date Z719LiqFecImp ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date AV27Insert_PeriodoLiq ;
   private java.util.Date Z98LiqFecha ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date Z283LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date Z280LiqFecPago ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date Z511LiqFecCre ;
   private java.util.Date A511LiqFecCre ;
   private java.util.Date Z581LiqDepPrvFec ;
   private java.util.Date A581LiqDepPrvFec ;
   private java.util.Date Z746LiqPerUltNorm ;
   private java.util.Date A746LiqPerUltNorm ;
   private java.util.Date Z2410LiqPerDes ;
   private java.util.Date A2410LiqPerDes ;
   private java.util.Date Z2411LiqPerHas ;
   private java.util.Date A2411LiqPerHas ;
   private java.util.Date Z1729PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean returnInSub ;
   private boolean AV24IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z361LiqGenInter ;
   private boolean A361LiqGenInter ;
   private boolean Z494LiqContabilizada ;
   private boolean A494LiqContabilizada ;
   private boolean Z500LegEspecificos ;
   private boolean A500LegEspecificos ;
   private boolean Z2195LiqSac ;
   private boolean A2195LiqSac ;
   private boolean Z2298LiqCancel ;
   private boolean A2298LiqCancel ;
   private boolean n268LiqClase ;
   private boolean n2180LiqPDFEstado ;
   private boolean n2195LiqSac ;
   private boolean n2196LiqSacLog ;
   private boolean n33LiqDepBanCod ;
   private boolean n32TLiqCod ;
   private boolean n2112LiqRelNro ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z1142LiqLog ;
   private String A1142LiqLog ;
   private String Z271LiqDescrip ;
   private String A271LiqDescrip ;
   private String Z2368TLiqDescAux ;
   private String A2368TLiqDescAux ;
   private String Z512LiqUsuCre ;
   private String A512LiqUsuCre ;
   private String Z588LiqUsuMod ;
   private String A588LiqUsuMod ;
   private String Z766LiqError ;
   private String A766LiqError ;
   private String Z1404LiqErrorAux ;
   private String A1404LiqErrorAux ;
   private String Z874LiqNombre ;
   private String A874LiqNombre ;
   private String Z881LiqLegajosTxt ;
   private String A881LiqLegajosTxt ;
   private String Z963LiqRutaPDFTodosVertical ;
   private String A963LiqRutaPDFTodosVertical ;
   private String Z964LiqRutaPDFTodosHorizontal ;
   private String A964LiqRutaPDFTodosHorizontal ;
   private String Z2196LiqSacLog ;
   private String A2196LiqSacLog ;
   private String Z582LiqDepBanDescrip ;
   private String A582LiqDepBanDescrip ;
   private String Z2EmpNom ;
   private String A2EmpNom ;
   private String Z340TliqDesc ;
   private String A340TliqDesc ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV11WebSession ;
   private web.SdtLiquidacion bcLiquidacion ;
   private IDataStoreProvider pr_default ;
   private int[] BC000R9_A31LiqNro ;
   private String[] BC000R9_A2EmpNom ;
   private String[] BC000R9_A271LiqDescrip ;
   private java.util.Date[] BC000R9_A98LiqFecha ;
   private short[] BC000R9_A585LiqPerAno ;
   private byte[] BC000R9_A586LiqPerMes ;
   private java.util.Date[] BC000R9_A283LiqPeriodo ;
   private java.util.Date[] BC000R9_A280LiqFecPago ;
   private String[] BC000R9_A340TliqDesc ;
   private String[] BC000R9_A2368TLiqDescAux ;
   private byte[] BC000R9_A278LiqEstado ;
   private byte[] BC000R9_A2292LiqLSDDepEst ;
   private byte[] BC000R9_A1403LiqAuxEstado ;
   private byte[] BC000R9_A2293LiqContrEst ;
   private byte[] BC000R9_A268LiqClase ;
   private boolean[] BC000R9_n268LiqClase ;
   private String[] BC000R9_A2180LiqPDFEstado ;
   private boolean[] BC000R9_n2180LiqPDFEstado ;
   private boolean[] BC000R9_A361LiqGenInter ;
   private boolean[] BC000R9_A494LiqContabilizada ;
   private short[] BC000R9_A495LiqCntLeg ;
   private java.math.BigDecimal[] BC000R9_A496LiqImpNeto ;
   private java.math.BigDecimal[] BC000R9_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] BC000R9_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] BC000R9_A497LiqImpBruto ;
   private boolean[] BC000R9_A500LegEspecificos ;
   private java.util.Date[] BC000R9_A511LiqFecCre ;
   private String[] BC000R9_A512LiqUsuCre ;
   private String[] BC000R9_A513LiqPerSinDia ;
   private String[] BC000R9_A748LiqPerPalabra ;
   private String[] BC000R9_A580LiqDepPrvPer ;
   private java.util.Date[] BC000R9_A581LiqDepPrvFec ;
   private String[] BC000R9_A582LiqDepBanDescrip ;
   private short[] BC000R9_A583LiqDepPerAno ;
   private byte[] BC000R9_A584LiqDepPerMes ;
   private java.util.Date[] BC000R9_A587LiqFecMod ;
   private String[] BC000R9_A588LiqUsuMod ;
   private java.util.Date[] BC000R9_A719LiqFecImp ;
   private java.math.BigDecimal[] BC000R9_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] BC000R9_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] BC000R9_A745LiqTopeDedInc ;
   private java.util.Date[] BC000R9_A746LiqPerUltNorm ;
   private String[] BC000R9_A766LiqError ;
   private String[] BC000R9_A1404LiqErrorAux ;
   private String[] BC000R9_A874LiqNombre ;
   private String[] BC000R9_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] BC000R9_A885LiqSegundos ;
   private String[] BC000R9_A963LiqRutaPDFTodosVertical ;
   private String[] BC000R9_A964LiqRutaPDFTodosHorizontal ;
   private String[] BC000R9_A965LiqRutaPDFTodosNombreVertical ;
   private String[] BC000R9_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] BC000R9_A1142LiqLog ;
   private boolean[] BC000R9_A2195LiqSac ;
   private boolean[] BC000R9_n2195LiqSac ;
   private String[] BC000R9_A2196LiqSacLog ;
   private boolean[] BC000R9_n2196LiqSacLog ;
   private boolean[] BC000R9_A2298LiqCancel ;
   private String[] BC000R9_A2409LiqModTra ;
   private byte[] BC000R9_A2414LiqFrecPag ;
   private java.util.Date[] BC000R9_A2410LiqPerDes ;
   private java.util.Date[] BC000R9_A2411LiqPerHas ;
   private String[] BC000R9_A2426LiqTipoTarifa ;
   private int[] BC000R9_A3CliCod ;
   private String[] BC000R9_A33LiqDepBanCod ;
   private boolean[] BC000R9_n33LiqDepBanCod ;
   private short[] BC000R9_A1EmpCod ;
   private String[] BC000R9_A32TLiqCod ;
   private boolean[] BC000R9_n32TLiqCod ;
   private java.util.Date[] BC000R9_A1729PeriodoLiq ;
   private int[] BC000R9_A2112LiqRelNro ;
   private boolean[] BC000R9_n2112LiqRelNro ;
   private String[] BC000R10_A582LiqDepBanDescrip ;
   private String[] BC000R11_A340TliqDesc ;
   private String[] BC000R12_A2EmpNom ;
   private int[] BC000R13_A3CliCod ;
   private int[] BC000R14_A3CliCod ;
   private int[] BC000R15_A3CliCod ;
   private short[] BC000R15_A1EmpCod ;
   private int[] BC000R15_A31LiqNro ;
   private int[] BC000R16_A31LiqNro ;
   private String[] BC000R16_A271LiqDescrip ;
   private java.util.Date[] BC000R16_A98LiqFecha ;
   private short[] BC000R16_A585LiqPerAno ;
   private byte[] BC000R16_A586LiqPerMes ;
   private java.util.Date[] BC000R16_A283LiqPeriodo ;
   private java.util.Date[] BC000R16_A280LiqFecPago ;
   private String[] BC000R16_A2368TLiqDescAux ;
   private byte[] BC000R16_A278LiqEstado ;
   private byte[] BC000R16_A2292LiqLSDDepEst ;
   private byte[] BC000R16_A1403LiqAuxEstado ;
   private byte[] BC000R16_A2293LiqContrEst ;
   private byte[] BC000R16_A268LiqClase ;
   private boolean[] BC000R16_n268LiqClase ;
   private String[] BC000R16_A2180LiqPDFEstado ;
   private boolean[] BC000R16_n2180LiqPDFEstado ;
   private boolean[] BC000R16_A361LiqGenInter ;
   private boolean[] BC000R16_A494LiqContabilizada ;
   private short[] BC000R16_A495LiqCntLeg ;
   private java.math.BigDecimal[] BC000R16_A496LiqImpNeto ;
   private java.math.BigDecimal[] BC000R16_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] BC000R16_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] BC000R16_A497LiqImpBruto ;
   private boolean[] BC000R16_A500LegEspecificos ;
   private java.util.Date[] BC000R16_A511LiqFecCre ;
   private String[] BC000R16_A512LiqUsuCre ;
   private String[] BC000R16_A513LiqPerSinDia ;
   private String[] BC000R16_A748LiqPerPalabra ;
   private String[] BC000R16_A580LiqDepPrvPer ;
   private java.util.Date[] BC000R16_A581LiqDepPrvFec ;
   private short[] BC000R16_A583LiqDepPerAno ;
   private byte[] BC000R16_A584LiqDepPerMes ;
   private java.util.Date[] BC000R16_A587LiqFecMod ;
   private String[] BC000R16_A588LiqUsuMod ;
   private java.util.Date[] BC000R16_A719LiqFecImp ;
   private java.math.BigDecimal[] BC000R16_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] BC000R16_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] BC000R16_A745LiqTopeDedInc ;
   private java.util.Date[] BC000R16_A746LiqPerUltNorm ;
   private String[] BC000R16_A766LiqError ;
   private String[] BC000R16_A1404LiqErrorAux ;
   private String[] BC000R16_A874LiqNombre ;
   private String[] BC000R16_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] BC000R16_A885LiqSegundos ;
   private String[] BC000R16_A963LiqRutaPDFTodosVertical ;
   private String[] BC000R16_A964LiqRutaPDFTodosHorizontal ;
   private String[] BC000R16_A965LiqRutaPDFTodosNombreVertical ;
   private String[] BC000R16_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] BC000R16_A1142LiqLog ;
   private boolean[] BC000R16_A2195LiqSac ;
   private boolean[] BC000R16_n2195LiqSac ;
   private String[] BC000R16_A2196LiqSacLog ;
   private boolean[] BC000R16_n2196LiqSacLog ;
   private boolean[] BC000R16_A2298LiqCancel ;
   private String[] BC000R16_A2409LiqModTra ;
   private byte[] BC000R16_A2414LiqFrecPag ;
   private java.util.Date[] BC000R16_A2410LiqPerDes ;
   private java.util.Date[] BC000R16_A2411LiqPerHas ;
   private String[] BC000R16_A2426LiqTipoTarifa ;
   private int[] BC000R16_A3CliCod ;
   private String[] BC000R16_A33LiqDepBanCod ;
   private boolean[] BC000R16_n33LiqDepBanCod ;
   private short[] BC000R16_A1EmpCod ;
   private String[] BC000R16_A32TLiqCod ;
   private boolean[] BC000R16_n32TLiqCod ;
   private java.util.Date[] BC000R16_A1729PeriodoLiq ;
   private int[] BC000R16_A2112LiqRelNro ;
   private boolean[] BC000R16_n2112LiqRelNro ;
   private int[] BC000R17_A31LiqNro ;
   private String[] BC000R17_A271LiqDescrip ;
   private java.util.Date[] BC000R17_A98LiqFecha ;
   private short[] BC000R17_A585LiqPerAno ;
   private byte[] BC000R17_A586LiqPerMes ;
   private java.util.Date[] BC000R17_A283LiqPeriodo ;
   private java.util.Date[] BC000R17_A280LiqFecPago ;
   private String[] BC000R17_A2368TLiqDescAux ;
   private byte[] BC000R17_A278LiqEstado ;
   private byte[] BC000R17_A2292LiqLSDDepEst ;
   private byte[] BC000R17_A1403LiqAuxEstado ;
   private byte[] BC000R17_A2293LiqContrEst ;
   private byte[] BC000R17_A268LiqClase ;
   private boolean[] BC000R17_n268LiqClase ;
   private String[] BC000R17_A2180LiqPDFEstado ;
   private boolean[] BC000R17_n2180LiqPDFEstado ;
   private boolean[] BC000R17_A361LiqGenInter ;
   private boolean[] BC000R17_A494LiqContabilizada ;
   private short[] BC000R17_A495LiqCntLeg ;
   private java.math.BigDecimal[] BC000R17_A496LiqImpNeto ;
   private java.math.BigDecimal[] BC000R17_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] BC000R17_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] BC000R17_A497LiqImpBruto ;
   private boolean[] BC000R17_A500LegEspecificos ;
   private java.util.Date[] BC000R17_A511LiqFecCre ;
   private String[] BC000R17_A512LiqUsuCre ;
   private String[] BC000R17_A513LiqPerSinDia ;
   private String[] BC000R17_A748LiqPerPalabra ;
   private String[] BC000R17_A580LiqDepPrvPer ;
   private java.util.Date[] BC000R17_A581LiqDepPrvFec ;
   private short[] BC000R17_A583LiqDepPerAno ;
   private byte[] BC000R17_A584LiqDepPerMes ;
   private java.util.Date[] BC000R17_A587LiqFecMod ;
   private String[] BC000R17_A588LiqUsuMod ;
   private java.util.Date[] BC000R17_A719LiqFecImp ;
   private java.math.BigDecimal[] BC000R17_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] BC000R17_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] BC000R17_A745LiqTopeDedInc ;
   private java.util.Date[] BC000R17_A746LiqPerUltNorm ;
   private String[] BC000R17_A766LiqError ;
   private String[] BC000R17_A1404LiqErrorAux ;
   private String[] BC000R17_A874LiqNombre ;
   private String[] BC000R17_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] BC000R17_A885LiqSegundos ;
   private String[] BC000R17_A963LiqRutaPDFTodosVertical ;
   private String[] BC000R17_A964LiqRutaPDFTodosHorizontal ;
   private String[] BC000R17_A965LiqRutaPDFTodosNombreVertical ;
   private String[] BC000R17_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] BC000R17_A1142LiqLog ;
   private boolean[] BC000R17_A2195LiqSac ;
   private boolean[] BC000R17_n2195LiqSac ;
   private String[] BC000R17_A2196LiqSacLog ;
   private boolean[] BC000R17_n2196LiqSacLog ;
   private boolean[] BC000R17_A2298LiqCancel ;
   private String[] BC000R17_A2409LiqModTra ;
   private byte[] BC000R17_A2414LiqFrecPag ;
   private java.util.Date[] BC000R17_A2410LiqPerDes ;
   private java.util.Date[] BC000R17_A2411LiqPerHas ;
   private String[] BC000R17_A2426LiqTipoTarifa ;
   private int[] BC000R17_A3CliCod ;
   private String[] BC000R17_A33LiqDepBanCod ;
   private boolean[] BC000R17_n33LiqDepBanCod ;
   private short[] BC000R17_A1EmpCod ;
   private String[] BC000R17_A32TLiqCod ;
   private boolean[] BC000R17_n32TLiqCod ;
   private java.util.Date[] BC000R17_A1729PeriodoLiq ;
   private int[] BC000R17_A2112LiqRelNro ;
   private boolean[] BC000R17_n2112LiqRelNro ;
   private String[] BC000R21_A2EmpNom ;
   private String[] BC000R22_A340TliqDesc ;
   private String[] BC000R23_A582LiqDepBanDescrip ;
   private int[] BC000R24_A3CliCod ;
   private short[] BC000R24_A1EmpCod ;
   private int[] BC000R24_A2112LiqRelNro ;
   private boolean[] BC000R24_n2112LiqRelNro ;
   private int[] BC000R25_A3CliCod ;
   private short[] BC000R25_A1EmpCod ;
   private int[] BC000R25_A31LiqNro ;
   private int[] BC000R25_A2285LinkLegNumero ;
   private String[] BC000R25_A2277LegLinkTiporec ;
   private int[] BC000R26_A3CliCod ;
   private short[] BC000R26_A1EmpCod ;
   private int[] BC000R26_A6LegNumero ;
   private String[] BC000R26_A2243LegCuenLicTpo ;
   private short[] BC000R26_A2266LegCuenAnio ;
   private short[] BC000R26_A2310LegCuLConsAnio ;
   private short[] BC000R26_A2311LegCuLConsSec ;
   private int[] BC000R27_A3CliCod ;
   private short[] BC000R27_A1EmpCod ;
   private int[] BC000R27_A6LegNumero ;
   private String[] BC000R27_A2243LegCuenLicTpo ;
   private short[] BC000R27_A2266LegCuenAnio ;
   private java.util.Date[] BC000R27_A2324LegCuLAprLicFch ;
   private int[] BC000R28_A3CliCod ;
   private short[] BC000R28_A1EmpCod ;
   private int[] BC000R28_A6LegNumero ;
   private java.util.Date[] BC000R28_A2253LegHisFecIng ;
   private int[] BC000R29_A3CliCod ;
   private short[] BC000R29_A1EmpCod ;
   private int[] BC000R29_A31LiqNro ;
   private String[] BC000R29_A2183LiqSuc ;
   private int[] BC000R30_A3CliCod ;
   private short[] BC000R30_A1EmpCod ;
   private int[] BC000R30_A31LiqNro ;
   private String[] BC000R30_A2145LiqArea ;
   private int[] BC000R31_A3CliCod ;
   private short[] BC000R31_A1EmpCod ;
   private int[] BC000R31_A31LiqNro ;
   private short[] BC000R31_A2142LiqPaiConve ;
   private String[] BC000R31_A2143LiqConvenio ;
   private int[] BC000R32_A3CliCod ;
   private short[] BC000R32_A1EmpCod ;
   private int[] BC000R32_A1649LSDSec ;
   private int[] BC000R33_A3CliCod ;
   private short[] BC000R33_A1EmpCod ;
   private int[] BC000R33_A6LegNumero ;
   private short[] BC000R33_A1172OblSecuencial ;
   private int[] BC000R33_A1184LiqOblAltaNro ;
   private int[] BC000R33_A1185LiqOblNuevaNro ;
   private int[] BC000R34_A3CliCod ;
   private short[] BC000R34_A1EmpCod ;
   private int[] BC000R34_A6LegNumero ;
   private short[] BC000R34_A1172OblSecuencial ;
   private int[] BC000R34_A1184LiqOblAltaNro ;
   private int[] BC000R34_A1185LiqOblNuevaNro ;
   private int[] BC000R35_A3CliCod ;
   private short[] BC000R35_A1EmpCod ;
   private int[] BC000R35_A6LegNumero ;
   private short[] BC000R35_A1172OblSecuencial ;
   private int[] BC000R36_A3CliCod ;
   private short[] BC000R36_A1EmpCod ;
   private short[] BC000R36_A869LiqLegConAnio ;
   private int[] BC000R36_A6LegNumero ;
   private String[] BC000R36_A26ConCodigo ;
   private int[] BC000R36_A1097LiqAltaNro ;
   private int[] BC000R36_A1098LiqNuevaNro ;
   private int[] BC000R37_A3CliCod ;
   private short[] BC000R37_A1EmpCod ;
   private short[] BC000R37_A869LiqLegConAnio ;
   private int[] BC000R37_A6LegNumero ;
   private String[] BC000R37_A26ConCodigo ;
   private int[] BC000R37_A1097LiqAltaNro ;
   private int[] BC000R37_A1098LiqNuevaNro ;
   private int[] BC000R38_A3CliCod ;
   private short[] BC000R38_A1EmpCod ;
   private int[] BC000R38_A31LiqNro ;
   private String[] BC000R38_A10LpgCodigo ;
   private int[] BC000R39_A3CliCod ;
   private short[] BC000R39_A1EmpCod ;
   private int[] BC000R39_A31LiqNro ;
   private int[] BC000R39_A6LegNumero ;
   private int[] BC000R40_A3CliCod ;
   private short[] BC000R40_A1EmpCod ;
   private int[] BC000R40_A6LegNumero ;
   private short[] BC000R40_A25AgeOrden ;
   private int[] BC000R41_A31LiqNro ;
   private String[] BC000R41_A2EmpNom ;
   private String[] BC000R41_A271LiqDescrip ;
   private java.util.Date[] BC000R41_A98LiqFecha ;
   private short[] BC000R41_A585LiqPerAno ;
   private byte[] BC000R41_A586LiqPerMes ;
   private java.util.Date[] BC000R41_A283LiqPeriodo ;
   private java.util.Date[] BC000R41_A280LiqFecPago ;
   private String[] BC000R41_A340TliqDesc ;
   private String[] BC000R41_A2368TLiqDescAux ;
   private byte[] BC000R41_A278LiqEstado ;
   private byte[] BC000R41_A2292LiqLSDDepEst ;
   private byte[] BC000R41_A1403LiqAuxEstado ;
   private byte[] BC000R41_A2293LiqContrEst ;
   private byte[] BC000R41_A268LiqClase ;
   private boolean[] BC000R41_n268LiqClase ;
   private String[] BC000R41_A2180LiqPDFEstado ;
   private boolean[] BC000R41_n2180LiqPDFEstado ;
   private boolean[] BC000R41_A361LiqGenInter ;
   private boolean[] BC000R41_A494LiqContabilizada ;
   private short[] BC000R41_A495LiqCntLeg ;
   private java.math.BigDecimal[] BC000R41_A496LiqImpNeto ;
   private java.math.BigDecimal[] BC000R41_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] BC000R41_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] BC000R41_A497LiqImpBruto ;
   private boolean[] BC000R41_A500LegEspecificos ;
   private java.util.Date[] BC000R41_A511LiqFecCre ;
   private String[] BC000R41_A512LiqUsuCre ;
   private String[] BC000R41_A513LiqPerSinDia ;
   private String[] BC000R41_A748LiqPerPalabra ;
   private String[] BC000R41_A580LiqDepPrvPer ;
   private java.util.Date[] BC000R41_A581LiqDepPrvFec ;
   private String[] BC000R41_A582LiqDepBanDescrip ;
   private short[] BC000R41_A583LiqDepPerAno ;
   private byte[] BC000R41_A584LiqDepPerMes ;
   private java.util.Date[] BC000R41_A587LiqFecMod ;
   private String[] BC000R41_A588LiqUsuMod ;
   private java.util.Date[] BC000R41_A719LiqFecImp ;
   private java.math.BigDecimal[] BC000R41_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] BC000R41_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] BC000R41_A745LiqTopeDedInc ;
   private java.util.Date[] BC000R41_A746LiqPerUltNorm ;
   private String[] BC000R41_A766LiqError ;
   private String[] BC000R41_A1404LiqErrorAux ;
   private String[] BC000R41_A874LiqNombre ;
   private String[] BC000R41_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] BC000R41_A885LiqSegundos ;
   private String[] BC000R41_A963LiqRutaPDFTodosVertical ;
   private String[] BC000R41_A964LiqRutaPDFTodosHorizontal ;
   private String[] BC000R41_A965LiqRutaPDFTodosNombreVertical ;
   private String[] BC000R41_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] BC000R41_A1142LiqLog ;
   private boolean[] BC000R41_A2195LiqSac ;
   private boolean[] BC000R41_n2195LiqSac ;
   private String[] BC000R41_A2196LiqSacLog ;
   private boolean[] BC000R41_n2196LiqSacLog ;
   private boolean[] BC000R41_A2298LiqCancel ;
   private String[] BC000R41_A2409LiqModTra ;
   private byte[] BC000R41_A2414LiqFrecPag ;
   private java.util.Date[] BC000R41_A2410LiqPerDes ;
   private java.util.Date[] BC000R41_A2411LiqPerHas ;
   private String[] BC000R41_A2426LiqTipoTarifa ;
   private int[] BC000R41_A3CliCod ;
   private String[] BC000R41_A33LiqDepBanCod ;
   private boolean[] BC000R41_n33LiqDepBanCod ;
   private short[] BC000R41_A1EmpCod ;
   private String[] BC000R41_A32TLiqCod ;
   private boolean[] BC000R41_n32TLiqCod ;
   private java.util.Date[] BC000R41_A1729PeriodoLiq ;
   private int[] BC000R41_A2112LiqRelNro ;
   private boolean[] BC000R41_n2112LiqRelNro ;
   private String[] BC000R42_A2EmpNom ;
   private String[] BC000R43_A2EmpNom ;
   private int[] BC000R2_A31LiqNro ;
   private String[] BC000R2_A271LiqDescrip ;
   private java.util.Date[] BC000R2_A98LiqFecha ;
   private short[] BC000R2_A585LiqPerAno ;
   private byte[] BC000R2_A586LiqPerMes ;
   private java.util.Date[] BC000R2_A283LiqPeriodo ;
   private java.util.Date[] BC000R2_A280LiqFecPago ;
   private String[] BC000R2_A2368TLiqDescAux ;
   private byte[] BC000R2_A278LiqEstado ;
   private byte[] BC000R2_A2292LiqLSDDepEst ;
   private byte[] BC000R2_A1403LiqAuxEstado ;
   private byte[] BC000R2_A2293LiqContrEst ;
   private byte[] BC000R2_A268LiqClase ;
   private String[] BC000R2_A2180LiqPDFEstado ;
   private boolean[] BC000R2_A361LiqGenInter ;
   private boolean[] BC000R2_A494LiqContabilizada ;
   private short[] BC000R2_A495LiqCntLeg ;
   private java.math.BigDecimal[] BC000R2_A496LiqImpNeto ;
   private java.math.BigDecimal[] BC000R2_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] BC000R2_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] BC000R2_A497LiqImpBruto ;
   private boolean[] BC000R2_A500LegEspecificos ;
   private java.util.Date[] BC000R2_A511LiqFecCre ;
   private String[] BC000R2_A512LiqUsuCre ;
   private String[] BC000R2_A513LiqPerSinDia ;
   private String[] BC000R2_A748LiqPerPalabra ;
   private String[] BC000R2_A580LiqDepPrvPer ;
   private java.util.Date[] BC000R2_A581LiqDepPrvFec ;
   private short[] BC000R2_A583LiqDepPerAno ;
   private byte[] BC000R2_A584LiqDepPerMes ;
   private java.util.Date[] BC000R2_A587LiqFecMod ;
   private String[] BC000R2_A588LiqUsuMod ;
   private java.util.Date[] BC000R2_A719LiqFecImp ;
   private java.math.BigDecimal[] BC000R2_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] BC000R2_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] BC000R2_A745LiqTopeDedInc ;
   private java.util.Date[] BC000R2_A746LiqPerUltNorm ;
   private String[] BC000R2_A766LiqError ;
   private String[] BC000R2_A1404LiqErrorAux ;
   private String[] BC000R2_A874LiqNombre ;
   private String[] BC000R2_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] BC000R2_A885LiqSegundos ;
   private String[] BC000R2_A963LiqRutaPDFTodosVertical ;
   private String[] BC000R2_A964LiqRutaPDFTodosHorizontal ;
   private String[] BC000R2_A965LiqRutaPDFTodosNombreVertical ;
   private String[] BC000R2_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] BC000R2_A1142LiqLog ;
   private boolean[] BC000R2_A2195LiqSac ;
   private String[] BC000R2_A2196LiqSacLog ;
   private boolean[] BC000R2_A2298LiqCancel ;
   private String[] BC000R2_A2409LiqModTra ;
   private byte[] BC000R2_A2414LiqFrecPag ;
   private java.util.Date[] BC000R2_A2410LiqPerDes ;
   private java.util.Date[] BC000R2_A2411LiqPerHas ;
   private String[] BC000R2_A2426LiqTipoTarifa ;
   private int[] BC000R2_A3CliCod ;
   private String[] BC000R2_A33LiqDepBanCod ;
   private short[] BC000R2_A1EmpCod ;
   private String[] BC000R2_A32TLiqCod ;
   private java.util.Date[] BC000R2_A1729PeriodoLiq ;
   private int[] BC000R2_A2112LiqRelNro ;
   private int[] BC000R3_A31LiqNro ;
   private String[] BC000R3_A271LiqDescrip ;
   private java.util.Date[] BC000R3_A98LiqFecha ;
   private short[] BC000R3_A585LiqPerAno ;
   private byte[] BC000R3_A586LiqPerMes ;
   private java.util.Date[] BC000R3_A283LiqPeriodo ;
   private java.util.Date[] BC000R3_A280LiqFecPago ;
   private String[] BC000R3_A2368TLiqDescAux ;
   private byte[] BC000R3_A278LiqEstado ;
   private byte[] BC000R3_A2292LiqLSDDepEst ;
   private byte[] BC000R3_A1403LiqAuxEstado ;
   private byte[] BC000R3_A2293LiqContrEst ;
   private byte[] BC000R3_A268LiqClase ;
   private String[] BC000R3_A2180LiqPDFEstado ;
   private boolean[] BC000R3_A361LiqGenInter ;
   private boolean[] BC000R3_A494LiqContabilizada ;
   private short[] BC000R3_A495LiqCntLeg ;
   private java.math.BigDecimal[] BC000R3_A496LiqImpNeto ;
   private java.math.BigDecimal[] BC000R3_A755LiqImpDescuentos ;
   private java.math.BigDecimal[] BC000R3_A756LiqImpRetenGan ;
   private java.math.BigDecimal[] BC000R3_A497LiqImpBruto ;
   private boolean[] BC000R3_A500LegEspecificos ;
   private java.util.Date[] BC000R3_A511LiqFecCre ;
   private String[] BC000R3_A512LiqUsuCre ;
   private String[] BC000R3_A513LiqPerSinDia ;
   private String[] BC000R3_A748LiqPerPalabra ;
   private String[] BC000R3_A580LiqDepPrvPer ;
   private java.util.Date[] BC000R3_A581LiqDepPrvFec ;
   private short[] BC000R3_A583LiqDepPerAno ;
   private byte[] BC000R3_A584LiqDepPerMes ;
   private java.util.Date[] BC000R3_A587LiqFecMod ;
   private String[] BC000R3_A588LiqUsuMod ;
   private java.util.Date[] BC000R3_A719LiqFecImp ;
   private java.math.BigDecimal[] BC000R3_A743LiqPisoGanancias ;
   private java.math.BigDecimal[] BC000R3_A744LiqPisGanSAC ;
   private java.math.BigDecimal[] BC000R3_A745LiqTopeDedInc ;
   private java.util.Date[] BC000R3_A746LiqPerUltNorm ;
   private String[] BC000R3_A766LiqError ;
   private String[] BC000R3_A1404LiqErrorAux ;
   private String[] BC000R3_A874LiqNombre ;
   private String[] BC000R3_A881LiqLegajosTxt ;
   private java.math.BigDecimal[] BC000R3_A885LiqSegundos ;
   private String[] BC000R3_A963LiqRutaPDFTodosVertical ;
   private String[] BC000R3_A964LiqRutaPDFTodosHorizontal ;
   private String[] BC000R3_A965LiqRutaPDFTodosNombreVertical ;
   private String[] BC000R3_A966LiqRutaPDFTodosNombreHorizonta ;
   private String[] BC000R3_A1142LiqLog ;
   private boolean[] BC000R3_A2195LiqSac ;
   private String[] BC000R3_A2196LiqSacLog ;
   private boolean[] BC000R3_A2298LiqCancel ;
   private String[] BC000R3_A2409LiqModTra ;
   private byte[] BC000R3_A2414LiqFrecPag ;
   private java.util.Date[] BC000R3_A2410LiqPerDes ;
   private java.util.Date[] BC000R3_A2411LiqPerHas ;
   private String[] BC000R3_A2426LiqTipoTarifa ;
   private int[] BC000R3_A3CliCod ;
   private String[] BC000R3_A33LiqDepBanCod ;
   private short[] BC000R3_A1EmpCod ;
   private String[] BC000R3_A32TLiqCod ;
   private java.util.Date[] BC000R3_A1729PeriodoLiq ;
   private int[] BC000R3_A2112LiqRelNro ;
   private String[] BC000R4_A582LiqDepBanDescrip ;
   private String[] BC000R5_A2EmpNom ;
   private String[] BC000R6_A340TliqDesc ;
   private int[] BC000R7_A3CliCod ;
   private int[] BC000R8_A3CliCod ;
   private boolean[] BC000R2_n268LiqClase ;
   private boolean[] BC000R2_n2180LiqPDFEstado ;
   private boolean[] BC000R2_n2195LiqSac ;
   private boolean[] BC000R2_n2196LiqSacLog ;
   private boolean[] BC000R2_n33LiqDepBanCod ;
   private boolean[] BC000R2_n32TLiqCod ;
   private boolean[] BC000R2_n2112LiqRelNro ;
   private boolean[] BC000R3_n268LiqClase ;
   private boolean[] BC000R3_n2180LiqPDFEstado ;
   private boolean[] BC000R3_n2195LiqSac ;
   private boolean[] BC000R3_n2196LiqSacLog ;
   private boolean[] BC000R3_n33LiqDepBanCod ;
   private boolean[] BC000R3_n32TLiqCod ;
   private boolean[] BC000R3_n2112LiqRelNro ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV10TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV13TrnContextAtt ;
}

final  class liquidacion_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000R2", "SELECT LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqDescAux, LiqEstado, LiqLSDDepEst, LiqAuxEstado, LiqContrEst, LiqClase, LiqPDFEstado, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqPerPalabra, LiqDepPrvPer, LiqDepPrvFec, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqError, LiqErrorAux, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqSac, LiqSacLog, LiqCancel, LiqModTra, LiqFrecPag, LiqPerDes, LiqPerHas, LiqTipoTarifa, CliCod, LiqDepBanCod, EmpCod, TLiqCod, PeriodoLiq, LiqRelNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  FOR UPDATE OF Liquidacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R3", "SELECT LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqDescAux, LiqEstado, LiqLSDDepEst, LiqAuxEstado, LiqContrEst, LiqClase, LiqPDFEstado, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqPerPalabra, LiqDepPrvPer, LiqDepPrvFec, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqError, LiqErrorAux, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqSac, LiqSacLog, LiqCancel, LiqModTra, LiqFrecPag, LiqPerDes, LiqPerHas, LiqTipoTarifa, CliCod, LiqDepBanCod, EmpCod, TLiqCod, PeriodoLiq, LiqRelNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R4", "SELECT BanDescrip AS LiqDepBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R5", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R6", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R7", "SELECT CliCod FROM Periodo WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R8", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R9", "SELECT TM1.LiqNro, T2.EmpNom, TM1.LiqDescrip, TM1.LiqFecha, TM1.LiqPerAno, TM1.LiqPerMes, TM1.LiqPeriodo, TM1.LiqFecPago, T3.TliqDesc, TM1.TLiqDescAux, TM1.LiqEstado, TM1.LiqLSDDepEst, TM1.LiqAuxEstado, TM1.LiqContrEst, TM1.LiqClase, TM1.LiqPDFEstado, TM1.LiqGenInter, TM1.LiqContabilizada, TM1.LiqCntLeg, TM1.LiqImpNeto, TM1.LiqImpDescuentos, TM1.LiqImpRetenGan, TM1.LiqImpBruto, TM1.LegEspecificos, TM1.LiqFecCre, TM1.LiqUsuCre, TM1.LiqPerSinDia, TM1.LiqPerPalabra, TM1.LiqDepPrvPer, TM1.LiqDepPrvFec, T4.BanDescrip AS LiqDepBanDescrip, TM1.LiqDepPerAno, TM1.LiqDepPerMes, TM1.LiqFecMod, TM1.LiqUsuMod, TM1.LiqFecImp, TM1.LiqPisoGanancias, TM1.LiqPisGanSAC, TM1.LiqTopeDedInc, TM1.LiqPerUltNorm, TM1.LiqError, TM1.LiqErrorAux, TM1.LiqNombre, TM1.LiqLegajosTxt, TM1.LiqSegundos, TM1.LiqRutaPDFTodosVertical, TM1.LiqRutaPDFTodosHorizontal, TM1.LiqRutaPDFTodosNombreVertical, TM1.LiqRutaPDFTodosNombreHorizonta, TM1.LiqLog, TM1.LiqSac, TM1.LiqSacLog, TM1.LiqCancel, TM1.LiqModTra, TM1.LiqFrecPag, TM1.LiqPerDes, TM1.LiqPerHas, TM1.LiqTipoTarifa, TM1.CliCod, TM1.LiqDepBanCod AS LiqDepBanCod, TM1.EmpCod, TM1.TLiqCod, TM1.PeriodoLiq, TM1.LiqRelNro AS LiqRelNro FROM (((Liquidacion TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) LEFT JOIN TipoLiquidacion T3 ON T3.CliCod = TM1.CliCod AND T3.TLiqCod = TM1.TLiqCod) LEFT JOIN Banco T4 ON T4.CliCod = TM1.CliCod AND T4.BanCod = TM1.LiqDepBanCod) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LiqNro = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R10", "SELECT BanDescrip AS LiqDepBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R11", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R12", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R13", "SELECT CliCod FROM Periodo WHERE CliCod = ? AND EmpCod = ? AND PeriodoLiq = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R14", "SELECT CliCod FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R15", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R16", "SELECT LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqDescAux, LiqEstado, LiqLSDDepEst, LiqAuxEstado, LiqContrEst, LiqClase, LiqPDFEstado, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqPerPalabra, LiqDepPrvPer, LiqDepPrvFec, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqError, LiqErrorAux, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqSac, LiqSacLog, LiqCancel, LiqModTra, LiqFrecPag, LiqPerDes, LiqPerHas, LiqTipoTarifa, CliCod, LiqDepBanCod, EmpCod, TLiqCod, PeriodoLiq, LiqRelNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R17", "SELECT LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqDescAux, LiqEstado, LiqLSDDepEst, LiqAuxEstado, LiqContrEst, LiqClase, LiqPDFEstado, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqPerPalabra, LiqDepPrvPer, LiqDepPrvFec, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqError, LiqErrorAux, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqSac, LiqSacLog, LiqCancel, LiqModTra, LiqFrecPag, LiqPerDes, LiqPerHas, LiqTipoTarifa, CliCod, LiqDepBanCod, EmpCod, TLiqCod, PeriodoLiq, LiqRelNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  FOR UPDATE OF Liquidacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000R18", "SAVEPOINT gxupdate;INSERT INTO Liquidacion(LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqDescAux, LiqEstado, LiqLSDDepEst, LiqAuxEstado, LiqContrEst, LiqClase, LiqPDFEstado, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpDescuentos, LiqImpRetenGan, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqPerPalabra, LiqDepPrvPer, LiqDepPrvFec, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisoGanancias, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqError, LiqErrorAux, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqSac, LiqSacLog, LiqCancel, LiqModTra, LiqFrecPag, LiqPerDes, LiqPerHas, LiqTipoTarifa, CliCod, LiqDepBanCod, EmpCod, TLiqCod, PeriodoLiq, LiqRelNro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000R19", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqDescrip=?, LiqFecha=?, LiqPerAno=?, LiqPerMes=?, LiqPeriodo=?, LiqFecPago=?, TLiqDescAux=?, LiqEstado=?, LiqLSDDepEst=?, LiqAuxEstado=?, LiqContrEst=?, LiqClase=?, LiqPDFEstado=?, LiqGenInter=?, LiqContabilizada=?, LiqCntLeg=?, LiqImpNeto=?, LiqImpDescuentos=?, LiqImpRetenGan=?, LiqImpBruto=?, LegEspecificos=?, LiqFecCre=?, LiqUsuCre=?, LiqPerSinDia=?, LiqPerPalabra=?, LiqDepPrvPer=?, LiqDepPrvFec=?, LiqDepPerAno=?, LiqDepPerMes=?, LiqFecMod=?, LiqUsuMod=?, LiqFecImp=?, LiqPisoGanancias=?, LiqPisGanSAC=?, LiqTopeDedInc=?, LiqPerUltNorm=?, LiqError=?, LiqErrorAux=?, LiqNombre=?, LiqLegajosTxt=?, LiqSegundos=?, LiqRutaPDFTodosVertical=?, LiqRutaPDFTodosHorizontal=?, LiqRutaPDFTodosNombreVertical=?, LiqRutaPDFTodosNombreHorizonta=?, LiqLog=?, LiqSac=?, LiqSacLog=?, LiqCancel=?, LiqModTra=?, LiqFrecPag=?, LiqPerDes=?, LiqPerHas=?, LiqTipoTarifa=?, LiqDepBanCod=?, TLiqCod=?, PeriodoLiq=?, LiqRelNro=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000R20", "SAVEPOINT gxupdate;DELETE FROM Liquidacion  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000R21", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R22", "SELECT TliqDesc FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R23", "SELECT BanDescrip AS LiqDepBanDescrip FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R24", "SELECT CliCod, EmpCod, LiqNro AS LiqRelNro FROM Liquidacion WHERE CliCod = ? AND EmpCod = ? AND LiqRelNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R25", "SELECT CliCod, EmpCod, LiqNro, LinkLegNumero, LegLinkTiporec FROM LiquidacionLegajoLinkPdf WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R26", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLConsAnio, LegCuLConsSec FROM legajo_cuenta_licenciasconsumos WHERE CliCod = ? AND EmpCod = ? AND LegCulConsLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R27", "SELECT CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio, LegCuLAprLicFch FROM legajo_cuenta_licenciasaprobaciones WHERE CliCod = ? AND EmpCod = ? AND LegCuLAprLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R28", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND EmpCod = ? AND LegHisLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R29", "SELECT CliCod, EmpCod, LiqNro, LiqSuc FROM LiquidacionSucursal WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R30", "SELECT CliCod, EmpCod, LiqNro, LiqArea FROM LiquidacionArea WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R31", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio FROM LiquidacionConvenio WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R32", "SELECT CliCod, EmpCod, LSDSec FROM LSD_reg1 WHERE CliCod = ? AND EmpCod = ? AND LSD1LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R33", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqOblNuevaNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R34", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro FROM LiqLegObligacionCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqOblAltaNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R35", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial FROM Obligacion WHERE CliCod = ? AND EmpCod = ? AND OblLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R36", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqNuevaNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R37", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? AND EmpCod = ? AND LiqAltaNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R38", "SELECT CliCod, EmpCod, LiqNro, LpgCodigo FROM LiquidacionLugarPago WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R39", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R40", "SELECT CliCod, EmpCod, LegNumero, AgeOrden FROM AgendaNovedades WHERE CliCod = ? AND EmpCod = ? AND AgeLiqNro = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000R41", "SELECT TM1.LiqNro, T2.EmpNom, TM1.LiqDescrip, TM1.LiqFecha, TM1.LiqPerAno, TM1.LiqPerMes, TM1.LiqPeriodo, TM1.LiqFecPago, T3.TliqDesc, TM1.TLiqDescAux, TM1.LiqEstado, TM1.LiqLSDDepEst, TM1.LiqAuxEstado, TM1.LiqContrEst, TM1.LiqClase, TM1.LiqPDFEstado, TM1.LiqGenInter, TM1.LiqContabilizada, TM1.LiqCntLeg, TM1.LiqImpNeto, TM1.LiqImpDescuentos, TM1.LiqImpRetenGan, TM1.LiqImpBruto, TM1.LegEspecificos, TM1.LiqFecCre, TM1.LiqUsuCre, TM1.LiqPerSinDia, TM1.LiqPerPalabra, TM1.LiqDepPrvPer, TM1.LiqDepPrvFec, T4.BanDescrip AS LiqDepBanDescrip, TM1.LiqDepPerAno, TM1.LiqDepPerMes, TM1.LiqFecMod, TM1.LiqUsuMod, TM1.LiqFecImp, TM1.LiqPisoGanancias, TM1.LiqPisGanSAC, TM1.LiqTopeDedInc, TM1.LiqPerUltNorm, TM1.LiqError, TM1.LiqErrorAux, TM1.LiqNombre, TM1.LiqLegajosTxt, TM1.LiqSegundos, TM1.LiqRutaPDFTodosVertical, TM1.LiqRutaPDFTodosHorizontal, TM1.LiqRutaPDFTodosNombreVertical, TM1.LiqRutaPDFTodosNombreHorizonta, TM1.LiqLog, TM1.LiqSac, TM1.LiqSacLog, TM1.LiqCancel, TM1.LiqModTra, TM1.LiqFrecPag, TM1.LiqPerDes, TM1.LiqPerHas, TM1.LiqTipoTarifa, TM1.CliCod, TM1.LiqDepBanCod AS LiqDepBanCod, TM1.EmpCod, TM1.TLiqCod, TM1.PeriodoLiq, TM1.LiqRelNro AS LiqRelNro FROM (((Liquidacion TM1 INNER JOIN Empresa T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod) LEFT JOIN TipoLiquidacion T3 ON T3.CliCod = TM1.CliCod AND T3.TLiqCod = TM1.TLiqCod) LEFT JOIN Banco T4 ON T4.CliCod = TM1.CliCod AND T4.BanCod = TM1.LiqDepBanCod) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LiqNro = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LiqNro ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R42", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000R43", "SELECT EmpNom FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((boolean[]) buf[16])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(16);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(22);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(23);
               ((String[]) buf[25])[0] = rslt.getVarchar(24);
               ((String[]) buf[26])[0] = rslt.getString(25, 20);
               ((String[]) buf[27])[0] = rslt.getString(26, 20);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((java.util.Date[]) buf[29])[0] = rslt.getGXDate(28);
               ((short[]) buf[30])[0] = rslt.getShort(29);
               ((byte[]) buf[31])[0] = rslt.getByte(30);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDateTime(31);
               ((String[]) buf[33])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[34])[0] = rslt.getGXDateTime(33);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(36,2);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((String[]) buf[39])[0] = rslt.getVarchar(38);
               ((String[]) buf[40])[0] = rslt.getVarchar(39);
               ((String[]) buf[41])[0] = rslt.getVarchar(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(42,2);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((String[]) buf[46])[0] = rslt.getString(45, 200);
               ((String[]) buf[47])[0] = rslt.getString(46, 200);
               ((String[]) buf[48])[0] = rslt.getLongVarchar(47);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((boolean[]) buf[53])[0] = rslt.getBoolean(50);
               ((String[]) buf[54])[0] = rslt.getString(51, 1);
               ((byte[]) buf[55])[0] = rslt.getByte(52);
               ((java.util.Date[]) buf[56])[0] = rslt.getGXDate(53);
               ((java.util.Date[]) buf[57])[0] = rslt.getGXDate(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 1);
               ((int[]) buf[59])[0] = rslt.getInt(56);
               ((String[]) buf[60])[0] = rslt.getString(57, 6);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(58);
               ((String[]) buf[63])[0] = rslt.getString(59, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[65])[0] = rslt.getGXDate(60);
               ((int[]) buf[66])[0] = rslt.getInt(61);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((boolean[]) buf[16])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(16);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(22);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(23);
               ((String[]) buf[25])[0] = rslt.getVarchar(24);
               ((String[]) buf[26])[0] = rslt.getString(25, 20);
               ((String[]) buf[27])[0] = rslt.getString(26, 20);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((java.util.Date[]) buf[29])[0] = rslt.getGXDate(28);
               ((short[]) buf[30])[0] = rslt.getShort(29);
               ((byte[]) buf[31])[0] = rslt.getByte(30);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDateTime(31);
               ((String[]) buf[33])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[34])[0] = rslt.getGXDateTime(33);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(36,2);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((String[]) buf[39])[0] = rslt.getVarchar(38);
               ((String[]) buf[40])[0] = rslt.getVarchar(39);
               ((String[]) buf[41])[0] = rslt.getVarchar(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(42,2);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((String[]) buf[46])[0] = rslt.getString(45, 200);
               ((String[]) buf[47])[0] = rslt.getString(46, 200);
               ((String[]) buf[48])[0] = rslt.getLongVarchar(47);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((boolean[]) buf[53])[0] = rslt.getBoolean(50);
               ((String[]) buf[54])[0] = rslt.getString(51, 1);
               ((byte[]) buf[55])[0] = rslt.getByte(52);
               ((java.util.Date[]) buf[56])[0] = rslt.getGXDate(53);
               ((java.util.Date[]) buf[57])[0] = rslt.getGXDate(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 1);
               ((int[]) buf[59])[0] = rslt.getInt(56);
               ((String[]) buf[60])[0] = rslt.getString(57, 6);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(58);
               ((String[]) buf[63])[0] = rslt.getString(59, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[65])[0] = rslt.getGXDate(60);
               ((int[]) buf[66])[0] = rslt.getInt(61);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((boolean[]) buf[18])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(18);
               ((short[]) buf[20])[0] = rslt.getShort(19);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(23,2);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(24);
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(25);
               ((String[]) buf[27])[0] = rslt.getVarchar(26);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((String[]) buf[29])[0] = rslt.getString(28, 20);
               ((String[]) buf[30])[0] = rslt.getString(29, 20);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(30);
               ((String[]) buf[32])[0] = rslt.getVarchar(31);
               ((short[]) buf[33])[0] = rslt.getShort(32);
               ((byte[]) buf[34])[0] = rslt.getByte(33);
               ((java.util.Date[]) buf[35])[0] = rslt.getGXDateTime(34);
               ((String[]) buf[36])[0] = rslt.getVarchar(35);
               ((java.util.Date[]) buf[37])[0] = rslt.getGXDateTime(36);
               ((java.math.BigDecimal[]) buf[38])[0] = rslt.getBigDecimal(37,2);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(38,2);
               ((java.math.BigDecimal[]) buf[40])[0] = rslt.getBigDecimal(39,2);
               ((java.util.Date[]) buf[41])[0] = rslt.getGXDate(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((String[]) buf[43])[0] = rslt.getVarchar(42);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((java.math.BigDecimal[]) buf[46])[0] = rslt.getBigDecimal(45,2);
               ((String[]) buf[47])[0] = rslt.getVarchar(46);
               ((String[]) buf[48])[0] = rslt.getVarchar(47);
               ((String[]) buf[49])[0] = rslt.getString(48, 200);
               ((String[]) buf[50])[0] = rslt.getString(49, 200);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(50);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getVarchar(52);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((boolean[]) buf[56])[0] = rslt.getBoolean(53);
               ((String[]) buf[57])[0] = rslt.getString(54, 1);
               ((byte[]) buf[58])[0] = rslt.getByte(55);
               ((java.util.Date[]) buf[59])[0] = rslt.getGXDate(56);
               ((java.util.Date[]) buf[60])[0] = rslt.getGXDate(57);
               ((String[]) buf[61])[0] = rslt.getString(58, 1);
               ((int[]) buf[62])[0] = rslt.getInt(59);
               ((String[]) buf[63])[0] = rslt.getString(60, 6);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((short[]) buf[65])[0] = rslt.getShort(61);
               ((String[]) buf[66])[0] = rslt.getString(62, 20);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[68])[0] = rslt.getGXDate(63);
               ((int[]) buf[69])[0] = rslt.getInt(64);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((boolean[]) buf[16])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(16);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(22);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(23);
               ((String[]) buf[25])[0] = rslt.getVarchar(24);
               ((String[]) buf[26])[0] = rslt.getString(25, 20);
               ((String[]) buf[27])[0] = rslt.getString(26, 20);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((java.util.Date[]) buf[29])[0] = rslt.getGXDate(28);
               ((short[]) buf[30])[0] = rslt.getShort(29);
               ((byte[]) buf[31])[0] = rslt.getByte(30);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDateTime(31);
               ((String[]) buf[33])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[34])[0] = rslt.getGXDateTime(33);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(36,2);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((String[]) buf[39])[0] = rslt.getVarchar(38);
               ((String[]) buf[40])[0] = rslt.getVarchar(39);
               ((String[]) buf[41])[0] = rslt.getVarchar(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(42,2);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((String[]) buf[46])[0] = rslt.getString(45, 200);
               ((String[]) buf[47])[0] = rslt.getString(46, 200);
               ((String[]) buf[48])[0] = rslt.getLongVarchar(47);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((boolean[]) buf[53])[0] = rslt.getBoolean(50);
               ((String[]) buf[54])[0] = rslt.getString(51, 1);
               ((byte[]) buf[55])[0] = rslt.getByte(52);
               ((java.util.Date[]) buf[56])[0] = rslt.getGXDate(53);
               ((java.util.Date[]) buf[57])[0] = rslt.getGXDate(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 1);
               ((int[]) buf[59])[0] = rslt.getInt(56);
               ((String[]) buf[60])[0] = rslt.getString(57, 6);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(58);
               ((String[]) buf[63])[0] = rslt.getString(59, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[65])[0] = rslt.getGXDate(60);
               ((int[]) buf[66])[0] = rslt.getInt(61);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((boolean[]) buf[16])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(16);
               ((short[]) buf[18])[0] = rslt.getShort(17);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(18,2);
               ((java.math.BigDecimal[]) buf[20])[0] = rslt.getBigDecimal(19,2);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((boolean[]) buf[23])[0] = rslt.getBoolean(22);
               ((java.util.Date[]) buf[24])[0] = rslt.getGXDate(23);
               ((String[]) buf[25])[0] = rslt.getVarchar(24);
               ((String[]) buf[26])[0] = rslt.getString(25, 20);
               ((String[]) buf[27])[0] = rslt.getString(26, 20);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((java.util.Date[]) buf[29])[0] = rslt.getGXDate(28);
               ((short[]) buf[30])[0] = rslt.getShort(29);
               ((byte[]) buf[31])[0] = rslt.getByte(30);
               ((java.util.Date[]) buf[32])[0] = rslt.getGXDateTime(31);
               ((String[]) buf[33])[0] = rslt.getVarchar(32);
               ((java.util.Date[]) buf[34])[0] = rslt.getGXDateTime(33);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(36,2);
               ((java.util.Date[]) buf[38])[0] = rslt.getGXDate(37);
               ((String[]) buf[39])[0] = rslt.getVarchar(38);
               ((String[]) buf[40])[0] = rslt.getVarchar(39);
               ((String[]) buf[41])[0] = rslt.getVarchar(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(42,2);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((String[]) buf[46])[0] = rslt.getString(45, 200);
               ((String[]) buf[47])[0] = rslt.getString(46, 200);
               ((String[]) buf[48])[0] = rslt.getLongVarchar(47);
               ((boolean[]) buf[49])[0] = rslt.getBoolean(48);
               ((boolean[]) buf[50])[0] = rslt.wasNull();
               ((String[]) buf[51])[0] = rslt.getVarchar(49);
               ((boolean[]) buf[52])[0] = rslt.wasNull();
               ((boolean[]) buf[53])[0] = rslt.getBoolean(50);
               ((String[]) buf[54])[0] = rslt.getString(51, 1);
               ((byte[]) buf[55])[0] = rslt.getByte(52);
               ((java.util.Date[]) buf[56])[0] = rslt.getGXDate(53);
               ((java.util.Date[]) buf[57])[0] = rslt.getGXDate(54);
               ((String[]) buf[58])[0] = rslt.getString(55, 1);
               ((int[]) buf[59])[0] = rslt.getInt(56);
               ((String[]) buf[60])[0] = rslt.getString(57, 6);
               ((boolean[]) buf[61])[0] = rslt.wasNull();
               ((short[]) buf[62])[0] = rslt.getShort(58);
               ((String[]) buf[63])[0] = rslt.getString(59, 20);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[65])[0] = rslt.getGXDate(60);
               ((int[]) buf[66])[0] = rslt.getInt(61);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((byte[]) buf[14])[0] = rslt.getByte(15);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((boolean[]) buf[18])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(18);
               ((short[]) buf[20])[0] = rslt.getShort(19);
               ((java.math.BigDecimal[]) buf[21])[0] = rslt.getBigDecimal(20,2);
               ((java.math.BigDecimal[]) buf[22])[0] = rslt.getBigDecimal(21,2);
               ((java.math.BigDecimal[]) buf[23])[0] = rslt.getBigDecimal(22,2);
               ((java.math.BigDecimal[]) buf[24])[0] = rslt.getBigDecimal(23,2);
               ((boolean[]) buf[25])[0] = rslt.getBoolean(24);
               ((java.util.Date[]) buf[26])[0] = rslt.getGXDate(25);
               ((String[]) buf[27])[0] = rslt.getVarchar(26);
               ((String[]) buf[28])[0] = rslt.getString(27, 20);
               ((String[]) buf[29])[0] = rslt.getString(28, 20);
               ((String[]) buf[30])[0] = rslt.getString(29, 20);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(30);
               ((String[]) buf[32])[0] = rslt.getVarchar(31);
               ((short[]) buf[33])[0] = rslt.getShort(32);
               ((byte[]) buf[34])[0] = rslt.getByte(33);
               ((java.util.Date[]) buf[35])[0] = rslt.getGXDateTime(34);
               ((String[]) buf[36])[0] = rslt.getVarchar(35);
               ((java.util.Date[]) buf[37])[0] = rslt.getGXDateTime(36);
               ((java.math.BigDecimal[]) buf[38])[0] = rslt.getBigDecimal(37,2);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(38,2);
               ((java.math.BigDecimal[]) buf[40])[0] = rslt.getBigDecimal(39,2);
               ((java.util.Date[]) buf[41])[0] = rslt.getGXDate(40);
               ((String[]) buf[42])[0] = rslt.getVarchar(41);
               ((String[]) buf[43])[0] = rslt.getVarchar(42);
               ((String[]) buf[44])[0] = rslt.getVarchar(43);
               ((String[]) buf[45])[0] = rslt.getVarchar(44);
               ((java.math.BigDecimal[]) buf[46])[0] = rslt.getBigDecimal(45,2);
               ((String[]) buf[47])[0] = rslt.getVarchar(46);
               ((String[]) buf[48])[0] = rslt.getVarchar(47);
               ((String[]) buf[49])[0] = rslt.getString(48, 200);
               ((String[]) buf[50])[0] = rslt.getString(49, 200);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(50);
               ((boolean[]) buf[52])[0] = rslt.getBoolean(51);
               ((boolean[]) buf[53])[0] = rslt.wasNull();
               ((String[]) buf[54])[0] = rslt.getVarchar(52);
               ((boolean[]) buf[55])[0] = rslt.wasNull();
               ((boolean[]) buf[56])[0] = rslt.getBoolean(53);
               ((String[]) buf[57])[0] = rslt.getString(54, 1);
               ((byte[]) buf[58])[0] = rslt.getByte(55);
               ((java.util.Date[]) buf[59])[0] = rslt.getGXDate(56);
               ((java.util.Date[]) buf[60])[0] = rslt.getGXDate(57);
               ((String[]) buf[61])[0] = rslt.getString(58, 1);
               ((int[]) buf[62])[0] = rslt.getInt(59);
               ((String[]) buf[63])[0] = rslt.getString(60, 6);
               ((boolean[]) buf[64])[0] = rslt.wasNull();
               ((short[]) buf[65])[0] = rslt.getShort(61);
               ((String[]) buf[66])[0] = rslt.getString(62, 20);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[68])[0] = rslt.getGXDate(63);
               ((int[]) buf[69])[0] = rslt.getInt(64);
               ((boolean[]) buf[70])[0] = rslt.wasNull();
               return;
            case 40 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 41 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(3, ((Number) parms[3]).intValue());
               }
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setVarchar(8, (String)parms[7], 30, false);
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(13, ((Number) parms[13]).byteValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(14, (String)parms[15], 20);
               }
               stmt.setBoolean(15, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[17]).booleanValue());
               stmt.setShort(17, ((Number) parms[18]).shortValue());
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[22], 2);
               stmt.setBoolean(22, ((Boolean) parms[23]).booleanValue());
               stmt.setDate(23, (java.util.Date)parms[24]);
               stmt.setVarchar(24, (String)parms[25], 100, false);
               stmt.setString(25, (String)parms[26], 20);
               stmt.setString(26, (String)parms[27], 20);
               stmt.setString(27, (String)parms[28], 20);
               stmt.setDate(28, (java.util.Date)parms[29]);
               stmt.setShort(29, ((Number) parms[30]).shortValue());
               stmt.setByte(30, ((Number) parms[31]).byteValue());
               stmt.setDateTime(31, (java.util.Date)parms[32], false);
               stmt.setVarchar(32, (String)parms[33], 100, false);
               stmt.setDateTime(33, (java.util.Date)parms[34], false);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[35], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[36], 2);
               stmt.setBigDecimal(36, (java.math.BigDecimal)parms[37], 2);
               stmt.setDate(37, (java.util.Date)parms[38]);
               stmt.setVarchar(38, (String)parms[39], 400, false);
               stmt.setVarchar(39, (String)parms[40], 400, false);
               stmt.setVarchar(40, (String)parms[41], 400, false);
               stmt.setVarchar(41, (String)parms[42], 1000, false);
               stmt.setBigDecimal(42, (java.math.BigDecimal)parms[43], 2);
               stmt.setVarchar(43, (String)parms[44], 400, false);
               stmt.setVarchar(44, (String)parms[45], 400, false);
               stmt.setString(45, (String)parms[46], 200);
               stmt.setString(46, (String)parms[47], 200);
               stmt.setNLongVarchar(47, (String)parms[48], false);
               if ( ((Boolean) parms[49]).booleanValue() )
               {
                  stmt.setNull( 48 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(48, ((Boolean) parms[50]).booleanValue());
               }
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(49, (String)parms[52], 400);
               }
               stmt.setBoolean(50, ((Boolean) parms[53]).booleanValue());
               stmt.setString(51, (String)parms[54], 1);
               stmt.setByte(52, ((Number) parms[55]).byteValue());
               stmt.setDate(53, (java.util.Date)parms[56]);
               stmt.setDate(54, (java.util.Date)parms[57]);
               stmt.setString(55, (String)parms[58], 1);
               stmt.setInt(56, ((Number) parms[59]).intValue());
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 57 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(57, (String)parms[61], 6);
               }
               stmt.setShort(58, ((Number) parms[62]).shortValue());
               if ( ((Boolean) parms[63]).booleanValue() )
               {
                  stmt.setNull( 59 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(59, (String)parms[64], 20);
               }
               stmt.setDate(60, (java.util.Date)parms[65]);
               if ( ((Boolean) parms[66]).booleanValue() )
               {
                  stmt.setNull( 61 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(61, ((Number) parms[67]).intValue());
               }
               return;
            case 17 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setDate(2, (java.util.Date)parms[1]);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setDate(6, (java.util.Date)parms[5]);
               stmt.setVarchar(7, (String)parms[6], 30, false);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(12, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[14], 20);
               }
               stmt.setBoolean(14, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[16]).booleanValue());
               stmt.setShort(16, ((Number) parms[17]).shortValue());
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[21], 2);
               stmt.setBoolean(21, ((Boolean) parms[22]).booleanValue());
               stmt.setDate(22, (java.util.Date)parms[23]);
               stmt.setVarchar(23, (String)parms[24], 100, false);
               stmt.setString(24, (String)parms[25], 20);
               stmt.setString(25, (String)parms[26], 20);
               stmt.setString(26, (String)parms[27], 20);
               stmt.setDate(27, (java.util.Date)parms[28]);
               stmt.setShort(28, ((Number) parms[29]).shortValue());
               stmt.setByte(29, ((Number) parms[30]).byteValue());
               stmt.setDateTime(30, (java.util.Date)parms[31], false);
               stmt.setVarchar(31, (String)parms[32], 100, false);
               stmt.setDateTime(32, (java.util.Date)parms[33], false);
               stmt.setBigDecimal(33, (java.math.BigDecimal)parms[34], 2);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[35], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[36], 2);
               stmt.setDate(36, (java.util.Date)parms[37]);
               stmt.setVarchar(37, (String)parms[38], 400, false);
               stmt.setVarchar(38, (String)parms[39], 400, false);
               stmt.setVarchar(39, (String)parms[40], 400, false);
               stmt.setVarchar(40, (String)parms[41], 1000, false);
               stmt.setBigDecimal(41, (java.math.BigDecimal)parms[42], 2);
               stmt.setVarchar(42, (String)parms[43], 400, false);
               stmt.setVarchar(43, (String)parms[44], 400, false);
               stmt.setString(44, (String)parms[45], 200);
               stmt.setString(45, (String)parms[46], 200);
               stmt.setNLongVarchar(46, (String)parms[47], false);
               if ( ((Boolean) parms[48]).booleanValue() )
               {
                  stmt.setNull( 47 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(47, ((Boolean) parms[49]).booleanValue());
               }
               if ( ((Boolean) parms[50]).booleanValue() )
               {
                  stmt.setNull( 48 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(48, (String)parms[51], 400);
               }
               stmt.setBoolean(49, ((Boolean) parms[52]).booleanValue());
               stmt.setString(50, (String)parms[53], 1);
               stmt.setByte(51, ((Number) parms[54]).byteValue());
               stmt.setDate(52, (java.util.Date)parms[55]);
               stmt.setDate(53, (java.util.Date)parms[56]);
               stmt.setString(54, (String)parms[57], 1);
               if ( ((Boolean) parms[58]).booleanValue() )
               {
                  stmt.setNull( 55 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(55, (String)parms[59], 6);
               }
               if ( ((Boolean) parms[60]).booleanValue() )
               {
                  stmt.setNull( 56 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(56, (String)parms[61], 20);
               }
               stmt.setDate(57, (java.util.Date)parms[62]);
               if ( ((Boolean) parms[63]).booleanValue() )
               {
                  stmt.setNull( 58 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(58, ((Number) parms[64]).intValue());
               }
               stmt.setInt(59, ((Number) parms[65]).intValue());
               stmt.setShort(60, ((Number) parms[66]).shortValue());
               stmt.setInt(61, ((Number) parms[67]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

