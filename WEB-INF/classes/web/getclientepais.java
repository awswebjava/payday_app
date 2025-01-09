package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getclientepais extends GXProcedure
{
   public getclientepais( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getclientepais.class ), "" );
   }

   public getclientepais( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( short aP0 )
   {
      getclientepais.this.aP1 = new int[] {0};
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
      getclientepais.this.AV8CliPaiCod = aP0;
      getclientepais.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01X12 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8CliPaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1605ClienteConveniador = P01X12_A1605ClienteConveniador[0] ;
         A747ClienteSistema = P01X12_A747ClienteSistema[0] ;
         A4CliPaiCod = P01X12_A4CliPaiCod[0] ;
         n4CliPaiCod = P01X12_n4CliPaiCod[0] ;
         A3CliCod = P01X12_A3CliCod[0] ;
         AV9CliCod = A3CliCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getclientepais.this.AV9CliCod;
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
      P01X12_A1605ClienteConveniador = new boolean[] {false} ;
      P01X12_A747ClienteSistema = new boolean[] {false} ;
      P01X12_A4CliPaiCod = new short[1] ;
      P01X12_n4CliPaiCod = new boolean[] {false} ;
      P01X12_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getclientepais__default(),
         new Object[] {
             new Object[] {
            P01X12_A1605ClienteConveniador, P01X12_A747ClienteSistema, P01X12_A4CliPaiCod, P01X12_n4CliPaiCod, P01X12_A3CliCod
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
   private boolean A1605ClienteConveniador ;
   private boolean A747ClienteSistema ;
   private boolean n4CliPaiCod ;
   private int[] aP1 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01X12_A1605ClienteConveniador ;
   private boolean[] P01X12_A747ClienteSistema ;
   private short[] P01X12_A4CliPaiCod ;
   private boolean[] P01X12_n4CliPaiCod ;
   private int[] P01X12_A3CliCod ;
}

final  class getclientepais__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01X12", "SELECT ClienteConveniador, ClienteSistema, CliPaiCod, CliCod FROM Cliente WHERE (CliPaiCod = ?) AND (ClienteSistema = TRUE) AND (ClienteConveniador = FALSE) ORDER BY CliPaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((int[]) buf[4])[0] = rslt.getInt(4);
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

