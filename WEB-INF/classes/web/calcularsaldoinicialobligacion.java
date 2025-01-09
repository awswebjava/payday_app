package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcularsaldoinicialobligacion extends GXProcedure
{
   public calcularsaldoinicialobligacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcularsaldoinicialobligacion.class ), "" );
   }

   public calcularsaldoinicialobligacion( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             int aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             short[] aP7 )
   {
      calcularsaldoinicialobligacion.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        int aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        short[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             int aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             short[] aP7 ,
                             String[] aP8 )
   {
      calcularsaldoinicialobligacion.this.AV13CliCod = aP0;
      calcularsaldoinicialobligacion.this.AV12EmpCod = aP1;
      calcularsaldoinicialobligacion.this.AV10LegNumero = aP2;
      calcularsaldoinicialobligacion.this.AV17OblSecuencial = aP3;
      calcularsaldoinicialobligacion.this.AV8LiqAltaNro = aP4;
      calcularsaldoinicialobligacion.this.AV14LiqNuevaNro = aP5;
      calcularsaldoinicialobligacion.this.aP6 = aP6;
      calcularsaldoinicialobligacion.this.aP7 = aP7;
      calcularsaldoinicialobligacion.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21GXLvl1 = (byte)(0) ;
      /* Using cursor P01A12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV10LegNumero), Short.valueOf(AV17OblSecuencial), Integer.valueOf(AV8LiqAltaNro), Integer.valueOf(AV14LiqNuevaNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1185LiqOblNuevaNro = P01A12_A1185LiqOblNuevaNro[0] ;
         A1184LiqOblAltaNro = P01A12_A1184LiqOblAltaNro[0] ;
         A1172OblSecuencial = P01A12_A1172OblSecuencial[0] ;
         A6LegNumero = P01A12_A6LegNumero[0] ;
         A1EmpCod = P01A12_A1EmpCod[0] ;
         A3CliCod = P01A12_A3CliCod[0] ;
         A1186LiqOblPrimera = P01A12_A1186LiqOblPrimera[0] ;
         A1190LiqOblTotRecal = P01A12_A1190LiqOblTotRecal[0] ;
         A1188LiqOblCuota = P01A12_A1188LiqOblCuota[0] ;
         AV21GXLvl1 = (byte)(1) ;
         if ( A1186LiqOblPrimera )
         {
            AV15Importes = AV15Importes.add(A1190LiqOblTotRecal) ;
            AV16LiqDLog += httpContext.getMessage( "Deuda Inicial: ", "") + GXutil.trim( GXutil.str( A1190LiqOblTotRecal, 14, 2)) ;
         }
         AV15Importes = AV15Importes.subtract(A1188LiqOblCuota) ;
         AV16LiqDLog += " - " + GXutil.trim( GXutil.str( A1188LiqOblCuota, 14, 2)) ;
         AV18cantLiquidadas = (short)(AV18cantLiquidadas+1) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV21GXLvl1 == 0 )
      {
         AV16LiqDLog = httpContext.getMessage( "NO encuentra registros para calcular saldo inicial", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = calcularsaldoinicialobligacion.this.AV15Importes;
      this.aP7[0] = calcularsaldoinicialobligacion.this.AV18cantLiquidadas;
      this.aP8[0] = calcularsaldoinicialobligacion.this.AV16LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15Importes = DecimalUtil.ZERO ;
      AV16LiqDLog = "" ;
      scmdbuf = "" ;
      P01A12_A1185LiqOblNuevaNro = new int[1] ;
      P01A12_A1184LiqOblAltaNro = new int[1] ;
      P01A12_A1172OblSecuencial = new short[1] ;
      P01A12_A6LegNumero = new int[1] ;
      P01A12_A1EmpCod = new short[1] ;
      P01A12_A3CliCod = new int[1] ;
      P01A12_A1186LiqOblPrimera = new boolean[] {false} ;
      P01A12_A1190LiqOblTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01A12_A1188LiqOblCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1190LiqOblTotRecal = DecimalUtil.ZERO ;
      A1188LiqOblCuota = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calcularsaldoinicialobligacion__default(),
         new Object[] {
             new Object[] {
            P01A12_A1185LiqOblNuevaNro, P01A12_A1184LiqOblAltaNro, P01A12_A1172OblSecuencial, P01A12_A6LegNumero, P01A12_A1EmpCod, P01A12_A3CliCod, P01A12_A1186LiqOblPrimera, P01A12_A1190LiqOblTotRecal, P01A12_A1188LiqOblCuota
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV21GXLvl1 ;
   private short AV12EmpCod ;
   private short AV17OblSecuencial ;
   private short AV18cantLiquidadas ;
   private short A1172OblSecuencial ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV10LegNumero ;
   private int AV8LiqAltaNro ;
   private int AV14LiqNuevaNro ;
   private int A1185LiqOblNuevaNro ;
   private int A1184LiqOblAltaNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV15Importes ;
   private java.math.BigDecimal A1190LiqOblTotRecal ;
   private java.math.BigDecimal A1188LiqOblCuota ;
   private String scmdbuf ;
   private boolean A1186LiqOblPrimera ;
   private String AV16LiqDLog ;
   private String[] aP8 ;
   private java.math.BigDecimal[] aP6 ;
   private short[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P01A12_A1185LiqOblNuevaNro ;
   private int[] P01A12_A1184LiqOblAltaNro ;
   private short[] P01A12_A1172OblSecuencial ;
   private int[] P01A12_A6LegNumero ;
   private short[] P01A12_A1EmpCod ;
   private int[] P01A12_A3CliCod ;
   private boolean[] P01A12_A1186LiqOblPrimera ;
   private java.math.BigDecimal[] P01A12_A1190LiqOblTotRecal ;
   private java.math.BigDecimal[] P01A12_A1188LiqOblCuota ;
}

final  class calcularsaldoinicialobligacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01A12", "SELECT LiqOblNuevaNro, LiqOblAltaNro, OblSecuencial, LegNumero, EmpCod, CliCod, LiqOblPrimera, LiqOblTotRecal, LiqOblCuota FROM LiqLegObligacionCuenta WHERE (CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? and LiqOblAltaNro = ?) AND (LiqOblNuevaNro <= ?) ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
      }
   }

}

