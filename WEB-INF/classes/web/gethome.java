package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethome extends GXProcedure
{
   public gethome( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethome.class ), "" );
   }

   public gethome( int remoteHandle ,
                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      gethome.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      gethome.this.aP0 = aP0;
      gethome.this.aP1 = aP1;
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
      gethome.this.GXt_int1 = GXv_int2[0] ;
      AV14SecUserId = GXt_int1 ;
      GXv_int3[0] = AV13RolId ;
      GXv_int4[0] = AV8PerfilId ;
      GXv_int5[0] = AV9MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV14SecUserId, GXv_int3, GXv_int4, GXv_int5) ;
      gethome.this.AV13RolId = GXv_int3[0] ;
      gethome.this.AV8PerfilId = GXv_int4[0] ;
      gethome.this.AV9MenuVerId = GXv_int5[0] ;
      /* Using cursor P01UT2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV13RolId), Byte.valueOf(AV8PerfilId), Long.valueOf(AV9MenuVerId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1934MenuHomeEs = P01UT2_A1934MenuHomeEs[0] ;
         A1928MenuVerId = P01UT2_A1928MenuVerId[0] ;
         A1925PerfilId = P01UT2_A1925PerfilId[0] ;
         A1923RolId = P01UT2_A1923RolId[0] ;
         A1937MenuItemId = P01UT2_A1937MenuItemId[0] ;
         A1929MenuOpcCod = P01UT2_A1929MenuOpcCod[0] ;
         GXt_char6 = AV10URL ;
         GXv_char7[0] = GXt_char6 ;
         new web.getlinkmenu(remoteHandle, context).execute( 0, (short)(0), AV8PerfilId, A1937MenuItemId, A1929MenuOpcCod, GXv_char7) ;
         gethome.this.GXt_char6 = GXv_char7[0] ;
         AV10URL = GXt_char6 ;
         AV15MenuOpcCod = A1929MenuOpcCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = gethome.this.AV10URL;
      this.aP1[0] = gethome.this.AV15MenuOpcCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10URL = "" ;
      AV15MenuOpcCod = "" ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new long[1] ;
      scmdbuf = "" ;
      P01UT2_A1934MenuHomeEs = new boolean[] {false} ;
      P01UT2_A1928MenuVerId = new long[1] ;
      P01UT2_A1925PerfilId = new byte[1] ;
      P01UT2_A1923RolId = new byte[1] ;
      P01UT2_A1937MenuItemId = new String[] {""} ;
      P01UT2_A1929MenuOpcCod = new String[] {""} ;
      A1937MenuItemId = "" ;
      A1929MenuOpcCod = "" ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gethome__default(),
         new Object[] {
             new Object[] {
            P01UT2_A1934MenuHomeEs, P01UT2_A1928MenuVerId, P01UT2_A1925PerfilId, P01UT2_A1923RolId, P01UT2_A1937MenuItemId, P01UT2_A1929MenuOpcCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13RolId ;
   private byte GXv_int3[] ;
   private byte AV8PerfilId ;
   private byte GXv_int4[] ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short AV14SecUserId ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private long AV9MenuVerId ;
   private long GXv_int5[] ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean A1934MenuHomeEs ;
   private String AV10URL ;
   private String AV15MenuOpcCod ;
   private String A1937MenuItemId ;
   private String A1929MenuOpcCod ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01UT2_A1934MenuHomeEs ;
   private long[] P01UT2_A1928MenuVerId ;
   private byte[] P01UT2_A1925PerfilId ;
   private byte[] P01UT2_A1923RolId ;
   private String[] P01UT2_A1937MenuItemId ;
   private String[] P01UT2_A1929MenuOpcCod ;
}

final  class gethome__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UT2", "SELECT MenuHomeEs, MenuVerId, PerfilId, RolId, MenuItemId, MenuOpcCod FROM MenuVersionesOpciones WHERE (RolId = ? and PerfilId = ? and MenuVerId = ?) AND (MenuHomeEs = TRUE) ORDER BY RolId, PerfilId, MenuVerId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
            case 0 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               return;
      }
   }

}

