package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarliqdupliporimporte extends GXProcedure
{
   public validarliqdupliporimporte( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarliqdupliporimporte.class ), "" );
   }

   public validarliqdupliporimporte( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          java.math.BigDecimal aP2 ,
                          int aP3 ,
                          int aP4 ,
                          java.util.Date aP5 ,
                          boolean aP6 ,
                          boolean[] aP7 )
   {
      validarliqdupliporimporte.this.aP8 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.math.BigDecimal aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        boolean aP6 ,
                        boolean[] aP7 ,
                        int[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.math.BigDecimal aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             boolean aP6 ,
                             boolean[] aP7 ,
                             int[] aP8 )
   {
      validarliqdupliporimporte.this.AV8clicod = aP0;
      validarliqdupliporimporte.this.AV9empcod = aP1;
      validarliqdupliporimporte.this.AV10LiqLegImpTotal = aP2;
      validarliqdupliporimporte.this.AV11LiqNro = aP3;
      validarliqdupliporimporte.this.AV12LegNumero = aP4;
      validarliqdupliporimporte.this.AV13LiqPeriodo = aP5;
      validarliqdupliporimporte.this.AV16soloImp = aP6;
      validarliqdupliporimporte.this.aP7 = aP7;
      validarliqdupliporimporte.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Boolean.valueOf(AV16soloImp) ,
                                           A719LiqFecImp ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV11LiqNro) ,
                                           A281LiqLegImpTotal ,
                                           AV10LiqLegImpTotal ,
                                           Integer.valueOf(AV8clicod) ,
                                           Short.valueOf(AV9empcod) ,
                                           Integer.valueOf(AV12LegNumero) ,
                                           AV13LiqPeriodo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A283LiqPeriodo } ,
                                           new int[]{
                                           TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE
                                           }
      });
      /* Using cursor P02CV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9empcod), Integer.valueOf(AV12LegNumero), AV13LiqPeriodo, Integer.valueOf(AV11LiqNro), AV10LiqLegImpTotal});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A283LiqPeriodo = P02CV2_A283LiqPeriodo[0] ;
         A6LegNumero = P02CV2_A6LegNumero[0] ;
         A31LiqNro = P02CV2_A31LiqNro[0] ;
         A281LiqLegImpTotal = P02CV2_A281LiqLegImpTotal[0] ;
         A719LiqFecImp = P02CV2_A719LiqFecImp[0] ;
         A1EmpCod = P02CV2_A1EmpCod[0] ;
         A3CliCod = P02CV2_A3CliCod[0] ;
         A719LiqFecImp = P02CV2_A719LiqFecImp[0] ;
         AV14duplicaEs = true ;
         AV15AuxLiqNro = A31LiqNro ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = validarliqdupliporimporte.this.AV14duplicaEs;
      this.aP8[0] = validarliqdupliporimporte.this.AV15AuxLiqNro;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A283LiqPeriodo = GXutil.nullDate() ;
      P02CV2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02CV2_A6LegNumero = new int[1] ;
      P02CV2_A31LiqNro = new int[1] ;
      P02CV2_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02CV2_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      P02CV2_A1EmpCod = new short[1] ;
      P02CV2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validarliqdupliporimporte__default(),
         new Object[] {
             new Object[] {
            P02CV2_A283LiqPeriodo, P02CV2_A6LegNumero, P02CV2_A31LiqNro, P02CV2_A281LiqLegImpTotal, P02CV2_A719LiqFecImp, P02CV2_A1EmpCod, P02CV2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8clicod ;
   private int AV11LiqNro ;
   private int AV12LegNumero ;
   private int AV15AuxLiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV10LiqLegImpTotal ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private String scmdbuf ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date AV13LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV16soloImp ;
   private boolean AV14duplicaEs ;
   private int[] aP8 ;
   private boolean[] aP7 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P02CV2_A283LiqPeriodo ;
   private int[] P02CV2_A6LegNumero ;
   private int[] P02CV2_A31LiqNro ;
   private java.math.BigDecimal[] P02CV2_A281LiqLegImpTotal ;
   private java.util.Date[] P02CV2_A719LiqFecImp ;
   private short[] P02CV2_A1EmpCod ;
   private int[] P02CV2_A3CliCod ;
}

final  class validarliqdupliporimporte__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02CV2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV16soloImp ,
                                          java.util.Date A719LiqFecImp ,
                                          int A31LiqNro ,
                                          int AV11LiqNro ,
                                          java.math.BigDecimal A281LiqLegImpTotal ,
                                          java.math.BigDecimal AV10LiqLegImpTotal ,
                                          int AV8clicod ,
                                          short AV9empcod ,
                                          int AV12LegNumero ,
                                          java.util.Date AV13LiqPeriodo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date A283LiqPeriodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[6];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT T1.LiqPeriodo, T1.LegNumero, T1.LiqNro, T1.LiqLegImpTotal, T2.LiqFecImp, T1.EmpCod, T1.CliCod FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod" ;
      scmdbuf += " = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LiqPeriodo = ?)");
      addWhere(sWhereString, "(T1.LiqNro <> ?)");
      addWhere(sWhereString, "(T1.LiqLegImpTotal = ?)");
      if ( AV16soloImp )
      {
         addWhere(sWhereString, "(Not (T2.LiqFecImp = DATE '00010101'))");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqPeriodo" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P02CV2(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , (java.math.BigDecimal)dynConstraints[4] , (java.math.BigDecimal)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (java.util.Date)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , (java.util.Date)dynConstraints[13] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CV2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[11], 2);
               }
               return;
      }
   }

}

