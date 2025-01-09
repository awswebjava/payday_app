package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clienteempresamultiple extends GXProcedure
{
   public clienteempresamultiple( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteempresamultiple.class ), "" );
   }

   public clienteempresamultiple( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 )
   {
      clienteempresamultiple.this.aP1 = new boolean[] {false};
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
      clienteempresamultiple.this.AV8CliCod = aP0;
      clienteempresamultiple.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00O52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00O52_A3CliCod[0] ;
         A1EmpCod = P00O52_A1EmpCod[0] ;
         AV9i = (short)(AV9i+1) ;
         if ( AV9i > 1 )
         {
            AV10multiEs = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = clienteempresamultiple.this.AV10multiEs;
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
      P00O52_A3CliCod = new int[1] ;
      P00O52_A1EmpCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteempresamultiple__default(),
         new Object[] {
             new Object[] {
            P00O52_A3CliCod, P00O52_A1EmpCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A1EmpCod ;
   private short AV9i ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV10multiEs ;
   private boolean[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00O52_A3CliCod ;
   private short[] P00O52_A1EmpCod ;
}

final  class clienteempresamultiple__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00O52", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

