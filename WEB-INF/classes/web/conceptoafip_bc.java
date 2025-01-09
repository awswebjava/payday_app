package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class conceptoafip_bc extends GXWebPanel implements IGxSilentTrn
{
   public conceptoafip_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public conceptoafip_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoafip_bc.class ));
   }

   public conceptoafip_bc( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0B9( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0B9( ) ;
      standaloneModal( ) ;
      addRow0B9( ) ;
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
         e110B2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z73ConCodPropio = A73ConCodPropio ;
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

   public void confirm_0B0( )
   {
      beforeValidate0B9( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0B9( ) ;
         }
         else
         {
            checkExtendedTable0B9( ) ;
            if ( AnyError == 0 )
            {
               zm0B9( 40) ;
            }
            closeExtendedTableCursors0B9( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
      }
   }

   public void e120B2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoAFIP_Insert", GXv_boolean3) ;
         conceptoafip_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoAFIP_Update", GXv_boolean3) ;
         conceptoafip_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV11IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConceptoAFIP_Delete", GXv_boolean3) ;
         conceptoafip_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV11IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
   }

   public void e110B2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm0B9( int GX_JID )
   {
      if ( ( GX_JID == 39 ) || ( GX_JID == 0 ) )
      {
         Z383ConAfipDesc = A383ConAfipDesc ;
         Z386ConAFIPConcepto = A386ConAFIPConcepto ;
         Z134ConAFIPMarcaRep = A134ConAFIPMarcaRep ;
         Z141ConAFIPSIPAApo = A141ConAFIPSIPAApo ;
         Z142ConAFIPSIPACont = A142ConAFIPSIPACont ;
         Z131ConAFIPINSSJyPApo = A131ConAFIPINSSJyPApo ;
         Z132ConAFIPINSSJyPCont = A132ConAFIPINSSJyPCont ;
         Z135ConAFIPObraSocApo = A135ConAFIPObraSocApo ;
         Z136ConAFIPObraSocCont = A136ConAFIPObraSocCont ;
         Z129ConAFIPFonSolRedApo = A129ConAFIPFonSolRedApo ;
         Z130ConAFIPFonSolRedCont = A130ConAFIPFonSolRedCont ;
         Z139ConAFIPRenateaApo = A139ConAFIPRenateaApo ;
         Z140ConAFIPRenateaCont = A140ConAFIPRenateaCont ;
         Z127ConAFIPAsigFamCont = A127ConAFIPAsigFamCont ;
         Z128ConAFIPFonNacEmpCont = A128ConAFIPFonNacEmpCont ;
         Z133ConAFIPLeyRieTrabCont = A133ConAFIPLeyRieTrabCont ;
         Z137ConAFIPRegDifApo = A137ConAFIPRegDifApo ;
         Z138ConAFIPRegEspApo = A138ConAFIPRegEspApo ;
         Z379ConAfipEstado = A379ConAfipEstado ;
         Z380ConAFIPTipo = A380ConAFIPTipo ;
         Z381ConAfipSubT1 = A381ConAfipSubT1 ;
         Z382ConAfipSubT2 = A382ConAfipSubT2 ;
         Z703ConAFIPLiquidado = A703ConAFIPLiquidado ;
         Z389ConAFIPTipoDef = A389ConAFIPTipoDef ;
         Z390ConAfipSubT1Def = A390ConAfipSubT1Def ;
         Z391ConAfipSubT2Def = A391ConAfipSubT2Def ;
      }
      if ( ( GX_JID == 40 ) || ( GX_JID == 0 ) )
      {
         Z389ConAFIPTipoDef = A389ConAFIPTipoDef ;
         Z390ConAfipSubT1Def = A390ConAfipSubT1Def ;
         Z391ConAfipSubT2Def = A391ConAfipSubT2Def ;
      }
      if ( GX_JID == -39 )
      {
         Z383ConAfipDesc = A383ConAfipDesc ;
         Z73ConCodPropio = A73ConCodPropio ;
         Z386ConAFIPConcepto = A386ConAFIPConcepto ;
         Z134ConAFIPMarcaRep = A134ConAFIPMarcaRep ;
         Z141ConAFIPSIPAApo = A141ConAFIPSIPAApo ;
         Z142ConAFIPSIPACont = A142ConAFIPSIPACont ;
         Z131ConAFIPINSSJyPApo = A131ConAFIPINSSJyPApo ;
         Z132ConAFIPINSSJyPCont = A132ConAFIPINSSJyPCont ;
         Z135ConAFIPObraSocApo = A135ConAFIPObraSocApo ;
         Z136ConAFIPObraSocCont = A136ConAFIPObraSocCont ;
         Z129ConAFIPFonSolRedApo = A129ConAFIPFonSolRedApo ;
         Z130ConAFIPFonSolRedCont = A130ConAFIPFonSolRedCont ;
         Z139ConAFIPRenateaApo = A139ConAFIPRenateaApo ;
         Z140ConAFIPRenateaCont = A140ConAFIPRenateaCont ;
         Z127ConAFIPAsigFamCont = A127ConAFIPAsigFamCont ;
         Z128ConAFIPFonNacEmpCont = A128ConAFIPFonNacEmpCont ;
         Z133ConAFIPLeyRieTrabCont = A133ConAFIPLeyRieTrabCont ;
         Z137ConAFIPRegDifApo = A137ConAFIPRegDifApo ;
         Z138ConAFIPRegEspApo = A138ConAFIPRegEspApo ;
         Z379ConAfipEstado = A379ConAfipEstado ;
         Z380ConAFIPTipo = A380ConAFIPTipo ;
         Z381ConAfipSubT1 = A381ConAfipSubT1 ;
         Z382ConAfipSubT2 = A382ConAfipSubT2 ;
         Z703ConAFIPLiquidado = A703ConAFIPLiquidado ;
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
         conceptoafip_bc.this.GXt_int4 = GXv_int5[0] ;
         A3CliCod = GXt_int4 ;
      }
   }

   public void standaloneModal( )
   {
   }

   public void load0B9( )
   {
      /* Using cursor BC000B5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A383ConAfipDesc = BC000B5_A383ConAfipDesc[0] ;
         A386ConAFIPConcepto = BC000B5_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = BC000B5_n386ConAFIPConcepto[0] ;
         A134ConAFIPMarcaRep = BC000B5_A134ConAFIPMarcaRep[0] ;
         A141ConAFIPSIPAApo = BC000B5_A141ConAFIPSIPAApo[0] ;
         A142ConAFIPSIPACont = BC000B5_A142ConAFIPSIPACont[0] ;
         A131ConAFIPINSSJyPApo = BC000B5_A131ConAFIPINSSJyPApo[0] ;
         A132ConAFIPINSSJyPCont = BC000B5_A132ConAFIPINSSJyPCont[0] ;
         A135ConAFIPObraSocApo = BC000B5_A135ConAFIPObraSocApo[0] ;
         A136ConAFIPObraSocCont = BC000B5_A136ConAFIPObraSocCont[0] ;
         A129ConAFIPFonSolRedApo = BC000B5_A129ConAFIPFonSolRedApo[0] ;
         A130ConAFIPFonSolRedCont = BC000B5_A130ConAFIPFonSolRedCont[0] ;
         A139ConAFIPRenateaApo = BC000B5_A139ConAFIPRenateaApo[0] ;
         A140ConAFIPRenateaCont = BC000B5_A140ConAFIPRenateaCont[0] ;
         A127ConAFIPAsigFamCont = BC000B5_A127ConAFIPAsigFamCont[0] ;
         A128ConAFIPFonNacEmpCont = BC000B5_A128ConAFIPFonNacEmpCont[0] ;
         A133ConAFIPLeyRieTrabCont = BC000B5_A133ConAFIPLeyRieTrabCont[0] ;
         A137ConAFIPRegDifApo = BC000B5_A137ConAFIPRegDifApo[0] ;
         A138ConAFIPRegEspApo = BC000B5_A138ConAFIPRegEspApo[0] ;
         A379ConAfipEstado = BC000B5_A379ConAfipEstado[0] ;
         A380ConAFIPTipo = BC000B5_A380ConAFIPTipo[0] ;
         A381ConAfipSubT1 = BC000B5_A381ConAfipSubT1[0] ;
         A382ConAfipSubT2 = BC000B5_A382ConAfipSubT2[0] ;
         A703ConAFIPLiquidado = BC000B5_A703ConAFIPLiquidado[0] ;
         zm0B9( -39) ;
      }
      pr_default.close(3);
      onLoadActions0B9( ) ;
   }

   public void onLoadActions0B9( )
   {
      AV26Pgmname = "ConceptoAFIP_BC" ;
      GXt_char6 = A391ConAfipSubT2Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
      A391ConAfipSubT2Def = GXt_char6 ;
      GXt_char6 = A390ConAfipSubT1Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
      A390ConAfipSubT1Def = GXt_char6 ;
      GXt_char6 = A389ConAFIPTipoDef ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
      A389ConAFIPTipoDef = GXt_char6 ;
      GXt_char6 = A383ConAfipDesc ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
      A383ConAfipDesc = GXt_char6 ;
   }

   public void checkExtendedTable0B9( )
   {
      nIsDirty_9 = (short)(0) ;
      standaloneModal( ) ;
      AV26Pgmname = "ConceptoAFIP_BC" ;
      /* Using cursor BC000B6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(4);
      nIsDirty_9 = (short)(1) ;
      GXt_char6 = A391ConAfipSubT2Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
      A391ConAfipSubT2Def = GXt_char6 ;
      nIsDirty_9 = (short)(1) ;
      GXt_char6 = A390ConAfipSubT1Def ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
      A390ConAfipSubT1Def = GXt_char6 ;
      nIsDirty_9 = (short)(1) ;
      GXt_char6 = A389ConAFIPTipoDef ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
      A389ConAFIPTipoDef = GXt_char6 ;
      nIsDirty_9 = (short)(1) ;
      GXt_char6 = A383ConAfipDesc ;
      GXv_char7[0] = GXt_char6 ;
      new web.conceptogetdescri(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
      conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
      A383ConAfipDesc = GXt_char6 ;
      if ( ! ( ( GXutil.strcmp(A134ConAFIPMarcaRep, "1") == 0 ) || ( GXutil.strcmp(A134ConAFIPMarcaRep, "0") == 0 ) || ( GXutil.strcmp(A134ConAFIPMarcaRep, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Marce Repeticion", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A141ConAFIPSIPAApo, "1") == 0 ) || ( GXutil.strcmp(A141ConAFIPSIPAApo, "0") == 0 ) || ( GXutil.strcmp(A141ConAFIPSIPAApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SIPA Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A142ConAFIPSIPACont, "1") == 0 ) || ( GXutil.strcmp(A142ConAFIPSIPACont, "0") == 0 ) || ( GXutil.strcmp(A142ConAFIPSIPACont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "SIPA Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A131ConAFIPINSSJyPApo, "1") == 0 ) || ( GXutil.strcmp(A131ConAFIPINSSJyPApo, "0") == 0 ) || ( GXutil.strcmp(A131ConAFIPINSSJyPApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "INSSJyP Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A132ConAFIPINSSJyPCont, "1") == 0 ) || ( GXutil.strcmp(A132ConAFIPINSSJyPCont, "0") == 0 ) || ( GXutil.strcmp(A132ConAFIPINSSJyPCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "INSSJyP Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A135ConAFIPObraSocApo, "1") == 0 ) || ( GXutil.strcmp(A135ConAFIPObraSocApo, "0") == 0 ) || ( GXutil.strcmp(A135ConAFIPObraSocApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Obra Social Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A136ConAFIPObraSocCont, "1") == 0 ) || ( GXutil.strcmp(A136ConAFIPObraSocCont, "0") == 0 ) || ( GXutil.strcmp(A136ConAFIPObraSocCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Obra Social Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A129ConAFIPFonSolRedApo, "1") == 0 ) || ( GXutil.strcmp(A129ConAFIPFonSolRedApo, "0") == 0 ) || ( GXutil.strcmp(A129ConAFIPFonSolRedApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fondo Solidario Redist. Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A130ConAFIPFonSolRedCont, "1") == 0 ) || ( GXutil.strcmp(A130ConAFIPFonSolRedCont, "0") == 0 ) || ( GXutil.strcmp(A130ConAFIPFonSolRedCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fondo Solidario Redist. Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A139ConAFIPRenateaApo, "1") == 0 ) || ( GXutil.strcmp(A139ConAFIPRenateaApo, "0") == 0 ) || ( GXutil.strcmp(A139ConAFIPRenateaApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "RENATEA Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A140ConAFIPRenateaCont, "1") == 0 ) || ( GXutil.strcmp(A140ConAFIPRenateaCont, "0") == 0 ) || ( GXutil.strcmp(A140ConAFIPRenateaCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "RENATEA Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A127ConAFIPAsigFamCont, "1") == 0 ) || ( GXutil.strcmp(A127ConAFIPAsigFamCont, "0") == 0 ) || ( GXutil.strcmp(A127ConAFIPAsigFamCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Asignaciones Familiares Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A128ConAFIPFonNacEmpCont, "1") == 0 ) || ( GXutil.strcmp(A128ConAFIPFonNacEmpCont, "0") == 0 ) || ( GXutil.strcmp(A128ConAFIPFonNacEmpCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Fondo Nacional Empleo Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A133ConAFIPLeyRieTrabCont, "1") == 0 ) || ( GXutil.strcmp(A133ConAFIPLeyRieTrabCont, "0") == 0 ) || ( GXutil.strcmp(A133ConAFIPLeyRieTrabCont, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Ley Riesgos Trabajo Contribuciones", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A137ConAFIPRegDifApo, "1") == 0 ) || ( GXutil.strcmp(A137ConAFIPRegDifApo, "0") == 0 ) || ( GXutil.strcmp(A137ConAFIPRegDifApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Regimenes Diferenciales Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A138ConAFIPRegEspApo, "1") == 0 ) || ( GXutil.strcmp(A138ConAFIPRegEspApo, "0") == 0 ) || ( GXutil.strcmp(A138ConAFIPRegEspApo, "") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Regimenes Especiales Aportes", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A380ConAFIPTipo, "REM_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "DES_ARG") == 0 ) || ( GXutil.strcmp(A380ConAFIPTipo, "CAL_ARG") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Con AFIPTipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors0B9( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void getKey0B9( )
   {
      /* Using cursor BC000B7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound9 = (short)(1) ;
      }
      else
      {
         RcdFound9 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000B8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm0B9( 39) ;
         RcdFound9 = (short)(1) ;
         A383ConAfipDesc = BC000B8_A383ConAfipDesc[0] ;
         A73ConCodPropio = BC000B8_A73ConCodPropio[0] ;
         A386ConAFIPConcepto = BC000B8_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = BC000B8_n386ConAFIPConcepto[0] ;
         A134ConAFIPMarcaRep = BC000B8_A134ConAFIPMarcaRep[0] ;
         A141ConAFIPSIPAApo = BC000B8_A141ConAFIPSIPAApo[0] ;
         A142ConAFIPSIPACont = BC000B8_A142ConAFIPSIPACont[0] ;
         A131ConAFIPINSSJyPApo = BC000B8_A131ConAFIPINSSJyPApo[0] ;
         A132ConAFIPINSSJyPCont = BC000B8_A132ConAFIPINSSJyPCont[0] ;
         A135ConAFIPObraSocApo = BC000B8_A135ConAFIPObraSocApo[0] ;
         A136ConAFIPObraSocCont = BC000B8_A136ConAFIPObraSocCont[0] ;
         A129ConAFIPFonSolRedApo = BC000B8_A129ConAFIPFonSolRedApo[0] ;
         A130ConAFIPFonSolRedCont = BC000B8_A130ConAFIPFonSolRedCont[0] ;
         A139ConAFIPRenateaApo = BC000B8_A139ConAFIPRenateaApo[0] ;
         A140ConAFIPRenateaCont = BC000B8_A140ConAFIPRenateaCont[0] ;
         A127ConAFIPAsigFamCont = BC000B8_A127ConAFIPAsigFamCont[0] ;
         A128ConAFIPFonNacEmpCont = BC000B8_A128ConAFIPFonNacEmpCont[0] ;
         A133ConAFIPLeyRieTrabCont = BC000B8_A133ConAFIPLeyRieTrabCont[0] ;
         A137ConAFIPRegDifApo = BC000B8_A137ConAFIPRegDifApo[0] ;
         A138ConAFIPRegEspApo = BC000B8_A138ConAFIPRegEspApo[0] ;
         A379ConAfipEstado = BC000B8_A379ConAfipEstado[0] ;
         A380ConAFIPTipo = BC000B8_A380ConAFIPTipo[0] ;
         A381ConAfipSubT1 = BC000B8_A381ConAfipSubT1[0] ;
         A382ConAfipSubT2 = BC000B8_A382ConAfipSubT2[0] ;
         A703ConAFIPLiquidado = BC000B8_A703ConAFIPLiquidado[0] ;
         A3CliCod = BC000B8_A3CliCod[0] ;
         Z3CliCod = A3CliCod ;
         Z73ConCodPropio = A73ConCodPropio ;
         sMode9 = Gx_mode ;
         Gx_mode = "DSP" ;
         load0B9( ) ;
         if ( AnyError == 1 )
         {
            RcdFound9 = (short)(0) ;
            initializeNonKey0B9( ) ;
         }
         Gx_mode = sMode9 ;
      }
      else
      {
         RcdFound9 = (short)(0) ;
         initializeNonKey0B9( ) ;
         sMode9 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode9 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey0B9( ) ;
      if ( RcdFound9 == 0 )
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
      confirm_0B0( ) ;
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

   public void checkOptimisticConcurrency0B9( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000B9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoAFIP"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z383ConAfipDesc, BC000B9_A383ConAfipDesc[0]) != 0 ) || ( GXutil.strcmp(Z386ConAFIPConcepto, BC000B9_A386ConAFIPConcepto[0]) != 0 ) || ( GXutil.strcmp(Z134ConAFIPMarcaRep, BC000B9_A134ConAFIPMarcaRep[0]) != 0 ) || ( GXutil.strcmp(Z141ConAFIPSIPAApo, BC000B9_A141ConAFIPSIPAApo[0]) != 0 ) || ( GXutil.strcmp(Z142ConAFIPSIPACont, BC000B9_A142ConAFIPSIPACont[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z131ConAFIPINSSJyPApo, BC000B9_A131ConAFIPINSSJyPApo[0]) != 0 ) || ( GXutil.strcmp(Z132ConAFIPINSSJyPCont, BC000B9_A132ConAFIPINSSJyPCont[0]) != 0 ) || ( GXutil.strcmp(Z135ConAFIPObraSocApo, BC000B9_A135ConAFIPObraSocApo[0]) != 0 ) || ( GXutil.strcmp(Z136ConAFIPObraSocCont, BC000B9_A136ConAFIPObraSocCont[0]) != 0 ) || ( GXutil.strcmp(Z129ConAFIPFonSolRedApo, BC000B9_A129ConAFIPFonSolRedApo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z130ConAFIPFonSolRedCont, BC000B9_A130ConAFIPFonSolRedCont[0]) != 0 ) || ( GXutil.strcmp(Z139ConAFIPRenateaApo, BC000B9_A139ConAFIPRenateaApo[0]) != 0 ) || ( GXutil.strcmp(Z140ConAFIPRenateaCont, BC000B9_A140ConAFIPRenateaCont[0]) != 0 ) || ( GXutil.strcmp(Z127ConAFIPAsigFamCont, BC000B9_A127ConAFIPAsigFamCont[0]) != 0 ) || ( GXutil.strcmp(Z128ConAFIPFonNacEmpCont, BC000B9_A128ConAFIPFonNacEmpCont[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z133ConAFIPLeyRieTrabCont, BC000B9_A133ConAFIPLeyRieTrabCont[0]) != 0 ) || ( GXutil.strcmp(Z137ConAFIPRegDifApo, BC000B9_A137ConAFIPRegDifApo[0]) != 0 ) || ( GXutil.strcmp(Z138ConAFIPRegEspApo, BC000B9_A138ConAFIPRegEspApo[0]) != 0 ) || ( GXutil.strcmp(Z379ConAfipEstado, BC000B9_A379ConAfipEstado[0]) != 0 ) || ( GXutil.strcmp(Z380ConAFIPTipo, BC000B9_A380ConAFIPTipo[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z381ConAfipSubT1, BC000B9_A381ConAfipSubT1[0]) != 0 ) || ( GXutil.strcmp(Z382ConAfipSubT2, BC000B9_A382ConAfipSubT2[0]) != 0 ) || ( Z703ConAFIPLiquidado != BC000B9_A703ConAFIPLiquidado[0] ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConceptoAFIP"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0B9( )
   {
      beforeValidate0B9( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B9( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0B9( 0) ;
         checkOptimisticConcurrency0B9( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B9( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0B9( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000B10 */
                  pr_default.execute(8, new Object[] {A383ConAfipDesc, A73ConCodPropio, Boolean.valueOf(n386ConAFIPConcepto), A386ConAFIPConcepto, A134ConAFIPMarcaRep, A141ConAFIPSIPAApo, A142ConAFIPSIPACont, A131ConAFIPINSSJyPApo, A132ConAFIPINSSJyPCont, A135ConAFIPObraSocApo, A136ConAFIPObraSocCont, A129ConAFIPFonSolRedApo, A130ConAFIPFonSolRedCont, A139ConAFIPRenateaApo, A140ConAFIPRenateaCont, A127ConAFIPAsigFamCont, A128ConAFIPFonNacEmpCont, A133ConAFIPLeyRieTrabCont, A137ConAFIPRegDifApo, A138ConAFIPRegEspApo, A379ConAfipEstado, A380ConAFIPTipo, A381ConAfipSubT1, A382ConAfipSubT2, Boolean.valueOf(A703ConAFIPLiquidado), Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoAFIP");
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
            load0B9( ) ;
         }
         endLevel0B9( ) ;
      }
      closeExtendedTableCursors0B9( ) ;
   }

   public void update0B9( )
   {
      beforeValidate0B9( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0B9( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B9( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0B9( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0B9( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000B11 */
                  pr_default.execute(9, new Object[] {A383ConAfipDesc, Boolean.valueOf(n386ConAFIPConcepto), A386ConAFIPConcepto, A134ConAFIPMarcaRep, A141ConAFIPSIPAApo, A142ConAFIPSIPACont, A131ConAFIPINSSJyPApo, A132ConAFIPINSSJyPCont, A135ConAFIPObraSocApo, A136ConAFIPObraSocCont, A129ConAFIPFonSolRedApo, A130ConAFIPFonSolRedCont, A139ConAFIPRenateaApo, A140ConAFIPRenateaCont, A127ConAFIPAsigFamCont, A128ConAFIPFonNacEmpCont, A133ConAFIPLeyRieTrabCont, A137ConAFIPRegDifApo, A138ConAFIPRegEspApo, A379ConAfipEstado, A380ConAFIPTipo, A381ConAfipSubT1, A382ConAfipSubT2, Boolean.valueOf(A703ConAFIPLiquidado), Integer.valueOf(A3CliCod), A73ConCodPropio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoAFIP");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConceptoAFIP"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0B9( ) ;
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
         endLevel0B9( ) ;
      }
      closeExtendedTableCursors0B9( ) ;
   }

   public void deferredUpdate0B9( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0B9( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0B9( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0B9( ) ;
         afterConfirm0B9( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0B9( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000B12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConceptoAFIP");
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
      sMode9 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0B9( ) ;
      Gx_mode = sMode9 ;
   }

   public void onDeleteControls0B9( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV26Pgmname = "ConceptoAFIP_BC" ;
         GXt_char6 = A391ConAfipSubT2Def ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogetsubt2(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
         A391ConAfipSubT2Def = GXt_char6 ;
         GXt_char6 = A390ConAfipSubT1Def ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogetsubt1(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
         A390ConAfipSubT1Def = GXt_char6 ;
         GXt_char6 = A389ConAFIPTipoDef ;
         GXv_char7[0] = GXt_char6 ;
         new web.conceptogettipo(remoteHandle, context).execute( A3CliCod, A73ConCodPropio, GXv_char7) ;
         conceptoafip_bc.this.GXt_char6 = GXv_char7[0] ;
         A389ConAFIPTipoDef = GXt_char6 ;
      }
   }

   public void endLevel0B9( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0B9( ) ;
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

   public void scanKeyStart0B9( )
   {
      /* Scan By routine */
      /* Using cursor BC000B13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A73ConCodPropio});
      RcdFound9 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A383ConAfipDesc = BC000B13_A383ConAfipDesc[0] ;
         A73ConCodPropio = BC000B13_A73ConCodPropio[0] ;
         A386ConAFIPConcepto = BC000B13_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = BC000B13_n386ConAFIPConcepto[0] ;
         A134ConAFIPMarcaRep = BC000B13_A134ConAFIPMarcaRep[0] ;
         A141ConAFIPSIPAApo = BC000B13_A141ConAFIPSIPAApo[0] ;
         A142ConAFIPSIPACont = BC000B13_A142ConAFIPSIPACont[0] ;
         A131ConAFIPINSSJyPApo = BC000B13_A131ConAFIPINSSJyPApo[0] ;
         A132ConAFIPINSSJyPCont = BC000B13_A132ConAFIPINSSJyPCont[0] ;
         A135ConAFIPObraSocApo = BC000B13_A135ConAFIPObraSocApo[0] ;
         A136ConAFIPObraSocCont = BC000B13_A136ConAFIPObraSocCont[0] ;
         A129ConAFIPFonSolRedApo = BC000B13_A129ConAFIPFonSolRedApo[0] ;
         A130ConAFIPFonSolRedCont = BC000B13_A130ConAFIPFonSolRedCont[0] ;
         A139ConAFIPRenateaApo = BC000B13_A139ConAFIPRenateaApo[0] ;
         A140ConAFIPRenateaCont = BC000B13_A140ConAFIPRenateaCont[0] ;
         A127ConAFIPAsigFamCont = BC000B13_A127ConAFIPAsigFamCont[0] ;
         A128ConAFIPFonNacEmpCont = BC000B13_A128ConAFIPFonNacEmpCont[0] ;
         A133ConAFIPLeyRieTrabCont = BC000B13_A133ConAFIPLeyRieTrabCont[0] ;
         A137ConAFIPRegDifApo = BC000B13_A137ConAFIPRegDifApo[0] ;
         A138ConAFIPRegEspApo = BC000B13_A138ConAFIPRegEspApo[0] ;
         A379ConAfipEstado = BC000B13_A379ConAfipEstado[0] ;
         A380ConAFIPTipo = BC000B13_A380ConAFIPTipo[0] ;
         A381ConAfipSubT1 = BC000B13_A381ConAfipSubT1[0] ;
         A382ConAfipSubT2 = BC000B13_A382ConAfipSubT2[0] ;
         A703ConAFIPLiquidado = BC000B13_A703ConAFIPLiquidado[0] ;
         A3CliCod = BC000B13_A3CliCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0B9( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound9 = (short)(0) ;
      scanKeyLoad0B9( ) ;
   }

   public void scanKeyLoad0B9( )
   {
      sMode9 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound9 = (short)(1) ;
         A383ConAfipDesc = BC000B13_A383ConAfipDesc[0] ;
         A73ConCodPropio = BC000B13_A73ConCodPropio[0] ;
         A386ConAFIPConcepto = BC000B13_A386ConAFIPConcepto[0] ;
         n386ConAFIPConcepto = BC000B13_n386ConAFIPConcepto[0] ;
         A134ConAFIPMarcaRep = BC000B13_A134ConAFIPMarcaRep[0] ;
         A141ConAFIPSIPAApo = BC000B13_A141ConAFIPSIPAApo[0] ;
         A142ConAFIPSIPACont = BC000B13_A142ConAFIPSIPACont[0] ;
         A131ConAFIPINSSJyPApo = BC000B13_A131ConAFIPINSSJyPApo[0] ;
         A132ConAFIPINSSJyPCont = BC000B13_A132ConAFIPINSSJyPCont[0] ;
         A135ConAFIPObraSocApo = BC000B13_A135ConAFIPObraSocApo[0] ;
         A136ConAFIPObraSocCont = BC000B13_A136ConAFIPObraSocCont[0] ;
         A129ConAFIPFonSolRedApo = BC000B13_A129ConAFIPFonSolRedApo[0] ;
         A130ConAFIPFonSolRedCont = BC000B13_A130ConAFIPFonSolRedCont[0] ;
         A139ConAFIPRenateaApo = BC000B13_A139ConAFIPRenateaApo[0] ;
         A140ConAFIPRenateaCont = BC000B13_A140ConAFIPRenateaCont[0] ;
         A127ConAFIPAsigFamCont = BC000B13_A127ConAFIPAsigFamCont[0] ;
         A128ConAFIPFonNacEmpCont = BC000B13_A128ConAFIPFonNacEmpCont[0] ;
         A133ConAFIPLeyRieTrabCont = BC000B13_A133ConAFIPLeyRieTrabCont[0] ;
         A137ConAFIPRegDifApo = BC000B13_A137ConAFIPRegDifApo[0] ;
         A138ConAFIPRegEspApo = BC000B13_A138ConAFIPRegEspApo[0] ;
         A379ConAfipEstado = BC000B13_A379ConAfipEstado[0] ;
         A380ConAFIPTipo = BC000B13_A380ConAFIPTipo[0] ;
         A381ConAfipSubT1 = BC000B13_A381ConAfipSubT1[0] ;
         A382ConAfipSubT2 = BC000B13_A382ConAfipSubT2[0] ;
         A703ConAFIPLiquidado = BC000B13_A703ConAFIPLiquidado[0] ;
         A3CliCod = BC000B13_A3CliCod[0] ;
      }
      Gx_mode = sMode9 ;
   }

   public void scanKeyEnd0B9( )
   {
      pr_default.close(11);
   }

   public void afterConfirm0B9( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0B9( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0B9( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0B9( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0B9( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0B9( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0B9( )
   {
   }

   public void send_integrity_lvl_hashes0B9( )
   {
   }

   public void addRow0B9( )
   {
      VarsToRow9( bcConceptoAFIP) ;
   }

   public void readRow0B9( )
   {
      RowToVars9( bcConceptoAFIP, 1) ;
   }

   public void initializeNonKey0B9( )
   {
      A383ConAfipDesc = "" ;
      A389ConAFIPTipoDef = "" ;
      A390ConAfipSubT1Def = "" ;
      A391ConAfipSubT2Def = "" ;
      A386ConAFIPConcepto = "" ;
      n386ConAFIPConcepto = false ;
      A134ConAFIPMarcaRep = "" ;
      A141ConAFIPSIPAApo = "" ;
      A142ConAFIPSIPACont = "" ;
      A131ConAFIPINSSJyPApo = "" ;
      A132ConAFIPINSSJyPCont = "" ;
      A135ConAFIPObraSocApo = "" ;
      A136ConAFIPObraSocCont = "" ;
      A129ConAFIPFonSolRedApo = "" ;
      A130ConAFIPFonSolRedCont = "" ;
      A139ConAFIPRenateaApo = "" ;
      A140ConAFIPRenateaCont = "" ;
      A127ConAFIPAsigFamCont = "" ;
      A128ConAFIPFonNacEmpCont = "" ;
      A133ConAFIPLeyRieTrabCont = "" ;
      A137ConAFIPRegDifApo = "" ;
      A138ConAFIPRegEspApo = "" ;
      A379ConAfipEstado = "" ;
      A380ConAFIPTipo = "" ;
      A381ConAfipSubT1 = "" ;
      A382ConAfipSubT2 = "" ;
      A703ConAFIPLiquidado = false ;
      Z383ConAfipDesc = "" ;
      Z386ConAFIPConcepto = "" ;
      Z134ConAFIPMarcaRep = "" ;
      Z141ConAFIPSIPAApo = "" ;
      Z142ConAFIPSIPACont = "" ;
      Z131ConAFIPINSSJyPApo = "" ;
      Z132ConAFIPINSSJyPCont = "" ;
      Z135ConAFIPObraSocApo = "" ;
      Z136ConAFIPObraSocCont = "" ;
      Z129ConAFIPFonSolRedApo = "" ;
      Z130ConAFIPFonSolRedCont = "" ;
      Z139ConAFIPRenateaApo = "" ;
      Z140ConAFIPRenateaCont = "" ;
      Z127ConAFIPAsigFamCont = "" ;
      Z128ConAFIPFonNacEmpCont = "" ;
      Z133ConAFIPLeyRieTrabCont = "" ;
      Z137ConAFIPRegDifApo = "" ;
      Z138ConAFIPRegEspApo = "" ;
      Z379ConAfipEstado = "" ;
      Z380ConAFIPTipo = "" ;
      Z381ConAfipSubT1 = "" ;
      Z382ConAfipSubT2 = "" ;
      Z703ConAFIPLiquidado = false ;
   }

   public void initAll0B9( )
   {
      A3CliCod = 0 ;
      A73ConCodPropio = "" ;
      initializeNonKey0B9( ) ;
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

   public void VarsToRow9( web.SdtConceptoAFIP obj9 )
   {
      obj9.setgxTv_SdtConceptoAFIP_Mode( Gx_mode );
      obj9.setgxTv_SdtConceptoAFIP_Conafipdesc( A383ConAfipDesc );
      obj9.setgxTv_SdtConceptoAFIP_Conafiptipodef( A389ConAFIPTipoDef );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsubt1def( A390ConAfipSubT1Def );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsubt2def( A391ConAfipSubT2Def );
      obj9.setgxTv_SdtConceptoAFIP_Conafipconcepto( A386ConAFIPConcepto );
      obj9.setgxTv_SdtConceptoAFIP_Conafipmarcarep( A134ConAFIPMarcaRep );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsipaapo( A141ConAFIPSIPAApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsipacont( A142ConAFIPSIPACont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipinssjypapo( A131ConAFIPINSSJyPApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipinssjypcont( A132ConAFIPINSSJyPCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipobrasocapo( A135ConAFIPObraSocApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipobrasoccont( A136ConAFIPObraSocCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipfonsolredapo( A129ConAFIPFonSolRedApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipfonsolredcont( A130ConAFIPFonSolRedCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafiprenateaapo( A139ConAFIPRenateaApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafiprenateacont( A140ConAFIPRenateaCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipasigfamcont( A127ConAFIPAsigFamCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipfonnacempcont( A128ConAFIPFonNacEmpCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont( A133ConAFIPLeyRieTrabCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipregdifapo( A137ConAFIPRegDifApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipregespapo( A138ConAFIPRegEspApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipestado( A379ConAfipEstado );
      obj9.setgxTv_SdtConceptoAFIP_Conafiptipo( A380ConAFIPTipo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsubt1( A381ConAfipSubT1 );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsubt2( A382ConAfipSubT2 );
      obj9.setgxTv_SdtConceptoAFIP_Conafipliquidado( A703ConAFIPLiquidado );
      obj9.setgxTv_SdtConceptoAFIP_Clicod( A3CliCod );
      obj9.setgxTv_SdtConceptoAFIP_Concodpropio( A73ConCodPropio );
      obj9.setgxTv_SdtConceptoAFIP_Clicod_Z( Z3CliCod );
      obj9.setgxTv_SdtConceptoAFIP_Concodpropio_Z( Z73ConCodPropio );
      obj9.setgxTv_SdtConceptoAFIP_Conafipconcepto_Z( Z386ConAFIPConcepto );
      obj9.setgxTv_SdtConceptoAFIP_Conafipmarcarep_Z( Z134ConAFIPMarcaRep );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsipaapo_Z( Z141ConAFIPSIPAApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsipacont_Z( Z142ConAFIPSIPACont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z( Z131ConAFIPINSSJyPApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z( Z132ConAFIPINSSJyPCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z( Z135ConAFIPObraSocApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z( Z136ConAFIPObraSocCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z( Z129ConAFIPFonSolRedApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z( Z130ConAFIPFonSolRedCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z( Z139ConAFIPRenateaApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafiprenateacont_Z( Z140ConAFIPRenateaCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z( Z127ConAFIPAsigFamCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z( Z128ConAFIPFonNacEmpCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z( Z133ConAFIPLeyRieTrabCont );
      obj9.setgxTv_SdtConceptoAFIP_Conafipregdifapo_Z( Z137ConAFIPRegDifApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipregespapo_Z( Z138ConAFIPRegEspApo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipestado_Z( Z379ConAfipEstado );
      obj9.setgxTv_SdtConceptoAFIP_Conafiptipo_Z( Z380ConAFIPTipo );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsubt1_Z( Z381ConAfipSubT1 );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsubt2_Z( Z382ConAfipSubT2 );
      obj9.setgxTv_SdtConceptoAFIP_Conafipdesc_Z( Z383ConAfipDesc );
      obj9.setgxTv_SdtConceptoAFIP_Conafiptipodef_Z( Z389ConAFIPTipoDef );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsubt1def_Z( Z390ConAfipSubT1Def );
      obj9.setgxTv_SdtConceptoAFIP_Conafipsubt2def_Z( Z391ConAfipSubT2Def );
      obj9.setgxTv_SdtConceptoAFIP_Conafipliquidado_Z( Z703ConAFIPLiquidado );
      obj9.setgxTv_SdtConceptoAFIP_Conafipconcepto_N( (byte)((byte)((n386ConAFIPConcepto)?1:0)) );
      obj9.setgxTv_SdtConceptoAFIP_Mode( Gx_mode );
   }

   public void KeyVarsToRow9( web.SdtConceptoAFIP obj9 )
   {
      obj9.setgxTv_SdtConceptoAFIP_Clicod( A3CliCod );
      obj9.setgxTv_SdtConceptoAFIP_Concodpropio( A73ConCodPropio );
   }

   public void RowToVars9( web.SdtConceptoAFIP obj9 ,
                           int forceLoad )
   {
      Gx_mode = obj9.getgxTv_SdtConceptoAFIP_Mode() ;
      A383ConAfipDesc = obj9.getgxTv_SdtConceptoAFIP_Conafipdesc() ;
      A389ConAFIPTipoDef = obj9.getgxTv_SdtConceptoAFIP_Conafiptipodef() ;
      A390ConAfipSubT1Def = obj9.getgxTv_SdtConceptoAFIP_Conafipsubt1def() ;
      A391ConAfipSubT2Def = obj9.getgxTv_SdtConceptoAFIP_Conafipsubt2def() ;
      A386ConAFIPConcepto = obj9.getgxTv_SdtConceptoAFIP_Conafipconcepto() ;
      n386ConAFIPConcepto = false ;
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A134ConAFIPMarcaRep = obj9.getgxTv_SdtConceptoAFIP_Conafipmarcarep() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A141ConAFIPSIPAApo = obj9.getgxTv_SdtConceptoAFIP_Conafipsipaapo() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A142ConAFIPSIPACont = obj9.getgxTv_SdtConceptoAFIP_Conafipsipacont() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A131ConAFIPINSSJyPApo = obj9.getgxTv_SdtConceptoAFIP_Conafipinssjypapo() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A132ConAFIPINSSJyPCont = obj9.getgxTv_SdtConceptoAFIP_Conafipinssjypcont() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A135ConAFIPObraSocApo = obj9.getgxTv_SdtConceptoAFIP_Conafipobrasocapo() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A136ConAFIPObraSocCont = obj9.getgxTv_SdtConceptoAFIP_Conafipobrasoccont() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A129ConAFIPFonSolRedApo = obj9.getgxTv_SdtConceptoAFIP_Conafipfonsolredapo() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A130ConAFIPFonSolRedCont = obj9.getgxTv_SdtConceptoAFIP_Conafipfonsolredcont() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A139ConAFIPRenateaApo = obj9.getgxTv_SdtConceptoAFIP_Conafiprenateaapo() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A140ConAFIPRenateaCont = obj9.getgxTv_SdtConceptoAFIP_Conafiprenateacont() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A127ConAFIPAsigFamCont = obj9.getgxTv_SdtConceptoAFIP_Conafipasigfamcont() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A128ConAFIPFonNacEmpCont = obj9.getgxTv_SdtConceptoAFIP_Conafipfonnacempcont() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) || ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "REM_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A133ConAFIPLeyRieTrabCont = obj9.getgxTv_SdtConceptoAFIP_Conafipleyrietrabcont() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A137ConAFIPRegDifApo = obj9.getgxTv_SdtConceptoAFIP_Conafipregdifapo() ;
      }
      if ( ! ( ( GXutil.strcmp(obj9.getgxTv_SdtConceptoAFIP_Conafiptipo(), "DES_ARG") == 0 ) ) || ( forceLoad == 1 ) )
      {
         A138ConAFIPRegEspApo = obj9.getgxTv_SdtConceptoAFIP_Conafipregespapo() ;
      }
      A379ConAfipEstado = obj9.getgxTv_SdtConceptoAFIP_Conafipestado() ;
      A380ConAFIPTipo = obj9.getgxTv_SdtConceptoAFIP_Conafiptipo() ;
      A381ConAfipSubT1 = obj9.getgxTv_SdtConceptoAFIP_Conafipsubt1() ;
      A382ConAfipSubT2 = obj9.getgxTv_SdtConceptoAFIP_Conafipsubt2() ;
      A703ConAFIPLiquidado = obj9.getgxTv_SdtConceptoAFIP_Conafipliquidado() ;
      A3CliCod = obj9.getgxTv_SdtConceptoAFIP_Clicod() ;
      A73ConCodPropio = obj9.getgxTv_SdtConceptoAFIP_Concodpropio() ;
      Z3CliCod = obj9.getgxTv_SdtConceptoAFIP_Clicod_Z() ;
      Z73ConCodPropio = obj9.getgxTv_SdtConceptoAFIP_Concodpropio_Z() ;
      Z386ConAFIPConcepto = obj9.getgxTv_SdtConceptoAFIP_Conafipconcepto_Z() ;
      Z134ConAFIPMarcaRep = obj9.getgxTv_SdtConceptoAFIP_Conafipmarcarep_Z() ;
      Z141ConAFIPSIPAApo = obj9.getgxTv_SdtConceptoAFIP_Conafipsipaapo_Z() ;
      Z142ConAFIPSIPACont = obj9.getgxTv_SdtConceptoAFIP_Conafipsipacont_Z() ;
      Z131ConAFIPINSSJyPApo = obj9.getgxTv_SdtConceptoAFIP_Conafipinssjypapo_Z() ;
      Z132ConAFIPINSSJyPCont = obj9.getgxTv_SdtConceptoAFIP_Conafipinssjypcont_Z() ;
      Z135ConAFIPObraSocApo = obj9.getgxTv_SdtConceptoAFIP_Conafipobrasocapo_Z() ;
      Z136ConAFIPObraSocCont = obj9.getgxTv_SdtConceptoAFIP_Conafipobrasoccont_Z() ;
      Z129ConAFIPFonSolRedApo = obj9.getgxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z() ;
      Z130ConAFIPFonSolRedCont = obj9.getgxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z() ;
      Z139ConAFIPRenateaApo = obj9.getgxTv_SdtConceptoAFIP_Conafiprenateaapo_Z() ;
      Z140ConAFIPRenateaCont = obj9.getgxTv_SdtConceptoAFIP_Conafiprenateacont_Z() ;
      Z127ConAFIPAsigFamCont = obj9.getgxTv_SdtConceptoAFIP_Conafipasigfamcont_Z() ;
      Z128ConAFIPFonNacEmpCont = obj9.getgxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z() ;
      Z133ConAFIPLeyRieTrabCont = obj9.getgxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z() ;
      Z137ConAFIPRegDifApo = obj9.getgxTv_SdtConceptoAFIP_Conafipregdifapo_Z() ;
      Z138ConAFIPRegEspApo = obj9.getgxTv_SdtConceptoAFIP_Conafipregespapo_Z() ;
      Z379ConAfipEstado = obj9.getgxTv_SdtConceptoAFIP_Conafipestado_Z() ;
      Z380ConAFIPTipo = obj9.getgxTv_SdtConceptoAFIP_Conafiptipo_Z() ;
      Z381ConAfipSubT1 = obj9.getgxTv_SdtConceptoAFIP_Conafipsubt1_Z() ;
      Z382ConAfipSubT2 = obj9.getgxTv_SdtConceptoAFIP_Conafipsubt2_Z() ;
      Z383ConAfipDesc = obj9.getgxTv_SdtConceptoAFIP_Conafipdesc_Z() ;
      Z389ConAFIPTipoDef = obj9.getgxTv_SdtConceptoAFIP_Conafiptipodef_Z() ;
      Z390ConAfipSubT1Def = obj9.getgxTv_SdtConceptoAFIP_Conafipsubt1def_Z() ;
      Z391ConAfipSubT2Def = obj9.getgxTv_SdtConceptoAFIP_Conafipsubt2def_Z() ;
      Z703ConAFIPLiquidado = obj9.getgxTv_SdtConceptoAFIP_Conafipliquidado_Z() ;
      n386ConAFIPConcepto = (boolean)((obj9.getgxTv_SdtConceptoAFIP_Conafipconcepto_N()==0)?false:true) ;
      Gx_mode = obj9.getgxTv_SdtConceptoAFIP_Mode() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A73ConCodPropio = (String)getParm(obj,1) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0B9( ) ;
      scanKeyStart0B9( ) ;
      if ( RcdFound9 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000B14 */
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
         Z73ConCodPropio = A73ConCodPropio ;
      }
      zm0B9( -39) ;
      onLoadActions0B9( ) ;
      addRow0B9( ) ;
      scanKeyEnd0B9( ) ;
      if ( RcdFound9 == 0 )
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
      RowToVars9( bcConceptoAFIP, 0) ;
      scanKeyStart0B9( ) ;
      if ( RcdFound9 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000B15 */
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
         Z73ConCodPropio = A73ConCodPropio ;
      }
      zm0B9( -39) ;
      onLoadActions0B9( ) ;
      addRow0B9( ) ;
      scanKeyEnd0B9( ) ;
      if ( RcdFound9 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0B9( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0B9( ) ;
      }
      else
      {
         if ( RcdFound9 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, Z73ConCodPropio) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A73ConCodPropio = Z73ConCodPropio ;
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
               update0B9( ) ;
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
               if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, Z73ConCodPropio) != 0 ) )
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
                     insert0B9( ) ;
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
                     insert0B9( ) ;
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
      RowToVars9( bcConceptoAFIP, 1) ;
      saveImpl( ) ;
      VarsToRow9( bcConceptoAFIP) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars9( bcConceptoAFIP, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0B9( ) ;
      afterTrn( ) ;
      VarsToRow9( bcConceptoAFIP) ;
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
         web.SdtConceptoAFIP auxBC = new web.SdtConceptoAFIP( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A73ConCodPropio);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcConceptoAFIP);
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
      RowToVars9( bcConceptoAFIP, 1) ;
      updateImpl( ) ;
      VarsToRow9( bcConceptoAFIP) ;
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
      RowToVars9( bcConceptoAFIP, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0B9( ) ;
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
      VarsToRow9( bcConceptoAFIP) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars9( bcConceptoAFIP, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0B9( ) ;
      if ( RcdFound9 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, Z73ConCodPropio) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A73ConCodPropio = Z73ConCodPropio ;
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
         if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A73ConCodPropio, Z73ConCodPropio) != 0 ) )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "conceptoafip_bc");
      VarsToRow9( bcConceptoAFIP) ;
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
      Gx_mode = bcConceptoAFIP.getgxTv_SdtConceptoAFIP_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcConceptoAFIP.setgxTv_SdtConceptoAFIP_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtConceptoAFIP sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcConceptoAFIP )
      {
         bcConceptoAFIP = sdt ;
         if ( GXutil.strcmp(bcConceptoAFIP.getgxTv_SdtConceptoAFIP_Mode(), "") == 0 )
         {
            bcConceptoAFIP.setgxTv_SdtConceptoAFIP_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow9( bcConceptoAFIP) ;
         }
         else
         {
            RowToVars9( bcConceptoAFIP, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcConceptoAFIP.getgxTv_SdtConceptoAFIP_Mode(), "") == 0 )
         {
            bcConceptoAFIP.setgxTv_SdtConceptoAFIP_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars9( bcConceptoAFIP, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtConceptoAFIP getConceptoAFIP_BC( )
   {
      return bcConceptoAFIP ;
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
      Z73ConCodPropio = "" ;
      A73ConCodPropio = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV26Pgmname = "" ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      Z383ConAfipDesc = "" ;
      A383ConAfipDesc = "" ;
      Z386ConAFIPConcepto = "" ;
      A386ConAFIPConcepto = "" ;
      Z134ConAFIPMarcaRep = "" ;
      A134ConAFIPMarcaRep = "" ;
      Z141ConAFIPSIPAApo = "" ;
      A141ConAFIPSIPAApo = "" ;
      Z142ConAFIPSIPACont = "" ;
      A142ConAFIPSIPACont = "" ;
      Z131ConAFIPINSSJyPApo = "" ;
      A131ConAFIPINSSJyPApo = "" ;
      Z132ConAFIPINSSJyPCont = "" ;
      A132ConAFIPINSSJyPCont = "" ;
      Z135ConAFIPObraSocApo = "" ;
      A135ConAFIPObraSocApo = "" ;
      Z136ConAFIPObraSocCont = "" ;
      A136ConAFIPObraSocCont = "" ;
      Z129ConAFIPFonSolRedApo = "" ;
      A129ConAFIPFonSolRedApo = "" ;
      Z130ConAFIPFonSolRedCont = "" ;
      A130ConAFIPFonSolRedCont = "" ;
      Z139ConAFIPRenateaApo = "" ;
      A139ConAFIPRenateaApo = "" ;
      Z140ConAFIPRenateaCont = "" ;
      A140ConAFIPRenateaCont = "" ;
      Z127ConAFIPAsigFamCont = "" ;
      A127ConAFIPAsigFamCont = "" ;
      Z128ConAFIPFonNacEmpCont = "" ;
      A128ConAFIPFonNacEmpCont = "" ;
      Z133ConAFIPLeyRieTrabCont = "" ;
      A133ConAFIPLeyRieTrabCont = "" ;
      Z137ConAFIPRegDifApo = "" ;
      A137ConAFIPRegDifApo = "" ;
      Z138ConAFIPRegEspApo = "" ;
      A138ConAFIPRegEspApo = "" ;
      Z379ConAfipEstado = "" ;
      A379ConAfipEstado = "" ;
      Z380ConAFIPTipo = "" ;
      A380ConAFIPTipo = "" ;
      Z381ConAfipSubT1 = "" ;
      A381ConAfipSubT1 = "" ;
      Z382ConAfipSubT2 = "" ;
      A382ConAfipSubT2 = "" ;
      Z389ConAFIPTipoDef = "" ;
      A389ConAFIPTipoDef = "" ;
      Z390ConAfipSubT1Def = "" ;
      A390ConAfipSubT1Def = "" ;
      Z391ConAfipSubT2Def = "" ;
      A391ConAfipSubT2Def = "" ;
      GXv_int5 = new int[1] ;
      BC000B5_A383ConAfipDesc = new String[] {""} ;
      BC000B5_A73ConCodPropio = new String[] {""} ;
      BC000B5_A386ConAFIPConcepto = new String[] {""} ;
      BC000B5_n386ConAFIPConcepto = new boolean[] {false} ;
      BC000B5_A134ConAFIPMarcaRep = new String[] {""} ;
      BC000B5_A141ConAFIPSIPAApo = new String[] {""} ;
      BC000B5_A142ConAFIPSIPACont = new String[] {""} ;
      BC000B5_A131ConAFIPINSSJyPApo = new String[] {""} ;
      BC000B5_A132ConAFIPINSSJyPCont = new String[] {""} ;
      BC000B5_A135ConAFIPObraSocApo = new String[] {""} ;
      BC000B5_A136ConAFIPObraSocCont = new String[] {""} ;
      BC000B5_A129ConAFIPFonSolRedApo = new String[] {""} ;
      BC000B5_A130ConAFIPFonSolRedCont = new String[] {""} ;
      BC000B5_A139ConAFIPRenateaApo = new String[] {""} ;
      BC000B5_A140ConAFIPRenateaCont = new String[] {""} ;
      BC000B5_A127ConAFIPAsigFamCont = new String[] {""} ;
      BC000B5_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      BC000B5_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      BC000B5_A137ConAFIPRegDifApo = new String[] {""} ;
      BC000B5_A138ConAFIPRegEspApo = new String[] {""} ;
      BC000B5_A379ConAfipEstado = new String[] {""} ;
      BC000B5_A380ConAFIPTipo = new String[] {""} ;
      BC000B5_A381ConAfipSubT1 = new String[] {""} ;
      BC000B5_A382ConAfipSubT2 = new String[] {""} ;
      BC000B5_A703ConAFIPLiquidado = new boolean[] {false} ;
      BC000B5_A3CliCod = new int[1] ;
      BC000B6_A3CliCod = new int[1] ;
      BC000B7_A3CliCod = new int[1] ;
      BC000B7_A73ConCodPropio = new String[] {""} ;
      BC000B8_A383ConAfipDesc = new String[] {""} ;
      BC000B8_A73ConCodPropio = new String[] {""} ;
      BC000B8_A386ConAFIPConcepto = new String[] {""} ;
      BC000B8_n386ConAFIPConcepto = new boolean[] {false} ;
      BC000B8_A134ConAFIPMarcaRep = new String[] {""} ;
      BC000B8_A141ConAFIPSIPAApo = new String[] {""} ;
      BC000B8_A142ConAFIPSIPACont = new String[] {""} ;
      BC000B8_A131ConAFIPINSSJyPApo = new String[] {""} ;
      BC000B8_A132ConAFIPINSSJyPCont = new String[] {""} ;
      BC000B8_A135ConAFIPObraSocApo = new String[] {""} ;
      BC000B8_A136ConAFIPObraSocCont = new String[] {""} ;
      BC000B8_A129ConAFIPFonSolRedApo = new String[] {""} ;
      BC000B8_A130ConAFIPFonSolRedCont = new String[] {""} ;
      BC000B8_A139ConAFIPRenateaApo = new String[] {""} ;
      BC000B8_A140ConAFIPRenateaCont = new String[] {""} ;
      BC000B8_A127ConAFIPAsigFamCont = new String[] {""} ;
      BC000B8_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      BC000B8_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      BC000B8_A137ConAFIPRegDifApo = new String[] {""} ;
      BC000B8_A138ConAFIPRegEspApo = new String[] {""} ;
      BC000B8_A379ConAfipEstado = new String[] {""} ;
      BC000B8_A380ConAFIPTipo = new String[] {""} ;
      BC000B8_A381ConAfipSubT1 = new String[] {""} ;
      BC000B8_A382ConAfipSubT2 = new String[] {""} ;
      BC000B8_A703ConAFIPLiquidado = new boolean[] {false} ;
      BC000B8_A3CliCod = new int[1] ;
      sMode9 = "" ;
      BC000B9_A383ConAfipDesc = new String[] {""} ;
      BC000B9_A73ConCodPropio = new String[] {""} ;
      BC000B9_A386ConAFIPConcepto = new String[] {""} ;
      BC000B9_n386ConAFIPConcepto = new boolean[] {false} ;
      BC000B9_A134ConAFIPMarcaRep = new String[] {""} ;
      BC000B9_A141ConAFIPSIPAApo = new String[] {""} ;
      BC000B9_A142ConAFIPSIPACont = new String[] {""} ;
      BC000B9_A131ConAFIPINSSJyPApo = new String[] {""} ;
      BC000B9_A132ConAFIPINSSJyPCont = new String[] {""} ;
      BC000B9_A135ConAFIPObraSocApo = new String[] {""} ;
      BC000B9_A136ConAFIPObraSocCont = new String[] {""} ;
      BC000B9_A129ConAFIPFonSolRedApo = new String[] {""} ;
      BC000B9_A130ConAFIPFonSolRedCont = new String[] {""} ;
      BC000B9_A139ConAFIPRenateaApo = new String[] {""} ;
      BC000B9_A140ConAFIPRenateaCont = new String[] {""} ;
      BC000B9_A127ConAFIPAsigFamCont = new String[] {""} ;
      BC000B9_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      BC000B9_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      BC000B9_A137ConAFIPRegDifApo = new String[] {""} ;
      BC000B9_A138ConAFIPRegEspApo = new String[] {""} ;
      BC000B9_A379ConAfipEstado = new String[] {""} ;
      BC000B9_A380ConAFIPTipo = new String[] {""} ;
      BC000B9_A381ConAfipSubT1 = new String[] {""} ;
      BC000B9_A382ConAfipSubT2 = new String[] {""} ;
      BC000B9_A703ConAFIPLiquidado = new boolean[] {false} ;
      BC000B9_A3CliCod = new int[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      BC000B13_A383ConAfipDesc = new String[] {""} ;
      BC000B13_A73ConCodPropio = new String[] {""} ;
      BC000B13_A386ConAFIPConcepto = new String[] {""} ;
      BC000B13_n386ConAFIPConcepto = new boolean[] {false} ;
      BC000B13_A134ConAFIPMarcaRep = new String[] {""} ;
      BC000B13_A141ConAFIPSIPAApo = new String[] {""} ;
      BC000B13_A142ConAFIPSIPACont = new String[] {""} ;
      BC000B13_A131ConAFIPINSSJyPApo = new String[] {""} ;
      BC000B13_A132ConAFIPINSSJyPCont = new String[] {""} ;
      BC000B13_A135ConAFIPObraSocApo = new String[] {""} ;
      BC000B13_A136ConAFIPObraSocCont = new String[] {""} ;
      BC000B13_A129ConAFIPFonSolRedApo = new String[] {""} ;
      BC000B13_A130ConAFIPFonSolRedCont = new String[] {""} ;
      BC000B13_A139ConAFIPRenateaApo = new String[] {""} ;
      BC000B13_A140ConAFIPRenateaCont = new String[] {""} ;
      BC000B13_A127ConAFIPAsigFamCont = new String[] {""} ;
      BC000B13_A128ConAFIPFonNacEmpCont = new String[] {""} ;
      BC000B13_A133ConAFIPLeyRieTrabCont = new String[] {""} ;
      BC000B13_A137ConAFIPRegDifApo = new String[] {""} ;
      BC000B13_A138ConAFIPRegEspApo = new String[] {""} ;
      BC000B13_A379ConAfipEstado = new String[] {""} ;
      BC000B13_A380ConAFIPTipo = new String[] {""} ;
      BC000B13_A381ConAfipSubT1 = new String[] {""} ;
      BC000B13_A382ConAfipSubT2 = new String[] {""} ;
      BC000B13_A703ConAFIPLiquidado = new boolean[] {false} ;
      BC000B13_A3CliCod = new int[1] ;
      N134ConAFIPMarcaRep = "" ;
      N141ConAFIPSIPAApo = "" ;
      N142ConAFIPSIPACont = "" ;
      N131ConAFIPINSSJyPApo = "" ;
      N132ConAFIPINSSJyPCont = "" ;
      N135ConAFIPObraSocApo = "" ;
      N136ConAFIPObraSocCont = "" ;
      N129ConAFIPFonSolRedApo = "" ;
      N130ConAFIPFonSolRedCont = "" ;
      N139ConAFIPRenateaApo = "" ;
      N140ConAFIPRenateaCont = "" ;
      N127ConAFIPAsigFamCont = "" ;
      N128ConAFIPFonNacEmpCont = "" ;
      N133ConAFIPLeyRieTrabCont = "" ;
      N137ConAFIPRegDifApo = "" ;
      N138ConAFIPRegEspApo = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000B14_A3CliCod = new int[1] ;
      BC000B15_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conceptoafip_bc__default(),
         new Object[] {
             new Object[] {
            BC000B2_A383ConAfipDesc, BC000B2_A73ConCodPropio, BC000B2_A386ConAFIPConcepto, BC000B2_n386ConAFIPConcepto, BC000B2_A134ConAFIPMarcaRep, BC000B2_A141ConAFIPSIPAApo, BC000B2_A142ConAFIPSIPACont, BC000B2_A131ConAFIPINSSJyPApo, BC000B2_A132ConAFIPINSSJyPCont, BC000B2_A135ConAFIPObraSocApo,
            BC000B2_A136ConAFIPObraSocCont, BC000B2_A129ConAFIPFonSolRedApo, BC000B2_A130ConAFIPFonSolRedCont, BC000B2_A139ConAFIPRenateaApo, BC000B2_A140ConAFIPRenateaCont, BC000B2_A127ConAFIPAsigFamCont, BC000B2_A128ConAFIPFonNacEmpCont, BC000B2_A133ConAFIPLeyRieTrabCont, BC000B2_A137ConAFIPRegDifApo, BC000B2_A138ConAFIPRegEspApo,
            BC000B2_A379ConAfipEstado, BC000B2_A380ConAFIPTipo, BC000B2_A381ConAfipSubT1, BC000B2_A382ConAfipSubT2, BC000B2_A703ConAFIPLiquidado, BC000B2_A3CliCod
            }
            , new Object[] {
            BC000B3_A383ConAfipDesc, BC000B3_A73ConCodPropio, BC000B3_A386ConAFIPConcepto, BC000B3_n386ConAFIPConcepto, BC000B3_A134ConAFIPMarcaRep, BC000B3_A141ConAFIPSIPAApo, BC000B3_A142ConAFIPSIPACont, BC000B3_A131ConAFIPINSSJyPApo, BC000B3_A132ConAFIPINSSJyPCont, BC000B3_A135ConAFIPObraSocApo,
            BC000B3_A136ConAFIPObraSocCont, BC000B3_A129ConAFIPFonSolRedApo, BC000B3_A130ConAFIPFonSolRedCont, BC000B3_A139ConAFIPRenateaApo, BC000B3_A140ConAFIPRenateaCont, BC000B3_A127ConAFIPAsigFamCont, BC000B3_A128ConAFIPFonNacEmpCont, BC000B3_A133ConAFIPLeyRieTrabCont, BC000B3_A137ConAFIPRegDifApo, BC000B3_A138ConAFIPRegEspApo,
            BC000B3_A379ConAfipEstado, BC000B3_A380ConAFIPTipo, BC000B3_A381ConAfipSubT1, BC000B3_A382ConAfipSubT2, BC000B3_A703ConAFIPLiquidado, BC000B3_A3CliCod
            }
            , new Object[] {
            BC000B4_A3CliCod
            }
            , new Object[] {
            BC000B5_A383ConAfipDesc, BC000B5_A73ConCodPropio, BC000B5_A386ConAFIPConcepto, BC000B5_n386ConAFIPConcepto, BC000B5_A134ConAFIPMarcaRep, BC000B5_A141ConAFIPSIPAApo, BC000B5_A142ConAFIPSIPACont, BC000B5_A131ConAFIPINSSJyPApo, BC000B5_A132ConAFIPINSSJyPCont, BC000B5_A135ConAFIPObraSocApo,
            BC000B5_A136ConAFIPObraSocCont, BC000B5_A129ConAFIPFonSolRedApo, BC000B5_A130ConAFIPFonSolRedCont, BC000B5_A139ConAFIPRenateaApo, BC000B5_A140ConAFIPRenateaCont, BC000B5_A127ConAFIPAsigFamCont, BC000B5_A128ConAFIPFonNacEmpCont, BC000B5_A133ConAFIPLeyRieTrabCont, BC000B5_A137ConAFIPRegDifApo, BC000B5_A138ConAFIPRegEspApo,
            BC000B5_A379ConAfipEstado, BC000B5_A380ConAFIPTipo, BC000B5_A381ConAfipSubT1, BC000B5_A382ConAfipSubT2, BC000B5_A703ConAFIPLiquidado, BC000B5_A3CliCod
            }
            , new Object[] {
            BC000B6_A3CliCod
            }
            , new Object[] {
            BC000B7_A3CliCod, BC000B7_A73ConCodPropio
            }
            , new Object[] {
            BC000B8_A383ConAfipDesc, BC000B8_A73ConCodPropio, BC000B8_A386ConAFIPConcepto, BC000B8_n386ConAFIPConcepto, BC000B8_A134ConAFIPMarcaRep, BC000B8_A141ConAFIPSIPAApo, BC000B8_A142ConAFIPSIPACont, BC000B8_A131ConAFIPINSSJyPApo, BC000B8_A132ConAFIPINSSJyPCont, BC000B8_A135ConAFIPObraSocApo,
            BC000B8_A136ConAFIPObraSocCont, BC000B8_A129ConAFIPFonSolRedApo, BC000B8_A130ConAFIPFonSolRedCont, BC000B8_A139ConAFIPRenateaApo, BC000B8_A140ConAFIPRenateaCont, BC000B8_A127ConAFIPAsigFamCont, BC000B8_A128ConAFIPFonNacEmpCont, BC000B8_A133ConAFIPLeyRieTrabCont, BC000B8_A137ConAFIPRegDifApo, BC000B8_A138ConAFIPRegEspApo,
            BC000B8_A379ConAfipEstado, BC000B8_A380ConAFIPTipo, BC000B8_A381ConAfipSubT1, BC000B8_A382ConAfipSubT2, BC000B8_A703ConAFIPLiquidado, BC000B8_A3CliCod
            }
            , new Object[] {
            BC000B9_A383ConAfipDesc, BC000B9_A73ConCodPropio, BC000B9_A386ConAFIPConcepto, BC000B9_n386ConAFIPConcepto, BC000B9_A134ConAFIPMarcaRep, BC000B9_A141ConAFIPSIPAApo, BC000B9_A142ConAFIPSIPACont, BC000B9_A131ConAFIPINSSJyPApo, BC000B9_A132ConAFIPINSSJyPCont, BC000B9_A135ConAFIPObraSocApo,
            BC000B9_A136ConAFIPObraSocCont, BC000B9_A129ConAFIPFonSolRedApo, BC000B9_A130ConAFIPFonSolRedCont, BC000B9_A139ConAFIPRenateaApo, BC000B9_A140ConAFIPRenateaCont, BC000B9_A127ConAFIPAsigFamCont, BC000B9_A128ConAFIPFonNacEmpCont, BC000B9_A133ConAFIPLeyRieTrabCont, BC000B9_A137ConAFIPRegDifApo, BC000B9_A138ConAFIPRegEspApo,
            BC000B9_A379ConAfipEstado, BC000B9_A380ConAFIPTipo, BC000B9_A381ConAfipSubT1, BC000B9_A382ConAfipSubT2, BC000B9_A703ConAFIPLiquidado, BC000B9_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000B13_A383ConAfipDesc, BC000B13_A73ConCodPropio, BC000B13_A386ConAFIPConcepto, BC000B13_n386ConAFIPConcepto, BC000B13_A134ConAFIPMarcaRep, BC000B13_A141ConAFIPSIPAApo, BC000B13_A142ConAFIPSIPACont, BC000B13_A131ConAFIPINSSJyPApo, BC000B13_A132ConAFIPINSSJyPCont, BC000B13_A135ConAFIPObraSocApo,
            BC000B13_A136ConAFIPObraSocCont, BC000B13_A129ConAFIPFonSolRedApo, BC000B13_A130ConAFIPFonSolRedCont, BC000B13_A139ConAFIPRenateaApo, BC000B13_A140ConAFIPRenateaCont, BC000B13_A127ConAFIPAsigFamCont, BC000B13_A128ConAFIPFonNacEmpCont, BC000B13_A133ConAFIPLeyRieTrabCont, BC000B13_A137ConAFIPRegDifApo, BC000B13_A138ConAFIPRegEspApo,
            BC000B13_A379ConAfipEstado, BC000B13_A380ConAFIPTipo, BC000B13_A381ConAfipSubT1, BC000B13_A382ConAfipSubT2, BC000B13_A703ConAFIPLiquidado, BC000B13_A3CliCod
            }
            , new Object[] {
            BC000B14_A3CliCod
            }
            , new Object[] {
            BC000B15_A3CliCod
            }
         }
      );
      AV26Pgmname = "ConceptoAFIP_BC" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e120B2 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound9 ;
   private short nIsDirty_9 ;
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
   private String Z73ConCodPropio ;
   private String A73ConCodPropio ;
   private String AV26Pgmname ;
   private String Z386ConAFIPConcepto ;
   private String A386ConAFIPConcepto ;
   private String Z134ConAFIPMarcaRep ;
   private String A134ConAFIPMarcaRep ;
   private String Z141ConAFIPSIPAApo ;
   private String A141ConAFIPSIPAApo ;
   private String Z142ConAFIPSIPACont ;
   private String A142ConAFIPSIPACont ;
   private String Z131ConAFIPINSSJyPApo ;
   private String A131ConAFIPINSSJyPApo ;
   private String Z132ConAFIPINSSJyPCont ;
   private String A132ConAFIPINSSJyPCont ;
   private String Z135ConAFIPObraSocApo ;
   private String A135ConAFIPObraSocApo ;
   private String Z136ConAFIPObraSocCont ;
   private String A136ConAFIPObraSocCont ;
   private String Z129ConAFIPFonSolRedApo ;
   private String A129ConAFIPFonSolRedApo ;
   private String Z130ConAFIPFonSolRedCont ;
   private String A130ConAFIPFonSolRedCont ;
   private String Z139ConAFIPRenateaApo ;
   private String A139ConAFIPRenateaApo ;
   private String Z140ConAFIPRenateaCont ;
   private String A140ConAFIPRenateaCont ;
   private String Z127ConAFIPAsigFamCont ;
   private String A127ConAFIPAsigFamCont ;
   private String Z128ConAFIPFonNacEmpCont ;
   private String A128ConAFIPFonNacEmpCont ;
   private String Z133ConAFIPLeyRieTrabCont ;
   private String A133ConAFIPLeyRieTrabCont ;
   private String Z137ConAFIPRegDifApo ;
   private String A137ConAFIPRegDifApo ;
   private String Z138ConAFIPRegEspApo ;
   private String A138ConAFIPRegEspApo ;
   private String Z379ConAfipEstado ;
   private String A379ConAfipEstado ;
   private String Z380ConAFIPTipo ;
   private String A380ConAFIPTipo ;
   private String Z381ConAfipSubT1 ;
   private String A381ConAfipSubT1 ;
   private String Z382ConAfipSubT2 ;
   private String A382ConAfipSubT2 ;
   private String Z389ConAFIPTipoDef ;
   private String A389ConAFIPTipoDef ;
   private String Z390ConAfipSubT1Def ;
   private String A390ConAfipSubT1Def ;
   private String Z391ConAfipSubT2Def ;
   private String A391ConAfipSubT2Def ;
   private String sMode9 ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String N134ConAFIPMarcaRep ;
   private String N141ConAFIPSIPAApo ;
   private String N142ConAFIPSIPACont ;
   private String N131ConAFIPINSSJyPApo ;
   private String N132ConAFIPINSSJyPCont ;
   private String N135ConAFIPObraSocApo ;
   private String N136ConAFIPObraSocCont ;
   private String N129ConAFIPFonSolRedApo ;
   private String N130ConAFIPFonSolRedCont ;
   private String N139ConAFIPRenateaApo ;
   private String N140ConAFIPRenateaCont ;
   private String N127ConAFIPAsigFamCont ;
   private String N128ConAFIPFonNacEmpCont ;
   private String N133ConAFIPLeyRieTrabCont ;
   private String N137ConAFIPRegDifApo ;
   private String N138ConAFIPRegEspApo ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Z703ConAFIPLiquidado ;
   private boolean A703ConAFIPLiquidado ;
   private boolean n386ConAFIPConcepto ;
   private boolean Gx_longc ;
   private boolean mustCommit ;
   private String Z383ConAfipDesc ;
   private String A383ConAfipDesc ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private web.SdtConceptoAFIP bcConceptoAFIP ;
   private IDataStoreProvider pr_default ;
   private String[] BC000B5_A383ConAfipDesc ;
   private String[] BC000B5_A73ConCodPropio ;
   private String[] BC000B5_A386ConAFIPConcepto ;
   private boolean[] BC000B5_n386ConAFIPConcepto ;
   private String[] BC000B5_A134ConAFIPMarcaRep ;
   private String[] BC000B5_A141ConAFIPSIPAApo ;
   private String[] BC000B5_A142ConAFIPSIPACont ;
   private String[] BC000B5_A131ConAFIPINSSJyPApo ;
   private String[] BC000B5_A132ConAFIPINSSJyPCont ;
   private String[] BC000B5_A135ConAFIPObraSocApo ;
   private String[] BC000B5_A136ConAFIPObraSocCont ;
   private String[] BC000B5_A129ConAFIPFonSolRedApo ;
   private String[] BC000B5_A130ConAFIPFonSolRedCont ;
   private String[] BC000B5_A139ConAFIPRenateaApo ;
   private String[] BC000B5_A140ConAFIPRenateaCont ;
   private String[] BC000B5_A127ConAFIPAsigFamCont ;
   private String[] BC000B5_A128ConAFIPFonNacEmpCont ;
   private String[] BC000B5_A133ConAFIPLeyRieTrabCont ;
   private String[] BC000B5_A137ConAFIPRegDifApo ;
   private String[] BC000B5_A138ConAFIPRegEspApo ;
   private String[] BC000B5_A379ConAfipEstado ;
   private String[] BC000B5_A380ConAFIPTipo ;
   private String[] BC000B5_A381ConAfipSubT1 ;
   private String[] BC000B5_A382ConAfipSubT2 ;
   private boolean[] BC000B5_A703ConAFIPLiquidado ;
   private int[] BC000B5_A3CliCod ;
   private int[] BC000B6_A3CliCod ;
   private int[] BC000B7_A3CliCod ;
   private String[] BC000B7_A73ConCodPropio ;
   private String[] BC000B8_A383ConAfipDesc ;
   private String[] BC000B8_A73ConCodPropio ;
   private String[] BC000B8_A386ConAFIPConcepto ;
   private boolean[] BC000B8_n386ConAFIPConcepto ;
   private String[] BC000B8_A134ConAFIPMarcaRep ;
   private String[] BC000B8_A141ConAFIPSIPAApo ;
   private String[] BC000B8_A142ConAFIPSIPACont ;
   private String[] BC000B8_A131ConAFIPINSSJyPApo ;
   private String[] BC000B8_A132ConAFIPINSSJyPCont ;
   private String[] BC000B8_A135ConAFIPObraSocApo ;
   private String[] BC000B8_A136ConAFIPObraSocCont ;
   private String[] BC000B8_A129ConAFIPFonSolRedApo ;
   private String[] BC000B8_A130ConAFIPFonSolRedCont ;
   private String[] BC000B8_A139ConAFIPRenateaApo ;
   private String[] BC000B8_A140ConAFIPRenateaCont ;
   private String[] BC000B8_A127ConAFIPAsigFamCont ;
   private String[] BC000B8_A128ConAFIPFonNacEmpCont ;
   private String[] BC000B8_A133ConAFIPLeyRieTrabCont ;
   private String[] BC000B8_A137ConAFIPRegDifApo ;
   private String[] BC000B8_A138ConAFIPRegEspApo ;
   private String[] BC000B8_A379ConAfipEstado ;
   private String[] BC000B8_A380ConAFIPTipo ;
   private String[] BC000B8_A381ConAfipSubT1 ;
   private String[] BC000B8_A382ConAfipSubT2 ;
   private boolean[] BC000B8_A703ConAFIPLiquidado ;
   private int[] BC000B8_A3CliCod ;
   private String[] BC000B9_A383ConAfipDesc ;
   private String[] BC000B9_A73ConCodPropio ;
   private String[] BC000B9_A386ConAFIPConcepto ;
   private boolean[] BC000B9_n386ConAFIPConcepto ;
   private String[] BC000B9_A134ConAFIPMarcaRep ;
   private String[] BC000B9_A141ConAFIPSIPAApo ;
   private String[] BC000B9_A142ConAFIPSIPACont ;
   private String[] BC000B9_A131ConAFIPINSSJyPApo ;
   private String[] BC000B9_A132ConAFIPINSSJyPCont ;
   private String[] BC000B9_A135ConAFIPObraSocApo ;
   private String[] BC000B9_A136ConAFIPObraSocCont ;
   private String[] BC000B9_A129ConAFIPFonSolRedApo ;
   private String[] BC000B9_A130ConAFIPFonSolRedCont ;
   private String[] BC000B9_A139ConAFIPRenateaApo ;
   private String[] BC000B9_A140ConAFIPRenateaCont ;
   private String[] BC000B9_A127ConAFIPAsigFamCont ;
   private String[] BC000B9_A128ConAFIPFonNacEmpCont ;
   private String[] BC000B9_A133ConAFIPLeyRieTrabCont ;
   private String[] BC000B9_A137ConAFIPRegDifApo ;
   private String[] BC000B9_A138ConAFIPRegEspApo ;
   private String[] BC000B9_A379ConAfipEstado ;
   private String[] BC000B9_A380ConAFIPTipo ;
   private String[] BC000B9_A381ConAfipSubT1 ;
   private String[] BC000B9_A382ConAfipSubT2 ;
   private boolean[] BC000B9_A703ConAFIPLiquidado ;
   private int[] BC000B9_A3CliCod ;
   private String[] BC000B13_A383ConAfipDesc ;
   private String[] BC000B13_A73ConCodPropio ;
   private String[] BC000B13_A386ConAFIPConcepto ;
   private boolean[] BC000B13_n386ConAFIPConcepto ;
   private String[] BC000B13_A134ConAFIPMarcaRep ;
   private String[] BC000B13_A141ConAFIPSIPAApo ;
   private String[] BC000B13_A142ConAFIPSIPACont ;
   private String[] BC000B13_A131ConAFIPINSSJyPApo ;
   private String[] BC000B13_A132ConAFIPINSSJyPCont ;
   private String[] BC000B13_A135ConAFIPObraSocApo ;
   private String[] BC000B13_A136ConAFIPObraSocCont ;
   private String[] BC000B13_A129ConAFIPFonSolRedApo ;
   private String[] BC000B13_A130ConAFIPFonSolRedCont ;
   private String[] BC000B13_A139ConAFIPRenateaApo ;
   private String[] BC000B13_A140ConAFIPRenateaCont ;
   private String[] BC000B13_A127ConAFIPAsigFamCont ;
   private String[] BC000B13_A128ConAFIPFonNacEmpCont ;
   private String[] BC000B13_A133ConAFIPLeyRieTrabCont ;
   private String[] BC000B13_A137ConAFIPRegDifApo ;
   private String[] BC000B13_A138ConAFIPRegEspApo ;
   private String[] BC000B13_A379ConAfipEstado ;
   private String[] BC000B13_A380ConAFIPTipo ;
   private String[] BC000B13_A381ConAfipSubT1 ;
   private String[] BC000B13_A382ConAfipSubT2 ;
   private boolean[] BC000B13_A703ConAFIPLiquidado ;
   private int[] BC000B13_A3CliCod ;
   private int[] BC000B14_A3CliCod ;
   private int[] BC000B15_A3CliCod ;
   private String[] BC000B2_A383ConAfipDesc ;
   private String[] BC000B2_A73ConCodPropio ;
   private String[] BC000B2_A386ConAFIPConcepto ;
   private String[] BC000B2_A134ConAFIPMarcaRep ;
   private String[] BC000B2_A141ConAFIPSIPAApo ;
   private String[] BC000B2_A142ConAFIPSIPACont ;
   private String[] BC000B2_A131ConAFIPINSSJyPApo ;
   private String[] BC000B2_A132ConAFIPINSSJyPCont ;
   private String[] BC000B2_A135ConAFIPObraSocApo ;
   private String[] BC000B2_A136ConAFIPObraSocCont ;
   private String[] BC000B2_A129ConAFIPFonSolRedApo ;
   private String[] BC000B2_A130ConAFIPFonSolRedCont ;
   private String[] BC000B2_A139ConAFIPRenateaApo ;
   private String[] BC000B2_A140ConAFIPRenateaCont ;
   private String[] BC000B2_A127ConAFIPAsigFamCont ;
   private String[] BC000B2_A128ConAFIPFonNacEmpCont ;
   private String[] BC000B2_A133ConAFIPLeyRieTrabCont ;
   private String[] BC000B2_A137ConAFIPRegDifApo ;
   private String[] BC000B2_A138ConAFIPRegEspApo ;
   private String[] BC000B2_A379ConAfipEstado ;
   private String[] BC000B2_A380ConAFIPTipo ;
   private String[] BC000B2_A381ConAfipSubT1 ;
   private String[] BC000B2_A382ConAfipSubT2 ;
   private boolean[] BC000B2_A703ConAFIPLiquidado ;
   private int[] BC000B2_A3CliCod ;
   private String[] BC000B3_A383ConAfipDesc ;
   private String[] BC000B3_A73ConCodPropio ;
   private String[] BC000B3_A386ConAFIPConcepto ;
   private String[] BC000B3_A134ConAFIPMarcaRep ;
   private String[] BC000B3_A141ConAFIPSIPAApo ;
   private String[] BC000B3_A142ConAFIPSIPACont ;
   private String[] BC000B3_A131ConAFIPINSSJyPApo ;
   private String[] BC000B3_A132ConAFIPINSSJyPCont ;
   private String[] BC000B3_A135ConAFIPObraSocApo ;
   private String[] BC000B3_A136ConAFIPObraSocCont ;
   private String[] BC000B3_A129ConAFIPFonSolRedApo ;
   private String[] BC000B3_A130ConAFIPFonSolRedCont ;
   private String[] BC000B3_A139ConAFIPRenateaApo ;
   private String[] BC000B3_A140ConAFIPRenateaCont ;
   private String[] BC000B3_A127ConAFIPAsigFamCont ;
   private String[] BC000B3_A128ConAFIPFonNacEmpCont ;
   private String[] BC000B3_A133ConAFIPLeyRieTrabCont ;
   private String[] BC000B3_A137ConAFIPRegDifApo ;
   private String[] BC000B3_A138ConAFIPRegEspApo ;
   private String[] BC000B3_A379ConAfipEstado ;
   private String[] BC000B3_A380ConAFIPTipo ;
   private String[] BC000B3_A381ConAfipSubT1 ;
   private String[] BC000B3_A382ConAfipSubT2 ;
   private boolean[] BC000B3_A703ConAFIPLiquidado ;
   private int[] BC000B3_A3CliCod ;
   private int[] BC000B4_A3CliCod ;
   private boolean[] BC000B2_n386ConAFIPConcepto ;
   private boolean[] BC000B3_n386ConAFIPConcepto ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
}

final  class conceptoafip_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC000B2", "SELECT ConAfipDesc, ConCodPropio, ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAFIPLiquidado, CliCod FROM ConceptoAFIP WHERE CliCod = ? AND ConCodPropio = ?  FOR UPDATE OF ConceptoAFIP",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B3", "SELECT ConAfipDesc, ConCodPropio, ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAFIPLiquidado, CliCod FROM ConceptoAFIP WHERE CliCod = ? AND ConCodPropio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B4", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B5", "SELECT TM1.ConAfipDesc, TM1.ConCodPropio, TM1.ConAFIPConcepto, TM1.ConAFIPMarcaRep, TM1.ConAFIPSIPAApo, TM1.ConAFIPSIPACont, TM1.ConAFIPINSSJyPApo, TM1.ConAFIPINSSJyPCont, TM1.ConAFIPObraSocApo, TM1.ConAFIPObraSocCont, TM1.ConAFIPFonSolRedApo, TM1.ConAFIPFonSolRedCont, TM1.ConAFIPRenateaApo, TM1.ConAFIPRenateaCont, TM1.ConAFIPAsigFamCont, TM1.ConAFIPFonNacEmpCont, TM1.ConAFIPLeyRieTrabCont, TM1.ConAFIPRegDifApo, TM1.ConAFIPRegEspApo, TM1.ConAfipEstado, TM1.ConAFIPTipo, TM1.ConAfipSubT1, TM1.ConAfipSubT2, TM1.ConAFIPLiquidado, TM1.CliCod FROM ConceptoAFIP TM1 WHERE TM1.CliCod = ? and TM1.ConCodPropio = ( ?) ORDER BY TM1.CliCod, TM1.ConCodPropio ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B6", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B7", "SELECT CliCod, ConCodPropio FROM ConceptoAFIP WHERE CliCod = ? AND ConCodPropio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B8", "SELECT ConAfipDesc, ConCodPropio, ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAFIPLiquidado, CliCod FROM ConceptoAFIP WHERE CliCod = ? AND ConCodPropio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B9", "SELECT ConAfipDesc, ConCodPropio, ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAFIPLiquidado, CliCod FROM ConceptoAFIP WHERE CliCod = ? AND ConCodPropio = ?  FOR UPDATE OF ConceptoAFIP",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000B10", "SAVEPOINT gxupdate;INSERT INTO ConceptoAFIP(ConAfipDesc, ConCodPropio, ConAFIPConcepto, ConAFIPMarcaRep, ConAFIPSIPAApo, ConAFIPSIPACont, ConAFIPINSSJyPApo, ConAFIPINSSJyPCont, ConAFIPObraSocApo, ConAFIPObraSocCont, ConAFIPFonSolRedApo, ConAFIPFonSolRedCont, ConAFIPRenateaApo, ConAFIPRenateaCont, ConAFIPAsigFamCont, ConAFIPFonNacEmpCont, ConAFIPLeyRieTrabCont, ConAFIPRegDifApo, ConAFIPRegEspApo, ConAfipEstado, ConAFIPTipo, ConAfipSubT1, ConAfipSubT2, ConAFIPLiquidado, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000B11", "SAVEPOINT gxupdate;UPDATE ConceptoAFIP SET ConAfipDesc=?, ConAFIPConcepto=?, ConAFIPMarcaRep=?, ConAFIPSIPAApo=?, ConAFIPSIPACont=?, ConAFIPINSSJyPApo=?, ConAFIPINSSJyPCont=?, ConAFIPObraSocApo=?, ConAFIPObraSocCont=?, ConAFIPFonSolRedApo=?, ConAFIPFonSolRedCont=?, ConAFIPRenateaApo=?, ConAFIPRenateaCont=?, ConAFIPAsigFamCont=?, ConAFIPFonNacEmpCont=?, ConAFIPLeyRieTrabCont=?, ConAFIPRegDifApo=?, ConAFIPRegEspApo=?, ConAfipEstado=?, ConAFIPTipo=?, ConAfipSubT1=?, ConAfipSubT2=?, ConAFIPLiquidado=?  WHERE CliCod = ? AND ConCodPropio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000B12", "SAVEPOINT gxupdate;DELETE FROM ConceptoAFIP  WHERE CliCod = ? AND ConCodPropio = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000B13", "SELECT TM1.ConAfipDesc, TM1.ConCodPropio, TM1.ConAFIPConcepto, TM1.ConAFIPMarcaRep, TM1.ConAFIPSIPAApo, TM1.ConAFIPSIPACont, TM1.ConAFIPINSSJyPApo, TM1.ConAFIPINSSJyPCont, TM1.ConAFIPObraSocApo, TM1.ConAFIPObraSocCont, TM1.ConAFIPFonSolRedApo, TM1.ConAFIPFonSolRedCont, TM1.ConAFIPRenateaApo, TM1.ConAFIPRenateaCont, TM1.ConAFIPAsigFamCont, TM1.ConAFIPFonNacEmpCont, TM1.ConAFIPLeyRieTrabCont, TM1.ConAFIPRegDifApo, TM1.ConAFIPRegEspApo, TM1.ConAfipEstado, TM1.ConAFIPTipo, TM1.ConAfipSubT1, TM1.ConAfipSubT2, TM1.ConAFIPLiquidado, TM1.CliCod FROM ConceptoAFIP TM1 WHERE TM1.CliCod = ? and TM1.ConCodPropio = ( ?) ORDER BY TM1.CliCod, TM1.ConCodPropio ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B14", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000B15", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 1);
               ((String[]) buf[5])[0] = rslt.getString(5, 1);
               ((String[]) buf[6])[0] = rslt.getString(6, 1);
               ((String[]) buf[7])[0] = rslt.getString(7, 1);
               ((String[]) buf[8])[0] = rslt.getString(8, 1);
               ((String[]) buf[9])[0] = rslt.getString(9, 1);
               ((String[]) buf[10])[0] = rslt.getString(10, 1);
               ((String[]) buf[11])[0] = rslt.getString(11, 1);
               ((String[]) buf[12])[0] = rslt.getString(12, 1);
               ((String[]) buf[13])[0] = rslt.getString(13, 1);
               ((String[]) buf[14])[0] = rslt.getString(14, 1);
               ((String[]) buf[15])[0] = rslt.getString(15, 1);
               ((String[]) buf[16])[0] = rslt.getString(16, 1);
               ((String[]) buf[17])[0] = rslt.getString(17, 1);
               ((String[]) buf[18])[0] = rslt.getString(18, 1);
               ((String[]) buf[19])[0] = rslt.getString(19, 1);
               ((String[]) buf[20])[0] = rslt.getString(20, 20);
               ((String[]) buf[21])[0] = rslt.getString(21, 20);
               ((String[]) buf[22])[0] = rslt.getString(22, 20);
               ((String[]) buf[23])[0] = rslt.getString(23, 20);
               ((boolean[]) buf[24])[0] = rslt.getBoolean(24);
               ((int[]) buf[25])[0] = rslt.getInt(25);
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
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 6);
               }
               stmt.setString(4, (String)parms[4], 1);
               stmt.setString(5, (String)parms[5], 1);
               stmt.setString(6, (String)parms[6], 1);
               stmt.setString(7, (String)parms[7], 1);
               stmt.setString(8, (String)parms[8], 1);
               stmt.setString(9, (String)parms[9], 1);
               stmt.setString(10, (String)parms[10], 1);
               stmt.setString(11, (String)parms[11], 1);
               stmt.setString(12, (String)parms[12], 1);
               stmt.setString(13, (String)parms[13], 1);
               stmt.setString(14, (String)parms[14], 1);
               stmt.setString(15, (String)parms[15], 1);
               stmt.setString(16, (String)parms[16], 1);
               stmt.setString(17, (String)parms[17], 1);
               stmt.setString(18, (String)parms[18], 1);
               stmt.setString(19, (String)parms[19], 1);
               stmt.setString(20, (String)parms[20], 20);
               stmt.setString(21, (String)parms[21], 20);
               stmt.setString(22, (String)parms[22], 20);
               stmt.setString(23, (String)parms[23], 20);
               stmt.setBoolean(24, ((Boolean) parms[24]).booleanValue());
               stmt.setInt(25, ((Number) parms[25]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 6);
               }
               stmt.setString(3, (String)parms[3], 1);
               stmt.setString(4, (String)parms[4], 1);
               stmt.setString(5, (String)parms[5], 1);
               stmt.setString(6, (String)parms[6], 1);
               stmt.setString(7, (String)parms[7], 1);
               stmt.setString(8, (String)parms[8], 1);
               stmt.setString(9, (String)parms[9], 1);
               stmt.setString(10, (String)parms[10], 1);
               stmt.setString(11, (String)parms[11], 1);
               stmt.setString(12, (String)parms[12], 1);
               stmt.setString(13, (String)parms[13], 1);
               stmt.setString(14, (String)parms[14], 1);
               stmt.setString(15, (String)parms[15], 1);
               stmt.setString(16, (String)parms[16], 1);
               stmt.setString(17, (String)parms[17], 1);
               stmt.setString(18, (String)parms[18], 1);
               stmt.setString(19, (String)parms[19], 20);
               stmt.setString(20, (String)parms[20], 20);
               stmt.setString(21, (String)parms[21], 20);
               stmt.setString(22, (String)parms[22], 20);
               stmt.setBoolean(23, ((Boolean) parms[23]).booleanValue());
               stmt.setInt(24, ((Number) parms[24]).intValue());
               stmt.setString(25, (String)parms[25], 20);
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

