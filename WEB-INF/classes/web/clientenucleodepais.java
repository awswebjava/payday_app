package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clientenucleodepais extends GXProcedure
{
   public clientenucleodepais( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientenucleodepais.class ), "" );
   }

   public clientenucleodepais( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( short aP0 )
   {
      clientenucleodepais.this.aP1 = new int[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        int[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             int[] aP1 )
   {
      clientenucleodepais.this.AV8CliPaiCod = aP0;
      clientenucleodepais.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01I22 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8CliPaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A747ClienteSistema = P01I22_A747ClienteSistema[0] ;
         A4CliPaiCod = P01I22_A4CliPaiCod[0] ;
         n4CliPaiCod = P01I22_n4CliPaiCod[0] ;
         A3CliCod = P01I22_A3CliCod[0] ;
         AV9CliCod = A3CliCod ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = clientenucleodepais.this.AV9CliCod;
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
      P01I22_A747ClienteSistema = new boolean[] {false} ;
      P01I22_A4CliPaiCod = new short[1] ;
      P01I22_n4CliPaiCod = new boolean[] {false} ;
      P01I22_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientenucleodepais__default(),
         new Object[] {
             new Object[] {
            P01I22_A747ClienteSistema, P01I22_A4CliPaiCod, P01I22_n4CliPaiCod, P01I22_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8CliPaiCod ;
   private short A4CliPaiCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean A747ClienteSistema ;
   private boolean n4CliPaiCod ;
   private int[] aP1 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01I22_A747ClienteSistema ;
   private short[] P01I22_A4CliPaiCod ;
   private boolean[] P01I22_n4CliPaiCod ;
   private int[] P01I22_A3CliCod ;
}

final  class clientenucleodepais__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01I22", "SELECT ClienteSistema, CliPaiCod, CliCod FROM Cliente WHERE (CliPaiCod = ?) AND (ClienteSistema = TRUE) ORDER BY CliPaiCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

