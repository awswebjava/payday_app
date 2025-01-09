package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnombrecliente extends GXProcedure
{
   public getnombrecliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnombrecliente.class ), "" );
   }

   public getnombrecliente( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      getnombrecliente.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      getnombrecliente.this.AV9CliCod = aP0;
      getnombrecliente.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01T22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01T22_A3CliCod[0] ;
         A344CliNom = P01T22_A344CliNom[0] ;
         AV8CliNom = A344CliNom ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getnombrecliente.this.AV8CliNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8CliNom = "" ;
      scmdbuf = "" ;
      P01T22_A3CliCod = new int[1] ;
      P01T22_A344CliNom = new String[] {""} ;
      A344CliNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnombrecliente__default(),
         new Object[] {
             new Object[] {
            P01T22_A3CliCod, P01T22_A344CliNom
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
   private String AV8CliNom ;
   private String A344CliNom ;
   private String[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P01T22_A3CliCod ;
   private String[] P01T22_A344CliNom ;
}

final  class getnombrecliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01T22", "SELECT CliCod, CliNom FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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

