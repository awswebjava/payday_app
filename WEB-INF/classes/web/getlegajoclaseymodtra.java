package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajoclaseymodtra extends GXProcedure
{
   public getlegajoclaseymodtra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajoclaseymodtra.class ), "" );
   }

   public getlegajoclaseymodtra( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte[] aP3 )
   {
      getlegajoclaseymodtra.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte[] aP3 ,
                             String[] aP4 )
   {
      getlegajoclaseymodtra.this.AV11CliCod = aP0;
      getlegajoclaseymodtra.this.AV10EmpCod = aP1;
      getlegajoclaseymodtra.this.AV9LegNumero = aP2;
      getlegajoclaseymodtra.this.aP3 = aP3;
      getlegajoclaseymodtra.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02L62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P02L62_A6LegNumero[0] ;
         A1EmpCod = P02L62_A1EmpCod[0] ;
         A3CliCod = P02L62_A3CliCod[0] ;
         A235LegClase = P02L62_A235LegClase[0] ;
         A2404LegModTra = P02L62_A2404LegModTra[0] ;
         AV8LegClase = A235LegClase ;
         AV12LegModTra = A2404LegModTra ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlegajoclaseymodtra.this.AV8LegClase;
      this.aP4[0] = getlegajoclaseymodtra.this.AV12LegModTra;
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
      P02L62_A6LegNumero = new int[1] ;
      P02L62_A1EmpCod = new short[1] ;
      P02L62_A3CliCod = new int[1] ;
      P02L62_A235LegClase = new byte[1] ;
      P02L62_A2404LegModTra = new String[] {""} ;
      A2404LegModTra = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlegajoclaseymodtra__default(),
         new Object[] {
             new Object[] {
            P02L62_A6LegNumero, P02L62_A1EmpCod, P02L62_A3CliCod, P02L62_A235LegClase, P02L62_A2404LegModTra
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LegClase ;
   private byte A235LegClase ;
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
   private String[] aP4 ;
   private byte[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02L62_A6LegNumero ;
   private short[] P02L62_A1EmpCod ;
   private int[] P02L62_A3CliCod ;
   private byte[] P02L62_A235LegClase ;
   private String[] P02L62_A2404LegModTra ;
}

final  class getlegajoclaseymodtra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02L62", "SELECT LegNumero, EmpCod, CliCod, LegClase, LegModTra FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
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

