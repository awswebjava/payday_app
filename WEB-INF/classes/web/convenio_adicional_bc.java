package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_adicional_bc extends GXWebPanel implements IGxSilentTrn
{
   public convenio_adicional_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_adicional_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicional_bc.class ));
   }

   public convenio_adicional_bc( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow2W207( ) ;
      standaloneNotModal( ) ;
      initializeNonKey2W207( ) ;
      standaloneModal( ) ;
      addRow2W207( ) ;
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
         e112W2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z996ConveAdicod = A996ConveAdicod ;
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

   public void confirm_2W0( )
   {
      beforeValidate2W207( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2W207( ) ;
         }
         else
         {
            checkExtendedTable2W207( ) ;
            if ( AnyError == 0 )
            {
               zm2W207( 5) ;
            }
            closeExtendedTableCursors2W207( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode207 = Gx_mode ;
         confirm_2W245( ) ;
         if ( AnyError == 0 )
         {
            confirm_2W208( ) ;
            if ( AnyError == 0 )
            {
               confirm_2W209( ) ;
               if ( AnyError == 0 )
               {
                  /* Restore parent mode. */
                  Gx_mode = sMode207 ;
                  IsConfirmed = (short)(1) ;
               }
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode207 ;
      }
   }

   public void confirm_2W209( )
   {
      nGXsfl_209_idx = 0 ;
      while ( nGXsfl_209_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().size() )
      {
         readRow2W209( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound209 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_209 != 0 ) )
         {
            getKey2W209( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound209 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate2W209( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2W209( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors2W209( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound209 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey2W209( ) ;
                     load2W209( ) ;
                     beforeValidate2W209( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2W209( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_209 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate2W209( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2W209( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors2W209( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow209( ((web.Sdtconvenio_adicional_alicuotas)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().elementAt(-1+nGXsfl_209_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_2W208( )
   {
      nGXsfl_208_idx = 0 ;
      while ( nGXsfl_208_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().size() )
      {
         readRow2W208( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound208 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_208 != 0 ) )
         {
            getKey2W208( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound208 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate2W208( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2W208( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors2W208( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound208 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey2W208( ) ;
                     load2W208( ) ;
                     beforeValidate2W208( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2W208( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_208 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate2W208( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2W208( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors2W208( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow208( ((web.Sdtconvenio_adicional_importes)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().elementAt(-1+nGXsfl_208_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_2W245( )
   {
      nGXsfl_245_idx = 0 ;
      while ( nGXsfl_245_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().size() )
      {
         readRow2W245( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound245 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_245 != 0 ) )
         {
            getKey2W245( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound245 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate2W245( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2W245( ) ;
                     if ( AnyError == 0 )
                     {
                        zm2W245( 7) ;
                     }
                     closeExtendedTableCursors2W245( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound245 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey2W245( ) ;
                     load2W245( ) ;
                     beforeValidate2W245( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2W245( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_245 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate2W245( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2W245( ) ;
                           if ( AnyError == 0 )
                           {
                              zm2W245( 7) ;
                           }
                           closeExtendedTableCursors2W245( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow245( ((web.Sdtconvenio_adicional_Cancela)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().elementAt(-1+nGXsfl_245_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e122W2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional_Insert", GXv_boolean3) ;
         convenio_adicional_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional_Update", GXv_boolean3) ;
         convenio_adicional_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional_Delete", GXv_boolean3) ;
         convenio_adicional_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV41Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
   }

   public void e112W2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm2W207( int GX_JID )
   {
      if ( ( GX_JID == 4 ) || ( GX_JID == 0 ) )
      {
         Z997ConveAdiDescri = A997ConveAdiDescri ;
         Z998ConveAdiAli = A998ConveAdiAli ;
         Z1803ConveAdiTipo = A1803ConveAdiTipo ;
         Z1901ConveAdiRelSec = A1901ConveAdiRelSec ;
         Z2046ConveAdiRelRef = A2046ConveAdiRelRef ;
      }
      if ( ( GX_JID == 5 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -4 )
      {
         Z996ConveAdicod = A996ConveAdicod ;
         Z997ConveAdiDescri = A997ConveAdiDescri ;
         Z998ConveAdiAli = A998ConveAdiAli ;
         Z1019ConveAdiInfo = A1019ConveAdiInfo ;
         Z1803ConveAdiTipo = A1803ConveAdiTipo ;
         Z1901ConveAdiRelSec = A1901ConveAdiRelSec ;
         Z2046ConveAdiRelRef = A2046ConveAdiRelRef ;
         Z2047ConveAdiOld = A2047ConveAdiOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         convenio_adicional_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
      Gx_BScreen = (byte)(0) ;
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (GXutil.strcmp("", A1803ConveAdiTipo)==0) && ( Gx_BScreen == 0 ) )
      {
         A1803ConveAdiTipo = "otros" ;
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
      }
   }

   public void load2W207( )
   {
      /* Using cursor BC002W12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound207 = (short)(1) ;
         A997ConveAdiDescri = BC002W12_A997ConveAdiDescri[0] ;
         A998ConveAdiAli = BC002W12_A998ConveAdiAli[0] ;
         A1019ConveAdiInfo = BC002W12_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = BC002W12_n1019ConveAdiInfo[0] ;
         A1803ConveAdiTipo = BC002W12_A1803ConveAdiTipo[0] ;
         A1901ConveAdiRelSec = BC002W12_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = BC002W12_n1901ConveAdiRelSec[0] ;
         A2046ConveAdiRelRef = BC002W12_A2046ConveAdiRelRef[0] ;
         A2047ConveAdiOld = BC002W12_A2047ConveAdiOld[0] ;
         zm2W207( -4) ;
      }
      pr_default.close(10);
      onLoadActions2W207( ) ;
   }

   public void onLoadActions2W207( )
   {
      AV41Pgmname = "convenio_adicional_BC" ;
   }

   public void checkExtendedTable2W207( )
   {
      nIsDirty_207 = (short)(0) ;
      standaloneModal( ) ;
      AV41Pgmname = "convenio_adicional_BC" ;
      /* Using cursor BC002W13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
      }
      pr_default.close(11);
      if ( ! ( ( GXutil.strcmp(A1803ConveAdiTipo, "titulo") == 0 ) || ( GXutil.strcmp(A1803ConveAdiTipo, "otros") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors2W207( )
   {
      pr_default.close(11);
   }

   public void enableDisable( )
   {
   }

   public void getKey2W207( )
   {
      /* Using cursor BC002W14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound207 = (short)(1) ;
      }
      else
      {
         RcdFound207 = (short)(0) ;
      }
      pr_default.close(12);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC002W15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(13) != 101) )
      {
         zm2W207( 4) ;
         RcdFound207 = (short)(1) ;
         A996ConveAdicod = BC002W15_A996ConveAdicod[0] ;
         A997ConveAdiDescri = BC002W15_A997ConveAdiDescri[0] ;
         A998ConveAdiAli = BC002W15_A998ConveAdiAli[0] ;
         A1019ConveAdiInfo = BC002W15_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = BC002W15_n1019ConveAdiInfo[0] ;
         A1803ConveAdiTipo = BC002W15_A1803ConveAdiTipo[0] ;
         A1901ConveAdiRelSec = BC002W15_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = BC002W15_n1901ConveAdiRelSec[0] ;
         A2046ConveAdiRelRef = BC002W15_A2046ConveAdiRelRef[0] ;
         A2047ConveAdiOld = BC002W15_A2047ConveAdiOld[0] ;
         A3CliCod = BC002W15_A3CliCod[0] ;
         A1564CliPaiConve = BC002W15_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC002W15_A1565CliConvenio[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         sMode207 = Gx_mode ;
         Gx_mode = "DSP" ;
         load2W207( ) ;
         if ( AnyError == 1 )
         {
            RcdFound207 = (short)(0) ;
            initializeNonKey2W207( ) ;
         }
         Gx_mode = sMode207 ;
      }
      else
      {
         RcdFound207 = (short)(0) ;
         initializeNonKey2W207( ) ;
         sMode207 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode207 ;
      }
      pr_default.close(13);
   }

   public void getEqualNoModal( )
   {
      getKey2W207( ) ;
      if ( RcdFound207 == 0 )
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
      confirm_2W0( ) ;
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

   public void checkOptimisticConcurrency2W207( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002W16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
         if ( (pr_default.getStatus(14) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(14) == 101) || ( GXutil.strcmp(Z997ConveAdiDescri, BC002W16_A997ConveAdiDescri[0]) != 0 ) || ( DecimalUtil.compareTo(Z998ConveAdiAli, BC002W16_A998ConveAdiAli[0]) != 0 ) || ( GXutil.strcmp(Z1803ConveAdiTipo, BC002W16_A1803ConveAdiTipo[0]) != 0 ) || ( Z1901ConveAdiRelSec != BC002W16_A1901ConveAdiRelSec[0] ) || ( GXutil.strcmp(Z2046ConveAdiRelRef, BC002W16_A2046ConveAdiRelRef[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2W207( )
   {
      beforeValidate2W207( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W207( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2W207( 0) ;
         checkOptimisticConcurrency2W207( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W207( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2W207( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W17 */
                  pr_default.execute(15, new Object[] {A996ConveAdicod, A997ConveAdiDescri, A998ConveAdiAli, Boolean.valueOf(n1019ConveAdiInfo), A1019ConveAdiInfo, A1803ConveAdiTipo, Boolean.valueOf(n1901ConveAdiRelSec), Integer.valueOf(A1901ConveAdiRelSec), A2046ConveAdiRelRef, A2047ConveAdiOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicional");
                  if ( (pr_default.getStatus(15) == 1) )
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
                        processLevel2W207( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                        }
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
            load2W207( ) ;
         }
         endLevel2W207( ) ;
      }
      closeExtendedTableCursors2W207( ) ;
   }

   public void update2W207( )
   {
      beforeValidate2W207( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W207( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W207( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W207( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2W207( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W18 */
                  pr_default.execute(16, new Object[] {A997ConveAdiDescri, A998ConveAdiAli, Boolean.valueOf(n1019ConveAdiInfo), A1019ConveAdiInfo, A1803ConveAdiTipo, Boolean.valueOf(n1901ConveAdiRelSec), Integer.valueOf(A1901ConveAdiRelSec), A2046ConveAdiRelRef, A2047ConveAdiOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicional");
                  if ( (pr_default.getStatus(16) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2W207( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel2W207( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
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
         }
         endLevel2W207( ) ;
      }
      closeExtendedTableCursors2W207( ) ;
   }

   public void deferredUpdate2W207( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2W207( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W207( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2W207( ) ;
         afterConfirm2W207( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2W207( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart2W245( ) ;
               while ( RcdFound245 != 0 )
               {
                  getByPrimaryKey2W245( ) ;
                  delete2W245( ) ;
                  scanKeyNext2W245( ) ;
               }
               scanKeyEnd2W245( ) ;
               scanKeyStart2W209( ) ;
               while ( RcdFound209 != 0 )
               {
                  getByPrimaryKey2W209( ) ;
                  delete2W209( ) ;
                  scanKeyNext2W209( ) ;
               }
               scanKeyEnd2W209( ) ;
               scanKeyStart2W208( ) ;
               while ( RcdFound208 != 0 )
               {
                  getByPrimaryKey2W208( ) ;
                  delete2W208( ) ;
                  scanKeyNext2W208( ) ;
               }
               scanKeyEnd2W208( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W19 */
                  pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicional");
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
      }
      sMode207 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2W207( ) ;
      Gx_mode = sMode207 ;
   }

   public void onDeleteControls2W207( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV41Pgmname = "convenio_adicional_BC" ;
      }
   }

   public void processNestedLevel2W245( )
   {
      nGXsfl_245_idx = 0 ;
      while ( nGXsfl_245_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().size() )
      {
         readRow2W245( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound245 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_245 != 0 ) )
         {
            standaloneNotModal2W245( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert2W245( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete2W245( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update2W245( ) ;
               }
            }
         }
         KeyVarsToRow245( ((web.Sdtconvenio_adicional_Cancela)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().elementAt(-1+nGXsfl_245_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_245_idx = 0 ;
         while ( nGXsfl_245_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().size() )
         {
            readRow2W245( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound245 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().removeElement(nGXsfl_245_idx);
               nGXsfl_245_idx = (int)(nGXsfl_245_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey2W245( ) ;
               VarsToRow245( ((web.Sdtconvenio_adicional_Cancela)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().elementAt(-1+nGXsfl_245_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2W245( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_245 = (short)(0) ;
      nIsMod_245 = (short)(0) ;
      Gxremove245 = (byte)(0) ;
   }

   public void processNestedLevel2W208( )
   {
      nGXsfl_208_idx = 0 ;
      while ( nGXsfl_208_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().size() )
      {
         readRow2W208( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound208 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_208 != 0 ) )
         {
            standaloneNotModal2W208( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert2W208( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete2W208( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update2W208( ) ;
               }
            }
         }
         KeyVarsToRow208( ((web.Sdtconvenio_adicional_importes)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().elementAt(-1+nGXsfl_208_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_208_idx = 0 ;
         while ( nGXsfl_208_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().size() )
         {
            readRow2W208( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound208 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().removeElement(nGXsfl_208_idx);
               nGXsfl_208_idx = (int)(nGXsfl_208_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey2W208( ) ;
               VarsToRow208( ((web.Sdtconvenio_adicional_importes)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().elementAt(-1+nGXsfl_208_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2W208( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_208 = (short)(0) ;
      nIsMod_208 = (short)(0) ;
      Gxremove208 = (byte)(0) ;
   }

   public void processNestedLevel2W209( )
   {
      nGXsfl_209_idx = 0 ;
      while ( nGXsfl_209_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().size() )
      {
         readRow2W209( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound209 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_209 != 0 ) )
         {
            standaloneNotModal2W209( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert2W209( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete2W209( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update2W209( ) ;
               }
            }
         }
         KeyVarsToRow209( ((web.Sdtconvenio_adicional_alicuotas)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().elementAt(-1+nGXsfl_209_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_209_idx = 0 ;
         while ( nGXsfl_209_idx < bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().size() )
         {
            readRow2W209( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound209 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().removeElement(nGXsfl_209_idx);
               nGXsfl_209_idx = (int)(nGXsfl_209_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey2W209( ) ;
               VarsToRow209( ((web.Sdtconvenio_adicional_alicuotas)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().elementAt(-1+nGXsfl_209_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2W209( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_209 = (short)(0) ;
      nIsMod_209 = (short)(0) ;
      Gxremove209 = (byte)(0) ;
   }

   public void processLevel2W207( )
   {
      /* Save parent mode. */
      sMode207 = Gx_mode ;
      processNestedLevel2W245( ) ;
      processNestedLevel2W208( ) ;
      processNestedLevel2W209( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode207 ;
      /* ' Update level parameters */
   }

   public void endLevel2W207( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(14);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2W207( ) ;
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

   public void scanKeyStart2W207( )
   {
      /* Scan By routine */
      /* Using cursor BC002W20 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      RcdFound207 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound207 = (short)(1) ;
         A996ConveAdicod = BC002W20_A996ConveAdicod[0] ;
         A997ConveAdiDescri = BC002W20_A997ConveAdiDescri[0] ;
         A998ConveAdiAli = BC002W20_A998ConveAdiAli[0] ;
         A1019ConveAdiInfo = BC002W20_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = BC002W20_n1019ConveAdiInfo[0] ;
         A1803ConveAdiTipo = BC002W20_A1803ConveAdiTipo[0] ;
         A1901ConveAdiRelSec = BC002W20_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = BC002W20_n1901ConveAdiRelSec[0] ;
         A2046ConveAdiRelRef = BC002W20_A2046ConveAdiRelRef[0] ;
         A2047ConveAdiOld = BC002W20_A2047ConveAdiOld[0] ;
         A3CliCod = BC002W20_A3CliCod[0] ;
         A1564CliPaiConve = BC002W20_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC002W20_A1565CliConvenio[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2W207( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound207 = (short)(0) ;
      scanKeyLoad2W207( ) ;
   }

   public void scanKeyLoad2W207( )
   {
      sMode207 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound207 = (short)(1) ;
         A996ConveAdicod = BC002W20_A996ConveAdicod[0] ;
         A997ConveAdiDescri = BC002W20_A997ConveAdiDescri[0] ;
         A998ConveAdiAli = BC002W20_A998ConveAdiAli[0] ;
         A1019ConveAdiInfo = BC002W20_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = BC002W20_n1019ConveAdiInfo[0] ;
         A1803ConveAdiTipo = BC002W20_A1803ConveAdiTipo[0] ;
         A1901ConveAdiRelSec = BC002W20_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = BC002W20_n1901ConveAdiRelSec[0] ;
         A2046ConveAdiRelRef = BC002W20_A2046ConveAdiRelRef[0] ;
         A2047ConveAdiOld = BC002W20_A2047ConveAdiOld[0] ;
         A3CliCod = BC002W20_A3CliCod[0] ;
         A1564CliPaiConve = BC002W20_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC002W20_A1565CliConvenio[0] ;
      }
      Gx_mode = sMode207 ;
   }

   public void scanKeyEnd2W207( )
   {
      pr_default.close(18);
   }

   public void afterConfirm2W207( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2W207( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2W207( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2W207( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2W207( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2W207( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2W207( )
   {
   }

   public void zm2W245( int GX_JID )
   {
      if ( ( GX_JID == 6 ) || ( GX_JID == 0 ) )
      {
         Z1898ConveAdiSitCanRelSec = A1898ConveAdiSitCanRelSec ;
      }
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z1825ConveAdiSitCancDes = A1825ConveAdiSitCancDes ;
      }
      if ( GX_JID == -6 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1898ConveAdiSitCanRelSec = A1898ConveAdiSitCanRelSec ;
         Z1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1825ConveAdiSitCancDes = A1825ConveAdiSitCancDes ;
      }
   }

   public void standaloneNotModal2W245( )
   {
   }

   public void standaloneModal2W245( )
   {
   }

   public void load2W245( )
   {
      /* Using cursor BC002W21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A1825ConveAdiSitCancDes = BC002W21_A1825ConveAdiSitCancDes[0] ;
         A1898ConveAdiSitCanRelSec = BC002W21_A1898ConveAdiSitCanRelSec[0] ;
         zm2W245( -6) ;
      }
      pr_default.close(19);
      onLoadActions2W245( ) ;
   }

   public void onLoadActions2W245( )
   {
   }

   public void checkExtendedTable2W245( )
   {
      nIsDirty_245 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal2W245( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC002W22 */
      pr_default.execute(20, new Object[] {A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Adi No Adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADISITCANCELA");
         AnyError = (short)(1) ;
      }
      A1825ConveAdiSitCancDes = BC002W22_A1825ConveAdiSitCancDes[0] ;
      pr_default.close(20);
   }

   public void closeExtendedTableCursors2W245( )
   {
      pr_default.close(20);
   }

   public void enableDisable2W245( )
   {
   }

   public void getKey2W245( )
   {
      /* Using cursor BC002W23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound245 = (short)(1) ;
      }
      else
      {
         RcdFound245 = (short)(0) ;
      }
      pr_default.close(21);
   }

   public void getByPrimaryKey2W245( )
   {
      /* Using cursor BC002W24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(22) != 101) )
      {
         zm2W245( 6) ;
         RcdFound245 = (short)(1) ;
         initializeNonKey2W245( ) ;
         A1898ConveAdiSitCanRelSec = BC002W24_A1898ConveAdiSitCanRelSec[0] ;
         A1824ConveAdiSitCancela = BC002W24_A1824ConveAdiSitCancela[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
         sMode245 = Gx_mode ;
         Gx_mode = "DSP" ;
         load2W245( ) ;
         Gx_mode = sMode245 ;
      }
      else
      {
         RcdFound245 = (short)(0) ;
         initializeNonKey2W245( ) ;
         sMode245 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal2W245( ) ;
         Gx_mode = sMode245 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2W245( ) ;
      }
      pr_default.close(22);
   }

   public void checkOptimisticConcurrency2W245( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002W25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
         if ( (pr_default.getStatus(23) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalCancela"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(23) == 101) || ( Z1898ConveAdiSitCanRelSec != BC002W25_A1898ConveAdiSitCanRelSec[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicionalCancela"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2W245( )
   {
      beforeValidate2W245( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W245( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2W245( 0) ;
         checkOptimisticConcurrency2W245( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W245( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2W245( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W26 */
                  pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A996ConveAdicod, Integer.valueOf(A1898ConveAdiSitCanRelSec), A1824ConveAdiSitCancela, Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
                  if ( (pr_default.getStatus(24) == 1) )
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
            load2W245( ) ;
         }
         endLevel2W245( ) ;
      }
      closeExtendedTableCursors2W245( ) ;
   }

   public void update2W245( )
   {
      beforeValidate2W245( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W245( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W245( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W245( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2W245( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W27 */
                  pr_default.execute(25, new Object[] {Integer.valueOf(A1898ConveAdiSitCanRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
                  if ( (pr_default.getStatus(25) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalCancela"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2W245( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey2W245( ) ;
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
         endLevel2W245( ) ;
      }
      closeExtendedTableCursors2W245( ) ;
   }

   public void deferredUpdate2W245( )
   {
   }

   public void delete2W245( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2W245( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W245( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2W245( ) ;
         afterConfirm2W245( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2W245( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002W28 */
               pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode245 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2W245( ) ;
      Gx_mode = sMode245 ;
   }

   public void onDeleteControls2W245( )
   {
      standaloneModal2W245( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC002W29 */
         pr_default.execute(27, new Object[] {A1824ConveAdiSitCancela});
         A1825ConveAdiSitCancDes = BC002W29_A1825ConveAdiSitCancDes[0] ;
         pr_default.close(27);
      }
   }

   public void endLevel2W245( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(23);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart2W245( )
   {
      /* Scan By routine */
      /* Using cursor BC002W30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      RcdFound245 = (short)(0) ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A1825ConveAdiSitCancDes = BC002W30_A1825ConveAdiSitCancDes[0] ;
         A1898ConveAdiSitCanRelSec = BC002W30_A1898ConveAdiSitCanRelSec[0] ;
         A1824ConveAdiSitCancela = BC002W30_A1824ConveAdiSitCancela[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2W245( )
   {
      /* Scan next routine */
      pr_default.readNext(28);
      RcdFound245 = (short)(0) ;
      scanKeyLoad2W245( ) ;
   }

   public void scanKeyLoad2W245( )
   {
      sMode245 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A1825ConveAdiSitCancDes = BC002W30_A1825ConveAdiSitCancDes[0] ;
         A1898ConveAdiSitCanRelSec = BC002W30_A1898ConveAdiSitCanRelSec[0] ;
         A1824ConveAdiSitCancela = BC002W30_A1824ConveAdiSitCancela[0] ;
      }
      Gx_mode = sMode245 ;
   }

   public void scanKeyEnd2W245( )
   {
      pr_default.close(28);
   }

   public void afterConfirm2W245( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2W245( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2W245( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2W245( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2W245( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2W245( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2W245( )
   {
   }

   public void send_integrity_lvl_hashes2W245( )
   {
   }

   public void zm2W208( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z1000ConveAdiImporte = A1000ConveAdiImporte ;
         Z1899ConveAdiImpRelSec = A1899ConveAdiImpRelSec ;
      }
      if ( GX_JID == -8 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z999ConveAdiVig = A999ConveAdiVig ;
         Z1000ConveAdiImporte = A1000ConveAdiImporte ;
         Z1899ConveAdiImpRelSec = A1899ConveAdiImpRelSec ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal2W208( )
   {
   }

   public void standaloneModal2W208( )
   {
   }

   public void load2W208( )
   {
      /* Using cursor BC002W31 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A1000ConveAdiImporte = BC002W31_A1000ConveAdiImporte[0] ;
         A1899ConveAdiImpRelSec = BC002W31_A1899ConveAdiImpRelSec[0] ;
         zm2W208( -8) ;
      }
      pr_default.close(29);
      onLoadActions2W208( ) ;
   }

   public void onLoadActions2W208( )
   {
   }

   public void checkExtendedTable2W208( )
   {
      nIsDirty_208 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal2W208( ) ;
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors2W208( )
   {
   }

   public void enableDisable2W208( )
   {
   }

   public void getKey2W208( )
   {
      /* Using cursor BC002W32 */
      pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound208 = (short)(1) ;
      }
      else
      {
         RcdFound208 = (short)(0) ;
      }
      pr_default.close(30);
   }

   public void getByPrimaryKey2W208( )
   {
      /* Using cursor BC002W33 */
      pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(31) != 101) )
      {
         zm2W208( 8) ;
         RcdFound208 = (short)(1) ;
         initializeNonKey2W208( ) ;
         A999ConveAdiVig = BC002W33_A999ConveAdiVig[0] ;
         A1000ConveAdiImporte = BC002W33_A1000ConveAdiImporte[0] ;
         A1899ConveAdiImpRelSec = BC002W33_A1899ConveAdiImpRelSec[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z999ConveAdiVig = A999ConveAdiVig ;
         sMode208 = Gx_mode ;
         Gx_mode = "DSP" ;
         load2W208( ) ;
         Gx_mode = sMode208 ;
      }
      else
      {
         RcdFound208 = (short)(0) ;
         initializeNonKey2W208( ) ;
         sMode208 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal2W208( ) ;
         Gx_mode = sMode208 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2W208( ) ;
      }
      pr_default.close(31);
   }

   public void checkOptimisticConcurrency2W208( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002W34 */
         pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
         if ( (pr_default.getStatus(32) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalimportes"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(32) == 101) || ( DecimalUtil.compareTo(Z1000ConveAdiImporte, BC002W34_A1000ConveAdiImporte[0]) != 0 ) || ( Z1899ConveAdiImpRelSec != BC002W34_A1899ConveAdiImpRelSec[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicionalimportes"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2W208( )
   {
      beforeValidate2W208( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W208( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2W208( 0) ;
         checkOptimisticConcurrency2W208( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W208( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2W208( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W35 */
                  pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig, A1000ConveAdiImporte, Integer.valueOf(A1899ConveAdiImpRelSec), Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
                  if ( (pr_default.getStatus(33) == 1) )
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
            load2W208( ) ;
         }
         endLevel2W208( ) ;
      }
      closeExtendedTableCursors2W208( ) ;
   }

   public void update2W208( )
   {
      beforeValidate2W208( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W208( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W208( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W208( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2W208( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W36 */
                  pr_default.execute(34, new Object[] {A1000ConveAdiImporte, Integer.valueOf(A1899ConveAdiImpRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
                  if ( (pr_default.getStatus(34) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalimportes"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2W208( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey2W208( ) ;
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
         endLevel2W208( ) ;
      }
      closeExtendedTableCursors2W208( ) ;
   }

   public void deferredUpdate2W208( )
   {
   }

   public void delete2W208( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2W208( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W208( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2W208( ) ;
         afterConfirm2W208( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2W208( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002W37 */
               pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode208 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2W208( ) ;
      Gx_mode = sMode208 ;
   }

   public void onDeleteControls2W208( )
   {
      standaloneModal2W208( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2W208( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(32);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart2W208( )
   {
      /* Scan By routine */
      /* Using cursor BC002W38 */
      pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      RcdFound208 = (short)(0) ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A999ConveAdiVig = BC002W38_A999ConveAdiVig[0] ;
         A1000ConveAdiImporte = BC002W38_A1000ConveAdiImporte[0] ;
         A1899ConveAdiImpRelSec = BC002W38_A1899ConveAdiImpRelSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2W208( )
   {
      /* Scan next routine */
      pr_default.readNext(36);
      RcdFound208 = (short)(0) ;
      scanKeyLoad2W208( ) ;
   }

   public void scanKeyLoad2W208( )
   {
      sMode208 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(36) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A999ConveAdiVig = BC002W38_A999ConveAdiVig[0] ;
         A1000ConveAdiImporte = BC002W38_A1000ConveAdiImporte[0] ;
         A1899ConveAdiImpRelSec = BC002W38_A1899ConveAdiImpRelSec[0] ;
      }
      Gx_mode = sMode208 ;
   }

   public void scanKeyEnd2W208( )
   {
      pr_default.close(36);
   }

   public void afterConfirm2W208( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2W208( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2W208( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2W208( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2W208( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2W208( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2W208( )
   {
   }

   public void send_integrity_lvl_hashes2W208( )
   {
   }

   public void zm2W209( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         Z1021ConveAdiOpcFor = A1021ConveAdiOpcFor ;
         Z1012ConveAdiOpcDes = A1012ConveAdiOpcDes ;
         Z1013ConveAdiOpcAli = A1013ConveAdiOpcAli ;
         Z1900ConveAdiOpcRelSec = A1900ConveAdiOpcRelSec ;
      }
      if ( GX_JID == -9 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1011ConveAdiOpcCod = A1011ConveAdiOpcCod ;
         Z1021ConveAdiOpcFor = A1021ConveAdiOpcFor ;
         Z1012ConveAdiOpcDes = A1012ConveAdiOpcDes ;
         Z1013ConveAdiOpcAli = A1013ConveAdiOpcAli ;
         Z1900ConveAdiOpcRelSec = A1900ConveAdiOpcRelSec ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal2W209( )
   {
   }

   public void standaloneModal2W209( )
   {
   }

   public void load2W209( )
   {
      /* Using cursor BC002W39 */
      pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
      if ( (pr_default.getStatus(37) != 101) )
      {
         RcdFound209 = (short)(1) ;
         A1021ConveAdiOpcFor = BC002W39_A1021ConveAdiOpcFor[0] ;
         A1012ConveAdiOpcDes = BC002W39_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = BC002W39_A1013ConveAdiOpcAli[0] ;
         A1900ConveAdiOpcRelSec = BC002W39_A1900ConveAdiOpcRelSec[0] ;
         zm2W209( -9) ;
      }
      pr_default.close(37);
      onLoadActions2W209( ) ;
   }

   public void onLoadActions2W209( )
   {
   }

   public void checkExtendedTable2W209( )
   {
      nIsDirty_209 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal2W209( ) ;
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors2W209( )
   {
   }

   public void enableDisable2W209( )
   {
   }

   public void getKey2W209( )
   {
      /* Using cursor BC002W40 */
      pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
      if ( (pr_default.getStatus(38) != 101) )
      {
         RcdFound209 = (short)(1) ;
      }
      else
      {
         RcdFound209 = (short)(0) ;
      }
      pr_default.close(38);
   }

   public void getByPrimaryKey2W209( )
   {
      /* Using cursor BC002W41 */
      pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
      if ( (pr_default.getStatus(39) != 101) )
      {
         zm2W209( 9) ;
         RcdFound209 = (short)(1) ;
         initializeNonKey2W209( ) ;
         A1011ConveAdiOpcCod = BC002W41_A1011ConveAdiOpcCod[0] ;
         A1021ConveAdiOpcFor = BC002W41_A1021ConveAdiOpcFor[0] ;
         A1012ConveAdiOpcDes = BC002W41_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = BC002W41_A1013ConveAdiOpcAli[0] ;
         A1900ConveAdiOpcRelSec = BC002W41_A1900ConveAdiOpcRelSec[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1011ConveAdiOpcCod = A1011ConveAdiOpcCod ;
         sMode209 = Gx_mode ;
         Gx_mode = "DSP" ;
         load2W209( ) ;
         Gx_mode = sMode209 ;
      }
      else
      {
         RcdFound209 = (short)(0) ;
         initializeNonKey2W209( ) ;
         sMode209 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal2W209( ) ;
         Gx_mode = sMode209 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2W209( ) ;
      }
      pr_default.close(39);
   }

   public void checkOptimisticConcurrency2W209( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC002W42 */
         pr_default.execute(40, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
         if ( (pr_default.getStatus(40) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalalicuotas"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(40) == 101) || ( GXutil.strcmp(Z1021ConveAdiOpcFor, BC002W42_A1021ConveAdiOpcFor[0]) != 0 ) || ( GXutil.strcmp(Z1012ConveAdiOpcDes, BC002W42_A1012ConveAdiOpcDes[0]) != 0 ) || ( DecimalUtil.compareTo(Z1013ConveAdiOpcAli, BC002W42_A1013ConveAdiOpcAli[0]) != 0 ) || ( Z1900ConveAdiOpcRelSec != BC002W42_A1900ConveAdiOpcRelSec[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicionalalicuotas"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2W209( )
   {
      beforeValidate2W209( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W209( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2W209( 0) ;
         checkOptimisticConcurrency2W209( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W209( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2W209( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W43 */
                  pr_default.execute(41, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod), A1021ConveAdiOpcFor, A1012ConveAdiOpcDes, A1013ConveAdiOpcAli, Integer.valueOf(A1900ConveAdiOpcRelSec), Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalalicuotas");
                  if ( (pr_default.getStatus(41) == 1) )
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
            load2W209( ) ;
         }
         endLevel2W209( ) ;
      }
      closeExtendedTableCursors2W209( ) ;
   }

   public void update2W209( )
   {
      beforeValidate2W209( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W209( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W209( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W209( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2W209( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002W44 */
                  pr_default.execute(42, new Object[] {A1021ConveAdiOpcFor, A1012ConveAdiOpcDes, A1013ConveAdiOpcAli, Integer.valueOf(A1900ConveAdiOpcRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalalicuotas");
                  if ( (pr_default.getStatus(42) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalalicuotas"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2W209( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey2W209( ) ;
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
         endLevel2W209( ) ;
      }
      closeExtendedTableCursors2W209( ) ;
   }

   public void deferredUpdate2W209( )
   {
   }

   public void delete2W209( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2W209( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W209( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2W209( ) ;
         afterConfirm2W209( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2W209( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002W45 */
               pr_default.execute(43, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalalicuotas");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode209 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2W209( ) ;
      Gx_mode = sMode209 ;
   }

   public void onDeleteControls2W209( )
   {
      standaloneModal2W209( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel2W209( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(40);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart2W209( )
   {
      /* Scan By routine */
      /* Using cursor BC002W46 */
      pr_default.execute(44, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      RcdFound209 = (short)(0) ;
      if ( (pr_default.getStatus(44) != 101) )
      {
         RcdFound209 = (short)(1) ;
         A1011ConveAdiOpcCod = BC002W46_A1011ConveAdiOpcCod[0] ;
         A1021ConveAdiOpcFor = BC002W46_A1021ConveAdiOpcFor[0] ;
         A1012ConveAdiOpcDes = BC002W46_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = BC002W46_A1013ConveAdiOpcAli[0] ;
         A1900ConveAdiOpcRelSec = BC002W46_A1900ConveAdiOpcRelSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2W209( )
   {
      /* Scan next routine */
      pr_default.readNext(44);
      RcdFound209 = (short)(0) ;
      scanKeyLoad2W209( ) ;
   }

   public void scanKeyLoad2W209( )
   {
      sMode209 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(44) != 101) )
      {
         RcdFound209 = (short)(1) ;
         A1011ConveAdiOpcCod = BC002W46_A1011ConveAdiOpcCod[0] ;
         A1021ConveAdiOpcFor = BC002W46_A1021ConveAdiOpcFor[0] ;
         A1012ConveAdiOpcDes = BC002W46_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = BC002W46_A1013ConveAdiOpcAli[0] ;
         A1900ConveAdiOpcRelSec = BC002W46_A1900ConveAdiOpcRelSec[0] ;
      }
      Gx_mode = sMode209 ;
   }

   public void scanKeyEnd2W209( )
   {
      pr_default.close(44);
   }

   public void afterConfirm2W209( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2W209( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2W209( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2W209( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2W209( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2W209( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2W209( )
   {
   }

   public void send_integrity_lvl_hashes2W209( )
   {
   }

   public void send_integrity_lvl_hashes2W207( )
   {
   }

   public void addRow2W207( )
   {
      VarsToRow207( bcconvenio_adicional) ;
   }

   public void readRow2W207( )
   {
      RowToVars207( bcconvenio_adicional, 1) ;
   }

   public void addRow2W245( )
   {
      web.Sdtconvenio_adicional_Cancela obj245;
      obj245 = new web.Sdtconvenio_adicional_Cancela(remoteHandle);
      VarsToRow245( obj245) ;
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().add(obj245, 0);
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Mode( "UPD" );
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Modified( (short)(0) );
   }

   public void readRow2W245( )
   {
      nGXsfl_245_idx = (int)(nGXsfl_245_idx+1) ;
      RowToVars245( ((web.Sdtconvenio_adicional_Cancela)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().elementAt(-1+nGXsfl_245_idx)), 1) ;
   }

   public void addRow2W208( )
   {
      web.Sdtconvenio_adicional_importes obj208;
      obj208 = new web.Sdtconvenio_adicional_importes(remoteHandle);
      VarsToRow208( obj208) ;
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().add(obj208, 0);
      obj208.setgxTv_Sdtconvenio_adicional_importes_Mode( "UPD" );
      obj208.setgxTv_Sdtconvenio_adicional_importes_Modified( (short)(0) );
   }

   public void readRow2W208( )
   {
      nGXsfl_208_idx = (int)(nGXsfl_208_idx+1) ;
      RowToVars208( ((web.Sdtconvenio_adicional_importes)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().elementAt(-1+nGXsfl_208_idx)), 1) ;
   }

   public void addRow2W209( )
   {
      web.Sdtconvenio_adicional_alicuotas obj209;
      obj209 = new web.Sdtconvenio_adicional_alicuotas(remoteHandle);
      VarsToRow209( obj209) ;
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().add(obj209, 0);
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Mode( "UPD" );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Modified( (short)(0) );
   }

   public void readRow2W209( )
   {
      nGXsfl_209_idx = (int)(nGXsfl_209_idx+1) ;
      RowToVars209( ((web.Sdtconvenio_adicional_alicuotas)bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().elementAt(-1+nGXsfl_209_idx)), 1) ;
   }

   public void initializeNonKey2W207( )
   {
      A997ConveAdiDescri = "" ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      A1019ConveAdiInfo = "" ;
      n1019ConveAdiInfo = false ;
      A1901ConveAdiRelSec = 0 ;
      n1901ConveAdiRelSec = false ;
      A2046ConveAdiRelRef = "" ;
      A2047ConveAdiOld = "" ;
      A1803ConveAdiTipo = "otros" ;
      Z997ConveAdiDescri = "" ;
      Z998ConveAdiAli = DecimalUtil.ZERO ;
      Z1803ConveAdiTipo = "" ;
      Z1901ConveAdiRelSec = 0 ;
      Z2046ConveAdiRelRef = "" ;
   }

   public void initAll2W207( )
   {
      A3CliCod = 0 ;
      A1564CliPaiConve = (short)(0) ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      initializeNonKey2W207( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1803ConveAdiTipo = i1803ConveAdiTipo ;
   }

   public void initializeNonKey2W245( )
   {
      A1825ConveAdiSitCancDes = "" ;
      A1898ConveAdiSitCanRelSec = 0 ;
      Z1898ConveAdiSitCanRelSec = 0 ;
   }

   public void initAll2W245( )
   {
      A1824ConveAdiSitCancela = "" ;
      initializeNonKey2W245( ) ;
   }

   public void standaloneModalInsert2W245( )
   {
   }

   public void initializeNonKey2W208( )
   {
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      A1899ConveAdiImpRelSec = 0 ;
      Z1000ConveAdiImporte = DecimalUtil.ZERO ;
      Z1899ConveAdiImpRelSec = 0 ;
   }

   public void initAll2W208( )
   {
      A999ConveAdiVig = GXutil.nullDate() ;
      initializeNonKey2W208( ) ;
   }

   public void standaloneModalInsert2W208( )
   {
   }

   public void initializeNonKey2W209( )
   {
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      A1900ConveAdiOpcRelSec = 0 ;
      Z1021ConveAdiOpcFor = "" ;
      Z1012ConveAdiOpcDes = "" ;
      Z1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      Z1900ConveAdiOpcRelSec = 0 ;
   }

   public void initAll2W209( )
   {
      A1011ConveAdiOpcCod = (short)(0) ;
      initializeNonKey2W209( ) ;
   }

   public void standaloneModalInsert2W209( )
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

   public void VarsToRow207( web.Sdtconvenio_adicional obj207 )
   {
      obj207.setgxTv_Sdtconvenio_adicional_Mode( Gx_mode );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadidescri( A997ConveAdiDescri );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadiali( A998ConveAdiAli );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadiinfo( A1019ConveAdiInfo );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadirelsec( A1901ConveAdiRelSec );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadirelref( A2046ConveAdiRelRef );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadiold( A2047ConveAdiOld );
      obj207.setgxTv_Sdtconvenio_adicional_Conveaditipo( A1803ConveAdiTipo );
      obj207.setgxTv_Sdtconvenio_adicional_Clicod( A3CliCod );
      obj207.setgxTv_Sdtconvenio_adicional_Clipaiconve( A1564CliPaiConve );
      obj207.setgxTv_Sdtconvenio_adicional_Cliconvenio( A1565CliConvenio );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadicod( A996ConveAdicod );
      obj207.setgxTv_Sdtconvenio_adicional_Clicod_Z( Z3CliCod );
      obj207.setgxTv_Sdtconvenio_adicional_Clipaiconve_Z( Z1564CliPaiConve );
      obj207.setgxTv_Sdtconvenio_adicional_Cliconvenio_Z( Z1565CliConvenio );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadicod_Z( Z996ConveAdicod );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadidescri_Z( Z997ConveAdiDescri );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadiali_Z( Z998ConveAdiAli );
      obj207.setgxTv_Sdtconvenio_adicional_Conveaditipo_Z( Z1803ConveAdiTipo );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadirelsec_Z( Z1901ConveAdiRelSec );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadirelref_Z( Z2046ConveAdiRelRef );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadiinfo_N( (byte)((byte)((n1019ConveAdiInfo)?1:0)) );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadirelsec_N( (byte)((byte)((n1901ConveAdiRelSec)?1:0)) );
      obj207.setgxTv_Sdtconvenio_adicional_Mode( Gx_mode );
   }

   public void KeyVarsToRow207( web.Sdtconvenio_adicional obj207 )
   {
      obj207.setgxTv_Sdtconvenio_adicional_Clicod( A3CliCod );
      obj207.setgxTv_Sdtconvenio_adicional_Clipaiconve( A1564CliPaiConve );
      obj207.setgxTv_Sdtconvenio_adicional_Cliconvenio( A1565CliConvenio );
      obj207.setgxTv_Sdtconvenio_adicional_Conveadicod( A996ConveAdicod );
   }

   public void RowToVars207( web.Sdtconvenio_adicional obj207 ,
                             int forceLoad )
   {
      Gx_mode = obj207.getgxTv_Sdtconvenio_adicional_Mode() ;
      A997ConveAdiDescri = obj207.getgxTv_Sdtconvenio_adicional_Conveadidescri() ;
      A998ConveAdiAli = obj207.getgxTv_Sdtconvenio_adicional_Conveadiali() ;
      A1019ConveAdiInfo = obj207.getgxTv_Sdtconvenio_adicional_Conveadiinfo() ;
      n1019ConveAdiInfo = false ;
      A1901ConveAdiRelSec = obj207.getgxTv_Sdtconvenio_adicional_Conveadirelsec() ;
      n1901ConveAdiRelSec = false ;
      A2046ConveAdiRelRef = obj207.getgxTv_Sdtconvenio_adicional_Conveadirelref() ;
      A2047ConveAdiOld = obj207.getgxTv_Sdtconvenio_adicional_Conveadiold() ;
      A1803ConveAdiTipo = obj207.getgxTv_Sdtconvenio_adicional_Conveaditipo() ;
      A3CliCod = obj207.getgxTv_Sdtconvenio_adicional_Clicod() ;
      A1564CliPaiConve = obj207.getgxTv_Sdtconvenio_adicional_Clipaiconve() ;
      A1565CliConvenio = obj207.getgxTv_Sdtconvenio_adicional_Cliconvenio() ;
      A996ConveAdicod = obj207.getgxTv_Sdtconvenio_adicional_Conveadicod() ;
      Z3CliCod = obj207.getgxTv_Sdtconvenio_adicional_Clicod_Z() ;
      Z1564CliPaiConve = obj207.getgxTv_Sdtconvenio_adicional_Clipaiconve_Z() ;
      Z1565CliConvenio = obj207.getgxTv_Sdtconvenio_adicional_Cliconvenio_Z() ;
      Z996ConveAdicod = obj207.getgxTv_Sdtconvenio_adicional_Conveadicod_Z() ;
      Z997ConveAdiDescri = obj207.getgxTv_Sdtconvenio_adicional_Conveadidescri_Z() ;
      Z998ConveAdiAli = obj207.getgxTv_Sdtconvenio_adicional_Conveadiali_Z() ;
      Z1803ConveAdiTipo = obj207.getgxTv_Sdtconvenio_adicional_Conveaditipo_Z() ;
      Z1901ConveAdiRelSec = obj207.getgxTv_Sdtconvenio_adicional_Conveadirelsec_Z() ;
      Z2046ConveAdiRelRef = obj207.getgxTv_Sdtconvenio_adicional_Conveadirelref_Z() ;
      n1019ConveAdiInfo = (boolean)((obj207.getgxTv_Sdtconvenio_adicional_Conveadiinfo_N()==0)?false:true) ;
      n1901ConveAdiRelSec = (boolean)((obj207.getgxTv_Sdtconvenio_adicional_Conveadirelsec_N()==0)?false:true) ;
      Gx_mode = obj207.getgxTv_Sdtconvenio_adicional_Mode() ;
   }

   public void VarsToRow245( web.Sdtconvenio_adicional_Cancela obj245 )
   {
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Mode( Gx_mode );
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes( A1825ConveAdiSitCancDes );
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec( A1898ConveAdiSitCanRelSec );
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela( A1824ConveAdiSitCancela );
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z( Z1824ConveAdiSitCancela );
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z( Z1825ConveAdiSitCancDes );
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z( Z1898ConveAdiSitCanRelSec );
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Modified( nIsMod_245 );
   }

   public void KeyVarsToRow245( web.Sdtconvenio_adicional_Cancela obj245 )
   {
      obj245.setgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela( A1824ConveAdiSitCancela );
   }

   public void RowToVars245( web.Sdtconvenio_adicional_Cancela obj245 ,
                             int forceLoad )
   {
      Gx_mode = obj245.getgxTv_Sdtconvenio_adicional_Cancela_Mode() ;
      A1825ConveAdiSitCancDes = obj245.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes() ;
      A1898ConveAdiSitCanRelSec = obj245.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec() ;
      A1824ConveAdiSitCancela = obj245.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela() ;
      Z1824ConveAdiSitCancela = obj245.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancela_Z() ;
      Z1825ConveAdiSitCancDes = obj245.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcancdes_Z() ;
      Z1898ConveAdiSitCanRelSec = obj245.getgxTv_Sdtconvenio_adicional_Cancela_Conveadisitcanrelsec_Z() ;
      nIsMod_245 = obj245.getgxTv_Sdtconvenio_adicional_Cancela_Modified() ;
   }

   public void VarsToRow208( web.Sdtconvenio_adicional_importes obj208 )
   {
      obj208.setgxTv_Sdtconvenio_adicional_importes_Mode( Gx_mode );
      obj208.setgxTv_Sdtconvenio_adicional_importes_Conveadiimporte( A1000ConveAdiImporte );
      obj208.setgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec( A1899ConveAdiImpRelSec );
      obj208.setgxTv_Sdtconvenio_adicional_importes_Conveadivig( A999ConveAdiVig );
      obj208.setgxTv_Sdtconvenio_adicional_importes_Conveadivig_Z( Z999ConveAdiVig );
      obj208.setgxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z( Z1000ConveAdiImporte );
      obj208.setgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z( Z1899ConveAdiImpRelSec );
      obj208.setgxTv_Sdtconvenio_adicional_importes_Modified( nIsMod_208 );
   }

   public void KeyVarsToRow208( web.Sdtconvenio_adicional_importes obj208 )
   {
      obj208.setgxTv_Sdtconvenio_adicional_importes_Conveadivig( A999ConveAdiVig );
   }

   public void RowToVars208( web.Sdtconvenio_adicional_importes obj208 ,
                             int forceLoad )
   {
      Gx_mode = obj208.getgxTv_Sdtconvenio_adicional_importes_Mode() ;
      A1000ConveAdiImporte = obj208.getgxTv_Sdtconvenio_adicional_importes_Conveadiimporte() ;
      A1899ConveAdiImpRelSec = obj208.getgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec() ;
      A999ConveAdiVig = obj208.getgxTv_Sdtconvenio_adicional_importes_Conveadivig() ;
      Z999ConveAdiVig = obj208.getgxTv_Sdtconvenio_adicional_importes_Conveadivig_Z() ;
      Z1000ConveAdiImporte = obj208.getgxTv_Sdtconvenio_adicional_importes_Conveadiimporte_Z() ;
      Z1899ConveAdiImpRelSec = obj208.getgxTv_Sdtconvenio_adicional_importes_Conveadiimprelsec_Z() ;
      nIsMod_208 = obj208.getgxTv_Sdtconvenio_adicional_importes_Modified() ;
   }

   public void VarsToRow209( web.Sdtconvenio_adicional_alicuotas obj209 )
   {
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Mode( Gx_mode );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor( A1021ConveAdiOpcFor );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes( A1012ConveAdiOpcDes );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali( A1013ConveAdiOpcAli );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec( A1900ConveAdiOpcRelSec );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod( A1011ConveAdiOpcCod );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z( Z1011ConveAdiOpcCod );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z( Z1021ConveAdiOpcFor );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z( Z1012ConveAdiOpcDes );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z( Z1013ConveAdiOpcAli );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z( Z1900ConveAdiOpcRelSec );
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Modified( nIsMod_209 );
   }

   public void KeyVarsToRow209( web.Sdtconvenio_adicional_alicuotas obj209 )
   {
      obj209.setgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod( A1011ConveAdiOpcCod );
   }

   public void RowToVars209( web.Sdtconvenio_adicional_alicuotas obj209 ,
                             int forceLoad )
   {
      Gx_mode = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Mode() ;
      A1021ConveAdiOpcFor = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor() ;
      A1012ConveAdiOpcDes = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes() ;
      A1013ConveAdiOpcAli = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali() ;
      A1900ConveAdiOpcRelSec = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec() ;
      A1011ConveAdiOpcCod = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod() ;
      Z1011ConveAdiOpcCod = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopccod_Z() ;
      Z1021ConveAdiOpcFor = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcfor_Z() ;
      Z1012ConveAdiOpcDes = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcdes_Z() ;
      Z1013ConveAdiOpcAli = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcali_Z() ;
      Z1900ConveAdiOpcRelSec = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Conveadiopcrelsec_Z() ;
      nIsMod_209 = obj209.getgxTv_Sdtconvenio_adicional_alicuotas_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1564CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A1565CliConvenio = (String)getParm(obj,2) ;
      A996ConveAdicod = (String)getParm(obj,3) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey2W207( ) ;
      scanKeyStart2W207( ) ;
      if ( RcdFound207 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002W47 */
         pr_default.execute(45, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(45) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
            AnyError = (short)(1) ;
         }
         pr_default.close(45);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
      }
      zm2W207( -4) ;
      onLoadActions2W207( ) ;
      addRow2W207( ) ;
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().clearCollection();
      if ( RcdFound207 == 1 )
      {
         scanKeyStart2W245( ) ;
         nGXsfl_245_idx = 1 ;
         while ( RcdFound245 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z996ConveAdicod = A996ConveAdicod ;
            Z1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
            zm2W245( -6) ;
            onLoadActions2W245( ) ;
            nRcdExists_245 = (short)(1) ;
            nIsMod_245 = (short)(0) ;
            addRow2W245( ) ;
            nGXsfl_245_idx = (int)(nGXsfl_245_idx+1) ;
            scanKeyNext2W245( ) ;
         }
         scanKeyEnd2W245( ) ;
      }
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().clearCollection();
      if ( RcdFound207 == 1 )
      {
         scanKeyStart2W208( ) ;
         nGXsfl_208_idx = 1 ;
         while ( RcdFound208 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z996ConveAdicod = A996ConveAdicod ;
            Z999ConveAdiVig = A999ConveAdiVig ;
            zm2W208( -8) ;
            onLoadActions2W208( ) ;
            nRcdExists_208 = (short)(1) ;
            nIsMod_208 = (short)(0) ;
            addRow2W208( ) ;
            nGXsfl_208_idx = (int)(nGXsfl_208_idx+1) ;
            scanKeyNext2W208( ) ;
         }
         scanKeyEnd2W208( ) ;
      }
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().clearCollection();
      if ( RcdFound207 == 1 )
      {
         scanKeyStart2W209( ) ;
         nGXsfl_209_idx = 1 ;
         while ( RcdFound209 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z996ConveAdicod = A996ConveAdicod ;
            Z1011ConveAdiOpcCod = A1011ConveAdiOpcCod ;
            zm2W209( -9) ;
            onLoadActions2W209( ) ;
            nRcdExists_209 = (short)(1) ;
            nIsMod_209 = (short)(0) ;
            addRow2W209( ) ;
            nGXsfl_209_idx = (int)(nGXsfl_209_idx+1) ;
            scanKeyNext2W209( ) ;
         }
         scanKeyEnd2W209( ) ;
      }
      scanKeyEnd2W207( ) ;
      if ( RcdFound207 == 0 )
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
      RowToVars207( bcconvenio_adicional, 0) ;
      scanKeyStart2W207( ) ;
      if ( RcdFound207 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002W48 */
         pr_default.execute(46, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(46) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
            AnyError = (short)(1) ;
         }
         pr_default.close(46);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
      }
      zm2W207( -4) ;
      onLoadActions2W207( ) ;
      addRow2W207( ) ;
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Cancela().clearCollection();
      if ( RcdFound207 == 1 )
      {
         scanKeyStart2W245( ) ;
         nGXsfl_245_idx = 1 ;
         while ( RcdFound245 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z996ConveAdicod = A996ConveAdicod ;
            Z1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
            zm2W245( -6) ;
            onLoadActions2W245( ) ;
            nRcdExists_245 = (short)(1) ;
            nIsMod_245 = (short)(0) ;
            addRow2W245( ) ;
            nGXsfl_245_idx = (int)(nGXsfl_245_idx+1) ;
            scanKeyNext2W245( ) ;
         }
         scanKeyEnd2W245( ) ;
      }
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Importes().clearCollection();
      if ( RcdFound207 == 1 )
      {
         scanKeyStart2W208( ) ;
         nGXsfl_208_idx = 1 ;
         while ( RcdFound208 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z996ConveAdicod = A996ConveAdicod ;
            Z999ConveAdiVig = A999ConveAdiVig ;
            zm2W208( -8) ;
            onLoadActions2W208( ) ;
            nRcdExists_208 = (short)(1) ;
            nIsMod_208 = (short)(0) ;
            addRow2W208( ) ;
            nGXsfl_208_idx = (int)(nGXsfl_208_idx+1) ;
            scanKeyNext2W208( ) ;
         }
         scanKeyEnd2W208( ) ;
      }
      bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Alicuotas().clearCollection();
      if ( RcdFound207 == 1 )
      {
         scanKeyStart2W209( ) ;
         nGXsfl_209_idx = 1 ;
         while ( RcdFound209 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z996ConveAdicod = A996ConveAdicod ;
            Z1011ConveAdiOpcCod = A1011ConveAdiOpcCod ;
            zm2W209( -9) ;
            onLoadActions2W209( ) ;
            nRcdExists_209 = (short)(1) ;
            nIsMod_209 = (short)(0) ;
            addRow2W209( ) ;
            nGXsfl_209_idx = (int)(nGXsfl_209_idx+1) ;
            scanKeyNext2W209( ) ;
         }
         scanKeyEnd2W209( ) ;
      }
      scanKeyEnd2W207( ) ;
      if ( RcdFound207 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2W207( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert2W207( ) ;
      }
      else
      {
         if ( RcdFound207 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A1564CliPaiConve = Z1564CliPaiConve ;
               A1565CliConvenio = Z1565CliConvenio ;
               A996ConveAdicod = Z996ConveAdicod ;
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
               update2W207( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) )
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
                     insert2W207( ) ;
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
                     insert2W207( ) ;
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
      RowToVars207( bcconvenio_adicional, 1) ;
      saveImpl( ) ;
      VarsToRow207( bcconvenio_adicional) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars207( bcconvenio_adicional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2W207( ) ;
      afterTrn( ) ;
      VarsToRow207( bcconvenio_adicional) ;
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
         web.Sdtconvenio_adicional auxBC = new web.Sdtconvenio_adicional( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcconvenio_adicional);
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
      RowToVars207( bcconvenio_adicional, 1) ;
      updateImpl( ) ;
      VarsToRow207( bcconvenio_adicional) ;
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
      RowToVars207( bcconvenio_adicional, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2W207( ) ;
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
      VarsToRow207( bcconvenio_adicional) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars207( bcconvenio_adicional, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey2W207( ) ;
      if ( RcdFound207 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A1564CliPaiConve = Z1564CliPaiConve ;
            A1565CliConvenio = Z1565CliConvenio ;
            A996ConveAdicod = Z996ConveAdicod ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "convenio_adicional_bc");
      VarsToRow207( bcconvenio_adicional) ;
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
      Gx_mode = bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcconvenio_adicional.setgxTv_Sdtconvenio_adicional_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtconvenio_adicional sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcconvenio_adicional )
      {
         bcconvenio_adicional = sdt ;
         if ( GXutil.strcmp(bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Mode(), "") == 0 )
         {
            bcconvenio_adicional.setgxTv_Sdtconvenio_adicional_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow207( bcconvenio_adicional) ;
         }
         else
         {
            RowToVars207( bcconvenio_adicional, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcconvenio_adicional.getgxTv_Sdtconvenio_adicional_Mode(), "") == 0 )
         {
            bcconvenio_adicional.setgxTv_Sdtconvenio_adicional_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars207( bcconvenio_adicional, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtconvenio_adicional getconvenio_adicional_BC( )
   {
      return bcconvenio_adicional ;
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
      Z1565CliConvenio = "" ;
      A1565CliConvenio = "" ;
      Z996ConveAdicod = "" ;
      A996ConveAdicod = "" ;
      sMode207 = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV41Pgmname = "" ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      Z997ConveAdiDescri = "" ;
      A997ConveAdiDescri = "" ;
      Z998ConveAdiAli = DecimalUtil.ZERO ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      Z1803ConveAdiTipo = "" ;
      A1803ConveAdiTipo = "" ;
      Z2046ConveAdiRelRef = "" ;
      A2046ConveAdiRelRef = "" ;
      Z1019ConveAdiInfo = "" ;
      A1019ConveAdiInfo = "" ;
      Z2047ConveAdiOld = "" ;
      A2047ConveAdiOld = "" ;
      GXv_int5 = new int[1] ;
      BC002W12_A996ConveAdicod = new String[] {""} ;
      BC002W12_A997ConveAdiDescri = new String[] {""} ;
      BC002W12_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W12_A1019ConveAdiInfo = new String[] {""} ;
      BC002W12_n1019ConveAdiInfo = new boolean[] {false} ;
      BC002W12_A1803ConveAdiTipo = new String[] {""} ;
      BC002W12_A1901ConveAdiRelSec = new int[1] ;
      BC002W12_n1901ConveAdiRelSec = new boolean[] {false} ;
      BC002W12_A2046ConveAdiRelRef = new String[] {""} ;
      BC002W12_A2047ConveAdiOld = new String[] {""} ;
      BC002W12_A3CliCod = new int[1] ;
      BC002W12_A1564CliPaiConve = new short[1] ;
      BC002W12_A1565CliConvenio = new String[] {""} ;
      BC002W13_A3CliCod = new int[1] ;
      BC002W14_A3CliCod = new int[1] ;
      BC002W14_A1564CliPaiConve = new short[1] ;
      BC002W14_A1565CliConvenio = new String[] {""} ;
      BC002W14_A996ConveAdicod = new String[] {""} ;
      BC002W15_A996ConveAdicod = new String[] {""} ;
      BC002W15_A997ConveAdiDescri = new String[] {""} ;
      BC002W15_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W15_A1019ConveAdiInfo = new String[] {""} ;
      BC002W15_n1019ConveAdiInfo = new boolean[] {false} ;
      BC002W15_A1803ConveAdiTipo = new String[] {""} ;
      BC002W15_A1901ConveAdiRelSec = new int[1] ;
      BC002W15_n1901ConveAdiRelSec = new boolean[] {false} ;
      BC002W15_A2046ConveAdiRelRef = new String[] {""} ;
      BC002W15_A2047ConveAdiOld = new String[] {""} ;
      BC002W15_A3CliCod = new int[1] ;
      BC002W15_A1564CliPaiConve = new short[1] ;
      BC002W15_A1565CliConvenio = new String[] {""} ;
      BC002W16_A996ConveAdicod = new String[] {""} ;
      BC002W16_A997ConveAdiDescri = new String[] {""} ;
      BC002W16_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W16_A1019ConveAdiInfo = new String[] {""} ;
      BC002W16_n1019ConveAdiInfo = new boolean[] {false} ;
      BC002W16_A1803ConveAdiTipo = new String[] {""} ;
      BC002W16_A1901ConveAdiRelSec = new int[1] ;
      BC002W16_n1901ConveAdiRelSec = new boolean[] {false} ;
      BC002W16_A2046ConveAdiRelRef = new String[] {""} ;
      BC002W16_A2047ConveAdiOld = new String[] {""} ;
      BC002W16_A3CliCod = new int[1] ;
      BC002W16_A1564CliPaiConve = new short[1] ;
      BC002W16_A1565CliConvenio = new String[] {""} ;
      BC002W20_A996ConveAdicod = new String[] {""} ;
      BC002W20_A997ConveAdiDescri = new String[] {""} ;
      BC002W20_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W20_A1019ConveAdiInfo = new String[] {""} ;
      BC002W20_n1019ConveAdiInfo = new boolean[] {false} ;
      BC002W20_A1803ConveAdiTipo = new String[] {""} ;
      BC002W20_A1901ConveAdiRelSec = new int[1] ;
      BC002W20_n1901ConveAdiRelSec = new boolean[] {false} ;
      BC002W20_A2046ConveAdiRelRef = new String[] {""} ;
      BC002W20_A2047ConveAdiOld = new String[] {""} ;
      BC002W20_A3CliCod = new int[1] ;
      BC002W20_A1564CliPaiConve = new short[1] ;
      BC002W20_A1565CliConvenio = new String[] {""} ;
      Z1825ConveAdiSitCancDes = "" ;
      A1825ConveAdiSitCancDes = "" ;
      Z1824ConveAdiSitCancela = "" ;
      A1824ConveAdiSitCancela = "" ;
      BC002W21_A3CliCod = new int[1] ;
      BC002W21_A1565CliConvenio = new String[] {""} ;
      BC002W21_A996ConveAdicod = new String[] {""} ;
      BC002W21_A1825ConveAdiSitCancDes = new String[] {""} ;
      BC002W21_A1898ConveAdiSitCanRelSec = new int[1] ;
      BC002W21_A1824ConveAdiSitCancela = new String[] {""} ;
      BC002W21_A1564CliPaiConve = new short[1] ;
      BC002W22_A1825ConveAdiSitCancDes = new String[] {""} ;
      BC002W23_A3CliCod = new int[1] ;
      BC002W23_A1564CliPaiConve = new short[1] ;
      BC002W23_A1565CliConvenio = new String[] {""} ;
      BC002W23_A996ConveAdicod = new String[] {""} ;
      BC002W23_A1824ConveAdiSitCancela = new String[] {""} ;
      BC002W24_A3CliCod = new int[1] ;
      BC002W24_A1565CliConvenio = new String[] {""} ;
      BC002W24_A996ConveAdicod = new String[] {""} ;
      BC002W24_A1898ConveAdiSitCanRelSec = new int[1] ;
      BC002W24_A1824ConveAdiSitCancela = new String[] {""} ;
      BC002W24_A1564CliPaiConve = new short[1] ;
      sMode245 = "" ;
      BC002W25_A3CliCod = new int[1] ;
      BC002W25_A1565CliConvenio = new String[] {""} ;
      BC002W25_A996ConveAdicod = new String[] {""} ;
      BC002W25_A1898ConveAdiSitCanRelSec = new int[1] ;
      BC002W25_A1824ConveAdiSitCancela = new String[] {""} ;
      BC002W25_A1564CliPaiConve = new short[1] ;
      BC002W29_A1825ConveAdiSitCancDes = new String[] {""} ;
      BC002W30_A3CliCod = new int[1] ;
      BC002W30_A1565CliConvenio = new String[] {""} ;
      BC002W30_A996ConveAdicod = new String[] {""} ;
      BC002W30_A1825ConveAdiSitCancDes = new String[] {""} ;
      BC002W30_A1898ConveAdiSitCanRelSec = new int[1] ;
      BC002W30_A1824ConveAdiSitCancela = new String[] {""} ;
      BC002W30_A1564CliPaiConve = new short[1] ;
      Z1000ConveAdiImporte = DecimalUtil.ZERO ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      Z999ConveAdiVig = GXutil.nullDate() ;
      A999ConveAdiVig = GXutil.nullDate() ;
      BC002W31_A3CliCod = new int[1] ;
      BC002W31_A1565CliConvenio = new String[] {""} ;
      BC002W31_A996ConveAdicod = new String[] {""} ;
      BC002W31_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002W31_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W31_A1899ConveAdiImpRelSec = new int[1] ;
      BC002W31_A1564CliPaiConve = new short[1] ;
      BC002W32_A3CliCod = new int[1] ;
      BC002W32_A1564CliPaiConve = new short[1] ;
      BC002W32_A1565CliConvenio = new String[] {""} ;
      BC002W32_A996ConveAdicod = new String[] {""} ;
      BC002W32_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002W33_A3CliCod = new int[1] ;
      BC002W33_A1565CliConvenio = new String[] {""} ;
      BC002W33_A996ConveAdicod = new String[] {""} ;
      BC002W33_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002W33_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W33_A1899ConveAdiImpRelSec = new int[1] ;
      BC002W33_A1564CliPaiConve = new short[1] ;
      sMode208 = "" ;
      BC002W34_A3CliCod = new int[1] ;
      BC002W34_A1565CliConvenio = new String[] {""} ;
      BC002W34_A996ConveAdicod = new String[] {""} ;
      BC002W34_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002W34_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W34_A1899ConveAdiImpRelSec = new int[1] ;
      BC002W34_A1564CliPaiConve = new short[1] ;
      BC002W38_A3CliCod = new int[1] ;
      BC002W38_A1565CliConvenio = new String[] {""} ;
      BC002W38_A996ConveAdicod = new String[] {""} ;
      BC002W38_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      BC002W38_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W38_A1899ConveAdiImpRelSec = new int[1] ;
      BC002W38_A1564CliPaiConve = new short[1] ;
      Z1021ConveAdiOpcFor = "" ;
      A1021ConveAdiOpcFor = "" ;
      Z1012ConveAdiOpcDes = "" ;
      A1012ConveAdiOpcDes = "" ;
      Z1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      BC002W39_A3CliCod = new int[1] ;
      BC002W39_A1565CliConvenio = new String[] {""} ;
      BC002W39_A996ConveAdicod = new String[] {""} ;
      BC002W39_A1011ConveAdiOpcCod = new short[1] ;
      BC002W39_A1021ConveAdiOpcFor = new String[] {""} ;
      BC002W39_A1012ConveAdiOpcDes = new String[] {""} ;
      BC002W39_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W39_A1900ConveAdiOpcRelSec = new int[1] ;
      BC002W39_A1564CliPaiConve = new short[1] ;
      BC002W40_A3CliCod = new int[1] ;
      BC002W40_A1564CliPaiConve = new short[1] ;
      BC002W40_A1565CliConvenio = new String[] {""} ;
      BC002W40_A996ConveAdicod = new String[] {""} ;
      BC002W40_A1011ConveAdiOpcCod = new short[1] ;
      BC002W41_A3CliCod = new int[1] ;
      BC002W41_A1565CliConvenio = new String[] {""} ;
      BC002W41_A996ConveAdicod = new String[] {""} ;
      BC002W41_A1011ConveAdiOpcCod = new short[1] ;
      BC002W41_A1021ConveAdiOpcFor = new String[] {""} ;
      BC002W41_A1012ConveAdiOpcDes = new String[] {""} ;
      BC002W41_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W41_A1900ConveAdiOpcRelSec = new int[1] ;
      BC002W41_A1564CliPaiConve = new short[1] ;
      sMode209 = "" ;
      BC002W42_A3CliCod = new int[1] ;
      BC002W42_A1565CliConvenio = new String[] {""} ;
      BC002W42_A996ConveAdicod = new String[] {""} ;
      BC002W42_A1011ConveAdiOpcCod = new short[1] ;
      BC002W42_A1021ConveAdiOpcFor = new String[] {""} ;
      BC002W42_A1012ConveAdiOpcDes = new String[] {""} ;
      BC002W42_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W42_A1900ConveAdiOpcRelSec = new int[1] ;
      BC002W42_A1564CliPaiConve = new short[1] ;
      BC002W46_A3CliCod = new int[1] ;
      BC002W46_A1565CliConvenio = new String[] {""} ;
      BC002W46_A996ConveAdicod = new String[] {""} ;
      BC002W46_A1011ConveAdiOpcCod = new short[1] ;
      BC002W46_A1021ConveAdiOpcFor = new String[] {""} ;
      BC002W46_A1012ConveAdiOpcDes = new String[] {""} ;
      BC002W46_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC002W46_A1900ConveAdiOpcRelSec = new int[1] ;
      BC002W46_A1564CliPaiConve = new short[1] ;
      i1803ConveAdiTipo = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC002W47_A3CliCod = new int[1] ;
      BC002W48_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicional_bc__default(),
         new Object[] {
             new Object[] {
            BC002W2_A3CliCod, BC002W2_A1565CliConvenio, BC002W2_A996ConveAdicod, BC002W2_A1011ConveAdiOpcCod, BC002W2_A1021ConveAdiOpcFor, BC002W2_A1012ConveAdiOpcDes, BC002W2_A1013ConveAdiOpcAli, BC002W2_A1900ConveAdiOpcRelSec, BC002W2_A1564CliPaiConve
            }
            , new Object[] {
            BC002W3_A3CliCod, BC002W3_A1565CliConvenio, BC002W3_A996ConveAdicod, BC002W3_A1011ConveAdiOpcCod, BC002W3_A1021ConveAdiOpcFor, BC002W3_A1012ConveAdiOpcDes, BC002W3_A1013ConveAdiOpcAli, BC002W3_A1900ConveAdiOpcRelSec, BC002W3_A1564CliPaiConve
            }
            , new Object[] {
            BC002W4_A3CliCod, BC002W4_A1565CliConvenio, BC002W4_A996ConveAdicod, BC002W4_A999ConveAdiVig, BC002W4_A1000ConveAdiImporte, BC002W4_A1899ConveAdiImpRelSec, BC002W4_A1564CliPaiConve
            }
            , new Object[] {
            BC002W5_A3CliCod, BC002W5_A1565CliConvenio, BC002W5_A996ConveAdicod, BC002W5_A999ConveAdiVig, BC002W5_A1000ConveAdiImporte, BC002W5_A1899ConveAdiImpRelSec, BC002W5_A1564CliPaiConve
            }
            , new Object[] {
            BC002W6_A3CliCod, BC002W6_A1565CliConvenio, BC002W6_A996ConveAdicod, BC002W6_A1898ConveAdiSitCanRelSec, BC002W6_A1824ConveAdiSitCancela, BC002W6_A1564CliPaiConve
            }
            , new Object[] {
            BC002W7_A3CliCod, BC002W7_A1565CliConvenio, BC002W7_A996ConveAdicod, BC002W7_A1898ConveAdiSitCanRelSec, BC002W7_A1824ConveAdiSitCancela, BC002W7_A1564CliPaiConve
            }
            , new Object[] {
            BC002W8_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            BC002W9_A996ConveAdicod, BC002W9_A997ConveAdiDescri, BC002W9_A998ConveAdiAli, BC002W9_A1019ConveAdiInfo, BC002W9_n1019ConveAdiInfo, BC002W9_A1803ConveAdiTipo, BC002W9_A1901ConveAdiRelSec, BC002W9_n1901ConveAdiRelSec, BC002W9_A2046ConveAdiRelRef, BC002W9_A2047ConveAdiOld,
            BC002W9_A3CliCod, BC002W9_A1564CliPaiConve, BC002W9_A1565CliConvenio
            }
            , new Object[] {
            BC002W10_A996ConveAdicod, BC002W10_A997ConveAdiDescri, BC002W10_A998ConveAdiAli, BC002W10_A1019ConveAdiInfo, BC002W10_n1019ConveAdiInfo, BC002W10_A1803ConveAdiTipo, BC002W10_A1901ConveAdiRelSec, BC002W10_n1901ConveAdiRelSec, BC002W10_A2046ConveAdiRelRef, BC002W10_A2047ConveAdiOld,
            BC002W10_A3CliCod, BC002W10_A1564CliPaiConve, BC002W10_A1565CliConvenio
            }
            , new Object[] {
            BC002W11_A3CliCod
            }
            , new Object[] {
            BC002W12_A996ConveAdicod, BC002W12_A997ConveAdiDescri, BC002W12_A998ConveAdiAli, BC002W12_A1019ConveAdiInfo, BC002W12_n1019ConveAdiInfo, BC002W12_A1803ConveAdiTipo, BC002W12_A1901ConveAdiRelSec, BC002W12_n1901ConveAdiRelSec, BC002W12_A2046ConveAdiRelRef, BC002W12_A2047ConveAdiOld,
            BC002W12_A3CliCod, BC002W12_A1564CliPaiConve, BC002W12_A1565CliConvenio
            }
            , new Object[] {
            BC002W13_A3CliCod
            }
            , new Object[] {
            BC002W14_A3CliCod, BC002W14_A1564CliPaiConve, BC002W14_A1565CliConvenio, BC002W14_A996ConveAdicod
            }
            , new Object[] {
            BC002W15_A996ConveAdicod, BC002W15_A997ConveAdiDescri, BC002W15_A998ConveAdiAli, BC002W15_A1019ConveAdiInfo, BC002W15_n1019ConveAdiInfo, BC002W15_A1803ConveAdiTipo, BC002W15_A1901ConveAdiRelSec, BC002W15_n1901ConveAdiRelSec, BC002W15_A2046ConveAdiRelRef, BC002W15_A2047ConveAdiOld,
            BC002W15_A3CliCod, BC002W15_A1564CliPaiConve, BC002W15_A1565CliConvenio
            }
            , new Object[] {
            BC002W16_A996ConveAdicod, BC002W16_A997ConveAdiDescri, BC002W16_A998ConveAdiAli, BC002W16_A1019ConveAdiInfo, BC002W16_n1019ConveAdiInfo, BC002W16_A1803ConveAdiTipo, BC002W16_A1901ConveAdiRelSec, BC002W16_n1901ConveAdiRelSec, BC002W16_A2046ConveAdiRelRef, BC002W16_A2047ConveAdiOld,
            BC002W16_A3CliCod, BC002W16_A1564CliPaiConve, BC002W16_A1565CliConvenio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002W20_A996ConveAdicod, BC002W20_A997ConveAdiDescri, BC002W20_A998ConveAdiAli, BC002W20_A1019ConveAdiInfo, BC002W20_n1019ConveAdiInfo, BC002W20_A1803ConveAdiTipo, BC002W20_A1901ConveAdiRelSec, BC002W20_n1901ConveAdiRelSec, BC002W20_A2046ConveAdiRelRef, BC002W20_A2047ConveAdiOld,
            BC002W20_A3CliCod, BC002W20_A1564CliPaiConve, BC002W20_A1565CliConvenio
            }
            , new Object[] {
            BC002W21_A3CliCod, BC002W21_A1565CliConvenio, BC002W21_A996ConveAdicod, BC002W21_A1825ConveAdiSitCancDes, BC002W21_A1898ConveAdiSitCanRelSec, BC002W21_A1824ConveAdiSitCancela, BC002W21_A1564CliPaiConve
            }
            , new Object[] {
            BC002W22_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            BC002W23_A3CliCod, BC002W23_A1564CliPaiConve, BC002W23_A1565CliConvenio, BC002W23_A996ConveAdicod, BC002W23_A1824ConveAdiSitCancela
            }
            , new Object[] {
            BC002W24_A3CliCod, BC002W24_A1565CliConvenio, BC002W24_A996ConveAdicod, BC002W24_A1898ConveAdiSitCanRelSec, BC002W24_A1824ConveAdiSitCancela, BC002W24_A1564CliPaiConve
            }
            , new Object[] {
            BC002W25_A3CliCod, BC002W25_A1565CliConvenio, BC002W25_A996ConveAdicod, BC002W25_A1898ConveAdiSitCanRelSec, BC002W25_A1824ConveAdiSitCancela, BC002W25_A1564CliPaiConve
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002W29_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            BC002W30_A3CliCod, BC002W30_A1565CliConvenio, BC002W30_A996ConveAdicod, BC002W30_A1825ConveAdiSitCancDes, BC002W30_A1898ConveAdiSitCanRelSec, BC002W30_A1824ConveAdiSitCancela, BC002W30_A1564CliPaiConve
            }
            , new Object[] {
            BC002W31_A3CliCod, BC002W31_A1565CliConvenio, BC002W31_A996ConveAdicod, BC002W31_A999ConveAdiVig, BC002W31_A1000ConveAdiImporte, BC002W31_A1899ConveAdiImpRelSec, BC002W31_A1564CliPaiConve
            }
            , new Object[] {
            BC002W32_A3CliCod, BC002W32_A1564CliPaiConve, BC002W32_A1565CliConvenio, BC002W32_A996ConveAdicod, BC002W32_A999ConveAdiVig
            }
            , new Object[] {
            BC002W33_A3CliCod, BC002W33_A1565CliConvenio, BC002W33_A996ConveAdicod, BC002W33_A999ConveAdiVig, BC002W33_A1000ConveAdiImporte, BC002W33_A1899ConveAdiImpRelSec, BC002W33_A1564CliPaiConve
            }
            , new Object[] {
            BC002W34_A3CliCod, BC002W34_A1565CliConvenio, BC002W34_A996ConveAdicod, BC002W34_A999ConveAdiVig, BC002W34_A1000ConveAdiImporte, BC002W34_A1899ConveAdiImpRelSec, BC002W34_A1564CliPaiConve
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002W38_A3CliCod, BC002W38_A1565CliConvenio, BC002W38_A996ConveAdicod, BC002W38_A999ConveAdiVig, BC002W38_A1000ConveAdiImporte, BC002W38_A1899ConveAdiImpRelSec, BC002W38_A1564CliPaiConve
            }
            , new Object[] {
            BC002W39_A3CliCod, BC002W39_A1565CliConvenio, BC002W39_A996ConveAdicod, BC002W39_A1011ConveAdiOpcCod, BC002W39_A1021ConveAdiOpcFor, BC002W39_A1012ConveAdiOpcDes, BC002W39_A1013ConveAdiOpcAli, BC002W39_A1900ConveAdiOpcRelSec, BC002W39_A1564CliPaiConve
            }
            , new Object[] {
            BC002W40_A3CliCod, BC002W40_A1564CliPaiConve, BC002W40_A1565CliConvenio, BC002W40_A996ConveAdicod, BC002W40_A1011ConveAdiOpcCod
            }
            , new Object[] {
            BC002W41_A3CliCod, BC002W41_A1565CliConvenio, BC002W41_A996ConveAdicod, BC002W41_A1011ConveAdiOpcCod, BC002W41_A1021ConveAdiOpcFor, BC002W41_A1012ConveAdiOpcDes, BC002W41_A1013ConveAdiOpcAli, BC002W41_A1900ConveAdiOpcRelSec, BC002W41_A1564CliPaiConve
            }
            , new Object[] {
            BC002W42_A3CliCod, BC002W42_A1565CliConvenio, BC002W42_A996ConveAdicod, BC002W42_A1011ConveAdiOpcCod, BC002W42_A1021ConveAdiOpcFor, BC002W42_A1012ConveAdiOpcDes, BC002W42_A1013ConveAdiOpcAli, BC002W42_A1900ConveAdiOpcRelSec, BC002W42_A1564CliPaiConve
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002W46_A3CliCod, BC002W46_A1565CliConvenio, BC002W46_A996ConveAdicod, BC002W46_A1011ConveAdiOpcCod, BC002W46_A1021ConveAdiOpcFor, BC002W46_A1012ConveAdiOpcDes, BC002W46_A1013ConveAdiOpcAli, BC002W46_A1900ConveAdiOpcRelSec, BC002W46_A1564CliPaiConve
            }
            , new Object[] {
            BC002W47_A3CliCod
            }
            , new Object[] {
            BC002W48_A3CliCod
            }
         }
      );
      AV41Pgmname = "convenio_adicional_BC" ;
      Z1803ConveAdiTipo = "otros" ;
      A1803ConveAdiTipo = "otros" ;
      i1803ConveAdiTipo = "otros" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e122W2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte Gxremove245 ;
   private byte Gxremove208 ;
   private byte Gxremove209 ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1564CliPaiConve ;
   private short A1564CliPaiConve ;
   private short nIsMod_209 ;
   private short RcdFound209 ;
   private short nIsMod_208 ;
   private short RcdFound208 ;
   private short nIsMod_245 ;
   private short RcdFound245 ;
   private short RcdFound207 ;
   private short nIsDirty_207 ;
   private short nRcdExists_245 ;
   private short nRcdExists_208 ;
   private short nRcdExists_209 ;
   private short nIsDirty_245 ;
   private short nIsDirty_208 ;
   private short Z1011ConveAdiOpcCod ;
   private short A1011ConveAdiOpcCod ;
   private short nIsDirty_209 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int nGXsfl_209_idx=1 ;
   private int nGXsfl_208_idx=1 ;
   private int nGXsfl_245_idx=1 ;
   private int GX_JID ;
   private int Z1901ConveAdiRelSec ;
   private int A1901ConveAdiRelSec ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private int Z1898ConveAdiSitCanRelSec ;
   private int A1898ConveAdiSitCanRelSec ;
   private int Z1899ConveAdiImpRelSec ;
   private int A1899ConveAdiImpRelSec ;
   private int Z1900ConveAdiOpcRelSec ;
   private int A1900ConveAdiOpcRelSec ;
   private java.math.BigDecimal Z998ConveAdiAli ;
   private java.math.BigDecimal A998ConveAdiAli ;
   private java.math.BigDecimal Z1000ConveAdiImporte ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private java.math.BigDecimal Z1013ConveAdiOpcAli ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z1565CliConvenio ;
   private String A1565CliConvenio ;
   private String Z996ConveAdicod ;
   private String A996ConveAdicod ;
   private String sMode207 ;
   private String AV41Pgmname ;
   private String Z1803ConveAdiTipo ;
   private String A1803ConveAdiTipo ;
   private String Z1824ConveAdiSitCancela ;
   private String A1824ConveAdiSitCancela ;
   private String sMode245 ;
   private String sMode208 ;
   private String Z1021ConveAdiOpcFor ;
   private String A1021ConveAdiOpcFor ;
   private String sMode209 ;
   private String i1803ConveAdiTipo ;
   private java.util.Date Z999ConveAdiVig ;
   private java.util.Date A999ConveAdiVig ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n1019ConveAdiInfo ;
   private boolean n1901ConveAdiRelSec ;
   private boolean mustCommit ;
   private String Z1019ConveAdiInfo ;
   private String A1019ConveAdiInfo ;
   private String Z2047ConveAdiOld ;
   private String A2047ConveAdiOld ;
   private String Z997ConveAdiDescri ;
   private String A997ConveAdiDescri ;
   private String Z2046ConveAdiRelRef ;
   private String A2046ConveAdiRelRef ;
   private String Z1825ConveAdiSitCancDes ;
   private String A1825ConveAdiSitCancDes ;
   private String Z1012ConveAdiOpcDes ;
   private String A1012ConveAdiOpcDes ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private web.Sdtconvenio_adicional bcconvenio_adicional ;
   private IDataStoreProvider pr_default ;
   private String[] BC002W12_A996ConveAdicod ;
   private String[] BC002W12_A997ConveAdiDescri ;
   private java.math.BigDecimal[] BC002W12_A998ConveAdiAli ;
   private String[] BC002W12_A1019ConveAdiInfo ;
   private boolean[] BC002W12_n1019ConveAdiInfo ;
   private String[] BC002W12_A1803ConveAdiTipo ;
   private int[] BC002W12_A1901ConveAdiRelSec ;
   private boolean[] BC002W12_n1901ConveAdiRelSec ;
   private String[] BC002W12_A2046ConveAdiRelRef ;
   private String[] BC002W12_A2047ConveAdiOld ;
   private int[] BC002W12_A3CliCod ;
   private short[] BC002W12_A1564CliPaiConve ;
   private String[] BC002W12_A1565CliConvenio ;
   private int[] BC002W13_A3CliCod ;
   private int[] BC002W14_A3CliCod ;
   private short[] BC002W14_A1564CliPaiConve ;
   private String[] BC002W14_A1565CliConvenio ;
   private String[] BC002W14_A996ConveAdicod ;
   private String[] BC002W15_A996ConveAdicod ;
   private String[] BC002W15_A997ConveAdiDescri ;
   private java.math.BigDecimal[] BC002W15_A998ConveAdiAli ;
   private String[] BC002W15_A1019ConveAdiInfo ;
   private boolean[] BC002W15_n1019ConveAdiInfo ;
   private String[] BC002W15_A1803ConveAdiTipo ;
   private int[] BC002W15_A1901ConveAdiRelSec ;
   private boolean[] BC002W15_n1901ConveAdiRelSec ;
   private String[] BC002W15_A2046ConveAdiRelRef ;
   private String[] BC002W15_A2047ConveAdiOld ;
   private int[] BC002W15_A3CliCod ;
   private short[] BC002W15_A1564CliPaiConve ;
   private String[] BC002W15_A1565CliConvenio ;
   private String[] BC002W16_A996ConveAdicod ;
   private String[] BC002W16_A997ConveAdiDescri ;
   private java.math.BigDecimal[] BC002W16_A998ConveAdiAli ;
   private String[] BC002W16_A1019ConveAdiInfo ;
   private boolean[] BC002W16_n1019ConveAdiInfo ;
   private String[] BC002W16_A1803ConveAdiTipo ;
   private int[] BC002W16_A1901ConveAdiRelSec ;
   private boolean[] BC002W16_n1901ConveAdiRelSec ;
   private String[] BC002W16_A2046ConveAdiRelRef ;
   private String[] BC002W16_A2047ConveAdiOld ;
   private int[] BC002W16_A3CliCod ;
   private short[] BC002W16_A1564CliPaiConve ;
   private String[] BC002W16_A1565CliConvenio ;
   private String[] BC002W20_A996ConveAdicod ;
   private String[] BC002W20_A997ConveAdiDescri ;
   private java.math.BigDecimal[] BC002W20_A998ConveAdiAli ;
   private String[] BC002W20_A1019ConveAdiInfo ;
   private boolean[] BC002W20_n1019ConveAdiInfo ;
   private String[] BC002W20_A1803ConveAdiTipo ;
   private int[] BC002W20_A1901ConveAdiRelSec ;
   private boolean[] BC002W20_n1901ConveAdiRelSec ;
   private String[] BC002W20_A2046ConveAdiRelRef ;
   private String[] BC002W20_A2047ConveAdiOld ;
   private int[] BC002W20_A3CliCod ;
   private short[] BC002W20_A1564CliPaiConve ;
   private String[] BC002W20_A1565CliConvenio ;
   private int[] BC002W21_A3CliCod ;
   private String[] BC002W21_A1565CliConvenio ;
   private String[] BC002W21_A996ConveAdicod ;
   private String[] BC002W21_A1825ConveAdiSitCancDes ;
   private int[] BC002W21_A1898ConveAdiSitCanRelSec ;
   private String[] BC002W21_A1824ConveAdiSitCancela ;
   private short[] BC002W21_A1564CliPaiConve ;
   private String[] BC002W22_A1825ConveAdiSitCancDes ;
   private int[] BC002W23_A3CliCod ;
   private short[] BC002W23_A1564CliPaiConve ;
   private String[] BC002W23_A1565CliConvenio ;
   private String[] BC002W23_A996ConveAdicod ;
   private String[] BC002W23_A1824ConveAdiSitCancela ;
   private int[] BC002W24_A3CliCod ;
   private String[] BC002W24_A1565CliConvenio ;
   private String[] BC002W24_A996ConveAdicod ;
   private int[] BC002W24_A1898ConveAdiSitCanRelSec ;
   private String[] BC002W24_A1824ConveAdiSitCancela ;
   private short[] BC002W24_A1564CliPaiConve ;
   private int[] BC002W25_A3CliCod ;
   private String[] BC002W25_A1565CliConvenio ;
   private String[] BC002W25_A996ConveAdicod ;
   private int[] BC002W25_A1898ConveAdiSitCanRelSec ;
   private String[] BC002W25_A1824ConveAdiSitCancela ;
   private short[] BC002W25_A1564CliPaiConve ;
   private String[] BC002W29_A1825ConveAdiSitCancDes ;
   private int[] BC002W30_A3CliCod ;
   private String[] BC002W30_A1565CliConvenio ;
   private String[] BC002W30_A996ConveAdicod ;
   private String[] BC002W30_A1825ConveAdiSitCancDes ;
   private int[] BC002W30_A1898ConveAdiSitCanRelSec ;
   private String[] BC002W30_A1824ConveAdiSitCancela ;
   private short[] BC002W30_A1564CliPaiConve ;
   private int[] BC002W31_A3CliCod ;
   private String[] BC002W31_A1565CliConvenio ;
   private String[] BC002W31_A996ConveAdicod ;
   private java.util.Date[] BC002W31_A999ConveAdiVig ;
   private java.math.BigDecimal[] BC002W31_A1000ConveAdiImporte ;
   private int[] BC002W31_A1899ConveAdiImpRelSec ;
   private short[] BC002W31_A1564CliPaiConve ;
   private int[] BC002W32_A3CliCod ;
   private short[] BC002W32_A1564CliPaiConve ;
   private String[] BC002W32_A1565CliConvenio ;
   private String[] BC002W32_A996ConveAdicod ;
   private java.util.Date[] BC002W32_A999ConveAdiVig ;
   private int[] BC002W33_A3CliCod ;
   private String[] BC002W33_A1565CliConvenio ;
   private String[] BC002W33_A996ConveAdicod ;
   private java.util.Date[] BC002W33_A999ConveAdiVig ;
   private java.math.BigDecimal[] BC002W33_A1000ConveAdiImporte ;
   private int[] BC002W33_A1899ConveAdiImpRelSec ;
   private short[] BC002W33_A1564CliPaiConve ;
   private int[] BC002W34_A3CliCod ;
   private String[] BC002W34_A1565CliConvenio ;
   private String[] BC002W34_A996ConveAdicod ;
   private java.util.Date[] BC002W34_A999ConveAdiVig ;
   private java.math.BigDecimal[] BC002W34_A1000ConveAdiImporte ;
   private int[] BC002W34_A1899ConveAdiImpRelSec ;
   private short[] BC002W34_A1564CliPaiConve ;
   private int[] BC002W38_A3CliCod ;
   private String[] BC002W38_A1565CliConvenio ;
   private String[] BC002W38_A996ConveAdicod ;
   private java.util.Date[] BC002W38_A999ConveAdiVig ;
   private java.math.BigDecimal[] BC002W38_A1000ConveAdiImporte ;
   private int[] BC002W38_A1899ConveAdiImpRelSec ;
   private short[] BC002W38_A1564CliPaiConve ;
   private int[] BC002W39_A3CliCod ;
   private String[] BC002W39_A1565CliConvenio ;
   private String[] BC002W39_A996ConveAdicod ;
   private short[] BC002W39_A1011ConveAdiOpcCod ;
   private String[] BC002W39_A1021ConveAdiOpcFor ;
   private String[] BC002W39_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] BC002W39_A1013ConveAdiOpcAli ;
   private int[] BC002W39_A1900ConveAdiOpcRelSec ;
   private short[] BC002W39_A1564CliPaiConve ;
   private int[] BC002W40_A3CliCod ;
   private short[] BC002W40_A1564CliPaiConve ;
   private String[] BC002W40_A1565CliConvenio ;
   private String[] BC002W40_A996ConveAdicod ;
   private short[] BC002W40_A1011ConveAdiOpcCod ;
   private int[] BC002W41_A3CliCod ;
   private String[] BC002W41_A1565CliConvenio ;
   private String[] BC002W41_A996ConveAdicod ;
   private short[] BC002W41_A1011ConveAdiOpcCod ;
   private String[] BC002W41_A1021ConveAdiOpcFor ;
   private String[] BC002W41_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] BC002W41_A1013ConveAdiOpcAli ;
   private int[] BC002W41_A1900ConveAdiOpcRelSec ;
   private short[] BC002W41_A1564CliPaiConve ;
   private int[] BC002W42_A3CliCod ;
   private String[] BC002W42_A1565CliConvenio ;
   private String[] BC002W42_A996ConveAdicod ;
   private short[] BC002W42_A1011ConveAdiOpcCod ;
   private String[] BC002W42_A1021ConveAdiOpcFor ;
   private String[] BC002W42_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] BC002W42_A1013ConveAdiOpcAli ;
   private int[] BC002W42_A1900ConveAdiOpcRelSec ;
   private short[] BC002W42_A1564CliPaiConve ;
   private int[] BC002W46_A3CliCod ;
   private String[] BC002W46_A1565CliConvenio ;
   private String[] BC002W46_A996ConveAdicod ;
   private short[] BC002W46_A1011ConveAdiOpcCod ;
   private String[] BC002W46_A1021ConveAdiOpcFor ;
   private String[] BC002W46_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] BC002W46_A1013ConveAdiOpcAli ;
   private int[] BC002W46_A1900ConveAdiOpcRelSec ;
   private short[] BC002W46_A1564CliPaiConve ;
   private int[] BC002W47_A3CliCod ;
   private int[] BC002W48_A3CliCod ;
   private int[] BC002W2_A3CliCod ;
   private String[] BC002W2_A1565CliConvenio ;
   private String[] BC002W2_A996ConveAdicod ;
   private short[] BC002W2_A1011ConveAdiOpcCod ;
   private String[] BC002W2_A1021ConveAdiOpcFor ;
   private String[] BC002W2_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] BC002W2_A1013ConveAdiOpcAli ;
   private int[] BC002W2_A1900ConveAdiOpcRelSec ;
   private short[] BC002W2_A1564CliPaiConve ;
   private int[] BC002W3_A3CliCod ;
   private String[] BC002W3_A1565CliConvenio ;
   private String[] BC002W3_A996ConveAdicod ;
   private short[] BC002W3_A1011ConveAdiOpcCod ;
   private String[] BC002W3_A1021ConveAdiOpcFor ;
   private String[] BC002W3_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] BC002W3_A1013ConveAdiOpcAli ;
   private int[] BC002W3_A1900ConveAdiOpcRelSec ;
   private short[] BC002W3_A1564CliPaiConve ;
   private int[] BC002W4_A3CliCod ;
   private String[] BC002W4_A1565CliConvenio ;
   private String[] BC002W4_A996ConveAdicod ;
   private java.util.Date[] BC002W4_A999ConveAdiVig ;
   private java.math.BigDecimal[] BC002W4_A1000ConveAdiImporte ;
   private int[] BC002W4_A1899ConveAdiImpRelSec ;
   private short[] BC002W4_A1564CliPaiConve ;
   private int[] BC002W5_A3CliCod ;
   private String[] BC002W5_A1565CliConvenio ;
   private String[] BC002W5_A996ConveAdicod ;
   private java.util.Date[] BC002W5_A999ConveAdiVig ;
   private java.math.BigDecimal[] BC002W5_A1000ConveAdiImporte ;
   private int[] BC002W5_A1899ConveAdiImpRelSec ;
   private short[] BC002W5_A1564CliPaiConve ;
   private int[] BC002W6_A3CliCod ;
   private String[] BC002W6_A1565CliConvenio ;
   private String[] BC002W6_A996ConveAdicod ;
   private int[] BC002W6_A1898ConveAdiSitCanRelSec ;
   private String[] BC002W6_A1824ConveAdiSitCancela ;
   private short[] BC002W6_A1564CliPaiConve ;
   private int[] BC002W7_A3CliCod ;
   private String[] BC002W7_A1565CliConvenio ;
   private String[] BC002W7_A996ConveAdicod ;
   private int[] BC002W7_A1898ConveAdiSitCanRelSec ;
   private String[] BC002W7_A1824ConveAdiSitCancela ;
   private short[] BC002W7_A1564CliPaiConve ;
   private String[] BC002W8_A1825ConveAdiSitCancDes ;
   private String[] BC002W9_A996ConveAdicod ;
   private String[] BC002W9_A997ConveAdiDescri ;
   private java.math.BigDecimal[] BC002W9_A998ConveAdiAli ;
   private String[] BC002W9_A1019ConveAdiInfo ;
   private String[] BC002W9_A1803ConveAdiTipo ;
   private int[] BC002W9_A1901ConveAdiRelSec ;
   private String[] BC002W9_A2046ConveAdiRelRef ;
   private String[] BC002W9_A2047ConveAdiOld ;
   private int[] BC002W9_A3CliCod ;
   private short[] BC002W9_A1564CliPaiConve ;
   private String[] BC002W9_A1565CliConvenio ;
   private String[] BC002W10_A996ConveAdicod ;
   private String[] BC002W10_A997ConveAdiDescri ;
   private java.math.BigDecimal[] BC002W10_A998ConveAdiAli ;
   private String[] BC002W10_A1019ConveAdiInfo ;
   private String[] BC002W10_A1803ConveAdiTipo ;
   private int[] BC002W10_A1901ConveAdiRelSec ;
   private String[] BC002W10_A2046ConveAdiRelRef ;
   private String[] BC002W10_A2047ConveAdiOld ;
   private int[] BC002W10_A3CliCod ;
   private short[] BC002W10_A1564CliPaiConve ;
   private String[] BC002W10_A1565CliConvenio ;
   private int[] BC002W11_A3CliCod ;
   private boolean[] BC002W9_n1019ConveAdiInfo ;
   private boolean[] BC002W9_n1901ConveAdiRelSec ;
   private boolean[] BC002W10_n1019ConveAdiInfo ;
   private boolean[] BC002W10_n1901ConveAdiRelSec ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class convenio_adicional_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC002W2", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ?  FOR UPDATE OF convenio_adicionalalicuotas",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W3", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W4", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?  FOR UPDATE OF convenio_adicionalimportes",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W5", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W6", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiSitCanRelSec, ConveAdiSitCancela, CliPaiConve FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?  FOR UPDATE OF convenio_adicionalCancela",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W7", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiSitCanRelSec, ConveAdiSitCancela, CliPaiConve FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W8", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W9", "SELECT ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, CliCod, CliPaiConve, CliConvenio FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ?  FOR UPDATE OF convenio_adicional",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W10", "SELECT ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, CliCod, CliPaiConve, CliConvenio FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W11", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W12", "SELECT TM1.ConveAdicod, TM1.ConveAdiDescri, TM1.ConveAdiAli, TM1.ConveAdiInfo, TM1.ConveAdiTipo, TM1.ConveAdiRelSec, TM1.ConveAdiRelRef, TM1.ConveAdiOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM convenio_adicional TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.ConveAdicod = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveAdicod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W13", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W14", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W15", "SELECT ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, CliCod, CliPaiConve, CliConvenio FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W16", "SELECT ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, CliCod, CliPaiConve, CliConvenio FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ?  FOR UPDATE OF convenio_adicional",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002W17", "SAVEPOINT gxupdate;INSERT INTO convenio_adicional(ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, CliCod, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002W18", "SAVEPOINT gxupdate;UPDATE convenio_adicional SET ConveAdiDescri=?, ConveAdiAli=?, ConveAdiInfo=?, ConveAdiTipo=?, ConveAdiRelSec=?, ConveAdiRelRef=?, ConveAdiOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002W19", "SAVEPOINT gxupdate;DELETE FROM convenio_adicional  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002W20", "SELECT TM1.ConveAdicod, TM1.ConveAdiDescri, TM1.ConveAdiAli, TM1.ConveAdiInfo, TM1.ConveAdiTipo, TM1.ConveAdiRelSec, TM1.ConveAdiRelRef, TM1.ConveAdiOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM convenio_adicional TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.ConveAdicod = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveAdicod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W21", "SELECT T1.CliCod, T1.CliConvenio, T1.ConveAdicod, T2.SitDescrip AS ConveAdiSitCancDes, T1.ConveAdiSitCanRelSec, T1.ConveAdiSitCancela AS ConveAdiSitCancela, T1.CliPaiConve FROM (convenio_adicionalCancela T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.ConveAdiSitCancela) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.ConveAdicod = ( ?) and T1.ConveAdiSitCancela = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.ConveAdicod, T1.ConveAdiSitCancela ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W22", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W23", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W24", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiSitCanRelSec, ConveAdiSitCancela, CliPaiConve FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W25", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiSitCanRelSec, ConveAdiSitCancela, CliPaiConve FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?  FOR UPDATE OF convenio_adicionalCancela",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002W26", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliConvenio, ConveAdicod, ConveAdiSitCanRelSec, ConveAdiSitCancela, CliPaiConve, ConveAdiSitCanRelRef, ConveAdiSitCanOld) VALUES(?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002W27", "SAVEPOINT gxupdate;UPDATE convenio_adicionalCancela SET ConveAdiSitCanRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002W28", "SAVEPOINT gxupdate;DELETE FROM convenio_adicionalCancela  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002W29", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W30", "SELECT T1.CliCod, T1.CliConvenio, T1.ConveAdicod, T2.SitDescrip AS ConveAdiSitCancDes, T1.ConveAdiSitCanRelSec, T1.ConveAdiSitCancela AS ConveAdiSitCancela, T1.CliPaiConve FROM (convenio_adicionalCancela T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.ConveAdiSitCancela) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.ConveAdicod = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.ConveAdicod, T1.ConveAdiSitCancela ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W31", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W32", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W33", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W34", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?  FOR UPDATE OF convenio_adicionalimportes",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002W35", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalimportes(CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve, ConveAdiImpRelRef, ConveAdiImpOld) VALUES(?, ?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002W36", "SAVEPOINT gxupdate;UPDATE convenio_adicionalimportes SET ConveAdiImporte=?, ConveAdiImpRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002W37", "SAVEPOINT gxupdate;DELETE FROM convenio_adicionalimportes  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002W38", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W39", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiOpcCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W40", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod FROM convenio_adicionalalicuotas WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W41", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W42", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ?  FOR UPDATE OF convenio_adicionalalicuotas",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002W43", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalalicuotas(CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve, ConveAdiOpcRelRef, ConveAdiOpcOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002W44", "SAVEPOINT gxupdate;UPDATE convenio_adicionalalicuotas SET ConveAdiOpcFor=?, ConveAdiOpcDes=?, ConveAdiOpcAli=?, ConveAdiOpcRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002W45", "SAVEPOINT gxupdate;DELETE FROM convenio_adicionalalicuotas  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002W46", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W47", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002W48", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 27 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 31 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 37 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 39 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 40 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 44 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 45 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 46 :
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
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
               stmt.setString(4, (String)parms[3], 20);
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
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[4]);
               }
               stmt.setString(5, (String)parms[5], 20);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(6, ((Number) parms[7]).intValue());
               }
               stmt.setVarchar(7, (String)parms[8], 40, false);
               stmt.setNLongVarchar(8, (String)parms[9], false);
               stmt.setInt(9, ((Number) parms[10]).intValue());
               stmt.setShort(10, ((Number) parms[11]).shortValue());
               stmt.setString(11, (String)parms[12], 20);
               return;
            case 16 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 4);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[3]);
               }
               stmt.setString(4, (String)parms[4], 20);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(5, ((Number) parms[6]).intValue());
               }
               stmt.setVarchar(6, (String)parms[7], 40, false);
               stmt.setNLongVarchar(7, (String)parms[8], false);
               stmt.setInt(8, ((Number) parms[9]).intValue());
               stmt.setShort(9, ((Number) parms[10]).shortValue());
               stmt.setString(10, (String)parms[11], 20);
               stmt.setString(11, (String)parms[12], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 20 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 4);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 4);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 27 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 34 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 40 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 41 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 4);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 42 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 43 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 44 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 45 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 46 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

