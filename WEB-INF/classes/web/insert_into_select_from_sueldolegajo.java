package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class insert_into_select_from_sueldolegajo extends GXProcedure
{
   public insert_into_select_from_sueldolegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( insert_into_select_from_sueldolegajo.class ), "" );
   }

   public insert_into_select_from_sueldolegajo( int remoteHandle ,
                                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        String aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             String aP6 )
   {
      insert_into_select_from_sueldolegajo.this.AV11CliCod = aP0;
      insert_into_select_from_sueldolegajo.this.AV13EmpCod = aP1;
      insert_into_select_from_sueldolegajo.this.AV12LiqNro = aP2;
      insert_into_select_from_sueldolegajo.this.AV9LegNumero = aP3;
      insert_into_select_from_sueldolegajo.this.AV25PreliqPeriodo = aP4;
      insert_into_select_from_sueldolegajo.this.AV30LegSuelSec = aP5;
      insert_into_select_from_sueldolegajo.this.AV14TLiqCod = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV26PreliqPeriodoPalabra = GXutil.trim( GXutil.str( GXutil.year( AV25PreliqPeriodo), 10, 0)) + GXutil.padl( GXutil.str( GXutil.month( AV25PreliqPeriodo), 10, 0), (short)(2), "0") + GXutil.padl( GXutil.str( GXutil.day( AV25PreliqPeriodo), 10, 0), (short)(2), "0") ;
      /* User SQL Command. */
      cmdBuffer = " INSERT INTO LiquidacionDetalle (clicod,empcod,liqnro,legnumero, LiqDClasifAux, DConConveCodigo,DConCondicion,LiqDSecuencial,dconcodigo,dliqperiodo,dcondescrip,DTLiqCod,DTipoConCod,dsubtipoconcod1,liqdcanti,liqdvaluni,LiqDImporte,LiqDImpCalcu,liqdformula,LiqDErrorDesc,DConVariable,dconorden,liqdmostrar,liqdfororig,LiqDCalculado,LiqDFormulaHTML,LiqDOrdEjec,DSubTipoConCod2,dliqperano,liqdformuaux,LiqDRecalculado,LiqDImpReCalcu,LiqdFormuRecalc,LiqDReFormulaHTML,liqdvueltares,LiqDUniMed,LiqDSIPAApo,LiqDSIPACont,LiqDINSSJyPApo,LiqDINSSJyPCont,LiqDObraSocApo,LiqDObraSocCont,LiqDFonSolRedApo,LiqDFonSolRedCont,LiqDRenateaApo,LiqDRenateaCont,LiqDAsigFamCont,LiqDFonNacEmpCont,LiqDLeyRieTrabCont,LiqDRegDifApo,LiqDRegEspApo,LiqDLog,LiqDLogRecal,LiqDNovedad,LiqDAdelDescu,DAplIIGG,LiqDProrr,LiqDOrdVis,LiqDLote,LiqDPlus,liqdseg,DConLiqBasica) SELECT " + AV11CliCod + "," + AV13EmpCod + "," + AV12LiqNro + "," + AV9LegNumero + ",c.ConClasifAux, '','',Suel.LegSuelConSec,Suel.LegSuelConcepto,'" + AV26PreliqPeriodoPalabra + "',C.ConDescrip,'" + AV14TLiqCod + "',C.TipoConCod,C.SubTipoConCod1,Suel.LegSuelConCnt,Suel.LegSuelConValU,Suel.LegSuelConImp,Suel.LegSuelConImp,Suel.LegSuelConFor,'',false,C.ConOrden,3,Suel.LegSuelConFor,1,Suel.LegSuelConFor,Suel.LegSuelConOrdE,C.SubTipoConCod2," + AV10DLiqPerAno + ",'',2,Suel.LegSuelConImp,'',Suel.LegSuelConFor,0,'',C.ConSIPAApo,C.ConSIPACont,C.ConINSSJyPApo,C.ConINSSJyPCont,C.ConObraSocApo,C.ConObraSocCont,C.ConFonSolRedApo,C.ConFonSolRedCont,C.ConRenateaApo,C.ConRenateaCont,C.ConAsigFamCont,C.ConFonNacEmpCont,C.ConLeyRieTrabCont,C.ConRegDifApo,C.ConRegEspApo,Suel.LegSuelLiqDLog,Suel.LegSuelLiqDLog,false,C.ConAdelDescu,C.AplIIGG,'SIN',C.ConOrden,1,0,0,1 FROM Legajo_sueldosConceptos Suel JOIN Concepto C ON Suel.LegSuelConcepto=C.ConCodigo and Suel.clicod = C.CliCod WHERE Suel.clicod=" + AV11CliCod + " and Suel.EmpCod=" + AV13EmpCod + " and Suel.LegNumero=" + AV9LegNumero + " and Suel.LegSuelSec=" + AV30LegSuelSec + ";" ;
      ExecuteDirectSQL.execute(context, remoteHandle, "DEFAULT", cmdBuffer) ;
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
      AV26PreliqPeriodoPalabra = "" ;
      cmdBuffer = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV30LegSuelSec ;
   private short AV10DLiqPerAno ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV12LiqNro ;
   private int AV9LegNumero ;
   private String AV14TLiqCod ;
   private String AV26PreliqPeriodoPalabra ;
   private String cmdBuffer ;
   private java.util.Date AV25PreliqPeriodo ;
}

