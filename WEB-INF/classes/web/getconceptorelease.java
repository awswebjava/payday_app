package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconceptorelease extends GXProcedure
{
   public getconceptorelease( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconceptorelease.class ), "" );
   }

   public getconceptorelease( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          String aP1 )
   {
      getconceptorelease.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             int[] aP2 )
   {
      getconceptorelease.this.AV8CliCod = aP0;
      getconceptorelease.this.AV9ConCodigo = aP1;
      getconceptorelease.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01T02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P01T02_A26ConCodigo[0] ;
         A3CliCod = P01T02_A3CliCod[0] ;
         A1886ConRelSec = P01T02_A1886ConRelSec[0] ;
         AV10ConRelSec = A1886ConRelSec ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getconceptorelease.this.AV10ConRelSec;
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
      P01T02_A26ConCodigo = new String[] {""} ;
      P01T02_A3CliCod = new int[1] ;
      P01T02_A1886ConRelSec = new int[1] ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconceptorelease__default(),
         new Object[] {
             new Object[] {
            P01T02_A26ConCodigo, P01T02_A3CliCod, P01T02_A1886ConRelSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10ConRelSec ;
   private int A3CliCod ;
   private int A1886ConRelSec ;
   private String AV9ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01T02_A26ConCodigo ;
   private int[] P01T02_A3CliCod ;
   private int[] P01T02_A1886ConRelSec ;
}

final  class getconceptorelease__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01T02", "SELECT ConCodigo, CliCod, ConRelSec FROM Concepto WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
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
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}
