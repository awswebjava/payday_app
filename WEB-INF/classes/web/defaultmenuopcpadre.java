package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultmenuopcpadre extends GXProcedure
{
   public defaultmenuopcpadre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultmenuopcpadre.class ), "" );
   }

   public defaultmenuopcpadre( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( byte aP0 ,
                             String aP1 )
   {
      defaultmenuopcpadre.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( byte aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( byte aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      defaultmenuopcpadre.this.AV10PerfilId = aP0;
      defaultmenuopcpadre.this.AV11MenuItemId = aP1;
      defaultmenuopcpadre.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV14SecUserId ;
      GXv_int2[0] = GXt_int1 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int2) ;
      defaultmenuopcpadre.this.GXt_int1 = GXv_int2[0] ;
      AV14SecUserId = GXt_int1 ;
      GXv_int3[0] = AV12RolId ;
      GXv_int4[0] = AV10PerfilId ;
      GXv_int5[0] = AV13MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV14SecUserId, GXv_int3, GXv_int4, GXv_int5) ;
      defaultmenuopcpadre.this.AV12RolId = GXv_int3[0] ;
      defaultmenuopcpadre.this.AV10PerfilId = GXv_int4[0] ;
      defaultmenuopcpadre.this.AV13MenuVerId = GXv_int5[0] ;
      /* Using cursor P01V02 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV12RolId), Byte.valueOf(AV10PerfilId), Long.valueOf(AV13MenuVerId), AV11MenuItemId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1929MenuOpcCod = P01V02_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P01V02_A1928MenuVerId[0] ;
         A1925PerfilId = P01V02_A1925PerfilId[0] ;
         A1923RolId = P01V02_A1923RolId[0] ;
         A1933MenuOpcPadre = P01V02_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = P01V02_n1933MenuOpcPadre[0] ;
         AV8MItemPadreDef = A1933MenuOpcPadre ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = defaultmenuopcpadre.this.AV8MItemPadreDef;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8MItemPadreDef = "" ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new long[1] ;
      scmdbuf = "" ;
      P01V02_A1929MenuOpcCod = new String[] {""} ;
      P01V02_A1928MenuVerId = new long[1] ;
      P01V02_A1925PerfilId = new byte[1] ;
      P01V02_A1923RolId = new byte[1] ;
      P01V02_A1933MenuOpcPadre = new String[] {""} ;
      P01V02_n1933MenuOpcPadre = new boolean[] {false} ;
      A1929MenuOpcCod = "" ;
      A1933MenuOpcPadre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.defaultmenuopcpadre__default(),
         new Object[] {
             new Object[] {
            P01V02_A1929MenuOpcCod, P01V02_A1928MenuVerId, P01V02_A1925PerfilId, P01V02_A1923RolId, P01V02_A1933MenuOpcPadre, P01V02_n1933MenuOpcPadre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10PerfilId ;
   private byte AV12RolId ;
   private byte GXv_int3[] ;
   private byte GXv_int4[] ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short AV14SecUserId ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private long AV13MenuVerId ;
   private long GXv_int5[] ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String A1933MenuOpcPadre ;
   private boolean n1933MenuOpcPadre ;
   private String AV11MenuItemId ;
   private String AV8MItemPadreDef ;
   private String A1929MenuOpcCod ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01V02_A1929MenuOpcCod ;
   private long[] P01V02_A1928MenuVerId ;
   private byte[] P01V02_A1925PerfilId ;
   private byte[] P01V02_A1923RolId ;
   private String[] P01V02_A1933MenuOpcPadre ;
   private boolean[] P01V02_n1933MenuOpcPadre ;
}

final  class defaultmenuopcpadre__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01V02", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuOpcPadre FROM MenuVersionesOpciones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
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
               stmt.setVarchar(4, (String)parms[3], 40);
               return;
      }
   }

}

