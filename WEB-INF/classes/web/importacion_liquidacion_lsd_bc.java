package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_liquidacion_lsd_bc extends GXWebPanel implements IGxSilentTrn
{
   public importacion_liquidacion_lsd_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_liquidacion_lsd_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_liquidacion_lsd_bc.class ));
   }

   public importacion_liquidacion_lsd_bc( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow2C79( ) ;
      standaloneNotModal( ) ;
      initializeNonKey2C79( ) ;
      standaloneModal( ) ;
      addRow2C79( ) ;
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
            Z704ImpLiqLSDSec = A704ImpLiqLSDSec ;
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

   public void confirm_2C0( )
   {
      beforeValidate2C79( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2C79( ) ;
         }
         else
         {
            checkExtendedTable2C79( ) ;
            if ( AnyError == 0 )
            {
               zm2C79( 3) ;
            }
            closeExtendedTableCursors2C79( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm2C79( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z708ImpLiqLSDFileNameAndType = A708ImpLiqLSDFileNameAndType ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z708ImpLiqLSDFileNameAndType = A708ImpLiqLSDFileNameAndType ;
         Z704ImpLiqLSDSec = A704ImpLiqLSDSec ;
         Z705ImpLiqLSDFile = A705ImpLiqLSDFile ;
         Z707ImpLiqLSDFileType = A707ImpLiqLSDFileType ;
         Z706ImpLiqLSDFileName = A706ImpLiqLSDFileName ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load2C79( )
   {
      /* Using cursor BC002C5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound79 = (short)(1) ;
         A708ImpLiqLSDFileNameAndType = BC002C5_A708ImpLiqLSDFileNameAndType[0] ;
         A705ImpLiqLSDFile = BC002C5_A705ImpLiqLSDFile[0] ;
         A707ImpLiqLSDFileType = BC002C5_A707ImpLiqLSDFileType[0] ;
         A705ImpLiqLSDFile_Filetype = A707ImpLiqLSDFileType ;
         A706ImpLiqLSDFileName = BC002C5_A706ImpLiqLSDFileName[0] ;
         A705ImpLiqLSDFile_Filename = A706ImpLiqLSDFileName ;
         zm2C79( -2) ;
      }
      pr_default.close(3);
      onLoadActions2C79( ) ;
   }

   public void onLoadActions2C79( )
   {
      A708ImpLiqLSDFileNameAndType = GXutil.trim( A706ImpLiqLSDFileName) + "." + GXutil.trim( A707ImpLiqLSDFileType) ;
   }

   public void checkExtendedTable2C79( )
   {
      nIsDirty_79 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC002C6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      nIsDirty_79 = (short)(1) ;
      A708ImpLiqLSDFileNameAndType = GXutil.trim( A706ImpLiqLSDFileName) + "." + GXutil.trim( A707ImpLiqLSDFileType) ;
   }

   public void closeExtendedTableCursors2C79( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey2C79( )
   {
      /* Using cursor BC002C7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound79 = (short)(1) ;
      }
      else
      {
         RcdFound79 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC002C8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm2C79( 2) ;
         RcdFound79 = (short)(1) ;
         A708ImpLiqLSDFileNameAndType = BC002C8_A708ImpLiqLSDFileNameAndType[0] ;
         A704ImpLiqLSDSec = BC002C8_A704ImpLiqLSDSec[0] ;
         A705ImpLiqLSDFile = BC002C8_A705ImpLiqLSDFile[0] ;
         A707ImpLiqLSDFileType = BC002C8_A707ImpLiqLSDFileType[0] ;
         A705ImpLiqLSDFile_Filetype = A707ImpLiqLSDFileType ;
         A706ImpLiqLSDFileName = BC002C8_A706ImpLiqLSDFileName[0] ;
         A705ImpLiqLSDFile_Filename = A706ImpLiqLSDFileName ;
         A3CliCod = BC002C8_A3CliCod[0] ;
         A1EmpCod = BC002C8_A1EmpCod[0] ;
         A88ImpLiqSec = BC002C8_A88ImpLiqSec[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z704ImpLiqLSDSec = A704ImpLiqLSDSec ;
         sMode79 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load2C79( ) ;
         if ( AnyError == 1 )
         {
            RcdFound79 = (short)(0) ;
            initializeNonKey2C79( ) ;
         }
         Gx_mode = sMode79 ;
      }
      else
      {
         RcdFound79 = (short)(0) ;
         initializeNonKey2C79( ) ;
         sMode79 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode79 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey2C79( ) ;
      if ( RcdFound79 == 0 )
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
      confirm_2C0( ) ;
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

   public void checkOptimisticConcurrency2C79( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002C9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_liquidacion_lsd"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z708ImpLiqLSDFileNameAndType, BC002C9_A708ImpLiqLSDFileNameAndType[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_liquidacion_lsd"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2C79( )
   {
      beforeValidate2C79( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2C79( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2C79( 0) ;
         checkOptimisticConcurrency2C79( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2C79( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2C79( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002C10 */
                  pr_default.execute(8, new Object[] {A708ImpLiqLSDFileNameAndType, Short.valueOf(A704ImpLiqLSDSec), A705ImpLiqLSDFile, A707ImpLiqLSDFileType, A706ImpLiqLSDFileName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd");
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
            load2C79( ) ;
         }
         endLevel2C79( ) ;
      }
      closeExtendedTableCursors2C79( ) ;
   }

   public void update2C79( )
   {
      beforeValidate2C79( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2C79( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2C79( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2C79( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2C79( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002C11 */
                  pr_default.execute(9, new Object[] {A708ImpLiqLSDFileNameAndType, A707ImpLiqLSDFileType, A706ImpLiqLSDFileName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_liquidacion_lsd"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2C79( ) ;
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
         endLevel2C79( ) ;
      }
      closeExtendedTableCursors2C79( ) ;
   }

   public void deferredUpdate2C79( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC002C12 */
         pr_default.execute(10, new Object[] {A705ImpLiqLSDFile, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2C79( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2C79( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2C79( ) ;
         afterConfirm2C79( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2C79( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002C13 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd");
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
      sMode79 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2C79( ) ;
      Gx_mode = sMode79 ;
   }

   public void onDeleteControls2C79( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2C79( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2C79( ) ;
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

   public void scanKeyStart2C79( )
   {
      /* Using cursor BC002C14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Short.valueOf(A704ImpLiqLSDSec)});
      RcdFound79 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound79 = (short)(1) ;
         A708ImpLiqLSDFileNameAndType = BC002C14_A708ImpLiqLSDFileNameAndType[0] ;
         A704ImpLiqLSDSec = BC002C14_A704ImpLiqLSDSec[0] ;
         A705ImpLiqLSDFile = BC002C14_A705ImpLiqLSDFile[0] ;
         A707ImpLiqLSDFileType = BC002C14_A707ImpLiqLSDFileType[0] ;
         A705ImpLiqLSDFile_Filetype = A707ImpLiqLSDFileType ;
         A706ImpLiqLSDFileName = BC002C14_A706ImpLiqLSDFileName[0] ;
         A705ImpLiqLSDFile_Filename = A706ImpLiqLSDFileName ;
         A3CliCod = BC002C14_A3CliCod[0] ;
         A1EmpCod = BC002C14_A1EmpCod[0] ;
         A88ImpLiqSec = BC002C14_A88ImpLiqSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2C79( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound79 = (short)(0) ;
      scanKeyLoad2C79( ) ;
   }

   public void scanKeyLoad2C79( )
   {
      sMode79 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound79 = (short)(1) ;
         A708ImpLiqLSDFileNameAndType = BC002C14_A708ImpLiqLSDFileNameAndType[0] ;
         A704ImpLiqLSDSec = BC002C14_A704ImpLiqLSDSec[0] ;
         A705ImpLiqLSDFile = BC002C14_A705ImpLiqLSDFile[0] ;
         A707ImpLiqLSDFileType = BC002C14_A707ImpLiqLSDFileType[0] ;
         A705ImpLiqLSDFile_Filetype = A707ImpLiqLSDFileType ;
         A706ImpLiqLSDFileName = BC002C14_A706ImpLiqLSDFileName[0] ;
         A705ImpLiqLSDFile_Filename = A706ImpLiqLSDFileName ;
         A3CliCod = BC002C14_A3CliCod[0] ;
         A1EmpCod = BC002C14_A1EmpCod[0] ;
         A88ImpLiqSec = BC002C14_A88ImpLiqSec[0] ;
      }
      Gx_mode = sMode79 ;
   }

   public void scanKeyEnd2C79( )
   {
      pr_default.close(12);
   }

   public void afterConfirm2C79( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2C79( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2C79( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2C79( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2C79( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2C79( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2C79( )
   {
   }

   public void send_integrity_lvl_hashes2C79( )
   {
   }

   public void addRow2C79( )
   {
      VarsToRow79( bcimportacion_liquidacion_lsd) ;
   }

   public void readRow2C79( )
   {
      RowToVars79( bcimportacion_liquidacion_lsd, 1) ;
   }

   public void initializeNonKey2C79( )
   {
      A708ImpLiqLSDFileNameAndType = "" ;
      A705ImpLiqLSDFile = "" ;
      A707ImpLiqLSDFileType = "" ;
      A706ImpLiqLSDFileName = "" ;
      Z708ImpLiqLSDFileNameAndType = "" ;
   }

   public void initAll2C79( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A88ImpLiqSec = (short)(0) ;
      A704ImpLiqLSDSec = (short)(0) ;
      initializeNonKey2C79( ) ;
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

   public void VarsToRow79( web.Sdtimportacion_liquidacion_lsd obj79 )
   {
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Mode( Gx_mode );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype( A708ImpLiqLSDFileNameAndType );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile( A705ImpLiqLSDFile );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype( A707ImpLiqLSDFileType );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename( A706ImpLiqLSDFileName );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod( A3CliCod );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod( A1EmpCod );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec( A88ImpLiqSec );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec( A704ImpLiqLSDSec );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z( Z3CliCod );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z( Z1EmpCod );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z( Z88ImpLiqSec );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z( Z704ImpLiqLSDSec );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z( Z706ImpLiqLSDFileName );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z( Z707ImpLiqLSDFileType );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z( Z708ImpLiqLSDFileNameAndType );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Mode( Gx_mode );
   }

   public void KeyVarsToRow79( web.Sdtimportacion_liquidacion_lsd obj79 )
   {
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Clicod( A3CliCod );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Empcod( A1EmpCod );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec( A88ImpLiqSec );
      obj79.setgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec( A704ImpLiqLSDSec );
   }

   public void RowToVars79( web.Sdtimportacion_liquidacion_lsd obj79 ,
                            int forceLoad )
   {
      Gx_mode = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Mode() ;
      A708ImpLiqLSDFileNameAndType = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype() ;
      A705ImpLiqLSDFile = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfile() ;
      A707ImpLiqLSDFileType = ((GXutil.strcmp("", obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype())==0) ? com.genexus.util.GXFile.getgxFileext( A705ImpLiqLSDFile) : obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype()) ;
      A706ImpLiqLSDFileName = ((GXutil.strcmp("", obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename())==0) ? com.genexus.util.GXFile.getgxFilename( A705ImpLiqLSDFile) : obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename()) ;
      A3CliCod = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Clicod() ;
      A1EmpCod = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Empcod() ;
      A88ImpLiqSec = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec() ;
      A704ImpLiqLSDSec = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec() ;
      Z3CliCod = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Clicod_Z() ;
      Z1EmpCod = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Empcod_Z() ;
      Z88ImpLiqSec = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqsec_Z() ;
      Z704ImpLiqLSDSec = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdsec_Z() ;
      Z706ImpLiqLSDFileName = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilename_Z() ;
      Z707ImpLiqLSDFileType = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfiletype_Z() ;
      Z708ImpLiqLSDFileNameAndType = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Impliqlsdfilenameandtype_Z() ;
      Gx_mode = obj79.getgxTv_Sdtimportacion_liquidacion_lsd_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A88ImpLiqSec = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      A704ImpLiqLSDSec = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey2C79( ) ;
      scanKeyStart2C79( ) ;
      if ( RcdFound79 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002C15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z704ImpLiqLSDSec = A704ImpLiqLSDSec ;
      }
      zm2C79( -2) ;
      onLoadActions2C79( ) ;
      addRow2C79( ) ;
      scanKeyEnd2C79( ) ;
      if ( RcdFound79 == 0 )
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
      RowToVars79( bcimportacion_liquidacion_lsd, 0) ;
      scanKeyStart2C79( ) ;
      if ( RcdFound79 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002C16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z704ImpLiqLSDSec = A704ImpLiqLSDSec ;
      }
      zm2C79( -2) ;
      onLoadActions2C79( ) ;
      addRow2C79( ) ;
      scanKeyEnd2C79( ) ;
      if ( RcdFound79 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2C79( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert2C79( ) ;
      }
      else
      {
         if ( RcdFound79 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A704ImpLiqLSDSec != Z704ImpLiqLSDSec ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A88ImpLiqSec = Z88ImpLiqSec ;
               A704ImpLiqLSDSec = Z704ImpLiqLSDSec ;
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
               update2C79( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A704ImpLiqLSDSec != Z704ImpLiqLSDSec ) )
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
                     insert2C79( ) ;
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
                     insert2C79( ) ;
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
      RowToVars79( bcimportacion_liquidacion_lsd, 1) ;
      saveImpl( ) ;
      VarsToRow79( bcimportacion_liquidacion_lsd) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars79( bcimportacion_liquidacion_lsd, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2C79( ) ;
      afterTrn( ) ;
      VarsToRow79( bcimportacion_liquidacion_lsd) ;
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
         web.Sdtimportacion_liquidacion_lsd auxBC = new web.Sdtimportacion_liquidacion_lsd( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A88ImpLiqSec, A704ImpLiqLSDSec);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcimportacion_liquidacion_lsd);
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
      RowToVars79( bcimportacion_liquidacion_lsd, 1) ;
      updateImpl( ) ;
      VarsToRow79( bcimportacion_liquidacion_lsd) ;
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
      RowToVars79( bcimportacion_liquidacion_lsd, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2C79( ) ;
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
      VarsToRow79( bcimportacion_liquidacion_lsd) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars79( bcimportacion_liquidacion_lsd, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey2C79( ) ;
      if ( RcdFound79 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A704ImpLiqLSDSec != Z704ImpLiqLSDSec ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A88ImpLiqSec = Z88ImpLiqSec ;
            A704ImpLiqLSDSec = Z704ImpLiqLSDSec ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( A704ImpLiqLSDSec != Z704ImpLiqLSDSec ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_liquidacion_lsd_bc");
      VarsToRow79( bcimportacion_liquidacion_lsd) ;
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
      Gx_mode = bcimportacion_liquidacion_lsd.getgxTv_Sdtimportacion_liquidacion_lsd_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcimportacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtimportacion_liquidacion_lsd sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcimportacion_liquidacion_lsd )
      {
         bcimportacion_liquidacion_lsd = sdt ;
         if ( GXutil.strcmp(bcimportacion_liquidacion_lsd.getgxTv_Sdtimportacion_liquidacion_lsd_Mode(), "") == 0 )
         {
            bcimportacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow79( bcimportacion_liquidacion_lsd) ;
         }
         else
         {
            RowToVars79( bcimportacion_liquidacion_lsd, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcimportacion_liquidacion_lsd.getgxTv_Sdtimportacion_liquidacion_lsd_Mode(), "") == 0 )
         {
            bcimportacion_liquidacion_lsd.setgxTv_Sdtimportacion_liquidacion_lsd_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars79( bcimportacion_liquidacion_lsd, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtimportacion_liquidacion_lsd getimportacion_liquidacion_lsd_BC( )
   {
      return bcimportacion_liquidacion_lsd ;
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
      Z708ImpLiqLSDFileNameAndType = "" ;
      A708ImpLiqLSDFileNameAndType = "" ;
      Z705ImpLiqLSDFile = "" ;
      A705ImpLiqLSDFile = "" ;
      Z707ImpLiqLSDFileType = "" ;
      A707ImpLiqLSDFileType = "" ;
      Z706ImpLiqLSDFileName = "" ;
      A706ImpLiqLSDFileName = "" ;
      BC002C5_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      BC002C5_A704ImpLiqLSDSec = new short[1] ;
      BC002C5_A705ImpLiqLSDFile = new String[] {""} ;
      BC002C5_A707ImpLiqLSDFileType = new String[] {""} ;
      BC002C5_A706ImpLiqLSDFileName = new String[] {""} ;
      BC002C5_A3CliCod = new int[1] ;
      BC002C5_A1EmpCod = new short[1] ;
      BC002C5_A88ImpLiqSec = new short[1] ;
      A705ImpLiqLSDFile_Filetype = "" ;
      A705ImpLiqLSDFile_Filename = "" ;
      BC002C6_A3CliCod = new int[1] ;
      BC002C7_A3CliCod = new int[1] ;
      BC002C7_A1EmpCod = new short[1] ;
      BC002C7_A88ImpLiqSec = new short[1] ;
      BC002C7_A704ImpLiqLSDSec = new short[1] ;
      BC002C8_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      BC002C8_A704ImpLiqLSDSec = new short[1] ;
      BC002C8_A705ImpLiqLSDFile = new String[] {""} ;
      BC002C8_A707ImpLiqLSDFileType = new String[] {""} ;
      BC002C8_A706ImpLiqLSDFileName = new String[] {""} ;
      BC002C8_A3CliCod = new int[1] ;
      BC002C8_A1EmpCod = new short[1] ;
      BC002C8_A88ImpLiqSec = new short[1] ;
      sMode79 = "" ;
      BC002C9_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      BC002C9_A704ImpLiqLSDSec = new short[1] ;
      BC002C9_A705ImpLiqLSDFile = new String[] {""} ;
      BC002C9_A707ImpLiqLSDFileType = new String[] {""} ;
      BC002C9_A706ImpLiqLSDFileName = new String[] {""} ;
      BC002C9_A3CliCod = new int[1] ;
      BC002C9_A1EmpCod = new short[1] ;
      BC002C9_A88ImpLiqSec = new short[1] ;
      BC002C14_A708ImpLiqLSDFileNameAndType = new String[] {""} ;
      BC002C14_A704ImpLiqLSDSec = new short[1] ;
      BC002C14_A705ImpLiqLSDFile = new String[] {""} ;
      BC002C14_A707ImpLiqLSDFileType = new String[] {""} ;
      BC002C14_A706ImpLiqLSDFileName = new String[] {""} ;
      BC002C14_A3CliCod = new int[1] ;
      BC002C14_A1EmpCod = new short[1] ;
      BC002C14_A88ImpLiqSec = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC002C15_A3CliCod = new int[1] ;
      BC002C16_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_liquidacion_lsd_bc__default(),
         new Object[] {
             new Object[] {
            BC002C2_A708ImpLiqLSDFileNameAndType, BC002C2_A704ImpLiqLSDSec, BC002C2_A705ImpLiqLSDFile, BC002C2_A707ImpLiqLSDFileType, BC002C2_A706ImpLiqLSDFileName, BC002C2_A3CliCod, BC002C2_A1EmpCod, BC002C2_A88ImpLiqSec
            }
            , new Object[] {
            BC002C3_A708ImpLiqLSDFileNameAndType, BC002C3_A704ImpLiqLSDSec, BC002C3_A705ImpLiqLSDFile, BC002C3_A707ImpLiqLSDFileType, BC002C3_A706ImpLiqLSDFileName, BC002C3_A3CliCod, BC002C3_A1EmpCod, BC002C3_A88ImpLiqSec
            }
            , new Object[] {
            BC002C4_A3CliCod
            }
            , new Object[] {
            BC002C5_A708ImpLiqLSDFileNameAndType, BC002C5_A704ImpLiqLSDSec, BC002C5_A705ImpLiqLSDFile, BC002C5_A707ImpLiqLSDFileType, BC002C5_A706ImpLiqLSDFileName, BC002C5_A3CliCod, BC002C5_A1EmpCod, BC002C5_A88ImpLiqSec
            }
            , new Object[] {
            BC002C6_A3CliCod
            }
            , new Object[] {
            BC002C7_A3CliCod, BC002C7_A1EmpCod, BC002C7_A88ImpLiqSec, BC002C7_A704ImpLiqLSDSec
            }
            , new Object[] {
            BC002C8_A708ImpLiqLSDFileNameAndType, BC002C8_A704ImpLiqLSDSec, BC002C8_A705ImpLiqLSDFile, BC002C8_A707ImpLiqLSDFileType, BC002C8_A706ImpLiqLSDFileName, BC002C8_A3CliCod, BC002C8_A1EmpCod, BC002C8_A88ImpLiqSec
            }
            , new Object[] {
            BC002C9_A708ImpLiqLSDFileNameAndType, BC002C9_A704ImpLiqLSDSec, BC002C9_A705ImpLiqLSDFile, BC002C9_A707ImpLiqLSDFileType, BC002C9_A706ImpLiqLSDFileName, BC002C9_A3CliCod, BC002C9_A1EmpCod, BC002C9_A88ImpLiqSec
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
            BC002C14_A708ImpLiqLSDFileNameAndType, BC002C14_A704ImpLiqLSDSec, BC002C14_A705ImpLiqLSDFile, BC002C14_A707ImpLiqLSDFileType, BC002C14_A706ImpLiqLSDFileName, BC002C14_A3CliCod, BC002C14_A1EmpCod, BC002C14_A88ImpLiqSec
            }
            , new Object[] {
            BC002C15_A3CliCod
            }
            , new Object[] {
            BC002C16_A3CliCod
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
   private short Z704ImpLiqLSDSec ;
   private short A704ImpLiqLSDSec ;
   private short RcdFound79 ;
   private short nIsDirty_79 ;
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
   private String Z707ImpLiqLSDFileType ;
   private String A707ImpLiqLSDFileType ;
   private String A705ImpLiqLSDFile_Filetype ;
   private String A705ImpLiqLSDFile_Filename ;
   private String sMode79 ;
   private boolean mustCommit ;
   private String Z705ImpLiqLSDFile ;
   private String A705ImpLiqLSDFile ;
   private String Z708ImpLiqLSDFileNameAndType ;
   private String A708ImpLiqLSDFileNameAndType ;
   private String Z706ImpLiqLSDFileName ;
   private String A706ImpLiqLSDFileName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.Sdtimportacion_liquidacion_lsd bcimportacion_liquidacion_lsd ;
   private IDataStoreProvider pr_default ;
   private String[] BC002C5_A708ImpLiqLSDFileNameAndType ;
   private short[] BC002C5_A704ImpLiqLSDSec ;
   private String[] BC002C5_A705ImpLiqLSDFile ;
   private String[] BC002C5_A707ImpLiqLSDFileType ;
   private String[] BC002C5_A706ImpLiqLSDFileName ;
   private int[] BC002C5_A3CliCod ;
   private short[] BC002C5_A1EmpCod ;
   private short[] BC002C5_A88ImpLiqSec ;
   private int[] BC002C6_A3CliCod ;
   private int[] BC002C7_A3CliCod ;
   private short[] BC002C7_A1EmpCod ;
   private short[] BC002C7_A88ImpLiqSec ;
   private short[] BC002C7_A704ImpLiqLSDSec ;
   private String[] BC002C8_A708ImpLiqLSDFileNameAndType ;
   private short[] BC002C8_A704ImpLiqLSDSec ;
   private String[] BC002C8_A705ImpLiqLSDFile ;
   private String[] BC002C8_A707ImpLiqLSDFileType ;
   private String[] BC002C8_A706ImpLiqLSDFileName ;
   private int[] BC002C8_A3CliCod ;
   private short[] BC002C8_A1EmpCod ;
   private short[] BC002C8_A88ImpLiqSec ;
   private String[] BC002C9_A708ImpLiqLSDFileNameAndType ;
   private short[] BC002C9_A704ImpLiqLSDSec ;
   private String[] BC002C9_A705ImpLiqLSDFile ;
   private String[] BC002C9_A707ImpLiqLSDFileType ;
   private String[] BC002C9_A706ImpLiqLSDFileName ;
   private int[] BC002C9_A3CliCod ;
   private short[] BC002C9_A1EmpCod ;
   private short[] BC002C9_A88ImpLiqSec ;
   private String[] BC002C14_A708ImpLiqLSDFileNameAndType ;
   private short[] BC002C14_A704ImpLiqLSDSec ;
   private String[] BC002C14_A705ImpLiqLSDFile ;
   private String[] BC002C14_A707ImpLiqLSDFileType ;
   private String[] BC002C14_A706ImpLiqLSDFileName ;
   private int[] BC002C14_A3CliCod ;
   private short[] BC002C14_A1EmpCod ;
   private short[] BC002C14_A88ImpLiqSec ;
   private int[] BC002C15_A3CliCod ;
   private int[] BC002C16_A3CliCod ;
   private String[] BC002C2_A708ImpLiqLSDFileNameAndType ;
   private short[] BC002C2_A704ImpLiqLSDSec ;
   private String[] BC002C2_A705ImpLiqLSDFile ;
   private String[] BC002C2_A707ImpLiqLSDFileType ;
   private String[] BC002C2_A706ImpLiqLSDFileName ;
   private int[] BC002C2_A3CliCod ;
   private short[] BC002C2_A1EmpCod ;
   private short[] BC002C2_A88ImpLiqSec ;
   private String[] BC002C3_A708ImpLiqLSDFileNameAndType ;
   private short[] BC002C3_A704ImpLiqLSDSec ;
   private String[] BC002C3_A705ImpLiqLSDFile ;
   private String[] BC002C3_A707ImpLiqLSDFileType ;
   private String[] BC002C3_A706ImpLiqLSDFileName ;
   private int[] BC002C3_A3CliCod ;
   private short[] BC002C3_A1EmpCod ;
   private short[] BC002C3_A88ImpLiqSec ;
   private int[] BC002C4_A3CliCod ;
}

final  class importacion_liquidacion_lsd_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC002C2", "SELECT ImpLiqLSDFileNameAndType, ImpLiqLSDSec, ImpLiqLSDFile, ImpLiqLSDFileType, ImpLiqLSDFileName, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?  FOR UPDATE OF importacion_liquidacion_lsd",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C3", "SELECT ImpLiqLSDFileNameAndType, ImpLiqLSDSec, ImpLiqLSDFile, ImpLiqLSDFileType, ImpLiqLSDFileName, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C4", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C5", "SELECT TM1.ImpLiqLSDFileNameAndType, TM1.ImpLiqLSDSec, TM1.ImpLiqLSDFile, TM1.ImpLiqLSDFileType, TM1.ImpLiqLSDFileName, TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec FROM importacion_liquidacion_lsd TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? and TM1.ImpLiqLSDSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec, TM1.ImpLiqLSDSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C6", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C7", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqLSDSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C8", "SELECT ImpLiqLSDFileNameAndType, ImpLiqLSDSec, ImpLiqLSDFile, ImpLiqLSDFileType, ImpLiqLSDFileName, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C9", "SELECT ImpLiqLSDFileNameAndType, ImpLiqLSDSec, ImpLiqLSDFile, ImpLiqLSDFileType, ImpLiqLSDFileName, CliCod, EmpCod, ImpLiqSec FROM importacion_liquidacion_lsd WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?  FOR UPDATE OF importacion_liquidacion_lsd",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002C10", "SAVEPOINT gxupdate;INSERT INTO importacion_liquidacion_lsd(ImpLiqLSDFileNameAndType, ImpLiqLSDSec, ImpLiqLSDFile, ImpLiqLSDFileType, ImpLiqLSDFileName, CliCod, EmpCod, ImpLiqSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002C11", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_lsd SET ImpLiqLSDFileNameAndType=?, ImpLiqLSDFileType=?, ImpLiqLSDFileName=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002C12", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_lsd SET ImpLiqLSDFile=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002C13", "SAVEPOINT gxupdate;DELETE FROM importacion_liquidacion_lsd  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002C14", "SELECT TM1.ImpLiqLSDFileNameAndType, TM1.ImpLiqLSDSec, TM1.ImpLiqLSDFile, TM1.ImpLiqLSDFileType, TM1.ImpLiqLSDFileName, TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec FROM importacion_liquidacion_lsd TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? and TM1.ImpLiqLSDSec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec, TM1.ImpLiqLSDSec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C15", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002C16", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(4, 20), rslt.getVarchar(5));
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 14 :
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBLOBFile(3, (String)parms[2]);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 10 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

