package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class faltas_y_tardes_bc extends GXWebPanel implements IGxSilentTrn
{
   public faltas_y_tardes_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public faltas_y_tardes_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( faltas_y_tardes_bc.class ));
   }

   public faltas_y_tardes_bc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow3P64( ) ;
      standaloneNotModal( ) ;
      initializeNonKey3P64( ) ;
      standaloneModal( ) ;
      addRow3P64( ) ;
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
         e113P2 ();
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

   public void confirm_3P0( )
   {
      beforeValidate3P64( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls3P64( ) ;
         }
         else
         {
            checkExtendedTable3P64( ) ;
            if ( AnyError == 0 )
            {
               zm3P64( 22) ;
               zm3P64( 23) ;
            }
            closeExtendedTableCursors3P64( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e123P2( )
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
         faltas_y_tardes_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos_Update", GXv_boolean3) ;
         faltas_y_tardes_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos_Delete", GXv_boolean3) ;
         faltas_y_tardes_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV37Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV37Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV38GXV1 = 1 ;
         while ( AV38GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV26TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV38GXV1));
            if ( GXutil.strcmp(AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegLicSitCodigo") == 0 )
            {
               AV25Insert_LegLicSitCodigo = AV26TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV38GXV1 = (int)(AV38GXV1+1) ;
         }
      }
   }

   public void e113P2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.recalcularlegsuelbasicaporlegupd(remoteHandle, context).execute( (short)(0), AV7CliCod, AV8EmpCod, A6LegNumero, httpContext.getMessage( "LICENCIAS", "")) ;
   }

   public void e133P2( )
   {
      /* LegLicenIni_Isvalid Routine */
      returnInSub = false ;
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A76LegLicenIni)) )
      {
         AV27cntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
      }
   }

   public void e143P2( )
   {
      /* LegLicenFin_Isvalid Routine */
      returnInSub = false ;
      AV27cntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
   }

   public void zm3P64( int GX_JID )
   {
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
         Z517LegLicSitDescrip = A517LegLicSitDescrip ;
         Z914LegLicDescrip = A914LegLicDescrip ;
         Z1497LegLicEstado = A1497LegLicEstado ;
         Z481LegLicenFin = A481LegLicenFin ;
         Z1218LegLicConPlus = A1218LegLicConPlus ;
         Z1287LegSitEsLic = A1287LegSitEsLic ;
         Z1288LegSitEsAu = A1288LegSitEsAu ;
         Z1289LegSitEsAfip = A1289LegSitEsAfip ;
         Z1643LegSitCuenTrab = A1643LegSitCuenTrab ;
         Z1808LegLicCanPres = A1808LegLicCanPres ;
         Z1810LegLicRemCorr = A1810LegLicRemCorr ;
         Z506LegLicSitCodigo = A506LegLicSitCodigo ;
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( ( GX_JID == 23 ) || ( GX_JID == 0 ) )
      {
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( GX_JID == -21 )
      {
         Z76LegLicenIni = A76LegLicenIni ;
         Z517LegLicSitDescrip = A517LegLicSitDescrip ;
         Z914LegLicDescrip = A914LegLicDescrip ;
         Z1497LegLicEstado = A1497LegLicEstado ;
         Z481LegLicenFin = A481LegLicenFin ;
         Z1218LegLicConPlus = A1218LegLicConPlus ;
         Z1287LegSitEsLic = A1287LegSitEsLic ;
         Z1288LegSitEsAu = A1288LegSitEsAu ;
         Z1289LegSitEsAfip = A1289LegSitEsAfip ;
         Z1643LegSitCuenTrab = A1643LegSitCuenTrab ;
         Z1808LegLicCanPres = A1808LegLicCanPres ;
         Z1810LegLicRemCorr = A1810LegLicRemCorr ;
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
         faltas_y_tardes_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      A1497LegLicEstado = "autorizada" ;
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load3P64( )
   {
      /* Using cursor BC003P6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A517LegLicSitDescrip = BC003P6_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC003P6_A914LegLicDescrip[0] ;
         A1497LegLicEstado = BC003P6_A1497LegLicEstado[0] ;
         A481LegLicenFin = BC003P6_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC003P6_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = BC003P6_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = BC003P6_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = BC003P6_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = BC003P6_A1643LegSitCuenTrab[0] ;
         A1808LegLicCanPres = BC003P6_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = BC003P6_A1810LegLicRemCorr[0] ;
         A506LegLicSitCodigo = BC003P6_A506LegLicSitCodigo[0] ;
         zm3P64( -21) ;
      }
      pr_default.close(4);
      onLoadActions3P64( ) ;
   }

   public void onLoadActions3P64( )
   {
      AV37Pgmname = "faltas_y_tardes_BC" ;
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) && ( Gx_BScreen == 0 ) )
      {
         A481LegLicenFin = A76LegLicenIni ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
      }
      else
      {
         A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
      }
   }

   public void checkExtendedTable3P64( )
   {
      nIsDirty_64 = (short)(0) ;
      standaloneModal( ) ;
      AV37Pgmname = "faltas_y_tardes_BC" ;
      /* Using cursor BC003P7 */
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
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A76LegLicenIni)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de Inicio", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      /* Using cursor BC003P8 */
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
      if ( isIns( )  && GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) && ( Gx_BScreen == 0 ) )
      {
         nIsDirty_64 = (short)(1) ;
         A481LegLicenFin = A76LegLicenIni ;
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
      if ( GXutil.resetTime(A481LegLicenFin).before( GXutil.resetTime( A76LegLicenIni )) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La fecha de Fin debe ser mayor o igual a la fecha de inicio", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors3P64( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey3P64( )
   {
      /* Using cursor BC003P9 */
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
      /* Using cursor BC003P10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm3P64( 21) ;
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC003P10_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC003P10_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC003P10_A914LegLicDescrip[0] ;
         A1497LegLicEstado = BC003P10_A1497LegLicEstado[0] ;
         A481LegLicenFin = BC003P10_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC003P10_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = BC003P10_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = BC003P10_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = BC003P10_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = BC003P10_A1643LegSitCuenTrab[0] ;
         A1808LegLicCanPres = BC003P10_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = BC003P10_A1810LegLicRemCorr[0] ;
         A3CliCod = BC003P10_A3CliCod[0] ;
         A1EmpCod = BC003P10_A1EmpCod[0] ;
         A6LegNumero = BC003P10_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC003P10_A506LegLicSitCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z76LegLicenIni = A76LegLicenIni ;
         sMode64 = Gx_mode ;
         Gx_mode = "DSP" ;
         load3P64( ) ;
         if ( AnyError == 1 )
         {
            RcdFound64 = (short)(0) ;
            initializeNonKey3P64( ) ;
         }
         Gx_mode = sMode64 ;
      }
      else
      {
         RcdFound64 = (short)(0) ;
         initializeNonKey3P64( ) ;
         sMode64 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode64 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey3P64( ) ;
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
      confirm_3P0( ) ;
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

   public void checkOptimisticConcurrency3P64( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC003P11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoLicencias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z517LegLicSitDescrip, BC003P11_A517LegLicSitDescrip[0]) != 0 ) || ( GXutil.strcmp(Z914LegLicDescrip, BC003P11_A914LegLicDescrip[0]) != 0 ) || ( GXutil.strcmp(Z1497LegLicEstado, BC003P11_A1497LegLicEstado[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z481LegLicenFin), GXutil.resetTime(BC003P11_A481LegLicenFin[0])) ) || ( Z1218LegLicConPlus != BC003P11_A1218LegLicConPlus[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1287LegSitEsLic != BC003P11_A1287LegSitEsLic[0] ) || ( Z1288LegSitEsAu != BC003P11_A1288LegSitEsAu[0] ) || ( Z1289LegSitEsAfip != BC003P11_A1289LegSitEsAfip[0] ) || ( Z1643LegSitCuenTrab != BC003P11_A1643LegSitCuenTrab[0] ) || ( Z1808LegLicCanPres != BC003P11_A1808LegLicCanPres[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1810LegLicRemCorr != BC003P11_A1810LegLicRemCorr[0] ) || ( GXutil.strcmp(Z506LegLicSitCodigo, BC003P11_A506LegLicSitCodigo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoLicencias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert3P64( )
   {
      beforeValidate3P64( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3P64( ) ;
      }
      if ( AnyError == 0 )
      {
         zm3P64( 0) ;
         checkOptimisticConcurrency3P64( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3P64( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert3P64( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003P12 */
                  pr_default.execute(10, new Object[] {A76LegLicenIni, A517LegLicSitDescrip, A914LegLicDescrip, A1497LegLicEstado, A481LegLicenFin, Boolean.valueOf(A1218LegLicConPlus), Byte.valueOf(A1287LegSitEsLic), Byte.valueOf(A1288LegSitEsAu), Byte.valueOf(A1289LegSitEsAfip), Byte.valueOf(A1643LegSitCuenTrab), Byte.valueOf(A1808LegLicCanPres), Byte.valueOf(A1810LegLicRemCorr), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A506LegLicSitCodigo});
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
            load3P64( ) ;
         }
         endLevel3P64( ) ;
      }
      closeExtendedTableCursors3P64( ) ;
   }

   public void update3P64( )
   {
      beforeValidate3P64( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable3P64( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3P64( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm3P64( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate3P64( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC003P13 */
                  pr_default.execute(11, new Object[] {A517LegLicSitDescrip, A914LegLicDescrip, A1497LegLicEstado, A481LegLicenFin, Boolean.valueOf(A1218LegLicConPlus), Byte.valueOf(A1287LegSitEsLic), Byte.valueOf(A1288LegSitEsAu), Byte.valueOf(A1289LegSitEsAfip), Byte.valueOf(A1643LegSitCuenTrab), Byte.valueOf(A1808LegLicCanPres), Byte.valueOf(A1810LegLicRemCorr), A506LegLicSitCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoLicencias"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate3P64( ) ;
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
         endLevel3P64( ) ;
      }
      closeExtendedTableCursors3P64( ) ;
   }

   public void deferredUpdate3P64( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate3P64( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency3P64( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls3P64( ) ;
         afterConfirm3P64( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete3P64( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC003P14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
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
      endLevel3P64( ) ;
      Gx_mode = sMode64 ;
   }

   public void onDeleteControls3P64( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV37Pgmname = "faltas_y_tardes_BC" ;
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

   public void endLevel3P64( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete3P64( ) ;
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

   public void scanKeyStart3P64( )
   {
      /* Scan By routine */
      /* Using cursor BC003P15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      RcdFound64 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC003P15_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC003P15_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC003P15_A914LegLicDescrip[0] ;
         A1497LegLicEstado = BC003P15_A1497LegLicEstado[0] ;
         A481LegLicenFin = BC003P15_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC003P15_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = BC003P15_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = BC003P15_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = BC003P15_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = BC003P15_A1643LegSitCuenTrab[0] ;
         A1808LegLicCanPres = BC003P15_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = BC003P15_A1810LegLicRemCorr[0] ;
         A3CliCod = BC003P15_A3CliCod[0] ;
         A1EmpCod = BC003P15_A1EmpCod[0] ;
         A6LegNumero = BC003P15_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC003P15_A506LegLicSitCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext3P64( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound64 = (short)(0) ;
      scanKeyLoad3P64( ) ;
   }

   public void scanKeyLoad3P64( )
   {
      sMode64 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC003P15_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC003P15_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC003P15_A914LegLicDescrip[0] ;
         A1497LegLicEstado = BC003P15_A1497LegLicEstado[0] ;
         A481LegLicenFin = BC003P15_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC003P15_A1218LegLicConPlus[0] ;
         A1287LegSitEsLic = BC003P15_A1287LegSitEsLic[0] ;
         A1288LegSitEsAu = BC003P15_A1288LegSitEsAu[0] ;
         A1289LegSitEsAfip = BC003P15_A1289LegSitEsAfip[0] ;
         A1643LegSitCuenTrab = BC003P15_A1643LegSitCuenTrab[0] ;
         A1808LegLicCanPres = BC003P15_A1808LegLicCanPres[0] ;
         A1810LegLicRemCorr = BC003P15_A1810LegLicRemCorr[0] ;
         A3CliCod = BC003P15_A3CliCod[0] ;
         A1EmpCod = BC003P15_A1EmpCod[0] ;
         A6LegNumero = BC003P15_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC003P15_A506LegLicSitCodigo[0] ;
      }
      Gx_mode = sMode64 ;
   }

   public void scanKeyEnd3P64( )
   {
      pr_default.close(13);
   }

   public void afterConfirm3P64( )
   {
      /* After Confirm Rules */
      GXt_char6 = A517LegLicSitDescrip ;
      GXv_char7[0] = GXt_char6 ;
      new web.getsituaciondescrip(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char7) ;
      faltas_y_tardes_bc.this.GXt_char6 = GXv_char7[0] ;
      A517LegLicSitDescrip = GXt_char6 ;
      GXt_char6 = A914LegLicDescrip ;
      GXv_char7[0] = GXt_char6 ;
      new web.getsituaciondescripabr(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char7) ;
      faltas_y_tardes_bc.this.GXt_char6 = GXv_char7[0] ;
      A914LegLicDescrip = GXt_char6 ;
      GXv_boolean3[0] = AV33SitEsLicencia ;
      GXv_boolean8[0] = AV32sitEsAusencia ;
      GXv_boolean9[0] = AV31SitLicCuentaTrab ;
      GXv_boolean10[0] = AV30SitEsRevistaAFip ;
      GXv_boolean11[0] = false ;
      GXv_boolean12[0] = AV34EstadoCanPresen ;
      GXv_boolean13[0] = AV35EstadoRemCorr ;
      new web.getsituacionlicenciaprops(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_boolean3, GXv_boolean8, GXv_boolean9, GXv_boolean10, GXv_boolean11, GXv_boolean12, GXv_boolean13) ;
      faltas_y_tardes_bc.this.AV33SitEsLicencia = GXv_boolean3[0] ;
      faltas_y_tardes_bc.this.AV32sitEsAusencia = GXv_boolean8[0] ;
      faltas_y_tardes_bc.this.AV31SitLicCuentaTrab = GXv_boolean9[0] ;
      faltas_y_tardes_bc.this.AV30SitEsRevistaAFip = GXv_boolean10[0] ;
      faltas_y_tardes_bc.this.AV34EstadoCanPresen = GXv_boolean12[0] ;
      faltas_y_tardes_bc.this.AV35EstadoRemCorr = GXv_boolean13[0] ;
      A1810LegLicRemCorr = (byte)((AV35EstadoRemCorr ? 1 : 0)) ;
      A1808LegLicCanPres = (byte)((AV34EstadoCanPresen ? 1 : 0)) ;
      A1289LegSitEsAfip = (byte)((AV30SitEsRevistaAFip ? 1 : 0)) ;
      A1643LegSitCuenTrab = (byte)((AV31SitLicCuentaTrab ? 1 : 0)) ;
      A1288LegSitEsAu = (byte)((AV32sitEsAusencia ? 1 : 0)) ;
      A1287LegSitEsLic = (byte)((AV33SitEsLicencia ? 1 : 0)) ;
   }

   public void beforeInsert3P64( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate3P64( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete3P64( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete3P64( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate3P64( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes3P64( )
   {
   }

   public void send_integrity_lvl_hashes3P64( )
   {
   }

   public void addRow3P64( )
   {
      VarsToRow64( bcfaltas_y_tardes) ;
   }

   public void readRow3P64( )
   {
      RowToVars64( bcfaltas_y_tardes, 1) ;
   }

   public void initializeNonKey3P64( )
   {
      A517LegLicSitDescrip = "" ;
      A914LegLicDescrip = "" ;
      AV33SitEsLicencia = false ;
      AV32sitEsAusencia = false ;
      AV31SitLicCuentaTrab = false ;
      AV30SitEsRevistaAFip = false ;
      AV34EstadoCanPresen = false ;
      AV35EstadoRemCorr = false ;
      A1497LegLicEstado = "" ;
      A501LegLicCntDias = (short)(0) ;
      A506LegLicSitCodigo = "" ;
      A1218LegLicConPlus = false ;
      A1287LegSitEsLic = (byte)(0) ;
      A1288LegSitEsAu = (byte)(0) ;
      A1289LegSitEsAfip = (byte)(0) ;
      A1643LegSitCuenTrab = (byte)(0) ;
      A1808LegLicCanPres = (byte)(0) ;
      A1810LegLicRemCorr = (byte)(0) ;
      A481LegLicenFin = GXutil.nullDate() ;
      Z517LegLicSitDescrip = "" ;
      Z914LegLicDescrip = "" ;
      Z1497LegLicEstado = "" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      Z1218LegLicConPlus = false ;
      Z1287LegSitEsLic = (byte)(0) ;
      Z1288LegSitEsAu = (byte)(0) ;
      Z1289LegSitEsAfip = (byte)(0) ;
      Z1643LegSitCuenTrab = (byte)(0) ;
      Z1808LegLicCanPres = (byte)(0) ;
      Z1810LegLicRemCorr = (byte)(0) ;
      Z506LegLicSitCodigo = "" ;
   }

   public void initAll3P64( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A76LegLicenIni = GXutil.nullDate() ;
      initializeNonKey3P64( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1497LegLicEstado = i1497LegLicEstado ;
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

   public void VarsToRow64( web.Sdtfaltas_y_tardes obj64 )
   {
      obj64.setgxTv_Sdtfaltas_y_tardes_Mode( Gx_mode );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip( A517LegLicSitDescrip );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicdescrip( A914LegLicDescrip );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicestado( A1497LegLicEstado );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legliccntdias( A501LegLicCntDias );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo( A506LegLicSitCodigo );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicconplus( A1218LegLicConPlus );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legsiteslic( A1287LegSitEsLic );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legsitesau( A1288LegSitEsAu );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legsitesafip( A1289LegSitEsAfip );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab( A1643LegSitCuenTrab );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legliccanpres( A1808LegLicCanPres );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicremcorr( A1810LegLicRemCorr );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicenfin( A481LegLicenFin );
      obj64.setgxTv_Sdtfaltas_y_tardes_Clicod( A3CliCod );
      obj64.setgxTv_Sdtfaltas_y_tardes_Empcod( A1EmpCod );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legnumero( A6LegNumero );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicenini( A76LegLicenIni );
      obj64.setgxTv_Sdtfaltas_y_tardes_Clicod_Z( Z3CliCod );
      obj64.setgxTv_Sdtfaltas_y_tardes_Empcod_Z( Z1EmpCod );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legnumero_Z( Z6LegNumero );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicenini_Z( Z76LegLicenIni );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z( Z481LegLicenFin );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z( Z506LegLicSitCodigo );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z( Z517LegLicSitDescrip );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z( Z501LegLicCntDias );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z( Z914LegLicDescrip );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z( Z1218LegLicConPlus );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z( Z1287LegSitEsLic );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legsitesau_Z( Z1288LegSitEsAu );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z( Z1289LegSitEsAfip );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z( Z1643LegSitCuenTrab );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z( Z1808LegLicCanPres );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z( Z1810LegLicRemCorr );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicestado_Z( Z1497LegLicEstado );
      obj64.setgxTv_Sdtfaltas_y_tardes_Mode( Gx_mode );
   }

   public void KeyVarsToRow64( web.Sdtfaltas_y_tardes obj64 )
   {
      obj64.setgxTv_Sdtfaltas_y_tardes_Clicod( A3CliCod );
      obj64.setgxTv_Sdtfaltas_y_tardes_Empcod( A1EmpCod );
      obj64.setgxTv_Sdtfaltas_y_tardes_Legnumero( A6LegNumero );
      obj64.setgxTv_Sdtfaltas_y_tardes_Leglicenini( A76LegLicenIni );
   }

   public void RowToVars64( web.Sdtfaltas_y_tardes obj64 ,
                            int forceLoad )
   {
      Gx_mode = obj64.getgxTv_Sdtfaltas_y_tardes_Mode() ;
      A517LegLicSitDescrip = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip() ;
      A914LegLicDescrip = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicdescrip() ;
      A1497LegLicEstado = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicestado() ;
      A501LegLicCntDias = obj64.getgxTv_Sdtfaltas_y_tardes_Legliccntdias() ;
      A506LegLicSitCodigo = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo() ;
      A1218LegLicConPlus = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicconplus() ;
      A1287LegSitEsLic = obj64.getgxTv_Sdtfaltas_y_tardes_Legsiteslic() ;
      A1288LegSitEsAu = obj64.getgxTv_Sdtfaltas_y_tardes_Legsitesau() ;
      A1289LegSitEsAfip = obj64.getgxTv_Sdtfaltas_y_tardes_Legsitesafip() ;
      A1643LegSitCuenTrab = obj64.getgxTv_Sdtfaltas_y_tardes_Legsitcuentrab() ;
      A1808LegLicCanPres = obj64.getgxTv_Sdtfaltas_y_tardes_Legliccanpres() ;
      A1810LegLicRemCorr = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicremcorr() ;
      A481LegLicenFin = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicenfin() ;
      A3CliCod = obj64.getgxTv_Sdtfaltas_y_tardes_Clicod() ;
      A1EmpCod = obj64.getgxTv_Sdtfaltas_y_tardes_Empcod() ;
      A6LegNumero = obj64.getgxTv_Sdtfaltas_y_tardes_Legnumero() ;
      A76LegLicenIni = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicenini() ;
      Z3CliCod = obj64.getgxTv_Sdtfaltas_y_tardes_Clicod_Z() ;
      Z1EmpCod = obj64.getgxTv_Sdtfaltas_y_tardes_Empcod_Z() ;
      Z6LegNumero = obj64.getgxTv_Sdtfaltas_y_tardes_Legnumero_Z() ;
      Z76LegLicenIni = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicenini_Z() ;
      Z481LegLicenFin = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicenfin_Z() ;
      Z506LegLicSitCodigo = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicsitcodigo_Z() ;
      Z517LegLicSitDescrip = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicsitdescrip_Z() ;
      Z501LegLicCntDias = obj64.getgxTv_Sdtfaltas_y_tardes_Legliccntdias_Z() ;
      Z914LegLicDescrip = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicdescrip_Z() ;
      Z1218LegLicConPlus = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicconplus_Z() ;
      Z1287LegSitEsLic = obj64.getgxTv_Sdtfaltas_y_tardes_Legsiteslic_Z() ;
      Z1288LegSitEsAu = obj64.getgxTv_Sdtfaltas_y_tardes_Legsitesau_Z() ;
      Z1289LegSitEsAfip = obj64.getgxTv_Sdtfaltas_y_tardes_Legsitesafip_Z() ;
      Z1643LegSitCuenTrab = obj64.getgxTv_Sdtfaltas_y_tardes_Legsitcuentrab_Z() ;
      Z1808LegLicCanPres = obj64.getgxTv_Sdtfaltas_y_tardes_Legliccanpres_Z() ;
      Z1810LegLicRemCorr = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicremcorr_Z() ;
      Z1497LegLicEstado = obj64.getgxTv_Sdtfaltas_y_tardes_Leglicestado_Z() ;
      Gx_mode = obj64.getgxTv_Sdtfaltas_y_tardes_Mode() ;
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
      initializeNonKey3P64( ) ;
      scanKeyStart3P64( ) ;
      if ( RcdFound64 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC003P16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z76LegLicenIni = A76LegLicenIni ;
      }
      zm3P64( -21) ;
      onLoadActions3P64( ) ;
      addRow3P64( ) ;
      scanKeyEnd3P64( ) ;
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
      RowToVars64( bcfaltas_y_tardes, 0) ;
      scanKeyStart3P64( ) ;
      if ( RcdFound64 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC003P17 */
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
      zm3P64( -21) ;
      onLoadActions3P64( ) ;
      addRow3P64( ) ;
      scanKeyEnd3P64( ) ;
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
      getKey3P64( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert3P64( ) ;
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
               update3P64( ) ;
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
                     insert3P64( ) ;
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
                     insert3P64( ) ;
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
      RowToVars64( bcfaltas_y_tardes, 1) ;
      saveImpl( ) ;
      VarsToRow64( bcfaltas_y_tardes) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars64( bcfaltas_y_tardes, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert3P64( ) ;
      afterTrn( ) ;
      VarsToRow64( bcfaltas_y_tardes) ;
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
         web.Sdtfaltas_y_tardes auxBC = new web.Sdtfaltas_y_tardes( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A76LegLicenIni);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcfaltas_y_tardes);
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
      RowToVars64( bcfaltas_y_tardes, 1) ;
      updateImpl( ) ;
      VarsToRow64( bcfaltas_y_tardes) ;
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
      RowToVars64( bcfaltas_y_tardes, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert3P64( ) ;
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
      VarsToRow64( bcfaltas_y_tardes) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars64( bcfaltas_y_tardes, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey3P64( ) ;
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "faltas_y_tardes_bc");
      VarsToRow64( bcfaltas_y_tardes) ;
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
      Gx_mode = bcfaltas_y_tardes.getgxTv_Sdtfaltas_y_tardes_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcfaltas_y_tardes.setgxTv_Sdtfaltas_y_tardes_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtfaltas_y_tardes sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcfaltas_y_tardes )
      {
         bcfaltas_y_tardes = sdt ;
         if ( GXutil.strcmp(bcfaltas_y_tardes.getgxTv_Sdtfaltas_y_tardes_Mode(), "") == 0 )
         {
            bcfaltas_y_tardes.setgxTv_Sdtfaltas_y_tardes_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow64( bcfaltas_y_tardes) ;
         }
         else
         {
            RowToVars64( bcfaltas_y_tardes, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcfaltas_y_tardes.getgxTv_Sdtfaltas_y_tardes_Mode(), "") == 0 )
         {
            bcfaltas_y_tardes.setgxTv_Sdtfaltas_y_tardes_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars64( bcfaltas_y_tardes, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtfaltas_y_tardes getfaltas_y_tardes_BC( )
   {
      return bcfaltas_y_tardes ;
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
      AV37Pgmname = "" ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV26TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV25Insert_LegLicSitCodigo = "" ;
      A481LegLicenFin = GXutil.nullDate() ;
      Z517LegLicSitDescrip = "" ;
      A517LegLicSitDescrip = "" ;
      Z914LegLicDescrip = "" ;
      A914LegLicDescrip = "" ;
      Z1497LegLicEstado = "" ;
      A1497LegLicEstado = "" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      Z506LegLicSitCodigo = "" ;
      A506LegLicSitCodigo = "" ;
      GXv_int5 = new int[1] ;
      BC003P6_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P6_A517LegLicSitDescrip = new String[] {""} ;
      BC003P6_A914LegLicDescrip = new String[] {""} ;
      BC003P6_A1497LegLicEstado = new String[] {""} ;
      BC003P6_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P6_A1218LegLicConPlus = new boolean[] {false} ;
      BC003P6_A1287LegSitEsLic = new byte[1] ;
      BC003P6_A1288LegSitEsAu = new byte[1] ;
      BC003P6_A1289LegSitEsAfip = new byte[1] ;
      BC003P6_A1643LegSitCuenTrab = new byte[1] ;
      BC003P6_A1808LegLicCanPres = new byte[1] ;
      BC003P6_A1810LegLicRemCorr = new byte[1] ;
      BC003P6_A3CliCod = new int[1] ;
      BC003P6_A1EmpCod = new short[1] ;
      BC003P6_A6LegNumero = new int[1] ;
      BC003P6_A506LegLicSitCodigo = new String[] {""} ;
      BC003P7_A3CliCod = new int[1] ;
      BC003P8_A506LegLicSitCodigo = new String[] {""} ;
      BC003P9_A3CliCod = new int[1] ;
      BC003P9_A1EmpCod = new short[1] ;
      BC003P9_A6LegNumero = new int[1] ;
      BC003P9_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P10_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P10_A517LegLicSitDescrip = new String[] {""} ;
      BC003P10_A914LegLicDescrip = new String[] {""} ;
      BC003P10_A1497LegLicEstado = new String[] {""} ;
      BC003P10_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P10_A1218LegLicConPlus = new boolean[] {false} ;
      BC003P10_A1287LegSitEsLic = new byte[1] ;
      BC003P10_A1288LegSitEsAu = new byte[1] ;
      BC003P10_A1289LegSitEsAfip = new byte[1] ;
      BC003P10_A1643LegSitCuenTrab = new byte[1] ;
      BC003P10_A1808LegLicCanPres = new byte[1] ;
      BC003P10_A1810LegLicRemCorr = new byte[1] ;
      BC003P10_A3CliCod = new int[1] ;
      BC003P10_A1EmpCod = new short[1] ;
      BC003P10_A6LegNumero = new int[1] ;
      BC003P10_A506LegLicSitCodigo = new String[] {""} ;
      sMode64 = "" ;
      BC003P11_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P11_A517LegLicSitDescrip = new String[] {""} ;
      BC003P11_A914LegLicDescrip = new String[] {""} ;
      BC003P11_A1497LegLicEstado = new String[] {""} ;
      BC003P11_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P11_A1218LegLicConPlus = new boolean[] {false} ;
      BC003P11_A1287LegSitEsLic = new byte[1] ;
      BC003P11_A1288LegSitEsAu = new byte[1] ;
      BC003P11_A1289LegSitEsAfip = new byte[1] ;
      BC003P11_A1643LegSitCuenTrab = new byte[1] ;
      BC003P11_A1808LegLicCanPres = new byte[1] ;
      BC003P11_A1810LegLicRemCorr = new byte[1] ;
      BC003P11_A3CliCod = new int[1] ;
      BC003P11_A1EmpCod = new short[1] ;
      BC003P11_A6LegNumero = new int[1] ;
      BC003P11_A506LegLicSitCodigo = new String[] {""} ;
      BC003P15_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P15_A517LegLicSitDescrip = new String[] {""} ;
      BC003P15_A914LegLicDescrip = new String[] {""} ;
      BC003P15_A1497LegLicEstado = new String[] {""} ;
      BC003P15_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC003P15_A1218LegLicConPlus = new boolean[] {false} ;
      BC003P15_A1287LegSitEsLic = new byte[1] ;
      BC003P15_A1288LegSitEsAu = new byte[1] ;
      BC003P15_A1289LegSitEsAfip = new byte[1] ;
      BC003P15_A1643LegSitCuenTrab = new byte[1] ;
      BC003P15_A1808LegLicCanPres = new byte[1] ;
      BC003P15_A1810LegLicRemCorr = new byte[1] ;
      BC003P15_A3CliCod = new int[1] ;
      BC003P15_A1EmpCod = new short[1] ;
      BC003P15_A6LegNumero = new int[1] ;
      BC003P15_A506LegLicSitCodigo = new String[] {""} ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_boolean8 = new boolean[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXv_boolean13 = new boolean[1] ;
      i1497LegLicEstado = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC003P16_A3CliCod = new int[1] ;
      BC003P17_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.faltas_y_tardes_bc__default(),
         new Object[] {
             new Object[] {
            BC003P2_A76LegLicenIni, BC003P2_A517LegLicSitDescrip, BC003P2_A914LegLicDescrip, BC003P2_A1497LegLicEstado, BC003P2_A481LegLicenFin, BC003P2_A1218LegLicConPlus, BC003P2_A1287LegSitEsLic, BC003P2_A1288LegSitEsAu, BC003P2_A1289LegSitEsAfip, BC003P2_A1643LegSitCuenTrab,
            BC003P2_A1808LegLicCanPres, BC003P2_A1810LegLicRemCorr, BC003P2_A3CliCod, BC003P2_A1EmpCod, BC003P2_A6LegNumero, BC003P2_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003P3_A76LegLicenIni, BC003P3_A517LegLicSitDescrip, BC003P3_A914LegLicDescrip, BC003P3_A1497LegLicEstado, BC003P3_A481LegLicenFin, BC003P3_A1218LegLicConPlus, BC003P3_A1287LegSitEsLic, BC003P3_A1288LegSitEsAu, BC003P3_A1289LegSitEsAfip, BC003P3_A1643LegSitCuenTrab,
            BC003P3_A1808LegLicCanPres, BC003P3_A1810LegLicRemCorr, BC003P3_A3CliCod, BC003P3_A1EmpCod, BC003P3_A6LegNumero, BC003P3_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003P4_A3CliCod
            }
            , new Object[] {
            BC003P5_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003P6_A76LegLicenIni, BC003P6_A517LegLicSitDescrip, BC003P6_A914LegLicDescrip, BC003P6_A1497LegLicEstado, BC003P6_A481LegLicenFin, BC003P6_A1218LegLicConPlus, BC003P6_A1287LegSitEsLic, BC003P6_A1288LegSitEsAu, BC003P6_A1289LegSitEsAfip, BC003P6_A1643LegSitCuenTrab,
            BC003P6_A1808LegLicCanPres, BC003P6_A1810LegLicRemCorr, BC003P6_A3CliCod, BC003P6_A1EmpCod, BC003P6_A6LegNumero, BC003P6_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003P7_A3CliCod
            }
            , new Object[] {
            BC003P8_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003P9_A3CliCod, BC003P9_A1EmpCod, BC003P9_A6LegNumero, BC003P9_A76LegLicenIni
            }
            , new Object[] {
            BC003P10_A76LegLicenIni, BC003P10_A517LegLicSitDescrip, BC003P10_A914LegLicDescrip, BC003P10_A1497LegLicEstado, BC003P10_A481LegLicenFin, BC003P10_A1218LegLicConPlus, BC003P10_A1287LegSitEsLic, BC003P10_A1288LegSitEsAu, BC003P10_A1289LegSitEsAfip, BC003P10_A1643LegSitCuenTrab,
            BC003P10_A1808LegLicCanPres, BC003P10_A1810LegLicRemCorr, BC003P10_A3CliCod, BC003P10_A1EmpCod, BC003P10_A6LegNumero, BC003P10_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003P11_A76LegLicenIni, BC003P11_A517LegLicSitDescrip, BC003P11_A914LegLicDescrip, BC003P11_A1497LegLicEstado, BC003P11_A481LegLicenFin, BC003P11_A1218LegLicConPlus, BC003P11_A1287LegSitEsLic, BC003P11_A1288LegSitEsAu, BC003P11_A1289LegSitEsAfip, BC003P11_A1643LegSitCuenTrab,
            BC003P11_A1808LegLicCanPres, BC003P11_A1810LegLicRemCorr, BC003P11_A3CliCod, BC003P11_A1EmpCod, BC003P11_A6LegNumero, BC003P11_A506LegLicSitCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC003P15_A76LegLicenIni, BC003P15_A517LegLicSitDescrip, BC003P15_A914LegLicDescrip, BC003P15_A1497LegLicEstado, BC003P15_A481LegLicenFin, BC003P15_A1218LegLicConPlus, BC003P15_A1287LegSitEsLic, BC003P15_A1288LegSitEsAu, BC003P15_A1289LegSitEsAfip, BC003P15_A1643LegSitCuenTrab,
            BC003P15_A1808LegLicCanPres, BC003P15_A1810LegLicRemCorr, BC003P15_A3CliCod, BC003P15_A1EmpCod, BC003P15_A6LegNumero, BC003P15_A506LegLicSitCodigo
            }
            , new Object[] {
            BC003P16_A3CliCod
            }
            , new Object[] {
            BC003P17_A3CliCod
            }
         }
      );
      AV37Pgmname = "faltas_y_tardes_BC" ;
      A481LegLicenFin = GXutil.nullDate() ;
      Z481LegLicenFin = GXutil.nullDate() ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e123P2 ();
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
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short AV27cntDias ;
   private short Z501LegLicCntDias ;
   private short A501LegLicCntDias ;
   private short RcdFound64 ;
   private short nIsDirty_64 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int AV38GXV1 ;
   private int AV7CliCod ;
   private int GX_JID ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV37Pgmname ;
   private String AV25Insert_LegLicSitCodigo ;
   private String Z1497LegLicEstado ;
   private String A1497LegLicEstado ;
   private String Z506LegLicSitCodigo ;
   private String A506LegLicSitCodigo ;
   private String sMode64 ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String i1497LegLicEstado ;
   private java.util.Date Z76LegLicenIni ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private java.util.Date Z481LegLicenFin ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean Z1218LegLicConPlus ;
   private boolean A1218LegLicConPlus ;
   private boolean Gx_longc ;
   private boolean AV33SitEsLicencia ;
   private boolean GXv_boolean3[] ;
   private boolean AV32sitEsAusencia ;
   private boolean GXv_boolean8[] ;
   private boolean AV31SitLicCuentaTrab ;
   private boolean GXv_boolean9[] ;
   private boolean AV30SitEsRevistaAFip ;
   private boolean GXv_boolean10[] ;
   private boolean GXv_boolean11[] ;
   private boolean AV34EstadoCanPresen ;
   private boolean GXv_boolean12[] ;
   private boolean AV35EstadoRemCorr ;
   private boolean GXv_boolean13[] ;
   private boolean mustCommit ;
   private String Z517LegLicSitDescrip ;
   private String A517LegLicSitDescrip ;
   private String Z914LegLicDescrip ;
   private String A914LegLicDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private web.Sdtfaltas_y_tardes bcfaltas_y_tardes ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] BC003P6_A76LegLicenIni ;
   private String[] BC003P6_A517LegLicSitDescrip ;
   private String[] BC003P6_A914LegLicDescrip ;
   private String[] BC003P6_A1497LegLicEstado ;
   private java.util.Date[] BC003P6_A481LegLicenFin ;
   private boolean[] BC003P6_A1218LegLicConPlus ;
   private byte[] BC003P6_A1287LegSitEsLic ;
   private byte[] BC003P6_A1288LegSitEsAu ;
   private byte[] BC003P6_A1289LegSitEsAfip ;
   private byte[] BC003P6_A1643LegSitCuenTrab ;
   private byte[] BC003P6_A1808LegLicCanPres ;
   private byte[] BC003P6_A1810LegLicRemCorr ;
   private int[] BC003P6_A3CliCod ;
   private short[] BC003P6_A1EmpCod ;
   private int[] BC003P6_A6LegNumero ;
   private String[] BC003P6_A506LegLicSitCodigo ;
   private int[] BC003P7_A3CliCod ;
   private String[] BC003P8_A506LegLicSitCodigo ;
   private int[] BC003P9_A3CliCod ;
   private short[] BC003P9_A1EmpCod ;
   private int[] BC003P9_A6LegNumero ;
   private java.util.Date[] BC003P9_A76LegLicenIni ;
   private java.util.Date[] BC003P10_A76LegLicenIni ;
   private String[] BC003P10_A517LegLicSitDescrip ;
   private String[] BC003P10_A914LegLicDescrip ;
   private String[] BC003P10_A1497LegLicEstado ;
   private java.util.Date[] BC003P10_A481LegLicenFin ;
   private boolean[] BC003P10_A1218LegLicConPlus ;
   private byte[] BC003P10_A1287LegSitEsLic ;
   private byte[] BC003P10_A1288LegSitEsAu ;
   private byte[] BC003P10_A1289LegSitEsAfip ;
   private byte[] BC003P10_A1643LegSitCuenTrab ;
   private byte[] BC003P10_A1808LegLicCanPres ;
   private byte[] BC003P10_A1810LegLicRemCorr ;
   private int[] BC003P10_A3CliCod ;
   private short[] BC003P10_A1EmpCod ;
   private int[] BC003P10_A6LegNumero ;
   private String[] BC003P10_A506LegLicSitCodigo ;
   private java.util.Date[] BC003P11_A76LegLicenIni ;
   private String[] BC003P11_A517LegLicSitDescrip ;
   private String[] BC003P11_A914LegLicDescrip ;
   private String[] BC003P11_A1497LegLicEstado ;
   private java.util.Date[] BC003P11_A481LegLicenFin ;
   private boolean[] BC003P11_A1218LegLicConPlus ;
   private byte[] BC003P11_A1287LegSitEsLic ;
   private byte[] BC003P11_A1288LegSitEsAu ;
   private byte[] BC003P11_A1289LegSitEsAfip ;
   private byte[] BC003P11_A1643LegSitCuenTrab ;
   private byte[] BC003P11_A1808LegLicCanPres ;
   private byte[] BC003P11_A1810LegLicRemCorr ;
   private int[] BC003P11_A3CliCod ;
   private short[] BC003P11_A1EmpCod ;
   private int[] BC003P11_A6LegNumero ;
   private String[] BC003P11_A506LegLicSitCodigo ;
   private java.util.Date[] BC003P15_A76LegLicenIni ;
   private String[] BC003P15_A517LegLicSitDescrip ;
   private String[] BC003P15_A914LegLicDescrip ;
   private String[] BC003P15_A1497LegLicEstado ;
   private java.util.Date[] BC003P15_A481LegLicenFin ;
   private boolean[] BC003P15_A1218LegLicConPlus ;
   private byte[] BC003P15_A1287LegSitEsLic ;
   private byte[] BC003P15_A1288LegSitEsAu ;
   private byte[] BC003P15_A1289LegSitEsAfip ;
   private byte[] BC003P15_A1643LegSitCuenTrab ;
   private byte[] BC003P15_A1808LegLicCanPres ;
   private byte[] BC003P15_A1810LegLicRemCorr ;
   private int[] BC003P15_A3CliCod ;
   private short[] BC003P15_A1EmpCod ;
   private int[] BC003P15_A6LegNumero ;
   private String[] BC003P15_A506LegLicSitCodigo ;
   private int[] BC003P16_A3CliCod ;
   private int[] BC003P17_A3CliCod ;
   private java.util.Date[] BC003P2_A76LegLicenIni ;
   private String[] BC003P2_A517LegLicSitDescrip ;
   private String[] BC003P2_A914LegLicDescrip ;
   private String[] BC003P2_A1497LegLicEstado ;
   private java.util.Date[] BC003P2_A481LegLicenFin ;
   private boolean[] BC003P2_A1218LegLicConPlus ;
   private byte[] BC003P2_A1287LegSitEsLic ;
   private byte[] BC003P2_A1288LegSitEsAu ;
   private byte[] BC003P2_A1289LegSitEsAfip ;
   private byte[] BC003P2_A1643LegSitCuenTrab ;
   private byte[] BC003P2_A1808LegLicCanPres ;
   private byte[] BC003P2_A1810LegLicRemCorr ;
   private int[] BC003P2_A3CliCod ;
   private short[] BC003P2_A1EmpCod ;
   private int[] BC003P2_A6LegNumero ;
   private String[] BC003P2_A506LegLicSitCodigo ;
   private java.util.Date[] BC003P3_A76LegLicenIni ;
   private String[] BC003P3_A517LegLicSitDescrip ;
   private String[] BC003P3_A914LegLicDescrip ;
   private String[] BC003P3_A1497LegLicEstado ;
   private java.util.Date[] BC003P3_A481LegLicenFin ;
   private boolean[] BC003P3_A1218LegLicConPlus ;
   private byte[] BC003P3_A1287LegSitEsLic ;
   private byte[] BC003P3_A1288LegSitEsAu ;
   private byte[] BC003P3_A1289LegSitEsAfip ;
   private byte[] BC003P3_A1643LegSitCuenTrab ;
   private byte[] BC003P3_A1808LegLicCanPres ;
   private byte[] BC003P3_A1810LegLicRemCorr ;
   private int[] BC003P3_A3CliCod ;
   private short[] BC003P3_A1EmpCod ;
   private int[] BC003P3_A6LegNumero ;
   private String[] BC003P3_A506LegLicSitCodigo ;
   private int[] BC003P4_A3CliCod ;
   private String[] BC003P5_A506LegLicSitCodigo ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV26TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class faltas_y_tardes_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC003P2", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicEstado, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?  FOR UPDATE OF LegajoLicencias",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P3", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicEstado, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P5", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P6", "SELECT TM1.LegLicenIni, TM1.LegLicSitDescrip, TM1.LegLicDescrip, TM1.LegLicEstado, TM1.LegLicenFin, TM1.LegLicConPlus, TM1.LegSitEsLic, TM1.LegSitEsAu, TM1.LegSitEsAfip, TM1.LegSitCuenTrab, TM1.LegLicCanPres, TM1.LegLicRemCorr, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicSitCodigo AS LegLicSitCodigo FROM LegajoLicencias TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegLicenIni = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicenIni ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P7", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P8", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P9", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P10", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicEstado, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P11", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicEstado, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?  FOR UPDATE OF LegajoLicencias",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC003P12", "SAVEPOINT gxupdate;INSERT INTO LegajoLicencias(LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicEstado, LegLicenFin, LegLicConPlus, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr, CliCod, EmpCod, LegNumero, LegLicSitCodigo, LegLIcMot, LegLicFile, LegLicFileNom, LegLicFileExt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003P13", "SAVEPOINT gxupdate;UPDATE LegajoLicencias SET LegLicSitDescrip=?, LegLicDescrip=?, LegLicEstado=?, LegLicenFin=?, LegLicConPlus=?, LegSitEsLic=?, LegSitEsAu=?, LegSitEsAfip=?, LegSitCuenTrab=?, LegLicCanPres=?, LegLicRemCorr=?, LegLicSitCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC003P14", "SAVEPOINT gxupdate;DELETE FROM LegajoLicencias  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC003P15", "SELECT TM1.LegLicenIni, TM1.LegLicSitDescrip, TM1.LegLicDescrip, TM1.LegLicEstado, TM1.LegLicenFin, TM1.LegLicConPlus, TM1.LegSitEsLic, TM1.LegSitEsAu, TM1.LegSitEsAfip, TM1.LegSitCuenTrab, TM1.LegLicCanPres, TM1.LegLicRemCorr, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicSitCodigo AS LegLicSitCodigo FROM LegajoLicencias TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegLicenIni = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicenIni ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P16", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC003P17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
               return;
            case 9 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
               return;
            case 13 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((byte[]) buf[11])[0] = rslt.getByte(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               ((short[]) buf[13])[0] = rslt.getShort(14);
               ((int[]) buf[14])[0] = rslt.getInt(15);
               ((String[]) buf[15])[0] = rslt.getString(16, 4);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 15 :
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setString(16, (String)parms[15], 4);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setString(12, (String)parms[11], 4);
               stmt.setInt(13, ((Number) parms[12]).intValue());
               stmt.setShort(14, ((Number) parms[13]).shortValue());
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setDate(16, (java.util.Date)parms[15]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
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
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

