package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class licccgetsaldodisponible extends GXProcedure
{
   public licccgetsaldodisponible( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( licccgetsaldodisponible.class ), "" );
   }

   public licccgetsaldodisponible( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            String aP3 ,
                            short aP4 )
   {
      licccgetsaldodisponible.this.aP5 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        short[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             short[] aP5 )
   {
      licccgetsaldodisponible.this.AV8CliCod = aP0;
      licccgetsaldodisponible.this.AV9EmpCod = aP1;
      licccgetsaldodisponible.this.AV13LegNumero = aP2;
      licccgetsaldodisponible.this.AV11LegCuenLicTpo = aP3;
      licccgetsaldodisponible.this.AV10LegCuenAnio = aP4;
      licccgetsaldodisponible.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02A92 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV13LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV10LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02A92_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02A92_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02A92_A6LegNumero[0] ;
         A1EmpCod = P02A92_A1EmpCod[0] ;
         A3CliCod = P02A92_A3CliCod[0] ;
         A2305LegCuLiPSaldo = P02A92_A2305LegCuLiPSaldo[0] ;
         AV12LegCuLiPSaldo = A2305LegCuLiPSaldo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = licccgetsaldodisponible.this.AV12LegCuLiPSaldo;
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
      P02A92_A2266LegCuenAnio = new short[1] ;
      P02A92_A2243LegCuenLicTpo = new String[] {""} ;
      P02A92_A6LegNumero = new int[1] ;
      P02A92_A1EmpCod = new short[1] ;
      P02A92_A3CliCod = new int[1] ;
      P02A92_A2305LegCuLiPSaldo = new short[1] ;
      A2243LegCuenLicTpo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.licccgetsaldodisponible__default(),
         new Object[] {
             new Object[] {
            P02A92_A2266LegCuenAnio, P02A92_A2243LegCuenLicTpo, P02A92_A6LegNumero, P02A92_A1EmpCod, P02A92_A3CliCod, P02A92_A2305LegCuLiPSaldo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV10LegCuenAnio ;
   private short AV12LegCuLiPSaldo ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2305LegCuLiPSaldo ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV13LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV11LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private short[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02A92_A2266LegCuenAnio ;
   private String[] P02A92_A2243LegCuenLicTpo ;
   private int[] P02A92_A6LegNumero ;
   private short[] P02A92_A1EmpCod ;
   private int[] P02A92_A3CliCod ;
   private short[] P02A92_A2305LegCuLiPSaldo ;
}

final  class licccgetsaldodisponible__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02A92", "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuLiPSaldo FROM legajo_cuenta_licencias WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
      }
   }

}

