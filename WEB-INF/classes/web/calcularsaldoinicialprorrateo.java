package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcularsaldoinicialprorrateo extends GXProcedure
{
   public calcularsaldoinicialprorrateo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcularsaldoinicialprorrateo.class ), "" );
   }

   public calcularsaldoinicialprorrateo( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             int aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 )
   {
      calcularsaldoinicialprorrateo.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        String aP4 ,
                        int aP5 ,
                        int aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             int aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 )
   {
      calcularsaldoinicialprorrateo.this.AV13CliCod = aP0;
      calcularsaldoinicialprorrateo.this.AV12EmpCod = aP1;
      calcularsaldoinicialprorrateo.this.AV11LiqLegConAnio = aP2;
      calcularsaldoinicialprorrateo.this.AV10LegNumero = aP3;
      calcularsaldoinicialprorrateo.this.AV9ConCodigo = aP4;
      calcularsaldoinicialprorrateo.this.AV8LiqAltaNro = aP5;
      calcularsaldoinicialprorrateo.this.AV14LiqNuevaNro = aP6;
      calcularsaldoinicialprorrateo.this.AV17LiqLegEsPrrGan = aP7;
      calcularsaldoinicialprorrateo.this.aP8 = aP8;
      calcularsaldoinicialprorrateo.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20GXLvl1 = (byte)(0) ;
      /* Using cursor P01962 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV11LiqLegConAnio), Integer.valueOf(AV10LegNumero), AV9ConCodigo, Integer.valueOf(AV8LiqAltaNro), Boolean.valueOf(AV17LiqLegEsPrrGan), Integer.valueOf(AV14LiqNuevaNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1778LiqLegEsPrrGan = P01962_A1778LiqLegEsPrrGan[0] ;
         A1098LiqNuevaNro = P01962_A1098LiqNuevaNro[0] ;
         A1097LiqAltaNro = P01962_A1097LiqAltaNro[0] ;
         A26ConCodigo = P01962_A26ConCodigo[0] ;
         A6LegNumero = P01962_A6LegNumero[0] ;
         A869LiqLegConAnio = P01962_A869LiqLegConAnio[0] ;
         A1EmpCod = P01962_A1EmpCod[0] ;
         A3CliCod = P01962_A3CliCod[0] ;
         A1148LiqLegTotRecal = P01962_A1148LiqLegTotRecal[0] ;
         A1099LiqLegCuota = P01962_A1099LiqLegCuota[0] ;
         AV20GXLvl1 = (byte)(1) ;
         AV15Importes = AV15Importes.add(A1148LiqLegTotRecal) ;
         AV16LiqDLog += httpContext.getMessage( "Suma total a gravar ", "") + GXutil.trim( GXutil.str( A1148LiqLegTotRecal, 14, 2)) ;
         AV15Importes = AV15Importes.subtract(A1099LiqLegCuota) ;
         AV16LiqDLog += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( A1099LiqLegCuota, 14, 2)) + httpContext.getMessage( " de cuota", "") ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV20GXLvl1 == 0 )
      {
         AV16LiqDLog = httpContext.getMessage( "NO encuentra registros para calcular saldo inicial", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = calcularsaldoinicialprorrateo.this.AV15Importes;
      this.aP9[0] = calcularsaldoinicialprorrateo.this.AV16LiqDLog;
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
      P01962_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      P01962_A1098LiqNuevaNro = new int[1] ;
      P01962_A1097LiqAltaNro = new int[1] ;
      P01962_A26ConCodigo = new String[] {""} ;
      P01962_A6LegNumero = new int[1] ;
      P01962_A869LiqLegConAnio = new short[1] ;
      P01962_A1EmpCod = new short[1] ;
      P01962_A3CliCod = new int[1] ;
      P01962_A1148LiqLegTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01962_A1099LiqLegCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A26ConCodigo = "" ;
      A1148LiqLegTotRecal = DecimalUtil.ZERO ;
      A1099LiqLegCuota = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calcularsaldoinicialprorrateo__default(),
         new Object[] {
             new Object[] {
            P01962_A1778LiqLegEsPrrGan, P01962_A1098LiqNuevaNro, P01962_A1097LiqAltaNro, P01962_A26ConCodigo, P01962_A6LegNumero, P01962_A869LiqLegConAnio, P01962_A1EmpCod, P01962_A3CliCod, P01962_A1148LiqLegTotRecal, P01962_A1099LiqLegCuota
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV20GXLvl1 ;
   private short AV12EmpCod ;
   private short AV11LiqLegConAnio ;
   private short A869LiqLegConAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV10LegNumero ;
   private int AV8LiqAltaNro ;
   private int AV14LiqNuevaNro ;
   private int A1098LiqNuevaNro ;
   private int A1097LiqAltaNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV15Importes ;
   private java.math.BigDecimal A1148LiqLegTotRecal ;
   private java.math.BigDecimal A1099LiqLegCuota ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private boolean AV17LiqLegEsPrrGan ;
   private boolean A1778LiqLegEsPrrGan ;
   private String AV16LiqDLog ;
   private String[] aP9 ;
   private java.math.BigDecimal[] aP8 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01962_A1778LiqLegEsPrrGan ;
   private int[] P01962_A1098LiqNuevaNro ;
   private int[] P01962_A1097LiqAltaNro ;
   private String[] P01962_A26ConCodigo ;
   private int[] P01962_A6LegNumero ;
   private short[] P01962_A869LiqLegConAnio ;
   private short[] P01962_A1EmpCod ;
   private int[] P01962_A3CliCod ;
   private java.math.BigDecimal[] P01962_A1148LiqLegTotRecal ;
   private java.math.BigDecimal[] P01962_A1099LiqLegCuota ;
}

final  class calcularsaldoinicialprorrateo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01962", "SELECT LiqLegEsPrrGan, LiqNuevaNro, LiqAltaNro, ConCodigo, LegNumero, LiqLegConAnio, EmpCod, CliCod, LiqLegTotRecal, LiqLegCuota FROM LiqLegConceptoCuenta WHERE (CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ? and ConCodigo = ( ?) and LiqAltaNro = ?) AND (LiqLegEsPrrGan = ?) AND (LiqNuevaNro <= ?) ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               return;
      }
   }

}

