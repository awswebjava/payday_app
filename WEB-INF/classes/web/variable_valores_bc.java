package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class variable_valores_bc extends GXWebPanel implements IGxSilentTrn
{
   public variable_valores_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public variable_valores_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( variable_valores_bc.class ));
   }

   public variable_valores_bc( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow2L81( ) ;
      standaloneNotModal( ) ;
      initializeNonKey2L81( ) ;
      standaloneModal( ) ;
      addRow2L81( ) ;
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
         e112L2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z82OpeCliId = A82OpeCliId ;
            Z754OpeCliVig = A754OpeCliVig ;
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

   public void confirm_2L0( )
   {
      beforeValidate2L81( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2L81( ) ;
         }
         else
         {
            checkExtendedTable2L81( ) ;
            if ( AnyError == 0 )
            {
               zm2L81( 3) ;
            }
            closeExtendedTableCursors2L81( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e122L2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWvariable_valores_Insert", GXv_boolean3) ;
         variable_valores_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWvariable_valores_Update", GXv_boolean3) ;
         variable_valores_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWvariable_valores_Delete", GXv_boolean3) ;
         variable_valores_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV27Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
   }

   public void e112L2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      GXt_int4 = AV21EmpCod ;
      GXv_int5[0] = GXt_int4 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int5) ;
      variable_valores_bc.this.GXt_int4 = GXv_int5[0] ;
      AV21EmpCod = GXt_int4 ;
      new web.setlegrecalcularliq(remoteHandle, context).execute( AV7CliCod, AV21EmpCod, 0, true) ;
      new web.variablevalorgrabarrelref(remoteHandle, context).execute( A3CliCod, A82OpeCliId, A754OpeCliVig) ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm2L81( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z924OpeCliVPropagar = A924OpeCliVPropagar ;
         Z1146OpeCliVRetro = A1146OpeCliVRetro ;
         Z1890OpeCliRelSec = A1890OpeCliRelSec ;
         Z1904OpeCliRelSecCli = A1904OpeCliRelSecCli ;
         Z2010OpeCliVRelRef = A2010OpeCliVRelRef ;
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -2 )
      {
         Z754OpeCliVig = A754OpeCliVig ;
         Z535OpeCliValor = A535OpeCliValor ;
         Z924OpeCliVPropagar = A924OpeCliVPropagar ;
         Z1146OpeCliVRetro = A1146OpeCliVRetro ;
         Z1890OpeCliRelSec = A1890OpeCliRelSec ;
         Z1904OpeCliRelSecCli = A1904OpeCliRelSecCli ;
         Z2010OpeCliVRelRef = A2010OpeCliVRelRef ;
         Z2032OpeCliVOld = A2032OpeCliVOld ;
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int6 = A3CliCod ;
         GXv_int7[0] = GXt_int6 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
         variable_valores_bc.this.GXt_int6 = GXv_int7[0] ;
         A3CliCod = GXt_int6 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
   }

   public void load2L81( )
   {
      /* Using cursor BC002L5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A535OpeCliValor = BC002L5_A535OpeCliValor[0] ;
         A924OpeCliVPropagar = BC002L5_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = BC002L5_n924OpeCliVPropagar[0] ;
         A1146OpeCliVRetro = BC002L5_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = BC002L5_n1146OpeCliVRetro[0] ;
         A1890OpeCliRelSec = BC002L5_A1890OpeCliRelSec[0] ;
         A1904OpeCliRelSecCli = BC002L5_A1904OpeCliRelSecCli[0] ;
         A2010OpeCliVRelRef = BC002L5_A2010OpeCliVRelRef[0] ;
         A2032OpeCliVOld = BC002L5_A2032OpeCliVOld[0] ;
         zm2L81( -2) ;
      }
      pr_default.close(3);
      onLoadActions2L81( ) ;
   }

   public void onLoadActions2L81( )
   {
      AV27Pgmname = "variable_valores_BC" ;
   }

   public void checkExtendedTable2L81( )
   {
      nIsDirty_81 = (short)(0) ;
      standaloneModal( ) ;
      AV27Pgmname = "variable_valores_BC" ;
      /* Using cursor BC002L6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Variable", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPECLIID");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
   }

   public void closeExtendedTableCursors2L81( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey2L81( )
   {
      /* Using cursor BC002L7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound81 = (short)(1) ;
      }
      else
      {
         RcdFound81 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC002L8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm2L81( 2) ;
         RcdFound81 = (short)(1) ;
         A754OpeCliVig = BC002L8_A754OpeCliVig[0] ;
         A535OpeCliValor = BC002L8_A535OpeCliValor[0] ;
         A924OpeCliVPropagar = BC002L8_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = BC002L8_n924OpeCliVPropagar[0] ;
         A1146OpeCliVRetro = BC002L8_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = BC002L8_n1146OpeCliVRetro[0] ;
         A1890OpeCliRelSec = BC002L8_A1890OpeCliRelSec[0] ;
         A1904OpeCliRelSecCli = BC002L8_A1904OpeCliRelSecCli[0] ;
         A2010OpeCliVRelRef = BC002L8_A2010OpeCliVRelRef[0] ;
         A2032OpeCliVOld = BC002L8_A2032OpeCliVOld[0] ;
         A3CliCod = BC002L8_A3CliCod[0] ;
         A82OpeCliId = BC002L8_A82OpeCliId[0] ;
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
         Z754OpeCliVig = A754OpeCliVig ;
         sMode81 = Gx_mode ;
         Gx_mode = "DSP" ;
         load2L81( ) ;
         if ( AnyError == 1 )
         {
            RcdFound81 = (short)(0) ;
            initializeNonKey2L81( ) ;
         }
         Gx_mode = sMode81 ;
      }
      else
      {
         RcdFound81 = (short)(0) ;
         initializeNonKey2L81( ) ;
         sMode81 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode81 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey2L81( ) ;
      if ( RcdFound81 == 0 )
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
      confirm_2L0( ) ;
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

   public void checkOptimisticConcurrency2L81( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002L9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"variable_valores"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( Z924OpeCliVPropagar != BC002L9_A924OpeCliVPropagar[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z1146OpeCliVRetro), GXutil.resetTime(BC002L9_A1146OpeCliVRetro[0])) ) || ( Z1890OpeCliRelSec != BC002L9_A1890OpeCliRelSec[0] ) || ( Z1904OpeCliRelSecCli != BC002L9_A1904OpeCliRelSecCli[0] ) || ( GXutil.strcmp(Z2010OpeCliVRelRef, BC002L9_A2010OpeCliVRelRef[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"variable_valores"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2L81( )
   {
      beforeValidate2L81( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2L81( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2L81( 0) ;
         checkOptimisticConcurrency2L81( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2L81( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2L81( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002L10 */
                  pr_default.execute(8, new Object[] {A754OpeCliVig, A535OpeCliValor, Boolean.valueOf(n924OpeCliVPropagar), Boolean.valueOf(A924OpeCliVPropagar), Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A1890OpeCliRelSec), Integer.valueOf(A1904OpeCliRelSecCli), A2010OpeCliVRelRef, A2032OpeCliVOld, Integer.valueOf(A3CliCod), A82OpeCliId});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
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
            load2L81( ) ;
         }
         endLevel2L81( ) ;
      }
      closeExtendedTableCursors2L81( ) ;
   }

   public void update2L81( )
   {
      beforeValidate2L81( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2L81( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2L81( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2L81( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2L81( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002L11 */
                  pr_default.execute(9, new Object[] {A535OpeCliValor, Boolean.valueOf(n924OpeCliVPropagar), Boolean.valueOf(A924OpeCliVPropagar), Boolean.valueOf(n1146OpeCliVRetro), A1146OpeCliVRetro, Integer.valueOf(A1890OpeCliRelSec), Integer.valueOf(A1904OpeCliRelSecCli), A2010OpeCliVRelRef, A2032OpeCliVOld, Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"variable_valores"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2L81( ) ;
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
         endLevel2L81( ) ;
      }
      closeExtendedTableCursors2L81( ) ;
   }

   public void deferredUpdate2L81( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2L81( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2L81( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2L81( ) ;
         afterConfirm2L81( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2L81( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002L12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("variable_valores");
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
      sMode81 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2L81( ) ;
      Gx_mode = sMode81 ;
   }

   public void onDeleteControls2L81( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV27Pgmname = "variable_valores_BC" ;
      }
   }

   public void endLevel2L81( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2L81( ) ;
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

   public void scanKeyStart2L81( )
   {
      /* Scan By routine */
      /* Using cursor BC002L13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId, A754OpeCliVig});
      RcdFound81 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A754OpeCliVig = BC002L13_A754OpeCliVig[0] ;
         A535OpeCliValor = BC002L13_A535OpeCliValor[0] ;
         A924OpeCliVPropagar = BC002L13_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = BC002L13_n924OpeCliVPropagar[0] ;
         A1146OpeCliVRetro = BC002L13_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = BC002L13_n1146OpeCliVRetro[0] ;
         A1890OpeCliRelSec = BC002L13_A1890OpeCliRelSec[0] ;
         A1904OpeCliRelSecCli = BC002L13_A1904OpeCliRelSecCli[0] ;
         A2010OpeCliVRelRef = BC002L13_A2010OpeCliVRelRef[0] ;
         A2032OpeCliVOld = BC002L13_A2032OpeCliVOld[0] ;
         A3CliCod = BC002L13_A3CliCod[0] ;
         A82OpeCliId = BC002L13_A82OpeCliId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2L81( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound81 = (short)(0) ;
      scanKeyLoad2L81( ) ;
   }

   public void scanKeyLoad2L81( )
   {
      sMode81 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound81 = (short)(1) ;
         A754OpeCliVig = BC002L13_A754OpeCliVig[0] ;
         A535OpeCliValor = BC002L13_A535OpeCliValor[0] ;
         A924OpeCliVPropagar = BC002L13_A924OpeCliVPropagar[0] ;
         n924OpeCliVPropagar = BC002L13_n924OpeCliVPropagar[0] ;
         A1146OpeCliVRetro = BC002L13_A1146OpeCliVRetro[0] ;
         n1146OpeCliVRetro = BC002L13_n1146OpeCliVRetro[0] ;
         A1890OpeCliRelSec = BC002L13_A1890OpeCliRelSec[0] ;
         A1904OpeCliRelSecCli = BC002L13_A1904OpeCliRelSecCli[0] ;
         A2010OpeCliVRelRef = BC002L13_A2010OpeCliVRelRef[0] ;
         A2032OpeCliVOld = BC002L13_A2032OpeCliVOld[0] ;
         A3CliCod = BC002L13_A3CliCod[0] ;
         A82OpeCliId = BC002L13_A82OpeCliId[0] ;
      }
      Gx_mode = sMode81 ;
   }

   public void scanKeyEnd2L81( )
   {
      pr_default.close(11);
   }

   public void afterConfirm2L81( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2L81( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2L81( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2L81( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2L81( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2L81( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2L81( )
   {
   }

   public void send_integrity_lvl_hashes2L81( )
   {
   }

   public void addRow2L81( )
   {
      VarsToRow81( bcvariable_valores) ;
   }

   public void readRow2L81( )
   {
      RowToVars81( bcvariable_valores, 1) ;
   }

   public void initializeNonKey2L81( )
   {
      A535OpeCliValor = "" ;
      A924OpeCliVPropagar = false ;
      n924OpeCliVPropagar = false ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      n1146OpeCliVRetro = false ;
      A1890OpeCliRelSec = 0 ;
      A1904OpeCliRelSecCli = 0 ;
      A2010OpeCliVRelRef = "" ;
      A2032OpeCliVOld = "" ;
      Z924OpeCliVPropagar = false ;
      Z1146OpeCliVRetro = GXutil.nullDate() ;
      Z1890OpeCliRelSec = 0 ;
      Z1904OpeCliRelSecCli = 0 ;
      Z2010OpeCliVRelRef = "" ;
   }

   public void initAll2L81( )
   {
      A3CliCod = 0 ;
      A82OpeCliId = "" ;
      A754OpeCliVig = GXutil.nullDate() ;
      initializeNonKey2L81( ) ;
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

   public void VarsToRow81( web.Sdtvariable_valores obj81 )
   {
      obj81.setgxTv_Sdtvariable_valores_Mode( Gx_mode );
      obj81.setgxTv_Sdtvariable_valores_Opeclivalor( A535OpeCliValor );
      obj81.setgxTv_Sdtvariable_valores_Opeclivpropagar( A924OpeCliVPropagar );
      obj81.setgxTv_Sdtvariable_valores_Opeclivretro( A1146OpeCliVRetro );
      obj81.setgxTv_Sdtvariable_valores_Opeclirelsec( A1890OpeCliRelSec );
      obj81.setgxTv_Sdtvariable_valores_Opeclirelseccli( A1904OpeCliRelSecCli );
      obj81.setgxTv_Sdtvariable_valores_Opeclivrelref( A2010OpeCliVRelRef );
      obj81.setgxTv_Sdtvariable_valores_Opeclivold( A2032OpeCliVOld );
      obj81.setgxTv_Sdtvariable_valores_Clicod( A3CliCod );
      obj81.setgxTv_Sdtvariable_valores_Opecliid( A82OpeCliId );
      obj81.setgxTv_Sdtvariable_valores_Opeclivig( A754OpeCliVig );
      obj81.setgxTv_Sdtvariable_valores_Clicod_Z( Z3CliCod );
      obj81.setgxTv_Sdtvariable_valores_Opecliid_Z( Z82OpeCliId );
      obj81.setgxTv_Sdtvariable_valores_Opeclivig_Z( Z754OpeCliVig );
      obj81.setgxTv_Sdtvariable_valores_Opeclivpropagar_Z( Z924OpeCliVPropagar );
      obj81.setgxTv_Sdtvariable_valores_Opeclivretro_Z( Z1146OpeCliVRetro );
      obj81.setgxTv_Sdtvariable_valores_Opeclirelsec_Z( Z1890OpeCliRelSec );
      obj81.setgxTv_Sdtvariable_valores_Opeclirelseccli_Z( Z1904OpeCliRelSecCli );
      obj81.setgxTv_Sdtvariable_valores_Opeclivrelref_Z( Z2010OpeCliVRelRef );
      obj81.setgxTv_Sdtvariable_valores_Opeclivpropagar_N( (byte)((byte)((n924OpeCliVPropagar)?1:0)) );
      obj81.setgxTv_Sdtvariable_valores_Opeclivretro_N( (byte)((byte)((n1146OpeCliVRetro)?1:0)) );
      obj81.setgxTv_Sdtvariable_valores_Mode( Gx_mode );
   }

   public void KeyVarsToRow81( web.Sdtvariable_valores obj81 )
   {
      obj81.setgxTv_Sdtvariable_valores_Clicod( A3CliCod );
      obj81.setgxTv_Sdtvariable_valores_Opecliid( A82OpeCliId );
      obj81.setgxTv_Sdtvariable_valores_Opeclivig( A754OpeCliVig );
   }

   public void RowToVars81( web.Sdtvariable_valores obj81 ,
                            int forceLoad )
   {
      Gx_mode = obj81.getgxTv_Sdtvariable_valores_Mode() ;
      A535OpeCliValor = obj81.getgxTv_Sdtvariable_valores_Opeclivalor() ;
      A924OpeCliVPropagar = obj81.getgxTv_Sdtvariable_valores_Opeclivpropagar() ;
      n924OpeCliVPropagar = false ;
      A1146OpeCliVRetro = obj81.getgxTv_Sdtvariable_valores_Opeclivretro() ;
      n1146OpeCliVRetro = false ;
      A1890OpeCliRelSec = obj81.getgxTv_Sdtvariable_valores_Opeclirelsec() ;
      A1904OpeCliRelSecCli = obj81.getgxTv_Sdtvariable_valores_Opeclirelseccli() ;
      A2010OpeCliVRelRef = obj81.getgxTv_Sdtvariable_valores_Opeclivrelref() ;
      A2032OpeCliVOld = obj81.getgxTv_Sdtvariable_valores_Opeclivold() ;
      A3CliCod = obj81.getgxTv_Sdtvariable_valores_Clicod() ;
      A82OpeCliId = obj81.getgxTv_Sdtvariable_valores_Opecliid() ;
      A754OpeCliVig = obj81.getgxTv_Sdtvariable_valores_Opeclivig() ;
      Z3CliCod = obj81.getgxTv_Sdtvariable_valores_Clicod_Z() ;
      Z82OpeCliId = obj81.getgxTv_Sdtvariable_valores_Opecliid_Z() ;
      Z754OpeCliVig = obj81.getgxTv_Sdtvariable_valores_Opeclivig_Z() ;
      Z924OpeCliVPropagar = obj81.getgxTv_Sdtvariable_valores_Opeclivpropagar_Z() ;
      Z1146OpeCliVRetro = obj81.getgxTv_Sdtvariable_valores_Opeclivretro_Z() ;
      Z1890OpeCliRelSec = obj81.getgxTv_Sdtvariable_valores_Opeclirelsec_Z() ;
      Z1904OpeCliRelSecCli = obj81.getgxTv_Sdtvariable_valores_Opeclirelseccli_Z() ;
      Z2010OpeCliVRelRef = obj81.getgxTv_Sdtvariable_valores_Opeclivrelref_Z() ;
      n924OpeCliVPropagar = (boolean)((obj81.getgxTv_Sdtvariable_valores_Opeclivpropagar_N()==0)?false:true) ;
      n1146OpeCliVRetro = (boolean)((obj81.getgxTv_Sdtvariable_valores_Opeclivretro_N()==0)?false:true) ;
      Gx_mode = obj81.getgxTv_Sdtvariable_valores_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A82OpeCliId = (String)getParm(obj,1) ;
      A754OpeCliVig = (java.util.Date)getParm(obj,2) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey2L81( ) ;
      scanKeyStart2L81( ) ;
      if ( RcdFound81 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002L14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
         if ( (pr_default.getStatus(12) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Variable", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPECLIID");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
         Z754OpeCliVig = A754OpeCliVig ;
      }
      zm2L81( -2) ;
      onLoadActions2L81( ) ;
      addRow2L81( ) ;
      scanKeyEnd2L81( ) ;
      if ( RcdFound81 == 0 )
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
      RowToVars81( bcvariable_valores, 0) ;
      scanKeyStart2L81( ) ;
      if ( RcdFound81 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002L15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A82OpeCliId});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Variable", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "OPECLIID");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z82OpeCliId = A82OpeCliId ;
         Z754OpeCliVig = A754OpeCliVig ;
      }
      zm2L81( -2) ;
      onLoadActions2L81( ) ;
      addRow2L81( ) ;
      scanKeyEnd2L81( ) ;
      if ( RcdFound81 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2L81( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert2L81( ) ;
      }
      else
      {
         if ( RcdFound81 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) )
            {
               A3CliCod = Z3CliCod ;
               A82OpeCliId = Z82OpeCliId ;
               A754OpeCliVig = Z754OpeCliVig ;
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
               update2L81( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) )
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
                     insert2L81( ) ;
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
                     insert2L81( ) ;
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
      RowToVars81( bcvariable_valores, 1) ;
      saveImpl( ) ;
      VarsToRow81( bcvariable_valores) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars81( bcvariable_valores, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2L81( ) ;
      afterTrn( ) ;
      VarsToRow81( bcvariable_valores) ;
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
         web.Sdtvariable_valores auxBC = new web.Sdtvariable_valores( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A82OpeCliId, A754OpeCliVig);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcvariable_valores);
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
      RowToVars81( bcvariable_valores, 1) ;
      updateImpl( ) ;
      VarsToRow81( bcvariable_valores) ;
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
      RowToVars81( bcvariable_valores, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2L81( ) ;
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
      VarsToRow81( bcvariable_valores) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars81( bcvariable_valores, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey2L81( ) ;
      if ( RcdFound81 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) )
         {
            A3CliCod = Z3CliCod ;
            A82OpeCliId = Z82OpeCliId ;
            A754OpeCliVig = Z754OpeCliVig ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A82OpeCliId, Z82OpeCliId) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A754OpeCliVig), GXutil.resetTime(Z754OpeCliVig)) ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "variable_valores_bc");
      VarsToRow81( bcvariable_valores) ;
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
      Gx_mode = bcvariable_valores.getgxTv_Sdtvariable_valores_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcvariable_valores.setgxTv_Sdtvariable_valores_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtvariable_valores sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcvariable_valores )
      {
         bcvariable_valores = sdt ;
         if ( GXutil.strcmp(bcvariable_valores.getgxTv_Sdtvariable_valores_Mode(), "") == 0 )
         {
            bcvariable_valores.setgxTv_Sdtvariable_valores_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow81( bcvariable_valores) ;
         }
         else
         {
            RowToVars81( bcvariable_valores, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcvariable_valores.getgxTv_Sdtvariable_valores_Mode(), "") == 0 )
         {
            bcvariable_valores.setgxTv_Sdtvariable_valores_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars81( bcvariable_valores, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtvariable_valores getvariable_valores_BC( )
   {
      return bcvariable_valores ;
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
      Z82OpeCliId = "" ;
      A82OpeCliId = "" ;
      Z754OpeCliVig = GXutil.nullDate() ;
      A754OpeCliVig = GXutil.nullDate() ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV27Pgmname = "" ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      GXv_int5 = new short[1] ;
      Z1146OpeCliVRetro = GXutil.nullDate() ;
      A1146OpeCliVRetro = GXutil.nullDate() ;
      Z2010OpeCliVRelRef = "" ;
      A2010OpeCliVRelRef = "" ;
      Z535OpeCliValor = "" ;
      A535OpeCliValor = "" ;
      Z2032OpeCliVOld = "" ;
      A2032OpeCliVOld = "" ;
      GXv_int7 = new int[1] ;
      BC002L5_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L5_A535OpeCliValor = new String[] {""} ;
      BC002L5_A924OpeCliVPropagar = new boolean[] {false} ;
      BC002L5_n924OpeCliVPropagar = new boolean[] {false} ;
      BC002L5_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L5_n1146OpeCliVRetro = new boolean[] {false} ;
      BC002L5_A1890OpeCliRelSec = new int[1] ;
      BC002L5_A1904OpeCliRelSecCli = new int[1] ;
      BC002L5_A2010OpeCliVRelRef = new String[] {""} ;
      BC002L5_A2032OpeCliVOld = new String[] {""} ;
      BC002L5_A3CliCod = new int[1] ;
      BC002L5_A82OpeCliId = new String[] {""} ;
      BC002L6_A3CliCod = new int[1] ;
      BC002L7_A3CliCod = new int[1] ;
      BC002L7_A82OpeCliId = new String[] {""} ;
      BC002L7_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L8_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L8_A535OpeCliValor = new String[] {""} ;
      BC002L8_A924OpeCliVPropagar = new boolean[] {false} ;
      BC002L8_n924OpeCliVPropagar = new boolean[] {false} ;
      BC002L8_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L8_n1146OpeCliVRetro = new boolean[] {false} ;
      BC002L8_A1890OpeCliRelSec = new int[1] ;
      BC002L8_A1904OpeCliRelSecCli = new int[1] ;
      BC002L8_A2010OpeCliVRelRef = new String[] {""} ;
      BC002L8_A2032OpeCliVOld = new String[] {""} ;
      BC002L8_A3CliCod = new int[1] ;
      BC002L8_A82OpeCliId = new String[] {""} ;
      sMode81 = "" ;
      BC002L9_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L9_A535OpeCliValor = new String[] {""} ;
      BC002L9_A924OpeCliVPropagar = new boolean[] {false} ;
      BC002L9_n924OpeCliVPropagar = new boolean[] {false} ;
      BC002L9_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L9_n1146OpeCliVRetro = new boolean[] {false} ;
      BC002L9_A1890OpeCliRelSec = new int[1] ;
      BC002L9_A1904OpeCliRelSecCli = new int[1] ;
      BC002L9_A2010OpeCliVRelRef = new String[] {""} ;
      BC002L9_A2032OpeCliVOld = new String[] {""} ;
      BC002L9_A3CliCod = new int[1] ;
      BC002L9_A82OpeCliId = new String[] {""} ;
      BC002L13_A754OpeCliVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L13_A535OpeCliValor = new String[] {""} ;
      BC002L13_A924OpeCliVPropagar = new boolean[] {false} ;
      BC002L13_n924OpeCliVPropagar = new boolean[] {false} ;
      BC002L13_A1146OpeCliVRetro = new java.util.Date[] {GXutil.nullDate()} ;
      BC002L13_n1146OpeCliVRetro = new boolean[] {false} ;
      BC002L13_A1890OpeCliRelSec = new int[1] ;
      BC002L13_A1904OpeCliRelSecCli = new int[1] ;
      BC002L13_A2010OpeCliVRelRef = new String[] {""} ;
      BC002L13_A2032OpeCliVOld = new String[] {""} ;
      BC002L13_A3CliCod = new int[1] ;
      BC002L13_A82OpeCliId = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC002L14_A3CliCod = new int[1] ;
      BC002L15_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.variable_valores_bc__default(),
         new Object[] {
             new Object[] {
            BC002L2_A754OpeCliVig, BC002L2_A535OpeCliValor, BC002L2_A924OpeCliVPropagar, BC002L2_n924OpeCliVPropagar, BC002L2_A1146OpeCliVRetro, BC002L2_n1146OpeCliVRetro, BC002L2_A1890OpeCliRelSec, BC002L2_A1904OpeCliRelSecCli, BC002L2_A2010OpeCliVRelRef, BC002L2_A2032OpeCliVOld,
            BC002L2_A3CliCod, BC002L2_A82OpeCliId
            }
            , new Object[] {
            BC002L3_A754OpeCliVig, BC002L3_A535OpeCliValor, BC002L3_A924OpeCliVPropagar, BC002L3_n924OpeCliVPropagar, BC002L3_A1146OpeCliVRetro, BC002L3_n1146OpeCliVRetro, BC002L3_A1890OpeCliRelSec, BC002L3_A1904OpeCliRelSecCli, BC002L3_A2010OpeCliVRelRef, BC002L3_A2032OpeCliVOld,
            BC002L3_A3CliCod, BC002L3_A82OpeCliId
            }
            , new Object[] {
            BC002L4_A3CliCod
            }
            , new Object[] {
            BC002L5_A754OpeCliVig, BC002L5_A535OpeCliValor, BC002L5_A924OpeCliVPropagar, BC002L5_n924OpeCliVPropagar, BC002L5_A1146OpeCliVRetro, BC002L5_n1146OpeCliVRetro, BC002L5_A1890OpeCliRelSec, BC002L5_A1904OpeCliRelSecCli, BC002L5_A2010OpeCliVRelRef, BC002L5_A2032OpeCliVOld,
            BC002L5_A3CliCod, BC002L5_A82OpeCliId
            }
            , new Object[] {
            BC002L6_A3CliCod
            }
            , new Object[] {
            BC002L7_A3CliCod, BC002L7_A82OpeCliId, BC002L7_A754OpeCliVig
            }
            , new Object[] {
            BC002L8_A754OpeCliVig, BC002L8_A535OpeCliValor, BC002L8_A924OpeCliVPropagar, BC002L8_n924OpeCliVPropagar, BC002L8_A1146OpeCliVRetro, BC002L8_n1146OpeCliVRetro, BC002L8_A1890OpeCliRelSec, BC002L8_A1904OpeCliRelSecCli, BC002L8_A2010OpeCliVRelRef, BC002L8_A2032OpeCliVOld,
            BC002L8_A3CliCod, BC002L8_A82OpeCliId
            }
            , new Object[] {
            BC002L9_A754OpeCliVig, BC002L9_A535OpeCliValor, BC002L9_A924OpeCliVPropagar, BC002L9_n924OpeCliVPropagar, BC002L9_A1146OpeCliVRetro, BC002L9_n1146OpeCliVRetro, BC002L9_A1890OpeCliRelSec, BC002L9_A1904OpeCliRelSecCli, BC002L9_A2010OpeCliVRelRef, BC002L9_A2032OpeCliVOld,
            BC002L9_A3CliCod, BC002L9_A82OpeCliId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002L13_A754OpeCliVig, BC002L13_A535OpeCliValor, BC002L13_A924OpeCliVPropagar, BC002L13_n924OpeCliVPropagar, BC002L13_A1146OpeCliVRetro, BC002L13_n1146OpeCliVRetro, BC002L13_A1890OpeCliRelSec, BC002L13_A1904OpeCliRelSecCli, BC002L13_A2010OpeCliVRelRef, BC002L13_A2032OpeCliVOld,
            BC002L13_A3CliCod, BC002L13_A82OpeCliId
            }
            , new Object[] {
            BC002L14_A3CliCod
            }
            , new Object[] {
            BC002L15_A3CliCod
            }
         }
      );
      AV27Pgmname = "variable_valores_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e122L2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV21EmpCod ;
   private short GXt_int4 ;
   private short GXv_int5[] ;
   private short RcdFound81 ;
   private short nIsDirty_81 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int GX_JID ;
   private int Z1890OpeCliRelSec ;
   private int A1890OpeCliRelSec ;
   private int Z1904OpeCliRelSecCli ;
   private int A1904OpeCliRelSecCli ;
   private int GXt_int6 ;
   private int GXv_int7[] ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z82OpeCliId ;
   private String A82OpeCliId ;
   private String AV27Pgmname ;
   private String sMode81 ;
   private java.util.Date Z754OpeCliVig ;
   private java.util.Date A754OpeCliVig ;
   private java.util.Date Z1146OpeCliVRetro ;
   private java.util.Date A1146OpeCliVRetro ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z924OpeCliVPropagar ;
   private boolean A924OpeCliVPropagar ;
   private boolean n924OpeCliVPropagar ;
   private boolean n1146OpeCliVRetro ;
   private boolean mustCommit ;
   private String Z535OpeCliValor ;
   private String A535OpeCliValor ;
   private String Z2032OpeCliVOld ;
   private String A2032OpeCliVOld ;
   private String Z2010OpeCliVRelRef ;
   private String A2010OpeCliVRelRef ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private web.Sdtvariable_valores bcvariable_valores ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] BC002L5_A754OpeCliVig ;
   private String[] BC002L5_A535OpeCliValor ;
   private boolean[] BC002L5_A924OpeCliVPropagar ;
   private boolean[] BC002L5_n924OpeCliVPropagar ;
   private java.util.Date[] BC002L5_A1146OpeCliVRetro ;
   private boolean[] BC002L5_n1146OpeCliVRetro ;
   private int[] BC002L5_A1890OpeCliRelSec ;
   private int[] BC002L5_A1904OpeCliRelSecCli ;
   private String[] BC002L5_A2010OpeCliVRelRef ;
   private String[] BC002L5_A2032OpeCliVOld ;
   private int[] BC002L5_A3CliCod ;
   private String[] BC002L5_A82OpeCliId ;
   private int[] BC002L6_A3CliCod ;
   private int[] BC002L7_A3CliCod ;
   private String[] BC002L7_A82OpeCliId ;
   private java.util.Date[] BC002L7_A754OpeCliVig ;
   private java.util.Date[] BC002L8_A754OpeCliVig ;
   private String[] BC002L8_A535OpeCliValor ;
   private boolean[] BC002L8_A924OpeCliVPropagar ;
   private boolean[] BC002L8_n924OpeCliVPropagar ;
   private java.util.Date[] BC002L8_A1146OpeCliVRetro ;
   private boolean[] BC002L8_n1146OpeCliVRetro ;
   private int[] BC002L8_A1890OpeCliRelSec ;
   private int[] BC002L8_A1904OpeCliRelSecCli ;
   private String[] BC002L8_A2010OpeCliVRelRef ;
   private String[] BC002L8_A2032OpeCliVOld ;
   private int[] BC002L8_A3CliCod ;
   private String[] BC002L8_A82OpeCliId ;
   private java.util.Date[] BC002L9_A754OpeCliVig ;
   private String[] BC002L9_A535OpeCliValor ;
   private boolean[] BC002L9_A924OpeCliVPropagar ;
   private boolean[] BC002L9_n924OpeCliVPropagar ;
   private java.util.Date[] BC002L9_A1146OpeCliVRetro ;
   private boolean[] BC002L9_n1146OpeCliVRetro ;
   private int[] BC002L9_A1890OpeCliRelSec ;
   private int[] BC002L9_A1904OpeCliRelSecCli ;
   private String[] BC002L9_A2010OpeCliVRelRef ;
   private String[] BC002L9_A2032OpeCliVOld ;
   private int[] BC002L9_A3CliCod ;
   private String[] BC002L9_A82OpeCliId ;
   private java.util.Date[] BC002L13_A754OpeCliVig ;
   private String[] BC002L13_A535OpeCliValor ;
   private boolean[] BC002L13_A924OpeCliVPropagar ;
   private boolean[] BC002L13_n924OpeCliVPropagar ;
   private java.util.Date[] BC002L13_A1146OpeCliVRetro ;
   private boolean[] BC002L13_n1146OpeCliVRetro ;
   private int[] BC002L13_A1890OpeCliRelSec ;
   private int[] BC002L13_A1904OpeCliRelSecCli ;
   private String[] BC002L13_A2010OpeCliVRelRef ;
   private String[] BC002L13_A2032OpeCliVOld ;
   private int[] BC002L13_A3CliCod ;
   private String[] BC002L13_A82OpeCliId ;
   private int[] BC002L14_A3CliCod ;
   private int[] BC002L15_A3CliCod ;
   private java.util.Date[] BC002L2_A754OpeCliVig ;
   private String[] BC002L2_A535OpeCliValor ;
   private boolean[] BC002L2_A924OpeCliVPropagar ;
   private java.util.Date[] BC002L2_A1146OpeCliVRetro ;
   private int[] BC002L2_A1890OpeCliRelSec ;
   private int[] BC002L2_A1904OpeCliRelSecCli ;
   private String[] BC002L2_A2010OpeCliVRelRef ;
   private String[] BC002L2_A2032OpeCliVOld ;
   private int[] BC002L2_A3CliCod ;
   private String[] BC002L2_A82OpeCliId ;
   private java.util.Date[] BC002L3_A754OpeCliVig ;
   private String[] BC002L3_A535OpeCliValor ;
   private boolean[] BC002L3_A924OpeCliVPropagar ;
   private java.util.Date[] BC002L3_A1146OpeCliVRetro ;
   private int[] BC002L3_A1890OpeCliRelSec ;
   private int[] BC002L3_A1904OpeCliRelSecCli ;
   private String[] BC002L3_A2010OpeCliVRelRef ;
   private String[] BC002L3_A2032OpeCliVOld ;
   private int[] BC002L3_A3CliCod ;
   private String[] BC002L3_A82OpeCliId ;
   private int[] BC002L4_A3CliCod ;
   private boolean[] BC002L2_n924OpeCliVPropagar ;
   private boolean[] BC002L2_n1146OpeCliVRetro ;
   private boolean[] BC002L3_n924OpeCliVPropagar ;
   private boolean[] BC002L3_n1146OpeCliVRetro ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class variable_valores_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC002L2", "SELECT OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRelRef, OpeCliVOld, CliCod, OpeCliId FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?  FOR UPDATE OF variable_valores",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L3", "SELECT OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRelRef, OpeCliVOld, CliCod, OpeCliId FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L4", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L5", "SELECT TM1.OpeCliVig, TM1.OpeCliValor, TM1.OpeCliVPropagar, TM1.OpeCliVRetro, TM1.OpeCliRelSec, TM1.OpeCliRelSecCli, TM1.OpeCliVRelRef, TM1.OpeCliVOld, TM1.CliCod, TM1.OpeCliId FROM variable_valores TM1 WHERE TM1.CliCod = ? and TM1.OpeCliId = ( ?) and TM1.OpeCliVig = ? ORDER BY TM1.CliCod, TM1.OpeCliId, TM1.OpeCliVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L6", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L7", "SELECT CliCod, OpeCliId, OpeCliVig FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L8", "SELECT OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRelRef, OpeCliVOld, CliCod, OpeCliId FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L9", "SELECT OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRelRef, OpeCliVOld, CliCod, OpeCliId FROM variable_valores WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?  FOR UPDATE OF variable_valores",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002L10", "SAVEPOINT gxupdate;INSERT INTO variable_valores(OpeCliVig, OpeCliValor, OpeCliVPropagar, OpeCliVRetro, OpeCliRelSec, OpeCliRelSecCli, OpeCliVRelRef, OpeCliVOld, CliCod, OpeCliId) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002L11", "SAVEPOINT gxupdate;UPDATE variable_valores SET OpeCliValor=?, OpeCliVPropagar=?, OpeCliVRetro=?, OpeCliRelSec=?, OpeCliRelSecCli=?, OpeCliVRelRef=?, OpeCliVOld=?  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002L12", "SAVEPOINT gxupdate;DELETE FROM variable_valores  WHERE CliCod = ? AND OpeCliId = ? AND OpeCliVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002L13", "SELECT TM1.OpeCliVig, TM1.OpeCliValor, TM1.OpeCliVPropagar, TM1.OpeCliVRetro, TM1.OpeCliRelSec, TM1.OpeCliRelSecCli, TM1.OpeCliVRelRef, TM1.OpeCliVOld, TM1.CliCod, TM1.OpeCliId FROM variable_valores TM1 WHERE TM1.CliCod = ? and TM1.OpeCliId = ( ?) and TM1.OpeCliVig = ? ORDER BY TM1.CliCod, TM1.OpeCliId, TM1.OpeCliVig ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L14", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002L15", "SELECT CliCod FROM Variable WHERE CliCod = ? AND OpeCliId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               return;
            case 6 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
               return;
            case 7 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
               return;
            case 11 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(4);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((String[]) buf[11])[0] = rslt.getString(10, 40);
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
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 8 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setNLongVarchar(2, (String)parms[1], false);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(3, ((Boolean) parms[3]).booleanValue());
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DATE );
               }
               else
               {
                  stmt.setDate(4, (java.util.Date)parms[5]);
               }
               stmt.setInt(5, ((Number) parms[6]).intValue());
               stmt.setInt(6, ((Number) parms[7]).intValue());
               stmt.setVarchar(7, (String)parms[8], 40, false);
               stmt.setNLongVarchar(8, (String)parms[9], false);
               stmt.setInt(9, ((Number) parms[10]).intValue());
               stmt.setString(10, (String)parms[11], 40);
               return;
            case 9 :
               stmt.setNLongVarchar(1, (String)parms[0], false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(2, ((Boolean) parms[2]).booleanValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DATE );
               }
               else
               {
                  stmt.setDate(3, (java.util.Date)parms[4]);
               }
               stmt.setInt(4, ((Number) parms[5]).intValue());
               stmt.setInt(5, ((Number) parms[6]).intValue());
               stmt.setVarchar(6, (String)parms[7], 40, false);
               stmt.setNLongVarchar(7, (String)parms[8], false);
               stmt.setInt(8, ((Number) parms[9]).intValue());
               stmt.setString(9, (String)parms[10], 40);
               stmt.setDate(10, (java.util.Date)parms[11]);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
      }
   }

}

