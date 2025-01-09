package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class escolaridad_bc extends GXWebPanel implements IGxSilentTrn
{
   public escolaridad_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public escolaridad_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( escolaridad_bc.class ));
   }

   public escolaridad_bc( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0G14( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0G14( ) ;
      standaloneModal( ) ;
      addRow0G14( ) ;
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
         e110G2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z49EscCod = A49EscCod ;
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

   public void confirm_0G0( )
   {
      beforeValidate0G14( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0G14( ) ;
         }
         else
         {
            checkExtendedTable0G14( ) ;
            if ( AnyError == 0 )
            {
               zm0G14( 3) ;
            }
            closeExtendedTableCursors0G14( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120G2( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e110G2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0G14( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z186EscDescrip = A186EscDescrip ;
         Z187EscHabilitada = A187EscHabilitada ;
         Z188EscRes551 = A188EscRes551 ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z49EscCod = A49EscCod ;
         Z186EscDescrip = A186EscDescrip ;
         Z187EscHabilitada = A187EscHabilitada ;
         Z188EscRes551 = A188EscRes551 ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (false==A187EscHabilitada) && ( Gx_BScreen == 0 ) )
      {
         A187EscHabilitada = true ;
      }
   }

   public void load0G14( )
   {
      /* Using cursor BC000G5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A49EscCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A186EscDescrip = BC000G5_A186EscDescrip[0] ;
         A187EscHabilitada = BC000G5_A187EscHabilitada[0] ;
         A188EscRes551 = BC000G5_A188EscRes551[0] ;
         zm0G14( -2) ;
      }
      pr_default.close(3);
      onLoadActions0G14( ) ;
   }

   public void onLoadActions0G14( )
   {
   }

   public void checkExtendedTable0G14( )
   {
      nIsDirty_14 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC000G6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
   }

   public void closeExtendedTableCursors0G14( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey0G14( )
   {
      /* Using cursor BC000G7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A49EscCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound14 = (short)(1) ;
      }
      else
      {
         RcdFound14 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000G8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A49EscCod});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0G14( 2) ;
         RcdFound14 = (short)(1) ;
         A49EscCod = BC000G8_A49EscCod[0] ;
         A186EscDescrip = BC000G8_A186EscDescrip[0] ;
         A187EscHabilitada = BC000G8_A187EscHabilitada[0] ;
         A188EscRes551 = BC000G8_A188EscRes551[0] ;
         A3CliCod = BC000G8_A3CliCod[0] ;
         Z3CliCod = A3CliCod ;
         Z49EscCod = A49EscCod ;
         sMode14 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0G14( ) ;
         if ( AnyError == 1 )
         {
            RcdFound14 = (short)(0) ;
            initializeNonKey0G14( ) ;
         }
         Gx_mode = sMode14 ;
      }
      else
      {
         RcdFound14 = (short)(0) ;
         initializeNonKey0G14( ) ;
         sMode14 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode14 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0G14( ) ;
      if ( RcdFound14 == 0 )
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
      confirm_0G0( ) ;
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

   public void checkOptimisticConcurrency0G14( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000G9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A49EscCod});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Escolaridad"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z186EscDescrip, BC000G9_A186EscDescrip[0]) != 0 ) || ( Z187EscHabilitada != BC000G9_A187EscHabilitada[0] ) || ( GXutil.strcmp(Z188EscRes551, BC000G9_A188EscRes551[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Escolaridad"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0G14( )
   {
      beforeValidate0G14( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0G14( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0G14( 0) ;
         checkOptimisticConcurrency0G14( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0G14( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0G14( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000G10 */
                  pr_default.execute(8, new Object[] {A49EscCod, A186EscDescrip, Boolean.valueOf(A187EscHabilitada), A188EscRes551, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Escolaridad");
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
            load0G14( ) ;
         }
         endLevel0G14( ) ;
      }
      closeExtendedTableCursors0G14( ) ;
   }

   public void update0G14( )
   {
      beforeValidate0G14( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0G14( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0G14( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0G14( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0G14( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000G11 */
                  pr_default.execute(9, new Object[] {A186EscDescrip, Boolean.valueOf(A187EscHabilitada), A188EscRes551, Integer.valueOf(A3CliCod), A49EscCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Escolaridad");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Escolaridad"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0G14( ) ;
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
         endLevel0G14( ) ;
      }
      closeExtendedTableCursors0G14( ) ;
   }

   public void deferredUpdate0G14( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0G14( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0G14( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0G14( ) ;
         afterConfirm0G14( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0G14( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000G12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A49EscCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Escolaridad");
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
      sMode14 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0G14( ) ;
      Gx_mode = sMode14 ;
   }

   public void onDeleteControls0G14( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0G14( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0G14( ) ;
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

   public void scanKeyStart0G14( )
   {
      /* Scan By routine */
      /* Using cursor BC000G13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A49EscCod});
      RcdFound14 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A49EscCod = BC000G13_A49EscCod[0] ;
         A186EscDescrip = BC000G13_A186EscDescrip[0] ;
         A187EscHabilitada = BC000G13_A187EscHabilitada[0] ;
         A188EscRes551 = BC000G13_A188EscRes551[0] ;
         A3CliCod = BC000G13_A3CliCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0G14( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound14 = (short)(0) ;
      scanKeyLoad0G14( ) ;
   }

   public void scanKeyLoad0G14( )
   {
      sMode14 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound14 = (short)(1) ;
         A49EscCod = BC000G13_A49EscCod[0] ;
         A186EscDescrip = BC000G13_A186EscDescrip[0] ;
         A187EscHabilitada = BC000G13_A187EscHabilitada[0] ;
         A188EscRes551 = BC000G13_A188EscRes551[0] ;
         A3CliCod = BC000G13_A3CliCod[0] ;
      }
      Gx_mode = sMode14 ;
   }

   public void scanKeyEnd0G14( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0G14( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0G14( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0G14( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0G14( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0G14( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0G14( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0G14( )
   {
   }

   public void send_integrity_lvl_hashes0G14( )
   {
   }

   public void addRow0G14( )
   {
      VarsToRow14( bcEscolaridad) ;
   }

   public void readRow0G14( )
   {
      RowToVars14( bcEscolaridad, 1) ;
   }

   public void initializeNonKey0G14( )
   {
      A186EscDescrip = "" ;
      A188EscRes551 = "" ;
      A187EscHabilitada = true ;
      Z186EscDescrip = "" ;
      Z187EscHabilitada = false ;
      Z188EscRes551 = "" ;
   }

   public void initAll0G14( )
   {
      A3CliCod = 0 ;
      A49EscCod = "" ;
      initializeNonKey0G14( ) ;
   }

   public void standaloneModalInsert( )
   {
      A187EscHabilitada = i187EscHabilitada ;
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

   public void VarsToRow14( web.SdtEscolaridad obj14 )
   {
      obj14.setgxTv_SdtEscolaridad_Mode( Gx_mode );
      obj14.setgxTv_SdtEscolaridad_Escdescrip( A186EscDescrip );
      obj14.setgxTv_SdtEscolaridad_Escres551( A188EscRes551 );
      obj14.setgxTv_SdtEscolaridad_Eschabilitada( A187EscHabilitada );
      obj14.setgxTv_SdtEscolaridad_Clicod( A3CliCod );
      obj14.setgxTv_SdtEscolaridad_Esccod( A49EscCod );
      obj14.setgxTv_SdtEscolaridad_Clicod_Z( Z3CliCod );
      obj14.setgxTv_SdtEscolaridad_Esccod_Z( Z49EscCod );
      obj14.setgxTv_SdtEscolaridad_Escdescrip_Z( Z186EscDescrip );
      obj14.setgxTv_SdtEscolaridad_Eschabilitada_Z( Z187EscHabilitada );
      obj14.setgxTv_SdtEscolaridad_Escres551_Z( Z188EscRes551 );
      obj14.setgxTv_SdtEscolaridad_Mode( Gx_mode );
   }

   public void KeyVarsToRow14( web.SdtEscolaridad obj14 )
   {
      obj14.setgxTv_SdtEscolaridad_Clicod( A3CliCod );
      obj14.setgxTv_SdtEscolaridad_Esccod( A49EscCod );
   }

   public void RowToVars14( web.SdtEscolaridad obj14 ,
                            int forceLoad )
   {
      Gx_mode = obj14.getgxTv_SdtEscolaridad_Mode() ;
      A186EscDescrip = obj14.getgxTv_SdtEscolaridad_Escdescrip() ;
      A188EscRes551 = obj14.getgxTv_SdtEscolaridad_Escres551() ;
      A187EscHabilitada = obj14.getgxTv_SdtEscolaridad_Eschabilitada() ;
      A3CliCod = obj14.getgxTv_SdtEscolaridad_Clicod() ;
      A49EscCod = obj14.getgxTv_SdtEscolaridad_Esccod() ;
      Z3CliCod = obj14.getgxTv_SdtEscolaridad_Clicod_Z() ;
      Z49EscCod = obj14.getgxTv_SdtEscolaridad_Esccod_Z() ;
      Z186EscDescrip = obj14.getgxTv_SdtEscolaridad_Escdescrip_Z() ;
      Z187EscHabilitada = obj14.getgxTv_SdtEscolaridad_Eschabilitada_Z() ;
      Z188EscRes551 = obj14.getgxTv_SdtEscolaridad_Escres551_Z() ;
      Gx_mode = obj14.getgxTv_SdtEscolaridad_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A49EscCod = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0G14( ) ;
      scanKeyStart0G14( ) ;
      if ( RcdFound14 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000G14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod)});
         if ( (pr_default.getStatus(12) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z49EscCod = A49EscCod ;
      }
      zm0G14( -2) ;
      onLoadActions0G14( ) ;
      addRow0G14( ) ;
      scanKeyEnd0G14( ) ;
      if ( RcdFound14 == 0 )
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
      RowToVars14( bcEscolaridad, 0) ;
      scanKeyStart0G14( ) ;
      if ( RcdFound14 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000G15 */
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
         Z49EscCod = A49EscCod ;
      }
      zm0G14( -2) ;
      onLoadActions0G14( ) ;
      addRow0G14( ) ;
      scanKeyEnd0G14( ) ;
      if ( RcdFound14 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0G14( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0G14( ) ;
      }
      else
      {
         if ( RcdFound14 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A49EscCod, Z49EscCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A49EscCod = Z49EscCod ;
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
               update0G14( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A49EscCod, Z49EscCod) != 0 ) )
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
                     insert0G14( ) ;
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
                     insert0G14( ) ;
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
      RowToVars14( bcEscolaridad, 1) ;
      saveImpl( ) ;
      VarsToRow14( bcEscolaridad) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars14( bcEscolaridad, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0G14( ) ;
      afterTrn( ) ;
      VarsToRow14( bcEscolaridad) ;
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
         web.SdtEscolaridad auxBC = new web.SdtEscolaridad( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A49EscCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEscolaridad);
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
      RowToVars14( bcEscolaridad, 1) ;
      updateImpl( ) ;
      VarsToRow14( bcEscolaridad) ;
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
      RowToVars14( bcEscolaridad, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0G14( ) ;
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
      VarsToRow14( bcEscolaridad) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars14( bcEscolaridad, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0G14( ) ;
      if ( RcdFound14 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A49EscCod, Z49EscCod) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A49EscCod = Z49EscCod ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A49EscCod, Z49EscCod) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "escolaridad_bc");
      VarsToRow14( bcEscolaridad) ;
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
      Gx_mode = bcEscolaridad.getgxTv_SdtEscolaridad_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEscolaridad.setgxTv_SdtEscolaridad_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtEscolaridad sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEscolaridad )
      {
         bcEscolaridad = sdt ;
         if ( GXutil.strcmp(bcEscolaridad.getgxTv_SdtEscolaridad_Mode(), "") == 0 )
         {
            bcEscolaridad.setgxTv_SdtEscolaridad_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow14( bcEscolaridad) ;
         }
         else
         {
            RowToVars14( bcEscolaridad, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEscolaridad.getgxTv_SdtEscolaridad_Mode(), "") == 0 )
         {
            bcEscolaridad.setgxTv_SdtEscolaridad_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars14( bcEscolaridad, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEscolaridad getEscolaridad_BC( )
   {
      return bcEscolaridad ;
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
      Z49EscCod = "" ;
      A49EscCod = "" ;
      Z186EscDescrip = "" ;
      A186EscDescrip = "" ;
      Z188EscRes551 = "" ;
      A188EscRes551 = "" ;
      BC000G5_A49EscCod = new String[] {""} ;
      BC000G5_A186EscDescrip = new String[] {""} ;
      BC000G5_A187EscHabilitada = new boolean[] {false} ;
      BC000G5_A188EscRes551 = new String[] {""} ;
      BC000G5_A3CliCod = new int[1] ;
      BC000G6_A3CliCod = new int[1] ;
      BC000G7_A3CliCod = new int[1] ;
      BC000G7_A49EscCod = new String[] {""} ;
      BC000G8_A49EscCod = new String[] {""} ;
      BC000G8_A186EscDescrip = new String[] {""} ;
      BC000G8_A187EscHabilitada = new boolean[] {false} ;
      BC000G8_A188EscRes551 = new String[] {""} ;
      BC000G8_A3CliCod = new int[1] ;
      sMode14 = "" ;
      BC000G9_A49EscCod = new String[] {""} ;
      BC000G9_A186EscDescrip = new String[] {""} ;
      BC000G9_A187EscHabilitada = new boolean[] {false} ;
      BC000G9_A188EscRes551 = new String[] {""} ;
      BC000G9_A3CliCod = new int[1] ;
      BC000G13_A49EscCod = new String[] {""} ;
      BC000G13_A186EscDescrip = new String[] {""} ;
      BC000G13_A187EscHabilitada = new boolean[] {false} ;
      BC000G13_A188EscRes551 = new String[] {""} ;
      BC000G13_A3CliCod = new int[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000G14_A3CliCod = new int[1] ;
      BC000G15_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.escolaridad_bc__default(),
         new Object[] {
             new Object[] {
            BC000G2_A49EscCod, BC000G2_A186EscDescrip, BC000G2_A187EscHabilitada, BC000G2_A188EscRes551, BC000G2_A3CliCod
            }
            , new Object[] {
            BC000G3_A49EscCod, BC000G3_A186EscDescrip, BC000G3_A187EscHabilitada, BC000G3_A188EscRes551, BC000G3_A3CliCod
            }
            , new Object[] {
            BC000G4_A3CliCod
            }
            , new Object[] {
            BC000G5_A49EscCod, BC000G5_A186EscDescrip, BC000G5_A187EscHabilitada, BC000G5_A188EscRes551, BC000G5_A3CliCod
            }
            , new Object[] {
            BC000G6_A3CliCod
            }
            , new Object[] {
            BC000G7_A3CliCod, BC000G7_A49EscCod
            }
            , new Object[] {
            BC000G8_A49EscCod, BC000G8_A186EscDescrip, BC000G8_A187EscHabilitada, BC000G8_A188EscRes551, BC000G8_A3CliCod
            }
            , new Object[] {
            BC000G9_A49EscCod, BC000G9_A186EscDescrip, BC000G9_A187EscHabilitada, BC000G9_A188EscRes551, BC000G9_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000G13_A49EscCod, BC000G13_A186EscDescrip, BC000G13_A187EscHabilitada, BC000G13_A188EscRes551, BC000G13_A3CliCod
            }
            , new Object[] {
            BC000G14_A3CliCod
            }
            , new Object[] {
            BC000G15_A3CliCod
            }
         }
      );
      Z187EscHabilitada = true ;
      A187EscHabilitada = true ;
      i187EscHabilitada = true ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120G2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound14 ;
   private short nIsDirty_14 ;
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
   private String Z49EscCod ;
   private String A49EscCod ;
   private String sMode14 ;
   private boolean returnInSub ;
   private boolean Z187EscHabilitada ;
   private boolean A187EscHabilitada ;
   private boolean i187EscHabilitada ;
   private boolean mustCommit ;
   private String Z186EscDescrip ;
   private String A186EscDescrip ;
   private String Z188EscRes551 ;
   private String A188EscRes551 ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.SdtEscolaridad bcEscolaridad ;
   private IDataStoreProvider pr_default ;
   private String[] BC000G5_A49EscCod ;
   private String[] BC000G5_A186EscDescrip ;
   private boolean[] BC000G5_A187EscHabilitada ;
   private String[] BC000G5_A188EscRes551 ;
   private int[] BC000G5_A3CliCod ;
   private int[] BC000G6_A3CliCod ;
   private int[] BC000G7_A3CliCod ;
   private String[] BC000G7_A49EscCod ;
   private String[] BC000G8_A49EscCod ;
   private String[] BC000G8_A186EscDescrip ;
   private boolean[] BC000G8_A187EscHabilitada ;
   private String[] BC000G8_A188EscRes551 ;
   private int[] BC000G8_A3CliCod ;
   private String[] BC000G9_A49EscCod ;
   private String[] BC000G9_A186EscDescrip ;
   private boolean[] BC000G9_A187EscHabilitada ;
   private String[] BC000G9_A188EscRes551 ;
   private int[] BC000G9_A3CliCod ;
   private String[] BC000G13_A49EscCod ;
   private String[] BC000G13_A186EscDescrip ;
   private boolean[] BC000G13_A187EscHabilitada ;
   private String[] BC000G13_A188EscRes551 ;
   private int[] BC000G13_A3CliCod ;
   private int[] BC000G14_A3CliCod ;
   private int[] BC000G15_A3CliCod ;
   private String[] BC000G2_A49EscCod ;
   private String[] BC000G2_A186EscDescrip ;
   private boolean[] BC000G2_A187EscHabilitada ;
   private String[] BC000G2_A188EscRes551 ;
   private int[] BC000G2_A3CliCod ;
   private String[] BC000G3_A49EscCod ;
   private String[] BC000G3_A186EscDescrip ;
   private boolean[] BC000G3_A187EscHabilitada ;
   private String[] BC000G3_A188EscRes551 ;
   private int[] BC000G3_A3CliCod ;
   private int[] BC000G4_A3CliCod ;
}

final  class escolaridad_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000G2", "SELECT EscCod, EscDescrip, EscHabilitada, EscRes551, CliCod FROM Escolaridad WHERE CliCod = ? AND EscCod = ?  FOR UPDATE OF Escolaridad",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G3", "SELECT EscCod, EscDescrip, EscHabilitada, EscRes551, CliCod FROM Escolaridad WHERE CliCod = ? AND EscCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G4", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G5", "SELECT TM1.EscCod, TM1.EscDescrip, TM1.EscHabilitada, TM1.EscRes551, TM1.CliCod FROM Escolaridad TM1 WHERE TM1.CliCod = ? and TM1.EscCod = ( ?) ORDER BY TM1.CliCod, TM1.EscCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G7", "SELECT CliCod, EscCod FROM Escolaridad WHERE CliCod = ? AND EscCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G8", "SELECT EscCod, EscDescrip, EscHabilitada, EscRes551, CliCod FROM Escolaridad WHERE CliCod = ? AND EscCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G9", "SELECT EscCod, EscDescrip, EscHabilitada, EscRes551, CliCod FROM Escolaridad WHERE CliCod = ? AND EscCod = ?  FOR UPDATE OF Escolaridad",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000G10", "SAVEPOINT gxupdate;INSERT INTO Escolaridad(EscCod, EscDescrip, EscHabilitada, EscRes551, CliCod) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000G11", "SAVEPOINT gxupdate;UPDATE Escolaridad SET EscDescrip=?, EscHabilitada=?, EscRes551=?  WHERE CliCod = ? AND EscCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000G12", "SAVEPOINT gxupdate;DELETE FROM Escolaridad  WHERE CliCod = ? AND EscCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000G13", "SELECT TM1.EscCod, TM1.EscDescrip, TM1.EscHabilitada, TM1.EscRes551, TM1.CliCod FROM Escolaridad TM1 WHERE TM1.CliCod = ? and TM1.EscCod = ( ?) ORDER BY TM1.CliCod, TM1.EscCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G14", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000G15", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 13 :
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
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setVarchar(4, (String)parms[3], 20, false);
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 30, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               stmt.setVarchar(3, (String)parms[2], 20, false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
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
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

