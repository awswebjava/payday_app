package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class hayalguncliente extends GXProcedure
{
   public hayalguncliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( hayalguncliente.class ), "" );
   }

   public hayalguncliente( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( )
   {
      hayalguncliente.this.aP0 = new boolean[] {false};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( boolean[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( boolean[] aP0 )
   {
      hayalguncliente.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00JU2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00JU2_A3CliCod[0] ;
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
      this.aP0[0] = hayalguncliente.this.AV8hay;
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
      P00JU2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.hayalguncliente__default(),
         new Object[] {
             new Object[] {
            P00JU2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV8hay ;
   private boolean[] aP0 ;
   private IDataStoreProvider pr_default ;
   private int[] P00JU2_A3CliCod ;
}

final  class hayalguncliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00JU2", "SELECT CliCod FROM Cliente ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

