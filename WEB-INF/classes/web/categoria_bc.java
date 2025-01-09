package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class categoria_bc extends GXWebPanel implements IGxSilentTrn
{
   public categoria_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public categoria_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categoria_bc.class ));
   }

   public categoria_bc( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow09205( ) ;
      standaloneNotModal( ) ;
      initializeNonKey09205( ) ;
      standaloneModal( ) ;
      addRow09205( ) ;
      Gx_mode = "INS" ;
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e11092 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z8CatCodigo = A8CatCodigo ;
            SetMode( "UPD") ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public boolean Reindex( )
   {
      return true ;
   }

   public void confirm_090( )
   {
      beforeValidate09205( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls09205( ) ;
         }
         else
         {
            checkExtendedTable09205( ) ;
            if ( AnyError == 0 )
            {
               zm09205( 9) ;
            }
            closeExtendedTableCursors09205( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode205 = Gx_mode ;
         confirm_09274( ) ;
         if ( AnyError == 0 )
         {
            confirm_09206( ) ;
            if ( AnyError == 0 )
            {
               /* Restore parent mode. */
               Gx_mode = sMode205 ;
               IsConfirmed = (short)(1) ;
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode205 ;
      }
   }

   public void confirm_09206( )
   {
      nGXsfl_206_idx = 0 ;
      while ( nGXsfl_206_idx < bcCategoria.getgxTv_SdtCategoria_Valores().size() )
      {
         readRow09206( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound206 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_206 != 0 ) )
         {
            getKey09206( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound206 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate09206( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable09206( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors09206( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound206 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey09206( ) ;
                     load09206( ) ;
                     beforeValidate09206( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls09206( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_206 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate09206( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable09206( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors09206( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow206( ((web.SdtCategoria_valores)bcCategoria.getgxTv_SdtCategoria_Valores().elementAt(-1+nGXsfl_206_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_09274( )
   {
      nGXsfl_274_idx = 0 ;
      while ( nGXsfl_274_idx < bcCategoria.getgxTv_SdtCategoria_Provincias().size() )
      {
         readRow09274( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound274 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_274 != 0 ) )
         {
            getKey09274( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound274 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate09274( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable09274( ) ;
                     if ( AnyError == 0 )
                     {
                        zm09274( 11) ;
                     }
                     closeExtendedTableCursors09274( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound274 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey09274( ) ;
                     load09274( ) ;
                     beforeValidate09274( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls09274( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_274 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate09274( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable09274( ) ;
                           if ( AnyError == 0 )
                           {
                              zm09274( 11) ;
                           }
                           closeExtendedTableCursors09274( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow274( ((web.SdtCategoria_Provincias)bcCategoria.getgxTv_SdtCategoria_Provincias().elementAt(-1+nGXsfl_274_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e12092( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoria_Insert", GXv_boolean3) ;
         categoria_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoria_Update", GXv_boolean3) ;
         categoria_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoria_Delete", GXv_boolean3) ;
         categoria_bc.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV38Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      GXt_int4 = AV7CliCod ;
      GXv_int5[0] = GXt_int4 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
      categoria_bc.this.GXt_int4 = GXv_int5[0] ;
      AV7CliCod = GXt_int4 ;
      GXt_int6 = AV8EmpCod ;
      GXv_int7[0] = GXt_int6 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int7) ;
      categoria_bc.this.GXt_int6 = GXv_int7[0] ;
      AV8EmpCod = GXt_int6 ;
      GXt_objcol_char8 = AV17SinCod ;
      GXv_objcol_char9[0] = GXt_objcol_char8 ;
      new web.getsindicatosactividadempresa(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, GXv_objcol_char9) ;
      GXt_objcol_char8 = GXv_objcol_char9[0] ;
      AV17SinCod = GXt_objcol_char8 ;
   }

   public void e11092( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm09205( int GX_JID )
   {
      if ( ( GX_JID == 8 ) || ( GX_JID == 0 ) )
      {
         Z123CatDescrip = A123CatDescrip ;
         Z676CatDescripSinAc = A676CatDescripSinAc ;
         Z1838CatClase = A1838CatClase ;
         Z2416CatTipoTarifa = A2416CatTipoTarifa ;
         Z1914CatFrecAct = A1914CatFrecAct ;
         Z1894CatRelSec = A1894CatRelSec ;
         Z2040CatRelRef = A2040CatRelRef ;
         Z2198CatAfipCod = A2198CatAfipCod ;
      }
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -8 )
      {
         Z8CatCodigo = A8CatCodigo ;
         Z123CatDescrip = A123CatDescrip ;
         Z676CatDescripSinAc = A676CatDescripSinAc ;
         Z1838CatClase = A1838CatClase ;
         Z2416CatTipoTarifa = A2416CatTipoTarifa ;
         Z1914CatFrecAct = A1914CatFrecAct ;
         Z1894CatRelSec = A1894CatRelSec ;
         Z2040CatRelRef = A2040CatRelRef ;
         Z2041CatOld = A2041CatOld ;
         Z2198CatAfipCod = A2198CatAfipCod ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
      {
         GXt_int6 = A1564CliPaiConve ;
         GXv_int7[0] = GXt_int6 ;
         new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int7) ;
         categoria_bc.this.GXt_int6 = GXv_int7[0] ;
         A1564CliPaiConve = GXt_int6 ;
      }
   }

   public void standaloneModal( )
   {
      if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
      {
         GXt_char10 = A1565CliConvenio ;
         GXv_char11[0] = GXt_char10 ;
         new web.getconveniodefault(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, "", GXv_char11) ;
         categoria_bc.this.GXt_char10 = GXv_char11[0] ;
         A1565CliConvenio = GXt_char10 ;
      }
   }

   public void load09205( )
   {
      /* Using cursor BC000910 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A123CatDescrip = BC000910_A123CatDescrip[0] ;
         A676CatDescripSinAc = BC000910_A676CatDescripSinAc[0] ;
         A1838CatClase = BC000910_A1838CatClase[0] ;
         A2416CatTipoTarifa = BC000910_A2416CatTipoTarifa[0] ;
         A1914CatFrecAct = BC000910_A1914CatFrecAct[0] ;
         A1894CatRelSec = BC000910_A1894CatRelSec[0] ;
         n1894CatRelSec = BC000910_n1894CatRelSec[0] ;
         A2040CatRelRef = BC000910_A2040CatRelRef[0] ;
         A2041CatOld = BC000910_A2041CatOld[0] ;
         A2198CatAfipCod = BC000910_A2198CatAfipCod[0] ;
         n2198CatAfipCod = BC000910_n2198CatAfipCod[0] ;
         zm09205( -8) ;
      }
      pr_default.close(8);
      onLoadActions09205( ) ;
   }

   public void onLoadActions09205( )
   {
      AV38Pgmname = "Categoria_BC" ;
   }

   public void checkExtendedTable09205( )
   {
      nIsDirty_205 = (short)(0) ;
      standaloneModal( ) ;
      AV38Pgmname = "Categoria_BC" ;
      /* Using cursor BC000911 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
      }
      pr_default.close(9);
      if ( (GXutil.strcmp("", A8CatCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Categoria", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( (GXutil.strcmp("", A123CatDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Categoría", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( A1838CatClase == 1 ) || ( A1838CatClase == 2 ) || ( A1838CatClase == 3 ) || ( A1838CatClase == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Frecuencia de pago", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A2416CatTipoTarifa, "H") == 0 ) || ( GXutil.strcmp(A2416CatTipoTarifa, "P") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de tarifa", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors09205( )
   {
      pr_default.close(9);
   }

   public void enableDisable( )
   {
   }

   public void getKey09205( )
   {
      /* Using cursor BC000912 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound205 = (short)(1) ;
      }
      else
      {
         RcdFound205 = (short)(0) ;
      }
      pr_default.close(10);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC000913 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(11) != 101) )
      {
         zm09205( 8) ;
         RcdFound205 = (short)(1) ;
         A8CatCodigo = BC000913_A8CatCodigo[0] ;
         A123CatDescrip = BC000913_A123CatDescrip[0] ;
         A676CatDescripSinAc = BC000913_A676CatDescripSinAc[0] ;
         A1838CatClase = BC000913_A1838CatClase[0] ;
         A2416CatTipoTarifa = BC000913_A2416CatTipoTarifa[0] ;
         A1914CatFrecAct = BC000913_A1914CatFrecAct[0] ;
         A1894CatRelSec = BC000913_A1894CatRelSec[0] ;
         n1894CatRelSec = BC000913_n1894CatRelSec[0] ;
         A2040CatRelRef = BC000913_A2040CatRelRef[0] ;
         A2041CatOld = BC000913_A2041CatOld[0] ;
         A2198CatAfipCod = BC000913_A2198CatAfipCod[0] ;
         n2198CatAfipCod = BC000913_n2198CatAfipCod[0] ;
         A3CliCod = BC000913_A3CliCod[0] ;
         A1564CliPaiConve = BC000913_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC000913_A1565CliConvenio[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         sMode205 = Gx_mode ;
         Gx_mode = "DSP" ;
         load09205( ) ;
         if ( AnyError == 1 )
         {
            RcdFound205 = (short)(0) ;
            initializeNonKey09205( ) ;
         }
         Gx_mode = sMode205 ;
      }
      else
      {
         RcdFound205 = (short)(0) ;
         initializeNonKey09205( ) ;
         sMode205 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode205 ;
      }
      pr_default.close(11);
   }

   public void getEqualNoModal( )
   {
      getKey09205( ) ;
      if ( RcdFound205 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_090( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency09205( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000914 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(12) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoria1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(12) == 101) || ( GXutil.strcmp(Z123CatDescrip, BC000914_A123CatDescrip[0]) != 0 ) || ( GXutil.strcmp(Z676CatDescripSinAc, BC000914_A676CatDescripSinAc[0]) != 0 ) || ( Z1838CatClase != BC000914_A1838CatClase[0] ) || ( GXutil.strcmp(Z2416CatTipoTarifa, BC000914_A2416CatTipoTarifa[0]) != 0 ) || ( Z1914CatFrecAct != BC000914_A1914CatFrecAct[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1894CatRelSec != BC000914_A1894CatRelSec[0] ) || ( GXutil.strcmp(Z2040CatRelRef, BC000914_A2040CatRelRef[0]) != 0 ) || ( GXutil.strcmp(Z2198CatAfipCod, BC000914_A2198CatAfipCod[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoria1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert09205( )
   {
      beforeValidate09205( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09205( ) ;
      }
      if ( AnyError == 0 )
      {
         zm09205( 0) ;
         checkOptimisticConcurrency09205( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09205( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert09205( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000915 */
                  pr_default.execute(13, new Object[] {A8CatCodigo, A123CatDescrip, A676CatDescripSinAc, Byte.valueOf(A1838CatClase), A2416CatTipoTarifa, Byte.valueOf(A1914CatFrecAct), Boolean.valueOf(n1894CatRelSec), Short.valueOf(A1894CatRelSec), A2040CatRelRef, A2041CatOld, Boolean.valueOf(n2198CatAfipCod), A2198CatAfipCod, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
                  if ( (pr_default.getStatus(13) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel09205( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load09205( ) ;
         }
         endLevel09205( ) ;
      }
      closeExtendedTableCursors09205( ) ;
   }

   public void update09205( )
   {
      beforeValidate09205( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09205( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09205( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09205( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate09205( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000916 */
                  pr_default.execute(14, new Object[] {A123CatDescrip, A676CatDescripSinAc, Byte.valueOf(A1838CatClase), A2416CatTipoTarifa, Byte.valueOf(A1914CatFrecAct), Boolean.valueOf(n1894CatRelSec), Short.valueOf(A1894CatRelSec), A2040CatRelRef, A2041CatOld, Boolean.valueOf(n2198CatAfipCod), A2198CatAfipCod, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
                  if ( (pr_default.getStatus(14) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoria1"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate09205( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel09205( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel09205( ) ;
      }
      closeExtendedTableCursors09205( ) ;
   }

   public void deferredUpdate09205( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate09205( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09205( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls09205( ) ;
         afterConfirm09205( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete09205( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart09274( ) ;
               while ( RcdFound274 != 0 )
               {
                  getByPrimaryKey09274( ) ;
                  delete09274( ) ;
                  scanKeyNext09274( ) ;
               }
               scanKeyEnd09274( ) ;
               scanKeyStart09206( ) ;
               while ( RcdFound206 != 0 )
               {
                  getByPrimaryKey09206( ) ;
                  delete09206( ) ;
                  scanKeyNext09206( ) ;
               }
               scanKeyEnd09206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000917 */
                  pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                        endTrnMsgCod = "SuccessfullyDeleted" ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
      sMode205 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel09205( ) ;
      Gx_mode = sMode205 ;
   }

   public void onDeleteControls09205( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV38Pgmname = "Categoria_BC" ;
      }
      if ( AnyError == 0 )
      {
         /* Using cursor BC000918 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionCategoria", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
      }
   }

   public void processNestedLevel09274( )
   {
      nGXsfl_274_idx = 0 ;
      while ( nGXsfl_274_idx < bcCategoria.getgxTv_SdtCategoria_Provincias().size() )
      {
         readRow09274( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound274 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_274 != 0 ) )
         {
            standaloneNotModal09274( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert09274( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete09274( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update09274( ) ;
               }
            }
         }
         KeyVarsToRow274( ((web.SdtCategoria_Provincias)bcCategoria.getgxTv_SdtCategoria_Provincias().elementAt(-1+nGXsfl_274_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_274_idx = 0 ;
         while ( nGXsfl_274_idx < bcCategoria.getgxTv_SdtCategoria_Provincias().size() )
         {
            readRow09274( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound274 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcCategoria.getgxTv_SdtCategoria_Provincias().removeElement(nGXsfl_274_idx);
               nGXsfl_274_idx = (int)(nGXsfl_274_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey09274( ) ;
               VarsToRow274( ((web.SdtCategoria_Provincias)bcCategoria.getgxTv_SdtCategoria_Provincias().elementAt(-1+nGXsfl_274_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll09274( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_274 = (short)(0) ;
      nIsMod_274 = (short)(0) ;
      Gxremove274 = (byte)(0) ;
   }

   public void processNestedLevel09206( )
   {
      nGXsfl_206_idx = 0 ;
      while ( nGXsfl_206_idx < bcCategoria.getgxTv_SdtCategoria_Valores().size() )
      {
         readRow09206( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound206 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_206 != 0 ) )
         {
            standaloneNotModal09206( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert09206( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete09206( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update09206( ) ;
               }
            }
         }
         KeyVarsToRow206( ((web.SdtCategoria_valores)bcCategoria.getgxTv_SdtCategoria_Valores().elementAt(-1+nGXsfl_206_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_206_idx = 0 ;
         while ( nGXsfl_206_idx < bcCategoria.getgxTv_SdtCategoria_Valores().size() )
         {
            readRow09206( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound206 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcCategoria.getgxTv_SdtCategoria_Valores().removeElement(nGXsfl_206_idx);
               nGXsfl_206_idx = (int)(nGXsfl_206_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey09206( ) ;
               VarsToRow206( ((web.SdtCategoria_valores)bcCategoria.getgxTv_SdtCategoria_Valores().elementAt(-1+nGXsfl_206_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll09206( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_206 = (short)(0) ;
      nIsMod_206 = (short)(0) ;
      Gxremove206 = (byte)(0) ;
   }

   public void processLevel09205( )
   {
      /* Save parent mode. */
      sMode205 = Gx_mode ;
      processNestedLevel09274( ) ;
      processNestedLevel09206( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode205 ;
      /* ' Update level parameters */
   }

   public void endLevel09205( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(12);
      }
      if ( AnyError == 0 )
      {
         beforeComplete09205( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart09205( )
   {
      /* Scan By routine */
      /* Using cursor BC000919 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      RcdFound205 = (short)(0) ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A8CatCodigo = BC000919_A8CatCodigo[0] ;
         A123CatDescrip = BC000919_A123CatDescrip[0] ;
         A676CatDescripSinAc = BC000919_A676CatDescripSinAc[0] ;
         A1838CatClase = BC000919_A1838CatClase[0] ;
         A2416CatTipoTarifa = BC000919_A2416CatTipoTarifa[0] ;
         A1914CatFrecAct = BC000919_A1914CatFrecAct[0] ;
         A1894CatRelSec = BC000919_A1894CatRelSec[0] ;
         n1894CatRelSec = BC000919_n1894CatRelSec[0] ;
         A2040CatRelRef = BC000919_A2040CatRelRef[0] ;
         A2041CatOld = BC000919_A2041CatOld[0] ;
         A2198CatAfipCod = BC000919_A2198CatAfipCod[0] ;
         n2198CatAfipCod = BC000919_n2198CatAfipCod[0] ;
         A3CliCod = BC000919_A3CliCod[0] ;
         A1564CliPaiConve = BC000919_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC000919_A1565CliConvenio[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext09205( )
   {
      /* Scan next routine */
      pr_default.readNext(17);
      RcdFound205 = (short)(0) ;
      scanKeyLoad09205( ) ;
   }

   public void scanKeyLoad09205( )
   {
      sMode205 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A8CatCodigo = BC000919_A8CatCodigo[0] ;
         A123CatDescrip = BC000919_A123CatDescrip[0] ;
         A676CatDescripSinAc = BC000919_A676CatDescripSinAc[0] ;
         A1838CatClase = BC000919_A1838CatClase[0] ;
         A2416CatTipoTarifa = BC000919_A2416CatTipoTarifa[0] ;
         A1914CatFrecAct = BC000919_A1914CatFrecAct[0] ;
         A1894CatRelSec = BC000919_A1894CatRelSec[0] ;
         n1894CatRelSec = BC000919_n1894CatRelSec[0] ;
         A2040CatRelRef = BC000919_A2040CatRelRef[0] ;
         A2041CatOld = BC000919_A2041CatOld[0] ;
         A2198CatAfipCod = BC000919_A2198CatAfipCod[0] ;
         n2198CatAfipCod = BC000919_n2198CatAfipCod[0] ;
         A3CliCod = BC000919_A3CliCod[0] ;
         A1564CliPaiConve = BC000919_A1564CliPaiConve[0] ;
         A1565CliConvenio = BC000919_A1565CliConvenio[0] ;
      }
      Gx_mode = sMode205 ;
   }

   public void scanKeyEnd09205( )
   {
      pr_default.close(17);
   }

   public void afterConfirm09205( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert09205( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate09205( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete09205( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete09205( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate09205( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes09205( )
   {
   }

   public void zm09274( int GX_JID )
   {
      if ( ( GX_JID == 10 ) || ( GX_JID == 0 ) )
      {
         Z2202CatProvRelSec = A2202CatProvRelSec ;
         Z2203CatProvRelRef = A2203CatProvRelRef ;
      }
      if ( ( GX_JID == 11 ) || ( GX_JID == 0 ) )
      {
      }
      if ( GX_JID == -10 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z2202CatProvRelSec = A2202CatProvRelSec ;
         Z2203CatProvRelRef = A2203CatProvRelRef ;
         Z2204CatProvOld = A2204CatProvOld ;
         Z2200CatPaiCod = A2200CatPaiCod ;
         Z2201CatProvCod = A2201CatProvCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal09274( )
   {
   }

   public void standaloneModal09274( )
   {
   }

   public void load09274( )
   {
      /* Using cursor BC000920 */
      pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2202CatProvRelSec = BC000920_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = BC000920_n2202CatProvRelSec[0] ;
         A2203CatProvRelRef = BC000920_A2203CatProvRelRef[0] ;
         n2203CatProvRelRef = BC000920_n2203CatProvRelRef[0] ;
         A2204CatProvOld = BC000920_A2204CatProvOld[0] ;
         n2204CatProvOld = BC000920_n2204CatProvOld[0] ;
         zm09274( -10) ;
      }
      pr_default.close(18);
      onLoadActions09274( ) ;
   }

   public void onLoadActions09274( )
   {
   }

   public void checkExtendedTable09274( )
   {
      nIsDirty_274 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal09274( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000921 */
      pr_default.execute(19, new Object[] {Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CATPROVCOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(19);
   }

   public void closeExtendedTableCursors09274( )
   {
      pr_default.close(19);
   }

   public void enableDisable09274( )
   {
   }

   public void getKey09274( )
   {
      /* Using cursor BC000922 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound274 = (short)(1) ;
      }
      else
      {
         RcdFound274 = (short)(0) ;
      }
      pr_default.close(20);
   }

   public void getByPrimaryKey09274( )
   {
      /* Using cursor BC000923 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(21) != 101) )
      {
         zm09274( 10) ;
         RcdFound274 = (short)(1) ;
         initializeNonKey09274( ) ;
         A2202CatProvRelSec = BC000923_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = BC000923_n2202CatProvRelSec[0] ;
         A2203CatProvRelRef = BC000923_A2203CatProvRelRef[0] ;
         n2203CatProvRelRef = BC000923_n2203CatProvRelRef[0] ;
         A2204CatProvOld = BC000923_A2204CatProvOld[0] ;
         n2204CatProvOld = BC000923_n2204CatProvOld[0] ;
         A2200CatPaiCod = BC000923_A2200CatPaiCod[0] ;
         A2201CatProvCod = BC000923_A2201CatProvCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z2200CatPaiCod = A2200CatPaiCod ;
         Z2201CatProvCod = A2201CatProvCod ;
         sMode274 = Gx_mode ;
         Gx_mode = "DSP" ;
         load09274( ) ;
         Gx_mode = sMode274 ;
      }
      else
      {
         RcdFound274 = (short)(0) ;
         initializeNonKey09274( ) ;
         sMode274 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal09274( ) ;
         Gx_mode = sMode274 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes09274( ) ;
      }
      pr_default.close(21);
   }

   public void checkOptimisticConcurrency09274( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000924 */
         pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
         if ( (pr_default.getStatus(22) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CategoriaProvincias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(22) == 101) || ( Z2202CatProvRelSec != BC000924_A2202CatProvRelSec[0] ) || ( GXutil.strcmp(Z2203CatProvRelRef, BC000924_A2203CatProvRelRef[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CategoriaProvincias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert09274( )
   {
      beforeValidate09274( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09274( ) ;
      }
      if ( AnyError == 0 )
      {
         zm09274( 0) ;
         checkOptimisticConcurrency09274( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09274( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert09274( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000925 */
                  pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A8CatCodigo, Boolean.valueOf(n2202CatProvRelSec), Integer.valueOf(A2202CatProvRelSec), Boolean.valueOf(n2203CatProvRelRef), A2203CatProvRelRef, Boolean.valueOf(n2204CatProvOld), A2204CatProvOld, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod), Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
                  if ( (pr_default.getStatus(23) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load09274( ) ;
         }
         endLevel09274( ) ;
      }
      closeExtendedTableCursors09274( ) ;
   }

   public void update09274( )
   {
      beforeValidate09274( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09274( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09274( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09274( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate09274( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000926 */
                  pr_default.execute(24, new Object[] {Boolean.valueOf(n2202CatProvRelSec), Integer.valueOf(A2202CatProvRelSec), Boolean.valueOf(n2203CatProvRelRef), A2203CatProvRelRef, Boolean.valueOf(n2204CatProvOld), A2204CatProvOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
                  if ( (pr_default.getStatus(24) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CategoriaProvincias"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate09274( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey09274( ) ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel09274( ) ;
      }
      closeExtendedTableCursors09274( ) ;
   }

   public void deferredUpdate09274( )
   {
   }

   public void delete09274( )
   {
      Gx_mode = "DLT" ;
      beforeValidate09274( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09274( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls09274( ) ;
         afterConfirm09274( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete09274( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000927 */
               pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode274 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel09274( ) ;
      Gx_mode = sMode274 ;
   }

   public void onDeleteControls09274( )
   {
      standaloneModal09274( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel09274( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(22);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart09274( )
   {
      /* Scan By routine */
      /* Using cursor BC000928 */
      pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      RcdFound274 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2202CatProvRelSec = BC000928_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = BC000928_n2202CatProvRelSec[0] ;
         A2203CatProvRelRef = BC000928_A2203CatProvRelRef[0] ;
         n2203CatProvRelRef = BC000928_n2203CatProvRelRef[0] ;
         A2204CatProvOld = BC000928_A2204CatProvOld[0] ;
         n2204CatProvOld = BC000928_n2204CatProvOld[0] ;
         A2200CatPaiCod = BC000928_A2200CatPaiCod[0] ;
         A2201CatProvCod = BC000928_A2201CatProvCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext09274( )
   {
      /* Scan next routine */
      pr_default.readNext(26);
      RcdFound274 = (short)(0) ;
      scanKeyLoad09274( ) ;
   }

   public void scanKeyLoad09274( )
   {
      sMode274 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2202CatProvRelSec = BC000928_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = BC000928_n2202CatProvRelSec[0] ;
         A2203CatProvRelRef = BC000928_A2203CatProvRelRef[0] ;
         n2203CatProvRelRef = BC000928_n2203CatProvRelRef[0] ;
         A2204CatProvOld = BC000928_A2204CatProvOld[0] ;
         n2204CatProvOld = BC000928_n2204CatProvOld[0] ;
         A2200CatPaiCod = BC000928_A2200CatPaiCod[0] ;
         A2201CatProvCod = BC000928_A2201CatProvCod[0] ;
      }
      Gx_mode = sMode274 ;
   }

   public void scanKeyEnd09274( )
   {
      pr_default.close(26);
   }

   public void afterConfirm09274( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert09274( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate09274( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete09274( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete09274( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate09274( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes09274( )
   {
   }

   public void send_integrity_lvl_hashes09274( )
   {
   }

   public void zm09206( int GX_JID )
   {
      if ( ( GX_JID == 12 ) || ( GX_JID == 0 ) )
      {
         Z122CatBasico = A122CatBasico ;
         Z731CatValorHora = A731CatValorHora ;
         Z908CatAdicional = A908CatAdicional ;
         Z909CatAdiHora = A909CatAdiHora ;
         Z1892EscBasico = A1892EscBasico ;
         Z1893EscAdicional = A1893EscAdicional ;
      }
      if ( GX_JID == -12 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         Z122CatBasico = A122CatBasico ;
         Z731CatValorHora = A731CatValorHora ;
         Z908CatAdicional = A908CatAdicional ;
         Z909CatAdiHora = A909CatAdiHora ;
         Z1892EscBasico = A1892EscBasico ;
         Z1893EscAdicional = A1893EscAdicional ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal09206( )
   {
   }

   public void standaloneModal09206( )
   {
   }

   public void load09206( )
   {
      /* Using cursor BC000929 */
      pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A122CatBasico = BC000929_A122CatBasico[0] ;
         n122CatBasico = BC000929_n122CatBasico[0] ;
         A731CatValorHora = BC000929_A731CatValorHora[0] ;
         n731CatValorHora = BC000929_n731CatValorHora[0] ;
         A908CatAdicional = BC000929_A908CatAdicional[0] ;
         n908CatAdicional = BC000929_n908CatAdicional[0] ;
         A909CatAdiHora = BC000929_A909CatAdiHora[0] ;
         n909CatAdiHora = BC000929_n909CatAdiHora[0] ;
         A1892EscBasico = BC000929_A1892EscBasico[0] ;
         A1893EscAdicional = BC000929_A1893EscAdicional[0] ;
         zm09206( -12) ;
      }
      pr_default.close(27);
      onLoadActions09206( ) ;
   }

   public void onLoadActions09206( )
   {
   }

   public void checkExtendedTable09206( )
   {
      nIsDirty_206 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal09206( ) ;
      Gx_BScreen = (byte)(0) ;
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A907CatVigencia)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Vigencia desde", ""), "", "", "", "", "", "", "", ""), 1, "");
         AnyError = (short)(1) ;
      }
   }

   public void closeExtendedTableCursors09206( )
   {
   }

   public void enableDisable09206( )
   {
   }

   public void getKey09206( )
   {
      /* Using cursor BC000930 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound206 = (short)(1) ;
      }
      else
      {
         RcdFound206 = (short)(0) ;
      }
      pr_default.close(28);
   }

   public void getByPrimaryKey09206( )
   {
      /* Using cursor BC000931 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(29) != 101) )
      {
         zm09206( 12) ;
         RcdFound206 = (short)(1) ;
         initializeNonKey09206( ) ;
         A907CatVigencia = BC000931_A907CatVigencia[0] ;
         A122CatBasico = BC000931_A122CatBasico[0] ;
         n122CatBasico = BC000931_n122CatBasico[0] ;
         A731CatValorHora = BC000931_A731CatValorHora[0] ;
         n731CatValorHora = BC000931_n731CatValorHora[0] ;
         A908CatAdicional = BC000931_A908CatAdicional[0] ;
         n908CatAdicional = BC000931_n908CatAdicional[0] ;
         A909CatAdiHora = BC000931_A909CatAdiHora[0] ;
         n909CatAdiHora = BC000931_n909CatAdiHora[0] ;
         A1892EscBasico = BC000931_A1892EscBasico[0] ;
         A1893EscAdicional = BC000931_A1893EscAdicional[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         load09206( ) ;
         Gx_mode = sMode206 ;
      }
      else
      {
         RcdFound206 = (short)(0) ;
         initializeNonKey09206( ) ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal09206( ) ;
         Gx_mode = sMode206 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes09206( ) ;
      }
      pr_default.close(29);
   }

   public void checkOptimisticConcurrency09206( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000932 */
         pr_default.execute(30, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
         if ( (pr_default.getStatus(30) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(30) == 101) || ( DecimalUtil.compareTo(Z122CatBasico, BC000932_A122CatBasico[0]) != 0 ) || ( DecimalUtil.compareTo(Z731CatValorHora, BC000932_A731CatValorHora[0]) != 0 ) || ( DecimalUtil.compareTo(Z908CatAdicional, BC000932_A908CatAdicional[0]) != 0 ) || ( DecimalUtil.compareTo(Z909CatAdiHora, BC000932_A909CatAdiHora[0]) != 0 ) || ( DecimalUtil.compareTo(Z1892EscBasico, BC000932_A1892EscBasico[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1893EscAdicional, BC000932_A1893EscAdicional[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoriavalores1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert09206( )
   {
      beforeValidate09206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09206( ) ;
      }
      if ( AnyError == 0 )
      {
         zm09206( 0) ;
         checkOptimisticConcurrency09206( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09206( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert09206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000933 */
                  pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A8CatCodigo, A907CatVigencia, Boolean.valueOf(n122CatBasico), A122CatBasico, Boolean.valueOf(n731CatValorHora), A731CatValorHora, Boolean.valueOf(n908CatAdicional), A908CatAdicional, Boolean.valueOf(n909CatAdiHora), A909CatAdiHora, A1892EscBasico, A1893EscAdicional, Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                  if ( (pr_default.getStatus(31) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load09206( ) ;
         }
         endLevel09206( ) ;
      }
      closeExtendedTableCursors09206( ) ;
   }

   public void update09206( )
   {
      beforeValidate09206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09206( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09206( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09206( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate09206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000934 */
                  pr_default.execute(32, new Object[] {Boolean.valueOf(n122CatBasico), A122CatBasico, Boolean.valueOf(n731CatValorHora), A731CatValorHora, Boolean.valueOf(n908CatAdicional), A908CatAdicional, Boolean.valueOf(n909CatAdiHora), A909CatAdiHora, A1892EscBasico, A1893EscAdicional, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                  if ( (pr_default.getStatus(32) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate09206( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey09206( ) ;
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel09206( ) ;
      }
      closeExtendedTableCursors09206( ) ;
   }

   public void deferredUpdate09206( )
   {
   }

   public void delete09206( )
   {
      Gx_mode = "DLT" ;
      beforeValidate09206( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09206( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls09206( ) ;
         afterConfirm09206( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete09206( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000935 */
               pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode206 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel09206( ) ;
      Gx_mode = sMode206 ;
   }

   public void onDeleteControls09206( )
   {
      standaloneModal09206( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel09206( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(30);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart09206( )
   {
      /* Scan By routine */
      /* Using cursor BC000936 */
      pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A907CatVigencia = BC000936_A907CatVigencia[0] ;
         A122CatBasico = BC000936_A122CatBasico[0] ;
         n122CatBasico = BC000936_n122CatBasico[0] ;
         A731CatValorHora = BC000936_A731CatValorHora[0] ;
         n731CatValorHora = BC000936_n731CatValorHora[0] ;
         A908CatAdicional = BC000936_A908CatAdicional[0] ;
         n908CatAdicional = BC000936_n908CatAdicional[0] ;
         A909CatAdiHora = BC000936_A909CatAdiHora[0] ;
         n909CatAdiHora = BC000936_n909CatAdiHora[0] ;
         A1892EscBasico = BC000936_A1892EscBasico[0] ;
         A1893EscAdicional = BC000936_A1893EscAdicional[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext09206( )
   {
      /* Scan next routine */
      pr_default.readNext(34);
      RcdFound206 = (short)(0) ;
      scanKeyLoad09206( ) ;
   }

   public void scanKeyLoad09206( )
   {
      sMode206 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A907CatVigencia = BC000936_A907CatVigencia[0] ;
         A122CatBasico = BC000936_A122CatBasico[0] ;
         n122CatBasico = BC000936_n122CatBasico[0] ;
         A731CatValorHora = BC000936_A731CatValorHora[0] ;
         n731CatValorHora = BC000936_n731CatValorHora[0] ;
         A908CatAdicional = BC000936_A908CatAdicional[0] ;
         n908CatAdicional = BC000936_n908CatAdicional[0] ;
         A909CatAdiHora = BC000936_A909CatAdiHora[0] ;
         n909CatAdiHora = BC000936_n909CatAdiHora[0] ;
         A1892EscBasico = BC000936_A1892EscBasico[0] ;
         A1893EscAdicional = BC000936_A1893EscAdicional[0] ;
      }
      Gx_mode = sMode206 ;
   }

   public void scanKeyEnd09206( )
   {
      pr_default.close(34);
   }

   public void afterConfirm09206( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert09206( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate09206( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete09206( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete09206( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate09206( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes09206( )
   {
   }

   public void send_integrity_lvl_hashes09206( )
   {
   }

   public void send_integrity_lvl_hashes09205( )
   {
   }

   public void addRow09205( )
   {
      VarsToRow205( bcCategoria) ;
   }

   public void readRow09205( )
   {
      RowToVars205( bcCategoria, 1) ;
   }

   public void addRow09274( )
   {
      web.SdtCategoria_Provincias obj274;
      obj274 = new web.SdtCategoria_Provincias(remoteHandle);
      VarsToRow274( obj274) ;
      bcCategoria.getgxTv_SdtCategoria_Provincias().add(obj274, 0);
      obj274.setgxTv_SdtCategoria_Provincias_Mode( "UPD" );
      obj274.setgxTv_SdtCategoria_Provincias_Modified( (short)(0) );
   }

   public void readRow09274( )
   {
      nGXsfl_274_idx = (int)(nGXsfl_274_idx+1) ;
      RowToVars274( ((web.SdtCategoria_Provincias)bcCategoria.getgxTv_SdtCategoria_Provincias().elementAt(-1+nGXsfl_274_idx)), 1) ;
   }

   public void addRow09206( )
   {
      web.SdtCategoria_valores obj206;
      obj206 = new web.SdtCategoria_valores(remoteHandle);
      VarsToRow206( obj206) ;
      bcCategoria.getgxTv_SdtCategoria_Valores().add(obj206, 0);
      obj206.setgxTv_SdtCategoria_valores_Mode( "UPD" );
      obj206.setgxTv_SdtCategoria_valores_Modified( (short)(0) );
   }

   public void readRow09206( )
   {
      nGXsfl_206_idx = (int)(nGXsfl_206_idx+1) ;
      RowToVars206( ((web.SdtCategoria_valores)bcCategoria.getgxTv_SdtCategoria_Valores().elementAt(-1+nGXsfl_206_idx)), 1) ;
   }

   public void initializeNonKey09205( )
   {
      A123CatDescrip = "" ;
      A676CatDescripSinAc = "" ;
      A1838CatClase = (byte)(0) ;
      A2416CatTipoTarifa = "" ;
      A1914CatFrecAct = (byte)(0) ;
      A1894CatRelSec = (short)(0) ;
      n1894CatRelSec = false ;
      A2040CatRelRef = "" ;
      A2041CatOld = "" ;
      A2198CatAfipCod = "" ;
      n2198CatAfipCod = false ;
      Z123CatDescrip = "" ;
      Z676CatDescripSinAc = "" ;
      Z1838CatClase = (byte)(0) ;
      Z2416CatTipoTarifa = "" ;
      Z1914CatFrecAct = (byte)(0) ;
      Z1894CatRelSec = (short)(0) ;
      Z2040CatRelRef = "" ;
      Z2198CatAfipCod = "" ;
   }

   public void initAll09205( )
   {
      A3CliCod = 0 ;
      A1564CliPaiConve = (short)(0) ;
      A1565CliConvenio = new web.getconveniodefault(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, "") ;
      A8CatCodigo = "" ;
      initializeNonKey09205( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey09274( )
   {
      A2202CatProvRelSec = 0 ;
      n2202CatProvRelSec = false ;
      A2203CatProvRelRef = "" ;
      n2203CatProvRelRef = false ;
      A2204CatProvOld = "" ;
      n2204CatProvOld = false ;
      Z2202CatProvRelSec = 0 ;
      Z2203CatProvRelRef = "" ;
   }

   public void initAll09274( )
   {
      A2200CatPaiCod = (short)(0) ;
      A2201CatProvCod = (short)(0) ;
      initializeNonKey09274( ) ;
   }

   public void standaloneModalInsert09274( )
   {
   }

   public void initializeNonKey09206( )
   {
      A122CatBasico = DecimalUtil.ZERO ;
      n122CatBasico = false ;
      A731CatValorHora = DecimalUtil.ZERO ;
      n731CatValorHora = false ;
      A908CatAdicional = DecimalUtil.ZERO ;
      n908CatAdicional = false ;
      A909CatAdiHora = DecimalUtil.ZERO ;
      n909CatAdiHora = false ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      Z122CatBasico = DecimalUtil.ZERO ;
      Z731CatValorHora = DecimalUtil.ZERO ;
      Z908CatAdicional = DecimalUtil.ZERO ;
      Z909CatAdiHora = DecimalUtil.ZERO ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      Z1893EscAdicional = DecimalUtil.ZERO ;
   }

   public void initAll09206( )
   {
      A907CatVigencia = GXutil.nullDate() ;
      initializeNonKey09206( ) ;
   }

   public void standaloneModalInsert09206( )
   {
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void VarsToRow205( web.SdtCategoria obj205 )
   {
      obj205.setgxTv_SdtCategoria_Mode( Gx_mode );
      obj205.setgxTv_SdtCategoria_Catdescrip( A123CatDescrip );
      obj205.setgxTv_SdtCategoria_Catdescripsinac( A676CatDescripSinAc );
      obj205.setgxTv_SdtCategoria_Catclase( A1838CatClase );
      obj205.setgxTv_SdtCategoria_Cattipotarifa( A2416CatTipoTarifa );
      obj205.setgxTv_SdtCategoria_Catfrecact( A1914CatFrecAct );
      obj205.setgxTv_SdtCategoria_Catrelsec( A1894CatRelSec );
      obj205.setgxTv_SdtCategoria_Catrelref( A2040CatRelRef );
      obj205.setgxTv_SdtCategoria_Catold( A2041CatOld );
      obj205.setgxTv_SdtCategoria_Catafipcod( A2198CatAfipCod );
      obj205.setgxTv_SdtCategoria_Clicod( A3CliCod );
      obj205.setgxTv_SdtCategoria_Clipaiconve( A1564CliPaiConve );
      obj205.setgxTv_SdtCategoria_Cliconvenio( A1565CliConvenio );
      obj205.setgxTv_SdtCategoria_Catcodigo( A8CatCodigo );
      obj205.setgxTv_SdtCategoria_Clicod_Z( Z3CliCod );
      obj205.setgxTv_SdtCategoria_Clipaiconve_Z( Z1564CliPaiConve );
      obj205.setgxTv_SdtCategoria_Cliconvenio_Z( Z1565CliConvenio );
      obj205.setgxTv_SdtCategoria_Catcodigo_Z( Z8CatCodigo );
      obj205.setgxTv_SdtCategoria_Catdescrip_Z( Z123CatDescrip );
      obj205.setgxTv_SdtCategoria_Catdescripsinac_Z( Z676CatDescripSinAc );
      obj205.setgxTv_SdtCategoria_Catclase_Z( Z1838CatClase );
      obj205.setgxTv_SdtCategoria_Cattipotarifa_Z( Z2416CatTipoTarifa );
      obj205.setgxTv_SdtCategoria_Catfrecact_Z( Z1914CatFrecAct );
      obj205.setgxTv_SdtCategoria_Catrelsec_Z( Z1894CatRelSec );
      obj205.setgxTv_SdtCategoria_Catrelref_Z( Z2040CatRelRef );
      obj205.setgxTv_SdtCategoria_Catafipcod_Z( Z2198CatAfipCod );
      obj205.setgxTv_SdtCategoria_Catrelsec_N( (byte)((byte)((n1894CatRelSec)?1:0)) );
      obj205.setgxTv_SdtCategoria_Catafipcod_N( (byte)((byte)((n2198CatAfipCod)?1:0)) );
      obj205.setgxTv_SdtCategoria_Mode( Gx_mode );
   }

   public void KeyVarsToRow205( web.SdtCategoria obj205 )
   {
      obj205.setgxTv_SdtCategoria_Clicod( A3CliCod );
      obj205.setgxTv_SdtCategoria_Clipaiconve( A1564CliPaiConve );
      obj205.setgxTv_SdtCategoria_Cliconvenio( A1565CliConvenio );
      obj205.setgxTv_SdtCategoria_Catcodigo( A8CatCodigo );
   }

   public void RowToVars205( web.SdtCategoria obj205 ,
                             int forceLoad )
   {
      Gx_mode = obj205.getgxTv_SdtCategoria_Mode() ;
      A123CatDescrip = obj205.getgxTv_SdtCategoria_Catdescrip() ;
      A676CatDescripSinAc = obj205.getgxTv_SdtCategoria_Catdescripsinac() ;
      A1838CatClase = obj205.getgxTv_SdtCategoria_Catclase() ;
      A2416CatTipoTarifa = obj205.getgxTv_SdtCategoria_Cattipotarifa() ;
      A1914CatFrecAct = obj205.getgxTv_SdtCategoria_Catfrecact() ;
      A1894CatRelSec = obj205.getgxTv_SdtCategoria_Catrelsec() ;
      n1894CatRelSec = false ;
      A2040CatRelRef = obj205.getgxTv_SdtCategoria_Catrelref() ;
      A2041CatOld = obj205.getgxTv_SdtCategoria_Catold() ;
      A2198CatAfipCod = obj205.getgxTv_SdtCategoria_Catafipcod() ;
      n2198CatAfipCod = false ;
      A3CliCod = obj205.getgxTv_SdtCategoria_Clicod() ;
      A1564CliPaiConve = obj205.getgxTv_SdtCategoria_Clipaiconve() ;
      A1565CliConvenio = obj205.getgxTv_SdtCategoria_Cliconvenio() ;
      A8CatCodigo = obj205.getgxTv_SdtCategoria_Catcodigo() ;
      Z3CliCod = obj205.getgxTv_SdtCategoria_Clicod_Z() ;
      Z1564CliPaiConve = obj205.getgxTv_SdtCategoria_Clipaiconve_Z() ;
      Z1565CliConvenio = obj205.getgxTv_SdtCategoria_Cliconvenio_Z() ;
      Z8CatCodigo = obj205.getgxTv_SdtCategoria_Catcodigo_Z() ;
      Z123CatDescrip = obj205.getgxTv_SdtCategoria_Catdescrip_Z() ;
      Z676CatDescripSinAc = obj205.getgxTv_SdtCategoria_Catdescripsinac_Z() ;
      Z1838CatClase = obj205.getgxTv_SdtCategoria_Catclase_Z() ;
      Z2416CatTipoTarifa = obj205.getgxTv_SdtCategoria_Cattipotarifa_Z() ;
      Z1914CatFrecAct = obj205.getgxTv_SdtCategoria_Catfrecact_Z() ;
      Z1894CatRelSec = obj205.getgxTv_SdtCategoria_Catrelsec_Z() ;
      Z2040CatRelRef = obj205.getgxTv_SdtCategoria_Catrelref_Z() ;
      Z2198CatAfipCod = obj205.getgxTv_SdtCategoria_Catafipcod_Z() ;
      n1894CatRelSec = (boolean)((obj205.getgxTv_SdtCategoria_Catrelsec_N()==0)?false:true) ;
      n2198CatAfipCod = (boolean)((obj205.getgxTv_SdtCategoria_Catafipcod_N()==0)?false:true) ;
      Gx_mode = obj205.getgxTv_SdtCategoria_Mode() ;
   }

   public void VarsToRow274( web.SdtCategoria_Provincias obj274 )
   {
      obj274.setgxTv_SdtCategoria_Provincias_Mode( Gx_mode );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovrelsec( A2202CatProvRelSec );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovrelref( A2203CatProvRelRef );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovold( A2204CatProvOld );
      obj274.setgxTv_SdtCategoria_Provincias_Catpaicod( A2200CatPaiCod );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovcod( A2201CatProvCod );
      obj274.setgxTv_SdtCategoria_Provincias_Catpaicod_Z( Z2200CatPaiCod );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovcod_Z( Z2201CatProvCod );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovrelsec_Z( Z2202CatProvRelSec );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovrelref_Z( Z2203CatProvRelRef );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovrelsec_N( (byte)((byte)((n2202CatProvRelSec)?1:0)) );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovrelref_N( (byte)((byte)((n2203CatProvRelRef)?1:0)) );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovold_N( (byte)((byte)((n2204CatProvOld)?1:0)) );
      obj274.setgxTv_SdtCategoria_Provincias_Modified( nIsMod_274 );
   }

   public void KeyVarsToRow274( web.SdtCategoria_Provincias obj274 )
   {
      obj274.setgxTv_SdtCategoria_Provincias_Catpaicod( A2200CatPaiCod );
      obj274.setgxTv_SdtCategoria_Provincias_Catprovcod( A2201CatProvCod );
   }

   public void RowToVars274( web.SdtCategoria_Provincias obj274 ,
                             int forceLoad )
   {
      Gx_mode = obj274.getgxTv_SdtCategoria_Provincias_Mode() ;
      A2202CatProvRelSec = obj274.getgxTv_SdtCategoria_Provincias_Catprovrelsec() ;
      n2202CatProvRelSec = false ;
      A2203CatProvRelRef = obj274.getgxTv_SdtCategoria_Provincias_Catprovrelref() ;
      n2203CatProvRelRef = false ;
      A2204CatProvOld = obj274.getgxTv_SdtCategoria_Provincias_Catprovold() ;
      n2204CatProvOld = false ;
      A2200CatPaiCod = obj274.getgxTv_SdtCategoria_Provincias_Catpaicod() ;
      A2201CatProvCod = obj274.getgxTv_SdtCategoria_Provincias_Catprovcod() ;
      Z2200CatPaiCod = obj274.getgxTv_SdtCategoria_Provincias_Catpaicod_Z() ;
      Z2201CatProvCod = obj274.getgxTv_SdtCategoria_Provincias_Catprovcod_Z() ;
      Z2202CatProvRelSec = obj274.getgxTv_SdtCategoria_Provincias_Catprovrelsec_Z() ;
      Z2203CatProvRelRef = obj274.getgxTv_SdtCategoria_Provincias_Catprovrelref_Z() ;
      n2202CatProvRelSec = (boolean)((obj274.getgxTv_SdtCategoria_Provincias_Catprovrelsec_N()==0)?false:true) ;
      n2203CatProvRelRef = (boolean)((obj274.getgxTv_SdtCategoria_Provincias_Catprovrelref_N()==0)?false:true) ;
      n2204CatProvOld = (boolean)((obj274.getgxTv_SdtCategoria_Provincias_Catprovold_N()==0)?false:true) ;
      nIsMod_274 = obj274.getgxTv_SdtCategoria_Provincias_Modified() ;
   }

   public void VarsToRow206( web.SdtCategoria_valores obj206 )
   {
      obj206.setgxTv_SdtCategoria_valores_Mode( Gx_mode );
      obj206.setgxTv_SdtCategoria_valores_Catbasico( A122CatBasico );
      obj206.setgxTv_SdtCategoria_valores_Catvalorhora( A731CatValorHora );
      obj206.setgxTv_SdtCategoria_valores_Catadicional( A908CatAdicional );
      obj206.setgxTv_SdtCategoria_valores_Catadihora( A909CatAdiHora );
      obj206.setgxTv_SdtCategoria_valores_Escbasico( A1892EscBasico );
      obj206.setgxTv_SdtCategoria_valores_Escadicional( A1893EscAdicional );
      obj206.setgxTv_SdtCategoria_valores_Catvigencia( A907CatVigencia );
      obj206.setgxTv_SdtCategoria_valores_Catvigencia_Z( Z907CatVigencia );
      obj206.setgxTv_SdtCategoria_valores_Catbasico_Z( Z122CatBasico );
      obj206.setgxTv_SdtCategoria_valores_Catvalorhora_Z( Z731CatValorHora );
      obj206.setgxTv_SdtCategoria_valores_Catadicional_Z( Z908CatAdicional );
      obj206.setgxTv_SdtCategoria_valores_Catadihora_Z( Z909CatAdiHora );
      obj206.setgxTv_SdtCategoria_valores_Escbasico_Z( Z1892EscBasico );
      obj206.setgxTv_SdtCategoria_valores_Escadicional_Z( Z1893EscAdicional );
      obj206.setgxTv_SdtCategoria_valores_Catbasico_N( (byte)((byte)((n122CatBasico)?1:0)) );
      obj206.setgxTv_SdtCategoria_valores_Catvalorhora_N( (byte)((byte)((n731CatValorHora)?1:0)) );
      obj206.setgxTv_SdtCategoria_valores_Catadicional_N( (byte)((byte)((n908CatAdicional)?1:0)) );
      obj206.setgxTv_SdtCategoria_valores_Catadihora_N( (byte)((byte)((n909CatAdiHora)?1:0)) );
      obj206.setgxTv_SdtCategoria_valores_Modified( nIsMod_206 );
   }

   public void KeyVarsToRow206( web.SdtCategoria_valores obj206 )
   {
      obj206.setgxTv_SdtCategoria_valores_Catvigencia( A907CatVigencia );
   }

   public void RowToVars206( web.SdtCategoria_valores obj206 ,
                             int forceLoad )
   {
      Gx_mode = obj206.getgxTv_SdtCategoria_valores_Mode() ;
      A122CatBasico = obj206.getgxTv_SdtCategoria_valores_Catbasico() ;
      n122CatBasico = false ;
      A731CatValorHora = obj206.getgxTv_SdtCategoria_valores_Catvalorhora() ;
      n731CatValorHora = false ;
      A908CatAdicional = obj206.getgxTv_SdtCategoria_valores_Catadicional() ;
      n908CatAdicional = false ;
      A909CatAdiHora = obj206.getgxTv_SdtCategoria_valores_Catadihora() ;
      n909CatAdiHora = false ;
      A1892EscBasico = obj206.getgxTv_SdtCategoria_valores_Escbasico() ;
      A1893EscAdicional = obj206.getgxTv_SdtCategoria_valores_Escadicional() ;
      A907CatVigencia = obj206.getgxTv_SdtCategoria_valores_Catvigencia() ;
      Z907CatVigencia = obj206.getgxTv_SdtCategoria_valores_Catvigencia_Z() ;
      Z122CatBasico = obj206.getgxTv_SdtCategoria_valores_Catbasico_Z() ;
      Z731CatValorHora = obj206.getgxTv_SdtCategoria_valores_Catvalorhora_Z() ;
      Z908CatAdicional = obj206.getgxTv_SdtCategoria_valores_Catadicional_Z() ;
      Z909CatAdiHora = obj206.getgxTv_SdtCategoria_valores_Catadihora_Z() ;
      Z1892EscBasico = obj206.getgxTv_SdtCategoria_valores_Escbasico_Z() ;
      Z1893EscAdicional = obj206.getgxTv_SdtCategoria_valores_Escadicional_Z() ;
      n122CatBasico = (boolean)((obj206.getgxTv_SdtCategoria_valores_Catbasico_N()==0)?false:true) ;
      n731CatValorHora = (boolean)((obj206.getgxTv_SdtCategoria_valores_Catvalorhora_N()==0)?false:true) ;
      n908CatAdicional = (boolean)((obj206.getgxTv_SdtCategoria_valores_Catadicional_N()==0)?false:true) ;
      n909CatAdiHora = (boolean)((obj206.getgxTv_SdtCategoria_valores_Catadihora_N()==0)?false:true) ;
      nIsMod_206 = obj206.getgxTv_SdtCategoria_valores_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      A1564CliPaiConve = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      A1565CliConvenio = (String)getParm(obj,2) ;
      A8CatCodigo = (String)getParm(obj,3) ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey09205( ) ;
      scanKeyStart09205( ) ;
      if ( RcdFound205 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000937 */
         pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(35) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
            AnyError = (short)(1) ;
         }
         pr_default.close(35);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
      }
      zm09205( -8) ;
      onLoadActions09205( ) ;
      addRow09205( ) ;
      bcCategoria.getgxTv_SdtCategoria_Provincias().clearCollection();
      if ( RcdFound205 == 1 )
      {
         scanKeyStart09274( ) ;
         nGXsfl_274_idx = 1 ;
         while ( RcdFound274 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z8CatCodigo = A8CatCodigo ;
            Z2200CatPaiCod = A2200CatPaiCod ;
            Z2201CatProvCod = A2201CatProvCod ;
            zm09274( -10) ;
            onLoadActions09274( ) ;
            nRcdExists_274 = (short)(1) ;
            nIsMod_274 = (short)(0) ;
            addRow09274( ) ;
            nGXsfl_274_idx = (int)(nGXsfl_274_idx+1) ;
            scanKeyNext09274( ) ;
         }
         scanKeyEnd09274( ) ;
      }
      bcCategoria.getgxTv_SdtCategoria_Valores().clearCollection();
      if ( RcdFound205 == 1 )
      {
         scanKeyStart09206( ) ;
         nGXsfl_206_idx = 1 ;
         while ( RcdFound206 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z8CatCodigo = A8CatCodigo ;
            Z907CatVigencia = A907CatVigencia ;
            zm09206( -12) ;
            onLoadActions09206( ) ;
            nRcdExists_206 = (short)(1) ;
            nIsMod_206 = (short)(0) ;
            addRow09206( ) ;
            nGXsfl_206_idx = (int)(nGXsfl_206_idx+1) ;
            scanKeyNext09206( ) ;
         }
         scanKeyEnd09206( ) ;
      }
      scanKeyEnd09205( ) ;
      if ( RcdFound205 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars205( bcCategoria, 0) ;
      scanKeyStart09205( ) ;
      if ( RcdFound205 == 0 )
      {
         Gx_mode = "INS" ;
         /* Using cursor BC000938 */
         pr_default.execute(36, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
         if ( (pr_default.getStatus(36) == 101) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
            AnyError = (short)(1) ;
         }
         pr_default.close(36);
      }
      else
      {
         Gx_mode = "UPD" ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
      }
      zm09205( -8) ;
      onLoadActions09205( ) ;
      addRow09205( ) ;
      bcCategoria.getgxTv_SdtCategoria_Provincias().clearCollection();
      if ( RcdFound205 == 1 )
      {
         scanKeyStart09274( ) ;
         nGXsfl_274_idx = 1 ;
         while ( RcdFound274 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z8CatCodigo = A8CatCodigo ;
            Z2200CatPaiCod = A2200CatPaiCod ;
            Z2201CatProvCod = A2201CatProvCod ;
            zm09274( -10) ;
            onLoadActions09274( ) ;
            nRcdExists_274 = (short)(1) ;
            nIsMod_274 = (short)(0) ;
            addRow09274( ) ;
            nGXsfl_274_idx = (int)(nGXsfl_274_idx+1) ;
            scanKeyNext09274( ) ;
         }
         scanKeyEnd09274( ) ;
      }
      bcCategoria.getgxTv_SdtCategoria_Valores().clearCollection();
      if ( RcdFound205 == 1 )
      {
         scanKeyStart09206( ) ;
         nGXsfl_206_idx = 1 ;
         while ( RcdFound206 != 0 )
         {
            Z3CliCod = A3CliCod ;
            Z1564CliPaiConve = A1564CliPaiConve ;
            Z1565CliConvenio = A1565CliConvenio ;
            Z8CatCodigo = A8CatCodigo ;
            Z907CatVigencia = A907CatVigencia ;
            zm09206( -12) ;
            onLoadActions09206( ) ;
            nRcdExists_206 = (short)(1) ;
            nIsMod_206 = (short)(0) ;
            addRow09206( ) ;
            nGXsfl_206_idx = (int)(nGXsfl_206_idx+1) ;
            scanKeyNext09206( ) ;
         }
         scanKeyEnd09206( ) ;
      }
      scanKeyEnd09205( ) ;
      if ( RcdFound205 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey09205( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert09205( ) ;
      }
      else
      {
         if ( RcdFound205 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               A1564CliPaiConve = Z1564CliPaiConve ;
               A1565CliConvenio = Z1565CliConvenio ;
               A8CatCodigo = Z8CatCodigo ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update09205( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert09205( ) ;
                  }
               }
               else
               {
                  if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert09205( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars205( bcCategoria, 1) ;
      saveImpl( ) ;
      VarsToRow205( bcCategoria) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars205( bcCategoria, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert09205( ) ;
      afterTrn( ) ;
      VarsToRow205( bcCategoria) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
      }
      else
      {
         web.SdtCategoria auxBC = new web.SdtCategoria( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A3CliCod, A1564CliPaiConve, A1565CliConvenio, A8CatCodigo);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcCategoria);
            auxBC.Save();
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars205( bcCategoria, 1) ;
      updateImpl( ) ;
      VarsToRow205( bcCategoria) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars205( bcCategoria, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert09205( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
      }
      else
      {
         afterTrn( ) ;
      }
      VarsToRow205( bcCategoria) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars205( bcCategoria, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey09205( ) ;
      if ( RcdFound205 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
         {
            A3CliCod = Z3CliCod ;
            A1564CliPaiConve = Z1564CliPaiConve ;
            A1565CliConvenio = Z1565CliConvenio ;
            A8CatCodigo = Z8CatCodigo ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "categoria_bc");
      VarsToRow205( bcCategoria) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcCategoria.getgxTv_SdtCategoria_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcCategoria.setgxTv_SdtCategoria_Mode( Gx_mode );
   }

   public void SetSDT( web.SdtCategoria sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcCategoria )
      {
         bcCategoria = sdt ;
         if ( GXutil.strcmp(bcCategoria.getgxTv_SdtCategoria_Mode(), "") == 0 )
         {
            bcCategoria.setgxTv_SdtCategoria_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow205( bcCategoria) ;
         }
         else
         {
            RowToVars205( bcCategoria, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcCategoria.getgxTv_SdtCategoria_Mode(), "") == 0 )
         {
            bcCategoria.setgxTv_SdtCategoria_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars205( bcCategoria, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtCategoria getCategoria_BC( )
   {
      return bcCategoria ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      Z1565CliConvenio = "" ;
      A1565CliConvenio = "" ;
      Z8CatCodigo = "" ;
      A8CatCodigo = "" ;
      sMode205 = "" ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV38Pgmname = "" ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      GXv_int5 = new int[1] ;
      AV17SinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_objcol_char8 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char9 = new GXSimpleCollection[1] ;
      Z123CatDescrip = "" ;
      A123CatDescrip = "" ;
      Z676CatDescripSinAc = "" ;
      A676CatDescripSinAc = "" ;
      Z2416CatTipoTarifa = "" ;
      A2416CatTipoTarifa = "" ;
      Z2040CatRelRef = "" ;
      A2040CatRelRef = "" ;
      Z2198CatAfipCod = "" ;
      A2198CatAfipCod = "" ;
      Z2041CatOld = "" ;
      A2041CatOld = "" ;
      GXv_int7 = new short[1] ;
      GXt_char10 = "" ;
      GXv_char11 = new String[1] ;
      BC000910_A8CatCodigo = new String[] {""} ;
      BC000910_A123CatDescrip = new String[] {""} ;
      BC000910_A676CatDescripSinAc = new String[] {""} ;
      BC000910_A1838CatClase = new byte[1] ;
      BC000910_A2416CatTipoTarifa = new String[] {""} ;
      BC000910_A1914CatFrecAct = new byte[1] ;
      BC000910_A1894CatRelSec = new short[1] ;
      BC000910_n1894CatRelSec = new boolean[] {false} ;
      BC000910_A2040CatRelRef = new String[] {""} ;
      BC000910_A2041CatOld = new String[] {""} ;
      BC000910_A2198CatAfipCod = new String[] {""} ;
      BC000910_n2198CatAfipCod = new boolean[] {false} ;
      BC000910_A3CliCod = new int[1] ;
      BC000910_A1564CliPaiConve = new short[1] ;
      BC000910_A1565CliConvenio = new String[] {""} ;
      BC000911_A3CliCod = new int[1] ;
      BC000912_A3CliCod = new int[1] ;
      BC000912_A1564CliPaiConve = new short[1] ;
      BC000912_A1565CliConvenio = new String[] {""} ;
      BC000912_A8CatCodigo = new String[] {""} ;
      BC000913_A8CatCodigo = new String[] {""} ;
      BC000913_A123CatDescrip = new String[] {""} ;
      BC000913_A676CatDescripSinAc = new String[] {""} ;
      BC000913_A1838CatClase = new byte[1] ;
      BC000913_A2416CatTipoTarifa = new String[] {""} ;
      BC000913_A1914CatFrecAct = new byte[1] ;
      BC000913_A1894CatRelSec = new short[1] ;
      BC000913_n1894CatRelSec = new boolean[] {false} ;
      BC000913_A2040CatRelRef = new String[] {""} ;
      BC000913_A2041CatOld = new String[] {""} ;
      BC000913_A2198CatAfipCod = new String[] {""} ;
      BC000913_n2198CatAfipCod = new boolean[] {false} ;
      BC000913_A3CliCod = new int[1] ;
      BC000913_A1564CliPaiConve = new short[1] ;
      BC000913_A1565CliConvenio = new String[] {""} ;
      BC000914_A8CatCodigo = new String[] {""} ;
      BC000914_A123CatDescrip = new String[] {""} ;
      BC000914_A676CatDescripSinAc = new String[] {""} ;
      BC000914_A1838CatClase = new byte[1] ;
      BC000914_A2416CatTipoTarifa = new String[] {""} ;
      BC000914_A1914CatFrecAct = new byte[1] ;
      BC000914_A1894CatRelSec = new short[1] ;
      BC000914_n1894CatRelSec = new boolean[] {false} ;
      BC000914_A2040CatRelRef = new String[] {""} ;
      BC000914_A2041CatOld = new String[] {""} ;
      BC000914_A2198CatAfipCod = new String[] {""} ;
      BC000914_n2198CatAfipCod = new boolean[] {false} ;
      BC000914_A3CliCod = new int[1] ;
      BC000914_A1564CliPaiConve = new short[1] ;
      BC000914_A1565CliConvenio = new String[] {""} ;
      BC000918_A3CliCod = new int[1] ;
      BC000918_A1EmpCod = new short[1] ;
      BC000918_A31LiqNro = new int[1] ;
      BC000918_A2142LiqPaiConve = new short[1] ;
      BC000918_A2143LiqConvenio = new String[] {""} ;
      BC000918_A2144LiqCatCodigo = new String[] {""} ;
      BC000919_A8CatCodigo = new String[] {""} ;
      BC000919_A123CatDescrip = new String[] {""} ;
      BC000919_A676CatDescripSinAc = new String[] {""} ;
      BC000919_A1838CatClase = new byte[1] ;
      BC000919_A2416CatTipoTarifa = new String[] {""} ;
      BC000919_A1914CatFrecAct = new byte[1] ;
      BC000919_A1894CatRelSec = new short[1] ;
      BC000919_n1894CatRelSec = new boolean[] {false} ;
      BC000919_A2040CatRelRef = new String[] {""} ;
      BC000919_A2041CatOld = new String[] {""} ;
      BC000919_A2198CatAfipCod = new String[] {""} ;
      BC000919_n2198CatAfipCod = new boolean[] {false} ;
      BC000919_A3CliCod = new int[1] ;
      BC000919_A1564CliPaiConve = new short[1] ;
      BC000919_A1565CliConvenio = new String[] {""} ;
      Z2203CatProvRelRef = "" ;
      A2203CatProvRelRef = "" ;
      Z2204CatProvOld = "" ;
      A2204CatProvOld = "" ;
      BC000920_A3CliCod = new int[1] ;
      BC000920_A1565CliConvenio = new String[] {""} ;
      BC000920_A8CatCodigo = new String[] {""} ;
      BC000920_A2202CatProvRelSec = new int[1] ;
      BC000920_n2202CatProvRelSec = new boolean[] {false} ;
      BC000920_A2203CatProvRelRef = new String[] {""} ;
      BC000920_n2203CatProvRelRef = new boolean[] {false} ;
      BC000920_A2204CatProvOld = new String[] {""} ;
      BC000920_n2204CatProvOld = new boolean[] {false} ;
      BC000920_A2200CatPaiCod = new short[1] ;
      BC000920_A2201CatProvCod = new short[1] ;
      BC000920_A1564CliPaiConve = new short[1] ;
      BC000921_A2200CatPaiCod = new short[1] ;
      BC000922_A3CliCod = new int[1] ;
      BC000922_A1564CliPaiConve = new short[1] ;
      BC000922_A1565CliConvenio = new String[] {""} ;
      BC000922_A8CatCodigo = new String[] {""} ;
      BC000922_A2200CatPaiCod = new short[1] ;
      BC000922_A2201CatProvCod = new short[1] ;
      BC000923_A3CliCod = new int[1] ;
      BC000923_A1565CliConvenio = new String[] {""} ;
      BC000923_A8CatCodigo = new String[] {""} ;
      BC000923_A2202CatProvRelSec = new int[1] ;
      BC000923_n2202CatProvRelSec = new boolean[] {false} ;
      BC000923_A2203CatProvRelRef = new String[] {""} ;
      BC000923_n2203CatProvRelRef = new boolean[] {false} ;
      BC000923_A2204CatProvOld = new String[] {""} ;
      BC000923_n2204CatProvOld = new boolean[] {false} ;
      BC000923_A2200CatPaiCod = new short[1] ;
      BC000923_A2201CatProvCod = new short[1] ;
      BC000923_A1564CliPaiConve = new short[1] ;
      sMode274 = "" ;
      BC000924_A3CliCod = new int[1] ;
      BC000924_A1565CliConvenio = new String[] {""} ;
      BC000924_A8CatCodigo = new String[] {""} ;
      BC000924_A2202CatProvRelSec = new int[1] ;
      BC000924_n2202CatProvRelSec = new boolean[] {false} ;
      BC000924_A2203CatProvRelRef = new String[] {""} ;
      BC000924_n2203CatProvRelRef = new boolean[] {false} ;
      BC000924_A2204CatProvOld = new String[] {""} ;
      BC000924_n2204CatProvOld = new boolean[] {false} ;
      BC000924_A2200CatPaiCod = new short[1] ;
      BC000924_A2201CatProvCod = new short[1] ;
      BC000924_A1564CliPaiConve = new short[1] ;
      BC000928_A3CliCod = new int[1] ;
      BC000928_A1565CliConvenio = new String[] {""} ;
      BC000928_A8CatCodigo = new String[] {""} ;
      BC000928_A2202CatProvRelSec = new int[1] ;
      BC000928_n2202CatProvRelSec = new boolean[] {false} ;
      BC000928_A2203CatProvRelRef = new String[] {""} ;
      BC000928_n2203CatProvRelRef = new boolean[] {false} ;
      BC000928_A2204CatProvOld = new String[] {""} ;
      BC000928_n2204CatProvOld = new boolean[] {false} ;
      BC000928_A2200CatPaiCod = new short[1] ;
      BC000928_A2201CatProvCod = new short[1] ;
      BC000928_A1564CliPaiConve = new short[1] ;
      Z122CatBasico = DecimalUtil.ZERO ;
      A122CatBasico = DecimalUtil.ZERO ;
      Z731CatValorHora = DecimalUtil.ZERO ;
      A731CatValorHora = DecimalUtil.ZERO ;
      Z908CatAdicional = DecimalUtil.ZERO ;
      A908CatAdicional = DecimalUtil.ZERO ;
      Z909CatAdiHora = DecimalUtil.ZERO ;
      A909CatAdiHora = DecimalUtil.ZERO ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      A1892EscBasico = DecimalUtil.ZERO ;
      Z1893EscAdicional = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      Z907CatVigencia = GXutil.nullDate() ;
      A907CatVigencia = GXutil.nullDate() ;
      BC000929_A3CliCod = new int[1] ;
      BC000929_A1565CliConvenio = new String[] {""} ;
      BC000929_A8CatCodigo = new String[] {""} ;
      BC000929_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      BC000929_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000929_n122CatBasico = new boolean[] {false} ;
      BC000929_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000929_n731CatValorHora = new boolean[] {false} ;
      BC000929_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000929_n908CatAdicional = new boolean[] {false} ;
      BC000929_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000929_n909CatAdiHora = new boolean[] {false} ;
      BC000929_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000929_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000929_A1564CliPaiConve = new short[1] ;
      BC000930_A3CliCod = new int[1] ;
      BC000930_A1564CliPaiConve = new short[1] ;
      BC000930_A1565CliConvenio = new String[] {""} ;
      BC000930_A8CatCodigo = new String[] {""} ;
      BC000930_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      BC000931_A3CliCod = new int[1] ;
      BC000931_A1565CliConvenio = new String[] {""} ;
      BC000931_A8CatCodigo = new String[] {""} ;
      BC000931_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      BC000931_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000931_n122CatBasico = new boolean[] {false} ;
      BC000931_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000931_n731CatValorHora = new boolean[] {false} ;
      BC000931_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000931_n908CatAdicional = new boolean[] {false} ;
      BC000931_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000931_n909CatAdiHora = new boolean[] {false} ;
      BC000931_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000931_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000931_A1564CliPaiConve = new short[1] ;
      sMode206 = "" ;
      BC000932_A3CliCod = new int[1] ;
      BC000932_A1565CliConvenio = new String[] {""} ;
      BC000932_A8CatCodigo = new String[] {""} ;
      BC000932_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      BC000932_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000932_n122CatBasico = new boolean[] {false} ;
      BC000932_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000932_n731CatValorHora = new boolean[] {false} ;
      BC000932_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000932_n908CatAdicional = new boolean[] {false} ;
      BC000932_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000932_n909CatAdiHora = new boolean[] {false} ;
      BC000932_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000932_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000932_A1564CliPaiConve = new short[1] ;
      BC000936_A3CliCod = new int[1] ;
      BC000936_A1565CliConvenio = new String[] {""} ;
      BC000936_A8CatCodigo = new String[] {""} ;
      BC000936_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      BC000936_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000936_n122CatBasico = new boolean[] {false} ;
      BC000936_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000936_n731CatValorHora = new boolean[] {false} ;
      BC000936_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000936_n908CatAdicional = new boolean[] {false} ;
      BC000936_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000936_n909CatAdiHora = new boolean[] {false} ;
      BC000936_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000936_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BC000936_A1564CliPaiConve = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      BC000937_A3CliCod = new int[1] ;
      BC000938_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.categoria_bc__default(),
         new Object[] {
             new Object[] {
            BC00092_A3CliCod, BC00092_A1565CliConvenio, BC00092_A8CatCodigo, BC00092_A907CatVigencia, BC00092_A122CatBasico, BC00092_n122CatBasico, BC00092_A731CatValorHora, BC00092_n731CatValorHora, BC00092_A908CatAdicional, BC00092_n908CatAdicional,
            BC00092_A909CatAdiHora, BC00092_n909CatAdiHora, BC00092_A1892EscBasico, BC00092_A1893EscAdicional, BC00092_A1564CliPaiConve
            }
            , new Object[] {
            BC00093_A3CliCod, BC00093_A1565CliConvenio, BC00093_A8CatCodigo, BC00093_A907CatVigencia, BC00093_A122CatBasico, BC00093_n122CatBasico, BC00093_A731CatValorHora, BC00093_n731CatValorHora, BC00093_A908CatAdicional, BC00093_n908CatAdicional,
            BC00093_A909CatAdiHora, BC00093_n909CatAdiHora, BC00093_A1892EscBasico, BC00093_A1893EscAdicional, BC00093_A1564CliPaiConve
            }
            , new Object[] {
            BC00094_A3CliCod, BC00094_A1565CliConvenio, BC00094_A8CatCodigo, BC00094_A2202CatProvRelSec, BC00094_n2202CatProvRelSec, BC00094_A2203CatProvRelRef, BC00094_n2203CatProvRelRef, BC00094_A2204CatProvOld, BC00094_n2204CatProvOld, BC00094_A2200CatPaiCod,
            BC00094_A2201CatProvCod, BC00094_A1564CliPaiConve
            }
            , new Object[] {
            BC00095_A3CliCod, BC00095_A1565CliConvenio, BC00095_A8CatCodigo, BC00095_A2202CatProvRelSec, BC00095_n2202CatProvRelSec, BC00095_A2203CatProvRelRef, BC00095_n2203CatProvRelRef, BC00095_A2204CatProvOld, BC00095_n2204CatProvOld, BC00095_A2200CatPaiCod,
            BC00095_A2201CatProvCod, BC00095_A1564CliPaiConve
            }
            , new Object[] {
            BC00096_A2200CatPaiCod
            }
            , new Object[] {
            BC00097_A8CatCodigo, BC00097_A123CatDescrip, BC00097_A676CatDescripSinAc, BC00097_A1838CatClase, BC00097_A2416CatTipoTarifa, BC00097_A1914CatFrecAct, BC00097_A1894CatRelSec, BC00097_n1894CatRelSec, BC00097_A2040CatRelRef, BC00097_A2041CatOld,
            BC00097_A2198CatAfipCod, BC00097_n2198CatAfipCod, BC00097_A3CliCod, BC00097_A1564CliPaiConve, BC00097_A1565CliConvenio
            }
            , new Object[] {
            BC00098_A8CatCodigo, BC00098_A123CatDescrip, BC00098_A676CatDescripSinAc, BC00098_A1838CatClase, BC00098_A2416CatTipoTarifa, BC00098_A1914CatFrecAct, BC00098_A1894CatRelSec, BC00098_n1894CatRelSec, BC00098_A2040CatRelRef, BC00098_A2041CatOld,
            BC00098_A2198CatAfipCod, BC00098_n2198CatAfipCod, BC00098_A3CliCod, BC00098_A1564CliPaiConve, BC00098_A1565CliConvenio
            }
            , new Object[] {
            BC00099_A3CliCod
            }
            , new Object[] {
            BC000910_A8CatCodigo, BC000910_A123CatDescrip, BC000910_A676CatDescripSinAc, BC000910_A1838CatClase, BC000910_A2416CatTipoTarifa, BC000910_A1914CatFrecAct, BC000910_A1894CatRelSec, BC000910_n1894CatRelSec, BC000910_A2040CatRelRef, BC000910_A2041CatOld,
            BC000910_A2198CatAfipCod, BC000910_n2198CatAfipCod, BC000910_A3CliCod, BC000910_A1564CliPaiConve, BC000910_A1565CliConvenio
            }
            , new Object[] {
            BC000911_A3CliCod
            }
            , new Object[] {
            BC000912_A3CliCod, BC000912_A1564CliPaiConve, BC000912_A1565CliConvenio, BC000912_A8CatCodigo
            }
            , new Object[] {
            BC000913_A8CatCodigo, BC000913_A123CatDescrip, BC000913_A676CatDescripSinAc, BC000913_A1838CatClase, BC000913_A2416CatTipoTarifa, BC000913_A1914CatFrecAct, BC000913_A1894CatRelSec, BC000913_n1894CatRelSec, BC000913_A2040CatRelRef, BC000913_A2041CatOld,
            BC000913_A2198CatAfipCod, BC000913_n2198CatAfipCod, BC000913_A3CliCod, BC000913_A1564CliPaiConve, BC000913_A1565CliConvenio
            }
            , new Object[] {
            BC000914_A8CatCodigo, BC000914_A123CatDescrip, BC000914_A676CatDescripSinAc, BC000914_A1838CatClase, BC000914_A2416CatTipoTarifa, BC000914_A1914CatFrecAct, BC000914_A1894CatRelSec, BC000914_n1894CatRelSec, BC000914_A2040CatRelRef, BC000914_A2041CatOld,
            BC000914_A2198CatAfipCod, BC000914_n2198CatAfipCod, BC000914_A3CliCod, BC000914_A1564CliPaiConve, BC000914_A1565CliConvenio
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000918_A3CliCod, BC000918_A1EmpCod, BC000918_A31LiqNro, BC000918_A2142LiqPaiConve, BC000918_A2143LiqConvenio, BC000918_A2144LiqCatCodigo
            }
            , new Object[] {
            BC000919_A8CatCodigo, BC000919_A123CatDescrip, BC000919_A676CatDescripSinAc, BC000919_A1838CatClase, BC000919_A2416CatTipoTarifa, BC000919_A1914CatFrecAct, BC000919_A1894CatRelSec, BC000919_n1894CatRelSec, BC000919_A2040CatRelRef, BC000919_A2041CatOld,
            BC000919_A2198CatAfipCod, BC000919_n2198CatAfipCod, BC000919_A3CliCod, BC000919_A1564CliPaiConve, BC000919_A1565CliConvenio
            }
            , new Object[] {
            BC000920_A3CliCod, BC000920_A1565CliConvenio, BC000920_A8CatCodigo, BC000920_A2202CatProvRelSec, BC000920_n2202CatProvRelSec, BC000920_A2203CatProvRelRef, BC000920_n2203CatProvRelRef, BC000920_A2204CatProvOld, BC000920_n2204CatProvOld, BC000920_A2200CatPaiCod,
            BC000920_A2201CatProvCod, BC000920_A1564CliPaiConve
            }
            , new Object[] {
            BC000921_A2200CatPaiCod
            }
            , new Object[] {
            BC000922_A3CliCod, BC000922_A1564CliPaiConve, BC000922_A1565CliConvenio, BC000922_A8CatCodigo, BC000922_A2200CatPaiCod, BC000922_A2201CatProvCod
            }
            , new Object[] {
            BC000923_A3CliCod, BC000923_A1565CliConvenio, BC000923_A8CatCodigo, BC000923_A2202CatProvRelSec, BC000923_n2202CatProvRelSec, BC000923_A2203CatProvRelRef, BC000923_n2203CatProvRelRef, BC000923_A2204CatProvOld, BC000923_n2204CatProvOld, BC000923_A2200CatPaiCod,
            BC000923_A2201CatProvCod, BC000923_A1564CliPaiConve
            }
            , new Object[] {
            BC000924_A3CliCod, BC000924_A1565CliConvenio, BC000924_A8CatCodigo, BC000924_A2202CatProvRelSec, BC000924_n2202CatProvRelSec, BC000924_A2203CatProvRelRef, BC000924_n2203CatProvRelRef, BC000924_A2204CatProvOld, BC000924_n2204CatProvOld, BC000924_A2200CatPaiCod,
            BC000924_A2201CatProvCod, BC000924_A1564CliPaiConve
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000928_A3CliCod, BC000928_A1565CliConvenio, BC000928_A8CatCodigo, BC000928_A2202CatProvRelSec, BC000928_n2202CatProvRelSec, BC000928_A2203CatProvRelRef, BC000928_n2203CatProvRelRef, BC000928_A2204CatProvOld, BC000928_n2204CatProvOld, BC000928_A2200CatPaiCod,
            BC000928_A2201CatProvCod, BC000928_A1564CliPaiConve
            }
            , new Object[] {
            BC000929_A3CliCod, BC000929_A1565CliConvenio, BC000929_A8CatCodigo, BC000929_A907CatVigencia, BC000929_A122CatBasico, BC000929_n122CatBasico, BC000929_A731CatValorHora, BC000929_n731CatValorHora, BC000929_A908CatAdicional, BC000929_n908CatAdicional,
            BC000929_A909CatAdiHora, BC000929_n909CatAdiHora, BC000929_A1892EscBasico, BC000929_A1893EscAdicional, BC000929_A1564CliPaiConve
            }
            , new Object[] {
            BC000930_A3CliCod, BC000930_A1564CliPaiConve, BC000930_A1565CliConvenio, BC000930_A8CatCodigo, BC000930_A907CatVigencia
            }
            , new Object[] {
            BC000931_A3CliCod, BC000931_A1565CliConvenio, BC000931_A8CatCodigo, BC000931_A907CatVigencia, BC000931_A122CatBasico, BC000931_n122CatBasico, BC000931_A731CatValorHora, BC000931_n731CatValorHora, BC000931_A908CatAdicional, BC000931_n908CatAdicional,
            BC000931_A909CatAdiHora, BC000931_n909CatAdiHora, BC000931_A1892EscBasico, BC000931_A1893EscAdicional, BC000931_A1564CliPaiConve
            }
            , new Object[] {
            BC000932_A3CliCod, BC000932_A1565CliConvenio, BC000932_A8CatCodigo, BC000932_A907CatVigencia, BC000932_A122CatBasico, BC000932_n122CatBasico, BC000932_A731CatValorHora, BC000932_n731CatValorHora, BC000932_A908CatAdicional, BC000932_n908CatAdicional,
            BC000932_A909CatAdiHora, BC000932_n909CatAdiHora, BC000932_A1892EscBasico, BC000932_A1893EscAdicional, BC000932_A1564CliPaiConve
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000936_A3CliCod, BC000936_A1565CliConvenio, BC000936_A8CatCodigo, BC000936_A907CatVigencia, BC000936_A122CatBasico, BC000936_n122CatBasico, BC000936_A731CatValorHora, BC000936_n731CatValorHora, BC000936_A908CatAdicional, BC000936_n908CatAdicional,
            BC000936_A909CatAdiHora, BC000936_n909CatAdiHora, BC000936_A1892EscBasico, BC000936_A1893EscAdicional, BC000936_A1564CliPaiConve
            }
            , new Object[] {
            BC000937_A3CliCod
            }
            , new Object[] {
            BC000938_A3CliCod
            }
         }
      );
      AV38Pgmname = "Categoria_BC" ;
      Z1565CliConvenio = "" ;
      A1565CliConvenio = "" ;
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12092 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Z1838CatClase ;
   private byte A1838CatClase ;
   private byte Z1914CatFrecAct ;
   private byte A1914CatFrecAct ;
   private byte Gx_BScreen ;
   private byte Gxremove274 ;
   private byte Gxremove206 ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z1564CliPaiConve ;
   private short A1564CliPaiConve ;
   private short nIsMod_206 ;
   private short RcdFound206 ;
   private short nIsMod_274 ;
   private short RcdFound274 ;
   private short AV8EmpCod ;
   private short Z1894CatRelSec ;
   private short A1894CatRelSec ;
   private short GXt_int6 ;
   private short GXv_int7[] ;
   private short RcdFound205 ;
   private short nIsDirty_205 ;
   private short nRcdExists_274 ;
   private short nRcdExists_206 ;
   private short Z2200CatPaiCod ;
   private short A2200CatPaiCod ;
   private short Z2201CatProvCod ;
   private short A2201CatProvCod ;
   private short nIsDirty_274 ;
   private short nIsDirty_206 ;
   private int trnEnded ;
   private int Z3CliCod ;
   private int A3CliCod ;
   private int nGXsfl_206_idx=1 ;
   private int nGXsfl_274_idx=1 ;
   private int AV7CliCod ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private int GX_JID ;
   private int Z2202CatProvRelSec ;
   private int A2202CatProvRelSec ;
   private java.math.BigDecimal Z122CatBasico ;
   private java.math.BigDecimal A122CatBasico ;
   private java.math.BigDecimal Z731CatValorHora ;
   private java.math.BigDecimal A731CatValorHora ;
   private java.math.BigDecimal Z908CatAdicional ;
   private java.math.BigDecimal A908CatAdicional ;
   private java.math.BigDecimal Z909CatAdiHora ;
   private java.math.BigDecimal A909CatAdiHora ;
   private java.math.BigDecimal Z1892EscBasico ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal Z1893EscAdicional ;
   private java.math.BigDecimal A1893EscAdicional ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String Z1565CliConvenio ;
   private String A1565CliConvenio ;
   private String Z8CatCodigo ;
   private String A8CatCodigo ;
   private String sMode205 ;
   private String AV38Pgmname ;
   private String Z2416CatTipoTarifa ;
   private String A2416CatTipoTarifa ;
   private String Z2198CatAfipCod ;
   private String A2198CatAfipCod ;
   private String GXt_char10 ;
   private String GXv_char11[] ;
   private String sMode274 ;
   private String sMode206 ;
   private java.util.Date Z907CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean n1894CatRelSec ;
   private boolean n2198CatAfipCod ;
   private boolean Gx_longc ;
   private boolean n2202CatProvRelSec ;
   private boolean n2203CatProvRelRef ;
   private boolean n2204CatProvOld ;
   private boolean n122CatBasico ;
   private boolean n731CatValorHora ;
   private boolean n908CatAdicional ;
   private boolean n909CatAdiHora ;
   private boolean mustCommit ;
   private String Z2041CatOld ;
   private String A2041CatOld ;
   private String Z2204CatProvOld ;
   private String A2204CatProvOld ;
   private String Z123CatDescrip ;
   private String A123CatDescrip ;
   private String Z676CatDescripSinAc ;
   private String A676CatDescripSinAc ;
   private String Z2040CatRelRef ;
   private String A2040CatRelRef ;
   private String Z2203CatProvRelRef ;
   private String A2203CatProvRelRef ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private web.SdtCategoria bcCategoria ;
   private IDataStoreProvider pr_default ;
   private String[] BC000910_A8CatCodigo ;
   private String[] BC000910_A123CatDescrip ;
   private String[] BC000910_A676CatDescripSinAc ;
   private byte[] BC000910_A1838CatClase ;
   private String[] BC000910_A2416CatTipoTarifa ;
   private byte[] BC000910_A1914CatFrecAct ;
   private short[] BC000910_A1894CatRelSec ;
   private boolean[] BC000910_n1894CatRelSec ;
   private String[] BC000910_A2040CatRelRef ;
   private String[] BC000910_A2041CatOld ;
   private String[] BC000910_A2198CatAfipCod ;
   private boolean[] BC000910_n2198CatAfipCod ;
   private int[] BC000910_A3CliCod ;
   private short[] BC000910_A1564CliPaiConve ;
   private String[] BC000910_A1565CliConvenio ;
   private int[] BC000911_A3CliCod ;
   private int[] BC000912_A3CliCod ;
   private short[] BC000912_A1564CliPaiConve ;
   private String[] BC000912_A1565CliConvenio ;
   private String[] BC000912_A8CatCodigo ;
   private String[] BC000913_A8CatCodigo ;
   private String[] BC000913_A123CatDescrip ;
   private String[] BC000913_A676CatDescripSinAc ;
   private byte[] BC000913_A1838CatClase ;
   private String[] BC000913_A2416CatTipoTarifa ;
   private byte[] BC000913_A1914CatFrecAct ;
   private short[] BC000913_A1894CatRelSec ;
   private boolean[] BC000913_n1894CatRelSec ;
   private String[] BC000913_A2040CatRelRef ;
   private String[] BC000913_A2041CatOld ;
   private String[] BC000913_A2198CatAfipCod ;
   private boolean[] BC000913_n2198CatAfipCod ;
   private int[] BC000913_A3CliCod ;
   private short[] BC000913_A1564CliPaiConve ;
   private String[] BC000913_A1565CliConvenio ;
   private String[] BC000914_A8CatCodigo ;
   private String[] BC000914_A123CatDescrip ;
   private String[] BC000914_A676CatDescripSinAc ;
   private byte[] BC000914_A1838CatClase ;
   private String[] BC000914_A2416CatTipoTarifa ;
   private byte[] BC000914_A1914CatFrecAct ;
   private short[] BC000914_A1894CatRelSec ;
   private boolean[] BC000914_n1894CatRelSec ;
   private String[] BC000914_A2040CatRelRef ;
   private String[] BC000914_A2041CatOld ;
   private String[] BC000914_A2198CatAfipCod ;
   private boolean[] BC000914_n2198CatAfipCod ;
   private int[] BC000914_A3CliCod ;
   private short[] BC000914_A1564CliPaiConve ;
   private String[] BC000914_A1565CliConvenio ;
   private int[] BC000918_A3CliCod ;
   private short[] BC000918_A1EmpCod ;
   private int[] BC000918_A31LiqNro ;
   private short[] BC000918_A2142LiqPaiConve ;
   private String[] BC000918_A2143LiqConvenio ;
   private String[] BC000918_A2144LiqCatCodigo ;
   private String[] BC000919_A8CatCodigo ;
   private String[] BC000919_A123CatDescrip ;
   private String[] BC000919_A676CatDescripSinAc ;
   private byte[] BC000919_A1838CatClase ;
   private String[] BC000919_A2416CatTipoTarifa ;
   private byte[] BC000919_A1914CatFrecAct ;
   private short[] BC000919_A1894CatRelSec ;
   private boolean[] BC000919_n1894CatRelSec ;
   private String[] BC000919_A2040CatRelRef ;
   private String[] BC000919_A2041CatOld ;
   private String[] BC000919_A2198CatAfipCod ;
   private boolean[] BC000919_n2198CatAfipCod ;
   private int[] BC000919_A3CliCod ;
   private short[] BC000919_A1564CliPaiConve ;
   private String[] BC000919_A1565CliConvenio ;
   private int[] BC000920_A3CliCod ;
   private String[] BC000920_A1565CliConvenio ;
   private String[] BC000920_A8CatCodigo ;
   private int[] BC000920_A2202CatProvRelSec ;
   private boolean[] BC000920_n2202CatProvRelSec ;
   private String[] BC000920_A2203CatProvRelRef ;
   private boolean[] BC000920_n2203CatProvRelRef ;
   private String[] BC000920_A2204CatProvOld ;
   private boolean[] BC000920_n2204CatProvOld ;
   private short[] BC000920_A2200CatPaiCod ;
   private short[] BC000920_A2201CatProvCod ;
   private short[] BC000920_A1564CliPaiConve ;
   private short[] BC000921_A2200CatPaiCod ;
   private int[] BC000922_A3CliCod ;
   private short[] BC000922_A1564CliPaiConve ;
   private String[] BC000922_A1565CliConvenio ;
   private String[] BC000922_A8CatCodigo ;
   private short[] BC000922_A2200CatPaiCod ;
   private short[] BC000922_A2201CatProvCod ;
   private int[] BC000923_A3CliCod ;
   private String[] BC000923_A1565CliConvenio ;
   private String[] BC000923_A8CatCodigo ;
   private int[] BC000923_A2202CatProvRelSec ;
   private boolean[] BC000923_n2202CatProvRelSec ;
   private String[] BC000923_A2203CatProvRelRef ;
   private boolean[] BC000923_n2203CatProvRelRef ;
   private String[] BC000923_A2204CatProvOld ;
   private boolean[] BC000923_n2204CatProvOld ;
   private short[] BC000923_A2200CatPaiCod ;
   private short[] BC000923_A2201CatProvCod ;
   private short[] BC000923_A1564CliPaiConve ;
   private int[] BC000924_A3CliCod ;
   private String[] BC000924_A1565CliConvenio ;
   private String[] BC000924_A8CatCodigo ;
   private int[] BC000924_A2202CatProvRelSec ;
   private boolean[] BC000924_n2202CatProvRelSec ;
   private String[] BC000924_A2203CatProvRelRef ;
   private boolean[] BC000924_n2203CatProvRelRef ;
   private String[] BC000924_A2204CatProvOld ;
   private boolean[] BC000924_n2204CatProvOld ;
   private short[] BC000924_A2200CatPaiCod ;
   private short[] BC000924_A2201CatProvCod ;
   private short[] BC000924_A1564CliPaiConve ;
   private int[] BC000928_A3CliCod ;
   private String[] BC000928_A1565CliConvenio ;
   private String[] BC000928_A8CatCodigo ;
   private int[] BC000928_A2202CatProvRelSec ;
   private boolean[] BC000928_n2202CatProvRelSec ;
   private String[] BC000928_A2203CatProvRelRef ;
   private boolean[] BC000928_n2203CatProvRelRef ;
   private String[] BC000928_A2204CatProvOld ;
   private boolean[] BC000928_n2204CatProvOld ;
   private short[] BC000928_A2200CatPaiCod ;
   private short[] BC000928_A2201CatProvCod ;
   private short[] BC000928_A1564CliPaiConve ;
   private int[] BC000929_A3CliCod ;
   private String[] BC000929_A1565CliConvenio ;
   private String[] BC000929_A8CatCodigo ;
   private java.util.Date[] BC000929_A907CatVigencia ;
   private java.math.BigDecimal[] BC000929_A122CatBasico ;
   private boolean[] BC000929_n122CatBasico ;
   private java.math.BigDecimal[] BC000929_A731CatValorHora ;
   private boolean[] BC000929_n731CatValorHora ;
   private java.math.BigDecimal[] BC000929_A908CatAdicional ;
   private boolean[] BC000929_n908CatAdicional ;
   private java.math.BigDecimal[] BC000929_A909CatAdiHora ;
   private boolean[] BC000929_n909CatAdiHora ;
   private java.math.BigDecimal[] BC000929_A1892EscBasico ;
   private java.math.BigDecimal[] BC000929_A1893EscAdicional ;
   private short[] BC000929_A1564CliPaiConve ;
   private int[] BC000930_A3CliCod ;
   private short[] BC000930_A1564CliPaiConve ;
   private String[] BC000930_A1565CliConvenio ;
   private String[] BC000930_A8CatCodigo ;
   private java.util.Date[] BC000930_A907CatVigencia ;
   private int[] BC000931_A3CliCod ;
   private String[] BC000931_A1565CliConvenio ;
   private String[] BC000931_A8CatCodigo ;
   private java.util.Date[] BC000931_A907CatVigencia ;
   private java.math.BigDecimal[] BC000931_A122CatBasico ;
   private boolean[] BC000931_n122CatBasico ;
   private java.math.BigDecimal[] BC000931_A731CatValorHora ;
   private boolean[] BC000931_n731CatValorHora ;
   private java.math.BigDecimal[] BC000931_A908CatAdicional ;
   private boolean[] BC000931_n908CatAdicional ;
   private java.math.BigDecimal[] BC000931_A909CatAdiHora ;
   private boolean[] BC000931_n909CatAdiHora ;
   private java.math.BigDecimal[] BC000931_A1892EscBasico ;
   private java.math.BigDecimal[] BC000931_A1893EscAdicional ;
   private short[] BC000931_A1564CliPaiConve ;
   private int[] BC000932_A3CliCod ;
   private String[] BC000932_A1565CliConvenio ;
   private String[] BC000932_A8CatCodigo ;
   private java.util.Date[] BC000932_A907CatVigencia ;
   private java.math.BigDecimal[] BC000932_A122CatBasico ;
   private boolean[] BC000932_n122CatBasico ;
   private java.math.BigDecimal[] BC000932_A731CatValorHora ;
   private boolean[] BC000932_n731CatValorHora ;
   private java.math.BigDecimal[] BC000932_A908CatAdicional ;
   private boolean[] BC000932_n908CatAdicional ;
   private java.math.BigDecimal[] BC000932_A909CatAdiHora ;
   private boolean[] BC000932_n909CatAdiHora ;
   private java.math.BigDecimal[] BC000932_A1892EscBasico ;
   private java.math.BigDecimal[] BC000932_A1893EscAdicional ;
   private short[] BC000932_A1564CliPaiConve ;
   private int[] BC000936_A3CliCod ;
   private String[] BC000936_A1565CliConvenio ;
   private String[] BC000936_A8CatCodigo ;
   private java.util.Date[] BC000936_A907CatVigencia ;
   private java.math.BigDecimal[] BC000936_A122CatBasico ;
   private boolean[] BC000936_n122CatBasico ;
   private java.math.BigDecimal[] BC000936_A731CatValorHora ;
   private boolean[] BC000936_n731CatValorHora ;
   private java.math.BigDecimal[] BC000936_A908CatAdicional ;
   private boolean[] BC000936_n908CatAdicional ;
   private java.math.BigDecimal[] BC000936_A909CatAdiHora ;
   private boolean[] BC000936_n909CatAdiHora ;
   private java.math.BigDecimal[] BC000936_A1892EscBasico ;
   private java.math.BigDecimal[] BC000936_A1893EscAdicional ;
   private short[] BC000936_A1564CliPaiConve ;
   private int[] BC000937_A3CliCod ;
   private int[] BC000938_A3CliCod ;
   private int[] BC00092_A3CliCod ;
   private String[] BC00092_A1565CliConvenio ;
   private String[] BC00092_A8CatCodigo ;
   private java.util.Date[] BC00092_A907CatVigencia ;
   private java.math.BigDecimal[] BC00092_A122CatBasico ;
   private java.math.BigDecimal[] BC00092_A731CatValorHora ;
   private java.math.BigDecimal[] BC00092_A908CatAdicional ;
   private java.math.BigDecimal[] BC00092_A909CatAdiHora ;
   private java.math.BigDecimal[] BC00092_A1892EscBasico ;
   private java.math.BigDecimal[] BC00092_A1893EscAdicional ;
   private short[] BC00092_A1564CliPaiConve ;
   private int[] BC00093_A3CliCod ;
   private String[] BC00093_A1565CliConvenio ;
   private String[] BC00093_A8CatCodigo ;
   private java.util.Date[] BC00093_A907CatVigencia ;
   private java.math.BigDecimal[] BC00093_A122CatBasico ;
   private java.math.BigDecimal[] BC00093_A731CatValorHora ;
   private java.math.BigDecimal[] BC00093_A908CatAdicional ;
   private java.math.BigDecimal[] BC00093_A909CatAdiHora ;
   private java.math.BigDecimal[] BC00093_A1892EscBasico ;
   private java.math.BigDecimal[] BC00093_A1893EscAdicional ;
   private short[] BC00093_A1564CliPaiConve ;
   private int[] BC00094_A3CliCod ;
   private String[] BC00094_A1565CliConvenio ;
   private String[] BC00094_A8CatCodigo ;
   private int[] BC00094_A2202CatProvRelSec ;
   private String[] BC00094_A2203CatProvRelRef ;
   private String[] BC00094_A2204CatProvOld ;
   private short[] BC00094_A2200CatPaiCod ;
   private short[] BC00094_A2201CatProvCod ;
   private short[] BC00094_A1564CliPaiConve ;
   private int[] BC00095_A3CliCod ;
   private String[] BC00095_A1565CliConvenio ;
   private String[] BC00095_A8CatCodigo ;
   private int[] BC00095_A2202CatProvRelSec ;
   private String[] BC00095_A2203CatProvRelRef ;
   private String[] BC00095_A2204CatProvOld ;
   private short[] BC00095_A2200CatPaiCod ;
   private short[] BC00095_A2201CatProvCod ;
   private short[] BC00095_A1564CliPaiConve ;
   private short[] BC00096_A2200CatPaiCod ;
   private String[] BC00097_A8CatCodigo ;
   private String[] BC00097_A123CatDescrip ;
   private String[] BC00097_A676CatDescripSinAc ;
   private byte[] BC00097_A1838CatClase ;
   private String[] BC00097_A2416CatTipoTarifa ;
   private byte[] BC00097_A1914CatFrecAct ;
   private short[] BC00097_A1894CatRelSec ;
   private String[] BC00097_A2040CatRelRef ;
   private String[] BC00097_A2041CatOld ;
   private String[] BC00097_A2198CatAfipCod ;
   private int[] BC00097_A3CliCod ;
   private short[] BC00097_A1564CliPaiConve ;
   private String[] BC00097_A1565CliConvenio ;
   private String[] BC00098_A8CatCodigo ;
   private String[] BC00098_A123CatDescrip ;
   private String[] BC00098_A676CatDescripSinAc ;
   private byte[] BC00098_A1838CatClase ;
   private String[] BC00098_A2416CatTipoTarifa ;
   private byte[] BC00098_A1914CatFrecAct ;
   private short[] BC00098_A1894CatRelSec ;
   private String[] BC00098_A2040CatRelRef ;
   private String[] BC00098_A2041CatOld ;
   private String[] BC00098_A2198CatAfipCod ;
   private int[] BC00098_A3CliCod ;
   private short[] BC00098_A1564CliPaiConve ;
   private String[] BC00098_A1565CliConvenio ;
   private int[] BC00099_A3CliCod ;
   private boolean[] BC00092_n122CatBasico ;
   private boolean[] BC00092_n731CatValorHora ;
   private boolean[] BC00092_n908CatAdicional ;
   private boolean[] BC00092_n909CatAdiHora ;
   private boolean[] BC00093_n122CatBasico ;
   private boolean[] BC00093_n731CatValorHora ;
   private boolean[] BC00093_n908CatAdicional ;
   private boolean[] BC00093_n909CatAdiHora ;
   private boolean[] BC00094_n2202CatProvRelSec ;
   private boolean[] BC00094_n2203CatProvRelRef ;
   private boolean[] BC00094_n2204CatProvOld ;
   private boolean[] BC00095_n2202CatProvRelSec ;
   private boolean[] BC00095_n2203CatProvRelRef ;
   private boolean[] BC00095_n2204CatProvOld ;
   private boolean[] BC00097_n1894CatRelSec ;
   private boolean[] BC00097_n2198CatAfipCod ;
   private boolean[] BC00098_n1894CatRelSec ;
   private boolean[] BC00098_n2198CatAfipCod ;
   private GXSimpleCollection<String> AV17SinCod ;
   private GXSimpleCollection<String> GXt_objcol_char8 ;
   private GXSimpleCollection<String> GXv_objcol_char9[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class categoria_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00092", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?  FOR UPDATE OF Categoriavalores1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00093", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00094", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?  FOR UPDATE OF CategoriaProvincias",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00095", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00096", "SELECT PaiCod AS CatPaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00097", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CatRelSec, CatRelRef, CatOld, CatAfipCod, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?  FOR UPDATE OF Categoria1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00098", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CatRelSec, CatRelRef, CatOld, CatAfipCod, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00099", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000910", "SELECT TM1.CatCodigo, TM1.CatDescrip, TM1.CatDescripSinAc, TM1.CatClase, TM1.CatTipoTarifa, TM1.CatFrecAct, TM1.CatRelSec, TM1.CatRelRef, TM1.CatOld, TM1.CatAfipCod, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM Categoria1 TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CatCodigo = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CatCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000911", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000912", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000913", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CatRelSec, CatRelRef, CatOld, CatAfipCod, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000914", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CatRelSec, CatRelRef, CatOld, CatAfipCod, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?  FOR UPDATE OF Categoria1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000915", "SAVEPOINT gxupdate;INSERT INTO Categoria1(CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CatRelSec, CatRelRef, CatOld, CatAfipCod, CliCod, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000916", "SAVEPOINT gxupdate;UPDATE Categoria1 SET CatDescrip=?, CatDescripSinAc=?, CatClase=?, CatTipoTarifa=?, CatFrecAct=?, CatRelSec=?, CatRelRef=?, CatOld=?, CatAfipCod=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000917", "SAVEPOINT gxupdate;DELETE FROM Categoria1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000918", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio, LiqCatCodigo FROM LiquidacionCategoria WHERE CliCod = ? AND LiqPaiConve = ? AND LiqConvenio = ? AND LiqCatCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000919", "SELECT TM1.CatCodigo, TM1.CatDescrip, TM1.CatDescripSinAc, TM1.CatClase, TM1.CatTipoTarifa, TM1.CatFrecAct, TM1.CatRelSec, TM1.CatRelRef, TM1.CatOld, TM1.CatAfipCod, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM Categoria1 TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CatCodigo = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CatCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000920", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatPaiCod = ? and CatProvCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000921", "SELECT PaiCod AS CatPaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000922", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000923", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000924", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?  FOR UPDATE OF CategoriaProvincias",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000925", "SAVEPOINT gxupdate;INSERT INTO CategoriaProvincias(CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000926", "SAVEPOINT gxupdate;UPDATE CategoriaProvincias SET CatProvRelSec=?, CatProvRelRef=?, CatProvOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000927", "SAVEPOINT gxupdate;DELETE FROM CategoriaProvincias  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000928", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000929", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000930", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000931", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000932", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?  FOR UPDATE OF Categoriavalores1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000933", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve, CatSalRelSec, CatSalRelRef, CatSalOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000934", "SAVEPOINT gxupdate;UPDATE Categoriavalores1 SET CatBasico=?, CatValorHora=?, CatAdicional=?, CatAdiHora=?, EscBasico=?, EscAdicional=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000935", "SAVEPOINT gxupdate;DELETE FROM Categoriavalores1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000936", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000937", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000938", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 11 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 22 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
            case 35 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 36 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 1);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[7]).shortValue());
               }
               stmt.setVarchar(8, (String)parms[8], 40, false);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[11], 6);
               }
               stmt.setInt(11, ((Number) parms[12]).intValue());
               stmt.setShort(12, ((Number) parms[13]).shortValue());
               stmt.setString(13, (String)parms[14], 20);
               return;
            case 14 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[6]).shortValue());
               }
               stmt.setVarchar(7, (String)parms[7], 40, false);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[10], 6);
               }
               stmt.setInt(10, ((Number) parms[11]).intValue());
               stmt.setShort(11, ((Number) parms[12]).shortValue());
               stmt.setString(12, (String)parms[13], 20);
               stmt.setString(13, (String)parms[14], 40);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 40);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[4]).intValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[6], 40);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(6, (String)parms[8]);
               }
               stmt.setShort(7, ((Number) parms[9]).shortValue());
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setShort(9, ((Number) parms[11]).shortValue());
               return;
            case 24 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 40);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[5]);
               }
               stmt.setInt(4, ((Number) parms[6]).intValue());
               stmt.setShort(5, ((Number) parms[7]).shortValue());
               stmt.setString(6, (String)parms[8], 20);
               stmt.setString(7, (String)parms[9], 40);
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setShort(9, ((Number) parms[11]).shortValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setDate(4, (java.util.Date)parms[3]);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 2);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(6, (java.math.BigDecimal)parms[7], 2);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(7, (java.math.BigDecimal)parms[9], 2);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(8, (java.math.BigDecimal)parms[11], 2);
               }
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[13], 2);
               stmt.setShort(11, ((Number) parms[14]).shortValue());
               return;
            case 32 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(1, (java.math.BigDecimal)parms[1], 2);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(2, (java.math.BigDecimal)parms[3], 2);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(3, (java.math.BigDecimal)parms[5], 2);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(4, (java.math.BigDecimal)parms[7], 2);
               }
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[9], 2);
               stmt.setInt(7, ((Number) parms[10]).intValue());
               stmt.setShort(8, ((Number) parms[11]).shortValue());
               stmt.setString(9, (String)parms[12], 20);
               stmt.setString(10, (String)parms[13], 40);
               stmt.setDate(11, (java.util.Date)parms[14]);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 36 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

