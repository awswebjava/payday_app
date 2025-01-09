package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class licccsugieredias extends GXProcedure
{
   public licccsugieredias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( licccsugieredias.class ), "" );
   }

   public licccsugieredias( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             short[] aP5 )
   {
      licccsugieredias.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short aP4 ,
                        short[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short aP4 ,
                             short[] aP5 ,
                             String[] aP6 )
   {
      licccsugieredias.this.AV8CliCod = aP0;
      licccsugieredias.this.AV9EmpCod = aP1;
      licccsugieredias.this.AV10LegNumero = aP2;
      licccsugieredias.this.AV11LegCuenLicTpo = aP3;
      licccsugieredias.this.AV12LegCuenAnio = aP4;
      licccsugieredias.this.aP5 = aP5;
      licccsugieredias.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02C42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero), AV11LegCuenLicTpo, Short.valueOf(AV12LegCuenAnio)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2266LegCuenAnio = P02C42_A2266LegCuenAnio[0] ;
         A2243LegCuenLicTpo = P02C42_A2243LegCuenLicTpo[0] ;
         A6LegNumero = P02C42_A6LegNumero[0] ;
         A1EmpCod = P02C42_A1EmpCod[0] ;
         A3CliCod = P02C42_A3CliCod[0] ;
         A2301LegCueAntTexto = P02C42_A2301LegCueAntTexto[0] ;
         A2305LegCuLiPSaldo = P02C42_A2305LegCuLiPSaldo[0] ;
         A2247LegCuenDiasCorres = P02C42_A2247LegCuenDiasCorres[0] ;
         AV13LiqDLog = GXutil.trim( A2301LegCueAntTexto) ;
         AV13LiqDLog += httpContext.getMessage( ". Total disponible: ", "") + GXutil.trim( GXutil.str( A2305LegCuLiPSaldo, 4, 0)) ;
         if ( A2305LegCuLiPSaldo <= A2247LegCuenDiasCorres )
         {
            AV14LegCuLiPSaldo = A2305LegCuLiPSaldo ;
         }
         else
         {
            AV14LegCuLiPSaldo = A2247LegCuenDiasCorres ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = licccsugieredias.this.AV14LegCuLiPSaldo;
      this.aP6[0] = licccsugieredias.this.AV13LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13LiqDLog = "" ;
      scmdbuf = "" ;
      P02C42_A2266LegCuenAnio = new short[1] ;
      P02C42_A2243LegCuenLicTpo = new String[] {""} ;
      P02C42_A6LegNumero = new int[1] ;
      P02C42_A1EmpCod = new short[1] ;
      P02C42_A3CliCod = new int[1] ;
      P02C42_A2301LegCueAntTexto = new String[] {""} ;
      P02C42_A2305LegCuLiPSaldo = new short[1] ;
      P02C42_A2247LegCuenDiasCorres = new short[1] ;
      A2243LegCuenLicTpo = "" ;
      A2301LegCueAntTexto = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.licccsugieredias__default(),
         new Object[] {
             new Object[] {
            P02C42_A2266LegCuenAnio, P02C42_A2243LegCuenLicTpo, P02C42_A6LegNumero, P02C42_A1EmpCod, P02C42_A3CliCod, P02C42_A2301LegCueAntTexto, P02C42_A2305LegCuLiPSaldo, P02C42_A2247LegCuenDiasCorres
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV12LegCuenAnio ;
   private short AV14LegCuLiPSaldo ;
   private short A2266LegCuenAnio ;
   private short A1EmpCod ;
   private short A2305LegCuLiPSaldo ;
   private short A2247LegCuenDiasCorres ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV11LegCuenLicTpo ;
   private String scmdbuf ;
   private String A2243LegCuenLicTpo ;
   private String AV13LiqDLog ;
   private String A2301LegCueAntTexto ;
   private String[] aP6 ;
   private short[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P02C42_A2266LegCuenAnio ;
   private String[] P02C42_A2243LegCuenLicTpo ;
   private int[] P02C42_A6LegNumero ;
   private short[] P02C42_A1EmpCod ;
   private int[] P02C42_A3CliCod ;
   private String[] P02C42_A2301LegCueAntTexto ;
   private short[] P02C42_A2305LegCuLiPSaldo ;
   private short[] P02C42_A2247LegCuenDiasCorres ;
}

final  class licccsugieredias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02C42", "SELECT LegCuenAnio, LegCuenLicTpo, LegNumero, EmpCod, CliCod, LegCueAntTexto, LegCuLiPSaldo, LegCuenDiasCorres FROM legajo_cuenta_licencias WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegCuenLicTpo = ( ?) and LegCuenAnio = ? ORDER BY CliCod, EmpCod, LegNumero, LegCuenLicTpo, LegCuenAnio ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
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

