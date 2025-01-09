package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newopcionmenu extends GXProcedure
{
   public newopcionmenu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newopcionmenu.class ), "" );
   }

   public newopcionmenu( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( byte aP0 ,
                        byte aP1 ,
                        long aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        byte aP9 ,
                        String aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( byte aP0 ,
                             byte aP1 ,
                             long aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             byte aP9 ,
                             String aP10 )
   {
      newopcionmenu.this.AV8RolId = aP0;
      newopcionmenu.this.AV9PerfilId = aP1;
      newopcionmenu.this.AV10MenuVerId = aP2;
      newopcionmenu.this.AV11MenuOpcCod = aP3;
      newopcionmenu.this.AV31dummy_SVGId = aP4;
      newopcionmenu.this.AV24parmMenuOpcTitulo = aP5;
      newopcionmenu.this.AV18MenuItemId = aP6;
      newopcionmenu.this.AV15MenuOpcPadre = aP7;
      newopcionmenu.this.AV16MenuHomeEs = aP8;
      newopcionmenu.this.AV19MenuItemOrd = aP9;
      newopcionmenu.this.AV32dummy_nombreFoto = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV25defMenuOpcTitulo ;
      GXv_char2[0] = AV26MItemIcoSVG ;
      GXv_char3[0] = AV27MitemIcoImg ;
      GXv_char4[0] = AV30MItemBienImgDef ;
      GXv_char5[0] = AV28MItemBienTitDef ;
      GXv_char6[0] = AV29MItemBienTextDef ;
      new web.getmenuitempredeterminados(remoteHandle, context).execute( AV9PerfilId, AV18MenuItemId, GXv_char1, GXv_char2, GXv_char3, GXv_char4, GXv_char5, GXv_char6) ;
      newopcionmenu.this.AV25defMenuOpcTitulo = GXv_char1[0] ;
      newopcionmenu.this.AV26MItemIcoSVG = GXv_char2[0] ;
      newopcionmenu.this.AV27MitemIcoImg = GXv_char3[0] ;
      newopcionmenu.this.AV30MItemBienImgDef = GXv_char4[0] ;
      newopcionmenu.this.AV28MItemBienTitDef = GXv_char5[0] ;
      newopcionmenu.this.AV29MItemBienTextDef = GXv_char6[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, httpContext.getMessage( "crea &MenuOpcCod ", "")+GXutil.trim( AV11MenuOpcCod)+httpContext.getMessage( " &MenuItemId ", "")+AV18MenuItemId) ;
      AV36GXLvl4 = (byte)(0) ;
      /* Using cursor P01UI2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV8RolId), Byte.valueOf(AV9PerfilId), Long.valueOf(AV10MenuVerId), AV11MenuOpcCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1929MenuOpcCod = P01UI2_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P01UI2_A1928MenuVerId[0] ;
         A1925PerfilId = P01UI2_A1925PerfilId[0] ;
         A1923RolId = P01UI2_A1923RolId[0] ;
         A1943MenuItemImgNom = P01UI2_A1943MenuItemImgNom[0] ;
         A1948MenuBienveImgNom = P01UI2_A1948MenuBienveImgNom[0] ;
         A1942MenuItemImgExt = P01UI2_A1942MenuItemImgExt[0] ;
         A1947MenuBienveImgExt = P01UI2_A1947MenuBienveImgExt[0] ;
         A1935SVGId = P01UI2_A1935SVGId[0] ;
         n1935SVGId = P01UI2_n1935SVGId[0] ;
         A1931MenuOpcTitulo = P01UI2_A1931MenuOpcTitulo[0] ;
         A1937MenuItemId = P01UI2_A1937MenuItemId[0] ;
         A1933MenuOpcPadre = P01UI2_A1933MenuOpcPadre[0] ;
         n1933MenuOpcPadre = P01UI2_n1933MenuOpcPadre[0] ;
         A1934MenuHomeEs = P01UI2_A1934MenuHomeEs[0] ;
         A1940MenuItemOrd = P01UI2_A1940MenuItemOrd[0] ;
         A1941MenuItemImg = P01UI2_A1941MenuItemImg[0] ;
         A1946MenuBienveImg = P01UI2_A1946MenuBienveImg[0] ;
         A1949MenuBienveTitulo = P01UI2_A1949MenuBienveTitulo[0] ;
         A1950MenuBienveTexto = P01UI2_A1950MenuBienveTexto[0] ;
         AV36GXLvl4 = (byte)(1) ;
         if ( ! (GXutil.strcmp("", AV26MItemIcoSVG)==0) )
         {
            A1935SVGId = AV26MItemIcoSVG ;
            n1935SVGId = false ;
         }
         else
         {
            A1935SVGId = "" ;
            n1935SVGId = false ;
            n1935SVGId = true ;
         }
         if ( ! (GXutil.strcmp("", AV24parmMenuOpcTitulo)==0) )
         {
            AV14MenuOpcTitulo = AV24parmMenuOpcTitulo ;
         }
         else
         {
            AV14MenuOpcTitulo = AV25defMenuOpcTitulo ;
         }
         A1931MenuOpcTitulo = AV14MenuOpcTitulo ;
         A1937MenuItemId = GXutil.trim( AV18MenuItemId) ;
         if ( ! (GXutil.strcmp("", AV15MenuOpcPadre)==0) )
         {
            A1933MenuOpcPadre = GXutil.trim( AV15MenuOpcPadre) ;
            n1933MenuOpcPadre = false ;
         }
         else
         {
            A1933MenuOpcPadre = "" ;
            n1933MenuOpcPadre = false ;
            n1933MenuOpcPadre = true ;
         }
         A1934MenuHomeEs = AV16MenuHomeEs ;
         A1940MenuItemOrd = AV19MenuItemOrd ;
         A1941MenuItemImg = AV27MitemIcoImg ;
         A1946MenuBienveImg = AV30MItemBienImgDef ;
         A1949MenuBienveTitulo = AV28MItemBienTitDef ;
         A1950MenuBienveTexto = AV29MItemBienTextDef ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01UI3 */
         A1942MenuItemImgExt = com.genexus.util.GXFile.getgxFileext( A1941MenuItemImg) ;
         A1947MenuBienveImgExt = com.genexus.util.GXFile.getgxFileext( A1946MenuBienveImg) ;
         A1943MenuItemImgNom = com.genexus.util.GXFile.getgxFilename( A1941MenuItemImg) ;
         A1948MenuBienveImgNom = com.genexus.util.GXFile.getgxFilename( A1946MenuBienveImg) ;
         pr_default.execute(1, new Object[] {Boolean.valueOf(n1935SVGId), A1935SVGId, A1931MenuOpcTitulo, A1937MenuItemId, Boolean.valueOf(n1933MenuOpcPadre), A1933MenuOpcPadre, Boolean.valueOf(A1934MenuHomeEs), Byte.valueOf(A1940MenuItemOrd), A1941MenuItemImg, A1946MenuBienveImg, A1949MenuBienveTitulo, A1950MenuBienveTexto, A1942MenuItemImgExt, A1947MenuBienveImgExt, A1943MenuItemImgNom, A1948MenuBienveImgNom, Byte.valueOf(A1923RolId), Byte.valueOf(A1925PerfilId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
         if (true) break;
         /* Using cursor P01UI4 */
         A1942MenuItemImgExt = com.genexus.util.GXFile.getgxFileext( A1941MenuItemImg) ;
         A1947MenuBienveImgExt = com.genexus.util.GXFile.getgxFileext( A1946MenuBienveImg) ;
         A1943MenuItemImgNom = com.genexus.util.GXFile.getgxFilename( A1941MenuItemImg) ;
         A1948MenuBienveImgNom = com.genexus.util.GXFile.getgxFilename( A1946MenuBienveImg) ;
         pr_default.execute(2, new Object[] {Boolean.valueOf(n1935SVGId), A1935SVGId, A1931MenuOpcTitulo, A1937MenuItemId, Boolean.valueOf(n1933MenuOpcPadre), A1933MenuOpcPadre, Boolean.valueOf(A1934MenuHomeEs), Byte.valueOf(A1940MenuItemOrd), A1941MenuItemImg, A1946MenuBienveImg, A1949MenuBienveTitulo, A1950MenuBienveTexto, A1942MenuItemImgExt, A1947MenuBienveImgExt, A1943MenuItemImgNom, A1948MenuBienveImgNom, Byte.valueOf(A1923RolId), Byte.valueOf(A1925PerfilId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV36GXLvl4 == 0 )
      {
         /*
            INSERT RECORD ON TABLE MenuVersionesOpciones

         */
         A1923RolId = AV8RolId ;
         A1925PerfilId = AV9PerfilId ;
         A1928MenuVerId = AV10MenuVerId ;
         A1929MenuOpcCod = GXutil.trim( AV11MenuOpcCod) ;
         if ( ! (GXutil.strcmp("", AV26MItemIcoSVG)==0) )
         {
            A1935SVGId = AV26MItemIcoSVG ;
            n1935SVGId = false ;
         }
         else
         {
            A1935SVGId = "" ;
            n1935SVGId = false ;
            n1935SVGId = true ;
         }
         if ( ! (GXutil.strcmp("", AV24parmMenuOpcTitulo)==0) )
         {
            AV14MenuOpcTitulo = AV24parmMenuOpcTitulo ;
         }
         else
         {
            AV14MenuOpcTitulo = AV25defMenuOpcTitulo ;
         }
         A1931MenuOpcTitulo = AV14MenuOpcTitulo ;
         A1937MenuItemId = GXutil.trim( AV18MenuItemId) ;
         if ( ! (GXutil.strcmp("", AV15MenuOpcPadre)==0) )
         {
            A1933MenuOpcPadre = GXutil.trim( AV15MenuOpcPadre) ;
            n1933MenuOpcPadre = false ;
         }
         else
         {
            A1933MenuOpcPadre = "" ;
            n1933MenuOpcPadre = false ;
            n1933MenuOpcPadre = true ;
         }
         A1934MenuHomeEs = AV16MenuHomeEs ;
         A1940MenuItemOrd = AV19MenuItemOrd ;
         A1941MenuItemImg = AV27MitemIcoImg ;
         A1946MenuBienveImg = AV30MItemBienImgDef ;
         A1949MenuBienveTitulo = AV28MItemBienTitDef ;
         A1950MenuBienveTexto = AV29MItemBienTextDef ;
         A1951MenuBienveVisible = true ;
         A1943MenuItemImgNom = "" ;
         A1942MenuItemImgExt = "" ;
         A1948MenuBienveImgNom = "" ;
         A1947MenuBienveImgExt = "" ;
         /* Using cursor P01UI5 */
         A1943MenuItemImgNom = com.genexus.util.GXFile.getgxFilename( A1941MenuItemImg) ;
         A1942MenuItemImgExt = com.genexus.util.GXFile.getgxFileext( A1941MenuItemImg) ;
         A1948MenuBienveImgNom = com.genexus.util.GXFile.getgxFilename( A1946MenuBienveImg) ;
         A1947MenuBienveImgExt = com.genexus.util.GXFile.getgxFileext( A1946MenuBienveImg) ;
         pr_default.execute(3, new Object[] {Byte.valueOf(A1923RolId), Byte.valueOf(A1925PerfilId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod, A1931MenuOpcTitulo, A1937MenuItemId, Boolean.valueOf(n1933MenuOpcPadre), A1933MenuOpcPadre, Boolean.valueOf(A1934MenuHomeEs), Byte.valueOf(A1940MenuItemOrd), Boolean.valueOf(n1935SVGId), A1935SVGId, A1941MenuItemImg, A1943MenuItemImgNom, A1942MenuItemImgExt, A1946MenuBienveImg, A1948MenuBienveImgNom, A1947MenuBienveImgExt, A1949MenuBienveTitulo, A1950MenuBienveTexto, Boolean.valueOf(A1951MenuBienveVisible)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVersionesOpciones");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newopcionmenu");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25defMenuOpcTitulo = "" ;
      GXv_char1 = new String[1] ;
      AV26MItemIcoSVG = "" ;
      GXv_char2 = new String[1] ;
      AV27MitemIcoImg = "" ;
      GXv_char3 = new String[1] ;
      AV30MItemBienImgDef = "" ;
      GXv_char4 = new String[1] ;
      AV28MItemBienTitDef = "" ;
      GXv_char5 = new String[1] ;
      AV29MItemBienTextDef = "" ;
      GXv_char6 = new String[1] ;
      AV35Pgmname = "" ;
      scmdbuf = "" ;
      P01UI2_A1929MenuOpcCod = new String[] {""} ;
      P01UI2_A1928MenuVerId = new long[1] ;
      P01UI2_A1925PerfilId = new byte[1] ;
      P01UI2_A1923RolId = new byte[1] ;
      P01UI2_A1943MenuItemImgNom = new String[] {""} ;
      P01UI2_A1948MenuBienveImgNom = new String[] {""} ;
      P01UI2_A1942MenuItemImgExt = new String[] {""} ;
      P01UI2_A1947MenuBienveImgExt = new String[] {""} ;
      P01UI2_A1935SVGId = new String[] {""} ;
      P01UI2_n1935SVGId = new boolean[] {false} ;
      P01UI2_A1931MenuOpcTitulo = new String[] {""} ;
      P01UI2_A1937MenuItemId = new String[] {""} ;
      P01UI2_A1933MenuOpcPadre = new String[] {""} ;
      P01UI2_n1933MenuOpcPadre = new boolean[] {false} ;
      P01UI2_A1934MenuHomeEs = new boolean[] {false} ;
      P01UI2_A1940MenuItemOrd = new byte[1] ;
      P01UI2_A1941MenuItemImg = new String[] {""} ;
      P01UI2_A1946MenuBienveImg = new String[] {""} ;
      P01UI2_A1949MenuBienveTitulo = new String[] {""} ;
      P01UI2_A1950MenuBienveTexto = new String[] {""} ;
      A1929MenuOpcCod = "" ;
      A1943MenuItemImgNom = "" ;
      A1948MenuBienveImgNom = "" ;
      A1942MenuItemImgExt = "" ;
      A1947MenuBienveImgExt = "" ;
      A1935SVGId = "" ;
      A1931MenuOpcTitulo = "" ;
      A1937MenuItemId = "" ;
      A1933MenuOpcPadre = "" ;
      A1941MenuItemImg = "" ;
      A1946MenuBienveImg = "" ;
      A1949MenuBienveTitulo = "" ;
      A1950MenuBienveTexto = "" ;
      AV14MenuOpcTitulo = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newopcionmenu__default(),
         new Object[] {
             new Object[] {
            P01UI2_A1929MenuOpcCod, P01UI2_A1928MenuVerId, P01UI2_A1925PerfilId, P01UI2_A1923RolId, P01UI2_A1943MenuItemImgNom, P01UI2_A1948MenuBienveImgNom, P01UI2_A1942MenuItemImgExt, P01UI2_A1947MenuBienveImgExt, P01UI2_A1935SVGId, P01UI2_n1935SVGId,
            P01UI2_A1931MenuOpcTitulo, P01UI2_A1937MenuItemId, P01UI2_A1933MenuOpcPadre, P01UI2_n1933MenuOpcPadre, P01UI2_A1934MenuHomeEs, P01UI2_A1940MenuItemOrd, P01UI2_A1941MenuItemImg, P01UI2_A1946MenuBienveImg, P01UI2_A1949MenuBienveTitulo, P01UI2_A1950MenuBienveTexto
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV35Pgmname = "newOpcionMenu" ;
      /* GeneXus formulas. */
      AV35Pgmname = "newOpcionMenu" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8RolId ;
   private byte AV9PerfilId ;
   private byte AV19MenuItemOrd ;
   private byte AV36GXLvl4 ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private byte A1940MenuItemOrd ;
   private short Gx_err ;
   private int GX_INS256 ;
   private long AV10MenuVerId ;
   private long A1928MenuVerId ;
   private String AV31dummy_SVGId ;
   private String AV15MenuOpcPadre ;
   private String GXv_char1[] ;
   private String AV26MItemIcoSVG ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String AV35Pgmname ;
   private String scmdbuf ;
   private String A1942MenuItemImgExt ;
   private String A1947MenuBienveImgExt ;
   private String A1935SVGId ;
   private String A1933MenuOpcPadre ;
   private String Gx_emsg ;
   private boolean AV16MenuHomeEs ;
   private boolean n1935SVGId ;
   private boolean n1933MenuOpcPadre ;
   private boolean A1934MenuHomeEs ;
   private boolean A1951MenuBienveVisible ;
   private String AV29MItemBienTextDef ;
   private String A1950MenuBienveTexto ;
   private String AV27MitemIcoImg ;
   private String AV30MItemBienImgDef ;
   private String A1941MenuItemImg ;
   private String A1946MenuBienveImg ;
   private String AV11MenuOpcCod ;
   private String AV24parmMenuOpcTitulo ;
   private String AV18MenuItemId ;
   private String AV32dummy_nombreFoto ;
   private String AV25defMenuOpcTitulo ;
   private String AV28MItemBienTitDef ;
   private String A1929MenuOpcCod ;
   private String A1943MenuItemImgNom ;
   private String A1948MenuBienveImgNom ;
   private String A1931MenuOpcTitulo ;
   private String A1937MenuItemId ;
   private String A1949MenuBienveTitulo ;
   private String AV14MenuOpcTitulo ;
   private IDataStoreProvider pr_default ;
   private String[] P01UI2_A1929MenuOpcCod ;
   private long[] P01UI2_A1928MenuVerId ;
   private byte[] P01UI2_A1925PerfilId ;
   private byte[] P01UI2_A1923RolId ;
   private String[] P01UI2_A1943MenuItemImgNom ;
   private String[] P01UI2_A1948MenuBienveImgNom ;
   private String[] P01UI2_A1942MenuItemImgExt ;
   private String[] P01UI2_A1947MenuBienveImgExt ;
   private String[] P01UI2_A1935SVGId ;
   private boolean[] P01UI2_n1935SVGId ;
   private String[] P01UI2_A1931MenuOpcTitulo ;
   private String[] P01UI2_A1937MenuItemId ;
   private String[] P01UI2_A1933MenuOpcPadre ;
   private boolean[] P01UI2_n1933MenuOpcPadre ;
   private boolean[] P01UI2_A1934MenuHomeEs ;
   private byte[] P01UI2_A1940MenuItemOrd ;
   private String[] P01UI2_A1941MenuItemImg ;
   private String[] P01UI2_A1946MenuBienveImg ;
   private String[] P01UI2_A1949MenuBienveTitulo ;
   private String[] P01UI2_A1950MenuBienveTexto ;
}

final  class newopcionmenu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UI2", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuItemImgNom, MenuBienveImgNom, MenuItemImgExt, MenuBienveImgExt, SVGId, MenuOpcTitulo, MenuItemId, MenuOpcPadre, MenuHomeEs, MenuItemOrd, MenuItemImg, MenuBienveImg, MenuBienveTitulo, MenuBienveTexto FROM MenuVersionesOpciones WHERE (RolId = ? and PerfilId = ? and MenuVerId = ?) AND (MenuOpcCod = ( RTRIM(LTRIM(?)))) ORDER BY RolId, PerfilId, MenuVerId  LIMIT 1 FOR UPDATE OF MenuVersionesOpciones",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01UI3", "SAVEPOINT gxupdate;UPDATE MenuVersionesOpciones SET SVGId=?, MenuOpcTitulo=?, MenuItemId=?, MenuOpcPadre=?, MenuHomeEs=?, MenuItemOrd=?, MenuItemImg=?, MenuBienveImg=?, MenuBienveTitulo=?, MenuBienveTexto=?, MenuItemImgExt=?, MenuBienveImgExt=?, MenuItemImgNom=?, MenuBienveImgNom=?  WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01UI4", "SAVEPOINT gxupdate;UPDATE MenuVersionesOpciones SET SVGId=?, MenuOpcTitulo=?, MenuItemId=?, MenuOpcPadre=?, MenuHomeEs=?, MenuItemOrd=?, MenuItemImg=?, MenuBienveImg=?, MenuBienveTitulo=?, MenuBienveTexto=?, MenuItemImgExt=?, MenuBienveImgExt=?, MenuItemImgNom=?, MenuBienveImgNom=?  WHERE RolId = ? AND PerfilId = ? AND MenuVerId = ? AND MenuOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01UI5", "SAVEPOINT gxupdate;INSERT INTO MenuVersionesOpciones(RolId, PerfilId, MenuVerId, MenuOpcCod, MenuOpcTitulo, MenuItemId, MenuOpcPadre, MenuHomeEs, MenuItemOrd, SVGId, MenuItemImg, MenuItemImgNom, MenuItemImgExt, MenuBienveImg, MenuBienveImgNom, MenuBienveImgExt, MenuBienveTitulo, MenuBienveTexto, MenuBienveVisible, MenuOpcObj, MenuOpcInst, MenuOpcForRet) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((String[]) buf[12])[0] = rslt.getString(12, 40);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((boolean[]) buf[14])[0] = rslt.getBoolean(13);
               ((byte[]) buf[15])[0] = rslt.getByte(14);
               ((String[]) buf[16])[0] = rslt.getBLOBFile(15, rslt.getString(7, 20), rslt.getVarchar(5));
               ((String[]) buf[17])[0] = rslt.getBLOBFile(16, rslt.getString(8, 20), rslt.getVarchar(6));
               ((String[]) buf[18])[0] = rslt.getVarchar(17);
               ((String[]) buf[19])[0] = rslt.getLongVarchar(18);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setVarchar(2, (String)parms[2], 400, false);
               stmt.setVarchar(3, (String)parms[3], 40, false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[5], 40);
               }
               stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               stmt.setByte(6, ((Number) parms[7]).byteValue());
               stmt.setBLOBFile(7, (String)parms[8]);
               stmt.setBLOBFile(8, (String)parms[9]);
               stmt.setVarchar(9, (String)parms[10], 400, false);
               stmt.setNLongVarchar(10, (String)parms[11], false);
               stmt.setString(11, (String)parms[12], 20);
               stmt.setString(12, (String)parms[13], 20);
               stmt.setVarchar(13, (String)parms[14], 400, false);
               stmt.setVarchar(14, (String)parms[15], 400, false);
               stmt.setByte(15, ((Number) parms[16]).byteValue());
               stmt.setByte(16, ((Number) parms[17]).byteValue());
               stmt.setLong(17, ((Number) parms[18]).longValue());
               stmt.setVarchar(18, (String)parms[19], 100, false);
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(1, (String)parms[1], 20);
               }
               stmt.setVarchar(2, (String)parms[2], 400, false);
               stmt.setVarchar(3, (String)parms[3], 40, false);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[5], 40);
               }
               stmt.setBoolean(5, ((Boolean) parms[6]).booleanValue());
               stmt.setByte(6, ((Number) parms[7]).byteValue());
               stmt.setBLOBFile(7, (String)parms[8]);
               stmt.setBLOBFile(8, (String)parms[9]);
               stmt.setVarchar(9, (String)parms[10], 400, false);
               stmt.setNLongVarchar(10, (String)parms[11], false);
               stmt.setString(11, (String)parms[12], 20);
               stmt.setString(12, (String)parms[13], 20);
               stmt.setVarchar(13, (String)parms[14], 400, false);
               stmt.setVarchar(14, (String)parms[15], 400, false);
               stmt.setByte(15, ((Number) parms[16]).byteValue());
               stmt.setByte(16, ((Number) parms[17]).byteValue());
               stmt.setLong(17, ((Number) parms[18]).longValue());
               stmt.setVarchar(18, (String)parms[19], 100, false);
               return;
            case 3 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setVarchar(4, (String)parms[3], 100, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[7], 40);
               }
               stmt.setBoolean(8, ((Boolean) parms[8]).booleanValue());
               stmt.setByte(9, ((Number) parms[9]).byteValue());
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[11], 20);
               }
               stmt.setBLOBFile(11, (String)parms[12]);
               stmt.setVarchar(12, (String)parms[13], 400, false);
               stmt.setString(13, (String)parms[14], 20);
               stmt.setBLOBFile(14, (String)parms[15]);
               stmt.setVarchar(15, (String)parms[16], 400, false);
               stmt.setString(16, (String)parms[17], 20);
               stmt.setVarchar(17, (String)parms[18], 400, false);
               stmt.setNLongVarchar(18, (String)parms[19], false);
               stmt.setBoolean(19, ((Boolean) parms[20]).booleanValue());
               return;
      }
   }

}

