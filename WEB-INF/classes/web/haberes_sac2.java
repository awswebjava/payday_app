package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class haberes_sac2 extends GXProcedure
{
   public haberes_sac2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( haberes_sac2.class ), "" );
   }

   public haberes_sac2( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             byte[] aP8 ,
                             String[] aP9 )
   {
      haberes_sac2.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        byte[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             byte[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      haberes_sac2.this.AV10CliCod = aP0;
      haberes_sac2.this.AV11EmpCod = aP1;
      haberes_sac2.this.AV14LiqNro = aP2;
      haberes_sac2.this.AV13LegNumero = aP3;
      haberes_sac2.this.AV12LiqPeriodo = aP4;
      haberes_sac2.this.AV45ProcesoLiquidacion = aP5;
      haberes_sac2.this.AV46insertandoConceptos = aP6;
      haberes_sac2.this.aP7 = aP7;
      haberes_sac2.this.aP8 = aP8;
      haberes_sac2.this.aP9 = aP9;
      haberes_sac2.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15Importe = DecimalUtil.ZERO ;
      new web.msgdebug7(remoteHandle, context).execute( AV57Pgmname, httpContext.getMessage( "&EmpCod ", "")+GXutil.trim( GXutil.str( AV11EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV14LiqNro, 8, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV13LegNumero, 8, 0))+httpContext.getMessage( " clicod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))) ;
      AV9LiqDCalculado = (byte)(1) ;
      GXv_objcol_char1[0] = AV53excluirConCodigo ;
      new web.sac_conceptos_excluidos(remoteHandle, context).execute( AV10CliCod, true, true, GXv_objcol_char1) ;
      AV53excluirConCodigo = GXv_objcol_char1[0] ;
      AV18LiqDLog = "" ;
      AV39recorridosConCodigo.clear();
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A394DConCodigo ,
                                           AV53excluirConCodigo ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV11EmpCod) ,
                                           Integer.valueOf(AV14LiqNro) ,
                                           Integer.valueOf(AV13LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A464DTipoConCod } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      /* Using cursor P01A82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV14LiqNro), Integer.valueOf(AV13LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A394DConCodigo = P01A82_A394DConCodigo[0] ;
         A464DTipoConCod = P01A82_A464DTipoConCod[0] ;
         A6LegNumero = P01A82_A6LegNumero[0] ;
         A31LiqNro = P01A82_A31LiqNro[0] ;
         A1EmpCod = P01A82_A1EmpCod[0] ;
         A3CliCod = P01A82_A3CliCod[0] ;
         A507LiqDCalculado = P01A82_A507LiqDCalculado[0] ;
         A764LiqDImpReCalcu = P01A82_A764LiqDImpReCalcu[0] ;
         A1078LiqDAdelDescu = P01A82_A1078LiqDAdelDescu[0] ;
         n1078LiqDAdelDescu = P01A82_n1078LiqDAdelDescu[0] ;
         A468DSubTipoConCod1 = P01A82_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01A82_n468DSubTipoConCod1[0] ;
         A763LiqDRecalculado = P01A82_A763LiqDRecalculado[0] ;
         A81LiqDSecuencial = P01A82_A81LiqDSecuencial[0] ;
         AV39recorridosConCodigo.add(A394DConCodigo, 0);
         new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, httpContext.getMessage( "recorre concepto ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " LiqDCalculado ", "")+GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV9LiqDCalculado, 1, 0))+httpContext.getMessage( " importe ", "")+GXutil.trim( GXutil.str( AV15Importe, 14, 2))) ;
         AV17aplica = true ;
         AV22i2 = (short)(AV22i2+1) ;
         AV16LiqDImpCalcu = DecimalUtil.ZERO ;
         if ( (0==A1078LiqDAdelDescu) )
         {
            AV16LiqDImpCalcu = A764LiqDImpReCalcu ;
         }
         else
         {
            if ( A1078LiqDAdelDescu == 2 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, "1") ;
               GXv_char2[0] = AV54ConCondCodigo ;
               new web.getcondicioncodigo(remoteHandle, context).execute( AV10CliCod, A394DConCodigo, GXv_char2) ;
               haberes_sac2.this.AV54ConCondCodigo = GXv_char2[0] ;
               GXv_decimal3[0] = AV52adelantoMexProxLiqDImpCalcu ;
               GXv_decimal4[0] = DecimalUtil.doubleToDec(0) ;
               GXv_char2[0] = "" ;
               GXv_int5[0] = (byte)(0) ;
               GXv_char6[0] = "" ;
               GXv_int7[0] = 0 ;
               GXv_char8[0] = "" ;
               new web.getadelantoanterior(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV13LegNumero, AV12LiqPeriodo, AV14LiqNro, A468DSubTipoConCod1, "", true, AV54ConCondCodigo, GXv_decimal3, GXv_decimal4, GXv_char2, GXv_int5, GXv_char6, GXv_int7, GXv_char8) ;
               haberes_sac2.this.AV52adelantoMexProxLiqDImpCalcu = GXv_decimal3[0] ;
               if ( AV52adelantoMexProxLiqDImpCalcu.doubleValue() == 0 )
               {
                  AV16LiqDImpCalcu = A764LiqDImpReCalcu ;
               }
            }
         }
         AV18LiqDLog += " + " + GXutil.trim( GXutil.str( AV16LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A394DConCodigo) ;
         AV15Importe = AV15Importe.add(AV16LiqDImpCalcu) ;
         AV20i = (short)(AV20i+1) ;
         GXv_int5[0] = AV9LiqDCalculado ;
         new web.dependenciaresuelta2(remoteHandle, context).execute( AV10CliCod, A394DConCodigo, AV45ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int5) ;
         haberes_sac2.this.AV9LiqDCalculado = GXv_int5[0] ;
         new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
         if ( AV9LiqDCalculado == 0 )
         {
            AV32error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A394DConCodigo) + httpContext.getMessage( " LiqDCalculado ", "") + GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0)) + httpContext.getMessage( " &ProcesoLiquidacion ", "") + GXutil.trim( AV45ProcesoLiquidacion) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, AV32error) ;
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = haberes_sac2.this.AV15Importe;
      this.aP8[0] = haberes_sac2.this.AV9LiqDCalculado;
      this.aP9[0] = haberes_sac2.this.AV18LiqDLog;
      this.aP10[0] = haberes_sac2.this.AV32error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Importe = DecimalUtil.ZERO ;
      AV18LiqDLog = "" ;
      AV32error = "" ;
      AV57Pgmname = "" ;
      AV53excluirConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char1 = new GXSimpleCollection[1] ;
      AV39recorridosConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      P01A82_A394DConCodigo = new String[] {""} ;
      P01A82_A464DTipoConCod = new String[] {""} ;
      P01A82_A6LegNumero = new int[1] ;
      P01A82_A31LiqNro = new int[1] ;
      P01A82_A1EmpCod = new short[1] ;
      P01A82_A3CliCod = new int[1] ;
      P01A82_A507LiqDCalculado = new byte[1] ;
      P01A82_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01A82_A1078LiqDAdelDescu = new byte[1] ;
      P01A82_n1078LiqDAdelDescu = new boolean[] {false} ;
      P01A82_A468DSubTipoConCod1 = new String[] {""} ;
      P01A82_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01A82_A763LiqDRecalculado = new short[1] ;
      P01A82_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A468DSubTipoConCod1 = "" ;
      AV16LiqDImpCalcu = DecimalUtil.ZERO ;
      AV54ConCondCodigo = "" ;
      AV52adelantoMexProxLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_char2 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_int7 = new int[1] ;
      GXv_char8 = new String[1] ;
      GXv_int5 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.haberes_sac2__default(),
         new Object[] {
             new Object[] {
            P01A82_A394DConCodigo, P01A82_A464DTipoConCod, P01A82_A6LegNumero, P01A82_A31LiqNro, P01A82_A1EmpCod, P01A82_A3CliCod, P01A82_A507LiqDCalculado, P01A82_A764LiqDImpReCalcu, P01A82_A1078LiqDAdelDescu, P01A82_n1078LiqDAdelDescu,
            P01A82_A468DSubTipoConCod1, P01A82_n468DSubTipoConCod1, P01A82_A763LiqDRecalculado, P01A82_A81LiqDSecuencial
            }
         }
      );
      AV57Pgmname = "haberes_sac2" ;
      /* GeneXus formulas. */
      AV57Pgmname = "haberes_sac2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV9LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private byte A1078LiqDAdelDescu ;
   private byte GXv_int5[] ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV22i2 ;
   private short AV20i ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV14LiqNro ;
   private int AV13LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private int GXv_int7[] ;
   private java.math.BigDecimal AV15Importe ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV16LiqDImpCalcu ;
   private java.math.BigDecimal AV52adelantoMexProxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV45ProcesoLiquidacion ;
   private String AV57Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A468DSubTipoConCod1 ;
   private String AV54ConCondCodigo ;
   private String GXv_char2[] ;
   private String GXv_char6[] ;
   private String GXv_char8[] ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean AV46insertandoConceptos ;
   private boolean n1078LiqDAdelDescu ;
   private boolean n468DSubTipoConCod1 ;
   private boolean AV17aplica ;
   private boolean returnInSub ;
   private String AV18LiqDLog ;
   private String AV32error ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private byte[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01A82_A394DConCodigo ;
   private String[] P01A82_A464DTipoConCod ;
   private int[] P01A82_A6LegNumero ;
   private int[] P01A82_A31LiqNro ;
   private short[] P01A82_A1EmpCod ;
   private int[] P01A82_A3CliCod ;
   private byte[] P01A82_A507LiqDCalculado ;
   private java.math.BigDecimal[] P01A82_A764LiqDImpReCalcu ;
   private byte[] P01A82_A1078LiqDAdelDescu ;
   private boolean[] P01A82_n1078LiqDAdelDescu ;
   private String[] P01A82_A468DSubTipoConCod1 ;
   private boolean[] P01A82_n468DSubTipoConCod1 ;
   private short[] P01A82_A763LiqDRecalculado ;
   private int[] P01A82_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV53excluirConCodigo ;
   private GXSimpleCollection<String> GXv_objcol_char1[] ;
   private GXSimpleCollection<String> AV39recorridosConCodigo ;
}

final  class haberes_sac2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01A82( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV53excluirConCodigo ,
                                          int AV10CliCod ,
                                          short AV11EmpCod ,
                                          int AV14LiqNro ,
                                          int AV13LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero ,
                                          String A464DTipoConCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[4];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT DConCodigo, DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDCalculado, LiqDImpReCalcu, LiqDAdelDescu, DSubTipoConCod1, LiqDRecalculado, LiqDSecuencial" ;
      scmdbuf += " FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( 'REM_ARG'))");
      addWhere(sWhereString, "(Not "+GXutil.toValueList("postgresql", AV53excluirConCodigo, "DConCodigo IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01A82(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01A82", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((int[]) buf[13])[0] = rslt.getInt(12);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
      }
   }

}

