package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconveniadorclicod extends GXProcedure
{
   public getconveniadorclicod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconveniadorclicod.class ), "" );
   }

   public getconveniadorclicod( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( boolean aP0 )
   {
      getconveniadorclicod.this.aP1 = new int[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( boolean aP0 ,
                        int[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( boolean aP0 ,
                             int[] aP1 )
   {
      getconveniadorclicod.this.AV8ClienteConveniador = aP0;
      getconveniadorclicod.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01RC2 */
      pr_default.execute(0, new Object[] {Boolean.valueOf(AV8ClienteConveniador)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1605ClienteConveniador = P01RC2_A1605ClienteConveniador[0] ;
         A3CliCod = P01RC2_A3CliCod[0] ;
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
      this.aP1[0] = getconveniadorclicod.this.AV9CliCod;
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
      P01RC2_A1605ClienteConveniador = new boolean[] {false} ;
      P01RC2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconveniadorclicod__default(),
         new Object[] {
             new Object[] {
            P01RC2_A1605ClienteConveniador, P01RC2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV8ClienteConveniador ;
   private boolean A1605ClienteConveniador ;
   private int[] aP1 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01RC2_A1605ClienteConveniador ;
   private int[] P01RC2_A3CliCod ;
}

final  class getconveniadorclicod__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RC2", "SELECT ClienteConveniador, CliCod FROM Cliente WHERE ClienteConveniador = ? ORDER BY CliCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               return;
      }
   }

}

