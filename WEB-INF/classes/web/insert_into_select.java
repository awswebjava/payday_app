package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class insert_into_select extends GXProcedure
{
   public insert_into_select( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( insert_into_select.class ), "" );
   }

   public insert_into_select( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        String aP3 ,
                        int aP4 ,
                        short aP5 ,
                        int aP6 ,
                        GXSimpleCollection<String> aP7 ,
                        GXSimpleCollection<String> aP8 ,
                        boolean aP9 ,
                        int aP10 ,
                        short aP11 ,
                        String aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             String aP3 ,
                             int aP4 ,
                             short aP5 ,
                             int aP6 ,
                             GXSimpleCollection<String> aP7 ,
                             GXSimpleCollection<String> aP8 ,
                             boolean aP9 ,
                             int aP10 ,
                             short aP11 ,
                             String aP12 )
   {
      insert_into_select.this.AV12CliCod = aP0;
      insert_into_select.this.AV14EmpCod = aP1;
      insert_into_select.this.AV16LiqPeriodo = aP2;
      insert_into_select.this.AV15TLiqCod = aP3;
      insert_into_select.this.AV13LiqNro = aP4;
      insert_into_select.this.AV11DLiqPerAno = aP5;
      insert_into_select.this.AV10LegNumero = aP6;
      insert_into_select.this.AV19ConCondicion = aP7;
      insert_into_select.this.AV22ConCodigo = aP8;
      insert_into_select.this.AV20basicaEs = aP9;
      insert_into_select.this.AV23LiqDSecuencial = aP10;
      insert_into_select.this.AV25PaiCod = aP11;
      insert_into_select.this.AV24ConveCodigo = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17LiqPeriodoPalabra = GXutil.trim( GXutil.str( GXutil.year( AV16LiqPeriodo), 10, 0)) + GXutil.padl( GXutil.str( GXutil.month( AV16LiqPeriodo), 10, 0), (short)(2), "0") + GXutil.padl( GXutil.str( GXutil.day( AV16LiqPeriodo), 10, 0), (short)(2), "0") ;
      AV18condiciones = GXutil.strReplace( GXutil.trim( AV19ConCondicion.toJSonString(false)), "[", "(") ;
      AV18condiciones = GXutil.strReplace( AV18condiciones, "]", ")") ;
      AV18condiciones = GXutil.strReplace( AV18condiciones, "\"", "'") ;
      AV21excluConceptos = GXutil.strReplace( GXutil.trim( AV22ConCodigo.toJSonString(false)), "[", "(") ;
      AV21excluConceptos = GXutil.strReplace( AV21excluConceptos, "]", ")") ;
      AV21excluConceptos = GXutil.strReplace( AV21excluConceptos, "\"", "'") ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "basicaes ", "")+GXutil.trim( GXutil.booltostr( AV20basicaEs))+httpContext.getMessage( " &condiciones ", "")+AV18condiciones) ;
      AV26sin_cuotas = "SIN" ;
      AV26sin_cuotas = GXutil.trim( AV26sin_cuotas) ;
      if ( (GXutil.strcmp("", AV27db_palabra)==0) )
      {
         AV27db_palabra = httpContext.getMessage( "paga_sueldos", "") ;
      }
      if ( ! AV20basicaEs )
      {
         if ( AV22ConCodigo.size() > 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "4antes", "")) ;
            /* User SQL Command. */
            cmdBuffer = " INSERT INTO LiquidacionDetalle (clicod, empcod, liqnro, legnumero, LiqDClasifAux, DConConveCodigo, DConCondicion, LiqDSecuencial, dconcodigo, dliqperiodo, dcondescrip, DTLiqCod, DTipoConCod, dsubtipoconcod1, liqdcanti, liqdvaluni, LiqDImporte, LiqDImpCalcu, liqdformula, LiqDErrorDesc, DConVariable, dconorden, liqdmostrar, liqdfororig, LiqDCalculado, LiqDFormulaHTML, LiqDOrdEjec, DSubTipoConCod2, dliqperano, liqdformuaux, LiqDRecalculado, LiqDImpReCalcu, LiqdFormuRecalc, LiqDReFormulaHTML, liqdvueltares, LiqDUniMed, LiqDSIPAApo, LiqDSIPACont, LiqDINSSJyPApo, LiqDINSSJyPCont, LiqDObraSocApo, LiqDObraSocCont, LiqDFonSolRedApo, LiqDFonSolRedCont, LiqDRenateaApo, LiqDRenateaCont, LiqDAsigFamCont, LiqDFonNacEmpCont,LiqDLeyRieTrabCont, LiqDRegDifApo, LiqDRegEspApo, LiqDLog, LiqDLogRecal, LiqDNovedad, LiqDAdelDescu, DAplIIGG, LiqDProrr, LiqDOrdVis, LiqDLote, LiqDPlus, liqdseg, DConLiqBasica) SELECT " + AV12CliCod + " , " + AV14EmpCod + " , " + AV13LiqNro + ", " + AV10LegNumero + ", c.ConClasifAux, '" + AV24ConveCodigo + "', c.ConCondicion, c.ConNumero + " + AV23LiqDSecuencial + ", c.concodigo, '" + AV17LiqPeriodoPalabra + "', c.condescrip, '" + AV15TLiqCod + "', c.TipoConCod, c.subtipoconcod1, 0, 0, 0, 0, c.ConFormula, '', c.ConVariable, c.conorden, 0, c.ConFormula, 0, c.ConFormula, c.ConOrdEjec, c.SubTipoConCod2, " + AV11DLiqPerAno + ", '', CASE WHEN c.ConRecalcular = false then 2 else 1 end, 0, '', 	c.ConFormula, 0, '', c.ConSIPAApo, c.ConSIPACont, c.ConINSSJyPApo, c.ConINSSJyPCont, c.ConObraSocApo, c.ConObraSocCont, c.ConFonSolRedApo, c.ConFonSolRedCont, c.ConRenateaApo, c.ConRenateaCont, c.ConAsigFamCont, c.ConFonNacEmpCont,c.ConLeyRieTrabCont, c.ConRegDifApo, c.ConRegEspApo, 	'', '', false, c.ConAdelDescu, c.AplIIGG, CASE WHEN c.AplIIGG is null then '" + AV26sin_cuotas + "' else (select AplIIGGPrrtear from tipo_aplicacion_ganancias where clicod = " + AV12CliCod + " and AplIIGG = c.AplIIGG) end, c.ConOrden, 1, 0, 0, 0 FROM Concepto c inner join conceptotipoliquidacion t ON c.clicod = t.clicod and c.concodigo = t.concodigo and t.tliqcod = '" + AV15TLiqCod + "' WHERE c.clicod = " + AV12CliCod + " and ConCondicion not in " + AV18condiciones + " and ConVigencia = 0 and ConHabilitado = true and ((ConceptoConveCodigo = '" + AV24ConveCodigo + "' and ConceptoPais = '" + AV25PaiCod + "') or ConceptoConveCodigo is null)  and c.ConCodigo not in " + AV21excluConceptos + " order by c.clicod, c.ConVigencia, c.TipoConCod;" ;
            ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "4despues &ConCodigo ", "")+AV22ConCodigo.toJSonString(false)) ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "3antes", "")) ;
            /* User SQL Command. */
            cmdBuffer = " INSERT INTO LiquidacionDetalle (clicod, empcod, liqnro, legnumero, LiqDClasifAux, DConConveCodigo, DConCondicion, LiqDSecuencial, dconcodigo, dliqperiodo, dcondescrip, DTLiqCod, DTipoConCod, dsubtipoconcod1, liqdcanti, liqdvaluni, LiqDImporte, LiqDImpCalcu, liqdformula, LiqDErrorDesc, DConVariable, dconorden, liqdmostrar, liqdfororig, LiqDCalculado, LiqDFormulaHTML, LiqDOrdEjec, DSubTipoConCod2, dliqperano, liqdformuaux, LiqDRecalculado, LiqDImpReCalcu, LiqdFormuRecalc, LiqDReFormulaHTML, liqdvueltares, LiqDUniMed, LiqDSIPAApo, LiqDSIPACont, LiqDINSSJyPApo, LiqDINSSJyPCont, LiqDObraSocApo, LiqDObraSocCont, LiqDFonSolRedApo, LiqDFonSolRedCont, LiqDRenateaApo, LiqDRenateaCont, LiqDAsigFamCont, LiqDFonNacEmpCont,LiqDLeyRieTrabCont, LiqDRegDifApo, LiqDRegEspApo, LiqDLog, LiqDLogRecal, LiqDNovedad, LiqDAdelDescu, DAplIIGG, LiqDProrr, LiqDOrdVis, LiqDLote, LiqDPlus, liqdseg, DConLiqBasica) SELECT " + AV12CliCod + " , " + AV14EmpCod + " , " + AV13LiqNro + ", " + AV10LegNumero + ", c.ConClasifAux, '" + AV24ConveCodigo + "', c.ConCondicion, c.ConNumero + " + AV23LiqDSecuencial + ", c.concodigo, '" + AV17LiqPeriodoPalabra + "', c.condescrip, '" + AV15TLiqCod + "', c.TipoConCod, c.subtipoconcod1, 0, 0, 0, 0, c.ConFormula, '', c.ConVariable, c.conorden, 0, c.ConFormula, 0, c.ConFormula, c.ConOrdEjec, c.SubTipoConCod2, " + AV11DLiqPerAno + ", '', CASE WHEN c.ConRecalcular = false then 2 else 1 end, 0, '', 	c.ConFormula, 0, '', c.ConSIPAApo, c.ConSIPACont, c.ConINSSJyPApo, c.ConINSSJyPCont, c.ConObraSocApo, c.ConObraSocCont, c.ConFonSolRedApo, c.ConFonSolRedCont, c.ConRenateaApo, c.ConRenateaCont, c.ConAsigFamCont, c.ConFonNacEmpCont,c.ConLeyRieTrabCont, c.ConRegDifApo, c.ConRegEspApo, 	'', '', false, c.ConAdelDescu, c.AplIIGG, CASE WHEN c.AplIIGG is null then '" + AV26sin_cuotas + "' else (select AplIIGGPrrtear from tipo_aplicacion_ganancias where clicod = " + AV12CliCod + " and AplIIGG = c.AplIIGG) end, c.ConOrden, 1, 0, 0, 0 FROM Concepto c inner join conceptotipoliquidacion t ON c.clicod = t.clicod and c.concodigo = t.concodigo and t.tliqcod = '" + AV15TLiqCod + "' WHERE c.clicod = " + AV12CliCod + " and ConCondicion not in " + AV18condiciones + " and ConVigencia = 0 and ConHabilitado = true and ((ConceptoConveCodigo = '" + AV24ConveCodigo + "' and ConceptoPais = '" + AV25PaiCod + "') or ConceptoConveCodigo is null) order by c.clicod, c.ConVigencia, c.TipoConCod;" ;
            ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "3despues", "")) ;
         }
      }
      else
      {
         AV28tipoDescuentoPalabra = "DES_ARG" ;
         AV28tipoDescuentoPalabra = GXutil.trim( AV28tipoDescuentoPalabra) ;
         AV29tipoRemunerativoPalabra = "REM_ARG" ;
         AV29tipoRemunerativoPalabra = GXutil.trim( AV29tipoRemunerativoPalabra) ;
         if ( AV22ConCodigo.size() > 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "2antes", "")) ;
            /* User SQL Command. */
            cmdBuffer = " INSERT INTO LiquidacionDetalle (clicod, empcod, liqnro, legnumero, LiqDClasifAux, DConConveCodigo, DConCondicion, LiqDSecuencial, dconcodigo, dliqperiodo, dcondescrip, DTLiqCod, DTipoConCod, dsubtipoconcod1, liqdcanti, liqdvaluni, LiqDImporte, LiqDImpCalcu, liqdformula, LiqDErrorDesc, DConVariable, dconorden, liqdmostrar, liqdfororig, LiqDCalculado, LiqDFormulaHTML, LiqDOrdEjec, DSubTipoConCod2, dliqperano, liqdformuaux, LiqDRecalculado, LiqDImpReCalcu, LiqdFormuRecalc, LiqDReFormulaHTML, liqdvueltares, LiqDUniMed, LiqDSIPAApo, LiqDSIPACont, LiqDINSSJyPApo, LiqDINSSJyPCont, LiqDObraSocApo, LiqDObraSocCont, LiqDFonSolRedApo, LiqDFonSolRedCont, LiqDRenateaApo, LiqDRenateaCont, LiqDAsigFamCont, LiqDFonNacEmpCont,LiqDLeyRieTrabCont, LiqDRegDifApo, LiqDRegEspApo, LiqDLog, LiqDLogRecal, LiqDNovedad, LiqDAdelDescu, DAplIIGG, LiqDProrr, LiqDOrdVis, LiqDLote, LiqDPlus, liqdseg, DConLiqBasica) SELECT " + AV12CliCod + " , " + AV14EmpCod + " , " + AV13LiqNro + ", " + AV10LegNumero + ", c.ConClasifAux, '" + AV24ConveCodigo + "', c.ConCondicion, c.ConNumero + " + AV23LiqDSecuencial + ", c.concodigo, '" + AV17LiqPeriodoPalabra + "', c.condescrip, '" + AV15TLiqCod + "', c.TipoConCod, c.subtipoconcod1, 0, 0, 0, 0, c.ConFormula, '', c.ConVariable, c.conorden, 0, c.ConFormula, 0, c.ConFormula, c.ConOrdEjec, c.SubTipoConCod2, " + AV11DLiqPerAno + ", '', CASE WHEN c.ConRecalcular = false then 2 else 1 end, 0, '', 	c.ConFormula, 0, '', c.ConSIPAApo, c.ConSIPACont, c.ConINSSJyPApo, c.ConINSSJyPCont, c.ConObraSocApo, c.ConObraSocCont, c.ConFonSolRedApo, c.ConFonSolRedCont, c.ConRenateaApo, c.ConRenateaCont, c.ConAsigFamCont, c.ConFonNacEmpCont,c.ConLeyRieTrabCont, c.ConRegDifApo, c.ConRegEspApo, 	'', '', false, c.ConAdelDescu, c.AplIIGG, CASE WHEN c.AplIIGG is null then '" + AV26sin_cuotas + "' else (select AplIIGGPrrtear from tipo_aplicacion_ganancias where clicod = " + AV12CliCod + " and AplIIGG = c.AplIIGG) end, c.ConOrden, 1, 0, 0, 1 FROM Concepto c inner join conceptotipoliquidacion t ON c.clicod = t.clicod and c.concodigo = t.concodigo and t.tliqcod = '" + AV15TLiqCod + "' WHERE c.clicod = " + AV12CliCod + " and c.TipoConCod >= '" + AV28tipoDescuentoPalabra + "' and c.TipoConCod <= '" + AV29tipoRemunerativoPalabra + "' and ConCondicion not in " + AV18condiciones + " and ConVigencia = 0 and ConHabilitado = true and ((ConceptoConveCodigo = '" + AV24ConveCodigo + "' and ConceptoPais = '" + AV25PaiCod + "') or ConceptoConveCodigo is null)  and c.ConCodigo not in " + AV21excluConceptos + " order by c.clicod, c.ConVigencia; " ;
            ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "despues basica &ConCodigo ", "")+GXutil.trim( AV22ConCodigo.toJSonString(false))) ;
         }
         else
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "1antes", "")) ;
            /* User SQL Command. */
            cmdBuffer = " INSERT INTO LiquidacionDetalle (clicod, empcod, liqnro, legnumero, LiqDClasifAux, DConConveCodigo, DConCondicion, LiqDSecuencial, dconcodigo, dliqperiodo, dcondescrip, DTLiqCod, DTipoConCod, dsubtipoconcod1, liqdcanti, liqdvaluni, LiqDImporte, LiqDImpCalcu, liqdformula, LiqDErrorDesc, DConVariable, dconorden, liqdmostrar, liqdfororig, LiqDCalculado, LiqDFormulaHTML, LiqDOrdEjec, DSubTipoConCod2, dliqperano, liqdformuaux, LiqDRecalculado, LiqDImpReCalcu, LiqdFormuRecalc, LiqDReFormulaHTML, liqdvueltares, LiqDUniMed, LiqDSIPAApo, LiqDSIPACont, LiqDINSSJyPApo, LiqDINSSJyPCont, LiqDObraSocApo, LiqDObraSocCont, LiqDFonSolRedApo, LiqDFonSolRedCont, LiqDRenateaApo, LiqDRenateaCont, LiqDAsigFamCont, LiqDFonNacEmpCont,LiqDLeyRieTrabCont, LiqDRegDifApo, LiqDRegEspApo, LiqDLog, LiqDLogRecal, LiqDNovedad, LiqDAdelDescu, DAplIIGG, LiqDProrr, LiqDOrdVis, LiqDLote, LiqDPlus, liqdseg, DConLiqBasica) SELECT " + AV12CliCod + " , " + AV14EmpCod + " , " + AV13LiqNro + ", " + AV10LegNumero + ", c.ConClasifAux, '" + AV24ConveCodigo + "', c.ConCondicion, c.ConNumero + " + AV23LiqDSecuencial + ", c.concodigo, '" + AV17LiqPeriodoPalabra + "', c.condescrip, '" + AV15TLiqCod + "', c.TipoConCod, c.subtipoconcod1, 0, 0, 0, 0, c.ConFormula, '', c.ConVariable, c.conorden, 0, c.ConFormula, 0, c.ConFormula, c.ConOrdEjec, c.SubTipoConCod2, " + AV11DLiqPerAno + ", '', CASE WHEN c.ConRecalcular = false then 2 else 1 end, 0, '', 	c.ConFormula, 0, '', c.ConSIPAApo, c.ConSIPACont, c.ConINSSJyPApo, c.ConINSSJyPCont, c.ConObraSocApo, c.ConObraSocCont, c.ConFonSolRedApo, c.ConFonSolRedCont, c.ConRenateaApo, c.ConRenateaCont, c.ConAsigFamCont, c.ConFonNacEmpCont,c.ConLeyRieTrabCont, c.ConRegDifApo, c.ConRegEspApo, 	'', '', false, c.ConAdelDescu, c.AplIIGG, CASE WHEN c.AplIIGG is null then '" + AV26sin_cuotas + "' else (select AplIIGGPrrtear from tipo_aplicacion_ganancias where clicod = " + AV12CliCod + " and AplIIGG = c.AplIIGG) end, c.ConOrden, 1, 0, 0, 1 FROM Concepto c inner join conceptotipoliquidacion t ON c.clicod = t.clicod and c.concodigo = t.concodigo and t.tliqcod = '" + AV15TLiqCod + "' WHERE c.clicod = " + AV12CliCod + " and c.TipoConCod >= '" + AV28tipoDescuentoPalabra + "' and c.TipoConCod <= '" + AV29tipoRemunerativoPalabra + "' and ConCondicion not in " + AV18condiciones + " and ConVigencia = 0 and ConHabilitado = true and ((ConceptoConveCodigo = '" + AV24ConveCodigo + "' and ConceptoPais = '" + AV25PaiCod + "') or ConceptoConveCodigo is null) order by c.clicod, c.ConVigencia; " ;
            ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV32Pgmname, httpContext.getMessage( "despues basica basica", "")) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17LiqPeriodoPalabra = "" ;
      AV18condiciones = "" ;
      AV21excluConceptos = "" ;
      AV32Pgmname = "" ;
      AV26sin_cuotas = "" ;
      AV27db_palabra = "" ;
      cmdBuffer = "" ;
      AV28tipoDescuentoPalabra = "" ;
      AV29tipoRemunerativoPalabra = "" ;
      AV32Pgmname = "insert_into_select" ;
      /* GeneXus formulas. */
      AV32Pgmname = "insert_into_select" ;
      Gx_err = (short)(0) ;
   }

   private short AV14EmpCod ;
   private short AV11DLiqPerAno ;
   private short AV25PaiCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV13LiqNro ;
   private int AV10LegNumero ;
   private int AV23LiqDSecuencial ;
   private String AV15TLiqCod ;
   private String AV24ConveCodigo ;
   private String AV17LiqPeriodoPalabra ;
   private String AV32Pgmname ;
   private String AV26sin_cuotas ;
   private String AV27db_palabra ;
   private String cmdBuffer ;
   private String AV28tipoDescuentoPalabra ;
   private String AV29tipoRemunerativoPalabra ;
   private java.util.Date AV16LiqPeriodo ;
   private boolean AV20basicaEs ;
   private String AV18condiciones ;
   private String AV21excluConceptos ;
   private GXSimpleCollection<String> AV19ConCondicion ;
   private GXSimpleCollection<String> AV22ConCodigo ;
}

