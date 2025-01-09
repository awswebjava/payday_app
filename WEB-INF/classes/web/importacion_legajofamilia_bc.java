package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_legajofamilia_bc extends GXWebPanel implements IGxSilentTrn
{
   public importacion_legajofamilia_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_legajofamilia_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_legajofamilia_bc.class ));
   }

   public importacion_legajofamilia_bc( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow61262( ) ;
      standaloneNotModal( ) ;
      initializeNonKey61262( ) ;
      standaloneModal( ) ;
      addRow61262( ) ;
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
         e11612 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z87MigrLegNumero = A87MigrLegNumero ;
            Z2078MigrLegFamSec = A2078MigrLegFamSec ;
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

   public void confirm_610( )
   {
      beforeValidate61262( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls61262( ) ;
         }
         else
         {
            checkExtendedTable61262( ) ;
            if ( AnyError == 0 )
            {
               zm61262( 3) ;
            }
            closeExtendedTableCursors61262( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12612( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXv_char1[0] = AV25MigrLegFamAdh ;
      GXv_decimal2[0] = AV24MigrLegFamDedGan ;
      GXv_char3[0] = AV23MigrLegFamNroDoc ;
      GXv_char4[0] = AV22MigrLegFamParen ;
      GXv_char5[0] = AV30MigrLegFamDiscap ;
      GXv_date6[0] = AV33MigrLegFamFecNac ;
      GXv_char7[0] = "" ;
      new web.getmigrfamiliadatos(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, AV9MigrLegNumero, AV10MigrLegFamSec, GXv_char1, GXv_decimal2, GXv_char3, GXv_char4, GXv_char5, GXv_date6, GXv_char7) ;
      importacion_legajofamilia_bc.this.AV25MigrLegFamAdh = GXv_char1[0] ;
      importacion_legajofamilia_bc.this.AV24MigrLegFamDedGan = GXv_decimal2[0] ;
      importacion_legajofamilia_bc.this.AV23MigrLegFamNroDoc = GXv_char3[0] ;
      importacion_legajofamilia_bc.this.AV22MigrLegFamParen = GXv_char4[0] ;
      importacion_legajofamilia_bc.this.AV30MigrLegFamDiscap = GXv_char5[0] ;
      importacion_legajofamilia_bc.this.AV33MigrLegFamFecNac = GXv_date6[0] ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext8[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext8) ;
      AV11WWPContext = GXv_SdtWWPContext8[0] ;
      AV12IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean9 = AV12IsAuthorized ;
         GXv_boolean10[0] = GXt_boolean9 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajoFamilia_Insert", GXv_boolean10) ;
         importacion_legajofamilia_bc.this.GXt_boolean9 = GXv_boolean10[0] ;
         AV12IsAuthorized = GXt_boolean9 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean9 = AV12IsAuthorized ;
         GXv_boolean10[0] = GXt_boolean9 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajoFamilia_Update", GXv_boolean10) ;
         importacion_legajofamilia_bc.this.GXt_boolean9 = GXv_boolean10[0] ;
         AV12IsAuthorized = GXt_boolean9 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean9 = AV12IsAuthorized ;
         GXv_boolean10[0] = GXt_boolean9 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajoFamilia_Delete", GXv_boolean10) ;
         importacion_legajofamilia_bc.this.GXt_boolean9 = GXv_boolean10[0] ;
         AV12IsAuthorized = GXt_boolean9 ;
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV34Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
   }

   public void e11612( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm61262( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z2079MigrLegFamParen = A2079MigrLegFamParen ;
         Z2086MigrLegFamDiscap = A2086MigrLegFamDiscap ;
         Z2080MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
         Z2081MigrLegFamDedGan = A2081MigrLegFamDedGan ;
         Z2082MigrLegFamAdh = A2082MigrLegFamAdh ;
         Z2088MigrLegFamNomApe = A2088MigrLegFamNomApe ;
         Z2089MigrLegFamFecNac = A2089MigrLegFamFecNac ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z592MigrLegApellido = A592MigrLegApellido ;
         Z593MigrLegNombre = A593MigrLegNombre ;
         Z597MigrLegCUIL = A597MigrLegCUIL ;
      }
      if ( GX_JID == -2 )
      {
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
         Z2079MigrLegFamParen = A2079MigrLegFamParen ;
         Z2086MigrLegFamDiscap = A2086MigrLegFamDiscap ;
         Z2080MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
         Z2081MigrLegFamDedGan = A2081MigrLegFamDedGan ;
         Z2082MigrLegFamAdh = A2082MigrLegFamAdh ;
         Z2084MigrLegFamErrores = A2084MigrLegFamErrores ;
         Z2085MigrLegFamWarnings = A2085MigrLegFamWarnings ;
         Z2088MigrLegFamNomApe = A2088MigrLegFamNomApe ;
         Z2089MigrLegFamFecNac = A2089MigrLegFamFecNac ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z592MigrLegApellido = A592MigrLegApellido ;
         Z593MigrLegNombre = A593MigrLegNombre ;
         Z597MigrLegCUIL = A597MigrLegCUIL ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int11 = A3CliCod ;
         GXv_int12[0] = GXt_int11 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int12) ;
         importacion_legajofamilia_bc.this.GXt_int11 = GXv_int12[0] ;
         A3CliCod = GXt_int11 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load61262( )
   {
      /* Using cursor BC00615 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2079MigrLegFamParen = BC00615_A2079MigrLegFamParen[0] ;
         A2086MigrLegFamDiscap = BC00615_A2086MigrLegFamDiscap[0] ;
         A2080MigrLegFamNroDoc = BC00615_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = BC00615_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = BC00615_A2082MigrLegFamAdh[0] ;
         A2084MigrLegFamErrores = BC00615_A2084MigrLegFamErrores[0] ;
         A2085MigrLegFamWarnings = BC00615_A2085MigrLegFamWarnings[0] ;
         A592MigrLegApellido = BC00615_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC00615_A593MigrLegNombre[0] ;
         A597MigrLegCUIL = BC00615_A597MigrLegCUIL[0] ;
         A2088MigrLegFamNomApe = BC00615_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = BC00615_A2089MigrLegFamFecNac[0] ;
         zm61262( -2) ;
      }
      pr_default.close(3);
      onLoadActions61262( ) ;
   }

   public void onLoadActions61262( )
   {
      AV34Pgmname = "importacion_legajoFamilia_BC" ;
   }

   public void checkExtendedTable61262( )
   {
      nIsDirty_262 = (short)(0) ;
      standaloneModal( ) ;
      AV34Pgmname = "importacion_legajoFamilia_BC" ;
      /* Using cursor BC00616 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MIGRLEGNUMERO");
         AnyError = (short)(1) ;
      }
      A592MigrLegApellido = BC00616_A592MigrLegApellido[0] ;
      A593MigrLegNombre = BC00616_A593MigrLegNombre[0] ;
      A597MigrLegCUIL = BC00616_A597MigrLegCUIL[0] ;
      pr_default.close(4);
   }

   public void closeExtendedTableCursors61262( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey61262( )
   {
      /* Using cursor BC00617 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound262 = (short)(1) ;
      }
      else
      {
         RcdFound262 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00618 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm61262( 2) ;
         RcdFound262 = (short)(1) ;
         A2078MigrLegFamSec = BC00618_A2078MigrLegFamSec[0] ;
         A2079MigrLegFamParen = BC00618_A2079MigrLegFamParen[0] ;
         A2086MigrLegFamDiscap = BC00618_A2086MigrLegFamDiscap[0] ;
         A2080MigrLegFamNroDoc = BC00618_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = BC00618_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = BC00618_A2082MigrLegFamAdh[0] ;
         A2084MigrLegFamErrores = BC00618_A2084MigrLegFamErrores[0] ;
         A2085MigrLegFamWarnings = BC00618_A2085MigrLegFamWarnings[0] ;
         A2088MigrLegFamNomApe = BC00618_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = BC00618_A2089MigrLegFamFecNac[0] ;
         A3CliCod = BC00618_A3CliCod[0] ;
         A1EmpCod = BC00618_A1EmpCod[0] ;
         A87MigrLegNumero = BC00618_A87MigrLegNumero[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
         sMode262 = Gx_mode ;
         Gx_mode = "DSP" ;
         load61262( ) ;
         if ( AnyError == 1 )
         {
            RcdFound262 = (short)(0) ;
            initializeNonKey61262( ) ;
         }
         Gx_mode = sMode262 ;
      }
      else
      {
         RcdFound262 = (short)(0) ;
         initializeNonKey61262( ) ;
         sMode262 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode262 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey61262( ) ;
      if ( RcdFound262 == 0 )
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
      confirm_610( ) ;
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

   public void checkOptimisticConcurrency61262( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00619 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajoFamilia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z2079MigrLegFamParen, BC00619_A2079MigrLegFamParen[0]) != 0 ) || ( GXutil.strcmp(Z2086MigrLegFamDiscap, BC00619_A2086MigrLegFamDiscap[0]) != 0 ) || ( GXutil.strcmp(Z2080MigrLegFamNroDoc, BC00619_A2080MigrLegFamNroDoc[0]) != 0 ) || ( DecimalUtil.compareTo(Z2081MigrLegFamDedGan, BC00619_A2081MigrLegFamDedGan[0]) != 0 ) || ( GXutil.strcmp(Z2082MigrLegFamAdh, BC00619_A2082MigrLegFamAdh[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2088MigrLegFamNomApe, BC00619_A2088MigrLegFamNomApe[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z2089MigrLegFamFecNac), GXutil.resetTime(BC00619_A2089MigrLegFamFecNac[0])) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_legajoFamilia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert61262( )
   {
      beforeValidate61262( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable61262( ) ;
      }
      if ( AnyError == 0 )
      {
         zm61262( 0) ;
         checkOptimisticConcurrency61262( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm61262( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert61262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC006110 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A2078MigrLegFamSec), A2079MigrLegFamParen, A2086MigrLegFamDiscap, A2080MigrLegFamNroDoc, A2081MigrLegFamDedGan, A2082MigrLegFamAdh, A2084MigrLegFamErrores, A2085MigrLegFamWarnings, A2088MigrLegFamNomApe, A2089MigrLegFamFecNac, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
                  if ( (pr_default.getStatus(8) == 1) )
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
            load61262( ) ;
         }
         endLevel61262( ) ;
      }
      closeExtendedTableCursors61262( ) ;
   }

   public void update61262( )
   {
      beforeValidate61262( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable61262( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency61262( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm61262( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate61262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC006111 */
                  pr_default.execute(9, new Object[] {A2079MigrLegFamParen, A2086MigrLegFamDiscap, A2080MigrLegFamNroDoc, A2081MigrLegFamDedGan, A2082MigrLegFamAdh, A2084MigrLegFamErrores, A2085MigrLegFamWarnings, A2088MigrLegFamNomApe, A2089MigrLegFamFecNac, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajoFamilia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate61262( ) ;
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
         endLevel61262( ) ;
      }
      closeExtendedTableCursors61262( ) ;
   }

   public void deferredUpdate61262( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate61262( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency61262( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls61262( ) ;
         afterConfirm61262( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete61262( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC006112 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
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
      sMode262 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel61262( ) ;
      Gx_mode = sMode262 ;
   }

   public void onDeleteControls61262( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV34Pgmname = "importacion_legajoFamilia_BC" ;
         /* Using cursor BC006113 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         A592MigrLegApellido = BC006113_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC006113_A593MigrLegNombre[0] ;
         A597MigrLegCUIL = BC006113_A597MigrLegCUIL[0] ;
         pr_default.close(11);
      }
   }

   public void endLevel61262( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete61262( ) ;
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

   public void scanKeyStart61262( )
   {
      /* Scan By routine */
      /* Using cursor BC006114 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      RcdFound262 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2078MigrLegFamSec = BC006114_A2078MigrLegFamSec[0] ;
         A2079MigrLegFamParen = BC006114_A2079MigrLegFamParen[0] ;
         A2086MigrLegFamDiscap = BC006114_A2086MigrLegFamDiscap[0] ;
         A2080MigrLegFamNroDoc = BC006114_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = BC006114_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = BC006114_A2082MigrLegFamAdh[0] ;
         A2084MigrLegFamErrores = BC006114_A2084MigrLegFamErrores[0] ;
         A2085MigrLegFamWarnings = BC006114_A2085MigrLegFamWarnings[0] ;
         A592MigrLegApellido = BC006114_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC006114_A593MigrLegNombre[0] ;
         A597MigrLegCUIL = BC006114_A597MigrLegCUIL[0] ;
         A2088MigrLegFamNomApe = BC006114_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = BC006114_A2089MigrLegFamFecNac[0] ;
         A3CliCod = BC006114_A3CliCod[0] ;
         A1EmpCod = BC006114_A1EmpCod[0] ;
         A87MigrLegNumero = BC006114_A87MigrLegNumero[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext61262( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound262 = (short)(0) ;
      scanKeyLoad61262( ) ;
   }

   public void scanKeyLoad61262( )
   {
      sMode262 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2078MigrLegFamSec = BC006114_A2078MigrLegFamSec[0] ;
         A2079MigrLegFamParen = BC006114_A2079MigrLegFamParen[0] ;
         A2086MigrLegFamDiscap = BC006114_A2086MigrLegFamDiscap[0] ;
         A2080MigrLegFamNroDoc = BC006114_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = BC006114_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = BC006114_A2082MigrLegFamAdh[0] ;
         A2084MigrLegFamErrores = BC006114_A2084MigrLegFamErrores[0] ;
         A2085MigrLegFamWarnings = BC006114_A2085MigrLegFamWarnings[0] ;
         A592MigrLegApellido = BC006114_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC006114_A593MigrLegNombre[0] ;
         A597MigrLegCUIL = BC006114_A597MigrLegCUIL[0] ;
         A2088MigrLegFamNomApe = BC006114_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = BC006114_A2089MigrLegFamFecNac[0] ;
         A3CliCod = BC006114_A3CliCod[0] ;
         A1EmpCod = BC006114_A1EmpCod[0] ;
         A87MigrLegNumero = BC006114_A87MigrLegNumero[0] ;
      }
      Gx_mode = sMode262 ;
   }

   public void scanKeyEnd61262( )
   {
      pr_default.close(12);
   }

   public void afterConfirm61262( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert61262( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate61262( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete61262( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete61262( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate61262( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes61262( )
   {
   }

   public void send_integrity_lvl_hashes61262( )
   {
   }

   public void addRow61262( )
   {
      VarsToRow262( bcimportacion_legajoFamilia) ;
   }

   public void readRow61262( )
   {
      RowToVars262( bcimportacion_legajoFamilia, 1) ;
   }

   public void initializeNonKey61262( )
   {
      A2079MigrLegFamParen = "" ;
      A2086MigrLegFamDiscap = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2082MigrLegFamAdh = "" ;
      A2084MigrLegFamErrores = "" ;
      A2085MigrLegFamWarnings = "" ;
      A592MigrLegApellido = "" ;
      A593MigrLegNombre = "" ;
      A597MigrLegCUIL = "" ;
      A2088MigrLegFamNomApe = "" ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      Z2079MigrLegFamParen = "" ;
      Z2086MigrLegFamDiscap = "" ;
      Z2080MigrLegFamNroDoc = "" ;
      Z2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      Z2082MigrLegFamAdh = "" ;
      Z2088MigrLegFamNomApe = "" ;
      Z2089MigrLegFamFecNac = GXutil.nullDate() ;
   }

   public void initAll61262( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A87MigrLegNumero = 0 ;
      A2078MigrLegFamSec = (short)(0) ;
      initializeNonKey61262( ) ;
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

   public void VarsToRow262( web.Sdtimportacion_legajoFamilia obj262 )
   {
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Mode( Gx_mode );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen( A2079MigrLegFamParen );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap( A2086MigrLegFamDiscap );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc( A2080MigrLegFamNroDoc );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan( A2081MigrLegFamDedGan );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh( A2082MigrLegFamAdh );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores( A2084MigrLegFamErrores );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings( A2085MigrLegFamWarnings );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido( A592MigrLegApellido );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre( A593MigrLegNombre );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil( A597MigrLegCUIL );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape( A2088MigrLegFamNomApe );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac( A2089MigrLegFamFecNac );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Clicod( A3CliCod );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Empcod( A1EmpCod );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero( A87MigrLegNumero );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec( A2078MigrLegFamSec );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Clicod_Z( Z3CliCod );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Empcod_Z( Z1EmpCod );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z( Z87MigrLegNumero );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z( Z2078MigrLegFamSec );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z( Z2079MigrLegFamParen );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z( Z2086MigrLegFamDiscap );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z( Z2080MigrLegFamNroDoc );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z( Z2081MigrLegFamDedGan );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z( Z2082MigrLegFamAdh );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z( Z592MigrLegApellido );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z( Z593MigrLegNombre );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z( Z597MigrLegCUIL );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z( Z2088MigrLegFamNomApe );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z( Z2089MigrLegFamFecNac );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Mode( Gx_mode );
   }

   public void KeyVarsToRow262( web.Sdtimportacion_legajoFamilia obj262 )
   {
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Clicod( A3CliCod );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Empcod( A1EmpCod );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero( A87MigrLegNumero );
      obj262.setgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec( A2078MigrLegFamSec );
   }

   public void RowToVars262( web.Sdtimportacion_legajoFamilia obj262 ,
                             int forceLoad )
   {
      Gx_mode = obj262.getgxTv_Sdtimportacion_legajoFamilia_Mode() ;
      A2079MigrLegFamParen = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen() ;
      A2086MigrLegFamDiscap = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap() ;
      A2080MigrLegFamNroDoc = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc() ;
      A2081MigrLegFamDedGan = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan() ;
      A2082MigrLegFamAdh = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh() ;
      A2084MigrLegFamErrores = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamerrores() ;
      A2085MigrLegFamWarnings = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamwarnings() ;
      A592MigrLegApellido = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido() ;
      A593MigrLegNombre = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre() ;
      A597MigrLegCUIL = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil() ;
      A2088MigrLegFamNomApe = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape() ;
      A2089MigrLegFamFecNac = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac() ;
      A3CliCod = obj262.getgxTv_Sdtimportacion_legajoFamilia_Clicod() ;
      A1EmpCod = obj262.getgxTv_Sdtimportacion_legajoFamilia_Empcod() ;
      A87MigrLegNumero = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero() ;
      A2078MigrLegFamSec = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec() ;
      Z3CliCod = obj262.getgxTv_Sdtimportacion_legajoFamilia_Clicod_Z() ;
      Z1EmpCod = obj262.getgxTv_Sdtimportacion_legajoFamilia_Empcod_Z() ;
      Z87MigrLegNumero = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegnumero_Z() ;
      Z2078MigrLegFamSec = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamsec_Z() ;
      Z2079MigrLegFamParen = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamparen_Z() ;
      Z2086MigrLegFamDiscap = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdiscap_Z() ;
      Z2080MigrLegFamNroDoc = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnrodoc_Z() ;
      Z2081MigrLegFamDedGan = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamdedgan_Z() ;
      Z2082MigrLegFamAdh = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamadh_Z() ;
      Z592MigrLegApellido = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegapellido_Z() ;
      Z593MigrLegNombre = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegnombre_Z() ;
      Z597MigrLegCUIL = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegcuil_Z() ;
      Z2088MigrLegFamNomApe = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamnomape_Z() ;
      Z2089MigrLegFamFecNac = obj262.getgxTv_Sdtimportacion_legajoFamilia_Migrlegfamfecnac_Z() ;
      Gx_mode = obj262.getgxTv_Sdtimportacion_legajoFamilia_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A87MigrLegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      A2078MigrLegFamSec = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey61262( ) ;
      scanKeyStart61262( ) ;
      if ( RcdFound262 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC006115 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MIGRLEGNUMERO");
            AnyError = (short)(1) ;
         }
         A592MigrLegApellido = BC006115_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC006115_A593MigrLegNombre[0] ;
         A597MigrLegCUIL = BC006115_A597MigrLegCUIL[0] ;
         pr_default.close(13);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
      }
      zm61262( -2) ;
      onLoadActions61262( ) ;
      addRow61262( ) ;
      scanKeyEnd61262( ) ;
      if ( RcdFound262 == 0 )
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
      RowToVars262( bcimportacion_legajoFamilia, 0) ;
      scanKeyStart61262( ) ;
      if ( RcdFound262 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC006116 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MIGRLEGNUMERO");
            AnyError = (short)(1) ;
         }
         A592MigrLegApellido = BC006116_A592MigrLegApellido[0] ;
         A593MigrLegNombre = BC006116_A593MigrLegNombre[0] ;
         A597MigrLegCUIL = BC006116_A597MigrLegCUIL[0] ;
         pr_default.close(14);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
      }
      zm61262( -2) ;
      onLoadActions61262( ) ;
      addRow61262( ) ;
      scanKeyEnd61262( ) ;
      if ( RcdFound262 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey61262( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert61262( ) ;
      }
      else
      {
         if ( RcdFound262 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) || ( A2078MigrLegFamSec != Z2078MigrLegFamSec ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A87MigrLegNumero = Z87MigrLegNumero ;
               A2078MigrLegFamSec = Z2078MigrLegFamSec ;
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
               update61262( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) || ( A2078MigrLegFamSec != Z2078MigrLegFamSec ) )
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
                     insert61262( ) ;
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
                     insert61262( ) ;
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
      RowToVars262( bcimportacion_legajoFamilia, 1) ;
      saveImpl( ) ;
      VarsToRow262( bcimportacion_legajoFamilia) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars262( bcimportacion_legajoFamilia, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert61262( ) ;
      afterTrn( ) ;
      VarsToRow262( bcimportacion_legajoFamilia) ;
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
         web.Sdtimportacion_legajoFamilia auxBC = new web.Sdtimportacion_legajoFamilia( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A87MigrLegNumero, A2078MigrLegFamSec);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcimportacion_legajoFamilia);
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
      RowToVars262( bcimportacion_legajoFamilia, 1) ;
      updateImpl( ) ;
      VarsToRow262( bcimportacion_legajoFamilia) ;
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
      RowToVars262( bcimportacion_legajoFamilia, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert61262( ) ;
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
      VarsToRow262( bcimportacion_legajoFamilia) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars262( bcimportacion_legajoFamilia, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey61262( ) ;
      if ( RcdFound262 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) || ( A2078MigrLegFamSec != Z2078MigrLegFamSec ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A87MigrLegNumero = Z87MigrLegNumero ;
            A2078MigrLegFamSec = Z2078MigrLegFamSec ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) || ( A2078MigrLegFamSec != Z2078MigrLegFamSec ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_legajofamilia_bc");
      VarsToRow262( bcimportacion_legajoFamilia) ;
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
      Gx_mode = bcimportacion_legajoFamilia.getgxTv_Sdtimportacion_legajoFamilia_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcimportacion_legajoFamilia.setgxTv_Sdtimportacion_legajoFamilia_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtimportacion_legajoFamilia sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcimportacion_legajoFamilia )
      {
         bcimportacion_legajoFamilia = sdt ;
         if ( GXutil.strcmp(bcimportacion_legajoFamilia.getgxTv_Sdtimportacion_legajoFamilia_Mode(), "") == 0 )
         {
            bcimportacion_legajoFamilia.setgxTv_Sdtimportacion_legajoFamilia_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow262( bcimportacion_legajoFamilia) ;
         }
         else
         {
            RowToVars262( bcimportacion_legajoFamilia, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcimportacion_legajoFamilia.getgxTv_Sdtimportacion_legajoFamilia_Mode(), "") == 0 )
         {
            bcimportacion_legajoFamilia.setgxTv_Sdtimportacion_legajoFamilia_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars262( bcimportacion_legajoFamilia, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtimportacion_legajoFamilia getimportacion_legajoFamilia_BC( )
   {
      return bcimportacion_legajoFamilia ;
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
      AV25MigrLegFamAdh = "" ;
      GXv_char1 = new String[1] ;
      AV24MigrLegFamDedGan = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV23MigrLegFamNroDoc = "" ;
      GXv_char3 = new String[1] ;
      AV22MigrLegFamParen = "" ;
      GXv_char4 = new String[1] ;
      AV30MigrLegFamDiscap = "" ;
      GXv_char5 = new String[1] ;
      AV33MigrLegFamFecNac = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      GXv_char7 = new String[1] ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext8 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean10 = new boolean[1] ;
      AV34Pgmname = "" ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      Z2079MigrLegFamParen = "" ;
      A2079MigrLegFamParen = "" ;
      Z2086MigrLegFamDiscap = "" ;
      A2086MigrLegFamDiscap = "" ;
      Z2080MigrLegFamNroDoc = "" ;
      A2080MigrLegFamNroDoc = "" ;
      Z2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      Z2082MigrLegFamAdh = "" ;
      A2082MigrLegFamAdh = "" ;
      Z2088MigrLegFamNomApe = "" ;
      A2088MigrLegFamNomApe = "" ;
      Z2089MigrLegFamFecNac = GXutil.nullDate() ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      Z592MigrLegApellido = "" ;
      A592MigrLegApellido = "" ;
      Z593MigrLegNombre = "" ;
      A593MigrLegNombre = "" ;
      Z597MigrLegCUIL = "" ;
      A597MigrLegCUIL = "" ;
      Z2084MigrLegFamErrores = "" ;
      A2084MigrLegFamErrores = "" ;
      Z2085MigrLegFamWarnings = "" ;
      A2085MigrLegFamWarnings = "" ;
      GXv_int12 = new int[1] ;
      BC00615_A2078MigrLegFamSec = new short[1] ;
      BC00615_A2079MigrLegFamParen = new String[] {""} ;
      BC00615_A2086MigrLegFamDiscap = new String[] {""} ;
      BC00615_A2080MigrLegFamNroDoc = new String[] {""} ;
      BC00615_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00615_A2082MigrLegFamAdh = new String[] {""} ;
      BC00615_A2084MigrLegFamErrores = new String[] {""} ;
      BC00615_A2085MigrLegFamWarnings = new String[] {""} ;
      BC00615_A592MigrLegApellido = new String[] {""} ;
      BC00615_A593MigrLegNombre = new String[] {""} ;
      BC00615_A597MigrLegCUIL = new String[] {""} ;
      BC00615_A2088MigrLegFamNomApe = new String[] {""} ;
      BC00615_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC00615_A3CliCod = new int[1] ;
      BC00615_A1EmpCod = new short[1] ;
      BC00615_A87MigrLegNumero = new int[1] ;
      BC00616_A592MigrLegApellido = new String[] {""} ;
      BC00616_A593MigrLegNombre = new String[] {""} ;
      BC00616_A597MigrLegCUIL = new String[] {""} ;
      BC00617_A3CliCod = new int[1] ;
      BC00617_A1EmpCod = new short[1] ;
      BC00617_A87MigrLegNumero = new int[1] ;
      BC00617_A2078MigrLegFamSec = new short[1] ;
      BC00618_A2078MigrLegFamSec = new short[1] ;
      BC00618_A2079MigrLegFamParen = new String[] {""} ;
      BC00618_A2086MigrLegFamDiscap = new String[] {""} ;
      BC00618_A2080MigrLegFamNroDoc = new String[] {""} ;
      BC00618_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00618_A2082MigrLegFamAdh = new String[] {""} ;
      BC00618_A2084MigrLegFamErrores = new String[] {""} ;
      BC00618_A2085MigrLegFamWarnings = new String[] {""} ;
      BC00618_A2088MigrLegFamNomApe = new String[] {""} ;
      BC00618_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC00618_A3CliCod = new int[1] ;
      BC00618_A1EmpCod = new short[1] ;
      BC00618_A87MigrLegNumero = new int[1] ;
      sMode262 = "" ;
      BC00619_A2078MigrLegFamSec = new short[1] ;
      BC00619_A2079MigrLegFamParen = new String[] {""} ;
      BC00619_A2086MigrLegFamDiscap = new String[] {""} ;
      BC00619_A2080MigrLegFamNroDoc = new String[] {""} ;
      BC00619_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC00619_A2082MigrLegFamAdh = new String[] {""} ;
      BC00619_A2084MigrLegFamErrores = new String[] {""} ;
      BC00619_A2085MigrLegFamWarnings = new String[] {""} ;
      BC00619_A2088MigrLegFamNomApe = new String[] {""} ;
      BC00619_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC00619_A3CliCod = new int[1] ;
      BC00619_A1EmpCod = new short[1] ;
      BC00619_A87MigrLegNumero = new int[1] ;
      BC006113_A592MigrLegApellido = new String[] {""} ;
      BC006113_A593MigrLegNombre = new String[] {""} ;
      BC006113_A597MigrLegCUIL = new String[] {""} ;
      BC006114_A2078MigrLegFamSec = new short[1] ;
      BC006114_A2079MigrLegFamParen = new String[] {""} ;
      BC006114_A2086MigrLegFamDiscap = new String[] {""} ;
      BC006114_A2080MigrLegFamNroDoc = new String[] {""} ;
      BC006114_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC006114_A2082MigrLegFamAdh = new String[] {""} ;
      BC006114_A2084MigrLegFamErrores = new String[] {""} ;
      BC006114_A2085MigrLegFamWarnings = new String[] {""} ;
      BC006114_A592MigrLegApellido = new String[] {""} ;
      BC006114_A593MigrLegNombre = new String[] {""} ;
      BC006114_A597MigrLegCUIL = new String[] {""} ;
      BC006114_A2088MigrLegFamNomApe = new String[] {""} ;
      BC006114_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      BC006114_A3CliCod = new int[1] ;
      BC006114_A1EmpCod = new short[1] ;
      BC006114_A87MigrLegNumero = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC006115_A592MigrLegApellido = new String[] {""} ;
      BC006115_A593MigrLegNombre = new String[] {""} ;
      BC006115_A597MigrLegCUIL = new String[] {""} ;
      BC006116_A592MigrLegApellido = new String[] {""} ;
      BC006116_A593MigrLegNombre = new String[] {""} ;
      BC006116_A597MigrLegCUIL = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_legajofamilia_bc__default(),
         new Object[] {
             new Object[] {
            BC00612_A2078MigrLegFamSec, BC00612_A2079MigrLegFamParen, BC00612_A2086MigrLegFamDiscap, BC00612_A2080MigrLegFamNroDoc, BC00612_A2081MigrLegFamDedGan, BC00612_A2082MigrLegFamAdh, BC00612_A2084MigrLegFamErrores, BC00612_A2085MigrLegFamWarnings, BC00612_A2088MigrLegFamNomApe, BC00612_A2089MigrLegFamFecNac,
            BC00612_A3CliCod, BC00612_A1EmpCod, BC00612_A87MigrLegNumero
            }
            , new Object[] {
            BC00613_A2078MigrLegFamSec, BC00613_A2079MigrLegFamParen, BC00613_A2086MigrLegFamDiscap, BC00613_A2080MigrLegFamNroDoc, BC00613_A2081MigrLegFamDedGan, BC00613_A2082MigrLegFamAdh, BC00613_A2084MigrLegFamErrores, BC00613_A2085MigrLegFamWarnings, BC00613_A2088MigrLegFamNomApe, BC00613_A2089MigrLegFamFecNac,
            BC00613_A3CliCod, BC00613_A1EmpCod, BC00613_A87MigrLegNumero
            }
            , new Object[] {
            BC00614_A592MigrLegApellido, BC00614_A593MigrLegNombre, BC00614_A597MigrLegCUIL
            }
            , new Object[] {
            BC00615_A2078MigrLegFamSec, BC00615_A2079MigrLegFamParen, BC00615_A2086MigrLegFamDiscap, BC00615_A2080MigrLegFamNroDoc, BC00615_A2081MigrLegFamDedGan, BC00615_A2082MigrLegFamAdh, BC00615_A2084MigrLegFamErrores, BC00615_A2085MigrLegFamWarnings, BC00615_A592MigrLegApellido, BC00615_A593MigrLegNombre,
            BC00615_A597MigrLegCUIL, BC00615_A2088MigrLegFamNomApe, BC00615_A2089MigrLegFamFecNac, BC00615_A3CliCod, BC00615_A1EmpCod, BC00615_A87MigrLegNumero
            }
            , new Object[] {
            BC00616_A592MigrLegApellido, BC00616_A593MigrLegNombre, BC00616_A597MigrLegCUIL
            }
            , new Object[] {
            BC00617_A3CliCod, BC00617_A1EmpCod, BC00617_A87MigrLegNumero, BC00617_A2078MigrLegFamSec
            }
            , new Object[] {
            BC00618_A2078MigrLegFamSec, BC00618_A2079MigrLegFamParen, BC00618_A2086MigrLegFamDiscap, BC00618_A2080MigrLegFamNroDoc, BC00618_A2081MigrLegFamDedGan, BC00618_A2082MigrLegFamAdh, BC00618_A2084MigrLegFamErrores, BC00618_A2085MigrLegFamWarnings, BC00618_A2088MigrLegFamNomApe, BC00618_A2089MigrLegFamFecNac,
            BC00618_A3CliCod, BC00618_A1EmpCod, BC00618_A87MigrLegNumero
            }
            , new Object[] {
            BC00619_A2078MigrLegFamSec, BC00619_A2079MigrLegFamParen, BC00619_A2086MigrLegFamDiscap, BC00619_A2080MigrLegFamNroDoc, BC00619_A2081MigrLegFamDedGan, BC00619_A2082MigrLegFamAdh, BC00619_A2084MigrLegFamErrores, BC00619_A2085MigrLegFamWarnings, BC00619_A2088MigrLegFamNomApe, BC00619_A2089MigrLegFamFecNac,
            BC00619_A3CliCod, BC00619_A1EmpCod, BC00619_A87MigrLegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC006113_A592MigrLegApellido, BC006113_A593MigrLegNombre, BC006113_A597MigrLegCUIL
            }
            , new Object[] {
            BC006114_A2078MigrLegFamSec, BC006114_A2079MigrLegFamParen, BC006114_A2086MigrLegFamDiscap, BC006114_A2080MigrLegFamNroDoc, BC006114_A2081MigrLegFamDedGan, BC006114_A2082MigrLegFamAdh, BC006114_A2084MigrLegFamErrores, BC006114_A2085MigrLegFamWarnings, BC006114_A592MigrLegApellido, BC006114_A593MigrLegNombre,
            BC006114_A597MigrLegCUIL, BC006114_A2088MigrLegFamNomApe, BC006114_A2089MigrLegFamFecNac, BC006114_A3CliCod, BC006114_A1EmpCod, BC006114_A87MigrLegNumero
            }
            , new Object[] {
            BC006115_A592MigrLegApellido, BC006115_A593MigrLegNombre, BC006115_A597MigrLegCUIL
            }
            , new Object[] {
            BC006116_A592MigrLegApellido, BC006116_A593MigrLegNombre, BC006116_A597MigrLegCUIL
            }
         }
      );
      AV34Pgmname = "importacion_legajoFamilia_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12612 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z2078MigrLegFamSec ;
   private short A2078MigrLegFamSec ;
   private short AV8EmpCod ;
   private short AV10MigrLegFamSec ;
   private short RcdFound262 ;
   private short nIsDirty_262 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z87MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int AV7CliCod ;
   private int AV9MigrLegNumero ;
   private int GX_JID ;
   private int GXt_int11 ;
   private int GXv_int12[] ;
   private java.math.BigDecimal AV24MigrLegFamDedGan ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal Z2081MigrLegFamDedGan ;
   private java.math.BigDecimal A2081MigrLegFamDedGan ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV25MigrLegFamAdh ;
   private String GXv_char1[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV30MigrLegFamDiscap ;
   private String GXv_char5[] ;
   private String GXv_char7[] ;
   private String AV34Pgmname ;
   private String Z2086MigrLegFamDiscap ;
   private String A2086MigrLegFamDiscap ;
   private String Z2082MigrLegFamAdh ;
   private String A2082MigrLegFamAdh ;
   private String Z597MigrLegCUIL ;
   private String A597MigrLegCUIL ;
   private String sMode262 ;
   private java.util.Date AV33MigrLegFamFecNac ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date Z2089MigrLegFamFecNac ;
   private java.util.Date A2089MigrLegFamFecNac ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean9 ;
   private boolean GXv_boolean10[] ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z2084MigrLegFamErrores ;
   private String A2084MigrLegFamErrores ;
   private String Z2085MigrLegFamWarnings ;
   private String A2085MigrLegFamWarnings ;
   private String AV23MigrLegFamNroDoc ;
   private String AV22MigrLegFamParen ;
   private String Z2079MigrLegFamParen ;
   private String A2079MigrLegFamParen ;
   private String Z2080MigrLegFamNroDoc ;
   private String A2080MigrLegFamNroDoc ;
   private String Z2088MigrLegFamNomApe ;
   private String A2088MigrLegFamNomApe ;
   private String Z592MigrLegApellido ;
   private String A592MigrLegApellido ;
   private String Z593MigrLegNombre ;
   private String A593MigrLegNombre ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private web.Sdtimportacion_legajoFamilia bcimportacion_legajoFamilia ;
   private IDataStoreProvider pr_default ;
   private short[] BC00615_A2078MigrLegFamSec ;
   private String[] BC00615_A2079MigrLegFamParen ;
   private String[] BC00615_A2086MigrLegFamDiscap ;
   private String[] BC00615_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC00615_A2081MigrLegFamDedGan ;
   private String[] BC00615_A2082MigrLegFamAdh ;
   private String[] BC00615_A2084MigrLegFamErrores ;
   private String[] BC00615_A2085MigrLegFamWarnings ;
   private String[] BC00615_A592MigrLegApellido ;
   private String[] BC00615_A593MigrLegNombre ;
   private String[] BC00615_A597MigrLegCUIL ;
   private String[] BC00615_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC00615_A2089MigrLegFamFecNac ;
   private int[] BC00615_A3CliCod ;
   private short[] BC00615_A1EmpCod ;
   private int[] BC00615_A87MigrLegNumero ;
   private String[] BC00616_A592MigrLegApellido ;
   private String[] BC00616_A593MigrLegNombre ;
   private String[] BC00616_A597MigrLegCUIL ;
   private int[] BC00617_A3CliCod ;
   private short[] BC00617_A1EmpCod ;
   private int[] BC00617_A87MigrLegNumero ;
   private short[] BC00617_A2078MigrLegFamSec ;
   private short[] BC00618_A2078MigrLegFamSec ;
   private String[] BC00618_A2079MigrLegFamParen ;
   private String[] BC00618_A2086MigrLegFamDiscap ;
   private String[] BC00618_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC00618_A2081MigrLegFamDedGan ;
   private String[] BC00618_A2082MigrLegFamAdh ;
   private String[] BC00618_A2084MigrLegFamErrores ;
   private String[] BC00618_A2085MigrLegFamWarnings ;
   private String[] BC00618_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC00618_A2089MigrLegFamFecNac ;
   private int[] BC00618_A3CliCod ;
   private short[] BC00618_A1EmpCod ;
   private int[] BC00618_A87MigrLegNumero ;
   private short[] BC00619_A2078MigrLegFamSec ;
   private String[] BC00619_A2079MigrLegFamParen ;
   private String[] BC00619_A2086MigrLegFamDiscap ;
   private String[] BC00619_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC00619_A2081MigrLegFamDedGan ;
   private String[] BC00619_A2082MigrLegFamAdh ;
   private String[] BC00619_A2084MigrLegFamErrores ;
   private String[] BC00619_A2085MigrLegFamWarnings ;
   private String[] BC00619_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC00619_A2089MigrLegFamFecNac ;
   private int[] BC00619_A3CliCod ;
   private short[] BC00619_A1EmpCod ;
   private int[] BC00619_A87MigrLegNumero ;
   private String[] BC006113_A592MigrLegApellido ;
   private String[] BC006113_A593MigrLegNombre ;
   private String[] BC006113_A597MigrLegCUIL ;
   private short[] BC006114_A2078MigrLegFamSec ;
   private String[] BC006114_A2079MigrLegFamParen ;
   private String[] BC006114_A2086MigrLegFamDiscap ;
   private String[] BC006114_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC006114_A2081MigrLegFamDedGan ;
   private String[] BC006114_A2082MigrLegFamAdh ;
   private String[] BC006114_A2084MigrLegFamErrores ;
   private String[] BC006114_A2085MigrLegFamWarnings ;
   private String[] BC006114_A592MigrLegApellido ;
   private String[] BC006114_A593MigrLegNombre ;
   private String[] BC006114_A597MigrLegCUIL ;
   private String[] BC006114_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC006114_A2089MigrLegFamFecNac ;
   private int[] BC006114_A3CliCod ;
   private short[] BC006114_A1EmpCod ;
   private int[] BC006114_A87MigrLegNumero ;
   private String[] BC006115_A592MigrLegApellido ;
   private String[] BC006115_A593MigrLegNombre ;
   private String[] BC006115_A597MigrLegCUIL ;
   private String[] BC006116_A592MigrLegApellido ;
   private String[] BC006116_A593MigrLegNombre ;
   private String[] BC006116_A597MigrLegCUIL ;
   private short[] BC00612_A2078MigrLegFamSec ;
   private String[] BC00612_A2079MigrLegFamParen ;
   private String[] BC00612_A2086MigrLegFamDiscap ;
   private String[] BC00612_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC00612_A2081MigrLegFamDedGan ;
   private String[] BC00612_A2082MigrLegFamAdh ;
   private String[] BC00612_A2084MigrLegFamErrores ;
   private String[] BC00612_A2085MigrLegFamWarnings ;
   private String[] BC00612_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC00612_A2089MigrLegFamFecNac ;
   private int[] BC00612_A3CliCod ;
   private short[] BC00612_A1EmpCod ;
   private int[] BC00612_A87MigrLegNumero ;
   private short[] BC00613_A2078MigrLegFamSec ;
   private String[] BC00613_A2079MigrLegFamParen ;
   private String[] BC00613_A2086MigrLegFamDiscap ;
   private String[] BC00613_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] BC00613_A2081MigrLegFamDedGan ;
   private String[] BC00613_A2082MigrLegFamAdh ;
   private String[] BC00613_A2084MigrLegFamErrores ;
   private String[] BC00613_A2085MigrLegFamWarnings ;
   private String[] BC00613_A2088MigrLegFamNomApe ;
   private java.util.Date[] BC00613_A2089MigrLegFamFecNac ;
   private int[] BC00613_A3CliCod ;
   private short[] BC00613_A1EmpCod ;
   private int[] BC00613_A87MigrLegNumero ;
   private String[] BC00614_A592MigrLegApellido ;
   private String[] BC00614_A593MigrLegNombre ;
   private String[] BC00614_A597MigrLegCUIL ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext8[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
}

final  class importacion_legajofamilia_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00612", "SELECT MigrLegFamSec, MigrLegFamParen, MigrLegFamDiscap, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, EmpCod, MigrLegNumero FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?  FOR UPDATE OF importacion_legajoFamilia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00613", "SELECT MigrLegFamSec, MigrLegFamParen, MigrLegFamDiscap, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, EmpCod, MigrLegNumero FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00614", "SELECT MigrLegApellido, MigrLegNombre, MigrLegCUIL FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00615", "SELECT TM1.MigrLegFamSec, TM1.MigrLegFamParen, TM1.MigrLegFamDiscap, TM1.MigrLegFamNroDoc, TM1.MigrLegFamDedGan, TM1.MigrLegFamAdh, TM1.MigrLegFamErrores, TM1.MigrLegFamWarnings, T2.MigrLegApellido, T2.MigrLegNombre, T2.MigrLegCUIL, TM1.MigrLegFamNomApe, TM1.MigrLegFamFecNac, TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero FROM (importacion_legajoFamilia TM1 INNER JOIN importacion_legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.MigrLegNumero = TM1.MigrLegNumero) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.MigrLegNumero = ? and TM1.MigrLegFamSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero, TM1.MigrLegFamSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00616", "SELECT MigrLegApellido, MigrLegNombre, MigrLegCUIL FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00617", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00618", "SELECT MigrLegFamSec, MigrLegFamParen, MigrLegFamDiscap, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, EmpCod, MigrLegNumero FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00619", "SELECT MigrLegFamSec, MigrLegFamParen, MigrLegFamDiscap, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, EmpCod, MigrLegNumero FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?  FOR UPDATE OF importacion_legajoFamilia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC006110", "SAVEPOINT gxupdate;INSERT INTO importacion_legajoFamilia(MigrLegFamSec, MigrLegFamParen, MigrLegFamDiscap, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamErrores, MigrLegFamWarnings, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, EmpCod, MigrLegNumero) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC006111", "SAVEPOINT gxupdate;UPDATE importacion_legajoFamilia SET MigrLegFamParen=?, MigrLegFamDiscap=?, MigrLegFamNroDoc=?, MigrLegFamDedGan=?, MigrLegFamAdh=?, MigrLegFamErrores=?, MigrLegFamWarnings=?, MigrLegFamNomApe=?, MigrLegFamFecNac=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC006112", "SAVEPOINT gxupdate;DELETE FROM importacion_legajoFamilia  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC006113", "SELECT MigrLegApellido, MigrLegNombre, MigrLegCUIL FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC006114", "SELECT TM1.MigrLegFamSec, TM1.MigrLegFamParen, TM1.MigrLegFamDiscap, TM1.MigrLegFamNroDoc, TM1.MigrLegFamDedGan, TM1.MigrLegFamAdh, TM1.MigrLegFamErrores, TM1.MigrLegFamWarnings, T2.MigrLegApellido, T2.MigrLegNombre, T2.MigrLegCUIL, TM1.MigrLegFamNomApe, TM1.MigrLegFamFecNac, TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero FROM (importacion_legajoFamilia TM1 INNER JOIN importacion_legajo T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.MigrLegNumero = TM1.MigrLegNumero) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.MigrLegNumero = ? and TM1.MigrLegFamSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero, TM1.MigrLegFamSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC006115", "SELECT MigrLegApellido, MigrLegNombre, MigrLegCUIL FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC006116", "SELECT MigrLegApellido, MigrLegNombre, MigrLegCUIL FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 13);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 13);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((int[]) buf[13])[0] = rslt.getInt(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 13);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               ((int[]) buf[12])[0] = rslt.getInt(13);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 13);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 13);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((int[]) buf[13])[0] = rslt.getInt(14);
               ((short[]) buf[14])[0] = rslt.getShort(15);
               ((int[]) buf[15])[0] = rslt.getInt(16);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 13);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 13);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setInt(13, ((Number) parms[12]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 40, false);
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[3], 4);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               stmt.setVarchar(8, (String)parms[7], 40, false);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setInt(12, ((Number) parms[11]).intValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
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
      }
   }

}

