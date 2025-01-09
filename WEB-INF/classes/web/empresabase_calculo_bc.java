package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresabase_calculo_bc extends GXWebPanel implements IGxSilentTrn
{
   public empresabase_calculo_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresabase_calculo_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabase_calculo_bc.class ));
   }

   public empresabase_calculo_bc( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow4E191( ) ;
      standaloneNotModal( ) ;
      initializeNonKey4E191( ) ;
      standaloneModal( ) ;
      addRow4E191( ) ;
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
         e114E2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
            Z1429EmpBaseTipo = A1429EmpBaseTipo ;
            Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
            Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
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

   public void confirm_4E0( )
   {
      beforeValidate4E191( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4E191( ) ;
         }
         else
         {
            checkExtendedTable4E191( ) ;
            if ( AnyError == 0 )
            {
               zm4E191( 8) ;
            }
            closeExtendedTableCursors4E191( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e124E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV13WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV13WWPContext = GXv_SdtWWPContext1[0] ;
      AV14IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV14IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Insert", GXv_boolean3) ;
         empresabase_calculo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV14IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV14IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Update", GXv_boolean3) ;
         empresabase_calculo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV14IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV14IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Delete", GXv_boolean3) ;
         empresabase_calculo_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV14IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV14IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV41Pgmname))}, new String[] {"GxObject"}) );
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
      AV16TrnContext.fromxml(AV17WebSession.getValue("TrnContext"), null, null);
   }

   public void e114E2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
   }

   public void zm4E191( int GX_JID )
   {
      if ( ( GX_JID == 7 ) || ( GX_JID == 0 ) )
      {
         Z1432EmpBasePlus = A1432EmpBasePlus ;
         Z1517EmpLicDMin = A1517EmpLicDMin ;
         Z1502EmpLicDLim = A1502EmpLicDLim ;
         Z1503EmpLicDSeman = A1503EmpLicDSeman ;
         Z1504EmpLicDMes = A1504EmpLicDMes ;
         Z1505EmpLicDSemes = A1505EmpLicDSemes ;
         Z1506EmpLicDAnual = A1506EmpLicDAnual ;
         Z1507EmpLicAdju = A1507EmpLicAdju ;
         Z1508EmpLicAdjuObl = A1508EmpLicAdjuObl ;
         Z1509EmpLicNecAut = A1509EmpLicNecAut ;
         Z1510EmpLicIngMot = A1510EmpLicIngMot ;
         Z1511EmpLicMotObl = A1511EmpLicMotObl ;
         Z1518EmpBaseOrd = A1518EmpBaseOrd ;
         Z1437EmpBasePromCnt1 = A1437EmpBasePromCnt1 ;
         Z1438EmpBasePromCnt2 = A1438EmpBasePromCnt2 ;
         Z1439EmpBasePromTCnt = A1439EmpBasePromTCnt ;
         Z2003EmpBaseRelSec = A2003EmpBaseRelSec ;
         Z1515EmpBaseC1Txt = A1515EmpBaseC1Txt ;
         Z1516EmpBaseC2Txt = A1516EmpBaseC2Txt ;
      }
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z1515EmpBaseC1Txt = A1515EmpBaseC1Txt ;
         Z1516EmpBaseC2Txt = A1516EmpBaseC2Txt ;
      }
      if ( GX_JID == -7 )
      {
         Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
         Z1429EmpBaseTipo = A1429EmpBaseTipo ;
         Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
         Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
         Z1432EmpBasePlus = A1432EmpBasePlus ;
         Z1517EmpLicDMin = A1517EmpLicDMin ;
         Z1502EmpLicDLim = A1502EmpLicDLim ;
         Z1503EmpLicDSeman = A1503EmpLicDSeman ;
         Z1504EmpLicDMes = A1504EmpLicDMes ;
         Z1505EmpLicDSemes = A1505EmpLicDSemes ;
         Z1506EmpLicDAnual = A1506EmpLicDAnual ;
         Z1507EmpLicAdju = A1507EmpLicAdju ;
         Z1508EmpLicAdjuObl = A1508EmpLicAdjuObl ;
         Z1509EmpLicNecAut = A1509EmpLicNecAut ;
         Z1510EmpLicIngMot = A1510EmpLicIngMot ;
         Z1511EmpLicMotObl = A1511EmpLicMotObl ;
         Z1518EmpBaseOrd = A1518EmpBaseOrd ;
         Z1437EmpBasePromCnt1 = A1437EmpBasePromCnt1 ;
         Z1438EmpBasePromCnt2 = A1438EmpBasePromCnt2 ;
         Z1439EmpBasePromTCnt = A1439EmpBasePromTCnt ;
         Z2003EmpBaseRelSec = A2003EmpBaseRelSec ;
         Z3CliCod = A3CliCod ;
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
         empresabase_calculo_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load4E191( )
   {
      /* Using cursor BC004E5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A1432EmpBasePlus = BC004E5_A1432EmpBasePlus[0] ;
         A1517EmpLicDMin = BC004E5_A1517EmpLicDMin[0] ;
         n1517EmpLicDMin = BC004E5_n1517EmpLicDMin[0] ;
         A1502EmpLicDLim = BC004E5_A1502EmpLicDLim[0] ;
         n1502EmpLicDLim = BC004E5_n1502EmpLicDLim[0] ;
         A1503EmpLicDSeman = BC004E5_A1503EmpLicDSeman[0] ;
         n1503EmpLicDSeman = BC004E5_n1503EmpLicDSeman[0] ;
         A1504EmpLicDMes = BC004E5_A1504EmpLicDMes[0] ;
         n1504EmpLicDMes = BC004E5_n1504EmpLicDMes[0] ;
         A1505EmpLicDSemes = BC004E5_A1505EmpLicDSemes[0] ;
         n1505EmpLicDSemes = BC004E5_n1505EmpLicDSemes[0] ;
         A1506EmpLicDAnual = BC004E5_A1506EmpLicDAnual[0] ;
         n1506EmpLicDAnual = BC004E5_n1506EmpLicDAnual[0] ;
         A1507EmpLicAdju = BC004E5_A1507EmpLicAdju[0] ;
         n1507EmpLicAdju = BC004E5_n1507EmpLicAdju[0] ;
         A1508EmpLicAdjuObl = BC004E5_A1508EmpLicAdjuObl[0] ;
         n1508EmpLicAdjuObl = BC004E5_n1508EmpLicAdjuObl[0] ;
         A1509EmpLicNecAut = BC004E5_A1509EmpLicNecAut[0] ;
         n1509EmpLicNecAut = BC004E5_n1509EmpLicNecAut[0] ;
         A1510EmpLicIngMot = BC004E5_A1510EmpLicIngMot[0] ;
         n1510EmpLicIngMot = BC004E5_n1510EmpLicIngMot[0] ;
         A1511EmpLicMotObl = BC004E5_A1511EmpLicMotObl[0] ;
         n1511EmpLicMotObl = BC004E5_n1511EmpLicMotObl[0] ;
         A1518EmpBaseOrd = BC004E5_A1518EmpBaseOrd[0] ;
         n1518EmpBaseOrd = BC004E5_n1518EmpBaseOrd[0] ;
         A1437EmpBasePromCnt1 = BC004E5_A1437EmpBasePromCnt1[0] ;
         A1438EmpBasePromCnt2 = BC004E5_A1438EmpBasePromCnt2[0] ;
         A1439EmpBasePromTCnt = BC004E5_A1439EmpBasePromTCnt[0] ;
         A2003EmpBaseRelSec = BC004E5_A2003EmpBaseRelSec[0] ;
         zm4E191( -7) ;
      }
      pr_default.close(3);
      onLoadActions4E191( ) ;
   }

   public void onLoadActions4E191( )
   {
      AV41Pgmname = "Empresabase_calculo_BC" ;
      GXt_char6 = A1515EmpBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char7) ;
      empresabase_calculo_bc.this.GXt_char6 = GXv_char7[0] ;
      A1515EmpBaseC1Txt = GXt_char6 ;
      GXt_char6 = A1516EmpBaseC2Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char7) ;
      empresabase_calculo_bc.this.GXt_char6 = GXv_char7[0] ;
      A1516EmpBaseC2Txt = GXt_char6 ;
   }

   public void checkExtendedTable4E191( )
   {
      nIsDirty_191 = (short)(0) ;
      standaloneModal( ) ;
      AV41Pgmname = "Empresabase_calculo_BC" ;
      /* Using cursor BC004E6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      if ( ! ( ( A1427EmpBaseClaseLeg == 1 ) || ( A1427EmpBaseClaseLeg == 2 ) || ( A1427EmpBaseClaseLeg == 3 ) || ( A1427EmpBaseClaseLeg == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase de legajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1429EmpBaseTipo, "licencia") == 0 ) || ( GXutil.strcmp(A1429EmpBaseTipo, "feriado") == 0 ) || ( GXutil.strcmp(A1429EmpBaseTipo, "horaNormal") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      nIsDirty_191 = (short)(1) ;
      GXt_char6 = A1515EmpBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char7) ;
      empresabase_calculo_bc.this.GXt_char6 = GXv_char7[0] ;
      A1515EmpBaseC1Txt = GXt_char6 ;
      nIsDirty_191 = (short)(1) ;
      GXt_char6 = A1516EmpBaseC2Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char7) ;
      empresabase_calculo_bc.this.GXt_char6 = GXv_char7[0] ;
      A1516EmpBaseC2Txt = GXt_char6 ;
      if ( ! ( ( GXutil.strcmp(A1439EmpBasePromTCnt, "dias") == 0 ) || ( GXutil.strcmp(A1439EmpBasePromTCnt, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días o Meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors4E191( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey4E191( )
   {
      /* Using cursor BC004E7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound191 = (short)(1) ;
      }
      else
      {
         RcdFound191 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC004E8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm4E191( 7) ;
         RcdFound191 = (short)(1) ;
         A1427EmpBaseClaseLeg = BC004E8_A1427EmpBaseClaseLeg[0] ;
         A1429EmpBaseTipo = BC004E8_A1429EmpBaseTipo[0] ;
         A1430EmpBaseCod1 = BC004E8_A1430EmpBaseCod1[0] ;
         A1431EmpBaseCod2 = BC004E8_A1431EmpBaseCod2[0] ;
         A1432EmpBasePlus = BC004E8_A1432EmpBasePlus[0] ;
         A1517EmpLicDMin = BC004E8_A1517EmpLicDMin[0] ;
         n1517EmpLicDMin = BC004E8_n1517EmpLicDMin[0] ;
         A1502EmpLicDLim = BC004E8_A1502EmpLicDLim[0] ;
         n1502EmpLicDLim = BC004E8_n1502EmpLicDLim[0] ;
         A1503EmpLicDSeman = BC004E8_A1503EmpLicDSeman[0] ;
         n1503EmpLicDSeman = BC004E8_n1503EmpLicDSeman[0] ;
         A1504EmpLicDMes = BC004E8_A1504EmpLicDMes[0] ;
         n1504EmpLicDMes = BC004E8_n1504EmpLicDMes[0] ;
         A1505EmpLicDSemes = BC004E8_A1505EmpLicDSemes[0] ;
         n1505EmpLicDSemes = BC004E8_n1505EmpLicDSemes[0] ;
         A1506EmpLicDAnual = BC004E8_A1506EmpLicDAnual[0] ;
         n1506EmpLicDAnual = BC004E8_n1506EmpLicDAnual[0] ;
         A1507EmpLicAdju = BC004E8_A1507EmpLicAdju[0] ;
         n1507EmpLicAdju = BC004E8_n1507EmpLicAdju[0] ;
         A1508EmpLicAdjuObl = BC004E8_A1508EmpLicAdjuObl[0] ;
         n1508EmpLicAdjuObl = BC004E8_n1508EmpLicAdjuObl[0] ;
         A1509EmpLicNecAut = BC004E8_A1509EmpLicNecAut[0] ;
         n1509EmpLicNecAut = BC004E8_n1509EmpLicNecAut[0] ;
         A1510EmpLicIngMot = BC004E8_A1510EmpLicIngMot[0] ;
         n1510EmpLicIngMot = BC004E8_n1510EmpLicIngMot[0] ;
         A1511EmpLicMotObl = BC004E8_A1511EmpLicMotObl[0] ;
         n1511EmpLicMotObl = BC004E8_n1511EmpLicMotObl[0] ;
         A1518EmpBaseOrd = BC004E8_A1518EmpBaseOrd[0] ;
         n1518EmpBaseOrd = BC004E8_n1518EmpBaseOrd[0] ;
         A1437EmpBasePromCnt1 = BC004E8_A1437EmpBasePromCnt1[0] ;
         A1438EmpBasePromCnt2 = BC004E8_A1438EmpBasePromCnt2[0] ;
         A1439EmpBasePromTCnt = BC004E8_A1439EmpBasePromTCnt[0] ;
         A2003EmpBaseRelSec = BC004E8_A2003EmpBaseRelSec[0] ;
         A3CliCod = BC004E8_A3CliCod[0] ;
         A1EmpCod = BC004E8_A1EmpCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
         Z1429EmpBaseTipo = A1429EmpBaseTipo ;
         Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
         Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
         sMode191 = Gx_mode ;
         Gx_mode = "DSP" ;
         load4E191( ) ;
         if ( AnyError == 1 )
         {
            RcdFound191 = (short)(0) ;
            initializeNonKey4E191( ) ;
         }
         Gx_mode = sMode191 ;
      }
      else
      {
         RcdFound191 = (short)(0) ;
         initializeNonKey4E191( ) ;
         sMode191 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode191 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey4E191( ) ;
      if ( RcdFound191 == 0 )
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
      confirm_4E0( ) ;
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

   public void checkOptimisticConcurrency4E191( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC004E9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresabase_calculo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(7) == 101) || ( DecimalUtil.compareTo(Z1432EmpBasePlus, BC004E9_A1432EmpBasePlus[0]) != 0 ) || ( Z1517EmpLicDMin != BC004E9_A1517EmpLicDMin[0] ) || ( Z1502EmpLicDLim != BC004E9_A1502EmpLicDLim[0] ) || ( Z1503EmpLicDSeman != BC004E9_A1503EmpLicDSeman[0] ) || ( Z1504EmpLicDMes != BC004E9_A1504EmpLicDMes[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1505EmpLicDSemes != BC004E9_A1505EmpLicDSemes[0] ) || ( Z1506EmpLicDAnual != BC004E9_A1506EmpLicDAnual[0] ) || ( Z1507EmpLicAdju != BC004E9_A1507EmpLicAdju[0] ) || ( Z1508EmpLicAdjuObl != BC004E9_A1508EmpLicAdjuObl[0] ) || ( Z1509EmpLicNecAut != BC004E9_A1509EmpLicNecAut[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1510EmpLicIngMot != BC004E9_A1510EmpLicIngMot[0] ) || ( Z1511EmpLicMotObl != BC004E9_A1511EmpLicMotObl[0] ) || ( Z1518EmpBaseOrd != BC004E9_A1518EmpBaseOrd[0] ) || ( Z1437EmpBasePromCnt1 != BC004E9_A1437EmpBasePromCnt1[0] ) || ( Z1438EmpBasePromCnt2 != BC004E9_A1438EmpBasePromCnt2[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1439EmpBasePromTCnt, BC004E9_A1439EmpBasePromTCnt[0]) != 0 ) || ( Z2003EmpBaseRelSec != BC004E9_A2003EmpBaseRelSec[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresabase_calculo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4E191( )
   {
      beforeValidate4E191( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4E191( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4E191( 0) ;
         checkOptimisticConcurrency4E191( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4E191( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4E191( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004E10 */
                  pr_default.execute(8, new Object[] {Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, A1432EmpBasePlus, Boolean.valueOf(n1517EmpLicDMin), Byte.valueOf(A1517EmpLicDMin), Boolean.valueOf(n1502EmpLicDLim), Short.valueOf(A1502EmpLicDLim), Boolean.valueOf(n1503EmpLicDSeman), Byte.valueOf(A1503EmpLicDSeman), Boolean.valueOf(n1504EmpLicDMes), Byte.valueOf(A1504EmpLicDMes), Boolean.valueOf(n1505EmpLicDSemes), Short.valueOf(A1505EmpLicDSemes), Boolean.valueOf(n1506EmpLicDAnual), Short.valueOf(A1506EmpLicDAnual), Boolean.valueOf(n1507EmpLicAdju), Boolean.valueOf(A1507EmpLicAdju), Boolean.valueOf(n1508EmpLicAdjuObl), Boolean.valueOf(A1508EmpLicAdjuObl), Boolean.valueOf(n1509EmpLicNecAut), Boolean.valueOf(A1509EmpLicNecAut), Boolean.valueOf(n1510EmpLicIngMot), Boolean.valueOf(A1510EmpLicIngMot), Boolean.valueOf(n1511EmpLicMotObl), Boolean.valueOf(A1511EmpLicMotObl), Boolean.valueOf(n1518EmpBaseOrd), Short.valueOf(A1518EmpBaseOrd), Short.valueOf(A1437EmpBasePromCnt1), Short.valueOf(A1438EmpBasePromCnt2), A1439EmpBasePromTCnt, Integer.valueOf(A2003EmpBaseRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
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
            load4E191( ) ;
         }
         endLevel4E191( ) ;
      }
      closeExtendedTableCursors4E191( ) ;
   }

   public void update4E191( )
   {
      beforeValidate4E191( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4E191( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4E191( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4E191( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4E191( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC004E11 */
                  pr_default.execute(9, new Object[] {A1432EmpBasePlus, Boolean.valueOf(n1517EmpLicDMin), Byte.valueOf(A1517EmpLicDMin), Boolean.valueOf(n1502EmpLicDLim), Short.valueOf(A1502EmpLicDLim), Boolean.valueOf(n1503EmpLicDSeman), Byte.valueOf(A1503EmpLicDSeman), Boolean.valueOf(n1504EmpLicDMes), Byte.valueOf(A1504EmpLicDMes), Boolean.valueOf(n1505EmpLicDSemes), Short.valueOf(A1505EmpLicDSemes), Boolean.valueOf(n1506EmpLicDAnual), Short.valueOf(A1506EmpLicDAnual), Boolean.valueOf(n1507EmpLicAdju), Boolean.valueOf(A1507EmpLicAdju), Boolean.valueOf(n1508EmpLicAdjuObl), Boolean.valueOf(A1508EmpLicAdjuObl), Boolean.valueOf(n1509EmpLicNecAut), Boolean.valueOf(A1509EmpLicNecAut), Boolean.valueOf(n1510EmpLicIngMot), Boolean.valueOf(A1510EmpLicIngMot), Boolean.valueOf(n1511EmpLicMotObl), Boolean.valueOf(A1511EmpLicMotObl), Boolean.valueOf(n1518EmpBaseOrd), Short.valueOf(A1518EmpBaseOrd), Short.valueOf(A1437EmpBasePromCnt1), Short.valueOf(A1438EmpBasePromCnt2), A1439EmpBasePromTCnt, Integer.valueOf(A2003EmpBaseRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresabase_calculo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4E191( ) ;
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
         endLevel4E191( ) ;
      }
      closeExtendedTableCursors4E191( ) ;
   }

   public void deferredUpdate4E191( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate4E191( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4E191( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4E191( ) ;
         afterConfirm4E191( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4E191( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC004E12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
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
      sMode191 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel4E191( ) ;
      Gx_mode = sMode191 ;
   }

   public void onDeleteControls4E191( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV41Pgmname = "Empresabase_calculo_BC" ;
         GXt_char6 = A1515EmpBaseC1Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char7) ;
         empresabase_calculo_bc.this.GXt_char6 = GXv_char7[0] ;
         A1515EmpBaseC1Txt = GXt_char6 ;
         GXt_char6 = A1516EmpBaseC2Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char7) ;
         empresabase_calculo_bc.this.GXt_char6 = GXv_char7[0] ;
         A1516EmpBaseC2Txt = GXt_char6 ;
      }
   }

   public void endLevel4E191( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4E191( ) ;
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

   public void scanKeyStart4E191( )
   {
      /* Scan By routine */
      /* Using cursor BC004E13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      RcdFound191 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A1427EmpBaseClaseLeg = BC004E13_A1427EmpBaseClaseLeg[0] ;
         A1429EmpBaseTipo = BC004E13_A1429EmpBaseTipo[0] ;
         A1430EmpBaseCod1 = BC004E13_A1430EmpBaseCod1[0] ;
         A1431EmpBaseCod2 = BC004E13_A1431EmpBaseCod2[0] ;
         A1432EmpBasePlus = BC004E13_A1432EmpBasePlus[0] ;
         A1517EmpLicDMin = BC004E13_A1517EmpLicDMin[0] ;
         n1517EmpLicDMin = BC004E13_n1517EmpLicDMin[0] ;
         A1502EmpLicDLim = BC004E13_A1502EmpLicDLim[0] ;
         n1502EmpLicDLim = BC004E13_n1502EmpLicDLim[0] ;
         A1503EmpLicDSeman = BC004E13_A1503EmpLicDSeman[0] ;
         n1503EmpLicDSeman = BC004E13_n1503EmpLicDSeman[0] ;
         A1504EmpLicDMes = BC004E13_A1504EmpLicDMes[0] ;
         n1504EmpLicDMes = BC004E13_n1504EmpLicDMes[0] ;
         A1505EmpLicDSemes = BC004E13_A1505EmpLicDSemes[0] ;
         n1505EmpLicDSemes = BC004E13_n1505EmpLicDSemes[0] ;
         A1506EmpLicDAnual = BC004E13_A1506EmpLicDAnual[0] ;
         n1506EmpLicDAnual = BC004E13_n1506EmpLicDAnual[0] ;
         A1507EmpLicAdju = BC004E13_A1507EmpLicAdju[0] ;
         n1507EmpLicAdju = BC004E13_n1507EmpLicAdju[0] ;
         A1508EmpLicAdjuObl = BC004E13_A1508EmpLicAdjuObl[0] ;
         n1508EmpLicAdjuObl = BC004E13_n1508EmpLicAdjuObl[0] ;
         A1509EmpLicNecAut = BC004E13_A1509EmpLicNecAut[0] ;
         n1509EmpLicNecAut = BC004E13_n1509EmpLicNecAut[0] ;
         A1510EmpLicIngMot = BC004E13_A1510EmpLicIngMot[0] ;
         n1510EmpLicIngMot = BC004E13_n1510EmpLicIngMot[0] ;
         A1511EmpLicMotObl = BC004E13_A1511EmpLicMotObl[0] ;
         n1511EmpLicMotObl = BC004E13_n1511EmpLicMotObl[0] ;
         A1518EmpBaseOrd = BC004E13_A1518EmpBaseOrd[0] ;
         n1518EmpBaseOrd = BC004E13_n1518EmpBaseOrd[0] ;
         A1437EmpBasePromCnt1 = BC004E13_A1437EmpBasePromCnt1[0] ;
         A1438EmpBasePromCnt2 = BC004E13_A1438EmpBasePromCnt2[0] ;
         A1439EmpBasePromTCnt = BC004E13_A1439EmpBasePromTCnt[0] ;
         A2003EmpBaseRelSec = BC004E13_A2003EmpBaseRelSec[0] ;
         A3CliCod = BC004E13_A3CliCod[0] ;
         A1EmpCod = BC004E13_A1EmpCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext4E191( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound191 = (short)(0) ;
      scanKeyLoad4E191( ) ;
   }

   public void scanKeyLoad4E191( )
   {
      sMode191 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A1427EmpBaseClaseLeg = BC004E13_A1427EmpBaseClaseLeg[0] ;
         A1429EmpBaseTipo = BC004E13_A1429EmpBaseTipo[0] ;
         A1430EmpBaseCod1 = BC004E13_A1430EmpBaseCod1[0] ;
         A1431EmpBaseCod2 = BC004E13_A1431EmpBaseCod2[0] ;
         A1432EmpBasePlus = BC004E13_A1432EmpBasePlus[0] ;
         A1517EmpLicDMin = BC004E13_A1517EmpLicDMin[0] ;
         n1517EmpLicDMin = BC004E13_n1517EmpLicDMin[0] ;
         A1502EmpLicDLim = BC004E13_A1502EmpLicDLim[0] ;
         n1502EmpLicDLim = BC004E13_n1502EmpLicDLim[0] ;
         A1503EmpLicDSeman = BC004E13_A1503EmpLicDSeman[0] ;
         n1503EmpLicDSeman = BC004E13_n1503EmpLicDSeman[0] ;
         A1504EmpLicDMes = BC004E13_A1504EmpLicDMes[0] ;
         n1504EmpLicDMes = BC004E13_n1504EmpLicDMes[0] ;
         A1505EmpLicDSemes = BC004E13_A1505EmpLicDSemes[0] ;
         n1505EmpLicDSemes = BC004E13_n1505EmpLicDSemes[0] ;
         A1506EmpLicDAnual = BC004E13_A1506EmpLicDAnual[0] ;
         n1506EmpLicDAnual = BC004E13_n1506EmpLicDAnual[0] ;
         A1507EmpLicAdju = BC004E13_A1507EmpLicAdju[0] ;
         n1507EmpLicAdju = BC004E13_n1507EmpLicAdju[0] ;
         A1508EmpLicAdjuObl = BC004E13_A1508EmpLicAdjuObl[0] ;
         n1508EmpLicAdjuObl = BC004E13_n1508EmpLicAdjuObl[0] ;
         A1509EmpLicNecAut = BC004E13_A1509EmpLicNecAut[0] ;
         n1509EmpLicNecAut = BC004E13_n1509EmpLicNecAut[0] ;
         A1510EmpLicIngMot = BC004E13_A1510EmpLicIngMot[0] ;
         n1510EmpLicIngMot = BC004E13_n1510EmpLicIngMot[0] ;
         A1511EmpLicMotObl = BC004E13_A1511EmpLicMotObl[0] ;
         n1511EmpLicMotObl = BC004E13_n1511EmpLicMotObl[0] ;
         A1518EmpBaseOrd = BC004E13_A1518EmpBaseOrd[0] ;
         n1518EmpBaseOrd = BC004E13_n1518EmpBaseOrd[0] ;
         A1437EmpBasePromCnt1 = BC004E13_A1437EmpBasePromCnt1[0] ;
         A1438EmpBasePromCnt2 = BC004E13_A1438EmpBasePromCnt2[0] ;
         A1439EmpBasePromTCnt = BC004E13_A1439EmpBasePromTCnt[0] ;
         A2003EmpBaseRelSec = BC004E13_A2003EmpBaseRelSec[0] ;
         A3CliCod = BC004E13_A3CliCod[0] ;
         A1EmpCod = BC004E13_A1EmpCod[0] ;
      }
      Gx_mode = sMode191 ;
   }

   public void scanKeyEnd4E191( )
   {
      pr_default.close(11);
   }

   public void afterConfirm4E191( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4E191( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4E191( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4E191( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4E191( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4E191( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4E191( )
   {
   }

   public void send_integrity_lvl_hashes4E191( )
   {
   }

   public void addRow4E191( )
   {
      VarsToRow191( bcEmpresabase_calculo) ;
   }

   public void readRow4E191( )
   {
      RowToVars191( bcEmpresabase_calculo, 1) ;
   }

   public void initializeNonKey4E191( )
   {
      A1515EmpBaseC1Txt = "" ;
      A1516EmpBaseC2Txt = "" ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      A1517EmpLicDMin = (byte)(0) ;
      n1517EmpLicDMin = false ;
      A1502EmpLicDLim = (short)(0) ;
      n1502EmpLicDLim = false ;
      A1503EmpLicDSeman = (byte)(0) ;
      n1503EmpLicDSeman = false ;
      A1504EmpLicDMes = (byte)(0) ;
      n1504EmpLicDMes = false ;
      A1505EmpLicDSemes = (short)(0) ;
      n1505EmpLicDSemes = false ;
      A1506EmpLicDAnual = (short)(0) ;
      n1506EmpLicDAnual = false ;
      A1507EmpLicAdju = false ;
      n1507EmpLicAdju = false ;
      A1508EmpLicAdjuObl = false ;
      n1508EmpLicAdjuObl = false ;
      A1509EmpLicNecAut = false ;
      n1509EmpLicNecAut = false ;
      A1510EmpLicIngMot = false ;
      n1510EmpLicIngMot = false ;
      A1511EmpLicMotObl = false ;
      n1511EmpLicMotObl = false ;
      A1518EmpBaseOrd = (short)(0) ;
      n1518EmpBaseOrd = false ;
      A1437EmpBasePromCnt1 = (short)(0) ;
      A1438EmpBasePromCnt2 = (short)(0) ;
      A1439EmpBasePromTCnt = "" ;
      A2003EmpBaseRelSec = 0 ;
      Z1432EmpBasePlus = DecimalUtil.ZERO ;
      Z1517EmpLicDMin = (byte)(0) ;
      Z1502EmpLicDLim = (short)(0) ;
      Z1503EmpLicDSeman = (byte)(0) ;
      Z1504EmpLicDMes = (byte)(0) ;
      Z1505EmpLicDSemes = (short)(0) ;
      Z1506EmpLicDAnual = (short)(0) ;
      Z1507EmpLicAdju = false ;
      Z1508EmpLicAdjuObl = false ;
      Z1509EmpLicNecAut = false ;
      Z1510EmpLicIngMot = false ;
      Z1511EmpLicMotObl = false ;
      Z1518EmpBaseOrd = (short)(0) ;
      Z1437EmpBasePromCnt1 = (short)(0) ;
      Z1438EmpBasePromCnt2 = (short)(0) ;
      Z1439EmpBasePromTCnt = "" ;
      Z2003EmpBaseRelSec = 0 ;
   }

   public void initAll4E191( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A1427EmpBaseClaseLeg = (byte)(0) ;
      A1429EmpBaseTipo = "" ;
      A1430EmpBaseCod1 = "" ;
      A1431EmpBaseCod2 = "" ;
      initializeNonKey4E191( ) ;
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

   public void VarsToRow191( web.SdtEmpresabase_calculo obj191 )
   {
      obj191.setgxTv_SdtEmpresabase_calculo_Mode( Gx_mode );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasec1txt( A1515EmpBaseC1Txt );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasec2txt( A1516EmpBaseC2Txt );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaseplus( A1432EmpBasePlus );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdmin( A1517EmpLicDMin );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdlim( A1502EmpLicDLim );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdseman( A1503EmpLicDSeman );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdmes( A1504EmpLicDMes );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdsemes( A1505EmpLicDSemes );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdanual( A1506EmpLicDAnual );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicadju( A1507EmpLicAdju );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl( A1508EmpLicAdjuObl );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicnecaut( A1509EmpLicNecAut );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicingmot( A1510EmpLicIngMot );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicmotobl( A1511EmpLicMotObl );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaseord( A1518EmpBaseOrd );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1( A1437EmpBasePromCnt1 );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2( A1438EmpBasePromCnt2 );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt( A1439EmpBasePromTCnt );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaserelsec( A2003EmpBaseRelSec );
      obj191.setgxTv_SdtEmpresabase_calculo_Clicod( A3CliCod );
      obj191.setgxTv_SdtEmpresabase_calculo_Empcod( A1EmpCod );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg( A1427EmpBaseClaseLeg );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasetipo( A1429EmpBaseTipo );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasecod1( A1430EmpBaseCod1 );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasecod2( A1431EmpBaseCod2 );
      obj191.setgxTv_SdtEmpresabase_calculo_Clicod_Z( Z3CliCod );
      obj191.setgxTv_SdtEmpresabase_calculo_Empcod_Z( Z1EmpCod );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z( Z1427EmpBaseClaseLeg );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasetipo_Z( Z1429EmpBaseTipo );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasecod1_Z( Z1430EmpBaseCod1 );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z( Z1515EmpBaseC1Txt );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasecod2_Z( Z1431EmpBaseCod2 );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z( Z1516EmpBaseC2Txt );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaseplus_Z( Z1432EmpBasePlus );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdmin_Z( Z1517EmpLicDMin );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdlim_Z( Z1502EmpLicDLim );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdseman_Z( Z1503EmpLicDSeman );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdmes_Z( Z1504EmpLicDMes );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z( Z1505EmpLicDSemes );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdanual_Z( Z1506EmpLicDAnual );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicadju_Z( Z1507EmpLicAdju );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z( Z1508EmpLicAdjuObl );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z( Z1509EmpLicNecAut );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicingmot_Z( Z1510EmpLicIngMot );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z( Z1511EmpLicMotObl );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaseord_Z( Z1518EmpBaseOrd );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z( Z1437EmpBasePromCnt1 );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z( Z1438EmpBasePromCnt2 );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z( Z1439EmpBasePromTCnt );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z( Z2003EmpBaseRelSec );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdmin_N( (byte)((byte)((n1517EmpLicDMin)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdlim_N( (byte)((byte)((n1502EmpLicDLim)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdseman_N( (byte)((byte)((n1503EmpLicDSeman)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdmes_N( (byte)((byte)((n1504EmpLicDMes)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdsemes_N( (byte)((byte)((n1505EmpLicDSemes)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicdanual_N( (byte)((byte)((n1506EmpLicDAnual)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicadju_N( (byte)((byte)((n1507EmpLicAdju)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N( (byte)((byte)((n1508EmpLicAdjuObl)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicnecaut_N( (byte)((byte)((n1509EmpLicNecAut)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicingmot_N( (byte)((byte)((n1510EmpLicIngMot)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Emplicmotobl_N( (byte)((byte)((n1511EmpLicMotObl)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaseord_N( (byte)((byte)((n1518EmpBaseOrd)?1:0)) );
      obj191.setgxTv_SdtEmpresabase_calculo_Mode( Gx_mode );
   }

   public void KeyVarsToRow191( web.SdtEmpresabase_calculo obj191 )
   {
      obj191.setgxTv_SdtEmpresabase_calculo_Clicod( A3CliCod );
      obj191.setgxTv_SdtEmpresabase_calculo_Empcod( A1EmpCod );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbaseclaseleg( A1427EmpBaseClaseLeg );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasetipo( A1429EmpBaseTipo );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasecod1( A1430EmpBaseCod1 );
      obj191.setgxTv_SdtEmpresabase_calculo_Empbasecod2( A1431EmpBaseCod2 );
   }

   public void RowToVars191( web.SdtEmpresabase_calculo obj191 ,
                             int forceLoad )
   {
      Gx_mode = obj191.getgxTv_SdtEmpresabase_calculo_Mode() ;
      A1515EmpBaseC1Txt = obj191.getgxTv_SdtEmpresabase_calculo_Empbasec1txt() ;
      A1516EmpBaseC2Txt = obj191.getgxTv_SdtEmpresabase_calculo_Empbasec2txt() ;
      A1432EmpBasePlus = obj191.getgxTv_SdtEmpresabase_calculo_Empbaseplus() ;
      A1517EmpLicDMin = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdmin() ;
      n1517EmpLicDMin = false ;
      A1502EmpLicDLim = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdlim() ;
      n1502EmpLicDLim = false ;
      A1503EmpLicDSeman = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdseman() ;
      n1503EmpLicDSeman = false ;
      A1504EmpLicDMes = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdmes() ;
      n1504EmpLicDMes = false ;
      A1505EmpLicDSemes = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdsemes() ;
      n1505EmpLicDSemes = false ;
      A1506EmpLicDAnual = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdanual() ;
      n1506EmpLicDAnual = false ;
      A1507EmpLicAdju = obj191.getgxTv_SdtEmpresabase_calculo_Emplicadju() ;
      n1507EmpLicAdju = false ;
      A1508EmpLicAdjuObl = obj191.getgxTv_SdtEmpresabase_calculo_Emplicadjuobl() ;
      n1508EmpLicAdjuObl = false ;
      A1509EmpLicNecAut = obj191.getgxTv_SdtEmpresabase_calculo_Emplicnecaut() ;
      n1509EmpLicNecAut = false ;
      A1510EmpLicIngMot = obj191.getgxTv_SdtEmpresabase_calculo_Emplicingmot() ;
      n1510EmpLicIngMot = false ;
      A1511EmpLicMotObl = obj191.getgxTv_SdtEmpresabase_calculo_Emplicmotobl() ;
      n1511EmpLicMotObl = false ;
      A1518EmpBaseOrd = obj191.getgxTv_SdtEmpresabase_calculo_Empbaseord() ;
      n1518EmpBaseOrd = false ;
      A1437EmpBasePromCnt1 = obj191.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1() ;
      A1438EmpBasePromCnt2 = obj191.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2() ;
      A1439EmpBasePromTCnt = obj191.getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt() ;
      A2003EmpBaseRelSec = obj191.getgxTv_SdtEmpresabase_calculo_Empbaserelsec() ;
      A3CliCod = obj191.getgxTv_SdtEmpresabase_calculo_Clicod() ;
      A1EmpCod = obj191.getgxTv_SdtEmpresabase_calculo_Empcod() ;
      A1427EmpBaseClaseLeg = obj191.getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg() ;
      A1429EmpBaseTipo = obj191.getgxTv_SdtEmpresabase_calculo_Empbasetipo() ;
      A1430EmpBaseCod1 = obj191.getgxTv_SdtEmpresabase_calculo_Empbasecod1() ;
      A1431EmpBaseCod2 = obj191.getgxTv_SdtEmpresabase_calculo_Empbasecod2() ;
      Z3CliCod = obj191.getgxTv_SdtEmpresabase_calculo_Clicod_Z() ;
      Z1EmpCod = obj191.getgxTv_SdtEmpresabase_calculo_Empcod_Z() ;
      Z1427EmpBaseClaseLeg = obj191.getgxTv_SdtEmpresabase_calculo_Empbaseclaseleg_Z() ;
      Z1429EmpBaseTipo = obj191.getgxTv_SdtEmpresabase_calculo_Empbasetipo_Z() ;
      Z1430EmpBaseCod1 = obj191.getgxTv_SdtEmpresabase_calculo_Empbasecod1_Z() ;
      Z1515EmpBaseC1Txt = obj191.getgxTv_SdtEmpresabase_calculo_Empbasec1txt_Z() ;
      Z1431EmpBaseCod2 = obj191.getgxTv_SdtEmpresabase_calculo_Empbasecod2_Z() ;
      Z1516EmpBaseC2Txt = obj191.getgxTv_SdtEmpresabase_calculo_Empbasec2txt_Z() ;
      Z1432EmpBasePlus = obj191.getgxTv_SdtEmpresabase_calculo_Empbaseplus_Z() ;
      Z1517EmpLicDMin = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdmin_Z() ;
      Z1502EmpLicDLim = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdlim_Z() ;
      Z1503EmpLicDSeman = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdseman_Z() ;
      Z1504EmpLicDMes = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdmes_Z() ;
      Z1505EmpLicDSemes = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdsemes_Z() ;
      Z1506EmpLicDAnual = obj191.getgxTv_SdtEmpresabase_calculo_Emplicdanual_Z() ;
      Z1507EmpLicAdju = obj191.getgxTv_SdtEmpresabase_calculo_Emplicadju_Z() ;
      Z1508EmpLicAdjuObl = obj191.getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_Z() ;
      Z1509EmpLicNecAut = obj191.getgxTv_SdtEmpresabase_calculo_Emplicnecaut_Z() ;
      Z1510EmpLicIngMot = obj191.getgxTv_SdtEmpresabase_calculo_Emplicingmot_Z() ;
      Z1511EmpLicMotObl = obj191.getgxTv_SdtEmpresabase_calculo_Emplicmotobl_Z() ;
      Z1518EmpBaseOrd = obj191.getgxTv_SdtEmpresabase_calculo_Empbaseord_Z() ;
      Z1437EmpBasePromCnt1 = obj191.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt1_Z() ;
      Z1438EmpBasePromCnt2 = obj191.getgxTv_SdtEmpresabase_calculo_Empbasepromcnt2_Z() ;
      Z1439EmpBasePromTCnt = obj191.getgxTv_SdtEmpresabase_calculo_Empbasepromtcnt_Z() ;
      Z2003EmpBaseRelSec = obj191.getgxTv_SdtEmpresabase_calculo_Empbaserelsec_Z() ;
      n1517EmpLicDMin = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicdmin_N()==0)?false:true) ;
      n1502EmpLicDLim = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicdlim_N()==0)?false:true) ;
      n1503EmpLicDSeman = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicdseman_N()==0)?false:true) ;
      n1504EmpLicDMes = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicdmes_N()==0)?false:true) ;
      n1505EmpLicDSemes = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicdsemes_N()==0)?false:true) ;
      n1506EmpLicDAnual = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicdanual_N()==0)?false:true) ;
      n1507EmpLicAdju = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicadju_N()==0)?false:true) ;
      n1508EmpLicAdjuObl = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicadjuobl_N()==0)?false:true) ;
      n1509EmpLicNecAut = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicnecaut_N()==0)?false:true) ;
      n1510EmpLicIngMot = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicingmot_N()==0)?false:true) ;
      n1511EmpLicMotObl = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Emplicmotobl_N()==0)?false:true) ;
      n1518EmpBaseOrd = (boolean)((obj191.getgxTv_SdtEmpresabase_calculo_Empbaseord_N()==0)?false:true) ;
      Gx_mode = obj191.getgxTv_SdtEmpresabase_calculo_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A1427EmpBaseClaseLeg = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.BYTE)).byteValue() ;
      A1429EmpBaseTipo = (String)getParm(obj,3) ;
      A1430EmpBaseCod1 = (String)getParm(obj,4) ;
      A1431EmpBaseCod2 = (String)getParm(obj,5) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey4E191( ) ;
      scanKeyStart4E191( ) ;
      if ( RcdFound191 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC004E14 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(12) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
         Z1429EmpBaseTipo = A1429EmpBaseTipo ;
         Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
         Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
      }
      zm4E191( -7) ;
      onLoadActions4E191( ) ;
      addRow4E191( ) ;
      scanKeyEnd4E191( ) ;
      if ( RcdFound191 == 0 )
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
      RowToVars191( bcEmpresabase_calculo, 0) ;
      scanKeyStart4E191( ) ;
      if ( RcdFound191 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC004E15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
         Z1429EmpBaseTipo = A1429EmpBaseTipo ;
         Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
         Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
      }
      zm4E191( -7) ;
      onLoadActions4E191( ) ;
      addRow4E191( ) ;
      scanKeyEnd4E191( ) ;
      if ( RcdFound191 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4E191( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert4E191( ) ;
      }
      else
      {
         if ( RcdFound191 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1427EmpBaseClaseLeg != Z1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, Z1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, Z1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, Z1431EmpBaseCod2) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A1427EmpBaseClaseLeg = Z1427EmpBaseClaseLeg ;
               A1429EmpBaseTipo = Z1429EmpBaseTipo ;
               A1430EmpBaseCod1 = Z1430EmpBaseCod1 ;
               A1431EmpBaseCod2 = Z1431EmpBaseCod2 ;
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
               update4E191( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1427EmpBaseClaseLeg != Z1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, Z1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, Z1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, Z1431EmpBaseCod2) != 0 ) )
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
                     insert4E191( ) ;
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
                     insert4E191( ) ;
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
      RowToVars191( bcEmpresabase_calculo, 1) ;
      saveImpl( ) ;
      VarsToRow191( bcEmpresabase_calculo) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars191( bcEmpresabase_calculo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert4E191( ) ;
      afterTrn( ) ;
      VarsToRow191( bcEmpresabase_calculo) ;
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
         web.SdtEmpresabase_calculo auxBC = new web.SdtEmpresabase_calculo( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A1427EmpBaseClaseLeg, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcEmpresabase_calculo);
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
      RowToVars191( bcEmpresabase_calculo, 1) ;
      updateImpl( ) ;
      VarsToRow191( bcEmpresabase_calculo) ;
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
      RowToVars191( bcEmpresabase_calculo, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert4E191( ) ;
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
      VarsToRow191( bcEmpresabase_calculo) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars191( bcEmpresabase_calculo, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey4E191( ) ;
      if ( RcdFound191 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1427EmpBaseClaseLeg != Z1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, Z1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, Z1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, Z1431EmpBaseCod2) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A1427EmpBaseClaseLeg = Z1427EmpBaseClaseLeg ;
            A1429EmpBaseTipo = Z1429EmpBaseTipo ;
            A1430EmpBaseCod1 = Z1430EmpBaseCod1 ;
            A1431EmpBaseCod2 = Z1431EmpBaseCod2 ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1427EmpBaseClaseLeg != Z1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, Z1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, Z1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, Z1431EmpBaseCod2) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "empresabase_calculo_bc");
      VarsToRow191( bcEmpresabase_calculo) ;
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
      Gx_mode = bcEmpresabase_calculo.getgxTv_SdtEmpresabase_calculo_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcEmpresabase_calculo.setgxTv_SdtEmpresabase_calculo_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtEmpresabase_calculo sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcEmpresabase_calculo )
      {
         bcEmpresabase_calculo = sdt ;
         if ( GXutil.strcmp(bcEmpresabase_calculo.getgxTv_SdtEmpresabase_calculo_Mode(), "") == 0 )
         {
            bcEmpresabase_calculo.setgxTv_SdtEmpresabase_calculo_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow191( bcEmpresabase_calculo) ;
         }
         else
         {
            RowToVars191( bcEmpresabase_calculo, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcEmpresabase_calculo.getgxTv_SdtEmpresabase_calculo_Mode(), "") == 0 )
         {
            bcEmpresabase_calculo.setgxTv_SdtEmpresabase_calculo_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars191( bcEmpresabase_calculo, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtEmpresabase_calculo getEmpresabase_calculo_BC( )
   {
      return bcEmpresabase_calculo ;
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
      Z1429EmpBaseTipo = "" ;
      A1429EmpBaseTipo = "" ;
      Z1430EmpBaseCod1 = "" ;
      A1430EmpBaseCod1 = "" ;
      Z1431EmpBaseCod2 = "" ;
      A1431EmpBaseCod2 = "" ;
      AV13WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV41Pgmname = "" ;
      AV16TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV17WebSession = httpContext.getWebSession();
      Z1432EmpBasePlus = DecimalUtil.ZERO ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      Z1439EmpBasePromTCnt = "" ;
      A1439EmpBasePromTCnt = "" ;
      Z1515EmpBaseC1Txt = "" ;
      A1515EmpBaseC1Txt = "" ;
      Z1516EmpBaseC2Txt = "" ;
      A1516EmpBaseC2Txt = "" ;
      GXv_int5 = new int[1] ;
      BC004E5_A1427EmpBaseClaseLeg = new byte[1] ;
      BC004E5_A1429EmpBaseTipo = new String[] {""} ;
      BC004E5_A1430EmpBaseCod1 = new String[] {""} ;
      BC004E5_A1431EmpBaseCod2 = new String[] {""} ;
      BC004E5_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004E5_A1517EmpLicDMin = new byte[1] ;
      BC004E5_n1517EmpLicDMin = new boolean[] {false} ;
      BC004E5_A1502EmpLicDLim = new short[1] ;
      BC004E5_n1502EmpLicDLim = new boolean[] {false} ;
      BC004E5_A1503EmpLicDSeman = new byte[1] ;
      BC004E5_n1503EmpLicDSeman = new boolean[] {false} ;
      BC004E5_A1504EmpLicDMes = new byte[1] ;
      BC004E5_n1504EmpLicDMes = new boolean[] {false} ;
      BC004E5_A1505EmpLicDSemes = new short[1] ;
      BC004E5_n1505EmpLicDSemes = new boolean[] {false} ;
      BC004E5_A1506EmpLicDAnual = new short[1] ;
      BC004E5_n1506EmpLicDAnual = new boolean[] {false} ;
      BC004E5_A1507EmpLicAdju = new boolean[] {false} ;
      BC004E5_n1507EmpLicAdju = new boolean[] {false} ;
      BC004E5_A1508EmpLicAdjuObl = new boolean[] {false} ;
      BC004E5_n1508EmpLicAdjuObl = new boolean[] {false} ;
      BC004E5_A1509EmpLicNecAut = new boolean[] {false} ;
      BC004E5_n1509EmpLicNecAut = new boolean[] {false} ;
      BC004E5_A1510EmpLicIngMot = new boolean[] {false} ;
      BC004E5_n1510EmpLicIngMot = new boolean[] {false} ;
      BC004E5_A1511EmpLicMotObl = new boolean[] {false} ;
      BC004E5_n1511EmpLicMotObl = new boolean[] {false} ;
      BC004E5_A1518EmpBaseOrd = new short[1] ;
      BC004E5_n1518EmpBaseOrd = new boolean[] {false} ;
      BC004E5_A1437EmpBasePromCnt1 = new short[1] ;
      BC004E5_A1438EmpBasePromCnt2 = new short[1] ;
      BC004E5_A1439EmpBasePromTCnt = new String[] {""} ;
      BC004E5_A2003EmpBaseRelSec = new int[1] ;
      BC004E5_A3CliCod = new int[1] ;
      BC004E5_A1EmpCod = new short[1] ;
      BC004E6_A3CliCod = new int[1] ;
      BC004E7_A3CliCod = new int[1] ;
      BC004E7_A1EmpCod = new short[1] ;
      BC004E7_A1427EmpBaseClaseLeg = new byte[1] ;
      BC004E7_A1429EmpBaseTipo = new String[] {""} ;
      BC004E7_A1430EmpBaseCod1 = new String[] {""} ;
      BC004E7_A1431EmpBaseCod2 = new String[] {""} ;
      BC004E8_A1427EmpBaseClaseLeg = new byte[1] ;
      BC004E8_A1429EmpBaseTipo = new String[] {""} ;
      BC004E8_A1430EmpBaseCod1 = new String[] {""} ;
      BC004E8_A1431EmpBaseCod2 = new String[] {""} ;
      BC004E8_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004E8_A1517EmpLicDMin = new byte[1] ;
      BC004E8_n1517EmpLicDMin = new boolean[] {false} ;
      BC004E8_A1502EmpLicDLim = new short[1] ;
      BC004E8_n1502EmpLicDLim = new boolean[] {false} ;
      BC004E8_A1503EmpLicDSeman = new byte[1] ;
      BC004E8_n1503EmpLicDSeman = new boolean[] {false} ;
      BC004E8_A1504EmpLicDMes = new byte[1] ;
      BC004E8_n1504EmpLicDMes = new boolean[] {false} ;
      BC004E8_A1505EmpLicDSemes = new short[1] ;
      BC004E8_n1505EmpLicDSemes = new boolean[] {false} ;
      BC004E8_A1506EmpLicDAnual = new short[1] ;
      BC004E8_n1506EmpLicDAnual = new boolean[] {false} ;
      BC004E8_A1507EmpLicAdju = new boolean[] {false} ;
      BC004E8_n1507EmpLicAdju = new boolean[] {false} ;
      BC004E8_A1508EmpLicAdjuObl = new boolean[] {false} ;
      BC004E8_n1508EmpLicAdjuObl = new boolean[] {false} ;
      BC004E8_A1509EmpLicNecAut = new boolean[] {false} ;
      BC004E8_n1509EmpLicNecAut = new boolean[] {false} ;
      BC004E8_A1510EmpLicIngMot = new boolean[] {false} ;
      BC004E8_n1510EmpLicIngMot = new boolean[] {false} ;
      BC004E8_A1511EmpLicMotObl = new boolean[] {false} ;
      BC004E8_n1511EmpLicMotObl = new boolean[] {false} ;
      BC004E8_A1518EmpBaseOrd = new short[1] ;
      BC004E8_n1518EmpBaseOrd = new boolean[] {false} ;
      BC004E8_A1437EmpBasePromCnt1 = new short[1] ;
      BC004E8_A1438EmpBasePromCnt2 = new short[1] ;
      BC004E8_A1439EmpBasePromTCnt = new String[] {""} ;
      BC004E8_A2003EmpBaseRelSec = new int[1] ;
      BC004E8_A3CliCod = new int[1] ;
      BC004E8_A1EmpCod = new short[1] ;
      sMode191 = "" ;
      BC004E9_A1427EmpBaseClaseLeg = new byte[1] ;
      BC004E9_A1429EmpBaseTipo = new String[] {""} ;
      BC004E9_A1430EmpBaseCod1 = new String[] {""} ;
      BC004E9_A1431EmpBaseCod2 = new String[] {""} ;
      BC004E9_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004E9_A1517EmpLicDMin = new byte[1] ;
      BC004E9_n1517EmpLicDMin = new boolean[] {false} ;
      BC004E9_A1502EmpLicDLim = new short[1] ;
      BC004E9_n1502EmpLicDLim = new boolean[] {false} ;
      BC004E9_A1503EmpLicDSeman = new byte[1] ;
      BC004E9_n1503EmpLicDSeman = new boolean[] {false} ;
      BC004E9_A1504EmpLicDMes = new byte[1] ;
      BC004E9_n1504EmpLicDMes = new boolean[] {false} ;
      BC004E9_A1505EmpLicDSemes = new short[1] ;
      BC004E9_n1505EmpLicDSemes = new boolean[] {false} ;
      BC004E9_A1506EmpLicDAnual = new short[1] ;
      BC004E9_n1506EmpLicDAnual = new boolean[] {false} ;
      BC004E9_A1507EmpLicAdju = new boolean[] {false} ;
      BC004E9_n1507EmpLicAdju = new boolean[] {false} ;
      BC004E9_A1508EmpLicAdjuObl = new boolean[] {false} ;
      BC004E9_n1508EmpLicAdjuObl = new boolean[] {false} ;
      BC004E9_A1509EmpLicNecAut = new boolean[] {false} ;
      BC004E9_n1509EmpLicNecAut = new boolean[] {false} ;
      BC004E9_A1510EmpLicIngMot = new boolean[] {false} ;
      BC004E9_n1510EmpLicIngMot = new boolean[] {false} ;
      BC004E9_A1511EmpLicMotObl = new boolean[] {false} ;
      BC004E9_n1511EmpLicMotObl = new boolean[] {false} ;
      BC004E9_A1518EmpBaseOrd = new short[1] ;
      BC004E9_n1518EmpBaseOrd = new boolean[] {false} ;
      BC004E9_A1437EmpBasePromCnt1 = new short[1] ;
      BC004E9_A1438EmpBasePromCnt2 = new short[1] ;
      BC004E9_A1439EmpBasePromTCnt = new String[] {""} ;
      BC004E9_A2003EmpBaseRelSec = new int[1] ;
      BC004E9_A3CliCod = new int[1] ;
      BC004E9_A1EmpCod = new short[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      BC004E13_A1427EmpBaseClaseLeg = new byte[1] ;
      BC004E13_A1429EmpBaseTipo = new String[] {""} ;
      BC004E13_A1430EmpBaseCod1 = new String[] {""} ;
      BC004E13_A1431EmpBaseCod2 = new String[] {""} ;
      BC004E13_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC004E13_A1517EmpLicDMin = new byte[1] ;
      BC004E13_n1517EmpLicDMin = new boolean[] {false} ;
      BC004E13_A1502EmpLicDLim = new short[1] ;
      BC004E13_n1502EmpLicDLim = new boolean[] {false} ;
      BC004E13_A1503EmpLicDSeman = new byte[1] ;
      BC004E13_n1503EmpLicDSeman = new boolean[] {false} ;
      BC004E13_A1504EmpLicDMes = new byte[1] ;
      BC004E13_n1504EmpLicDMes = new boolean[] {false} ;
      BC004E13_A1505EmpLicDSemes = new short[1] ;
      BC004E13_n1505EmpLicDSemes = new boolean[] {false} ;
      BC004E13_A1506EmpLicDAnual = new short[1] ;
      BC004E13_n1506EmpLicDAnual = new boolean[] {false} ;
      BC004E13_A1507EmpLicAdju = new boolean[] {false} ;
      BC004E13_n1507EmpLicAdju = new boolean[] {false} ;
      BC004E13_A1508EmpLicAdjuObl = new boolean[] {false} ;
      BC004E13_n1508EmpLicAdjuObl = new boolean[] {false} ;
      BC004E13_A1509EmpLicNecAut = new boolean[] {false} ;
      BC004E13_n1509EmpLicNecAut = new boolean[] {false} ;
      BC004E13_A1510EmpLicIngMot = new boolean[] {false} ;
      BC004E13_n1510EmpLicIngMot = new boolean[] {false} ;
      BC004E13_A1511EmpLicMotObl = new boolean[] {false} ;
      BC004E13_n1511EmpLicMotObl = new boolean[] {false} ;
      BC004E13_A1518EmpBaseOrd = new short[1] ;
      BC004E13_n1518EmpBaseOrd = new boolean[] {false} ;
      BC004E13_A1437EmpBasePromCnt1 = new short[1] ;
      BC004E13_A1438EmpBasePromCnt2 = new short[1] ;
      BC004E13_A1439EmpBasePromTCnt = new String[] {""} ;
      BC004E13_A2003EmpBaseRelSec = new int[1] ;
      BC004E13_A3CliCod = new int[1] ;
      BC004E13_A1EmpCod = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC004E14_A3CliCod = new int[1] ;
      BC004E15_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabase_calculo_bc__default(),
         new Object[] {
             new Object[] {
            BC004E2_A1427EmpBaseClaseLeg, BC004E2_A1429EmpBaseTipo, BC004E2_A1430EmpBaseCod1, BC004E2_A1431EmpBaseCod2, BC004E2_A1432EmpBasePlus, BC004E2_A1517EmpLicDMin, BC004E2_n1517EmpLicDMin, BC004E2_A1502EmpLicDLim, BC004E2_n1502EmpLicDLim, BC004E2_A1503EmpLicDSeman,
            BC004E2_n1503EmpLicDSeman, BC004E2_A1504EmpLicDMes, BC004E2_n1504EmpLicDMes, BC004E2_A1505EmpLicDSemes, BC004E2_n1505EmpLicDSemes, BC004E2_A1506EmpLicDAnual, BC004E2_n1506EmpLicDAnual, BC004E2_A1507EmpLicAdju, BC004E2_n1507EmpLicAdju, BC004E2_A1508EmpLicAdjuObl,
            BC004E2_n1508EmpLicAdjuObl, BC004E2_A1509EmpLicNecAut, BC004E2_n1509EmpLicNecAut, BC004E2_A1510EmpLicIngMot, BC004E2_n1510EmpLicIngMot, BC004E2_A1511EmpLicMotObl, BC004E2_n1511EmpLicMotObl, BC004E2_A1518EmpBaseOrd, BC004E2_n1518EmpBaseOrd, BC004E2_A1437EmpBasePromCnt1,
            BC004E2_A1438EmpBasePromCnt2, BC004E2_A1439EmpBasePromTCnt, BC004E2_A2003EmpBaseRelSec, BC004E2_A3CliCod, BC004E2_A1EmpCod
            }
            , new Object[] {
            BC004E3_A1427EmpBaseClaseLeg, BC004E3_A1429EmpBaseTipo, BC004E3_A1430EmpBaseCod1, BC004E3_A1431EmpBaseCod2, BC004E3_A1432EmpBasePlus, BC004E3_A1517EmpLicDMin, BC004E3_n1517EmpLicDMin, BC004E3_A1502EmpLicDLim, BC004E3_n1502EmpLicDLim, BC004E3_A1503EmpLicDSeman,
            BC004E3_n1503EmpLicDSeman, BC004E3_A1504EmpLicDMes, BC004E3_n1504EmpLicDMes, BC004E3_A1505EmpLicDSemes, BC004E3_n1505EmpLicDSemes, BC004E3_A1506EmpLicDAnual, BC004E3_n1506EmpLicDAnual, BC004E3_A1507EmpLicAdju, BC004E3_n1507EmpLicAdju, BC004E3_A1508EmpLicAdjuObl,
            BC004E3_n1508EmpLicAdjuObl, BC004E3_A1509EmpLicNecAut, BC004E3_n1509EmpLicNecAut, BC004E3_A1510EmpLicIngMot, BC004E3_n1510EmpLicIngMot, BC004E3_A1511EmpLicMotObl, BC004E3_n1511EmpLicMotObl, BC004E3_A1518EmpBaseOrd, BC004E3_n1518EmpBaseOrd, BC004E3_A1437EmpBasePromCnt1,
            BC004E3_A1438EmpBasePromCnt2, BC004E3_A1439EmpBasePromTCnt, BC004E3_A2003EmpBaseRelSec, BC004E3_A3CliCod, BC004E3_A1EmpCod
            }
            , new Object[] {
            BC004E4_A3CliCod
            }
            , new Object[] {
            BC004E5_A1427EmpBaseClaseLeg, BC004E5_A1429EmpBaseTipo, BC004E5_A1430EmpBaseCod1, BC004E5_A1431EmpBaseCod2, BC004E5_A1432EmpBasePlus, BC004E5_A1517EmpLicDMin, BC004E5_n1517EmpLicDMin, BC004E5_A1502EmpLicDLim, BC004E5_n1502EmpLicDLim, BC004E5_A1503EmpLicDSeman,
            BC004E5_n1503EmpLicDSeman, BC004E5_A1504EmpLicDMes, BC004E5_n1504EmpLicDMes, BC004E5_A1505EmpLicDSemes, BC004E5_n1505EmpLicDSemes, BC004E5_A1506EmpLicDAnual, BC004E5_n1506EmpLicDAnual, BC004E5_A1507EmpLicAdju, BC004E5_n1507EmpLicAdju, BC004E5_A1508EmpLicAdjuObl,
            BC004E5_n1508EmpLicAdjuObl, BC004E5_A1509EmpLicNecAut, BC004E5_n1509EmpLicNecAut, BC004E5_A1510EmpLicIngMot, BC004E5_n1510EmpLicIngMot, BC004E5_A1511EmpLicMotObl, BC004E5_n1511EmpLicMotObl, BC004E5_A1518EmpBaseOrd, BC004E5_n1518EmpBaseOrd, BC004E5_A1437EmpBasePromCnt1,
            BC004E5_A1438EmpBasePromCnt2, BC004E5_A1439EmpBasePromTCnt, BC004E5_A2003EmpBaseRelSec, BC004E5_A3CliCod, BC004E5_A1EmpCod
            }
            , new Object[] {
            BC004E6_A3CliCod
            }
            , new Object[] {
            BC004E7_A3CliCod, BC004E7_A1EmpCod, BC004E7_A1427EmpBaseClaseLeg, BC004E7_A1429EmpBaseTipo, BC004E7_A1430EmpBaseCod1, BC004E7_A1431EmpBaseCod2
            }
            , new Object[] {
            BC004E8_A1427EmpBaseClaseLeg, BC004E8_A1429EmpBaseTipo, BC004E8_A1430EmpBaseCod1, BC004E8_A1431EmpBaseCod2, BC004E8_A1432EmpBasePlus, BC004E8_A1517EmpLicDMin, BC004E8_n1517EmpLicDMin, BC004E8_A1502EmpLicDLim, BC004E8_n1502EmpLicDLim, BC004E8_A1503EmpLicDSeman,
            BC004E8_n1503EmpLicDSeman, BC004E8_A1504EmpLicDMes, BC004E8_n1504EmpLicDMes, BC004E8_A1505EmpLicDSemes, BC004E8_n1505EmpLicDSemes, BC004E8_A1506EmpLicDAnual, BC004E8_n1506EmpLicDAnual, BC004E8_A1507EmpLicAdju, BC004E8_n1507EmpLicAdju, BC004E8_A1508EmpLicAdjuObl,
            BC004E8_n1508EmpLicAdjuObl, BC004E8_A1509EmpLicNecAut, BC004E8_n1509EmpLicNecAut, BC004E8_A1510EmpLicIngMot, BC004E8_n1510EmpLicIngMot, BC004E8_A1511EmpLicMotObl, BC004E8_n1511EmpLicMotObl, BC004E8_A1518EmpBaseOrd, BC004E8_n1518EmpBaseOrd, BC004E8_A1437EmpBasePromCnt1,
            BC004E8_A1438EmpBasePromCnt2, BC004E8_A1439EmpBasePromTCnt, BC004E8_A2003EmpBaseRelSec, BC004E8_A3CliCod, BC004E8_A1EmpCod
            }
            , new Object[] {
            BC004E9_A1427EmpBaseClaseLeg, BC004E9_A1429EmpBaseTipo, BC004E9_A1430EmpBaseCod1, BC004E9_A1431EmpBaseCod2, BC004E9_A1432EmpBasePlus, BC004E9_A1517EmpLicDMin, BC004E9_n1517EmpLicDMin, BC004E9_A1502EmpLicDLim, BC004E9_n1502EmpLicDLim, BC004E9_A1503EmpLicDSeman,
            BC004E9_n1503EmpLicDSeman, BC004E9_A1504EmpLicDMes, BC004E9_n1504EmpLicDMes, BC004E9_A1505EmpLicDSemes, BC004E9_n1505EmpLicDSemes, BC004E9_A1506EmpLicDAnual, BC004E9_n1506EmpLicDAnual, BC004E9_A1507EmpLicAdju, BC004E9_n1507EmpLicAdju, BC004E9_A1508EmpLicAdjuObl,
            BC004E9_n1508EmpLicAdjuObl, BC004E9_A1509EmpLicNecAut, BC004E9_n1509EmpLicNecAut, BC004E9_A1510EmpLicIngMot, BC004E9_n1510EmpLicIngMot, BC004E9_A1511EmpLicMotObl, BC004E9_n1511EmpLicMotObl, BC004E9_A1518EmpBaseOrd, BC004E9_n1518EmpBaseOrd, BC004E9_A1437EmpBasePromCnt1,
            BC004E9_A1438EmpBasePromCnt2, BC004E9_A1439EmpBasePromTCnt, BC004E9_A2003EmpBaseRelSec, BC004E9_A3CliCod, BC004E9_A1EmpCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC004E13_A1427EmpBaseClaseLeg, BC004E13_A1429EmpBaseTipo, BC004E13_A1430EmpBaseCod1, BC004E13_A1431EmpBaseCod2, BC004E13_A1432EmpBasePlus, BC004E13_A1517EmpLicDMin, BC004E13_n1517EmpLicDMin, BC004E13_A1502EmpLicDLim, BC004E13_n1502EmpLicDLim, BC004E13_A1503EmpLicDSeman,
            BC004E13_n1503EmpLicDSeman, BC004E13_A1504EmpLicDMes, BC004E13_n1504EmpLicDMes, BC004E13_A1505EmpLicDSemes, BC004E13_n1505EmpLicDSemes, BC004E13_A1506EmpLicDAnual, BC004E13_n1506EmpLicDAnual, BC004E13_A1507EmpLicAdju, BC004E13_n1507EmpLicAdju, BC004E13_A1508EmpLicAdjuObl,
            BC004E13_n1508EmpLicAdjuObl, BC004E13_A1509EmpLicNecAut, BC004E13_n1509EmpLicNecAut, BC004E13_A1510EmpLicIngMot, BC004E13_n1510EmpLicIngMot, BC004E13_A1511EmpLicMotObl, BC004E13_n1511EmpLicMotObl, BC004E13_A1518EmpBaseOrd, BC004E13_n1518EmpBaseOrd, BC004E13_A1437EmpBasePromCnt1,
            BC004E13_A1438EmpBasePromCnt2, BC004E13_A1439EmpBasePromTCnt, BC004E13_A2003EmpBaseRelSec, BC004E13_A3CliCod, BC004E13_A1EmpCod
            }
            , new Object[] {
            BC004E14_A3CliCod
            }
            , new Object[] {
            BC004E15_A3CliCod
            }
         }
      );
      AV41Pgmname = "Empresabase_calculo_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e124E2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z1427EmpBaseClaseLeg ;
   private byte A1427EmpBaseClaseLeg ;
   private byte Z1517EmpLicDMin ;
   private byte A1517EmpLicDMin ;
   private byte Z1503EmpLicDSeman ;
   private byte A1503EmpLicDSeman ;
   private byte Z1504EmpLicDMes ;
   private byte A1504EmpLicDMes ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z1502EmpLicDLim ;
   private short A1502EmpLicDLim ;
   private short Z1505EmpLicDSemes ;
   private short A1505EmpLicDSemes ;
   private short Z1506EmpLicDAnual ;
   private short A1506EmpLicDAnual ;
   private short Z1518EmpBaseOrd ;
   private short A1518EmpBaseOrd ;
   private short Z1437EmpBasePromCnt1 ;
   private short A1437EmpBasePromCnt1 ;
   private short Z1438EmpBasePromCnt2 ;
   private short A1438EmpBasePromCnt2 ;
   private short RcdFound191 ;
   private short nIsDirty_191 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int GX_JID ;
   private int Z2003EmpBaseRelSec ;
   private int A2003EmpBaseRelSec ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private java.math.BigDecimal Z1432EmpBasePlus ;
   private java.math.BigDecimal A1432EmpBasePlus ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z1429EmpBaseTipo ;
   private String A1429EmpBaseTipo ;
   private String Z1430EmpBaseCod1 ;
   private String A1430EmpBaseCod1 ;
   private String Z1431EmpBaseCod2 ;
   private String A1431EmpBaseCod2 ;
   private String AV41Pgmname ;
   private String Z1439EmpBasePromTCnt ;
   private String A1439EmpBasePromTCnt ;
   private String sMode191 ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean returnInSub ;
   private boolean AV14IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z1507EmpLicAdju ;
   private boolean A1507EmpLicAdju ;
   private boolean Z1508EmpLicAdjuObl ;
   private boolean A1508EmpLicAdjuObl ;
   private boolean Z1509EmpLicNecAut ;
   private boolean A1509EmpLicNecAut ;
   private boolean Z1510EmpLicIngMot ;
   private boolean A1510EmpLicIngMot ;
   private boolean Z1511EmpLicMotObl ;
   private boolean A1511EmpLicMotObl ;
   private boolean n1517EmpLicDMin ;
   private boolean n1502EmpLicDLim ;
   private boolean n1503EmpLicDSeman ;
   private boolean n1504EmpLicDMes ;
   private boolean n1505EmpLicDSemes ;
   private boolean n1506EmpLicDAnual ;
   private boolean n1507EmpLicAdju ;
   private boolean n1508EmpLicAdjuObl ;
   private boolean n1509EmpLicNecAut ;
   private boolean n1510EmpLicIngMot ;
   private boolean n1511EmpLicMotObl ;
   private boolean n1518EmpBaseOrd ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z1515EmpBaseC1Txt ;
   private String A1515EmpBaseC1Txt ;
   private String Z1516EmpBaseC2Txt ;
   private String A1516EmpBaseC2Txt ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV17WebSession ;
   private web.SdtEmpresabase_calculo bcEmpresabase_calculo ;
   private IDataStoreProvider pr_default ;
   private byte[] BC004E5_A1427EmpBaseClaseLeg ;
   private String[] BC004E5_A1429EmpBaseTipo ;
   private String[] BC004E5_A1430EmpBaseCod1 ;
   private String[] BC004E5_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC004E5_A1432EmpBasePlus ;
   private byte[] BC004E5_A1517EmpLicDMin ;
   private boolean[] BC004E5_n1517EmpLicDMin ;
   private short[] BC004E5_A1502EmpLicDLim ;
   private boolean[] BC004E5_n1502EmpLicDLim ;
   private byte[] BC004E5_A1503EmpLicDSeman ;
   private boolean[] BC004E5_n1503EmpLicDSeman ;
   private byte[] BC004E5_A1504EmpLicDMes ;
   private boolean[] BC004E5_n1504EmpLicDMes ;
   private short[] BC004E5_A1505EmpLicDSemes ;
   private boolean[] BC004E5_n1505EmpLicDSemes ;
   private short[] BC004E5_A1506EmpLicDAnual ;
   private boolean[] BC004E5_n1506EmpLicDAnual ;
   private boolean[] BC004E5_A1507EmpLicAdju ;
   private boolean[] BC004E5_n1507EmpLicAdju ;
   private boolean[] BC004E5_A1508EmpLicAdjuObl ;
   private boolean[] BC004E5_n1508EmpLicAdjuObl ;
   private boolean[] BC004E5_A1509EmpLicNecAut ;
   private boolean[] BC004E5_n1509EmpLicNecAut ;
   private boolean[] BC004E5_A1510EmpLicIngMot ;
   private boolean[] BC004E5_n1510EmpLicIngMot ;
   private boolean[] BC004E5_A1511EmpLicMotObl ;
   private boolean[] BC004E5_n1511EmpLicMotObl ;
   private short[] BC004E5_A1518EmpBaseOrd ;
   private boolean[] BC004E5_n1518EmpBaseOrd ;
   private short[] BC004E5_A1437EmpBasePromCnt1 ;
   private short[] BC004E5_A1438EmpBasePromCnt2 ;
   private String[] BC004E5_A1439EmpBasePromTCnt ;
   private int[] BC004E5_A2003EmpBaseRelSec ;
   private int[] BC004E5_A3CliCod ;
   private short[] BC004E5_A1EmpCod ;
   private int[] BC004E6_A3CliCod ;
   private int[] BC004E7_A3CliCod ;
   private short[] BC004E7_A1EmpCod ;
   private byte[] BC004E7_A1427EmpBaseClaseLeg ;
   private String[] BC004E7_A1429EmpBaseTipo ;
   private String[] BC004E7_A1430EmpBaseCod1 ;
   private String[] BC004E7_A1431EmpBaseCod2 ;
   private byte[] BC004E8_A1427EmpBaseClaseLeg ;
   private String[] BC004E8_A1429EmpBaseTipo ;
   private String[] BC004E8_A1430EmpBaseCod1 ;
   private String[] BC004E8_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC004E8_A1432EmpBasePlus ;
   private byte[] BC004E8_A1517EmpLicDMin ;
   private boolean[] BC004E8_n1517EmpLicDMin ;
   private short[] BC004E8_A1502EmpLicDLim ;
   private boolean[] BC004E8_n1502EmpLicDLim ;
   private byte[] BC004E8_A1503EmpLicDSeman ;
   private boolean[] BC004E8_n1503EmpLicDSeman ;
   private byte[] BC004E8_A1504EmpLicDMes ;
   private boolean[] BC004E8_n1504EmpLicDMes ;
   private short[] BC004E8_A1505EmpLicDSemes ;
   private boolean[] BC004E8_n1505EmpLicDSemes ;
   private short[] BC004E8_A1506EmpLicDAnual ;
   private boolean[] BC004E8_n1506EmpLicDAnual ;
   private boolean[] BC004E8_A1507EmpLicAdju ;
   private boolean[] BC004E8_n1507EmpLicAdju ;
   private boolean[] BC004E8_A1508EmpLicAdjuObl ;
   private boolean[] BC004E8_n1508EmpLicAdjuObl ;
   private boolean[] BC004E8_A1509EmpLicNecAut ;
   private boolean[] BC004E8_n1509EmpLicNecAut ;
   private boolean[] BC004E8_A1510EmpLicIngMot ;
   private boolean[] BC004E8_n1510EmpLicIngMot ;
   private boolean[] BC004E8_A1511EmpLicMotObl ;
   private boolean[] BC004E8_n1511EmpLicMotObl ;
   private short[] BC004E8_A1518EmpBaseOrd ;
   private boolean[] BC004E8_n1518EmpBaseOrd ;
   private short[] BC004E8_A1437EmpBasePromCnt1 ;
   private short[] BC004E8_A1438EmpBasePromCnt2 ;
   private String[] BC004E8_A1439EmpBasePromTCnt ;
   private int[] BC004E8_A2003EmpBaseRelSec ;
   private int[] BC004E8_A3CliCod ;
   private short[] BC004E8_A1EmpCod ;
   private byte[] BC004E9_A1427EmpBaseClaseLeg ;
   private String[] BC004E9_A1429EmpBaseTipo ;
   private String[] BC004E9_A1430EmpBaseCod1 ;
   private String[] BC004E9_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC004E9_A1432EmpBasePlus ;
   private byte[] BC004E9_A1517EmpLicDMin ;
   private boolean[] BC004E9_n1517EmpLicDMin ;
   private short[] BC004E9_A1502EmpLicDLim ;
   private boolean[] BC004E9_n1502EmpLicDLim ;
   private byte[] BC004E9_A1503EmpLicDSeman ;
   private boolean[] BC004E9_n1503EmpLicDSeman ;
   private byte[] BC004E9_A1504EmpLicDMes ;
   private boolean[] BC004E9_n1504EmpLicDMes ;
   private short[] BC004E9_A1505EmpLicDSemes ;
   private boolean[] BC004E9_n1505EmpLicDSemes ;
   private short[] BC004E9_A1506EmpLicDAnual ;
   private boolean[] BC004E9_n1506EmpLicDAnual ;
   private boolean[] BC004E9_A1507EmpLicAdju ;
   private boolean[] BC004E9_n1507EmpLicAdju ;
   private boolean[] BC004E9_A1508EmpLicAdjuObl ;
   private boolean[] BC004E9_n1508EmpLicAdjuObl ;
   private boolean[] BC004E9_A1509EmpLicNecAut ;
   private boolean[] BC004E9_n1509EmpLicNecAut ;
   private boolean[] BC004E9_A1510EmpLicIngMot ;
   private boolean[] BC004E9_n1510EmpLicIngMot ;
   private boolean[] BC004E9_A1511EmpLicMotObl ;
   private boolean[] BC004E9_n1511EmpLicMotObl ;
   private short[] BC004E9_A1518EmpBaseOrd ;
   private boolean[] BC004E9_n1518EmpBaseOrd ;
   private short[] BC004E9_A1437EmpBasePromCnt1 ;
   private short[] BC004E9_A1438EmpBasePromCnt2 ;
   private String[] BC004E9_A1439EmpBasePromTCnt ;
   private int[] BC004E9_A2003EmpBaseRelSec ;
   private int[] BC004E9_A3CliCod ;
   private short[] BC004E9_A1EmpCod ;
   private byte[] BC004E13_A1427EmpBaseClaseLeg ;
   private String[] BC004E13_A1429EmpBaseTipo ;
   private String[] BC004E13_A1430EmpBaseCod1 ;
   private String[] BC004E13_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC004E13_A1432EmpBasePlus ;
   private byte[] BC004E13_A1517EmpLicDMin ;
   private boolean[] BC004E13_n1517EmpLicDMin ;
   private short[] BC004E13_A1502EmpLicDLim ;
   private boolean[] BC004E13_n1502EmpLicDLim ;
   private byte[] BC004E13_A1503EmpLicDSeman ;
   private boolean[] BC004E13_n1503EmpLicDSeman ;
   private byte[] BC004E13_A1504EmpLicDMes ;
   private boolean[] BC004E13_n1504EmpLicDMes ;
   private short[] BC004E13_A1505EmpLicDSemes ;
   private boolean[] BC004E13_n1505EmpLicDSemes ;
   private short[] BC004E13_A1506EmpLicDAnual ;
   private boolean[] BC004E13_n1506EmpLicDAnual ;
   private boolean[] BC004E13_A1507EmpLicAdju ;
   private boolean[] BC004E13_n1507EmpLicAdju ;
   private boolean[] BC004E13_A1508EmpLicAdjuObl ;
   private boolean[] BC004E13_n1508EmpLicAdjuObl ;
   private boolean[] BC004E13_A1509EmpLicNecAut ;
   private boolean[] BC004E13_n1509EmpLicNecAut ;
   private boolean[] BC004E13_A1510EmpLicIngMot ;
   private boolean[] BC004E13_n1510EmpLicIngMot ;
   private boolean[] BC004E13_A1511EmpLicMotObl ;
   private boolean[] BC004E13_n1511EmpLicMotObl ;
   private short[] BC004E13_A1518EmpBaseOrd ;
   private boolean[] BC004E13_n1518EmpBaseOrd ;
   private short[] BC004E13_A1437EmpBasePromCnt1 ;
   private short[] BC004E13_A1438EmpBasePromCnt2 ;
   private String[] BC004E13_A1439EmpBasePromTCnt ;
   private int[] BC004E13_A2003EmpBaseRelSec ;
   private int[] BC004E13_A3CliCod ;
   private short[] BC004E13_A1EmpCod ;
   private int[] BC004E14_A3CliCod ;
   private int[] BC004E15_A3CliCod ;
   private byte[] BC004E2_A1427EmpBaseClaseLeg ;
   private String[] BC004E2_A1429EmpBaseTipo ;
   private String[] BC004E2_A1430EmpBaseCod1 ;
   private String[] BC004E2_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC004E2_A1432EmpBasePlus ;
   private byte[] BC004E2_A1517EmpLicDMin ;
   private short[] BC004E2_A1502EmpLicDLim ;
   private byte[] BC004E2_A1503EmpLicDSeman ;
   private byte[] BC004E2_A1504EmpLicDMes ;
   private short[] BC004E2_A1505EmpLicDSemes ;
   private short[] BC004E2_A1506EmpLicDAnual ;
   private boolean[] BC004E2_A1507EmpLicAdju ;
   private boolean[] BC004E2_A1508EmpLicAdjuObl ;
   private boolean[] BC004E2_A1509EmpLicNecAut ;
   private boolean[] BC004E2_A1510EmpLicIngMot ;
   private boolean[] BC004E2_A1511EmpLicMotObl ;
   private short[] BC004E2_A1518EmpBaseOrd ;
   private short[] BC004E2_A1437EmpBasePromCnt1 ;
   private short[] BC004E2_A1438EmpBasePromCnt2 ;
   private String[] BC004E2_A1439EmpBasePromTCnt ;
   private int[] BC004E2_A2003EmpBaseRelSec ;
   private int[] BC004E2_A3CliCod ;
   private short[] BC004E2_A1EmpCod ;
   private byte[] BC004E3_A1427EmpBaseClaseLeg ;
   private String[] BC004E3_A1429EmpBaseTipo ;
   private String[] BC004E3_A1430EmpBaseCod1 ;
   private String[] BC004E3_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] BC004E3_A1432EmpBasePlus ;
   private byte[] BC004E3_A1517EmpLicDMin ;
   private short[] BC004E3_A1502EmpLicDLim ;
   private byte[] BC004E3_A1503EmpLicDSeman ;
   private byte[] BC004E3_A1504EmpLicDMes ;
   private short[] BC004E3_A1505EmpLicDSemes ;
   private short[] BC004E3_A1506EmpLicDAnual ;
   private boolean[] BC004E3_A1507EmpLicAdju ;
   private boolean[] BC004E3_A1508EmpLicAdjuObl ;
   private boolean[] BC004E3_A1509EmpLicNecAut ;
   private boolean[] BC004E3_A1510EmpLicIngMot ;
   private boolean[] BC004E3_A1511EmpLicMotObl ;
   private short[] BC004E3_A1518EmpBaseOrd ;
   private short[] BC004E3_A1437EmpBasePromCnt1 ;
   private short[] BC004E3_A1438EmpBasePromCnt2 ;
   private String[] BC004E3_A1439EmpBasePromTCnt ;
   private int[] BC004E3_A2003EmpBaseRelSec ;
   private int[] BC004E3_A3CliCod ;
   private short[] BC004E3_A1EmpCod ;
   private int[] BC004E4_A3CliCod ;
   private boolean[] BC004E2_n1517EmpLicDMin ;
   private boolean[] BC004E2_n1502EmpLicDLim ;
   private boolean[] BC004E2_n1503EmpLicDSeman ;
   private boolean[] BC004E2_n1504EmpLicDMes ;
   private boolean[] BC004E2_n1505EmpLicDSemes ;
   private boolean[] BC004E2_n1506EmpLicDAnual ;
   private boolean[] BC004E2_n1507EmpLicAdju ;
   private boolean[] BC004E2_n1508EmpLicAdjuObl ;
   private boolean[] BC004E2_n1509EmpLicNecAut ;
   private boolean[] BC004E2_n1510EmpLicIngMot ;
   private boolean[] BC004E2_n1511EmpLicMotObl ;
   private boolean[] BC004E2_n1518EmpBaseOrd ;
   private boolean[] BC004E3_n1517EmpLicDMin ;
   private boolean[] BC004E3_n1502EmpLicDLim ;
   private boolean[] BC004E3_n1503EmpLicDSeman ;
   private boolean[] BC004E3_n1504EmpLicDMes ;
   private boolean[] BC004E3_n1505EmpLicDSemes ;
   private boolean[] BC004E3_n1506EmpLicDAnual ;
   private boolean[] BC004E3_n1507EmpLicAdju ;
   private boolean[] BC004E3_n1508EmpLicAdjuObl ;
   private boolean[] BC004E3_n1509EmpLicNecAut ;
   private boolean[] BC004E3_n1510EmpLicIngMot ;
   private boolean[] BC004E3_n1511EmpLicMotObl ;
   private boolean[] BC004E3_n1518EmpBaseOrd ;
   private web.wwpbaseobjects.SdtWWPContext AV13WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV16TrnContext ;
}

final  class empresabase_calculo_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC004E2", "SELECT EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDMin, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, CliCod, EmpCod FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?  FOR UPDATE OF Empresabase_calculo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E3", "SELECT EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDMin, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, CliCod, EmpCod FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E4", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E5", "SELECT TM1.EmpBaseClaseLeg, TM1.EmpBaseTipo, TM1.EmpBaseCod1, TM1.EmpBaseCod2, TM1.EmpBasePlus, TM1.EmpLicDMin, TM1.EmpLicDLim, TM1.EmpLicDSeman, TM1.EmpLicDMes, TM1.EmpLicDSemes, TM1.EmpLicDAnual, TM1.EmpLicAdju, TM1.EmpLicAdjuObl, TM1.EmpLicNecAut, TM1.EmpLicIngMot, TM1.EmpLicMotObl, TM1.EmpBaseOrd, TM1.EmpBasePromCnt1, TM1.EmpBasePromCnt2, TM1.EmpBasePromTCnt, TM1.EmpBaseRelSec, TM1.CliCod, TM1.EmpCod FROM Empresabase_calculo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.EmpBaseClaseLeg = ? and TM1.EmpBaseTipo = ( ?) and TM1.EmpBaseCod1 = ( ?) and TM1.EmpBaseCod2 = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpBaseClaseLeg, TM1.EmpBaseTipo, TM1.EmpBaseCod1, TM1.EmpBaseCod2 ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E6", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E7", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E8", "SELECT EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDMin, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, CliCod, EmpCod FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E9", "SELECT EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDMin, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, CliCod, EmpCod FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?  FOR UPDATE OF Empresabase_calculo",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC004E10", "SAVEPOINT gxupdate;INSERT INTO Empresabase_calculo(EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDMin, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, CliCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004E11", "SAVEPOINT gxupdate;UPDATE Empresabase_calculo SET EmpBasePlus=?, EmpLicDMin=?, EmpLicDLim=?, EmpLicDSeman=?, EmpLicDMes=?, EmpLicDSemes=?, EmpLicDAnual=?, EmpLicAdju=?, EmpLicAdjuObl=?, EmpLicNecAut=?, EmpLicIngMot=?, EmpLicMotObl=?, EmpBaseOrd=?, EmpBasePromCnt1=?, EmpBasePromCnt2=?, EmpBasePromTCnt=?, EmpBaseRelSec=?  WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC004E12", "SAVEPOINT gxupdate;DELETE FROM Empresabase_calculo  WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC004E13", "SELECT TM1.EmpBaseClaseLeg, TM1.EmpBaseTipo, TM1.EmpBaseCod1, TM1.EmpBaseCod2, TM1.EmpBasePlus, TM1.EmpLicDMin, TM1.EmpLicDLim, TM1.EmpLicDSeman, TM1.EmpLicDMes, TM1.EmpLicDSemes, TM1.EmpLicDAnual, TM1.EmpLicAdju, TM1.EmpLicAdjuObl, TM1.EmpLicNecAut, TM1.EmpLicIngMot, TM1.EmpLicMotObl, TM1.EmpBaseOrd, TM1.EmpBasePromCnt1, TM1.EmpBasePromCnt2, TM1.EmpBasePromTCnt, TM1.EmpBaseRelSec, TM1.CliCod, TM1.EmpCod FROM Empresabase_calculo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.EmpBaseClaseLeg = ? and TM1.EmpBaseTipo = ( ?) and TM1.EmpBaseCod1 = ( ?) and TM1.EmpBaseCod2 = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpBaseClaseLeg, TM1.EmpBaseTipo, TM1.EmpBaseCod1, TM1.EmpBaseCod2 ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E14", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC004E15", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 6 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
               return;
            case 7 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
               return;
            case 11 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(6, ((Number) parms[6]).byteValue());
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[8]).shortValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(8, ((Number) parms[10]).byteValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[14]).shortValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(11, ((Number) parms[16]).shortValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(12, ((Boolean) parms[18]).booleanValue());
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(13, ((Boolean) parms[20]).booleanValue());
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(14, ((Boolean) parms[22]).booleanValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(15, ((Boolean) parms[24]).booleanValue());
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(16, ((Boolean) parms[26]).booleanValue());
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(17, ((Number) parms[28]).shortValue());
               }
               stmt.setShort(18, ((Number) parms[29]).shortValue());
               stmt.setShort(19, ((Number) parms[30]).shortValue());
               stmt.setString(20, (String)parms[31], 20);
               stmt.setInt(21, ((Number) parms[32]).intValue());
               stmt.setInt(22, ((Number) parms[33]).intValue());
               stmt.setShort(23, ((Number) parms[34]).shortValue());
               return;
            case 9 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[2]).byteValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[4]).shortValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(4, ((Number) parms[6]).byteValue());
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(5, ((Number) parms[8]).byteValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[10]).shortValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[12]).shortValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(8, ((Boolean) parms[14]).booleanValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(9, ((Boolean) parms[16]).booleanValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(10, ((Boolean) parms[18]).booleanValue());
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(11, ((Boolean) parms[20]).booleanValue());
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(12, ((Boolean) parms[22]).booleanValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(13, ((Number) parms[24]).shortValue());
               }
               stmt.setShort(14, ((Number) parms[25]).shortValue());
               stmt.setShort(15, ((Number) parms[26]).shortValue());
               stmt.setString(16, (String)parms[27], 20);
               stmt.setInt(17, ((Number) parms[28]).intValue());
               stmt.setInt(18, ((Number) parms[29]).intValue());
               stmt.setShort(19, ((Number) parms[30]).shortValue());
               stmt.setByte(20, ((Number) parms[31]).byteValue());
               stmt.setString(21, (String)parms[32], 20);
               stmt.setString(22, (String)parms[33], 20);
               stmt.setString(23, (String)parms[34], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

