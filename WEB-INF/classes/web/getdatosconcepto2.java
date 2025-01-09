package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatosconcepto2 extends GXProcedure
{
   public getdatosconcepto2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatosconcepto2.class ), "" );
   }

   public getdatosconcepto2( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             int[] aP12 ,
                             long[] aP13 ,
                             String[] aP14 ,
                             byte[] aP15 ,
                             boolean[] aP16 ,
                             short[] aP17 ,
                             boolean[] aP18 ,
                             String[] aP19 ,
                             boolean[] aP20 ,
                             byte[] aP21 ,
                             String[] aP22 ,
                             byte[] aP23 ,
                             String[] aP24 )
   {
      getdatosconcepto2.this.aP25 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25);
      return aP25[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 ,
                        boolean[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        int[] aP12 ,
                        long[] aP13 ,
                        String[] aP14 ,
                        byte[] aP15 ,
                        boolean[] aP16 ,
                        short[] aP17 ,
                        boolean[] aP18 ,
                        String[] aP19 ,
                        boolean[] aP20 ,
                        byte[] aP21 ,
                        String[] aP22 ,
                        byte[] aP23 ,
                        String[] aP24 ,
                        String[] aP25 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             int[] aP12 ,
                             long[] aP13 ,
                             String[] aP14 ,
                             byte[] aP15 ,
                             boolean[] aP16 ,
                             short[] aP17 ,
                             boolean[] aP18 ,
                             String[] aP19 ,
                             boolean[] aP20 ,
                             byte[] aP21 ,
                             String[] aP22 ,
                             byte[] aP23 ,
                             String[] aP24 ,
                             String[] aP25 )
   {
      getdatosconcepto2.this.AV8CliCod = aP0;
      getdatosconcepto2.this.AV9ConCodigo = aP1;
      getdatosconcepto2.this.aP2 = aP2;
      getdatosconcepto2.this.aP3 = aP3;
      getdatosconcepto2.this.aP4 = aP4;
      getdatosconcepto2.this.aP5 = aP5;
      getdatosconcepto2.this.aP6 = aP6;
      getdatosconcepto2.this.aP7 = aP7;
      getdatosconcepto2.this.aP8 = aP8;
      getdatosconcepto2.this.aP9 = aP9;
      getdatosconcepto2.this.aP10 = aP10;
      getdatosconcepto2.this.aP11 = aP11;
      getdatosconcepto2.this.aP12 = aP12;
      getdatosconcepto2.this.aP13 = aP13;
      getdatosconcepto2.this.aP14 = aP14;
      getdatosconcepto2.this.aP15 = aP15;
      getdatosconcepto2.this.aP16 = aP16;
      getdatosconcepto2.this.aP17 = aP17;
      getdatosconcepto2.this.aP18 = aP18;
      getdatosconcepto2.this.aP19 = aP19;
      getdatosconcepto2.this.aP20 = aP20;
      getdatosconcepto2.this.aP21 = aP21;
      getdatosconcepto2.this.aP22 = aP22;
      getdatosconcepto2.this.aP23 = aP23;
      getdatosconcepto2.this.aP24 = aP24;
      getdatosconcepto2.this.aP25 = aP25;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " concodigo ", "")+GXutil.trim( AV9ConCodigo)) ;
      /* Using cursor P00RU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00RU2_A26ConCodigo[0] ;
         A3CliCod = P00RU2_A3CliCod[0] ;
         A41ConDescrip = P00RU2_A41ConDescrip[0] ;
         A37TipoConCod = P00RU2_A37TipoConCod[0] ;
         A148ConFormula = P00RU2_A148ConFormula[0] ;
         n148ConFormula = P00RU2_n148ConFormula[0] ;
         A146ConForEditable = P00RU2_A146ConForEditable[0] ;
         n146ConForEditable = P00RU2_n146ConForEditable[0] ;
         A159ConVariable = P00RU2_A159ConVariable[0] ;
         A970ConClasifAux = P00RU2_A970ConClasifAux[0] ;
         n970ConClasifAux = P00RU2_n970ConClasifAux[0] ;
         A38SubTipoConCod1 = P00RU2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00RU2_n38SubTipoConCod1[0] ;
         A371SubTipoConDes1 = P00RU2_A371SubTipoConDes1[0] ;
         A40ConOrden = P00RU2_A40ConOrden[0] ;
         A510ConOrdEjec = P00RU2_A510ConOrdEjec[0] ;
         A569ConFormulaExpl = P00RU2_A569ConFormulaExpl[0] ;
         A39SubTipoConCod2 = P00RU2_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P00RU2_n39SubTipoConCod2[0] ;
         A372SubTipoConDes2 = P00RU2_A372SubTipoConDes2[0] ;
         A162ConVigencia = P00RU2_A162ConVigencia[0] ;
         A762ConRecalcular = P00RU2_A762ConRecalcular[0] ;
         A1112AplIIGG = P00RU2_A1112AplIIGG[0] ;
         n1112AplIIGG = P00RU2_n1112AplIIGG[0] ;
         A1066ConPreReq = P00RU2_A1066ConPreReq[0] ;
         n1066ConPreReq = P00RU2_n1066ConPreReq[0] ;
         A1068ConMostrarPos = P00RU2_A1068ConMostrarPos[0] ;
         A1077ConAdelDescu = P00RU2_A1077ConAdelDescu[0] ;
         n1077ConAdelDescu = P00RU2_n1077ConAdelDescu[0] ;
         A953ConCondicion = P00RU2_A953ConCondicion[0] ;
         n953ConCondicion = P00RU2_n953ConCondicion[0] ;
         A1488ConLiqBasica = P00RU2_A1488ConLiqBasica[0] ;
         A1645ConceptoConveCodigo = P00RU2_A1645ConceptoConveCodigo[0] ;
         n1645ConceptoConveCodigo = P00RU2_n1645ConceptoConveCodigo[0] ;
         A371SubTipoConDes1 = P00RU2_A371SubTipoConDes1[0] ;
         A372SubTipoConDes2 = P00RU2_A372SubTipoConDes2[0] ;
         AV10ConDescrip = A41ConDescrip ;
         AV13TipoConCod = A37TipoConCod ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&TipoConCod ", "")+AV13TipoConCod+httpContext.getMessage( " TipoConCod ", "")+A37TipoConCod) ;
         AV12ConFormula = A148ConFormula ;
         AV11ConForEditable = A146ConForEditable ;
         AV14ConVariable = A159ConVariable ;
         AV29ConClasifAux = A970ConClasifAux ;
         AV16DSubTipoConCod1 = A38SubTipoConCod1 ;
         AV17DSubTipoConDes1 = A371SubTipoConDes1 ;
         AV18ConOrden = A40ConOrden ;
         AV19ConOrdEjec = A510ConOrdEjec ;
         AV21ConFormulaExpl = A569ConFormulaExpl ;
         AV23DSubTipoConCod2 = A39SubTipoConCod2 ;
         AV24DSubTipoConDes2 = A372SubTipoConDes2 ;
         AV25ConVigencia = A162ConVigencia ;
         AV26ConRecalcular = A762ConRecalcular ;
         AV35AplIIGG = A1112AplIIGG ;
         AV30ConPreReq = A1066ConPreReq ;
         AV31ConMostrarPos = A1068ConMostrarPos ;
         AV33ConAdelDescu = A1077ConAdelDescu ;
         AV36ConCondicion = A953ConCondicion ;
         AV37ConLiqBasica = A1488ConLiqBasica ;
         AV39ConceptoConveCodigo = A1645ConceptoConveCodigo ;
         AV29ConClasifAux = A970ConClasifAux ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getdatosconcepto2.this.AV10ConDescrip;
      this.aP3[0] = getdatosconcepto2.this.AV13TipoConCod;
      this.aP4[0] = getdatosconcepto2.this.AV12ConFormula;
      this.aP5[0] = getdatosconcepto2.this.AV11ConForEditable;
      this.aP6[0] = getdatosconcepto2.this.AV14ConVariable;
      this.aP7[0] = getdatosconcepto2.this.AV16DSubTipoConCod1;
      this.aP8[0] = getdatosconcepto2.this.AV17DSubTipoConDes1;
      this.aP9[0] = getdatosconcepto2.this.AV23DSubTipoConCod2;
      this.aP10[0] = getdatosconcepto2.this.AV24DSubTipoConDes2;
      this.aP11[0] = getdatosconcepto2.this.AV29ConClasifAux;
      this.aP12[0] = getdatosconcepto2.this.AV18ConOrden;
      this.aP13[0] = getdatosconcepto2.this.AV19ConOrdEjec;
      this.aP14[0] = getdatosconcepto2.this.AV21ConFormulaExpl;
      this.aP15[0] = getdatosconcepto2.this.AV25ConVigencia;
      this.aP16[0] = getdatosconcepto2.this.AV26ConRecalcular;
      this.aP17[0] = getdatosconcepto2.this.AV35AplIIGG;
      this.aP18[0] = getdatosconcepto2.this.AV28ConSegVuelta;
      this.aP19[0] = getdatosconcepto2.this.AV30ConPreReq;
      this.aP20[0] = getdatosconcepto2.this.AV31ConMostrarPos;
      this.aP21[0] = getdatosconcepto2.this.AV33ConAdelDescu;
      this.aP22[0] = getdatosconcepto2.this.AV36ConCondicion;
      this.aP23[0] = getdatosconcepto2.this.AV37ConLiqBasica;
      this.aP24[0] = getdatosconcepto2.this.AV39ConceptoConveCodigo;
      this.aP25[0] = getdatosconcepto2.this.AV29ConClasifAux;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConDescrip = "" ;
      AV13TipoConCod = "" ;
      AV12ConFormula = "" ;
      AV16DSubTipoConCod1 = "" ;
      AV17DSubTipoConDes1 = "" ;
      AV23DSubTipoConCod2 = "" ;
      AV24DSubTipoConDes2 = "" ;
      AV29ConClasifAux = "" ;
      AV21ConFormulaExpl = "" ;
      AV30ConPreReq = "" ;
      AV36ConCondicion = "" ;
      AV39ConceptoConveCodigo = "" ;
      AV42Pgmname = "" ;
      scmdbuf = "" ;
      P00RU2_A26ConCodigo = new String[] {""} ;
      P00RU2_A3CliCod = new int[1] ;
      P00RU2_A41ConDescrip = new String[] {""} ;
      P00RU2_A37TipoConCod = new String[] {""} ;
      P00RU2_A148ConFormula = new String[] {""} ;
      P00RU2_n148ConFormula = new boolean[] {false} ;
      P00RU2_A146ConForEditable = new boolean[] {false} ;
      P00RU2_n146ConForEditable = new boolean[] {false} ;
      P00RU2_A159ConVariable = new boolean[] {false} ;
      P00RU2_A970ConClasifAux = new String[] {""} ;
      P00RU2_n970ConClasifAux = new boolean[] {false} ;
      P00RU2_A38SubTipoConCod1 = new String[] {""} ;
      P00RU2_n38SubTipoConCod1 = new boolean[] {false} ;
      P00RU2_A371SubTipoConDes1 = new String[] {""} ;
      P00RU2_A40ConOrden = new int[1] ;
      P00RU2_A510ConOrdEjec = new long[1] ;
      P00RU2_A569ConFormulaExpl = new String[] {""} ;
      P00RU2_A39SubTipoConCod2 = new String[] {""} ;
      P00RU2_n39SubTipoConCod2 = new boolean[] {false} ;
      P00RU2_A372SubTipoConDes2 = new String[] {""} ;
      P00RU2_A162ConVigencia = new byte[1] ;
      P00RU2_A762ConRecalcular = new boolean[] {false} ;
      P00RU2_A1112AplIIGG = new short[1] ;
      P00RU2_n1112AplIIGG = new boolean[] {false} ;
      P00RU2_A1066ConPreReq = new String[] {""} ;
      P00RU2_n1066ConPreReq = new boolean[] {false} ;
      P00RU2_A1068ConMostrarPos = new boolean[] {false} ;
      P00RU2_A1077ConAdelDescu = new byte[1] ;
      P00RU2_n1077ConAdelDescu = new boolean[] {false} ;
      P00RU2_A953ConCondicion = new String[] {""} ;
      P00RU2_n953ConCondicion = new boolean[] {false} ;
      P00RU2_A1488ConLiqBasica = new byte[1] ;
      P00RU2_A1645ConceptoConveCodigo = new String[] {""} ;
      P00RU2_n1645ConceptoConveCodigo = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A148ConFormula = "" ;
      A970ConClasifAux = "" ;
      A38SubTipoConCod1 = "" ;
      A371SubTipoConDes1 = "" ;
      A569ConFormulaExpl = "" ;
      A39SubTipoConCod2 = "" ;
      A372SubTipoConDes2 = "" ;
      A1066ConPreReq = "" ;
      A953ConCondicion = "" ;
      A1645ConceptoConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatosconcepto2__default(),
         new Object[] {
             new Object[] {
            P00RU2_A26ConCodigo, P00RU2_A3CliCod, P00RU2_A41ConDescrip, P00RU2_A37TipoConCod, P00RU2_A148ConFormula, P00RU2_n148ConFormula, P00RU2_A146ConForEditable, P00RU2_n146ConForEditable, P00RU2_A159ConVariable, P00RU2_A970ConClasifAux,
            P00RU2_n970ConClasifAux, P00RU2_A38SubTipoConCod1, P00RU2_n38SubTipoConCod1, P00RU2_A371SubTipoConDes1, P00RU2_A40ConOrden, P00RU2_A510ConOrdEjec, P00RU2_A569ConFormulaExpl, P00RU2_A39SubTipoConCod2, P00RU2_n39SubTipoConCod2, P00RU2_A372SubTipoConDes2,
            P00RU2_A162ConVigencia, P00RU2_A762ConRecalcular, P00RU2_A1112AplIIGG, P00RU2_n1112AplIIGG, P00RU2_A1066ConPreReq, P00RU2_n1066ConPreReq, P00RU2_A1068ConMostrarPos, P00RU2_A1077ConAdelDescu, P00RU2_n1077ConAdelDescu, P00RU2_A953ConCondicion,
            P00RU2_n953ConCondicion, P00RU2_A1488ConLiqBasica, P00RU2_A1645ConceptoConveCodigo, P00RU2_n1645ConceptoConveCodigo
            }
         }
      );
      AV42Pgmname = "getDatosConcepto2" ;
      /* GeneXus formulas. */
      AV42Pgmname = "getDatosConcepto2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25ConVigencia ;
   private byte AV33ConAdelDescu ;
   private byte AV37ConLiqBasica ;
   private byte A162ConVigencia ;
   private byte A1077ConAdelDescu ;
   private byte A1488ConLiqBasica ;
   private short AV35AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV18ConOrden ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private long AV19ConOrdEjec ;
   private long A510ConOrdEjec ;
   private String AV9ConCodigo ;
   private String AV13TipoConCod ;
   private String AV16DSubTipoConCod1 ;
   private String AV23DSubTipoConCod2 ;
   private String AV30ConPreReq ;
   private String AV36ConCondicion ;
   private String AV39ConceptoConveCodigo ;
   private String AV42Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private String A1066ConPreReq ;
   private String A953ConCondicion ;
   private String A1645ConceptoConveCodigo ;
   private boolean AV11ConForEditable ;
   private boolean AV14ConVariable ;
   private boolean AV26ConRecalcular ;
   private boolean AV28ConSegVuelta ;
   private boolean AV31ConMostrarPos ;
   private boolean n148ConFormula ;
   private boolean A146ConForEditable ;
   private boolean n146ConForEditable ;
   private boolean A159ConVariable ;
   private boolean n970ConClasifAux ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean A762ConRecalcular ;
   private boolean n1112AplIIGG ;
   private boolean n1066ConPreReq ;
   private boolean A1068ConMostrarPos ;
   private boolean n1077ConAdelDescu ;
   private boolean n953ConCondicion ;
   private boolean n1645ConceptoConveCodigo ;
   private String AV12ConFormula ;
   private String AV21ConFormulaExpl ;
   private String A148ConFormula ;
   private String A569ConFormulaExpl ;
   private String AV10ConDescrip ;
   private String AV17DSubTipoConDes1 ;
   private String AV24DSubTipoConDes2 ;
   private String AV29ConClasifAux ;
   private String A41ConDescrip ;
   private String A970ConClasifAux ;
   private String A371SubTipoConDes1 ;
   private String A372SubTipoConDes2 ;
   private String[] aP25 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private boolean[] aP5 ;
   private boolean[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private int[] aP12 ;
   private long[] aP13 ;
   private String[] aP14 ;
   private byte[] aP15 ;
   private boolean[] aP16 ;
   private short[] aP17 ;
   private boolean[] aP18 ;
   private String[] aP19 ;
   private boolean[] aP20 ;
   private byte[] aP21 ;
   private String[] aP22 ;
   private byte[] aP23 ;
   private String[] aP24 ;
   private IDataStoreProvider pr_default ;
   private String[] P00RU2_A26ConCodigo ;
   private int[] P00RU2_A3CliCod ;
   private String[] P00RU2_A41ConDescrip ;
   private String[] P00RU2_A37TipoConCod ;
   private String[] P00RU2_A148ConFormula ;
   private boolean[] P00RU2_n148ConFormula ;
   private boolean[] P00RU2_A146ConForEditable ;
   private boolean[] P00RU2_n146ConForEditable ;
   private boolean[] P00RU2_A159ConVariable ;
   private String[] P00RU2_A970ConClasifAux ;
   private boolean[] P00RU2_n970ConClasifAux ;
   private String[] P00RU2_A38SubTipoConCod1 ;
   private boolean[] P00RU2_n38SubTipoConCod1 ;
   private String[] P00RU2_A371SubTipoConDes1 ;
   private int[] P00RU2_A40ConOrden ;
   private long[] P00RU2_A510ConOrdEjec ;
   private String[] P00RU2_A569ConFormulaExpl ;
   private String[] P00RU2_A39SubTipoConCod2 ;
   private boolean[] P00RU2_n39SubTipoConCod2 ;
   private String[] P00RU2_A372SubTipoConDes2 ;
   private byte[] P00RU2_A162ConVigencia ;
   private boolean[] P00RU2_A762ConRecalcular ;
   private short[] P00RU2_A1112AplIIGG ;
   private boolean[] P00RU2_n1112AplIIGG ;
   private String[] P00RU2_A1066ConPreReq ;
   private boolean[] P00RU2_n1066ConPreReq ;
   private boolean[] P00RU2_A1068ConMostrarPos ;
   private byte[] P00RU2_A1077ConAdelDescu ;
   private boolean[] P00RU2_n1077ConAdelDescu ;
   private String[] P00RU2_A953ConCondicion ;
   private boolean[] P00RU2_n953ConCondicion ;
   private byte[] P00RU2_A1488ConLiqBasica ;
   private String[] P00RU2_A1645ConceptoConveCodigo ;
   private boolean[] P00RU2_n1645ConceptoConveCodigo ;
}

