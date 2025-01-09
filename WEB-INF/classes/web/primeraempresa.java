package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class primeraempresa extends GXProcedure
{
   public primeraempresa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( primeraempresa.class ), "" );
   }

   public primeraempresa( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short[] aP1 )
   {
      primeraempresa.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 ,
                             String[] aP2 )
   {
      primeraempresa.this.AV10CliCod = aP0;
      primeraempresa.this.aP1 = aP1;
      primeraempresa.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00812 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00812_A3CliCod[0] ;
         A2EmpNom = P00812_A2EmpNom[0] ;
         A1EmpCod = P00812_A1EmpCod[0] ;
         AV8EmpCod = A1EmpCod ;
         AV9EmpNom = A2EmpNom ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = primeraempresa.this.AV8EmpCod;
      this.aP2[0] = primeraempresa.this.AV9EmpNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9EmpNom = "" ;
      scmdbuf = "" ;
      P00812_A3CliCod = new int[1] ;
      P00812_A2EmpNom = new String[] {""} ;
      P00812_A1EmpCod = new short[1] ;
      A2EmpNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.primeraempresa__default(),
         new Object[] {
             new Object[] {
            P00812_A3CliCod, P00812_A2EmpNom, P00812_A1EmpCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV9EmpNom ;
   private String A2EmpNom ;
   private String[] aP2 ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00812_A3CliCod ;
   private String[] P00812_A2EmpNom ;
   private short[] P00812_A1EmpCod ;
}

final  class primeraempresa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00812", "SELECT CliCod, EmpNom, EmpCod FROM Empresa WHERE CliCod = ? ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
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

