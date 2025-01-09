package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmenuopctitulo extends GXProcedure
{
   public getmenuopctitulo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmenuopctitulo.class ), "" );
   }

   public getmenuopctitulo( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( byte aP0 ,
                             byte aP1 ,
                             long aP2 ,
                             String aP3 )
   {
      getmenuopctitulo.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( byte aP0 ,
                        byte aP1 ,
                        long aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( byte aP0 ,
                             byte aP1 ,
                             long aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      getmenuopctitulo.this.AV12RolId = aP0;
      getmenuopctitulo.this.AV11PerfilId = aP1;
      getmenuopctitulo.this.AV10MenuVerId = aP2;
      getmenuopctitulo.this.AV9MenuOpcCod = aP3;
      getmenuopctitulo.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02EO2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV12RolId), Byte.valueOf(AV11PerfilId), Long.valueOf(AV10MenuVerId), AV9MenuOpcCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1929MenuOpcCod = P02EO2_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P02EO2_A1928MenuVerId[0] ;
         A1925PerfilId = P02EO2_A1925PerfilId[0] ;
         A1923RolId = P02EO2_A1923RolId[0] ;
         A1931MenuOpcTitulo = P02EO2_A1931MenuOpcTitulo[0] ;
         AV8MenuOpcTitulo = A1931MenuOpcTitulo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getmenuopctitulo.this.AV8MenuOpcTitulo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8MenuOpcTitulo = "" ;
      scmdbuf = "" ;
      P02EO2_A1929MenuOpcCod = new String[] {""} ;
      P02EO2_A1928MenuVerId = new long[1] ;
      P02EO2_A1925PerfilId = new byte[1] ;
      P02EO2_A1923RolId = new byte[1] ;
      P02EO2_A1931MenuOpcTitulo = new String[] {""} ;
      A1929MenuOpcCod = "" ;
      A1931MenuOpcTitulo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmenuopctitulo__default(),
         new Object[] {
             new Object[] {
            P02EO2_A1929MenuOpcCod, P02EO2_A1928MenuVerId, P02EO2_A1925PerfilId, P02EO2_A1923RolId, P02EO2_A1931MenuOpcTitulo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12RolId ;
   private byte AV11PerfilId ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short Gx_err ;
   private long AV10MenuVerId ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String AV9MenuOpcCod ;
   private String AV8MenuOpcTitulo ;
   private String A1929MenuOpcCod ;
   private String A1931MenuOpcTitulo ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P02EO2_A1929MenuOpcCod ;
   private long[] P02EO2_A1928MenuVerId ;
   private byte[] P02EO2_A1925PerfilId ;
   private byte[] P02EO2_A1923RolId ;
   private String[] P02EO2_A1931MenuOpcTitulo ;
}

final  class getmenuopctitulo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02EO2", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuOpcTitulo FROM MenuVersionesOpciones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setVarchar(4, (String)parms[3], 100);
               return;
      }
   }

}

