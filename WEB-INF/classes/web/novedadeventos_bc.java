package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class novedadeventos_bc extends GXWebPanel implements IGxSilentTrn
{
   public novedadeventos_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public novedadeventos_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadeventos_bc.class ));
   }

   public novedadeventos_bc( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow3164( ) ;
      standaloneNotModal( ) ;
      initializeNonKey3164( ) ;
      standaloneModal( ) ;
      addRow3164( ) ;
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
         e11312 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z76LegLicenIni = A76LegLicenIni ;
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

   public void confirm_310( )
   {
      beforeValidate3164( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3164( ) ;
         }
         else
         {
            checkExtendedTable3164( ) ;
            if ( AnyError == 0 )
            {
               zm3164( 13) ;
               zm3164( 14) ;
            }
            closeExtendedTableCursors3164( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12312( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos_Insert", GXv_boolean3) ;
         novedadeventos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos_Update", GXv_boolean3) ;
         novedadeventos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos_Delete", GXv_boolean3) ;
         novedadeventos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV28Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV28Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV29GXV1 = 1 ;
         while ( AV29GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV26TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV29GXV1));
            if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegLicSitCodigo") == 0 )
            {
               AV25Insert_LegLicSitCodigo = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV29GXV1 = (int)(AV29GXV1+1) ;
         }
      }
   }

   public void e11312( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm3164( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z517LegLicSitDescrip = A517LegLicSitDescrip ;
         Z914LegLicDescrip = A914LegLicDescrip ;
         Z481LegLicenFin = A481LegLicenFin ;
         Z1218LegLicConPlus = A1218LegLicConPlus ;
         Z1287LegSitEsLic = A1287LegSitEsLic ;
         Z1288LegSitEsAu = A1288LegSitEsAu ;
         Z1289LegSitEsAfip = A1289LegSitEsAfip ;
         Z1643LegSitCuenTrab = A1643LegSitCuenTrab ;
         Z1497LegLicEstado = A1497LegLicEstado ;
         Z1808LegLicCanPres = A1808LegLicCanPres ;
         Z1810LegLicRemCorr = A1810LegLicRemCorr ;
         Z506LegLicSitCodigo = A506LegLicSitCodigo ;
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( ( GX_JID == 14 ) || ( GX_JID == 0 ) )
      {
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( GX_JID == -12 )
      {
         Z76LegLicenIni = A76LegLicenIni ;
         Z517LegLicSitDescrip = A517LegLicSitDescrip ;
         Z914LegLicDescrip = A914LegLicDescrip ;
         Z481LegLicenFin = A481LegLicenFin ;
         Z1218LegLicConPlus = A1218LegLicConPlus ;
         Z1287LegSitEsLic = A1287LegSitEsLic ;
         Z1288LegSitEsAu = A1288LegSitEsAu ;
         Z1289LegSitEsAfip = A1289LegSitEsAfip ;
         Z1643LegSitCuenTrab = A1643LegSitCuenTrab ;
         Z1497LegLicEstado = A1497LegLicEstado ;
         Z1498LegLIcMot = A1498LegLIcMot ;
         Z1499LegLicFile = A1499LegLicFile ;
         Z1808LegLicCanPres = A1808LegLicCanPres ;
         Z1810LegLicRemCorr = A1810LegLicRemCorr ;
         Z1501LegLicFileExt = A1501LegLicFileExt ;
         Z1500LegLicFileNom = A1500LegLicFileNom ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z506LegLicSitCodigo = A506LegLicSitCodigo ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         novedadeventos_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load3164( )
   {
      /* Using cursor BC00316 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A517LegLicSitDescrip = BC00316_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC00316_A914LegLicDescrip[0] ;
         A481LegLicenFin = BC00316_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC00316_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = BC00316_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = BC00316_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = BC00316_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = BC00316_A1643LegSitCuenTrab[0] ;
         A1497LegLicEstado = BC00316_A1497LegLicEstado[0] ;
         A1498LegLIcMot = BC00316_A1498LegLIcMot[0] ;
         A1499LegLicFile = BC00316_A1499LegLicFile[0] ;
         A1808LegLicCanPres = BC00316_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = BC00316_A1810LegLicRemCorr[0] ;
         A1501LegLicFileExt = BC00316_A1501LegLicFileExt[0] ;
         A1499LegLicFile_Filetype = A1501LegLicFileExt ;
         A1500LegLicFileNom = BC00316_A1500LegLicFileNom[0] ;
         A1499LegLicFile_Filename = A1500LegLicFileNom ;
         A506LegLicSitCodigo = BC00316_A506LegLicSitCodigo[0] ;
         zm3164( -12) ;
      }
      pr_default.close(4);
      onLoadActions3164( ) ;
   }

   public void onLoadActions3164( )
   {
      AV28Pgmname = "NovedadEventos_BC" ;
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
      }
      else
      {
         A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
      }
   }

   public void checkExtendedTable3164( )
   {
      nIsDirty_64 = (short)(0) ;
      standaloneModal( ) ;
      AV28Pgmname = "NovedadEventos_BC" ;
      /* Using cursor BC00317 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      if ( (0==A6LegNumero) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         nIsDirty_64 = (short)(1) ;
         A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
      }
      else
      {
         nIsDirty_64 = (short)(1) ;
         A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A76LegLicenIni)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de Inicio", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( GXutil.resetTime(A481LegLicenFin).before( GXutil.resetTime( A76LegLicenIni )) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha de Fin debe ser mayor o igual a la fecha de inicio", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC00318 */
      pr_default.execute(6, new Object[] {A506LegLicSitCodigo});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Situacion Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGLICSITCODIGO");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( (GXutil.strcmp("", A506LegLicSitCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Situación de Revista", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1497LegLicEstado, "pendiente") == 0 ) || ( GXutil.strcmp(A1497LegLicEstado, "autorizada") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Estado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors3164( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey3164( )
   {
      /* Using cursor BC00319 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound64 = (short)(1) ;
      }
      else
      {
         RcdFound64 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC003110 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm3164( 12) ;
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC003110_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC003110_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC003110_A914LegLicDescrip[0] ;
         A481LegLicenFin = BC003110_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC003110_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = BC003110_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = BC003110_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = BC003110_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = BC003110_A1643LegSitCuenTrab[0] ;
         A1497LegLicEstado = BC003110_A1497LegLicEstado[0] ;
         A1498LegLIcMot = BC003110_A1498LegLIcMot[0] ;
         A1499LegLicFile = BC003110_A1499LegLicFile[0] ;
         A1808LegLicCanPres = BC003110_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = BC003110_A1810LegLicRemCorr[0] ;
         A1501LegLicFileExt = BC003110_A1501LegLicFileExt[0] ;
         A1499LegLicFile_Filetype = A1501LegLicFileExt ;
         A1500LegLicFileNom = BC003110_A1500LegLicFileNom[0] ;
         A1499LegLicFile_Filename = A1500LegLicFileNom ;
         A3CliCod = BC003110_A3CliCod[0] ;
         A1EmpCod = BC003110_A1EmpCod[0] ;
         A6LegNumero = BC003110_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC003110_A506LegLicSitCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z76LegLicenIni = A76LegLicenIni ;
         sMode64 = Gx_mode ;
         Gx_mode = "DSP" ;
         load3164( ) ;
         if ( AnyError == 1 )
         {
            RcdFound64 = (short)(0) ;
            initializeNonKey3164( ) ;
         }
         Gx_mode = sMode64 ;
      }
      else
      {
         RcdFound64 = (short)(0) ;
         initializeNonKey3164( ) ;
         sMode64 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode64 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey3164( ) ;
      if ( RcdFound64 == 0 )
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
      confirm_310( ) ;
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

   public void checkOptimisticConcurrency3164( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC003111 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoLicencias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z517LegLicSitDescrip, BC003111_A517LegLicSitDescrip[0]) != 0 ) || ( GXutil.strcmp(Z914LegLicDescrip, BC003111_A914LegLicDescrip[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z481LegLicenFin), GXutil.resetTime(BC003111_A481LegLicenFin[0])) ) || ( Z1218LegLicConPlus != BC003111_A1218LegLicConPlus[0] ) || ( Z1287LegSitEsLic != BC003111_A1287LegSitEsLic[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1288LegSitEsAu != BC003111_A1288LegSitEsAu[0] ) || ( Z1289LegSitEsAfip != BC003111_A1289LegSitEsAfip[0] ) || ( Z1643LegSitCuenTrab != BC003111_A1643LegSitCuenTrab[0] ) || ( GXutil.strcmp(Z1497LegLicEstado, BC003111_A1497LegLicEstado[0]) != 0 ) || ( Z1808LegLicCanPres != BC003111_A1808LegLicCanPres[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1810LegLicRemCorr != BC003111_A1810LegLicRemCorr[0] ) || ( GXutil.strcmp(Z506LegLicSitCodigo, BC003111_A506LegLicSitCodigo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoLicencias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3164( )
   {
      beforeValidate3164( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3164( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3164( 0) ;
         checkOptimisticConcurrency3164( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3164( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3164( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003112 */
                  pr_default.execute(10, new Object[] {A76LegLicenIni, A517LegLicSitDescrip, A914LegLicDescrip, A481LegLicenFin, Boolean.valueOf(A1218LegLicConPlus), Byte.valueOf(A1287LegSitEsLic), Byte.valueOf(A1288LegSitEsAu), Byte.valueOf(A1289LegSitEsAfip), Byte.valueOf(A1643LegSitCuenTrab), A1497LegLicEstado, A1498LegLIcMot, A1499LegLicFile, Byte.valueOf(A1808LegLicCanPres), Byte.valueOf(A1810LegLicRemCorr), A1501LegLicFileExt, A1500LegLicFileNom, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A506LegLicSitCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
                  if ( (pr_default.getStatus(10) == 1) )
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
            load3164( ) ;
         }
         endLevel3164( ) ;
      }
      closeExtendedTableCursors3164( ) ;
   }

   public void update3164( )
   {
      beforeValidate3164( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3164( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3164( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3164( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3164( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003113 */
                  pr_default.execute(11, new Object[] {A517LegLicSitDescrip, A914LegLicDescrip, A481LegLicenFin, Boolean.valueOf(A1218LegLicConPlus), Byte.valueOf(A1287LegSitEsLic), Byte.valueOf(A1288LegSitEsAu), Byte.valueOf(A1289LegSitEsAfip), Byte.valueOf(A1643LegSitCuenTrab), A1497LegLicEstado, A1498LegLIcMot, Byte.valueOf(A1808LegLicCanPres), Byte.valueOf(A1810LegLicRemCorr), A1501LegLicFileExt, A1500LegLicFileNom, A506LegLicSitCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoLicencias"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3164( ) ;
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
         endLevel3164( ) ;
      }
      closeExtendedTableCursors3164( ) ;
   }

   public void deferredUpdate3164( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC003114 */
         pr_default.execute(12, new Object[] {A1499LegLicFile, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate3164( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3164( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3164( ) ;
         afterConfirm3164( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3164( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC003115 */
               pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
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
      sMode64 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel3164( ) ;
      Gx_mode = sMode64 ;
   }

   public void onDeleteControls3164( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV28Pgmname = "NovedadEventos_BC" ;
         if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
         {
            A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
         }
         else
         {
            A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
         }
      }
   }

   public void endLevel3164( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3164( ) ;
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

   public void scanKeyStart3164( )
   {
      /* Scan By routine */
      /* Using cursor BC003116 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      RcdFound64 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC003116_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC003116_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC003116_A914LegLicDescrip[0] ;
         A481LegLicenFin = BC003116_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC003116_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = BC003116_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = BC003116_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = BC003116_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = BC003116_A1643LegSitCuenTrab[0] ;
         A1497LegLicEstado = BC003116_A1497LegLicEstado[0] ;
         A1498LegLIcMot = BC003116_A1498LegLIcMot[0] ;
         A1499LegLicFile = BC003116_A1499LegLicFile[0] ;
         A1808LegLicCanPres = BC003116_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = BC003116_A1810LegLicRemCorr[0] ;
         A1501LegLicFileExt = BC003116_A1501LegLicFileExt[0] ;
         A1499LegLicFile_Filetype = A1501LegLicFileExt ;
         A1500LegLicFileNom = BC003116_A1500LegLicFileNom[0] ;
         A1499LegLicFile_Filename = A1500LegLicFileNom ;
         A3CliCod = BC003116_A3CliCod[0] ;
         A1EmpCod = BC003116_A1EmpCod[0] ;
         A6LegNumero = BC003116_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC003116_A506LegLicSitCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext3164( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound64 = (short)(0) ;
      scanKeyLoad3164( ) ;
   }

   public void scanKeyLoad3164( )
   {
      sMode64 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC003116_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC003116_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC003116_A914LegLicDescrip[0] ;
         A481LegLicenFin = BC003116_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC003116_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = BC003116_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = BC003116_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = BC003116_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = BC003116_A1643LegSitCuenTrab[0] ;
         A1497LegLicEstado = BC003116_A1497LegLicEstado[0] ;
         A1498LegLIcMot = BC003116_A1498LegLIcMot[0] ;
         A1499LegLicFile = BC003116_A1499LegLicFile[0] ;
         A1808LegLicCanPres = BC003116_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = BC003116_A1810LegLicRemCorr[0] ;
         A1501LegLicFileExt = BC003116_A1501LegLicFileExt[0] ;
         A1499LegLicFile_Filetype = A1501LegLicFileExt ;
         A1500LegLicFileNom = BC003116_A1500LegLicFileNom[0] ;
         A1499LegLicFile_Filename = A1500LegLicFileNom ;
         A3CliCod = BC003116_A3CliCod[0] ;
         A1EmpCod = BC003116_A1EmpCod[0] ;
         A6LegNumero = BC003116_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC003116_A506LegLicSitCodigo[0] ;
      }
      Gx_mode = sMode64 ;
   }

   public void scanKeyEnd3164( )
   {
      pr_default.close(14);
   }

   public void afterConfirm3164( )
   {
      /* After Confirm Rules */
      GXt_char6 = A517LegLicSitDescrip ;
      GXv_char7[0] = GXt_char6 ;
      new web.getsituaciondescrip(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char7) ;
      novedadeventos_bc.this.GXt_char6 = GXv_char7[0] ;
      A517LegLicSitDescrip = GXt_char6 ;
      GXt_char6 = A914LegLicDescrip ;
      GXv_char7[0] = GXt_char6 ;
      new web.getsituaciondescripabr(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char7) ;
      novedadeventos_bc.this.GXt_char6 = GXv_char7[0] ;
      A914LegLicDescrip = GXt_char6 ;
   }

   public void beforeInsert3164( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3164( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3164( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3164( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3164( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3164( )
   {
   }

   public void send_integrity_lvl_hashes3164( )
   {
   }

   public void addRow3164( )
   {
      VarsToRow64( bcNovedadEventos) ;
   }

   public void readRow3164( )
   {
      RowToVars64( bcNovedadEventos, 1) ;
   }

   public void initializeNonKey3164( )
   {
      A517LegLicSitDescrip = "" ;
      A914LegLicDescrip = "" ;
      A501LegLicCntDias = (short)(0) ;
      A481LegLicenFin = GXutil.nullDate() ;
      A506LegLicSitCodigo = "" ;
      A1218LegLicConPlus = false ;
      A1287LegSitEsLic = (byte)(0) ;
      A1288LegSitEsAu = (byte)(0) ;
      A1289LegSitEsAfip = (byte)(0) ;
      A1643LegSitCuenTrab = (byte)(0) ;
      A1497LegLicEstado = "" ;
      A1498LegLIcMot = "" ;
      A1499LegLicFile = "" ;
      A1808LegLicCanPres = (byte)(0) ;
      A1810LegLicRemCorr = (byte)(0) ;
      A1501LegLicFileExt = "" ;
      A1500LegLicFileNom = "" ;
      Z517LegLicSitDescrip = "" ;
      Z914LegLicDescrip = "" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      Z1218LegLicConPlus = false ;
      Z1287LegSitEsLic = (byte)(0) ;
      Z1288LegSitEsAu = (byte)(0) ;
      Z1289LegSitEsAfip = (byte)(0) ;
      Z1643LegSitCuenTrab = (byte)(0) ;
      Z1497LegLicEstado = "" ;
      Z1808LegLicCanPres = (byte)(0) ;
      Z1810LegLicRemCorr = (byte)(0) ;
      Z506LegLicSitCodigo = "" ;
   }

   public void initAll3164( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A76LegLicenIni = GXutil.nullDate() ;
      initializeNonKey3164( ) ;
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

   public void VarsToRow64( web.SdtNovedadEventos obj64 )
   {
      obj64.setgxTv_SdtNovedadEventos_Mode( Gx_mode );
      obj64.setgxTv_SdtNovedadEventos_Leglicsitdescrip( A517LegLicSitDescrip );
      obj64.setgxTv_SdtNovedadEventos_Leglicdescrip( A914LegLicDescrip );
      obj64.setgxTv_SdtNovedadEventos_Legliccntdias( A501LegLicCntDias );
      obj64.setgxTv_SdtNovedadEventos_Leglicenfin( A481LegLicenFin );
      obj64.setgxTv_SdtNovedadEventos_Leglicsitcodigo( A506LegLicSitCodigo );
      obj64.setgxTv_SdtNovedadEventos_Leglicconplus( A1218LegLicConPlus );
      obj64.setgxTv_SdtNovedadEventos_Legsiteslic( A1287LegSitEsLic );
      obj64.setgxTv_SdtNovedadEventos_Legsitesau( A1288LegSitEsAu );
      obj64.setgxTv_SdtNovedadEventos_Legsitesafip( A1289LegSitEsAfip );
      obj64.setgxTv_SdtNovedadEventos_Legsitcuentrab( A1643LegSitCuenTrab );
      obj64.setgxTv_SdtNovedadEventos_Leglicestado( A1497LegLicEstado );
      obj64.setgxTv_SdtNovedadEventos_Leglicmot( A1498LegLIcMot );
      obj64.setgxTv_SdtNovedadEventos_Leglicfile( A1499LegLicFile );
      obj64.setgxTv_SdtNovedadEventos_Legliccanpres( A1808LegLicCanPres );
      obj64.setgxTv_SdtNovedadEventos_Leglicremcorr( A1810LegLicRemCorr );
      obj64.setgxTv_SdtNovedadEventos_Leglicfileext( A1501LegLicFileExt );
      obj64.setgxTv_SdtNovedadEventos_Leglicfilenom( A1500LegLicFileNom );
      obj64.setgxTv_SdtNovedadEventos_Clicod( A3CliCod );
      obj64.setgxTv_SdtNovedadEventos_Empcod( A1EmpCod );
      obj64.setgxTv_SdtNovedadEventos_Legnumero( A6LegNumero );
      obj64.setgxTv_SdtNovedadEventos_Leglicenini( A76LegLicenIni );
      obj64.setgxTv_SdtNovedadEventos_Clicod_Z( Z3CliCod );
      obj64.setgxTv_SdtNovedadEventos_Empcod_Z( Z1EmpCod );
      obj64.setgxTv_SdtNovedadEventos_Legnumero_Z( Z6LegNumero );
      obj64.setgxTv_SdtNovedadEventos_Leglicenini_Z( Z76LegLicenIni );
      obj64.setgxTv_SdtNovedadEventos_Leglicenfin_Z( Z481LegLicenFin );
      obj64.setgxTv_SdtNovedadEventos_Leglicsitcodigo_Z( Z506LegLicSitCodigo );
      obj64.setgxTv_SdtNovedadEventos_Leglicsitdescrip_Z( Z517LegLicSitDescrip );
      obj64.setgxTv_SdtNovedadEventos_Legliccntdias_Z( Z501LegLicCntDias );
      obj64.setgxTv_SdtNovedadEventos_Leglicdescrip_Z( Z914LegLicDescrip );
      obj64.setgxTv_SdtNovedadEventos_Leglicconplus_Z( Z1218LegLicConPlus );
      obj64.setgxTv_SdtNovedadEventos_Legsiteslic_Z( Z1287LegSitEsLic );
      obj64.setgxTv_SdtNovedadEventos_Legsitesau_Z( Z1288LegSitEsAu );
      obj64.setgxTv_SdtNovedadEventos_Legsitesafip_Z( Z1289LegSitEsAfip );
      obj64.setgxTv_SdtNovedadEventos_Legsitcuentrab_Z( Z1643LegSitCuenTrab );
      obj64.setgxTv_SdtNovedadEventos_Leglicestado_Z( Z1497LegLicEstado );
      obj64.setgxTv_SdtNovedadEventos_Leglicfilenom_Z( Z1500LegLicFileNom );
      obj64.setgxTv_SdtNovedadEventos_Leglicfileext_Z( Z1501LegLicFileExt );
      obj64.setgxTv_SdtNovedadEventos_Legliccanpres_Z( Z1808LegLicCanPres );
      obj64.setgxTv_SdtNovedadEventos_Leglicremcorr_Z( Z1810LegLicRemCorr );
      obj64.setgxTv_SdtNovedadEventos_Mode( Gx_mode );
   }

   public void KeyVarsToRow64( web.SdtNovedadEventos obj64 )
   {
      obj64.setgxTv_SdtNovedadEventos_Clicod( A3CliCod );
      obj64.setgxTv_SdtNovedadEventos_Empcod( A1EmpCod );
      obj64.setgxTv_SdtNovedadEventos_Legnumero( A6LegNumero );
      obj64.setgxTv_SdtNovedadEventos_Leglicenini( A76LegLicenIni );
   }

   public void RowToVars64( web.SdtNovedadEventos obj64 ,
                            int forceLoad )
   {
      Gx_mode = obj64.getgxTv_SdtNovedadEventos_Mode() ;
      A517LegLicSitDescrip = obj64.getgxTv_SdtNovedadEventos_Leglicsitdescrip() ;
      A914LegLicDescrip = obj64.getgxTv_SdtNovedadEventos_Leglicdescrip() ;
      A501LegLicCntDias = obj64.getgxTv_SdtNovedadEventos_Legliccntdias() ;
      A481LegLicenFin = obj64.getgxTv_SdtNovedadEventos_Leglicenfin() ;
      A506LegLicSitCodigo = obj64.getgxTv_SdtNovedadEventos_Leglicsitcodigo() ;
      A1218LegLicConPlus = obj64.getgxTv_SdtNovedadEventos_Leglicconplus() ;
      A1287LegSitEsLic = obj64.getgxTv_SdtNovedadEventos_Legsiteslic() ;
      A1288LegSitEsAu = obj64.getgxTv_SdtNovedadEventos_Legsitesau() ;
      A1289LegSitEsAfip = obj64.getgxTv_SdtNovedadEventos_Legsitesafip() ;
      A1643LegSitCuenTrab = obj64.getgxTv_SdtNovedadEventos_Legsitcuentrab() ;
      A1497LegLicEstado = obj64.getgxTv_SdtNovedadEventos_Leglicestado() ;
      A1498LegLIcMot = obj64.getgxTv_SdtNovedadEventos_Leglicmot() ;
      A1499LegLicFile = obj64.getgxTv_SdtNovedadEventos_Leglicfile() ;
      A1808LegLicCanPres = obj64.getgxTv_SdtNovedadEventos_Legliccanpres() ;
      A1810LegLicRemCorr = obj64.getgxTv_SdtNovedadEventos_Leglicremcorr() ;
      A1501LegLicFileExt = ((GXutil.strcmp("", obj64.getgxTv_SdtNovedadEventos_Leglicfileext())==0) ? com.genexus.util.GXFile.getgxFileext( A1499LegLicFile) : obj64.getgxTv_SdtNovedadEventos_Leglicfileext()) ;
      A1500LegLicFileNom = ((GXutil.strcmp("", obj64.getgxTv_SdtNovedadEventos_Leglicfilenom())==0) ? com.genexus.util.GXFile.getgxFilename( A1499LegLicFile) : obj64.getgxTv_SdtNovedadEventos_Leglicfilenom()) ;
      A3CliCod = obj64.getgxTv_SdtNovedadEventos_Clicod() ;
      A1EmpCod = obj64.getgxTv_SdtNovedadEventos_Empcod() ;
      A6LegNumero = obj64.getgxTv_SdtNovedadEventos_Legnumero() ;
      A76LegLicenIni = obj64.getgxTv_SdtNovedadEventos_Leglicenini() ;
      Z3CliCod = obj64.getgxTv_SdtNovedadEventos_Clicod_Z() ;
      Z1EmpCod = obj64.getgxTv_SdtNovedadEventos_Empcod_Z() ;
      Z6LegNumero = obj64.getgxTv_SdtNovedadEventos_Legnumero_Z() ;
      Z76LegLicenIni = obj64.getgxTv_SdtNovedadEventos_Leglicenini_Z() ;
      Z481LegLicenFin = obj64.getgxTv_SdtNovedadEventos_Leglicenfin_Z() ;
      Z506LegLicSitCodigo = obj64.getgxTv_SdtNovedadEventos_Leglicsitcodigo_Z() ;
      Z517LegLicSitDescrip = obj64.getgxTv_SdtNovedadEventos_Leglicsitdescrip_Z() ;
      Z501LegLicCntDias = obj64.getgxTv_SdtNovedadEventos_Legliccntdias_Z() ;
      Z914LegLicDescrip = obj64.getgxTv_SdtNovedadEventos_Leglicdescrip_Z() ;
      Z1218LegLicConPlus = obj64.getgxTv_SdtNovedadEventos_Leglicconplus_Z() ;
      Z1287LegSitEsLic = obj64.getgxTv_SdtNovedadEventos_Legsiteslic_Z() ;
      Z1288LegSitEsAu = obj64.getgxTv_SdtNovedadEventos_Legsitesau_Z() ;
      Z1289LegSitEsAfip = obj64.getgxTv_SdtNovedadEventos_Legsitesafip_Z() ;
      Z1643LegSitCuenTrab = obj64.getgxTv_SdtNovedadEventos_Legsitcuentrab_Z() ;
      Z1497LegLicEstado = obj64.getgxTv_SdtNovedadEventos_Leglicestado_Z() ;
      Z1500LegLicFileNom = obj64.getgxTv_SdtNovedadEventos_Leglicfilenom_Z() ;
      Z1501LegLicFileExt = obj64.getgxTv_SdtNovedadEventos_Leglicfileext_Z() ;
      Z1808LegLicCanPres = obj64.getgxTv_SdtNovedadEventos_Legliccanpres_Z() ;
      Z1810LegLicRemCorr = obj64.getgxTv_SdtNovedadEventos_Leglicremcorr_Z() ;
      Gx_mode = obj64.getgxTv_SdtNovedadEventos_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      A76LegLicenIni = (java.util.Date)getParm(obj,3) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey3164( ) ;
      scanKeyStart3164( ) ;
      if ( RcdFound64 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC003117 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(15) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z76LegLicenIni = A76LegLicenIni ;
      }
      zm3164( -12) ;
      onLoadActions3164( ) ;
      addRow3164( ) ;
      scanKeyEnd3164( ) ;
      if ( RcdFound64 == 0 )
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
      RowToVars64( bcNovedadEventos, 0) ;
      scanKeyStart3164( ) ;
      if ( RcdFound64 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC003118 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z76LegLicenIni = A76LegLicenIni ;
      }
      zm3164( -12) ;
      onLoadActions3164( ) ;
      addRow3164( ) ;
      scanKeyEnd3164( ) ;
      if ( RcdFound64 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey3164( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert3164( ) ;
      }
      else
      {
         if ( RcdFound64 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(Z76LegLicenIni)) ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A6LegNumero = Z6LegNumero ;
               A76LegLicenIni = Z76LegLicenIni ;
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
               update3164( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(Z76LegLicenIni)) ) )
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
                     insert3164( ) ;
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
                     insert3164( ) ;
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
      RowToVars64( bcNovedadEventos, 1) ;
      saveImpl( ) ;
      VarsToRow64( bcNovedadEventos) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars64( bcNovedadEventos, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert3164( ) ;
      afterTrn( ) ;
      VarsToRow64( bcNovedadEventos) ;
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
         web.SdtNovedadEventos auxBC = new web.SdtNovedadEventos( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A76LegLicenIni);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcNovedadEventos);
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
      RowToVars64( bcNovedadEventos, 1) ;
      updateImpl( ) ;
      VarsToRow64( bcNovedadEventos) ;
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
      RowToVars64( bcNovedadEventos, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert3164( ) ;
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
      VarsToRow64( bcNovedadEventos) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars64( bcNovedadEventos, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey3164( ) ;
      if ( RcdFound64 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(Z76LegLicenIni)) ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A6LegNumero = Z6LegNumero ;
            A76LegLicenIni = Z76LegLicenIni ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || !( GXutil.dateCompare(GXutil.resetTime(A76LegLicenIni), GXutil.resetTime(Z76LegLicenIni)) ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "novedadeventos_bc");
      VarsToRow64( bcNovedadEventos) ;
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
      Gx_mode = bcNovedadEventos.getgxTv_SdtNovedadEventos_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcNovedadEventos.setgxTv_SdtNovedadEventos_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtNovedadEventos sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcNovedadEventos )
      {
         bcNovedadEventos = sdt ;
         if ( GXutil.strcmp(bcNovedadEventos.getgxTv_SdtNovedadEventos_Mode(), "") == 0 )
         {
            bcNovedadEventos.setgxTv_SdtNovedadEventos_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow64( bcNovedadEventos) ;
         }
         else
         {
            RowToVars64( bcNovedadEventos, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcNovedadEventos.getgxTv_SdtNovedadEventos_Mode(), "") == 0 )
         {
            bcNovedadEventos.setgxTv_SdtNovedadEventos_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars64( bcNovedadEventos, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtNovedadEventos getNovedadEventos_BC( )
   {
      return bcNovedadEventos ;
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
      Z76LegLicenIni = GXutil.nullDate() ;
      A76LegLicenIni = GXutil.nullDate() ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV28Pgmname = "" ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV26TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV25Insert_LegLicSitCodigo = "" ;
      Z517LegLicSitDescrip = "" ;
      A517LegLicSitDescrip = "" ;
      Z914LegLicDescrip = "" ;
      A914LegLicDescrip = "" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      Z1497LegLicEstado = "" ;
      A1497LegLicEstado = "" ;
      Z506LegLicSitCodigo = "" ;
      A506LegLicSitCodigo = "" ;
      Z1498LegLIcMot = "" ;
      A1498LegLIcMot = "" ;
      Z1499LegLicFile = "" ;
      A1499LegLicFile = "" ;
      Z1501LegLicFileExt = "" ;
      A1501LegLicFileExt = "" ;
      Z1500LegLicFileNom = "" ;
      A1500LegLicFileNom = "" ;
      GXv_int5 = new int[1] ;
      BC00316_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC00316_A517LegLicSitDescrip = new String[] {""} ;
      BC00316_A914LegLicDescrip = new String[] {""} ;
      BC00316_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC00316_A1218LegLicConPlus = new boolean[] {false} ;
      BC00316_A1287LegSitEsLic = new byte[1] ;
      BC00316_A1288LegSitEsAu = new byte[1] ;
      BC00316_A1289LegSitEsAfip = new byte[1] ;
      BC00316_A1643LegSitCuenTrab = new byte[1] ;
      BC00316_A1497LegLicEstado = new String[] {""} ;
      BC00316_A1498LegLIcMot = new String[] {""} ;
      BC00316_A1499LegLicFile = new String[] {""} ;
      BC00316_A1808LegLicCanPres = new byte[1] ;
      BC00316_A1810LegLicRemCorr = new byte[1] ;
      BC00316_A1501LegLicFileExt = new String[] {""} ;
      BC00316_A1500LegLicFileNom = new String[] {""} ;
      BC00316_A3CliCod = new int[1] ;
      BC00316_A1EmpCod = new short[1] ;
      BC00316_A6LegNumero = new int[1] ;
      BC00316_A506LegLicSitCodigo = new String[] {""} ;
      A1499LegLicFile_Filetype = "" ;
      A1499LegLicFile_Filename = "" ;
      BC00317_A3CliCod = new int[1] ;
      BC00318_A506LegLicSitCodigo = new String[] {""} ;
      BC00319_A3CliCod = new int[1] ;
      BC00319_A1EmpCod = new short[1] ;
      BC00319_A6LegNumero = new int[1] ;
      BC00319_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003110_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003110_A517LegLicSitDescrip = new String[] {""} ;
      BC003110_A914LegLicDescrip = new String[] {""} ;
      BC003110_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC003110_A1218LegLicConPlus = new boolean[] {false} ;
      BC003110_A1287LegSitEsLic = new byte[1] ;
      BC003110_A1288LegSitEsAu = new byte[1] ;
      BC003110_A1289LegSitEsAfip = new byte[1] ;
      BC003110_A1643LegSitCuenTrab = new byte[1] ;
      BC003110_A1497LegLicEstado = new String[] {""} ;
      BC003110_A1498LegLIcMot = new String[] {""} ;
      BC003110_A1499LegLicFile = new String[] {""} ;
      BC003110_A1808LegLicCanPres = new byte[1] ;
      BC003110_A1810LegLicRemCorr = new byte[1] ;
      BC003110_A1501LegLicFileExt = new String[] {""} ;
      BC003110_A1500LegLicFileNom = new String[] {""} ;
      BC003110_A3CliCod = new int[1] ;
      BC003110_A1EmpCod = new short[1] ;
      BC003110_A6LegNumero = new int[1] ;
      BC003110_A506LegLicSitCodigo = new String[] {""} ;
      sMode64 = "" ;
      BC003111_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003111_A517LegLicSitDescrip = new String[] {""} ;
      BC003111_A914LegLicDescrip = new String[] {""} ;
      BC003111_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC003111_A1218LegLicConPlus = new boolean[] {false} ;
      BC003111_A1287LegSitEsLic = new byte[1] ;
      BC003111_A1288LegSitEsAu = new byte[1] ;
      BC003111_A1289LegSitEsAfip = new byte[1] ;
      BC003111_A1643LegSitCuenTrab = new byte[1] ;
      BC003111_A1497LegLicEstado = new String[] {""} ;
      BC003111_A1498LegLIcMot = new String[] {""} ;
      BC003111_A1499LegLicFile = new String[] {""} ;
      BC003111_A1808LegLicCanPres = new byte[1] ;
      BC003111_A1810LegLicRemCorr = new byte[1] ;
      BC003111_A1501LegLicFileExt = new String[] {""} ;
      BC003111_A1500LegLicFileNom = new String[] {""} ;
      BC003111_A3CliCod = new int[1] ;
      BC003111_A1EmpCod = new short[1] ;
      BC003111_A6LegNumero = new int[1] ;
      BC003111_A506LegLicSitCodigo = new String[] {""} ;
      BC003116_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003116_A517LegLicSitDescrip = new String[] {""} ;
      BC003116_A914LegLicDescrip = new String[] {""} ;
      BC003116_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC003116_A1218LegLicConPlus = new boolean[] {false} ;
      BC003116_A1287LegSitEsLic = new byte[1] ;
      BC003116_A1288LegSitEsAu = new byte[1] ;
      BC003116_A1289LegSitEsAfip = new byte[1] ;
      BC003116_A1643LegSitCuenTrab = new byte[1] ;
      BC003116_A1497LegLicEstado = new String[] {""} ;
      BC003116_A1498LegLIcMot = new String[] {""} ;
      BC003116_A1499LegLicFile = new String[] {""} ;
      BC003116_A1808LegLicCanPres = new byte[1] ;
      BC003116_A1810LegLicRemCorr = new byte[1] ;
      BC003116_A1501LegLicFileExt = new String[] {""} ;
      BC003116_A1500LegLicFileNom = new String[] {""} ;
      BC003116_A3CliCod = new int[1] ;
      BC003116_A1EmpCod = new short[1] ;
      BC003116_A6LegNumero = new int[1] ;
      BC003116_A506LegLicSitCodigo = new String[] {""} ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC003117_A3CliCod = new int[1] ;
      BC003118_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadeventos_bc__default(),
         new Object[] {
             new Object[] {
            BC00312_A76LegLicenIni, BC00312_A517LegLicSitDescrip, BC00312_A914LegLicDescrip, BC00312_A481LegLicenFin, BC00312_A1218LegLicConPlus, BC00312_A1287LegSitEsLic, BC00312_A1288LegSitEsAu, BC00312_A1289LegSitEsAfip, BC00312_A1643LegSitCuenTrab, BC00312_A1497LegLicEstado,
            BC00312_A1498LegLIcMot, BC00312_A1499LegLicFile, BC00312_A1808LegLicCanPres, BC00312_A1810LegLicRemCorr, BC00312_A1501LegLicFileExt, BC00312_A1500LegLicFileNom, BC00312_A3CliCod, BC00312_A1EmpCod, BC00312_A6LegNumero, BC00312_A506LegLicSitCodigo
            }
            , new Object[] {
            BC00313_A76LegLicenIni, BC00313_A517LegLicSitDescrip, BC00313_A914LegLicDescrip, BC00313_A481LegLicenFin, BC00313_A1218LegLicConPlus, BC00313_A1287LegSitEsLic, BC00313_A1288LegSitEsAu, BC00313_A1289LegSitEsAfip, BC00313_A1643LegSitCuenTrab, BC00313_A1497LegLicEstado,
            BC00313_A1498LegLIcMot, BC00313_A1499LegLicFile, BC00313_A1808LegLicCanPres, BC00313_A1810LegLicRemCorr, BC00313_A1501LegLicFileExt, BC00313_A1500LegLicFileNom, BC00313_A3CliCod, BC00313_A1EmpCod, BC00313_A6LegNumero, BC00313_A506LegLicSitCodigo
            }
            , new Object[] {
            BC00314_A3CliCod
            }
            , new Object[] {
            BC00315_A506LegLicSitCodigo
            }
            , new Object[] {
            BC00316_A76LegLicenIni, BC00316_A517LegLicSitDescrip, BC00316_A914LegLicDescrip, BC00316_A481LegLicenFin, BC00316_A1218LegLicConPlus, BC00316_A1287LegSitEsLic, BC00316_A1288LegSitEsAu, BC00316_A1289LegSitEsAfip, BC00316_A1643LegSitCuenTrab, BC00316_A1497LegLicEstado,
            BC00316_A1498LegLIcMot, BC00316_A1499LegLicFile, BC00316_A1808LegLicCanPres, BC00316_A1810LegLicRemCorr, BC00316_A1501LegLicFileExt, BC00316_A1500LegLicFileNom, BC00316_A3CliCod, BC00316_A1EmpCod, BC00316_A6LegNumero, BC00316_A506LegLicSitCodigo
            }
            , new Object[] {
            BC00317_A3CliCod
            }
            , new Object[] {
            BC00318_A506LegLicSitCodigo
            }
            , new Object[] {
            BC00319_A3CliCod, BC00319_A1EmpCod, BC00319_A6LegNumero, BC00319_A76LegLicenIni
            }
            , new Object[] {
            BC003110_A76LegLicenIni, BC003110_A517LegLicSitDescrip, BC003110_A914LegLicDescrip, BC003110_A481LegLicenFin, BC003110_A1218LegLicConPlus, BC003110_A1287LegSitEsLic, BC003110_A1288LegSitEsAu, BC003110_A1289LegSitEsAfip, BC003110_A1643LegSitCuenTrab, BC003110_A1497LegLicEstado,
            BC003110_A1498LegLIcMot, BC003110_A1499LegLicFile, BC003110_A1808LegLicCanPres, BC003110_A1810LegLicRemCorr, BC003110_A1501LegLicFileExt, BC003110_A1500LegLicFileNom, BC003110_A3CliCod, BC003110_A1EmpCod, BC003110_A6LegNumero, BC003110_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003111_A76LegLicenIni, BC003111_A517LegLicSitDescrip, BC003111_A914LegLicDescrip, BC003111_A481LegLicenFin, BC003111_A1218LegLicConPlus, BC003111_A1287LegSitEsLic, BC003111_A1288LegSitEsAu, BC003111_A1289LegSitEsAfip, BC003111_A1643LegSitCuenTrab, BC003111_A1497LegLicEstado,
            BC003111_A1498LegLIcMot, BC003111_A1499LegLicFile, BC003111_A1808LegLicCanPres, BC003111_A1810LegLicRemCorr, BC003111_A1501LegLicFileExt, BC003111_A1500LegLicFileNom, BC003111_A3CliCod, BC003111_A1EmpCod, BC003111_A6LegNumero, BC003111_A506LegLicSitCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC003116_A76LegLicenIni, BC003116_A517LegLicSitDescrip, BC003116_A914LegLicDescrip, BC003116_A481LegLicenFin, BC003116_A1218LegLicConPlus, BC003116_A1287LegSitEsLic, BC003116_A1288LegSitEsAu, BC003116_A1289LegSitEsAfip, BC003116_A1643LegSitCuenTrab, BC003116_A1497LegLicEstado,
            BC003116_A1498LegLIcMot, BC003116_A1499LegLicFile, BC003116_A1808LegLicCanPres, BC003116_A1810LegLicRemCorr, BC003116_A1501LegLicFileExt, BC003116_A1500LegLicFileNom, BC003116_A3CliCod, BC003116_A1EmpCod, BC003116_A6LegNumero, BC003116_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003117_A3CliCod
            }
            , new Object[] {
            BC003118_A3CliCod
            }
         }
      );
      AV28Pgmname = "NovedadEventos_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12312 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z1287LegSitEsLic ;
   private byte A1287LegSitEsLic ;
   private byte Z1288LegSitEsAu ;
   private byte A1288LegSitEsAu ;
   private byte Z1289LegSitEsAfip ;
   private byte A1289LegSitEsAfip ;
   private byte Z1643LegSitCuenTrab ;
   private byte A1643LegSitCuenTrab ;
   private byte Z1808LegLicCanPres ;
   private byte A1808LegLicCanPres ;
   private byte Z1810LegLicRemCorr ;
   private byte A1810LegLicRemCorr ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z501LegLicCntDias ;
   private short A501LegLicCntDias ;
   private short RcdFound64 ;
   private short nIsDirty_64 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int AV29GXV1 ;
   private int GX_JID ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV28Pgmname ;
   private String AV25Insert_LegLicSitCodigo ;
   private String Z1497LegLicEstado ;
   private String A1497LegLicEstado ;
   private String Z506LegLicSitCodigo ;
   private String A506LegLicSitCodigo ;
   private String Z1501LegLicFileExt ;
   private String A1501LegLicFileExt ;
   private String A1499LegLicFile_Filetype ;
   private String A1499LegLicFile_Filename ;
   private String sMode64 ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private java.util.Date Z76LegLicenIni ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date Z481LegLicenFin ;
   private java.util.Date A481LegLicenFin ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z1218LegLicConPlus ;
   private boolean A1218LegLicConPlus ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z1498LegLIcMot ;
   private String A1498LegLIcMot ;
   private String Z1499LegLicFile ;
   private String A1499LegLicFile ;
   private String Z517LegLicSitDescrip ;
   private String A517LegLicSitDescrip ;
   private String Z914LegLicDescrip ;
   private String A914LegLicDescrip ;
   private String Z1500LegLicFileNom ;
   private String A1500LegLicFileNom ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private web.SdtNovedadEventos bcNovedadEventos ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] BC00316_A76LegLicenIni ;
   private String[] BC00316_A517LegLicSitDescrip ;
   private String[] BC00316_A914LegLicDescrip ;
   private java.util.Date[] BC00316_A481LegLicenFin ;
   private boolean[] BC00316_A1218LegLicConPlus ;
   private byte[] BC00316_A1287LegSitEsLic ;
   private byte[] BC00316_A1288LegSitEsAu ;
   private byte[] BC00316_A1289LegSitEsAfip ;
   private byte[] BC00316_A1643LegSitCuenTrab ;
   private String[] BC00316_A1497LegLicEstado ;
   private String[] BC00316_A1498LegLIcMot ;
   private String[] BC00316_A1499LegLicFile ;
   private byte[] BC00316_A1808LegLicCanPres ;
   private byte[] BC00316_A1810LegLicRemCorr ;
   private String[] BC00316_A1501LegLicFileExt ;
   private String[] BC00316_A1500LegLicFileNom ;
   private int[] BC00316_A3CliCod ;
   private short[] BC00316_A1EmpCod ;
   private int[] BC00316_A6LegNumero ;
   private String[] BC00316_A506LegLicSitCodigo ;
   private int[] BC00317_A3CliCod ;
   private String[] BC00318_A506LegLicSitCodigo ;
   private int[] BC00319_A3CliCod ;
   private short[] BC00319_A1EmpCod ;
   private int[] BC00319_A6LegNumero ;
   private java.util.Date[] BC00319_A76LegLicenIni ;
   private java.util.Date[] BC003110_A76LegLicenIni ;
   private String[] BC003110_A517LegLicSitDescrip ;
   private String[] BC003110_A914LegLicDescrip ;
   private java.util.Date[] BC003110_A481LegLicenFin ;
   private boolean[] BC003110_A1218LegLicConPlus ;
   private byte[] BC003110_A1287LegSitEsLic ;
   private byte[] BC003110_A1288LegSitEsAu ;
   private byte[] BC003110_A1289LegSitEsAfip ;
   private byte[] BC003110_A1643LegSitCuenTrab ;
   private String[] BC003110_A1497LegLicEstado ;
   private String[] BC003110_A1498LegLIcMot ;
   private String[] BC003110_A1499LegLicFile ;
   private byte[] BC003110_A1808LegLicCanPres ;
   private byte[] BC003110_A1810LegLicRemCorr ;
   private String[] BC003110_A1501LegLicFileExt ;
   private String[] BC003110_A1500LegLicFileNom ;
   private int[] BC003110_A3CliCod ;
   private short[] BC003110_A1EmpCod ;
   private int[] BC003110_A6LegNumero ;
   private String[] BC003110_A506LegLicSitCodigo ;
   private java.util.Date[] BC003111_A76LegLicenIni ;
   private String[] BC003111_A517LegLicSitDescrip ;
   private String[] BC003111_A914LegLicDescrip ;
   private java.util.Date[] BC003111_A481LegLicenFin ;
   private boolean[] BC003111_A1218LegLicConPlus ;
   private byte[] BC003111_A1287LegSitEsLic ;
   private byte[] BC003111_A1288LegSitEsAu ;
   private byte[] BC003111_A1289LegSitEsAfip ;
   private byte[] BC003111_A1643LegSitCuenTrab ;
   private String[] BC003111_A1497LegLicEstado ;
   private String[] BC003111_A1498LegLIcMot ;
   private String[] BC003111_A1499LegLicFile ;
   private byte[] BC003111_A1808LegLicCanPres ;
   private byte[] BC003111_A1810LegLicRemCorr ;
   private String[] BC003111_A1501LegLicFileExt ;
   private String[] BC003111_A1500LegLicFileNom ;
   private int[] BC003111_A3CliCod ;
   private short[] BC003111_A1EmpCod ;
   private int[] BC003111_A6LegNumero ;
   private String[] BC003111_A506LegLicSitCodigo ;
   private java.util.Date[] BC003116_A76LegLicenIni ;
   private String[] BC003116_A517LegLicSitDescrip ;
   private String[] BC003116_A914LegLicDescrip ;
   private java.util.Date[] BC003116_A481LegLicenFin ;
   private boolean[] BC003116_A1218LegLicConPlus ;
   private byte[] BC003116_A1287LegSitEsLic ;
   private byte[] BC003116_A1288LegSitEsAu ;
   private byte[] BC003116_A1289LegSitEsAfip ;
   private byte[] BC003116_A1643LegSitCuenTrab ;
   private String[] BC003116_A1497LegLicEstado ;
   private String[] BC003116_A1498LegLIcMot ;
   private String[] BC003116_A1499LegLicFile ;
   private byte[] BC003116_A1808LegLicCanPres ;
   private byte[] BC003116_A1810LegLicRemCorr ;
   private String[] BC003116_A1501LegLicFileExt ;
   private String[] BC003116_A1500LegLicFileNom ;
   private int[] BC003116_A3CliCod ;
   private short[] BC003116_A1EmpCod ;
   private int[] BC003116_A6LegNumero ;
   private String[] BC003116_A506LegLicSitCodigo ;
   private int[] BC003117_A3CliCod ;
   private int[] BC003118_A3CliCod ;
   private java.util.Date[] BC00312_A76LegLicenIni ;
   private String[] BC00312_A517LegLicSitDescrip ;
   private String[] BC00312_A914LegLicDescrip ;
   private java.util.Date[] BC00312_A481LegLicenFin ;
   private boolean[] BC00312_A1218LegLicConPlus ;
   private byte[] BC00312_A1287LegSitEsLic ;
   private byte[] BC00312_A1288LegSitEsAu ;
   private byte[] BC00312_A1289LegSitEsAfip ;
   private byte[] BC00312_A1643LegSitCuenTrab ;
   private String[] BC00312_A1497LegLicEstado ;
   private String[] BC00312_A1498LegLIcMot ;
   private String[] BC00312_A1499LegLicFile ;
   private byte[] BC00312_A1808LegLicCanPres ;
   private byte[] BC00312_A1810LegLicRemCorr ;
   private String[] BC00312_A1501LegLicFileExt ;
   private String[] BC00312_A1500LegLicFileNom ;
   private int[] BC00312_A3CliCod ;
   private short[] BC00312_A1EmpCod ;
   private int[] BC00312_A6LegNumero ;
   private String[] BC00312_A506LegLicSitCodigo ;
   private java.util.Date[] BC00313_A76LegLicenIni ;
   private String[] BC00313_A517LegLicSitDescrip ;
   private String[] BC00313_A914LegLicDescrip ;
   private java.util.Date[] BC00313_A481LegLicenFin ;
   private boolean[] BC00313_A1218LegLicConPlus ;
   private byte[] BC00313_A1287LegSitEsLic ;
   private byte[] BC00313_A1288LegSitEsAu ;
   private byte[] BC00313_A1289LegSitEsAfip ;
   private byte[] BC00313_A1643LegSitCuenTrab ;
   private String[] BC00313_A1497LegLicEstado ;
   private String[] BC00313_A1498LegLIcMot ;
   private String[] BC00313_A1499LegLicFile ;
   private byte[] BC00313_A1808LegLicCanPres ;
   private byte[] BC00313_A1810LegLicRemCorr ;
   private String[] BC00313_A1501LegLicFileExt ;
   private String[] BC00313_A1500LegLicFileNom ;
   private int[] BC00313_A3CliCod ;
   private short[] BC00313_A1EmpCod ;
   private int[] BC00313_A6LegNumero ;
   private String[] BC00313_A506LegLicSitCodigo ;
   private int[] BC00314_A3CliCod ;
   private String[] BC00315_A506LegLicSitCodigo ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV26TrnContextAtt ;
}

final  class novedadeventos_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00312", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicEstado, LegLIcMot, LegLicFile, LegLicCanPres, LegLicRemCorr, LegLicFileExt, LegLicFileNom, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?  FOR UPDATE OF LegajoLicencias",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00313", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicEstado, LegLIcMot, LegLicFile, LegLicCanPres, LegLicRemCorr, LegLicFileExt, LegLicFileNom, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00314", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00315", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00316", "SELECT TM1.LegLicenIni, TM1.LegLicSitDescrip, TM1.LegLicDescrip, TM1.LegLicenFin, TM1.LegLicConPlus, TM1.LegSitEsLic, TM1.LegSitEsAu, TM1.LegSitEsAfip, TM1.LegSitCuenTrab, TM1.LegLicEstado, TM1.LegLIcMot, TM1.LegLicFile, TM1.LegLicCanPres, TM1.LegLicRemCorr, TM1.LegLicFileExt, TM1.LegLicFileNom, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicSitCodigo AS LegLicSitCodigo FROM LegajoLicencias TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegLicenIni = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicenIni ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00317", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00318", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00319", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003110", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicEstado, LegLIcMot, LegLicFile, LegLicCanPres, LegLicRemCorr, LegLicFileExt, LegLicFileNom, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003111", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicEstado, LegLIcMot, LegLicFile, LegLicCanPres, LegLicRemCorr, LegLicFileExt, LegLicFileNom, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?  FOR UPDATE OF LegajoLicencias",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC003112", "SAVEPOINT gxupdate;INSERT INTO LegajoLicencias(LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicEstado, LegLIcMot, LegLicFile, LegLicCanPres, LegLicRemCorr, LegLicFileExt, LegLicFileNom, CliCod, EmpCod, LegNumero, LegLicSitCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003113", "SAVEPOINT gxupdate;UPDATE LegajoLicencias SET LegLicSitDescrip=?, LegLicDescrip=?, LegLicenFin=?, LegLicConPlus=?, LegSitEsLic=?, LegSitEsAu=?, LegSitEsAfip=?, LegSitCuenTrab=?, LegLicEstado=?, LegLIcMot=?, LegLicCanPres=?, LegLicRemCorr=?, LegLicFileExt=?, LegLicFileNom=?, LegLicSitCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003114", "SAVEPOINT gxupdate;UPDATE LegajoLicencias SET LegLicFile=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003115", "SAVEPOINT gxupdate;DELETE FROM LegajoLicencias  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC003116", "SELECT TM1.LegLicenIni, TM1.LegLicSitDescrip, TM1.LegLicDescrip, TM1.LegLicenFin, TM1.LegLicConPlus, TM1.LegSitEsLic, TM1.LegSitEsAu, TM1.LegSitEsAfip, TM1.LegSitCuenTrab, TM1.LegLicEstado, TM1.LegLIcMot, TM1.LegLicFile, TM1.LegLicCanPres, TM1.LegLicRemCorr, TM1.LegLicFileExt, TM1.LegLicFileNom, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicSitCodigo AS LegLicSitCodigo FROM LegajoLicencias TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegLicenIni = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicenIni ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003117", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003118", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(12, rslt.getString(15, 20), rslt.getVarchar(16));
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 4);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(12, rslt.getString(15, 20), rslt.getVarchar(16));
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(12, rslt.getString(15, 20), rslt.getVarchar(16));
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 4);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 8 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(12, rslt.getString(15, 20), rslt.getVarchar(16));
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 4);
               return;
            case 9 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(12, rslt.getString(15, 20), rslt.getVarchar(16));
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 4);
               return;
            case 14 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(12, rslt.getString(15, 20), rslt.getVarchar(16));
               ((byte[]) buf[12])[0] = rslt.getByte(13);
               ((byte[]) buf[13])[0] = rslt.getByte(14);
               ((String[]) buf[14])[0] = rslt.getString(15, 20);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((int[]) buf[16])[0] = rslt.getInt(17);
               ((short[]) buf[17])[0] = rslt.getShort(18);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getString(20, 4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 10 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               stmt.setBLOBFile(12, (String)parms[11]);
               stmt.setByte(13, ((Number) parms[12]).byteValue());
               stmt.setByte(14, ((Number) parms[13]).byteValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setVarchar(16, (String)parms[15], 400, false);
               stmt.setInt(17, ((Number) parms[16]).intValue());
               stmt.setShort(18, ((Number) parms[17]).shortValue());
               stmt.setInt(19, ((Number) parms[18]).intValue());
               stmt.setString(20, (String)parms[19], 4);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setNLongVarchar(10, (String)parms[9], false);
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setString(13, (String)parms[12], 20);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setString(15, (String)parms[14], 4);
               stmt.setInt(16, ((Number) parms[15]).intValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setInt(18, ((Number) parms[17]).intValue());
               stmt.setDate(19, (java.util.Date)parms[18]);
               return;
            case 12 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

