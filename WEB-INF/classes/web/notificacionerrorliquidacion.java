package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class notificacionerrorliquidacion extends GXProcedure
{
   public notificacionerrorliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( notificacionerrorliquidacion.class ), "" );
   }

   public notificacionerrorliquidacion( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      notificacionerrorliquidacion.this.AV15CliCod = aP0;
      notificacionerrorliquidacion.this.AV13EmpCod = aP1;
      notificacionerrorliquidacion.this.AV12LiqNro = aP2;
      notificacionerrorliquidacion.this.AV16ClientId = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00SU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV12LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P00SU2_A31LiqNro[0] ;
         A1EmpCod = P00SU2_A1EmpCod[0] ;
         A3CliCod = P00SU2_A3CliCod[0] ;
         A766LiqError = P00SU2_A766LiqError[0] ;
         GXv_char1[0] = "" ;
         new web.invocarnotificacion(remoteHandle, context).execute( AV15CliCod, httpContext.getMessage( "ERROR GuardaLiquidacion ", "")+GXutil.trim( GXutil.str( AV12LiqNro, 8, 0)), GXutil.trim( A766LiqError), AV16ClientId, GXv_char1) ;
         /* Exiting from a For First loop. */
         if (true) break;
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
      P00SU2_A31LiqNro = new int[1] ;
      P00SU2_A1EmpCod = new short[1] ;
      P00SU2_A3CliCod = new int[1] ;
      P00SU2_A766LiqError = new String[] {""} ;
      A766LiqError = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.notificacionerrorliquidacion__default(),
         new Object[] {
             new Object[] {
            P00SU2_A31LiqNro, P00SU2_A1EmpCod, P00SU2_A3CliCod, P00SU2_A766LiqError
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV12LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String GXv_char1[] ;
   private String AV16ClientId ;
   private String A766LiqError ;
   private IDataStoreProvider pr_default ;
   private int[] P00SU2_A31LiqNro ;
   private short[] P00SU2_A1EmpCod ;
   private int[] P00SU2_A3CliCod ;
   private String[] P00SU2_A766LiqError ;
}

final  class notificacionerrorliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00SU2", "SELECT LiqNro, EmpCod, CliCod, LiqError FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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