final  class getdatosconcepto2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00RU2", "SELECT T1.ConCodigo, T1.CliCod, T1.ConDescrip, T1.TipoConCod, T1.ConFormula, T1.ConForEditable, T1.ConVariable, T1.ConClasifAux, T1.SubTipoConCod1, T2.SubTipoConDes1, T1.ConOrden, T1.ConOrdEjec, T1.ConFormulaExpl, T1.SubTipoConCod2, T3.SubTipoConDes2, T1.ConVigencia, T1.ConRecalcular, T1.AplIIGG, T1.ConPreReq, T1.ConMostrarPos, T1.ConAdelDescu, T1.ConCondicion, T1.ConLiqBasica, T1.ConceptoConveCodigo FROM ((Concepto T1 LEFT JOIN TipoDeConceptoSubtipo1 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1) LEFT JOIN tipo_concepto_subtipo2 T3 ON T3.TipoConCod = T1.TipoConCod AND T3.SubTipoConCod1 = T1.SubTipoConCod1 AND T3.SubTipoConCod2 = T1.SubTipoConCod2) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) ORDER BY T1.CliCod, T1.ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((boolean[]) buf[8])[0] = rslt.getBoolean(7);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getVarchar(10);
               ((int[]) buf[14])[0] = rslt.getInt(11);
               ((long[]) buf[15])[0] = rslt.getLong(12);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(13);
               ((String[]) buf[17])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((String[]) buf[19])[0] = rslt.getVarchar(15);
               ((byte[]) buf[20])[0] = rslt.getByte(16);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(17);
               ((short[]) buf[22])[0] = rslt.getShort(18);
               ((boolean[]) buf[23])[0] = rslt.wasNull();
               ((String[]) buf[24])[0] = rslt.getString(19, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((boolean[]) buf[26])[0] = rslt.getBoolean(20);
               ((byte[]) buf[27])[0] = rslt.getByte(21);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((String[]) buf[29])[0] = rslt.getString(22, 20);
               ((boolean[]) buf[30])[0] = rslt.wasNull();
               ((byte[]) buf[31])[0] = rslt.getByte(23);
               ((String[]) buf[32])[0] = rslt.getString(24, 20);
               ((boolean[]) buf[33])[0] = rslt.wasNull();
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

