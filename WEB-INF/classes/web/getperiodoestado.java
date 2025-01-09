package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getperiodoestado extends GXProcedure
{
   public getperiodoestado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getperiodoestado.class ), "" );
   }

   public getperiodoestado( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           java.util.Date aP2 )
   {
      getperiodoestado.this.aP3 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        byte[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             byte[] aP3 )
   {
      getperiodoestado.this.AV10CliCod = aP0;
      getperiodoestado.this.AV11EmpCod = aP1;
      getperiodoestado.this.AV12PeriodoLiq = aP2;
      getperiodoestado.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiquidacionEstado = (byte)(3) ;
      /* Using cursor P01O42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV12PeriodoLiq});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2112LiqRelNro = P01O42_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01O42_n2112LiqRelNro[0] ;
         A278LiqEstado = P01O42_A278LiqEstado[0] ;
         A1729PeriodoLiq = P01O42_A1729PeriodoLiq[0] ;
         A1EmpCod = P01O42_A1EmpCod[0] ;
         A3CliCod = P01O42_A3CliCod[0] ;
         A31LiqNro = P01O42_A31LiqNro[0] ;
         AV8LiquidacionEstado = (byte)(2) ;
         pr_default.close(0);
         returnInSub = true;
         cleanup();
         if (true) return;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV16GXLvl12 = (byte)(0) ;
      /* Using cursor P01O43 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV11EmpCod), AV12PeriodoLiq});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = P01O43_A3CliCod[0] ;
         A1EmpCod = P01O43_A1EmpCod[0] ;
         A1729PeriodoLiq = P01O43_A1729PeriodoLiq[0] ;
         A2112LiqRelNro = P01O43_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01O43_n2112LiqRelNro[0] ;
         A278LiqEstado = P01O43_A278LiqEstado[0] ;
         A31LiqNro = P01O43_A31LiqNro[0] ;
         AV16GXLvl12 = (byte)(1) ;
         if ( A278LiqEstado != 3 )
         {
            AV8LiquidacionEstado = A278LiqEstado ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV16GXLvl12 == 0 )
      {
         AV8LiquidacionEstado = (byte)(1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getperiodoestado.this.AV8LiquidacionEstado;
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
      P01O42_A2112LiqRelNro = new int[1] ;
      P01O42_n2112LiqRelNro = new boolean[] {false} ;
      P01O42_A278LiqEstado = new byte[1] ;
      P01O42_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P01O42_A1EmpCod = new short[1] ;
      P01O42_A3CliCod = new int[1] ;
      P01O42_A31LiqNro = new int[1] ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      P01O43_A3CliCod = new int[1] ;
      P01O43_A1EmpCod = new short[1] ;
      P01O43_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P01O43_A2112LiqRelNro = new int[1] ;
      P01O43_n2112LiqRelNro = new boolean[] {false} ;
      P01O43_A278LiqEstado = new byte[1] ;
      P01O43_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getperiodoestado__default(),
         new Object[] {
             new Object[] {
            P01O42_A2112LiqRelNro, P01O42_n2112LiqRelNro, P01O42_A278LiqEstado, P01O42_A1729PeriodoLiq, P01O42_A1EmpCod, P01O42_A3CliCod, P01O42_A31LiqNro
            }
            , new Object[] {
            P01O43_A3CliCod, P01O43_A1EmpCod, P01O43_A1729PeriodoLiq, P01O43_A2112LiqRelNro, P01O43_n2112LiqRelNro, P01O43_A278LiqEstado, P01O43_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LiquidacionEstado ;
   private byte A278LiqEstado ;
   private byte AV16GXLvl12 ;
   private short AV11EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private java.util.Date AV12PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean n2112LiqRelNro ;
   private boolean returnInSub ;
   private byte[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01O42_A2112LiqRelNro ;
   private boolean[] P01O42_n2112LiqRelNro ;
   private byte[] P01O42_A278LiqEstado ;
   private java.util.Date[] P01O42_A1729PeriodoLiq ;
   private short[] P01O42_A1EmpCod ;
   private int[] P01O42_A3CliCod ;
   private int[] P01O42_A31LiqNro ;
   private int[] P01O43_A3CliCod ;
   private short[] P01O43_A1EmpCod ;
   private java.util.Date[] P01O43_A1729PeriodoLiq ;
   private int[] P01O43_A2112LiqRelNro ;
   private boolean[] P01O43_n2112LiqRelNro ;
   private byte[] P01O43_A278LiqEstado ;
   private int[] P01O43_A31LiqNro ;
}

final  class getperiodoestado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01O42", "SELECT LiqRelNro, LiqEstado, PeriodoLiq, EmpCod, CliCod, LiqNro FROM Liquidacion WHERE (CliCod = ? and EmpCod = ? and PeriodoLiq = ?) AND (LiqRelNro IS NULL) AND (LiqEstado = 2) ORDER BY CliCod, EmpCod, PeriodoLiq  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01O43", "SELECT CliCod, EmpCod, PeriodoLiq, LiqRelNro, LiqEstado, LiqNro FROM Liquidacion WHERE (CliCod = ? and EmpCod = ? and PeriodoLiq = ?) AND (LiqRelNro IS NULL) ORDER BY CliCod, EmpCod, PeriodoLiq, LiqEstado ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

