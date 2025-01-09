package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ultimolegajosuelsec extends GXProcedure
{
   public ultimolegajosuelsec( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ultimolegajosuelsec.class ), "" );
   }

   public ultimolegajosuelsec( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      ultimolegajosuelsec.this.aP3 = new short[] {0};
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
      ultimolegajosuelsec.this.AV12CliCod = aP0;
      ultimolegajosuelsec.this.AV9EmpCod = aP1;
      ultimolegajosuelsec.this.AV10LegNumero = aP2;
      ultimolegajosuelsec.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P018G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P018G2_A3CliCod[0] ;
         A1EmpCod = P018G2_A1EmpCod[0] ;
         A6LegNumero = P018G2_A6LegNumero[0] ;
         A1135LegSuelSec = P018G2_A1135LegSuelSec[0] ;
         AV11LegSuelSec = A1135LegSuelSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV11LegSuelSec = (short)(AV11LegSuelSec+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = ultimolegajosuelsec.this.AV11LegSuelSec;
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
      P018G2_A3CliCod = new int[1] ;
      P018G2_A1EmpCod = new short[1] ;
      P018G2_A6LegNumero = new int[1] ;
      P018G2_A1135LegSuelSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ultimolegajosuelsec__default(),
         new Object[] {
             new Object[] {
            P018G2_A3CliCod, P018G2_A1EmpCod, P018G2_A6LegNumero, P018G2_A1135LegSuelSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11LegSuelSec ;
   private short A1EmpCod ;
   private short A1135LegSuelSec ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P018G2_A3CliCod ;
   private short[] P018G2_A1EmpCod ;
   private int[] P018G2_A6LegNumero ;
   private short[] P018G2_A1135LegSuelSec ;
}

final  class ultimolegajosuelsec__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P018G2", "SELECT CliCod, EmpCod, LegNumero, LegSuelSec FROM legajo_sueldos WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero, LegSuelSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

