package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_liquidacion_bc extends GXWebPanel implements IGxSilentTrn
{
   public importacion_liquidacion_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_liquidacion_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_liquidacion_bc.class ));
   }

   public importacion_liquidacion_bc( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0276( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0276( ) ;
      standaloneModal( ) ;
      addRow0276( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z88ImpLiqSec = A88ImpLiqSec ;
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

   public void confirm_020( )
   {
      beforeValidate0276( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0276( ) ;
         }
         else
         {
            checkExtendedTable0276( ) ;
            if ( AnyError == 0 )
            {
               zm0276( 3) ;
            }
            closeExtendedTableCursors0276( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0276( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z658ImpLiqConFileNameAndType = A658ImpLiqConFileNameAndType ;
         Z636ImpLiqFec = A636ImpLiqFec ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z658ImpLiqConFileNameAndType = A658ImpLiqConFileNameAndType ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z636ImpLiqFec = A636ImpLiqFec ;
         Z637ImpLiqConFile = A637ImpLiqConFile ;
         Z639ImpLiqConFileType = A639ImpLiqConFileType ;
         Z638ImpLiqConFileName = A638ImpLiqConFileName ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0276( )
   {
      /* Using cursor BC00025 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound76 = (short)(1) ;
         A658ImpLiqConFileNameAndType = BC00025_A658ImpLiqConFileNameAndType[0] ;
         A636ImpLiqFec = BC00025_A636ImpLiqFec[0] ;
         A637ImpLiqConFile = BC00025_A637ImpLiqConFile[0] ;
         A639ImpLiqConFileType = BC00025_A639ImpLiqConFileType[0] ;
         A637ImpLiqConFile_Filetype = A639ImpLiqConFileType ;
         A638ImpLiqConFileName = BC00025_A638ImpLiqConFileName[0] ;
         A637ImpLiqConFile_Filename = A638ImpLiqConFileName ;
         zm0276( -2) ;
      }
      pr_default.close(3);
      onLoadActions0276( ) ;
   }

   public void onLoadActions0276( )
   {
      A658ImpLiqConFileNameAndType = GXutil.trim( A638ImpLiqConFileName) + "." + GXutil.trim( A639ImpLiqConFileType) ;
   }

   public void checkExtendedTable0276( )
   {
      nIsDirty_76 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00026 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      nIsDirty_76 = (short)(1) ;
      A658ImpLiqConFileNameAndType = GXutil.trim( A638ImpLiqConFileName) + "." + GXutil.trim( A639ImpLiqConFileType) ;
   }

   public void closeExtendedTableCursors0276( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey0276( )
   {
      /* Using cursor BC00027 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound76 = (short)(1) ;
      }
      else
      {
         RcdFound76 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00028 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0276( 2) ;
         RcdFound76 = (short)(1) ;
         A658ImpLiqConFileNameAndType = BC00028_A658ImpLiqConFileNameAndType[0] ;
         A88ImpLiqSec = BC00028_A88ImpLiqSec[0] ;
         A636ImpLiqFec = BC00028_A636ImpLiqFec[0] ;
         A637ImpLiqConFile = BC00028_A637ImpLiqConFile[0] ;
         A639ImpLiqConFileType = BC00028_A639ImpLiqConFileType[0] ;
         A637ImpLiqConFile_Filetype = A639ImpLiqConFileType ;
         A638ImpLiqConFileName = BC00028_A638ImpLiqConFileName[0] ;
         A637ImpLiqConFile_Filename = A638ImpLiqConFileName ;
         A3CliCod = BC00028_A3CliCod[0] ;
         A1EmpCod = BC00028_A1EmpCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         sMode76 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0276( ) ;
         if ( AnyError == 1 )
         {
            RcdFound76 = (short)(0) ;
            initializeNonKey0276( ) ;
         }
         Gx_mode = sMode76 ;
      }
      else
      {
         RcdFound76 = (short)(0) ;
         initializeNonKey0276( ) ;
         sMode76 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode76 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0276( ) ;
      if ( RcdFound76 == 0 )
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
      confirm_020( ) ;
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

   public void checkOptimisticConcurrency0276( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00029 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_liquidacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z658ImpLiqConFileNameAndType, BC00029_A658ImpLiqConFileNameAndType[0]) != 0 ) || !( GXutil.dateCompare(Z636ImpLiqFec, BC00029_A636ImpLiqFec[0]) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_liquidacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0276( )
   {
      beforeValidate0276( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0276( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0276( 0) ;
         checkOptimisticConcurrency0276( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0276( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0276( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000210 */
                  pr_default.execute(8, new Object[] {A658ImpLiqConFileNameAndType, Short.valueOf(A88ImpLiqSec), A636ImpLiqFec, A637ImpLiqConFile, A639ImpLiqConFileType, A638ImpLiqConFileName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion");
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
            load0276( ) ;
         }
         endLevel0276( ) ;
      }
      closeExtendedTableCursors0276( ) ;
   }

   public void update0276( )
   {
      beforeValidate0276( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0276( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0276( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0276( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0276( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000211 */
                  pr_default.execute(9, new Object[] {A658ImpLiqConFileNameAndType, A636ImpLiqFec, A639ImpLiqConFileType, A638ImpLiqConFileName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_liquidacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0276( ) ;
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
         endLevel0276( ) ;
      }
      closeExtendedTableCursors0276( ) ;
   }

   public void deferredUpdate0276( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000212 */
         pr_default.execute(10, new Object[] {A637ImpLiqConFile, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0276( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0276( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0276( ) ;
         afterConfirm0276( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0276( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000213 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion");
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
      sMode76 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0276( ) ;
      Gx_mode = sMode76 ;
   }

   public void onDeleteControls0276( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC000214 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_liquidacion_lsd_legajos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor BC000215 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_liquidacion_lsd", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor BC000216 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_liquidacion_detalle", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor BC000217 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "importacion_liquidacion_conceptos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void endLevel0276( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0276( ) ;
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

   public void scanKeyStart0276( )
   {
      /* Using cursor BC000218 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      RcdFound76 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound76 = (short)(1) ;
         A658ImpLiqConFileNameAndType = BC000218_A658ImpLiqConFileNameAndType[0] ;
         A88ImpLiqSec = BC000218_A88ImpLiqSec[0] ;
         A636ImpLiqFec = BC000218_A636ImpLiqFec[0] ;
         A637ImpLiqConFile = BC000218_A637ImpLiqConFile[0] ;
         A639ImpLiqConFileType = BC000218_A639ImpLiqConFileType[0] ;
         A637ImpLiqConFile_Filetype = A639ImpLiqConFileType ;
         A638ImpLiqConFileName = BC000218_A638ImpLiqConFileName[0] ;
         A637ImpLiqConFile_Filename = A638ImpLiqConFileName ;
         A3CliCod = BC000218_A3CliCod[0] ;
         A1EmpCod = BC000218_A1EmpCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0276( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound76 = (short)(0) ;
      scanKeyLoad0276( ) ;
   }

   public void scanKeyLoad0276( )
   {
      sMode76 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound76 = (short)(1) ;
         A658ImpLiqConFileNameAndType = BC000218_A658ImpLiqConFileNameAndType[0] ;
         A88ImpLiqSec = BC000218_A88ImpLiqSec[0] ;
         A636ImpLiqFec = BC000218_A636ImpLiqFec[0] ;
         A637ImpLiqConFile = BC000218_A637ImpLiqConFile[0] ;
         A639ImpLiqConFileType = BC000218_A639ImpLiqConFileType[0] ;
         A637ImpLiqConFile_Filetype = A639ImpLiqConFileType ;
         A638ImpLiqConFileName = BC000218_A638ImpLiqConFileName[0] ;
         A637ImpLiqConFile_Filename = A638ImpLiqConFileName ;
         A3CliCod = BC000218_A3CliCod[0] ;
         A1EmpCod = BC000218_A1EmpCod[0] ;
      }
      Gx_mode = sMode76 ;
   }

   public void scanKeyEnd0276( )
   {
      pr_default.close(16);
   }

   public void afterConfirm0276( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0276( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0276( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0276( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0276( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0276( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0276( )
   {
   }

   public void send_integrity_lvl_hashes0276( )
   {
   }

   public void addRow0276( )
   {
      VarsToRow76( bcimportacion_liquidacion) ;
   }

   public void readRow0276( )
   {
      RowToVars76( bcimportacion_liquidacion, 1) ;
   }

   public void initializeNonKey0276( )
   {
      A658ImpLiqConFileNameAndType = "" ;
      A636ImpLiqFec = GXutil.resetTime( GXutil.nullDate() );
      A637ImpLiqConFile = "" ;
      A639ImpLiqConFileType = "" ;
      A638ImpLiqConFileName = "" ;
      Z658ImpLiqConFileNameAndType = "" ;
      Z636ImpLiqFec = GXutil.resetTime( GXutil.nullDate() );
   }

   public void initAll0276( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A88ImpLiqSec = (short)(0) ;
      initializeNonKey0276( ) ;
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

   public void VarsToRow76( web.Sdtimportacion_liquidacion obj76 )
   {
      obj76.setgxTv_Sdtimportacion_liquidacion_Mode( Gx_mode );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype( A658ImpLiqConFileNameAndType );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqfec( A636ImpLiqFec );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqconfile( A637ImpLiqConFile );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype( A639ImpLiqConFileType );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqconfilename( A638ImpLiqConFileName );
      obj76.setgxTv_Sdtimportacion_liquidacion_Clicod( A3CliCod );
      obj76.setgxTv_Sdtimportacion_liquidacion_Empcod( A1EmpCod );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqsec( A88ImpLiqSec );
      obj76.setgxTv_Sdtimportacion_liquidacion_Clicod_Z( Z3CliCod );
      obj76.setgxTv_Sdtimportacion_liquidacion_Empcod_Z( Z1EmpCod );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqsec_Z( Z88ImpLiqSec );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqfec_Z( Z636ImpLiqFec );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z( Z638ImpLiqConFileName );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z( Z639ImpLiqConFileType );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z( Z658ImpLiqConFileNameAndType );
      obj76.setgxTv_Sdtimportacion_liquidacion_Mode( Gx_mode );
   }

   public void KeyVarsToRow76( web.Sdtimportacion_liquidacion obj76 )
   {
      obj76.setgxTv_Sdtimportacion_liquidacion_Clicod( A3CliCod );
      obj76.setgxTv_Sdtimportacion_liquidacion_Empcod( A1EmpCod );
      obj76.setgxTv_Sdtimportacion_liquidacion_Impliqsec( A88ImpLiqSec );
   }

   public void RowToVars76( web.Sdtimportacion_liquidacion obj76 ,
                            int forceLoad )
   {
      Gx_mode = obj76.getgxTv_Sdtimportacion_liquidacion_Mode() ;
      A658ImpLiqConFileNameAndType = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype() ;
      A636ImpLiqFec = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqfec() ;
      A637ImpLiqConFile = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfile() ;
      A639ImpLiqConFileType = ((GXutil.strcmp("", obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype())==0) ? com.genexus.util.GXFile.getgxFileext( A637ImpLiqConFile) : obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype()) ;
      A638ImpLiqConFileName = ((GXutil.strcmp("", obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfilename())==0) ? com.genexus.util.GXFile.getgxFilename( A637ImpLiqConFile) : obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfilename()) ;
      A3CliCod = obj76.getgxTv_Sdtimportacion_liquidacion_Clicod() ;
      A1EmpCod = obj76.getgxTv_Sdtimportacion_liquidacion_Empcod() ;
      A88ImpLiqSec = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqsec() ;
      Z3CliCod = obj76.getgxTv_Sdtimportacion_liquidacion_Clicod_Z() ;
      Z1EmpCod = obj76.getgxTv_Sdtimportacion_liquidacion_Empcod_Z() ;
      Z88ImpLiqSec = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqsec_Z() ;
      Z636ImpLiqFec = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqfec_Z() ;
      Z638ImpLiqConFileName = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfilename_Z() ;
      Z639ImpLiqConFileType = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfiletype_Z() ;
      Z658ImpLiqConFileNameAndType = obj76.getgxTv_Sdtimportacion_liquidacion_Impliqconfilenameandtype_Z() ;
      Gx_mode = obj76.getgxTv_Sdtimportacion_liquidacion_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A88ImpLiqSec = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0276( ) ;
      scanKeyStart0276( ) ;
      if ( RcdFound76 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000219 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(17) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
      }
      zm0276( -2) ;
      onLoadActions0276( ) ;
      addRow0276( ) ;
      scanKeyEnd0276( ) ;
      if ( RcdFound76 == 0 )
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
      RowToVars76( bcimportacion_liquidacion, 0) ;
      scanKeyStart0276( ) ;
      if ( RcdFound76 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000220 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(18) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
      }
      zm0276( -2) ;
      onLoadActions0276( ) ;
      addRow0276( ) ;
      scanKeyEnd0276( ) ;
      if ( RcdFound76 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0276( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0276( ) ;
      }
      else
      {
         if ( RcdFound76 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A88ImpLiqSec = Z88ImpLiqSec ;
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
               update0276( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) )
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
                     insert0276( ) ;
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
                     insert0276( ) ;
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
      RowToVars76( bcimportacion_liquidacion, 1) ;
      saveImpl( ) ;
      VarsToRow76( bcimportacion_liquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars76( bcimportacion_liquidacion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0276( ) ;
      afterTrn( ) ;
      VarsToRow76( bcimportacion_liquidacion) ;
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
         web.Sdtimportacion_liquidacion auxBC = new web.Sdtimportacion_liquidacion( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A88ImpLiqSec);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcimportacion_liquidacion);
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
      RowToVars76( bcimportacion_liquidacion, 1) ;
      updateImpl( ) ;
      VarsToRow76( bcimportacion_liquidacion) ;
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
      RowToVars76( bcimportacion_liquidacion, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0276( ) ;
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
      VarsToRow76( bcimportacion_liquidacion) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars76( bcimportacion_liquidacion, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0276( ) ;
      if ( RcdFound76 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A88ImpLiqSec = Z88ImpLiqSec ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_liquidacion_bc");
      VarsToRow76( bcimportacion_liquidacion) ;
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
      Gx_mode = bcimportacion_liquidacion.getgxTv_Sdtimportacion_liquidacion_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcimportacion_liquidacion.setgxTv_Sdtimportacion_liquidacion_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtimportacion_liquidacion sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcimportacion_liquidacion )
      {
         bcimportacion_liquidacion = sdt ;
         if ( GXutil.strcmp(bcimportacion_liquidacion.getgxTv_Sdtimportacion_liquidacion_Mode(), "") == 0 )
         {
            bcimportacion_liquidacion.setgxTv_Sdtimportacion_liquidacion_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow76( bcimportacion_liquidacion) ;
         }
         else
         {
            RowToVars76( bcimportacion_liquidacion, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcimportacion_liquidacion.getgxTv_Sdtimportacion_liquidacion_Mode(), "") == 0 )
         {
            bcimportacion_liquidacion.setgxTv_Sdtimportacion_liquidacion_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars76( bcimportacion_liquidacion, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtimportacion_liquidacion getimportacion_liquidacion_BC( )
   {
      return bcimportacion_liquidacion ;
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
      Z658ImpLiqConFileNameAndType = "" ;
      A658ImpLiqConFileNameAndType = "" ;
      Z636ImpLiqFec = GXutil.resetTime( GXutil.nullDate() );
      A636ImpLiqFec = GXutil.resetTime( GXutil.nullDate() );
      Z637ImpLiqConFile = "" ;
      A637ImpLiqConFile = "" ;
      Z639ImpLiqConFileType = "" ;
      A639ImpLiqConFileType = "" ;
      Z638ImpLiqConFileName = "" ;
      A638ImpLiqConFileName = "" ;
      BC00025_A658ImpLiqConFileNameAndType = new String[] {""} ;
      BC00025_A88ImpLiqSec = new short[1] ;
      BC00025_A636ImpLiqFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC00025_A637ImpLiqConFile = new String[] {""} ;
      BC00025_A639ImpLiqConFileType = new String[] {""} ;
      BC00025_A638ImpLiqConFileName = new String[] {""} ;
      BC00025_A3CliCod = new int[1] ;
      BC00025_A1EmpCod = new short[1] ;
      A637ImpLiqConFile_Filetype = "" ;
      A637ImpLiqConFile_Filename = "" ;
      BC00026_A3CliCod = new int[1] ;
      BC00027_A3CliCod = new int[1] ;
      BC00027_A1EmpCod = new short[1] ;
      BC00027_A88ImpLiqSec = new short[1] ;
      BC00028_A658ImpLiqConFileNameAndType = new String[] {""} ;
      BC00028_A88ImpLiqSec = new short[1] ;
      BC00028_A636ImpLiqFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC00028_A637ImpLiqConFile = new String[] {""} ;
      BC00028_A639ImpLiqConFileType = new String[] {""} ;
      BC00028_A638ImpLiqConFileName = new String[] {""} ;
      BC00028_A3CliCod = new int[1] ;
      BC00028_A1EmpCod = new short[1] ;
      sMode76 = "" ;
      BC00029_A658ImpLiqConFileNameAndType = new String[] {""} ;
      BC00029_A88ImpLiqSec = new short[1] ;
      BC00029_A636ImpLiqFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC00029_A637ImpLiqConFile = new String[] {""} ;
      BC00029_A639ImpLiqConFileType = new String[] {""} ;
      BC00029_A638ImpLiqConFileName = new String[] {""} ;
      BC00029_A3CliCod = new int[1] ;
      BC00029_A1EmpCod = new short[1] ;
      BC000214_A3CliCod = new int[1] ;
      BC000214_A1EmpCod = new short[1] ;
      BC000214_A88ImpLiqSec = new short[1] ;
      BC000214_A1770ImpLiqLSDCuil = new long[1] ;
      BC000215_A3CliCod = new int[1] ;
      BC000215_A1EmpCod = new short[1] ;
      BC000215_A88ImpLiqSec = new short[1] ;
      BC000215_A704ImpLiqLSDSec = new short[1] ;
      BC000216_A3CliCod = new int[1] ;
      BC000216_A1EmpCod = new short[1] ;
      BC000216_A88ImpLiqSec = new short[1] ;
      BC000216_A90ImpLiqDetSec = new short[1] ;
      BC000217_A3CliCod = new int[1] ;
      BC000217_A1EmpCod = new short[1] ;
      BC000217_A88ImpLiqSec = new short[1] ;
      BC000217_A89ImpLiqConExtCod = new String[] {""} ;
      BC000218_A658ImpLiqConFileNameAndType = new String[] {""} ;
      BC000218_A88ImpLiqSec = new short[1] ;
      BC000218_A636ImpLiqFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC000218_A637ImpLiqConFile = new String[] {""} ;
      BC000218_A639ImpLiqConFileType = new String[] {""} ;
      BC000218_A638ImpLiqConFileName = new String[] {""} ;
      BC000218_A3CliCod = new int[1] ;
      BC000218_A1EmpCod = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000219_A3CliCod = new int[1] ;
      BC000220_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_liquidacion_bc__default(),
         new Object[] {
             new Object[] {
            BC00022_A658ImpLiqConFileNameAndType, BC00022_A88ImpLiqSec, BC00022_A636ImpLiqFec, BC00022_A637ImpLiqConFile, BC00022_A639ImpLiqConFileType, BC00022_A638ImpLiqConFileName, BC00022_A3CliCod, BC00022_A1EmpCod
            }
            , new Object[] {
            BC00023_A658ImpLiqConFileNameAndType, BC00023_A88ImpLiqSec, BC00023_A636ImpLiqFec, BC00023_A637ImpLiqConFile, BC00023_A639ImpLiqConFileType, BC00023_A638ImpLiqConFileName, BC00023_A3CliCod, BC00023_A1EmpCod
            }
            , new Object[] {
            BC00024_A3CliCod
            }
            , new Object[] {
            BC00025_A658ImpLiqConFileNameAndType, BC00025_A88ImpLiqSec, BC00025_A636ImpLiqFec, BC00025_A637ImpLiqConFile, BC00025_A639ImpLiqConFileType, BC00025_A638ImpLiqConFileName, BC00025_A3CliCod, BC00025_A1EmpCod
            }
            , new Object[] {
            BC00026_A3CliCod
            }
            , new Object[] {
            BC00027_A3CliCod, BC00027_A1EmpCod, BC00027_A88ImpLiqSec
            }
            , new Object[] {
            BC00028_A658ImpLiqConFileNameAndType, BC00028_A88ImpLiqSec, BC00028_A636ImpLiqFec, BC00028_A637ImpLiqConFile, BC00028_A639ImpLiqConFileType, BC00028_A638ImpLiqConFileName, BC00028_A3CliCod, BC00028_A1EmpCod
            }
            , new Object[] {
            BC00029_A658ImpLiqConFileNameAndType, BC00029_A88ImpLiqSec, BC00029_A636ImpLiqFec, BC00029_A637ImpLiqConFile, BC00029_A639ImpLiqConFileType, BC00029_A638ImpLiqConFileName, BC00029_A3CliCod, BC00029_A1EmpCod
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
            BC000214_A3CliCod, BC000214_A1EmpCod, BC000214_A88ImpLiqSec, BC000214_A1770ImpLiqLSDCuil
            }
            , new Object[] {
            BC000215_A3CliCod, BC000215_A1EmpCod, BC000215_A88ImpLiqSec, BC000215_A704ImpLiqLSDSec
            }
            , new Object[] {
            BC000216_A3CliCod, BC000216_A1EmpCod, BC000216_A88ImpLiqSec, BC000216_A90ImpLiqDetSec
            }
            , new Object[] {
            BC000217_A3CliCod, BC000217_A1EmpCod, BC000217_A88ImpLiqSec, BC000217_A89ImpLiqConExtCod
            }
            , new Object[] {
            BC000218_A658ImpLiqConFileNameAndType, BC000218_A88ImpLiqSec, BC000218_A636ImpLiqFec, BC000218_A637ImpLiqConFile, BC000218_A639ImpLiqConFileType, BC000218_A638ImpLiqConFileName, BC000218_A3CliCod, BC000218_A1EmpCod
            }
            , new Object[] {
            BC000219_A3CliCod
            }
            , new Object[] {
            BC000220_A3CliCod
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z88ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short RcdFound76 ;
   private short nIsDirty_76 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z639ImpLiqConFileType ;
   private String A639ImpLiqConFileType ;
   private String A637ImpLiqConFile_Filetype ;
   private String A637ImpLiqConFile_Filename ;
   private String sMode76 ;
   private java.util.Date Z636ImpLiqFec ;
   private java.util.Date A636ImpLiqFec ;
   private boolean mustCommit ;
   private String Z637ImpLiqConFile ;
   private String A637ImpLiqConFile ;
   private String Z658ImpLiqConFileNameAndType ;
   private String A658ImpLiqConFileNameAndType ;
   private String Z638ImpLiqConFileName ;
   private String A638ImpLiqConFileName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.Sdtimportacion_liquidacion bcimportacion_liquidacion ;
   private IDataStoreProvider pr_default ;
   private String[] BC00025_A658ImpLiqConFileNameAndType ;
   private short[] BC00025_A88ImpLiqSec ;
   private java.util.Date[] BC00025_A636ImpLiqFec ;
   private String[] BC00025_A637ImpLiqConFile ;
   private String[] BC00025_A639ImpLiqConFileType ;
   private String[] BC00025_A638ImpLiqConFileName ;
   private int[] BC00025_A3CliCod ;
   private short[] BC00025_A1EmpCod ;
   private int[] BC00026_A3CliCod ;
   private int[] BC00027_A3CliCod ;
   private short[] BC00027_A1EmpCod ;
   private short[] BC00027_A88ImpLiqSec ;
   private String[] BC00028_A658ImpLiqConFileNameAndType ;
   private short[] BC00028_A88ImpLiqSec ;
   private java.util.Date[] BC00028_A636ImpLiqFec ;
   private String[] BC00028_A637ImpLiqConFile ;
   private String[] BC00028_A639ImpLiqConFileType ;
   private String[] BC00028_A638ImpLiqConFileName ;
   private int[] BC00028_A3CliCod ;
   private short[] BC00028_A1EmpCod ;
   private String[] BC00029_A658ImpLiqConFileNameAndType ;
   private short[] BC00029_A88ImpLiqSec ;
   private java.util.Date[] BC00029_A636ImpLiqFec ;
   private String[] BC00029_A637ImpLiqConFile ;
   private String[] BC00029_A639ImpLiqConFileType ;
   private String[] BC00029_A638ImpLiqConFileName ;
   private int[] BC00029_A3CliCod ;
   private short[] BC00029_A1EmpCod ;
   private int[] BC000214_A3CliCod ;
   private short[] BC000214_A1EmpCod ;
   private short[] BC000214_A88ImpLiqSec ;
   private long[] BC000214_A1770ImpLiqLSDCuil ;
   private int[] BC000215_A3CliCod ;
   private short[] BC000215_A1EmpCod ;
   private short[] BC000215_A88ImpLiqSec ;
   private short[] BC000215_A704ImpLiqLSDSec ;
   private int[] BC000216_A3CliCod ;
   private short[] BC000216_A1EmpCod ;
   private short[] BC000216_A88ImpLiqSec ;
   private short[] BC000216_A90ImpLiqDetSec ;
   private int[] BC000217_A3CliCod ;
   private short[] BC000217_A1EmpCod ;
   private short[] BC000217_A88ImpLiqSec ;
   private String[] BC000217_A89ImpLiqConExtCod ;
   private String[] BC000218_A658ImpLiqConFileNameAndType ;
   private short[] BC000218_A88ImpLiqSec ;
   private java.util.Date[] BC000218_A636ImpLiqFec ;
   private String[] BC000218_A637ImpLiqConFile ;
   private String[] BC000218_A639ImpLiqConFileType ;
   private String[] BC000218_A638ImpLiqConFileName ;
   private int[] BC000218_A3CliCod ;
   private short[] BC000218_A1EmpCod ;
   private int[] BC000219_A3CliCod ;
   private int[] BC000220_A3CliCod ;
   private String[] BC00022_A658ImpLiqConFileNameAndType ;
   private short[] BC00022_A88ImpLiqSec ;
   private java.util.Date[] BC00022_A636ImpLiqFec ;
   private String[] BC00022_A637ImpLiqConFile ;
   private String[] BC00022_A639ImpLiqConFileType ;
   private String[] BC00022_A638ImpLiqConFileName ;
   private int[] BC00022_A3CliCod ;
   private short[] BC00022_A1EmpCod ;
   private String[] BC00023_A658ImpLiqConFileNameAndType ;
   private short[] BC00023_A88ImpLiqSec ;
   private java.util.Date[] BC00023_A636ImpLiqFec ;
   private String[] BC00023_A637ImpLiqConFile ;
   private String[] BC00023_A639ImpLiqConFileType ;
   private String[] BC00023_A638ImpLiqConFileName ;
   private int[] BC00023_A3CliCod ;
   private short[] BC00023_A1EmpCod ;
   private int[] BC00024_A3CliCod ;
}

final  class importacion_liquidacion_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00022", "SELECT ImpLiqConFileNameAndType, ImpLiqSec, ImpLiqFec, ImpLiqConFile, ImpLiqConFileType, ImpLiqConFileName, CliCod, EmpCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?  FOR UPDATE OF importacion_liquidacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00023", "SELECT ImpLiqConFileNameAndType, ImpLiqSec, ImpLiqFec, ImpLiqConFile, ImpLiqConFileType, ImpLiqConFileName, CliCod, EmpCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00024", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00025", "SELECT TM1.ImpLiqConFileNameAndType, TM1.ImpLiqSec, TM1.ImpLiqFec, TM1.ImpLiqConFile, TM1.ImpLiqConFileType, TM1.ImpLiqConFileName, TM1.CliCod, TM1.EmpCod FROM importacion_liquidacion TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00026", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00027", "SELECT CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00028", "SELECT ImpLiqConFileNameAndType, ImpLiqSec, ImpLiqFec, ImpLiqConFile, ImpLiqConFileType, ImpLiqConFileName, CliCod, EmpCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00029", "SELECT ImpLiqConFileNameAndType, ImpLiqSec, ImpLiqFec, ImpLiqConFile, ImpLiqConFileType, ImpLiqConFileName, CliCod, EmpCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?  FOR UPDATE OF importacion_liquidacion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000210", "SAVEPOINT gxupdate;INSERT INTO importacion_liquidacion(ImpLiqConFileNameAndType, ImpLiqSec, ImpLiqFec, ImpLiqConFile, ImpLiqConFileType, ImpLiqConFileName, CliCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000211", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion SET ImpLiqConFileNameAndType=?, ImpLiqFec=?, ImpLiqConFileType=?, ImpLiqConFileName=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000212", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion SET ImpLiqConFile=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000213", "SAVEPOINT gxupdate;DELETE FROM importacion_liquidacion  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000214", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDCuil FROM importacion_liquidacion_lsd_legajos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000215", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000216", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqDetSec FROM importacion_liquidacion_detalle WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000217", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000218", "SELECT TM1.ImpLiqConFileNameAndType, TM1.ImpLiqSec, TM1.ImpLiqFec, TM1.ImpLiqConFile, TM1.ImpLiqConFileType, TM1.ImpLiqConFileName, TM1.CliCod, TM1.EmpCod FROM importacion_liquidacion TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000219", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000220", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getBLOBFile(4, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getBLOBFile(4, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getBLOBFile(4, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getBLOBFile(4, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getBLOBFile(4, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((String[]) buf[3])[0] = rslt.getBLOBFile(4, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 18 :
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               stmt.setBLOBFile(4, (String)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setDateTime(2, (java.util.Date)parms[1], false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 10 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

