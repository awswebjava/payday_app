package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatoscliente extends GXProcedure
{
   public getdatoscliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatoscliente.class ), "" );
   }

   public getdatoscliente( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             long[] aP1 ,
                             java.util.Date[] aP2 ,
                             boolean[] aP3 )
   {
      getdatoscliente.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        long[] aP1 ,
                        java.util.Date[] aP2 ,
                        boolean[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             long[] aP1 ,
                             java.util.Date[] aP2 ,
                             boolean[] aP3 ,
                             String[] aP4 )
   {
      getdatoscliente.this.AV8CliCod = aP0;
      getdatoscliente.this.aP1 = aP1;
      getdatoscliente.this.aP2 = aP2;
      getdatoscliente.this.aP3 = aP3;
      getdatoscliente.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00162 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00162_A3CliCod[0] ;
         A345CliCUIT = P00162_A345CliCUIT[0] ;
         A346CliFecAlta = P00162_A346CliFecAlta[0] ;
         A366CliMultiEmp = P00162_A366CliMultiEmp[0] ;
         A344CliNom = P00162_A344CliNom[0] ;
         AV9CliCUIT = A345CliCUIT ;
         AV10CliFecAlta = A346CliFecAlta ;
         AV12CliMultiEmp = A366CliMultiEmp ;
         AV11CliNom = A344CliNom ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getdatoscliente.this.AV9CliCUIT;
      this.aP2[0] = getdatoscliente.this.AV10CliFecAlta;
      this.aP3[0] = getdatoscliente.this.AV12CliMultiEmp;
      this.aP4[0] = getdatoscliente.this.AV11CliNom;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10CliFecAlta = GXutil.nullDate() ;
      AV11CliNom = "" ;
      scmdbuf = "" ;
      P00162_A3CliCod = new int[1] ;
      P00162_A345CliCUIT = new long[1] ;
      P00162_A346CliFecAlta = new java.util.Date[] {GXutil.nullDate()} ;
      P00162_A366CliMultiEmp = new boolean[] {false} ;
      P00162_A344CliNom = new String[] {""} ;
      A346CliFecAlta = GXutil.nullDate() ;
      A344CliNom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatoscliente__default(),
         new Object[] {
             new Object[] {
            P00162_A3CliCod, P00162_A345CliCUIT, P00162_A346CliFecAlta, P00162_A366CliMultiEmp, P00162_A344CliNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private long AV9CliCUIT ;
   private long A345CliCUIT ;
   private String scmdbuf ;
   private java.util.Date AV10CliFecAlta ;
   private java.util.Date A346CliFecAlta ;
   private boolean AV12CliMultiEmp ;
   private boolean A366CliMultiEmp ;
   private String AV11CliNom ;
   private String A344CliNom ;
   private String[] aP4 ;
   private long[] aP1 ;
   private java.util.Date[] aP2 ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00162_A3CliCod ;
   private long[] P00162_A345CliCUIT ;
   private java.util.Date[] P00162_A346CliFecAlta ;
   private boolean[] P00162_A366CliMultiEmp ;
   private String[] P00162_A344CliNom ;
}

final  class getdatoscliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00162", "SELECT CliCod, CliCUIT, CliFecAlta, CliMultiEmp, CliNom FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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

