package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class tipoliquidacion_bc extends GXWebPanel implements IGxSilentTrn
{
   public tipoliquidacion_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public tipoliquidacion_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( tipoliquidacion_bc.class ));
   }

   public tipoliquidacion_bc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1E47( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1E47( ) ;
      standaloneModal( ) ;
      addRow1E47( ) ;
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
         e111E2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z32TLiqCod = A32TLiqCod ;
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

   public void confirm_1E0( )
   {
      beforeValidate1E47( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1E47( ) ;
         }
         else
         {
            checkExtendedTable1E47( ) ;
            if ( AnyError == 0 )
            {
               zm1E47( 8) ;
            }
            closeExtendedTableCursors1E47( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode47 = Gx_mode ;
         confirm_1E300( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode47 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode47 ;
      }
   }

   public void confirm_1E300( )
   {
      nGXsfl_300_idx = 0 ;
      while ( nGXsfl_300_idx < bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().size() )
      {
         readRow1E300( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound300 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_300 != 0 ) )
         {
            getKey1E300( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound300 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate1E300( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1E300( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors1E300( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound300 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey1E300( ) ;
                     load1E300( ) ;
                     beforeValidate1E300( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1E300( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_300 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate1E300( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1E300( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors1E300( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow300( ((web.SdtTipoLiquidacion_modo_frec)bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().elementAt(-1+nGXsfl_300_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e121E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion_Insert", GXv_boolean3) ;
         tipoliquidacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion_Update", GXv_boolean3) ;
         tipoliquidacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWTipoLiquidacion_Delete", GXv_boolean3) ;
         tipoliquidacion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV20Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e111E2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1E47( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z340TliqDesc = A340TliqDesc ;
         Z341TLiqHabilitada = A341TLiqHabilitada ;
         Z1076TLiqAcuDiasTrab = A1076TLiqAcuDiasTrab ;
         Z1211TliqSAC = A1211TliqSAC ;
         Z1817TLiqOrd = A1817TLiqOrd ;
         Z2091TLiqCodFor = A2091TLiqCodFor ;
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -7 )
      {
         Z32TLiqCod = A32TLiqCod ;
         Z340TliqDesc = A340TliqDesc ;
         Z341TLiqHabilitada = A341TLiqHabilitada ;
         Z1076TLiqAcuDiasTrab = A1076TLiqAcuDiasTrab ;
         Z1211TliqSAC = A1211TliqSAC ;
         Z1817TLiqOrd = A1817TLiqOrd ;
         Z2091TLiqCodFor = A2091TLiqCodFor ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         tipoliquidacion_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (false==A341TLiqHabilitada) && ( Gx_BScreen == 0 ) )
      {
         A341TLiqHabilitada = true ;
      }
   }

   public void load1E47( )
   {
      /* Using cursor BC001E7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A340TliqDesc = BC001E7_A340TliqDesc[0] ;
         A341TLiqHabilitada = BC001E7_A341TLiqHabilitada[0] ;
         A1076TLiqAcuDiasTrab = BC001E7_A1076TLiqAcuDiasTrab[0] ;
         A1211TliqSAC = BC001E7_A1211TliqSAC[0] ;
         A1817TLiqOrd = BC001E7_A1817TLiqOrd[0] ;
         A2091TLiqCodFor = BC001E7_A2091TLiqCodFor[0] ;
         zm1E47( -7) ;
      }
      pr_default.close(5);
      onLoadActions1E47( ) ;
   }

   public void onLoadActions1E47( )
   {
      AV20Pgmname = "TipoLiquidacion_BC" ;
   }

   public void checkExtendedTable1E47( )
   {
      nIsDirty_47 = (short)(0) ;
      standaloneModal( ) ;
      AV20Pgmname = "TipoLiquidacion_BC" ;
      /* Using cursor BC001E8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( (GXutil.strcmp("", A32TLiqCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Tipo de Liquidación", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A340TliqDesc)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripcion", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1E47( )
   {
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey1E47( )
   {
      /* Using cursor BC001E9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound47 = (short)(1) ;
      }
      else
      {
         RcdFound47 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001E10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm1E47( 7) ;
         RcdFound47 = (short)(1) ;
         A32TLiqCod = BC001E10_A32TLiqCod[0] ;
         n32TLiqCod = BC001E10_n32TLiqCod[0] ;
         A340TliqDesc = BC001E10_A340TliqDesc[0] ;
         A341TLiqHabilitada = BC001E10_A341TLiqHabilitada[0] ;
         A1076TLiqAcuDiasTrab = BC001E10_A1076TLiqAcuDiasTrab[0] ;
         A1211TliqSAC = BC001E10_A1211TliqSAC[0] ;
         A1817TLiqOrd = BC001E10_A1817TLiqOrd[0] ;
         A2091TLiqCodFor = BC001E10_A2091TLiqCodFor[0] ;
         A3CliCod = BC001E10_A3CliCod[0] ;
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         sMode47 = Gx_mode ;
         Gx_mode = "DSP" ;
         load1E47( ) ;
         if ( AnyError == 1 )
         {
            RcdFound47 = (short)(0) ;
            initializeNonKey1E47( ) ;
         }
         Gx_mode = sMode47 ;
      }
      else
      {
         RcdFound47 = (short)(0) ;
         initializeNonKey1E47( ) ;
         sMode47 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode47 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey1E47( ) ;
      if ( RcdFound47 == 0 )
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
      confirm_1E0( ) ;
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

   public void checkOptimisticConcurrency1E47( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001E11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoLiquidacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z340TliqDesc, BC001E11_A340TliqDesc[0]) != 0 ) || ( Z341TLiqHabilitada != BC001E11_A341TLiqHabilitada[0] ) || ( Z1076TLiqAcuDiasTrab != BC001E11_A1076TLiqAcuDiasTrab[0] ) || ( Z1211TliqSAC != BC001E11_A1211TliqSAC[0] ) || ( Z1817TLiqOrd != BC001E11_A1817TLiqOrd[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2091TLiqCodFor, BC001E11_A2091TLiqCodFor[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"TipoLiquidacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1E47( )
   {
      beforeValidate1E47( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1E47( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1E47( 0) ;
         checkOptimisticConcurrency1E47( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1E47( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1E47( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001E12 */
                  pr_default.execute(10, new Object[] {Boolean.valueOf(n32TLiqCod), A32TLiqCod, A340TliqDesc, Boolean.valueOf(A341TLiqHabilitada), Boolean.valueOf(A1076TLiqAcuDiasTrab), Boolean.valueOf(A1211TliqSAC), Short.valueOf(A1817TLiqOrd), A2091TLiqCodFor, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacion");
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
                        processLevel1E47( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                        }
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
            load1E47( ) ;
         }
         endLevel1E47( ) ;
      }
      closeExtendedTableCursors1E47( ) ;
   }

   public void update1E47( )
   {
      beforeValidate1E47( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1E47( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1E47( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1E47( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1E47( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001E13 */
                  pr_default.execute(11, new Object[] {A340TliqDesc, Boolean.valueOf(A341TLiqHabilitada), Boolean.valueOf(A1076TLiqAcuDiasTrab), Boolean.valueOf(A1211TliqSAC), Short.valueOf(A1817TLiqOrd), A2091TLiqCodFor, Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacion");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoLiquidacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1E47( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1E47( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
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
         }
         endLevel1E47( ) ;
      }
      closeExtendedTableCursors1E47( ) ;
   }

   public void deferredUpdate1E47( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1E47( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1E47( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1E47( ) ;
         afterConfirm1E47( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1E47( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart1E300( ) ;
               while ( RcdFound300 != 0 )
               {
                  getByPrimaryKey1E300( ) ;
                  delete1E300( ) ;
                  scanKeyNext1E300( ) ;
               }
               scanKeyEnd1E300( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001E14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacion");
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
      }
      sMode47 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1E47( ) ;
      Gx_mode = sMode47 ;
   }

   public void onDeleteControls1E47( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV20Pgmname = "TipoLiquidacion_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC001E15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LegPreliqCab", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor BC001E16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor BC001E17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Tipo Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void processNestedLevel1E300( )
   {
      nGXsfl_300_idx = 0 ;
      while ( nGXsfl_300_idx < bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().size() )
      {
         readRow1E300( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound300 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_300 != 0 ) )
         {
            standaloneNotModal1E300( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert1E300( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete1E300( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update1E300( ) ;
               }
            }
         }
         KeyVarsToRow300( ((web.SdtTipoLiquidacion_modo_frec)bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().elementAt(-1+nGXsfl_300_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_300_idx = 0 ;
         while ( nGXsfl_300_idx < bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().size() )
         {
            readRow1E300( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound300 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().removeElement(nGXsfl_300_idx);
               nGXsfl_300_idx = (int)(nGXsfl_300_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey1E300( ) ;
               VarsToRow300( ((web.SdtTipoLiquidacion_modo_frec)bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().elementAt(-1+nGXsfl_300_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1E300( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_300 = (short)(0) ;
      nIsMod_300 = (short)(0) ;
      Gxremove300 = (byte)(0) ;
   }

   public void processLevel1E47( )
   {
      /* Save parent mode. */
      sMode47 = Gx_mode ;
      processNestedLevel1E300( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode47 ;
      /* ' Update level parameters */
   }

   public void endLevel1E47( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1E47( ) ;
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

   public void scanKeyStart1E47( )
   {
      /* Scan By routine */
      /* Using cursor BC001E18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      RcdFound47 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A32TLiqCod = BC001E18_A32TLiqCod[0] ;
         n32TLiqCod = BC001E18_n32TLiqCod[0] ;
         A340TliqDesc = BC001E18_A340TliqDesc[0] ;
         A341TLiqHabilitada = BC001E18_A341TLiqHabilitada[0] ;
         A1076TLiqAcuDiasTrab = BC001E18_A1076TLiqAcuDiasTrab[0] ;
         A1211TliqSAC = BC001E18_A1211TliqSAC[0] ;
         A1817TLiqOrd = BC001E18_A1817TLiqOrd[0] ;
         A2091TLiqCodFor = BC001E18_A2091TLiqCodFor[0] ;
         A3CliCod = BC001E18_A3CliCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1E47( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound47 = (short)(0) ;
      scanKeyLoad1E47( ) ;
   }

   public void scanKeyLoad1E47( )
   {
      sMode47 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound47 = (short)(1) ;
         A32TLiqCod = BC001E18_A32TLiqCod[0] ;
         n32TLiqCod = BC001E18_n32TLiqCod[0] ;
         A340TliqDesc = BC001E18_A340TliqDesc[0] ;
         A341TLiqHabilitada = BC001E18_A341TLiqHabilitada[0] ;
         A1076TLiqAcuDiasTrab = BC001E18_A1076TLiqAcuDiasTrab[0] ;
         A1211TliqSAC = BC001E18_A1211TliqSAC[0] ;
         A1817TLiqOrd = BC001E18_A1817TLiqOrd[0] ;
         A2091TLiqCodFor = BC001E18_A2091TLiqCodFor[0] ;
         A3CliCod = BC001E18_A3CliCod[0] ;
      }
      Gx_mode = sMode47 ;
   }

   public void scanKeyEnd1E47( )
   {
      pr_default.close(16);
   }

   public void afterConfirm1E47( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1E47( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1E47( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1E47( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1E47( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1E47( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1E47( )
   {
   }

   public void zm1E300( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z2413TLiqDescAuxFrec = A2413TLiqDescAuxFrec ;
      }
      if ( GX_JID == -9 )
      {
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z2408TLiqModTra = A2408TLiqModTra ;
         Z2412TLiqFrecPag = A2412TLiqFrecPag ;
         Z2413TLiqDescAuxFrec = A2413TLiqDescAuxFrec ;
      }
   }

   public void standaloneNotModal1E300( )
   {
   }

   public void standaloneModal1E300( )
   {
   }

   public void load1E300( )
   {
      /* Using cursor BC001E19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound300 = (short)(1) ;
         A2413TLiqDescAuxFrec = BC001E19_A2413TLiqDescAuxFrec[0] ;
         zm1E300( -9) ;
      }
      pr_default.close(17);
      onLoadActions1E300( ) ;
   }

   public void onLoadActions1E300( )
   {
   }

   public void checkExtendedTable1E300( )
   {
      nIsDirty_300 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1E300( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( ! ( ( GXutil.strcmp(A2408TLiqModTra, "E") == 0 ) || ( GXutil.strcmp(A2408TLiqModTra, "I") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Modo de trabajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A2412TLiqFrecPag == 1 ) || ( A2412TLiqFrecPag == 2 ) || ( A2412TLiqFrecPag == 3 ) || ( A2412TLiqFrecPag == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Frecuencia de pago", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1E300( )
   {
   }

   public void enableDisable1E300( )
   {
   }

   public void getKey1E300( )
   {
      /* Using cursor BC001E20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound300 = (short)(1) ;
      }
      else
      {
         RcdFound300 = (short)(0) ;
      }
      pr_default.close(18);
   }

   public void getByPrimaryKey1E300( )
   {
      /* Using cursor BC001E21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         zm1E300( 9) ;
         RcdFound300 = (short)(1) ;
         initializeNonKey1E300( ) ;
         A2408TLiqModTra = BC001E21_A2408TLiqModTra[0] ;
         A2412TLiqFrecPag = BC001E21_A2412TLiqFrecPag[0] ;
         A2413TLiqDescAuxFrec = BC001E21_A2413TLiqDescAuxFrec[0] ;
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
         Z2408TLiqModTra = A2408TLiqModTra ;
         Z2412TLiqFrecPag = A2412TLiqFrecPag ;
         sMode300 = Gx_mode ;
         Gx_mode = "DSP" ;
         load1E300( ) ;
         Gx_mode = sMode300 ;
      }
      else
      {
         RcdFound300 = (short)(0) ;
         initializeNonKey1E300( ) ;
         sMode300 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal1E300( ) ;
         Gx_mode = sMode300 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1E300( ) ;
      }
      pr_default.close(19);
   }

   public void checkOptimisticConcurrency1E300( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001E22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
         if ( (pr_default.getStatus(20) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoLiquidacionmodo_frec"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(20) == 101) || ( GXutil.strcmp(Z2413TLiqDescAuxFrec, BC001E22_A2413TLiqDescAuxFrec[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"TipoLiquidacionmodo_frec"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1E300( )
   {
      beforeValidate1E300( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1E300( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1E300( 0) ;
         checkOptimisticConcurrency1E300( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1E300( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1E300( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001E23 */
                  pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag), A2413TLiqDescAuxFrec});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacionmodo_frec");
                  if ( (pr_default.getStatus(21) == 1) )
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
            load1E300( ) ;
         }
         endLevel1E300( ) ;
      }
      closeExtendedTableCursors1E300( ) ;
   }

   public void update1E300( )
   {
      beforeValidate1E300( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1E300( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1E300( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1E300( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1E300( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001E24 */
                  pr_default.execute(22, new Object[] {A2413TLiqDescAuxFrec, Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacionmodo_frec");
                  if ( (pr_default.getStatus(22) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TipoLiquidacionmodo_frec"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1E300( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey1E300( ) ;
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
         endLevel1E300( ) ;
      }
      closeExtendedTableCursors1E300( ) ;
   }

   public void deferredUpdate1E300( )
   {
   }

   public void delete1E300( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1E300( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1E300( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1E300( ) ;
         afterConfirm1E300( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1E300( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001E25 */
               pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod, A2408TLiqModTra, Byte.valueOf(A2412TLiqFrecPag)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoLiquidacionmodo_frec");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode300 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1E300( ) ;
      Gx_mode = sMode300 ;
   }

   public void onDeleteControls1E300( )
   {
      standaloneModal1E300( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel1E300( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(20);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart1E300( )
   {
      /* Scan By routine */
      /* Using cursor BC001E26 */
      pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Boolean.valueOf(n32TLiqCod), A32TLiqCod});
      RcdFound300 = (short)(0) ;
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound300 = (short)(1) ;
         A2408TLiqModTra = BC001E26_A2408TLiqModTra[0] ;
         A2412TLiqFrecPag = BC001E26_A2412TLiqFrecPag[0] ;
         A2413TLiqDescAuxFrec = BC001E26_A2413TLiqDescAuxFrec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1E300( )
   {
      /* Scan next routine */
      pr_default.readNext(24);
      RcdFound300 = (short)(0) ;
      scanKeyLoad1E300( ) ;
   }

   public void scanKeyLoad1E300( )
   {
      sMode300 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound300 = (short)(1) ;
         A2408TLiqModTra = BC001E26_A2408TLiqModTra[0] ;
         A2412TLiqFrecPag = BC001E26_A2412TLiqFrecPag[0] ;
         A2413TLiqDescAuxFrec = BC001E26_A2413TLiqDescAuxFrec[0] ;
      }
      Gx_mode = sMode300 ;
   }

   public void scanKeyEnd1E300( )
   {
      pr_default.close(24);
   }

   public void afterConfirm1E300( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1E300( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1E300( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1E300( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1E300( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1E300( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1E300( )
   {
   }

   public void send_integrity_lvl_hashes1E300( )
   {
   }

   public void send_integrity_lvl_hashes1E47( )
   {
   }

   public void addRow1E47( )
   {
      VarsToRow47( bcTipoLiquidacion) ;
   }

   public void readRow1E47( )
   {
      RowToVars47( bcTipoLiquidacion, 1) ;
   }

   public void addRow1E300( )
   {
      web.SdtTipoLiquidacion_modo_frec obj300;
      obj300 = new web.SdtTipoLiquidacion_modo_frec(remoteHandle);
      VarsToRow300( obj300) ;
      bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().add(obj300, 0);
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Mode( "UPD" );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Modified( (short)(0) );
   }

   public void readRow1E300( )
   {
      nGXsfl_300_idx = (int)(nGXsfl_300_idx+1) ;
      RowToVars300( ((web.SdtTipoLiquidacion_modo_frec)bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().elementAt(-1+nGXsfl_300_idx)), 1) ;
   }

   public void initializeNonKey1E47( )
   {
      A340TliqDesc = "" ;
      A1076TLiqAcuDiasTrab = false ;
      A1211TliqSAC = false ;
      A1817TLiqOrd = (short)(0) ;
      A2091TLiqCodFor = "" ;
      A341TLiqHabilitada = true ;
      Z340TliqDesc = "" ;
      Z341TLiqHabilitada = false ;
      Z1076TLiqAcuDiasTrab = false ;
      Z1211TliqSAC = false ;
      Z1817TLiqOrd = (short)(0) ;
      Z2091TLiqCodFor = "" ;
   }

   public void initAll1E47( )
   {
      A3CliCod = 0 ;
      A32TLiqCod = "" ;
      n32TLiqCod = false ;
      initializeNonKey1E47( ) ;
   }

   public void standaloneModalInsert( )
   {
      A341TLiqHabilitada = i341TLiqHabilitada ;
   }

   public void initializeNonKey1E300( )
   {
      A2413TLiqDescAuxFrec = "" ;
      Z2413TLiqDescAuxFrec = "" ;
   }

   public void initAll1E300( )
   {
      A2408TLiqModTra = "" ;
      A2412TLiqFrecPag = (byte)(0) ;
      initializeNonKey1E300( ) ;
   }

   public void standaloneModalInsert1E300( )
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

   public void VarsToRow47( web.SdtTipoLiquidacion obj47 )
   {
      obj47.setgxTv_SdtTipoLiquidacion_Mode( Gx_mode );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqdesc( A340TliqDesc );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab( A1076TLiqAcuDiasTrab );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqsac( A1211TliqSAC );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqord( A1817TLiqOrd );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqcodfor( A2091TLiqCodFor );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqhabilitada( A341TLiqHabilitada );
      obj47.setgxTv_SdtTipoLiquidacion_Clicod( A3CliCod );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqcod( A32TLiqCod );
      obj47.setgxTv_SdtTipoLiquidacion_Clicod_Z( Z3CliCod );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqcod_Z( Z32TLiqCod );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqdesc_Z( Z340TliqDesc );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z( Z341TLiqHabilitada );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z( Z1076TLiqAcuDiasTrab );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqsac_Z( Z1211TliqSAC );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqord_Z( Z1817TLiqOrd );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqcodfor_Z( Z2091TLiqCodFor );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqcod_N( (byte)((byte)((n32TLiqCod)?1:0)) );
      obj47.setgxTv_SdtTipoLiquidacion_Mode( Gx_mode );
   }

   public void KeyVarsToRow47( web.SdtTipoLiquidacion obj47 )
   {
      obj47.setgxTv_SdtTipoLiquidacion_Clicod( A3CliCod );
      obj47.setgxTv_SdtTipoLiquidacion_Tliqcod( A32TLiqCod );
   }

   public void RowToVars47( web.SdtTipoLiquidacion obj47 ,
                            int forceLoad )
   {
      Gx_mode = obj47.getgxTv_SdtTipoLiquidacion_Mode() ;
      A340TliqDesc = obj47.getgxTv_SdtTipoLiquidacion_Tliqdesc() ;
      A1076TLiqAcuDiasTrab = obj47.getgxTv_SdtTipoLiquidacion_Tliqacudiastrab() ;
      A1211TliqSAC = obj47.getgxTv_SdtTipoLiquidacion_Tliqsac() ;
      A1817TLiqOrd = obj47.getgxTv_SdtTipoLiquidacion_Tliqord() ;
      A2091TLiqCodFor = obj47.getgxTv_SdtTipoLiquidacion_Tliqcodfor() ;
      A341TLiqHabilitada = obj47.getgxTv_SdtTipoLiquidacion_Tliqhabilitada() ;
      A3CliCod = obj47.getgxTv_SdtTipoLiquidacion_Clicod() ;
      A32TLiqCod = obj47.getgxTv_SdtTipoLiquidacion_Tliqcod() ;
      n32TLiqCod = false ;
      Z3CliCod = obj47.getgxTv_SdtTipoLiquidacion_Clicod_Z() ;
      Z32TLiqCod = obj47.getgxTv_SdtTipoLiquidacion_Tliqcod_Z() ;
      Z340TliqDesc = obj47.getgxTv_SdtTipoLiquidacion_Tliqdesc_Z() ;
      Z341TLiqHabilitada = obj47.getgxTv_SdtTipoLiquidacion_Tliqhabilitada_Z() ;
      Z1076TLiqAcuDiasTrab = obj47.getgxTv_SdtTipoLiquidacion_Tliqacudiastrab_Z() ;
      Z1211TliqSAC = obj47.getgxTv_SdtTipoLiquidacion_Tliqsac_Z() ;
      Z1817TLiqOrd = obj47.getgxTv_SdtTipoLiquidacion_Tliqord_Z() ;
      Z2091TLiqCodFor = obj47.getgxTv_SdtTipoLiquidacion_Tliqcodfor_Z() ;
      n32TLiqCod = (boolean)((obj47.getgxTv_SdtTipoLiquidacion_Tliqcod_N()==0)?false:true) ;
      Gx_mode = obj47.getgxTv_SdtTipoLiquidacion_Mode() ;
   }

   public void VarsToRow300( web.SdtTipoLiquidacion_modo_frec obj300 )
   {
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Mode( Gx_mode );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec( A2413TLiqDescAuxFrec );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra( A2408TLiqModTra );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag( A2412TLiqFrecPag );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z( Z2408TLiqModTra );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z( Z2412TLiqFrecPag );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z( Z2413TLiqDescAuxFrec );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Modified( nIsMod_300 );
   }

   public void KeyVarsToRow300( web.SdtTipoLiquidacion_modo_frec obj300 )
   {
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra( A2408TLiqModTra );
      obj300.setgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag( A2412TLiqFrecPag );
   }

   public void RowToVars300( web.SdtTipoLiquidacion_modo_frec obj300 ,
                             int forceLoad )
   {
      Gx_mode = obj300.getgxTv_SdtTipoLiquidacion_modo_frec_Mode() ;
      A2413TLiqDescAuxFrec = obj300.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec() ;
      A2408TLiqModTra = obj300.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra() ;
      A2412TLiqFrecPag = obj300.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag() ;
      Z2408TLiqModTra = obj300.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqmodtra_Z() ;
      Z2412TLiqFrecPag = obj300.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqfrecpag_Z() ;
      Z2413TLiqDescAuxFrec = obj300.getgxTv_SdtTipoLiquidacion_modo_frec_Tliqdescauxfrec_Z() ;
      nIsMod_300 = obj300.getgxTv_SdtTipoLiquidacion_modo_frec_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A32TLiqCod = (String)getParm(obj,1) ;
      n32TLiqCod = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1E47( ) ;
      scanKeyStart1E47( ) ;
      if ( RcdFound47 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001E27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(25) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
      }
      zm1E47( -7) ;
      onLoadActions1E47( ) ;
      addRow1E47( ) ;
      bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().clearCollection();
      if ( RcdFound47 == 1 )
      {
         scanKeyStart1E300( ) ;
         nGXsfl_300_idx = 1 ;
         while ( RcdFound300 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z32TLiqCod = A32TLiqCod ;
            Z2408TLiqModTra = A2408TLiqModTra ;
            Z2412TLiqFrecPag = A2412TLiqFrecPag ;
            zm1E300( -9) ;
            onLoadActions1E300( ) ;
            nRcdExists_300 = (short)(1) ;
            nIsMod_300 = (short)(0) ;
            addRow1E300( ) ;
            nGXsfl_300_idx = (int)(nGXsfl_300_idx+1) ;
            scanKeyNext1E300( ) ;
         }
         scanKeyEnd1E300( ) ;
      }
      scanKeyEnd1E47( ) ;
      if ( RcdFound47 == 0 )
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
      RowToVars47( bcTipoLiquidacion, 0) ;
      scanKeyStart1E47( ) ;
      if ( RcdFound47 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001E28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(26) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z32TLiqCod = A32TLiqCod ;
      }
      zm1E47( -7) ;
      onLoadActions1E47( ) ;
      addRow1E47( ) ;
      bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Modo_frec().clearCollection();
      if ( RcdFound47 == 1 )
      {
         scanKeyStart1E300( ) ;
         nGXsfl_300_idx = 1 ;
         while ( RcdFound300 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z32TLiqCod = A32TLiqCod ;
            Z2408TLiqModTra = A2408TLiqModTra ;
            Z2412TLiqFrecPag = A2412TLiqFrecPag ;
            zm1E300( -9) ;
            onLoadActions1E300( ) ;
            nRcdExists_300 = (short)(1) ;
            nIsMod_300 = (short)(0) ;
            addRow1E300( ) ;
            nGXsfl_300_idx = (int)(nGXsfl_300_idx+1) ;
            scanKeyNext1E300( ) ;
         }
         scanKeyEnd1E300( ) ;
      }
      scanKeyEnd1E47( ) ;
      if ( RcdFound47 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1E47( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1E47( ) ;
      }
      else
      {
         if ( RcdFound47 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A32TLiqCod = Z32TLiqCod ;
               n32TLiqCod = false ;
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
               update1E47( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
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
                     insert1E47( ) ;
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
                     insert1E47( ) ;
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
      RowToVars47( bcTipoLiquidacion, 1) ;
      saveImpl( ) ;
      VarsToRow47( bcTipoLiquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars47( bcTipoLiquidacion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1E47( ) ;
      afterTrn( ) ;
      VarsToRow47( bcTipoLiquidacion) ;
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
         web.SdtTipoLiquidacion auxBC = new web.SdtTipoLiquidacion( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A32TLiqCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcTipoLiquidacion);
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
      RowToVars47( bcTipoLiquidacion, 1) ;
      updateImpl( ) ;
      VarsToRow47( bcTipoLiquidacion) ;
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
      RowToVars47( bcTipoLiquidacion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1E47( ) ;
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
      VarsToRow47( bcTipoLiquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars47( bcTipoLiquidacion, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1E47( ) ;
      if ( RcdFound47 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A32TLiqCod = Z32TLiqCod ;
            n32TLiqCod = false ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A32TLiqCod, Z32TLiqCod) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "tipoliquidacion_bc");
      VarsToRow47( bcTipoLiquidacion) ;
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
      Gx_mode = bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcTipoLiquidacion.setgxTv_SdtTipoLiquidacion_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtTipoLiquidacion sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcTipoLiquidacion )
      {
         bcTipoLiquidacion = sdt ;
         if ( GXutil.strcmp(bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Mode(), "") == 0 )
         {
            bcTipoLiquidacion.setgxTv_SdtTipoLiquidacion_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow47( bcTipoLiquidacion) ;
         }
         else
         {
            RowToVars47( bcTipoLiquidacion, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcTipoLiquidacion.getgxTv_SdtTipoLiquidacion_Mode(), "") == 0 )
         {
            bcTipoLiquidacion.setgxTv_SdtTipoLiquidacion_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars47( bcTipoLiquidacion, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtTipoLiquidacion getTipoLiquidacion_BC( )
   {
      return bcTipoLiquidacion ;
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
      Z32TLiqCod = "" ;
      A32TLiqCod = "" ;
      sMode47 = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV20Pgmname = "" ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      Z340TliqDesc = "" ;
      A340TliqDesc = "" ;
      Z2091TLiqCodFor = "" ;
      A2091TLiqCodFor = "" ;
      GXv_int5 = new int[1] ;
      BC001E7_A32TLiqCod = new String[] {""} ;
      BC001E7_n32TLiqCod = new boolean[] {false} ;
      BC001E7_A340TliqDesc = new String[] {""} ;
      BC001E7_A341TLiqHabilitada = new boolean[] {false} ;
      BC001E7_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      BC001E7_A1211TliqSAC = new boolean[] {false} ;
      BC001E7_A1817TLiqOrd = new short[1] ;
      BC001E7_A2091TLiqCodFor = new String[] {""} ;
      BC001E7_A3CliCod = new int[1] ;
      BC001E8_A3CliCod = new int[1] ;
      BC001E9_A3CliCod = new int[1] ;
      BC001E9_A32TLiqCod = new String[] {""} ;
      BC001E9_n32TLiqCod = new boolean[] {false} ;
      BC001E10_A32TLiqCod = new String[] {""} ;
      BC001E10_n32TLiqCod = new boolean[] {false} ;
      BC001E10_A340TliqDesc = new String[] {""} ;
      BC001E10_A341TLiqHabilitada = new boolean[] {false} ;
      BC001E10_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      BC001E10_A1211TliqSAC = new boolean[] {false} ;
      BC001E10_A1817TLiqOrd = new short[1] ;
      BC001E10_A2091TLiqCodFor = new String[] {""} ;
      BC001E10_A3CliCod = new int[1] ;
      BC001E11_A32TLiqCod = new String[] {""} ;
      BC001E11_n32TLiqCod = new boolean[] {false} ;
      BC001E11_A340TliqDesc = new String[] {""} ;
      BC001E11_A341TLiqHabilitada = new boolean[] {false} ;
      BC001E11_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      BC001E11_A1211TliqSAC = new boolean[] {false} ;
      BC001E11_A1817TLiqOrd = new short[1] ;
      BC001E11_A2091TLiqCodFor = new String[] {""} ;
      BC001E11_A3CliCod = new int[1] ;
      BC001E15_A3CliCod = new int[1] ;
      BC001E15_A1EmpCod = new short[1] ;
      BC001E15_A6LegNumero = new int[1] ;
      BC001E15_A1829PreliqTLiqCod = new String[] {""} ;
      BC001E15_A1830PreliqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      BC001E16_A3CliCod = new int[1] ;
      BC001E16_A1EmpCod = new short[1] ;
      BC001E16_A31LiqNro = new int[1] ;
      BC001E17_A3CliCod = new int[1] ;
      BC001E17_A26ConCodigo = new String[] {""} ;
      BC001E17_A32TLiqCod = new String[] {""} ;
      BC001E17_n32TLiqCod = new boolean[] {false} ;
      BC001E18_A32TLiqCod = new String[] {""} ;
      BC001E18_n32TLiqCod = new boolean[] {false} ;
      BC001E18_A340TliqDesc = new String[] {""} ;
      BC001E18_A341TLiqHabilitada = new boolean[] {false} ;
      BC001E18_A1076TLiqAcuDiasTrab = new boolean[] {false} ;
      BC001E18_A1211TliqSAC = new boolean[] {false} ;
      BC001E18_A1817TLiqOrd = new short[1] ;
      BC001E18_A2091TLiqCodFor = new String[] {""} ;
      BC001E18_A3CliCod = new int[1] ;
      Z2413TLiqDescAuxFrec = "" ;
      A2413TLiqDescAuxFrec = "" ;
      Z2408TLiqModTra = "" ;
      A2408TLiqModTra = "" ;
      BC001E19_A3CliCod = new int[1] ;
      BC001E19_A32TLiqCod = new String[] {""} ;
      BC001E19_n32TLiqCod = new boolean[] {false} ;
      BC001E19_A2408TLiqModTra = new String[] {""} ;
      BC001E19_A2412TLiqFrecPag = new byte[1] ;
      BC001E19_A2413TLiqDescAuxFrec = new String[] {""} ;
      BC001E20_A3CliCod = new int[1] ;
      BC001E20_A32TLiqCod = new String[] {""} ;
      BC001E20_n32TLiqCod = new boolean[] {false} ;
      BC001E20_A2408TLiqModTra = new String[] {""} ;
      BC001E20_A2412TLiqFrecPag = new byte[1] ;
      BC001E21_A3CliCod = new int[1] ;
      BC001E21_A32TLiqCod = new String[] {""} ;
      BC001E21_n32TLiqCod = new boolean[] {false} ;
      BC001E21_A2408TLiqModTra = new String[] {""} ;
      BC001E21_A2412TLiqFrecPag = new byte[1] ;
      BC001E21_A2413TLiqDescAuxFrec = new String[] {""} ;
      sMode300 = "" ;
      BC001E22_A3CliCod = new int[1] ;
      BC001E22_A32TLiqCod = new String[] {""} ;
      BC001E22_n32TLiqCod = new boolean[] {false} ;
      BC001E22_A2408TLiqModTra = new String[] {""} ;
      BC001E22_A2412TLiqFrecPag = new byte[1] ;
      BC001E22_A2413TLiqDescAuxFrec = new String[] {""} ;
      BC001E26_A3CliCod = new int[1] ;
      BC001E26_A32TLiqCod = new String[] {""} ;
      BC001E26_n32TLiqCod = new boolean[] {false} ;
      BC001E26_A2408TLiqModTra = new String[] {""} ;
      BC001E26_A2412TLiqFrecPag = new byte[1] ;
      BC001E26_A2413TLiqDescAuxFrec = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001E27_A3CliCod = new int[1] ;
      BC001E28_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.tipoliquidacion_bc__default(),
         new Object[] {
             new Object[] {
            BC001E2_A3CliCod, BC001E2_A32TLiqCod, BC001E2_A2408TLiqModTra, BC001E2_A2412TLiqFrecPag, BC001E2_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            BC001E3_A3CliCod, BC001E3_A32TLiqCod, BC001E3_A2408TLiqModTra, BC001E3_A2412TLiqFrecPag, BC001E3_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            BC001E4_A32TLiqCod, BC001E4_A340TliqDesc, BC001E4_A341TLiqHabilitada, BC001E4_A1076TLiqAcuDiasTrab, BC001E4_A1211TliqSAC, BC001E4_A1817TLiqOrd, BC001E4_A2091TLiqCodFor, BC001E4_A3CliCod
            }
            , new Object[] {
            BC001E5_A32TLiqCod, BC001E5_A340TliqDesc, BC001E5_A341TLiqHabilitada, BC001E5_A1076TLiqAcuDiasTrab, BC001E5_A1211TliqSAC, BC001E5_A1817TLiqOrd, BC001E5_A2091TLiqCodFor, BC001E5_A3CliCod
            }
            , new Object[] {
            BC001E6_A3CliCod
            }
            , new Object[] {
            BC001E7_A32TLiqCod, BC001E7_A340TliqDesc, BC001E7_A341TLiqHabilitada, BC001E7_A1076TLiqAcuDiasTrab, BC001E7_A1211TliqSAC, BC001E7_A1817TLiqOrd, BC001E7_A2091TLiqCodFor, BC001E7_A3CliCod
            }
            , new Object[] {
            BC001E8_A3CliCod
            }
            , new Object[] {
            BC001E9_A3CliCod, BC001E9_A32TLiqCod
            }
            , new Object[] {
            BC001E10_A32TLiqCod, BC001E10_A340TliqDesc, BC001E10_A341TLiqHabilitada, BC001E10_A1076TLiqAcuDiasTrab, BC001E10_A1211TliqSAC, BC001E10_A1817TLiqOrd, BC001E10_A2091TLiqCodFor, BC001E10_A3CliCod
            }
            , new Object[] {
            BC001E11_A32TLiqCod, BC001E11_A340TliqDesc, BC001E11_A341TLiqHabilitada, BC001E11_A1076TLiqAcuDiasTrab, BC001E11_A1211TliqSAC, BC001E11_A1817TLiqOrd, BC001E11_A2091TLiqCodFor, BC001E11_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001E15_A3CliCod, BC001E15_A1EmpCod, BC001E15_A6LegNumero, BC001E15_A1829PreliqTLiqCod, BC001E15_A1830PreliqPeriodo
            }
            , new Object[] {
            BC001E16_A3CliCod, BC001E16_A1EmpCod, BC001E16_A31LiqNro
            }
            , new Object[] {
            BC001E17_A3CliCod, BC001E17_A26ConCodigo, BC001E17_A32TLiqCod
            }
            , new Object[] {
            BC001E18_A32TLiqCod, BC001E18_A340TliqDesc, BC001E18_A341TLiqHabilitada, BC001E18_A1076TLiqAcuDiasTrab, BC001E18_A1211TliqSAC, BC001E18_A1817TLiqOrd, BC001E18_A2091TLiqCodFor, BC001E18_A3CliCod
            }
            , new Object[] {
            BC001E19_A3CliCod, BC001E19_A32TLiqCod, BC001E19_A2408TLiqModTra, BC001E19_A2412TLiqFrecPag, BC001E19_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            BC001E20_A3CliCod, BC001E20_A32TLiqCod, BC001E20_A2408TLiqModTra, BC001E20_A2412TLiqFrecPag
            }
            , new Object[] {
            BC001E21_A3CliCod, BC001E21_A32TLiqCod, BC001E21_A2408TLiqModTra, BC001E21_A2412TLiqFrecPag, BC001E21_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            BC001E22_A3CliCod, BC001E22_A32TLiqCod, BC001E22_A2408TLiqModTra, BC001E22_A2412TLiqFrecPag, BC001E22_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001E26_A3CliCod, BC001E26_A32TLiqCod, BC001E26_A2408TLiqModTra, BC001E26_A2412TLiqFrecPag, BC001E26_A2413TLiqDescAuxFrec
            }
            , new Object[] {
            BC001E27_A3CliCod
            }
            , new Object[] {
            BC001E28_A3CliCod
            }
         }
      );
      AV20Pgmname = "TipoLiquidacion_BC" ;
      Z341TLiqHabilitada = true ;
      A341TLiqHabilitada = true ;
      i341TLiqHabilitada = true ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e121E2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte Gxremove300 ;
   private byte Z2412TLiqFrecPag ;
   private byte A2412TLiqFrecPag ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nIsMod_300 ;
   private short RcdFound300 ;
   private short Z1817TLiqOrd ;
   private short A1817TLiqOrd ;
   private short RcdFound47 ;
   private short nIsDirty_47 ;
   private short nRcdExists_300 ;
   private short nIsDirty_300 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int nGXsfl_300_idx=1 ;
   private int GX_JID ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z32TLiqCod ;
   private String A32TLiqCod ;
   private String sMode47 ;
   private String AV20Pgmname ;
   private String Z2091TLiqCodFor ;
   private String A2091TLiqCodFor ;
   private String Z2408TLiqModTra ;
   private String A2408TLiqModTra ;
   private String sMode300 ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z341TLiqHabilitada ;
   private boolean A341TLiqHabilitada ;
   private boolean Z1076TLiqAcuDiasTrab ;
   private boolean A1076TLiqAcuDiasTrab ;
   private boolean Z1211TliqSAC ;
   private boolean A1211TliqSAC ;
   private boolean n32TLiqCod ;
   private boolean Gx_longc ;
   private boolean i341TLiqHabilitada ;
   private boolean mustCommit ;
   private String Z340TliqDesc ;
   private String A340TliqDesc ;
   private String Z2413TLiqDescAuxFrec ;
   private String A2413TLiqDescAuxFrec ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private web.SdtTipoLiquidacion bcTipoLiquidacion ;
   private IDataStoreProvider pr_default ;
   private String[] BC001E7_A32TLiqCod ;
   private boolean[] BC001E7_n32TLiqCod ;
   private String[] BC001E7_A340TliqDesc ;
   private boolean[] BC001E7_A341TLiqHabilitada ;
   private boolean[] BC001E7_A1076TLiqAcuDiasTrab ;
   private boolean[] BC001E7_A1211TliqSAC ;
   private short[] BC001E7_A1817TLiqOrd ;
   private String[] BC001E7_A2091TLiqCodFor ;
   private int[] BC001E7_A3CliCod ;
   private int[] BC001E8_A3CliCod ;
   private int[] BC001E9_A3CliCod ;
   private String[] BC001E9_A32TLiqCod ;
   private boolean[] BC001E9_n32TLiqCod ;
   private String[] BC001E10_A32TLiqCod ;
   private boolean[] BC001E10_n32TLiqCod ;
   private String[] BC001E10_A340TliqDesc ;
   private boolean[] BC001E10_A341TLiqHabilitada ;
   private boolean[] BC001E10_A1076TLiqAcuDiasTrab ;
   private boolean[] BC001E10_A1211TliqSAC ;
   private short[] BC001E10_A1817TLiqOrd ;
   private String[] BC001E10_A2091TLiqCodFor ;
   private int[] BC001E10_A3CliCod ;
   private String[] BC001E11_A32TLiqCod ;
   private boolean[] BC001E11_n32TLiqCod ;
   private String[] BC001E11_A340TliqDesc ;
   private boolean[] BC001E11_A341TLiqHabilitada ;
   private boolean[] BC001E11_A1076TLiqAcuDiasTrab ;
   private boolean[] BC001E11_A1211TliqSAC ;
   private short[] BC001E11_A1817TLiqOrd ;
   private String[] BC001E11_A2091TLiqCodFor ;
   private int[] BC001E11_A3CliCod ;
   private int[] BC001E15_A3CliCod ;
   private short[] BC001E15_A1EmpCod ;
   private int[] BC001E15_A6LegNumero ;
   private String[] BC001E15_A1829PreliqTLiqCod ;
   private java.util.Date[] BC001E15_A1830PreliqPeriodo ;
   private int[] BC001E16_A3CliCod ;
   private short[] BC001E16_A1EmpCod ;
   private int[] BC001E16_A31LiqNro ;
   private int[] BC001E17_A3CliCod ;
   private String[] BC001E17_A26ConCodigo ;
   private String[] BC001E17_A32TLiqCod ;
   private boolean[] BC001E17_n32TLiqCod ;
   private String[] BC001E18_A32TLiqCod ;
   private boolean[] BC001E18_n32TLiqCod ;
   private String[] BC001E18_A340TliqDesc ;
   private boolean[] BC001E18_A341TLiqHabilitada ;
   private boolean[] BC001E18_A1076TLiqAcuDiasTrab ;
   private boolean[] BC001E18_A1211TliqSAC ;
   private short[] BC001E18_A1817TLiqOrd ;
   private String[] BC001E18_A2091TLiqCodFor ;
   private int[] BC001E18_A3CliCod ;
   private int[] BC001E19_A3CliCod ;
   private String[] BC001E19_A32TLiqCod ;
   private boolean[] BC001E19_n32TLiqCod ;
   private String[] BC001E19_A2408TLiqModTra ;
   private byte[] BC001E19_A2412TLiqFrecPag ;
   private String[] BC001E19_A2413TLiqDescAuxFrec ;
   private int[] BC001E20_A3CliCod ;
   private String[] BC001E20_A32TLiqCod ;
   private boolean[] BC001E20_n32TLiqCod ;
   private String[] BC001E20_A2408TLiqModTra ;
   private byte[] BC001E20_A2412TLiqFrecPag ;
   private int[] BC001E21_A3CliCod ;
   private String[] BC001E21_A32TLiqCod ;
   private boolean[] BC001E21_n32TLiqCod ;
   private String[] BC001E21_A2408TLiqModTra ;
   private byte[] BC001E21_A2412TLiqFrecPag ;
   private String[] BC001E21_A2413TLiqDescAuxFrec ;
   private int[] BC001E22_A3CliCod ;
   private String[] BC001E22_A32TLiqCod ;
   private boolean[] BC001E22_n32TLiqCod ;
   private String[] BC001E22_A2408TLiqModTra ;
   private byte[] BC001E22_A2412TLiqFrecPag ;
   private String[] BC001E22_A2413TLiqDescAuxFrec ;
   private int[] BC001E26_A3CliCod ;
   private String[] BC001E26_A32TLiqCod ;
   private boolean[] BC001E26_n32TLiqCod ;
   private String[] BC001E26_A2408TLiqModTra ;
   private byte[] BC001E26_A2412TLiqFrecPag ;
   private String[] BC001E26_A2413TLiqDescAuxFrec ;
   private int[] BC001E27_A3CliCod ;
   private int[] BC001E28_A3CliCod ;
   private int[] BC001E2_A3CliCod ;
   private String[] BC001E2_A32TLiqCod ;
   private String[] BC001E2_A2408TLiqModTra ;
   private byte[] BC001E2_A2412TLiqFrecPag ;
   private String[] BC001E2_A2413TLiqDescAuxFrec ;
   private int[] BC001E3_A3CliCod ;
   private String[] BC001E3_A32TLiqCod ;
   private String[] BC001E3_A2408TLiqModTra ;
   private byte[] BC001E3_A2412TLiqFrecPag ;
   private String[] BC001E3_A2413TLiqDescAuxFrec ;
   private String[] BC001E4_A32TLiqCod ;
   private String[] BC001E4_A340TliqDesc ;
   private boolean[] BC001E4_A341TLiqHabilitada ;
   private boolean[] BC001E4_A1076TLiqAcuDiasTrab ;
   private boolean[] BC001E4_A1211TliqSAC ;
   private short[] BC001E4_A1817TLiqOrd ;
   private String[] BC001E4_A2091TLiqCodFor ;
   private int[] BC001E4_A3CliCod ;
   private String[] BC001E5_A32TLiqCod ;
   private String[] BC001E5_A340TliqDesc ;
   private boolean[] BC001E5_A341TLiqHabilitada ;
   private boolean[] BC001E5_A1076TLiqAcuDiasTrab ;
   private boolean[] BC001E5_A1211TliqSAC ;
   private short[] BC001E5_A1817TLiqOrd ;
   private String[] BC001E5_A2091TLiqCodFor ;
   private int[] BC001E5_A3CliCod ;
   private int[] BC001E6_A3CliCod ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class tipoliquidacion_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC001E2", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ?  FOR UPDATE OF TipoLiquidacionmodo_frec",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E3", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E4", "SELECT TLiqCod, TliqDesc, TLiqHabilitada, TLiqAcuDiasTrab, TliqSAC, TLiqOrd, TLiqCodFor, CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ?  FOR UPDATE OF TipoLiquidacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E5", "SELECT TLiqCod, TliqDesc, TLiqHabilitada, TLiqAcuDiasTrab, TliqSAC, TLiqOrd, TLiqCodFor, CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E7", "SELECT TM1.TLiqCod, TM1.TliqDesc, TM1.TLiqHabilitada, TM1.TLiqAcuDiasTrab, TM1.TliqSAC, TM1.TLiqOrd, TM1.TLiqCodFor, TM1.CliCod FROM TipoLiquidacion TM1 WHERE TM1.CliCod = ? and TM1.TLiqCod = ( ?) ORDER BY TM1.CliCod, TM1.TLiqCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E8", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E9", "SELECT CliCod, TLiqCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E10", "SELECT TLiqCod, TliqDesc, TLiqHabilitada, TLiqAcuDiasTrab, TliqSAC, TLiqOrd, TLiqCodFor, CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E11", "SELECT TLiqCod, TliqDesc, TLiqHabilitada, TLiqAcuDiasTrab, TliqSAC, TLiqOrd, TLiqCodFor, CliCod FROM TipoLiquidacion WHERE CliCod = ? AND TLiqCod = ?  FOR UPDATE OF TipoLiquidacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001E12", "SAVEPOINT gxupdate;INSERT INTO TipoLiquidacion(TLiqCod, TliqDesc, TLiqHabilitada, TLiqAcuDiasTrab, TliqSAC, TLiqOrd, TLiqCodFor, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001E13", "SAVEPOINT gxupdate;UPDATE TipoLiquidacion SET TliqDesc=?, TLiqHabilitada=?, TLiqAcuDiasTrab=?, TliqSAC=?, TLiqOrd=?, TLiqCodFor=?  WHERE CliCod = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001E14", "SAVEPOINT gxupdate;DELETE FROM TipoLiquidacion  WHERE CliCod = ? AND TLiqCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001E15", "SELECT CliCod, EmpCod, LegNumero, PreliqTLiqCod, PreliqPeriodo FROM LegPreliqCab WHERE CliCod = ? AND PreliqTLiqCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001E16", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE CliCod = ? AND TLiqCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001E17", "SELECT CliCod, ConCodigo, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? AND TLiqCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001E18", "SELECT TM1.TLiqCod, TM1.TliqDesc, TM1.TLiqHabilitada, TM1.TLiqAcuDiasTrab, TM1.TliqSAC, TM1.TLiqOrd, TM1.TLiqCodFor, TM1.CliCod FROM TipoLiquidacion TM1 WHERE TM1.CliCod = ? and TM1.TLiqCod = ( ?) ORDER BY TM1.CliCod, TM1.TLiqCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E19", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? and TLiqCod = ( ?) and TLiqModTra = ( ?) and TLiqFrecPag = ? ORDER BY CliCod, TLiqCod, TLiqModTra, TLiqFrecPag ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E20", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag FROM TipoLiquidacionmodo_frec WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E21", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E22", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ?  FOR UPDATE OF TipoLiquidacionmodo_frec",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001E23", "SAVEPOINT gxupdate;INSERT INTO TipoLiquidacionmodo_frec(CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001E24", "SAVEPOINT gxupdate;UPDATE TipoLiquidacionmodo_frec SET TLiqDescAuxFrec=?  WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001E25", "SAVEPOINT gxupdate;DELETE FROM TipoLiquidacionmodo_frec  WHERE CliCod = ? AND TLiqCod = ? AND TLiqModTra = ? AND TLiqFrecPag = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001E26", "SELECT CliCod, TLiqCod, TLiqModTra, TLiqFrecPag, TLiqDescAuxFrec FROM TipoLiquidacionmodo_frec WHERE CliCod = ? and TLiqCod = ( ?) ORDER BY CliCod, TLiqCod, TLiqModTra, TLiqFrecPag ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E27", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001E28", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 26 :
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
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 2 :
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
            case 3 :
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
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
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
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
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
            case 8 :
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setVarchar(2, (String)parms[2], 30, false);
               stmt.setBoolean(3, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[5]).booleanValue());
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setString(7, (String)parms[7], 20);
               stmt.setInt(8, ((Number) parms[8]).intValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[8], 20);
               }
               return;
            case 12 :
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
            case 13 :
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
            case 14 :
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
            case 15 :
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
            case 16 :
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
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
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
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               stmt.setVarchar(5, (String)parms[5], 30, false);
               return;
            case 22 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               stmt.setString(4, (String)parms[4], 1);
               stmt.setByte(5, ((Number) parms[5]).byteValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setByte(4, ((Number) parms[4]).byteValue());
               return;
            case 24 :
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
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

