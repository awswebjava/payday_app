package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legsuelhayconcepto extends GXProcedure
{
   public legsuelhayconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legsuelhayconcepto.class ), "" );
   }

   public legsuelhayconcepto( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              short aP3 ,
                              String aP4 )
   {
      legsuelhayconcepto.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             boolean[] aP5 )
   {
      legsuelhayconcepto.this.AV13CliCod = aP0;
      legsuelhayconcepto.this.AV12EmpCod = aP1;
      legsuelhayconcepto.this.AV11LegNumero = aP2;
      legsuelhayconcepto.this.AV8LegSuelSec = aP3;
      legsuelhayconcepto.this.AV9LegSuelConcepto = aP4;
      legsuelhayconcepto.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02DC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV11LegNumero), Short.valueOf(AV8LegSuelSec), AV9LegSuelConcepto});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2349LegSuelConcepto = P02DC2_A2349LegSuelConcepto[0] ;
         A1135LegSuelSec = P02DC2_A1135LegSuelSec[0] ;
         A6LegNumero = P02DC2_A6LegNumero[0] ;
         A1EmpCod = P02DC2_A1EmpCod[0] ;
         A3CliCod = P02DC2_A3CliCod[0] ;
         AV10hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = legsuelhayconcepto.this.AV10hay;
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
      P02DC2_A2349LegSuelConcepto = new String[] {""} ;
      P02DC2_A1135LegSuelSec = new short[1] ;
      P02DC2_A6LegNumero = new int[1] ;
      P02DC2_A1EmpCod = new short[1] ;
      P02DC2_A3CliCod = new int[1] ;
      A2349LegSuelConcepto = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legsuelhayconcepto__default(),
         new Object[] {
             new Object[] {
            P02DC2_A2349LegSuelConcepto, P02DC2_A1135LegSuelSec, P02DC2_A6LegNumero, P02DC2_A1EmpCod, P02DC2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short AV8LegSuelSec ;
   private short A1135LegSuelSec ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV9LegSuelConcepto ;
   private String scmdbuf ;
   private String A2349LegSuelConcepto ;
   private boolean AV10hay ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private String[] P02DC2_A2349LegSuelConcepto ;
   private short[] P02DC2_A1135LegSuelSec ;
   private int[] P02DC2_A6LegNumero ;
   private short[] P02DC2_A1EmpCod ;
   private int[] P02DC2_A3CliCod ;
}

final  class legsuelhayconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02DC2", "SELECT LegSuelConcepto, LegSuelSec, LegNumero, EmpCod, CliCod FROM Legajo_sueldosConceptos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegSuelSec = ? and LegSuelConcepto = ( ?) ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec, LegSuelConcepto  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
      }
   }

}

