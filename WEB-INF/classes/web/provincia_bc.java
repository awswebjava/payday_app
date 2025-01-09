package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class provincia_bc extends GXWebPanel implements IGxSilentTrn
{
   public provincia_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public provincia_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( provincia_bc.class ));
   }

   public provincia_bc( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1942( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1942( ) ;
      standaloneModal( ) ;
      addRow1942( ) ;
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
         e11192 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z46PaiCod = A46PaiCod ;
            Z47ProvCod = A47ProvCod ;
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

   public void confirm_190( )
   {
      beforeValidate1942( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1942( ) ;
         }
         else
         {
            checkExtendedTable1942( ) ;
            if ( AnyError == 0 )
            {
               zm1942( 2) ;
            }
            closeExtendedTableCursors1942( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12192( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWProvincia_Insert", GXv_boolean3) ;
         provincia_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWProvincia_Update", GXv_boolean3) ;
         provincia_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWProvincia_Delete", GXv_boolean3) ;
         provincia_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV14Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
   }

   public void e11192( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1942( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         Z322ProvNom = A322ProvNom ;
         Z554ProvSiradig = A554ProvSiradig ;
      }
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z312PaiNom = A312PaiNom ;
      }
      if ( GX_JID == -1 )
      {
         Z47ProvCod = A47ProvCod ;
         Z322ProvNom = A322ProvNom ;
         Z554ProvSiradig = A554ProvSiradig ;
         Z46PaiCod = A46PaiCod ;
         Z312PaiNom = A312PaiNom ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1942( )
   {
      /* Using cursor BC00195 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A312PaiNom = BC00195_A312PaiNom[0] ;
         A322ProvNom = BC00195_A322ProvNom[0] ;
         A554ProvSiradig = BC00195_A554ProvSiradig[0] ;
         zm1942( -1) ;
      }
      pr_default.close(3);
      onLoadActions1942( ) ;
   }

   public void onLoadActions1942( )
   {
      AV14Pgmname = "Provincia_BC" ;
   }

   public void checkExtendedTable1942( )
   {
      nIsDirty_42 = (short)(0) ;
      standaloneModal( ) ;
      AV14Pgmname = "Provincia_BC" ;
      /* Using cursor BC00196 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
      }
      A312PaiNom = BC00196_A312PaiNom[0] ;
      pr_default.close(4);
   }

   public void closeExtendedTableCursors1942( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey1942( )
   {
      /* Using cursor BC00197 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound42 = (short)(1) ;
      }
      else
      {
         RcdFound42 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00198 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm1942( 1) ;
         RcdFound42 = (short)(1) ;
         A47ProvCod = BC00198_A47ProvCod[0] ;
         A322ProvNom = BC00198_A322ProvNom[0] ;
         A554ProvSiradig = BC00198_A554ProvSiradig[0] ;
         A46PaiCod = BC00198_A46PaiCod[0] ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
         sMode42 = Gx_mode ;
         Gx_mode = "DSP" ;
         load1942( ) ;
         if ( AnyError == 1 )
         {
            RcdFound42 = (short)(0) ;
            initializeNonKey1942( ) ;
         }
         Gx_mode = sMode42 ;
      }
      else
      {
         RcdFound42 = (short)(0) ;
         initializeNonKey1942( ) ;
         sMode42 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode42 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey1942( ) ;
      if ( RcdFound42 == 0 )
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
      confirm_190( ) ;
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

   public void checkOptimisticConcurrency1942( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00199 */
         pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Provincia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z322ProvNom, BC00199_A322ProvNom[0]) != 0 ) || ( Z554ProvSiradig != BC00199_A554ProvSiradig[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Provincia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1942( )
   {
      beforeValidate1942( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1942( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1942( 0) ;
         checkOptimisticConcurrency1942( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1942( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1942( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001910 */
                  pr_default.execute(8, new Object[] {Short.valueOf(A47ProvCod), A322ProvNom, Short.valueOf(A554ProvSiradig), Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Provincia");
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
            load1942( ) ;
         }
         endLevel1942( ) ;
      }
      closeExtendedTableCursors1942( ) ;
   }

   public void update1942( )
   {
      beforeValidate1942( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1942( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1942( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1942( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1942( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001911 */
                  pr_default.execute(9, new Object[] {A322ProvNom, Short.valueOf(A554ProvSiradig), Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Provincia");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Provincia"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1942( ) ;
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
         endLevel1942( ) ;
      }
      closeExtendedTableCursors1942( ) ;
   }

   public void deferredUpdate1942( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1942( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1942( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1942( ) ;
         afterConfirm1942( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1942( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001912 */
               pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Provincia");
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
      sMode42 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1942( ) ;
      Gx_mode = sMode42 ;
   }

   public void onDeleteControls1942( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV14Pgmname = "Provincia_BC" ;
         /* Using cursor BC001913 */
         pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod)});
         A312PaiNom = BC001913_A312PaiNom[0] ;
         pr_default.close(11);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC001914 */
         pr_default.execute(12, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "CategoriaProvincias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor BC001915 */
         pr_default.execute(13, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Localidad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor BC001916 */
         pr_default.execute(14, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void endLevel1942( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1942( ) ;
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

   public void scanKeyStart1942( )
   {
      /* Scan By routine */
      /* Using cursor BC001917 */
      pr_default.execute(15, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A47ProvCod)});
      RcdFound42 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A47ProvCod = BC001917_A47ProvCod[0] ;
         A312PaiNom = BC001917_A312PaiNom[0] ;
         A322ProvNom = BC001917_A322ProvNom[0] ;
         A554ProvSiradig = BC001917_A554ProvSiradig[0] ;
         A46PaiCod = BC001917_A46PaiCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1942( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound42 = (short)(0) ;
      scanKeyLoad1942( ) ;
   }

   public void scanKeyLoad1942( )
   {
      sMode42 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound42 = (short)(1) ;
         A47ProvCod = BC001917_A47ProvCod[0] ;
         A312PaiNom = BC001917_A312PaiNom[0] ;
         A322ProvNom = BC001917_A322ProvNom[0] ;
         A554ProvSiradig = BC001917_A554ProvSiradig[0] ;
         A46PaiCod = BC001917_A46PaiCod[0] ;
      }
      Gx_mode = sMode42 ;
   }

   public void scanKeyEnd1942( )
   {
      pr_default.close(15);
   }

   public void afterConfirm1942( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1942( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1942( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1942( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1942( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1942( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1942( )
   {
   }

   public void send_integrity_lvl_hashes1942( )
   {
   }

   public void addRow1942( )
   {
      VarsToRow42( bcProvincia) ;
   }

   public void readRow1942( )
   {
      RowToVars42( bcProvincia, 1) ;
   }

   public void initializeNonKey1942( )
   {
      A312PaiNom = "" ;
      A322ProvNom = "" ;
      A554ProvSiradig = (short)(0) ;
      Z322ProvNom = "" ;
      Z554ProvSiradig = (short)(0) ;
   }

   public void initAll1942( )
   {
      A46PaiCod = (short)(0) ;
      A47ProvCod = (short)(0) ;
      initializeNonKey1942( ) ;
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

   public void VarsToRow42( web.SdtProvincia obj42 )
   {
      obj42.setgxTv_SdtProvincia_Mode( Gx_mode );
      obj42.setgxTv_SdtProvincia_Painom( A312PaiNom );
      obj42.setgxTv_SdtProvincia_Provnom( A322ProvNom );
      obj42.setgxTv_SdtProvincia_Provsiradig( A554ProvSiradig );
      obj42.setgxTv_SdtProvincia_Paicod( A46PaiCod );
      obj42.setgxTv_SdtProvincia_Provcod( A47ProvCod );
      obj42.setgxTv_SdtProvincia_Paicod_Z( Z46PaiCod );
      obj42.setgxTv_SdtProvincia_Painom_Z( Z312PaiNom );
      obj42.setgxTv_SdtProvincia_Provcod_Z( Z47ProvCod );
      obj42.setgxTv_SdtProvincia_Provnom_Z( Z322ProvNom );
      obj42.setgxTv_SdtProvincia_Provsiradig_Z( Z554ProvSiradig );
      obj42.setgxTv_SdtProvincia_Mode( Gx_mode );
   }

   public void KeyVarsToRow42( web.SdtProvincia obj42 )
   {
      obj42.setgxTv_SdtProvincia_Paicod( A46PaiCod );
      obj42.setgxTv_SdtProvincia_Provcod( A47ProvCod );
   }

   public void RowToVars42( web.SdtProvincia obj42 ,
                            int forceLoad )
   {
      Gx_mode = obj42.getgxTv_SdtProvincia_Mode() ;
      A312PaiNom = obj42.getgxTv_SdtProvincia_Painom() ;
      A322ProvNom = obj42.getgxTv_SdtProvincia_Provnom() ;
      A554ProvSiradig = obj42.getgxTv_SdtProvincia_Provsiradig() ;
      A46PaiCod = obj42.getgxTv_SdtProvincia_Paicod() ;
      A47ProvCod = obj42.getgxTv_SdtProvincia_Provcod() ;
      Z46PaiCod = obj42.getgxTv_SdtProvincia_Paicod_Z() ;
      Z312PaiNom = obj42.getgxTv_SdtProvincia_Painom_Z() ;
      Z47ProvCod = obj42.getgxTv_SdtProvincia_Provcod_Z() ;
      Z322ProvNom = obj42.getgxTv_SdtProvincia_Provnom_Z() ;
      Z554ProvSiradig = obj42.getgxTv_SdtProvincia_Provsiradig_Z() ;
      Gx_mode = obj42.getgxTv_SdtProvincia_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A46PaiCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      A47ProvCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1942( ) ;
      scanKeyStart1942( ) ;
      if ( RcdFound42 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001918 */
         pr_default.execute(16, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
         }
         A312PaiNom = BC001918_A312PaiNom[0] ;
         pr_default.close(16);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
      }
      zm1942( -1) ;
      onLoadActions1942( ) ;
      addRow1942( ) ;
      scanKeyEnd1942( ) ;
      if ( RcdFound42 == 0 )
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
      RowToVars42( bcProvincia, 0) ;
      scanKeyStart1942( ) ;
      if ( RcdFound42 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001919 */
         pr_default.execute(17, new Object[] {Short.valueOf(A46PaiCod)});
         if ( (pr_default.getStatus(17) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
            AnyError = (short)(1) ;
         }
         A312PaiNom = BC001919_A312PaiNom[0] ;
         pr_default.close(17);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z46PaiCod = A46PaiCod ;
         Z47ProvCod = A47ProvCod ;
      }
      zm1942( -1) ;
      onLoadActions1942( ) ;
      addRow1942( ) ;
      scanKeyEnd1942( ) ;
      if ( RcdFound42 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1942( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1942( ) ;
      }
      else
      {
         if ( RcdFound42 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) )
            {
               A46PaiCod = Z46PaiCod ;
               A47ProvCod = Z47ProvCod ;
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
               update1942( ) ;
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
               if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) )
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
                     insert1942( ) ;
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
                     insert1942( ) ;
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
      RowToVars42( bcProvincia, 1) ;
      saveImpl( ) ;
      VarsToRow42( bcProvincia) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars42( bcProvincia, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1942( ) ;
      afterTrn( ) ;
      VarsToRow42( bcProvincia) ;
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
         web.SdtProvincia auxBC = new web.SdtProvincia( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A46PaiCod, A47ProvCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcProvincia);
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
      RowToVars42( bcProvincia, 1) ;
      updateImpl( ) ;
      VarsToRow42( bcProvincia) ;
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
      RowToVars42( bcProvincia, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1942( ) ;
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
      VarsToRow42( bcProvincia) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars42( bcProvincia, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1942( ) ;
      if ( RcdFound42 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) )
         {
            A46PaiCod = Z46PaiCod ;
            A47ProvCod = Z47ProvCod ;
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
         if ( ( A46PaiCod != Z46PaiCod ) || ( A47ProvCod != Z47ProvCod ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "provincia_bc");
      VarsToRow42( bcProvincia) ;
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
      Gx_mode = bcProvincia.getgxTv_SdtProvincia_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcProvincia.setgxTv_SdtProvincia_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtProvincia sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcProvincia )
      {
         bcProvincia = sdt ;
         if ( GXutil.strcmp(bcProvincia.getgxTv_SdtProvincia_Mode(), "") == 0 )
         {
            bcProvincia.setgxTv_SdtProvincia_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow42( bcProvincia) ;
         }
         else
         {
            RowToVars42( bcProvincia, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcProvincia.getgxTv_SdtProvincia_Mode(), "") == 0 )
         {
            bcProvincia.setgxTv_SdtProvincia_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars42( bcProvincia, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtProvincia getProvincia_BC( )
   {
      return bcProvincia ;
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
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV14Pgmname = "" ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      Z322ProvNom = "" ;
      A322ProvNom = "" ;
      Z312PaiNom = "" ;
      A312PaiNom = "" ;
      BC00195_A47ProvCod = new short[1] ;
      BC00195_A312PaiNom = new String[] {""} ;
      BC00195_A322ProvNom = new String[] {""} ;
      BC00195_A554ProvSiradig = new short[1] ;
      BC00195_A46PaiCod = new short[1] ;
      BC00196_A312PaiNom = new String[] {""} ;
      BC00197_A46PaiCod = new short[1] ;
      BC00197_A47ProvCod = new short[1] ;
      BC00198_A47ProvCod = new short[1] ;
      BC00198_A322ProvNom = new String[] {""} ;
      BC00198_A554ProvSiradig = new short[1] ;
      BC00198_A46PaiCod = new short[1] ;
      sMode42 = "" ;
      BC00199_A47ProvCod = new short[1] ;
      BC00199_A322ProvNom = new String[] {""} ;
      BC00199_A554ProvSiradig = new short[1] ;
      BC00199_A46PaiCod = new short[1] ;
      BC001913_A312PaiNom = new String[] {""} ;
      BC001914_A3CliCod = new int[1] ;
      BC001914_A1564CliPaiConve = new short[1] ;
      BC001914_A1565CliConvenio = new String[] {""} ;
      BC001914_A8CatCodigo = new String[] {""} ;
      BC001914_A2200CatPaiCod = new short[1] ;
      BC001914_A2201CatProvCod = new short[1] ;
      BC001915_A46PaiCod = new short[1] ;
      BC001915_A47ProvCod = new short[1] ;
      BC001915_A48LocCod = new short[1] ;
      BC001916_A3CliCod = new int[1] ;
      BC001916_A1EmpCod = new short[1] ;
      BC001916_A6LegNumero = new int[1] ;
      BC001917_A47ProvCod = new short[1] ;
      BC001917_A312PaiNom = new String[] {""} ;
      BC001917_A322ProvNom = new String[] {""} ;
      BC001917_A554ProvSiradig = new short[1] ;
      BC001917_A46PaiCod = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001918_A312PaiNom = new String[] {""} ;
      BC001919_A312PaiNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.provincia_bc__default(),
         new Object[] {
             new Object[] {
            BC00192_A47ProvCod, BC00192_A322ProvNom, BC00192_A554ProvSiradig, BC00192_A46PaiCod
            }
            , new Object[] {
            BC00193_A47ProvCod, BC00193_A322ProvNom, BC00193_A554ProvSiradig, BC00193_A46PaiCod
            }
            , new Object[] {
            BC00194_A312PaiNom
            }
            , new Object[] {
            BC00195_A47ProvCod, BC00195_A312PaiNom, BC00195_A322ProvNom, BC00195_A554ProvSiradig, BC00195_A46PaiCod
            }
            , new Object[] {
            BC00196_A312PaiNom
            }
            , new Object[] {
            BC00197_A46PaiCod, BC00197_A47ProvCod
            }
            , new Object[] {
            BC00198_A47ProvCod, BC00198_A322ProvNom, BC00198_A554ProvSiradig, BC00198_A46PaiCod
            }
            , new Object[] {
            BC00199_A47ProvCod, BC00199_A322ProvNom, BC00199_A554ProvSiradig, BC00199_A46PaiCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001913_A312PaiNom
            }
            , new Object[] {
            BC001914_A3CliCod, BC001914_A1564CliPaiConve, BC001914_A1565CliConvenio, BC001914_A8CatCodigo, BC001914_A2200CatPaiCod, BC001914_A2201CatProvCod
            }
            , new Object[] {
            BC001915_A46PaiCod, BC001915_A47ProvCod, BC001915_A48LocCod
            }
            , new Object[] {
            BC001916_A3CliCod, BC001916_A1EmpCod, BC001916_A6LegNumero
            }
            , new Object[] {
            BC001917_A47ProvCod, BC001917_A312PaiNom, BC001917_A322ProvNom, BC001917_A554ProvSiradig, BC001917_A46PaiCod
            }
            , new Object[] {
            BC001918_A312PaiNom
            }
            , new Object[] {
            BC001919_A312PaiNom
            }
         }
      );
      AV14Pgmname = "Provincia_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12192 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short Z47ProvCod ;
   private short A47ProvCod ;
   private short Z554ProvSiradig ;
   private short A554ProvSiradig ;
   private short RcdFound42 ;
   private short nIsDirty_42 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV14Pgmname ;
   private String sMode42 ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean mustCommit ;
   private String Z322ProvNom ;
   private String A322ProvNom ;
   private String Z312PaiNom ;
   private String A312PaiNom ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private web.SdtProvincia bcProvincia ;
   private IDataStoreProvider pr_default ;
   private short[] BC00195_A47ProvCod ;
   private String[] BC00195_A312PaiNom ;
   private String[] BC00195_A322ProvNom ;
   private short[] BC00195_A554ProvSiradig ;
   private short[] BC00195_A46PaiCod ;
   private String[] BC00196_A312PaiNom ;
   private short[] BC00197_A46PaiCod ;
   private short[] BC00197_A47ProvCod ;
   private short[] BC00198_A47ProvCod ;
   private String[] BC00198_A322ProvNom ;
   private short[] BC00198_A554ProvSiradig ;
   private short[] BC00198_A46PaiCod ;
   private short[] BC00199_A47ProvCod ;
   private String[] BC00199_A322ProvNom ;
   private short[] BC00199_A554ProvSiradig ;
   private short[] BC00199_A46PaiCod ;
   private String[] BC001913_A312PaiNom ;
   private int[] BC001914_A3CliCod ;
   private short[] BC001914_A1564CliPaiConve ;
   private String[] BC001914_A1565CliConvenio ;
   private String[] BC001914_A8CatCodigo ;
   private short[] BC001914_A2200CatPaiCod ;
   private short[] BC001914_A2201CatProvCod ;
   private short[] BC001915_A46PaiCod ;
   private short[] BC001915_A47ProvCod ;
   private short[] BC001915_A48LocCod ;
   private int[] BC001916_A3CliCod ;
   private short[] BC001916_A1EmpCod ;
   private int[] BC001916_A6LegNumero ;
   private short[] BC001917_A47ProvCod ;
   private String[] BC001917_A312PaiNom ;
   private String[] BC001917_A322ProvNom ;
   private short[] BC001917_A554ProvSiradig ;
   private short[] BC001917_A46PaiCod ;
   private String[] BC001918_A312PaiNom ;
   private String[] BC001919_A312PaiNom ;
   private short[] BC00192_A47ProvCod ;
   private String[] BC00192_A322ProvNom ;
   private short[] BC00192_A554ProvSiradig ;
   private short[] BC00192_A46PaiCod ;
   private short[] BC00193_A47ProvCod ;
   private String[] BC00193_A322ProvNom ;
   private short[] BC00193_A554ProvSiradig ;
   private short[] BC00193_A46PaiCod ;
   private String[] BC00194_A312PaiNom ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class provincia_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00192", "SELECT ProvCod, ProvNom, ProvSiradig, PaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ?  FOR UPDATE OF Provincia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00193", "SELECT ProvCod, ProvNom, ProvSiradig, PaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00194", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00195", "SELECT TM1.ProvCod, T2.PaiNom, TM1.ProvNom, TM1.ProvSiradig, TM1.PaiCod FROM (Provincia TM1 INNER JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) WHERE TM1.PaiCod = ? and TM1.ProvCod = ? ORDER BY TM1.PaiCod, TM1.ProvCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00196", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00197", "SELECT PaiCod, ProvCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00198", "SELECT ProvCod, ProvNom, ProvSiradig, PaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00199", "SELECT ProvCod, ProvNom, ProvSiradig, PaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ?  FOR UPDATE OF Provincia",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001910", "SAVEPOINT gxupdate;INSERT INTO Provincia(ProvCod, ProvNom, ProvSiradig, PaiCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001911", "SAVEPOINT gxupdate;UPDATE Provincia SET ProvNom=?, ProvSiradig=?  WHERE PaiCod = ? AND ProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001912", "SAVEPOINT gxupdate;DELETE FROM Provincia  WHERE PaiCod = ? AND ProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001913", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001914", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CatPaiCod = ? AND CatProvCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001915", "SELECT PaiCod, ProvCod, LocCod FROM Localidad WHERE PaiCod = ? AND ProvCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001916", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE LegPaiCod = ? AND LegProvCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001917", "SELECT TM1.ProvCod, T2.PaiNom, TM1.ProvNom, TM1.ProvSiradig, TM1.PaiCod FROM (Provincia TM1 INNER JOIN Pais T2 ON T2.PaiCod = TM1.PaiCod) WHERE TM1.PaiCod = ? and TM1.ProvCod = ? ORDER BY TM1.PaiCod, TM1.ProvCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001918", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001919", "SELECT PaiNom FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

