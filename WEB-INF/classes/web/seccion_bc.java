package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class seccion_bc extends GXWebPanel implements IGxSilentTrn
{
   public seccion_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public seccion_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( seccion_bc.class ));
   }

   public seccion_bc( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1A43( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1A43( ) ;
      standaloneModal( ) ;
      addRow1A43( ) ;
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
         e111A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z13SecCodigo = A13SecCodigo ;
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

   public void confirm_1A0( )
   {
      beforeValidate1A43( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1A43( ) ;
         }
         else
         {
            checkExtendedTable1A43( ) ;
            if ( AnyError == 0 )
            {
               zm1A43( 8) ;
            }
            closeExtendedTableCursors1A43( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode43 = Gx_mode ;
         confirm_1A153( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode43 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode43 ;
      }
   }

   public void confirm_1A153( )
   {
      nGXsfl_153_idx = 0 ;
      while ( nGXsfl_153_idx < bcSeccion.getgxTv_SdtSeccion_Puestos().size() )
      {
         readRow1A153( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound153 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_153 != 0 ) )
         {
            getKey1A153( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound153 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate1A153( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable1A153( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors1A153( ) ;
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
               if ( RcdFound153 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey1A153( ) ;
                     load1A153( ) ;
                     beforeValidate1A153( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls1A153( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_153 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate1A153( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable1A153( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors1A153( ) ;
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
            VarsToRow153( ((web.SdtSeccion_Puestos)bcSeccion.getgxTv_SdtSeccion_Puestos().elementAt(-1+nGXsfl_153_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e121A2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSeccion_Insert", GXv_boolean3) ;
         seccion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSeccion_Update", GXv_boolean3) ;
         seccion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSeccion_Delete", GXv_boolean3) ;
         seccion_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV17Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e111A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.secciongrabarrelref(remoteHandle, context).execute( A3CliCod) ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm1A43( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z675SecDescripSinAc = A675SecDescripSinAc ;
         Z329SecDescrip = A329SecDescrip ;
         Z330SecHabilitada = A330SecHabilitada ;
         Z1984SecRelSec = A1984SecRelSec ;
         Z1985SecRelSecCli = A1985SecRelSecCli ;
         Z1986SecPadre = A1986SecPadre ;
         Z2015SecRelRef = A2015SecRelRef ;
         Z2308SecApoOpc = A2308SecApoOpc ;
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -7 )
      {
         Z675SecDescripSinAc = A675SecDescripSinAc ;
         Z13SecCodigo = A13SecCodigo ;
         Z329SecDescrip = A329SecDescrip ;
         Z330SecHabilitada = A330SecHabilitada ;
         Z1984SecRelSec = A1984SecRelSec ;
         Z1985SecRelSecCli = A1985SecRelSecCli ;
         Z1986SecPadre = A1986SecPadre ;
         Z2015SecRelRef = A2015SecRelRef ;
         Z2033SecOld = A2033SecOld ;
         Z2308SecApoOpc = A2308SecApoOpc ;
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
         seccion_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (false==A330SecHabilitada) && ( Gx_BScreen == 0 ) )
      {
         A330SecHabilitada = true ;
      }
   }

   public void load1A43( )
   {
      /* Using cursor BC001A7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A675SecDescripSinAc = BC001A7_A675SecDescripSinAc[0] ;
         A329SecDescrip = BC001A7_A329SecDescrip[0] ;
         A330SecHabilitada = BC001A7_A330SecHabilitada[0] ;
         A1984SecRelSec = BC001A7_A1984SecRelSec[0] ;
         A1985SecRelSecCli = BC001A7_A1985SecRelSecCli[0] ;
         A1986SecPadre = BC001A7_A1986SecPadre[0] ;
         A2015SecRelRef = BC001A7_A2015SecRelRef[0] ;
         A2033SecOld = BC001A7_A2033SecOld[0] ;
         A2308SecApoOpc = BC001A7_A2308SecApoOpc[0] ;
         zm1A43( -7) ;
      }
      pr_default.close(5);
      onLoadActions1A43( ) ;
   }

   public void onLoadActions1A43( )
   {
      AV17Pgmname = "Seccion_BC" ;
      GXt_char6 = A675SecDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char7) ;
      seccion_bc.this.GXt_char6 = GXv_char7[0] ;
      A675SecDescripSinAc = GXt_char6 ;
   }

   public void checkExtendedTable1A43( )
   {
      nIsDirty_43 = (short)(0) ;
      standaloneModal( ) ;
      AV17Pgmname = "Seccion_BC" ;
      /* Using cursor BC001A8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
      if ( (GXutil.strcmp("", A13SecCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Area", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      nIsDirty_43 = (short)(1) ;
      GXt_char6 = A675SecDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A329SecDescrip, GXv_char7) ;
      seccion_bc.this.GXt_char6 = GXv_char7[0] ;
      A675SecDescripSinAc = GXt_char6 ;
      if ( (GXutil.strcmp("", A329SecDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Area", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1A43( )
   {
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey1A43( )
   {
      /* Using cursor BC001A9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound43 = (short)(1) ;
      }
      else
      {
         RcdFound43 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001A10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm1A43( 7) ;
         RcdFound43 = (short)(1) ;
         A675SecDescripSinAc = BC001A10_A675SecDescripSinAc[0] ;
         A13SecCodigo = BC001A10_A13SecCodigo[0] ;
         A329SecDescrip = BC001A10_A329SecDescrip[0] ;
         A330SecHabilitada = BC001A10_A330SecHabilitada[0] ;
         A1984SecRelSec = BC001A10_A1984SecRelSec[0] ;
         A1985SecRelSecCli = BC001A10_A1985SecRelSecCli[0] ;
         A1986SecPadre = BC001A10_A1986SecPadre[0] ;
         A2015SecRelRef = BC001A10_A2015SecRelRef[0] ;
         A2033SecOld = BC001A10_A2033SecOld[0] ;
         A2308SecApoOpc = BC001A10_A2308SecApoOpc[0] ;
         A3CliCod = BC001A10_A3CliCod[0] ;
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1A43( ) ;
         if ( AnyError == 1 )
         {
            RcdFound43 = (short)(0) ;
            initializeNonKey1A43( ) ;
         }
         Gx_mode = sMode43 ;
      }
      else
      {
         RcdFound43 = (short)(0) ;
         initializeNonKey1A43( ) ;
         sMode43 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode43 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey1A43( ) ;
      if ( RcdFound43 == 0 )
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
      confirm_1A0( ) ;
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

   public void checkOptimisticConcurrency1A43( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001A11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Seccion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(9) == 101) || ( GXutil.strcmp(Z675SecDescripSinAc, BC001A11_A675SecDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z329SecDescrip, BC001A11_A329SecDescrip[0]) != 0 ) || ( Z330SecHabilitada != BC001A11_A330SecHabilitada[0] ) || ( Z1984SecRelSec != BC001A11_A1984SecRelSec[0] ) || ( Z1985SecRelSecCli != BC001A11_A1985SecRelSecCli[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1986SecPadre, BC001A11_A1986SecPadre[0]) != 0 ) || ( GXutil.strcmp(Z2015SecRelRef, BC001A11_A2015SecRelRef[0]) != 0 ) || ( Z2308SecApoOpc != BC001A11_A2308SecApoOpc[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Seccion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1A43( )
   {
      beforeValidate1A43( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1A43( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1A43( 0) ;
         checkOptimisticConcurrency1A43( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1A43( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1A43( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001A12 */
                  pr_default.execute(10, new Object[] {A675SecDescripSinAc, A13SecCodigo, A329SecDescrip, Boolean.valueOf(A330SecHabilitada), Integer.valueOf(A1984SecRelSec), Integer.valueOf(A1985SecRelSecCli), A1986SecPadre, A2015SecRelRef, A2033SecOld, Boolean.valueOf(A2308SecApoOpc), Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
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
                        processLevel1A43( ) ;
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
            load1A43( ) ;
         }
         endLevel1A43( ) ;
      }
      closeExtendedTableCursors1A43( ) ;
   }

   public void update1A43( )
   {
      beforeValidate1A43( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1A43( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1A43( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1A43( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1A43( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001A13 */
                  pr_default.execute(11, new Object[] {A675SecDescripSinAc, A329SecDescrip, Boolean.valueOf(A330SecHabilitada), Integer.valueOf(A1984SecRelSec), Integer.valueOf(A1985SecRelSecCli), A1986SecPadre, A2015SecRelRef, A2033SecOld, Boolean.valueOf(A2308SecApoOpc), Integer.valueOf(A3CliCod), A13SecCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Seccion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1A43( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1A43( ) ;
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
         endLevel1A43( ) ;
      }
      closeExtendedTableCursors1A43( ) ;
   }

   public void deferredUpdate1A43( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1A43( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1A43( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1A43( ) ;
         afterConfirm1A43( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1A43( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart1A153( ) ;
               while ( RcdFound153 != 0 )
               {
                  getByPrimaryKey1A153( ) ;
                  delete1A153( ) ;
                  scanKeyNext1A153( ) ;
               }
               scanKeyEnd1A153( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001A14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
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
      sMode43 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1A43( ) ;
      Gx_mode = sMode43 ;
   }

   public void onDeleteControls1A43( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV17Pgmname = "Seccion_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC001A15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionArea", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor BC001A16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")+" ("+httpContext.getMessage( "Legajo Seccion", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor BC001A17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor BC001A18 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void processNestedLevel1A153( )
   {
      nGXsfl_153_idx = 0 ;
      while ( nGXsfl_153_idx < bcSeccion.getgxTv_SdtSeccion_Puestos().size() )
      {
         readRow1A153( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound153 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_153 != 0 ) )
         {
            standaloneNotModal1A153( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert1A153( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete1A153( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update1A153( ) ;
               }
            }
         }
         KeyVarsToRow153( ((web.SdtSeccion_Puestos)bcSeccion.getgxTv_SdtSeccion_Puestos().elementAt(-1+nGXsfl_153_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_153_idx = 0 ;
         while ( nGXsfl_153_idx < bcSeccion.getgxTv_SdtSeccion_Puestos().size() )
         {
            readRow1A153( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound153 == 0 )
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
               bcSeccion.getgxTv_SdtSeccion_Puestos().removeElement(nGXsfl_153_idx);
               nGXsfl_153_idx = (int)(nGXsfl_153_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey1A153( ) ;
               VarsToRow153( ((web.SdtSeccion_Puestos)bcSeccion.getgxTv_SdtSeccion_Puestos().elementAt(-1+nGXsfl_153_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll1A153( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_153 = (short)(0) ;
      nIsMod_153 = (short)(0) ;
      Gxremove153 = (byte)(0) ;
   }

   public void processLevel1A43( )
   {
      /* Save parent mode. */
      sMode43 = Gx_mode ;
      processNestedLevel1A153( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode43 ;
      /* ' Update level parameters */
   }

   public void endLevel1A43( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1A43( ) ;
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

   public void scanKeyStart1A43( )
   {
      /* Scan By routine */
      /* Using cursor BC001A19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      RcdFound43 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A675SecDescripSinAc = BC001A19_A675SecDescripSinAc[0] ;
         A13SecCodigo = BC001A19_A13SecCodigo[0] ;
         A329SecDescrip = BC001A19_A329SecDescrip[0] ;
         A330SecHabilitada = BC001A19_A330SecHabilitada[0] ;
         A1984SecRelSec = BC001A19_A1984SecRelSec[0] ;
         A1985SecRelSecCli = BC001A19_A1985SecRelSecCli[0] ;
         A1986SecPadre = BC001A19_A1986SecPadre[0] ;
         A2015SecRelRef = BC001A19_A2015SecRelRef[0] ;
         A2033SecOld = BC001A19_A2033SecOld[0] ;
         A2308SecApoOpc = BC001A19_A2308SecApoOpc[0] ;
         A3CliCod = BC001A19_A3CliCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1A43( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound43 = (short)(0) ;
      scanKeyLoad1A43( ) ;
   }

   public void scanKeyLoad1A43( )
   {
      sMode43 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound43 = (short)(1) ;
         A675SecDescripSinAc = BC001A19_A675SecDescripSinAc[0] ;
         A13SecCodigo = BC001A19_A13SecCodigo[0] ;
         A329SecDescrip = BC001A19_A329SecDescrip[0] ;
         A330SecHabilitada = BC001A19_A330SecHabilitada[0] ;
         A1984SecRelSec = BC001A19_A1984SecRelSec[0] ;
         A1985SecRelSecCli = BC001A19_A1985SecRelSecCli[0] ;
         A1986SecPadre = BC001A19_A1986SecPadre[0] ;
         A2015SecRelRef = BC001A19_A2015SecRelRef[0] ;
         A2033SecOld = BC001A19_A2033SecOld[0] ;
         A2308SecApoOpc = BC001A19_A2308SecApoOpc[0] ;
         A3CliCod = BC001A19_A3CliCod[0] ;
      }
      Gx_mode = sMode43 ;
   }

   public void scanKeyEnd1A43( )
   {
      pr_default.close(17);
   }

   public void afterConfirm1A43( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1A43( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1A43( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1A43( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1A43( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1A43( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1A43( )
   {
   }

   public void zm1A153( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z1242PuestoDescripSinAc = A1242PuestoDescripSinAc ;
         Z1241PuestoDescrip = A1241PuestoDescrip ;
         Z1255PuestoHorasExt = A1255PuestoHorasExt ;
         Z1987PuestoRelSec = A1987PuestoRelSec ;
         Z1988PuestoRelSecCli = A1988PuestoRelSecCli ;
         Z1989PuestoPadre = A1989PuestoPadre ;
         Z2016PuestoRelRef = A2016PuestoRelRef ;
      }
      if ( GX_JID == -9 )
      {
         Z1242PuestoDescripSinAc = A1242PuestoDescripSinAc ;
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
         Z1240PuestoCodigo = A1240PuestoCodigo ;
         Z1241PuestoDescrip = A1241PuestoDescrip ;
         Z1255PuestoHorasExt = A1255PuestoHorasExt ;
         Z1987PuestoRelSec = A1987PuestoRelSec ;
         Z1988PuestoRelSecCli = A1988PuestoRelSecCli ;
         Z1989PuestoPadre = A1989PuestoPadre ;
         Z2016PuestoRelRef = A2016PuestoRelRef ;
         Z2034PuestoOld = A2034PuestoOld ;
      }
   }

   public void standaloneNotModal1A153( )
   {
   }

   public void standaloneModal1A153( )
   {
   }

   public void load1A153( )
   {
      /* Using cursor BC001A20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A1242PuestoDescripSinAc = BC001A20_A1242PuestoDescripSinAc[0] ;
         A1241PuestoDescrip = BC001A20_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = BC001A20_A1255PuestoHorasExt[0] ;
         A1987PuestoRelSec = BC001A20_A1987PuestoRelSec[0] ;
         A1988PuestoRelSecCli = BC001A20_A1988PuestoRelSecCli[0] ;
         A1989PuestoPadre = BC001A20_A1989PuestoPadre[0] ;
         A2016PuestoRelRef = BC001A20_A2016PuestoRelRef[0] ;
         A2034PuestoOld = BC001A20_A2034PuestoOld[0] ;
         zm1A153( -9) ;
      }
      pr_default.close(18);
      onLoadActions1A153( ) ;
   }

   public void onLoadActions1A153( )
   {
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char7) ;
      seccion_bc.this.GXt_char6 = GXv_char7[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
   }

   public void checkExtendedTable1A153( )
   {
      nIsDirty_153 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal1A153( ) ;
      Gx_BScreen = (byte)(0) ;
      nIsDirty_153 = (short)(1) ;
      GXt_char6 = A1242PuestoDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A1241PuestoDescrip, GXv_char7) ;
      seccion_bc.this.GXt_char6 = GXv_char7[0] ;
      A1242PuestoDescripSinAc = GXt_char6 ;
   }

   public void closeExtendedTableCursors1A153( )
   {
   }

   public void enableDisable1A153( )
   {
   }

   public void getKey1A153( )
   {
      /* Using cursor BC001A21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound153 = (short)(1) ;
      }
      else
      {
         RcdFound153 = (short)(0) ;
      }
      pr_default.close(19);
   }

   public void getByPrimaryKey1A153( )
   {
      /* Using cursor BC001A22 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
      if ( (pr_default.getStatus(20) != 101) )
      {
         zm1A153( 9) ;
         RcdFound153 = (short)(1) ;
         initializeNonKey1A153( ) ;
         A1242PuestoDescripSinAc = BC001A22_A1242PuestoDescripSinAc[0] ;
         A1240PuestoCodigo = BC001A22_A1240PuestoCodigo[0] ;
         A1241PuestoDescrip = BC001A22_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = BC001A22_A1255PuestoHorasExt[0] ;
         A1987PuestoRelSec = BC001A22_A1987PuestoRelSec[0] ;
         A1988PuestoRelSecCli = BC001A22_A1988PuestoRelSecCli[0] ;
         A1989PuestoPadre = BC001A22_A1989PuestoPadre[0] ;
         A2016PuestoRelRef = BC001A22_A2016PuestoRelRef[0] ;
         A2034PuestoOld = BC001A22_A2034PuestoOld[0] ;
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
         Z1240PuestoCodigo = A1240PuestoCodigo ;
         sMode153 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal1A153( ) ;
         load1A153( ) ;
         Gx_mode = sMode153 ;
      }
      else
      {
         RcdFound153 = (short)(0) ;
         initializeNonKey1A153( ) ;
         sMode153 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal1A153( ) ;
         Gx_mode = sMode153 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes1A153( ) ;
      }
      pr_default.close(20);
   }

   public void checkOptimisticConcurrency1A153( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001A23 */
         pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(21) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Puesto"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(21) == 101) || ( GXutil.strcmp(Z1242PuestoDescripSinAc, BC001A23_A1242PuestoDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z1241PuestoDescrip, BC001A23_A1241PuestoDescrip[0]) != 0 ) || ( Z1255PuestoHorasExt != BC001A23_A1255PuestoHorasExt[0] ) || ( Z1987PuestoRelSec != BC001A23_A1987PuestoRelSec[0] ) || ( Z1988PuestoRelSecCli != BC001A23_A1988PuestoRelSecCli[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1989PuestoPadre, BC001A23_A1989PuestoPadre[0]) != 0 ) || ( GXutil.strcmp(Z2016PuestoRelRef, BC001A23_A2016PuestoRelRef[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Puesto"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1A153( )
   {
      beforeValidate1A153( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1A153( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1A153( 0) ;
         checkOptimisticConcurrency1A153( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1A153( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1A153( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001A24 */
                  pr_default.execute(22, new Object[] {A1242PuestoDescripSinAc, Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo, A1241PuestoDescrip, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
                  if ( (pr_default.getStatus(22) == 1) )
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
            load1A153( ) ;
         }
         endLevel1A153( ) ;
      }
      closeExtendedTableCursors1A153( ) ;
   }

   public void update1A153( )
   {
      beforeValidate1A153( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1A153( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1A153( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1A153( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1A153( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001A25 */
                  pr_default.execute(23, new Object[] {A1242PuestoDescripSinAc, A1241PuestoDescrip, Boolean.valueOf(A1255PuestoHorasExt), Integer.valueOf(A1987PuestoRelSec), Integer.valueOf(A1988PuestoRelSecCli), A1989PuestoPadre, A2016PuestoRelRef, A2034PuestoOld, Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
                  if ( (pr_default.getStatus(23) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Puesto"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1A153( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey1A153( ) ;
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
         endLevel1A153( ) ;
      }
      closeExtendedTableCursors1A153( ) ;
   }

   public void deferredUpdate1A153( )
   {
   }

   public void delete1A153( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1A153( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1A153( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1A153( ) ;
         afterConfirm1A153( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1A153( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001A26 */
               pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Puesto");
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
      sMode153 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1A153( ) ;
      Gx_mode = sMode153 ;
   }

   public void onDeleteControls1A153( )
   {
      standaloneModal1A153( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC001A27 */
         pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(25) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionPuesto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(25);
         /* Using cursor BC001A28 */
         pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo, A1240PuestoCodigo});
         if ( (pr_default.getStatus(26) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(26);
      }
   }

   public void endLevel1A153( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(21);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart1A153( )
   {
      /* Scan By routine */
      /* Using cursor BC001A29 */
      pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), A13SecCodigo});
      RcdFound153 = (short)(0) ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A1242PuestoDescripSinAc = BC001A29_A1242PuestoDescripSinAc[0] ;
         A1240PuestoCodigo = BC001A29_A1240PuestoCodigo[0] ;
         A1241PuestoDescrip = BC001A29_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = BC001A29_A1255PuestoHorasExt[0] ;
         A1987PuestoRelSec = BC001A29_A1987PuestoRelSec[0] ;
         A1988PuestoRelSecCli = BC001A29_A1988PuestoRelSecCli[0] ;
         A1989PuestoPadre = BC001A29_A1989PuestoPadre[0] ;
         A2016PuestoRelRef = BC001A29_A2016PuestoRelRef[0] ;
         A2034PuestoOld = BC001A29_A2034PuestoOld[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1A153( )
   {
      /* Scan next routine */
      pr_default.readNext(27);
      RcdFound153 = (short)(0) ;
      scanKeyLoad1A153( ) ;
   }

   public void scanKeyLoad1A153( )
   {
      sMode153 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound153 = (short)(1) ;
         A1242PuestoDescripSinAc = BC001A29_A1242PuestoDescripSinAc[0] ;
         A1240PuestoCodigo = BC001A29_A1240PuestoCodigo[0] ;
         A1241PuestoDescrip = BC001A29_A1241PuestoDescrip[0] ;
         A1255PuestoHorasExt = BC001A29_A1255PuestoHorasExt[0] ;
         A1987PuestoRelSec = BC001A29_A1987PuestoRelSec[0] ;
         A1988PuestoRelSecCli = BC001A29_A1988PuestoRelSecCli[0] ;
         A1989PuestoPadre = BC001A29_A1989PuestoPadre[0] ;
         A2016PuestoRelRef = BC001A29_A2016PuestoRelRef[0] ;
         A2034PuestoOld = BC001A29_A2034PuestoOld[0] ;
      }
      Gx_mode = sMode153 ;
   }

   public void scanKeyEnd1A153( )
   {
      pr_default.close(27);
   }

   public void afterConfirm1A153( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1A153( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1A153( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1A153( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1A153( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1A153( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1A153( )
   {
   }

   public void send_integrity_lvl_hashes1A153( )
   {
   }

   public void send_integrity_lvl_hashes1A43( )
   {
   }

   public void addRow1A43( )
   {
      VarsToRow43( bcSeccion) ;
   }

   public void readRow1A43( )
   {
      RowToVars43( bcSeccion, 1) ;
   }

   public void addRow1A153( )
   {
      web.SdtSeccion_Puestos obj153;
      obj153 = new web.SdtSeccion_Puestos(remoteHandle);
      VarsToRow153( obj153) ;
      bcSeccion.getgxTv_SdtSeccion_Puestos().add(obj153, 0);
      obj153.setgxTv_SdtSeccion_Puestos_Mode( "UPD" );
      obj153.setgxTv_SdtSeccion_Puestos_Modified( (short)(0) );
   }

   public void readRow1A153( )
   {
      nGXsfl_153_idx = (int)(nGXsfl_153_idx+1) ;
      RowToVars153( ((web.SdtSeccion_Puestos)bcSeccion.getgxTv_SdtSeccion_Puestos().elementAt(-1+nGXsfl_153_idx)), 1) ;
   }

   public void initializeNonKey1A43( )
   {
      A675SecDescripSinAc = "" ;
      A329SecDescrip = "" ;
      A1984SecRelSec = 0 ;
      A1985SecRelSecCli = 0 ;
      A1986SecPadre = "" ;
      A2015SecRelRef = "" ;
      A2033SecOld = "" ;
      A2308SecApoOpc = false ;
      A330SecHabilitada = true ;
      Z675SecDescripSinAc = "" ;
      Z329SecDescrip = "" ;
      Z330SecHabilitada = false ;
      Z1984SecRelSec = 0 ;
      Z1985SecRelSecCli = 0 ;
      Z1986SecPadre = "" ;
      Z2015SecRelRef = "" ;
      Z2308SecApoOpc = false ;
   }

   public void initAll1A43( )
   {
      A3CliCod = 0 ;
      A13SecCodigo = "" ;
      initializeNonKey1A43( ) ;
   }

   public void standaloneModalInsert( )
   {
      A330SecHabilitada = i330SecHabilitada ;
   }

   public void initializeNonKey1A153( )
   {
      A1242PuestoDescripSinAc = "" ;
      A1241PuestoDescrip = "" ;
      A1255PuestoHorasExt = false ;
      A1987PuestoRelSec = 0 ;
      A1988PuestoRelSecCli = 0 ;
      A1989PuestoPadre = "" ;
      A2016PuestoRelRef = "" ;
      A2034PuestoOld = "" ;
      Z1242PuestoDescripSinAc = "" ;
      Z1241PuestoDescrip = "" ;
      Z1255PuestoHorasExt = false ;
      Z1987PuestoRelSec = 0 ;
      Z1988PuestoRelSecCli = 0 ;
      Z1989PuestoPadre = "" ;
      Z2016PuestoRelRef = "" ;
   }

   public void initAll1A153( )
   {
      A1240PuestoCodigo = "" ;
      initializeNonKey1A153( ) ;
   }

   public void standaloneModalInsert1A153( )
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

   public void VarsToRow43( web.SdtSeccion obj43 )
   {
      obj43.setgxTv_SdtSeccion_Mode( Gx_mode );
      obj43.setgxTv_SdtSeccion_Secdescripsinac( A675SecDescripSinAc );
      obj43.setgxTv_SdtSeccion_Secdescrip( A329SecDescrip );
      obj43.setgxTv_SdtSeccion_Secrelsec( A1984SecRelSec );
      obj43.setgxTv_SdtSeccion_Secrelseccli( A1985SecRelSecCli );
      obj43.setgxTv_SdtSeccion_Secpadre( A1986SecPadre );
      obj43.setgxTv_SdtSeccion_Secrelref( A2015SecRelRef );
      obj43.setgxTv_SdtSeccion_Secold( A2033SecOld );
      obj43.setgxTv_SdtSeccion_Secapoopc( A2308SecApoOpc );
      obj43.setgxTv_SdtSeccion_Sechabilitada( A330SecHabilitada );
      obj43.setgxTv_SdtSeccion_Clicod( A3CliCod );
      obj43.setgxTv_SdtSeccion_Seccodigo( A13SecCodigo );
      obj43.setgxTv_SdtSeccion_Clicod_Z( Z3CliCod );
      obj43.setgxTv_SdtSeccion_Seccodigo_Z( Z13SecCodigo );
      obj43.setgxTv_SdtSeccion_Secdescrip_Z( Z329SecDescrip );
      obj43.setgxTv_SdtSeccion_Sechabilitada_Z( Z330SecHabilitada );
      obj43.setgxTv_SdtSeccion_Secdescripsinac_Z( Z675SecDescripSinAc );
      obj43.setgxTv_SdtSeccion_Secrelsec_Z( Z1984SecRelSec );
      obj43.setgxTv_SdtSeccion_Secrelseccli_Z( Z1985SecRelSecCli );
      obj43.setgxTv_SdtSeccion_Secpadre_Z( Z1986SecPadre );
      obj43.setgxTv_SdtSeccion_Secrelref_Z( Z2015SecRelRef );
      obj43.setgxTv_SdtSeccion_Secapoopc_Z( Z2308SecApoOpc );
      obj43.setgxTv_SdtSeccion_Mode( Gx_mode );
   }

   public void KeyVarsToRow43( web.SdtSeccion obj43 )
   {
      obj43.setgxTv_SdtSeccion_Clicod( A3CliCod );
      obj43.setgxTv_SdtSeccion_Seccodigo( A13SecCodigo );
   }

   public void RowToVars43( web.SdtSeccion obj43 ,
                            int forceLoad )
   {
      Gx_mode = obj43.getgxTv_SdtSeccion_Mode() ;
      A675SecDescripSinAc = obj43.getgxTv_SdtSeccion_Secdescripsinac() ;
      A329SecDescrip = obj43.getgxTv_SdtSeccion_Secdescrip() ;
      A1984SecRelSec = obj43.getgxTv_SdtSeccion_Secrelsec() ;
      A1985SecRelSecCli = obj43.getgxTv_SdtSeccion_Secrelseccli() ;
      A1986SecPadre = obj43.getgxTv_SdtSeccion_Secpadre() ;
      A2015SecRelRef = obj43.getgxTv_SdtSeccion_Secrelref() ;
      A2033SecOld = obj43.getgxTv_SdtSeccion_Secold() ;
      A2308SecApoOpc = obj43.getgxTv_SdtSeccion_Secapoopc() ;
      A330SecHabilitada = obj43.getgxTv_SdtSeccion_Sechabilitada() ;
      A3CliCod = obj43.getgxTv_SdtSeccion_Clicod() ;
      A13SecCodigo = obj43.getgxTv_SdtSeccion_Seccodigo() ;
      Z3CliCod = obj43.getgxTv_SdtSeccion_Clicod_Z() ;
      Z13SecCodigo = obj43.getgxTv_SdtSeccion_Seccodigo_Z() ;
      Z329SecDescrip = obj43.getgxTv_SdtSeccion_Secdescrip_Z() ;
      Z330SecHabilitada = obj43.getgxTv_SdtSeccion_Sechabilitada_Z() ;
      Z675SecDescripSinAc = obj43.getgxTv_SdtSeccion_Secdescripsinac_Z() ;
      Z1984SecRelSec = obj43.getgxTv_SdtSeccion_Secrelsec_Z() ;
      Z1985SecRelSecCli = obj43.getgxTv_SdtSeccion_Secrelseccli_Z() ;
      Z1986SecPadre = obj43.getgxTv_SdtSeccion_Secpadre_Z() ;
      Z2015SecRelRef = obj43.getgxTv_SdtSeccion_Secrelref_Z() ;
      Z2308SecApoOpc = obj43.getgxTv_SdtSeccion_Secapoopc_Z() ;
      Gx_mode = obj43.getgxTv_SdtSeccion_Mode() ;
   }

   public void VarsToRow153( web.SdtSeccion_Puestos obj153 )
   {
      obj153.setgxTv_SdtSeccion_Puestos_Mode( Gx_mode );
      obj153.setgxTv_SdtSeccion_Puestos_Puestodescripsinac( A1242PuestoDescripSinAc );
      obj153.setgxTv_SdtSeccion_Puestos_Puestodescrip( A1241PuestoDescrip );
      obj153.setgxTv_SdtSeccion_Puestos_Puestohorasext( A1255PuestoHorasExt );
      obj153.setgxTv_SdtSeccion_Puestos_Puestorelsec( A1987PuestoRelSec );
      obj153.setgxTv_SdtSeccion_Puestos_Puestorelseccli( A1988PuestoRelSecCli );
      obj153.setgxTv_SdtSeccion_Puestos_Puestopadre( A1989PuestoPadre );
      obj153.setgxTv_SdtSeccion_Puestos_Puestorelref( A2016PuestoRelRef );
      obj153.setgxTv_SdtSeccion_Puestos_Puestoold( A2034PuestoOld );
      obj153.setgxTv_SdtSeccion_Puestos_Puestocodigo( A1240PuestoCodigo );
      obj153.setgxTv_SdtSeccion_Puestos_Puestocodigo_Z( Z1240PuestoCodigo );
      obj153.setgxTv_SdtSeccion_Puestos_Puestodescrip_Z( Z1241PuestoDescrip );
      obj153.setgxTv_SdtSeccion_Puestos_Puestodescripsinac_Z( Z1242PuestoDescripSinAc );
      obj153.setgxTv_SdtSeccion_Puestos_Puestohorasext_Z( Z1255PuestoHorasExt );
      obj153.setgxTv_SdtSeccion_Puestos_Puestorelsec_Z( Z1987PuestoRelSec );
      obj153.setgxTv_SdtSeccion_Puestos_Puestorelseccli_Z( Z1988PuestoRelSecCli );
      obj153.setgxTv_SdtSeccion_Puestos_Puestopadre_Z( Z1989PuestoPadre );
      obj153.setgxTv_SdtSeccion_Puestos_Puestorelref_Z( Z2016PuestoRelRef );
      obj153.setgxTv_SdtSeccion_Puestos_Modified( nIsMod_153 );
   }

   public void KeyVarsToRow153( web.SdtSeccion_Puestos obj153 )
   {
      obj153.setgxTv_SdtSeccion_Puestos_Puestocodigo( A1240PuestoCodigo );
   }

   public void RowToVars153( web.SdtSeccion_Puestos obj153 ,
                             int forceLoad )
   {
      Gx_mode = obj153.getgxTv_SdtSeccion_Puestos_Mode() ;
      A1242PuestoDescripSinAc = obj153.getgxTv_SdtSeccion_Puestos_Puestodescripsinac() ;
      A1241PuestoDescrip = obj153.getgxTv_SdtSeccion_Puestos_Puestodescrip() ;
      A1255PuestoHorasExt = obj153.getgxTv_SdtSeccion_Puestos_Puestohorasext() ;
      A1987PuestoRelSec = obj153.getgxTv_SdtSeccion_Puestos_Puestorelsec() ;
      A1988PuestoRelSecCli = obj153.getgxTv_SdtSeccion_Puestos_Puestorelseccli() ;
      A1989PuestoPadre = obj153.getgxTv_SdtSeccion_Puestos_Puestopadre() ;
      A2016PuestoRelRef = obj153.getgxTv_SdtSeccion_Puestos_Puestorelref() ;
      A2034PuestoOld = obj153.getgxTv_SdtSeccion_Puestos_Puestoold() ;
      A1240PuestoCodigo = obj153.getgxTv_SdtSeccion_Puestos_Puestocodigo() ;
      Z1240PuestoCodigo = obj153.getgxTv_SdtSeccion_Puestos_Puestocodigo_Z() ;
      Z1241PuestoDescrip = obj153.getgxTv_SdtSeccion_Puestos_Puestodescrip_Z() ;
      Z1242PuestoDescripSinAc = obj153.getgxTv_SdtSeccion_Puestos_Puestodescripsinac_Z() ;
      Z1255PuestoHorasExt = obj153.getgxTv_SdtSeccion_Puestos_Puestohorasext_Z() ;
      Z1987PuestoRelSec = obj153.getgxTv_SdtSeccion_Puestos_Puestorelsec_Z() ;
      Z1988PuestoRelSecCli = obj153.getgxTv_SdtSeccion_Puestos_Puestorelseccli_Z() ;
      Z1989PuestoPadre = obj153.getgxTv_SdtSeccion_Puestos_Puestopadre_Z() ;
      Z2016PuestoRelRef = obj153.getgxTv_SdtSeccion_Puestos_Puestorelref_Z() ;
      nIsMod_153 = obj153.getgxTv_SdtSeccion_Puestos_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A13SecCodigo = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1A43( ) ;
      scanKeyStart1A43( ) ;
      if ( RcdFound43 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001A30 */
         pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(28) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(28);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z13SecCodigo = A13SecCodigo ;
      }
      zm1A43( -7) ;
      onLoadActions1A43( ) ;
      addRow1A43( ) ;
      bcSeccion.getgxTv_SdtSeccion_Puestos().clearCollection();
      if ( RcdFound43 == 1 )
      {
         scanKeyStart1A153( ) ;
         nGXsfl_153_idx = 1 ;
         while ( RcdFound153 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z13SecCodigo = A13SecCodigo ;
            Z1240PuestoCodigo = A1240PuestoCodigo ;
            zm1A153( -9) ;
            onLoadActions1A153( ) ;
            nRcdExists_153 = (short)(1) ;
            nIsMod_153 = (short)(0) ;
            addRow1A153( ) ;
            nGXsfl_153_idx = (int)(nGXsfl_153_idx+1) ;
            scanKeyNext1A153( ) ;
         }
         scanKeyEnd1A153( ) ;
      }
      scanKeyEnd1A43( ) ;
      if ( RcdFound43 == 0 )
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
      RowToVars43( bcSeccion, 0) ;
      scanKeyStart1A43( ) ;
      if ( RcdFound43 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001A31 */
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
         Z13SecCodigo = A13SecCodigo ;
      }
      zm1A43( -7) ;
      onLoadActions1A43( ) ;
      addRow1A43( ) ;
      bcSeccion.getgxTv_SdtSeccion_Puestos().clearCollection();
      if ( RcdFound43 == 1 )
      {
         scanKeyStart1A153( ) ;
         nGXsfl_153_idx = 1 ;
         while ( RcdFound153 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z13SecCodigo = A13SecCodigo ;
            Z1240PuestoCodigo = A1240PuestoCodigo ;
            zm1A153( -9) ;
            onLoadActions1A153( ) ;
            nRcdExists_153 = (short)(1) ;
            nIsMod_153 = (short)(0) ;
            addRow1A153( ) ;
            nGXsfl_153_idx = (int)(nGXsfl_153_idx+1) ;
            scanKeyNext1A153( ) ;
         }
         scanKeyEnd1A153( ) ;
      }
      scanKeyEnd1A43( ) ;
      if ( RcdFound43 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1A43( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1A43( ) ;
      }
      else
      {
         if ( RcdFound43 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A13SecCodigo = Z13SecCodigo ;
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
               update1A43( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) )
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
                     insert1A43( ) ;
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
                     insert1A43( ) ;
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
      RowToVars43( bcSeccion, 1) ;
      saveImpl( ) ;
      VarsToRow43( bcSeccion) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars43( bcSeccion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1A43( ) ;
      afterTrn( ) ;
      VarsToRow43( bcSeccion) ;
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
         web.SdtSeccion auxBC = new web.SdtSeccion( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A13SecCodigo);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcSeccion);
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
      RowToVars43( bcSeccion, 1) ;
      updateImpl( ) ;
      VarsToRow43( bcSeccion) ;
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
      RowToVars43( bcSeccion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1A43( ) ;
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
      VarsToRow43( bcSeccion) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars43( bcSeccion, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1A43( ) ;
      if ( RcdFound43 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A13SecCodigo = Z13SecCodigo ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A13SecCodigo, Z13SecCodigo) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "seccion_bc");
      VarsToRow43( bcSeccion) ;
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
      Gx_mode = bcSeccion.getgxTv_SdtSeccion_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcSeccion.setgxTv_SdtSeccion_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtSeccion sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcSeccion )
      {
         bcSeccion = sdt ;
         if ( GXutil.strcmp(bcSeccion.getgxTv_SdtSeccion_Mode(), "") == 0 )
         {
            bcSeccion.setgxTv_SdtSeccion_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow43( bcSeccion) ;
         }
         else
         {
            RowToVars43( bcSeccion, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcSeccion.getgxTv_SdtSeccion_Mode(), "") == 0 )
         {
            bcSeccion.setgxTv_SdtSeccion_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars43( bcSeccion, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtSeccion getSeccion_BC( )
   {
      return bcSeccion ;
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
      Z13SecCodigo = "" ;
      A13SecCodigo = "" ;
      sMode43 = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV17Pgmname = "" ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      Z675SecDescripSinAc = "" ;
      A675SecDescripSinAc = "" ;
      Z329SecDescrip = "" ;
      A329SecDescrip = "" ;
      Z1986SecPadre = "" ;
      A1986SecPadre = "" ;
      Z2015SecRelRef = "" ;
      A2015SecRelRef = "" ;
      Z2033SecOld = "" ;
      A2033SecOld = "" ;
      GXv_int5 = new int[1] ;
      BC001A7_A675SecDescripSinAc = new String[] {""} ;
      BC001A7_A13SecCodigo = new String[] {""} ;
      BC001A7_A329SecDescrip = new String[] {""} ;
      BC001A7_A330SecHabilitada = new boolean[] {false} ;
      BC001A7_A1984SecRelSec = new int[1] ;
      BC001A7_A1985SecRelSecCli = new int[1] ;
      BC001A7_A1986SecPadre = new String[] {""} ;
      BC001A7_A2015SecRelRef = new String[] {""} ;
      BC001A7_A2033SecOld = new String[] {""} ;
      BC001A7_A2308SecApoOpc = new boolean[] {false} ;
      BC001A7_A3CliCod = new int[1] ;
      BC001A8_A3CliCod = new int[1] ;
      BC001A9_A3CliCod = new int[1] ;
      BC001A9_A13SecCodigo = new String[] {""} ;
      BC001A10_A675SecDescripSinAc = new String[] {""} ;
      BC001A10_A13SecCodigo = new String[] {""} ;
      BC001A10_A329SecDescrip = new String[] {""} ;
      BC001A10_A330SecHabilitada = new boolean[] {false} ;
      BC001A10_A1984SecRelSec = new int[1] ;
      BC001A10_A1985SecRelSecCli = new int[1] ;
      BC001A10_A1986SecPadre = new String[] {""} ;
      BC001A10_A2015SecRelRef = new String[] {""} ;
      BC001A10_A2033SecOld = new String[] {""} ;
      BC001A10_A2308SecApoOpc = new boolean[] {false} ;
      BC001A10_A3CliCod = new int[1] ;
      BC001A11_A675SecDescripSinAc = new String[] {""} ;
      BC001A11_A13SecCodigo = new String[] {""} ;
      BC001A11_A329SecDescrip = new String[] {""} ;
      BC001A11_A330SecHabilitada = new boolean[] {false} ;
      BC001A11_A1984SecRelSec = new int[1] ;
      BC001A11_A1985SecRelSecCli = new int[1] ;
      BC001A11_A1986SecPadre = new String[] {""} ;
      BC001A11_A2015SecRelRef = new String[] {""} ;
      BC001A11_A2033SecOld = new String[] {""} ;
      BC001A11_A2308SecApoOpc = new boolean[] {false} ;
      BC001A11_A3CliCod = new int[1] ;
      BC001A15_A3CliCod = new int[1] ;
      BC001A15_A1EmpCod = new short[1] ;
      BC001A15_A31LiqNro = new int[1] ;
      BC001A15_A2145LiqArea = new String[] {""} ;
      BC001A16_A3CliCod = new int[1] ;
      BC001A16_A1EmpCod = new short[1] ;
      BC001A16_A6LegNumero = new int[1] ;
      BC001A17_A3CliCod = new int[1] ;
      BC001A17_A1EmpCod = new short[1] ;
      BC001A17_A31LiqNro = new int[1] ;
      BC001A17_A6LegNumero = new int[1] ;
      BC001A18_A3CliCod = new int[1] ;
      BC001A18_A1EmpCod = new short[1] ;
      BC001A18_A6LegNumero = new int[1] ;
      BC001A19_A675SecDescripSinAc = new String[] {""} ;
      BC001A19_A13SecCodigo = new String[] {""} ;
      BC001A19_A329SecDescrip = new String[] {""} ;
      BC001A19_A330SecHabilitada = new boolean[] {false} ;
      BC001A19_A1984SecRelSec = new int[1] ;
      BC001A19_A1985SecRelSecCli = new int[1] ;
      BC001A19_A1986SecPadre = new String[] {""} ;
      BC001A19_A2015SecRelRef = new String[] {""} ;
      BC001A19_A2033SecOld = new String[] {""} ;
      BC001A19_A2308SecApoOpc = new boolean[] {false} ;
      BC001A19_A3CliCod = new int[1] ;
      Z1242PuestoDescripSinAc = "" ;
      A1242PuestoDescripSinAc = "" ;
      Z1241PuestoDescrip = "" ;
      A1241PuestoDescrip = "" ;
      Z1989PuestoPadre = "" ;
      A1989PuestoPadre = "" ;
      Z2016PuestoRelRef = "" ;
      A2016PuestoRelRef = "" ;
      Z1240PuestoCodigo = "" ;
      A1240PuestoCodigo = "" ;
      Z2034PuestoOld = "" ;
      A2034PuestoOld = "" ;
      BC001A20_A1242PuestoDescripSinAc = new String[] {""} ;
      BC001A20_A3CliCod = new int[1] ;
      BC001A20_A13SecCodigo = new String[] {""} ;
      BC001A20_A1240PuestoCodigo = new String[] {""} ;
      BC001A20_A1241PuestoDescrip = new String[] {""} ;
      BC001A20_A1255PuestoHorasExt = new boolean[] {false} ;
      BC001A20_A1987PuestoRelSec = new int[1] ;
      BC001A20_A1988PuestoRelSecCli = new int[1] ;
      BC001A20_A1989PuestoPadre = new String[] {""} ;
      BC001A20_A2016PuestoRelRef = new String[] {""} ;
      BC001A20_A2034PuestoOld = new String[] {""} ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      BC001A21_A3CliCod = new int[1] ;
      BC001A21_A13SecCodigo = new String[] {""} ;
      BC001A21_A1240PuestoCodigo = new String[] {""} ;
      BC001A22_A1242PuestoDescripSinAc = new String[] {""} ;
      BC001A22_A3CliCod = new int[1] ;
      BC001A22_A13SecCodigo = new String[] {""} ;
      BC001A22_A1240PuestoCodigo = new String[] {""} ;
      BC001A22_A1241PuestoDescrip = new String[] {""} ;
      BC001A22_A1255PuestoHorasExt = new boolean[] {false} ;
      BC001A22_A1987PuestoRelSec = new int[1] ;
      BC001A22_A1988PuestoRelSecCli = new int[1] ;
      BC001A22_A1989PuestoPadre = new String[] {""} ;
      BC001A22_A2016PuestoRelRef = new String[] {""} ;
      BC001A22_A2034PuestoOld = new String[] {""} ;
      sMode153 = "" ;
      BC001A23_A1242PuestoDescripSinAc = new String[] {""} ;
      BC001A23_A3CliCod = new int[1] ;
      BC001A23_A13SecCodigo = new String[] {""} ;
      BC001A23_A1240PuestoCodigo = new String[] {""} ;
      BC001A23_A1241PuestoDescrip = new String[] {""} ;
      BC001A23_A1255PuestoHorasExt = new boolean[] {false} ;
      BC001A23_A1987PuestoRelSec = new int[1] ;
      BC001A23_A1988PuestoRelSecCli = new int[1] ;
      BC001A23_A1989PuestoPadre = new String[] {""} ;
      BC001A23_A2016PuestoRelRef = new String[] {""} ;
      BC001A23_A2034PuestoOld = new String[] {""} ;
      BC001A27_A3CliCod = new int[1] ;
      BC001A27_A1EmpCod = new short[1] ;
      BC001A27_A31LiqNro = new int[1] ;
      BC001A27_A2145LiqArea = new String[] {""} ;
      BC001A27_A2146LiqPuesto = new String[] {""} ;
      BC001A28_A3CliCod = new int[1] ;
      BC001A28_A1EmpCod = new short[1] ;
      BC001A28_A6LegNumero = new int[1] ;
      BC001A29_A1242PuestoDescripSinAc = new String[] {""} ;
      BC001A29_A3CliCod = new int[1] ;
      BC001A29_A13SecCodigo = new String[] {""} ;
      BC001A29_A1240PuestoCodigo = new String[] {""} ;
      BC001A29_A1241PuestoDescrip = new String[] {""} ;
      BC001A29_A1255PuestoHorasExt = new boolean[] {false} ;
      BC001A29_A1987PuestoRelSec = new int[1] ;
      BC001A29_A1988PuestoRelSecCli = new int[1] ;
      BC001A29_A1989PuestoPadre = new String[] {""} ;
      BC001A29_A2016PuestoRelRef = new String[] {""} ;
      BC001A29_A2034PuestoOld = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001A30_A3CliCod = new int[1] ;
      BC001A31_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.seccion_bc__default(),
         new Object[] {
             new Object[] {
            BC001A2_A1242PuestoDescripSinAc, BC001A2_A3CliCod, BC001A2_A13SecCodigo, BC001A2_A1240PuestoCodigo, BC001A2_A1241PuestoDescrip, BC001A2_A1255PuestoHorasExt, BC001A2_A1987PuestoRelSec, BC001A2_A1988PuestoRelSecCli, BC001A2_A1989PuestoPadre, BC001A2_A2016PuestoRelRef,
            BC001A2_A2034PuestoOld
            }
            , new Object[] {
            BC001A3_A1242PuestoDescripSinAc, BC001A3_A3CliCod, BC001A3_A13SecCodigo, BC001A3_A1240PuestoCodigo, BC001A3_A1241PuestoDescrip, BC001A3_A1255PuestoHorasExt, BC001A3_A1987PuestoRelSec, BC001A3_A1988PuestoRelSecCli, BC001A3_A1989PuestoPadre, BC001A3_A2016PuestoRelRef,
            BC001A3_A2034PuestoOld
            }
            , new Object[] {
            BC001A4_A675SecDescripSinAc, BC001A4_A13SecCodigo, BC001A4_A329SecDescrip, BC001A4_A330SecHabilitada, BC001A4_A1984SecRelSec, BC001A4_A1985SecRelSecCli, BC001A4_A1986SecPadre, BC001A4_A2015SecRelRef, BC001A4_A2033SecOld, BC001A4_A2308SecApoOpc,
            BC001A4_A3CliCod
            }
            , new Object[] {
            BC001A5_A675SecDescripSinAc, BC001A5_A13SecCodigo, BC001A5_A329SecDescrip, BC001A5_A330SecHabilitada, BC001A5_A1984SecRelSec, BC001A5_A1985SecRelSecCli, BC001A5_A1986SecPadre, BC001A5_A2015SecRelRef, BC001A5_A2033SecOld, BC001A5_A2308SecApoOpc,
            BC001A5_A3CliCod
            }
            , new Object[] {
            BC001A6_A3CliCod
            }
            , new Object[] {
            BC001A7_A675SecDescripSinAc, BC001A7_A13SecCodigo, BC001A7_A329SecDescrip, BC001A7_A330SecHabilitada, BC001A7_A1984SecRelSec, BC001A7_A1985SecRelSecCli, BC001A7_A1986SecPadre, BC001A7_A2015SecRelRef, BC001A7_A2033SecOld, BC001A7_A2308SecApoOpc,
            BC001A7_A3CliCod
            }
            , new Object[] {
            BC001A8_A3CliCod
            }
            , new Object[] {
            BC001A9_A3CliCod, BC001A9_A13SecCodigo
            }
            , new Object[] {
            BC001A10_A675SecDescripSinAc, BC001A10_A13SecCodigo, BC001A10_A329SecDescrip, BC001A10_A330SecHabilitada, BC001A10_A1984SecRelSec, BC001A10_A1985SecRelSecCli, BC001A10_A1986SecPadre, BC001A10_A2015SecRelRef, BC001A10_A2033SecOld, BC001A10_A2308SecApoOpc,
            BC001A10_A3CliCod
            }
            , new Object[] {
            BC001A11_A675SecDescripSinAc, BC001A11_A13SecCodigo, BC001A11_A329SecDescrip, BC001A11_A330SecHabilitada, BC001A11_A1984SecRelSec, BC001A11_A1985SecRelSecCli, BC001A11_A1986SecPadre, BC001A11_A2015SecRelRef, BC001A11_A2033SecOld, BC001A11_A2308SecApoOpc,
            BC001A11_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001A15_A3CliCod, BC001A15_A1EmpCod, BC001A15_A31LiqNro, BC001A15_A2145LiqArea
            }
            , new Object[] {
            BC001A16_A3CliCod, BC001A16_A1EmpCod, BC001A16_A6LegNumero
            }
            , new Object[] {
            BC001A17_A3CliCod, BC001A17_A1EmpCod, BC001A17_A31LiqNro, BC001A17_A6LegNumero
            }
            , new Object[] {
            BC001A18_A3CliCod, BC001A18_A1EmpCod, BC001A18_A6LegNumero
            }
            , new Object[] {
            BC001A19_A675SecDescripSinAc, BC001A19_A13SecCodigo, BC001A19_A329SecDescrip, BC001A19_A330SecHabilitada, BC001A19_A1984SecRelSec, BC001A19_A1985SecRelSecCli, BC001A19_A1986SecPadre, BC001A19_A2015SecRelRef, BC001A19_A2033SecOld, BC001A19_A2308SecApoOpc,
            BC001A19_A3CliCod
            }
            , new Object[] {
            BC001A20_A1242PuestoDescripSinAc, BC001A20_A3CliCod, BC001A20_A13SecCodigo, BC001A20_A1240PuestoCodigo, BC001A20_A1241PuestoDescrip, BC001A20_A1255PuestoHorasExt, BC001A20_A1987PuestoRelSec, BC001A20_A1988PuestoRelSecCli, BC001A20_A1989PuestoPadre, BC001A20_A2016PuestoRelRef,
            BC001A20_A2034PuestoOld
            }
            , new Object[] {
            BC001A21_A3CliCod, BC001A21_A13SecCodigo, BC001A21_A1240PuestoCodigo
            }
            , new Object[] {
            BC001A22_A1242PuestoDescripSinAc, BC001A22_A3CliCod, BC001A22_A13SecCodigo, BC001A22_A1240PuestoCodigo, BC001A22_A1241PuestoDescrip, BC001A22_A1255PuestoHorasExt, BC001A22_A1987PuestoRelSec, BC001A22_A1988PuestoRelSecCli, BC001A22_A1989PuestoPadre, BC001A22_A2016PuestoRelRef,
            BC001A22_A2034PuestoOld
            }
            , new Object[] {
            BC001A23_A1242PuestoDescripSinAc, BC001A23_A3CliCod, BC001A23_A13SecCodigo, BC001A23_A1240PuestoCodigo, BC001A23_A1241PuestoDescrip, BC001A23_A1255PuestoHorasExt, BC001A23_A1987PuestoRelSec, BC001A23_A1988PuestoRelSecCli, BC001A23_A1989PuestoPadre, BC001A23_A2016PuestoRelRef,
            BC001A23_A2034PuestoOld
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001A27_A3CliCod, BC001A27_A1EmpCod, BC001A27_A31LiqNro, BC001A27_A2145LiqArea, BC001A27_A2146LiqPuesto
            }
            , new Object[] {
            BC001A28_A3CliCod, BC001A28_A1EmpCod, BC001A28_A6LegNumero
            }
            , new Object[] {
            BC001A29_A1242PuestoDescripSinAc, BC001A29_A3CliCod, BC001A29_A13SecCodigo, BC001A29_A1240PuestoCodigo, BC001A29_A1241PuestoDescrip, BC001A29_A1255PuestoHorasExt, BC001A29_A1987PuestoRelSec, BC001A29_A1988PuestoRelSecCli, BC001A29_A1989PuestoPadre, BC001A29_A2016PuestoRelRef,
            BC001A29_A2034PuestoOld
            }
            , new Object[] {
            BC001A30_A3CliCod
            }
            , new Object[] {
            BC001A31_A3CliCod
            }
         }
      );
      AV17Pgmname = "Seccion_BC" ;
      Z330SecHabilitada = true ;
      A330SecHabilitada = true ;
      i330SecHabilitada = true ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e121A2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte Gxremove153 ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nIsMod_153 ;
   private short RcdFound153 ;
   private short RcdFound43 ;
   private short nIsDirty_43 ;
   private short nRcdExists_153 ;
   private short nIsDirty_153 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int nGXsfl_153_idx=1 ;
   private int GX_JID ;
   private int Z1984SecRelSec ;
   private int A1984SecRelSec ;
   private int Z1985SecRelSecCli ;
   private int A1985SecRelSecCli ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private int Z1987PuestoRelSec ;
   private int A1987PuestoRelSec ;
   private int Z1988PuestoRelSecCli ;
   private int A1988PuestoRelSecCli ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z13SecCodigo ;
   private String A13SecCodigo ;
   private String sMode43 ;
   private String AV17Pgmname ;
   private String Z1986SecPadre ;
   private String A1986SecPadre ;
   private String Z1989PuestoPadre ;
   private String A1989PuestoPadre ;
   private String Z1240PuestoCodigo ;
   private String A1240PuestoCodigo ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String sMode153 ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z330SecHabilitada ;
   private boolean A330SecHabilitada ;
   private boolean Z2308SecApoOpc ;
   private boolean A2308SecApoOpc ;
   private boolean Gx_longc ;
   private boolean Z1255PuestoHorasExt ;
   private boolean A1255PuestoHorasExt ;
   private boolean i330SecHabilitada ;
   private boolean mustCommit ;
   private String Z2033SecOld ;
   private String A2033SecOld ;
   private String Z2034PuestoOld ;
   private String A2034PuestoOld ;
   private String Z675SecDescripSinAc ;
   private String A675SecDescripSinAc ;
   private String Z329SecDescrip ;
   private String A329SecDescrip ;
   private String Z2015SecRelRef ;
   private String A2015SecRelRef ;
   private String Z1242PuestoDescripSinAc ;
   private String A1242PuestoDescripSinAc ;
   private String Z1241PuestoDescrip ;
   private String A1241PuestoDescrip ;
   private String Z2016PuestoRelRef ;
   private String A2016PuestoRelRef ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private web.SdtSeccion bcSeccion ;
   private IDataStoreProvider pr_default ;
   private String[] BC001A7_A675SecDescripSinAc ;
   private String[] BC001A7_A13SecCodigo ;
   private String[] BC001A7_A329SecDescrip ;
   private boolean[] BC001A7_A330SecHabilitada ;
   private int[] BC001A7_A1984SecRelSec ;
   private int[] BC001A7_A1985SecRelSecCli ;
   private String[] BC001A7_A1986SecPadre ;
   private String[] BC001A7_A2015SecRelRef ;
   private String[] BC001A7_A2033SecOld ;
   private boolean[] BC001A7_A2308SecApoOpc ;
   private int[] BC001A7_A3CliCod ;
   private int[] BC001A8_A3CliCod ;
   private int[] BC001A9_A3CliCod ;
   private String[] BC001A9_A13SecCodigo ;
   private String[] BC001A10_A675SecDescripSinAc ;
   private String[] BC001A10_A13SecCodigo ;
   private String[] BC001A10_A329SecDescrip ;
   private boolean[] BC001A10_A330SecHabilitada ;
   private int[] BC001A10_A1984SecRelSec ;
   private int[] BC001A10_A1985SecRelSecCli ;
   private String[] BC001A10_A1986SecPadre ;
   private String[] BC001A10_A2015SecRelRef ;
   private String[] BC001A10_A2033SecOld ;
   private boolean[] BC001A10_A2308SecApoOpc ;
   private int[] BC001A10_A3CliCod ;
   private String[] BC001A11_A675SecDescripSinAc ;
   private String[] BC001A11_A13SecCodigo ;
   private String[] BC001A11_A329SecDescrip ;
   private boolean[] BC001A11_A330SecHabilitada ;
   private int[] BC001A11_A1984SecRelSec ;
   private int[] BC001A11_A1985SecRelSecCli ;
   private String[] BC001A11_A1986SecPadre ;
   private String[] BC001A11_A2015SecRelRef ;
   private String[] BC001A11_A2033SecOld ;
   private boolean[] BC001A11_A2308SecApoOpc ;
   private int[] BC001A11_A3CliCod ;
   private int[] BC001A15_A3CliCod ;
   private short[] BC001A15_A1EmpCod ;
   private int[] BC001A15_A31LiqNro ;
   private String[] BC001A15_A2145LiqArea ;
   private int[] BC001A16_A3CliCod ;
   private short[] BC001A16_A1EmpCod ;
   private int[] BC001A16_A6LegNumero ;
   private int[] BC001A17_A3CliCod ;
   private short[] BC001A17_A1EmpCod ;
   private int[] BC001A17_A31LiqNro ;
   private int[] BC001A17_A6LegNumero ;
   private int[] BC001A18_A3CliCod ;
   private short[] BC001A18_A1EmpCod ;
   private int[] BC001A18_A6LegNumero ;
   private String[] BC001A19_A675SecDescripSinAc ;
   private String[] BC001A19_A13SecCodigo ;
   private String[] BC001A19_A329SecDescrip ;
   private boolean[] BC001A19_A330SecHabilitada ;
   private int[] BC001A19_A1984SecRelSec ;
   private int[] BC001A19_A1985SecRelSecCli ;
   private String[] BC001A19_A1986SecPadre ;
   private String[] BC001A19_A2015SecRelRef ;
   private String[] BC001A19_A2033SecOld ;
   private boolean[] BC001A19_A2308SecApoOpc ;
   private int[] BC001A19_A3CliCod ;
   private String[] BC001A20_A1242PuestoDescripSinAc ;
   private int[] BC001A20_A3CliCod ;
   private String[] BC001A20_A13SecCodigo ;
   private String[] BC001A20_A1240PuestoCodigo ;
   private String[] BC001A20_A1241PuestoDescrip ;
   private boolean[] BC001A20_A1255PuestoHorasExt ;
   private int[] BC001A20_A1987PuestoRelSec ;
   private int[] BC001A20_A1988PuestoRelSecCli ;
   private String[] BC001A20_A1989PuestoPadre ;
   private String[] BC001A20_A2016PuestoRelRef ;
   private String[] BC001A20_A2034PuestoOld ;
   private int[] BC001A21_A3CliCod ;
   private String[] BC001A21_A13SecCodigo ;
   private String[] BC001A21_A1240PuestoCodigo ;
   private String[] BC001A22_A1242PuestoDescripSinAc ;
   private int[] BC001A22_A3CliCod ;
   private String[] BC001A22_A13SecCodigo ;
   private String[] BC001A22_A1240PuestoCodigo ;
   private String[] BC001A22_A1241PuestoDescrip ;
   private boolean[] BC001A22_A1255PuestoHorasExt ;
   private int[] BC001A22_A1987PuestoRelSec ;
   private int[] BC001A22_A1988PuestoRelSecCli ;
   private String[] BC001A22_A1989PuestoPadre ;
   private String[] BC001A22_A2016PuestoRelRef ;
   private String[] BC001A22_A2034PuestoOld ;
   private String[] BC001A23_A1242PuestoDescripSinAc ;
   private int[] BC001A23_A3CliCod ;
   private String[] BC001A23_A13SecCodigo ;
   private String[] BC001A23_A1240PuestoCodigo ;
   private String[] BC001A23_A1241PuestoDescrip ;
   private boolean[] BC001A23_A1255PuestoHorasExt ;
   private int[] BC001A23_A1987PuestoRelSec ;
   private int[] BC001A23_A1988PuestoRelSecCli ;
   private String[] BC001A23_A1989PuestoPadre ;
   private String[] BC001A23_A2016PuestoRelRef ;
   private String[] BC001A23_A2034PuestoOld ;
   private int[] BC001A27_A3CliCod ;
   private short[] BC001A27_A1EmpCod ;
   private int[] BC001A27_A31LiqNro ;
   private String[] BC001A27_A2145LiqArea ;
   private String[] BC001A27_A2146LiqPuesto ;
   private int[] BC001A28_A3CliCod ;
   private short[] BC001A28_A1EmpCod ;
   private int[] BC001A28_A6LegNumero ;
   private String[] BC001A29_A1242PuestoDescripSinAc ;
   private int[] BC001A29_A3CliCod ;
   private String[] BC001A29_A13SecCodigo ;
   private String[] BC001A29_A1240PuestoCodigo ;
   private String[] BC001A29_A1241PuestoDescrip ;
   private boolean[] BC001A29_A1255PuestoHorasExt ;
   private int[] BC001A29_A1987PuestoRelSec ;
   private int[] BC001A29_A1988PuestoRelSecCli ;
   private String[] BC001A29_A1989PuestoPadre ;
   private String[] BC001A29_A2016PuestoRelRef ;
   private String[] BC001A29_A2034PuestoOld ;
   private int[] BC001A30_A3CliCod ;
   private int[] BC001A31_A3CliCod ;
   private String[] BC001A2_A1242PuestoDescripSinAc ;
   private int[] BC001A2_A3CliCod ;
   private String[] BC001A2_A13SecCodigo ;
   private String[] BC001A2_A1240PuestoCodigo ;
   private String[] BC001A2_A1241PuestoDescrip ;
   private boolean[] BC001A2_A1255PuestoHorasExt ;
   private int[] BC001A2_A1987PuestoRelSec ;
   private int[] BC001A2_A1988PuestoRelSecCli ;
   private String[] BC001A2_A1989PuestoPadre ;
   private String[] BC001A2_A2016PuestoRelRef ;
   private String[] BC001A2_A2034PuestoOld ;
   private String[] BC001A3_A1242PuestoDescripSinAc ;
   private int[] BC001A3_A3CliCod ;
   private String[] BC001A3_A13SecCodigo ;
   private String[] BC001A3_A1240PuestoCodigo ;
   private String[] BC001A3_A1241PuestoDescrip ;
   private boolean[] BC001A3_A1255PuestoHorasExt ;
   private int[] BC001A3_A1987PuestoRelSec ;
   private int[] BC001A3_A1988PuestoRelSecCli ;
   private String[] BC001A3_A1989PuestoPadre ;
   private String[] BC001A3_A2016PuestoRelRef ;
   private String[] BC001A3_A2034PuestoOld ;
   private String[] BC001A4_A675SecDescripSinAc ;
   private String[] BC001A4_A13SecCodigo ;
   private String[] BC001A4_A329SecDescrip ;
   private boolean[] BC001A4_A330SecHabilitada ;
   private int[] BC001A4_A1984SecRelSec ;
   private int[] BC001A4_A1985SecRelSecCli ;
   private String[] BC001A4_A1986SecPadre ;
   private String[] BC001A4_A2015SecRelRef ;
   private String[] BC001A4_A2033SecOld ;
   private boolean[] BC001A4_A2308SecApoOpc ;
   private int[] BC001A4_A3CliCod ;
   private String[] BC001A5_A675SecDescripSinAc ;
   private String[] BC001A5_A13SecCodigo ;
   private String[] BC001A5_A329SecDescrip ;
   private boolean[] BC001A5_A330SecHabilitada ;
   private int[] BC001A5_A1984SecRelSec ;
   private int[] BC001A5_A1985SecRelSecCli ;
   private String[] BC001A5_A1986SecPadre ;
   private String[] BC001A5_A2015SecRelRef ;
   private String[] BC001A5_A2033SecOld ;
   private boolean[] BC001A5_A2308SecApoOpc ;
   private int[] BC001A5_A3CliCod ;
   private int[] BC001A6_A3CliCod ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class seccion_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC001A2", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?  FOR UPDATE OF Puesto",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A3", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A4", "SELECT SecDescripSinAc, SecCodigo, SecDescrip, SecHabilitada, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecApoOpc, CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ?  FOR UPDATE OF Seccion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A5", "SELECT SecDescripSinAc, SecCodigo, SecDescrip, SecHabilitada, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecApoOpc, CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A7", "SELECT TM1.SecDescripSinAc, TM1.SecCodigo, TM1.SecDescrip, TM1.SecHabilitada, TM1.SecRelSec, TM1.SecRelSecCli, TM1.SecPadre, TM1.SecRelRef, TM1.SecOld, TM1.SecApoOpc, TM1.CliCod FROM Seccion TM1 WHERE TM1.CliCod = ? and TM1.SecCodigo = ( ?) ORDER BY TM1.CliCod, TM1.SecCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A8", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A9", "SELECT CliCod, SecCodigo FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A10", "SELECT SecDescripSinAc, SecCodigo, SecDescrip, SecHabilitada, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecApoOpc, CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A11", "SELECT SecDescripSinAc, SecCodigo, SecDescrip, SecHabilitada, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecApoOpc, CliCod FROM Seccion WHERE CliCod = ? AND SecCodigo = ?  FOR UPDATE OF Seccion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001A12", "SAVEPOINT gxupdate;INSERT INTO Seccion(SecDescripSinAc, SecCodigo, SecDescrip, SecHabilitada, SecRelSec, SecRelSecCli, SecPadre, SecRelRef, SecOld, SecApoOpc, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001A13", "SAVEPOINT gxupdate;UPDATE Seccion SET SecDescripSinAc=?, SecDescrip=?, SecHabilitada=?, SecRelSec=?, SecRelSecCli=?, SecPadre=?, SecRelRef=?, SecOld=?, SecApoOpc=?  WHERE CliCod = ? AND SecCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001A14", "SAVEPOINT gxupdate;DELETE FROM Seccion  WHERE CliCod = ? AND SecCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001A15", "SELECT CliCod, EmpCod, LiqNro, LiqArea FROM LiquidacionArea WHERE CliCod = ? AND LiqArea = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001A16", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegSecCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001A17", "SELECT CliCod, EmpCod, LiqNro, LegNumero FROM LiquidacionLegajo WHERE CliCod = ? AND LiqSecCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001A18", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegSecCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001A19", "SELECT TM1.SecDescripSinAc, TM1.SecCodigo, TM1.SecDescrip, TM1.SecHabilitada, TM1.SecRelSec, TM1.SecRelSecCli, TM1.SecPadre, TM1.SecRelRef, TM1.SecOld, TM1.SecApoOpc, TM1.CliCod FROM Seccion TM1 WHERE TM1.CliCod = ? and TM1.SecCodigo = ( ?) ORDER BY TM1.CliCod, TM1.SecCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A20", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? and SecCodigo = ( ?) and PuestoCodigo = ( ?) ORDER BY CliCod, SecCodigo, PuestoCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A21", "SELECT CliCod, SecCodigo, PuestoCodigo FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A22", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A23", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?  FOR UPDATE OF Puesto",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001A24", "SAVEPOINT gxupdate;INSERT INTO Puesto(PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001A25", "SAVEPOINT gxupdate;UPDATE Puesto SET PuestoDescripSinAc=?, PuestoDescrip=?, PuestoHorasExt=?, PuestoRelSec=?, PuestoRelSecCli=?, PuestoPadre=?, PuestoRelRef=?, PuestoOld=?  WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001A26", "SAVEPOINT gxupdate;DELETE FROM Puesto  WHERE CliCod = ? AND SecCodigo = ? AND PuestoCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001A27", "SELECT CliCod, EmpCod, LiqNro, LiqArea, LiqPuesto FROM LiquidacionPuesto WHERE CliCod = ? AND LiqArea = ? AND LiqPuesto = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001A28", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegSecCodigo = ? AND LegPuesCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001A29", "SELECT PuestoDescripSinAc, CliCod, SecCodigo, PuestoCodigo, PuestoDescrip, PuestoHorasExt, PuestoRelSec, PuestoRelSecCli, PuestoPadre, PuestoRelRef, PuestoOld FROM Puesto WHERE CliCod = ? and SecCodigo = ( ?) ORDER BY CliCod, SecCodigo, PuestoCodigo ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A30", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001A31", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(11);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 29 :
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
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
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setString(11, (String)parms[10], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 22 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setVarchar(10, (String)parms[9], 40, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               return;
            case 23 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

