package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class destildargananciasfamiliares extends GXProcedure
{
   public destildargananciasfamiliares( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( destildargananciasfamiliares.class ), "" );
   }

   public destildargananciasfamiliares( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      destildargananciasfamiliares.this.AV10CliCod = aP0;
      destildargananciasfamiliares.this.AV9EmpCod = aP1;
      destildargananciasfamiliares.this.AV8LegNumero = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00RW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00RW2_A6LegNumero[0] ;
         A1EmpCod = P00RW2_A1EmpCod[0] ;
         A3CliCod = P00RW2_A3CliCod[0] ;
         A83LegDedSec = P00RW2_A83LegDedSec[0] ;
         O220FamTomaDeducImpGan = A220FamTomaDeducImpGan ;
         A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
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
      P00RW2_A6LegNumero = new int[1] ;
      P00RW2_A1EmpCod = new short[1] ;
      P00RW2_A3CliCod = new int[1] ;
      P00RW2_A83LegDedSec = new int[1] ;
      O220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      A220FamTomaDeducImpGan = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.destildargananciasfamiliares__default(),
         new Object[] {
             new Object[] {
            P00RW2_A6LegNumero, P00RW2_A1EmpCod, P00RW2_A3CliCod, P00RW2_A83LegDedSec
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
   private int A83LegDedSec ;
   private java.math.BigDecimal O220FamTomaDeducImpGan ;
   private java.math.BigDecimal A220FamTomaDeducImpGan ;
   private String scmdbuf ;
   private IDataStoreProvider pr_default ;
   private int[] P00RW2_A6LegNumero ;
   private short[] P00RW2_A1EmpCod ;
   private int[] P00RW2_A3CliCod ;
   private int[] P00RW2_A83LegDedSec ;
}

final  class destildargananciasfamiliares__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00RW2", "SELECT LegNumero, EmpCod, CliCod, LegDedSec FROM legajo_deducciones WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
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

