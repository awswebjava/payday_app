package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlinkpadre extends GXProcedure
{
   public getlinkpadre( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlinkpadre.class ), "" );
   }

   public getlinkpadre( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 )
   {
      getlinkpadre.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      getlinkpadre.this.AV17CliCod = aP0;
      getlinkpadre.this.AV16EmpCod = aP1;
      getlinkpadre.this.AV9MenuOpcCod = aP2;
      getlinkpadre.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV12SecUserId ;
      GXv_int2[0] = GXt_int1 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int2) ;
      getlinkpadre.this.GXt_int1 = GXv_int2[0] ;
      AV12SecUserId = GXt_int1 ;
      GXv_int3[0] = AV11RolId ;
      GXv_int4[0] = AV10PerfilId ;
      GXv_int5[0] = AV8MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV12SecUserId, GXv_int3, GXv_int4, GXv_int5) ;
      getlinkpadre.this.AV11RolId = GXv_int3[0] ;
      getlinkpadre.this.AV10PerfilId = GXv_int4[0] ;
      getlinkpadre.this.AV8MenuVerId = GXv_int5[0] ;
      AV20GXLvl4 = (byte)(0) ;
      /* Using cursor P01UU2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV11RolId), Byte.valueOf(AV10PerfilId), Long.valueOf(AV8MenuVerId), AV9MenuOpcCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1929MenuOpcCod = P01UU2_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P01UU2_A1928MenuVerId[0] ;
         A1925PerfilId = P01UU2_A1925PerfilId[0] ;
         A1923RolId = P01UU2_A1923RolId[0] ;
         A1933MenuOpcPadre = P01UU2_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = P01UU2_n1933MenuOpcPadre[0] ;
         AV20GXLvl4 = (byte)(1) ;
         AV14MenuOpcPadre = GXutil.trim( A1933MenuOpcPadre) ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV20GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "none 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&RolId: ", "")+GXutil.trim( GXutil.str( AV11RolId, 2, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&PerfilId: ", "")+GXutil.trim( GXutil.str( AV10PerfilId, 2, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&MenuVerId: ", "")+GXutil.trim( GXutil.str( AV8MenuVerId, 15, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&MenuOpcCod: ", "")+GXutil.trim( AV9MenuOpcCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&MenuOpcPadre: \"", "")+AV14MenuOpcPadre+"\"") ;
      AV22GXLvl20 = (byte)(0) ;
      /* Using cursor P01UU3 */
      pr_default.execute(1, new Object[] {Byte.valueOf(AV11RolId), Byte.valueOf(AV10PerfilId), Long.valueOf(AV8MenuVerId), AV14MenuOpcPadre});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1929MenuOpcCod = P01UU3_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P01UU3_A1928MenuVerId[0] ;
         A1925PerfilId = P01UU3_A1925PerfilId[0] ;
         A1923RolId = P01UU3_A1923RolId[0] ;
         A1937MenuItemId = P01UU3_A1937MenuItemId[0] ;
         AV22GXLvl20 = (byte)(1) ;
         AV13MenuItemId = A1937MenuItemId ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      if ( AV22GXLvl20 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "none 2", "")) ;
      }
      if ( false )
      {
         new web.revisartematrimsporperformance(remoteHandle, context).execute( ) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&MenuItemId ", "")+AV13MenuItemId) ;
      GXv_char6[0] = AV15URL ;
      new web.getlinkmenu(remoteHandle, context).execute( AV17CliCod, AV16EmpCod, AV10PerfilId, AV13MenuItemId, AV14MenuOpcPadre, GXv_char6) ;
      getlinkpadre.this.AV15URL = GXv_char6[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getlinkpadre.this.AV15URL;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15URL = "" ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new long[1] ;
      scmdbuf = "" ;
      P01UU2_A1929MenuOpcCod = new String[] {""} ;
      P01UU2_A1928MenuVerId = new long[1] ;
      P01UU2_A1925PerfilId = new byte[1] ;
      P01UU2_A1923RolId = new byte[1] ;
      P01UU2_A1933MenuOpcPadre = new String[] {""} ;
      P01UU2_n1933MenuOpcPadre = new boolean[] {false} ;
      A1929MenuOpcCod = "" ;
      A1933MenuOpcPadre = "" ;
      AV14MenuOpcPadre = "" ;
      AV21Pgmname = "" ;
      P01UU3_A1929MenuOpcCod = new String[] {""} ;
      P01UU3_A1928MenuVerId = new long[1] ;
      P01UU3_A1925PerfilId = new byte[1] ;
      P01UU3_A1923RolId = new byte[1] ;
      P01UU3_A1937MenuItemId = new String[] {""} ;
      A1937MenuItemId = "" ;
      AV13MenuItemId = "" ;
      GXv_char6 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getlinkpadre__default(),
         new Object[] {
             new Object[] {
            P01UU2_A1929MenuOpcCod, P01UU2_A1928MenuVerId, P01UU2_A1925PerfilId, P01UU2_A1923RolId, P01UU2_A1933MenuOpcPadre, P01UU2_n1933MenuOpcPadre
            }
            , new Object[] {
            P01UU3_A1929MenuOpcCod, P01UU3_A1928MenuVerId, P01UU3_A1925PerfilId, P01UU3_A1923RolId, P01UU3_A1937MenuItemId
            }
         }
      );
      AV21Pgmname = "getLinkPadre" ;
      /* GeneXus formulas. */
      AV21Pgmname = "getLinkPadre" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11RolId ;
   private byte GXv_int3[] ;
   private byte AV10PerfilId ;
   private byte GXv_int4[] ;
   private byte AV20GXLvl4 ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private byte AV22GXLvl20 ;
   private short AV16EmpCod ;
   private short AV12SecUserId ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV17CliCod ;
   private long AV8MenuVerId ;
   private long GXv_int5[] ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String A1933MenuOpcPadre ;
   private String AV14MenuOpcPadre ;
   private String AV21Pgmname ;
   private String GXv_char6[] ;
   private boolean n1933MenuOpcPadre ;
   private String AV9MenuOpcCod ;
   private String AV15URL ;
   private String A1929MenuOpcCod ;
   private String A1937MenuItemId ;
   private String AV13MenuItemId ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UU2_A1929MenuOpcCod ;
   private long[] P01UU2_A1928MenuVerId ;
   private byte[] P01UU2_A1925PerfilId ;
   private byte[] P01UU2_A1923RolId ;
   private String[] P01UU2_A1933MenuOpcPadre ;
   private boolean[] P01UU2_n1933MenuOpcPadre ;
   private String[] P01UU3_A1929MenuOpcCod ;
   private long[] P01UU3_A1928MenuVerId ;
   private byte[] P01UU3_A1925PerfilId ;
   private byte[] P01UU3_A1923RolId ;
   private String[] P01UU3_A1937MenuItemId ;
}

final  class getlinkpadre__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UU2", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuOpcPadre FROM MenuVersionesOpciones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01UU3", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuItemId FROM MenuVersionesOpciones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
            case 1 :
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
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
   }

}

