package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class legajocc_bc extends GXWebPanel implements IGxSilentTrn
{
   public legajocc_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public legajocc_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajocc_bc.class ));
   }

   public legajocc_bc( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1X66( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1X66( ) ;
      standaloneModal( ) ;
      addRow1X66( ) ;
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
         e111X2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z6LegNumero = A6LegNumero ;
            Z77CenCodigo = A77CenCodigo ;
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

   public void confirm_1X0( )
   {
      beforeValidate1X66( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1X66( ) ;
         }
         else
         {
            checkExtendedTable1X66( ) ;
            if ( AnyError == 0 )
            {
               zm1X66( 3) ;
               zm1X66( 4) ;
            }
            closeExtendedTableCursors1X66( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e121X2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e111X2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1X66( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z484LegCenPrc = A484LegCenPrc ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z483CenDescripcion = A483CenDescripcion ;
      }
      if ( GX_JID == -2 )
      {
         Z484LegCenPrc = A484LegCenPrc ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z77CenCodigo = A77CenCodigo ;
         Z483CenDescripcion = A483CenDescripcion ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
   }

   public void load1X66( )
   {
      /* Using cursor BC001X6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A77CenCodigo)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound66 = (short)(1) ;
         A484LegCenPrc = BC001X6_A484LegCenPrc[0] ;
         A483CenDescripcion = BC001X6_A483CenDescripcion[0] ;
         zm1X66( -2) ;
      }
      pr_default.close(4);
      onLoadActions1X66( ) ;
   }

   public void onLoadActions1X66( )
   {
   }

   public void checkExtendedTable1X66( )
   {
      nIsDirty_66 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC001X7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC001X8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A77CenCodigo)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Centro De Costo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CENCODIGO");
         AnyError = (short)(1) ;
      }
      A483CenDescripcion = BC001X8_A483CenDescripcion[0] ;
      pr_default.close(6);
      if ( A484LegCenPrc.doubleValue() <= 0 )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Debe asignar Porcentaje", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1X66( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey1X66( )
   {
      /* Using cursor BC001X9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A77CenCodigo)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound66 = (short)(1) ;
      }
      else
      {
         RcdFound66 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001X10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A77CenCodigo)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm1X66( 2) ;
         RcdFound66 = (short)(1) ;
         A484LegCenPrc = BC001X10_A484LegCenPrc[0] ;
         A3CliCod = BC001X10_A3CliCod[0] ;
         A1EmpCod = BC001X10_A1EmpCod[0] ;
         A6LegNumero = BC001X10_A6LegNumero[0] ;
         A77CenCodigo = BC001X10_A77CenCodigo[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z77CenCodigo = A77CenCodigo ;
         sMode66 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1X66( ) ;
         if ( AnyError == 1 )
         {
            RcdFound66 = (short)(0) ;
            initializeNonKey1X66( ) ;
         }
         Gx_mode = sMode66 ;
      }
      else
      {
         RcdFound66 = (short)(0) ;
         initializeNonKey1X66( ) ;
         sMode66 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode66 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey1X66( ) ;
      if ( RcdFound66 == 0 )
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
      confirm_1X0( ) ;
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

   public void checkOptimisticConcurrency1X66( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001X11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A77CenCodigo)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoCC"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) || ( DecimalUtil.compareTo(Z484LegCenPrc, BC001X11_A484LegCenPrc[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"LegajoCC"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1X66( )
   {
      beforeValidate1X66( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1X66( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1X66( 0) ;
         checkOptimisticConcurrency1X66( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1X66( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1X66( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001X12 */
                  pr_default.execute(10, new Object[] {A484LegCenPrc, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A77CenCodigo)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoCC");
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
            load1X66( ) ;
         }
         endLevel1X66( ) ;
      }
      closeExtendedTableCursors1X66( ) ;
   }

   public void update1X66( )
   {
      beforeValidate1X66( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1X66( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1X66( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1X66( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1X66( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001X13 */
                  pr_default.execute(11, new Object[] {A484LegCenPrc, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A77CenCodigo)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoCC");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"LegajoCC"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1X66( ) ;
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
         endLevel1X66( ) ;
      }
      closeExtendedTableCursors1X66( ) ;
   }

   public void deferredUpdate1X66( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1X66( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1X66( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1X66( ) ;
         afterConfirm1X66( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1X66( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001X14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A77CenCodigo)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LegajoCC");
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
      sMode66 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1X66( ) ;
      Gx_mode = sMode66 ;
   }

   public void onDeleteControls1X66( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC001X15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A77CenCodigo)});
         A483CenDescripcion = BC001X15_A483CenDescripcion[0] ;
         pr_default.close(13);
      }
   }

   public void endLevel1X66( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1X66( ) ;
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

   public void scanKeyStart1X66( )
   {
      /* Scan By routine */
      /* Using cursor BC001X16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A77CenCodigo)});
      RcdFound66 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound66 = (short)(1) ;
         A484LegCenPrc = BC001X16_A484LegCenPrc[0] ;
         A483CenDescripcion = BC001X16_A483CenDescripcion[0] ;
         A3CliCod = BC001X16_A3CliCod[0] ;
         A1EmpCod = BC001X16_A1EmpCod[0] ;
         A6LegNumero = BC001X16_A6LegNumero[0] ;
         A77CenCodigo = BC001X16_A77CenCodigo[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1X66( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound66 = (short)(0) ;
      scanKeyLoad1X66( ) ;
   }

   public void scanKeyLoad1X66( )
   {
      sMode66 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound66 = (short)(1) ;
         A484LegCenPrc = BC001X16_A484LegCenPrc[0] ;
         A483CenDescripcion = BC001X16_A483CenDescripcion[0] ;
         A3CliCod = BC001X16_A3CliCod[0] ;
         A1EmpCod = BC001X16_A1EmpCod[0] ;
         A6LegNumero = BC001X16_A6LegNumero[0] ;
         A77CenCodigo = BC001X16_A77CenCodigo[0] ;
      }
      Gx_mode = sMode66 ;
   }

   public void scanKeyEnd1X66( )
   {
      pr_default.close(14);
   }

   public void afterConfirm1X66( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1X66( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1X66( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1X66( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1X66( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1X66( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1X66( )
   {
   }

   public void send_integrity_lvl_hashes1X66( )
   {
   }

   public void addRow1X66( )
   {
      VarsToRow66( bcLegajoCC) ;
   }

   public void readRow1X66( )
   {
      RowToVars66( bcLegajoCC, 1) ;
   }

   public void initializeNonKey1X66( )
   {
      A484LegCenPrc = DecimalUtil.ZERO ;
      A483CenDescripcion = "" ;
      Z484LegCenPrc = DecimalUtil.ZERO ;
   }

   public void initAll1X66( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A6LegNumero = 0 ;
      A77CenCodigo = (short)(0) ;
      initializeNonKey1X66( ) ;
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

   public void VarsToRow66( web.SdtLegajoCC obj66 )
   {
      obj66.setgxTv_SdtLegajoCC_Mode( Gx_mode );
      obj66.setgxTv_SdtLegajoCC_Legcenprc( A484LegCenPrc );
      obj66.setgxTv_SdtLegajoCC_Cendescripcion( A483CenDescripcion );
      obj66.setgxTv_SdtLegajoCC_Clicod( A3CliCod );
      obj66.setgxTv_SdtLegajoCC_Empcod( A1EmpCod );
      obj66.setgxTv_SdtLegajoCC_Legnumero( A6LegNumero );
      obj66.setgxTv_SdtLegajoCC_Cencodigo( A77CenCodigo );
      obj66.setgxTv_SdtLegajoCC_Clicod_Z( Z3CliCod );
      obj66.setgxTv_SdtLegajoCC_Empcod_Z( Z1EmpCod );
      obj66.setgxTv_SdtLegajoCC_Legnumero_Z( Z6LegNumero );
      obj66.setgxTv_SdtLegajoCC_Cencodigo_Z( Z77CenCodigo );
      obj66.setgxTv_SdtLegajoCC_Legcenprc_Z( Z484LegCenPrc );
      obj66.setgxTv_SdtLegajoCC_Cendescripcion_Z( Z483CenDescripcion );
      obj66.setgxTv_SdtLegajoCC_Mode( Gx_mode );
   }

   public void KeyVarsToRow66( web.SdtLegajoCC obj66 )
   {
      obj66.setgxTv_SdtLegajoCC_Clicod( A3CliCod );
      obj66.setgxTv_SdtLegajoCC_Empcod( A1EmpCod );
      obj66.setgxTv_SdtLegajoCC_Legnumero( A6LegNumero );
      obj66.setgxTv_SdtLegajoCC_Cencodigo( A77CenCodigo );
   }

   public void RowToVars66( web.SdtLegajoCC obj66 ,
                            int forceLoad )
   {
      Gx_mode = obj66.getgxTv_SdtLegajoCC_Mode() ;
      A484LegCenPrc = obj66.getgxTv_SdtLegajoCC_Legcenprc() ;
      A483CenDescripcion = obj66.getgxTv_SdtLegajoCC_Cendescripcion() ;
      A3CliCod = obj66.getgxTv_SdtLegajoCC_Clicod() ;
      A1EmpCod = obj66.getgxTv_SdtLegajoCC_Empcod() ;
      A6LegNumero = obj66.getgxTv_SdtLegajoCC_Legnumero() ;
      A77CenCodigo = obj66.getgxTv_SdtLegajoCC_Cencodigo() ;
      Z3CliCod = obj66.getgxTv_SdtLegajoCC_Clicod_Z() ;
      Z1EmpCod = obj66.getgxTv_SdtLegajoCC_Empcod_Z() ;
      Z6LegNumero = obj66.getgxTv_SdtLegajoCC_Legnumero_Z() ;
      Z77CenCodigo = obj66.getgxTv_SdtLegajoCC_Cencodigo_Z() ;
      Z484LegCenPrc = obj66.getgxTv_SdtLegajoCC_Legcenprc_Z() ;
      Z483CenDescripcion = obj66.getgxTv_SdtLegajoCC_Cendescripcion_Z() ;
      Gx_mode = obj66.getgxTv_SdtLegajoCC_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      A77CenCodigo = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1X66( ) ;
      scanKeyStart1X66( ) ;
      if ( RcdFound66 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001X17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(15) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor BC001X18 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A77CenCodigo)});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Centro De Costo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CENCODIGO");
            AnyError = (short)(1) ;
         }
         A483CenDescripcion = BC001X18_A483CenDescripcion[0] ;
         pr_default.close(16);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z77CenCodigo = A77CenCodigo ;
      }
      zm1X66( -2) ;
      onLoadActions1X66( ) ;
      addRow1X66( ) ;
      scanKeyEnd1X66( ) ;
      if ( RcdFound66 == 0 )
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
      RowToVars66( bcLegajoCC, 0) ;
      scanKeyStart1X66( ) ;
      if ( RcdFound66 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001X19 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero)});
         if ( (pr_default.getStatus(17) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Legajo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "LEGNUMERO");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor BC001X20 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A77CenCodigo)});
         if ( (pr_default.getStatus(18) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Centro De Costo", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CENCODIGO");
            AnyError = (short)(1) ;
         }
         A483CenDescripcion = BC001X20_A483CenDescripcion[0] ;
         pr_default.close(18);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z6LegNumero = A6LegNumero ;
         Z77CenCodigo = A77CenCodigo ;
      }
      zm1X66( -2) ;
      onLoadActions1X66( ) ;
      addRow1X66( ) ;
      scanKeyEnd1X66( ) ;
      if ( RcdFound66 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1X66( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1X66( ) ;
      }
      else
      {
         if ( RcdFound66 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A77CenCodigo != Z77CenCodigo ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A6LegNumero = Z6LegNumero ;
               A77CenCodigo = Z77CenCodigo ;
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
               update1X66( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A77CenCodigo != Z77CenCodigo ) )
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
                     insert1X66( ) ;
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
                     insert1X66( ) ;
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
      RowToVars66( bcLegajoCC, 1) ;
      saveImpl( ) ;
      VarsToRow66( bcLegajoCC) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars66( bcLegajoCC, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1X66( ) ;
      afterTrn( ) ;
      VarsToRow66( bcLegajoCC) ;
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
         web.SdtLegajoCC auxBC = new web.SdtLegajoCC( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A6LegNumero, A77CenCodigo);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcLegajoCC);
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
      RowToVars66( bcLegajoCC, 1) ;
      updateImpl( ) ;
      VarsToRow66( bcLegajoCC) ;
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
      RowToVars66( bcLegajoCC, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1X66( ) ;
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
      VarsToRow66( bcLegajoCC) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars66( bcLegajoCC, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1X66( ) ;
      if ( RcdFound66 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A77CenCodigo != Z77CenCodigo ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A6LegNumero = Z6LegNumero ;
            A77CenCodigo = Z77CenCodigo ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A6LegNumero != Z6LegNumero ) || ( A77CenCodigo != Z77CenCodigo ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "legajocc_bc");
      VarsToRow66( bcLegajoCC) ;
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
      Gx_mode = bcLegajoCC.getgxTv_SdtLegajoCC_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcLegajoCC.setgxTv_SdtLegajoCC_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtLegajoCC sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcLegajoCC )
      {
         bcLegajoCC = sdt ;
         if ( GXutil.strcmp(bcLegajoCC.getgxTv_SdtLegajoCC_Mode(), "") == 0 )
         {
            bcLegajoCC.setgxTv_SdtLegajoCC_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow66( bcLegajoCC) ;
         }
         else
         {
            RowToVars66( bcLegajoCC, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcLegajoCC.getgxTv_SdtLegajoCC_Mode(), "") == 0 )
         {
            bcLegajoCC.setgxTv_SdtLegajoCC_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars66( bcLegajoCC, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtLegajoCC getLegajoCC_BC( )
   {
      return bcLegajoCC ;
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
      Z484LegCenPrc = DecimalUtil.ZERO ;
      A484LegCenPrc = DecimalUtil.ZERO ;
      Z483CenDescripcion = "" ;
      A483CenDescripcion = "" ;
      BC001X6_A484LegCenPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001X6_A483CenDescripcion = new String[] {""} ;
      BC001X6_A3CliCod = new int[1] ;
      BC001X6_A1EmpCod = new short[1] ;
      BC001X6_A6LegNumero = new int[1] ;
      BC001X6_A77CenCodigo = new short[1] ;
      BC001X7_A3CliCod = new int[1] ;
      BC001X8_A483CenDescripcion = new String[] {""} ;
      BC001X9_A3CliCod = new int[1] ;
      BC001X9_A1EmpCod = new short[1] ;
      BC001X9_A6LegNumero = new int[1] ;
      BC001X9_A77CenCodigo = new short[1] ;
      BC001X10_A484LegCenPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001X10_A3CliCod = new int[1] ;
      BC001X10_A1EmpCod = new short[1] ;
      BC001X10_A6LegNumero = new int[1] ;
      BC001X10_A77CenCodigo = new short[1] ;
      sMode66 = "" ;
      BC001X11_A484LegCenPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001X11_A3CliCod = new int[1] ;
      BC001X11_A1EmpCod = new short[1] ;
      BC001X11_A6LegNumero = new int[1] ;
      BC001X11_A77CenCodigo = new short[1] ;
      BC001X15_A483CenDescripcion = new String[] {""} ;
      BC001X16_A484LegCenPrc = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC001X16_A483CenDescripcion = new String[] {""} ;
      BC001X16_A3CliCod = new int[1] ;
      BC001X16_A1EmpCod = new short[1] ;
      BC001X16_A6LegNumero = new int[1] ;
      BC001X16_A77CenCodigo = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001X17_A3CliCod = new int[1] ;
      BC001X18_A483CenDescripcion = new String[] {""} ;
      BC001X19_A3CliCod = new int[1] ;
      BC001X20_A483CenDescripcion = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajocc_bc__default(),
         new Object[] {
             new Object[] {
            BC001X2_A484LegCenPrc, BC001X2_A3CliCod, BC001X2_A1EmpCod, BC001X2_A6LegNumero, BC001X2_A77CenCodigo
            }
            , new Object[] {
            BC001X3_A484LegCenPrc, BC001X3_A3CliCod, BC001X3_A1EmpCod, BC001X3_A6LegNumero, BC001X3_A77CenCodigo
            }
            , new Object[] {
            BC001X4_A3CliCod
            }
            , new Object[] {
            BC001X5_A483CenDescripcion
            }
            , new Object[] {
            BC001X6_A484LegCenPrc, BC001X6_A483CenDescripcion, BC001X6_A3CliCod, BC001X6_A1EmpCod, BC001X6_A6LegNumero, BC001X6_A77CenCodigo
            }
            , new Object[] {
            BC001X7_A3CliCod
            }
            , new Object[] {
            BC001X8_A483CenDescripcion
            }
            , new Object[] {
            BC001X9_A3CliCod, BC001X9_A1EmpCod, BC001X9_A6LegNumero, BC001X9_A77CenCodigo
            }
            , new Object[] {
            BC001X10_A484LegCenPrc, BC001X10_A3CliCod, BC001X10_A1EmpCod, BC001X10_A6LegNumero, BC001X10_A77CenCodigo
            }
            , new Object[] {
            BC001X11_A484LegCenPrc, BC001X11_A3CliCod, BC001X11_A1EmpCod, BC001X11_A6LegNumero, BC001X11_A77CenCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001X15_A483CenDescripcion
            }
            , new Object[] {
            BC001X16_A484LegCenPrc, BC001X16_A483CenDescripcion, BC001X16_A3CliCod, BC001X16_A1EmpCod, BC001X16_A6LegNumero, BC001X16_A77CenCodigo
            }
            , new Object[] {
            BC001X17_A3CliCod
            }
            , new Object[] {
            BC001X18_A483CenDescripcion
            }
            , new Object[] {
            BC001X19_A3CliCod
            }
            , new Object[] {
            BC001X20_A483CenDescripcion
            }
         }
      );
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e121X2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z77CenCodigo ;
   private short A77CenCodigo ;
   private short RcdFound66 ;
   private short nIsDirty_66 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int Z6LegNumero ;
   private int A6LegNumero ;
   private int GX_JID ;
   private java.math.BigDecimal Z484LegCenPrc ;
   private java.math.BigDecimal A484LegCenPrc ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode66 ;
   private boolean returnInSub ;
   private boolean mustCommit ;
   private String Z483CenDescripcion ;
   private String A483CenDescripcion ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.SdtLegajoCC bcLegajoCC ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] BC001X6_A484LegCenPrc ;
   private String[] BC001X6_A483CenDescripcion ;
   private int[] BC001X6_A3CliCod ;
   private short[] BC001X6_A1EmpCod ;
   private int[] BC001X6_A6LegNumero ;
   private short[] BC001X6_A77CenCodigo ;
   private int[] BC001X7_A3CliCod ;
   private String[] BC001X8_A483CenDescripcion ;
   private int[] BC001X9_A3CliCod ;
   private short[] BC001X9_A1EmpCod ;
   private int[] BC001X9_A6LegNumero ;
   private short[] BC001X9_A77CenCodigo ;
   private java.math.BigDecimal[] BC001X10_A484LegCenPrc ;
   private int[] BC001X10_A3CliCod ;
   private short[] BC001X10_A1EmpCod ;
   private int[] BC001X10_A6LegNumero ;
   private short[] BC001X10_A77CenCodigo ;
   private java.math.BigDecimal[] BC001X11_A484LegCenPrc ;
   private int[] BC001X11_A3CliCod ;
   private short[] BC001X11_A1EmpCod ;
   private int[] BC001X11_A6LegNumero ;
   private short[] BC001X11_A77CenCodigo ;
   private String[] BC001X15_A483CenDescripcion ;
   private java.math.BigDecimal[] BC001X16_A484LegCenPrc ;
   private String[] BC001X16_A483CenDescripcion ;
   private int[] BC001X16_A3CliCod ;
   private short[] BC001X16_A1EmpCod ;
   private int[] BC001X16_A6LegNumero ;
   private short[] BC001X16_A77CenCodigo ;
   private int[] BC001X17_A3CliCod ;
   private String[] BC001X18_A483CenDescripcion ;
   private int[] BC001X19_A3CliCod ;
   private String[] BC001X20_A483CenDescripcion ;
   private java.math.BigDecimal[] BC001X2_A484LegCenPrc ;
   private int[] BC001X2_A3CliCod ;
   private short[] BC001X2_A1EmpCod ;
   private int[] BC001X2_A6LegNumero ;
   private short[] BC001X2_A77CenCodigo ;
   private java.math.BigDecimal[] BC001X3_A484LegCenPrc ;
   private int[] BC001X3_A3CliCod ;
   private short[] BC001X3_A1EmpCod ;
   private int[] BC001X3_A6LegNumero ;
   private short[] BC001X3_A77CenCodigo ;
   private int[] BC001X4_A3CliCod ;
   private String[] BC001X5_A483CenDescripcion ;
}

final  class legajocc_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC001X2", "SELECT LegCenPrc, CliCod, EmpCod, LegNumero, CenCodigo FROM LegajoCC WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND CenCodigo = ?  FOR UPDATE OF LegajoCC",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X3", "SELECT LegCenPrc, CliCod, EmpCod, LegNumero, CenCodigo FROM LegajoCC WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND CenCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X4", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X5", "SELECT CenDescripcion FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ? AND CenCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X6", "SELECT TM1.LegCenPrc, T2.CenDescripcion, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.CenCodigo FROM (LegajoCC TM1 INNER JOIN CentroDeCosto T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.CenCodigo = TM1.CenCodigo) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.CenCodigo = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.CenCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X7", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X8", "SELECT CenDescripcion FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ? AND CenCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X9", "SELECT CliCod, EmpCod, LegNumero, CenCodigo FROM LegajoCC WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND CenCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X10", "SELECT LegCenPrc, CliCod, EmpCod, LegNumero, CenCodigo FROM LegajoCC WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND CenCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X11", "SELECT LegCenPrc, CliCod, EmpCod, LegNumero, CenCodigo FROM LegajoCC WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND CenCodigo = ?  FOR UPDATE OF LegajoCC",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001X12", "SAVEPOINT gxupdate;INSERT INTO LegajoCC(LegCenPrc, CliCod, EmpCod, LegNumero, CenCodigo) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001X13", "SAVEPOINT gxupdate;UPDATE LegajoCC SET LegCenPrc=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND CenCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001X14", "SAVEPOINT gxupdate;DELETE FROM LegajoCC  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND CenCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001X15", "SELECT CenDescripcion FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ? AND CenCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X16", "SELECT TM1.LegCenPrc, T2.CenDescripcion, TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.CenCodigo FROM (LegajoCC TM1 INNER JOIN CentroDeCosto T2 ON T2.CliCod = TM1.CliCod AND T2.EmpCod = TM1.EmpCod AND T2.CenCodigo = TM1.CenCodigo) WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.LegNumero = ? and TM1.CenCodigo = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.LegNumero, TM1.CenCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X17", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X18", "SELECT CenDescripcion FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ? AND CenCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X19", "SELECT CliCod FROM Legajo WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001X20", "SELECT CenDescripcion FROM CentroDeCosto WHERE CliCod = ? AND EmpCod = ? AND CenCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 8 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 9 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 10 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 11 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

