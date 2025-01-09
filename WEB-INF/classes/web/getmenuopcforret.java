package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmenuopcforret extends GXProcedure
{
   public getmenuopcforret( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmenuopcforret.class ), "" );
   }

   public getmenuopcforret( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( byte aP0 ,
                              byte aP1 ,
                              long aP2 ,
                              String aP3 )
   {
      getmenuopcforret.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( byte aP0 ,
                        byte aP1 ,
                        long aP2 ,
                        String aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( byte aP0 ,
                             byte aP1 ,
                             long aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      getmenuopcforret.this.AV12RolId = aP0;
      getmenuopcforret.this.AV11PerfilId = aP1;
      getmenuopcforret.this.AV10MenuVerId = aP2;
      getmenuopcforret.this.AV8MenuOpcCod = aP3;
      getmenuopcforret.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02GJ2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV12RolId), Byte.valueOf(AV11PerfilId), Long.valueOf(AV10MenuVerId), AV8MenuOpcCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1929MenuOpcCod = P02GJ2_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P02GJ2_A1928MenuVerId[0] ;
         A1925PerfilId = P02GJ2_A1925PerfilId[0] ;
         A1923RolId = P02GJ2_A1923RolId[0] ;
         A2367MenuOpcForRet = P02GJ2_A2367MenuOpcForRet[0] ;
         AV9MenuOpcForRet = A2367MenuOpcForRet ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getmenuopcforret.this.AV9MenuOpcForRet;
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
      P02GJ2_A1929MenuOpcCod = new String[] {""} ;
      P02GJ2_A1928MenuVerId = new long[1] ;
      P02GJ2_A1925PerfilId = new byte[1] ;
      P02GJ2_A1923RolId = new byte[1] ;
      P02GJ2_A2367MenuOpcForRet = new boolean[] {false} ;
      A1929MenuOpcCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmenuopcforret__default(),
         new Object[] {
             new Object[] {
            P02GJ2_A1929MenuOpcCod, P02GJ2_A1928MenuVerId, P02GJ2_A1925PerfilId, P02GJ2_A1923RolId, P02GJ2_A2367MenuOpcForRet
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
   private boolean AV9MenuOpcForRet ;
   private boolean A2367MenuOpcForRet ;
   private String AV8MenuOpcCod ;
   private String A1929MenuOpcCod ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P02GJ2_A1929MenuOpcCod ;
   private long[] P02GJ2_A1928MenuVerId ;
   private byte[] P02GJ2_A1925PerfilId ;
   private byte[] P02GJ2_A1923RolId ;
   private boolean[] P02GJ2_A2367MenuOpcForRet ;
}

final  class getmenuopcforret__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02GJ2", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuOpcForRet FROM MenuVersionesOpciones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
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

