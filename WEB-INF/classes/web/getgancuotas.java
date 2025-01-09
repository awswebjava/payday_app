package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getgancuotas extends GXProcedure
{
   public getgancuotas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getgancuotas.class ), "" );
   }

   public getgancuotas( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      getgancuotas.this.aP3 = new short[] {0};
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
      getgancuotas.this.AV11CliCod = aP0;
      getgancuotas.this.AV8EmpCod = aP1;
      getgancuotas.this.AV9LiqNro = aP2;
      getgancuotas.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00JE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00JE2_A31LiqNro[0] ;
         A1EmpCod = P00JE2_A1EmpCod[0] ;
         A3CliCod = P00JE2_A3CliCod[0] ;
         A283LiqPeriodo = P00JE2_A283LiqPeriodo[0] ;
         AV10cantCuotas = (short)(13-GXutil.month( A283LiqPeriodo)) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getgancuotas.this.AV10cantCuotas;
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
      P00JE2_A31LiqNro = new int[1] ;
      P00JE2_A1EmpCod = new short[1] ;
      P00JE2_A3CliCod = new int[1] ;
      P00JE2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      A283LiqPeriodo = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getgancuotas__default(),
         new Object[] {
             new Object[] {
            P00JE2_A31LiqNro, P00JE2_A1EmpCod, P00JE2_A3CliCod, P00JE2_A283LiqPeriodo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short AV10cantCuotas ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date A283LiqPeriodo ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00JE2_A31LiqNro ;
   private short[] P00JE2_A1EmpCod ;
   private int[] P00JE2_A3CliCod ;
   private java.util.Date[] P00JE2_A283LiqPeriodo ;
}

final  class getgancuotas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00JE2", "SELECT LiqNro, EmpCod, CliCod, LiqPeriodo FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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

