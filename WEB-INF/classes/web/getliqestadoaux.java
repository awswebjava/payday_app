package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqestadoaux extends GXProcedure
{
   public getliqestadoaux( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqestadoaux.class ), "" );
   }

   public getliqestadoaux( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 )
   {
      getliqestadoaux.this.aP3 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte[] aP3 )
   {
      getliqestadoaux.this.AV10CliCod = aP0;
      getliqestadoaux.this.AV11EmpCod = aP1;
      getliqestadoaux.this.AV8LiqNro = aP2;
      getliqestadoaux.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01EV2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV8LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P01EV2_A31LiqNro[0] ;
         A1EmpCod = P01EV2_A1EmpCod[0] ;
         A3CliCod = P01EV2_A3CliCod[0] ;
         A1403LiqAuxEstado = P01EV2_A1403LiqAuxEstado[0] ;
         AV12LiqAuxEstado = A1403LiqAuxEstado ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqestadoaux.this.AV12LiqAuxEstado;
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
      P01EV2_A31LiqNro = new int[1] ;
      P01EV2_A1EmpCod = new short[1] ;
      P01EV2_A3CliCod = new int[1] ;
      P01EV2_A1403LiqAuxEstado = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqestadoaux__default(),
         new Object[] {
             new Object[] {
            P01EV2_A31LiqNro, P01EV2_A1EmpCod, P01EV2_A3CliCod, P01EV2_A1403LiqAuxEstado
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12LiqAuxEstado ;
   private byte A1403LiqAuxEstado ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV8LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private byte[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01EV2_A31LiqNro ;
   private short[] P01EV2_A1EmpCod ;
   private int[] P01EV2_A3CliCod ;
   private byte[] P01EV2_A1403LiqAuxEstado ;
}

final  class getliqestadoaux__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01EV2", "SELECT LiqNro, EmpCod, CliCod, LiqAuxEstado FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

