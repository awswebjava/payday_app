package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class haypendientescierre extends GXProcedure
{
   public haypendientescierre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( haypendientescierre.class ), "" );
   }

   public haypendientescierre( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 )
   {
      haypendientescierre.this.aP2 = new boolean[] {false};
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
      haypendientescierre.this.AV10CliCod = aP0;
      haypendientescierre.this.AV8EmpCod = aP1;
      haypendientescierre.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00JB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A278LiqEstado = P00JB2_A278LiqEstado[0] ;
         A1EmpCod = P00JB2_A1EmpCod[0] ;
         A3CliCod = P00JB2_A3CliCod[0] ;
         A31LiqNro = P00JB2_A31LiqNro[0] ;
         AV9hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = haypendientescierre.this.AV9hay;
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
      P00JB2_A278LiqEstado = new byte[1] ;
      P00JB2_A1EmpCod = new short[1] ;
      P00JB2_A3CliCod = new int[1] ;
      P00JB2_A31LiqNro = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.haypendientescierre__default(),
         new Object[] {
             new Object[] {
            P00JB2_A278LiqEstado, P00JB2_A1EmpCod, P00JB2_A3CliCod, P00JB2_A31LiqNro
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A278LiqEstado ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private boolean AV9hay ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private byte[] P00JB2_A278LiqEstado ;
   private short[] P00JB2_A1EmpCod ;
   private int[] P00JB2_A3CliCod ;
   private int[] P00JB2_A31LiqNro ;
}

final  class haypendientescierre__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00JB2", "SELECT LiqEstado, EmpCod, CliCod, LiqNro FROM Liquidacion WHERE (CliCod = ? and EmpCod = ?) AND (LiqEstado = 3) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
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
               return;
      }
   }

}

