package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class motivoegreso_bc extends GXWebPanel implements IGxSilentTrn
{
   public motivoegreso_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public motivoegreso_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegreso_bc.class ));
   }

   public motivoegreso_bc( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1336( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1336( ) ;
      standaloneModal( ) ;
      addRow1336( ) ;
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
         e11132 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z11MegCodigo = A11MegCodigo ;
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

   public void confirm_130( )
   {
      beforeValidate1336( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1336( ) ;
         }
         else
         {
            checkExtendedTable1336( ) ;
            if ( AnyError == 0 )
            {
               zm1336( 6) ;
            }
            closeExtendedTableCursors1336( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode36 = Gx_mode ;
         confirm_13220( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode36 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode36 ;
      }
   }

   public void confirm_13220( )
   {
      nGXsfl_220_idx = 0 ;
      while ( nGXsfl_220_idx < bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().size() )
      {
         readRow13220( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound220 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_220 != 0 ) )
         {
            getKey13220( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound220 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate13220( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable13220( ) ;
                     if ( AnyError == 0 )
                     {
                        zm13220( 8) ;
                     }
                     closeExtendedTableCursors13220( ) ;
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
               if ( RcdFound220 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey13220( ) ;
                     load13220( ) ;
                     beforeValidate13220( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls13220( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_220 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate13220( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable13220( ) ;
                           if ( AnyError == 0 )
                           {
                              zm13220( 8) ;
                           }
                           closeExtendedTableCursors13220( ) ;
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
            VarsToRow220( ((web.SdtMotivoEgreso_RevistaAfip)bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().elementAt(-1+nGXsfl_220_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e12132( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV10IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgreso_Insert", GXv_boolean3) ;
         motivoegreso_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgreso_Update", GXv_boolean3) ;
         motivoegreso_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgreso_Delete", GXv_boolean3) ;
         motivoegreso_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
   }

   public void e11132( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.motivoegresograbarrelref(remoteHandle, context).execute( A3CliCod) ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm1336( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z300MegDescrip = A300MegDescrip ;
         Z301MegHabilitado = A301MegHabilitado ;
         Z302MegRes551 = A302MegRes551 ;
         Z1990MegRelSec = A1990MegRelSec ;
         Z1991MegRelSecCli = A1991MegRelSecCli ;
         Z1992MegPadre = A1992MegPadre ;
         Z2017MegRelRef = A2017MegRelRef ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -5 )
      {
         Z11MegCodigo = A11MegCodigo ;
         Z300MegDescrip = A300MegDescrip ;
         Z301MegHabilitado = A301MegHabilitado ;
         Z302MegRes551 = A302MegRes551 ;
         Z1990MegRelSec = A1990MegRelSec ;
         Z1991MegRelSecCli = A1991MegRelSecCli ;
         Z1992MegPadre = A1992MegPadre ;
         Z2017MegRelRef = A2017MegRelRef ;
         Z2029MegOld = A2029MegOld ;
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
         motivoegreso_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (false==A301MegHabilitado) && ( Gx_BScreen == 0 ) )
      {
         A301MegHabilitado = true ;
      }
   }

   public void load1336( )
   {
      /* Using cursor BC00138 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A300MegDescrip = BC00138_A300MegDescrip[0] ;
         A301MegHabilitado = BC00138_A301MegHabilitado[0] ;
         A302MegRes551 = BC00138_A302MegRes551[0] ;
         n302MegRes551 = BC00138_n302MegRes551[0] ;
         A1990MegRelSec = BC00138_A1990MegRelSec[0] ;
         A1991MegRelSecCli = BC00138_A1991MegRelSecCli[0] ;
         A1992MegPadre = BC00138_A1992MegPadre[0] ;
         A2017MegRelRef = BC00138_A2017MegRelRef[0] ;
         A2029MegOld = BC00138_A2029MegOld[0] ;
         zm1336( -5) ;
      }
      pr_default.close(6);
      onLoadActions1336( ) ;
   }

   public void onLoadActions1336( )
   {
      AV16Pgmname = "MotivoEgreso_BC" ;
   }

   public void checkExtendedTable1336( )
   {
      nIsDirty_36 = (short)(0) ;
      standaloneModal( ) ;
      AV16Pgmname = "MotivoEgreso_BC" ;
      /* Using cursor BC00139 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(7);
      if ( (GXutil.strcmp("", A11MegCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Motivo", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A300MegDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripción", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1336( )
   {
      pr_default.close(7);
   }

   public void enableDisable( )
   {
   }

   public void getKey1336( )
   {
      /* Using cursor BC001310 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound36 = (short)(1) ;
      }
      else
      {
         RcdFound36 = (short)(0) ;
      }
      pr_default.close(8);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001311 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         zm1336( 5) ;
         RcdFound36 = (short)(1) ;
         A11MegCodigo = BC001311_A11MegCodigo[0] ;
         A300MegDescrip = BC001311_A300MegDescrip[0] ;
         A301MegHabilitado = BC001311_A301MegHabilitado[0] ;
         A302MegRes551 = BC001311_A302MegRes551[0] ;
         n302MegRes551 = BC001311_n302MegRes551[0] ;
         A1990MegRelSec = BC001311_A1990MegRelSec[0] ;
         A1991MegRelSecCli = BC001311_A1991MegRelSecCli[0] ;
         A1992MegPadre = BC001311_A1992MegPadre[0] ;
         A2017MegRelRef = BC001311_A2017MegRelRef[0] ;
         A2029MegOld = BC001311_A2029MegOld[0] ;
         A3CliCod = BC001311_A3CliCod[0] ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         load1336( ) ;
         if ( AnyError == 1 )
         {
            RcdFound36 = (short)(0) ;
            initializeNonKey1336( ) ;
         }
         Gx_mode = sMode36 ;
      }
      else
      {
         RcdFound36 = (short)(0) ;
         initializeNonKey1336( ) ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode36 ;
      }
      pr_default.close(9);
   }

   public void getEqualNoModal( )
   {
      getKey1336( ) ;
      if ( RcdFound36 == 0 )
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
      confirm_130( ) ;
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

   public void checkOptimisticConcurrency1336( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001312 */
         pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(10) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgreso"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(10) == 101) || ( GXutil.strcmp(Z300MegDescrip, BC001312_A300MegDescrip[0]) != 0 ) || ( Z301MegHabilitado != BC001312_A301MegHabilitado[0] ) || ( GXutil.strcmp(Z302MegRes551, BC001312_A302MegRes551[0]) != 0 ) || ( Z1990MegRelSec != BC001312_A1990MegRelSec[0] ) || ( Z1991MegRelSecCli != BC001312_A1991MegRelSecCli[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1992MegPadre, BC001312_A1992MegPadre[0]) != 0 ) || ( GXutil.strcmp(Z2017MegRelRef, BC001312_A2017MegRelRef[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MotivoEgreso"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1336( )
   {
      beforeValidate1336( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1336( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1336( 0) ;
         checkOptimisticConcurrency1336( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1336( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1336( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001313 */
                  pr_default.execute(11, new Object[] {A11MegCodigo, A300MegDescrip, Boolean.valueOf(A301MegHabilitado), Boolean.valueOf(n302MegRes551), A302MegRes551, Integer.valueOf(A1990MegRelSec), Integer.valueOf(A1991MegRelSecCli), A1992MegPadre, A2017MegRelRef, A2029MegOld, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgreso");
                  if ( (pr_default.getStatus(11) == 1) )
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
                        processLevel1336( ) ;
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
            load1336( ) ;
         }
         endLevel1336( ) ;
      }
      closeExtendedTableCursors1336( ) ;
   }

   public void update1336( )
   {
      beforeValidate1336( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1336( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1336( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1336( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1336( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001314 */
                  pr_default.execute(12, new Object[] {A300MegDescrip, Boolean.valueOf(A301MegHabilitado), Boolean.valueOf(n302MegRes551), A302MegRes551, Integer.valueOf(A1990MegRelSec), Integer.valueOf(A1991MegRelSecCli), A1992MegPadre, A2017MegRelRef, A2029MegOld, Integer.valueOf(A3CliCod), A11MegCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgreso");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgreso"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1336( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1336( ) ;
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
         endLevel1336( ) ;
      }
      closeExtendedTableCursors1336( ) ;
   }

   public void deferredUpdate1336( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1336( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1336( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1336( ) ;
         afterConfirm1336( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1336( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart13220( ) ;
               while ( RcdFound220 != 0 )
               {
                  getByPrimaryKey13220( ) ;
                  delete13220( ) ;
                  scanKeyNext13220( ) ;
               }
               scanKeyEnd13220( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001315 */
                  pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgreso");
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
      sMode36 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1336( ) ;
      Gx_mode = sMode36 ;
   }

   public void onDeleteControls1336( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "MotivoEgreso_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC001316 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_permanencia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor BC001317 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor BC001318 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Motivo Egreso Tipos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor BC001319 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
   }

   public void processNestedLevel13220( )
   {
      nGXsfl_220_idx = 0 ;
      while ( nGXsfl_220_idx < bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().size() )
      {
         readRow13220( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound220 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_220 != 0 ) )
         {
            standaloneNotModal13220( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert13220( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete13220( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update13220( ) ;
               }
            }
         }
         KeyVarsToRow220( ((web.SdtMotivoEgreso_RevistaAfip)bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().elementAt(-1+nGXsfl_220_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_220_idx = 0 ;
         while ( nGXsfl_220_idx < bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().size() )
         {
            readRow13220( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound220 == 0 )
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
               bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().removeElement(nGXsfl_220_idx);
               nGXsfl_220_idx = (int)(nGXsfl_220_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey13220( ) ;
               VarsToRow220( ((web.SdtMotivoEgreso_RevistaAfip)bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().elementAt(-1+nGXsfl_220_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll13220( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_220 = (short)(0) ;
      nIsMod_220 = (short)(0) ;
      Gxremove220 = (byte)(0) ;
   }

   public void processLevel1336( )
   {
      /* Save parent mode. */
      sMode36 = Gx_mode ;
      processNestedLevel13220( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode36 ;
      /* ' Update level parameters */
   }

   public void endLevel1336( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(10);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1336( ) ;
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

   public void scanKeyStart1336( )
   {
      /* Scan By routine */
      /* Using cursor BC001320 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      RcdFound36 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A11MegCodigo = BC001320_A11MegCodigo[0] ;
         A300MegDescrip = BC001320_A300MegDescrip[0] ;
         A301MegHabilitado = BC001320_A301MegHabilitado[0] ;
         A302MegRes551 = BC001320_A302MegRes551[0] ;
         n302MegRes551 = BC001320_n302MegRes551[0] ;
         A1990MegRelSec = BC001320_A1990MegRelSec[0] ;
         A1991MegRelSecCli = BC001320_A1991MegRelSecCli[0] ;
         A1992MegPadre = BC001320_A1992MegPadre[0] ;
         A2017MegRelRef = BC001320_A2017MegRelRef[0] ;
         A2029MegOld = BC001320_A2029MegOld[0] ;
         A3CliCod = BC001320_A3CliCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1336( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound36 = (short)(0) ;
      scanKeyLoad1336( ) ;
   }

   public void scanKeyLoad1336( )
   {
      sMode36 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A11MegCodigo = BC001320_A11MegCodigo[0] ;
         A300MegDescrip = BC001320_A300MegDescrip[0] ;
         A301MegHabilitado = BC001320_A301MegHabilitado[0] ;
         A302MegRes551 = BC001320_A302MegRes551[0] ;
         n302MegRes551 = BC001320_n302MegRes551[0] ;
         A1990MegRelSec = BC001320_A1990MegRelSec[0] ;
         A1991MegRelSecCli = BC001320_A1991MegRelSecCli[0] ;
         A1992MegPadre = BC001320_A1992MegPadre[0] ;
         A2017MegRelRef = BC001320_A2017MegRelRef[0] ;
         A2029MegOld = BC001320_A2029MegOld[0] ;
         A3CliCod = BC001320_A3CliCod[0] ;
      }
      Gx_mode = sMode36 ;
   }

   public void scanKeyEnd1336( )
   {
      pr_default.close(18);
   }

   public void afterConfirm1336( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1336( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1336( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1336( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1336( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1336( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1336( )
   {
   }

   public void zm13220( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z1606MegSitRevDef = A1606MegSitRevDef ;
         Z1993MegSitRelSec = A1993MegSitRelSec ;
         Z1994MegSitRelSecCli = A1994MegSitRelSecCli ;
         Z1995MegSitPadre = A1995MegSitPadre ;
         Z2018MegSitRelRef = A2018MegSitRelRef ;
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z1604MegSitRevDescrip = A1604MegSitRevDescrip ;
      }
      if ( GX_JID == -7 )
      {
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
         Z1606MegSitRevDef = A1606MegSitRevDef ;
         Z1993MegSitRelSec = A1993MegSitRelSec ;
         Z1994MegSitRelSecCli = A1994MegSitRelSecCli ;
         Z1995MegSitPadre = A1995MegSitPadre ;
         Z2018MegSitRelRef = A2018MegSitRelRef ;
         Z2030MegSitOld = A2030MegSitOld ;
         Z1601MegSitRevista = A1601MegSitRevista ;
         Z1604MegSitRevDescrip = A1604MegSitRevDescrip ;
      }
   }

   public void standaloneNotModal13220( )
   {
   }

   public void standaloneModal13220( )
   {
   }

   public void load13220( )
   {
      /* Using cursor BC001321 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A1604MegSitRevDescrip = BC001321_A1604MegSitRevDescrip[0] ;
         A1606MegSitRevDef = BC001321_A1606MegSitRevDef[0] ;
         A1993MegSitRelSec = BC001321_A1993MegSitRelSec[0] ;
         A1994MegSitRelSecCli = BC001321_A1994MegSitRelSecCli[0] ;
         A1995MegSitPadre = BC001321_A1995MegSitPadre[0] ;
         A2018MegSitRelRef = BC001321_A2018MegSitRelRef[0] ;
         A2030MegSitOld = BC001321_A2030MegSitOld[0] ;
         zm13220( -7) ;
      }
      pr_default.close(19);
      onLoadActions13220( ) ;
   }

   public void onLoadActions13220( )
   {
   }

   public void checkExtendedTable13220( )
   {
      nIsDirty_220 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal13220( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC001322 */
      pr_default.execute(20, new Object[] {Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGSITREVISTA");
         AnyError = (short)(1) ;
      }
      A1604MegSitRevDescrip = BC001322_A1604MegSitRevDescrip[0] ;
      pr_default.close(20);
   }

   public void closeExtendedTableCursors13220( )
   {
      pr_default.close(20);
   }

   public void enableDisable13220( )
   {
   }

   public void getKey13220( )
   {
      /* Using cursor BC001323 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound220 = (short)(1) ;
      }
      else
      {
         RcdFound220 = (short)(0) ;
      }
      pr_default.close(21);
   }

   public void getByPrimaryKey13220( )
   {
      /* Using cursor BC001324 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(22) != 101) )
      {
         zm13220( 7) ;
         RcdFound220 = (short)(1) ;
         initializeNonKey13220( ) ;
         A1606MegSitRevDef = BC001324_A1606MegSitRevDef[0] ;
         A1993MegSitRelSec = BC001324_A1993MegSitRelSec[0] ;
         A1994MegSitRelSecCli = BC001324_A1994MegSitRelSecCli[0] ;
         A1995MegSitPadre = BC001324_A1995MegSitPadre[0] ;
         A2018MegSitRelRef = BC001324_A2018MegSitRelRef[0] ;
         A2030MegSitOld = BC001324_A2030MegSitOld[0] ;
         A1601MegSitRevista = BC001324_A1601MegSitRevista[0] ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
         Z1601MegSitRevista = A1601MegSitRevista ;
         sMode220 = Gx_mode ;
         Gx_mode = "DSP" ;
         load13220( ) ;
         Gx_mode = sMode220 ;
      }
      else
      {
         RcdFound220 = (short)(0) ;
         initializeNonKey13220( ) ;
         sMode220 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal13220( ) ;
         Gx_mode = sMode220 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes13220( ) ;
      }
      pr_default.close(22);
   }

   public void checkOptimisticConcurrency13220( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001325 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
         if ( (pr_default.getStatus(23) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(23) == 101) || ( Z1606MegSitRevDef != BC001325_A1606MegSitRevDef[0] ) || ( Z1993MegSitRelSec != BC001325_A1993MegSitRelSec[0] ) || ( Z1994MegSitRelSecCli != BC001325_A1994MegSitRelSecCli[0] ) || ( Z1995MegSitPadre != BC001325_A1995MegSitPadre[0] ) || ( GXutil.strcmp(Z2018MegSitRelRef, BC001325_A2018MegSitRelRef[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert13220( )
   {
      beforeValidate13220( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable13220( ) ;
      }
      if ( AnyError == 0 )
      {
         zm13220( 0) ;
         checkOptimisticConcurrency13220( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm13220( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert13220( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001326 */
                  pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Boolean.valueOf(A1606MegSitRevDef), Integer.valueOf(A1993MegSitRelSec), Integer.valueOf(A1994MegSitRelSecCli), Short.valueOf(A1995MegSitPadre), A2018MegSitRelRef, A2030MegSitOld, Short.valueOf(A1601MegSitRevista)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
                  if ( (pr_default.getStatus(24) == 1) )
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
            load13220( ) ;
         }
         endLevel13220( ) ;
      }
      closeExtendedTableCursors13220( ) ;
   }

   public void update13220( )
   {
      beforeValidate13220( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable13220( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency13220( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm13220( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate13220( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001327 */
                  pr_default.execute(25, new Object[] {Boolean.valueOf(A1606MegSitRevDef), Integer.valueOf(A1993MegSitRelSec), Integer.valueOf(A1994MegSitRelSecCli), Short.valueOf(A1995MegSitPadre), A2018MegSitRelRef, A2030MegSitOld, Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
                  if ( (pr_default.getStatus(25) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate13220( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey13220( ) ;
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
         endLevel13220( ) ;
      }
      closeExtendedTableCursors13220( ) ;
   }

   public void deferredUpdate13220( )
   {
   }

   public void delete13220( )
   {
      Gx_mode = "DLT" ;
      beforeValidate13220( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency13220( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls13220( ) ;
         afterConfirm13220( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete13220( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001328 */
               pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
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
      sMode220 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel13220( ) ;
      Gx_mode = sMode220 ;
   }

   public void onDeleteControls13220( )
   {
      standaloneModal13220( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC001329 */
         pr_default.execute(27, new Object[] {Short.valueOf(A1601MegSitRevista)});
         A1604MegSitRevDescrip = BC001329_A1604MegSitRevDescrip[0] ;
         pr_default.close(27);
      }
   }

   public void endLevel13220( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(23);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart13220( )
   {
      /* Scan By routine */
      /* Using cursor BC001330 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      RcdFound220 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A1604MegSitRevDescrip = BC001330_A1604MegSitRevDescrip[0] ;
         A1606MegSitRevDef = BC001330_A1606MegSitRevDef[0] ;
         A1993MegSitRelSec = BC001330_A1993MegSitRelSec[0] ;
         A1994MegSitRelSecCli = BC001330_A1994MegSitRelSecCli[0] ;
         A1995MegSitPadre = BC001330_A1995MegSitPadre[0] ;
         A2018MegSitRelRef = BC001330_A2018MegSitRelRef[0] ;
         A2030MegSitOld = BC001330_A2030MegSitOld[0] ;
         A1601MegSitRevista = BC001330_A1601MegSitRevista[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext13220( )
   {
      /* Scan next routine */
      pr_default.readNext(28);
      RcdFound220 = (short)(0) ;
      scanKeyLoad13220( ) ;
   }

   public void scanKeyLoad13220( )
   {
      sMode220 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A1604MegSitRevDescrip = BC001330_A1604MegSitRevDescrip[0] ;
         A1606MegSitRevDef = BC001330_A1606MegSitRevDef[0] ;
         A1993MegSitRelSec = BC001330_A1993MegSitRelSec[0] ;
         A1994MegSitRelSecCli = BC001330_A1994MegSitRelSecCli[0] ;
         A1995MegSitPadre = BC001330_A1995MegSitPadre[0] ;
         A2018MegSitRelRef = BC001330_A2018MegSitRelRef[0] ;
         A2030MegSitOld = BC001330_A2030MegSitOld[0] ;
         A1601MegSitRevista = BC001330_A1601MegSitRevista[0] ;
      }
      Gx_mode = sMode220 ;
   }

   public void scanKeyEnd13220( )
   {
      pr_default.close(28);
   }

   public void afterConfirm13220( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert13220( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate13220( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete13220( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete13220( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate13220( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes13220( )
   {
   }

   public void send_integrity_lvl_hashes13220( )
   {
   }

   public void send_integrity_lvl_hashes1336( )
   {
   }

   public void addRow1336( )
   {
      VarsToRow36( bcMotivoEgreso) ;
   }

   public void readRow1336( )
   {
      RowToVars36( bcMotivoEgreso, 1) ;
   }

   public void addRow13220( )
   {
      web.SdtMotivoEgreso_RevistaAfip obj220;
      obj220 = new web.SdtMotivoEgreso_RevistaAfip(remoteHandle);
      VarsToRow220( obj220) ;
      bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().add(obj220, 0);
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Mode( "UPD" );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Modified( (short)(0) );
   }

   public void readRow13220( )
   {
      nGXsfl_220_idx = (int)(nGXsfl_220_idx+1) ;
      RowToVars220( ((web.SdtMotivoEgreso_RevistaAfip)bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().elementAt(-1+nGXsfl_220_idx)), 1) ;
   }

   public void initializeNonKey1336( )
   {
      A300MegDescrip = "" ;
      A302MegRes551 = "" ;
      n302MegRes551 = false ;
      A1990MegRelSec = 0 ;
      A1991MegRelSecCli = 0 ;
      A1992MegPadre = "" ;
      A2017MegRelRef = "" ;
      A2029MegOld = "" ;
      A301MegHabilitado = true ;
      Z300MegDescrip = "" ;
      Z301MegHabilitado = false ;
      Z302MegRes551 = "" ;
      Z1990MegRelSec = 0 ;
      Z1991MegRelSecCli = 0 ;
      Z1992MegPadre = "" ;
      Z2017MegRelRef = "" ;
   }

   public void initAll1336( )
   {
      A3CliCod = 0 ;
      A11MegCodigo = "" ;
      initializeNonKey1336( ) ;
   }

   public void standaloneModalInsert( )
   {
      A301MegHabilitado = i301MegHabilitado ;
   }

   public void initializeNonKey13220( )
   {
      A1604MegSitRevDescrip = "" ;
      A1606MegSitRevDef = false ;
      A1993MegSitRelSec = 0 ;
      A1994MegSitRelSecCli = 0 ;
      A1995MegSitPadre = (short)(0) ;
      A2018MegSitRelRef = "" ;
      A2030MegSitOld = "" ;
      Z1606MegSitRevDef = false ;
      Z1993MegSitRelSec = 0 ;
      Z1994MegSitRelSecCli = 0 ;
      Z1995MegSitPadre = (short)(0) ;
      Z2018MegSitRelRef = "" ;
   }

   public void initAll13220( )
   {
      A1601MegSitRevista = (short)(0) ;
      initializeNonKey13220( ) ;
   }

   public void standaloneModalInsert13220( )
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

   public void VarsToRow36( web.SdtMotivoEgreso obj36 )
   {
      obj36.setgxTv_SdtMotivoEgreso_Mode( Gx_mode );
      obj36.setgxTv_SdtMotivoEgreso_Megdescrip( A300MegDescrip );
      obj36.setgxTv_SdtMotivoEgreso_Megres551( A302MegRes551 );
      obj36.setgxTv_SdtMotivoEgreso_Megrelsec( A1990MegRelSec );
      obj36.setgxTv_SdtMotivoEgreso_Megrelseccli( A1991MegRelSecCli );
      obj36.setgxTv_SdtMotivoEgreso_Megpadre( A1992MegPadre );
      obj36.setgxTv_SdtMotivoEgreso_Megrelref( A2017MegRelRef );
      obj36.setgxTv_SdtMotivoEgreso_Megold( A2029MegOld );
      obj36.setgxTv_SdtMotivoEgreso_Meghabilitado( A301MegHabilitado );
      obj36.setgxTv_SdtMotivoEgreso_Clicod( A3CliCod );
      obj36.setgxTv_SdtMotivoEgreso_Megcodigo( A11MegCodigo );
      obj36.setgxTv_SdtMotivoEgreso_Clicod_Z( Z3CliCod );
      obj36.setgxTv_SdtMotivoEgreso_Megcodigo_Z( Z11MegCodigo );
      obj36.setgxTv_SdtMotivoEgreso_Megdescrip_Z( Z300MegDescrip );
      obj36.setgxTv_SdtMotivoEgreso_Meghabilitado_Z( Z301MegHabilitado );
      obj36.setgxTv_SdtMotivoEgreso_Megres551_Z( Z302MegRes551 );
      obj36.setgxTv_SdtMotivoEgreso_Megrelsec_Z( Z1990MegRelSec );
      obj36.setgxTv_SdtMotivoEgreso_Megrelseccli_Z( Z1991MegRelSecCli );
      obj36.setgxTv_SdtMotivoEgreso_Megpadre_Z( Z1992MegPadre );
      obj36.setgxTv_SdtMotivoEgreso_Megrelref_Z( Z2017MegRelRef );
      obj36.setgxTv_SdtMotivoEgreso_Megres551_N( (byte)((byte)((n302MegRes551)?1:0)) );
      obj36.setgxTv_SdtMotivoEgreso_Mode( Gx_mode );
   }

   public void KeyVarsToRow36( web.SdtMotivoEgreso obj36 )
   {
      obj36.setgxTv_SdtMotivoEgreso_Clicod( A3CliCod );
      obj36.setgxTv_SdtMotivoEgreso_Megcodigo( A11MegCodigo );
   }

   public void RowToVars36( web.SdtMotivoEgreso obj36 ,
                            int forceLoad )
   {
      Gx_mode = obj36.getgxTv_SdtMotivoEgreso_Mode() ;
      A300MegDescrip = obj36.getgxTv_SdtMotivoEgreso_Megdescrip() ;
      A302MegRes551 = obj36.getgxTv_SdtMotivoEgreso_Megres551() ;
      n302MegRes551 = false ;
      A1990MegRelSec = obj36.getgxTv_SdtMotivoEgreso_Megrelsec() ;
      A1991MegRelSecCli = obj36.getgxTv_SdtMotivoEgreso_Megrelseccli() ;
      A1992MegPadre = obj36.getgxTv_SdtMotivoEgreso_Megpadre() ;
      A2017MegRelRef = obj36.getgxTv_SdtMotivoEgreso_Megrelref() ;
      A2029MegOld = obj36.getgxTv_SdtMotivoEgreso_Megold() ;
      A301MegHabilitado = obj36.getgxTv_SdtMotivoEgreso_Meghabilitado() ;
      A3CliCod = obj36.getgxTv_SdtMotivoEgreso_Clicod() ;
      A11MegCodigo = obj36.getgxTv_SdtMotivoEgreso_Megcodigo() ;
      Z3CliCod = obj36.getgxTv_SdtMotivoEgreso_Clicod_Z() ;
      Z11MegCodigo = obj36.getgxTv_SdtMotivoEgreso_Megcodigo_Z() ;
      Z300MegDescrip = obj36.getgxTv_SdtMotivoEgreso_Megdescrip_Z() ;
      Z301MegHabilitado = obj36.getgxTv_SdtMotivoEgreso_Meghabilitado_Z() ;
      Z302MegRes551 = obj36.getgxTv_SdtMotivoEgreso_Megres551_Z() ;
      Z1990MegRelSec = obj36.getgxTv_SdtMotivoEgreso_Megrelsec_Z() ;
      Z1991MegRelSecCli = obj36.getgxTv_SdtMotivoEgreso_Megrelseccli_Z() ;
      Z1992MegPadre = obj36.getgxTv_SdtMotivoEgreso_Megpadre_Z() ;
      Z2017MegRelRef = obj36.getgxTv_SdtMotivoEgreso_Megrelref_Z() ;
      n302MegRes551 = (boolean)((obj36.getgxTv_SdtMotivoEgreso_Megres551_N()==0)?false:true) ;
      Gx_mode = obj36.getgxTv_SdtMotivoEgreso_Mode() ;
   }

   public void VarsToRow220( web.SdtMotivoEgreso_RevistaAfip obj220 )
   {
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Mode( Gx_mode );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip( A1604MegSitRevDescrip );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef( A1606MegSitRevDef );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec( A1993MegSitRelSec );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli( A1994MegSitRelSecCli );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre( A1995MegSitPadre );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref( A2018MegSitRelRef );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitold( A2030MegSitOld );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( A1601MegSitRevista );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z( Z1601MegSitRevista );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z( Z1604MegSitRevDescrip );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z( Z1606MegSitRevDef );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z( Z1993MegSitRelSec );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z( Z1994MegSitRelSecCli );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z( Z1995MegSitPadre );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z( Z2018MegSitRelRef );
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Modified( nIsMod_220 );
   }

   public void KeyVarsToRow220( web.SdtMotivoEgreso_RevistaAfip obj220 )
   {
      obj220.setgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista( A1601MegSitRevista );
   }

   public void RowToVars220( web.SdtMotivoEgreso_RevistaAfip obj220 ,
                             int forceLoad )
   {
      Gx_mode = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Mode() ;
      A1604MegSitRevDescrip = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip() ;
      A1606MegSitRevDef = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef() ;
      A1993MegSitRelSec = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec() ;
      A1994MegSitRelSecCli = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli() ;
      A1995MegSitPadre = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre() ;
      A2018MegSitRelRef = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref() ;
      A2030MegSitOld = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitold() ;
      A1601MegSitRevista = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista() ;
      Z1601MegSitRevista = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevista_Z() ;
      Z1604MegSitRevDescrip = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdescrip_Z() ;
      Z1606MegSitRevDef = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrevdef_Z() ;
      Z1993MegSitRelSec = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelsec_Z() ;
      Z1994MegSitRelSecCli = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelseccli_Z() ;
      Z1995MegSitPadre = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitpadre_Z() ;
      Z2018MegSitRelRef = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Megsitrelref_Z() ;
      nIsMod_220 = obj220.getgxTv_SdtMotivoEgreso_RevistaAfip_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A11MegCodigo = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1336( ) ;
      scanKeyStart1336( ) ;
      if ( RcdFound36 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001331 */
         pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(29) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(29);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
      }
      zm1336( -5) ;
      onLoadActions1336( ) ;
      addRow1336( ) ;
      bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().clearCollection();
      if ( RcdFound36 == 1 )
      {
         scanKeyStart13220( ) ;
         nGXsfl_220_idx = 1 ;
         while ( RcdFound220 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z11MegCodigo = A11MegCodigo ;
            Z1601MegSitRevista = A1601MegSitRevista ;
            zm13220( -7) ;
            onLoadActions13220( ) ;
            nRcdExists_220 = (short)(1) ;
            nIsMod_220 = (short)(0) ;
            addRow13220( ) ;
            nGXsfl_220_idx = (int)(nGXsfl_220_idx+1) ;
            scanKeyNext13220( ) ;
         }
         scanKeyEnd13220( ) ;
      }
      scanKeyEnd1336( ) ;
      if ( RcdFound36 == 0 )
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
      RowToVars36( bcMotivoEgreso, 0) ;
      scanKeyStart1336( ) ;
      if ( RcdFound36 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001332 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(30) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(30);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
      }
      zm1336( -5) ;
      onLoadActions1336( ) ;
      addRow1336( ) ;
      bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Revistaafip().clearCollection();
      if ( RcdFound36 == 1 )
      {
         scanKeyStart13220( ) ;
         nGXsfl_220_idx = 1 ;
         while ( RcdFound220 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z11MegCodigo = A11MegCodigo ;
            Z1601MegSitRevista = A1601MegSitRevista ;
            zm13220( -7) ;
            onLoadActions13220( ) ;
            nRcdExists_220 = (short)(1) ;
            nIsMod_220 = (short)(0) ;
            addRow13220( ) ;
            nGXsfl_220_idx = (int)(nGXsfl_220_idx+1) ;
            scanKeyNext13220( ) ;
         }
         scanKeyEnd13220( ) ;
      }
      scanKeyEnd1336( ) ;
      if ( RcdFound36 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1336( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1336( ) ;
      }
      else
      {
         if ( RcdFound36 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A11MegCodigo = Z11MegCodigo ;
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
               update1336( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) )
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
                     insert1336( ) ;
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
                     insert1336( ) ;
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
      RowToVars36( bcMotivoEgreso, 1) ;
      saveImpl( ) ;
      VarsToRow36( bcMotivoEgreso) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars36( bcMotivoEgreso, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1336( ) ;
      afterTrn( ) ;
      VarsToRow36( bcMotivoEgreso) ;
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
         web.SdtMotivoEgreso auxBC = new web.SdtMotivoEgreso( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A11MegCodigo);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcMotivoEgreso);
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
      RowToVars36( bcMotivoEgreso, 1) ;
      updateImpl( ) ;
      VarsToRow36( bcMotivoEgreso) ;
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
      RowToVars36( bcMotivoEgreso, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1336( ) ;
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
      VarsToRow36( bcMotivoEgreso) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars36( bcMotivoEgreso, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1336( ) ;
      if ( RcdFound36 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A11MegCodigo = Z11MegCodigo ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "motivoegreso_bc");
      VarsToRow36( bcMotivoEgreso) ;
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
      Gx_mode = bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcMotivoEgreso.setgxTv_SdtMotivoEgreso_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtMotivoEgreso sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcMotivoEgreso )
      {
         bcMotivoEgreso = sdt ;
         if ( GXutil.strcmp(bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Mode(), "") == 0 )
         {
            bcMotivoEgreso.setgxTv_SdtMotivoEgreso_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow36( bcMotivoEgreso) ;
         }
         else
         {
            RowToVars36( bcMotivoEgreso, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcMotivoEgreso.getgxTv_SdtMotivoEgreso_Mode(), "") == 0 )
         {
            bcMotivoEgreso.setgxTv_SdtMotivoEgreso_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars36( bcMotivoEgreso, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtMotivoEgreso getMotivoEgreso_BC( )
   {
      return bcMotivoEgreso ;
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
      Z11MegCodigo = "" ;
      A11MegCodigo = "" ;
      sMode36 = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV16Pgmname = "" ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      Z300MegDescrip = "" ;
      A300MegDescrip = "" ;
      Z302MegRes551 = "" ;
      A302MegRes551 = "" ;
      Z1992MegPadre = "" ;
      A1992MegPadre = "" ;
      Z2017MegRelRef = "" ;
      A2017MegRelRef = "" ;
      Z2029MegOld = "" ;
      A2029MegOld = "" ;
      GXv_int5 = new int[1] ;
      BC00138_A11MegCodigo = new String[] {""} ;
      BC00138_A300MegDescrip = new String[] {""} ;
      BC00138_A301MegHabilitado = new boolean[] {false} ;
      BC00138_A302MegRes551 = new String[] {""} ;
      BC00138_n302MegRes551 = new boolean[] {false} ;
      BC00138_A1990MegRelSec = new int[1] ;
      BC00138_A1991MegRelSecCli = new int[1] ;
      BC00138_A1992MegPadre = new String[] {""} ;
      BC00138_A2017MegRelRef = new String[] {""} ;
      BC00138_A2029MegOld = new String[] {""} ;
      BC00138_A3CliCod = new int[1] ;
      BC00139_A3CliCod = new int[1] ;
      BC001310_A3CliCod = new int[1] ;
      BC001310_A11MegCodigo = new String[] {""} ;
      BC001311_A11MegCodigo = new String[] {""} ;
      BC001311_A300MegDescrip = new String[] {""} ;
      BC001311_A301MegHabilitado = new boolean[] {false} ;
      BC001311_A302MegRes551 = new String[] {""} ;
      BC001311_n302MegRes551 = new boolean[] {false} ;
      BC001311_A1990MegRelSec = new int[1] ;
      BC001311_A1991MegRelSecCli = new int[1] ;
      BC001311_A1992MegPadre = new String[] {""} ;
      BC001311_A2017MegRelRef = new String[] {""} ;
      BC001311_A2029MegOld = new String[] {""} ;
      BC001311_A3CliCod = new int[1] ;
      BC001312_A11MegCodigo = new String[] {""} ;
      BC001312_A300MegDescrip = new String[] {""} ;
      BC001312_A301MegHabilitado = new boolean[] {false} ;
      BC001312_A302MegRes551 = new String[] {""} ;
      BC001312_n302MegRes551 = new boolean[] {false} ;
      BC001312_A1990MegRelSec = new int[1] ;
      BC001312_A1991MegRelSecCli = new int[1] ;
      BC001312_A1992MegPadre = new String[] {""} ;
      BC001312_A2017MegRelRef = new String[] {""} ;
      BC001312_A2029MegOld = new String[] {""} ;
      BC001312_A3CliCod = new int[1] ;
      BC001316_A3CliCod = new int[1] ;
      BC001316_A1EmpCod = new short[1] ;
      BC001316_A6LegNumero = new int[1] ;
      BC001316_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      BC001317_A3CliCod = new int[1] ;
      BC001317_A26ConCodigo = new String[] {""} ;
      BC001317_A11MegCodigo = new String[] {""} ;
      BC001317_A2077ConMegSec = new short[1] ;
      BC001318_A3CliCod = new int[1] ;
      BC001318_A11MegCodigo = new String[] {""} ;
      BC001318_A1525MegTipo = new String[] {""} ;
      BC001319_A3CliCod = new int[1] ;
      BC001319_A1EmpCod = new short[1] ;
      BC001319_A6LegNumero = new int[1] ;
      BC001320_A11MegCodigo = new String[] {""} ;
      BC001320_A300MegDescrip = new String[] {""} ;
      BC001320_A301MegHabilitado = new boolean[] {false} ;
      BC001320_A302MegRes551 = new String[] {""} ;
      BC001320_n302MegRes551 = new boolean[] {false} ;
      BC001320_A1990MegRelSec = new int[1] ;
      BC001320_A1991MegRelSecCli = new int[1] ;
      BC001320_A1992MegPadre = new String[] {""} ;
      BC001320_A2017MegRelRef = new String[] {""} ;
      BC001320_A2029MegOld = new String[] {""} ;
      BC001320_A3CliCod = new int[1] ;
      Z2018MegSitRelRef = "" ;
      A2018MegSitRelRef = "" ;
      Z1604MegSitRevDescrip = "" ;
      A1604MegSitRevDescrip = "" ;
      Z2030MegSitOld = "" ;
      A2030MegSitOld = "" ;
      BC001321_A3CliCod = new int[1] ;
      BC001321_A11MegCodigo = new String[] {""} ;
      BC001321_A1604MegSitRevDescrip = new String[] {""} ;
      BC001321_A1606MegSitRevDef = new boolean[] {false} ;
      BC001321_A1993MegSitRelSec = new int[1] ;
      BC001321_A1994MegSitRelSecCli = new int[1] ;
      BC001321_A1995MegSitPadre = new short[1] ;
      BC001321_A2018MegSitRelRef = new String[] {""} ;
      BC001321_A2030MegSitOld = new String[] {""} ;
      BC001321_A1601MegSitRevista = new short[1] ;
      BC001322_A1604MegSitRevDescrip = new String[] {""} ;
      BC001323_A3CliCod = new int[1] ;
      BC001323_A11MegCodigo = new String[] {""} ;
      BC001323_A1601MegSitRevista = new short[1] ;
      BC001324_A3CliCod = new int[1] ;
      BC001324_A11MegCodigo = new String[] {""} ;
      BC001324_A1606MegSitRevDef = new boolean[] {false} ;
      BC001324_A1993MegSitRelSec = new int[1] ;
      BC001324_A1994MegSitRelSecCli = new int[1] ;
      BC001324_A1995MegSitPadre = new short[1] ;
      BC001324_A2018MegSitRelRef = new String[] {""} ;
      BC001324_A2030MegSitOld = new String[] {""} ;
      BC001324_A1601MegSitRevista = new short[1] ;
      sMode220 = "" ;
      BC001325_A3CliCod = new int[1] ;
      BC001325_A11MegCodigo = new String[] {""} ;
      BC001325_A1606MegSitRevDef = new boolean[] {false} ;
      BC001325_A1993MegSitRelSec = new int[1] ;
      BC001325_A1994MegSitRelSecCli = new int[1] ;
      BC001325_A1995MegSitPadre = new short[1] ;
      BC001325_A2018MegSitRelRef = new String[] {""} ;
      BC001325_A2030MegSitOld = new String[] {""} ;
      BC001325_A1601MegSitRevista = new short[1] ;
      BC001329_A1604MegSitRevDescrip = new String[] {""} ;
      BC001330_A3CliCod = new int[1] ;
      BC001330_A11MegCodigo = new String[] {""} ;
      BC001330_A1604MegSitRevDescrip = new String[] {""} ;
      BC001330_A1606MegSitRevDef = new boolean[] {false} ;
      BC001330_A1993MegSitRelSec = new int[1] ;
      BC001330_A1994MegSitRelSecCli = new int[1] ;
      BC001330_A1995MegSitPadre = new short[1] ;
      BC001330_A2018MegSitRelRef = new String[] {""} ;
      BC001330_A2030MegSitOld = new String[] {""} ;
      BC001330_A1601MegSitRevista = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001331_A3CliCod = new int[1] ;
      BC001332_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.motivoegreso_bc__default(),
         new Object[] {
             new Object[] {
            BC00132_A3CliCod, BC00132_A11MegCodigo, BC00132_A1606MegSitRevDef, BC00132_A1993MegSitRelSec, BC00132_A1994MegSitRelSecCli, BC00132_A1995MegSitPadre, BC00132_A2018MegSitRelRef, BC00132_A2030MegSitOld, BC00132_A1601MegSitRevista
            }
            , new Object[] {
            BC00133_A3CliCod, BC00133_A11MegCodigo, BC00133_A1606MegSitRevDef, BC00133_A1993MegSitRelSec, BC00133_A1994MegSitRelSecCli, BC00133_A1995MegSitPadre, BC00133_A2018MegSitRelRef, BC00133_A2030MegSitOld, BC00133_A1601MegSitRevista
            }
            , new Object[] {
            BC00134_A1604MegSitRevDescrip
            }
            , new Object[] {
            BC00135_A11MegCodigo, BC00135_A300MegDescrip, BC00135_A301MegHabilitado, BC00135_A302MegRes551, BC00135_n302MegRes551, BC00135_A1990MegRelSec, BC00135_A1991MegRelSecCli, BC00135_A1992MegPadre, BC00135_A2017MegRelRef, BC00135_A2029MegOld,
            BC00135_A3CliCod
            }
            , new Object[] {
            BC00136_A11MegCodigo, BC00136_A300MegDescrip, BC00136_A301MegHabilitado, BC00136_A302MegRes551, BC00136_n302MegRes551, BC00136_A1990MegRelSec, BC00136_A1991MegRelSecCli, BC00136_A1992MegPadre, BC00136_A2017MegRelRef, BC00136_A2029MegOld,
            BC00136_A3CliCod
            }
            , new Object[] {
            BC00137_A3CliCod
            }
            , new Object[] {
            BC00138_A11MegCodigo, BC00138_A300MegDescrip, BC00138_A301MegHabilitado, BC00138_A302MegRes551, BC00138_n302MegRes551, BC00138_A1990MegRelSec, BC00138_A1991MegRelSecCli, BC00138_A1992MegPadre, BC00138_A2017MegRelRef, BC00138_A2029MegOld,
            BC00138_A3CliCod
            }
            , new Object[] {
            BC00139_A3CliCod
            }
            , new Object[] {
            BC001310_A3CliCod, BC001310_A11MegCodigo
            }
            , new Object[] {
            BC001311_A11MegCodigo, BC001311_A300MegDescrip, BC001311_A301MegHabilitado, BC001311_A302MegRes551, BC001311_n302MegRes551, BC001311_A1990MegRelSec, BC001311_A1991MegRelSecCli, BC001311_A1992MegPadre, BC001311_A2017MegRelRef, BC001311_A2029MegOld,
            BC001311_A3CliCod
            }
            , new Object[] {
            BC001312_A11MegCodigo, BC001312_A300MegDescrip, BC001312_A301MegHabilitado, BC001312_A302MegRes551, BC001312_n302MegRes551, BC001312_A1990MegRelSec, BC001312_A1991MegRelSecCli, BC001312_A1992MegPadre, BC001312_A2017MegRelRef, BC001312_A2029MegOld,
            BC001312_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001316_A3CliCod, BC001316_A1EmpCod, BC001316_A6LegNumero, BC001316_A2253LegHisFecIng
            }
            , new Object[] {
            BC001317_A3CliCod, BC001317_A26ConCodigo, BC001317_A11MegCodigo, BC001317_A2077ConMegSec
            }
            , new Object[] {
            BC001318_A3CliCod, BC001318_A11MegCodigo, BC001318_A1525MegTipo
            }
            , new Object[] {
            BC001319_A3CliCod, BC001319_A1EmpCod, BC001319_A6LegNumero
            }
            , new Object[] {
            BC001320_A11MegCodigo, BC001320_A300MegDescrip, BC001320_A301MegHabilitado, BC001320_A302MegRes551, BC001320_n302MegRes551, BC001320_A1990MegRelSec, BC001320_A1991MegRelSecCli, BC001320_A1992MegPadre, BC001320_A2017MegRelRef, BC001320_A2029MegOld,
            BC001320_A3CliCod
            }
            , new Object[] {
            BC001321_A3CliCod, BC001321_A11MegCodigo, BC001321_A1604MegSitRevDescrip, BC001321_A1606MegSitRevDef, BC001321_A1993MegSitRelSec, BC001321_A1994MegSitRelSecCli, BC001321_A1995MegSitPadre, BC001321_A2018MegSitRelRef, BC001321_A2030MegSitOld, BC001321_A1601MegSitRevista
            }
            , new Object[] {
            BC001322_A1604MegSitRevDescrip
            }
            , new Object[] {
            BC001323_A3CliCod, BC001323_A11MegCodigo, BC001323_A1601MegSitRevista
            }
            , new Object[] {
            BC001324_A3CliCod, BC001324_A11MegCodigo, BC001324_A1606MegSitRevDef, BC001324_A1993MegSitRelSec, BC001324_A1994MegSitRelSecCli, BC001324_A1995MegSitPadre, BC001324_A2018MegSitRelRef, BC001324_A2030MegSitOld, BC001324_A1601MegSitRevista
            }
            , new Object[] {
            BC001325_A3CliCod, BC001325_A11MegCodigo, BC001325_A1606MegSitRevDef, BC001325_A1993MegSitRelSec, BC001325_A1994MegSitRelSecCli, BC001325_A1995MegSitPadre, BC001325_A2018MegSitRelRef, BC001325_A2030MegSitOld, BC001325_A1601MegSitRevista
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001329_A1604MegSitRevDescrip
            }
            , new Object[] {
            BC001330_A3CliCod, BC001330_A11MegCodigo, BC001330_A1604MegSitRevDescrip, BC001330_A1606MegSitRevDef, BC001330_A1993MegSitRelSec, BC001330_A1994MegSitRelSecCli, BC001330_A1995MegSitPadre, BC001330_A2018MegSitRelRef, BC001330_A2030MegSitOld, BC001330_A1601MegSitRevista
            }
            , new Object[] {
            BC001331_A3CliCod
            }
            , new Object[] {
            BC001332_A3CliCod
            }
         }
      );
      AV16Pgmname = "MotivoEgreso_BC" ;
      Z301MegHabilitado = true ;
      A301MegHabilitado = true ;
      i301MegHabilitado = true ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12132 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte Gxremove220 ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nIsMod_220 ;
   private short RcdFound220 ;
   private short RcdFound36 ;
   private short nIsDirty_36 ;
   private short nRcdExists_220 ;
   private short Z1995MegSitPadre ;
   private short A1995MegSitPadre ;
   private short Z1601MegSitRevista ;
   private short A1601MegSitRevista ;
   private short nIsDirty_220 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int nGXsfl_220_idx=1 ;
   private int GX_JID ;
   private int Z1990MegRelSec ;
   private int A1990MegRelSec ;
   private int Z1991MegRelSecCli ;
   private int A1991MegRelSecCli ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private int Z1993MegSitRelSec ;
   private int A1993MegSitRelSec ;
   private int Z1994MegSitRelSecCli ;
   private int A1994MegSitRelSecCli ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z11MegCodigo ;
   private String A11MegCodigo ;
   private String sMode36 ;
   private String AV16Pgmname ;
   private String Z302MegRes551 ;
   private String A302MegRes551 ;
   private String Z1992MegPadre ;
   private String A1992MegPadre ;
   private String sMode220 ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z301MegHabilitado ;
   private boolean A301MegHabilitado ;
   private boolean n302MegRes551 ;
   private boolean Gx_longc ;
   private boolean Z1606MegSitRevDef ;
   private boolean A1606MegSitRevDef ;
   private boolean i301MegHabilitado ;
   private boolean mustCommit ;
   private String Z2029MegOld ;
   private String A2029MegOld ;
   private String Z2030MegSitOld ;
   private String A2030MegSitOld ;
   private String Z300MegDescrip ;
   private String A300MegDescrip ;
   private String Z2017MegRelRef ;
   private String A2017MegRelRef ;
   private String Z2018MegSitRelRef ;
   private String A2018MegSitRelRef ;
   private String Z1604MegSitRevDescrip ;
   private String A1604MegSitRevDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private web.SdtMotivoEgreso bcMotivoEgreso ;
   private IDataStoreProvider pr_default ;
   private String[] BC00138_A11MegCodigo ;
   private String[] BC00138_A300MegDescrip ;
   private boolean[] BC00138_A301MegHabilitado ;
   private String[] BC00138_A302MegRes551 ;
   private boolean[] BC00138_n302MegRes551 ;
   private int[] BC00138_A1990MegRelSec ;
   private int[] BC00138_A1991MegRelSecCli ;
   private String[] BC00138_A1992MegPadre ;
   private String[] BC00138_A2017MegRelRef ;
   private String[] BC00138_A2029MegOld ;
   private int[] BC00138_A3CliCod ;
   private int[] BC00139_A3CliCod ;
   private int[] BC001310_A3CliCod ;
   private String[] BC001310_A11MegCodigo ;
   private String[] BC001311_A11MegCodigo ;
   private String[] BC001311_A300MegDescrip ;
   private boolean[] BC001311_A301MegHabilitado ;
   private String[] BC001311_A302MegRes551 ;
   private boolean[] BC001311_n302MegRes551 ;
   private int[] BC001311_A1990MegRelSec ;
   private int[] BC001311_A1991MegRelSecCli ;
   private String[] BC001311_A1992MegPadre ;
   private String[] BC001311_A2017MegRelRef ;
   private String[] BC001311_A2029MegOld ;
   private int[] BC001311_A3CliCod ;
   private String[] BC001312_A11MegCodigo ;
   private String[] BC001312_A300MegDescrip ;
   private boolean[] BC001312_A301MegHabilitado ;
   private String[] BC001312_A302MegRes551 ;
   private boolean[] BC001312_n302MegRes551 ;
   private int[] BC001312_A1990MegRelSec ;
   private int[] BC001312_A1991MegRelSecCli ;
   private String[] BC001312_A1992MegPadre ;
   private String[] BC001312_A2017MegRelRef ;
   private String[] BC001312_A2029MegOld ;
   private int[] BC001312_A3CliCod ;
   private int[] BC001316_A3CliCod ;
   private short[] BC001316_A1EmpCod ;
   private int[] BC001316_A6LegNumero ;
   private java.util.Date[] BC001316_A2253LegHisFecIng ;
   private int[] BC001317_A3CliCod ;
   private String[] BC001317_A26ConCodigo ;
   private String[] BC001317_A11MegCodigo ;
   private short[] BC001317_A2077ConMegSec ;
   private int[] BC001318_A3CliCod ;
   private String[] BC001318_A11MegCodigo ;
   private String[] BC001318_A1525MegTipo ;
   private int[] BC001319_A3CliCod ;
   private short[] BC001319_A1EmpCod ;
   private int[] BC001319_A6LegNumero ;
   private String[] BC001320_A11MegCodigo ;
   private String[] BC001320_A300MegDescrip ;
   private boolean[] BC001320_A301MegHabilitado ;
   private String[] BC001320_A302MegRes551 ;
   private boolean[] BC001320_n302MegRes551 ;
   private int[] BC001320_A1990MegRelSec ;
   private int[] BC001320_A1991MegRelSecCli ;
   private String[] BC001320_A1992MegPadre ;
   private String[] BC001320_A2017MegRelRef ;
   private String[] BC001320_A2029MegOld ;
   private int[] BC001320_A3CliCod ;
   private int[] BC001321_A3CliCod ;
   private String[] BC001321_A11MegCodigo ;
   private String[] BC001321_A1604MegSitRevDescrip ;
   private boolean[] BC001321_A1606MegSitRevDef ;
   private int[] BC001321_A1993MegSitRelSec ;
   private int[] BC001321_A1994MegSitRelSecCli ;
   private short[] BC001321_A1995MegSitPadre ;
   private String[] BC001321_A2018MegSitRelRef ;
   private String[] BC001321_A2030MegSitOld ;
   private short[] BC001321_A1601MegSitRevista ;
   private String[] BC001322_A1604MegSitRevDescrip ;
   private int[] BC001323_A3CliCod ;
   private String[] BC001323_A11MegCodigo ;
   private short[] BC001323_A1601MegSitRevista ;
   private int[] BC001324_A3CliCod ;
   private String[] BC001324_A11MegCodigo ;
   private boolean[] BC001324_A1606MegSitRevDef ;
   private int[] BC001324_A1993MegSitRelSec ;
   private int[] BC001324_A1994MegSitRelSecCli ;
   private short[] BC001324_A1995MegSitPadre ;
   private String[] BC001324_A2018MegSitRelRef ;
   private String[] BC001324_A2030MegSitOld ;
   private short[] BC001324_A1601MegSitRevista ;
   private int[] BC001325_A3CliCod ;
   private String[] BC001325_A11MegCodigo ;
   private boolean[] BC001325_A1606MegSitRevDef ;
   private int[] BC001325_A1993MegSitRelSec ;
   private int[] BC001325_A1994MegSitRelSecCli ;
   private short[] BC001325_A1995MegSitPadre ;
   private String[] BC001325_A2018MegSitRelRef ;
   private String[] BC001325_A2030MegSitOld ;
   private short[] BC001325_A1601MegSitRevista ;
   private String[] BC001329_A1604MegSitRevDescrip ;
   private int[] BC001330_A3CliCod ;
   private String[] BC001330_A11MegCodigo ;
   private String[] BC001330_A1604MegSitRevDescrip ;
   private boolean[] BC001330_A1606MegSitRevDef ;
   private int[] BC001330_A1993MegSitRelSec ;
   private int[] BC001330_A1994MegSitRelSecCli ;
   private short[] BC001330_A1995MegSitPadre ;
   private String[] BC001330_A2018MegSitRelRef ;
   private String[] BC001330_A2030MegSitOld ;
   private short[] BC001330_A1601MegSitRevista ;
   private int[] BC001331_A3CliCod ;
   private int[] BC001332_A3CliCod ;
   private int[] BC00132_A3CliCod ;
   private String[] BC00132_A11MegCodigo ;
   private boolean[] BC00132_A1606MegSitRevDef ;
   private int[] BC00132_A1993MegSitRelSec ;
   private int[] BC00132_A1994MegSitRelSecCli ;
   private short[] BC00132_A1995MegSitPadre ;
   private String[] BC00132_A2018MegSitRelRef ;
   private String[] BC00132_A2030MegSitOld ;
   private short[] BC00132_A1601MegSitRevista ;
   private int[] BC00133_A3CliCod ;
   private String[] BC00133_A11MegCodigo ;
   private boolean[] BC00133_A1606MegSitRevDef ;
   private int[] BC00133_A1993MegSitRelSec ;
   private int[] BC00133_A1994MegSitRelSecCli ;
   private short[] BC00133_A1995MegSitPadre ;
   private String[] BC00133_A2018MegSitRelRef ;
   private String[] BC00133_A2030MegSitOld ;
   private short[] BC00133_A1601MegSitRevista ;
   private String[] BC00134_A1604MegSitRevDescrip ;
   private String[] BC00135_A11MegCodigo ;
   private String[] BC00135_A300MegDescrip ;
   private boolean[] BC00135_A301MegHabilitado ;
   private String[] BC00135_A302MegRes551 ;
   private int[] BC00135_A1990MegRelSec ;
   private int[] BC00135_A1991MegRelSecCli ;
   private String[] BC00135_A1992MegPadre ;
   private String[] BC00135_A2017MegRelRef ;
   private String[] BC00135_A2029MegOld ;
   private int[] BC00135_A3CliCod ;
   private String[] BC00136_A11MegCodigo ;
   private String[] BC00136_A300MegDescrip ;
   private boolean[] BC00136_A301MegHabilitado ;
   private String[] BC00136_A302MegRes551 ;
   private int[] BC00136_A1990MegRelSec ;
   private int[] BC00136_A1991MegRelSecCli ;
   private String[] BC00136_A1992MegPadre ;
   private String[] BC00136_A2017MegRelRef ;
   private String[] BC00136_A2029MegOld ;
   private int[] BC00136_A3CliCod ;
   private int[] BC00137_A3CliCod ;
   private boolean[] BC00135_n302MegRes551 ;
   private boolean[] BC00136_n302MegRes551 ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class motivoegreso_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00132", "SELECT CliCod, MegCodigo, MegSitRevDef, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?  FOR UPDATE OF MotivoEgresoRevistaAfip",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00133", "SELECT CliCod, MegCodigo, MegSitRevDef, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00134", "SELECT SitRevDescrip AS MegSitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00135", "SELECT MegCodigo, MegDescrip, MegHabilitado, MegRes551, MegRelSec, MegRelSecCli, MegPadre, MegRelRef, MegOld, CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ?  FOR UPDATE OF MotivoEgreso",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00136", "SELECT MegCodigo, MegDescrip, MegHabilitado, MegRes551, MegRelSec, MegRelSecCli, MegPadre, MegRelRef, MegOld, CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00137", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00138", "SELECT TM1.MegCodigo, TM1.MegDescrip, TM1.MegHabilitado, TM1.MegRes551, TM1.MegRelSec, TM1.MegRelSecCli, TM1.MegPadre, TM1.MegRelRef, TM1.MegOld, TM1.CliCod FROM MotivoEgreso TM1 WHERE TM1.CliCod = ? and TM1.MegCodigo = ( ?) ORDER BY TM1.CliCod, TM1.MegCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00139", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001310", "SELECT CliCod, MegCodigo FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001311", "SELECT MegCodigo, MegDescrip, MegHabilitado, MegRes551, MegRelSec, MegRelSecCli, MegPadre, MegRelRef, MegOld, CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001312", "SELECT MegCodigo, MegDescrip, MegHabilitado, MegRes551, MegRelSec, MegRelSecCli, MegPadre, MegRelRef, MegOld, CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ?  FOR UPDATE OF MotivoEgreso",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001313", "SAVEPOINT gxupdate;INSERT INTO MotivoEgreso(MegCodigo, MegDescrip, MegHabilitado, MegRes551, MegRelSec, MegRelSecCli, MegPadre, MegRelRef, MegOld, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001314", "SAVEPOINT gxupdate;UPDATE MotivoEgreso SET MegDescrip=?, MegHabilitado=?, MegRes551=?, MegRelSec=?, MegRelSecCli=?, MegPadre=?, MegRelRef=?, MegOld=?  WHERE CliCod = ? AND MegCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001315", "SAVEPOINT gxupdate;DELETE FROM MotivoEgreso  WHERE CliCod = ? AND MegCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001316", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND LegHisMotCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001317", "SELECT CliCod, ConCodigo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? AND MegCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001318", "SELECT CliCod, MegCodigo, MegTipo FROM MotivoEgresoTipos WHERE CliCod = ? AND MegCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001319", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegMegCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001320", "SELECT TM1.MegCodigo, TM1.MegDescrip, TM1.MegHabilitado, TM1.MegRes551, TM1.MegRelSec, TM1.MegRelSecCli, TM1.MegPadre, TM1.MegRelRef, TM1.MegOld, TM1.CliCod FROM MotivoEgreso TM1 WHERE TM1.CliCod = ? and TM1.MegCodigo = ( ?) ORDER BY TM1.CliCod, TM1.MegCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001321", "SELECT T1.CliCod, T1.MegCodigo, T2.SitRevDescrip AS MegSitRevDescrip, T1.MegSitRevDef, T1.MegSitRelSec, T1.MegSitRelSecCli, T1.MegSitPadre, T1.MegSitRelRef, T1.MegSitOld, T1.MegSitRevista AS MegSitRevista FROM (MotivoEgresoRevistaAfip T1 INNER JOIN SituacionRevistaAFIP T2 ON T2.SitRevCodigo = T1.MegSitRevista) WHERE T1.CliCod = ? and T1.MegCodigo = ( ?) and T1.MegSitRevista = ? ORDER BY T1.CliCod, T1.MegCodigo, T1.MegSitRevista ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001322", "SELECT SitRevDescrip AS MegSitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001323", "SELECT CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001324", "SELECT CliCod, MegCodigo, MegSitRevDef, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001325", "SELECT CliCod, MegCodigo, MegSitRevDef, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?  FOR UPDATE OF MotivoEgresoRevistaAfip",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001326", "SAVEPOINT gxupdate;INSERT INTO MotivoEgresoRevistaAfip(CliCod, MegCodigo, MegSitRevDef, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld, MegSitRevista) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001327", "SAVEPOINT gxupdate;UPDATE MotivoEgresoRevistaAfip SET MegSitRevDef=?, MegSitRelSec=?, MegSitRelSecCli=?, MegSitPadre=?, MegSitRelRef=?, MegSitOld=?  WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001328", "SAVEPOINT gxupdate;DELETE FROM MotivoEgresoRevistaAfip  WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001329", "SELECT SitRevDescrip AS MegSitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001330", "SELECT T1.CliCod, T1.MegCodigo, T2.SitRevDescrip AS MegSitRevDescrip, T1.MegSitRevDef, T1.MegSitRelSec, T1.MegSitRelSecCli, T1.MegSitPadre, T1.MegSitRelRef, T1.MegSitOld, T1.MegSitRevista AS MegSitRevista FROM (MotivoEgresoRevistaAfip T1 INNER JOIN SituacionRevistaAFIP T2 ON T2.SitRevCodigo = T1.MegSitRevista) WHERE T1.CliCod = ? and T1.MegCodigo = ( ?) ORDER BY T1.CliCod, T1.MegCodigo, T1.MegSitRevista ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001331", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001332", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 20);
               }
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setString(7, (String)parms[7], 20);
               stmt.setVarchar(8, (String)parms[8], 40, false);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               stmt.setInt(10, ((Number) parms[10]).intValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setString(6, (String)parms[6], 20);
               stmt.setVarchar(7, (String)parms[7], 40, false);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setString(10, (String)parms[10], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 25 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 27 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               return;
      }
   }

}

