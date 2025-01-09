package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientegetpais extends GXProcedure
{
   public clientegetpais( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientegetpais.class ), "" );
   }

   public clientegetpais( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      clientegetpais.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      clientegetpais.this.AV9clicod = aP0;
      clientegetpais.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00IW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9clicod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00IW2_A3CliCod[0] ;
         A4CliPaiCod = P00IW2_A4CliPaiCod[0] ;
         n4CliPaiCod = P00IW2_n4CliPaiCod[0] ;
         AV8CliPaiCod = A4CliPaiCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.pruebaharcode(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = clientegetpais.this.AV8CliPaiCod;
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
      P00IW2_A3CliCod = new int[1] ;
      P00IW2_A4CliPaiCod = new short[1] ;
      P00IW2_n4CliPaiCod = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientegetpais__default(),
         new Object[] {
             new Object[] {
            P00IW2_A3CliCod, P00IW2_A4CliPaiCod, P00IW2_n4CliPaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8CliPaiCod ;
   private short A4CliPaiCod ;
   private short Gx_err ;
   private int AV9clicod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean n4CliPaiCod ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00IW2_A3CliCod ;
   private short[] P00IW2_A4CliPaiCod ;
   private boolean[] P00IW2_n4CliPaiCod ;
}

final  class clientegetpais__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00IW2", "SELECT CliCod, CliPaiCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[2])[0] = rslt.wasNull();
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
               return;
      }
   }

}

