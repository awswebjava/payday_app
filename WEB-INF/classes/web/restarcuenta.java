package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class restarcuenta extends GXProcedure
{
   public restarcuenta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( restarcuenta.class ), "" );
   }

   public restarcuenta( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.math.BigDecimal aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.math.BigDecimal aP5 )
   {
      restarcuenta.this.AV8CliCod = aP0;
      restarcuenta.this.AV15EmpCod = aP1;
      restarcuenta.this.AV9LiqLegConAnio = aP2;
      restarcuenta.this.AV13Legnumero = aP3;
      restarcuenta.this.AV10ConCodigo = aP4;
      restarcuenta.this.AV16Importes = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00VF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV15EmpCod), Short.valueOf(AV9LiqLegConAnio), Integer.valueOf(AV13Legnumero), AV10ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00VF2_A26ConCodigo[0] ;
         A6LegNumero = P00VF2_A6LegNumero[0] ;
         A869LiqLegConAnio = P00VF2_A869LiqLegConAnio[0] ;
         A1EmpCod = P00VF2_A1EmpCod[0] ;
         A3CliCod = P00VF2_A3CliCod[0] ;
         A868LiqLegConSaldo = P00VF2_A868LiqLegConSaldo[0] ;
         A1097LiqAltaNro = P00VF2_A1097LiqAltaNro[0] ;
         A1098LiqNuevaNro = P00VF2_A1098LiqNuevaNro[0] ;
         A868LiqLegConSaldo = A868LiqLegConSaldo.subtract(AV16Importes) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P00VF3 */
         pr_default.execute(1, new Object[] {A868LiqLegConSaldo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
         if (true) break;
         /* Using cursor P00VF4 */
         pr_default.execute(2, new Object[] {A868LiqLegConSaldo, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A869LiqLegConAnio), Integer.valueOf(A6LegNumero), A26ConCodigo, Integer.valueOf(A1097LiqAltaNro), Integer.valueOf(A1098LiqNuevaNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
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
      scmdbuf = "" ;
      P00VF2_A26ConCodigo = new String[] {""} ;
      P00VF2_A6LegNumero = new int[1] ;
      P00VF2_A869LiqLegConAnio = new short[1] ;
      P00VF2_A1EmpCod = new short[1] ;
      P00VF2_A3CliCod = new int[1] ;
      P00VF2_A868LiqLegConSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00VF2_A1097LiqAltaNro = new int[1] ;
      P00VF2_A1098LiqNuevaNro = new int[1] ;
      A26ConCodigo = "" ;
      A868LiqLegConSaldo = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.restarcuenta__default(),
         new Object[] {
             new Object[] {
            P00VF2_A26ConCodigo, P00VF2_A6LegNumero, P00VF2_A869LiqLegConAnio, P00VF2_A1EmpCod, P00VF2_A3CliCod, P00VF2_A868LiqLegConSaldo, P00VF2_A1097LiqAltaNro, P00VF2_A1098LiqNuevaNro
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short AV9LiqLegConAnio ;
   private short A869LiqLegConAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13Legnumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1097LiqAltaNro ;
   private int A1098LiqNuevaNro ;
   private java.math.BigDecimal AV16Importes ;
   private java.math.BigDecimal A868LiqLegConSaldo ;
   private String AV10ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private IDataStoreProvider pr_default ;
   private String[] P00VF2_A26ConCodigo ;
   private int[] P00VF2_A6LegNumero ;
   private short[] P00VF2_A869LiqLegConAnio ;
   private short[] P00VF2_A1EmpCod ;
   private int[] P00VF2_A3CliCod ;
   private java.math.BigDecimal[] P00VF2_A868LiqLegConSaldo ;
   private int[] P00VF2_A1097LiqAltaNro ;
   private int[] P00VF2_A1098LiqNuevaNro ;
}

final  class restarcuenta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00VF2", "SELECT ConCodigo, LegNumero, LiqLegConAnio, EmpCod, CliCod, LiqLegConSaldo, LiqAltaNro, LiqNuevaNro FROM LiqLegConceptoCuenta WHERE CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ? and ConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, ConCodigo  LIMIT 1 FOR UPDATE OF LiqLegConceptoCuenta",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00VF3", "SAVEPOINT gxupdate;UPDATE LiqLegConceptoCuenta SET LiqLegConSaldo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00VF4", "SAVEPOINT gxupdate;UPDATE LiqLegConceptoCuenta SET LiqLegConSaldo=?  WHERE CliCod = ? AND EmpCod = ? AND LiqLegConAnio = ? AND LegNumero = ? AND ConCodigo = ? AND LiqAltaNro = ? AND LiqNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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

