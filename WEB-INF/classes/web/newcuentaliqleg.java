package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newcuentaliqleg extends GXProcedure
{
   public newcuentaliqleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newcuentaliqleg.class ), "" );
   }

   public newcuentaliqleg( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           short aP2 ,
                                           int aP3 ,
                                           int aP4 ,
                                           int aP5 ,
                                           String aP6 ,
                                           short aP7 ,
                                           java.math.BigDecimal aP8 ,
                                           java.math.BigDecimal aP9 ,
                                           java.util.Date aP10 ,
                                           boolean aP11 ,
                                           boolean aP12 ,
                                           String aP13 )
   {
      newcuentaliqleg.this.aP14 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        int aP4 ,
                        int aP5 ,
                        String aP6 ,
                        short aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.math.BigDecimal aP9 ,
                        java.util.Date aP10 ,
                        boolean aP11 ,
                        boolean aP12 ,
                        String aP13 ,
                        java.math.BigDecimal[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             int aP5 ,
                             String aP6 ,
                             short aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             java.util.Date aP10 ,
                             boolean aP11 ,
                             boolean aP12 ,
                             String aP13 ,
                             java.math.BigDecimal[] aP14 )
   {
      newcuentaliqleg.this.AV8CliCod = aP0;
      newcuentaliqleg.this.AV9EmpCod = aP1;
      newcuentaliqleg.this.AV10LiqLegConAnio = aP2;
      newcuentaliqleg.this.AV20LiqAltaNro = aP3;
      newcuentaliqleg.this.AV21LiqNuevaNro = aP4;
      newcuentaliqleg.this.AV11LegNumero = aP5;
      newcuentaliqleg.this.AV12ConCodigo = aP6;
      newcuentaliqleg.this.AV16LiqLegCodigo = aP7;
      newcuentaliqleg.this.AV13LiqLegConSaldo = aP8;
      newcuentaliqleg.this.AV24LiqLegCuota = aP9;
      newcuentaliqleg.this.AV14LiqLegConPer = aP10;
      newcuentaliqleg.this.AV17LiqLegPrimera = aP11;
      newcuentaliqleg.this.AV26LiqLegEsPrrGan = aP12;
      newcuentaliqleg.this.AV25ProcesoLiquidacion = aP13;
      newcuentaliqleg.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE LiqLegConceptoCuenta

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A869LiqLegConAnio = AV10LiqLegConAnio ;
      A1097LiqAltaNro = AV20LiqAltaNro ;
      A1098LiqNuevaNro = AV21LiqNuevaNro ;
      A6LegNumero = AV11LegNumero ;
      A26ConCodigo = AV12ConCodigo ;
      if ( AV13LiqLegConSaldo.doubleValue() >= 0 )
      {
         A868LiqLegConSaldo = AV13LiqLegConSaldo ;
      }
      A886LiqLegConPer = AV14LiqLegConPer ;
      n886LiqLegConPer = false ;
      if ( ! (0==AV16LiqLegCodigo) )
      {
         A888LiqLegCodigo = AV16LiqLegCodigo ;
         n888LiqLegCodigo = false ;
      }
      else
      {
         A888LiqLegCodigo = (short)(0) ;
         n888LiqLegCodigo = false ;
         n888LiqLegCodigo = true ;
      }
      A889LiqLegPrimera = AV17LiqLegPrimera ;
      A1099LiqLegCuota = AV24LiqLegCuota ;
      AV23ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      AV22LiqDLog = "#" + GXutil.trim( localUtil.ttoc( AV23ahora, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ")) + httpContext.getMessage( " &LiqLegPrimera ", "") + GXutil.trim( GXutil.booltostr( AV17LiqLegPrimera)) + httpContext.getMessage( " &LiqAltaNro ", "") + GXutil.trim( GXutil.str( AV20LiqAltaNro, 8, 0)) + httpContext.getMessage( " &LiqNuevaNro ", "") + GXutil.trim( GXutil.str( AV21LiqNuevaNro, 8, 0)) + httpContext.getMessage( " &LiqLegConSaldo ", "") + GXutil.trim( GXutil.str( AV13LiqLegConSaldo, 14, 2)) ;
      A1094LiqLegLog = AV22LiqDLog ;
      if ( AV17LiqLegPrimera )
      {
         A1147LiqLegTotal = AV24LiqLegCuota.add(AV13LiqLegConSaldo) ;
         A1148LiqLegTotRecal = AV24LiqLegCuota.add(AV13LiqLegConSaldo) ;
      }
      else
      {
         A1147LiqLegTotal = DecimalUtil.ZERO ;
         if ( AV13LiqLegConSaldo.doubleValue() < 0 )
         {
            A1148LiqLegTotRecal = AV13LiqLegConSaldo.multiply(DecimalUtil.doubleToDec(-1)) ;
         }
         else
         {
            A1148LiqLegTotRecal = DecimalUtil.ZERO ;
         }
      }
      A1778LiqLegEsPrrGan = AV26LiqLegEsPrrGan ;
      /* Using cursor P00WR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro), A868LiqLegConSaldo, Boolean.valueOf(n886LiqLegConPer), A886LiqLegConPer, Boolean.valueOf(n888LiqLegCodigo), Short.valueOf(A888LiqLegCodigo), Boolean.valueOf(A889LiqLegPrimera), A1094LiqLegLog, A1099LiqLegCuota, A1147LiqLegTotal, A1148LiqLegTotRecal, Boolean.valueOf(A1778LiqLegEsPrrGan)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         AV22LiqDLog = httpContext.getMessage( "#dupli#&LiqLegPrimera ", "") + GXutil.trim( GXutil.booltostr( AV17LiqLegPrimera)) + httpContext.getMessage( " &ProcesoLiquidacion ", "") + GXutil.trim( AV25ProcesoLiquidacion) ;
         if ( ( AV17LiqLegPrimera ) && ( GXutil.strcmp(AV25ProcesoLiquidacion, "Recalculo") == 0 ) )
         {
            /* Using cursor P00WR3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A3CliCod = P00WR3_A3CliCod[0] ;
               A1EmpCod = P00WR3_A1EmpCod[0] ;
               A869LiqLegConAnio = P00WR3_A869LiqLegConAnio[0] ;
               A6LegNumero = P00WR3_A6LegNumero[0] ;
               A26ConCodigo = P00WR3_A26ConCodigo[0] ;
               A1097LiqAltaNro = P00WR3_A1097LiqAltaNro[0] ;
               A1098LiqNuevaNro = P00WR3_A1098LiqNuevaNro[0] ;
               A1148LiqLegTotRecal = P00WR3_A1148LiqLegTotRecal[0] ;
               A1148LiqLegTotRecal = AV24LiqLegCuota.add(AV13LiqLegConSaldo) ;
               AV22LiqDLog += httpContext.getMessage( "actualiza recal &LiqLegCuota ", "") + GXutil.trim( GXutil.str( AV24LiqLegCuota, 14, 2)) + httpContext.getMessage( " + &LiqLegConSaldo ", "") + GXutil.trim( GXutil.str( AV13LiqLegConSaldo, 14, 2)) ;
               /* Using cursor P00WR4 */
               pr_default.execute(2, new Object[] {A1148LiqLegTotRecal, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, AV22LiqDLog) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP14[0] = newcuentaliqleg.this.AV19nuevo_LiqLegConSaldo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19nuevo_LiqLegConSaldo = DecimalUtil.ZERO ;
      A26ConCodigo = "" ;
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      A886LiqLegConPer = GXutil.nullDate() ;
      A1099LiqLegCuota = DecimalUtil.ZERO ;
      AV23ahora = GXutil.resetTime( GXutil.nullDate() );
      AV22LiqDLog = "" ;
      A1094LiqLegLog = "" ;
      A1147LiqLegTotal = DecimalUtil.ZERO ;
      A1148LiqLegTotRecal = DecimalUtil.ZERO ;
      Gx_emsg = "" ;
      scmdbuf = "" ;
      P00WR3_A3CliCod = new int[1] ;
      P00WR3_A1EmpCod = new short[1] ;
      P00WR3_A869LiqLegConAnio = new short[1] ;
      P00WR3_A6LegNumero = new int[1] ;
      P00WR3_A26ConCodigo = new String[] {""} ;
      P00WR3_A1097LiqAltaNro = new int[1] ;
      P00WR3_A1098LiqNuevaNro = new int[1] ;
      P00WR3_A1148LiqLegTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV30Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newcuentaliqleg__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P00WR3_A3CliCod, P00WR3_A1EmpCod, P00WR3_A869LiqLegConAnio, P00WR3_A6LegNumero, P00WR3_A26ConCodigo, P00WR3_A1097LiqAltaNro, P00WR3_A1098LiqNuevaNro, P00WR3_A1148LiqLegTotRecal
            }
            , new Object[] {
            }
         }
      );
      AV30Pgmname = "NewCuentaLiqLeg" ;
      /* GeneXus formulas. */
      AV30Pgmname = "NewCuentaLiqLeg" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV10LiqLegConAnio ;
   private short AV16LiqLegCodigo ;
   private short A1EmpCod ;
   private short A869LiqLegConAnio ;
   private short A888LiqLegCodigo ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV20LiqAltaNro ;
   private int AV21LiqNuevaNro ;
   private int AV11LegNumero ;
   private int GX_INS122 ;
   private int A3CliCod ;
   private int A1097LiqAltaNro ;
   private int A1098LiqNuevaNro ;
   private int A6LegNumero ;
   private java.math.BigDecimal AV13LiqLegConSaldo ;
   private java.math.BigDecimal AV24LiqLegCuota ;
   private java.math.BigDecimal AV19nuevo_LiqLegConSaldo ;
   private java.math.BigDecimal A868LiqLegConSaldo ;
   private java.math.BigDecimal A1099LiqLegCuota ;
   private java.math.BigDecimal A1147LiqLegTotal ;
   private java.math.BigDecimal A1148LiqLegTotRecal ;
   private String AV12ConCodigo ;
   private String AV25ProcesoLiquidacion ;
   private String A26ConCodigo ;
   private String Gx_emsg ;
   private String scmdbuf ;
   private String AV30Pgmname ;
   private java.util.Date AV23ahora ;
   private java.util.Date AV14LiqLegConPer ;
   private java.util.Date A886LiqLegConPer ;
   private boolean AV17LiqLegPrimera ;
   private boolean AV26LiqLegEsPrrGan ;
   private boolean n886LiqLegConPer ;
   private boolean n888LiqLegCodigo ;
   private boolean A889LiqLegPrimera ;
   private boolean A1778LiqLegEsPrrGan ;
   private String AV22LiqDLog ;
   private String A1094LiqLegLog ;
   private java.math.BigDecimal[] aP14 ;
   private IDataStoreProvider pr_default ;
   private int[] P00WR3_A3CliCod ;
   private short[] P00WR3_A1EmpCod ;
   private short[] P00WR3_A869LiqLegConAnio ;
   private int[] P00WR3_A6LegNumero ;
   private String[] P00WR3_A26ConCodigo ;
   private int[] P00WR3_A1097LiqAltaNro ;
   private int[] P00WR3_A1098LiqNuevaNro ;
   private java.math.BigDecimal[] P00WR3_A1148LiqLegTotRecal ;
}

final  class newcuentaliqleg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00WR2", "SAVEPOINT gxupdate;INSERT INTO LiqLegConceptoCuenta(CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro, LiqLegConSaldo, LiqLegConPer, LiqLegCodigo, LiqLegPrimera, LiqLegLog, LiqLegCuota, LiqLegTotal, LiqLegTotRecal, LiqLegEsPrrGan) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00WR3", "SELECT CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro, LiqLegTotRecal FROM LiqLegConceptoCuenta WHERE CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ? and ConCodigo = ( ?) and LiqAltaNro = ? and LiqNuevaNro = ? ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo, LiqAltaNro, LiqNuevaNro  FOR UPDATE OF LiqLegConceptoCuenta",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00WR4", "SAVEPOINT gxupdate;UPDATE LiqLegConceptoCuenta SET LiqLegTotRecal=?  WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.DATE );
               }
               else
               {
                  stmt.setDate(9, (java.util.Date)parms[9]);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[11]).shortValue());
               }
               stmt.setBoolean(11, ((Boolean) parms[12]).booleanValue());
               stmt.setVarchar(12, (String)parms[13], 1000, false);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[16], 2);
               stmt.setBoolean(16, ((Boolean) parms[17]).booleanValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
            case 2 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
               return;
      }
   }

}

