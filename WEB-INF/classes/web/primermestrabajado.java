package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class primermestrabajado extends GXProcedure
{
   public primermestrabajado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( primermestrabajado.class ), "" );
   }

   public primermestrabajado( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           java.util.Date aP3 )
   {
      primermestrabajado.this.aP4 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        byte[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             byte[] aP4 )
   {
      primermestrabajado.this.AV10CliCod = aP0;
      primermestrabajado.this.AV9EmpCod = aP1;
      primermestrabajado.this.AV8LegNumero = aP2;
      primermestrabajado.this.AV11fecha = aP3;
      primermestrabajado.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12comienzoDeAnioFecha = localUtil.ymdtod( GXutil.year( AV11fecha), 1, 31) ;
      /* Using cursor P00QS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00QS2_A6LegNumero[0] ;
         A1EmpCod = P00QS2_A1EmpCod[0] ;
         A3CliCod = P00QS2_A3CliCod[0] ;
         A245LegFecIngreso = P00QS2_A245LegFecIngreso[0] ;
         if ( (( GXutil.resetTime(A245LegFecIngreso).before( GXutil.resetTime( AV12comienzoDeAnioFecha )) ) || ( GXutil.dateCompare(GXutil.resetTime(A245LegFecIngreso), GXutil.resetTime(AV12comienzoDeAnioFecha)) )) )
         {
            AV13mes = (byte)(1) ;
         }
         else
         {
            AV13mes = (byte)(GXutil.month( A245LegFecIngreso)) ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = primermestrabajado.this.AV13mes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12comienzoDeAnioFecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00QS2_A6LegNumero = new int[1] ;
      P00QS2_A1EmpCod = new short[1] ;
      P00QS2_A3CliCod = new int[1] ;
      P00QS2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      A245LegFecIngreso = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.primermestrabajado__default(),
         new Object[] {
             new Object[] {
            P00QS2_A6LegNumero, P00QS2_A1EmpCod, P00QS2_A3CliCod, P00QS2_A245LegFecIngreso
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13mes ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String scmdbuf ;
   private java.util.Date AV11fecha ;
   private java.util.Date AV12comienzoDeAnioFecha ;
   private java.util.Date A245LegFecIngreso ;
   private byte[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00QS2_A6LegNumero ;
   private short[] P00QS2_A1EmpCod ;
   private int[] P00QS2_A3CliCod ;
   private java.util.Date[] P00QS2_A245LegFecIngreso ;
}

final  class primermestrabajado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00QS2", "SELECT LegNumero, EmpCod, CliCod, LegFecIngreso FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

