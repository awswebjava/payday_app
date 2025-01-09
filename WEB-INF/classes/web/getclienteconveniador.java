package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getclienteconveniador extends GXProcedure
{
   public getclienteconveniador( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getclienteconveniador.class ), "" );
   }

   public getclienteconveniador( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 )
   {
      getclienteconveniador.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             boolean[] aP1 )
   {
      getclienteconveniador.this.AV9CliCod = aP0;
      getclienteconveniador.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01GE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01GE2_A3CliCod[0] ;
         A1605ClienteConveniador = P01GE2_A1605ClienteConveniador[0] ;
         AV8ClienteConveniador = A1605ClienteConveniador ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getclienteconveniador.this.AV8ClienteConveniador;
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
      P01GE2_A3CliCod = new int[1] ;
      P01GE2_A1605ClienteConveniador = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getclienteconveniador__default(),
         new Object[] {
             new Object[] {
            P01GE2_A3CliCod, P01GE2_A1605ClienteConveniador
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
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P01GE2_A3CliCod ;
   private boolean[] P01GE2_A1605ClienteConveniador ;
}

final  class getclienteconveniador__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GE2", "SELECT CliCod, ClienteConveniador FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
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

