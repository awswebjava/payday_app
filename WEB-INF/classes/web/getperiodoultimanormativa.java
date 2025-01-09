package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodoultimanormativa extends GXProcedure
{
   public getperiodoultimanormativa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodoultimanormativa.class ), "" );
   }

   public getperiodoultimanormativa( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     java.util.Date aP2 ,
                                     java.math.BigDecimal aP3 )
   {
      getperiodoultimanormativa.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.util.Date[] aP4 )
   {
      getperiodoultimanormativa.this.AV11CliCod = aP0;
      getperiodoultimanormativa.this.AV12EmpCod = aP1;
      getperiodoultimanormativa.this.AV13actualLiqPeriodo = aP2;
      getperiodoultimanormativa.this.AV16actual_PisoGanancias = aP3;
      getperiodoultimanormativa.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00QW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), AV13actualLiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A283LiqPeriodo = P00QW2_A283LiqPeriodo[0] ;
         A1EmpCod = P00QW2_A1EmpCod[0] ;
         A3CliCod = P00QW2_A3CliCod[0] ;
         A743LiqPisoGanancias = P00QW2_A743LiqPisoGanancias[0] ;
         A746LiqPerUltNorm = P00QW2_A746LiqPerUltNorm[0] ;
         A31LiqNro = P00QW2_A31LiqNro[0] ;
         AV14ultimoLiqPisoGanancias = A743LiqPisoGanancias ;
         AV15LiqPerUltNorm = A746LiqPerUltNorm ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( DecimalUtil.compareTo(AV14ultimoLiqPisoGanancias, AV16actual_PisoGanancias) != 0 )
      {
         AV10LiqPeriodo = AV13actualLiqPeriodo ;
      }
      else
      {
         /* Using cursor P00QW3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), AV14ultimoLiqPisoGanancias});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A743LiqPisoGanancias = P00QW3_A743LiqPisoGanancias[0] ;
            A1EmpCod = P00QW3_A1EmpCod[0] ;
            A3CliCod = P00QW3_A3CliCod[0] ;
            A283LiqPeriodo = P00QW3_A283LiqPeriodo[0] ;
            A31LiqNro = P00QW3_A31LiqNro[0] ;
            AV10LiqPeriodo = A283LiqPeriodo ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getperiodoultimanormativa.this.AV10LiqPeriodo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqPeriodo = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00QW2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00QW2_A1EmpCod = new short[1] ;
      P00QW2_A3CliCod = new int[1] ;
      P00QW2_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00QW2_A746LiqPerUltNorm = new java.util.Date[] {GXutil.nullDate()} ;
      P00QW2_A31LiqNro = new int[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A743LiqPisoGanancias = DecimalUtil.ZERO ;
      A746LiqPerUltNorm = GXutil.nullDate() ;
      AV14ultimoLiqPisoGanancias = DecimalUtil.ZERO ;
      AV15LiqPerUltNorm = GXutil.nullDate() ;
      P00QW3_A743LiqPisoGanancias = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00QW3_A1EmpCod = new short[1] ;
      P00QW3_A3CliCod = new int[1] ;
      P00QW3_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00QW3_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getperiodoultimanormativa__default(),
         new Object[] {
             new Object[] {
            P00QW2_A283LiqPeriodo, P00QW2_A1EmpCod, P00QW2_A3CliCod, P00QW2_A743LiqPisoGanancias, P00QW2_A746LiqPerUltNorm, P00QW2_A31LiqNro
            }
            , new Object[] {
            P00QW3_A743LiqPisoGanancias, P00QW3_A1EmpCod, P00QW3_A3CliCod, P00QW3_A283LiqPeriodo, P00QW3_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private java.math.BigDecimal AV16actual_PisoGanancias ;
   private java.math.BigDecimal A743LiqPisoGanancias ;
   private java.math.BigDecimal AV14ultimoLiqPisoGanancias ;
   private String scmdbuf ;
   private java.util.Date AV13actualLiqPeriodo ;
   private java.util.Date AV10LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date A746LiqPerUltNorm ;
   private java.util.Date AV15LiqPerUltNorm ;
   private java.util.Date[] aP4 ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P00QW2_A283LiqPeriodo ;
   private short[] P00QW2_A1EmpCod ;
   private int[] P00QW2_A3CliCod ;
   private java.math.BigDecimal[] P00QW2_A743LiqPisoGanancias ;
   private java.util.Date[] P00QW2_A746LiqPerUltNorm ;
   private int[] P00QW2_A31LiqNro ;
   private java.math.BigDecimal[] P00QW3_A743LiqPisoGanancias ;
   private short[] P00QW3_A1EmpCod ;
   private int[] P00QW3_A3CliCod ;
   private java.util.Date[] P00QW3_A283LiqPeriodo ;
   private int[] P00QW3_A31LiqNro ;
}

final  class getperiodoultimanormativa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00QW2", "SELECT LiqPeriodo, EmpCod, CliCod, LiqPisoGanancias, LiqPerUltNorm, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqPeriodo < ? ORDER BY CliCod, EmpCod, LiqPeriodo DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00QW3", "SELECT LiqPisoGanancias, EmpCod, CliCod, LiqPeriodo, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqPisoGanancias = ? ORDER BY CliCod, EmpCod, LiqPisoGanancias, LiqPeriodo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               return;
      }
   }

}

