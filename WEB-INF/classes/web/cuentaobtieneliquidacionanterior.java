package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class cuentaobtieneliquidacionanterior extends GXProcedure
{
   public cuentaobtieneliquidacionanterior( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( cuentaobtieneliquidacionanterior.class ), "" );
   }

   public cuentaobtieneliquidacionanterior( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          short aP2 ,
                          int aP3 ,
                          int aP4 ,
                          boolean aP5 )
   {
      cuentaobtieneliquidacionanterior.this.aP6 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        int aP3 ,
                        int aP4 ,
                        boolean aP5 ,
                        int[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             boolean aP5 ,
                             int[] aP6 )
   {
      cuentaobtieneliquidacionanterior.this.AV8CliCod = aP0;
      cuentaobtieneliquidacionanterior.this.AV9EmpCod = aP1;
      cuentaobtieneliquidacionanterior.this.AV10LiqLegConAnio = aP2;
      cuentaobtieneliquidacionanterior.this.AV11LegNumero = aP3;
      cuentaobtieneliquidacionanterior.this.AV12LiqNro = aP4;
      cuentaobtieneliquidacionanterior.this.AV13LiqLegEsPrrGan = aP5;
      cuentaobtieneliquidacionanterior.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18GXLvl1 = (byte)(0) ;
      /* Using cursor P01LW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Short.valueOf(AV10LiqLegConAnio), Integer.valueOf(AV11LegNumero), Integer.valueOf(AV12LiqNro), Boolean.valueOf(AV13LiqLegEsPrrGan)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1778LiqLegEsPrrGan = P01LW2_A1778LiqLegEsPrrGan[0] ;
         A1098LiqNuevaNro = P01LW2_A1098LiqNuevaNro[0] ;
         A6LegNumero = P01LW2_A6LegNumero[0] ;
         A869LiqLegConAnio = P01LW2_A869LiqLegConAnio[0] ;
         A1EmpCod = P01LW2_A1EmpCod[0] ;
         A3CliCod = P01LW2_A3CliCod[0] ;
         A26ConCodigo = P01LW2_A26ConCodigo[0] ;
         A1097LiqAltaNro = P01LW2_A1097LiqAltaNro[0] ;
         AV18GXLvl1 = (byte)(1) ;
         AV15anteriorLiqNro = A1098LiqNuevaNro ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV18GXLvl1 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "none ", "")) ;
         AV14LiqDLog += httpContext.getMessage( ". none", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = cuentaobtieneliquidacionanterior.this.AV15anteriorLiqNro;
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
      P01LW2_A1778LiqLegEsPrrGan = new boolean[] {false} ;
      P01LW2_A1098LiqNuevaNro = new int[1] ;
      P01LW2_A6LegNumero = new int[1] ;
      P01LW2_A869LiqLegConAnio = new short[1] ;
      P01LW2_A1EmpCod = new short[1] ;
      P01LW2_A3CliCod = new int[1] ;
      P01LW2_A26ConCodigo = new String[] {""} ;
      P01LW2_A1097LiqAltaNro = new int[1] ;
      A26ConCodigo = "" ;
      AV19Pgmname = "" ;
      AV14LiqDLog = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.cuentaobtieneliquidacionanterior__default(),
         new Object[] {
             new Object[] {
            P01LW2_A1778LiqLegEsPrrGan, P01LW2_A1098LiqNuevaNro, P01LW2_A6LegNumero, P01LW2_A869LiqLegConAnio, P01LW2_A1EmpCod, P01LW2_A3CliCod, P01LW2_A26ConCodigo, P01LW2_A1097LiqAltaNro
            }
         }
      );
      AV19Pgmname = "cuentaObtieneLiquidacionAnterior" ;
      /* GeneXus formulas. */
      AV19Pgmname = "cuentaObtieneLiquidacionAnterior" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl1 ;
   private short AV9EmpCod ;
   private short AV10LiqLegConAnio ;
   private short A869LiqLegConAnio ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LegNumero ;
   private int AV12LiqNro ;
   private int AV15anteriorLiqNro ;
   private int A1098LiqNuevaNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int A1097LiqAltaNro ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV19Pgmname ;
   private boolean AV13LiqLegEsPrrGan ;
   private boolean A1778LiqLegEsPrrGan ;
   private String AV14LiqDLog ;
   private int[] aP6 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01LW2_A1778LiqLegEsPrrGan ;
   private int[] P01LW2_A1098LiqNuevaNro ;
   private int[] P01LW2_A6LegNumero ;
   private short[] P01LW2_A869LiqLegConAnio ;
   private short[] P01LW2_A1EmpCod ;
   private int[] P01LW2_A3CliCod ;
   private String[] P01LW2_A26ConCodigo ;
   private int[] P01LW2_A1097LiqAltaNro ;
}

final  class cuentaobtieneliquidacionanterior__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LW2", "SELECT LiqLegEsPrrGan, LiqNuevaNro, LegNumero, LiqLegConAnio, EmpCod, CliCod, ConCodigo, LiqAltaNro FROM LiqLegConceptoCuenta WHERE (CliCod = ? and EmpCod = ? and LiqLegConAnio = ? and LegNumero = ? and LiqNuevaNro < ?) AND (LiqLegEsPrrGan = ?) ORDER BY CliCod, EmpCod, LiqLegConAnio, LegNumero, LiqNuevaNro DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[6])[0] = rslt.getString(7, 10);
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
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               return;
      }
   }

}

