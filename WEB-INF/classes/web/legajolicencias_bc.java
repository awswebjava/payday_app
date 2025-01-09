package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajolicencias_bc extends GXWebPanel implements IGxSilentTrn
{
   public legajolicencias_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajolicencias_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajolicencias_bc.class ));
   }

   public legajolicencias_bc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1V64( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1V64( ) ;
      standaloneModal( ) ;
      addRow1V64( ) ;
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
         e111V2 ();
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

   public void confirm_1V0( )
   {
      beforeValidate1V64( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1V64( ) ;
         }
         else
         {
            checkExtendedTable1V64( ) ;
            if ( AnyError == 0 )
            {
               zm1V64( 11) ;
               zm1V64( 12) ;
            }
            closeExtendedTableCursors1V64( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e121V2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoLicencias_Insert", GXv_boolean3) ;
         legajolicencias_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoLicencias_Update", GXv_boolean3) ;
         legajolicencias_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoLicencias_Delete", GXv_boolean3) ;
         legajolicencias_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV22Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV14TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV22Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV23GXV1 = 1 ;
         while ( AV23GXV1 <= AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV21TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV14TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV23GXV1));
            if ( GXutil.strcmp(AV21TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "LegLicSitCodigo") == 0 )
            {
               AV20Insert_LegLicSitCodigo = AV21TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
            }
            AV23GXV1 = (int)(AV23GXV1+1) ;
         }
      }
   }

   public void e111V2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1V64( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z517LegLicSitDescrip = A517LegLicSitDescrip ;
         Z914LegLicDescrip = A914LegLicDescrip ;
         Z481LegLicenFin = A481LegLicenFin ;
         Z1218LegLicConPlus = A1218LegLicConPlus ;
         Z506LegLicSitCodigo = A506LegLicSitCodigo ;
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z501LegLicCntDias = A501LegLicCntDias ;
      }
      if ( GX_JID == -10 )
      {
         Z76LegLicenIni = A76LegLicenIni ;
         Z517LegLicSitDescrip = A517LegLicSitDescrip ;
         Z914LegLicDescrip = A914LegLicDescrip ;
         Z481LegLicenFin = A481LegLicenFin ;
         Z1218LegLicConPlus = A1218LegLicConPlus ;
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
         legajolicencias_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load1V64( )
   {
      /* Using cursor BC001V6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A517LegLicSitDescrip = BC001V6_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC001V6_A914LegLicDescrip[0] ;
         A481LegLicenFin = BC001V6_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC001V6_A1218LegLicConPlus[0] ;
         A506LegLicSitCodigo = BC001V6_A506LegLicSitCodigo[0] ;
         zm1V64( -10) ;
      }
      pr_default.close(4);
      onLoadActions1V64( ) ;
   }

   public void onLoadActions1V64( )
   {
      AV22Pgmname = "LegajoLicencias_BC" ;
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A481LegLicenFin)) )
      {
         A501LegLicCntDias = (short)(GXutil.ddiff(A481LegLicenFin,A76LegLicenIni)+1) ;
      }
      else
      {
         A501LegLicCntDias = (short)(GXutil.ddiff(GXutil.eomdate( A76LegLicenIni),A76LegLicenIni)+1) ;
      }
   }

   public void checkExtendedTable1V64( )
   {
      nIsDirty_64 = (short)(0) ;
      standaloneModal( ) ;
      AV22Pgmname = "LegajoLicencias_BC" ;
      /* Using cursor BC001V7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
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
      /* Using cursor BC001V8 */
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
   }

   public void closeExtendedTableCursors1V64( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey1V64( )
   {
      /* Using cursor BC001V9 */
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
      /* Using cursor BC001V10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm1V64( 10) ;
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC001V10_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC001V10_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC001V10_A914LegLicDescrip[0] ;
         A481LegLicenFin = BC001V10_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC001V10_A1218LegLicConPlus[0] ;
         A3CliCod = BC001V10_A3CliCod[0] ;
         A1EmpCod = BC001V10_A1EmpCod[0] ;
         A6LegNumero = BC001V10_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC001V10_A506LegLicSitCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z76LegLicenIni = A76LegLicenIni ;
         sMode64 = Gx_mode ;
         Gx_mode = "DSP" ;
         load1V64( ) ;
         if ( AnyError == 1 )
         {
            RcdFound64 = (short)(0) ;
            initializeNonKey1V64( ) ;
         }
         Gx_mode = sMode64 ;
      }
      else
      {
         RcdFound64 = (short)(0) ;
         initializeNonKey1V64( ) ;
         sMode64 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode64 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey1V64( ) ;
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
      confirm_1V0( ) ;
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

   public void checkOptimisticConcurrency1V64( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001V11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoLicencias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z517LegLicSitDescrip, BC001V11_A517LegLicSitDescrip[0]) != 0 ) || ( GXutil.strcmp(Z914LegLicDescrip, BC001V11_A914LegLicDescrip[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z481LegLicenFin), GXutil.resetTime(BC001V11_A481LegLicenFin[0])) ) || ( Z1218LegLicConPlus != BC001V11_A1218LegLicConPlus[0] ) || ( GXutil.strcmp(Z506LegLicSitCodigo, BC001V11_A506LegLicSitCodigo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoLicencias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1V64( )
   {
      beforeValidate1V64( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1V64( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1V64( 0) ;
         checkOptimisticConcurrency1V64( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1V64( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1V64( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001V12 */
                  pr_default.execute(10, new Object[] {A76LegLicenIni, A517LegLicSitDescrip, A914LegLicDescrip, A481LegLicenFin, Boolean.valueOf(A1218LegLicConPlus), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A506LegLicSitCodigo});
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
            load1V64( ) ;
         }
         endLevel1V64( ) ;
      }
      closeExtendedTableCursors1V64( ) ;
   }

   public void update1V64( )
   {
      beforeValidate1V64( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1V64( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1V64( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1V64( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1V64( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001V13 */
                  pr_default.execute(11, new Object[] {A517LegLicSitDescrip, A914LegLicDescrip, A481LegLicenFin, Boolean.valueOf(A1218LegLicConPlus), A506LegLicSitCodigo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoLicencias");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoLicencias"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1V64( ) ;
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
         endLevel1V64( ) ;
      }
      closeExtendedTableCursors1V64( ) ;
   }

   public void deferredUpdate1V64( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1V64( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1V64( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1V64( ) ;
         afterConfirm1V64( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1V64( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001V14 */
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
      endLevel1V64( ) ;
      Gx_mode = sMode64 ;
   }

   public void onDeleteControls1V64( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV22Pgmname = "LegajoLicencias_BC" ;
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

   public void endLevel1V64( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1V64( ) ;
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

   public void scanKeyStart1V64( )
   {
      /* Scan By routine */
      /* Using cursor BC001V15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A76LegLicenIni});
      RcdFound64 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC001V15_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC001V15_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC001V15_A914LegLicDescrip[0] ;
         A481LegLicenFin = BC001V15_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC001V15_A1218LegLicConPlus[0] ;
         A3CliCod = BC001V15_A3CliCod[0] ;
         A1EmpCod = BC001V15_A1EmpCod[0] ;
         A6LegNumero = BC001V15_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC001V15_A506LegLicSitCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1V64( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound64 = (short)(0) ;
      scanKeyLoad1V64( ) ;
   }

   public void scanKeyLoad1V64( )
   {
      sMode64 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound64 = (short)(1) ;
         A76LegLicenIni = BC001V15_A76LegLicenIni[0] ;
         A517LegLicSitDescrip = BC001V15_A517LegLicSitDescrip[0] ;
         A914LegLicDescrip = BC001V15_A914LegLicDescrip[0] ;
         A481LegLicenFin = BC001V15_A481LegLicenFin[0] ;
         A1218LegLicConPlus = BC001V15_A1218LegLicConPlus[0] ;
         A3CliCod = BC001V15_A3CliCod[0] ;
         A1EmpCod = BC001V15_A1EmpCod[0] ;
         A6LegNumero = BC001V15_A6LegNumero[0] ;
         A506LegLicSitCodigo = BC001V15_A506LegLicSitCodigo[0] ;
      }
      Gx_mode = sMode64 ;
   }

   public void scanKeyEnd1V64( )
   {
      pr_default.close(13);
   }

   public void afterConfirm1V64( )
   {
      /* After Confirm Rules */
      GXt_char6 = A517LegLicSitDescrip ;
      GXv_char7[0] = GXt_char6 ;
      new web.getsituaciondescrip(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char7) ;
      legajolicencias_bc.this.GXt_char6 = GXv_char7[0] ;
      A517LegLicSitDescrip = GXt_char6 ;
      GXt_char6 = A914LegLicDescrip ;
      GXv_char7[0] = GXt_char6 ;
      new web.getsituaciondescripabr(remoteHandle, context).execute( A506LegLicSitCodigo, GXv_char7) ;
      legajolicencias_bc.this.GXt_char6 = GXv_char7[0] ;
      A914LegLicDescrip = GXt_char6 ;
   }

   public void beforeInsert1V64( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1V64( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1V64( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1V64( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1V64( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1V64( )
   {
   }

   public void send_integrity_lvl_hashes1V64( )
   {
   }

   public void addRow1V64( )
   {
      VarsToRow64( bcLegajoLicencias) ;
   }

   public void readRow1V64( )
   {
      RowToVars64( bcLegajoLicencias, 1) ;
   }

   public void initializeNonKey1V64( )
   {
      A517LegLicSitDescrip = "" ;
      A914LegLicDescrip = "" ;
      A501LegLicCntDias = (short)(0) ;
      A481LegLicenFin = GXutil.nullDate() ;
      A506LegLicSitCodigo = "" ;
      A1218LegLicConPlus = false ;
      Z517LegLicSitDescrip = "" ;
      Z914LegLicDescrip = "" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      Z1218LegLicConPlus = false ;
      Z506LegLicSitCodigo = "" ;
   }

   public void initAll1V64( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A76LegLicenIni = GXutil.nullDate() ;
      initializeNonKey1V64( ) ;
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

   public void VarsToRow64( web.SdtLegajoLicencias obj64 )
   {
      obj64.setgxTv_SdtLegajoLicencias_Mode( Gx_mode );
      obj64.setgxTv_SdtLegajoLicencias_Leglicsitdescrip( A517LegLicSitDescrip );
      obj64.setgxTv_SdtLegajoLicencias_Leglicdescrip( A914LegLicDescrip );
      obj64.setgxTv_SdtLegajoLicencias_Legliccntdias( A501LegLicCntDias );
      obj64.setgxTv_SdtLegajoLicencias_Leglicenfin( A481LegLicenFin );
      obj64.setgxTv_SdtLegajoLicencias_Leglicsitcodigo( A506LegLicSitCodigo );
      obj64.setgxTv_SdtLegajoLicencias_Leglicconplus( A1218LegLicConPlus );
      obj64.setgxTv_SdtLegajoLicencias_Clicod( A3CliCod );
      obj64.setgxTv_SdtLegajoLicencias_Empcod( A1EmpCod );
      obj64.setgxTv_SdtLegajoLicencias_Legnumero( A6LegNumero );
      obj64.setgxTv_SdtLegajoLicencias_Leglicenini( A76LegLicenIni );
      obj64.setgxTv_SdtLegajoLicencias_Clicod_Z( Z3CliCod );
      obj64.setgxTv_SdtLegajoLicencias_Empcod_Z( Z1EmpCod );
      obj64.setgxTv_SdtLegajoLicencias_Legnumero_Z( Z6LegNumero );
      obj64.setgxTv_SdtLegajoLicencias_Leglicenini_Z( Z76LegLicenIni );
      obj64.setgxTv_SdtLegajoLicencias_Leglicenfin_Z( Z481LegLicenFin );
      obj64.setgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z( Z506LegLicSitCodigo );
      obj64.setgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z( Z517LegLicSitDescrip );
      obj64.setgxTv_SdtLegajoLicencias_Legliccntdias_Z( Z501LegLicCntDias );
      obj64.setgxTv_SdtLegajoLicencias_Leglicdescrip_Z( Z914LegLicDescrip );
      obj64.setgxTv_SdtLegajoLicencias_Leglicconplus_Z( Z1218LegLicConPlus );
      obj64.setgxTv_SdtLegajoLicencias_Mode( Gx_mode );
   }

   public void KeyVarsToRow64( web.SdtLegajoLicencias obj64 )
   {
      obj64.setgxTv_SdtLegajoLicencias_Clicod( A3CliCod );
      obj64.setgxTv_SdtLegajoLicencias_Empcod( A1EmpCod );
      obj64.setgxTv_SdtLegajoLicencias_Legnumero( A6LegNumero );
      obj64.setgxTv_SdtLegajoLicencias_Leglicenini( A76LegLicenIni );
   }

   public void RowToVars64( web.SdtLegajoLicencias obj64 ,
                            int forceLoad )
   {
      Gx_mode = obj64.getgxTv_SdtLegajoLicencias_Mode() ;
      A517LegLicSitDescrip = obj64.getgxTv_SdtLegajoLicencias_Leglicsitdescrip() ;
      A914LegLicDescrip = obj64.getgxTv_SdtLegajoLicencias_Leglicdescrip() ;
      A501LegLicCntDias = obj64.getgxTv_SdtLegajoLicencias_Legliccntdias() ;
      A481LegLicenFin = obj64.getgxTv_SdtLegajoLicencias_Leglicenfin() ;
      A506LegLicSitCodigo = obj64.getgxTv_SdtLegajoLicencias_Leglicsitcodigo() ;
      A1218LegLicConPlus = obj64.getgxTv_SdtLegajoLicencias_Leglicconplus() ;
      A3CliCod = obj64.getgxTv_SdtLegajoLicencias_Clicod() ;
      A1EmpCod = obj64.getgxTv_SdtLegajoLicencias_Empcod() ;
      A6LegNumero = obj64.getgxTv_SdtLegajoLicencias_Legnumero() ;
      A76LegLicenIni = obj64.getgxTv_SdtLegajoLicencias_Leglicenini() ;
      Z3CliCod = obj64.getgxTv_SdtLegajoLicencias_Clicod_Z() ;
      Z1EmpCod = obj64.getgxTv_SdtLegajoLicencias_Empcod_Z() ;
      Z6LegNumero = obj64.getgxTv_SdtLegajoLicencias_Legnumero_Z() ;
      Z76LegLicenIni = obj64.getgxTv_SdtLegajoLicencias_Leglicenini_Z() ;
      Z481LegLicenFin = obj64.getgxTv_SdtLegajoLicencias_Leglicenfin_Z() ;
      Z506LegLicSitCodigo = obj64.getgxTv_SdtLegajoLicencias_Leglicsitcodigo_Z() ;
      Z517LegLicSitDescrip = obj64.getgxTv_SdtLegajoLicencias_Leglicsitdescrip_Z() ;
      Z501LegLicCntDias = obj64.getgxTv_SdtLegajoLicencias_Legliccntdias_Z() ;
      Z914LegLicDescrip = obj64.getgxTv_SdtLegajoLicencias_Leglicdescrip_Z() ;
      Z1218LegLicConPlus = obj64.getgxTv_SdtLegajoLicencias_Leglicconplus_Z() ;
      Gx_mode = obj64.getgxTv_SdtLegajoLicencias_Mode() ;
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
      initializeNonKey1V64( ) ;
      scanKeyStart1V64( ) ;
      if ( RcdFound64 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001V16 */
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
      zm1V64( -10) ;
      onLoadActions1V64( ) ;
      addRow1V64( ) ;
      scanKeyEnd1V64( ) ;
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
      RowToVars64( bcLegajoLicencias, 0) ;
      scanKeyStart1V64( ) ;
      if ( RcdFound64 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001V17 */
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
      zm1V64( -10) ;
      onLoadActions1V64( ) ;
      addRow1V64( ) ;
      scanKeyEnd1V64( ) ;
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
      getKey1V64( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1V64( ) ;
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
               update1V64( ) ;
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
                     insert1V64( ) ;
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
                     insert1V64( ) ;
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
      RowToVars64( bcLegajoLicencias, 1) ;
      saveImpl( ) ;
      VarsToRow64( bcLegajoLicencias) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars64( bcLegajoLicencias, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1V64( ) ;
      afterTrn( ) ;
      VarsToRow64( bcLegajoLicencias) ;
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
         web.SdtLegajoLicencias auxBC = new web.SdtLegajoLicencias( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A76LegLicenIni);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcLegajoLicencias);
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
      RowToVars64( bcLegajoLicencias, 1) ;
      updateImpl( ) ;
      VarsToRow64( bcLegajoLicencias) ;
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
      RowToVars64( bcLegajoLicencias, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1V64( ) ;
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
      VarsToRow64( bcLegajoLicencias) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars64( bcLegajoLicencias, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1V64( ) ;
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "legajolicencias_bc");
      VarsToRow64( bcLegajoLicencias) ;
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
      Gx_mode = bcLegajoLicencias.getgxTv_SdtLegajoLicencias_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcLegajoLicencias.setgxTv_SdtLegajoLicencias_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtLegajoLicencias sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcLegajoLicencias )
      {
         bcLegajoLicencias = sdt ;
         if ( GXutil.strcmp(bcLegajoLicencias.getgxTv_SdtLegajoLicencias_Mode(), "") == 0 )
         {
            bcLegajoLicencias.setgxTv_SdtLegajoLicencias_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow64( bcLegajoLicencias) ;
         }
         else
         {
            RowToVars64( bcLegajoLicencias, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcLegajoLicencias.getgxTv_SdtLegajoLicencias_Mode(), "") == 0 )
         {
            bcLegajoLicencias.setgxTv_SdtLegajoLicencias_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars64( bcLegajoLicencias, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtLegajoLicencias getLegajoLicencias_BC( )
   {
      return bcLegajoLicencias ;
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
      AV22Pgmname = "" ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      AV21TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV20Insert_LegLicSitCodigo = "" ;
      Z517LegLicSitDescrip = "" ;
      A517LegLicSitDescrip = "" ;
      Z914LegLicDescrip = "" ;
      A914LegLicDescrip = "" ;
      Z481LegLicenFin = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      Z506LegLicSitCodigo = "" ;
      A506LegLicSitCodigo = "" ;
      GXv_int5 = new int[1] ;
      BC001V6_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V6_A517LegLicSitDescrip = new String[] {""} ;
      BC001V6_A914LegLicDescrip = new String[] {""} ;
      BC001V6_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V6_A1218LegLicConPlus = new boolean[] {false} ;
      BC001V6_A3CliCod = new int[1] ;
      BC001V6_A1EmpCod = new short[1] ;
      BC001V6_A6LegNumero = new int[1] ;
      BC001V6_A506LegLicSitCodigo = new String[] {""} ;
      BC001V7_A3CliCod = new int[1] ;
      BC001V8_A506LegLicSitCodigo = new String[] {""} ;
      BC001V9_A3CliCod = new int[1] ;
      BC001V9_A1EmpCod = new short[1] ;
      BC001V9_A6LegNumero = new int[1] ;
      BC001V9_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V10_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V10_A517LegLicSitDescrip = new String[] {""} ;
      BC001V10_A914LegLicDescrip = new String[] {""} ;
      BC001V10_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V10_A1218LegLicConPlus = new boolean[] {false} ;
      BC001V10_A3CliCod = new int[1] ;
      BC001V10_A1EmpCod = new short[1] ;
      BC001V10_A6LegNumero = new int[1] ;
      BC001V10_A506LegLicSitCodigo = new String[] {""} ;
      sMode64 = "" ;
      BC001V11_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V11_A517LegLicSitDescrip = new String[] {""} ;
      BC001V11_A914LegLicDescrip = new String[] {""} ;
      BC001V11_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V11_A1218LegLicConPlus = new boolean[] {false} ;
      BC001V11_A3CliCod = new int[1] ;
      BC001V11_A1EmpCod = new short[1] ;
      BC001V11_A6LegNumero = new int[1] ;
      BC001V11_A506LegLicSitCodigo = new String[] {""} ;
      BC001V15_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V15_A517LegLicSitDescrip = new String[] {""} ;
      BC001V15_A914LegLicDescrip = new String[] {""} ;
      BC001V15_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      BC001V15_A1218LegLicConPlus = new boolean[] {false} ;
      BC001V15_A3CliCod = new int[1] ;
      BC001V15_A1EmpCod = new short[1] ;
      BC001V15_A6LegNumero = new int[1] ;
      BC001V15_A506LegLicSitCodigo = new String[] {""} ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001V16_A3CliCod = new int[1] ;
      BC001V17_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajolicencias_bc__default(),
         new Object[] {
             new Object[] {
            BC001V2_A76LegLicenIni, BC001V2_A517LegLicSitDescrip, BC001V2_A914LegLicDescrip, BC001V2_A481LegLicenFin, BC001V2_A1218LegLicConPlus, BC001V2_A3CliCod, BC001V2_A1EmpCod, BC001V2_A6LegNumero, BC001V2_A506LegLicSitCodigo
            }
            , new Object[] {
            BC001V3_A76LegLicenIni, BC001V3_A517LegLicSitDescrip, BC001V3_A914LegLicDescrip, BC001V3_A481LegLicenFin, BC001V3_A1218LegLicConPlus, BC001V3_A3CliCod, BC001V3_A1EmpCod, BC001V3_A6LegNumero, BC001V3_A506LegLicSitCodigo
            }
            , new Object[] {
            BC001V4_A3CliCod
            }
            , new Object[] {
            BC001V5_A506LegLicSitCodigo
            }
            , new Object[] {
            BC001V6_A76LegLicenIni, BC001V6_A517LegLicSitDescrip, BC001V6_A914LegLicDescrip, BC001V6_A481LegLicenFin, BC001V6_A1218LegLicConPlus, BC001V6_A3CliCod, BC001V6_A1EmpCod, BC001V6_A6LegNumero, BC001V6_A506LegLicSitCodigo
            }
            , new Object[] {
            BC001V7_A3CliCod
            }
            , new Object[] {
            BC001V8_A506LegLicSitCodigo
            }
            , new Object[] {
            BC001V9_A3CliCod, BC001V9_A1EmpCod, BC001V9_A6LegNumero, BC001V9_A76LegLicenIni
            }
            , new Object[] {
            BC001V10_A76LegLicenIni, BC001V10_A517LegLicSitDescrip, BC001V10_A914LegLicDescrip, BC001V10_A481LegLicenFin, BC001V10_A1218LegLicConPlus, BC001V10_A3CliCod, BC001V10_A1EmpCod, BC001V10_A6LegNumero, BC001V10_A506LegLicSitCodigo
            }
            , new Object[] {
            BC001V11_A76LegLicenIni, BC001V11_A517LegLicSitDescrip, BC001V11_A914LegLicDescrip, BC001V11_A481LegLicenFin, BC001V11_A1218LegLicConPlus, BC001V11_A3CliCod, BC001V11_A1EmpCod, BC001V11_A6LegNumero, BC001V11_A506LegLicSitCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001V15_A76LegLicenIni, BC001V15_A517LegLicSitDescrip, BC001V15_A914LegLicDescrip, BC001V15_A481LegLicenFin, BC001V15_A1218LegLicConPlus, BC001V15_A3CliCod, BC001V15_A1EmpCod, BC001V15_A6LegNumero, BC001V15_A506LegLicSitCodigo
            }
            , new Object[] {
            BC001V16_A3CliCod
            }
            , new Object[] {
            BC001V17_A3CliCod
            }
         }
      );
      AV22Pgmname = "LegajoLicencias_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e121V2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
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
   private int AV23GXV1 ;
   private int GX_JID ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV22Pgmname ;
   private String AV20Insert_LegLicSitCodigo ;
   private String Z506LegLicSitCodigo ;
   private String A506LegLicSitCodigo ;
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
   private boolean mustCommit ;
   private String Z517LegLicSitDescrip ;
   private String A517LegLicSitDescrip ;
   private String Z914LegLicDescrip ;
   private String A914LegLicDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private web.SdtLegajoLicencias bcLegajoLicencias ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] BC001V6_A76LegLicenIni ;
   private String[] BC001V6_A517LegLicSitDescrip ;
   private String[] BC001V6_A914LegLicDescrip ;
   private java.util.Date[] BC001V6_A481LegLicenFin ;
   private boolean[] BC001V6_A1218LegLicConPlus ;
   private int[] BC001V6_A3CliCod ;
   private short[] BC001V6_A1EmpCod ;
   private int[] BC001V6_A6LegNumero ;
   private String[] BC001V6_A506LegLicSitCodigo ;
   private int[] BC001V7_A3CliCod ;
   private String[] BC001V8_A506LegLicSitCodigo ;
   private int[] BC001V9_A3CliCod ;
   private short[] BC001V9_A1EmpCod ;
   private int[] BC001V9_A6LegNumero ;
   private java.util.Date[] BC001V9_A76LegLicenIni ;
   private java.util.Date[] BC001V10_A76LegLicenIni ;
   private String[] BC001V10_A517LegLicSitDescrip ;
   private String[] BC001V10_A914LegLicDescrip ;
   private java.util.Date[] BC001V10_A481LegLicenFin ;
   private boolean[] BC001V10_A1218LegLicConPlus ;
   private int[] BC001V10_A3CliCod ;
   private short[] BC001V10_A1EmpCod ;
   private int[] BC001V10_A6LegNumero ;
   private String[] BC001V10_A506LegLicSitCodigo ;
   private java.util.Date[] BC001V11_A76LegLicenIni ;
   private String[] BC001V11_A517LegLicSitDescrip ;
   private String[] BC001V11_A914LegLicDescrip ;
   private java.util.Date[] BC001V11_A481LegLicenFin ;
   private boolean[] BC001V11_A1218LegLicConPlus ;
   private int[] BC001V11_A3CliCod ;
   private short[] BC001V11_A1EmpCod ;
   private int[] BC001V11_A6LegNumero ;
   private String[] BC001V11_A506LegLicSitCodigo ;
   private java.util.Date[] BC001V15_A76LegLicenIni ;
   private String[] BC001V15_A517LegLicSitDescrip ;
   private String[] BC001V15_A914LegLicDescrip ;
   private java.util.Date[] BC001V15_A481LegLicenFin ;
   private boolean[] BC001V15_A1218LegLicConPlus ;
   private int[] BC001V15_A3CliCod ;
   private short[] BC001V15_A1EmpCod ;
   private int[] BC001V15_A6LegNumero ;
   private String[] BC001V15_A506LegLicSitCodigo ;
   private int[] BC001V16_A3CliCod ;
   private int[] BC001V17_A3CliCod ;
   private java.util.Date[] BC001V2_A76LegLicenIni ;
   private String[] BC001V2_A517LegLicSitDescrip ;
   private String[] BC001V2_A914LegLicDescrip ;
   private java.util.Date[] BC001V2_A481LegLicenFin ;
   private boolean[] BC001V2_A1218LegLicConPlus ;
   private int[] BC001V2_A3CliCod ;
   private short[] BC001V2_A1EmpCod ;
   private int[] BC001V2_A6LegNumero ;
   private String[] BC001V2_A506LegLicSitCodigo ;
   private java.util.Date[] BC001V3_A76LegLicenIni ;
   private String[] BC001V3_A517LegLicSitDescrip ;
   private String[] BC001V3_A914LegLicDescrip ;
   private java.util.Date[] BC001V3_A481LegLicenFin ;
   private boolean[] BC001V3_A1218LegLicConPlus ;
   private int[] BC001V3_A3CliCod ;
   private short[] BC001V3_A1EmpCod ;
   private int[] BC001V3_A6LegNumero ;
   private String[] BC001V3_A506LegLicSitCodigo ;
   private int[] BC001V4_A3CliCod ;
   private String[] BC001V5_A506LegLicSitCodigo ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV21TrnContextAtt ;
}

final  class legajolicencias_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC001V2", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?  FOR UPDATE OF LegajoLicencias",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V3", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V5", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V6", "SELECT TM1.LegLicenIni, TM1.LegLicSitDescrip, TM1.LegLicDescrip, TM1.LegLicenFin, TM1.LegLicConPlus, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicSitCodigo AS LegLicSitCodigo FROM LegajoLicencias TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegLicenIni = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicenIni ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V7", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V8", "SELECT SitCodigo AS LegLicSitCodigo FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V9", "SELECT CliCod, EmpCod, LegNumero, LegLicenIni FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V10", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V11", "SELECT LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, CliCod, EmpCod, LegNumero, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?  FOR UPDATE OF LegajoLicencias",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001V12", "SAVEPOINT gxupdate;INSERT INTO LegajoLicencias(LegLicenIni, LegLicSitDescrip, LegLicDescrip, LegLicenFin, LegLicConPlus, CliCod, EmpCod, LegNumero, LegLicSitCodigo, LegSitEsLic, LegSitEsAu, LegSitEsAfip, LegLicEstado, LegLIcMot, LegLicFile, LegLicFileNom, LegLicFileExt, LegSitCuenTrab, LegLicCanPres, LegLicRemCorr) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, '', '', '', '', '', 0, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001V13", "SAVEPOINT gxupdate;UPDATE LegajoLicencias SET LegLicSitDescrip=?, LegLicDescrip=?, LegLicenFin=?, LegLicConPlus=?, LegLicSitCodigo=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001V14", "SAVEPOINT gxupdate;DELETE FROM LegajoLicencias  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND LegLicenIni = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001V15", "SELECT TM1.LegLicenIni, TM1.LegLicSitDescrip, TM1.LegLicDescrip, TM1.LegLicenFin, TM1.LegLicConPlus, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicSitCodigo AS LegLicSitCodigo FROM LegajoLicencias TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.LegLicenIni = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.LegLicenIni ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V16", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001V17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
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
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
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
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               return;
            case 9 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               return;
            case 13 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 4);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setString(5, (String)parms[4], 4);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setDate(9, (java.util.Date)parms[8]);
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

