package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esclientenucleogeneral2 extends GXProcedure
{
   public esclientenucleogeneral2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esclientenucleogeneral2.class ), "" );
   }

   public esclientenucleogeneral2( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( )
   {
      esclientenucleogeneral2.this.aP0 = new boolean[] {false};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( boolean[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( boolean[] aP0 )
   {
      esclientenucleogeneral2.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV8CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      esclientenucleogeneral2.this.GXt_int1 = GXv_int2[0] ;
      AV8CliCod = GXt_int1 ;
      /* Using cursor P01XJ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A4CliPaiCod = P01XJ2_A4CliPaiCod[0] ;
         n4CliPaiCod = P01XJ2_n4CliPaiCod[0] ;
         A747ClienteSistema = P01XJ2_A747ClienteSistema[0] ;
         A3CliCod = P01XJ2_A3CliCod[0] ;
         AV9es = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = esclientenucleogeneral2.this.AV9es;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      P01XJ2_A4CliPaiCod = new short[1] ;
      P01XJ2_n4CliPaiCod = new boolean[] {false} ;
      P01XJ2_A747ClienteSistema = new boolean[] {false} ;
      P01XJ2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.esclientenucleogeneral2__default(),
         new Object[] {
             new Object[] {
            P01XJ2_A4CliPaiCod, P01XJ2_n4CliPaiCod, P01XJ2_A747ClienteSistema, P01XJ2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A4CliPaiCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV9es ;
   private boolean n4CliPaiCod ;
   private boolean A747ClienteSistema ;
   private boolean[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P01XJ2_A4CliPaiCod ;
   private boolean[] P01XJ2_n4CliPaiCod ;
   private boolean[] P01XJ2_A747ClienteSistema ;
   private int[] P01XJ2_A3CliCod ;
}

final  class esclientenucleogeneral2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01XJ2", "SELECT CliPaiCod, ClienteSistema, CliCod FROM Cliente WHERE (CliCod = ?) AND (CliPaiCod IS NULL) AND (ClienteSistema = TRUE) ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((boolean[]) buf[2])[0] = rslt.getBoolean(2);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

