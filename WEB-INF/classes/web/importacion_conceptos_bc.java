package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_conceptos_bc extends GXWebPanel implements IGxSilentTrn
{
   public importacion_conceptos_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_conceptos_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_conceptos_bc.class ));
   }

   public importacion_conceptos_bc( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow2977( ) ;
      standaloneNotModal( ) ;
      initializeNonKey2977( ) ;
      standaloneModal( ) ;
      addRow2977( ) ;
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
         e11292 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1EmpCod = A1EmpCod ;
            Z88ImpLiqSec = A88ImpLiqSec ;
            Z89ImpLiqConExtCod = A89ImpLiqConExtCod ;
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

   public void confirm_290( )
   {
      beforeValidate2977( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2977( ) ;
         }
         else
         {
            checkExtendedTable2977( ) ;
            if ( AnyError == 0 )
            {
               zm2977( 21) ;
            }
            closeExtendedTableCursors2977( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e12292( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos_Insert", GXv_boolean3) ;
         importacion_conceptos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos_Update", GXv_boolean3) ;
         importacion_conceptos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_conceptos_Delete", GXv_boolean3) ;
         importacion_conceptos_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
   }

   public void e11292( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm2977( int GX_JID )
   {
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
         Z701ImpLiqConExtCodYDescrip = A701ImpLiqConExtCodYDescrip ;
         Z659ImpLiqConError = A659ImpLiqConError ;
         Z660ImpLiqConWarning = A660ImpLiqConWarning ;
         Z640ImpLiqConExtDescrip = A640ImpLiqConExtDescrip ;
         Z2186ImpLiqConExtDesSinAc = A2186ImpLiqConExtDesSinAc ;
         Z641ImpLiqConSisCod = A641ImpLiqConSisCod ;
         Z642ImpLiqConAfipCod = A642ImpLiqConAfipCod ;
         Z912ImpLiqAfipCodMasDesc = A912ImpLiqAfipCodMasDesc ;
         Z643ImpLiqSIPAApo = A643ImpLiqSIPAApo ;
         Z644ImpLiqSIPACont = A644ImpLiqSIPACont ;
         Z645ImpLiqINSSJyPApo = A645ImpLiqINSSJyPApo ;
         Z646ImpLiqINSSJyPCont = A646ImpLiqINSSJyPCont ;
         Z647ImpLiqObraSocApo = A647ImpLiqObraSocApo ;
         Z648ImpLiqObraSocCont = A648ImpLiqObraSocCont ;
         Z649ImpLiqFonSolRedApo = A649ImpLiqFonSolRedApo ;
         Z650ImpLiqFonSolRedCont = A650ImpLiqFonSolRedCont ;
         Z651ImpLiqRenateaApo = A651ImpLiqRenateaApo ;
         Z652ImpLiqRenateaCont = A652ImpLiqRenateaCont ;
         Z653ImpLiqAsigFamCont = A653ImpLiqAsigFamCont ;
         Z654ImpLiqFonNacEmpCont = A654ImpLiqFonNacEmpCont ;
         Z655ImpLiqLeyRieTrabCont = A655ImpLiqLeyRieTrabCont ;
         Z656ImpLiqRegDifApo = A656ImpLiqRegDifApo ;
         Z657ImpLiqRegEspApo = A657ImpLiqRegEspApo ;
         Z702ImpLiqConSisCodYDescrip = A702ImpLiqConSisCodYDescrip ;
         Z911ImpLiqTipoConCod = A911ImpLiqTipoConCod ;
      }
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -20 )
      {
         Z701ImpLiqConExtCodYDescrip = A701ImpLiqConExtCodYDescrip ;
         Z89ImpLiqConExtCod = A89ImpLiqConExtCod ;
         Z659ImpLiqConError = A659ImpLiqConError ;
         Z660ImpLiqConWarning = A660ImpLiqConWarning ;
         Z640ImpLiqConExtDescrip = A640ImpLiqConExtDescrip ;
         Z2186ImpLiqConExtDesSinAc = A2186ImpLiqConExtDesSinAc ;
         Z641ImpLiqConSisCod = A641ImpLiqConSisCod ;
         Z642ImpLiqConAfipCod = A642ImpLiqConAfipCod ;
         Z912ImpLiqAfipCodMasDesc = A912ImpLiqAfipCodMasDesc ;
         Z643ImpLiqSIPAApo = A643ImpLiqSIPAApo ;
         Z644ImpLiqSIPACont = A644ImpLiqSIPACont ;
         Z645ImpLiqINSSJyPApo = A645ImpLiqINSSJyPApo ;
         Z646ImpLiqINSSJyPCont = A646ImpLiqINSSJyPCont ;
         Z647ImpLiqObraSocApo = A647ImpLiqObraSocApo ;
         Z648ImpLiqObraSocCont = A648ImpLiqObraSocCont ;
         Z649ImpLiqFonSolRedApo = A649ImpLiqFonSolRedApo ;
         Z650ImpLiqFonSolRedCont = A650ImpLiqFonSolRedCont ;
         Z651ImpLiqRenateaApo = A651ImpLiqRenateaApo ;
         Z652ImpLiqRenateaCont = A652ImpLiqRenateaCont ;
         Z653ImpLiqAsigFamCont = A653ImpLiqAsigFamCont ;
         Z654ImpLiqFonNacEmpCont = A654ImpLiqFonNacEmpCont ;
         Z655ImpLiqLeyRieTrabCont = A655ImpLiqLeyRieTrabCont ;
         Z656ImpLiqRegDifApo = A656ImpLiqRegDifApo ;
         Z657ImpLiqRegEspApo = A657ImpLiqRegEspApo ;
         Z702ImpLiqConSisCodYDescrip = A702ImpLiqConSisCodYDescrip ;
         Z911ImpLiqTipoConCod = A911ImpLiqTipoConCod ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int4 = A3CliCod ;
         GXv_int5[0] = GXt_int4 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
         importacion_conceptos_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load2977( )
   {
      /* Using cursor BC00295 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound77 = (short)(1) ;
         A701ImpLiqConExtCodYDescrip = BC00295_A701ImpLiqConExtCodYDescrip[0] ;
         A659ImpLiqConError = BC00295_A659ImpLiqConError[0] ;
         A660ImpLiqConWarning = BC00295_A660ImpLiqConWarning[0] ;
         A640ImpLiqConExtDescrip = BC00295_A640ImpLiqConExtDescrip[0] ;
         A2186ImpLiqConExtDesSinAc = BC00295_A2186ImpLiqConExtDesSinAc[0] ;
         A641ImpLiqConSisCod = BC00295_A641ImpLiqConSisCod[0] ;
         A642ImpLiqConAfipCod = BC00295_A642ImpLiqConAfipCod[0] ;
         A912ImpLiqAfipCodMasDesc = BC00295_A912ImpLiqAfipCodMasDesc[0] ;
         A643ImpLiqSIPAApo = BC00295_A643ImpLiqSIPAApo[0] ;
         A644ImpLiqSIPACont = BC00295_A644ImpLiqSIPACont[0] ;
         A645ImpLiqINSSJyPApo = BC00295_A645ImpLiqINSSJyPApo[0] ;
         A646ImpLiqINSSJyPCont = BC00295_A646ImpLiqINSSJyPCont[0] ;
         A647ImpLiqObraSocApo = BC00295_A647ImpLiqObraSocApo[0] ;
         A648ImpLiqObraSocCont = BC00295_A648ImpLiqObraSocCont[0] ;
         A649ImpLiqFonSolRedApo = BC00295_A649ImpLiqFonSolRedApo[0] ;
         A650ImpLiqFonSolRedCont = BC00295_A650ImpLiqFonSolRedCont[0] ;
         A651ImpLiqRenateaApo = BC00295_A651ImpLiqRenateaApo[0] ;
         A652ImpLiqRenateaCont = BC00295_A652ImpLiqRenateaCont[0] ;
         A653ImpLiqAsigFamCont = BC00295_A653ImpLiqAsigFamCont[0] ;
         A654ImpLiqFonNacEmpCont = BC00295_A654ImpLiqFonNacEmpCont[0] ;
         A655ImpLiqLeyRieTrabCont = BC00295_A655ImpLiqLeyRieTrabCont[0] ;
         A656ImpLiqRegDifApo = BC00295_A656ImpLiqRegDifApo[0] ;
         A657ImpLiqRegEspApo = BC00295_A657ImpLiqRegEspApo[0] ;
         A702ImpLiqConSisCodYDescrip = BC00295_A702ImpLiqConSisCodYDescrip[0] ;
         A911ImpLiqTipoConCod = BC00295_A911ImpLiqTipoConCod[0] ;
         zm2977( -20) ;
      }
      pr_default.close(3);
      onLoadActions2977( ) ;
   }

   public void onLoadActions2977( )
   {
      AV24Pgmname = "importacion_conceptos_BC" ;
      A701ImpLiqConExtCodYDescrip = GXutil.trim( A89ImpLiqConExtCod) + " - " + GXutil.trim( A640ImpLiqConExtDescrip) ;
   }

   public void checkExtendedTable2977( )
   {
      nIsDirty_77 = (short)(0) ;
      standaloneModal( ) ;
      AV24Pgmname = "importacion_conceptos_BC" ;
      /* Using cursor BC00296 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      nIsDirty_77 = (short)(1) ;
      A701ImpLiqConExtCodYDescrip = GXutil.trim( A89ImpLiqConExtCod) + " - " + GXutil.trim( A640ImpLiqConExtDescrip) ;
      if ( (GXutil.strcmp("", A641ImpLiqConSisCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Concepto Sistema", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A643ImpLiqSIPAApo, "1") == 0 ) || ( GXutil.strcmp(A643ImpLiqSIPAApo, "0") == 0 ) || ( GXutil.strcmp(A643ImpLiqSIPAApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq SIPAApo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A644ImpLiqSIPACont, "1") == 0 ) || ( GXutil.strcmp(A644ImpLiqSIPACont, "0") == 0 ) || ( GXutil.strcmp(A644ImpLiqSIPACont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq SIPACont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A645ImpLiqINSSJyPApo, "1") == 0 ) || ( GXutil.strcmp(A645ImpLiqINSSJyPApo, "0") == 0 ) || ( GXutil.strcmp(A645ImpLiqINSSJyPApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq INSSJy PApo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A646ImpLiqINSSJyPCont, "1") == 0 ) || ( GXutil.strcmp(A646ImpLiqINSSJyPCont, "0") == 0 ) || ( GXutil.strcmp(A646ImpLiqINSSJyPCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq INSSJy PCont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A647ImpLiqObraSocApo, "1") == 0 ) || ( GXutil.strcmp(A647ImpLiqObraSocApo, "0") == 0 ) || ( GXutil.strcmp(A647ImpLiqObraSocApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Obra Soc Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A648ImpLiqObraSocCont, "1") == 0 ) || ( GXutil.strcmp(A648ImpLiqObraSocCont, "0") == 0 ) || ( GXutil.strcmp(A648ImpLiqObraSocCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Obra Soc Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A649ImpLiqFonSolRedApo, "1") == 0 ) || ( GXutil.strcmp(A649ImpLiqFonSolRedApo, "0") == 0 ) || ( GXutil.strcmp(A649ImpLiqFonSolRedApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Fon Sol Red Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A650ImpLiqFonSolRedCont, "1") == 0 ) || ( GXutil.strcmp(A650ImpLiqFonSolRedCont, "0") == 0 ) || ( GXutil.strcmp(A650ImpLiqFonSolRedCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Fon Sol Red Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A651ImpLiqRenateaApo, "1") == 0 ) || ( GXutil.strcmp(A651ImpLiqRenateaApo, "0") == 0 ) || ( GXutil.strcmp(A651ImpLiqRenateaApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Renatea Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A652ImpLiqRenateaCont, "1") == 0 ) || ( GXutil.strcmp(A652ImpLiqRenateaCont, "0") == 0 ) || ( GXutil.strcmp(A652ImpLiqRenateaCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Renatea Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A653ImpLiqAsigFamCont, "1") == 0 ) || ( GXutil.strcmp(A653ImpLiqAsigFamCont, "0") == 0 ) || ( GXutil.strcmp(A653ImpLiqAsigFamCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Asig Fam Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A654ImpLiqFonNacEmpCont, "1") == 0 ) || ( GXutil.strcmp(A654ImpLiqFonNacEmpCont, "0") == 0 ) || ( GXutil.strcmp(A654ImpLiqFonNacEmpCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Fon Nac Emp Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A655ImpLiqLeyRieTrabCont, "1") == 0 ) || ( GXutil.strcmp(A655ImpLiqLeyRieTrabCont, "0") == 0 ) || ( GXutil.strcmp(A655ImpLiqLeyRieTrabCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Ley Rie Trab Cont", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A656ImpLiqRegDifApo, "1") == 0 ) || ( GXutil.strcmp(A656ImpLiqRegDifApo, "0") == 0 ) || ( GXutil.strcmp(A656ImpLiqRegDifApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Reg Dif Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A657ImpLiqRegEspApo, "1") == 0 ) || ( GXutil.strcmp(A657ImpLiqRegEspApo, "0") == 0 ) || ( GXutil.strcmp(A657ImpLiqRegEspApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Imp Liq Reg Esp Apo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A911ImpLiqTipoConCod, "REM_ARG") == 0 ) || ( GXutil.strcmp(A911ImpLiqTipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A911ImpLiqTipoConCod, "DES_ARG") == 0 ) || ( GXutil.strcmp(A911ImpLiqTipoConCod, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors2977( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey2977( )
   {
      /* Using cursor BC00297 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound77 = (short)(1) ;
      }
      else
      {
         RcdFound77 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00298 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm2977( 20) ;
         RcdFound77 = (short)(1) ;
         A701ImpLiqConExtCodYDescrip = BC00298_A701ImpLiqConExtCodYDescrip[0] ;
         A89ImpLiqConExtCod = BC00298_A89ImpLiqConExtCod[0] ;
         A659ImpLiqConError = BC00298_A659ImpLiqConError[0] ;
         A660ImpLiqConWarning = BC00298_A660ImpLiqConWarning[0] ;
         A640ImpLiqConExtDescrip = BC00298_A640ImpLiqConExtDescrip[0] ;
         A2186ImpLiqConExtDesSinAc = BC00298_A2186ImpLiqConExtDesSinAc[0] ;
         A641ImpLiqConSisCod = BC00298_A641ImpLiqConSisCod[0] ;
         A642ImpLiqConAfipCod = BC00298_A642ImpLiqConAfipCod[0] ;
         A912ImpLiqAfipCodMasDesc = BC00298_A912ImpLiqAfipCodMasDesc[0] ;
         A643ImpLiqSIPAApo = BC00298_A643ImpLiqSIPAApo[0] ;
         A644ImpLiqSIPACont = BC00298_A644ImpLiqSIPACont[0] ;
         A645ImpLiqINSSJyPApo = BC00298_A645ImpLiqINSSJyPApo[0] ;
         A646ImpLiqINSSJyPCont = BC00298_A646ImpLiqINSSJyPCont[0] ;
         A647ImpLiqObraSocApo = BC00298_A647ImpLiqObraSocApo[0] ;
         A648ImpLiqObraSocCont = BC00298_A648ImpLiqObraSocCont[0] ;
         A649ImpLiqFonSolRedApo = BC00298_A649ImpLiqFonSolRedApo[0] ;
         A650ImpLiqFonSolRedCont = BC00298_A650ImpLiqFonSolRedCont[0] ;
         A651ImpLiqRenateaApo = BC00298_A651ImpLiqRenateaApo[0] ;
         A652ImpLiqRenateaCont = BC00298_A652ImpLiqRenateaCont[0] ;
         A653ImpLiqAsigFamCont = BC00298_A653ImpLiqAsigFamCont[0] ;
         A654ImpLiqFonNacEmpCont = BC00298_A654ImpLiqFonNacEmpCont[0] ;
         A655ImpLiqLeyRieTrabCont = BC00298_A655ImpLiqLeyRieTrabCont[0] ;
         A656ImpLiqRegDifApo = BC00298_A656ImpLiqRegDifApo[0] ;
         A657ImpLiqRegEspApo = BC00298_A657ImpLiqRegEspApo[0] ;
         A702ImpLiqConSisCodYDescrip = BC00298_A702ImpLiqConSisCodYDescrip[0] ;
         A911ImpLiqTipoConCod = BC00298_A911ImpLiqTipoConCod[0] ;
         A3CliCod = BC00298_A3CliCod[0] ;
         A1EmpCod = BC00298_A1EmpCod[0] ;
         A88ImpLiqSec = BC00298_A88ImpLiqSec[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z89ImpLiqConExtCod = A89ImpLiqConExtCod ;
         sMode77 = Gx_mode ;
         Gx_mode = "DSP" ;
         load2977( ) ;
         if ( AnyError == 1 )
         {
            RcdFound77 = (short)(0) ;
            initializeNonKey2977( ) ;
         }
         Gx_mode = sMode77 ;
      }
      else
      {
         RcdFound77 = (short)(0) ;
         initializeNonKey2977( ) ;
         sMode77 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode77 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey2977( ) ;
      if ( RcdFound77 == 0 )
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
      confirm_290( ) ;
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

   public void checkOptimisticConcurrency2977( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00299 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_conceptos"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z701ImpLiqConExtCodYDescrip, BC00299_A701ImpLiqConExtCodYDescrip[0]) != 0 ) || ( GXutil.strcmp(Z659ImpLiqConError, BC00299_A659ImpLiqConError[0]) != 0 ) || ( GXutil.strcmp(Z660ImpLiqConWarning, BC00299_A660ImpLiqConWarning[0]) != 0 ) || ( GXutil.strcmp(Z640ImpLiqConExtDescrip, BC00299_A640ImpLiqConExtDescrip[0]) != 0 ) || ( GXutil.strcmp(Z2186ImpLiqConExtDesSinAc, BC00299_A2186ImpLiqConExtDesSinAc[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z641ImpLiqConSisCod, BC00299_A641ImpLiqConSisCod[0]) != 0 ) || ( GXutil.strcmp(Z642ImpLiqConAfipCod, BC00299_A642ImpLiqConAfipCod[0]) != 0 ) || ( GXutil.strcmp(Z912ImpLiqAfipCodMasDesc, BC00299_A912ImpLiqAfipCodMasDesc[0]) != 0 ) || ( GXutil.strcmp(Z643ImpLiqSIPAApo, BC00299_A643ImpLiqSIPAApo[0]) != 0 ) || ( GXutil.strcmp(Z644ImpLiqSIPACont, BC00299_A644ImpLiqSIPACont[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z645ImpLiqINSSJyPApo, BC00299_A645ImpLiqINSSJyPApo[0]) != 0 ) || ( GXutil.strcmp(Z646ImpLiqINSSJyPCont, BC00299_A646ImpLiqINSSJyPCont[0]) != 0 ) || ( GXutil.strcmp(Z647ImpLiqObraSocApo, BC00299_A647ImpLiqObraSocApo[0]) != 0 ) || ( GXutil.strcmp(Z648ImpLiqObraSocCont, BC00299_A648ImpLiqObraSocCont[0]) != 0 ) || ( GXutil.strcmp(Z649ImpLiqFonSolRedApo, BC00299_A649ImpLiqFonSolRedApo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z650ImpLiqFonSolRedCont, BC00299_A650ImpLiqFonSolRedCont[0]) != 0 ) || ( GXutil.strcmp(Z651ImpLiqRenateaApo, BC00299_A651ImpLiqRenateaApo[0]) != 0 ) || ( GXutil.strcmp(Z652ImpLiqRenateaCont, BC00299_A652ImpLiqRenateaCont[0]) != 0 ) || ( GXutil.strcmp(Z653ImpLiqAsigFamCont, BC00299_A653ImpLiqAsigFamCont[0]) != 0 ) || ( GXutil.strcmp(Z654ImpLiqFonNacEmpCont, BC00299_A654ImpLiqFonNacEmpCont[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z655ImpLiqLeyRieTrabCont, BC00299_A655ImpLiqLeyRieTrabCont[0]) != 0 ) || ( GXutil.strcmp(Z656ImpLiqRegDifApo, BC00299_A656ImpLiqRegDifApo[0]) != 0 ) || ( GXutil.strcmp(Z657ImpLiqRegEspApo, BC00299_A657ImpLiqRegEspApo[0]) != 0 ) || ( GXutil.strcmp(Z702ImpLiqConSisCodYDescrip, BC00299_A702ImpLiqConSisCodYDescrip[0]) != 0 ) || ( GXutil.strcmp(Z911ImpLiqTipoConCod, BC00299_A911ImpLiqTipoConCod[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_conceptos"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2977( )
   {
      beforeValidate2977( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2977( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2977( 0) ;
         checkOptimisticConcurrency2977( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2977( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2977( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002910 */
                  pr_default.execute(8, new Object[] {A701ImpLiqConExtCodYDescrip, A89ImpLiqConExtCod, A659ImpLiqConError, A660ImpLiqConWarning, A640ImpLiqConExtDescrip, A2186ImpLiqConExtDesSinAc, A641ImpLiqConSisCod, A642ImpLiqConAfipCod, A912ImpLiqAfipCodMasDesc, A643ImpLiqSIPAApo, A644ImpLiqSIPACont, A645ImpLiqINSSJyPApo, A646ImpLiqINSSJyPCont, A647ImpLiqObraSocApo, A648ImpLiqObraSocCont, A649ImpLiqFonSolRedApo, A650ImpLiqFonSolRedCont, A651ImpLiqRenateaApo, A652ImpLiqRenateaCont, A653ImpLiqAsigFamCont, A654ImpLiqFonNacEmpCont, A655ImpLiqLeyRieTrabCont, A656ImpLiqRegDifApo, A657ImpLiqRegEspApo, A702ImpLiqConSisCodYDescrip, A911ImpLiqTipoConCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
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
            load2977( ) ;
         }
         endLevel2977( ) ;
      }
      closeExtendedTableCursors2977( ) ;
   }

   public void update2977( )
   {
      beforeValidate2977( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2977( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2977( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2977( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2977( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC002911 */
                  pr_default.execute(9, new Object[] {A701ImpLiqConExtCodYDescrip, A659ImpLiqConError, A660ImpLiqConWarning, A640ImpLiqConExtDescrip, A2186ImpLiqConExtDesSinAc, A641ImpLiqConSisCod, A642ImpLiqConAfipCod, A912ImpLiqAfipCodMasDesc, A643ImpLiqSIPAApo, A644ImpLiqSIPACont, A645ImpLiqINSSJyPApo, A646ImpLiqINSSJyPCont, A647ImpLiqObraSocApo, A648ImpLiqObraSocCont, A649ImpLiqFonSolRedApo, A650ImpLiqFonSolRedCont, A651ImpLiqRenateaApo, A652ImpLiqRenateaCont, A653ImpLiqAsigFamCont, A654ImpLiqFonNacEmpCont, A655ImpLiqLeyRieTrabCont, A656ImpLiqRegDifApo, A657ImpLiqRegEspApo, A702ImpLiqConSisCodYDescrip, A911ImpLiqTipoConCod, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_conceptos"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2977( ) ;
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
         endLevel2977( ) ;
      }
      closeExtendedTableCursors2977( ) ;
   }

   public void deferredUpdate2977( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate2977( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2977( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2977( ) ;
         afterConfirm2977( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2977( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC002912 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_conceptos");
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
      sMode77 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel2977( ) ;
      Gx_mode = sMode77 ;
   }

   public void onDeleteControls2977( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV24Pgmname = "importacion_conceptos_BC" ;
      }
   }

   public void endLevel2977( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2977( ) ;
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

   public void scanKeyStart2977( )
   {
      /* Scan By routine */
      /* Using cursor BC002913 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), A89ImpLiqConExtCod});
      RcdFound77 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound77 = (short)(1) ;
         A701ImpLiqConExtCodYDescrip = BC002913_A701ImpLiqConExtCodYDescrip[0] ;
         A89ImpLiqConExtCod = BC002913_A89ImpLiqConExtCod[0] ;
         A659ImpLiqConError = BC002913_A659ImpLiqConError[0] ;
         A660ImpLiqConWarning = BC002913_A660ImpLiqConWarning[0] ;
         A640ImpLiqConExtDescrip = BC002913_A640ImpLiqConExtDescrip[0] ;
         A2186ImpLiqConExtDesSinAc = BC002913_A2186ImpLiqConExtDesSinAc[0] ;
         A641ImpLiqConSisCod = BC002913_A641ImpLiqConSisCod[0] ;
         A642ImpLiqConAfipCod = BC002913_A642ImpLiqConAfipCod[0] ;
         A912ImpLiqAfipCodMasDesc = BC002913_A912ImpLiqAfipCodMasDesc[0] ;
         A643ImpLiqSIPAApo = BC002913_A643ImpLiqSIPAApo[0] ;
         A644ImpLiqSIPACont = BC002913_A644ImpLiqSIPACont[0] ;
         A645ImpLiqINSSJyPApo = BC002913_A645ImpLiqINSSJyPApo[0] ;
         A646ImpLiqINSSJyPCont = BC002913_A646ImpLiqINSSJyPCont[0] ;
         A647ImpLiqObraSocApo = BC002913_A647ImpLiqObraSocApo[0] ;
         A648ImpLiqObraSocCont = BC002913_A648ImpLiqObraSocCont[0] ;
         A649ImpLiqFonSolRedApo = BC002913_A649ImpLiqFonSolRedApo[0] ;
         A650ImpLiqFonSolRedCont = BC002913_A650ImpLiqFonSolRedCont[0] ;
         A651ImpLiqRenateaApo = BC002913_A651ImpLiqRenateaApo[0] ;
         A652ImpLiqRenateaCont = BC002913_A652ImpLiqRenateaCont[0] ;
         A653ImpLiqAsigFamCont = BC002913_A653ImpLiqAsigFamCont[0] ;
         A654ImpLiqFonNacEmpCont = BC002913_A654ImpLiqFonNacEmpCont[0] ;
         A655ImpLiqLeyRieTrabCont = BC002913_A655ImpLiqLeyRieTrabCont[0] ;
         A656ImpLiqRegDifApo = BC002913_A656ImpLiqRegDifApo[0] ;
         A657ImpLiqRegEspApo = BC002913_A657ImpLiqRegEspApo[0] ;
         A702ImpLiqConSisCodYDescrip = BC002913_A702ImpLiqConSisCodYDescrip[0] ;
         A911ImpLiqTipoConCod = BC002913_A911ImpLiqTipoConCod[0] ;
         A3CliCod = BC002913_A3CliCod[0] ;
         A1EmpCod = BC002913_A1EmpCod[0] ;
         A88ImpLiqSec = BC002913_A88ImpLiqSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext2977( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound77 = (short)(0) ;
      scanKeyLoad2977( ) ;
   }

   public void scanKeyLoad2977( )
   {
      sMode77 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound77 = (short)(1) ;
         A701ImpLiqConExtCodYDescrip = BC002913_A701ImpLiqConExtCodYDescrip[0] ;
         A89ImpLiqConExtCod = BC002913_A89ImpLiqConExtCod[0] ;
         A659ImpLiqConError = BC002913_A659ImpLiqConError[0] ;
         A660ImpLiqConWarning = BC002913_A660ImpLiqConWarning[0] ;
         A640ImpLiqConExtDescrip = BC002913_A640ImpLiqConExtDescrip[0] ;
         A2186ImpLiqConExtDesSinAc = BC002913_A2186ImpLiqConExtDesSinAc[0] ;
         A641ImpLiqConSisCod = BC002913_A641ImpLiqConSisCod[0] ;
         A642ImpLiqConAfipCod = BC002913_A642ImpLiqConAfipCod[0] ;
         A912ImpLiqAfipCodMasDesc = BC002913_A912ImpLiqAfipCodMasDesc[0] ;
         A643ImpLiqSIPAApo = BC002913_A643ImpLiqSIPAApo[0] ;
         A644ImpLiqSIPACont = BC002913_A644ImpLiqSIPACont[0] ;
         A645ImpLiqINSSJyPApo = BC002913_A645ImpLiqINSSJyPApo[0] ;
         A646ImpLiqINSSJyPCont = BC002913_A646ImpLiqINSSJyPCont[0] ;
         A647ImpLiqObraSocApo = BC002913_A647ImpLiqObraSocApo[0] ;
         A648ImpLiqObraSocCont = BC002913_A648ImpLiqObraSocCont[0] ;
         A649ImpLiqFonSolRedApo = BC002913_A649ImpLiqFonSolRedApo[0] ;
         A650ImpLiqFonSolRedCont = BC002913_A650ImpLiqFonSolRedCont[0] ;
         A651ImpLiqRenateaApo = BC002913_A651ImpLiqRenateaApo[0] ;
         A652ImpLiqRenateaCont = BC002913_A652ImpLiqRenateaCont[0] ;
         A653ImpLiqAsigFamCont = BC002913_A653ImpLiqAsigFamCont[0] ;
         A654ImpLiqFonNacEmpCont = BC002913_A654ImpLiqFonNacEmpCont[0] ;
         A655ImpLiqLeyRieTrabCont = BC002913_A655ImpLiqLeyRieTrabCont[0] ;
         A656ImpLiqRegDifApo = BC002913_A656ImpLiqRegDifApo[0] ;
         A657ImpLiqRegEspApo = BC002913_A657ImpLiqRegEspApo[0] ;
         A702ImpLiqConSisCodYDescrip = BC002913_A702ImpLiqConSisCodYDescrip[0] ;
         A911ImpLiqTipoConCod = BC002913_A911ImpLiqTipoConCod[0] ;
         A3CliCod = BC002913_A3CliCod[0] ;
         A1EmpCod = BC002913_A1EmpCod[0] ;
         A88ImpLiqSec = BC002913_A88ImpLiqSec[0] ;
      }
      Gx_mode = sMode77 ;
   }

   public void scanKeyEnd2977( )
   {
      pr_default.close(11);
   }

   public void afterConfirm2977( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert2977( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2977( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2977( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2977( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2977( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2977( )
   {
   }

   public void send_integrity_lvl_hashes2977( )
   {
   }

   public void addRow2977( )
   {
      VarsToRow77( bcimportacion_conceptos) ;
   }

   public void readRow2977( )
   {
      RowToVars77( bcimportacion_conceptos, 1) ;
   }

   public void initializeNonKey2977( )
   {
      A701ImpLiqConExtCodYDescrip = "" ;
      A659ImpLiqConError = "" ;
      A660ImpLiqConWarning = "" ;
      A640ImpLiqConExtDescrip = "" ;
      A2186ImpLiqConExtDesSinAc = "" ;
      A641ImpLiqConSisCod = "" ;
      A642ImpLiqConAfipCod = "" ;
      A912ImpLiqAfipCodMasDesc = "" ;
      A643ImpLiqSIPAApo = "" ;
      A644ImpLiqSIPACont = "" ;
      A645ImpLiqINSSJyPApo = "" ;
      A646ImpLiqINSSJyPCont = "" ;
      A647ImpLiqObraSocApo = "" ;
      A648ImpLiqObraSocCont = "" ;
      A649ImpLiqFonSolRedApo = "" ;
      A650ImpLiqFonSolRedCont = "" ;
      A651ImpLiqRenateaApo = "" ;
      A652ImpLiqRenateaCont = "" ;
      A653ImpLiqAsigFamCont = "" ;
      A654ImpLiqFonNacEmpCont = "" ;
      A655ImpLiqLeyRieTrabCont = "" ;
      A656ImpLiqRegDifApo = "" ;
      A657ImpLiqRegEspApo = "" ;
      A702ImpLiqConSisCodYDescrip = "" ;
      A911ImpLiqTipoConCod = "" ;
      Z701ImpLiqConExtCodYDescrip = "" ;
      Z659ImpLiqConError = "" ;
      Z660ImpLiqConWarning = "" ;
      Z640ImpLiqConExtDescrip = "" ;
      Z2186ImpLiqConExtDesSinAc = "" ;
      Z641ImpLiqConSisCod = "" ;
      Z642ImpLiqConAfipCod = "" ;
      Z912ImpLiqAfipCodMasDesc = "" ;
      Z643ImpLiqSIPAApo = "" ;
      Z644ImpLiqSIPACont = "" ;
      Z645ImpLiqINSSJyPApo = "" ;
      Z646ImpLiqINSSJyPCont = "" ;
      Z647ImpLiqObraSocApo = "" ;
      Z648ImpLiqObraSocCont = "" ;
      Z649ImpLiqFonSolRedApo = "" ;
      Z650ImpLiqFonSolRedCont = "" ;
      Z651ImpLiqRenateaApo = "" ;
      Z652ImpLiqRenateaCont = "" ;
      Z653ImpLiqAsigFamCont = "" ;
      Z654ImpLiqFonNacEmpCont = "" ;
      Z655ImpLiqLeyRieTrabCont = "" ;
      Z656ImpLiqRegDifApo = "" ;
      Z657ImpLiqRegEspApo = "" ;
      Z702ImpLiqConSisCodYDescrip = "" ;
      Z911ImpLiqTipoConCod = "" ;
   }

   public void initAll2977( )
   {
      A3CliCod = 0 ;
      A1EmpCod = (short)(0) ;
      A88ImpLiqSec = (short)(0) ;
      A89ImpLiqConExtCod = "" ;
      initializeNonKey2977( ) ;
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

   public void VarsToRow77( web.Sdtimportacion_conceptos obj77 )
   {
      obj77.setgxTv_Sdtimportacion_conceptos_Mode( Gx_mode );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip( A701ImpLiqConExtCodYDescrip );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconerror( A659ImpLiqConError );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconwarning( A660ImpLiqConWarning );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip( A640ImpLiqConExtDescrip );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac( A2186ImpLiqConExtDesSinAc );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconsiscod( A641ImpLiqConSisCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconafipcod( A642ImpLiqConAfipCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc( A912ImpLiqAfipCodMasDesc );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqsipaapo( A643ImpLiqSIPAApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqsipacont( A644ImpLiqSIPACont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo( A645ImpLiqINSSJyPApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont( A646ImpLiqINSSJyPCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo( A647ImpLiqObraSocApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont( A648ImpLiqObraSocCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo( A649ImpLiqFonSolRedApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont( A650ImpLiqFonSolRedCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo( A651ImpLiqRenateaApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqrenateacont( A652ImpLiqRenateaCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont( A653ImpLiqAsigFamCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont( A654ImpLiqFonNacEmpCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont( A655ImpLiqLeyRieTrabCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqregdifapo( A656ImpLiqRegDifApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqregespapo( A657ImpLiqRegEspApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip( A702ImpLiqConSisCodYDescrip );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod( A911ImpLiqTipoConCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Clicod( A3CliCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Empcod( A1EmpCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqsec( A88ImpLiqSec );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextcod( A89ImpLiqConExtCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Clicod_Z( Z3CliCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Empcod_Z( Z1EmpCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqsec_Z( Z88ImpLiqSec );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z( Z89ImpLiqConExtCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconerror_Z( Z659ImpLiqConError );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z( Z660ImpLiqConWarning );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z( Z640ImpLiqConExtDescrip );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z( Z2186ImpLiqConExtDesSinAc );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z( Z641ImpLiqConSisCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z( Z642ImpLiqConAfipCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z( Z912ImpLiqAfipCodMasDesc );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z( Z643ImpLiqSIPAApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z( Z644ImpLiqSIPACont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z( Z645ImpLiqINSSJyPApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z( Z646ImpLiqINSSJyPCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z( Z647ImpLiqObraSocApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z( Z648ImpLiqObraSocCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z( Z649ImpLiqFonSolRedApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z( Z650ImpLiqFonSolRedCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z( Z651ImpLiqRenateaApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z( Z652ImpLiqRenateaCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z( Z653ImpLiqAsigFamCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z( Z654ImpLiqFonNacEmpCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z( Z655ImpLiqLeyRieTrabCont );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z( Z656ImpLiqRegDifApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z( Z657ImpLiqRegEspApo );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z( Z701ImpLiqConExtCodYDescrip );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z( Z702ImpLiqConSisCodYDescrip );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z( Z911ImpLiqTipoConCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Mode( Gx_mode );
   }

   public void KeyVarsToRow77( web.Sdtimportacion_conceptos obj77 )
   {
      obj77.setgxTv_Sdtimportacion_conceptos_Clicod( A3CliCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Empcod( A1EmpCod );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqsec( A88ImpLiqSec );
      obj77.setgxTv_Sdtimportacion_conceptos_Impliqconextcod( A89ImpLiqConExtCod );
   }

   public void RowToVars77( web.Sdtimportacion_conceptos obj77 ,
                            int forceLoad )
   {
      Gx_mode = obj77.getgxTv_Sdtimportacion_conceptos_Mode() ;
      A701ImpLiqConExtCodYDescrip = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip() ;
      A659ImpLiqConError = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconerror() ;
      A660ImpLiqConWarning = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconwarning() ;
      A640ImpLiqConExtDescrip = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconextdescrip() ;
      A2186ImpLiqConExtDesSinAc = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconextdessinac() ;
      A641ImpLiqConSisCod = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconsiscod() ;
      A642ImpLiqConAfipCod = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconafipcod() ;
      A912ImpLiqAfipCodMasDesc = obj77.getgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc() ;
      A643ImpLiqSIPAApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqsipaapo() ;
      A644ImpLiqSIPACont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqsipacont() ;
      A645ImpLiqINSSJyPApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqinssjypapo() ;
      A646ImpLiqINSSJyPCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqinssjypcont() ;
      A647ImpLiqObraSocApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqobrasocapo() ;
      A648ImpLiqObraSocCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqobrasoccont() ;
      A649ImpLiqFonSolRedApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo() ;
      A650ImpLiqFonSolRedCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont() ;
      A651ImpLiqRenateaApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqrenateaapo() ;
      A652ImpLiqRenateaCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqrenateacont() ;
      A653ImpLiqAsigFamCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqasigfamcont() ;
      A654ImpLiqFonNacEmpCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont() ;
      A655ImpLiqLeyRieTrabCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont() ;
      A656ImpLiqRegDifApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqregdifapo() ;
      A657ImpLiqRegEspApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqregespapo() ;
      A702ImpLiqConSisCodYDescrip = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip() ;
      A911ImpLiqTipoConCod = obj77.getgxTv_Sdtimportacion_conceptos_Impliqtipoconcod() ;
      A3CliCod = obj77.getgxTv_Sdtimportacion_conceptos_Clicod() ;
      A1EmpCod = obj77.getgxTv_Sdtimportacion_conceptos_Empcod() ;
      A88ImpLiqSec = obj77.getgxTv_Sdtimportacion_conceptos_Impliqsec() ;
      A89ImpLiqConExtCod = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconextcod() ;
      Z3CliCod = obj77.getgxTv_Sdtimportacion_conceptos_Clicod_Z() ;
      Z1EmpCod = obj77.getgxTv_Sdtimportacion_conceptos_Empcod_Z() ;
      Z88ImpLiqSec = obj77.getgxTv_Sdtimportacion_conceptos_Impliqsec_Z() ;
      Z89ImpLiqConExtCod = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconextcod_Z() ;
      Z659ImpLiqConError = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconerror_Z() ;
      Z660ImpLiqConWarning = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconwarning_Z() ;
      Z640ImpLiqConExtDescrip = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconextdescrip_Z() ;
      Z2186ImpLiqConExtDesSinAc = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconextdessinac_Z() ;
      Z641ImpLiqConSisCod = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconsiscod_Z() ;
      Z642ImpLiqConAfipCod = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconafipcod_Z() ;
      Z912ImpLiqAfipCodMasDesc = obj77.getgxTv_Sdtimportacion_conceptos_Impliqafipcodmasdesc_Z() ;
      Z643ImpLiqSIPAApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqsipaapo_Z() ;
      Z644ImpLiqSIPACont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqsipacont_Z() ;
      Z645ImpLiqINSSJyPApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqinssjypapo_Z() ;
      Z646ImpLiqINSSJyPCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqinssjypcont_Z() ;
      Z647ImpLiqObraSocApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqobrasocapo_Z() ;
      Z648ImpLiqObraSocCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqobrasoccont_Z() ;
      Z649ImpLiqFonSolRedApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqfonsolredapo_Z() ;
      Z650ImpLiqFonSolRedCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqfonsolredcont_Z() ;
      Z651ImpLiqRenateaApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqrenateaapo_Z() ;
      Z652ImpLiqRenateaCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqrenateacont_Z() ;
      Z653ImpLiqAsigFamCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqasigfamcont_Z() ;
      Z654ImpLiqFonNacEmpCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqfonnacempcont_Z() ;
      Z655ImpLiqLeyRieTrabCont = obj77.getgxTv_Sdtimportacion_conceptos_Impliqleyrietrabcont_Z() ;
      Z656ImpLiqRegDifApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqregdifapo_Z() ;
      Z657ImpLiqRegEspApo = obj77.getgxTv_Sdtimportacion_conceptos_Impliqregespapo_Z() ;
      Z701ImpLiqConExtCodYDescrip = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconextcodydescrip_Z() ;
      Z702ImpLiqConSisCodYDescrip = obj77.getgxTv_Sdtimportacion_conceptos_Impliqconsiscodydescrip_Z() ;
      Z911ImpLiqTipoConCod = obj77.getgxTv_Sdtimportacion_conceptos_Impliqtipoconcod_Z() ;
      Gx_mode = obj77.getgxTv_Sdtimportacion_conceptos_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A88ImpLiqSec = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.SHORT)).shortValue() ;
      A89ImpLiqConExtCod = (String)getParm(obj,3) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey2977( ) ;
      scanKeyStart2977( ) ;
      if ( RcdFound77 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002914 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(12) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z89ImpLiqConExtCod = A89ImpLiqConExtCod ;
      }
      zm2977( -20) ;
      onLoadActions2977( ) ;
      addRow2977( ) ;
      scanKeyEnd2977( ) ;
      if ( RcdFound77 == 0 )
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
      RowToVars77( bcimportacion_conceptos, 0) ;
      scanKeyStart2977( ) ;
      if ( RcdFound77 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC002915 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec)});
         if ( (pr_default.getStatus(13) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "importacion_liquidaciones", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "IMPLIQSEC");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z88ImpLiqSec = A88ImpLiqSec ;
         Z89ImpLiqConExtCod = A89ImpLiqConExtCod ;
      }
      zm2977( -20) ;
      onLoadActions2977( ) ;
      addRow2977( ) ;
      scanKeyEnd2977( ) ;
      if ( RcdFound77 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2977( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert2977( ) ;
      }
      else
      {
         if ( RcdFound77 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, Z89ImpLiqConExtCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A1EmpCod = Z1EmpCod ;
               A88ImpLiqSec = Z88ImpLiqSec ;
               A89ImpLiqConExtCod = Z89ImpLiqConExtCod ;
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
               update2977( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, Z89ImpLiqConExtCod) != 0 ) )
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
                     insert2977( ) ;
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
                     insert2977( ) ;
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
      RowToVars77( bcimportacion_conceptos, 1) ;
      saveImpl( ) ;
      VarsToRow77( bcimportacion_conceptos) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars77( bcimportacion_conceptos, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2977( ) ;
      afterTrn( ) ;
      VarsToRow77( bcimportacion_conceptos) ;
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
         web.Sdtimportacion_conceptos auxBC = new web.Sdtimportacion_conceptos( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1EmpCod, A88ImpLiqSec, A89ImpLiqConExtCod);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcimportacion_conceptos);
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
      RowToVars77( bcimportacion_conceptos, 1) ;
      updateImpl( ) ;
      VarsToRow77( bcimportacion_conceptos) ;
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
      RowToVars77( bcimportacion_conceptos, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert2977( ) ;
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
      VarsToRow77( bcimportacion_conceptos) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars77( bcimportacion_conceptos, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey2977( ) ;
      if ( RcdFound77 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, Z89ImpLiqConExtCod) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A1EmpCod = Z1EmpCod ;
            A88ImpLiqSec = Z88ImpLiqSec ;
            A89ImpLiqConExtCod = Z89ImpLiqConExtCod ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A88ImpLiqSec != Z88ImpLiqSec ) || ( GXutil.strcmp(A89ImpLiqConExtCod, Z89ImpLiqConExtCod) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_conceptos_bc");
      VarsToRow77( bcimportacion_conceptos) ;
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
      Gx_mode = bcimportacion_conceptos.getgxTv_Sdtimportacion_conceptos_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcimportacion_conceptos.setgxTv_Sdtimportacion_conceptos_Mode( Gx_mode );
   }

   public void SetSDT( web.Sdtimportacion_conceptos sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcimportacion_conceptos )
      {
         bcimportacion_conceptos = sdt ;
         if ( GXutil.strcmp(bcimportacion_conceptos.getgxTv_Sdtimportacion_conceptos_Mode(), "") == 0 )
         {
            bcimportacion_conceptos.setgxTv_Sdtimportacion_conceptos_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow77( bcimportacion_conceptos) ;
         }
         else
         {
            RowToVars77( bcimportacion_conceptos, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcimportacion_conceptos.getgxTv_Sdtimportacion_conceptos_Mode(), "") == 0 )
         {
            bcimportacion_conceptos.setgxTv_Sdtimportacion_conceptos_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars77( bcimportacion_conceptos, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public Sdtimportacion_conceptos getimportacion_conceptos_BC( )
   {
      return bcimportacion_conceptos ;
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
      Z89ImpLiqConExtCod = "" ;
      A89ImpLiqConExtCod = "" ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV24Pgmname = "" ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      Z701ImpLiqConExtCodYDescrip = "" ;
      A701ImpLiqConExtCodYDescrip = "" ;
      Z659ImpLiqConError = "" ;
      A659ImpLiqConError = "" ;
      Z660ImpLiqConWarning = "" ;
      A660ImpLiqConWarning = "" ;
      Z640ImpLiqConExtDescrip = "" ;
      A640ImpLiqConExtDescrip = "" ;
      Z2186ImpLiqConExtDesSinAc = "" ;
      A2186ImpLiqConExtDesSinAc = "" ;
      Z641ImpLiqConSisCod = "" ;
      A641ImpLiqConSisCod = "" ;
      Z642ImpLiqConAfipCod = "" ;
      A642ImpLiqConAfipCod = "" ;
      Z912ImpLiqAfipCodMasDesc = "" ;
      A912ImpLiqAfipCodMasDesc = "" ;
      Z643ImpLiqSIPAApo = "" ;
      A643ImpLiqSIPAApo = "" ;
      Z644ImpLiqSIPACont = "" ;
      A644ImpLiqSIPACont = "" ;
      Z645ImpLiqINSSJyPApo = "" ;
      A645ImpLiqINSSJyPApo = "" ;
      Z646ImpLiqINSSJyPCont = "" ;
      A646ImpLiqINSSJyPCont = "" ;
      Z647ImpLiqObraSocApo = "" ;
      A647ImpLiqObraSocApo = "" ;
      Z648ImpLiqObraSocCont = "" ;
      A648ImpLiqObraSocCont = "" ;
      Z649ImpLiqFonSolRedApo = "" ;
      A649ImpLiqFonSolRedApo = "" ;
      Z650ImpLiqFonSolRedCont = "" ;
      A650ImpLiqFonSolRedCont = "" ;
      Z651ImpLiqRenateaApo = "" ;
      A651ImpLiqRenateaApo = "" ;
      Z652ImpLiqRenateaCont = "" ;
      A652ImpLiqRenateaCont = "" ;
      Z653ImpLiqAsigFamCont = "" ;
      A653ImpLiqAsigFamCont = "" ;
      Z654ImpLiqFonNacEmpCont = "" ;
      A654ImpLiqFonNacEmpCont = "" ;
      Z655ImpLiqLeyRieTrabCont = "" ;
      A655ImpLiqLeyRieTrabCont = "" ;
      Z656ImpLiqRegDifApo = "" ;
      A656ImpLiqRegDifApo = "" ;
      Z657ImpLiqRegEspApo = "" ;
      A657ImpLiqRegEspApo = "" ;
      Z702ImpLiqConSisCodYDescrip = "" ;
      A702ImpLiqConSisCodYDescrip = "" ;
      Z911ImpLiqTipoConCod = "" ;
      A911ImpLiqTipoConCod = "" ;
      GXv_int5 = new int[1] ;
      BC00295_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      BC00295_A89ImpLiqConExtCod = new String[] {""} ;
      BC00295_A659ImpLiqConError = new String[] {""} ;
      BC00295_A660ImpLiqConWarning = new String[] {""} ;
      BC00295_A640ImpLiqConExtDescrip = new String[] {""} ;
      BC00295_A2186ImpLiqConExtDesSinAc = new String[] {""} ;
      BC00295_A641ImpLiqConSisCod = new String[] {""} ;
      BC00295_A642ImpLiqConAfipCod = new String[] {""} ;
      BC00295_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      BC00295_A643ImpLiqSIPAApo = new String[] {""} ;
      BC00295_A644ImpLiqSIPACont = new String[] {""} ;
      BC00295_A645ImpLiqINSSJyPApo = new String[] {""} ;
      BC00295_A646ImpLiqINSSJyPCont = new String[] {""} ;
      BC00295_A647ImpLiqObraSocApo = new String[] {""} ;
      BC00295_A648ImpLiqObraSocCont = new String[] {""} ;
      BC00295_A649ImpLiqFonSolRedApo = new String[] {""} ;
      BC00295_A650ImpLiqFonSolRedCont = new String[] {""} ;
      BC00295_A651ImpLiqRenateaApo = new String[] {""} ;
      BC00295_A652ImpLiqRenateaCont = new String[] {""} ;
      BC00295_A653ImpLiqAsigFamCont = new String[] {""} ;
      BC00295_A654ImpLiqFonNacEmpCont = new String[] {""} ;
      BC00295_A655ImpLiqLeyRieTrabCont = new String[] {""} ;
      BC00295_A656ImpLiqRegDifApo = new String[] {""} ;
      BC00295_A657ImpLiqRegEspApo = new String[] {""} ;
      BC00295_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      BC00295_A911ImpLiqTipoConCod = new String[] {""} ;
      BC00295_A3CliCod = new int[1] ;
      BC00295_A1EmpCod = new short[1] ;
      BC00295_A88ImpLiqSec = new short[1] ;
      BC00296_A3CliCod = new int[1] ;
      BC00297_A3CliCod = new int[1] ;
      BC00297_A1EmpCod = new short[1] ;
      BC00297_A88ImpLiqSec = new short[1] ;
      BC00297_A89ImpLiqConExtCod = new String[] {""} ;
      BC00298_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      BC00298_A89ImpLiqConExtCod = new String[] {""} ;
      BC00298_A659ImpLiqConError = new String[] {""} ;
      BC00298_A660ImpLiqConWarning = new String[] {""} ;
      BC00298_A640ImpLiqConExtDescrip = new String[] {""} ;
      BC00298_A2186ImpLiqConExtDesSinAc = new String[] {""} ;
      BC00298_A641ImpLiqConSisCod = new String[] {""} ;
      BC00298_A642ImpLiqConAfipCod = new String[] {""} ;
      BC00298_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      BC00298_A643ImpLiqSIPAApo = new String[] {""} ;
      BC00298_A644ImpLiqSIPACont = new String[] {""} ;
      BC00298_A645ImpLiqINSSJyPApo = new String[] {""} ;
      BC00298_A646ImpLiqINSSJyPCont = new String[] {""} ;
      BC00298_A647ImpLiqObraSocApo = new String[] {""} ;
      BC00298_A648ImpLiqObraSocCont = new String[] {""} ;
      BC00298_A649ImpLiqFonSolRedApo = new String[] {""} ;
      BC00298_A650ImpLiqFonSolRedCont = new String[] {""} ;
      BC00298_A651ImpLiqRenateaApo = new String[] {""} ;
      BC00298_A652ImpLiqRenateaCont = new String[] {""} ;
      BC00298_A653ImpLiqAsigFamCont = new String[] {""} ;
      BC00298_A654ImpLiqFonNacEmpCont = new String[] {""} ;
      BC00298_A655ImpLiqLeyRieTrabCont = new String[] {""} ;
      BC00298_A656ImpLiqRegDifApo = new String[] {""} ;
      BC00298_A657ImpLiqRegEspApo = new String[] {""} ;
      BC00298_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      BC00298_A911ImpLiqTipoConCod = new String[] {""} ;
      BC00298_A3CliCod = new int[1] ;
      BC00298_A1EmpCod = new short[1] ;
      BC00298_A88ImpLiqSec = new short[1] ;
      sMode77 = "" ;
      BC00299_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      BC00299_A89ImpLiqConExtCod = new String[] {""} ;
      BC00299_A659ImpLiqConError = new String[] {""} ;
      BC00299_A660ImpLiqConWarning = new String[] {""} ;
      BC00299_A640ImpLiqConExtDescrip = new String[] {""} ;
      BC00299_A2186ImpLiqConExtDesSinAc = new String[] {""} ;
      BC00299_A641ImpLiqConSisCod = new String[] {""} ;
      BC00299_A642ImpLiqConAfipCod = new String[] {""} ;
      BC00299_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      BC00299_A643ImpLiqSIPAApo = new String[] {""} ;
      BC00299_A644ImpLiqSIPACont = new String[] {""} ;
      BC00299_A645ImpLiqINSSJyPApo = new String[] {""} ;
      BC00299_A646ImpLiqINSSJyPCont = new String[] {""} ;
      BC00299_A647ImpLiqObraSocApo = new String[] {""} ;
      BC00299_A648ImpLiqObraSocCont = new String[] {""} ;
      BC00299_A649ImpLiqFonSolRedApo = new String[] {""} ;
      BC00299_A650ImpLiqFonSolRedCont = new String[] {""} ;
      BC00299_A651ImpLiqRenateaApo = new String[] {""} ;
      BC00299_A652ImpLiqRenateaCont = new String[] {""} ;
      BC00299_A653ImpLiqAsigFamCont = new String[] {""} ;
      BC00299_A654ImpLiqFonNacEmpCont = new String[] {""} ;
      BC00299_A655ImpLiqLeyRieTrabCont = new String[] {""} ;
      BC00299_A656ImpLiqRegDifApo = new String[] {""} ;
      BC00299_A657ImpLiqRegEspApo = new String[] {""} ;
      BC00299_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      BC00299_A911ImpLiqTipoConCod = new String[] {""} ;
      BC00299_A3CliCod = new int[1] ;
      BC00299_A1EmpCod = new short[1] ;
      BC00299_A88ImpLiqSec = new short[1] ;
      BC002913_A701ImpLiqConExtCodYDescrip = new String[] {""} ;
      BC002913_A89ImpLiqConExtCod = new String[] {""} ;
      BC002913_A659ImpLiqConError = new String[] {""} ;
      BC002913_A660ImpLiqConWarning = new String[] {""} ;
      BC002913_A640ImpLiqConExtDescrip = new String[] {""} ;
      BC002913_A2186ImpLiqConExtDesSinAc = new String[] {""} ;
      BC002913_A641ImpLiqConSisCod = new String[] {""} ;
      BC002913_A642ImpLiqConAfipCod = new String[] {""} ;
      BC002913_A912ImpLiqAfipCodMasDesc = new String[] {""} ;
      BC002913_A643ImpLiqSIPAApo = new String[] {""} ;
      BC002913_A644ImpLiqSIPACont = new String[] {""} ;
      BC002913_A645ImpLiqINSSJyPApo = new String[] {""} ;
      BC002913_A646ImpLiqINSSJyPCont = new String[] {""} ;
      BC002913_A647ImpLiqObraSocApo = new String[] {""} ;
      BC002913_A648ImpLiqObraSocCont = new String[] {""} ;
      BC002913_A649ImpLiqFonSolRedApo = new String[] {""} ;
      BC002913_A650ImpLiqFonSolRedCont = new String[] {""} ;
      BC002913_A651ImpLiqRenateaApo = new String[] {""} ;
      BC002913_A652ImpLiqRenateaCont = new String[] {""} ;
      BC002913_A653ImpLiqAsigFamCont = new String[] {""} ;
      BC002913_A654ImpLiqFonNacEmpCont = new String[] {""} ;
      BC002913_A655ImpLiqLeyRieTrabCont = new String[] {""} ;
      BC002913_A656ImpLiqRegDifApo = new String[] {""} ;
      BC002913_A657ImpLiqRegEspApo = new String[] {""} ;
      BC002913_A702ImpLiqConSisCodYDescrip = new String[] {""} ;
      BC002913_A911ImpLiqTipoConCod = new String[] {""} ;
      BC002913_A3CliCod = new int[1] ;
      BC002913_A1EmpCod = new short[1] ;
      BC002913_A88ImpLiqSec = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC002914_A3CliCod = new int[1] ;
      BC002915_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_conceptos_bc__default(),
         new Object[] {
             new Object[] {
            BC00292_A701ImpLiqConExtCodYDescrip, BC00292_A89ImpLiqConExtCod, BC00292_A659ImpLiqConError, BC00292_A660ImpLiqConWarning, BC00292_A640ImpLiqConExtDescrip, BC00292_A2186ImpLiqConExtDesSinAc, BC00292_A641ImpLiqConSisCod, BC00292_A642ImpLiqConAfipCod, BC00292_A912ImpLiqAfipCodMasDesc, BC00292_A643ImpLiqSIPAApo,
            BC00292_A644ImpLiqSIPACont, BC00292_A645ImpLiqINSSJyPApo, BC00292_A646ImpLiqINSSJyPCont, BC00292_A647ImpLiqObraSocApo, BC00292_A648ImpLiqObraSocCont, BC00292_A649ImpLiqFonSolRedApo, BC00292_A650ImpLiqFonSolRedCont, BC00292_A651ImpLiqRenateaApo, BC00292_A652ImpLiqRenateaCont, BC00292_A653ImpLiqAsigFamCont,
            BC00292_A654ImpLiqFonNacEmpCont, BC00292_A655ImpLiqLeyRieTrabCont, BC00292_A656ImpLiqRegDifApo, BC00292_A657ImpLiqRegEspApo, BC00292_A702ImpLiqConSisCodYDescrip, BC00292_A911ImpLiqTipoConCod, BC00292_A3CliCod, BC00292_A1EmpCod, BC00292_A88ImpLiqSec
            }
            , new Object[] {
            BC00293_A701ImpLiqConExtCodYDescrip, BC00293_A89ImpLiqConExtCod, BC00293_A659ImpLiqConError, BC00293_A660ImpLiqConWarning, BC00293_A640ImpLiqConExtDescrip, BC00293_A2186ImpLiqConExtDesSinAc, BC00293_A641ImpLiqConSisCod, BC00293_A642ImpLiqConAfipCod, BC00293_A912ImpLiqAfipCodMasDesc, BC00293_A643ImpLiqSIPAApo,
            BC00293_A644ImpLiqSIPACont, BC00293_A645ImpLiqINSSJyPApo, BC00293_A646ImpLiqINSSJyPCont, BC00293_A647ImpLiqObraSocApo, BC00293_A648ImpLiqObraSocCont, BC00293_A649ImpLiqFonSolRedApo, BC00293_A650ImpLiqFonSolRedCont, BC00293_A651ImpLiqRenateaApo, BC00293_A652ImpLiqRenateaCont, BC00293_A653ImpLiqAsigFamCont,
            BC00293_A654ImpLiqFonNacEmpCont, BC00293_A655ImpLiqLeyRieTrabCont, BC00293_A656ImpLiqRegDifApo, BC00293_A657ImpLiqRegEspApo, BC00293_A702ImpLiqConSisCodYDescrip, BC00293_A911ImpLiqTipoConCod, BC00293_A3CliCod, BC00293_A1EmpCod, BC00293_A88ImpLiqSec
            }
            , new Object[] {
            BC00294_A3CliCod
            }
            , new Object[] {
            BC00295_A701ImpLiqConExtCodYDescrip, BC00295_A89ImpLiqConExtCod, BC00295_A659ImpLiqConError, BC00295_A660ImpLiqConWarning, BC00295_A640ImpLiqConExtDescrip, BC00295_A2186ImpLiqConExtDesSinAc, BC00295_A641ImpLiqConSisCod, BC00295_A642ImpLiqConAfipCod, BC00295_A912ImpLiqAfipCodMasDesc, BC00295_A643ImpLiqSIPAApo,
            BC00295_A644ImpLiqSIPACont, BC00295_A645ImpLiqINSSJyPApo, BC00295_A646ImpLiqINSSJyPCont, BC00295_A647ImpLiqObraSocApo, BC00295_A648ImpLiqObraSocCont, BC00295_A649ImpLiqFonSolRedApo, BC00295_A650ImpLiqFonSolRedCont, BC00295_A651ImpLiqRenateaApo, BC00295_A652ImpLiqRenateaCont, BC00295_A653ImpLiqAsigFamCont,
            BC00295_A654ImpLiqFonNacEmpCont, BC00295_A655ImpLiqLeyRieTrabCont, BC00295_A656ImpLiqRegDifApo, BC00295_A657ImpLiqRegEspApo, BC00295_A702ImpLiqConSisCodYDescrip, BC00295_A911ImpLiqTipoConCod, BC00295_A3CliCod, BC00295_A1EmpCod, BC00295_A88ImpLiqSec
            }
            , new Object[] {
            BC00296_A3CliCod
            }
            , new Object[] {
            BC00297_A3CliCod, BC00297_A1EmpCod, BC00297_A88ImpLiqSec, BC00297_A89ImpLiqConExtCod
            }
            , new Object[] {
            BC00298_A701ImpLiqConExtCodYDescrip, BC00298_A89ImpLiqConExtCod, BC00298_A659ImpLiqConError, BC00298_A660ImpLiqConWarning, BC00298_A640ImpLiqConExtDescrip, BC00298_A2186ImpLiqConExtDesSinAc, BC00298_A641ImpLiqConSisCod, BC00298_A642ImpLiqConAfipCod, BC00298_A912ImpLiqAfipCodMasDesc, BC00298_A643ImpLiqSIPAApo,
            BC00298_A644ImpLiqSIPACont, BC00298_A645ImpLiqINSSJyPApo, BC00298_A646ImpLiqINSSJyPCont, BC00298_A647ImpLiqObraSocApo, BC00298_A648ImpLiqObraSocCont, BC00298_A649ImpLiqFonSolRedApo, BC00298_A650ImpLiqFonSolRedCont, BC00298_A651ImpLiqRenateaApo, BC00298_A652ImpLiqRenateaCont, BC00298_A653ImpLiqAsigFamCont,
            BC00298_A654ImpLiqFonNacEmpCont, BC00298_A655ImpLiqLeyRieTrabCont, BC00298_A656ImpLiqRegDifApo, BC00298_A657ImpLiqRegEspApo, BC00298_A702ImpLiqConSisCodYDescrip, BC00298_A911ImpLiqTipoConCod, BC00298_A3CliCod, BC00298_A1EmpCod, BC00298_A88ImpLiqSec
            }
            , new Object[] {
            BC00299_A701ImpLiqConExtCodYDescrip, BC00299_A89ImpLiqConExtCod, BC00299_A659ImpLiqConError, BC00299_A660ImpLiqConWarning, BC00299_A640ImpLiqConExtDescrip, BC00299_A2186ImpLiqConExtDesSinAc, BC00299_A641ImpLiqConSisCod, BC00299_A642ImpLiqConAfipCod, BC00299_A912ImpLiqAfipCodMasDesc, BC00299_A643ImpLiqSIPAApo,
            BC00299_A644ImpLiqSIPACont, BC00299_A645ImpLiqINSSJyPApo, BC00299_A646ImpLiqINSSJyPCont, BC00299_A647ImpLiqObraSocApo, BC00299_A648ImpLiqObraSocCont, BC00299_A649ImpLiqFonSolRedApo, BC00299_A650ImpLiqFonSolRedCont, BC00299_A651ImpLiqRenateaApo, BC00299_A652ImpLiqRenateaCont, BC00299_A653ImpLiqAsigFamCont,
            BC00299_A654ImpLiqFonNacEmpCont, BC00299_A655ImpLiqLeyRieTrabCont, BC00299_A656ImpLiqRegDifApo, BC00299_A657ImpLiqRegEspApo, BC00299_A702ImpLiqConSisCodYDescrip, BC00299_A911ImpLiqTipoConCod, BC00299_A3CliCod, BC00299_A1EmpCod, BC00299_A88ImpLiqSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC002913_A701ImpLiqConExtCodYDescrip, BC002913_A89ImpLiqConExtCod, BC002913_A659ImpLiqConError, BC002913_A660ImpLiqConWarning, BC002913_A640ImpLiqConExtDescrip, BC002913_A2186ImpLiqConExtDesSinAc, BC002913_A641ImpLiqConSisCod, BC002913_A642ImpLiqConAfipCod, BC002913_A912ImpLiqAfipCodMasDesc, BC002913_A643ImpLiqSIPAApo,
            BC002913_A644ImpLiqSIPACont, BC002913_A645ImpLiqINSSJyPApo, BC002913_A646ImpLiqINSSJyPCont, BC002913_A647ImpLiqObraSocApo, BC002913_A648ImpLiqObraSocCont, BC002913_A649ImpLiqFonSolRedApo, BC002913_A650ImpLiqFonSolRedCont, BC002913_A651ImpLiqRenateaApo, BC002913_A652ImpLiqRenateaCont, BC002913_A653ImpLiqAsigFamCont,
            BC002913_A654ImpLiqFonNacEmpCont, BC002913_A655ImpLiqLeyRieTrabCont, BC002913_A656ImpLiqRegDifApo, BC002913_A657ImpLiqRegEspApo, BC002913_A702ImpLiqConSisCodYDescrip, BC002913_A911ImpLiqTipoConCod, BC002913_A3CliCod, BC002913_A1EmpCod, BC002913_A88ImpLiqSec
            }
            , new Object[] {
            BC002914_A3CliCod
            }
            , new Object[] {
            BC002915_A3CliCod
            }
         }
      );
      AV24Pgmname = "importacion_conceptos_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12292 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1EmpCod ;
   private short A1EmpCod ;
   private short Z88ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short RcdFound77 ;
   private short nIsDirty_77 ;
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
   private String Z89ImpLiqConExtCod ;
   private String A89ImpLiqConExtCod ;
   private String AV24Pgmname ;
   private String Z641ImpLiqConSisCod ;
   private String A641ImpLiqConSisCod ;
   private String Z642ImpLiqConAfipCod ;
   private String A642ImpLiqConAfipCod ;
   private String Z643ImpLiqSIPAApo ;
   private String A643ImpLiqSIPAApo ;
   private String Z644ImpLiqSIPACont ;
   private String A644ImpLiqSIPACont ;
   private String Z645ImpLiqINSSJyPApo ;
   private String A645ImpLiqINSSJyPApo ;
   private String Z646ImpLiqINSSJyPCont ;
   private String A646ImpLiqINSSJyPCont ;
   private String Z647ImpLiqObraSocApo ;
   private String A647ImpLiqObraSocApo ;
   private String Z648ImpLiqObraSocCont ;
   private String A648ImpLiqObraSocCont ;
   private String Z649ImpLiqFonSolRedApo ;
   private String A649ImpLiqFonSolRedApo ;
   private String Z650ImpLiqFonSolRedCont ;
   private String A650ImpLiqFonSolRedCont ;
   private String Z651ImpLiqRenateaApo ;
   private String A651ImpLiqRenateaApo ;
   private String Z652ImpLiqRenateaCont ;
   private String A652ImpLiqRenateaCont ;
   private String Z653ImpLiqAsigFamCont ;
   private String A653ImpLiqAsigFamCont ;
   private String Z654ImpLiqFonNacEmpCont ;
   private String A654ImpLiqFonNacEmpCont ;
   private String Z655ImpLiqLeyRieTrabCont ;
   private String A655ImpLiqLeyRieTrabCont ;
   private String Z656ImpLiqRegDifApo ;
   private String A656ImpLiqRegDifApo ;
   private String Z657ImpLiqRegEspApo ;
   private String A657ImpLiqRegEspApo ;
   private String Z911ImpLiqTipoConCod ;
   private String A911ImpLiqTipoConCod ;
   private String sMode77 ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z701ImpLiqConExtCodYDescrip ;
   private String A701ImpLiqConExtCodYDescrip ;
   private String Z659ImpLiqConError ;
   private String A659ImpLiqConError ;
   private String Z660ImpLiqConWarning ;
   private String A660ImpLiqConWarning ;
   private String Z640ImpLiqConExtDescrip ;
   private String A640ImpLiqConExtDescrip ;
   private String Z2186ImpLiqConExtDesSinAc ;
   private String A2186ImpLiqConExtDesSinAc ;
   private String Z912ImpLiqAfipCodMasDesc ;
   private String A912ImpLiqAfipCodMasDesc ;
   private String Z702ImpLiqConSisCodYDescrip ;
   private String A702ImpLiqConSisCodYDescrip ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private web.Sdtimportacion_conceptos bcimportacion_conceptos ;
   private IDataStoreProvider pr_default ;
   private String[] BC00295_A701ImpLiqConExtCodYDescrip ;
   private String[] BC00295_A89ImpLiqConExtCod ;
   private String[] BC00295_A659ImpLiqConError ;
   private String[] BC00295_A660ImpLiqConWarning ;
   private String[] BC00295_A640ImpLiqConExtDescrip ;
   private String[] BC00295_A2186ImpLiqConExtDesSinAc ;
   private String[] BC00295_A641ImpLiqConSisCod ;
   private String[] BC00295_A642ImpLiqConAfipCod ;
   private String[] BC00295_A912ImpLiqAfipCodMasDesc ;
   private String[] BC00295_A643ImpLiqSIPAApo ;
   private String[] BC00295_A644ImpLiqSIPACont ;
   private String[] BC00295_A645ImpLiqINSSJyPApo ;
   private String[] BC00295_A646ImpLiqINSSJyPCont ;
   private String[] BC00295_A647ImpLiqObraSocApo ;
   private String[] BC00295_A648ImpLiqObraSocCont ;
   private String[] BC00295_A649ImpLiqFonSolRedApo ;
   private String[] BC00295_A650ImpLiqFonSolRedCont ;
   private String[] BC00295_A651ImpLiqRenateaApo ;
   private String[] BC00295_A652ImpLiqRenateaCont ;
   private String[] BC00295_A653ImpLiqAsigFamCont ;
   private String[] BC00295_A654ImpLiqFonNacEmpCont ;
   private String[] BC00295_A655ImpLiqLeyRieTrabCont ;
   private String[] BC00295_A656ImpLiqRegDifApo ;
   private String[] BC00295_A657ImpLiqRegEspApo ;
   private String[] BC00295_A702ImpLiqConSisCodYDescrip ;
   private String[] BC00295_A911ImpLiqTipoConCod ;
   private int[] BC00295_A3CliCod ;
   private short[] BC00295_A1EmpCod ;
   private short[] BC00295_A88ImpLiqSec ;
   private int[] BC00296_A3CliCod ;
   private int[] BC00297_A3CliCod ;
   private short[] BC00297_A1EmpCod ;
   private short[] BC00297_A88ImpLiqSec ;
   private String[] BC00297_A89ImpLiqConExtCod ;
   private String[] BC00298_A701ImpLiqConExtCodYDescrip ;
   private String[] BC00298_A89ImpLiqConExtCod ;
   private String[] BC00298_A659ImpLiqConError ;
   private String[] BC00298_A660ImpLiqConWarning ;
   private String[] BC00298_A640ImpLiqConExtDescrip ;
   private String[] BC00298_A2186ImpLiqConExtDesSinAc ;
   private String[] BC00298_A641ImpLiqConSisCod ;
   private String[] BC00298_A642ImpLiqConAfipCod ;
   private String[] BC00298_A912ImpLiqAfipCodMasDesc ;
   private String[] BC00298_A643ImpLiqSIPAApo ;
   private String[] BC00298_A644ImpLiqSIPACont ;
   private String[] BC00298_A645ImpLiqINSSJyPApo ;
   private String[] BC00298_A646ImpLiqINSSJyPCont ;
   private String[] BC00298_A647ImpLiqObraSocApo ;
   private String[] BC00298_A648ImpLiqObraSocCont ;
   private String[] BC00298_A649ImpLiqFonSolRedApo ;
   private String[] BC00298_A650ImpLiqFonSolRedCont ;
   private String[] BC00298_A651ImpLiqRenateaApo ;
   private String[] BC00298_A652ImpLiqRenateaCont ;
   private String[] BC00298_A653ImpLiqAsigFamCont ;
   private String[] BC00298_A654ImpLiqFonNacEmpCont ;
   private String[] BC00298_A655ImpLiqLeyRieTrabCont ;
   private String[] BC00298_A656ImpLiqRegDifApo ;
   private String[] BC00298_A657ImpLiqRegEspApo ;
   private String[] BC00298_A702ImpLiqConSisCodYDescrip ;
   private String[] BC00298_A911ImpLiqTipoConCod ;
   private int[] BC00298_A3CliCod ;
   private short[] BC00298_A1EmpCod ;
   private short[] BC00298_A88ImpLiqSec ;
   private String[] BC00299_A701ImpLiqConExtCodYDescrip ;
   private String[] BC00299_A89ImpLiqConExtCod ;
   private String[] BC00299_A659ImpLiqConError ;
   private String[] BC00299_A660ImpLiqConWarning ;
   private String[] BC00299_A640ImpLiqConExtDescrip ;
   private String[] BC00299_A2186ImpLiqConExtDesSinAc ;
   private String[] BC00299_A641ImpLiqConSisCod ;
   private String[] BC00299_A642ImpLiqConAfipCod ;
   private String[] BC00299_A912ImpLiqAfipCodMasDesc ;
   private String[] BC00299_A643ImpLiqSIPAApo ;
   private String[] BC00299_A644ImpLiqSIPACont ;
   private String[] BC00299_A645ImpLiqINSSJyPApo ;
   private String[] BC00299_A646ImpLiqINSSJyPCont ;
   private String[] BC00299_A647ImpLiqObraSocApo ;
   private String[] BC00299_A648ImpLiqObraSocCont ;
   private String[] BC00299_A649ImpLiqFonSolRedApo ;
   private String[] BC00299_A650ImpLiqFonSolRedCont ;
   private String[] BC00299_A651ImpLiqRenateaApo ;
   private String[] BC00299_A652ImpLiqRenateaCont ;
   private String[] BC00299_A653ImpLiqAsigFamCont ;
   private String[] BC00299_A654ImpLiqFonNacEmpCont ;
   private String[] BC00299_A655ImpLiqLeyRieTrabCont ;
   private String[] BC00299_A656ImpLiqRegDifApo ;
   private String[] BC00299_A657ImpLiqRegEspApo ;
   private String[] BC00299_A702ImpLiqConSisCodYDescrip ;
   private String[] BC00299_A911ImpLiqTipoConCod ;
   private int[] BC00299_A3CliCod ;
   private short[] BC00299_A1EmpCod ;
   private short[] BC00299_A88ImpLiqSec ;
   private String[] BC002913_A701ImpLiqConExtCodYDescrip ;
   private String[] BC002913_A89ImpLiqConExtCod ;
   private String[] BC002913_A659ImpLiqConError ;
   private String[] BC002913_A660ImpLiqConWarning ;
   private String[] BC002913_A640ImpLiqConExtDescrip ;
   private String[] BC002913_A2186ImpLiqConExtDesSinAc ;
   private String[] BC002913_A641ImpLiqConSisCod ;
   private String[] BC002913_A642ImpLiqConAfipCod ;
   private String[] BC002913_A912ImpLiqAfipCodMasDesc ;
   private String[] BC002913_A643ImpLiqSIPAApo ;
   private String[] BC002913_A644ImpLiqSIPACont ;
   private String[] BC002913_A645ImpLiqINSSJyPApo ;
   private String[] BC002913_A646ImpLiqINSSJyPCont ;
   private String[] BC002913_A647ImpLiqObraSocApo ;
   private String[] BC002913_A648ImpLiqObraSocCont ;
   private String[] BC002913_A649ImpLiqFonSolRedApo ;
   private String[] BC002913_A650ImpLiqFonSolRedCont ;
   private String[] BC002913_A651ImpLiqRenateaApo ;
   private String[] BC002913_A652ImpLiqRenateaCont ;
   private String[] BC002913_A653ImpLiqAsigFamCont ;
   private String[] BC002913_A654ImpLiqFonNacEmpCont ;
   private String[] BC002913_A655ImpLiqLeyRieTrabCont ;
   private String[] BC002913_A656ImpLiqRegDifApo ;
   private String[] BC002913_A657ImpLiqRegEspApo ;
   private String[] BC002913_A702ImpLiqConSisCodYDescrip ;
   private String[] BC002913_A911ImpLiqTipoConCod ;
   private int[] BC002913_A3CliCod ;
   private short[] BC002913_A1EmpCod ;
   private short[] BC002913_A88ImpLiqSec ;
   private int[] BC002914_A3CliCod ;
   private int[] BC002915_A3CliCod ;
   private String[] BC00292_A701ImpLiqConExtCodYDescrip ;
   private String[] BC00292_A89ImpLiqConExtCod ;
   private String[] BC00292_A659ImpLiqConError ;
   private String[] BC00292_A660ImpLiqConWarning ;
   private String[] BC00292_A640ImpLiqConExtDescrip ;
   private String[] BC00292_A2186ImpLiqConExtDesSinAc ;
   private String[] BC00292_A641ImpLiqConSisCod ;
   private String[] BC00292_A642ImpLiqConAfipCod ;
   private String[] BC00292_A912ImpLiqAfipCodMasDesc ;
   private String[] BC00292_A643ImpLiqSIPAApo ;
   private String[] BC00292_A644ImpLiqSIPACont ;
   private String[] BC00292_A645ImpLiqINSSJyPApo ;
   private String[] BC00292_A646ImpLiqINSSJyPCont ;
   private String[] BC00292_A647ImpLiqObraSocApo ;
   private String[] BC00292_A648ImpLiqObraSocCont ;
   private String[] BC00292_A649ImpLiqFonSolRedApo ;
   private String[] BC00292_A650ImpLiqFonSolRedCont ;
   private String[] BC00292_A651ImpLiqRenateaApo ;
   private String[] BC00292_A652ImpLiqRenateaCont ;
   private String[] BC00292_A653ImpLiqAsigFamCont ;
   private String[] BC00292_A654ImpLiqFonNacEmpCont ;
   private String[] BC00292_A655ImpLiqLeyRieTrabCont ;
   private String[] BC00292_A656ImpLiqRegDifApo ;
   private String[] BC00292_A657ImpLiqRegEspApo ;
   private String[] BC00292_A702ImpLiqConSisCodYDescrip ;
   private String[] BC00292_A911ImpLiqTipoConCod ;
   private int[] BC00292_A3CliCod ;
   private short[] BC00292_A1EmpCod ;
   private short[] BC00292_A88ImpLiqSec ;
   private String[] BC00293_A701ImpLiqConExtCodYDescrip ;
   private String[] BC00293_A89ImpLiqConExtCod ;
   private String[] BC00293_A659ImpLiqConError ;
   private String[] BC00293_A660ImpLiqConWarning ;
   private String[] BC00293_A640ImpLiqConExtDescrip ;
   private String[] BC00293_A2186ImpLiqConExtDesSinAc ;
   private String[] BC00293_A641ImpLiqConSisCod ;
   private String[] BC00293_A642ImpLiqConAfipCod ;
   private String[] BC00293_A912ImpLiqAfipCodMasDesc ;
   private String[] BC00293_A643ImpLiqSIPAApo ;
   private String[] BC00293_A644ImpLiqSIPACont ;
   private String[] BC00293_A645ImpLiqINSSJyPApo ;
   private String[] BC00293_A646ImpLiqINSSJyPCont ;
   private String[] BC00293_A647ImpLiqObraSocApo ;
   private String[] BC00293_A648ImpLiqObraSocCont ;
   private String[] BC00293_A649ImpLiqFonSolRedApo ;
   private String[] BC00293_A650ImpLiqFonSolRedCont ;
   private String[] BC00293_A651ImpLiqRenateaApo ;
   private String[] BC00293_A652ImpLiqRenateaCont ;
   private String[] BC00293_A653ImpLiqAsigFamCont ;
   private String[] BC00293_A654ImpLiqFonNacEmpCont ;
   private String[] BC00293_A655ImpLiqLeyRieTrabCont ;
   private String[] BC00293_A656ImpLiqRegDifApo ;
   private String[] BC00293_A657ImpLiqRegEspApo ;
   private String[] BC00293_A702ImpLiqConSisCodYDescrip ;
   private String[] BC00293_A911ImpLiqTipoConCod ;
   private int[] BC00293_A3CliCod ;
   private short[] BC00293_A1EmpCod ;
   private short[] BC00293_A88ImpLiqSec ;
   private int[] BC00294_A3CliCod ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
}

final  class importacion_conceptos_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00292", "SELECT ImpLiqConExtCodYDescrip, ImpLiqConExtCod, ImpLiqConError, ImpLiqConWarning, ImpLiqConExtDescrip, ImpLiqConExtDesSinAc, ImpLiqConSisCod, ImpLiqConAfipCod, ImpLiqAfipCodMasDesc, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConSisCodYDescrip, ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?  FOR UPDATE OF importacion_conceptos",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00293", "SELECT ImpLiqConExtCodYDescrip, ImpLiqConExtCod, ImpLiqConError, ImpLiqConWarning, ImpLiqConExtDescrip, ImpLiqConExtDesSinAc, ImpLiqConSisCod, ImpLiqConAfipCod, ImpLiqAfipCodMasDesc, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConSisCodYDescrip, ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00294", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00295", "SELECT TM1.ImpLiqConExtCodYDescrip, TM1.ImpLiqConExtCod, TM1.ImpLiqConError, TM1.ImpLiqConWarning, TM1.ImpLiqConExtDescrip, TM1.ImpLiqConExtDesSinAc, TM1.ImpLiqConSisCod, TM1.ImpLiqConAfipCod, TM1.ImpLiqAfipCodMasDesc, TM1.ImpLiqSIPAApo, TM1.ImpLiqSIPACont, TM1.ImpLiqINSSJyPApo, TM1.ImpLiqINSSJyPCont, TM1.ImpLiqObraSocApo, TM1.ImpLiqObraSocCont, TM1.ImpLiqFonSolRedApo, TM1.ImpLiqFonSolRedCont, TM1.ImpLiqRenateaApo, TM1.ImpLiqRenateaCont, TM1.ImpLiqAsigFamCont, TM1.ImpLiqFonNacEmpCont, TM1.ImpLiqLeyRieTrabCont, TM1.ImpLiqRegDifApo, TM1.ImpLiqRegEspApo, TM1.ImpLiqConSisCodYDescrip, TM1.ImpLiqTipoConCod, TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec FROM importacion_conceptos TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? and TM1.ImpLiqConExtCod = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec, TM1.ImpLiqConExtCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00296", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00297", "SELECT CliCod, EmpCod, ImpLiqSec, ImpLiqConExtCod FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00298", "SELECT ImpLiqConExtCodYDescrip, ImpLiqConExtCod, ImpLiqConError, ImpLiqConWarning, ImpLiqConExtDescrip, ImpLiqConExtDesSinAc, ImpLiqConSisCod, ImpLiqConAfipCod, ImpLiqAfipCodMasDesc, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConSisCodYDescrip, ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00299", "SELECT ImpLiqConExtCodYDescrip, ImpLiqConExtCod, ImpLiqConError, ImpLiqConWarning, ImpLiqConExtDescrip, ImpLiqConExtDesSinAc, ImpLiqConSisCod, ImpLiqConAfipCod, ImpLiqAfipCodMasDesc, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConSisCodYDescrip, ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec FROM importacion_conceptos WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?  FOR UPDATE OF importacion_conceptos",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC002910", "SAVEPOINT gxupdate;INSERT INTO importacion_conceptos(ImpLiqConExtCodYDescrip, ImpLiqConExtCod, ImpLiqConError, ImpLiqConWarning, ImpLiqConExtDescrip, ImpLiqConExtDesSinAc, ImpLiqConSisCod, ImpLiqConAfipCod, ImpLiqAfipCodMasDesc, ImpLiqSIPAApo, ImpLiqSIPACont, ImpLiqINSSJyPApo, ImpLiqINSSJyPCont, ImpLiqObraSocApo, ImpLiqObraSocCont, ImpLiqFonSolRedApo, ImpLiqFonSolRedCont, ImpLiqRenateaApo, ImpLiqRenateaCont, ImpLiqAsigFamCont, ImpLiqFonNacEmpCont, ImpLiqLeyRieTrabCont, ImpLiqRegDifApo, ImpLiqRegEspApo, ImpLiqConSisCodYDescrip, ImpLiqTipoConCod, CliCod, EmpCod, ImpLiqSec) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002911", "SAVEPOINT gxupdate;UPDATE importacion_conceptos SET ImpLiqConExtCodYDescrip=?, ImpLiqConError=?, ImpLiqConWarning=?, ImpLiqConExtDescrip=?, ImpLiqConExtDesSinAc=?, ImpLiqConSisCod=?, ImpLiqConAfipCod=?, ImpLiqAfipCodMasDesc=?, ImpLiqSIPAApo=?, ImpLiqSIPACont=?, ImpLiqINSSJyPApo=?, ImpLiqINSSJyPCont=?, ImpLiqObraSocApo=?, ImpLiqObraSocCont=?, ImpLiqFonSolRedApo=?, ImpLiqFonSolRedCont=?, ImpLiqRenateaApo=?, ImpLiqRenateaCont=?, ImpLiqAsigFamCont=?, ImpLiqFonNacEmpCont=?, ImpLiqLeyRieTrabCont=?, ImpLiqRegDifApo=?, ImpLiqRegEspApo=?, ImpLiqConSisCodYDescrip=?, ImpLiqTipoConCod=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC002912", "SAVEPOINT gxupdate;DELETE FROM importacion_conceptos  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqConExtCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC002913", "SELECT TM1.ImpLiqConExtCodYDescrip, TM1.ImpLiqConExtCod, TM1.ImpLiqConError, TM1.ImpLiqConWarning, TM1.ImpLiqConExtDescrip, TM1.ImpLiqConExtDesSinAc, TM1.ImpLiqConSisCod, TM1.ImpLiqConAfipCod, TM1.ImpLiqAfipCodMasDesc, TM1.ImpLiqSIPAApo, TM1.ImpLiqSIPACont, TM1.ImpLiqINSSJyPApo, TM1.ImpLiqINSSJyPCont, TM1.ImpLiqObraSocApo, TM1.ImpLiqObraSocCont, TM1.ImpLiqFonSolRedApo, TM1.ImpLiqFonSolRedCont, TM1.ImpLiqRenateaApo, TM1.ImpLiqRenateaCont, TM1.ImpLiqAsigFamCont, TM1.ImpLiqFonNacEmpCont, TM1.ImpLiqLeyRieTrabCont, TM1.ImpLiqRegDifApo, TM1.ImpLiqRegEspApo, TM1.ImpLiqConSisCodYDescrip, TM1.ImpLiqTipoConCod, TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec FROM importacion_conceptos TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.ImpLiqSec = ? and TM1.ImpLiqConExtCod = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.ImpLiqSec, TM1.ImpLiqConExtCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002914", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC002915", "SELECT CliCod FROM importacion_liquidacion WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 1);
               ((String[]) buf[13])[0] = rslt.getString(14, 1);
               ((String[]) buf[14])[0] = rslt.getString(15, 1);
               ((String[]) buf[15])[0] = rslt.getString(16, 1);
               ((String[]) buf[16])[0] = rslt.getString(17, 1);
               ((String[]) buf[17])[0] = rslt.getString(18, 1);
               ((String[]) buf[18])[0] = rslt.getString(19, 1);
               ((String[]) buf[19])[0] = rslt.getString(20, 1);
               ((String[]) buf[20])[0] = rslt.getString(21, 1);
               ((String[]) buf[21])[0] = rslt.getString(22, 1);
               ((String[]) buf[22])[0] = rslt.getString(23, 1);
               ((String[]) buf[23])[0] = rslt.getString(24, 1);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getString(26, 20);
               ((int[]) buf[26])[0] = rslt.getInt(27);
               ((short[]) buf[27])[0] = rslt.getShort(28);
               ((short[]) buf[28])[0] = rslt.getShort(29);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setVarchar(9, (String)parms[8], 200, false);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 1);
               stmt.setString(14, (String)parms[13], 1);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setString(16, (String)parms[15], 1);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 1);
               stmt.setString(19, (String)parms[18], 1);
               stmt.setString(20, (String)parms[19], 1);
               stmt.setString(21, (String)parms[20], 1);
               stmt.setString(22, (String)parms[21], 1);
               stmt.setString(23, (String)parms[22], 1);
               stmt.setString(24, (String)parms[23], 1);
               stmt.setVarchar(25, (String)parms[24], 400, false);
               stmt.setString(26, (String)parms[25], 20);
               stmt.setInt(27, ((Number) parms[26]).intValue());
               stmt.setShort(28, ((Number) parms[27]).shortValue());
               stmt.setShort(29, ((Number) parms[28]).shortValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setVarchar(8, (String)parms[7], 200, false);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 1);
               stmt.setString(14, (String)parms[13], 1);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setString(16, (String)parms[15], 1);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 1);
               stmt.setString(19, (String)parms[18], 1);
               stmt.setString(20, (String)parms[19], 1);
               stmt.setString(21, (String)parms[20], 1);
               stmt.setString(22, (String)parms[21], 1);
               stmt.setString(23, (String)parms[22], 1);
               stmt.setVarchar(24, (String)parms[23], 400, false);
               stmt.setString(25, (String)parms[24], 20);
               stmt.setInt(26, ((Number) parms[25]).intValue());
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               stmt.setShort(28, ((Number) parms[27]).shortValue());
               stmt.setString(29, (String)parms[28], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

