package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inipermisos extends GXProcedure
{
   public inipermisos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inipermisos.class ), "" );
   }

   public inipermisos( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02GB2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1940MenuItemOrd = P02GB2_A1940MenuItemOrd[0] ;
         A2361MenuOpcObj = P02GB2_A2361MenuOpcObj[0] ;
         A1923RolId = P02GB2_A1923RolId[0] ;
         A1925PerfilId = P02GB2_A1925PerfilId[0] ;
         A1928MenuVerId = P02GB2_A1928MenuVerId[0] ;
         A1929MenuOpcCod = P02GB2_A1929MenuOpcCod[0] ;
         if ( ! (GXutil.strcmp("", A2361MenuOpcObj)==0) && ! P02GB2_n2361MenuOpcObj[0] )
         {
            new web.newopcpermiso(remoteHandle, context).execute( A1923RolId, A1925PerfilId, A1928MenuVerId, A1929MenuOpcCod, httpContext.getMessage( "INS", "")) ;
            new web.newopcpermiso(remoteHandle, context).execute( A1923RolId, A1925PerfilId, A1928MenuVerId, A1929MenuOpcCod, httpContext.getMessage( "UPD", "")) ;
            new web.newopcpermiso(remoteHandle, context).execute( A1923RolId, A1925PerfilId, A1928MenuVerId, A1929MenuOpcCod, httpContext.getMessage( "DLT", "")) ;
            new web.newopcpermiso(remoteHandle, context).execute( A1923RolId, A1925PerfilId, A1928MenuVerId, A1929MenuOpcCod, httpContext.getMessage( "WW", "")) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
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
      P02GB2_A1940MenuItemOrd = new byte[1] ;
      P02GB2_A2361MenuOpcObj = new String[] {""} ;
      P02GB2_A1923RolId = new byte[1] ;
      P02GB2_A1925PerfilId = new byte[1] ;
      P02GB2_A1928MenuVerId = new long[1] ;
      P02GB2_A1929MenuOpcCod = new String[] {""} ;
      A2361MenuOpcObj = "" ;
      A1929MenuOpcCod = "" ;
      P02GB2_n2361MenuOpcObj = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inipermisos__default(),
         new Object[] {
             new Object[] {
            P02GB2_A1940MenuItemOrd, P02GB2_A2361MenuOpcObj, P02GB2_A1923RolId, P02GB2_A1925PerfilId, P02GB2_A1928MenuVerId, P02GB2_A1929MenuOpcCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1940MenuItemOrd ;
   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private short Gx_err ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String A2361MenuOpcObj ;
   private String A1929MenuOpcCod ;
   private IDataStoreProvider pr_default ;
   private byte[] P02GB2_A1940MenuItemOrd ;
   private String[] P02GB2_A2361MenuOpcObj ;
   private byte[] P02GB2_A1923RolId ;
   private byte[] P02GB2_A1925PerfilId ;
   private long[] P02GB2_A1928MenuVerId ;
   private String[] P02GB2_A1929MenuOpcCod ;
   private boolean[] P02GB2_n2361MenuOpcObj ;
}

final  class inipermisos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02GB2", "SELECT MenuItemOrd, MenuOpcObj, RolId, PerfilId, MenuVerId, MenuOpcCod FROM MenuVersionesOpciones ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 128);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
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

