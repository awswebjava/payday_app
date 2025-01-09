package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class horasextrasexentas extends GXProcedure
{
   public horasextrasexentas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( horasextrasexentas.class ), "" );
   }

   public horasextrasexentas( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 )
   {
      horasextrasexentas.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        byte[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      horasextrasexentas.this.AV18CliCod = aP0;
      horasextrasexentas.this.AV21EmpCod = aP1;
      horasextrasexentas.this.AV30LiqNro = aP2;
      horasextrasexentas.this.AV53LiqRelNro = aP3;
      horasextrasexentas.this.AV27LegNumero = aP4;
      horasextrasexentas.this.AV37ConCodigo = aP5;
      horasextrasexentas.this.AV39fecha = aP6;
      horasextrasexentas.this.AV35ProcesoLiquidacion = aP7;
      horasextrasexentas.this.AV43insertandoConceptos = aP8;
      horasextrasexentas.this.aP9 = aP9;
      horasextrasexentas.this.aP10 = aP10;
      horasextrasexentas.this.aP11 = aP11;
      horasextrasexentas.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV28LiqDCalculado = (byte)(1) ;
      if ( (0==AV30LiqNro) )
      {
         AV40comienzoFecha = localUtil.ymdtod( GXutil.year( AV39fecha), 1, 1) ;
      }
      else
      {
         AV40comienzoFecha = AV39fecha ;
      }
      GXt_int1 = AV50horasExtrasAplIIGG ;
      GXv_int2[0] = GXt_int1 ;
      new web.getapliigg_horasextras(remoteHandle, context).execute( AV18CliCod, GXv_int2) ;
      horasextrasexentas.this.GXt_int1 = GXv_int2[0] ;
      AV50horasExtrasAplIIGG = GXt_int1 ;
      AV56GXLvl15 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV30LiqNro) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A397DLiqPeriodo ,
                                           AV39fecha ,
                                           AV40comienzoFecha ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(AV53LiqRelNro) ,
                                           Short.valueOf(A1122DAplIIGG) ,
                                           Short.valueOf(AV50horasExtrasAplIIGG) ,
                                           Integer.valueOf(AV18CliCod) ,
                                           Short.valueOf(AV21EmpCod) ,
                                           Integer.valueOf(AV27LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.BOOLEAN,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P00QU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV21EmpCod), Integer.valueOf(AV27LegNumero), AV39fecha, AV40comienzoFecha, Integer.valueOf(AV53LiqRelNro), Short.valueOf(AV50horasExtrasAplIIGG), Integer.valueOf(AV30LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P00QU2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00QU2_n2112LiqRelNro[0] ;
         A397DLiqPeriodo = P00QU2_A397DLiqPeriodo[0] ;
         A1122DAplIIGG = P00QU2_A1122DAplIIGG[0] ;
         n1122DAplIIGG = P00QU2_n1122DAplIIGG[0] ;
         A31LiqNro = P00QU2_A31LiqNro[0] ;
         A6LegNumero = P00QU2_A6LegNumero[0] ;
         A1EmpCod = P00QU2_A1EmpCod[0] ;
         A3CliCod = P00QU2_A3CliCod[0] ;
         A732DSubTipoConCod2 = P00QU2_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P00QU2_n732DSubTipoConCod2[0] ;
         A394DConCodigo = P00QU2_A394DConCodigo[0] ;
         A507LiqDCalculado = P00QU2_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P00QU2_A763LiqDRecalculado[0] ;
         A504LiqDForOrig = P00QU2_A504LiqDForOrig[0] ;
         A764LiqDImpReCalcu = P00QU2_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P00QU2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P00QU2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00QU2_n2112LiqRelNro[0] ;
         AV56GXLvl15 = (byte)(1) ;
         if ( ( GXutil.strcmp(A732DSubTipoConCod2, new web.conceptoafiphorasextras100(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(A732DSubTipoConCod2, new web.conceptoafiphorasextras200(remoteHandle, context).executeUdp( )) == 0 ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
            GXv_int3[0] = AV28LiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV18CliCod, A394DConCodigo, AV35ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int3) ;
            horasextrasexentas.this.AV28LiqDCalculado = GXv_int3[0] ;
            if ( AV28LiqDCalculado == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV51error = httpContext.getMessage( "Falta calcular concepto ", "") + A394DConCodigo ;
               AV52LiqDLog += ". " + GXutil.trim( AV51error) ;
               pr_default.close(0);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV31multis_char = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(A504LiqDForOrig,"*")) ;
            AV23extra = (short)(2) ;
            AV25i = (short)(1) ;
            while ( AV25i <= AV31multis_char.size() )
            {
               if ( new web.esnumero(remoteHandle, context).executeUdp( (String)AV31multis_char.elementAt(-1+AV25i)) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV23extra = (short)(GXutil.lval( (String)AV31multis_char.elementAt(-1+AV25i))) ;
                  if (true) break;
               }
               AV25i = (short)(AV25i+1) ;
            }
            AV29LiqDImpCalcu = A764LiqDImpReCalcu.divide(DecimalUtil.doubleToDec(AV23extra), 18, java.math.RoundingMode.DOWN) ;
            AV52LiqDLog += GXutil.trim( GXutil.str( AV29LiqDImpCalcu, 14, 2)) + " (" + GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV23extra, 4, 0)) + httpContext.getMessage( ") de concepto ", "") + GXutil.trim( A394DConCodigo) + ", " ;
            AV26importe = AV26importe.add(AV29LiqDImpCalcu) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV56GXLvl15 == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = horasextrasexentas.this.AV26importe;
      this.aP10[0] = horasextrasexentas.this.AV28LiqDCalculado;
      this.aP11[0] = horasextrasexentas.this.AV51error;
      this.aP12[0] = horasextrasexentas.this.AV52LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26importe = DecimalUtil.ZERO ;
      AV51error = "" ;
      AV52LiqDLog = "" ;
      AV40comienzoFecha = GXutil.nullDate() ;
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      P00QU2_A2112LiqRelNro = new int[1] ;
      P00QU2_n2112LiqRelNro = new boolean[] {false} ;
      P00QU2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00QU2_A1122DAplIIGG = new short[1] ;
      P00QU2_n1122DAplIIGG = new boolean[] {false} ;
      P00QU2_A31LiqNro = new int[1] ;
      P00QU2_A6LegNumero = new int[1] ;
      P00QU2_A1EmpCod = new short[1] ;
      P00QU2_A3CliCod = new int[1] ;
      P00QU2_A732DSubTipoConCod2 = new String[] {""} ;
      P00QU2_n732DSubTipoConCod2 = new boolean[] {false} ;
      P00QU2_A394DConCodigo = new String[] {""} ;
      P00QU2_A507LiqDCalculado = new byte[1] ;
      P00QU2_A763LiqDRecalculado = new short[1] ;
      P00QU2_A504LiqDForOrig = new String[] {""} ;
      P00QU2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00QU2_A81LiqDSecuencial = new int[1] ;
      A732DSubTipoConCod2 = "" ;
      A394DConCodigo = "" ;
      A504LiqDForOrig = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      AV31multis_char = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29LiqDImpCalcu = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.horasextrasexentas__default(),
         new Object[] {
             new Object[] {
            P00QU2_A2112LiqRelNro, P00QU2_n2112LiqRelNro, P00QU2_A397DLiqPeriodo, P00QU2_A1122DAplIIGG, P00QU2_n1122DAplIIGG, P00QU2_A31LiqNro, P00QU2_A6LegNumero, P00QU2_A1EmpCod, P00QU2_A3CliCod, P00QU2_A732DSubTipoConCod2,
            P00QU2_n732DSubTipoConCod2, P00QU2_A394DConCodigo, P00QU2_A507LiqDCalculado, P00QU2_A763LiqDRecalculado, P00QU2_A504LiqDForOrig, P00QU2_A764LiqDImpReCalcu, P00QU2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV28LiqDCalculado ;
   private byte AV56GXLvl15 ;
   private byte A507LiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV21EmpCod ;
   private short AV50horasExtrasAplIIGG ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1122DAplIIGG ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV23extra ;
   private short AV25i ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV30LiqNro ;
   private int AV53LiqRelNro ;
   private int AV27LegNumero ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV26importe ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV29LiqDImpCalcu ;
   private String AV37ConCodigo ;
   private String AV35ProcesoLiquidacion ;
   private String scmdbuf ;
   private String A732DSubTipoConCod2 ;
   private String A394DConCodigo ;
   private java.util.Date AV39fecha ;
   private java.util.Date AV40comienzoFecha ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV43insertandoConceptos ;
   private boolean n2112LiqRelNro ;
   private boolean n1122DAplIIGG ;
   private boolean n732DSubTipoConCod2 ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private String AV52LiqDLog ;
   private String A504LiqDForOrig ;
   private String AV51error ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP9 ;
   private byte[] aP10 ;
   private String[] aP11 ;
   private IDataStoreProvider pr_default ;
   private int[] P00QU2_A2112LiqRelNro ;
   private boolean[] P00QU2_n2112LiqRelNro ;
   private java.util.Date[] P00QU2_A397DLiqPeriodo ;
   private short[] P00QU2_A1122DAplIIGG ;
   private boolean[] P00QU2_n1122DAplIIGG ;
   private int[] P00QU2_A31LiqNro ;
   private int[] P00QU2_A6LegNumero ;
   private short[] P00QU2_A1EmpCod ;
   private int[] P00QU2_A3CliCod ;
   private String[] P00QU2_A732DSubTipoConCod2 ;
   private boolean[] P00QU2_n732DSubTipoConCod2 ;
   private String[] P00QU2_A394DConCodigo ;
   private byte[] P00QU2_A507LiqDCalculado ;
   private short[] P00QU2_A763LiqDRecalculado ;
   private String[] P00QU2_A504LiqDForOrig ;
   private java.math.BigDecimal[] P00QU2_A764LiqDImpReCalcu ;
   private int[] P00QU2_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV31multis_char ;
}

final  class horasextrasexentas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00QU2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV30LiqNro ,
                                          int A31LiqNro ,
                                          java.util.Date A397DLiqPeriodo ,
                                          java.util.Date AV39fecha ,
                                          java.util.Date AV40comienzoFecha ,
                                          int A2112LiqRelNro ,
                                          int AV53LiqRelNro ,
                                          short A1122DAplIIGG ,
                                          short AV50horasExtrasAplIIGG ,
                                          int AV18CliCod ,
                                          short AV21EmpCod ,
                                          int AV27LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.LiqRelNro, T1.DLiqPeriodo, T1.DAplIIGG, T1.LiqNro, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.DSubTipoConCod2, T1.DConCodigo, T1.LiqDCalculado, T1.LiqDRecalculado," ;
      scmdbuf += " T1.LiqDForOrig, T1.LiqDImpReCalcu, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND" ;
      scmdbuf += " T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo <= ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo >= ?)");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL or T2.LiqRelNro = ?)");
      addWhere(sWhereString, "(T1.DAplIIGG = ?)");
      if ( ! (0==AV30LiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro = ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P00QU2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00QU2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               ((String[]) buf[9])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 10);
               ((byte[]) buf[12])[0] = rslt.getByte(10);
               ((short[]) buf[13])[0] = rslt.getShort(11);
               ((String[]) buf[14])[0] = rslt.getLongVarchar(12);
               ((java.math.BigDecimal[]) buf[15])[0] = rslt.getBigDecimal(13,2);
               ((int[]) buf[16])[0] = rslt.getInt(14);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               return;
      }
   }

}

