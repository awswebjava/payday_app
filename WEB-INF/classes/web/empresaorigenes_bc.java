package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresaorigenes_bc extends GXWebPanel implements IGxSilentTrn
{
   public empresaorigenes_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresaorigenes_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresaorigenes_bc.class ));
   }

   public empresaorigenes_bc( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow4A145( ) ;
      standaloneNotModal( ) ;
      initializeNonKey4A145( ) ;
      standaloneModal( ) ;
      addRow4A145( ) ;
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
         e114A2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1238EmpOrigen = A1238EmpOrigen ;
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

   public void confirm_4A0( )
   {
      beforeValidate4A145( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4A145( ) ;
         }
         else
         {
            checkExtendedTable4A145( ) ;
            if ( AnyError == 0 )
            {
               zm4A145( 3) ;
               zm4A145( 4) ;
            }
            closeExtendedTableCursors4A145( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e124A2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaOrigenes_Insert", GXv_boolean3) ;
         empresaorigenes_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaOrigenes_Update", GXv_boolean3) ;
         empresaorigenes_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaOrigenes_Delete", GXv_boolean3) ;
         empresaorigenes_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV28Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
   }

   public void e114A2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm4A145( int GX_JID )
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
         Z1EmpCod = A1EmpCod ;
         Z1238EmpOrigen = A1238EmpOrigen ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         empresaorigenes_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load4A145( )
   {
      /* Using cursor BC004A6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound145 = (short)(1) ;
         zm4A145( -2) ;
      }
      pr_default.close(4);
      onLoadActions4A145( ) ;
   }

   public void onLoadActions4A145( )
   {
      AV28Pgmname = "EmpresaOrigenes_BC" ;
   }

   public void checkExtendedTable4A145( )
   {
      nIsDirty_145 = (short)(0) ;
      standaloneModal( ) ;
      AV28Pgmname = "EmpresaOrigenes_BC" ;
      /* Using cursor BC004A7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      /* Using cursor BC004A8 */
      pr_default.execute(6, new Object[] {A1238EmpOrigen});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Origen", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPORIGEN");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
   }

   public void closeExtendedTableCursors4A145( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey4A145( )
   {
      /* Using cursor BC004A9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound145 = (short)(1) ;
      }
      else
      {
         RcdFound145 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC004A10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm4A145( 2) ;
         RcdFound145 = (short)(1) ;
         A3CliCod = BC004A10_A3CliCod[0] ;
         A1EmpCod = BC004A10_A1EmpCod[0] ;
         A1238EmpOrigen = BC004A10_A1238EmpOrigen[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1238EmpOrigen = A1238EmpOrigen ;
         sMode145 = Gx_mode ;
         Gx_mode = "DSP" ;
         load4A145( ) ;
         if ( AnyError == 1 )
         {
            RcdFound145 = (short)(0) ;
            initializeNonKey4A145( ) ;
         }
         Gx_mode = sMode145 ;
      }
      else
      {
         RcdFound145 = (short)(0) ;
         initializeNonKey4A145( ) ;
         sMode145 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode145 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey4A145( ) ;
      if ( RcdFound145 == 0 )
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
      confirm_4A0( ) ;
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

   public void checkOptimisticConcurrency4A145( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC004A11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresanolaborables_origen"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresanolaborables_origen"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4A145( )
   {
      beforeValidate4A145( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4A145( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4A145( 0) ;
         checkOptimisticConcurrency4A145( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4A145( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4A145( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004A12 */
                  pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_origen");
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
            load4A145( ) ;
         }
         endLevel4A145( ) ;
      }
      closeExtendedTableCursors4A145( ) ;
   }

   public void update4A145( )
   {
      beforeValidate4A145( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4A145( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4A145( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4A145( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4A145( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table Empresanolaborables_origen */
                  deferredUpdate4A145( ) ;
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
         endLevel4A145( ) ;
      }
      closeExtendedTableCursors4A145( ) ;
   }

   public void deferredUpdate4A145( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate4A145( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4A145( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4A145( ) ;
         afterConfirm4A145( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4A145( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC004A13 */
               pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresanolaborables_origen");
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
      sMode145 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel4A145( ) ;
      Gx_mode = sMode145 ;
   }

   public void onDeleteControls4A145( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV28Pgmname = "EmpresaOrigenes_BC" ;
      }
   }

   public void endLevel4A145( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4A145( ) ;
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

   public void scanKeyStart4A145( )
   {
      /* Scan By routine */
      /* Using cursor BC004A14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1238EmpOrigen});
      RcdFound145 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound145 = (short)(1) ;
         A3CliCod = BC004A14_A3CliCod[0] ;
         A1EmpCod = BC004A14_A1EmpCod[0] ;
         A1238EmpOrigen = BC004A14_A1238EmpOrigen[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext4A145( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound145 = (short)(0) ;
      scanKeyLoad4A145( ) ;
   }

   public void scanKeyLoad4A145( )
   {
      sMode145 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound145 = (short)(1) ;
         A3CliCod = BC004A14_A3CliCod[0] ;
         A1EmpCod = BC004A14_A1EmpCod[0] ;
         A1238EmpOrigen = BC004A14_A1238EmpOrigen[0] ;
      }
      Gx_mode = sMode145 ;
   }

   public void scanKeyEnd4A145( )
   {
      pr_default.close(12);
   }

   public void afterConfirm4A145( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4A145( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4A145( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4A145( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4A145( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4A145( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4A145( )
   {
   }

   public void send_integrity_lvl_hashes4A145( )
   {
   }

   public void addRow4A145( )
   {
      VarsToRow145( bcEmpresaOrigenes) ;
   }

   public void readRow4A145( )
   {
      RowToVars145( bcEmpresaOrigenes, 1) ;
   }

   public void initializeNonKey4A145( )
   {
      A1231OrigId = "" ;
   }

   public void initAll4A145( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A1238EmpOrigen = "" ;
      initializeNonKey4A145( ) ;
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

   public void VarsToRow145( web.SdtEmpresaOrigenes obj145 )
   {
      obj145.setgxTv_SdtEmpresaOrigenes_Mode( Gx_mode );
      obj145.setgxTv_SdtEmpresaOrigenes_Clicod( A3CliCod );
      obj145.setgxTv_SdtEmpresaOrigenes_Empcod( A1EmpCod );
      obj145.setgxTv_SdtEmpresaOrigenes_Emporigen( A1238EmpOrigen );
      obj145.setgxTv_SdtEmpresaOrigenes_Clicod_Z( Z3CliCod );
      obj145.setgxTv_SdtEmpresaOrigenes_Empcod_Z( Z1EmpCod );
      obj145.setgxTv_SdtEmpresaOrigenes_Emporigen_Z( Z1238EmpOrigen );
      obj145.setgxTv_SdtEmpresaOrigenes_Mode( Gx_mode );
   }

   public void KeyVarsToRow145( web.SdtEmpresaOrigenes obj145 )
   {
      obj145.setgxTv_SdtEmpresaOrigenes_Clicod( A3CliCod );
      obj145.setgxTv_SdtEmpresaOrigenes_Empcod( A1EmpCod );
      obj145.setgxTv_SdtEmpresaOrigenes_Emporigen( A1238EmpOrigen );
   }

   public void RowToVars145( web.SdtEmpresaOrigenes obj145 ,
                             int forceLoad )
   {
      Gx_mode = obj145.getgxTv_SdtEmpresaOrigenes_Mode() ;
      A3CliCod = obj145.getgxTv_SdtEmpresaOrigenes_Clicod() ;
      A1EmpCod = obj145.getgxTv_SdtEmpresaOrigenes_Empcod() ;
      A1238EmpOrigen = obj145.getgxTv_SdtEmpresaOrigenes_Emporigen() ;
      Z3CliCod = obj145.getgxTv_SdtEmpresaOrigenes_Clicod_Z() ;
      Z1EmpCod = obj145.getgxTv_SdtEmpresaOrigenes_Empcod_Z() ;
      Z1238EmpOrigen = obj145.getgxTv_SdtEmpresaOrigenes_Emporigen_Z() ;
      Gx_mode = obj145.getgxTv_SdtEmpresaOrigenes_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A1238EmpOrigen = (String)getParm(obj,2) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey4A145( ) ;
      scanKeyStart4A145( ) ;
      if ( RcdFound145 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC004A15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor BC004A16 */
         pr_default.execute(14, new Object[] {A1238EmpOrigen});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Origen", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPORIGEN");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1238EmpOrigen = A1238EmpOrigen ;
      }
      zm4A145( -2) ;
      onLoadActions4A145( ) ;
      addRow4A145( ) ;
      scanKeyEnd4A145( ) ;
      if ( RcdFound145 == 0 )
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
      RowToVars145( bcEmpresaOrigenes, 0) ;
      scanKeyStart4A145( ) ;
      if ( RcdFound145 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC004A17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(15) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor BC004A18 */
         pr_default.execute(16, new Object[] {A1238EmpOrigen});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Origen", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPORIGEN");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1238EmpOrigen = A1238EmpOrigen ;
      }
      zm4A145( -2) ;
      onLoadActions4A145( ) ;
      addRow4A145( ) ;
      scanKeyEnd4A145( ) ;
      if ( RcdFound145 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4A145( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert4A145( ) ;
      }
      else
      {
         if ( RcdFound145 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1238EmpOrigen, Z1238EmpOrigen) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A1238EmpOrigen = Z1238EmpOrigen ;
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
               update4A145( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1238EmpOrigen, Z1238EmpOrigen) != 0 ) )
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
                     insert4A145( ) ;
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
                     insert4A145( ) ;
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
      RowToVars145( bcEmpresaOrigenes, 1) ;
      saveImpl( ) ;
      VarsToRow145( bcEmpresaOrigenes) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars145( bcEmpresaOrigenes, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert4A145( ) ;
      afterTrn( ) ;
      VarsToRow145( bcEmpresaOrigenes) ;
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
         web.SdtEmpresaOrigenes auxBC = new web.SdtEmpresaOrigenes( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A1238EmpOrigen);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEmpresaOrigenes);
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
      RowToVars145( bcEmpresaOrigenes, 1) ;
      updateImpl( ) ;
      VarsToRow145( bcEmpresaOrigenes) ;
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
      RowToVars145( bcEmpresaOrigenes, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert4A145( ) ;
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
      VarsToRow145( bcEmpresaOrigenes) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars145( bcEmpresaOrigenes, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey4A145( ) ;
      if ( RcdFound145 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1238EmpOrigen, Z1238EmpOrigen) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A1238EmpOrigen = Z1238EmpOrigen ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( GXutil.strcmp(A1238EmpOrigen, Z1238EmpOrigen) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "empresaorigenes_bc");
      VarsToRow145( bcEmpresaOrigenes) ;
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
      Gx_mode = bcEmpresaOrigenes.getgxTv_SdtEmpresaOrigenes_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEmpresaOrigenes.setgxTv_SdtEmpresaOrigenes_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtEmpresaOrigenes sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEmpresaOrigenes )
      {
         bcEmpresaOrigenes = sdt ;
         if ( GXutil.strcmp(bcEmpresaOrigenes.getgxTv_SdtEmpresaOrigenes_Mode(), "") == 0 )
         {
            bcEmpresaOrigenes.setgxTv_SdtEmpresaOrigenes_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow145( bcEmpresaOrigenes) ;
         }
         else
         {
            RowToVars145( bcEmpresaOrigenes, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEmpresaOrigenes.getgxTv_SdtEmpresaOrigenes_Mode(), "") == 0 )
         {
            bcEmpresaOrigenes.setgxTv_SdtEmpresaOrigenes_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars145( bcEmpresaOrigenes, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEmpresaOrigenes getEmpresaOrigenes_BC( )
   {
      return bcEmpresaOrigenes ;
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
      Z1238EmpOrigen = "" ;
      A1238EmpOrigen = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV28Pgmname = "" ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      GXv_int5 = new int[1] ;
      BC004A6_A3CliCod = new int[1] ;
      BC004A6_A1EmpCod = new short[1] ;
      BC004A6_A1238EmpOrigen = new String[] {""} ;
      BC004A7_A3CliCod = new int[1] ;
      BC004A8_A1231OrigId = new String[] {""} ;
      BC004A9_A3CliCod = new int[1] ;
      BC004A9_A1EmpCod = new short[1] ;
      BC004A9_A1238EmpOrigen = new String[] {""} ;
      BC004A10_A3CliCod = new int[1] ;
      BC004A10_A1EmpCod = new short[1] ;
      BC004A10_A1238EmpOrigen = new String[] {""} ;
      sMode145 = "" ;
      BC004A11_A3CliCod = new int[1] ;
      BC004A11_A1EmpCod = new short[1] ;
      BC004A11_A1238EmpOrigen = new String[] {""} ;
      BC004A14_A3CliCod = new int[1] ;
      BC004A14_A1EmpCod = new short[1] ;
      BC004A14_A1238EmpOrigen = new String[] {""} ;
      A1231OrigId = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC004A15_A3CliCod = new int[1] ;
      BC004A16_A1231OrigId = new String[] {""} ;
      BC004A17_A3CliCod = new int[1] ;
      BC004A18_A1231OrigId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresaorigenes_bc__default(),
         new Object[] {
             new Object[] {
            BC004A2_A3CliCod, BC004A2_A1EmpCod, BC004A2_A1238EmpOrigen
            }
            , new Object[] {
            BC004A3_A3CliCod, BC004A3_A1EmpCod, BC004A3_A1238EmpOrigen
            }
            , new Object[] {
            BC004A4_A3CliCod
            }
            , new Object[] {
            BC004A5_A1231OrigId
            }
            , new Object[] {
            BC004A6_A3CliCod, BC004A6_A1EmpCod, BC004A6_A1238EmpOrigen
            }
            , new Object[] {
            BC004A7_A3CliCod
            }
            , new Object[] {
            BC004A8_A1231OrigId
            }
            , new Object[] {
            BC004A9_A3CliCod, BC004A9_A1EmpCod, BC004A9_A1238EmpOrigen
            }
            , new Object[] {
            BC004A10_A3CliCod, BC004A10_A1EmpCod, BC004A10_A1238EmpOrigen
            }
            , new Object[] {
            BC004A11_A3CliCod, BC004A11_A1EmpCod, BC004A11_A1238EmpOrigen
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC004A14_A3CliCod, BC004A14_A1EmpCod, BC004A14_A1238EmpOrigen
            }
            , new Object[] {
            BC004A15_A3CliCod
            }
            , new Object[] {
            BC004A16_A1231OrigId
            }
            , new Object[] {
            BC004A17_A3CliCod
            }
            , new Object[] {
            BC004A18_A1231OrigId
            }
         }
      );
      AV28Pgmname = "EmpresaOrigenes_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e124A2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short RcdFound145 ;
   private short nIsDirty_145 ;
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
   private String Z1238EmpOrigen ;
   private String A1238EmpOrigen ;
   private String AV28Pgmname ;
   private String sMode145 ;
   private String A1231OrigId ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean mustCommit ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private web.SdtEmpresaOrigenes bcEmpresaOrigenes ;
   private IDataStoreProvider pr_default ;
   private int[] BC004A6_A3CliCod ;
   private short[] BC004A6_A1EmpCod ;
   private String[] BC004A6_A1238EmpOrigen ;
   private int[] BC004A7_A3CliCod ;
   private String[] BC004A8_A1231OrigId ;
   private int[] BC004A9_A3CliCod ;
   private short[] BC004A9_A1EmpCod ;
   private String[] BC004A9_A1238EmpOrigen ;
   private int[] BC004A10_A3CliCod ;
   private short[] BC004A10_A1EmpCod ;
   private String[] BC004A10_A1238EmpOrigen ;
   private int[] BC004A11_A3CliCod ;
   private short[] BC004A11_A1EmpCod ;
   private String[] BC004A11_A1238EmpOrigen ;
   private int[] BC004A14_A3CliCod ;
   private short[] BC004A14_A1EmpCod ;
   private String[] BC004A14_A1238EmpOrigen ;
   private int[] BC004A15_A3CliCod ;
   private String[] BC004A16_A1231OrigId ;
   private int[] BC004A17_A3CliCod ;
   private String[] BC004A18_A1231OrigId ;
   private int[] BC004A2_A3CliCod ;
   private short[] BC004A2_A1EmpCod ;
   private String[] BC004A2_A1238EmpOrigen ;
   private int[] BC004A3_A3CliCod ;
   private short[] BC004A3_A1EmpCod ;
   private String[] BC004A3_A1238EmpOrigen ;
   private int[] BC004A4_A3CliCod ;
   private String[] BC004A5_A1231OrigId ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class empresaorigenes_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC004A2", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?  FOR UPDATE OF Empresanolaborables_origen",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A3", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A4", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A5", "SELECT OrigId FROM Origen WHERE OrigId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A6", "SELECT TM1.CliCod, TM1.EmpCod, TM1.EmpOrigen FROM Empresanolaborables_origen TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.EmpOrigen = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpOrigen ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A7", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A8", "SELECT OrigId FROM Origen WHERE OrigId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A9", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A10", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A11", "SELECT CliCod, EmpCod, EmpOrigen FROM Empresanolaborables_origen WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?  FOR UPDATE OF Empresanolaborables_origen",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC004A12", "SAVEPOINT gxupdate;INSERT INTO Empresanolaborables_origen(CliCod, EmpCod, EmpOrigen) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004A13", "SAVEPOINT gxupdate;DELETE FROM Empresanolaborables_origen  WHERE CliCod = ? AND EmpCod = ? AND EmpOrigen = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC004A14", "SELECT TM1.CliCod, TM1.EmpCod, TM1.EmpOrigen FROM Empresanolaborables_origen TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.EmpOrigen = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpOrigen ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A15", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A16", "SELECT OrigId FROM Origen WHERE OrigId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A17", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004A18", "SELECT OrigId FROM Origen WHERE OrigId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
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

