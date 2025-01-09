package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class estado_bc extends GXWebPanel implements IGxSilentTrn
{
   public estado_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public estado_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( estado_bc.class ));
   }

   public estado_bc( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1D46( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1D46( ) ;
      standaloneModal( ) ;
      addRow1D46( ) ;
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
         e111D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z16SitCodigo = A16SitCodigo ;
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

   public void confirm_1D0( )
   {
      beforeValidate1D46( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1D46( ) ;
         }
         else
         {
            checkExtendedTable1D46( ) ;
            if ( AnyError == 0 )
            {
               zm1D46( 6) ;
               zm1D46( 7) ;
               zm1D46( 8) ;
            }
            closeExtendedTableCursors1D46( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e121D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion_Insert", GXv_boolean3) ;
         estado_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion_Update", GXv_boolean3) ;
         estado_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacion_Delete", GXv_boolean3) ;
         estado_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV30Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV30Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV31GXV1 = 1 ;
         while ( AV31GXV1 <= AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV17TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV31GXV1));
            if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "SitPaiCod") == 0 )
            {
               AV16Insert_SitPaiCod = (short)(GXutil.lval( AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EstadoSitRevista") == 0 )
            {
               AV18Insert_EstadoSitRevista = (short)(GXutil.lval( AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue())) ;
            }
            else if ( GXutil.strcmp(AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "EstadoSiniestro") == 0 )
            {
               AV19Insert_EstadoSiniestro = AV17TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV31GXV1 = (int)(AV31GXV1+1) ;
         }
      }
   }

   public void e111D2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm1D46( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z685SitDescripSinAc = A685SitDescripSinAc ;
         Z334SitDescrip = A334SitDescrip ;
         Z738SitEsLicencia = A738SitEsLicencia ;
         Z739SitLicCuentaTrab = A739SitLicCuentaTrab ;
         Z897SitLicMesesProm = A897SitLicMesesProm ;
         Z898SitLicMesesProm2 = A898SitLicMesesProm2 ;
         Z913sItDescAbrev = A913sItDescAbrev ;
         Z915SitDiasDivision = A915SitDiasDivision ;
         Z916SitEsAusencia = A916SitEsAusencia ;
         Z1217SitAplicaPlus = A1217SitAplicaPlus ;
         Z1220SitAbsorbeFer = A1220SitAbsorbeFer ;
         Z1489SitLicLimiteDef = A1489SitLicLimiteDef ;
         Z1490SitLicAdjunDef = A1490SitLicAdjunDef ;
         Z1491SitLicAdjOblDef = A1491SitLicAdjOblDef ;
         Z1492SitLicNecApr = A1492SitLicNecApr ;
         Z1493SitLIcIngMot = A1493SitLIcIngMot ;
         Z1494SitLicOblIngMot = A1494SitLicOblIngMot ;
         Z1807EstadoCanPresen = A1807EstadoCanPresen ;
         Z1809EstadoRemCorr = A1809EstadoRemCorr ;
         Z1593SitPaiCod = A1593SitPaiCod ;
         Z1598EstadoSitRevista = A1598EstadoSitRevista ;
         Z1600EstadoSiniestro = A1600EstadoSiniestro ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -5 )
      {
         Z685SitDescripSinAc = A685SitDescripSinAc ;
         Z16SitCodigo = A16SitCodigo ;
         Z334SitDescrip = A334SitDescrip ;
         Z738SitEsLicencia = A738SitEsLicencia ;
         Z739SitLicCuentaTrab = A739SitLicCuentaTrab ;
         Z897SitLicMesesProm = A897SitLicMesesProm ;
         Z898SitLicMesesProm2 = A898SitLicMesesProm2 ;
         Z913sItDescAbrev = A913sItDescAbrev ;
         Z915SitDiasDivision = A915SitDiasDivision ;
         Z916SitEsAusencia = A916SitEsAusencia ;
         Z1217SitAplicaPlus = A1217SitAplicaPlus ;
         Z1220SitAbsorbeFer = A1220SitAbsorbeFer ;
         Z1489SitLicLimiteDef = A1489SitLicLimiteDef ;
         Z1490SitLicAdjunDef = A1490SitLicAdjunDef ;
         Z1491SitLicAdjOblDef = A1491SitLicAdjOblDef ;
         Z1492SitLicNecApr = A1492SitLicNecApr ;
         Z1493SitLIcIngMot = A1493SitLIcIngMot ;
         Z1494SitLicOblIngMot = A1494SitLicOblIngMot ;
         Z1807EstadoCanPresen = A1807EstadoCanPresen ;
         Z1809EstadoRemCorr = A1809EstadoRemCorr ;
         Z1593SitPaiCod = A1593SitPaiCod ;
         Z1598EstadoSitRevista = A1598EstadoSitRevista ;
         Z1600EstadoSiniestro = A1600EstadoSiniestro ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1D46( )
   {
      /* Using cursor BC001D7 */
      pr_default.execute(5, new Object[] {A16SitCodigo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A685SitDescripSinAc = BC001D7_A685SitDescripSinAc[0] ;
         A334SitDescrip = BC001D7_A334SitDescrip[0] ;
         A738SitEsLicencia = BC001D7_A738SitEsLicencia[0] ;
         A739SitLicCuentaTrab = BC001D7_A739SitLicCuentaTrab[0] ;
         A897SitLicMesesProm = BC001D7_A897SitLicMesesProm[0] ;
         A898SitLicMesesProm2 = BC001D7_A898SitLicMesesProm2[0] ;
         A913sItDescAbrev = BC001D7_A913sItDescAbrev[0] ;
         A915SitDiasDivision = BC001D7_A915SitDiasDivision[0] ;
         A916SitEsAusencia = BC001D7_A916SitEsAusencia[0] ;
         A1217SitAplicaPlus = BC001D7_A1217SitAplicaPlus[0] ;
         A1220SitAbsorbeFer = BC001D7_A1220SitAbsorbeFer[0] ;
         A1489SitLicLimiteDef = BC001D7_A1489SitLicLimiteDef[0] ;
         A1490SitLicAdjunDef = BC001D7_A1490SitLicAdjunDef[0] ;
         A1491SitLicAdjOblDef = BC001D7_A1491SitLicAdjOblDef[0] ;
         A1492SitLicNecApr = BC001D7_A1492SitLicNecApr[0] ;
         A1493SitLIcIngMot = BC001D7_A1493SitLIcIngMot[0] ;
         A1494SitLicOblIngMot = BC001D7_A1494SitLicOblIngMot[0] ;
         A1807EstadoCanPresen = BC001D7_A1807EstadoCanPresen[0] ;
         A1809EstadoRemCorr = BC001D7_A1809EstadoRemCorr[0] ;
         A1593SitPaiCod = BC001D7_A1593SitPaiCod[0] ;
         n1593SitPaiCod = BC001D7_n1593SitPaiCod[0] ;
         A1598EstadoSitRevista = BC001D7_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = BC001D7_n1598EstadoSitRevista[0] ;
         A1600EstadoSiniestro = BC001D7_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = BC001D7_n1600EstadoSiniestro[0] ;
         zm1D46( -5) ;
      }
      pr_default.close(5);
      onLoadActions1D46( ) ;
   }

   public void onLoadActions1D46( )
   {
      AV30Pgmname = "Estado_BC" ;
      GXt_char4 = A685SitDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A334SitDescrip, GXv_char5) ;
      estado_bc.this.GXt_char4 = GXv_char5[0] ;
      A685SitDescripSinAc = GXt_char4 ;
   }

   public void checkExtendedTable1D46( )
   {
      nIsDirty_46 = (short)(0) ;
      standaloneModal( ) ;
      AV30Pgmname = "Estado_BC" ;
      nIsDirty_46 = (short)(1) ;
      GXt_char4 = A685SitDescripSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A334SitDescrip, GXv_char5) ;
      estado_bc.this.GXt_char4 = GXv_char5[0] ;
      A685SitDescripSinAc = GXt_char4 ;
      if ( ! ( ( A1217SitAplicaPlus == 1 ) || ( A1217SitAplicaPlus == 2 ) || ( A1217SitAplicaPlus == 3 ) || ( A1217SitAplicaPlus == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "(borrar) Sit Aplica Plus", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC001D8 */
      pr_default.execute(6, new Object[] {Boolean.valueOf(n1593SitPaiCod), Short.valueOf(A1593SitPaiCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A1593SitPaiCod) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Situacion Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SITPAICOD");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(6);
      /* Using cursor BC001D9 */
      pr_default.execute(7, new Object[] {Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         if ( ! ( (0==A1598EstadoSitRevista) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Situacion Revista", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTADOSITREVISTA");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(7);
      /* Using cursor BC001D10 */
      pr_default.execute(8, new Object[] {Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (GXutil.strcmp("", A1600EstadoSiniestro)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Estado Siniestro Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "ESTADOSINIESTRO");
            AnyError = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void closeExtendedTableCursors1D46( )
   {
      pr_default.close(6);
      pr_default.close(7);
      pr_default.close(8);
   }

   public void enableDisable( )
   {
   }

   public void getKey1D46( )
   {
      /* Using cursor BC001D11 */
      pr_default.execute(9, new Object[] {A16SitCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound46 = (short)(1) ;
      }
      else
      {
         RcdFound46 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001D12 */
      pr_default.execute(10, new Object[] {A16SitCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         zm1D46( 5) ;
         RcdFound46 = (short)(1) ;
         A685SitDescripSinAc = BC001D12_A685SitDescripSinAc[0] ;
         A16SitCodigo = BC001D12_A16SitCodigo[0] ;
         A334SitDescrip = BC001D12_A334SitDescrip[0] ;
         A738SitEsLicencia = BC001D12_A738SitEsLicencia[0] ;
         A739SitLicCuentaTrab = BC001D12_A739SitLicCuentaTrab[0] ;
         A897SitLicMesesProm = BC001D12_A897SitLicMesesProm[0] ;
         A898SitLicMesesProm2 = BC001D12_A898SitLicMesesProm2[0] ;
         A913sItDescAbrev = BC001D12_A913sItDescAbrev[0] ;
         A915SitDiasDivision = BC001D12_A915SitDiasDivision[0] ;
         A916SitEsAusencia = BC001D12_A916SitEsAusencia[0] ;
         A1217SitAplicaPlus = BC001D12_A1217SitAplicaPlus[0] ;
         A1220SitAbsorbeFer = BC001D12_A1220SitAbsorbeFer[0] ;
         A1489SitLicLimiteDef = BC001D12_A1489SitLicLimiteDef[0] ;
         A1490SitLicAdjunDef = BC001D12_A1490SitLicAdjunDef[0] ;
         A1491SitLicAdjOblDef = BC001D12_A1491SitLicAdjOblDef[0] ;
         A1492SitLicNecApr = BC001D12_A1492SitLicNecApr[0] ;
         A1493SitLIcIngMot = BC001D12_A1493SitLIcIngMot[0] ;
         A1494SitLicOblIngMot = BC001D12_A1494SitLicOblIngMot[0] ;
         A1807EstadoCanPresen = BC001D12_A1807EstadoCanPresen[0] ;
         A1809EstadoRemCorr = BC001D12_A1809EstadoRemCorr[0] ;
         A1593SitPaiCod = BC001D12_A1593SitPaiCod[0] ;
         n1593SitPaiCod = BC001D12_n1593SitPaiCod[0] ;
         A1598EstadoSitRevista = BC001D12_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = BC001D12_n1598EstadoSitRevista[0] ;
         A1600EstadoSiniestro = BC001D12_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = BC001D12_n1600EstadoSiniestro[0] ;
         Z16SitCodigo = A16SitCodigo ;
         sMode46 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1D46( ) ;
         if ( AnyError == 1 )
         {
            RcdFound46 = (short)(0) ;
            initializeNonKey1D46( ) ;
         }
         Gx_mode = sMode46 ;
      }
      else
      {
         RcdFound46 = (short)(0) ;
         initializeNonKey1D46( ) ;
         sMode46 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode46 ;
      }
      pr_default.close(10);
   }

   public void getEqualNoModal( )
   {
      getKey1D46( ) ;
      if ( RcdFound46 == 0 )
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
      confirm_1D0( ) ;
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

   public void checkOptimisticConcurrency1D46( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001D13 */
         pr_default.execute(11, new Object[] {A16SitCodigo});
         if ( (pr_default.getStatus(11) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Estado"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(11) == 101) || ( GXutil.strcmp(Z685SitDescripSinAc, BC001D13_A685SitDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z334SitDescrip, BC001D13_A334SitDescrip[0]) != 0 ) || ( Z738SitEsLicencia != BC001D13_A738SitEsLicencia[0] ) || ( Z739SitLicCuentaTrab != BC001D13_A739SitLicCuentaTrab[0] ) || ( Z897SitLicMesesProm != BC001D13_A897SitLicMesesProm[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z898SitLicMesesProm2 != BC001D13_A898SitLicMesesProm2[0] ) || ( GXutil.strcmp(Z913sItDescAbrev, BC001D13_A913sItDescAbrev[0]) != 0 ) || ( DecimalUtil.compareTo(Z915SitDiasDivision, BC001D13_A915SitDiasDivision[0]) != 0 ) || ( Z916SitEsAusencia != BC001D13_A916SitEsAusencia[0] ) || ( Z1217SitAplicaPlus != BC001D13_A1217SitAplicaPlus[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1220SitAbsorbeFer != BC001D13_A1220SitAbsorbeFer[0] ) || ( Z1489SitLicLimiteDef != BC001D13_A1489SitLicLimiteDef[0] ) || ( Z1490SitLicAdjunDef != BC001D13_A1490SitLicAdjunDef[0] ) || ( Z1491SitLicAdjOblDef != BC001D13_A1491SitLicAdjOblDef[0] ) || ( Z1492SitLicNecApr != BC001D13_A1492SitLicNecApr[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1493SitLIcIngMot != BC001D13_A1493SitLIcIngMot[0] ) || ( Z1494SitLicOblIngMot != BC001D13_A1494SitLicOblIngMot[0] ) || ( Z1807EstadoCanPresen != BC001D13_A1807EstadoCanPresen[0] ) || ( Z1809EstadoRemCorr != BC001D13_A1809EstadoRemCorr[0] ) || ( Z1593SitPaiCod != BC001D13_A1593SitPaiCod[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1598EstadoSitRevista != BC001D13_A1598EstadoSitRevista[0] ) || ( GXutil.strcmp(Z1600EstadoSiniestro, BC001D13_A1600EstadoSiniestro[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Estado"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1D46( )
   {
      beforeValidate1D46( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1D46( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1D46( 0) ;
         checkOptimisticConcurrency1D46( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1D46( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1D46( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001D14 */
                  pr_default.execute(12, new Object[] {A685SitDescripSinAc, A16SitCodigo, A334SitDescrip, Boolean.valueOf(A738SitEsLicencia), Boolean.valueOf(A739SitLicCuentaTrab), Byte.valueOf(A897SitLicMesesProm), Byte.valueOf(A898SitLicMesesProm2), A913sItDescAbrev, A915SitDiasDivision, Boolean.valueOf(A916SitEsAusencia), Byte.valueOf(A1217SitAplicaPlus), Boolean.valueOf(A1220SitAbsorbeFer), Short.valueOf(A1489SitLicLimiteDef), Boolean.valueOf(A1490SitLicAdjunDef), Boolean.valueOf(A1491SitLicAdjOblDef), Boolean.valueOf(A1492SitLicNecApr), Boolean.valueOf(A1493SitLIcIngMot), Boolean.valueOf(A1494SitLicOblIngMot), Boolean.valueOf(A1807EstadoCanPresen), Boolean.valueOf(A1809EstadoRemCorr), Boolean.valueOf(n1593SitPaiCod), Short.valueOf(A1593SitPaiCod), Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista), Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Estado");
                  if ( (pr_default.getStatus(12) == 1) )
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
            load1D46( ) ;
         }
         endLevel1D46( ) ;
      }
      closeExtendedTableCursors1D46( ) ;
   }

   public void update1D46( )
   {
      beforeValidate1D46( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1D46( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1D46( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1D46( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1D46( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001D15 */
                  pr_default.execute(13, new Object[] {A685SitDescripSinAc, A334SitDescrip, Boolean.valueOf(A738SitEsLicencia), Boolean.valueOf(A739SitLicCuentaTrab), Byte.valueOf(A897SitLicMesesProm), Byte.valueOf(A898SitLicMesesProm2), A913sItDescAbrev, A915SitDiasDivision, Boolean.valueOf(A916SitEsAusencia), Byte.valueOf(A1217SitAplicaPlus), Boolean.valueOf(A1220SitAbsorbeFer), Short.valueOf(A1489SitLicLimiteDef), Boolean.valueOf(A1490SitLicAdjunDef), Boolean.valueOf(A1491SitLicAdjOblDef), Boolean.valueOf(A1492SitLicNecApr), Boolean.valueOf(A1493SitLIcIngMot), Boolean.valueOf(A1494SitLicOblIngMot), Boolean.valueOf(A1807EstadoCanPresen), Boolean.valueOf(A1809EstadoRemCorr), Boolean.valueOf(n1593SitPaiCod), Short.valueOf(A1593SitPaiCod), Boolean.valueOf(n1598EstadoSitRevista), Short.valueOf(A1598EstadoSitRevista), Boolean.valueOf(n1600EstadoSiniestro), A1600EstadoSiniestro, A16SitCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Estado");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Estado"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1D46( ) ;
                  if ( AnyError == 0 )
                  {
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
         endLevel1D46( ) ;
      }
      closeExtendedTableCursors1D46( ) ;
   }

   public void deferredUpdate1D46( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1D46( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1D46( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1D46( ) ;
         afterConfirm1D46( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1D46( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001D16 */
               pr_default.execute(14, new Object[] {A16SitCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Estado");
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
      sMode46 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1D46( ) ;
      Gx_mode = sMode46 ;
   }

   public void onDeleteControls1D46( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV30Pgmname = "Estado_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC001D17 */
         pr_default.execute(15, new Object[] {A16SitCodigo});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_adicionalCancela", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor BC001D18 */
         pr_default.execute(16, new Object[] {A16SitCodigo});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "convenio_estados_no_presen", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor BC001D19 */
         pr_default.execute(17, new Object[] {A16SitCodigo});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo Licencias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
   }

   public void endLevel1D46( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1D46( ) ;
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

   public void scanKeyStart1D46( )
   {
      /* Scan By routine */
      /* Using cursor BC001D20 */
      pr_default.execute(18, new Object[] {A16SitCodigo});
      RcdFound46 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A685SitDescripSinAc = BC001D20_A685SitDescripSinAc[0] ;
         A16SitCodigo = BC001D20_A16SitCodigo[0] ;
         A334SitDescrip = BC001D20_A334SitDescrip[0] ;
         A738SitEsLicencia = BC001D20_A738SitEsLicencia[0] ;
         A739SitLicCuentaTrab = BC001D20_A739SitLicCuentaTrab[0] ;
         A897SitLicMesesProm = BC001D20_A897SitLicMesesProm[0] ;
         A898SitLicMesesProm2 = BC001D20_A898SitLicMesesProm2[0] ;
         A913sItDescAbrev = BC001D20_A913sItDescAbrev[0] ;
         A915SitDiasDivision = BC001D20_A915SitDiasDivision[0] ;
         A916SitEsAusencia = BC001D20_A916SitEsAusencia[0] ;
         A1217SitAplicaPlus = BC001D20_A1217SitAplicaPlus[0] ;
         A1220SitAbsorbeFer = BC001D20_A1220SitAbsorbeFer[0] ;
         A1489SitLicLimiteDef = BC001D20_A1489SitLicLimiteDef[0] ;
         A1490SitLicAdjunDef = BC001D20_A1490SitLicAdjunDef[0] ;
         A1491SitLicAdjOblDef = BC001D20_A1491SitLicAdjOblDef[0] ;
         A1492SitLicNecApr = BC001D20_A1492SitLicNecApr[0] ;
         A1493SitLIcIngMot = BC001D20_A1493SitLIcIngMot[0] ;
         A1494SitLicOblIngMot = BC001D20_A1494SitLicOblIngMot[0] ;
         A1807EstadoCanPresen = BC001D20_A1807EstadoCanPresen[0] ;
         A1809EstadoRemCorr = BC001D20_A1809EstadoRemCorr[0] ;
         A1593SitPaiCod = BC001D20_A1593SitPaiCod[0] ;
         n1593SitPaiCod = BC001D20_n1593SitPaiCod[0] ;
         A1598EstadoSitRevista = BC001D20_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = BC001D20_n1598EstadoSitRevista[0] ;
         A1600EstadoSiniestro = BC001D20_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = BC001D20_n1600EstadoSiniestro[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1D46( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound46 = (short)(0) ;
      scanKeyLoad1D46( ) ;
   }

   public void scanKeyLoad1D46( )
   {
      sMode46 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound46 = (short)(1) ;
         A685SitDescripSinAc = BC001D20_A685SitDescripSinAc[0] ;
         A16SitCodigo = BC001D20_A16SitCodigo[0] ;
         A334SitDescrip = BC001D20_A334SitDescrip[0] ;
         A738SitEsLicencia = BC001D20_A738SitEsLicencia[0] ;
         A739SitLicCuentaTrab = BC001D20_A739SitLicCuentaTrab[0] ;
         A897SitLicMesesProm = BC001D20_A897SitLicMesesProm[0] ;
         A898SitLicMesesProm2 = BC001D20_A898SitLicMesesProm2[0] ;
         A913sItDescAbrev = BC001D20_A913sItDescAbrev[0] ;
         A915SitDiasDivision = BC001D20_A915SitDiasDivision[0] ;
         A916SitEsAusencia = BC001D20_A916SitEsAusencia[0] ;
         A1217SitAplicaPlus = BC001D20_A1217SitAplicaPlus[0] ;
         A1220SitAbsorbeFer = BC001D20_A1220SitAbsorbeFer[0] ;
         A1489SitLicLimiteDef = BC001D20_A1489SitLicLimiteDef[0] ;
         A1490SitLicAdjunDef = BC001D20_A1490SitLicAdjunDef[0] ;
         A1491SitLicAdjOblDef = BC001D20_A1491SitLicAdjOblDef[0] ;
         A1492SitLicNecApr = BC001D20_A1492SitLicNecApr[0] ;
         A1493SitLIcIngMot = BC001D20_A1493SitLIcIngMot[0] ;
         A1494SitLicOblIngMot = BC001D20_A1494SitLicOblIngMot[0] ;
         A1807EstadoCanPresen = BC001D20_A1807EstadoCanPresen[0] ;
         A1809EstadoRemCorr = BC001D20_A1809EstadoRemCorr[0] ;
         A1593SitPaiCod = BC001D20_A1593SitPaiCod[0] ;
         n1593SitPaiCod = BC001D20_n1593SitPaiCod[0] ;
         A1598EstadoSitRevista = BC001D20_A1598EstadoSitRevista[0] ;
         n1598EstadoSitRevista = BC001D20_n1598EstadoSitRevista[0] ;
         A1600EstadoSiniestro = BC001D20_A1600EstadoSiniestro[0] ;
         n1600EstadoSiniestro = BC001D20_n1600EstadoSiniestro[0] ;
      }
      Gx_mode = sMode46 ;
   }

   public void scanKeyEnd1D46( )
   {
      pr_default.close(18);
   }

   public void afterConfirm1D46( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1D46( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1D46( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1D46( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1D46( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1D46( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1D46( )
   {
   }

   public void send_integrity_lvl_hashes1D46( )
   {
   }

   public void addRow1D46( )
   {
      VarsToRow46( bcEstado) ;
   }

   public void readRow1D46( )
   {
      RowToVars46( bcEstado, 1) ;
   }

   public void initializeNonKey1D46( )
   {
      A685SitDescripSinAc = "" ;
      A334SitDescrip = "" ;
      A738SitEsLicencia = false ;
      A739SitLicCuentaTrab = false ;
      A897SitLicMesesProm = (byte)(0) ;
      A898SitLicMesesProm2 = (byte)(0) ;
      A913sItDescAbrev = "" ;
      A915SitDiasDivision = DecimalUtil.ZERO ;
      A916SitEsAusencia = false ;
      A1217SitAplicaPlus = (byte)(0) ;
      A1220SitAbsorbeFer = false ;
      A1489SitLicLimiteDef = (short)(0) ;
      A1490SitLicAdjunDef = false ;
      A1491SitLicAdjOblDef = false ;
      A1492SitLicNecApr = false ;
      A1493SitLIcIngMot = false ;
      A1494SitLicOblIngMot = false ;
      A1593SitPaiCod = (short)(0) ;
      n1593SitPaiCod = false ;
      A1598EstadoSitRevista = (short)(0) ;
      n1598EstadoSitRevista = false ;
      A1600EstadoSiniestro = "" ;
      n1600EstadoSiniestro = false ;
      A1807EstadoCanPresen = false ;
      A1809EstadoRemCorr = false ;
      Z685SitDescripSinAc = "" ;
      Z334SitDescrip = "" ;
      Z738SitEsLicencia = false ;
      Z739SitLicCuentaTrab = false ;
      Z897SitLicMesesProm = (byte)(0) ;
      Z898SitLicMesesProm2 = (byte)(0) ;
      Z913sItDescAbrev = "" ;
      Z915SitDiasDivision = DecimalUtil.ZERO ;
      Z916SitEsAusencia = false ;
      Z1217SitAplicaPlus = (byte)(0) ;
      Z1220SitAbsorbeFer = false ;
      Z1489SitLicLimiteDef = (short)(0) ;
      Z1490SitLicAdjunDef = false ;
      Z1491SitLicAdjOblDef = false ;
      Z1492SitLicNecApr = false ;
      Z1493SitLIcIngMot = false ;
      Z1494SitLicOblIngMot = false ;
      Z1807EstadoCanPresen = false ;
      Z1809EstadoRemCorr = false ;
      Z1593SitPaiCod = (short)(0) ;
      Z1598EstadoSitRevista = (short)(0) ;
      Z1600EstadoSiniestro = "" ;
   }

   public void initAll1D46( )
   {
      A16SitCodigo = "" ;
      initializeNonKey1D46( ) ;
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

   public void VarsToRow46( web.SdtEstado obj46 )
   {
      obj46.setgxTv_SdtEstado_Mode( Gx_mode );
      obj46.setgxTv_SdtEstado_Sitdescripsinac( A685SitDescripSinAc );
      obj46.setgxTv_SdtEstado_Sitdescrip( A334SitDescrip );
      obj46.setgxTv_SdtEstado_Siteslicencia( A738SitEsLicencia );
      obj46.setgxTv_SdtEstado_Sitliccuentatrab( A739SitLicCuentaTrab );
      obj46.setgxTv_SdtEstado_Sitlicmesesprom( A897SitLicMesesProm );
      obj46.setgxTv_SdtEstado_Sitlicmesesprom2( A898SitLicMesesProm2 );
      obj46.setgxTv_SdtEstado_Sitdescabrev( A913sItDescAbrev );
      obj46.setgxTv_SdtEstado_Sitdiasdivision( A915SitDiasDivision );
      obj46.setgxTv_SdtEstado_Sitesausencia( A916SitEsAusencia );
      obj46.setgxTv_SdtEstado_Sitaplicaplus( A1217SitAplicaPlus );
      obj46.setgxTv_SdtEstado_Sitabsorbefer( A1220SitAbsorbeFer );
      obj46.setgxTv_SdtEstado_Sitliclimitedef( A1489SitLicLimiteDef );
      obj46.setgxTv_SdtEstado_Sitlicadjundef( A1490SitLicAdjunDef );
      obj46.setgxTv_SdtEstado_Sitlicadjobldef( A1491SitLicAdjOblDef );
      obj46.setgxTv_SdtEstado_Sitlicnecapr( A1492SitLicNecApr );
      obj46.setgxTv_SdtEstado_Sitlicingmot( A1493SitLIcIngMot );
      obj46.setgxTv_SdtEstado_Sitlicoblingmot( A1494SitLicOblIngMot );
      obj46.setgxTv_SdtEstado_Sitpaicod( A1593SitPaiCod );
      obj46.setgxTv_SdtEstado_Estadositrevista( A1598EstadoSitRevista );
      obj46.setgxTv_SdtEstado_Estadosiniestro( A1600EstadoSiniestro );
      obj46.setgxTv_SdtEstado_Estadocanpresen( A1807EstadoCanPresen );
      obj46.setgxTv_SdtEstado_Estadoremcorr( A1809EstadoRemCorr );
      obj46.setgxTv_SdtEstado_Sitcodigo( A16SitCodigo );
      obj46.setgxTv_SdtEstado_Sitcodigo_Z( Z16SitCodigo );
      obj46.setgxTv_SdtEstado_Sitdescrip_Z( Z334SitDescrip );
      obj46.setgxTv_SdtEstado_Sitdescripsinac_Z( Z685SitDescripSinAc );
      obj46.setgxTv_SdtEstado_Siteslicencia_Z( Z738SitEsLicencia );
      obj46.setgxTv_SdtEstado_Sitliccuentatrab_Z( Z739SitLicCuentaTrab );
      obj46.setgxTv_SdtEstado_Sitlicmesesprom_Z( Z897SitLicMesesProm );
      obj46.setgxTv_SdtEstado_Sitlicmesesprom2_Z( Z898SitLicMesesProm2 );
      obj46.setgxTv_SdtEstado_Sitdescabrev_Z( Z913sItDescAbrev );
      obj46.setgxTv_SdtEstado_Sitdiasdivision_Z( Z915SitDiasDivision );
      obj46.setgxTv_SdtEstado_Sitesausencia_Z( Z916SitEsAusencia );
      obj46.setgxTv_SdtEstado_Sitaplicaplus_Z( Z1217SitAplicaPlus );
      obj46.setgxTv_SdtEstado_Sitabsorbefer_Z( Z1220SitAbsorbeFer );
      obj46.setgxTv_SdtEstado_Sitliclimitedef_Z( Z1489SitLicLimiteDef );
      obj46.setgxTv_SdtEstado_Sitlicadjundef_Z( Z1490SitLicAdjunDef );
      obj46.setgxTv_SdtEstado_Sitlicadjobldef_Z( Z1491SitLicAdjOblDef );
      obj46.setgxTv_SdtEstado_Sitlicnecapr_Z( Z1492SitLicNecApr );
      obj46.setgxTv_SdtEstado_Sitlicingmot_Z( Z1493SitLIcIngMot );
      obj46.setgxTv_SdtEstado_Sitlicoblingmot_Z( Z1494SitLicOblIngMot );
      obj46.setgxTv_SdtEstado_Sitpaicod_Z( Z1593SitPaiCod );
      obj46.setgxTv_SdtEstado_Estadositrevista_Z( Z1598EstadoSitRevista );
      obj46.setgxTv_SdtEstado_Estadosiniestro_Z( Z1600EstadoSiniestro );
      obj46.setgxTv_SdtEstado_Estadocanpresen_Z( Z1807EstadoCanPresen );
      obj46.setgxTv_SdtEstado_Estadoremcorr_Z( Z1809EstadoRemCorr );
      obj46.setgxTv_SdtEstado_Sitpaicod_N( (byte)((byte)((n1593SitPaiCod)?1:0)) );
      obj46.setgxTv_SdtEstado_Estadositrevista_N( (byte)((byte)((n1598EstadoSitRevista)?1:0)) );
      obj46.setgxTv_SdtEstado_Estadosiniestro_N( (byte)((byte)((n1600EstadoSiniestro)?1:0)) );
      obj46.setgxTv_SdtEstado_Mode( Gx_mode );
   }

   public void KeyVarsToRow46( web.SdtEstado obj46 )
   {
      obj46.setgxTv_SdtEstado_Sitcodigo( A16SitCodigo );
   }

   public void RowToVars46( web.SdtEstado obj46 ,
                            int forceLoad )
   {
      Gx_mode = obj46.getgxTv_SdtEstado_Mode() ;
      A685SitDescripSinAc = obj46.getgxTv_SdtEstado_Sitdescripsinac() ;
      A334SitDescrip = obj46.getgxTv_SdtEstado_Sitdescrip() ;
      A738SitEsLicencia = obj46.getgxTv_SdtEstado_Siteslicencia() ;
      A739SitLicCuentaTrab = obj46.getgxTv_SdtEstado_Sitliccuentatrab() ;
      A897SitLicMesesProm = obj46.getgxTv_SdtEstado_Sitlicmesesprom() ;
      A898SitLicMesesProm2 = obj46.getgxTv_SdtEstado_Sitlicmesesprom2() ;
      A913sItDescAbrev = obj46.getgxTv_SdtEstado_Sitdescabrev() ;
      A915SitDiasDivision = obj46.getgxTv_SdtEstado_Sitdiasdivision() ;
      A916SitEsAusencia = obj46.getgxTv_SdtEstado_Sitesausencia() ;
      A1217SitAplicaPlus = obj46.getgxTv_SdtEstado_Sitaplicaplus() ;
      A1220SitAbsorbeFer = obj46.getgxTv_SdtEstado_Sitabsorbefer() ;
      A1489SitLicLimiteDef = obj46.getgxTv_SdtEstado_Sitliclimitedef() ;
      A1490SitLicAdjunDef = obj46.getgxTv_SdtEstado_Sitlicadjundef() ;
      A1491SitLicAdjOblDef = obj46.getgxTv_SdtEstado_Sitlicadjobldef() ;
      A1492SitLicNecApr = obj46.getgxTv_SdtEstado_Sitlicnecapr() ;
      A1493SitLIcIngMot = obj46.getgxTv_SdtEstado_Sitlicingmot() ;
      A1494SitLicOblIngMot = obj46.getgxTv_SdtEstado_Sitlicoblingmot() ;
      A1593SitPaiCod = obj46.getgxTv_SdtEstado_Sitpaicod() ;
      n1593SitPaiCod = false ;
      A1598EstadoSitRevista = obj46.getgxTv_SdtEstado_Estadositrevista() ;
      n1598EstadoSitRevista = false ;
      A1600EstadoSiniestro = obj46.getgxTv_SdtEstado_Estadosiniestro() ;
      n1600EstadoSiniestro = false ;
      A1807EstadoCanPresen = obj46.getgxTv_SdtEstado_Estadocanpresen() ;
      A1809EstadoRemCorr = obj46.getgxTv_SdtEstado_Estadoremcorr() ;
      A16SitCodigo = obj46.getgxTv_SdtEstado_Sitcodigo() ;
      Z16SitCodigo = obj46.getgxTv_SdtEstado_Sitcodigo_Z() ;
      Z334SitDescrip = obj46.getgxTv_SdtEstado_Sitdescrip_Z() ;
      Z685SitDescripSinAc = obj46.getgxTv_SdtEstado_Sitdescripsinac_Z() ;
      Z738SitEsLicencia = obj46.getgxTv_SdtEstado_Siteslicencia_Z() ;
      Z739SitLicCuentaTrab = obj46.getgxTv_SdtEstado_Sitliccuentatrab_Z() ;
      Z897SitLicMesesProm = obj46.getgxTv_SdtEstado_Sitlicmesesprom_Z() ;
      Z898SitLicMesesProm2 = obj46.getgxTv_SdtEstado_Sitlicmesesprom2_Z() ;
      Z913sItDescAbrev = obj46.getgxTv_SdtEstado_Sitdescabrev_Z() ;
      Z915SitDiasDivision = obj46.getgxTv_SdtEstado_Sitdiasdivision_Z() ;
      Z916SitEsAusencia = obj46.getgxTv_SdtEstado_Sitesausencia_Z() ;
      Z1217SitAplicaPlus = obj46.getgxTv_SdtEstado_Sitaplicaplus_Z() ;
      Z1220SitAbsorbeFer = obj46.getgxTv_SdtEstado_Sitabsorbefer_Z() ;
      Z1489SitLicLimiteDef = obj46.getgxTv_SdtEstado_Sitliclimitedef_Z() ;
      Z1490SitLicAdjunDef = obj46.getgxTv_SdtEstado_Sitlicadjundef_Z() ;
      Z1491SitLicAdjOblDef = obj46.getgxTv_SdtEstado_Sitlicadjobldef_Z() ;
      Z1492SitLicNecApr = obj46.getgxTv_SdtEstado_Sitlicnecapr_Z() ;
      Z1493SitLIcIngMot = obj46.getgxTv_SdtEstado_Sitlicingmot_Z() ;
      Z1494SitLicOblIngMot = obj46.getgxTv_SdtEstado_Sitlicoblingmot_Z() ;
      Z1593SitPaiCod = obj46.getgxTv_SdtEstado_Sitpaicod_Z() ;
      Z1598EstadoSitRevista = obj46.getgxTv_SdtEstado_Estadositrevista_Z() ;
      Z1600EstadoSiniestro = obj46.getgxTv_SdtEstado_Estadosiniestro_Z() ;
      Z1807EstadoCanPresen = obj46.getgxTv_SdtEstado_Estadocanpresen_Z() ;
      Z1809EstadoRemCorr = obj46.getgxTv_SdtEstado_Estadoremcorr_Z() ;
      n1593SitPaiCod = (boolean)((obj46.getgxTv_SdtEstado_Sitpaicod_N()==0)?false:true) ;
      n1598EstadoSitRevista = (boolean)((obj46.getgxTv_SdtEstado_Estadositrevista_N()==0)?false:true) ;
      n1600EstadoSiniestro = (boolean)((obj46.getgxTv_SdtEstado_Estadosiniestro_N()==0)?false:true) ;
      Gx_mode = obj46.getgxTv_SdtEstado_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A16SitCodigo = (String)getParm(obj,0) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1D46( ) ;
      scanKeyStart1D46( ) ;
      if ( RcdFound46 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z16SitCodigo = A16SitCodigo ;
      }
      zm1D46( -5) ;
      onLoadActions1D46( ) ;
      addRow1D46( ) ;
      scanKeyEnd1D46( ) ;
      if ( RcdFound46 == 0 )
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
      RowToVars46( bcEstado, 0) ;
      scanKeyStart1D46( ) ;
      if ( RcdFound46 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z16SitCodigo = A16SitCodigo ;
      }
      zm1D46( -5) ;
      onLoadActions1D46( ) ;
      addRow1D46( ) ;
      scanKeyEnd1D46( ) ;
      if ( RcdFound46 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1D46( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1D46( ) ;
      }
      else
      {
         if ( RcdFound46 == 1 )
         {
            if ( GXutil.strcmp(A16SitCodigo, Z16SitCodigo) != 0 )
            {
               A16SitCodigo = Z16SitCodigo ;
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
               update1D46( ) ;
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
               if ( GXutil.strcmp(A16SitCodigo, Z16SitCodigo) != 0 )
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
                     insert1D46( ) ;
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
                     insert1D46( ) ;
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
      RowToVars46( bcEstado, 1) ;
      saveImpl( ) ;
      VarsToRow46( bcEstado) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars46( bcEstado, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1D46( ) ;
      afterTrn( ) ;
      VarsToRow46( bcEstado) ;
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
         web.SdtEstado auxBC = new web.SdtEstado( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A16SitCodigo);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEstado);
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
      RowToVars46( bcEstado, 1) ;
      updateImpl( ) ;
      VarsToRow46( bcEstado) ;
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
      RowToVars46( bcEstado, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1D46( ) ;
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
      VarsToRow46( bcEstado) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars46( bcEstado, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1D46( ) ;
      if ( RcdFound46 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( GXutil.strcmp(A16SitCodigo, Z16SitCodigo) != 0 )
         {
            A16SitCodigo = Z16SitCodigo ;
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
         if ( GXutil.strcmp(A16SitCodigo, Z16SitCodigo) != 0 )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "estado_bc");
      VarsToRow46( bcEstado) ;
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
      Gx_mode = bcEstado.getgxTv_SdtEstado_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEstado.setgxTv_SdtEstado_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtEstado sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEstado )
      {
         bcEstado = sdt ;
         if ( GXutil.strcmp(bcEstado.getgxTv_SdtEstado_Mode(), "") == 0 )
         {
            bcEstado.setgxTv_SdtEstado_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow46( bcEstado) ;
         }
         else
         {
            RowToVars46( bcEstado, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEstado.getgxTv_SdtEstado_Mode(), "") == 0 )
         {
            bcEstado.setgxTv_SdtEstado_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars46( bcEstado, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEstado getEstado_BC( )
   {
      return bcEstado ;
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
      Z16SitCodigo = "" ;
      A16SitCodigo = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV30Pgmname = "" ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV17TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV19Insert_EstadoSiniestro = "" ;
      Z685SitDescripSinAc = "" ;
      A685SitDescripSinAc = "" ;
      Z334SitDescrip = "" ;
      A334SitDescrip = "" ;
      Z913sItDescAbrev = "" ;
      A913sItDescAbrev = "" ;
      Z915SitDiasDivision = DecimalUtil.ZERO ;
      A915SitDiasDivision = DecimalUtil.ZERO ;
      Z1600EstadoSiniestro = "" ;
      A1600EstadoSiniestro = "" ;
      BC001D7_A685SitDescripSinAc = new String[] {""} ;
      BC001D7_A16SitCodigo = new String[] {""} ;
      BC001D7_A334SitDescrip = new String[] {""} ;
      BC001D7_A738SitEsLicencia = new boolean[] {false} ;
      BC001D7_A739SitLicCuentaTrab = new boolean[] {false} ;
      BC001D7_A897SitLicMesesProm = new byte[1] ;
      BC001D7_A898SitLicMesesProm2 = new byte[1] ;
      BC001D7_A913sItDescAbrev = new String[] {""} ;
      BC001D7_A915SitDiasDivision = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001D7_A916SitEsAusencia = new boolean[] {false} ;
      BC001D7_A1217SitAplicaPlus = new byte[1] ;
      BC001D7_A1220SitAbsorbeFer = new boolean[] {false} ;
      BC001D7_A1489SitLicLimiteDef = new short[1] ;
      BC001D7_A1490SitLicAdjunDef = new boolean[] {false} ;
      BC001D7_A1491SitLicAdjOblDef = new boolean[] {false} ;
      BC001D7_A1492SitLicNecApr = new boolean[] {false} ;
      BC001D7_A1493SitLIcIngMot = new boolean[] {false} ;
      BC001D7_A1494SitLicOblIngMot = new boolean[] {false} ;
      BC001D7_A1807EstadoCanPresen = new boolean[] {false} ;
      BC001D7_A1809EstadoRemCorr = new boolean[] {false} ;
      BC001D7_A1593SitPaiCod = new short[1] ;
      BC001D7_n1593SitPaiCod = new boolean[] {false} ;
      BC001D7_A1598EstadoSitRevista = new short[1] ;
      BC001D7_n1598EstadoSitRevista = new boolean[] {false} ;
      BC001D7_A1600EstadoSiniestro = new String[] {""} ;
      BC001D7_n1600EstadoSiniestro = new boolean[] {false} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      BC001D8_A1593SitPaiCod = new short[1] ;
      BC001D8_n1593SitPaiCod = new boolean[] {false} ;
      BC001D9_A1598EstadoSitRevista = new short[1] ;
      BC001D9_n1598EstadoSitRevista = new boolean[] {false} ;
      BC001D10_A1600EstadoSiniestro = new String[] {""} ;
      BC001D10_n1600EstadoSiniestro = new boolean[] {false} ;
      BC001D11_A16SitCodigo = new String[] {""} ;
      BC001D12_A685SitDescripSinAc = new String[] {""} ;
      BC001D12_A16SitCodigo = new String[] {""} ;
      BC001D12_A334SitDescrip = new String[] {""} ;
      BC001D12_A738SitEsLicencia = new boolean[] {false} ;
      BC001D12_A739SitLicCuentaTrab = new boolean[] {false} ;
      BC001D12_A897SitLicMesesProm = new byte[1] ;
      BC001D12_A898SitLicMesesProm2 = new byte[1] ;
      BC001D12_A913sItDescAbrev = new String[] {""} ;
      BC001D12_A915SitDiasDivision = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001D12_A916SitEsAusencia = new boolean[] {false} ;
      BC001D12_A1217SitAplicaPlus = new byte[1] ;
      BC001D12_A1220SitAbsorbeFer = new boolean[] {false} ;
      BC001D12_A1489SitLicLimiteDef = new short[1] ;
      BC001D12_A1490SitLicAdjunDef = new boolean[] {false} ;
      BC001D12_A1491SitLicAdjOblDef = new boolean[] {false} ;
      BC001D12_A1492SitLicNecApr = new boolean[] {false} ;
      BC001D12_A1493SitLIcIngMot = new boolean[] {false} ;
      BC001D12_A1494SitLicOblIngMot = new boolean[] {false} ;
      BC001D12_A1807EstadoCanPresen = new boolean[] {false} ;
      BC001D12_A1809EstadoRemCorr = new boolean[] {false} ;
      BC001D12_A1593SitPaiCod = new short[1] ;
      BC001D12_n1593SitPaiCod = new boolean[] {false} ;
      BC001D12_A1598EstadoSitRevista = new short[1] ;
      BC001D12_n1598EstadoSitRevista = new boolean[] {false} ;
      BC001D12_A1600EstadoSiniestro = new String[] {""} ;
      BC001D12_n1600EstadoSiniestro = new boolean[] {false} ;
      sMode46 = "" ;
      BC001D13_A685SitDescripSinAc = new String[] {""} ;
      BC001D13_A16SitCodigo = new String[] {""} ;
      BC001D13_A334SitDescrip = new String[] {""} ;
      BC001D13_A738SitEsLicencia = new boolean[] {false} ;
      BC001D13_A739SitLicCuentaTrab = new boolean[] {false} ;
      BC001D13_A897SitLicMesesProm = new byte[1] ;
      BC001D13_A898SitLicMesesProm2 = new byte[1] ;
      BC001D13_A913sItDescAbrev = new String[] {""} ;
      BC001D13_A915SitDiasDivision = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001D13_A916SitEsAusencia = new boolean[] {false} ;
      BC001D13_A1217SitAplicaPlus = new byte[1] ;
      BC001D13_A1220SitAbsorbeFer = new boolean[] {false} ;
      BC001D13_A1489SitLicLimiteDef = new short[1] ;
      BC001D13_A1490SitLicAdjunDef = new boolean[] {false} ;
      BC001D13_A1491SitLicAdjOblDef = new boolean[] {false} ;
      BC001D13_A1492SitLicNecApr = new boolean[] {false} ;
      BC001D13_A1493SitLIcIngMot = new boolean[] {false} ;
      BC001D13_A1494SitLicOblIngMot = new boolean[] {false} ;
      BC001D13_A1807EstadoCanPresen = new boolean[] {false} ;
      BC001D13_A1809EstadoRemCorr = new boolean[] {false} ;
      BC001D13_A1593SitPaiCod = new short[1] ;
      BC001D13_n1593SitPaiCod = new boolean[] {false} ;
      BC001D13_A1598EstadoSitRevista = new short[1] ;
      BC001D13_n1598EstadoSitRevista = new boolean[] {false} ;
      BC001D13_A1600EstadoSiniestro = new String[] {""} ;
      BC001D13_n1600EstadoSiniestro = new boolean[] {false} ;
      BC001D17_A3CliCod = new int[1] ;
      BC001D17_A1564CliPaiConve = new short[1] ;
      BC001D17_A1565CliConvenio = new String[] {""} ;
      BC001D17_A996ConveAdicod = new String[] {""} ;
      BC001D17_A1824ConveAdiSitCancela = new String[] {""} ;
      BC001D18_A3CliCod = new int[1] ;
      BC001D18_A1564CliPaiConve = new short[1] ;
      BC001D18_A1565CliConvenio = new String[] {""} ;
      BC001D18_A1805ConveSitPresen = new String[] {""} ;
      BC001D19_A3CliCod = new int[1] ;
      BC001D19_A1EmpCod = new short[1] ;
      BC001D19_A6LegNumero = new int[1] ;
      BC001D19_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC001D20_A685SitDescripSinAc = new String[] {""} ;
      BC001D20_A16SitCodigo = new String[] {""} ;
      BC001D20_A334SitDescrip = new String[] {""} ;
      BC001D20_A738SitEsLicencia = new boolean[] {false} ;
      BC001D20_A739SitLicCuentaTrab = new boolean[] {false} ;
      BC001D20_A897SitLicMesesProm = new byte[1] ;
      BC001D20_A898SitLicMesesProm2 = new byte[1] ;
      BC001D20_A913sItDescAbrev = new String[] {""} ;
      BC001D20_A915SitDiasDivision = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001D20_A916SitEsAusencia = new boolean[] {false} ;
      BC001D20_A1217SitAplicaPlus = new byte[1] ;
      BC001D20_A1220SitAbsorbeFer = new boolean[] {false} ;
      BC001D20_A1489SitLicLimiteDef = new short[1] ;
      BC001D20_A1490SitLicAdjunDef = new boolean[] {false} ;
      BC001D20_A1491SitLicAdjOblDef = new boolean[] {false} ;
      BC001D20_A1492SitLicNecApr = new boolean[] {false} ;
      BC001D20_A1493SitLIcIngMot = new boolean[] {false} ;
      BC001D20_A1494SitLicOblIngMot = new boolean[] {false} ;
      BC001D20_A1807EstadoCanPresen = new boolean[] {false} ;
      BC001D20_A1809EstadoRemCorr = new boolean[] {false} ;
      BC001D20_A1593SitPaiCod = new short[1] ;
      BC001D20_n1593SitPaiCod = new boolean[] {false} ;
      BC001D20_A1598EstadoSitRevista = new short[1] ;
      BC001D20_n1598EstadoSitRevista = new boolean[] {false} ;
      BC001D20_A1600EstadoSiniestro = new String[] {""} ;
      BC001D20_n1600EstadoSiniestro = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.estado_bc__default(),
         new Object[] {
             new Object[] {
            BC001D2_A685SitDescripSinAc, BC001D2_A16SitCodigo, BC001D2_A334SitDescrip, BC001D2_A738SitEsLicencia, BC001D2_A739SitLicCuentaTrab, BC001D2_A897SitLicMesesProm, BC001D2_A898SitLicMesesProm2, BC001D2_A913sItDescAbrev, BC001D2_A915SitDiasDivision, BC001D2_A916SitEsAusencia,
            BC001D2_A1217SitAplicaPlus, BC001D2_A1220SitAbsorbeFer, BC001D2_A1489SitLicLimiteDef, BC001D2_A1490SitLicAdjunDef, BC001D2_A1491SitLicAdjOblDef, BC001D2_A1492SitLicNecApr, BC001D2_A1493SitLIcIngMot, BC001D2_A1494SitLicOblIngMot, BC001D2_A1807EstadoCanPresen, BC001D2_A1809EstadoRemCorr,
            BC001D2_A1593SitPaiCod, BC001D2_n1593SitPaiCod, BC001D2_A1598EstadoSitRevista, BC001D2_n1598EstadoSitRevista, BC001D2_A1600EstadoSiniestro, BC001D2_n1600EstadoSiniestro
            }
            , new Object[] {
            BC001D3_A685SitDescripSinAc, BC001D3_A16SitCodigo, BC001D3_A334SitDescrip, BC001D3_A738SitEsLicencia, BC001D3_A739SitLicCuentaTrab, BC001D3_A897SitLicMesesProm, BC001D3_A898SitLicMesesProm2, BC001D3_A913sItDescAbrev, BC001D3_A915SitDiasDivision, BC001D3_A916SitEsAusencia,
            BC001D3_A1217SitAplicaPlus, BC001D3_A1220SitAbsorbeFer, BC001D3_A1489SitLicLimiteDef, BC001D3_A1490SitLicAdjunDef, BC001D3_A1491SitLicAdjOblDef, BC001D3_A1492SitLicNecApr, BC001D3_A1493SitLIcIngMot, BC001D3_A1494SitLicOblIngMot, BC001D3_A1807EstadoCanPresen, BC001D3_A1809EstadoRemCorr,
            BC001D3_A1593SitPaiCod, BC001D3_n1593SitPaiCod, BC001D3_A1598EstadoSitRevista, BC001D3_n1598EstadoSitRevista, BC001D3_A1600EstadoSiniestro, BC001D3_n1600EstadoSiniestro
            }
            , new Object[] {
            BC001D4_A1593SitPaiCod
            }
            , new Object[] {
            BC001D5_A1598EstadoSitRevista
            }
            , new Object[] {
            BC001D6_A1600EstadoSiniestro
            }
            , new Object[] {
            BC001D7_A685SitDescripSinAc, BC001D7_A16SitCodigo, BC001D7_A334SitDescrip, BC001D7_A738SitEsLicencia, BC001D7_A739SitLicCuentaTrab, BC001D7_A897SitLicMesesProm, BC001D7_A898SitLicMesesProm2, BC001D7_A913sItDescAbrev, BC001D7_A915SitDiasDivision, BC001D7_A916SitEsAusencia,
            BC001D7_A1217SitAplicaPlus, BC001D7_A1220SitAbsorbeFer, BC001D7_A1489SitLicLimiteDef, BC001D7_A1490SitLicAdjunDef, BC001D7_A1491SitLicAdjOblDef, BC001D7_A1492SitLicNecApr, BC001D7_A1493SitLIcIngMot, BC001D7_A1494SitLicOblIngMot, BC001D7_A1807EstadoCanPresen, BC001D7_A1809EstadoRemCorr,
            BC001D7_A1593SitPaiCod, BC001D7_n1593SitPaiCod, BC001D7_A1598EstadoSitRevista, BC001D7_n1598EstadoSitRevista, BC001D7_A1600EstadoSiniestro, BC001D7_n1600EstadoSiniestro
            }
            , new Object[] {
            BC001D8_A1593SitPaiCod
            }
            , new Object[] {
            BC001D9_A1598EstadoSitRevista
            }
            , new Object[] {
            BC001D10_A1600EstadoSiniestro
            }
            , new Object[] {
            BC001D11_A16SitCodigo
            }
            , new Object[] {
            BC001D12_A685SitDescripSinAc, BC001D12_A16SitCodigo, BC001D12_A334SitDescrip, BC001D12_A738SitEsLicencia, BC001D12_A739SitLicCuentaTrab, BC001D12_A897SitLicMesesProm, BC001D12_A898SitLicMesesProm2, BC001D12_A913sItDescAbrev, BC001D12_A915SitDiasDivision, BC001D12_A916SitEsAusencia,
            BC001D12_A1217SitAplicaPlus, BC001D12_A1220SitAbsorbeFer, BC001D12_A1489SitLicLimiteDef, BC001D12_A1490SitLicAdjunDef, BC001D12_A1491SitLicAdjOblDef, BC001D12_A1492SitLicNecApr, BC001D12_A1493SitLIcIngMot, BC001D12_A1494SitLicOblIngMot, BC001D12_A1807EstadoCanPresen, BC001D12_A1809EstadoRemCorr,
            BC001D12_A1593SitPaiCod, BC001D12_n1593SitPaiCod, BC001D12_A1598EstadoSitRevista, BC001D12_n1598EstadoSitRevista, BC001D12_A1600EstadoSiniestro, BC001D12_n1600EstadoSiniestro
            }
            , new Object[] {
            BC001D13_A685SitDescripSinAc, BC001D13_A16SitCodigo, BC001D13_A334SitDescrip, BC001D13_A738SitEsLicencia, BC001D13_A739SitLicCuentaTrab, BC001D13_A897SitLicMesesProm, BC001D13_A898SitLicMesesProm2, BC001D13_A913sItDescAbrev, BC001D13_A915SitDiasDivision, BC001D13_A916SitEsAusencia,
            BC001D13_A1217SitAplicaPlus, BC001D13_A1220SitAbsorbeFer, BC001D13_A1489SitLicLimiteDef, BC001D13_A1490SitLicAdjunDef, BC001D13_A1491SitLicAdjOblDef, BC001D13_A1492SitLicNecApr, BC001D13_A1493SitLIcIngMot, BC001D13_A1494SitLicOblIngMot, BC001D13_A1807EstadoCanPresen, BC001D13_A1809EstadoRemCorr,
            BC001D13_A1593SitPaiCod, BC001D13_n1593SitPaiCod, BC001D13_A1598EstadoSitRevista, BC001D13_n1598EstadoSitRevista, BC001D13_A1600EstadoSiniestro, BC001D13_n1600EstadoSiniestro
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001D17_A3CliCod, BC001D17_A1564CliPaiConve, BC001D17_A1565CliConvenio, BC001D17_A996ConveAdicod, BC001D17_A1824ConveAdiSitCancela
            }
            , new Object[] {
            BC001D18_A3CliCod, BC001D18_A1564CliPaiConve, BC001D18_A1565CliConvenio, BC001D18_A1805ConveSitPresen
            }
            , new Object[] {
            BC001D19_A3CliCod, BC001D19_A1EmpCod, BC001D19_A6LegNumero, BC001D19_A76LegLicenIni
            }
            , new Object[] {
            BC001D20_A685SitDescripSinAc, BC001D20_A16SitCodigo, BC001D20_A334SitDescrip, BC001D20_A738SitEsLicencia, BC001D20_A739SitLicCuentaTrab, BC001D20_A897SitLicMesesProm, BC001D20_A898SitLicMesesProm2, BC001D20_A913sItDescAbrev, BC001D20_A915SitDiasDivision, BC001D20_A916SitEsAusencia,
            BC001D20_A1217SitAplicaPlus, BC001D20_A1220SitAbsorbeFer, BC001D20_A1489SitLicLimiteDef, BC001D20_A1490SitLicAdjunDef, BC001D20_A1491SitLicAdjOblDef, BC001D20_A1492SitLicNecApr, BC001D20_A1493SitLIcIngMot, BC001D20_A1494SitLicOblIngMot, BC001D20_A1807EstadoCanPresen, BC001D20_A1809EstadoRemCorr,
            BC001D20_A1593SitPaiCod, BC001D20_n1593SitPaiCod, BC001D20_A1598EstadoSitRevista, BC001D20_n1598EstadoSitRevista, BC001D20_A1600EstadoSiniestro, BC001D20_n1600EstadoSiniestro
            }
         }
      );
      AV30Pgmname = "Estado_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e121D2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z897SitLicMesesProm ;
   private byte A897SitLicMesesProm ;
   private byte Z898SitLicMesesProm2 ;
   private byte A898SitLicMesesProm2 ;
   private byte Z1217SitAplicaPlus ;
   private byte A1217SitAplicaPlus ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV16Insert_SitPaiCod ;
   private short AV18Insert_EstadoSitRevista ;
   private short Z1489SitLicLimiteDef ;
   private short A1489SitLicLimiteDef ;
   private short Z1593SitPaiCod ;
   private short A1593SitPaiCod ;
   private short Z1598EstadoSitRevista ;
   private short A1598EstadoSitRevista ;
   private short RcdFound46 ;
   private short nIsDirty_46 ;
   private int trnEnded ;
   private int AV31GXV1 ;
   private int GX_JID ;
   private java.math.BigDecimal Z915SitDiasDivision ;
   private java.math.BigDecimal A915SitDiasDivision ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z16SitCodigo ;
   private String A16SitCodigo ;
   private String AV30Pgmname ;
   private String AV19Insert_EstadoSiniestro ;
   private String Z1600EstadoSiniestro ;
   private String A1600EstadoSiniestro ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String sMode46 ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z738SitEsLicencia ;
   private boolean A738SitEsLicencia ;
   private boolean Z739SitLicCuentaTrab ;
   private boolean A739SitLicCuentaTrab ;
   private boolean Z916SitEsAusencia ;
   private boolean A916SitEsAusencia ;
   private boolean Z1220SitAbsorbeFer ;
   private boolean A1220SitAbsorbeFer ;
   private boolean Z1490SitLicAdjunDef ;
   private boolean A1490SitLicAdjunDef ;
   private boolean Z1491SitLicAdjOblDef ;
   private boolean A1491SitLicAdjOblDef ;
   private boolean Z1492SitLicNecApr ;
   private boolean A1492SitLicNecApr ;
   private boolean Z1493SitLIcIngMot ;
   private boolean A1493SitLIcIngMot ;
   private boolean Z1494SitLicOblIngMot ;
   private boolean A1494SitLicOblIngMot ;
   private boolean Z1807EstadoCanPresen ;
   private boolean A1807EstadoCanPresen ;
   private boolean Z1809EstadoRemCorr ;
   private boolean A1809EstadoRemCorr ;
   private boolean n1593SitPaiCod ;
   private boolean n1598EstadoSitRevista ;
   private boolean n1600EstadoSiniestro ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z685SitDescripSinAc ;
   private String A685SitDescripSinAc ;
   private String Z334SitDescrip ;
   private String A334SitDescrip ;
   private String Z913sItDescAbrev ;
   private String A913sItDescAbrev ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private web.SdtEstado bcEstado ;
   private IDataStoreProvider pr_default ;
   private String[] BC001D7_A685SitDescripSinAc ;
   private String[] BC001D7_A16SitCodigo ;
   private String[] BC001D7_A334SitDescrip ;
   private boolean[] BC001D7_A738SitEsLicencia ;
   private boolean[] BC001D7_A739SitLicCuentaTrab ;
   private byte[] BC001D7_A897SitLicMesesProm ;
   private byte[] BC001D7_A898SitLicMesesProm2 ;
   private String[] BC001D7_A913sItDescAbrev ;
   private java.math.BigDecimal[] BC001D7_A915SitDiasDivision ;
   private boolean[] BC001D7_A916SitEsAusencia ;
   private byte[] BC001D7_A1217SitAplicaPlus ;
   private boolean[] BC001D7_A1220SitAbsorbeFer ;
   private short[] BC001D7_A1489SitLicLimiteDef ;
   private boolean[] BC001D7_A1490SitLicAdjunDef ;
   private boolean[] BC001D7_A1491SitLicAdjOblDef ;
   private boolean[] BC001D7_A1492SitLicNecApr ;
   private boolean[] BC001D7_A1493SitLIcIngMot ;
   private boolean[] BC001D7_A1494SitLicOblIngMot ;
   private boolean[] BC001D7_A1807EstadoCanPresen ;
   private boolean[] BC001D7_A1809EstadoRemCorr ;
   private short[] BC001D7_A1593SitPaiCod ;
   private boolean[] BC001D7_n1593SitPaiCod ;
   private short[] BC001D7_A1598EstadoSitRevista ;
   private boolean[] BC001D7_n1598EstadoSitRevista ;
   private String[] BC001D7_A1600EstadoSiniestro ;
   private boolean[] BC001D7_n1600EstadoSiniestro ;
   private short[] BC001D8_A1593SitPaiCod ;
   private boolean[] BC001D8_n1593SitPaiCod ;
   private short[] BC001D9_A1598EstadoSitRevista ;
   private boolean[] BC001D9_n1598EstadoSitRevista ;
   private String[] BC001D10_A1600EstadoSiniestro ;
   private boolean[] BC001D10_n1600EstadoSiniestro ;
   private String[] BC001D11_A16SitCodigo ;
   private String[] BC001D12_A685SitDescripSinAc ;
   private String[] BC001D12_A16SitCodigo ;
   private String[] BC001D12_A334SitDescrip ;
   private boolean[] BC001D12_A738SitEsLicencia ;
   private boolean[] BC001D12_A739SitLicCuentaTrab ;
   private byte[] BC001D12_A897SitLicMesesProm ;
   private byte[] BC001D12_A898SitLicMesesProm2 ;
   private String[] BC001D12_A913sItDescAbrev ;
   private java.math.BigDecimal[] BC001D12_A915SitDiasDivision ;
   private boolean[] BC001D12_A916SitEsAusencia ;
   private byte[] BC001D12_A1217SitAplicaPlus ;
   private boolean[] BC001D12_A1220SitAbsorbeFer ;
   private short[] BC001D12_A1489SitLicLimiteDef ;
   private boolean[] BC001D12_A1490SitLicAdjunDef ;
   private boolean[] BC001D12_A1491SitLicAdjOblDef ;
   private boolean[] BC001D12_A1492SitLicNecApr ;
   private boolean[] BC001D12_A1493SitLIcIngMot ;
   private boolean[] BC001D12_A1494SitLicOblIngMot ;
   private boolean[] BC001D12_A1807EstadoCanPresen ;
   private boolean[] BC001D12_A1809EstadoRemCorr ;
   private short[] BC001D12_A1593SitPaiCod ;
   private boolean[] BC001D12_n1593SitPaiCod ;
   private short[] BC001D12_A1598EstadoSitRevista ;
   private boolean[] BC001D12_n1598EstadoSitRevista ;
   private String[] BC001D12_A1600EstadoSiniestro ;
   private boolean[] BC001D12_n1600EstadoSiniestro ;
   private String[] BC001D13_A685SitDescripSinAc ;
   private String[] BC001D13_A16SitCodigo ;
   private String[] BC001D13_A334SitDescrip ;
   private boolean[] BC001D13_A738SitEsLicencia ;
   private boolean[] BC001D13_A739SitLicCuentaTrab ;
   private byte[] BC001D13_A897SitLicMesesProm ;
   private byte[] BC001D13_A898SitLicMesesProm2 ;
   private String[] BC001D13_A913sItDescAbrev ;
   private java.math.BigDecimal[] BC001D13_A915SitDiasDivision ;
   private boolean[] BC001D13_A916SitEsAusencia ;
   private byte[] BC001D13_A1217SitAplicaPlus ;
   private boolean[] BC001D13_A1220SitAbsorbeFer ;
   private short[] BC001D13_A1489SitLicLimiteDef ;
   private boolean[] BC001D13_A1490SitLicAdjunDef ;
   private boolean[] BC001D13_A1491SitLicAdjOblDef ;
   private boolean[] BC001D13_A1492SitLicNecApr ;
   private boolean[] BC001D13_A1493SitLIcIngMot ;
   private boolean[] BC001D13_A1494SitLicOblIngMot ;
   private boolean[] BC001D13_A1807EstadoCanPresen ;
   private boolean[] BC001D13_A1809EstadoRemCorr ;
   private short[] BC001D13_A1593SitPaiCod ;
   private boolean[] BC001D13_n1593SitPaiCod ;
   private short[] BC001D13_A1598EstadoSitRevista ;
   private boolean[] BC001D13_n1598EstadoSitRevista ;
   private String[] BC001D13_A1600EstadoSiniestro ;
   private boolean[] BC001D13_n1600EstadoSiniestro ;
   private int[] BC001D17_A3CliCod ;
   private short[] BC001D17_A1564CliPaiConve ;
   private String[] BC001D17_A1565CliConvenio ;
   private String[] BC001D17_A996ConveAdicod ;
   private String[] BC001D17_A1824ConveAdiSitCancela ;
   private int[] BC001D18_A3CliCod ;
   private short[] BC001D18_A1564CliPaiConve ;
   private String[] BC001D18_A1565CliConvenio ;
   private String[] BC001D18_A1805ConveSitPresen ;
   private int[] BC001D19_A3CliCod ;
   private short[] BC001D19_A1EmpCod ;
   private int[] BC001D19_A6LegNumero ;
   private java.util.Date[] BC001D19_A76LegLicenIni ;
   private String[] BC001D20_A685SitDescripSinAc ;
   private String[] BC001D20_A16SitCodigo ;
   private String[] BC001D20_A334SitDescrip ;
   private boolean[] BC001D20_A738SitEsLicencia ;
   private boolean[] BC001D20_A739SitLicCuentaTrab ;
   private byte[] BC001D20_A897SitLicMesesProm ;
   private byte[] BC001D20_A898SitLicMesesProm2 ;
   private String[] BC001D20_A913sItDescAbrev ;
   private java.math.BigDecimal[] BC001D20_A915SitDiasDivision ;
   private boolean[] BC001D20_A916SitEsAusencia ;
   private byte[] BC001D20_A1217SitAplicaPlus ;
   private boolean[] BC001D20_A1220SitAbsorbeFer ;
   private short[] BC001D20_A1489SitLicLimiteDef ;
   private boolean[] BC001D20_A1490SitLicAdjunDef ;
   private boolean[] BC001D20_A1491SitLicAdjOblDef ;
   private boolean[] BC001D20_A1492SitLicNecApr ;
   private boolean[] BC001D20_A1493SitLIcIngMot ;
   private boolean[] BC001D20_A1494SitLicOblIngMot ;
   private boolean[] BC001D20_A1807EstadoCanPresen ;
   private boolean[] BC001D20_A1809EstadoRemCorr ;
   private short[] BC001D20_A1593SitPaiCod ;
   private boolean[] BC001D20_n1593SitPaiCod ;
   private short[] BC001D20_A1598EstadoSitRevista ;
   private boolean[] BC001D20_n1598EstadoSitRevista ;
   private String[] BC001D20_A1600EstadoSiniestro ;
   private boolean[] BC001D20_n1600EstadoSiniestro ;
   private String[] BC001D2_A685SitDescripSinAc ;
   private String[] BC001D2_A16SitCodigo ;
   private String[] BC001D2_A334SitDescrip ;
   private boolean[] BC001D2_A738SitEsLicencia ;
   private boolean[] BC001D2_A739SitLicCuentaTrab ;
   private byte[] BC001D2_A897SitLicMesesProm ;
   private byte[] BC001D2_A898SitLicMesesProm2 ;
   private String[] BC001D2_A913sItDescAbrev ;
   private java.math.BigDecimal[] BC001D2_A915SitDiasDivision ;
   private boolean[] BC001D2_A916SitEsAusencia ;
   private byte[] BC001D2_A1217SitAplicaPlus ;
   private boolean[] BC001D2_A1220SitAbsorbeFer ;
   private short[] BC001D2_A1489SitLicLimiteDef ;
   private boolean[] BC001D2_A1490SitLicAdjunDef ;
   private boolean[] BC001D2_A1491SitLicAdjOblDef ;
   private boolean[] BC001D2_A1492SitLicNecApr ;
   private boolean[] BC001D2_A1493SitLIcIngMot ;
   private boolean[] BC001D2_A1494SitLicOblIngMot ;
   private boolean[] BC001D2_A1807EstadoCanPresen ;
   private boolean[] BC001D2_A1809EstadoRemCorr ;
   private short[] BC001D2_A1593SitPaiCod ;
   private short[] BC001D2_A1598EstadoSitRevista ;
   private String[] BC001D2_A1600EstadoSiniestro ;
   private String[] BC001D3_A685SitDescripSinAc ;
   private String[] BC001D3_A16SitCodigo ;
   private String[] BC001D3_A334SitDescrip ;
   private boolean[] BC001D3_A738SitEsLicencia ;
   private boolean[] BC001D3_A739SitLicCuentaTrab ;
   private byte[] BC001D3_A897SitLicMesesProm ;
   private byte[] BC001D3_A898SitLicMesesProm2 ;
   private String[] BC001D3_A913sItDescAbrev ;
   private java.math.BigDecimal[] BC001D3_A915SitDiasDivision ;
   private boolean[] BC001D3_A916SitEsAusencia ;
   private byte[] BC001D3_A1217SitAplicaPlus ;
   private boolean[] BC001D3_A1220SitAbsorbeFer ;
   private short[] BC001D3_A1489SitLicLimiteDef ;
   private boolean[] BC001D3_A1490SitLicAdjunDef ;
   private boolean[] BC001D3_A1491SitLicAdjOblDef ;
   private boolean[] BC001D3_A1492SitLicNecApr ;
   private boolean[] BC001D3_A1493SitLIcIngMot ;
   private boolean[] BC001D3_A1494SitLicOblIngMot ;
   private boolean[] BC001D3_A1807EstadoCanPresen ;
   private boolean[] BC001D3_A1809EstadoRemCorr ;
   private short[] BC001D3_A1593SitPaiCod ;
   private short[] BC001D3_A1598EstadoSitRevista ;
   private String[] BC001D3_A1600EstadoSiniestro ;
   private short[] BC001D4_A1593SitPaiCod ;
   private short[] BC001D5_A1598EstadoSitRevista ;
   private String[] BC001D6_A1600EstadoSiniestro ;
   private boolean[] BC001D2_n1593SitPaiCod ;
   private boolean[] BC001D2_n1598EstadoSitRevista ;
   private boolean[] BC001D2_n1600EstadoSiniestro ;
   private boolean[] BC001D3_n1593SitPaiCod ;
   private boolean[] BC001D3_n1598EstadoSitRevista ;
   private boolean[] BC001D3_n1600EstadoSiniestro ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV17TrnContextAtt ;
}

final  class estado_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC001D2", "SELECT SitDescripSinAc, SitCodigo, SitDescrip, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, EstadoCanPresen, EstadoRemCorr, SitPaiCod, EstadoSitRevista, EstadoSiniestro FROM Estado WHERE SitCodigo = ?  FOR UPDATE OF Estado",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D3", "SELECT SitDescripSinAc, SitCodigo, SitDescrip, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, EstadoCanPresen, EstadoRemCorr, SitPaiCod, EstadoSitRevista, EstadoSiniestro FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D4", "SELECT PaiCod AS SitPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D5", "SELECT SitRevCodigo AS EstadoSitRevista FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D6", "SELECT SinieCodigo AS EstadoSiniestro FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D7", "SELECT TM1.SitDescripSinAc, TM1.SitCodigo, TM1.SitDescrip, TM1.SitEsLicencia, TM1.SitLicCuentaTrab, TM1.SitLicMesesProm, TM1.SitLicMesesProm2, TM1.sItDescAbrev, TM1.SitDiasDivision, TM1.SitEsAusencia, TM1.SitAplicaPlus, TM1.SitAbsorbeFer, TM1.SitLicLimiteDef, TM1.SitLicAdjunDef, TM1.SitLicAdjOblDef, TM1.SitLicNecApr, TM1.SitLIcIngMot, TM1.SitLicOblIngMot, TM1.EstadoCanPresen, TM1.EstadoRemCorr, TM1.SitPaiCod AS SitPaiCod, TM1.EstadoSitRevista AS EstadoSitRevista, TM1.EstadoSiniestro AS EstadoSiniestro FROM Estado TM1 WHERE TM1.SitCodigo = ( ?) ORDER BY TM1.SitCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D8", "SELECT PaiCod AS SitPaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D9", "SELECT SitRevCodigo AS EstadoSitRevista FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D10", "SELECT SinieCodigo AS EstadoSiniestro FROM Siniestrado WHERE SinieCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D11", "SELECT SitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D12", "SELECT SitDescripSinAc, SitCodigo, SitDescrip, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, EstadoCanPresen, EstadoRemCorr, SitPaiCod, EstadoSitRevista, EstadoSiniestro FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001D13", "SELECT SitDescripSinAc, SitCodigo, SitDescrip, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, EstadoCanPresen, EstadoRemCorr, SitPaiCod, EstadoSitRevista, EstadoSiniestro FROM Estado WHERE SitCodigo = ?  FOR UPDATE OF Estado",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001D14", "SAVEPOINT gxupdate;INSERT INTO Estado(SitDescripSinAc, SitCodigo, SitDescrip, SitEsLicencia, SitLicCuentaTrab, SitLicMesesProm, SitLicMesesProm2, sItDescAbrev, SitDiasDivision, SitEsAusencia, SitAplicaPlus, SitAbsorbeFer, SitLicLimiteDef, SitLicAdjunDef, SitLicAdjOblDef, SitLicNecApr, SitLIcIngMot, SitLicOblIngMot, EstadoCanPresen, EstadoRemCorr, SitPaiCod, EstadoSitRevista, EstadoSiniestro) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001D15", "SAVEPOINT gxupdate;UPDATE Estado SET SitDescripSinAc=?, SitDescrip=?, SitEsLicencia=?, SitLicCuentaTrab=?, SitLicMesesProm=?, SitLicMesesProm2=?, sItDescAbrev=?, SitDiasDivision=?, SitEsAusencia=?, SitAplicaPlus=?, SitAbsorbeFer=?, SitLicLimiteDef=?, SitLicAdjunDef=?, SitLicAdjOblDef=?, SitLicNecApr=?, SitLIcIngMot=?, SitLicOblIngMot=?, EstadoCanPresen=?, EstadoRemCorr=?, SitPaiCod=?, EstadoSitRevista=?, EstadoSiniestro=?  WHERE SitCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001D16", "SAVEPOINT gxupdate;DELETE FROM Estado  WHERE SitCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001D17", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE ConveAdiSitCancela = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001D18", "SELECT CliCod, CliPaiConve, CliConvenio, ConveSitPresen FROM convenio_estados_no_presen WHERE ConveSitPresen = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001D19", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE LegLicSitCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001D20", "SELECT TM1.SitDescripSinAc, TM1.SitCodigo, TM1.SitDescrip, TM1.SitEsLicencia, TM1.SitLicCuentaTrab, TM1.SitLicMesesProm, TM1.SitLicMesesProm2, TM1.sItDescAbrev, TM1.SitDiasDivision, TM1.SitEsAusencia, TM1.SitAplicaPlus, TM1.SitAbsorbeFer, TM1.SitLicLimiteDef, TM1.SitLicAdjunDef, TM1.SitLicAdjOblDef, TM1.SitLicNecApr, TM1.SitLIcIngMot, TM1.SitLicOblIngMot, TM1.EstadoCanPresen, TM1.EstadoRemCorr, TM1.SitPaiCod AS SitPaiCod, TM1.EstadoSitRevista AS EstadoSitRevista, TM1.EstadoSiniestro AS EstadoSiniestro FROM Estado TM1 WHERE TM1.SitCodigo = ( ?) ORDER BY TM1.SitCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 4);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 4);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,1);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((short[]) buf[12])[0] = rslt.getShort(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(17);
               ((boolean[]) buf[17])[0] = rslt.getBoolean(18);
               ((boolean[]) buf[18])[0] = rslt.getBoolean(19);
               ((boolean[]) buf[19])[0] = rslt.getBoolean(20);
               ((short[]) buf[20])[0] = rslt.getShort(21);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(22);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(23, 4);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
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
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 6 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 7 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 4);
               }
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setString(2, (String)parms[1], 4);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(18, ((Boolean) parms[17]).booleanValue());
               stmt.setBoolean(19, ((Boolean) parms[18]).booleanValue());
               stmt.setBoolean(20, ((Boolean) parms[19]).booleanValue());
               if ( ((Boolean) parms[20]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(21, ((Number) parms[21]).shortValue());
               }
               if ( ((Boolean) parms[22]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(22, ((Number) parms[23]).shortValue());
               }
               if ( ((Boolean) parms[24]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(23, (String)parms[25], 4);
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 1);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setBoolean(13, ((Boolean) parms[12]).booleanValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(16, ((Boolean) parms[15]).booleanValue());
               stmt.setBoolean(17, ((Boolean) parms[16]).booleanValue());
               stmt.setBoolean(18, ((Boolean) parms[17]).booleanValue());
               stmt.setBoolean(19, ((Boolean) parms[18]).booleanValue());
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(20, ((Number) parms[20]).shortValue());
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(21, ((Number) parms[22]).shortValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 22 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(22, (String)parms[24], 4);
               }
               stmt.setString(23, (String)parms[25], 4);
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 17 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 4);
               return;
      }
   }

}

