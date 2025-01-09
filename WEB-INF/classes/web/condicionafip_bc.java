package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class condicionafip_bc extends GXWebPanel implements IGxSilentTrn
{
   public condicionafip_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public condicionafip_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicionafip_bc.class ));
   }

   public condicionafip_bc( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0D11( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0D11( ) ;
      standaloneModal( ) ;
      addRow0D11( ) ;
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
         e110D2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z17CondiCodigo = A17CondiCodigo ;
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

   public void confirm_0D0( )
   {
      beforeValidate0D11( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0D11( ) ;
         }
         else
         {
            checkExtendedTable0D11( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0D11( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV8WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV8WWPContext = GXv_SdtWWPContext1[0] ;
      AV9IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondicionAFIP_Insert", GXv_boolean3) ;
         condicionafip_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondicionAFIP_Update", GXv_boolean3) ;
         condicionafip_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV9IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCondicionAFIP_Delete", GXv_boolean3) ;
         condicionafip_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV9IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV9IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV13Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
   }

   public void e110D2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0D11( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z686CondiDescriSinAc = A686CondiDescriSinAc ;
         Z144CondiDescri = A144CondiDescri ;
      }
      if ( GX_JID == -2 )
      {
         Z686CondiDescriSinAc = A686CondiDescriSinAc ;
         Z17CondiCodigo = A17CondiCodigo ;
         Z144CondiDescri = A144CondiDescri ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0D11( )
   {
      /* Using cursor BC000D4 */
      pr_default.execute(2, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A686CondiDescriSinAc = BC000D4_A686CondiDescriSinAc[0] ;
         A144CondiDescri = BC000D4_A144CondiDescri[0] ;
         zm0D11( -2) ;
      }
      pr_default.close(2);
      onLoadActions0D11( ) ;
   }

   public void onLoadActions0D11( )
   {
      AV13Pgmname = "CondicionAFIP_BC" ;
      GXt_char4 = A686CondiDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A144CondiDescri, GXv_char5) ;
      condicionafip_bc.this.GXt_char4 = GXv_char5[0] ;
      A686CondiDescriSinAc = GXutil.upper( GXt_char4) ;
   }

   public void checkExtendedTable0D11( )
   {
      nIsDirty_11 = (short)(0) ;
      standaloneModal( ) ;
      AV13Pgmname = "CondicionAFIP_BC" ;
      nIsDirty_11 = (short)(1) ;
      GXt_char4 = A686CondiDescriSinAc ;
      GXv_char5[0] = GXt_char4 ;
      new web.sacaracentos2(remoteHandle, context).execute( A144CondiDescri, GXv_char5) ;
      condicionafip_bc.this.GXt_char4 = GXv_char5[0] ;
      A686CondiDescriSinAc = GXutil.upper( GXt_char4) ;
   }

   public void closeExtendedTableCursors0D11( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0D11( )
   {
      /* Using cursor BC000D5 */
      pr_default.execute(3, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound11 = (short)(1) ;
      }
      else
      {
         RcdFound11 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000D6 */
      pr_default.execute(4, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0D11( 2) ;
         RcdFound11 = (short)(1) ;
         A686CondiDescriSinAc = BC000D6_A686CondiDescriSinAc[0] ;
         A17CondiCodigo = BC000D6_A17CondiCodigo[0] ;
         n17CondiCodigo = BC000D6_n17CondiCodigo[0] ;
         A144CondiDescri = BC000D6_A144CondiDescri[0] ;
         Z17CondiCodigo = A17CondiCodigo ;
         sMode11 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0D11( ) ;
         if ( AnyError == 1 )
         {
            RcdFound11 = (short)(0) ;
            initializeNonKey0D11( ) ;
         }
         Gx_mode = sMode11 ;
      }
      else
      {
         RcdFound11 = (short)(0) ;
         initializeNonKey0D11( ) ;
         sMode11 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode11 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0D11( ) ;
      if ( RcdFound11 == 0 )
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
      confirm_0D0( ) ;
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

   public void checkOptimisticConcurrency0D11( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000D7 */
         pr_default.execute(5, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CondicionAFIP"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z686CondiDescriSinAc, BC000D7_A686CondiDescriSinAc[0]) != 0 ) || ( GXutil.strcmp(Z144CondiDescri, BC000D7_A144CondiDescri[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CondicionAFIP"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0D11( )
   {
      beforeValidate0D11( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0D11( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0D11( 0) ;
         checkOptimisticConcurrency0D11( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0D11( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0D11( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000D8 */
                  pr_default.execute(6, new Object[] {A686CondiDescriSinAc, Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo), A144CondiDescri});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CondicionAFIP");
                  if ( (pr_default.getStatus(6) == 1) )
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
            load0D11( ) ;
         }
         endLevel0D11( ) ;
      }
      closeExtendedTableCursors0D11( ) ;
   }

   public void update0D11( )
   {
      beforeValidate0D11( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0D11( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0D11( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0D11( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0D11( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000D9 */
                  pr_default.execute(7, new Object[] {A686CondiDescriSinAc, A144CondiDescri, Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CondicionAFIP");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CondicionAFIP"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0D11( ) ;
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
         endLevel0D11( ) ;
      }
      closeExtendedTableCursors0D11( ) ;
   }

   public void deferredUpdate0D11( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0D11( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0D11( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0D11( ) ;
         afterConfirm0D11( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0D11( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000D10 */
               pr_default.execute(8, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CondicionAFIP");
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
      sMode11 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0D11( ) ;
      Gx_mode = sMode11 ;
   }

   public void onDeleteControls0D11( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV13Pgmname = "CondicionAFIP_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000D11 */
         pr_default.execute(9, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
         if ( (pr_default.getStatus(9) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(9);
         /* Using cursor BC000D12 */
         pr_default.execute(10, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
         if ( (pr_default.getStatus(10) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(10);
      }
   }

   public void endLevel0D11( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0D11( ) ;
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

   public void scanKeyStart0D11( )
   {
      /* Scan By routine */
      /* Using cursor BC000D13 */
      pr_default.execute(11, new Object[] {Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo)});
      RcdFound11 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A686CondiDescriSinAc = BC000D13_A686CondiDescriSinAc[0] ;
         A17CondiCodigo = BC000D13_A17CondiCodigo[0] ;
         n17CondiCodigo = BC000D13_n17CondiCodigo[0] ;
         A144CondiDescri = BC000D13_A144CondiDescri[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0D11( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound11 = (short)(0) ;
      scanKeyLoad0D11( ) ;
   }

   public void scanKeyLoad0D11( )
   {
      sMode11 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound11 = (short)(1) ;
         A686CondiDescriSinAc = BC000D13_A686CondiDescriSinAc[0] ;
         A17CondiCodigo = BC000D13_A17CondiCodigo[0] ;
         n17CondiCodigo = BC000D13_n17CondiCodigo[0] ;
         A144CondiDescri = BC000D13_A144CondiDescri[0] ;
      }
      Gx_mode = sMode11 ;
   }

   public void scanKeyEnd0D11( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0D11( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0D11( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0D11( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0D11( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0D11( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0D11( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0D11( )
   {
   }

   public void send_integrity_lvl_hashes0D11( )
   {
   }

   public void addRow0D11( )
   {
      VarsToRow11( bcCondicionAFIP) ;
   }

   public void readRow0D11( )
   {
      RowToVars11( bcCondicionAFIP, 1) ;
   }

   public void initializeNonKey0D11( )
   {
      A686CondiDescriSinAc = "" ;
      A144CondiDescri = "" ;
      Z686CondiDescriSinAc = "" ;
      Z144CondiDescri = "" ;
   }

   public void initAll0D11( )
   {
      A17CondiCodigo = (short)(0) ;
      n17CondiCodigo = false ;
      initializeNonKey0D11( ) ;
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

   public void VarsToRow11( web.SdtCondicionAFIP obj11 )
   {
      obj11.setgxTv_SdtCondicionAFIP_Mode( Gx_mode );
      obj11.setgxTv_SdtCondicionAFIP_Condidescrisinac( A686CondiDescriSinAc );
      obj11.setgxTv_SdtCondicionAFIP_Condidescri( A144CondiDescri );
      obj11.setgxTv_SdtCondicionAFIP_Condicodigo( A17CondiCodigo );
      obj11.setgxTv_SdtCondicionAFIP_Condicodigo_Z( Z17CondiCodigo );
      obj11.setgxTv_SdtCondicionAFIP_Condidescri_Z( Z144CondiDescri );
      obj11.setgxTv_SdtCondicionAFIP_Condidescrisinac_Z( Z686CondiDescriSinAc );
      obj11.setgxTv_SdtCondicionAFIP_Condicodigo_N( (byte)((byte)((n17CondiCodigo)?1:0)) );
      obj11.setgxTv_SdtCondicionAFIP_Mode( Gx_mode );
   }

   public void KeyVarsToRow11( web.SdtCondicionAFIP obj11 )
   {
      obj11.setgxTv_SdtCondicionAFIP_Condicodigo( A17CondiCodigo );
   }

   public void RowToVars11( web.SdtCondicionAFIP obj11 ,
                            int forceLoad )
   {
      Gx_mode = obj11.getgxTv_SdtCondicionAFIP_Mode() ;
      A686CondiDescriSinAc = obj11.getgxTv_SdtCondicionAFIP_Condidescrisinac() ;
      A144CondiDescri = obj11.getgxTv_SdtCondicionAFIP_Condidescri() ;
      A17CondiCodigo = obj11.getgxTv_SdtCondicionAFIP_Condicodigo() ;
      n17CondiCodigo = false ;
      Z17CondiCodigo = obj11.getgxTv_SdtCondicionAFIP_Condicodigo_Z() ;
      Z144CondiDescri = obj11.getgxTv_SdtCondicionAFIP_Condidescri_Z() ;
      Z686CondiDescriSinAc = obj11.getgxTv_SdtCondicionAFIP_Condidescrisinac_Z() ;
      n17CondiCodigo = (boolean)((obj11.getgxTv_SdtCondicionAFIP_Condicodigo_N()==0)?false:true) ;
      Gx_mode = obj11.getgxTv_SdtCondicionAFIP_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A17CondiCodigo = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      n17CondiCodigo = false ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0D11( ) ;
      scanKeyStart0D11( ) ;
      if ( RcdFound11 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z17CondiCodigo = A17CondiCodigo ;
      }
      zm0D11( -2) ;
      onLoadActions0D11( ) ;
      addRow0D11( ) ;
      scanKeyEnd0D11( ) ;
      if ( RcdFound11 == 0 )
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
      RowToVars11( bcCondicionAFIP, 0) ;
      scanKeyStart0D11( ) ;
      if ( RcdFound11 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z17CondiCodigo = A17CondiCodigo ;
      }
      zm0D11( -2) ;
      onLoadActions0D11( ) ;
      addRow0D11( ) ;
      scanKeyEnd0D11( ) ;
      if ( RcdFound11 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0D11( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0D11( ) ;
      }
      else
      {
         if ( RcdFound11 == 1 )
         {
            if ( A17CondiCodigo != Z17CondiCodigo )
            {
               A17CondiCodigo = Z17CondiCodigo ;
               n17CondiCodigo = false ;
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
               update0D11( ) ;
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
               if ( A17CondiCodigo != Z17CondiCodigo )
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
                     insert0D11( ) ;
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
                     insert0D11( ) ;
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
      RowToVars11( bcCondicionAFIP, 1) ;
      saveImpl( ) ;
      VarsToRow11( bcCondicionAFIP) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars11( bcCondicionAFIP, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0D11( ) ;
      afterTrn( ) ;
      VarsToRow11( bcCondicionAFIP) ;
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
         web.SdtCondicionAFIP auxBC = new web.SdtCondicionAFIP( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A17CondiCodigo);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcCondicionAFIP);
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
      RowToVars11( bcCondicionAFIP, 1) ;
      updateImpl( ) ;
      VarsToRow11( bcCondicionAFIP) ;
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
      RowToVars11( bcCondicionAFIP, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0D11( ) ;
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
      VarsToRow11( bcCondicionAFIP) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars11( bcCondicionAFIP, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0D11( ) ;
      if ( RcdFound11 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A17CondiCodigo != Z17CondiCodigo )
         {
            A17CondiCodigo = Z17CondiCodigo ;
            n17CondiCodigo = false ;
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
         if ( A17CondiCodigo != Z17CondiCodigo )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "condicionafip_bc");
      VarsToRow11( bcCondicionAFIP) ;
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
      Gx_mode = bcCondicionAFIP.getgxTv_SdtCondicionAFIP_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcCondicionAFIP.setgxTv_SdtCondicionAFIP_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtCondicionAFIP sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcCondicionAFIP )
      {
         bcCondicionAFIP = sdt ;
         if ( GXutil.strcmp(bcCondicionAFIP.getgxTv_SdtCondicionAFIP_Mode(), "") == 0 )
         {
            bcCondicionAFIP.setgxTv_SdtCondicionAFIP_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow11( bcCondicionAFIP) ;
         }
         else
         {
            RowToVars11( bcCondicionAFIP, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcCondicionAFIP.getgxTv_SdtCondicionAFIP_Mode(), "") == 0 )
         {
            bcCondicionAFIP.setgxTv_SdtCondicionAFIP_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars11( bcCondicionAFIP, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtCondicionAFIP getCondicionAFIP_BC( )
   {
      return bcCondicionAFIP ;
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
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV13Pgmname = "" ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      Z686CondiDescriSinAc = "" ;
      A686CondiDescriSinAc = "" ;
      Z144CondiDescri = "" ;
      A144CondiDescri = "" ;
      BC000D4_A686CondiDescriSinAc = new String[] {""} ;
      BC000D4_A17CondiCodigo = new short[1] ;
      BC000D4_n17CondiCodigo = new boolean[] {false} ;
      BC000D4_A144CondiDescri = new String[] {""} ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      BC000D5_A17CondiCodigo = new short[1] ;
      BC000D5_n17CondiCodigo = new boolean[] {false} ;
      BC000D6_A686CondiDescriSinAc = new String[] {""} ;
      BC000D6_A17CondiCodigo = new short[1] ;
      BC000D6_n17CondiCodigo = new boolean[] {false} ;
      BC000D6_A144CondiDescri = new String[] {""} ;
      sMode11 = "" ;
      BC000D7_A686CondiDescriSinAc = new String[] {""} ;
      BC000D7_A17CondiCodigo = new short[1] ;
      BC000D7_n17CondiCodigo = new boolean[] {false} ;
      BC000D7_A144CondiDescri = new String[] {""} ;
      BC000D11_A3CliCod = new int[1] ;
      BC000D11_A1EmpCod = new short[1] ;
      BC000D12_A3CliCod = new int[1] ;
      BC000D12_A1EmpCod = new short[1] ;
      BC000D12_A6LegNumero = new int[1] ;
      BC000D13_A686CondiDescriSinAc = new String[] {""} ;
      BC000D13_A17CondiCodigo = new short[1] ;
      BC000D13_n17CondiCodigo = new boolean[] {false} ;
      BC000D13_A144CondiDescri = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicionafip_bc__default(),
         new Object[] {
             new Object[] {
            BC000D2_A686CondiDescriSinAc, BC000D2_A17CondiCodigo, BC000D2_A144CondiDescri
            }
            , new Object[] {
            BC000D3_A686CondiDescriSinAc, BC000D3_A17CondiCodigo, BC000D3_A144CondiDescri
            }
            , new Object[] {
            BC000D4_A686CondiDescriSinAc, BC000D4_A17CondiCodigo, BC000D4_A144CondiDescri
            }
            , new Object[] {
            BC000D5_A17CondiCodigo
            }
            , new Object[] {
            BC000D6_A686CondiDescriSinAc, BC000D6_A17CondiCodigo, BC000D6_A144CondiDescri
            }
            , new Object[] {
            BC000D7_A686CondiDescriSinAc, BC000D7_A17CondiCodigo, BC000D7_A144CondiDescri
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000D11_A3CliCod, BC000D11_A1EmpCod
            }
            , new Object[] {
            BC000D12_A3CliCod, BC000D12_A1EmpCod, BC000D12_A6LegNumero
            }
            , new Object[] {
            BC000D13_A686CondiDescriSinAc, BC000D13_A17CondiCodigo, BC000D13_A144CondiDescri
            }
         }
      );
      AV13Pgmname = "CondicionAFIP_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120D2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z17CondiCodigo ;
   private short A17CondiCodigo ;
   private short RcdFound11 ;
   private short nIsDirty_11 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV13Pgmname ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private String sMode11 ;
   private boolean returnInSub ;
   private boolean AV9IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n17CondiCodigo ;
   private boolean mustCommit ;
   private String Z686CondiDescriSinAc ;
   private String A686CondiDescriSinAc ;
   private String Z144CondiDescri ;
   private String A144CondiDescri ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private web.SdtCondicionAFIP bcCondicionAFIP ;
   private IDataStoreProvider pr_default ;
   private String[] BC000D4_A686CondiDescriSinAc ;
   private short[] BC000D4_A17CondiCodigo ;
   private boolean[] BC000D4_n17CondiCodigo ;
   private String[] BC000D4_A144CondiDescri ;
   private short[] BC000D5_A17CondiCodigo ;
   private boolean[] BC000D5_n17CondiCodigo ;
   private String[] BC000D6_A686CondiDescriSinAc ;
   private short[] BC000D6_A17CondiCodigo ;
   private boolean[] BC000D6_n17CondiCodigo ;
   private String[] BC000D6_A144CondiDescri ;
   private String[] BC000D7_A686CondiDescriSinAc ;
   private short[] BC000D7_A17CondiCodigo ;
   private boolean[] BC000D7_n17CondiCodigo ;
   private String[] BC000D7_A144CondiDescri ;
   private int[] BC000D11_A3CliCod ;
   private short[] BC000D11_A1EmpCod ;
   private int[] BC000D12_A3CliCod ;
   private short[] BC000D12_A1EmpCod ;
   private int[] BC000D12_A6LegNumero ;
   private String[] BC000D13_A686CondiDescriSinAc ;
   private short[] BC000D13_A17CondiCodigo ;
   private boolean[] BC000D13_n17CondiCodigo ;
   private String[] BC000D13_A144CondiDescri ;
   private String[] BC000D2_A686CondiDescriSinAc ;
   private short[] BC000D2_A17CondiCodigo ;
   private String[] BC000D2_A144CondiDescri ;
   private String[] BC000D3_A686CondiDescriSinAc ;
   private short[] BC000D3_A17CondiCodigo ;
   private String[] BC000D3_A144CondiDescri ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
}

final  class condicionafip_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000D2", "SELECT CondiDescriSinAc, CondiCodigo, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ?  FOR UPDATE OF CondicionAFIP",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D3", "SELECT CondiDescriSinAc, CondiCodigo, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D4", "SELECT TM1.CondiDescriSinAc, TM1.CondiCodigo, TM1.CondiDescri FROM CondicionAFIP TM1 WHERE TM1.CondiCodigo = ? ORDER BY TM1.CondiCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D5", "SELECT CondiCodigo FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D6", "SELECT CondiDescriSinAc, CondiCodigo, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000D7", "SELECT CondiDescriSinAc, CondiCodigo, CondiDescri FROM CondicionAFIP WHERE CondiCodigo = ?  FOR UPDATE OF CondicionAFIP",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000D8", "SAVEPOINT gxupdate;INSERT INTO CondicionAFIP(CondiDescriSinAc, CondiCodigo, CondiDescri) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000D9", "SAVEPOINT gxupdate;UPDATE CondicionAFIP SET CondiDescriSinAc=?, CondiDescri=?  WHERE CondiCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000D10", "SAVEPOINT gxupdate;DELETE FROM CondicionAFIP  WHERE CondiCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000D11", "SELECT CliCod, EmpCod FROM Empresa WHERE EmpCondiCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000D12", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CondiCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000D13", "SELECT TM1.CondiDescriSinAc, TM1.CondiCodigo, TM1.CondiDescri FROM CondicionAFIP TM1 WHERE TM1.CondiCodigo = ? ORDER BY TM1.CondiCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 4 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 5 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(2, ((Number) parms[2]).shortValue());
               }
               stmt.setVarchar(3, (String)parms[3], 40, false);
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[3]).shortValue());
               }
               return;
            case 8 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 9 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 10 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
            case 11 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(1, ((Number) parms[1]).shortValue());
               }
               return;
      }
   }

}

