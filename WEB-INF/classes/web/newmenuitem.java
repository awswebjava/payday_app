package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newmenuitem extends GXProcedure
{
   public newmenuitem( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newmenuitem.class ), "" );
   }

   public newmenuitem( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( byte aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        String aP4 ,
                        boolean aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( byte aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             String aP4 ,
                             boolean aP5 )
   {
      newmenuitem.this.AV12PerfilId = aP0;
      newmenuitem.this.AV8MenuItemId = aP1;
      newmenuitem.this.AV11parmMenuItemTitulo = aP2;
      newmenuitem.this.AV10MItemEsMenu = aP3;
      newmenuitem.this.AV18MItemPadreDef = aP4;
      newmenuitem.this.AV19MItemPadreObl = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( (GXutil.strcmp("", AV11parmMenuItemTitulo)==0) )
      {
         AV9MenuItemTitulo = GXutil.trim( AV8MenuItemId) ;
      }
      else
      {
         AV9MenuItemTitulo = AV11parmMenuItemTitulo ;
      }
      AV27GXLvl7 = (byte)(0) ;
      /* Using cursor P01UK2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV12PerfilId), AV8MenuItemId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1937MenuItemId = P01UK2_A1937MenuItemId[0] ;
         A1925PerfilId = P01UK2_A1925PerfilId[0] ;
         A1960MitemIcoImgNom = P01UK2_A1960MitemIcoImgNom[0] ;
         A1954MItemBienImgNom = P01UK2_A1954MItemBienImgNom[0] ;
         A1959MItemIcoImgExt = P01UK2_A1959MItemIcoImgExt[0] ;
         A1953MItemBienImgExt = P01UK2_A1953MItemBienImgExt[0] ;
         A1939MenuItemTitulo = P01UK2_A1939MenuItemTitulo[0] ;
         A1938MItemEsMenu = P01UK2_A1938MItemEsMenu[0] ;
         A1944MItemPadreDef = P01UK2_A1944MItemPadreDef[0] ;
         n1944MItemPadreDef = P01UK2_n1944MItemPadreDef[0] ;
         A1945MItemPadreObl = P01UK2_A1945MItemPadreObl[0] ;
         A1958MitemIcoImg = P01UK2_A1958MitemIcoImg[0] ;
         A1957MItemIcoSVG = P01UK2_A1957MItemIcoSVG[0] ;
         n1957MItemIcoSVG = P01UK2_n1957MItemIcoSVG[0] ;
         A1952MItemBienImgDef = P01UK2_A1952MItemBienImgDef[0] ;
         A1955MItemBienTitDef = P01UK2_A1955MItemBienTitDef[0] ;
         A1956MItemBienTextDef = P01UK2_A1956MItemBienTextDef[0] ;
         A1961MItemHelp = P01UK2_A1961MItemHelp[0] ;
         AV27GXLvl7 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "new con \"", "")+AV8MenuItemId+httpContext.getMessage( "\" &PerfilId ", "")+GXutil.trim( GXutil.str( AV12PerfilId, 2, 0))) ;
         A1939MenuItemTitulo = AV9MenuItemTitulo ;
         A1938MItemEsMenu = AV10MItemEsMenu ;
         if ( ! (GXutil.strcmp("", AV18MItemPadreDef)==0) )
         {
            A1944MItemPadreDef = GXutil.trim( AV18MItemPadreDef) ;
            n1944MItemPadreDef = false ;
         }
         else
         {
            A1944MItemPadreDef = "" ;
            n1944MItemPadreDef = false ;
            n1944MItemPadreDef = true ;
         }
         A1945MItemPadreObl = AV19MItemPadreObl ;
         AV23rutaFotoIconos = httpContext.getMessage( "C:\\sueldos\\fotos\\menu\\", "") ;
         GXv_char1[0] = AV16MitemIcoImg_nombreFoto ;
         new web.getitemiconoimgpredeterminada(remoteHandle, context).execute( AV8MenuItemId, GXv_char1) ;
         newmenuitem.this.AV16MitemIcoImg_nombreFoto = GXv_char1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&MenuItemId ", "")+AV8MenuItemId+httpContext.getMessage( " devuelve &MitemIcoImg_nombreFoto ", "")+AV16MitemIcoImg_nombreFoto) ;
         if ( ! (GXutil.strcmp("", AV16MitemIcoImg_nombreFoto)==0) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "es foto", "")) ;
            AV20pathFoto = GXutil.trim( AV23rutaFotoIconos) + GXutil.trim( AV16MitemIcoImg_nombreFoto) + httpContext.getMessage( ".png", "") ;
            A1958MitemIcoImg = AV20pathFoto ;
            A1957MItemIcoSVG = "" ;
            n1957MItemIcoSVG = false ;
            n1957MItemIcoSVG = true ;
         }
         else
         {
            GXt_char2 = AV17MItemIcoSVG ;
            GXv_char1[0] = GXt_char2 ;
            new web.svgid_homeiconos(remoteHandle, context).execute( AV8MenuItemId, GXv_char1) ;
            newmenuitem.this.GXt_char2 = GXv_char1[0] ;
            AV17MItemIcoSVG = GXt_char2 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "es svg", "")) ;
            if ( ! (GXutil.strcmp("", AV17MItemIcoSVG)==0) )
            {
               A1957MItemIcoSVG = AV17MItemIcoSVG ;
               n1957MItemIcoSVG = false ;
            }
            else
            {
               A1957MItemIcoSVG = "" ;
               n1957MItemIcoSVG = false ;
               n1957MItemIcoSVG = true ;
            }
         }
         AV24rutaFotoBienvenidas = httpContext.getMessage( "C:\\sueldos\\fotos\\menu\\Small\\importar\\", "") ;
         GXv_char1[0] = AV22MItemBienImgDef_nombreFoto ;
         new web.getitembienvenidaimgpredeterminada(remoteHandle, context).execute( AV8MenuItemId, GXv_char1) ;
         newmenuitem.this.AV22MItemBienImgDef_nombreFoto = GXv_char1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "bienvenida menuitemid ", "")+GXutil.trim( AV8MenuItemId)+httpContext.getMessage( " foto ", "")+AV22MItemBienImgDef_nombreFoto) ;
         if ( ! (GXutil.strcmp("", AV22MItemBienImgDef_nombreFoto)==0) )
         {
            AV20pathFoto = GXutil.trim( AV24rutaFotoBienvenidas) + GXutil.trim( AV22MItemBienImgDef_nombreFoto) ;
            A1952MItemBienImgDef = AV20pathFoto ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "bienve 2", "")) ;
         GXv_char1[0] = AV14MItemBienTitDef ;
         GXv_char3[0] = AV13MItemBienTextDef ;
         new web.gettextobienvedesdeprovider(remoteHandle, context).execute( 0, AV8MenuItemId, GXv_char1, GXv_char3) ;
         newmenuitem.this.AV14MItemBienTitDef = GXv_char1[0] ;
         newmenuitem.this.AV13MItemBienTextDef = GXv_char3[0] ;
         A1955MItemBienTitDef = AV14MItemBienTitDef ;
         A1956MItemBienTextDef = AV13MItemBienTextDef ;
         AV15MItemHelp = httpContext.getMessage( "Ayuda de ", "") + AV14MItemBienTitDef ;
         A1961MItemHelp = AV15MItemHelp ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P01UK3 */
         A1959MItemIcoImgExt = com.genexus.util.GXFile.getgxFileext( A1958MitemIcoImg) ;
         A1953MItemBienImgExt = com.genexus.util.GXFile.getgxFileext( A1952MItemBienImgDef) ;
         A1960MitemIcoImgNom = com.genexus.util.GXFile.getgxFilename( A1958MitemIcoImg) ;
         A1954MItemBienImgNom = com.genexus.util.GXFile.getgxFilename( A1952MItemBienImgDef) ;
         pr_default.execute(1, new Object[] {A1939MenuItemTitulo, Boolean.valueOf(A1938MItemEsMenu), Boolean.valueOf(n1944MItemPadreDef), A1944MItemPadreDef, Boolean.valueOf(A1945MItemPadreObl), A1958MitemIcoImg, Boolean.valueOf(n1957MItemIcoSVG), A1957MItemIcoSVG, A1952MItemBienImgDef, A1955MItemBienTitDef, A1956MItemBienTextDef, A1961MItemHelp, A1959MItemIcoImgExt, A1953MItemBienImgExt, A1960MitemIcoImgNom, A1954MItemBienImgNom, Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
         if (true) break;
         /* Using cursor P01UK4 */
         A1959MItemIcoImgExt = com.genexus.util.GXFile.getgxFileext( A1958MitemIcoImg) ;
         A1953MItemBienImgExt = com.genexus.util.GXFile.getgxFileext( A1952MItemBienImgDef) ;
         A1960MitemIcoImgNom = com.genexus.util.GXFile.getgxFilename( A1958MitemIcoImg) ;
         A1954MItemBienImgNom = com.genexus.util.GXFile.getgxFilename( A1952MItemBienImgDef) ;
         pr_default.execute(2, new Object[] {A1939MenuItemTitulo, Boolean.valueOf(A1938MItemEsMenu), Boolean.valueOf(n1944MItemPadreDef), A1944MItemPadreDef, Boolean.valueOf(A1945MItemPadreObl), A1958MitemIcoImg, Boolean.valueOf(n1957MItemIcoSVG), A1957MItemIcoSVG, A1952MItemBienImgDef, A1955MItemBienTitDef, A1956MItemBienTextDef, A1961MItemHelp, A1959MItemIcoImgExt, A1953MItemBienImgExt, A1960MitemIcoImgNom, A1954MItemBienImgNom, Byte.valueOf(A1925PerfilId), A1937MenuItemId});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV27GXLvl7 == 0 )
      {
         /*
            INSERT RECORD ON TABLE MenuItem

         */
         A1925PerfilId = AV12PerfilId ;
         A1937MenuItemId = GXutil.trim( AV8MenuItemId) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "new con \"", "")+AV8MenuItemId+httpContext.getMessage( "\" &PerfilId ", "")+GXutil.trim( GXutil.str( AV12PerfilId, 2, 0))) ;
         A1939MenuItemTitulo = AV9MenuItemTitulo ;
         A1938MItemEsMenu = AV10MItemEsMenu ;
         if ( ! (GXutil.strcmp("", AV18MItemPadreDef)==0) )
         {
            A1944MItemPadreDef = GXutil.trim( AV18MItemPadreDef) ;
            n1944MItemPadreDef = false ;
         }
         else
         {
            A1944MItemPadreDef = "" ;
            n1944MItemPadreDef = false ;
            n1944MItemPadreDef = true ;
         }
         A1945MItemPadreObl = AV19MItemPadreObl ;
         AV23rutaFotoIconos = httpContext.getMessage( "C:\\sueldos\\fotos\\menu\\", "") ;
         GXv_char3[0] = AV16MitemIcoImg_nombreFoto ;
         new web.getitemiconoimgpredeterminada(remoteHandle, context).execute( AV8MenuItemId, GXv_char3) ;
         newmenuitem.this.AV16MitemIcoImg_nombreFoto = GXv_char3[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&MenuItemId ", "")+AV8MenuItemId+httpContext.getMessage( " devuelve &MitemIcoImg_nombreFoto ", "")+AV16MitemIcoImg_nombreFoto) ;
         if ( ! (GXutil.strcmp("", AV16MitemIcoImg_nombreFoto)==0) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "es foto", "")) ;
            AV20pathFoto = GXutil.trim( AV23rutaFotoIconos) + GXutil.trim( AV16MitemIcoImg_nombreFoto) + httpContext.getMessage( ".png", "") ;
            A1958MitemIcoImg = AV20pathFoto ;
            A1957MItemIcoSVG = "" ;
            n1957MItemIcoSVG = false ;
            n1957MItemIcoSVG = true ;
         }
         else
         {
            GXt_char2 = AV17MItemIcoSVG ;
            GXv_char3[0] = GXt_char2 ;
            new web.svgid_homeiconos(remoteHandle, context).execute( AV8MenuItemId, GXv_char3) ;
            newmenuitem.this.GXt_char2 = GXv_char3[0] ;
            AV17MItemIcoSVG = GXt_char2 ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "es svg", "")) ;
            if ( ! (GXutil.strcmp("", AV17MItemIcoSVG)==0) )
            {
               A1957MItemIcoSVG = AV17MItemIcoSVG ;
               n1957MItemIcoSVG = false ;
            }
            else
            {
               A1957MItemIcoSVG = "" ;
               n1957MItemIcoSVG = false ;
               n1957MItemIcoSVG = true ;
            }
         }
         AV24rutaFotoBienvenidas = httpContext.getMessage( "C:\\sueldos\\fotos\\menu\\Small\\importar\\", "") ;
         GXv_char3[0] = AV22MItemBienImgDef_nombreFoto ;
         new web.getitembienvenidaimgpredeterminada(remoteHandle, context).execute( AV8MenuItemId, GXv_char3) ;
         newmenuitem.this.AV22MItemBienImgDef_nombreFoto = GXv_char3[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "bienvenida menuitemid ", "")+GXutil.trim( AV8MenuItemId)+httpContext.getMessage( " foto ", "")+AV22MItemBienImgDef_nombreFoto) ;
         if ( ! (GXutil.strcmp("", AV22MItemBienImgDef_nombreFoto)==0) )
         {
            AV20pathFoto = GXutil.trim( AV24rutaFotoBienvenidas) + GXutil.trim( AV22MItemBienImgDef_nombreFoto) ;
            A1952MItemBienImgDef = AV20pathFoto ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "bienve 2", "")) ;
         GXv_char3[0] = AV14MItemBienTitDef ;
         GXv_char1[0] = AV13MItemBienTextDef ;
         new web.gettextobienvedesdeprovider(remoteHandle, context).execute( 0, AV8MenuItemId, GXv_char3, GXv_char1) ;
         newmenuitem.this.AV14MItemBienTitDef = GXv_char3[0] ;
         newmenuitem.this.AV13MItemBienTextDef = GXv_char1[0] ;
         A1955MItemBienTitDef = AV14MItemBienTitDef ;
         A1956MItemBienTextDef = AV13MItemBienTextDef ;
         AV15MItemHelp = httpContext.getMessage( "Ayuda de ", "") + AV14MItemBienTitDef ;
         A1961MItemHelp = AV15MItemHelp ;
         A1954MItemBienImgNom = "" ;
         A1953MItemBienImgExt = "" ;
         A1960MitemIcoImgNom = "" ;
         A1959MItemIcoImgExt = "" ;
         /* Using cursor P01UK5 */
         A1960MitemIcoImgNom = com.genexus.util.GXFile.getgxFilename( A1958MitemIcoImg) ;
         A1959MItemIcoImgExt = com.genexus.util.GXFile.getgxFileext( A1958MitemIcoImg) ;
         A1954MItemBienImgNom = com.genexus.util.GXFile.getgxFilename( A1952MItemBienImgDef) ;
         A1953MItemBienImgExt = com.genexus.util.GXFile.getgxFileext( A1952MItemBienImgDef) ;
         pr_default.execute(3, new Object[] {Byte.valueOf(A1925PerfilId), A1937MenuItemId, A1939MenuItemTitulo, Boolean.valueOf(A1938MItemEsMenu), Boolean.valueOf(n1944MItemPadreDef), A1944MItemPadreDef, Boolean.valueOf(A1945MItemPadreObl), Boolean.valueOf(n1957MItemIcoSVG), A1957MItemIcoSVG, A1958MitemIcoImg, A1960MitemIcoImgNom, A1959MItemIcoImgExt, A1952MItemBienImgDef, A1954MItemBienImgNom, A1953MItemBienImgExt, A1955MItemBienTitDef, A1956MItemBienTextDef, A1961MItemHelp});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuItem");
         if ( (pr_default.getStatus(3) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "duplicate", "")) ;
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newmenuitem");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9MenuItemTitulo = "" ;
      scmdbuf = "" ;
      P01UK2_A1937MenuItemId = new String[] {""} ;
      P01UK2_A1925PerfilId = new byte[1] ;
      P01UK2_A1960MitemIcoImgNom = new String[] {""} ;
      P01UK2_A1954MItemBienImgNom = new String[] {""} ;
      P01UK2_A1959MItemIcoImgExt = new String[] {""} ;
      P01UK2_A1953MItemBienImgExt = new String[] {""} ;
      P01UK2_A1939MenuItemTitulo = new String[] {""} ;
      P01UK2_A1938MItemEsMenu = new boolean[] {false} ;
      P01UK2_A1944MItemPadreDef = new String[] {""} ;
      P01UK2_n1944MItemPadreDef = new boolean[] {false} ;
      P01UK2_A1945MItemPadreObl = new boolean[] {false} ;
      P01UK2_A1958MitemIcoImg = new String[] {""} ;
      P01UK2_A1957MItemIcoSVG = new String[] {""} ;
      P01UK2_n1957MItemIcoSVG = new boolean[] {false} ;
      P01UK2_A1952MItemBienImgDef = new String[] {""} ;
      P01UK2_A1955MItemBienTitDef = new String[] {""} ;
      P01UK2_A1956MItemBienTextDef = new String[] {""} ;
      P01UK2_A1961MItemHelp = new String[] {""} ;
      A1937MenuItemId = "" ;
      A1960MitemIcoImgNom = "" ;
      A1954MItemBienImgNom = "" ;
      A1959MItemIcoImgExt = "" ;
      A1953MItemBienImgExt = "" ;
      A1939MenuItemTitulo = "" ;
      A1944MItemPadreDef = "" ;
      A1958MitemIcoImg = "" ;
      A1957MItemIcoSVG = "" ;
      A1952MItemBienImgDef = "" ;
      A1955MItemBienTitDef = "" ;
      A1956MItemBienTextDef = "" ;
      A1961MItemHelp = "" ;
      AV28Pgmname = "" ;
      AV23rutaFotoIconos = "" ;
      AV16MitemIcoImg_nombreFoto = "" ;
      AV20pathFoto = "" ;
      AV17MItemIcoSVG = "" ;
      AV24rutaFotoBienvenidas = "" ;
      AV22MItemBienImgDef_nombreFoto = "" ;
      AV14MItemBienTitDef = "" ;
      AV13MItemBienTextDef = "" ;
      AV15MItemHelp = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char1 = new String[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newmenuitem__default(),
         new Object[] {
             new Object[] {
            P01UK2_A1937MenuItemId, P01UK2_A1925PerfilId, P01UK2_A1960MitemIcoImgNom, P01UK2_A1954MItemBienImgNom, P01UK2_A1959MItemIcoImgExt, P01UK2_A1953MItemBienImgExt, P01UK2_A1939MenuItemTitulo, P01UK2_A1938MItemEsMenu, P01UK2_A1944MItemPadreDef, P01UK2_n1944MItemPadreDef,
            P01UK2_A1945MItemPadreObl, P01UK2_A1958MitemIcoImg, P01UK2_A1957MItemIcoSVG, P01UK2_n1957MItemIcoSVG, P01UK2_A1952MItemBienImgDef, P01UK2_A1955MItemBienTitDef, P01UK2_A1956MItemBienTextDef, P01UK2_A1961MItemHelp
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV28Pgmname = "newMenuItem" ;
      /* GeneXus formulas. */
      AV28Pgmname = "newMenuItem" ;
      Gx_err = (short)(0) ;
   }

   private byte AV12PerfilId ;
   private byte AV27GXLvl7 ;
   private byte A1925PerfilId ;
   private short Gx_err ;
   private int GX_INS258 ;
   private String scmdbuf ;
   private String A1959MItemIcoImgExt ;
   private String A1953MItemBienImgExt ;
   private String A1957MItemIcoSVG ;
   private String AV28Pgmname ;
   private String AV17MItemIcoSVG ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char1[] ;
   private String Gx_emsg ;
   private boolean AV10MItemEsMenu ;
   private boolean AV19MItemPadreObl ;
   private boolean A1938MItemEsMenu ;
   private boolean n1944MItemPadreDef ;
   private boolean A1945MItemPadreObl ;
   private boolean n1957MItemIcoSVG ;
   private String A1956MItemBienTextDef ;
   private String A1961MItemHelp ;
   private String AV13MItemBienTextDef ;
   private String AV15MItemHelp ;
   private String A1958MitemIcoImg ;
   private String A1952MItemBienImgDef ;
   private String AV8MenuItemId ;
   private String AV11parmMenuItemTitulo ;
   private String AV18MItemPadreDef ;
   private String AV9MenuItemTitulo ;
   private String A1937MenuItemId ;
   private String A1960MitemIcoImgNom ;
   private String A1954MItemBienImgNom ;
   private String A1939MenuItemTitulo ;
   private String A1944MItemPadreDef ;
   private String A1955MItemBienTitDef ;
   private String AV23rutaFotoIconos ;
   private String AV16MitemIcoImg_nombreFoto ;
   private String AV20pathFoto ;
   private String AV24rutaFotoBienvenidas ;
   private String AV22MItemBienImgDef_nombreFoto ;
   private String AV14MItemBienTitDef ;
   private IDataStoreProvider pr_default ;
   private String[] P01UK2_A1937MenuItemId ;
   private byte[] P01UK2_A1925PerfilId ;
   private String[] P01UK2_A1960MitemIcoImgNom ;
   private String[] P01UK2_A1954MItemBienImgNom ;
   private String[] P01UK2_A1959MItemIcoImgExt ;
   private String[] P01UK2_A1953MItemBienImgExt ;
   private String[] P01UK2_A1939MenuItemTitulo ;
   private boolean[] P01UK2_A1938MItemEsMenu ;
   private String[] P01UK2_A1944MItemPadreDef ;
   private boolean[] P01UK2_n1944MItemPadreDef ;
   private boolean[] P01UK2_A1945MItemPadreObl ;
   private String[] P01UK2_A1958MitemIcoImg ;
   private String[] P01UK2_A1957MItemIcoSVG ;
   private boolean[] P01UK2_n1957MItemIcoSVG ;
   private String[] P01UK2_A1952MItemBienImgDef ;
   private String[] P01UK2_A1955MItemBienTitDef ;
   private String[] P01UK2_A1956MItemBienTextDef ;
   private String[] P01UK2_A1961MItemHelp ;
}

final  class newmenuitem__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UK2", "SELECT MenuItemId, PerfilId, MitemIcoImgNom, MItemBienImgNom, MItemIcoImgExt, MItemBienImgExt, MenuItemTitulo, MItemEsMenu, MItemPadreDef, MItemPadreObl, MitemIcoImg, MItemIcoSVG, MItemBienImgDef, MItemBienTitDef, MItemBienTextDef, MItemHelp FROM MenuItem WHERE (PerfilId = ?) AND (MenuItemId = ( RTRIM(LTRIM(?)))) ORDER BY PerfilId  LIMIT 1 FOR UPDATE OF MenuItem",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01UK3", "SAVEPOINT gxupdate;UPDATE MenuItem SET MenuItemTitulo=?, MItemEsMenu=?, MItemPadreDef=?, MItemPadreObl=?, MitemIcoImg=?, MItemIcoSVG=?, MItemBienImgDef=?, MItemBienTitDef=?, MItemBienTextDef=?, MItemHelp=?, MItemIcoImgExt=?, MItemBienImgExt=?, MitemIcoImgNom=?, MItemBienImgNom=?  WHERE PerfilId = ? AND MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01UK4", "SAVEPOINT gxupdate;UPDATE MenuItem SET MenuItemTitulo=?, MItemEsMenu=?, MItemPadreDef=?, MItemPadreObl=?, MitemIcoImg=?, MItemIcoSVG=?, MItemBienImgDef=?, MItemBienTitDef=?, MItemBienTextDef=?, MItemHelp=?, MItemIcoImgExt=?, MItemBienImgExt=?, MitemIcoImgNom=?, MItemBienImgNom=?  WHERE PerfilId = ? AND MenuItemId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01UK5", "SAVEPOINT gxupdate;INSERT INTO MenuItem(PerfilId, MenuItemId, MenuItemTitulo, MItemEsMenu, MItemPadreDef, MItemPadreObl, MItemIcoSVG, MitemIcoImg, MitemIcoImgNom, MItemIcoImgExt, MItemBienImgDef, MItemBienImgNom, MItemBienImgExt, MItemBienTitDef, MItemBienTextDef, MItemHelp) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((boolean[]) buf[10])[0] = rslt.getBoolean(10);
               ((String[]) buf[11])[0] = rslt.getBLOBFile(11, rslt.getString(5, 20), rslt.getVarchar(3));
               ((String[]) buf[12])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getBLOBFile(13, rslt.getString(6, 20), rslt.getVarchar(4));
               ((String[]) buf[15])[0] = rslt.getVarchar(14);
               ((String[]) buf[16])[0] = rslt.getLongVarchar(15);
               ((String[]) buf[17])[0] = rslt.getLongVarchar(16);
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
               stmt.setVarchar(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(3, (String)parms[3], 40);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setBLOBFile(5, (String)parms[5]);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 20);
               }
               stmt.setBLOBFile(7, (String)parms[8]);
               stmt.setVarchar(8, (String)parms[9], 400, false);
               stmt.setNLongVarchar(9, (String)parms[10], false);
               stmt.setNLongVarchar(10, (String)parms[11], false);
               stmt.setString(11, (String)parms[12], 20);
               stmt.setString(12, (String)parms[13], 20);
               stmt.setVarchar(13, (String)parms[14], 400, false);
               stmt.setVarchar(14, (String)parms[15], 400, false);
               stmt.setByte(15, ((Number) parms[16]).byteValue());
               stmt.setVarchar(16, (String)parms[17], 40, false);
               return;
            case 2 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(3, (String)parms[3], 40);
               }
               stmt.setBoolean(4, ((Boolean) parms[4]).booleanValue());
               stmt.setBLOBFile(5, (String)parms[5]);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[7], 20);
               }
               stmt.setBLOBFile(7, (String)parms[8]);
               stmt.setVarchar(8, (String)parms[9], 400, false);
               stmt.setNLongVarchar(9, (String)parms[10], false);
               stmt.setNLongVarchar(10, (String)parms[11], false);
               stmt.setString(11, (String)parms[12], 20);
               stmt.setString(12, (String)parms[13], 20);
               stmt.setVarchar(13, (String)parms[14], 400, false);
               stmt.setVarchar(14, (String)parms[15], 400, false);
               stmt.setByte(15, ((Number) parms[16]).byteValue());
               stmt.setVarchar(16, (String)parms[17], 40, false);
               return;
            case 3 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[5], 40);
               }
               stmt.setBoolean(6, ((Boolean) parms[6]).booleanValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[8], 20);
               }
               stmt.setBLOBFile(8, (String)parms[9]);
               stmt.setVarchar(9, (String)parms[10], 400, false);
               stmt.setString(10, (String)parms[11], 20);
               stmt.setBLOBFile(11, (String)parms[12]);
               stmt.setVarchar(12, (String)parms[13], 400, false);
               stmt.setString(13, (String)parms[14], 20);
               stmt.setVarchar(14, (String)parms[15], 400, false);
               stmt.setNLongVarchar(15, (String)parms[16], false);
               stmt.setNLongVarchar(16, (String)parms[17], false);
               return;
      }
   }

}

