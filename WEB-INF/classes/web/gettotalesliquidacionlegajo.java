package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettotalesliquidacionlegajo extends GXProcedure
{
   public gettotalesliquidacionlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettotalesliquidacionlegajo.class ), "" );
   }

   public gettotalesliquidacionlegajo( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           java.math.BigDecimal[] aP4 ,
                                           java.math.BigDecimal[] aP5 ,
                                           java.math.BigDecimal[] aP6 )
   {
      gettotalesliquidacionlegajo.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      gettotalesliquidacionlegajo.this.AV14CliCod = aP0;
      gettotalesliquidacionlegajo.this.AV8EmpCod = aP1;
      gettotalesliquidacionlegajo.this.AV15LiqNro = aP2;
      gettotalesliquidacionlegajo.this.AV9LegNumero = aP3;
      gettotalesliquidacionlegajo.this.aP4 = aP4;
      gettotalesliquidacionlegajo.this.aP5 = aP5;
      gettotalesliquidacionlegajo.this.aP6 = aP6;
      gettotalesliquidacionlegajo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01602 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV15LiqNro), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01602_A6LegNumero[0] ;
         A31LiqNro = P01602_A31LiqNro[0] ;
         A1EmpCod = P01602_A1EmpCod[0] ;
         A3CliCod = P01602_A3CliCod[0] ;
         A577LiqLegImpTotRemu = P01602_A577LiqLegImpTotRemu[0] ;
         A578LiqLegImpTotNoRemu = P01602_A578LiqLegImpTotNoRemu[0] ;
         A579LiqLegImpTotDescu = P01602_A579LiqLegImpTotDescu[0] ;
         A281LiqLegImpTotal = P01602_A281LiqLegImpTotal[0] ;
         AV12LiqLegImpTotRemu = A577LiqLegImpTotRemu ;
         AV13LiqLegImpTotNoRemu = A578LiqLegImpTotNoRemu ;
         AV11LiqLegImpTotDescu = A579LiqLegImpTotDescu ;
         AV10LiqLegImpTotal = A281LiqLegImpTotal ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = gettotalesliquidacionlegajo.this.AV12LiqLegImpTotRemu;
      this.aP5[0] = gettotalesliquidacionlegajo.this.AV13LiqLegImpTotNoRemu;
      this.aP6[0] = gettotalesliquidacionlegajo.this.AV11LiqLegImpTotDescu;
      this.aP7[0] = gettotalesliquidacionlegajo.this.AV10LiqLegImpTotal;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqLegImpTotRemu = DecimalUtil.ZERO ;
      AV13LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      AV11LiqLegImpTotDescu = DecimalUtil.ZERO ;
      AV10LiqLegImpTotal = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P01602_A6LegNumero = new int[1] ;
      P01602_A31LiqNro = new int[1] ;
      P01602_A1EmpCod = new short[1] ;
      P01602_A3CliCod = new int[1] ;
      P01602_A577LiqLegImpTotRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01602_A578LiqLegImpTotNoRemu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01602_A579LiqLegImpTotDescu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01602_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A577LiqLegImpTotRemu = DecimalUtil.ZERO ;
      A578LiqLegImpTotNoRemu = DecimalUtil.ZERO ;
      A579LiqLegImpTotDescu = DecimalUtil.ZERO ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettotalesliquidacionlegajo__default(),
         new Object[] {
             new Object[] {
            P01602_A6LegNumero, P01602_A31LiqNro, P01602_A1EmpCod, P01602_A3CliCod, P01602_A577LiqLegImpTotRemu, P01602_A578LiqLegImpTotNoRemu, P01602_A579LiqLegImpTotDescu, P01602_A281LiqLegImpTotal
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV15LiqNro ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private java.math.BigDecimal AV12LiqLegImpTotRemu ;
   private java.math.BigDecimal AV13LiqLegImpTotNoRemu ;
   private java.math.BigDecimal AV11LiqLegImpTotDescu ;
   private java.math.BigDecimal AV10LiqLegImpTotal ;
   private java.math.BigDecimal A577LiqLegImpTotRemu ;
   private java.math.BigDecimal A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal A579LiqLegImpTotDescu ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private String scmdbuf ;
   private java.math.BigDecimal[] aP7 ;
   private java.math.BigDecimal[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P01602_A6LegNumero ;
   private int[] P01602_A31LiqNro ;
   private short[] P01602_A1EmpCod ;
   private int[] P01602_A3CliCod ;
   private java.math.BigDecimal[] P01602_A577LiqLegImpTotRemu ;
   private java.math.BigDecimal[] P01602_A578LiqLegImpTotNoRemu ;
   private java.math.BigDecimal[] P01602_A579LiqLegImpTotDescu ;
   private java.math.BigDecimal[] P01602_A281LiqLegImpTotal ;
}

final  class gettotalesliquidacionlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01602", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegImpTotRemu, LiqLegImpTotNoRemu, LiqLegImpTotDescu, LiqLegImpTotal FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

