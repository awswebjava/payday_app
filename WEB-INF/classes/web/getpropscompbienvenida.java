package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpropscompbienvenida extends GXProcedure
{
   public getpropscompbienvenida( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpropscompbienvenida.class ), "" );
   }

   public getpropscompbienvenida( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 ,
                              String[] aP1 ,
                              String[] aP2 ,
                              String[] aP3 )
   {
      getpropscompbienvenida.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             boolean[] aP4 )
   {
      getpropscompbienvenida.this.AV8MenuOpcCod = aP0;
      getpropscompbienvenida.this.aP1 = aP1;
      getpropscompbienvenida.this.aP2 = aP2;
      getpropscompbienvenida.this.aP3 = aP3;
      getpropscompbienvenida.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV16SecUserId ;
      GXv_int2[0] = GXt_int1 ;
      new web.getusuloggedid(remoteHandle, context).execute( GXv_int2) ;
      getpropscompbienvenida.this.GXt_int1 = GXv_int2[0] ;
      AV16SecUserId = GXt_int1 ;
      GXv_int3[0] = AV15RolId ;
      GXv_int4[0] = AV14PerfilId ;
      GXv_int5[0] = AV13MenuVerId ;
      new web.getusumenu(remoteHandle, context).execute( AV16SecUserId, GXv_int3, GXv_int4, GXv_int5) ;
      getpropscompbienvenida.this.AV15RolId = GXv_int3[0] ;
      getpropscompbienvenida.this.AV14PerfilId = GXv_int4[0] ;
      getpropscompbienvenida.this.AV13MenuVerId = GXv_int5[0] ;
      /* Using cursor P01V92 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV15RolId), Byte.valueOf(AV14PerfilId), Long.valueOf(AV13MenuVerId), AV8MenuOpcCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1929MenuOpcCod = P01V92_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P01V92_A1928MenuVerId[0] ;
         A1925PerfilId = P01V92_A1925PerfilId[0] ;
         A1923RolId = P01V92_A1923RolId[0] ;
         A1948MenuBienveImgNom = P01V92_A1948MenuBienveImgNom[0] ;
         A1947MenuBienveImgExt = P01V92_A1947MenuBienveImgExt[0] ;
         A1951MenuBienveVisible = P01V92_A1951MenuBienveVisible[0] ;
         A1946MenuBienveImg = P01V92_A1946MenuBienveImg[0] ;
         A1949MenuBienveTitulo = P01V92_A1949MenuBienveTitulo[0] ;
         A1950MenuBienveTexto = P01V92_A1950MenuBienveTexto[0] ;
         AV12MenuBienveVisible = A1951MenuBienveVisible ;
         AV9MenuBienveImgURL = A1946MenuBienveImg ;
         AV10MenuBienveTitulo = A1949MenuBienveTitulo ;
         AV11MenuBienveTexto = A1950MenuBienveTexto ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getpropscompbienvenida.this.AV9MenuBienveImgURL;
      this.aP2[0] = getpropscompbienvenida.this.AV10MenuBienveTitulo;
      this.aP3[0] = getpropscompbienvenida.this.AV11MenuBienveTexto;
      this.aP4[0] = getpropscompbienvenida.this.AV12MenuBienveVisible;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9MenuBienveImgURL = "" ;
      AV10MenuBienveTitulo = "" ;
      AV11MenuBienveTexto = "" ;
      GXv_int2 = new short[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int5 = new long[1] ;
      scmdbuf = "" ;
      P01V92_A1929MenuOpcCod = new String[] {""} ;
      P01V92_A1928MenuVerId = new long[1] ;
      P01V92_A1925PerfilId = new byte[1] ;
      P01V92_A1923RolId = new byte[1] ;
      P01V92_A1948MenuBienveImgNom = new String[] {""} ;
      P01V92_A1947MenuBienveImgExt = new String[] {""} ;
      P01V92_A1951MenuBienveVisible = new boolean[] {false} ;
      P01V92_A1946MenuBienveImg = new String[] {""} ;
      P01V92_A1949MenuBienveTitulo = new String[] {""} ;
      P01V92_A1950MenuBienveTexto = new String[] {""} ;
      A1929MenuOpcCod = "" ;
      A1948MenuBienveImgNom = "" ;
      A1947MenuBienveImgExt = "" ;
      A1946MenuBienveImg = "" ;
      A1949MenuBienveTitulo = "" ;
      A1950MenuBienveTexto = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpropscompbienvenida__default(),
         new Object[] {
             new Object[] {
            P01V92_A1929MenuOpcCod, P01V92_A1928MenuVerId, P01V92_A1925PerfilId, P01V92_A1923RolId, P01V92_A1948MenuBienveImgNom, P01V92_A1947MenuBienveImgExt, P01V92_A1951MenuBienveVisible, P01V92_A1946MenuBienveImg, P01V92_A1949MenuBienveTitulo, P01V92_A1950MenuBienveTexto
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15RolId ;
   private byte GXv_int3[] ;
   private byte AV14PerfilId ;
   private byte GXv_int4[] ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short AV16SecUserId ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private long AV13MenuVerId ;
   private long GXv_int5[] ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String A1947MenuBienveImgExt ;
   private boolean AV12MenuBienveVisible ;
   private boolean A1951MenuBienveVisible ;
   private String AV11MenuBienveTexto ;
   private String A1950MenuBienveTexto ;
   private String A1946MenuBienveImg ;
   private String AV8MenuOpcCod ;
   private String AV9MenuBienveImgURL ;
   private String AV10MenuBienveTitulo ;
   private String A1929MenuOpcCod ;
   private String A1948MenuBienveImgNom ;
   private String A1949MenuBienveTitulo ;
   private boolean[] aP4 ;
   private String[] aP1 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01V92_A1929MenuOpcCod ;
   private long[] P01V92_A1928MenuVerId ;
   private byte[] P01V92_A1925PerfilId ;
   private byte[] P01V92_A1923RolId ;
   private String[] P01V92_A1948MenuBienveImgNom ;
   private String[] P01V92_A1947MenuBienveImgExt ;
   private boolean[] P01V92_A1951MenuBienveVisible ;
   private String[] P01V92_A1946MenuBienveImg ;
   private String[] P01V92_A1949MenuBienveTitulo ;
   private String[] P01V92_A1950MenuBienveTexto ;
}

final  class getpropscompbienvenida__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01V92", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuBienveImgNom, MenuBienveImgExt, MenuBienveVisible, MenuBienveImg, MenuBienveTitulo, MenuBienveTexto FROM MenuVersionesOpciones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getBLOBFile(8, rslt.getString(6, 20), rslt.getVarchar(5));
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(10);
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

