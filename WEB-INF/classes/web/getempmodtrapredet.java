package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempmodtrapredet extends GXProcedure
{
   public getempmodtrapredet( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempmodtrapredet.class ), "" );
   }

   public getempmodtrapredet( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 )
   {
      getempmodtrapredet.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String[] aP2 )
   {
      getempmodtrapredet.this.AV10CliCod = aP0;
      getempmodtrapredet.this.AV8EmpCod = aP1;
      getempmodtrapredet.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02L12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P02L12_A1EmpCod[0] ;
         A3CliCod = P02L12_A3CliCod[0] ;
         A2405EmpModTra = P02L12_A2405EmpModTra[0] ;
         AV9EmpModTra = A2405EmpModTra ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempmodtrapredet.this.AV9EmpModTra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9EmpModTra = "" ;
      scmdbuf = "" ;
      P02L12_A1EmpCod = new short[1] ;
      P02L12_A3CliCod = new int[1] ;
      P02L12_A2405EmpModTra = new String[] {""} ;
      A2405EmpModTra = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempmodtrapredet__default(),
         new Object[] {
             new Object[] {
            P02L12_A1EmpCod, P02L12_A3CliCod, P02L12_A2405EmpModTra
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
   private String AV9EmpModTra ;
   private String scmdbuf ;
   private String A2405EmpModTra ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P02L12_A1EmpCod ;
   private int[] P02L12_A3CliCod ;
   private String[] P02L12_A2405EmpModTra ;
}

final  class getempmodtrapredet__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02L12", "SELECT EmpCod, CliCod, EmpModTra FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 1);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

