package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatosconcepto extends GXProcedure
{
   public getdatosconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatosconcepto.class ), "" );
   }

   public getdatosconcepto( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String[] aP2 ,
                              String[] aP3 ,
                              String[] aP4 ,
                              boolean[] aP5 ,
                              boolean[] aP6 ,
                              java.math.BigDecimal[] aP7 ,
                              String[] aP8 ,
                              String[] aP9 ,
                              String[] aP10 ,
                              String[] aP11 ,
                              int[] aP12 ,
                              long[] aP13 ,
                              String[] aP14 ,
                              byte[] aP15 ,
                              boolean[] aP16 )
   {
      getdatosconcepto.this.aP17 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
      return aP17[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        boolean[] aP5 ,
                        boolean[] aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        int[] aP12 ,
                        long[] aP13 ,
                        String[] aP14 ,
                        byte[] aP15 ,
                        boolean[] aP16 ,
                        boolean[] aP17 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             boolean[] aP5 ,
                             boolean[] aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             int[] aP12 ,
                             long[] aP13 ,
                             String[] aP14 ,
                             byte[] aP15 ,
                             boolean[] aP16 ,
                             boolean[] aP17 )
   {
      getdatosconcepto.this.AV8CliCod = aP0;
      getdatosconcepto.this.AV9ConCodigo = aP1;
      getdatosconcepto.this.aP2 = aP2;
      getdatosconcepto.this.aP3 = aP3;
      getdatosconcepto.this.aP4 = aP4;
      getdatosconcepto.this.aP5 = aP5;
      getdatosconcepto.this.aP6 = aP6;
      getdatosconcepto.this.aP7 = aP7;
      getdatosconcepto.this.aP8 = aP8;
      getdatosconcepto.this.aP9 = aP9;
      getdatosconcepto.this.aP10 = aP10;
      getdatosconcepto.this.aP11 = aP11;
      getdatosconcepto.this.aP12 = aP12;
      getdatosconcepto.this.aP13 = aP13;
      getdatosconcepto.this.aP14 = aP14;
      getdatosconcepto.this.aP15 = aP15;
      getdatosconcepto.this.aP16 = aP16;
      getdatosconcepto.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P003P2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P003P2_A26ConCodigo[0] ;
         A3CliCod = P003P2_A3CliCod[0] ;
         A41ConDescrip = P003P2_A41ConDescrip[0] ;
         A37TipoConCod = P003P2_A37TipoConCod[0] ;
         A148ConFormula = P003P2_A148ConFormula[0] ;
         n148ConFormula = P003P2_n148ConFormula[0] ;
         A146ConForEditable = P003P2_A146ConForEditable[0] ;
         n146ConForEditable = P003P2_n146ConForEditable[0] ;
         A159ConVariable = P003P2_A159ConVariable[0] ;
         A157ConValorGen = P003P2_A157ConValorGen[0] ;
         n157ConValorGen = P003P2_n157ConValorGen[0] ;
         A38SubTipoConCod1 = P003P2_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P003P2_n38SubTipoConCod1[0] ;
         A371SubTipoConDes1 = P003P2_A371SubTipoConDes1[0] ;
         A40ConOrden = P003P2_A40ConOrden[0] ;
         A510ConOrdEjec = P003P2_A510ConOrdEjec[0] ;
         A569ConFormulaExpl = P003P2_A569ConFormulaExpl[0] ;
         A39SubTipoConCod2 = P003P2_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P003P2_n39SubTipoConCod2[0] ;
         A372SubTipoConDes2 = P003P2_A372SubTipoConDes2[0] ;
         A162ConVigencia = P003P2_A162ConVigencia[0] ;
         A1068ConMostrarPos = P003P2_A1068ConMostrarPos[0] ;
         A1821ConErrorSiCero = P003P2_A1821ConErrorSiCero[0] ;
         A371SubTipoConDes1 = P003P2_A371SubTipoConDes1[0] ;
         A372SubTipoConDes2 = P003P2_A372SubTipoConDes2[0] ;
         AV10ConDescrip = A41ConDescrip ;
         AV13TipoConCod = A37TipoConCod ;
         AV12ConFormula = A148ConFormula ;
         AV11ConForEditable = A146ConForEditable ;
         AV14ConVariable = A159ConVariable ;
         AV15ConValorGen = A157ConValorGen ;
         AV16DSubTipoConCod1 = A38SubTipoConCod1 ;
         AV17DSubTipoConDes1 = A371SubTipoConDes1 ;
         AV18ConOrden = A40ConOrden ;
         AV19ConOrdEjec = A510ConOrdEjec ;
         AV21ConFormulaExpl = A569ConFormulaExpl ;
         AV23DSubTipoConCod2 = A39SubTipoConCod2 ;
         AV24DSubTipoConDes2 = A372SubTipoConDes2 ;
         AV25ConVigencia = A162ConVigencia ;
         AV26ConMostrarPos = A1068ConMostrarPos ;
         AV27ConErrorSiCero = A1821ConErrorSiCero ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getdatosconcepto.this.AV10ConDescrip;
      this.aP3[0] = getdatosconcepto.this.AV13TipoConCod;
      this.aP4[0] = getdatosconcepto.this.AV12ConFormula;
      this.aP5[0] = getdatosconcepto.this.AV11ConForEditable;
      this.aP6[0] = getdatosconcepto.this.AV14ConVariable;
      this.aP7[0] = getdatosconcepto.this.AV15ConValorGen;
      this.aP8[0] = getdatosconcepto.this.AV16DSubTipoConCod1;
      this.aP9[0] = getdatosconcepto.this.AV17DSubTipoConDes1;
      this.aP10[0] = getdatosconcepto.this.AV23DSubTipoConCod2;
      this.aP11[0] = getdatosconcepto.this.AV24DSubTipoConDes2;
      this.aP12[0] = getdatosconcepto.this.AV18ConOrden;
      this.aP13[0] = getdatosconcepto.this.AV19ConOrdEjec;
      this.aP14[0] = getdatosconcepto.this.AV21ConFormulaExpl;
      this.aP15[0] = getdatosconcepto.this.AV25ConVigencia;
      this.aP16[0] = getdatosconcepto.this.AV26ConMostrarPos;
      this.aP17[0] = getdatosconcepto.this.AV27ConErrorSiCero;
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
      AV15ConValorGen = DecimalUtil.ZERO ;
      AV16DSubTipoConCod1 = "" ;
      AV17DSubTipoConDes1 = "" ;
      AV23DSubTipoConCod2 = "" ;
      AV24DSubTipoConDes2 = "" ;
      AV21ConFormulaExpl = "" ;
      scmdbuf = "" ;
      P003P2_A26ConCodigo = new String[] {""} ;
      P003P2_A3CliCod = new int[1] ;
      P003P2_A41ConDescrip = new String[] {""} ;
      P003P2_A37TipoConCod = new String[] {""} ;
      P003P2_A148ConFormula = new String[] {""} ;
      P003P2_n148ConFormula = new boolean[] {false} ;
      P003P2_A146ConForEditable = new boolean[] {false} ;
      P003P2_n146ConForEditable = new boolean[] {false} ;
      P003P2_A159ConVariable = new boolean[] {false} ;
      P003P2_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P003P2_n157ConValorGen = new boolean[] {false} ;
      P003P2_A38SubTipoConCod1 = new String[] {""} ;
      P003P2_n38SubTipoConCod1 = new boolean[] {false} ;
      P003P2_A371SubTipoConDes1 = new String[] {""} ;
      P003P2_A40ConOrden = new int[1] ;
      P003P2_A510ConOrdEjec = new long[1] ;
      P003P2_A569ConFormulaExpl = new String[] {""} ;
      P003P2_A39SubTipoConCod2 = new String[] {""} ;
      P003P2_n39SubTipoConCod2 = new boolean[] {false} ;
      P003P2_A372SubTipoConDes2 = new String[] {""} ;
      P003P2_A162ConVigencia = new byte[1] ;
      P003P2_A1068ConMostrarPos = new boolean[] {false} ;
      P003P2_A1821ConErrorSiCero = new boolean[] {false} ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      A37TipoConCod = "" ;
      A148ConFormula = "" ;
      A157ConValorGen = DecimalUtil.ZERO ;
      A38SubTipoConCod1 = "" ;
      A371SubTipoConDes1 = "" ;
      A569ConFormulaExpl = "" ;
      A39SubTipoConCod2 = "" ;
      A372SubTipoConDes2 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatosconcepto__default(),
         new Object[] {
             new Object[] {
            P003P2_A26ConCodigo, P003P2_A3CliCod, P003P2_A41ConDescrip, P003P2_A37TipoConCod, P003P2_A148ConFormula, P003P2_n148ConFormula, P003P2_A146ConForEditable, P003P2_n146ConForEditable, P003P2_A159ConVariable, P003P2_A157ConValorGen,
            P003P2_n157ConValorGen, P003P2_A38SubTipoConCod1, P003P2_n38SubTipoConCod1, P003P2_A371SubTipoConDes1, P003P2_A40ConOrden, P003P2_A510ConOrdEjec, P003P2_A569ConFormulaExpl, P003P2_A39SubTipoConCod2, P003P2_n39SubTipoConCod2, P003P2_A372SubTipoConDes2,
            P003P2_A162ConVigencia, P003P2_A1068ConMostrarPos, P003P2_A1821ConErrorSiCero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV25ConVigencia ;
   private byte A162ConVigencia ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV18ConOrden ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private long AV19ConOrdEjec ;
   private long A510ConOrdEjec ;
   private java.math.BigDecimal AV15ConValorGen ;
   private java.math.BigDecimal A157ConValorGen ;
   private String AV9ConCodigo ;
   private String AV13TipoConCod ;
   private String AV16DSubTipoConCod1 ;
   private String AV23DSubTipoConCod2 ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String A39SubTipoConCod2 ;
   private boolean AV11ConForEditable ;
   private boolean AV14ConVariable ;
   private boolean AV26ConMostrarPos ;
   private boolean AV27ConErrorSiCero ;
   private boolean n148ConFormula ;
   private boolean A146ConForEditable ;
   private boolean n146ConForEditable ;
   private boolean A159ConVariable ;
   private boolean n157ConValorGen ;
   private boolean n38SubTipoConCod1 ;
   private boolean n39SubTipoConCod2 ;
   private boolean A1068ConMostrarPos ;
   private boolean A1821ConErrorSiCero ;
   private String AV12ConFormula ;
   private String AV21ConFormulaExpl ;
   private String A148ConFormula ;
   private String A569ConFormulaExpl ;
   private String AV10ConDescrip ;
   private String AV17DSubTipoConDes1 ;
   private String AV24DSubTipoConDes2 ;
   private String A41ConDescrip ;
   private String A371SubTipoConDes1 ;
   private String A372SubTipoConDes2 ;
   private boolean[] aP17 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private boolean[] aP5 ;
   private boolean[] aP6 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private int[] aP12 ;
   private long[] aP13 ;
   private String[] aP14 ;
   private byte[] aP15 ;
   private boolean[] aP16 ;
   private IDataStoreProvider pr_default ;
   private String[] P003P2_A26ConCodigo ;
   private int[] P003P2_A3CliCod ;
   private String[] P003P2_A41ConDescrip ;
   private String[] P003P2_A37TipoConCod ;
   private String[] P003P2_A148ConFormula ;
   private boolean[] P003P2_n148ConFormula ;
   private boolean[] P003P2_A146ConForEditable ;
   private boolean[] P003P2_n146ConForEditable ;
   private boolean[] P003P2_A159ConVariable ;
   private java.math.BigDecimal[] P003P2_A157ConValorGen ;
   private boolean[] P003P2_n157ConValorGen ;
   private String[] P003P2_A38SubTipoConCod1 ;
   private boolean[] P003P2_n38SubTipoConCod1 ;
   private String[] P003P2_A371SubTipoConDes1 ;
   private int[] P003P2_A40ConOrden ;
   private long[] P003P2_A510ConOrdEjec ;
   private String[] P003P2_A569ConFormulaExpl ;
   private String[] P003P2_A39SubTipoConCod2 ;
   private boolean[] P003P2_n39SubTipoConCod2 ;
   private String[] P003P2_A372SubTipoConDes2 ;
   private byte[] P003P2_A162ConVigencia ;
   private boolean[] P003P2_A1068ConMostrarPos ;
   private boolean[] P003P2_A1821ConErrorSiCero ;
}

final  class getdatosconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P003P2", "SELECT T1.ConCodigo, T1.CliCod, T1.ConDescrip, T1.TipoConCod, T1.ConFormula, T1.ConForEditable, T1.ConVariable, T1.ConValorGen, T1.SubTipoConCod1, T2.SubTipoConDes1, T1.ConOrden, T1.ConOrdEjec, T1.ConFormulaExpl, T1.SubTipoConCod2, T3.SubTipoConDes2, T1.ConVigencia, T1.ConMostrarPos, T1.ConErrorSiCero FROM ((Concepto T1 LEFT JOIN TipoDeConceptoSubtipo1 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1) LEFT JOIN tipo_concepto_subtipo2 T3 ON T3.TipoConCod = T1.TipoConCod AND T3.SubTipoConCod1 = T1.SubTipoConCod1 AND T3.SubTipoConCod2 = T1.SubTipoConCod2) WHERE T1.CliCod = ? and T1.ConCodigo = ( ?) ORDER BY T1.CliCod, T1.ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
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
               ((boolean[]) buf[22])[0] = rslt.getBoolean(18);
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

