package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresareligiones_bc extends GXWebPanel implements IGxSilentTrn
{
   public empresareligiones_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresareligiones_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresareligiones_bc.class ));
   }

   public empresareligiones_bc( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow46146( ) ;
      standaloneNotModal( ) ;
      initializeNonKey46146( ) ;
      standaloneModal( ) ;
      addRow46146( ) ;
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
         e11462 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1237EmpReligion = A1237EmpReligion ;
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

   public void confirm_460( )
   {
      beforeValidate46146( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls46146( ) ;
         }
         else
         {
            checkExtendedTable46146( ) ;
            if ( AnyError == 0 )
            {
               zm46146( 3) ;
               zm46146( 4) ;
            }
            closeExtendedTableCursors46146( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12462( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      AV11IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaReligiones_Insert", GXv_boolean3) ;
         empresareligiones_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaReligiones_Update", GXv_boolean3) ;
         empresareligiones_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaReligiones_Delete", GXv_boolean3) ;
         empresareligiones_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
   }

   public void e11462( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm46146( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z3CliCod = A3CliCod ;
         Z1237EmpReligion = A1237EmpReligion ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         empresareligiones_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load46146( )
   {
      /* Using cursor BC00466 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound146 = (short)(1) ;
         zm46146( -2) ;
      }
      pr_default.close(4);
      onLoadActions46146( ) ;
   }

   public void onLoadActions46146( )
   {
      AV27Pgmname = "EmpresaReligiones_BC" ;
   }

   public void checkExtendedTable46146( )
   {
      nIsDirty_146 = (short)(0) ;
      standaloneModal( ) ;
      AV27Pgmname = "EmpresaReligiones_BC" ;
      /* Using cursor BC00467 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC00468 */
      pr_default.execute(6, new Object[] {A1237EmpReligion});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPRELIGION");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
   }

   public void closeExtendedTableCursors46146( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey46146( )
   {
      /* Using cursor BC00469 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound146 = (short)(1) ;
      }
      else
      {
         RcdFound146 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC004610 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm46146( 2) ;
         RcdFound146 = (short)(1) ;
         A3CliCod = BC004610_A3CliCod[0] ;
         A1237EmpReligion = BC004610_A1237EmpReligion[0] ;
         A1EmpCod = BC004610_A1EmpCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1237EmpReligion = A1237EmpReligion ;
         sMode146 = Gx_mode ;
         Gx_mode = "DSP" ;
         load46146( ) ;
         if ( AnyError == 1 )
         {
            RcdFound146 = (short)(0) ;
            initializeNonKey46146( ) ;
         }
         Gx_mode = sMode146 ;
      }
      else
      {
         RcdFound146 = (short)(0) ;
         initializeNonKey46146( ) ;
         sMode146 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode146 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey46146( ) ;
      if ( RcdFound146 == 0 )
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
      confirm_460( ) ;
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

   public void checkOptimisticConcurrency46146( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC004611 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresanolaborables_religion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresanolaborables_religion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert46146( )
   {
      beforeValidate46146( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable46146( ) ;
      }
      if ( AnyError == 0 )
      {
         zm46146( 0) ;
         checkOptimisticConcurrency46146( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm46146( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert46146( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004612 */
                  pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A1237EmpReligion, Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_religion");
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
            load46146( ) ;
         }
         endLevel46146( ) ;
      }
      closeExtendedTableCursors46146( ) ;
   }

   public void update46146( )
   {
      beforeValidate46146( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable46146( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency46146( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm46146( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate46146( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Empresanolaborables_religion */
                  deferredUpdate46146( ) ;
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
         endLevel46146( ) ;
      }
      closeExtendedTableCursors46146( ) ;
   }

   public void deferredUpdate46146( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate46146( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency46146( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls46146( ) ;
         afterConfirm46146( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete46146( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC004613 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_religion");
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
      sMode146 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel46146( ) ;
      Gx_mode = sMode146 ;
   }

   public void onDeleteControls46146( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV27Pgmname = "EmpresaReligiones_BC" ;
      }
   }

   public void endLevel46146( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete46146( ) ;
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

   public void scanKeyStart46146( )
   {
      /* Scan By routine */
      /* Using cursor BC004614 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1237EmpReligion});
      RcdFound146 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound146 = (short)(1) ;
         A3CliCod = BC004614_A3CliCod[0] ;
         A1237EmpReligion = BC004614_A1237EmpReligion[0] ;
         A1EmpCod = BC004614_A1EmpCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext46146( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound146 = (short)(0) ;
      scanKeyLoad46146( ) ;
   }

   public void scanKeyLoad46146( )
   {
      sMode146 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound146 = (short)(1) ;
         A3CliCod = BC004614_A3CliCod[0] ;
         A1237EmpReligion = BC004614_A1237EmpReligion[0] ;
         A1EmpCod = BC004614_A1EmpCod[0] ;
      }
      Gx_mode = sMode146 ;
   }

   public void scanKeyEnd46146( )
   {
      pr_default.close(12);
   }

   public void afterConfirm46146( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert46146( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate46146( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete46146( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete46146( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate46146( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes46146( )
   {
   }

   public void send_integrity_lvl_hashes46146( )
   {
   }

   public void addRow46146( )
   {
      VarsToRow146( bcEmpresaReligiones) ;
   }

   public void readRow46146( )
   {
      RowToVars146( bcEmpresaReligiones, 1) ;
   }

   public void initializeNonKey46146( )
   {
      A1229ReligId = "" ;
   }

   public void initAll46146( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A1237EmpReligion = "" ;
      initializeNonKey46146( ) ;
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

   public void VarsToRow146( web.SdtEmpresaReligiones obj146 )
   {
      obj146.setgxTv_SdtEmpresaReligiones_Mode( Gx_mode );
      obj146.setgxTv_SdtEmpresaReligiones_Clicod( A3CliCod );
      obj146.setgxTv_SdtEmpresaReligiones_Empcod( A1EmpCod );
      obj146.setgxTv_SdtEmpresaReligiones_Empreligion( A1237EmpReligion );
      obj146.setgxTv_SdtEmpresaReligiones_Clicod_Z( Z3CliCod );
      obj146.setgxTv_SdtEmpresaReligiones_Empcod_Z( Z1EmpCod );
      obj146.setgxTv_SdtEmpresaReligiones_Empreligion_Z( Z1237EmpReligion );
      obj146.setgxTv_SdtEmpresaReligiones_Mode( Gx_mode );
   }

   public void KeyVarsToRow146( web.SdtEmpresaReligiones obj146 )
   {
      obj146.setgxTv_SdtEmpresaReligiones_Clicod( A3CliCod );
      obj146.setgxTv_SdtEmpresaReligiones_Empcod( A1EmpCod );
      obj146.setgxTv_SdtEmpresaReligiones_Empreligion( A1237EmpReligion );
   }

   public void RowToVars146( web.SdtEmpresaReligiones obj146 ,
                             int forceLoad )
   {
      Gx_mode = obj146.getgxTv_SdtEmpresaReligiones_Mode() ;
      A3CliCod = obj146.getgxTv_SdtEmpresaReligiones_Clicod() ;
      A1EmpCod = obj146.getgxTv_SdtEmpresaReligiones_Empcod() ;
      A1237EmpReligion = obj146.getgxTv_SdtEmpresaReligiones_Empreligion() ;
      Z3CliCod = obj146.getgxTv_SdtEmpresaReligiones_Clicod_Z() ;
      Z1EmpCod = obj146.getgxTv_SdtEmpresaReligiones_Empcod_Z() ;
      Z1237EmpReligion = obj146.getgxTv_SdtEmpresaReligiones_Empreligion_Z() ;
      Gx_mode = obj146.getgxTv_SdtEmpresaReligiones_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A1237EmpReligion = (String)getParm(obj,2) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey46146( ) ;
      scanKeyStart46146( ) ;
      if ( RcdFound146 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC004615 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor BC004616 */
         pr_default.execute(14, new Object[] {A1237EmpReligion});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPRELIGION");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1237EmpReligion = A1237EmpReligion ;
      }
      zm46146( -2) ;
      onLoadActions46146( ) ;
      addRow46146( ) ;
      scanKeyEnd46146( ) ;
      if ( RcdFound146 == 0 )
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
      RowToVars146( bcEmpresaReligiones, 0) ;
      scanKeyStart46146( ) ;
      if ( RcdFound146 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC004617 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(15) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor BC004618 */
         pr_default.execute(16, new Object[] {A1237EmpReligion});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Religion", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPRELIGION");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1237EmpReligion = A1237EmpReligion ;
      }
      zm46146( -2) ;
      onLoadActions46146( ) ;
      addRow46146( ) ;
      scanKeyEnd46146( ) ;
      if ( RcdFound146 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey46146( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert46146( ) ;
      }
      else
      {
         if ( RcdFound146 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1237EmpReligion, Z1237EmpReligion) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A1237EmpReligion = Z1237EmpReligion ;
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
               update46146( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1237EmpReligion, Z1237EmpReligion) != 0 ) )
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
                     insert46146( ) ;
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
                     insert46146( ) ;
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
      RowToVars146( bcEmpresaReligiones, 1) ;
      saveImpl( ) ;
      VarsToRow146( bcEmpresaReligiones) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars146( bcEmpresaReligiones, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert46146( ) ;
      afterTrn( ) ;
      VarsToRow146( bcEmpresaReligiones) ;
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
         web.SdtEmpresaReligiones auxBC = new web.SdtEmpresaReligiones( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A1237EmpReligion);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEmpresaReligiones);
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
      RowToVars146( bcEmpresaReligiones, 1) ;
      updateImpl( ) ;
      VarsToRow146( bcEmpresaReligiones) ;
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
      RowToVars146( bcEmpresaReligiones, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert46146( ) ;
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
      VarsToRow146( bcEmpresaReligiones) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars146( bcEmpresaReligiones, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey46146( ) ;
      if ( RcdFound146 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1237EmpReligion, Z1237EmpReligion) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A1237EmpReligion = Z1237EmpReligion ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1237EmpReligion, Z1237EmpReligion) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "empresareligiones_bc");
      VarsToRow146( bcEmpresaReligiones) ;
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
      Gx_mode = bcEmpresaReligiones.getgxTv_SdtEmpresaReligiones_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEmpresaReligiones.setgxTv_SdtEmpresaReligiones_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtEmpresaReligiones sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEmpresaReligiones )
      {
         bcEmpresaReligiones = sdt ;
         if ( GXutil.strcmp(bcEmpresaReligiones.getgxTv_SdtEmpresaReligiones_Mode(), "") == 0 )
         {
            bcEmpresaReligiones.setgxTv_SdtEmpresaReligiones_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow146( bcEmpresaReligiones) ;
         }
         else
         {
            RowToVars146( bcEmpresaReligiones, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEmpresaReligiones.getgxTv_SdtEmpresaReligiones_Mode(), "") == 0 )
         {
            bcEmpresaReligiones.setgxTv_SdtEmpresaReligiones_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars146( bcEmpresaReligiones, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEmpresaReligiones getEmpresaReligiones_BC( )
   {
      return bcEmpresaReligiones ;
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
      Z1237EmpReligion = "" ;
      A1237EmpReligion = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV27Pgmname = "" ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      GXv_int5 = new int[1] ;
      BC00466_A3CliCod = new int[1] ;
      BC00466_A1237EmpReligion = new String[] {""} ;
      BC00466_A1EmpCod = new short[1] ;
      BC00467_A3CliCod = new int[1] ;
      BC00468_A1229ReligId = new String[] {""} ;
      BC00469_A3CliCod = new int[1] ;
      BC00469_A1EmpCod = new short[1] ;
      BC00469_A1237EmpReligion = new String[] {""} ;
      BC004610_A3CliCod = new int[1] ;
      BC004610_A1237EmpReligion = new String[] {""} ;
      BC004610_A1EmpCod = new short[1] ;
      sMode146 = "" ;
      BC004611_A3CliCod = new int[1] ;
      BC004611_A1237EmpReligion = new String[] {""} ;
      BC004611_A1EmpCod = new short[1] ;
      BC004614_A3CliCod = new int[1] ;
      BC004614_A1237EmpReligion = new String[] {""} ;
      BC004614_A1EmpCod = new short[1] ;
      A1229ReligId = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC004615_A3CliCod = new int[1] ;
      BC004616_A1229ReligId = new String[] {""} ;
      BC004617_A3CliCod = new int[1] ;
      BC004618_A1229ReligId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresareligiones_bc__default(),
         new Object[] {
             new Object[] {
            BC00462_A3CliCod, BC00462_A1237EmpReligion, BC00462_A1EmpCod
            }
            , new Object[] {
            BC00463_A3CliCod, BC00463_A1237EmpReligion, BC00463_A1EmpCod
            }
            , new Object[] {
            BC00464_A1229ReligId
            }
            , new Object[] {
            BC00465_A3CliCod
            }
            , new Object[] {
            BC00466_A3CliCod, BC00466_A1237EmpReligion, BC00466_A1EmpCod
            }
            , new Object[] {
            BC00467_A3CliCod
            }
            , new Object[] {
            BC00468_A1229ReligId
            }
            , new Object[] {
            BC00469_A3CliCod, BC00469_A1EmpCod, BC00469_A1237EmpReligion
            }
            , new Object[] {
            BC004610_A3CliCod, BC004610_A1237EmpReligion, BC004610_A1EmpCod
            }
            , new Object[] {
            BC004611_A3CliCod, BC004611_A1237EmpReligion, BC004611_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC004614_A3CliCod, BC004614_A1237EmpReligion, BC004614_A1EmpCod
            }
            , new Object[] {
            BC004615_A3CliCod
            }
            , new Object[] {
            BC004616_A1229ReligId
            }
            , new Object[] {
            BC004617_A3CliCod
            }
            , new Object[] {
            BC004618_A1229ReligId
            }
         }
      );
      AV27Pgmname = "EmpresaReligiones_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12462 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short RcdFound146 ;
   private short nIsDirty_146 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int GX_JID ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z1237EmpReligion ;
   private String A1237EmpReligion ;
   private String AV27Pgmname ;
   private String sMode146 ;
   private String A1229ReligId ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean mustCommit ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private web.SdtEmpresaReligiones bcEmpresaReligiones ;
   private IDataStoreProvider pr_default ;
   private int[] BC00466_A3CliCod ;
   private String[] BC00466_A1237EmpReligion ;
   private short[] BC00466_A1EmpCod ;
   private int[] BC00467_A3CliCod ;
   private String[] BC00468_A1229ReligId ;
   private int[] BC00469_A3CliCod ;
   private short[] BC00469_A1EmpCod ;
   private String[] BC00469_A1237EmpReligion ;
   private int[] BC004610_A3CliCod ;
   private String[] BC004610_A1237EmpReligion ;
   private short[] BC004610_A1EmpCod ;
   private int[] BC004611_A3CliCod ;
   private String[] BC004611_A1237EmpReligion ;
   private short[] BC004611_A1EmpCod ;
   private int[] BC004614_A3CliCod ;
   private String[] BC004614_A1237EmpReligion ;
   private short[] BC004614_A1EmpCod ;
   private int[] BC004615_A3CliCod ;
   private String[] BC004616_A1229ReligId ;
   private int[] BC004617_A3CliCod ;
   private String[] BC004618_A1229ReligId ;
   private int[] BC00462_A3CliCod ;
   private String[] BC00462_A1237EmpReligion ;
   private short[] BC00462_A1EmpCod ;
   private int[] BC00463_A3CliCod ;
   private String[] BC00463_A1237EmpReligion ;
   private short[] BC00463_A1EmpCod ;
   private String[] BC00464_A1229ReligId ;
   private int[] BC00465_A3CliCod ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class empresareligiones_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00462", "SELECT CliCod, EmpReligion, EmpCod FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?  FOR UPDATE OF Empresanolaborables_religion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00463", "SELECT CliCod, EmpReligion, EmpCod FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00464", "SELECT ReligId FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00465", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00466", "SELECT TM1.CliCod, TM1.EmpReligion, TM1.EmpCod FROM Empresanolaborables_religion TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.EmpReligion = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpReligion ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00467", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00468", "SELECT ReligId FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00469", "SELECT CliCod, EmpCod, EmpReligion FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004610", "SELECT CliCod, EmpReligion, EmpCod FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004611", "SELECT CliCod, EmpReligion, EmpCod FROM Empresanolaborables_religion WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?  FOR UPDATE OF Empresanolaborables_religion",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC004612", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_religion(CliCod, EmpReligion, EmpCod) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004613", "SAVEPOINT gxupdate;DELETE FROM Empresanolaborables_religion  WHERE CliCod = ? AND EmpCod = ? AND EmpReligion = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC004614", "SELECT TM1.CliCod, TM1.EmpReligion, TM1.EmpCod FROM Empresanolaborables_religion TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.EmpReligion = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpReligion ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004615", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004616", "SELECT ReligId FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004617", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004618", "SELECT ReligId FROM Religion WHERE ReligId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 16 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

