package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class resetearcuenta extends GXProcedure
{
   public resetearcuenta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( resetearcuenta.class ), "" );
   }

   public resetearcuenta( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        java.util.Date aP4 ,
                        int aP5 ,
                        String aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             java.util.Date aP4 ,
                             int aP5 ,
                             String aP6 )
   {
      resetearcuenta.this.AV8CliCod = aP0;
      resetearcuenta.this.AV17EmpCod = aP1;
      resetearcuenta.this.AV19LiqNro = aP2;
      resetearcuenta.this.AV9LiqLegConAnio = aP3;
      resetearcuenta.this.AV18LiqPeriodo = aP4;
      resetearcuenta.this.AV14Legnumero = aP5;
      resetearcuenta.this.AV10ConCodigo = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV12pagosACuentaConCodigo ;
      GXt_char2 = AV12pagosACuentaConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      resetearcuenta.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      resetearcuenta.this.GXt_char1 = GXv_char4[0] ;
      AV12pagosACuentaConCodigo = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "llama...", "")) ;
      GXt_decimal5 = AV11LiqLegConSaldo ;
      GXv_boolean6[0] = false ;
      GXv_decimal7[0] = GXt_decimal5 ;
      new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV17EmpCod, 0, AV14Legnumero, "[monto_siradig]", AV18LiqPeriodo, AV12pagosACuentaConCodigo, true, (byte)(0), "", false, GXv_boolean6, GXv_decimal7) ;
      resetearcuenta.this.GXt_decimal5 = GXv_decimal7[0] ;
      AV11LiqLegConSaldo = GXt_decimal5 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV24Pgmname, httpContext.getMessage( "&LiqLegConSaldo ", "")+GXutil.trim( GXutil.str( AV11LiqLegConSaldo, 14, 2))) ;
      AV25GXLvl9 = (byte)(0) ;
      /* Using cursor P00VD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV17EmpCod), Short.valueOf(AV9LiqLegConAnio), Integer.valueOf(AV14Legnumero), AV10ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00VD2_A26ConCodigo[0] ;
         A6LegNumero = P00VD2_A6LegNumero[0] ;
         A869LiqLegConAnio = P00VD2_A869LiqLegConAnio[0] ;
         A1EmpCod = P00VD2_A1EmpCod[0] ;
         A3CliCod = P00VD2_A3CliCod[0] ;
         A868LiqLegConSaldo = P00VD2_A868LiqLegConSaldo[0] ;
         A1097LiqAltaNro = P00VD2_A1097LiqAltaNro[0] ;
         A1098LiqNuevaNro = P00VD2_A1098LiqNuevaNro[0] ;
         AV25GXLvl9 = (byte)(1) ;
         A868LiqLegConSaldo = AV11LiqLegConSaldo ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P00VD3 */
         pr_default.execute(1, new Object[] {A868LiqLegConSaldo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
         if (true) break;
         /* Using cursor P00VD4 */
         pr_default.execute(2, new Object[] {A868LiqLegConSaldo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV25GXLvl9 == 0 )
      {
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV11LiqLegConSaldo)==0) )
         {
            GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
            new web.newcuentaliqleg(remoteHandle, context).execute( AV8CliCod, AV17EmpCod, AV9LiqLegConAnio, AV19LiqNro, AV19LiqNro, AV14Legnumero, AV10ConCodigo, (short)(0), AV11LiqLegConSaldo, DecimalUtil.doubleToDec(0), AV18LiqPeriodo, true, false, "Calculo", GXv_decimal7) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "resetearcuenta");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12pagosACuentaConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV24Pgmname = "" ;
      AV11LiqLegConSaldo = DecimalUtil.ZERO ;
      GXt_decimal5 = DecimalUtil.ZERO ;
      GXv_boolean6 = new boolean[1] ;
      scmdbuf = "" ;
      P00VD2_A26ConCodigo = new String[] {""} ;
      P00VD2_A6LegNumero = new int[1] ;
      P00VD2_A869LiqLegConAnio = new short[1] ;
      P00VD2_A1EmpCod = new short[1] ;
      P00VD2_A3CliCod = new int[1] ;
      P00VD2_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00VD2_A1097LiqAltaNro = new int[1] ;
      P00VD2_A1098LiqNuevaNro = new int[1] ;
      A26ConCodigo = "" ;
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.resetearcuenta__default(),
         new Object[] {
             new Object[] {
            P00VD2_A26ConCodigo, P00VD2_A6LegNumero, P00VD2_A869LiqLegConAnio, P00VD2_A1EmpCod, P00VD2_A3CliCod, P00VD2_A868LiqLegConSaldo, P00VD2_A1097LiqAltaNro, P00VD2_A1098LiqNuevaNro
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV24Pgmname = "ResetearCuenta" ;
      /* GeneXus formulas. */
      AV24Pgmname = "ResetearCuenta" ;
      Gx_err = (short)(0) ;
   }

   private byte AV25GXLvl9 ;
   private short AV17EmpCod ;
   private short AV9LiqLegConAnio ;
   private short A869LiqLegConAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV19LiqNro ;
   private int AV14Legnumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1097LiqAltaNro ;
   private int A1098LiqNuevaNro ;
   private java.math.BigDecimal AV11LiqLegConSaldo ;
   private java.math.BigDecimal GXt_decimal5 ;
   private java.math.BigDecimal A868LiqLegConSaldo ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV10ConCodigo ;
   private String AV12pagosACuentaConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV24Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private java.util.Date AV18LiqPeriodo ;
   private boolean GXv_boolean6[] ;
   private IDataStoreProvider pr_default ;
   private String[] P00VD2_A26ConCodigo ;
   private int[] P00VD2_A6LegNumero ;
   private short[] P00VD2_A869LiqLegConAnio ;
   private short[] P00VD2_A1EmpCod ;
   private int[] P00VD2_A3CliCod ;
   private java.math.BigDecimal[] P00VD2_A868LiqLegConSaldo ;
   private int[] P00VD2_A1097LiqAltaNro ;
   private int[] P00VD2_A1098LiqNuevaNro ;
}

final  class resetearcuenta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00VD2", "SELECT ConCodigo, LegNumero, LiqLegConAnio, EmpCod, CliCod, LiqLegConSaldo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ? and ConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo  LIMIT 1 FOR UPDATE OF LiqLegConceptoCuenta",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00VD3", "SAVEPOINT gxupdate;UPDATE LiqLegConceptoCuenta SET LiqLegConSaldo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00VD4", "SAVEPOINT gxupdate;UPDATE LiqLegConceptoCuenta SET LiqLegConSaldo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((int[]) buf[7])[0] = rslt.getInt(8);
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
               return;
            case 1 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setInt(8, ((Number) parms[7]).intValue());
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

