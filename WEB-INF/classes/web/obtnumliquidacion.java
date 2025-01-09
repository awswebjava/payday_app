package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtnumliquidacion extends GXProcedure
{
   public obtnumliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtnumliquidacion.class ), "" );
   }

   public obtnumliquidacion( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 )
   {
      obtnumliquidacion.this.aP2 = new int[] {0};
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
      obtnumliquidacion.this.AV10CliCod = aP0;
      obtnumliquidacion.this.AV8EmpCod = aP1;
      obtnumliquidacion.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13GXLvl3 = (byte)(0) ;
      /* Using cursor P009P2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P009P2_A3CliCod[0] ;
         A1EmpCod = P009P2_A1EmpCod[0] ;
         A31LiqNro = P009P2_A31LiqNro[0] ;
         AV13GXLvl3 = (byte)(1) ;
         AV9LiqNroSiguiente = (int)(A31LiqNro+1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV13GXLvl3 == 0 )
      {
         AV9LiqNroSiguiente = 1 ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = obtnumliquidacion.this.AV9LiqNroSiguiente;
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
      P009P2_A3CliCod = new int[1] ;
      P009P2_A1EmpCod = new short[1] ;
      P009P2_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtnumliquidacion__default(),
         new Object[] {
             new Object[] {
            P009P2_A3CliCod, P009P2_A1EmpCod, P009P2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13GXLvl3 ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9LiqNroSiguiente ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P009P2_A3CliCod ;
   private short[] P009P2_A1EmpCod ;
   private int[] P009P2_A31LiqNro ;
}

final  class obtnumliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P009P2", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, LiqNro DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

