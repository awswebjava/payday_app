package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devuelveimportecuota extends GXProcedure
{
   public devuelveimportecuota( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devuelveimportecuota.class ), "" );
   }

   public devuelveimportecuota( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             int aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      devuelveimportecuota.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        int aP4 ,
                        boolean aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             int aP4 ,
                             boolean aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 )
   {
      devuelveimportecuota.this.AV10CliCod = aP0;
      devuelveimportecuota.this.AV11EmpCod = aP1;
      devuelveimportecuota.this.AV18LiqNro = aP2;
      devuelveimportecuota.this.AV19LiqPeriodo = aP3;
      devuelveimportecuota.this.AV13LegNumero = aP4;
      devuelveimportecuota.this.AV15LiqLegEsPrrGan = aP5;
      devuelveimportecuota.this.AV8TLiqCod = aP6;
      devuelveimportecuota.this.aP7 = aP7;
      devuelveimportecuota.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV9egresoTLiqCod ;
      GXt_char2 = AV9egresoTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      devuelveimportecuota.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      devuelveimportecuota.this.GXt_char1 = GXv_char4[0] ;
      AV9egresoTLiqCod = GXt_char1 ;
      AV12LiqLegConAnio = (short)(GXutil.year( AV19LiqPeriodo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&TLiqCod \"", "")+AV8TLiqCod+httpContext.getMessage( "\" &egresoTLiqCod \"", "")+AV9egresoTLiqCod+"\"") ;
      if ( GXutil.strcmp(GXutil.trim( AV8TLiqCod), GXutil.trim( AV9egresoTLiqCod)) == 0 )
      {
         GXv_int5[0] = AV14anteriorLiqNro ;
         new web.cuentaobtieneliquidacionanterior(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqLegConAnio, AV13LegNumero, AV18LiqNro, AV15LiqLegEsPrrGan, GXv_int5) ;
         devuelveimportecuota.this.AV14anteriorLiqNro = GXv_int5[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "es egreso", "")) ;
         AV17LiqDLog = httpContext.getMessage( "Suma los saldos pendientes de prorratear", "") ;
         AV23GXLvl11 = (byte)(0) ;
         /* Using cursor P01LX2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Short.valueOf(AV12LiqLegConAnio), Integer.valueOf(AV13LegNumero), Integer.valueOf(AV14anteriorLiqNro), Boolean.valueOf(AV15LiqLegEsPrrGan)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1778LiqLegEsPrrGan = P01LX2_A1778LiqLegEsPrrGan[0] ;
            A1098LiqNuevaNro = P01LX2_A1098LiqNuevaNro[0] ;
            A6LegNumero = P01LX2_A6LegNumero[0] ;
            A869LiqLegConAnio = P01LX2_A869LiqLegConAnio[0] ;
            A1EmpCod = P01LX2_A1EmpCod[0] ;
            A3CliCod = P01LX2_A3CliCod[0] ;
            A868LiqLegConSaldo = P01LX2_A868LiqLegConSaldo[0] ;
            A26ConCodigo = P01LX2_A26ConCodigo[0] ;
            A1097LiqAltaNro = P01LX2_A1097LiqAltaNro[0] ;
            AV23GXLvl11 = (byte)(1) ;
            AV16Importes = AV16Importes.add(A868LiqLegConSaldo) ;
            AV17LiqDLog += " +" + GXutil.trim( GXutil.str( A868LiqLegConSaldo, 14, 2)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "suma ", "")+GXutil.trim( GXutil.str( A868LiqLegConSaldo, 14, 2))) ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV23GXLvl11 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "nonin", "")) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&Importes ", "")+GXutil.trim( GXutil.str( AV16Importes, 14, 2))) ;
      }
      else
      {
         AV17LiqDLog = httpContext.getMessage( "Suma cuotas de prorrateo de Liq. nro. ", "") + GXutil.trim( GXutil.str( AV18LiqNro, 8, 0)) ;
         /* Using cursor P01LX3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Short.valueOf(AV12LiqLegConAnio), Integer.valueOf(AV13LegNumero), AV19LiqPeriodo, Integer.valueOf(AV18LiqNro), Boolean.valueOf(AV15LiqLegEsPrrGan)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1778LiqLegEsPrrGan = P01LX3_A1778LiqLegEsPrrGan[0] ;
            A1098LiqNuevaNro = P01LX3_A1098LiqNuevaNro[0] ;
            A886LiqLegConPer = P01LX3_A886LiqLegConPer[0] ;
            n886LiqLegConPer = P01LX3_n886LiqLegConPer[0] ;
            A6LegNumero = P01LX3_A6LegNumero[0] ;
            A869LiqLegConAnio = P01LX3_A869LiqLegConAnio[0] ;
            A1EmpCod = P01LX3_A1EmpCod[0] ;
            A3CliCod = P01LX3_A3CliCod[0] ;
            A1099LiqLegCuota = P01LX3_A1099LiqLegCuota[0] ;
            A26ConCodigo = P01LX3_A26ConCodigo[0] ;
            A1097LiqAltaNro = P01LX3_A1097LiqAltaNro[0] ;
            AV16Importes = AV16Importes.add(A1099LiqLegCuota) ;
            AV17LiqDLog += " +" + GXutil.trim( GXutil.str( A1099LiqLegCuota, 14, 2)) ;
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = devuelveimportecuota.this.AV16Importes;
      this.aP8[0] = devuelveimportecuota.this.AV17LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16Importes = DecimalUtil.ZERO ;
      AV17LiqDLog = "" ;
      AV9egresoTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV22Pgmname = "" ;
      GXv_int5 = new int[1] ;
      scmdbuf = "" ;
      P01LX2_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      P01LX2_A1098LiqNuevaNro = new int[1] ;
      P01LX2_A6LegNumero = new int[1] ;
      P01LX2_A869LiqLegConAnio = new short[1] ;
      P01LX2_A1EmpCod = new short[1] ;
      P01LX2_A3CliCod = new int[1] ;
      P01LX2_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01LX2_A26ConCodigo = new String[] {""} ;
      P01LX2_A1097LiqAltaNro = new int[1] ;
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      A26ConCodigo = "" ;
      P01LX3_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      P01LX3_A1098LiqNuevaNro = new int[1] ;
      P01LX3_A886LiqLegConPer = new java.util.Date[] {GXutil.nullDate()} ;
      P01LX3_n886LiqLegConPer = new boolean[] {false} ;
      P01LX3_A6LegNumero = new int[1] ;
      P01LX3_A869LiqLegConAnio = new short[1] ;
      P01LX3_A1EmpCod = new short[1] ;
      P01LX3_A3CliCod = new int[1] ;
      P01LX3_A1099LiqLegCuota = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01LX3_A26ConCodigo = new String[] {""} ;
      P01LX3_A1097LiqAltaNro = new int[1] ;
      A886LiqLegConPer = GXutil.nullDate() ;
      A1099LiqLegCuota = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.devuelveimportecuota__default(),
         new Object[] {
             new Object[] {
            P01LX2_A1778LiqLegEsPrrGan, P01LX2_A1098LiqNuevaNro, P01LX2_A6LegNumero, P01LX2_A869LiqLegConAnio, P01LX2_A1EmpCod, P01LX2_A3CliCod, P01LX2_A868LiqLegConSaldo, P01LX2_A26ConCodigo, P01LX2_A1097LiqAltaNro
            }
            , new Object[] {
            P01LX3_A1778LiqLegEsPrrGan, P01LX3_A1098LiqNuevaNro, P01LX3_A886LiqLegConPer, P01LX3_n886LiqLegConPer, P01LX3_A6LegNumero, P01LX3_A869LiqLegConAnio, P01LX3_A1EmpCod, P01LX3_A3CliCod, P01LX3_A1099LiqLegCuota, P01LX3_A26ConCodigo,
            P01LX3_A1097LiqAltaNro
            }
         }
      );
      AV22Pgmname = "devuelveImporteCuota" ;
      /* GeneXus formulas. */
      AV22Pgmname = "devuelveImporteCuota" ;
      Gx_err = (short)(0) ;
   }

   private byte AV23GXLvl11 ;
   private short AV11EmpCod ;
   private short AV12LiqLegConAnio ;
   private short A869LiqLegConAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV18LiqNro ;
   private int AV13LegNumero ;
   private int AV14anteriorLiqNro ;
   private int GXv_int5[] ;
   private int A1098LiqNuevaNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1097LiqAltaNro ;
   private java.math.BigDecimal AV16Importes ;
   private java.math.BigDecimal A868LiqLegConSaldo ;
   private java.math.BigDecimal A1099LiqLegCuota ;
   private String AV8TLiqCod ;
   private String AV9egresoTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV22Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private java.util.Date AV19LiqPeriodo ;
   private java.util.Date A886LiqLegConPer ;
   private boolean AV15LiqLegEsPrrGan ;
   private boolean A1778LiqLegEsPrrGan ;
   private boolean n886LiqLegConPer ;
   private String AV17LiqDLog ;
   private String[] aP8 ;
   private java.math.BigDecimal[] aP7 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01LX2_A1778LiqLegEsPrrGan ;
   private int[] P01LX2_A1098LiqNuevaNro ;
   private int[] P01LX2_A6LegNumero ;
   private short[] P01LX2_A869LiqLegConAnio ;
   private short[] P01LX2_A1EmpCod ;
   private int[] P01LX2_A3CliCod ;
   private java.math.BigDecimal[] P01LX2_A868LiqLegConSaldo ;
   private String[] P01LX2_A26ConCodigo ;
   private int[] P01LX2_A1097LiqAltaNro ;
   private boolean[] P01LX3_A1778LiqLegEsPrrGan ;
   private int[] P01LX3_A1098LiqNuevaNro ;
   private java.util.Date[] P01LX3_A886LiqLegConPer ;
   private boolean[] P01LX3_n886LiqLegConPer ;
   private int[] P01LX3_A6LegNumero ;
   private short[] P01LX3_A869LiqLegConAnio ;
   private short[] P01LX3_A1EmpCod ;
   private int[] P01LX3_A3CliCod ;
   private java.math.BigDecimal[] P01LX3_A1099LiqLegCuota ;
   private String[] P01LX3_A26ConCodigo ;
   private int[] P01LX3_A1097LiqAltaNro ;
}

final  class devuelveimportecuota__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LX2", "SELECT LiqLegEsPrrGan, LiqNuevaNro, LegNumero, LiqLegConAnio, EmpCod, CliCod, LiqLegConSaldo, ConCodigo, LiqAltaNro FROM LiqLegConceptoCuenta WHERE (CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ?) AND (LiqNuevaNro = ?) AND (LiqLegEsPrrGan = ?) ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01LX3", "SELECT LiqLegEsPrrGan, LiqNuevaNro, LiqLegConPer, LegNumero, LiqLegConAnio, EmpCod, CliCod, LiqLegCuota, ConCodigo, LiqAltaNro FROM LiqLegConceptoCuenta WHERE (CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ?) AND (LiqLegConPer = ?) AND (LiqNuevaNro = ?) AND (LiqLegEsPrrGan = ?) ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getString(8, 10);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               return;
            case 1 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getString(9, 10);
               ((int[]) buf[10])[0] = rslt.getInt(10);
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
      }
   }

}

