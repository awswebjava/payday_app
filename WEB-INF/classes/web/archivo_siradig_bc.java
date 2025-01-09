package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class archivo_siradig_bc extends GXWebPanel implements IGxSilentTrn
{
   public archivo_siradig_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public archivo_siradig_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( archivo_siradig_bc.class ));
   }

   public archivo_siradig_bc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0373( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0373( ) ;
      standaloneModal( ) ;
      addRow0373( ) ;
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
            Z85ArchSiradigFec = A85ArchSiradigFec ;
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

   public void confirm_030( )
   {
      beforeValidate0373( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0373( ) ;
         }
         else
         {
            checkExtendedTable0373( ) ;
            if ( AnyError == 0 )
            {
               zm0373( 6) ;
            }
            closeExtendedTableCursors0373( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm0373( int GX_JID )
   {
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
         Z565ArchSiradigEstado = A565ArchSiradigEstado ;
         Z566ArchSiradigError = A566ArchSiradigError ;
         Z567ArchSirdigNameAndType = A567ArchSirdigNameAndType ;
      }
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z567ArchSirdigNameAndType = A567ArchSirdigNameAndType ;
      }
      if ( GX_JID == -5 )
      {
         Z85ArchSiradigFec = A85ArchSiradigFec ;
         Z565ArchSiradigEstado = A565ArchSiradigEstado ;
         Z562ArchSiradigFile = A562ArchSiradigFile ;
         Z566ArchSiradigError = A566ArchSiradigError ;
         Z563ArchSiradigType = A563ArchSiradigType ;
         Z564ArchSiradigName = A564ArchSiradigName ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      A85ArchSiradigFec = GXutil.serverNow( context, remoteHandle, pr_default) ;
      A565ArchSiradigEstado = (short)(1) ;
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load0373( )
   {
      /* Using cursor BC00035 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound73 = (short)(1) ;
         A565ArchSiradigEstado = BC00035_A565ArchSiradigEstado[0] ;
         A562ArchSiradigFile = BC00035_A562ArchSiradigFile[0] ;
         A566ArchSiradigError = BC00035_A566ArchSiradigError[0] ;
         A563ArchSiradigType = BC00035_A563ArchSiradigType[0] ;
         A562ArchSiradigFile_Filetype = A563ArchSiradigType ;
         A564ArchSiradigName = BC00035_A564ArchSiradigName[0] ;
         A562ArchSiradigFile_Filename = A564ArchSiradigName ;
         zm0373( -5) ;
      }
      pr_default.close(3);
      onLoadActions0373( ) ;
   }

   public void onLoadActions0373( )
   {
      A567ArchSirdigNameAndType = GXutil.trim( A564ArchSiradigName) + " ." + GXutil.trim( A563ArchSiradigType) ;
   }

   public void checkExtendedTable0373( )
   {
      nIsDirty_73 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC00036 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      if ( ! ( ( A565ArchSiradigEstado == 1 ) || ( A565ArchSiradigEstado == 2 ) || ( A565ArchSiradigEstado == 3 ) || ( A565ArchSiradigEstado == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Arch Siradig Estado", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      nIsDirty_73 = (short)(1) ;
      A567ArchSirdigNameAndType = GXutil.trim( A564ArchSiradigName) + " ." + GXutil.trim( A563ArchSiradigType) ;
   }

   public void closeExtendedTableCursors0373( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey0373( )
   {
      /* Using cursor BC00037 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound73 = (short)(1) ;
      }
      else
      {
         RcdFound73 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00038 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0373( 5) ;
         RcdFound73 = (short)(1) ;
         A85ArchSiradigFec = BC00038_A85ArchSiradigFec[0] ;
         A565ArchSiradigEstado = BC00038_A565ArchSiradigEstado[0] ;
         A562ArchSiradigFile = BC00038_A562ArchSiradigFile[0] ;
         A566ArchSiradigError = BC00038_A566ArchSiradigError[0] ;
         A563ArchSiradigType = BC00038_A563ArchSiradigType[0] ;
         A562ArchSiradigFile_Filetype = A563ArchSiradigType ;
         A564ArchSiradigName = BC00038_A564ArchSiradigName[0] ;
         A562ArchSiradigFile_Filename = A564ArchSiradigName ;
         A3CliCod = BC00038_A3CliCod[0] ;
         A1EmpCod = BC00038_A1EmpCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z85ArchSiradigFec = A85ArchSiradigFec ;
         sMode73 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0373( ) ;
         if ( AnyError == 1 )
         {
            RcdFound73 = (short)(0) ;
            initializeNonKey0373( ) ;
         }
         Gx_mode = sMode73 ;
      }
      else
      {
         RcdFound73 = (short)(0) ;
         initializeNonKey0373( ) ;
         sMode73 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode73 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0373( ) ;
      if ( RcdFound73 == 0 )
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
      confirm_030( ) ;
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

   public void checkOptimisticConcurrency0373( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00039 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"archivo_siradig"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( Z565ArchSiradigEstado != BC00039_A565ArchSiradigEstado[0] ) || ( GXutil.strcmp(Z566ArchSiradigError, BC00039_A566ArchSiradigError[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"archivo_siradig"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0373( )
   {
      beforeValidate0373( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0373( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0373( 0) ;
         checkOptimisticConcurrency0373( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0373( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0373( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000310 */
                  pr_default.execute(8, new Object[] {A85ArchSiradigFec, Short.valueOf(A565ArchSiradigEstado), A562ArchSiradigFile, A566ArchSiradigError, A563ArchSiradigType, A564ArchSiradigName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
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
            load0373( ) ;
         }
         endLevel0373( ) ;
      }
      closeExtendedTableCursors0373( ) ;
   }

   public void update0373( )
   {
      beforeValidate0373( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0373( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0373( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0373( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0373( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000311 */
                  pr_default.execute(9, new Object[] {Short.valueOf(A565ArchSiradigEstado), A566ArchSiradigError, A563ArchSiradigType, A564ArchSiradigName, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"archivo_siradig"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0373( ) ;
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
         endLevel0373( ) ;
      }
      closeExtendedTableCursors0373( ) ;
   }

   public void deferredUpdate0373( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor BC000312 */
         pr_default.execute(10, new Object[] {A562ArchSiradigFile, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
      }
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0373( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0373( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0373( ) ;
         afterConfirm0373( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0373( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000313 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("archivo_siradig");
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
      sMode73 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0373( ) ;
      Gx_mode = sMode73 ;
   }

   public void onDeleteControls0373( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         A567ArchSirdigNameAndType = GXutil.trim( A564ArchSiradigName) + " ." + GXutil.trim( A563ArchSiradigType) ;
      }
   }

   public void endLevel0373( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0373( ) ;
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

   public void scanKeyStart0373( )
   {
      /* Using cursor BC000314 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A85ArchSiradigFec});
      RcdFound73 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound73 = (short)(1) ;
         A85ArchSiradigFec = BC000314_A85ArchSiradigFec[0] ;
         A565ArchSiradigEstado = BC000314_A565ArchSiradigEstado[0] ;
         A562ArchSiradigFile = BC000314_A562ArchSiradigFile[0] ;
         A566ArchSiradigError = BC000314_A566ArchSiradigError[0] ;
         A563ArchSiradigType = BC000314_A563ArchSiradigType[0] ;
         A562ArchSiradigFile_Filetype = A563ArchSiradigType ;
         A564ArchSiradigName = BC000314_A564ArchSiradigName[0] ;
         A562ArchSiradigFile_Filename = A564ArchSiradigName ;
         A3CliCod = BC000314_A3CliCod[0] ;
         A1EmpCod = BC000314_A1EmpCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0373( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound73 = (short)(0) ;
      scanKeyLoad0373( ) ;
   }

   public void scanKeyLoad0373( )
   {
      sMode73 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound73 = (short)(1) ;
         A85ArchSiradigFec = BC000314_A85ArchSiradigFec[0] ;
         A565ArchSiradigEstado = BC000314_A565ArchSiradigEstado[0] ;
         A562ArchSiradigFile = BC000314_A562ArchSiradigFile[0] ;
         A566ArchSiradigError = BC000314_A566ArchSiradigError[0] ;
         A563ArchSiradigType = BC000314_A563ArchSiradigType[0] ;
         A562ArchSiradigFile_Filetype = A563ArchSiradigType ;
         A564ArchSiradigName = BC000314_A564ArchSiradigName[0] ;
         A562ArchSiradigFile_Filename = A564ArchSiradigName ;
         A3CliCod = BC000314_A3CliCod[0] ;
         A1EmpCod = BC000314_A1EmpCod[0] ;
      }
      Gx_mode = sMode73 ;
   }

   public void scanKeyEnd0373( )
   {
      pr_default.close(12);
   }

   public void afterConfirm0373( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0373( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0373( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0373( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0373( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0373( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0373( )
   {
   }

   public void send_integrity_lvl_hashes0373( )
   {
   }

   public void addRow0373( )
   {
      VarsToRow73( bcarchivo_siradig) ;
   }

   public void readRow0373( )
   {
      RowToVars73( bcarchivo_siradig, 1) ;
   }

   public void initializeNonKey0373( )
   {
      A565ArchSiradigEstado = (short)(0) ;
      A567ArchSirdigNameAndType = "" ;
      A562ArchSiradigFile = "" ;
      A566ArchSiradigError = "" ;
      A563ArchSiradigType = "" ;
      A564ArchSiradigName = "" ;
      Z565ArchSiradigEstado = (short)(0) ;
      Z566ArchSiradigError = "" ;
   }

   public void initAll0373( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      initializeNonKey0373( ) ;
   }

   public void standaloneModalInsert( )
   {
      A565ArchSiradigEstado = i565ArchSiradigEstado ;
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

   public void VarsToRow73( web.Sdtarchivo_siradig obj73 )
   {
      obj73.setgxTv_Sdtarchivo_siradig_Mode( Gx_mode );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigestado( A565ArchSiradigEstado );
      obj73.setgxTv_Sdtarchivo_siradig_Archsirdignameandtype( A567ArchSirdigNameAndType );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigfile( A562ArchSiradigFile );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigerror( A566ArchSiradigError );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigtype( A563ArchSiradigType );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigname( A564ArchSiradigName );
      obj73.setgxTv_Sdtarchivo_siradig_Clicod( A3CliCod );
      obj73.setgxTv_Sdtarchivo_siradig_Empcod( A1EmpCod );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigfec( A85ArchSiradigFec );
      obj73.setgxTv_Sdtarchivo_siradig_Clicod_Z( Z3CliCod );
      obj73.setgxTv_Sdtarchivo_siradig_Empcod_Z( Z1EmpCod );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigfec_Z( Z85ArchSiradigFec );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigname_Z( Z564ArchSiradigName );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigtype_Z( Z563ArchSiradigType );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigestado_Z( Z565ArchSiradigEstado );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigerror_Z( Z566ArchSiradigError );
      obj73.setgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z( Z567ArchSirdigNameAndType );
      obj73.setgxTv_Sdtarchivo_siradig_Mode( Gx_mode );
   }

   public void KeyVarsToRow73( web.Sdtarchivo_siradig obj73 )
   {
      obj73.setgxTv_Sdtarchivo_siradig_Clicod( A3CliCod );
      obj73.setgxTv_Sdtarchivo_siradig_Empcod( A1EmpCod );
      obj73.setgxTv_Sdtarchivo_siradig_Archsiradigfec( A85ArchSiradigFec );
   }

   public void RowToVars73( web.Sdtarchivo_siradig obj73 ,
                            int forceLoad )
   {
      Gx_mode = obj73.getgxTv_Sdtarchivo_siradig_Mode() ;
      A565ArchSiradigEstado = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigestado() ;
      A567ArchSirdigNameAndType = obj73.getgxTv_Sdtarchivo_siradig_Archsirdignameandtype() ;
      A562ArchSiradigFile = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigfile() ;
      A566ArchSiradigError = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigerror() ;
      A563ArchSiradigType = ((GXutil.strcmp("", obj73.getgxTv_Sdtarchivo_siradig_Archsiradigtype())==0) ? com.genexus.util.GXFile.getgxFileext( A562ArchSiradigFile) : obj73.getgxTv_Sdtarchivo_siradig_Archsiradigtype()) ;
      A564ArchSiradigName = ((GXutil.strcmp("", obj73.getgxTv_Sdtarchivo_siradig_Archsiradigname())==0) ? com.genexus.util.GXFile.getgxFilename( A562ArchSiradigFile) : obj73.getgxTv_Sdtarchivo_siradig_Archsiradigname()) ;
      A3CliCod = obj73.getgxTv_Sdtarchivo_siradig_Clicod() ;
      A1EmpCod = obj73.getgxTv_Sdtarchivo_siradig_Empcod() ;
      A85ArchSiradigFec = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigfec() ;
      Z3CliCod = obj73.getgxTv_Sdtarchivo_siradig_Clicod_Z() ;
      Z1EmpCod = obj73.getgxTv_Sdtarchivo_siradig_Empcod_Z() ;
      Z85ArchSiradigFec = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigfec_Z() ;
      Z564ArchSiradigName = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigname_Z() ;
      Z563ArchSiradigType = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigtype_Z() ;
      Z565ArchSiradigEstado = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigestado_Z() ;
      Z566ArchSiradigError = obj73.getgxTv_Sdtarchivo_siradig_Archsiradigerror_Z() ;
      Z567ArchSirdigNameAndType = obj73.getgxTv_Sdtarchivo_siradig_Archsirdignameandtype_Z() ;
      Gx_mode = obj73.getgxTv_Sdtarchivo_siradig_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A85ArchSiradigFec = (java.util.Date)getParm(obj,2) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0373( ) ;
      scanKeyStart0373( ) ;
      if ( RcdFound73 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000315 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z85ArchSiradigFec = A85ArchSiradigFec ;
      }
      zm0373( -5) ;
      onLoadActions0373( ) ;
      addRow0373( ) ;
      scanKeyEnd0373( ) ;
      if ( RcdFound73 == 0 )
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
      RowToVars73( bcarchivo_siradig, 0) ;
      scanKeyStart0373( ) ;
      if ( RcdFound73 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000316 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z85ArchSiradigFec = A85ArchSiradigFec ;
      }
      zm0373( -5) ;
      onLoadActions0373( ) ;
      addRow0373( ) ;
      scanKeyEnd0373( ) ;
      if ( RcdFound73 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0373( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0373( ) ;
      }
      else
      {
         if ( RcdFound73 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(A85ArchSiradigFec, Z85ArchSiradigFec) ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A85ArchSiradigFec = Z85ArchSiradigFec ;
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
               update0373( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(A85ArchSiradigFec, Z85ArchSiradigFec) ) )
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
                     insert0373( ) ;
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
                     insert0373( ) ;
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
      RowToVars73( bcarchivo_siradig, 1) ;
      saveImpl( ) ;
      VarsToRow73( bcarchivo_siradig) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars73( bcarchivo_siradig, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0373( ) ;
      afterTrn( ) ;
      VarsToRow73( bcarchivo_siradig) ;
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
         web.Sdtarchivo_siradig auxBC = new web.Sdtarchivo_siradig( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A85ArchSiradigFec);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcarchivo_siradig);
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
      RowToVars73( bcarchivo_siradig, 1) ;
      updateImpl( ) ;
      VarsToRow73( bcarchivo_siradig) ;
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
      RowToVars73( bcarchivo_siradig, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0373( ) ;
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
      VarsToRow73( bcarchivo_siradig) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars73( bcarchivo_siradig, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0373( ) ;
      if ( RcdFound73 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(A85ArchSiradigFec, Z85ArchSiradigFec) ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A85ArchSiradigFec = Z85ArchSiradigFec ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || !( GXutil.dateCompare(A85ArchSiradigFec, Z85ArchSiradigFec) ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "archivo_siradig_bc");
      VarsToRow73( bcarchivo_siradig) ;
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
      Gx_mode = bcarchivo_siradig.getgxTv_Sdtarchivo_siradig_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcarchivo_siradig.setgxTv_Sdtarchivo_siradig_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtarchivo_siradig sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcarchivo_siradig )
      {
         bcarchivo_siradig = sdt ;
         if ( GXutil.strcmp(bcarchivo_siradig.getgxTv_Sdtarchivo_siradig_Mode(), "") == 0 )
         {
            bcarchivo_siradig.setgxTv_Sdtarchivo_siradig_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow73( bcarchivo_siradig) ;
         }
         else
         {
            RowToVars73( bcarchivo_siradig, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcarchivo_siradig.getgxTv_Sdtarchivo_siradig_Mode(), "") == 0 )
         {
            bcarchivo_siradig.setgxTv_Sdtarchivo_siradig_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars73( bcarchivo_siradig, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtarchivo_siradig getarchivo_siradig_BC( )
   {
      return bcarchivo_siradig ;
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
      Z85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      A85ArchSiradigFec = GXutil.resetTime( GXutil.nullDate() );
      Z566ArchSiradigError = "" ;
      A566ArchSiradigError = "" ;
      Z567ArchSirdigNameAndType = "" ;
      A567ArchSirdigNameAndType = "" ;
      Z562ArchSiradigFile = "" ;
      A562ArchSiradigFile = "" ;
      Z563ArchSiradigType = "" ;
      A563ArchSiradigType = "" ;
      Z564ArchSiradigName = "" ;
      A564ArchSiradigName = "" ;
      BC00035_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC00035_A565ArchSiradigEstado = new short[1] ;
      BC00035_A562ArchSiradigFile = new String[] {""} ;
      BC00035_A566ArchSiradigError = new String[] {""} ;
      BC00035_A563ArchSiradigType = new String[] {""} ;
      BC00035_A564ArchSiradigName = new String[] {""} ;
      BC00035_A3CliCod = new int[1] ;
      BC00035_A1EmpCod = new short[1] ;
      A562ArchSiradigFile_Filetype = "" ;
      A562ArchSiradigFile_Filename = "" ;
      BC00036_A3CliCod = new int[1] ;
      BC00037_A3CliCod = new int[1] ;
      BC00037_A1EmpCod = new short[1] ;
      BC00037_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC00038_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC00038_A565ArchSiradigEstado = new short[1] ;
      BC00038_A562ArchSiradigFile = new String[] {""} ;
      BC00038_A566ArchSiradigError = new String[] {""} ;
      BC00038_A563ArchSiradigType = new String[] {""} ;
      BC00038_A564ArchSiradigName = new String[] {""} ;
      BC00038_A3CliCod = new int[1] ;
      BC00038_A1EmpCod = new short[1] ;
      sMode73 = "" ;
      BC00039_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC00039_A565ArchSiradigEstado = new short[1] ;
      BC00039_A562ArchSiradigFile = new String[] {""} ;
      BC00039_A566ArchSiradigError = new String[] {""} ;
      BC00039_A563ArchSiradigType = new String[] {""} ;
      BC00039_A564ArchSiradigName = new String[] {""} ;
      BC00039_A3CliCod = new int[1] ;
      BC00039_A1EmpCod = new short[1] ;
      BC000314_A85ArchSiradigFec = new java.util.Date[] {GXutil.nullDate()} ;
      BC000314_A565ArchSiradigEstado = new short[1] ;
      BC000314_A562ArchSiradigFile = new String[] {""} ;
      BC000314_A566ArchSiradigError = new String[] {""} ;
      BC000314_A563ArchSiradigType = new String[] {""} ;
      BC000314_A564ArchSiradigName = new String[] {""} ;
      BC000314_A3CliCod = new int[1] ;
      BC000314_A1EmpCod = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000315_A3CliCod = new int[1] ;
      BC000316_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.archivo_siradig_bc__default(),
         new Object[] {
             new Object[] {
            BC00032_A85ArchSiradigFec, BC00032_A565ArchSiradigEstado, BC00032_A562ArchSiradigFile, BC00032_A566ArchSiradigError, BC00032_A563ArchSiradigType, BC00032_A564ArchSiradigName, BC00032_A3CliCod, BC00032_A1EmpCod
            }
            , new Object[] {
            BC00033_A85ArchSiradigFec, BC00033_A565ArchSiradigEstado, BC00033_A562ArchSiradigFile, BC00033_A566ArchSiradigError, BC00033_A563ArchSiradigType, BC00033_A564ArchSiradigName, BC00033_A3CliCod, BC00033_A1EmpCod
            }
            , new Object[] {
            BC00034_A3CliCod
            }
            , new Object[] {
            BC00035_A85ArchSiradigFec, BC00035_A565ArchSiradigEstado, BC00035_A562ArchSiradigFile, BC00035_A566ArchSiradigError, BC00035_A563ArchSiradigType, BC00035_A564ArchSiradigName, BC00035_A3CliCod, BC00035_A1EmpCod
            }
            , new Object[] {
            BC00036_A3CliCod
            }
            , new Object[] {
            BC00037_A3CliCod, BC00037_A1EmpCod, BC00037_A85ArchSiradigFec
            }
            , new Object[] {
            BC00038_A85ArchSiradigFec, BC00038_A565ArchSiradigEstado, BC00038_A562ArchSiradigFile, BC00038_A566ArchSiradigError, BC00038_A563ArchSiradigType, BC00038_A564ArchSiradigName, BC00038_A3CliCod, BC00038_A1EmpCod
            }
            , new Object[] {
            BC00039_A85ArchSiradigFec, BC00039_A565ArchSiradigEstado, BC00039_A562ArchSiradigFile, BC00039_A566ArchSiradigError, BC00039_A563ArchSiradigType, BC00039_A564ArchSiradigName, BC00039_A3CliCod, BC00039_A1EmpCod
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
            BC000314_A85ArchSiradigFec, BC000314_A565ArchSiradigEstado, BC000314_A562ArchSiradigFile, BC000314_A566ArchSiradigError, BC000314_A563ArchSiradigType, BC000314_A564ArchSiradigName, BC000314_A3CliCod, BC000314_A1EmpCod
            }
            , new Object[] {
            BC000315_A3CliCod
            }
            , new Object[] {
            BC000316_A3CliCod
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z565ArchSiradigEstado ;
   private short A565ArchSiradigEstado ;
   private short RcdFound73 ;
   private short nIsDirty_73 ;
   private short i565ArchSiradigEstado ;
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
   private String Z563ArchSiradigType ;
   private String A563ArchSiradigType ;
   private String A562ArchSiradigFile_Filetype ;
   private String A562ArchSiradigFile_Filename ;
   private String sMode73 ;
   private java.util.Date Z85ArchSiradigFec ;
   private java.util.Date A85ArchSiradigFec ;
   private boolean mustCommit ;
   private String Z562ArchSiradigFile ;
   private String A562ArchSiradigFile ;
   private String Z566ArchSiradigError ;
   private String A566ArchSiradigError ;
   private String Z567ArchSirdigNameAndType ;
   private String A567ArchSirdigNameAndType ;
   private String Z564ArchSiradigName ;
   private String A564ArchSiradigName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.Sdtarchivo_siradig bcarchivo_siradig ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] BC00035_A85ArchSiradigFec ;
   private short[] BC00035_A565ArchSiradigEstado ;
   private String[] BC00035_A562ArchSiradigFile ;
   private String[] BC00035_A566ArchSiradigError ;
   private String[] BC00035_A563ArchSiradigType ;
   private String[] BC00035_A564ArchSiradigName ;
   private int[] BC00035_A3CliCod ;
   private short[] BC00035_A1EmpCod ;
   private int[] BC00036_A3CliCod ;
   private int[] BC00037_A3CliCod ;
   private short[] BC00037_A1EmpCod ;
   private java.util.Date[] BC00037_A85ArchSiradigFec ;
   private java.util.Date[] BC00038_A85ArchSiradigFec ;
   private short[] BC00038_A565ArchSiradigEstado ;
   private String[] BC00038_A562ArchSiradigFile ;
   private String[] BC00038_A566ArchSiradigError ;
   private String[] BC00038_A563ArchSiradigType ;
   private String[] BC00038_A564ArchSiradigName ;
   private int[] BC00038_A3CliCod ;
   private short[] BC00038_A1EmpCod ;
   private java.util.Date[] BC00039_A85ArchSiradigFec ;
   private short[] BC00039_A565ArchSiradigEstado ;
   private String[] BC00039_A562ArchSiradigFile ;
   private String[] BC00039_A566ArchSiradigError ;
   private String[] BC00039_A563ArchSiradigType ;
   private String[] BC00039_A564ArchSiradigName ;
   private int[] BC00039_A3CliCod ;
   private short[] BC00039_A1EmpCod ;
   private java.util.Date[] BC000314_A85ArchSiradigFec ;
   private short[] BC000314_A565ArchSiradigEstado ;
   private String[] BC000314_A562ArchSiradigFile ;
   private String[] BC000314_A566ArchSiradigError ;
   private String[] BC000314_A563ArchSiradigType ;
   private String[] BC000314_A564ArchSiradigName ;
   private int[] BC000314_A3CliCod ;
   private short[] BC000314_A1EmpCod ;
   private int[] BC000315_A3CliCod ;
   private int[] BC000316_A3CliCod ;
   private java.util.Date[] BC00032_A85ArchSiradigFec ;
   private short[] BC00032_A565ArchSiradigEstado ;
   private String[] BC00032_A562ArchSiradigFile ;
   private String[] BC00032_A566ArchSiradigError ;
   private String[] BC00032_A563ArchSiradigType ;
   private String[] BC00032_A564ArchSiradigName ;
   private int[] BC00032_A3CliCod ;
   private short[] BC00032_A1EmpCod ;
   private java.util.Date[] BC00033_A85ArchSiradigFec ;
   private short[] BC00033_A565ArchSiradigEstado ;
   private String[] BC00033_A562ArchSiradigFile ;
   private String[] BC00033_A566ArchSiradigError ;
   private String[] BC00033_A563ArchSiradigType ;
   private String[] BC00033_A564ArchSiradigName ;
   private int[] BC00033_A3CliCod ;
   private short[] BC00033_A1EmpCod ;
   private int[] BC00034_A3CliCod ;
}

final  class archivo_siradig_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00032", "SELECT ArchSiradigFec, ArchSiradigEstado, ArchSiradigFile, ArchSiradigError, ArchSiradigType, ArchSiradigName, CliCod, EmpCod FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?  FOR UPDATE OF archivo_siradig",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00033", "SELECT ArchSiradigFec, ArchSiradigEstado, ArchSiradigFile, ArchSiradigError, ArchSiradigType, ArchSiradigName, CliCod, EmpCod FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00034", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00035", "SELECT TM1.ArchSiradigFec, TM1.ArchSiradigEstado, TM1.ArchSiradigFile, TM1.ArchSiradigError, TM1.ArchSiradigType, TM1.ArchSiradigName, TM1.CliCod, TM1.EmpCod FROM archivo_siradig TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ArchSiradigFec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ArchSiradigFec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00036", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00037", "SELECT CliCod, EmpCod, ArchSiradigFec FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00038", "SELECT ArchSiradigFec, ArchSiradigEstado, ArchSiradigFile, ArchSiradigError, ArchSiradigType, ArchSiradigName, CliCod, EmpCod FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00039", "SELECT ArchSiradigFec, ArchSiradigEstado, ArchSiradigFile, ArchSiradigError, ArchSiradigType, ArchSiradigName, CliCod, EmpCod FROM archivo_siradig WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?  FOR UPDATE OF archivo_siradig",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000310", "SAVEPOINT gxupdate;INSERT INTO archivo_siradig(ArchSiradigFec, ArchSiradigEstado, ArchSiradigFile, ArchSiradigError, ArchSiradigType, ArchSiradigName, CliCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000311", "SAVEPOINT gxupdate;UPDATE archivo_siradig SET ArchSiradigEstado=?, ArchSiradigError=?, ArchSiradigType=?, ArchSiradigName=?  WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000312", "SAVEPOINT gxupdate;UPDATE archivo_siradig SET ArchSiradigFile=?  WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000313", "SAVEPOINT gxupdate;DELETE FROM archivo_siradig  WHERE CliCod = ? AND EmpCod = ? AND ArchSiradigFec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000314", "SELECT TM1.ArchSiradigFec, TM1.ArchSiradigEstado, TM1.ArchSiradigFile, TM1.ArchSiradigError, TM1.ArchSiradigType, TM1.ArchSiradigName, TM1.CliCod, TM1.EmpCod FROM archivo_siradig TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ArchSiradigFec = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ArchSiradigFec ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000315", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000316", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               return;
            case 6 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 7 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 12 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDateTime(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getBLOBFile(3, rslt.getString(5, 20), rslt.getVarchar(6));
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 8 :
               stmt.setDateTime(1, (java.util.Date)parms[0], false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBLOBFile(3, (String)parms[2]);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setDateTime(7, (java.util.Date)parms[6], false);
               return;
            case 10 :
               stmt.setBLOBFile(1, (String)parms[0]);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDateTime(4, (java.util.Date)parms[3], false);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

