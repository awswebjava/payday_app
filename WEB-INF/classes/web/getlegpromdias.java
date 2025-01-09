package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegpromdias extends GXProcedure
{
   public getlegpromdias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegpromdias.class ), "" );
   }

   public getlegpromdias( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getlegpromdias.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      getlegpromdias.this.AV10CliCod = aP0;
      getlegpromdias.this.AV9EmpCod = aP1;
      getlegpromdias.this.AV8LegNumero = aP2;
      getlegpromdias.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01LC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01LC2_A6LegNumero[0] ;
         A1EmpCod = P01LC2_A1EmpCod[0] ;
         A3CliCod = P01LC2_A3CliCod[0] ;
         A1759LegPromDias = P01LC2_A1759LegPromDias[0] ;
         AV11LegPromDias = A1759LegPromDias ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegpromdias.this.AV11LegPromDias;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LegPromDias = "" ;
      scmdbuf = "" ;
      P01LC2_A6LegNumero = new int[1] ;
      P01LC2_A1EmpCod = new short[1] ;
      P01LC2_A3CliCod = new int[1] ;
      P01LC2_A1759LegPromDias = new String[] {""} ;
      A1759LegPromDias = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegpromdias__default(),
         new Object[] {
             new Object[] {
            P01LC2_A6LegNumero, P01LC2_A1EmpCod, P01LC2_A3CliCod, P01LC2_A1759LegPromDias
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV11LegPromDias ;
   private String A1759LegPromDias ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01LC2_A6LegNumero ;
   private short[] P01LC2_A1EmpCod ;
   private int[] P01LC2_A3CliCod ;
   private String[] P01LC2_A1759LegPromDias ;
}

final  class getlegpromdias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01LC2", "SELECT LegNumero, EmpCod, CliCod, LegPromDias FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
               return;
      }
   }

}

