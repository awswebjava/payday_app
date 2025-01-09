package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayliquidaciones extends GXProcedure
{
   public hayliquidaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayliquidaciones.class ), "" );
   }

   public hayliquidaciones( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 )
   {
      hayliquidaciones.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             boolean[] aP2 )
   {
      hayliquidaciones.this.AV9CliCod = aP0;
      hayliquidaciones.this.AV10EmpCod = aP1;
      hayliquidaciones.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8hay = false ;
      /* Using cursor P00IT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P00IT2_A1EmpCod[0] ;
         A3CliCod = P00IT2_A3CliCod[0] ;
         A31LiqNro = P00IT2_A31LiqNro[0] ;
         AV8hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = hayliquidaciones.this.AV8hay;
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
      P00IT2_A1EmpCod = new short[1] ;
      P00IT2_A3CliCod = new int[1] ;
      P00IT2_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayliquidaciones__default(),
         new Object[] {
             new Object[] {
            P00IT2_A1EmpCod, P00IT2_A3CliCod, P00IT2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private boolean AV8hay ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P00IT2_A1EmpCod ;
   private int[] P00IT2_A3CliCod ;
   private int[] P00IT2_A31LiqNro ;
}

final  class hayliquidaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00IT2", "SELECT EmpCod, CliCod, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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

