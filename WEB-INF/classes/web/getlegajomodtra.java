package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajomodtra extends GXProcedure
{
   public getlegajomodtra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajomodtra.class ), "" );
   }

   public getlegajomodtra( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      getlegajomodtra.this.aP3 = new String[] {""};
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
      getlegajomodtra.this.AV11CliCod = aP0;
      getlegajomodtra.this.AV10EmpCod = aP1;
      getlegajomodtra.this.AV9LegNumero = aP2;
      getlegajomodtra.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02L52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02L52_A6LegNumero[0] ;
         A1EmpCod = P02L52_A1EmpCod[0] ;
         A3CliCod = P02L52_A3CliCod[0] ;
         A2404LegModTra = P02L52_A2404LegModTra[0] ;
         AV12LegModTra = A2404LegModTra ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegajomodtra.this.AV12LegModTra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegModTra = "" ;
      scmdbuf = "" ;
      P02L52_A6LegNumero = new int[1] ;
      P02L52_A1EmpCod = new short[1] ;
      P02L52_A3CliCod = new int[1] ;
      P02L52_A2404LegModTra = new String[] {""} ;
      A2404LegModTra = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajomodtra__default(),
         new Object[] {
             new Object[] {
            P02L52_A6LegNumero, P02L52_A1EmpCod, P02L52_A3CliCod, P02L52_A2404LegModTra
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV12LegModTra ;
   private String scmdbuf ;
   private String A2404LegModTra ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02L52_A6LegNumero ;
   private short[] P02L52_A1EmpCod ;
   private int[] P02L52_A3CliCod ;
   private String[] P02L52_A2404LegModTra ;
}

final  class getlegajomodtra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02L52", "SELECT LegNumero, EmpCod, CliCod, LegModTra FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
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

