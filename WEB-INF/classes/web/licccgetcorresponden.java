package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class licccgetcorresponden extends GXProcedure
{
   public licccgetcorresponden( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( licccgetcorresponden.class ), "" );
   }

   public licccgetcorresponden( int remoteHandle ,
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
      licccgetcorresponden.this.aP5 = new short[] {0};
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
      licccgetcorresponden.this.AV13CliCod = aP0;
      licccgetcorresponden.this.AV12EmpCod = aP1;
      licccgetcorresponden.this.AV11LegNumero = aP2;
      licccgetcorresponden.this.AV10LegCuenLicTpo = aP3;
      licccgetcorresponden.this.AV9LegCuenAnio = aP4;
      licccgetcorresponden.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02C82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LegNumero), AV10LegCuenLicTpo, Short.valueOf(AV9LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02C82_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02C82_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02C82_A6LegNumero[0] ;
         A1EmpCod = P02C82_A1EmpCod[0] ;
         A3CliCod = P02C82_A3CliCod[0] ;
         A2247LegCuenDiasCorres = P02C82_A2247LegCuenDiasCorres[0] ;
         AV8LegCuenDiasCorres = A2247LegCuenDiasCorres ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = licccgetcorresponden.this.AV8LegCuenDiasCorres;
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
      P02C82_A2266LegCuenAnio = new short[1] ;
      P02C82_A2243LegCuenLicTpo = new String[] {""} ;
      P02C82_A6LegNumero = new int[1] ;
      P02C82_A1EmpCod = new short[1] ;
      P02C82_A3CliCod = new int[1] ;
      P02C82_A2247LegCuenDiasCorres = new short[1] ;
      A2243LegCuenLicTpo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.licccgetcorresponden__default(),
         new Object[] {
             new Object[] {
            P02C82_A2266LegCuenAnio, P02C82_A2243LegCuenLicTpo, P02C82_A6LegNumero, P02C82_A1EmpCod, P02C82_A3CliCod, P02C82_A2247LegCuenDiasCorres
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV9LegCuenAnio ;
   private short AV8LegCuenDiasCorres ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2247LegCuenDiasCorres ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV10LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private short[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02C82_A2266LegCuenAnio ;
   private String[] P02C82_A2243LegCuenLicTpo ;
   private int[] P02C82_A6LegNumero ;
   private short[] P02C82_A1EmpCod ;
   private int[] P02C82_A3CliCod ;
   private short[] P02C82_A2247LegCuenDiasCorres ;
}

final  class licccgetcorresponden__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02C82", "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCuenDiasCorres FROM legajo_cuenta_licencias WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

