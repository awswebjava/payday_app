package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getestadocivil extends GXProcedure
{
   public getestadocivil( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getestadocivil.class ), "" );
   }

   public getestadocivil( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      getestadocivil.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 )
   {
      getestadocivil.this.AV11CliCod = aP0;
      getestadocivil.this.AV10EmpCod = aP1;
      getestadocivil.this.AV9LegNumero = aP2;
      getestadocivil.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02AQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02AQ2_A6LegNumero[0] ;
         A1EmpCod = P02AQ2_A1EmpCod[0] ;
         A3CliCod = P02AQ2_A3CliCod[0] ;
         A243LegEstadoCivil = P02AQ2_A243LegEstadoCivil[0] ;
         n243LegEstadoCivil = P02AQ2_n243LegEstadoCivil[0] ;
         AV8LegEstadoCivil = A243LegEstadoCivil ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getestadocivil.this.AV8LegEstadoCivil;
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
      P02AQ2_A6LegNumero = new int[1] ;
      P02AQ2_A1EmpCod = new short[1] ;
      P02AQ2_A3CliCod = new int[1] ;
      P02AQ2_A243LegEstadoCivil = new short[1] ;
      P02AQ2_n243LegEstadoCivil = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getestadocivil__default(),
         new Object[] {
             new Object[] {
            P02AQ2_A6LegNumero, P02AQ2_A1EmpCod, P02AQ2_A3CliCod, P02AQ2_A243LegEstadoCivil, P02AQ2_n243LegEstadoCivil
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV8LegEstadoCivil ;
   private short A1EmpCod ;
   private short A243LegEstadoCivil ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean n243LegEstadoCivil ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02AQ2_A6LegNumero ;
   private short[] P02AQ2_A1EmpCod ;
   private int[] P02AQ2_A3CliCod ;
   private short[] P02AQ2_A243LegEstadoCivil ;
   private boolean[] P02AQ2_n243LegEstadoCivil ;
}

final  class getestadocivil__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02AQ2", "SELECT LegNumero, EmpCod, CliCod, LegEstadoCivil FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
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

