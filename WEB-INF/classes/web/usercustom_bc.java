package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class usercustom_bc extends GXWebPanel implements IGxSilentTrn
{
   public usercustom_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public usercustom_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( usercustom_bc.class ));
   }

   public usercustom_bc( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow2E82( ) ;
      standaloneNotModal( ) ;
      initializeNonKey2E82( ) ;
      standaloneModal( ) ;
      addRow2E82( ) ;
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
            Z770UserId = A770UserId ;
            Z771UserCustomKey = A771UserCustomKey ;
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

   public void confirm_2E0( )
   {
      beforeValidate2E82( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2E82( ) ;
         }
         else
         {
            checkExtendedTable2E82( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors2E82( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm2E82( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -1 )
      {
         Z770UserId = A770UserId ;
         Z771UserCustomKey = A771UserCustomKey ;
         Z772UserCustomValue = A772UserCustomValue ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load2E82( )
   {
      /* Using cursor BC002E4 */
      pr_default.execute(2, new Object[] {A770UserId, A771UserCustomKey});
      if ( (pr_default.getStatus(2) != 101) )
      {
         RcdFound82 = (short)(1) ;
         A772UserCustomValue = BC002E4_A772UserCustomValue[0] ;
         zm2E82( -1) ;
      }
      pr_default.close(2);
      onLoadActions2E82( ) ;
   }

   public void onLoadActions2E82( )
   {
   }

   public void checkExtendedTable2E82( )
   {
      nIsDirty_82 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors2E82( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey2E82( )
   {
      /* Using cursor BC002E5 */
      pr_default.execute(3, new Object[] {A770UserId, A771UserCustomKey});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound82 = (short)(1) ;
      }
      else
      {
         RcdFound82 = (short)(0) ;
      }
      pr_default.close(3);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC002E6 */
      pr_default.execute(4, new Object[] {A770UserId, A771UserCustomKey});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm2E82( 1) ;
         RcdFound82 = (short)(1) ;
         A770UserId = BC002E6_A770UserId[0] ;
         A771UserCustomKey = BC002E6_A771UserCustomKey[0] ;
         A772UserCustomValue = BC002E6_A772UserCustomValue[0] ;
         Z770UserId = A770UserId ;
         Z771UserCustomKey = A771UserCustomKey ;
         sMode82 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load2E82( ) ;
         if ( AnyError == 1 )
         {
            RcdFound82 = (short)(0) ;
            initializeNonKey2E82( ) ;
         }
         Gx_mode = sMode82 ;
      }
      else
      {
         RcdFound82 = (short)(0) ;
         initializeNonKey2E82( ) ;
         sMode82 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode82 ;
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey2E82( ) ;
      if ( RcdFound82 == 0 )
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
      confirm_2E0( ) ;
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

   public void checkOptimisticConcurrency2E82( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002E7 */
         pr_default.execute(5, new Object[] {A770UserId, A771UserCustomKey});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"UserCustom"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(5) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"UserCustom"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2E82( )
   {
      beforeValidate2E82( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2E82( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2E82( 0) ;
         checkOptimisticConcurrency2E82( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2E82( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2E82( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002E8 */
                  pr_default.execute(6, new Object[] {A770UserId, A771UserCustomKey, A772UserCustomValue});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustom");
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
            load2E82( ) ;
         }
         endLevel2E82( ) ;
      }
      closeExtendedTableCursors2E82( ) ;
   }

   public void update2E82( )
   {
      beforeValidate2E82( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2E82( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2E82( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2E82( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2E82( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002E9 */
                  pr_default.execute(7, new Object[] {A772UserCustomValue, A770UserId, A771UserCustomKey});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustom");
                  if ( (pr_default.getStatus(7) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"UserCustom"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2E82( ) ;
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
         endLevel2E82( ) ;
      }
      closeExtendedTableCursors2E82( ) ;
   }

   public void deferredUpdate2E82( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2E82( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2E82( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2E82( ) ;
         afterConfirm2E82( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2E82( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002E10 */
               pr_default.execute(8, new Object[] {A770UserId, A771UserCustomKey});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("UserCustom");
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
      sMode82 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2E82( ) ;
      Gx_mode = sMode82 ;
   }

   public void onDeleteControls2E82( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2E82( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2E82( ) ;
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

   public void scanKeyStart2E82( )
   {
      /* Using cursor BC002E11 */
      pr_default.execute(9, new Object[] {A770UserId, A771UserCustomKey});
      RcdFound82 = (short)(0) ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound82 = (short)(1) ;
         A770UserId = BC002E11_A770UserId[0] ;
         A771UserCustomKey = BC002E11_A771UserCustomKey[0] ;
         A772UserCustomValue = BC002E11_A772UserCustomValue[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2E82( )
   {
      /* Scan next routine */
      pr_default.readNext(9);
      RcdFound82 = (short)(0) ;
      scanKeyLoad2E82( ) ;
   }

   public void scanKeyLoad2E82( )
   {
      sMode82 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound82 = (short)(1) ;
         A770UserId = BC002E11_A770UserId[0] ;
         A771UserCustomKey = BC002E11_A771UserCustomKey[0] ;
         A772UserCustomValue = BC002E11_A772UserCustomValue[0] ;
      }
      Gx_mode = sMode82 ;
   }

   public void scanKeyEnd2E82( )
   {
      pr_default.close(9);
   }

   public void afterConfirm2E82( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2E82( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2E82( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2E82( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2E82( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2E82( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2E82( )
   {
   }

   public void send_integrity_lvl_hashes2E82( )
   {
   }

   public void addRow2E82( )
   {
      VarsToRow82( bcUserCustom) ;
   }

   public void readRow2E82( )
   {
      RowToVars82( bcUserCustom, 1) ;
   }

   public void initializeNonKey2E82( )
   {
      A772UserCustomValue = "" ;
   }

   public void initAll2E82( )
   {
      A770UserId = "" ;
      A771UserCustomKey = "" ;
      initializeNonKey2E82( ) ;
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

   public void VarsToRow82( web.SdtUserCustom obj82 )
   {
      obj82.setgxTv_SdtUserCustom_Mode( Gx_mode );
      obj82.setgxTv_SdtUserCustom_Usercustomvalue( A772UserCustomValue );
      obj82.setgxTv_SdtUserCustom_Userid( A770UserId );
      obj82.setgxTv_SdtUserCustom_Usercustomkey( A771UserCustomKey );
      obj82.setgxTv_SdtUserCustom_Userid_Z( Z770UserId );
      obj82.setgxTv_SdtUserCustom_Usercustomkey_Z( Z771UserCustomKey );
      obj82.setgxTv_SdtUserCustom_Mode( Gx_mode );
   }

   public void KeyVarsToRow82( web.SdtUserCustom obj82 )
   {
      obj82.setgxTv_SdtUserCustom_Userid( A770UserId );
      obj82.setgxTv_SdtUserCustom_Usercustomkey( A771UserCustomKey );
   }

   public void RowToVars82( web.SdtUserCustom obj82 ,
                            int forceLoad )
   {
      Gx_mode = obj82.getgxTv_SdtUserCustom_Mode() ;
      A772UserCustomValue = obj82.getgxTv_SdtUserCustom_Usercustomvalue() ;
      A770UserId = obj82.getgxTv_SdtUserCustom_Userid() ;
      A771UserCustomKey = obj82.getgxTv_SdtUserCustom_Usercustomkey() ;
      Z770UserId = obj82.getgxTv_SdtUserCustom_Userid_Z() ;
      Z771UserCustomKey = obj82.getgxTv_SdtUserCustom_Usercustomkey_Z() ;
      Gx_mode = obj82.getgxTv_SdtUserCustom_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A770UserId = (String)getParm(obj,0) ;
      A771UserCustomKey = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey2E82( ) ;
      scanKeyStart2E82( ) ;
      if ( RcdFound82 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z770UserId = A770UserId ;
         Z771UserCustomKey = A771UserCustomKey ;
      }
      zm2E82( -1) ;
      onLoadActions2E82( ) ;
      addRow2E82( ) ;
      scanKeyEnd2E82( ) ;
      if ( RcdFound82 == 0 )
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
      RowToVars82( bcUserCustom, 0) ;
      scanKeyStart2E82( ) ;
      if ( RcdFound82 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z770UserId = A770UserId ;
         Z771UserCustomKey = A771UserCustomKey ;
      }
      zm2E82( -1) ;
      onLoadActions2E82( ) ;
      addRow2E82( ) ;
      scanKeyEnd2E82( ) ;
      if ( RcdFound82 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2E82( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert2E82( ) ;
      }
      else
      {
         if ( RcdFound82 == 1 )
         {
            if ( ( GXutil.strcmp(A770UserId, Z770UserId) != 0 ) || ( GXutil.strcmp(A771UserCustomKey, Z771UserCustomKey) != 0 ) )
            {
               A770UserId = Z770UserId ;
               A771UserCustomKey = Z771UserCustomKey ;
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
               update2E82( ) ;
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
               if ( ( GXutil.strcmp(A770UserId, Z770UserId) != 0 ) || ( GXutil.strcmp(A771UserCustomKey, Z771UserCustomKey) != 0 ) )
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
                     insert2E82( ) ;
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
                     insert2E82( ) ;
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
      RowToVars82( bcUserCustom, 1) ;
      saveImpl( ) ;
      VarsToRow82( bcUserCustom) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars82( bcUserCustom, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2E82( ) ;
      afterTrn( ) ;
      VarsToRow82( bcUserCustom) ;
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
         web.SdtUserCustom auxBC = new web.SdtUserCustom( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A770UserId, A771UserCustomKey);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcUserCustom);
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
      RowToVars82( bcUserCustom, 1) ;
      updateImpl( ) ;
      VarsToRow82( bcUserCustom) ;
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
      RowToVars82( bcUserCustom, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2E82( ) ;
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
      VarsToRow82( bcUserCustom) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars82( bcUserCustom, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey2E82( ) ;
      if ( RcdFound82 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( GXutil.strcmp(A770UserId, Z770UserId) != 0 ) || ( GXutil.strcmp(A771UserCustomKey, Z771UserCustomKey) != 0 ) )
         {
            A770UserId = Z770UserId ;
            A771UserCustomKey = Z771UserCustomKey ;
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
         if ( ( GXutil.strcmp(A770UserId, Z770UserId) != 0 ) || ( GXutil.strcmp(A771UserCustomKey, Z771UserCustomKey) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "usercustom_bc");
      VarsToRow82( bcUserCustom) ;
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
      Gx_mode = bcUserCustom.getgxTv_SdtUserCustom_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcUserCustom.setgxTv_SdtUserCustom_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtUserCustom sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcUserCustom )
      {
         bcUserCustom = sdt ;
         if ( GXutil.strcmp(bcUserCustom.getgxTv_SdtUserCustom_Mode(), "") == 0 )
         {
            bcUserCustom.setgxTv_SdtUserCustom_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow82( bcUserCustom) ;
         }
         else
         {
            RowToVars82( bcUserCustom, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcUserCustom.getgxTv_SdtUserCustom_Mode(), "") == 0 )
         {
            bcUserCustom.setgxTv_SdtUserCustom_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars82( bcUserCustom, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtUserCustom getUserCustom_BC( )
   {
      return bcUserCustom ;
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
      Z770UserId = "" ;
      A770UserId = "" ;
      Z771UserCustomKey = "" ;
      A771UserCustomKey = "" ;
      Z772UserCustomValue = "" ;
      A772UserCustomValue = "" ;
      BC002E4_A770UserId = new String[] {""} ;
      BC002E4_A771UserCustomKey = new String[] {""} ;
      BC002E4_A772UserCustomValue = new String[] {""} ;
      BC002E5_A770UserId = new String[] {""} ;
      BC002E5_A771UserCustomKey = new String[] {""} ;
      BC002E6_A770UserId = new String[] {""} ;
      BC002E6_A771UserCustomKey = new String[] {""} ;
      BC002E6_A772UserCustomValue = new String[] {""} ;
      sMode82 = "" ;
      BC002E7_A770UserId = new String[] {""} ;
      BC002E7_A771UserCustomKey = new String[] {""} ;
      BC002E7_A772UserCustomValue = new String[] {""} ;
      BC002E11_A770UserId = new String[] {""} ;
      BC002E11_A771UserCustomKey = new String[] {""} ;
      BC002E11_A772UserCustomValue = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.usercustom_bc__default(),
         new Object[] {
             new Object[] {
            BC002E2_A770UserId, BC002E2_A771UserCustomKey, BC002E2_A772UserCustomValue
            }
            , new Object[] {
            BC002E3_A770UserId, BC002E3_A771UserCustomKey, BC002E3_A772UserCustomValue
            }
            , new Object[] {
            BC002E4_A770UserId, BC002E4_A771UserCustomKey, BC002E4_A772UserCustomValue
            }
            , new Object[] {
            BC002E5_A770UserId, BC002E5_A771UserCustomKey
            }
            , new Object[] {
            BC002E6_A770UserId, BC002E6_A771UserCustomKey, BC002E6_A772UserCustomValue
            }
            , new Object[] {
            BC002E7_A770UserId, BC002E7_A771UserCustomKey, BC002E7_A772UserCustomValue
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002E11_A770UserId, BC002E11_A771UserCustomKey, BC002E11_A772UserCustomValue
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
   private short RcdFound82 ;
   private short nIsDirty_82 ;
   private int trnEnded ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode82 ;
   private boolean mustCommit ;
   private String Z772UserCustomValue ;
   private String A772UserCustomValue ;
   private String Z770UserId ;
   private String A770UserId ;
   private String Z771UserCustomKey ;
   private String A771UserCustomKey ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.SdtUserCustom bcUserCustom ;
   private IDataStoreProvider pr_default ;
   private String[] BC002E4_A770UserId ;
   private String[] BC002E4_A771UserCustomKey ;
   private String[] BC002E4_A772UserCustomValue ;
   private String[] BC002E5_A770UserId ;
   private String[] BC002E5_A771UserCustomKey ;
   private String[] BC002E6_A770UserId ;
   private String[] BC002E6_A771UserCustomKey ;
   private String[] BC002E6_A772UserCustomValue ;
   private String[] BC002E7_A770UserId ;
   private String[] BC002E7_A771UserCustomKey ;
   private String[] BC002E7_A772UserCustomValue ;
   private String[] BC002E11_A770UserId ;
   private String[] BC002E11_A771UserCustomKey ;
   private String[] BC002E11_A772UserCustomValue ;
   private String[] BC002E2_A770UserId ;
   private String[] BC002E2_A771UserCustomKey ;
   private String[] BC002E2_A772UserCustomValue ;
   private String[] BC002E3_A770UserId ;
   private String[] BC002E3_A771UserCustomKey ;
   private String[] BC002E3_A772UserCustomValue ;
}

final  class usercustom_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC002E2", "SELECT UserId, UserCustomKey, UserCustomValue FROM UserCustom WHERE UserId = ? AND UserCustomKey = ?  FOR UPDATE OF UserCustom",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002E3", "SELECT UserId, UserCustomKey, UserCustomValue FROM UserCustom WHERE UserId = ? AND UserCustomKey = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002E4", "SELECT TM1.UserId, TM1.UserCustomKey, TM1.UserCustomValue FROM UserCustom TM1 WHERE TM1.UserId = ( ?) and TM1.UserCustomKey = ( ?) ORDER BY TM1.UserId, TM1.UserCustomKey ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002E5", "SELECT UserId, UserCustomKey FROM UserCustom WHERE UserId = ? AND UserCustomKey = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002E6", "SELECT UserId, UserCustomKey, UserCustomValue FROM UserCustom WHERE UserId = ? AND UserCustomKey = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002E7", "SELECT UserId, UserCustomKey, UserCustomValue FROM UserCustom WHERE UserId = ? AND UserCustomKey = ?  FOR UPDATE OF UserCustom",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002E8", "SAVEPOINT gxupdate;INSERT INTO UserCustom(UserId, UserCustomKey, UserCustomValue) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002E9", "SAVEPOINT gxupdate;UPDATE UserCustom SET UserCustomValue=?  WHERE UserId = ? AND UserCustomKey = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002E10", "SAVEPOINT gxupdate;DELETE FROM UserCustom  WHERE UserId = ? AND UserCustomKey = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002E11", "SELECT TM1.UserId, TM1.UserCustomKey, TM1.UserCustomValue FROM UserCustom TM1 WHERE TM1.UserId = ( ?) and TM1.UserCustomKey = ( ?) ORDER BY TM1.UserId, TM1.UserCustomKey ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               return;
            case 9 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
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
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
            case 4 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
            case 5 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
            case 6 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               return;
            case 7 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setVarchar(3, (String)parms[2], 120, false);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 100, false);
               stmt.setVarchar(2, (String)parms[1], 120, false);
               return;
      }
   }

}

