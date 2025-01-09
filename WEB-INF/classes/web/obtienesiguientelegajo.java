package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtienesiguientelegajo extends GXProcedure
{
   public obtienesiguientelegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtienesiguientelegajo.class ), "" );
   }

   public obtienesiguientelegajo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 )
   {
      obtienesiguientelegajo.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int[] aP2 )
   {
      obtienesiguientelegajo.this.AV8CliCod = aP0;
      obtienesiguientelegajo.this.AV9EmpCod = aP1;
      obtienesiguientelegajo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P001G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P001G2_A3CliCod[0] ;
         A1EmpCod = P001G2_A1EmpCod[0] ;
         A6LegNumero = P001G2_A6LegNumero[0] ;
         AV10LegNumero = A6LegNumero ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV10LegNumero = (int)(AV10LegNumero+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = obtienesiguientelegajo.this.AV10LegNumero;
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
      P001G2_A3CliCod = new int[1] ;
      P001G2_A1EmpCod = new short[1] ;
      P001G2_A6LegNumero = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtienesiguientelegajo__default(),
         new Object[] {
             new Object[] {
            P001G2_A3CliCod, P001G2_A1EmpCod, P001G2_A6LegNumero
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P001G2_A3CliCod ;
   private short[] P001G2_A1EmpCod ;
   private int[] P001G2_A6LegNumero ;
}

final  class obtienesiguientelegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001G2", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, LegNumero DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
      }
   }

}

