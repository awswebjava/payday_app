package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class parentesco_bc extends GXWebPanel implements IGxSilentTrn
{
   public parentesco_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public parentesco_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parentesco_bc.class ));
   }

   public parentesco_bc( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1740( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1740( ) ;
      standaloneModal( ) ;
      addRow1740( ) ;
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
         e11172 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z30ParCod = A30ParCod ;
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

   public void confirm_170( )
   {
      beforeValidate1740( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1740( ) ;
         }
         else
         {
            checkExtendedTable1740( ) ;
            if ( AnyError == 0 )
            {
               zm1740( 7) ;
            }
            closeExtendedTableCursors1740( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12172( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWParentesco_Insert", GXv_boolean3) ;
         parentesco_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWParentesco_Update", GXv_boolean3) ;
         parentesco_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWParentesco_Delete", GXv_boolean3) ;
         parentesco_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e11172( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm1740( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z313ParDescrip = A313ParDescrip ;
         Z317ParRes551 = A317ParRes551 ;
         Z314ParHabilitado = A314ParHabilitado ;
         Z2083ParDescripSinAc = A2083ParDescripSinAc ;
         Z2274ParenTipo = A2274ParenTipo ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -6 )
      {
         Z30ParCod = A30ParCod ;
         Z313ParDescrip = A313ParDescrip ;
         Z317ParRes551 = A317ParRes551 ;
         Z314ParHabilitado = A314ParHabilitado ;
         Z2083ParDescripSinAc = A2083ParDescripSinAc ;
         Z2274ParenTipo = A2274ParenTipo ;
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
         parentesco_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (false==A314ParHabilitado) && ( Gx_BScreen == 0 ) )
      {
         A314ParHabilitado = true ;
      }
   }

   public void load1740( )
   {
      /* Using cursor BC00175 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A313ParDescrip = BC00175_A313ParDescrip[0] ;
         A317ParRes551 = BC00175_A317ParRes551[0] ;
         A314ParHabilitado = BC00175_A314ParHabilitado[0] ;
         A2083ParDescripSinAc = BC00175_A2083ParDescripSinAc[0] ;
         A2274ParenTipo = BC00175_A2274ParenTipo[0] ;
         zm1740( -6) ;
      }
      pr_default.close(3);
      onLoadActions1740( ) ;
   }

   public void onLoadActions1740( )
   {
      AV16Pgmname = "Parentesco_BC" ;
   }

   public void checkExtendedTable1740( )
   {
      nIsDirty_40 = (short)(0) ;
      standaloneModal( ) ;
      AV16Pgmname = "Parentesco_BC" ;
      /* Using cursor BC00176 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      if ( (GXutil.strcmp("", A30ParCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Código", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A313ParDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripción", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A2274ParenTipo, "1") == 0 ) || ( GXutil.strcmp(A2274ParenTipo, "2") == 0 ) || ( GXutil.strcmp(A2274ParenTipo, "3") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de parentesco", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors1740( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey1740( )
   {
      /* Using cursor BC00177 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound40 = (short)(1) ;
      }
      else
      {
         RcdFound40 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00178 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm1740( 6) ;
         RcdFound40 = (short)(1) ;
         A30ParCod = BC00178_A30ParCod[0] ;
         A313ParDescrip = BC00178_A313ParDescrip[0] ;
         A317ParRes551 = BC00178_A317ParRes551[0] ;
         A314ParHabilitado = BC00178_A314ParHabilitado[0] ;
         A2083ParDescripSinAc = BC00178_A2083ParDescripSinAc[0] ;
         A2274ParenTipo = BC00178_A2274ParenTipo[0] ;
         A3CliCod = BC00178_A3CliCod[0] ;
         Z3CliCod = A3CliCod ;
         Z30ParCod = A30ParCod ;
         sMode40 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1740( ) ;
         if ( AnyError == 1 )
         {
            RcdFound40 = (short)(0) ;
            initializeNonKey1740( ) ;
         }
         Gx_mode = sMode40 ;
      }
      else
      {
         RcdFound40 = (short)(0) ;
         initializeNonKey1740( ) ;
         sMode40 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode40 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey1740( ) ;
      if ( RcdFound40 == 0 )
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
      confirm_170( ) ;
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

   public void checkOptimisticConcurrency1740( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00179 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Parentesco"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z313ParDescrip, BC00179_A313ParDescrip[0]) != 0 ) || ( GXutil.strcmp(Z317ParRes551, BC00179_A317ParRes551[0]) != 0 ) || ( Z314ParHabilitado != BC00179_A314ParHabilitado[0] ) || ( GXutil.strcmp(Z2083ParDescripSinAc, BC00179_A2083ParDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z2274ParenTipo, BC00179_A2274ParenTipo[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Parentesco"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1740( )
   {
      beforeValidate1740( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1740( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1740( 0) ;
         checkOptimisticConcurrency1740( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1740( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1740( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001710 */
                  pr_default.execute(8, new Object[] {A30ParCod, A313ParDescrip, A317ParRes551, Boolean.valueOf(A314ParHabilitado), A2083ParDescripSinAc, A2274ParenTipo, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Parentesco");
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
            load1740( ) ;
         }
         endLevel1740( ) ;
      }
      closeExtendedTableCursors1740( ) ;
   }

   public void update1740( )
   {
      beforeValidate1740( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1740( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1740( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1740( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1740( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001711 */
                  pr_default.execute(9, new Object[] {A313ParDescrip, A317ParRes551, Boolean.valueOf(A314ParHabilitado), A2083ParDescripSinAc, A2274ParenTipo, Integer.valueOf(A3CliCod), A30ParCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Parentesco");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Parentesco"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1740( ) ;
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
         endLevel1740( ) ;
      }
      closeExtendedTableCursors1740( ) ;
   }

   public void deferredUpdate1740( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1740( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1740( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1740( ) ;
         afterConfirm1740( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1740( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001712 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Parentesco");
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
      sMode40 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1740( ) ;
      Gx_mode = sMode40 ;
   }

   public void onDeleteControls1740( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "Parentesco_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC001713 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo Familia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
      }
   }

   public void endLevel1740( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1740( ) ;
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

   public void scanKeyStart1740( )
   {
      /* Scan By routine */
      /* Using cursor BC001714 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A30ParCod});
      RcdFound40 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A30ParCod = BC001714_A30ParCod[0] ;
         A313ParDescrip = BC001714_A313ParDescrip[0] ;
         A317ParRes551 = BC001714_A317ParRes551[0] ;
         A314ParHabilitado = BC001714_A314ParHabilitado[0] ;
         A2083ParDescripSinAc = BC001714_A2083ParDescripSinAc[0] ;
         A2274ParenTipo = BC001714_A2274ParenTipo[0] ;
         A3CliCod = BC001714_A3CliCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1740( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound40 = (short)(0) ;
      scanKeyLoad1740( ) ;
   }

   public void scanKeyLoad1740( )
   {
      sMode40 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound40 = (short)(1) ;
         A30ParCod = BC001714_A30ParCod[0] ;
         A313ParDescrip = BC001714_A313ParDescrip[0] ;
         A317ParRes551 = BC001714_A317ParRes551[0] ;
         A314ParHabilitado = BC001714_A314ParHabilitado[0] ;
         A2083ParDescripSinAc = BC001714_A2083ParDescripSinAc[0] ;
         A2274ParenTipo = BC001714_A2274ParenTipo[0] ;
         A3CliCod = BC001714_A3CliCod[0] ;
      }
      Gx_mode = sMode40 ;
   }

   public void scanKeyEnd1740( )
   {
      pr_default.close(12);
   }

   public void afterConfirm1740( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1740( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1740( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1740( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1740( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1740( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1740( )
   {
   }

   public void send_integrity_lvl_hashes1740( )
   {
   }

   public void addRow1740( )
   {
      VarsToRow40( bcParentesco) ;
   }

   public void readRow1740( )
   {
      RowToVars40( bcParentesco, 1) ;
   }

   public void initializeNonKey1740( )
   {
      A313ParDescrip = "" ;
      A317ParRes551 = "" ;
      A2083ParDescripSinAc = "" ;
      A2274ParenTipo = "" ;
      A314ParHabilitado = true ;
      Z313ParDescrip = "" ;
      Z317ParRes551 = "" ;
      Z314ParHabilitado = false ;
      Z2083ParDescripSinAc = "" ;
      Z2274ParenTipo = "" ;
   }

   public void initAll1740( )
   {
      A3CliCod = 0 ;
      A30ParCod = "" ;
      initializeNonKey1740( ) ;
   }

   public void standaloneModalInsert( )
   {
      A314ParHabilitado = i314ParHabilitado ;
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

   public void VarsToRow40( web.SdtParentesco obj40 )
   {
      obj40.setgxTv_SdtParentesco_Mode( Gx_mode );
      obj40.setgxTv_SdtParentesco_Pardescrip( A313ParDescrip );
      obj40.setgxTv_SdtParentesco_Parres551( A317ParRes551 );
      obj40.setgxTv_SdtParentesco_Pardescripsinac( A2083ParDescripSinAc );
      obj40.setgxTv_SdtParentesco_Parentipo( A2274ParenTipo );
      obj40.setgxTv_SdtParentesco_Parhabilitado( A314ParHabilitado );
      obj40.setgxTv_SdtParentesco_Clicod( A3CliCod );
      obj40.setgxTv_SdtParentesco_Parcod( A30ParCod );
      obj40.setgxTv_SdtParentesco_Clicod_Z( Z3CliCod );
      obj40.setgxTv_SdtParentesco_Parcod_Z( Z30ParCod );
      obj40.setgxTv_SdtParentesco_Pardescrip_Z( Z313ParDescrip );
      obj40.setgxTv_SdtParentesco_Parres551_Z( Z317ParRes551 );
      obj40.setgxTv_SdtParentesco_Parhabilitado_Z( Z314ParHabilitado );
      obj40.setgxTv_SdtParentesco_Pardescripsinac_Z( Z2083ParDescripSinAc );
      obj40.setgxTv_SdtParentesco_Parentipo_Z( Z2274ParenTipo );
      obj40.setgxTv_SdtParentesco_Mode( Gx_mode );
   }

   public void KeyVarsToRow40( web.SdtParentesco obj40 )
   {
      obj40.setgxTv_SdtParentesco_Clicod( A3CliCod );
      obj40.setgxTv_SdtParentesco_Parcod( A30ParCod );
   }

   public void RowToVars40( web.SdtParentesco obj40 ,
                            int forceLoad )
   {
      Gx_mode = obj40.getgxTv_SdtParentesco_Mode() ;
      A313ParDescrip = obj40.getgxTv_SdtParentesco_Pardescrip() ;
      A317ParRes551 = obj40.getgxTv_SdtParentesco_Parres551() ;
      A2083ParDescripSinAc = obj40.getgxTv_SdtParentesco_Pardescripsinac() ;
      A2274ParenTipo = obj40.getgxTv_SdtParentesco_Parentipo() ;
      A314ParHabilitado = obj40.getgxTv_SdtParentesco_Parhabilitado() ;
      A3CliCod = obj40.getgxTv_SdtParentesco_Clicod() ;
      A30ParCod = obj40.getgxTv_SdtParentesco_Parcod() ;
      Z3CliCod = obj40.getgxTv_SdtParentesco_Clicod_Z() ;
      Z30ParCod = obj40.getgxTv_SdtParentesco_Parcod_Z() ;
      Z313ParDescrip = obj40.getgxTv_SdtParentesco_Pardescrip_Z() ;
      Z317ParRes551 = obj40.getgxTv_SdtParentesco_Parres551_Z() ;
      Z314ParHabilitado = obj40.getgxTv_SdtParentesco_Parhabilitado_Z() ;
      Z2083ParDescripSinAc = obj40.getgxTv_SdtParentesco_Pardescripsinac_Z() ;
      Z2274ParenTipo = obj40.getgxTv_SdtParentesco_Parentipo_Z() ;
      Gx_mode = obj40.getgxTv_SdtParentesco_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A30ParCod = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1740( ) ;
      scanKeyStart1740( ) ;
      if ( RcdFound40 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001715 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z30ParCod = A30ParCod ;
      }
      zm1740( -6) ;
      onLoadActions1740( ) ;
      addRow1740( ) ;
      scanKeyEnd1740( ) ;
      if ( RcdFound40 == 0 )
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
      RowToVars40( bcParentesco, 0) ;
      scanKeyStart1740( ) ;
      if ( RcdFound40 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001716 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z30ParCod = A30ParCod ;
      }
      zm1740( -6) ;
      onLoadActions1740( ) ;
      addRow1740( ) ;
      scanKeyEnd1740( ) ;
      if ( RcdFound40 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1740( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1740( ) ;
      }
      else
      {
         if ( RcdFound40 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A30ParCod, Z30ParCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A30ParCod = Z30ParCod ;
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
               update1740( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A30ParCod, Z30ParCod) != 0 ) )
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
                     insert1740( ) ;
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
                     insert1740( ) ;
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
      RowToVars40( bcParentesco, 1) ;
      saveImpl( ) ;
      VarsToRow40( bcParentesco) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars40( bcParentesco, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1740( ) ;
      afterTrn( ) ;
      VarsToRow40( bcParentesco) ;
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
         web.SdtParentesco auxBC = new web.SdtParentesco( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A30ParCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcParentesco);
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
      RowToVars40( bcParentesco, 1) ;
      updateImpl( ) ;
      VarsToRow40( bcParentesco) ;
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
      RowToVars40( bcParentesco, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1740( ) ;
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
      VarsToRow40( bcParentesco) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars40( bcParentesco, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1740( ) ;
      if ( RcdFound40 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A30ParCod, Z30ParCod) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A30ParCod = Z30ParCod ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A30ParCod, Z30ParCod) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "parentesco_bc");
      VarsToRow40( bcParentesco) ;
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
      Gx_mode = bcParentesco.getgxTv_SdtParentesco_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcParentesco.setgxTv_SdtParentesco_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtParentesco sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcParentesco )
      {
         bcParentesco = sdt ;
         if ( GXutil.strcmp(bcParentesco.getgxTv_SdtParentesco_Mode(), "") == 0 )
         {
            bcParentesco.setgxTv_SdtParentesco_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow40( bcParentesco) ;
         }
         else
         {
            RowToVars40( bcParentesco, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcParentesco.getgxTv_SdtParentesco_Mode(), "") == 0 )
         {
            bcParentesco.setgxTv_SdtParentesco_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars40( bcParentesco, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtParentesco getParentesco_BC( )
   {
      return bcParentesco ;
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
      Z30ParCod = "" ;
      A30ParCod = "" ;
      AV8WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV16Pgmname = "" ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      Z313ParDescrip = "" ;
      A313ParDescrip = "" ;
      Z317ParRes551 = "" ;
      A317ParRes551 = "" ;
      Z2083ParDescripSinAc = "" ;
      A2083ParDescripSinAc = "" ;
      Z2274ParenTipo = "" ;
      A2274ParenTipo = "" ;
      GXv_int5 = new int[1] ;
      BC00175_A30ParCod = new String[] {""} ;
      BC00175_A313ParDescrip = new String[] {""} ;
      BC00175_A317ParRes551 = new String[] {""} ;
      BC00175_A314ParHabilitado = new boolean[] {false} ;
      BC00175_A2083ParDescripSinAc = new String[] {""} ;
      BC00175_A2274ParenTipo = new String[] {""} ;
      BC00175_A3CliCod = new int[1] ;
      BC00176_A3CliCod = new int[1] ;
      BC00177_A3CliCod = new int[1] ;
      BC00177_A30ParCod = new String[] {""} ;
      BC00178_A30ParCod = new String[] {""} ;
      BC00178_A313ParDescrip = new String[] {""} ;
      BC00178_A317ParRes551 = new String[] {""} ;
      BC00178_A314ParHabilitado = new boolean[] {false} ;
      BC00178_A2083ParDescripSinAc = new String[] {""} ;
      BC00178_A2274ParenTipo = new String[] {""} ;
      BC00178_A3CliCod = new int[1] ;
      sMode40 = "" ;
      BC00179_A30ParCod = new String[] {""} ;
      BC00179_A313ParDescrip = new String[] {""} ;
      BC00179_A317ParRes551 = new String[] {""} ;
      BC00179_A314ParHabilitado = new boolean[] {false} ;
      BC00179_A2083ParDescripSinAc = new String[] {""} ;
      BC00179_A2274ParenTipo = new String[] {""} ;
      BC00179_A3CliCod = new int[1] ;
      BC001713_A3CliCod = new int[1] ;
      BC001713_A1EmpCod = new short[1] ;
      BC001713_A6LegNumero = new int[1] ;
      BC001713_A29LegOrden = new short[1] ;
      BC001714_A30ParCod = new String[] {""} ;
      BC001714_A313ParDescrip = new String[] {""} ;
      BC001714_A317ParRes551 = new String[] {""} ;
      BC001714_A314ParHabilitado = new boolean[] {false} ;
      BC001714_A2083ParDescripSinAc = new String[] {""} ;
      BC001714_A2274ParenTipo = new String[] {""} ;
      BC001714_A3CliCod = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001715_A3CliCod = new int[1] ;
      BC001716_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.parentesco_bc__default(),
         new Object[] {
             new Object[] {
            BC00172_A30ParCod, BC00172_A313ParDescrip, BC00172_A317ParRes551, BC00172_A314ParHabilitado, BC00172_A2083ParDescripSinAc, BC00172_A2274ParenTipo, BC00172_A3CliCod
            }
            , new Object[] {
            BC00173_A30ParCod, BC00173_A313ParDescrip, BC00173_A317ParRes551, BC00173_A314ParHabilitado, BC00173_A2083ParDescripSinAc, BC00173_A2274ParenTipo, BC00173_A3CliCod
            }
            , new Object[] {
            BC00174_A3CliCod
            }
            , new Object[] {
            BC00175_A30ParCod, BC00175_A313ParDescrip, BC00175_A317ParRes551, BC00175_A314ParHabilitado, BC00175_A2083ParDescripSinAc, BC00175_A2274ParenTipo, BC00175_A3CliCod
            }
            , new Object[] {
            BC00176_A3CliCod
            }
            , new Object[] {
            BC00177_A3CliCod, BC00177_A30ParCod
            }
            , new Object[] {
            BC00178_A30ParCod, BC00178_A313ParDescrip, BC00178_A317ParRes551, BC00178_A314ParHabilitado, BC00178_A2083ParDescripSinAc, BC00178_A2274ParenTipo, BC00178_A3CliCod
            }
            , new Object[] {
            BC00179_A30ParCod, BC00179_A313ParDescrip, BC00179_A317ParRes551, BC00179_A314ParHabilitado, BC00179_A2083ParDescripSinAc, BC00179_A2274ParenTipo, BC00179_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001713_A3CliCod, BC001713_A1EmpCod, BC001713_A6LegNumero, BC001713_A29LegOrden
            }
            , new Object[] {
            BC001714_A30ParCod, BC001714_A313ParDescrip, BC001714_A317ParRes551, BC001714_A314ParHabilitado, BC001714_A2083ParDescripSinAc, BC001714_A2274ParenTipo, BC001714_A3CliCod
            }
            , new Object[] {
            BC001715_A3CliCod
            }
            , new Object[] {
            BC001716_A3CliCod
            }
         }
      );
      AV16Pgmname = "Parentesco_BC" ;
      Z314ParHabilitado = true ;
      A314ParHabilitado = true ;
      i314ParHabilitado = true ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12172 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound40 ;
   private short nIsDirty_40 ;
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
   private String Z30ParCod ;
   private String A30ParCod ;
   private String AV16Pgmname ;
   private String Z2274ParenTipo ;
   private String A2274ParenTipo ;
   private String sMode40 ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z314ParHabilitado ;
   private boolean A314ParHabilitado ;
   private boolean i314ParHabilitado ;
   private boolean mustCommit ;
   private String Z313ParDescrip ;
   private String A313ParDescrip ;
   private String Z317ParRes551 ;
   private String A317ParRes551 ;
   private String Z2083ParDescripSinAc ;
   private String A2083ParDescripSinAc ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private web.SdtParentesco bcParentesco ;
   private IDataStoreProvider pr_default ;
   private String[] BC00175_A30ParCod ;
   private String[] BC00175_A313ParDescrip ;
   private String[] BC00175_A317ParRes551 ;
   private boolean[] BC00175_A314ParHabilitado ;
   private String[] BC00175_A2083ParDescripSinAc ;
   private String[] BC00175_A2274ParenTipo ;
   private int[] BC00175_A3CliCod ;
   private int[] BC00176_A3CliCod ;
   private int[] BC00177_A3CliCod ;
   private String[] BC00177_A30ParCod ;
   private String[] BC00178_A30ParCod ;
   private String[] BC00178_A313ParDescrip ;
   private String[] BC00178_A317ParRes551 ;
   private boolean[] BC00178_A314ParHabilitado ;
   private String[] BC00178_A2083ParDescripSinAc ;
   private String[] BC00178_A2274ParenTipo ;
   private int[] BC00178_A3CliCod ;
   private String[] BC00179_A30ParCod ;
   private String[] BC00179_A313ParDescrip ;
   private String[] BC00179_A317ParRes551 ;
   private boolean[] BC00179_A314ParHabilitado ;
   private String[] BC00179_A2083ParDescripSinAc ;
   private String[] BC00179_A2274ParenTipo ;
   private int[] BC00179_A3CliCod ;
   private int[] BC001713_A3CliCod ;
   private short[] BC001713_A1EmpCod ;
   private int[] BC001713_A6LegNumero ;
   private short[] BC001713_A29LegOrden ;
   private String[] BC001714_A30ParCod ;
   private String[] BC001714_A313ParDescrip ;
   private String[] BC001714_A317ParRes551 ;
   private boolean[] BC001714_A314ParHabilitado ;
   private String[] BC001714_A2083ParDescripSinAc ;
   private String[] BC001714_A2274ParenTipo ;
   private int[] BC001714_A3CliCod ;
   private int[] BC001715_A3CliCod ;
   private int[] BC001716_A3CliCod ;
   private String[] BC00172_A30ParCod ;
   private String[] BC00172_A313ParDescrip ;
   private String[] BC00172_A317ParRes551 ;
   private boolean[] BC00172_A314ParHabilitado ;
   private String[] BC00172_A2083ParDescripSinAc ;
   private String[] BC00172_A2274ParenTipo ;
   private int[] BC00172_A3CliCod ;
   private String[] BC00173_A30ParCod ;
   private String[] BC00173_A313ParDescrip ;
   private String[] BC00173_A317ParRes551 ;
   private boolean[] BC00173_A314ParHabilitado ;
   private String[] BC00173_A2083ParDescripSinAc ;
   private String[] BC00173_A2274ParenTipo ;
   private int[] BC00173_A3CliCod ;
   private int[] BC00174_A3CliCod ;
   private web.wwpbaseobjects.SdtWWPContext AV8WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
}

final  class parentesco_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00172", "SELECT ParCod, ParDescrip, ParRes551, ParHabilitado, ParDescripSinAc, ParenTipo, CliCod FROM Parentesco WHERE CliCod = ? AND ParCod = ?  FOR UPDATE OF Parentesco",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00173", "SELECT ParCod, ParDescrip, ParRes551, ParHabilitado, ParDescripSinAc, ParenTipo, CliCod FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00174", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00175", "SELECT TM1.ParCod, TM1.ParDescrip, TM1.ParRes551, TM1.ParHabilitado, TM1.ParDescripSinAc, TM1.ParenTipo, TM1.CliCod FROM Parentesco TM1 WHERE TM1.CliCod = ? and TM1.ParCod = ( ?) ORDER BY TM1.CliCod, TM1.ParCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00176", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00177", "SELECT CliCod, ParCod FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00178", "SELECT ParCod, ParDescrip, ParRes551, ParHabilitado, ParDescripSinAc, ParenTipo, CliCod FROM Parentesco WHERE CliCod = ? AND ParCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00179", "SELECT ParCod, ParDescrip, ParRes551, ParHabilitado, ParDescripSinAc, ParenTipo, CliCod FROM Parentesco WHERE CliCod = ? AND ParCod = ?  FOR UPDATE OF Parentesco",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001710", "SAVEPOINT gxupdate;INSERT INTO Parentesco(ParCod, ParDescrip, ParRes551, ParHabilitado, ParDescripSinAc, ParenTipo, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001711", "SAVEPOINT gxupdate;UPDATE Parentesco SET ParDescrip=?, ParRes551=?, ParHabilitado=?, ParDescripSinAc=?, ParenTipo=?  WHERE CliCod = ? AND ParCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001712", "SAVEPOINT gxupdate;DELETE FROM Parentesco  WHERE CliCod = ? AND ParCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001713", "SELECT CliCod, EmpCod, LegNumero, LegOrden FROM LegajoFamilia WHERE CliCod = ? AND ParCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC001714", "SELECT TM1.ParCod, TM1.ParDescrip, TM1.ParRes551, TM1.ParHabilitado, TM1.ParDescripSinAc, TM1.ParenTipo, TM1.CliCod FROM Parentesco TM1 WHERE TM1.CliCod = ? and TM1.ParCod = ( ?) ORDER BY TM1.CliCod, TM1.ParCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001715", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001716", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               stmt.setVarchar(3, (String)parms[2], 20, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setVarchar(5, (String)parms[4], 30, false);
               stmt.setString(6, (String)parms[5], 1);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setVarchar(2, (String)parms[1], 20, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 30, false);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

