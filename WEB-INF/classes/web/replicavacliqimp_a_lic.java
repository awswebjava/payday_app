package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class replicavacliqimp_a_lic extends GXProcedure
{
   public replicavacliqimp_a_lic( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( replicavacliqimp_a_lic.class ), "" );
   }

   public replicavacliqimp_a_lic( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 )
   {
      replicavacliqimp_a_lic.this.AV9CliCod = aP0;
      replicavacliqimp_a_lic.this.AV10EmpCod = aP1;
      replicavacliqimp_a_lic.this.AV11LegNumero = aP2;
      replicavacliqimp_a_lic.this.AV12desdeAnio = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV8vacConCodigo ;
      GXt_char2 = AV8vacConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_vacacioneslibres_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      replicavacliqimp_a_lic.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      replicavacliqimp_a_lic.this.GXt_char1 = GXv_char4[0] ;
      AV8vacConCodigo = GXt_char1 ;
      GXt_char2 = AV13vacSitCodigo ;
      GXv_char4[0] = GXt_char2 ;
      new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV9CliCod, GXv_char4) ;
      replicavacliqimp_a_lic.this.GXt_char2 = GXv_char4[0] ;
      AV13vacSitCodigo = GXt_char2 ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV11LegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A719LiqFecImp ,
                                           A394DConCodigo ,
                                           AV8vacConCodigo ,
                                           Integer.valueOf(AV9CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02BW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), AV8vacConCodigo, Integer.valueOf(AV11LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02BW2_A31LiqNro[0] ;
         A394DConCodigo = P02BW2_A394DConCodigo[0] ;
         A719LiqFecImp = P02BW2_A719LiqFecImp[0] ;
         A6LegNumero = P02BW2_A6LegNumero[0] ;
         A1EmpCod = P02BW2_A1EmpCod[0] ;
         A3CliCod = P02BW2_A3CliCod[0] ;
         A397DLiqPeriodo = P02BW2_A397DLiqPeriodo[0] ;
         A269LiqDCanti = P02BW2_A269LiqDCanti[0] ;
         n269LiqDCanti = P02BW2_n269LiqDCanti[0] ;
         A81LiqDSecuencial = P02BW2_A81LiqDSecuencial[0] ;
         A719LiqFecImp = P02BW2_A719LiqFecImp[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV18Pgmname, httpContext.getMessage( "importaciones legnumero ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))) ;
         new web.asignarconsumoscclicencias(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, A397DLiqPeriodo, (short)(DecimalUtil.decToDouble(A269LiqDCanti)), "importacion", 0) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
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
      AV8vacConCodigo = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV13vacSitCodigo = "" ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      A394DConCodigo = "" ;
      P02BW2_A31LiqNro = new int[1] ;
      P02BW2_A394DConCodigo = new String[] {""} ;
      P02BW2_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      P02BW2_A6LegNumero = new int[1] ;
      P02BW2_A1EmpCod = new short[1] ;
      P02BW2_A3CliCod = new int[1] ;
      P02BW2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02BW2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02BW2_n269LiqDCanti = new boolean[] {false} ;
      P02BW2_A81LiqDSecuencial = new int[1] ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      AV18Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.replicavacliqimp_a_lic__default(),
         new Object[] {
             new Object[] {
            P02BW2_A31LiqNro, P02BW2_A394DConCodigo, P02BW2_A719LiqFecImp, P02BW2_A6LegNumero, P02BW2_A1EmpCod, P02BW2_A3CliCod, P02BW2_A397DLiqPeriodo, P02BW2_A269LiqDCanti, P02BW2_n269LiqDCanti, P02BW2_A81LiqDSecuencial
            }
         }
      );
      AV18Pgmname = "replicaVacLIqImp_a_Lic" ;
      /* GeneXus formulas. */
      AV18Pgmname = "replicaVacLIqImp_a_Lic" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV12desdeAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal A269LiqDCanti ;
   private String AV8vacConCodigo ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV13vacSitCodigo ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV18Pgmname ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean n269LiqDCanti ;
   private IDataStoreProvider pr_default ;
   private int[] P02BW2_A31LiqNro ;
   private String[] P02BW2_A394DConCodigo ;
   private java.util.Date[] P02BW2_A719LiqFecImp ;
   private int[] P02BW2_A6LegNumero ;
   private short[] P02BW2_A1EmpCod ;
   private int[] P02BW2_A3CliCod ;
   private java.util.Date[] P02BW2_A397DLiqPeriodo ;
   private java.math.BigDecimal[] P02BW2_A269LiqDCanti ;
   private boolean[] P02BW2_n269LiqDCanti ;
   private int[] P02BW2_A81LiqDSecuencial ;
}

final  class replicavacliqimp_a_lic__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02BW2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV11LegNumero ,
                                          int A6LegNumero ,
                                          java.util.Date A719LiqFecImp ,
                                          String A394DConCodigo ,
                                          String AV8vacConCodigo ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[4];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT T1.LiqNro, T1.DConCodigo, T2.LiqFecImp, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.DLiqPeriodo, T1.LiqDCanti, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER" ;
      scmdbuf += " JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(Not (T2.LiqFecImp = DATE '00010101'))");
      addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      if ( ! (0==AV11LegNumero) )
      {
         addWhere(sWhereString, "(T1.LegNumero = ?)");
      }
      else
      {
         GXv_int5[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P02BW2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (java.util.Date)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BW2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDateTime(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
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
                  stmt.setString(sIdx, (String)parms[6], 10);
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

