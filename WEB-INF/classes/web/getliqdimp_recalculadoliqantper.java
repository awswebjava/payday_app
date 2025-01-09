package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimp_recalculadoliqantper extends GXProcedure
{
   public getliqdimp_recalculadoliqantper( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimp_recalculadoliqantper.class ), "" );
   }

   public getliqdimp_recalculadoliqantper( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           java.util.Date aP4 ,
                                           int aP5 ,
                                           String aP6 )
   {
      getliqdimp_recalculadoliqantper.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        int aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             int aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      getliqdimp_recalculadoliqantper.this.AV13CliCod = aP0;
      getliqdimp_recalculadoliqantper.this.AV8EmpCod = aP1;
      getliqdimp_recalculadoliqantper.this.AV9LiqNro = aP2;
      getliqdimp_recalculadoliqantper.this.AV21LiqRelNro = aP3;
      getliqdimp_recalculadoliqantper.this.AV20LiqPeriodo = aP4;
      getliqdimp_recalculadoliqantper.this.AV10LegNumero = aP5;
      getliqdimp_recalculadoliqantper.this.AV11ConCodigo = aP6;
      getliqdimp_recalculadoliqantper.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "&ConCodigo ", "")+GXutil.trim( AV11ConCodigo)) ;
      AV25GXLvl4 = (byte)(0) ;
      /* Using cursor P01682 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV11ConCodigo, AV20LiqPeriodo, Integer.valueOf(AV9LiqNro), Integer.valueOf(AV21LiqRelNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P01682_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01682_n2112LiqRelNro[0] ;
         A394DConCodigo = P01682_A394DConCodigo[0] ;
         A6LegNumero = P01682_A6LegNumero[0] ;
         A31LiqNro = P01682_A31LiqNro[0] ;
         A397DLiqPeriodo = P01682_A397DLiqPeriodo[0] ;
         A1EmpCod = P01682_A1EmpCod[0] ;
         A3CliCod = P01682_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01682_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P01682_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01682_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01682_n2112LiqRelNro[0] ;
         AV25GXLvl4 = (byte)(1) ;
         AV19LiqDImpReCalcu = AV19LiqDImpReCalcu.add(A764LiqDImpReCalcu) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV25GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "none", "")) ;
      }
      new web.dependenciasesion(remoteHandle, context).execute( AV11ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getliqdimp_recalculadoliqantper.this.AV19LiqDImpReCalcu;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV24Pgmname = "" ;
      scmdbuf = "" ;
      P01682_A2112LiqRelNro = new int[1] ;
      P01682_n2112LiqRelNro = new boolean[] {false} ;
      P01682_A394DConCodigo = new String[] {""} ;
      P01682_A6LegNumero = new int[1] ;
      P01682_A31LiqNro = new int[1] ;
      P01682_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01682_A1EmpCod = new short[1] ;
      P01682_A3CliCod = new int[1] ;
      P01682_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01682_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimp_recalculadoliqantper__default(),
         new Object[] {
             new Object[] {
            P01682_A2112LiqRelNro, P01682_n2112LiqRelNro, P01682_A394DConCodigo, P01682_A6LegNumero, P01682_A31LiqNro, P01682_A397DLiqPeriodo, P01682_A1EmpCod, P01682_A3CliCod, P01682_A764LiqDImpReCalcu, P01682_A81LiqDSecuencial
            }
         }
      );
      AV24Pgmname = "getLiqDImp_recalculadoLiqAntPer" ;
      /* GeneXus formulas. */
      AV24Pgmname = "getLiqDImp_recalculadoLiqAntPer" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25GXLvl4 ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV21LiqRelNro ;
   private int AV10LegNumero ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV19LiqDImpReCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV11ConCodigo ;
   private String AV24Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private java.util.Date AV20LiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean n2112LiqRelNro ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P01682_A2112LiqRelNro ;
   private boolean[] P01682_n2112LiqRelNro ;
   private String[] P01682_A394DConCodigo ;
   private int[] P01682_A6LegNumero ;
   private int[] P01682_A31LiqNro ;
   private java.util.Date[] P01682_A397DLiqPeriodo ;
   private short[] P01682_A1EmpCod ;
   private int[] P01682_A3CliCod ;
   private java.math.BigDecimal[] P01682_A764LiqDImpReCalcu ;
   private int[] P01682_A81LiqDSecuencial ;
}

final  class getliqdimp_recalculadoliqantper__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01682", "SELECT T2.LiqRelNro, T1.DConCodigo, T1.LegNumero, T1.LiqNro, T1.DLiqPeriodo, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo = ?) AND (T1.LiqNro < ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[9])[0] = rslt.getInt(9);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
      }
   }

}

