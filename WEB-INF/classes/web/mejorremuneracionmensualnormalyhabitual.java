package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mejorremuneracionmensualnormalyhabitual extends GXProcedure
{
   public mejorremuneracionmensualnormalyhabitual( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mejorremuneracionmensualnormalyhabitual.class ), "" );
   }

   public mejorremuneracionmensualnormalyhabitual( int remoteHandle ,
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
                             java.math.BigDecimal[] aP5 )
   {
      mejorremuneracionmensualnormalyhabitual.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 )
   {
      mejorremuneracionmensualnormalyhabitual.this.AV18CliCod = aP0;
      mejorremuneracionmensualnormalyhabitual.this.AV9EmpCod = aP1;
      mejorremuneracionmensualnormalyhabitual.this.AV26LiqRelNro = aP2;
      mejorremuneracionmensualnormalyhabitual.this.AV19LegNumero = aP3;
      mejorremuneracionmensualnormalyhabitual.this.AV10LiqPeriodo = aP4;
      mejorremuneracionmensualnormalyhabitual.this.aP5 = aP5;
      mejorremuneracionmensualnormalyhabitual.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8unAnioAtrasFecha = GXutil.addmth( AV10LiqPeriodo, (short)(-12)) ;
      AV24anterior_LiqPeriodo = GXutil.addmth( AV10LiqPeriodo, (short)(-1)) ;
      GXv_objcol_char1[0] = AV15conceptosHabituales ;
      new web.devuelveconceptosporhabitualidad(remoteHandle, context).execute( AV18CliCod, AV9EmpCod, AV19LegNumero, AV8unAnioAtrasFecha, AV24anterior_LiqPeriodo, httpContext.getMessage( "HABITUALES", ""), GXv_objcol_char1) ;
      AV15conceptosHabituales = GXv_objcol_char1[0] ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A394DConCodigo ,
                                           AV15conceptosHabituales ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(AV26LiqRelNro) ,
                                           Integer.valueOf(AV18CliCod) ,
                                           Short.valueOf(AV9EmpCod) ,
                                           Integer.valueOf(AV19LegNumero) ,
                                           AV8unAnioAtrasFecha ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A397DLiqPeriodo ,
                                           AV10LiqPeriodo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE
                                           }
      });
      /* Using cursor P00XG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV19LegNumero), AV8unAnioAtrasFecha, Integer.valueOf(AV26LiqRelNro), AV10LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkXG2 = false ;
         A31LiqNro = P00XG2_A31LiqNro[0] ;
         A3CliCod = P00XG2_A3CliCod[0] ;
         A1EmpCod = P00XG2_A1EmpCod[0] ;
         A6LegNumero = P00XG2_A6LegNumero[0] ;
         A764LiqDImpReCalcu = P00XG2_A764LiqDImpReCalcu[0] ;
         A397DLiqPeriodo = P00XG2_A397DLiqPeriodo[0] ;
         A2112LiqRelNro = P00XG2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00XG2_n2112LiqRelNro[0] ;
         A394DConCodigo = P00XG2_A394DConCodigo[0] ;
         A81LiqDSecuencial = P00XG2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P00XG2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00XG2_n2112LiqRelNro[0] ;
         AV13LiqDImpCalcu = DecimalUtil.ZERO ;
         while ( (pr_default.getStatus(0) != 101) && ( P00XG2_A3CliCod[0] == A3CliCod ) && ( P00XG2_A1EmpCod[0] == A1EmpCod ) && ( P00XG2_A6LegNumero[0] == A6LegNumero ) && GXutil.dateCompare(GXutil.resetTime(P00XG2_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) )
         {
            brkXG2 = false ;
            A31LiqNro = P00XG2_A31LiqNro[0] ;
            A764LiqDImpReCalcu = P00XG2_A764LiqDImpReCalcu[0] ;
            A81LiqDSecuencial = P00XG2_A81LiqDSecuencial[0] ;
            AV13LiqDImpCalcu = AV13LiqDImpCalcu.add(A764LiqDImpReCalcu) ;
            brkXG2 = true ;
            pr_default.readNext(0);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "dliqperiodo ", "")+GXutil.trim( localUtil.dtoc( A397DLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV13LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &maximo_LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV14maximo_LiqDImpCalcu, 14, 2))) ;
         if ( DecimalUtil.compareTo(AV13LiqDImpCalcu, AV14maximo_LiqDImpCalcu) > 0 )
         {
            AV14maximo_LiqDImpCalcu = AV13LiqDImpCalcu ;
            AV25LiqDLog = httpContext.getMessage( "Valor de mejor remuneración mensual normal y habitual ", "") + GXutil.trim( GXutil.str( AV14maximo_LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( localUtil.cmonth( A397DLiqPeriodo, httpContext.getLanguage( ))) ;
         }
         new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
         if ( ! brkXG2 )
         {
            brkXG2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      new web.pendientescrearindices(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = mejorremuneracionmensualnormalyhabitual.this.AV14maximo_LiqDImpCalcu;
      this.aP6[0] = mejorremuneracionmensualnormalyhabitual.this.AV25LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14maximo_LiqDImpCalcu = DecimalUtil.ZERO ;
      AV25LiqDLog = "" ;
      AV8unAnioAtrasFecha = GXutil.nullDate() ;
      AV24anterior_LiqPeriodo = GXutil.nullDate() ;
      AV15conceptosHabituales = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char1 = new GXSimpleCollection[1] ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      P00XG2_A31LiqNro = new int[1] ;
      P00XG2_A3CliCod = new int[1] ;
      P00XG2_A1EmpCod = new short[1] ;
      P00XG2_A6LegNumero = new int[1] ;
      P00XG2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00XG2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00XG2_A2112LiqRelNro = new int[1] ;
      P00XG2_n2112LiqRelNro = new boolean[] {false} ;
      P00XG2_A394DConCodigo = new String[] {""} ;
      P00XG2_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV13LiqDImpCalcu = DecimalUtil.ZERO ;
      AV31Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.mejorremuneracionmensualnormalyhabitual__default(),
         new Object[] {
             new Object[] {
            P00XG2_A31LiqNro, P00XG2_A3CliCod, P00XG2_A1EmpCod, P00XG2_A6LegNumero, P00XG2_A764LiqDImpReCalcu, P00XG2_A397DLiqPeriodo, P00XG2_A2112LiqRelNro, P00XG2_n2112LiqRelNro, P00XG2_A394DConCodigo, P00XG2_A81LiqDSecuencial
            }
         }
      );
      AV31Pgmname = "mejorRemuneracionMensualNormalYHabitual" ;
      /* GeneXus formulas. */
      AV31Pgmname = "mejorRemuneracionMensualNormalYHabitual" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV26LiqRelNro ;
   private int AV19LegNumero ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV14maximo_LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV13LiqDImpCalcu ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV31Pgmname ;
   private java.util.Date AV10LiqPeriodo ;
   private java.util.Date AV8unAnioAtrasFecha ;
   private java.util.Date AV24anterior_LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean brkXG2 ;
   private boolean n2112LiqRelNro ;
   private String AV25LiqDLog ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P00XG2_A31LiqNro ;
   private int[] P00XG2_A3CliCod ;
   private short[] P00XG2_A1EmpCod ;
   private int[] P00XG2_A6LegNumero ;
   private java.math.BigDecimal[] P00XG2_A764LiqDImpReCalcu ;
   private java.util.Date[] P00XG2_A397DLiqPeriodo ;
   private int[] P00XG2_A2112LiqRelNro ;
   private boolean[] P00XG2_n2112LiqRelNro ;
   private String[] P00XG2_A394DConCodigo ;
   private int[] P00XG2_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV15conceptosHabituales ;
   private GXSimpleCollection<String> GXv_objcol_char1[] ;
}

final  class mejorremuneracionmensualnormalyhabitual__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00XG2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV15conceptosHabituales ,
                                          int A2112LiqRelNro ,
                                          int AV26LiqRelNro ,
                                          int AV18CliCod ,
                                          short AV9EmpCod ,
                                          int AV19LegNumero ,
                                          java.util.Date AV8unAnioAtrasFecha ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date A397DLiqPeriodo ,
                                          java.util.Date AV10LiqPeriodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[6];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT T1.LiqNro, T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqDImpReCalcu, T1.DLiqPeriodo, T2.LiqRelNro, T1.DConCodigo, T1.LiqDSecuencial FROM (LiquidacionDetalle" ;
      scmdbuf += " T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DLiqPeriodo >= ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV15conceptosHabituales, "T1.DConCodigo IN (", ")")+")");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL or T2.LiqRelNro = ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo < ?)");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DLiqPeriodo" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
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
                  return conditional_P00XG2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , (java.util.Date)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , (java.util.Date)dynConstraints[11] , (java.util.Date)dynConstraints[12] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00XG2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(8, 10);
               ((int[]) buf[9])[0] = rslt.getInt(9);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               return;
      }
   }

}

