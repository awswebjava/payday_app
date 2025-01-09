package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class secfunctionalityrole_bc extends GXWebPanel implements IGxSilentTrn
{
   public secfunctionalityrole_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public secfunctionalityrole_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secfunctionalityrole_bc.class ));
   }

   public secfunctionalityrole_bc( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow1J51( ) ;
      standaloneNotModal( ) ;
      initializeNonKey1J51( ) ;
      standaloneModal( ) ;
      addRow1J51( ) ;
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
            Z62SecFunctionalityId = A62SecFunctionalityId ;
            Z65SecRoleId = A65SecRoleId ;
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

   public void confirm_1J0( )
   {
      beforeValidate1J51( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1J51( ) ;
         }
         else
         {
            checkExtendedTable1J51( ) ;
            if ( AnyError == 0 )
            {
               zm1J51( 2) ;
               zm1J51( 3) ;
            }
            closeExtendedTableCursors1J51( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void zm1J51( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z350SecFunctionalityDescription = A350SecFunctionalityDescription ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -1 )
      {
         Z62SecFunctionalityId = A62SecFunctionalityId ;
         Z65SecRoleId = A65SecRoleId ;
         Z350SecFunctionalityDescription = A350SecFunctionalityDescription ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load1J51( )
   {
      /* Using cursor BC001J6 */
      pr_default.execute(4, new Object[] {Long.valueOf(A62SecFunctionalityId), Short.valueOf(A65SecRoleId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A350SecFunctionalityDescription = BC001J6_A350SecFunctionalityDescription[0] ;
         zm1J51( -1) ;
      }
      pr_default.close(4);
      onLoadActions1J51( ) ;
   }

   public void onLoadActions1J51( )
   {
   }

   public void checkExtendedTable1J51( )
   {
      nIsDirty_51 = (short)(0) ;
      standaloneModal( ) ;
      /* Using cursor BC001J7 */
      pr_default.execute(5, new Object[] {Long.valueOf(A62SecFunctionalityId)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Functionality", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECFUNCTIONALITYID");
         AnyError = (short)(1) ;
      }
      A350SecFunctionalityDescription = BC001J7_A350SecFunctionalityDescription[0] ;
      pr_default.close(5);
      /* Using cursor BC001J8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A65SecRoleId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Role", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECROLEID");
         AnyError = (short)(1) ;
      }
      pr_default.close(6);
   }

   public void closeExtendedTableCursors1J51( )
   {
      pr_default.close(5);
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void getKey1J51( )
   {
      /* Using cursor BC001J9 */
      pr_default.execute(7, new Object[] {Long.valueOf(A62SecFunctionalityId), Short.valueOf(A65SecRoleId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound51 = (short)(1) ;
      }
      else
      {
         RcdFound51 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC001J10 */
      pr_default.execute(8, new Object[] {Long.valueOf(A62SecFunctionalityId), Short.valueOf(A65SecRoleId)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm1J51( 1) ;
         RcdFound51 = (short)(1) ;
         A62SecFunctionalityId = BC001J10_A62SecFunctionalityId[0] ;
         A65SecRoleId = BC001J10_A65SecRoleId[0] ;
         Z62SecFunctionalityId = A62SecFunctionalityId ;
         Z65SecRoleId = A65SecRoleId ;
         sMode51 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load1J51( ) ;
         if ( AnyError == 1 )
         {
            RcdFound51 = (short)(0) ;
            initializeNonKey1J51( ) ;
         }
         Gx_mode = sMode51 ;
      }
      else
      {
         RcdFound51 = (short)(0) ;
         initializeNonKey1J51( ) ;
         sMode51 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode51 ;
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey1J51( ) ;
      if ( RcdFound51 == 0 )
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
      confirm_1J0( ) ;
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

   public void checkOptimisticConcurrency1J51( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC001J11 */
         pr_default.execute(9, new Object[] {Long.valueOf(A62SecFunctionalityId), Short.valueOf(A65SecRoleId)});
         if ( (pr_default.getStatus(9) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"SecFunctionalityRole"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(9) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"SecFunctionalityRole"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1J51( )
   {
      beforeValidate1J51( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1J51( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1J51( 0) ;
         checkOptimisticConcurrency1J51( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1J51( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1J51( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC001J12 */
                  pr_default.execute(10, new Object[] {Long.valueOf(A62SecFunctionalityId), Short.valueOf(A65SecRoleId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionalityRole");
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
            load1J51( ) ;
         }
         endLevel1J51( ) ;
      }
      closeExtendedTableCursors1J51( ) ;
   }

   public void update1J51( )
   {
      beforeValidate1J51( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1J51( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1J51( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1J51( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1J51( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table SecFunctionalityRole */
                  deferredUpdate1J51( ) ;
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
         endLevel1J51( ) ;
      }
      closeExtendedTableCursors1J51( ) ;
   }

   public void deferredUpdate1J51( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate1J51( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1J51( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1J51( ) ;
         afterConfirm1J51( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1J51( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC001J13 */
               pr_default.execute(11, new Object[] {Long.valueOf(A62SecFunctionalityId), Short.valueOf(A65SecRoleId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("SecFunctionalityRole");
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
      sMode51 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel1J51( ) ;
      Gx_mode = sMode51 ;
   }

   public void onDeleteControls1J51( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC001J14 */
         pr_default.execute(12, new Object[] {Long.valueOf(A62SecFunctionalityId)});
         A350SecFunctionalityDescription = BC001J14_A350SecFunctionalityDescription[0] ;
         pr_default.close(12);
      }
   }

   public void endLevel1J51( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(9);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1J51( ) ;
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

   public void scanKeyStart1J51( )
   {
      /* Scan By routine */
      /* Using cursor BC001J15 */
      pr_default.execute(13, new Object[] {Long.valueOf(A62SecFunctionalityId), Short.valueOf(A65SecRoleId)});
      RcdFound51 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A350SecFunctionalityDescription = BC001J15_A350SecFunctionalityDescription[0] ;
         A62SecFunctionalityId = BC001J15_A62SecFunctionalityId[0] ;
         A65SecRoleId = BC001J15_A65SecRoleId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext1J51( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound51 = (short)(0) ;
      scanKeyLoad1J51( ) ;
   }

   public void scanKeyLoad1J51( )
   {
      sMode51 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound51 = (short)(1) ;
         A350SecFunctionalityDescription = BC001J15_A350SecFunctionalityDescription[0] ;
         A62SecFunctionalityId = BC001J15_A62SecFunctionalityId[0] ;
         A65SecRoleId = BC001J15_A65SecRoleId[0] ;
      }
      Gx_mode = sMode51 ;
   }

   public void scanKeyEnd1J51( )
   {
      pr_default.close(13);
   }

   public void afterConfirm1J51( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1J51( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1J51( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1J51( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1J51( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1J51( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1J51( )
   {
   }

   public void send_integrity_lvl_hashes1J51( )
   {
   }

   public void addRow1J51( )
   {
      VarsToRow51( bcwwpbaseobjects_SecFunctionalityRole) ;
   }

   public void readRow1J51( )
   {
      RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
   }

   public void initializeNonKey1J51( )
   {
      A350SecFunctionalityDescription = "" ;
   }

   public void initAll1J51( )
   {
      A62SecFunctionalityId = 0 ;
      A65SecRoleId = (short)(0) ;
      initializeNonKey1J51( ) ;
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

   public void VarsToRow51( web.wwpbaseobjects.SdtSecFunctionalityRole obj51 )
   {
      obj51.setgxTv_SdtSecFunctionalityRole_Mode( Gx_mode );
      obj51.setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription( A350SecFunctionalityDescription );
      obj51.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid( A62SecFunctionalityId );
      obj51.setgxTv_SdtSecFunctionalityRole_Secroleid( A65SecRoleId );
      obj51.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z( Z62SecFunctionalityId );
      obj51.setgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z( Z350SecFunctionalityDescription );
      obj51.setgxTv_SdtSecFunctionalityRole_Secroleid_Z( Z65SecRoleId );
      obj51.setgxTv_SdtSecFunctionalityRole_Mode( Gx_mode );
   }

   public void KeyVarsToRow51( web.wwpbaseobjects.SdtSecFunctionalityRole obj51 )
   {
      obj51.setgxTv_SdtSecFunctionalityRole_Secfunctionalityid( A62SecFunctionalityId );
      obj51.setgxTv_SdtSecFunctionalityRole_Secroleid( A65SecRoleId );
   }

   public void RowToVars51( web.wwpbaseobjects.SdtSecFunctionalityRole obj51 ,
                            int forceLoad )
   {
      Gx_mode = obj51.getgxTv_SdtSecFunctionalityRole_Mode() ;
      A350SecFunctionalityDescription = obj51.getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription() ;
      A62SecFunctionalityId = obj51.getgxTv_SdtSecFunctionalityRole_Secfunctionalityid() ;
      A65SecRoleId = obj51.getgxTv_SdtSecFunctionalityRole_Secroleid() ;
      Z62SecFunctionalityId = obj51.getgxTv_SdtSecFunctionalityRole_Secfunctionalityid_Z() ;
      Z350SecFunctionalityDescription = obj51.getgxTv_SdtSecFunctionalityRole_Secfunctionalitydescription_Z() ;
      Z65SecRoleId = obj51.getgxTv_SdtSecFunctionalityRole_Secroleid_Z() ;
      Gx_mode = obj51.getgxTv_SdtSecFunctionalityRole_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A62SecFunctionalityId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.LONG)).longValue() ;
      A65SecRoleId = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey1J51( ) ;
      scanKeyStart1J51( ) ;
      if ( RcdFound51 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001J16 */
         pr_default.execute(14, new Object[] {Long.valueOf(A62SecFunctionalityId)});
         if ( (pr_default.getStatus(14) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Functionality", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECFUNCTIONALITYID");
            AnyError = (short)(1) ;
         }
         A350SecFunctionalityDescription = BC001J16_A350SecFunctionalityDescription[0] ;
         pr_default.close(14);
         /* Using cursor BC001J17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A65SecRoleId)});
         if ( (pr_default.getStatus(15) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Role", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECROLEID");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z62SecFunctionalityId = A62SecFunctionalityId ;
         Z65SecRoleId = A65SecRoleId ;
      }
      zm1J51( -1) ;
      onLoadActions1J51( ) ;
      addRow1J51( ) ;
      scanKeyEnd1J51( ) ;
      if ( RcdFound51 == 0 )
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
      RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 0) ;
      scanKeyStart1J51( ) ;
      if ( RcdFound51 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC001J18 */
         pr_default.execute(16, new Object[] {Long.valueOf(A62SecFunctionalityId)});
         if ( (pr_default.getStatus(16) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Functionality", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECFUNCTIONALITYID");
            AnyError = (short)(1) ;
         }
         A350SecFunctionalityDescription = BC001J18_A350SecFunctionalityDescription[0] ;
         pr_default.close(16);
         /* Using cursor BC001J19 */
         pr_default.execute(17, new Object[] {Short.valueOf(A65SecRoleId)});
         if ( (pr_default.getStatus(17) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Role", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "SECROLEID");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z62SecFunctionalityId = A62SecFunctionalityId ;
         Z65SecRoleId = A65SecRoleId ;
      }
      zm1J51( -1) ;
      onLoadActions1J51( ) ;
      addRow1J51( ) ;
      scanKeyEnd1J51( ) ;
      if ( RcdFound51 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1J51( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert1J51( ) ;
      }
      else
      {
         if ( RcdFound51 == 1 )
         {
            if ( ( A62SecFunctionalityId != Z62SecFunctionalityId ) || ( A65SecRoleId != Z65SecRoleId ) )
            {
               A62SecFunctionalityId = Z62SecFunctionalityId ;
               A65SecRoleId = Z65SecRoleId ;
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
               update1J51( ) ;
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
               if ( ( A62SecFunctionalityId != Z62SecFunctionalityId ) || ( A65SecRoleId != Z65SecRoleId ) )
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
                     insert1J51( ) ;
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
                     insert1J51( ) ;
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
      RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
      saveImpl( ) ;
      VarsToRow51( bcwwpbaseobjects_SecFunctionalityRole) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1J51( ) ;
      afterTrn( ) ;
      VarsToRow51( bcwwpbaseobjects_SecFunctionalityRole) ;
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
         web.wwpbaseobjects.SdtSecFunctionalityRole auxBC = new web.wwpbaseobjects.SdtSecFunctionalityRole( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A62SecFunctionalityId, A65SecRoleId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcwwpbaseobjects_SecFunctionalityRole);
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
      RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
      updateImpl( ) ;
      VarsToRow51( bcwwpbaseobjects_SecFunctionalityRole) ;
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
      RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert1J51( ) ;
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
      VarsToRow51( bcwwpbaseobjects_SecFunctionalityRole) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey1J51( ) ;
      if ( RcdFound51 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A62SecFunctionalityId != Z62SecFunctionalityId ) || ( A65SecRoleId != Z65SecRoleId ) )
         {
            A62SecFunctionalityId = Z62SecFunctionalityId ;
            A65SecRoleId = Z65SecRoleId ;
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
         if ( ( A62SecFunctionalityId != Z62SecFunctionalityId ) || ( A65SecRoleId != Z65SecRoleId ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.secfunctionalityrole_bc");
      VarsToRow51( bcwwpbaseobjects_SecFunctionalityRole) ;
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
      Gx_mode = bcwwpbaseobjects_SecFunctionalityRole.getgxTv_SdtSecFunctionalityRole_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcwwpbaseobjects_SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Mode( Gx_mode );
   }

   public void SetSDT( web.wwpbaseobjects.SdtSecFunctionalityRole sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcwwpbaseobjects_SecFunctionalityRole )
      {
         bcwwpbaseobjects_SecFunctionalityRole = sdt ;
         if ( GXutil.strcmp(bcwwpbaseobjects_SecFunctionalityRole.getgxTv_SdtSecFunctionalityRole_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow51( bcwwpbaseobjects_SecFunctionalityRole) ;
         }
         else
         {
            RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcwwpbaseobjects_SecFunctionalityRole.getgxTv_SdtSecFunctionalityRole_Mode(), "") == 0 )
         {
            bcwwpbaseobjects_SecFunctionalityRole.setgxTv_SdtSecFunctionalityRole_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars51( bcwwpbaseobjects_SecFunctionalityRole, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtSecFunctionalityRole getSecFunctionalityRole_BC( )
   {
      return bcwwpbaseobjects_SecFunctionalityRole ;
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
      Z350SecFunctionalityDescription = "" ;
      A350SecFunctionalityDescription = "" ;
      BC001J6_A350SecFunctionalityDescription = new String[] {""} ;
      BC001J6_A62SecFunctionalityId = new long[1] ;
      BC001J6_A65SecRoleId = new short[1] ;
      BC001J7_A350SecFunctionalityDescription = new String[] {""} ;
      BC001J8_A65SecRoleId = new short[1] ;
      BC001J9_A62SecFunctionalityId = new long[1] ;
      BC001J9_A65SecRoleId = new short[1] ;
      BC001J10_A62SecFunctionalityId = new long[1] ;
      BC001J10_A65SecRoleId = new short[1] ;
      sMode51 = "" ;
      BC001J11_A62SecFunctionalityId = new long[1] ;
      BC001J11_A65SecRoleId = new short[1] ;
      BC001J14_A350SecFunctionalityDescription = new String[] {""} ;
      BC001J15_A350SecFunctionalityDescription = new String[] {""} ;
      BC001J15_A62SecFunctionalityId = new long[1] ;
      BC001J15_A65SecRoleId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC001J16_A350SecFunctionalityDescription = new String[] {""} ;
      BC001J17_A65SecRoleId = new short[1] ;
      BC001J18_A350SecFunctionalityDescription = new String[] {""} ;
      BC001J19_A65SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secfunctionalityrole_bc__default(),
         new Object[] {
             new Object[] {
            BC001J2_A62SecFunctionalityId, BC001J2_A65SecRoleId
            }
            , new Object[] {
            BC001J3_A62SecFunctionalityId, BC001J3_A65SecRoleId
            }
            , new Object[] {
            BC001J4_A350SecFunctionalityDescription
            }
            , new Object[] {
            BC001J5_A65SecRoleId
            }
            , new Object[] {
            BC001J6_A350SecFunctionalityDescription, BC001J6_A62SecFunctionalityId, BC001J6_A65SecRoleId
            }
            , new Object[] {
            BC001J7_A350SecFunctionalityDescription
            }
            , new Object[] {
            BC001J8_A65SecRoleId
            }
            , new Object[] {
            BC001J9_A62SecFunctionalityId, BC001J9_A65SecRoleId
            }
            , new Object[] {
            BC001J10_A62SecFunctionalityId, BC001J10_A65SecRoleId
            }
            , new Object[] {
            BC001J11_A62SecFunctionalityId, BC001J11_A65SecRoleId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC001J14_A350SecFunctionalityDescription
            }
            , new Object[] {
            BC001J15_A350SecFunctionalityDescription, BC001J15_A62SecFunctionalityId, BC001J15_A65SecRoleId
            }
            , new Object[] {
            BC001J16_A350SecFunctionalityDescription
            }
            , new Object[] {
            BC001J17_A65SecRoleId
            }
            , new Object[] {
            BC001J18_A350SecFunctionalityDescription
            }
            , new Object[] {
            BC001J19_A65SecRoleId
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
   private short Z65SecRoleId ;
   private short A65SecRoleId ;
   private short RcdFound51 ;
   private short nIsDirty_51 ;
   private int trnEnded ;
   private int GX_JID ;
   private long Z62SecFunctionalityId ;
   private long A62SecFunctionalityId ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode51 ;
   private boolean mustCommit ;
   private String Z350SecFunctionalityDescription ;
   private String A350SecFunctionalityDescription ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private web.wwpbaseobjects.SdtSecFunctionalityRole bcwwpbaseobjects_SecFunctionalityRole ;
   private IDataStoreProvider pr_default ;
   private String[] BC001J6_A350SecFunctionalityDescription ;
   private long[] BC001J6_A62SecFunctionalityId ;
   private short[] BC001J6_A65SecRoleId ;
   private String[] BC001J7_A350SecFunctionalityDescription ;
   private short[] BC001J8_A65SecRoleId ;
   private long[] BC001J9_A62SecFunctionalityId ;
   private short[] BC001J9_A65SecRoleId ;
   private long[] BC001J10_A62SecFunctionalityId ;
   private short[] BC001J10_A65SecRoleId ;
   private long[] BC001J11_A62SecFunctionalityId ;
   private short[] BC001J11_A65SecRoleId ;
   private String[] BC001J14_A350SecFunctionalityDescription ;
   private String[] BC001J15_A350SecFunctionalityDescription ;
   private long[] BC001J15_A62SecFunctionalityId ;
   private short[] BC001J15_A65SecRoleId ;
   private String[] BC001J16_A350SecFunctionalityDescription ;
   private short[] BC001J17_A65SecRoleId ;
   private String[] BC001J18_A350SecFunctionalityDescription ;
   private short[] BC001J19_A65SecRoleId ;
   private long[] BC001J2_A62SecFunctionalityId ;
   private short[] BC001J2_A65SecRoleId ;
   private long[] BC001J3_A62SecFunctionalityId ;
   private short[] BC001J3_A65SecRoleId ;
   private String[] BC001J4_A350SecFunctionalityDescription ;
   private short[] BC001J5_A65SecRoleId ;
}

final  class secfunctionalityrole_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC001J2", "SELECT SecFunctionalityId, SecRoleId FROM SecFunctionalityRole WHERE SecFunctionalityId = ? AND SecRoleId = ?  FOR UPDATE OF SecFunctionalityRole",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J3", "SELECT SecFunctionalityId, SecRoleId FROM SecFunctionalityRole WHERE SecFunctionalityId = ? AND SecRoleId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J4", "SELECT SecFunctionalityDescription FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J5", "SELECT SecRoleId FROM SecRole WHERE SecRoleId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J6", "SELECT T2.SecFunctionalityDescription, TM1.SecFunctionalityId, TM1.SecRoleId FROM (SecFunctionalityRole TM1 INNER JOIN SecFunctionality T2 ON T2.SecFunctionalityId = TM1.SecFunctionalityId) WHERE TM1.SecFunctionalityId = ? and TM1.SecRoleId = ? ORDER BY TM1.SecFunctionalityId, TM1.SecRoleId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J7", "SELECT SecFunctionalityDescription FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J8", "SELECT SecRoleId FROM SecRole WHERE SecRoleId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J9", "SELECT SecFunctionalityId, SecRoleId FROM SecFunctionalityRole WHERE SecFunctionalityId = ? AND SecRoleId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J10", "SELECT SecFunctionalityId, SecRoleId FROM SecFunctionalityRole WHERE SecFunctionalityId = ? AND SecRoleId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J11", "SELECT SecFunctionalityId, SecRoleId FROM SecFunctionalityRole WHERE SecFunctionalityId = ? AND SecRoleId = ?  FOR UPDATE OF SecFunctionalityRole",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC001J12", "SAVEPOINT gxupdate;INSERT INTO SecFunctionalityRole(SecFunctionalityId, SecRoleId) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC001J13", "SAVEPOINT gxupdate;DELETE FROM SecFunctionalityRole  WHERE SecFunctionalityId = ? AND SecRoleId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC001J14", "SELECT SecFunctionalityDescription FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J15", "SELECT T2.SecFunctionalityDescription, TM1.SecFunctionalityId, TM1.SecRoleId FROM (SecFunctionalityRole TM1 INNER JOIN SecFunctionality T2 ON T2.SecFunctionalityId = TM1.SecFunctionalityId) WHERE TM1.SecFunctionalityId = ? and TM1.SecRoleId = ? ORDER BY TM1.SecFunctionalityId, TM1.SecRoleId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J16", "SELECT SecFunctionalityDescription FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J17", "SELECT SecRoleId FROM SecRole WHERE SecRoleId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J18", "SELECT SecFunctionalityDescription FROM SecFunctionality WHERE SecFunctionalityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC001J19", "SELECT SecRoleId FROM SecRole WHERE SecRoleId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 8 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 9 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 9 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 10 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 11 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 12 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 13 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 16 :
               stmt.setLong(1, ((Number) parms[0]).longValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

